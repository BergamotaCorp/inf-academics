package co.bergamota.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class LoginController {
    @RequestMapping("/login")
    public String loginAction (ModelMap model) {
        return "login/login";
    }

    @RequestMapping("/logout")
    public String logoutAction (ModelMap model) {
        return "login/logout";
    }
}
