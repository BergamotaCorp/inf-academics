package co.bergamota.controllers;

import co.bergamota.business.objects.*;
import co.bergamota.dataaccess.*;
import com.google.common.collect.Lists;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Stream;

import org.jbibtex.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PesquisadorRepository pesquisadorRepository;

    @Autowired
    PublicacaoRepository publicacaoRepository;

    @Autowired
    PublicacaoCamposRepository publicacaoCamposRepository;

    @Autowired
    TipoPublicacaoRepository tipoPublicacaoRepository;

    @RequestMapping("/usuarios/getAll")
    public ArrayList<Usuario> getUsuarios() {
        return Lists.newArrayList(usuarioRepository.findAll());
    }

    @RequestMapping("/pesquisadores/getAll")
    public ArrayList<Pesquisador> getPesquisadores() {
        return Lists.newArrayList(pesquisadorRepository.findAll());
    }

    @RequestMapping("/publicacoes/getAll")
    public ArrayList<Publicacao> getPublicacoes() {
        return Lists.newArrayList(publicacaoRepository.findAll());
    }

    @RequestMapping( "/publicacoes/search")
    public ArrayList<Publicacao> searchPublicacoes(@RequestParam(value = "search") String search) {
        return Lists.newArrayList(publicacaoRepository.search(search));
    }

    @RequestMapping("/tipopublicacoes/getAll")
    public ArrayList<TipoPublicacao> getTipoPublicacoes() {
        return Lists.newArrayList(tipoPublicacaoRepository.findAll());
    }

    @Transactional(rollbackOn = Exception.class)
    @RequestMapping(value = "/importar-publicacoes", method = RequestMethod.POST)
    public String importarPublicacoes(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        if (!file.isEmpty()) try {
            //Files.copy(file.getInputStream(), Paths.get("src/main/resources/upload-dir", file.getOriginalFilename()));
            Reader reader = new InputStreamReader(file.getInputStream());
            BibTeXParser bibtexParser = new BibTeXParser();
            BibTeXDatabase database = bibtexParser.parse(reader);

            Map<Key, BibTeXEntry> entryMap = database.getEntries();

            Collection<BibTeXEntry> entries = entryMap.values();
            ArrayList<Key> atributos = new ArrayList<>();

            for(Field field : BibTeXEntry.class.getDeclaredFields()){
                try {
                    if(field.getType() == Key.class) atributos.add((Key)field.get(null));
                } catch (IllegalAccessException e) {
                    continue;
                }
            }

            for (BibTeXEntry entry : entries) {

                Publicacao publicacao = new Publicacao();
                publicacao.setAno(entry.getField(BibTeXEntry.KEY_YEAR).toUserString());
                publicacao.setDatacadastro(new Date());
                publicacao.setNomepublicacao(entry.getField(BibTeXEntry.KEY_TITLE).toUserString());

                String nomeTipoPublicacao = entry.getType().getValue().toString();
                TipoPublicacao tipoPublicacao = tipoPublicacaoRepository.findByNometipopublicacao(nomeTipoPublicacao);
                if(tipoPublicacao == null){
                    tipoPublicacao.setNometipopublicacao(nomeTipoPublicacao);
                    tipoPublicacaoRepository.save(tipoPublicacao);
                }
                publicacao.setTipoPublicacao(tipoPublicacao);

                ArrayList<Pesquisador> pesquisadores = new ArrayList<>();
                String[] nomePesquisadores = entry.getField(BibTeXEntry.KEY_AUTHOR).toUserString().split(" and ");
                for(String nomePesquisador : nomePesquisadores){
                    Pesquisador pesquisador = pesquisadorRepository.findByNomepesquisador(nomePesquisador.trim());
                    if(pesquisador == null){
                        pesquisador = new Pesquisador();
                        pesquisador.setNomepesquisador(nomePesquisador.trim());
                        pesquisador.setDatacadastro(new Date());
                        pesquisadorRepository.save(pesquisador);
                    }
                    pesquisadores.add(pesquisador);
                }
                publicacao.setPesquisadores(pesquisadores);
                publicacao.setDatacadastro(new Date());
                publicacaoRepository.save(publicacao);

                publicacao.setCampos(new ArrayList<>());

                for(Key atributo : atributos){
                    if(entry.getField(atributo) == null) continue;
                    PublicacaoCampos publicacaoCampos = new PublicacaoCampos();
                    publicacaoCampos.setNomecampo(atributo.getValue());
                    publicacaoCampos.setValorcampo(entry.getField(atributo).toUserString());
                    publicacaoCampos.setPublicacao(publicacao);
                    publicacao.getCampos().add(publicacaoCampos);
                    publicacaoCamposRepository.save(publicacaoCampos);
                    publicacaoRepository.save(publicacao);
                }
            }

            response.setStatus(HttpServletResponse.SC_OK);
            return "Upload executado com sucesso";
        } catch (IOException | RuntimeException e) {
            throw e;
            //response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            //return "Não foi possívell executar o upload do arquivo";
        } catch (ParseException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Arquivo Bibtex inválido\n\n" + e.getMessage();
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return "Não foi possívell executar o upload do arquivo porque ele está vazio";
    }
}