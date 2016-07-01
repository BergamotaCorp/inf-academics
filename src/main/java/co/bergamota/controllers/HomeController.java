package co.bergamota.controllers;

import co.bergamota.business.objects.*;
import co.bergamota.dataaccess.*;
import co.bergamota.modelview.PublicacaoModelView;
import co.bergamota.modelview.SignUpModelView;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@Controller
@EnableAutoConfiguration
@RequestMapping(value = {"/","/home"})
public class HomeController {
    @Autowired
    PublicacaoRepository publicacaoRepository;

    @Autowired
    private PesquisadorRepository pesquisadorRepository;

    @Autowired
    private TipoPublicacaoRepository tipoPublicacaoRepository;

    @RequestMapping( value = {"/", "/index"})
    public String indexAction (ModelMap model) {
        model.addAttribute("name", "world");
        return "home/index";
    }

    @RequestMapping(value = "/cadastrar-publicacao", method = RequestMethod.GET)
    public String cadastrarPublicacaoAction() {
        //model.addAttribute("PublicacaoModelView", new PublicacaoModelView());
        return "home/cadastrar-publicacao";
    }

    @RequestMapping(value = {"/cadastrar-publicacao"}, method = RequestMethod.POST)
    public String cadastrarPublicacaoSaveAction(HttpServletRequest request,
                                   final RedirectAttributes redirectAttributes) {
        PublicacaoModelView publicacaoModelView = new PublicacaoModelView(request, pesquisadorRepository, tipoPublicacaoRepository);
        Publicacao publicacao = new Publicacao();
        publicacao.setPesquisadores(publicacaoModelView.getIdpesquisador());
        publicacao.setAno(publicacaoModelView.getAnopublicacao());
        publicacao.setAtributos(publicacaoModelView.getAtributos());
        publicacao.setNomepublicacao(publicacaoModelView.getNomepublicacao());
        publicacao.setTipoPublicacao(publicacaoModelView.getTipopublicacao());
        publicacao.setPublicador(publicacaoModelView.getPublicador());
        publicacao.setCampos(null);
        publicacao.setDatacadastro(new Date());
        publicacaoRepository.save(publicacao);
        return "redirect:/";
    }

    @RequestMapping(value = "/detalhes/{id}", method = RequestMethod.GET)
    public String detalhesPublicacaoAction(@PathVariable("id") Long id, ModelMap model) {
        Publicacao publicacao = publicacaoRepository.findOne(id);
        model.addAttribute("model", publicacao);

        String pesquisadores = publicacao.getPesquisadores().stream().map(p -> p.getNomepesquisador()).collect(Collectors.joining(", ")).toString();

        model.addAttribute("pesquisadores", pesquisadores);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("canEdit", publicacao.getPesquisadores().stream().anyMatch(p -> p.getIdpesquisador() == ((Credenciais) auth.getPrincipal()).getId()));

        return "home/detalhes";
    }


    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editarPublicacaoAction(@PathVariable("id") Long id, ModelMap model) {
        Publicacao publicacao = publicacaoRepository.findOne(id);
        String pesquisadores = new JSONArray(publicacao.getPesquisadores()).toString();

        model.addAttribute("pesquisadores", pesquisadores);
        model.addAttribute("model", publicacao);
        return "home/editar-publicacao";
    }


    @RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
    public String editarPublicacaoAction(@PathVariable("id") Long id, HttpServletRequest request) {
        Publicacao publicacao = publicacaoRepository.findOne(id);

        PublicacaoModelView publicacaoModelView = new PublicacaoModelView(request, pesquisadorRepository, tipoPublicacaoRepository);
        publicacao.setPesquisadores(publicacaoModelView.getIdpesquisador());
        publicacao.setAno(publicacaoModelView.getAnopublicacao());
        publicacao.setAtributos(publicacaoModelView.getAtributos());
        publicacao.setNomepublicacao(publicacaoModelView.getNomepublicacao());
        publicacao.setTipoPublicacao(publicacaoModelView.getTipopublicacao());
        publicacao.setPublicador(publicacaoModelView.getPublicador());
        publicacaoRepository.save(publicacao);

        return "redirect:/editar/" + id.toString();
    }
}
