package co.bergamota.controllers;

import co.bergamota.business.objects.Pesquisador;
import co.bergamota.business.objects.Publicacao;
import co.bergamota.business.objects.PublicacaoCampos;
import co.bergamota.business.objects.Usuario;
import co.bergamota.dataaccess.*;
import co.bergamota.modelview.PublicacaoModelView;
import co.bergamota.modelview.SignUpModelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

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
        publicacao.setCampos(null);
        publicacao.setDatacadastro(new Date());
        publicacaoRepository.save(publicacao);
        return "redirect:/";
    }
}
