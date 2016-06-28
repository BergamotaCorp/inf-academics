package co.bergamota.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
}
