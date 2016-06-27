package co.bergamota.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@RequestMapping(value = {"/","/home"})
public class HomeController {
    @RequestMapping( value = {"/", "/index"})
    public String indexAction (ModelMap model) {
        model.addAttribute("name", "world");
        return "home/index";
    }
}
