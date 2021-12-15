package net.tempest.rimuru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.tempest.rimuru.model.User;
import net.tempest.rimuru.service.userServ;

@Controller
public class MainController {
    
    @Autowired
    private userServ serv;

    @GetMapping("")
    public String getMain(){
        return "index";
    }

    @GetMapping("/nosecurity")
    public String getHello(){
        return "nosecurity";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/wow")
    public String getWow(Model model, Authentication authentication){
        User user = serv.findByUsername(authentication.getName());
        model.addAttribute("asd", authentication.getAuthorities() + " " + user.getRole().getName());
        return "wow";
    }
}
