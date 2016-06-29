package co.bergamota.controllers;

import co.bergamota.business.objects.Pesquisador;
import co.bergamota.business.objects.Usuario;
import co.bergamota.dataaccess.PesquisadorRepository;
import co.bergamota.dataaccess.PublicacaoRepository;
import co.bergamota.dataaccess.UsuarioRepository;
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

import java.util.Date;

@Controller
@EnableAutoConfiguration
@RequestMapping(value = {"/","/home"})
public class HomeController {
    @Autowired
    PublicacaoRepository publicacaoRepository;

    @Autowired
    PesquisadorRepository pesquisadorRepository;

    @RequestMapping( value = {"/", "/index"})
    public String indexAction (ModelMap model) {
        model.addAttribute("name", "world");
        return "home/index";
    }

    @RequestMapping(value = "/cadastrar-publicacao", method = RequestMethod.GET)
    public String cadastrarPublicacaoAction(ModelMap model) {
        model.addAttribute("PublicacaoModelView", new PublicacaoModelView());
        return "home/cadastrar-publicacao";
    }

    @RequestMapping(value = {"/cadastrar-publicacao"}, method = RequestMethod.POST)
    public String cadastrarPublicacaoSaveAction(@ModelAttribute("PublicacaoModelView") PublicacaoModelView publicacaoModelView,
                                   final RedirectAttributes redirectAttributes) {



        return "redirect:/login";
    }
}
