package co.bergamota.controllers;

import co.bergamota.business.objects.Pesquisador;
import co.bergamota.business.objects.Usuario;
import co.bergamota.dataaccess.PesquisadorRepository;
import co.bergamota.dataaccess.UsuarioRepository;
import co.bergamota.modelview.SignUpModelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.Optional;

@Controller
@EnableAutoConfiguration
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginAction (@RequestParam Optional<String> error, ModelMap model) {
        model.addAttribute("error", error);
        return "login/login";
    }

    @RequestMapping("/logout")
    public String logoutAction (ModelMap model) {
        return "login/logout";
    }

    @RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
    public String signupAction (ModelMap model) {
        model.addAttribute("SignUpModelView", new SignUpModelView());
        return "login/signup";
    }

    @Autowired
    PesquisadorRepository pesquisadorRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping(value = {"/signup"}, method = RequestMethod.POST)
    public String signupSaveAction(@ModelAttribute("SignUpModelView") SignUpModelView signUpModelView,
                               final RedirectAttributes redirectAttributes) {

        Pesquisador pesquisador = new Pesquisador();
        pesquisador.setNomepesquisador(signUpModelView.getNomepesquisador());
        pesquisador.setDatacadastro(new Date());
        pesquisadorRepository.save(pesquisador);

        Usuario usuario = new Usuario();
        usuario.setAtivo(1);
        usuario.setDatacriacao(new Date());
        usuario.setNomeusuario(signUpModelView.getNomeusuario());
        usuario.setPesquisador(pesquisador);
        usuario.setSenha(signUpModelView.getSenha());
        usuarioRepository.save(usuario);

        return "redirect:/login";
    }
}
