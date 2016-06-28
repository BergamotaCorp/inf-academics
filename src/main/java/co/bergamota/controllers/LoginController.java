package co.bergamota.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@RequestMapping("/login")
public class LoginController {
    @RequestMapping( value = {"/", "/index"})
    public String indexAction (ModelMap model) {
        return "login/index";
    }
}
