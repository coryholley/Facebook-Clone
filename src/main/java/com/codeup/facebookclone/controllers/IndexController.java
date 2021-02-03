package com.codeup.facebookclone.controllers;

import com.codeup.facebookclone.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String indexPage(Model model) {

        return "index";
    }
}
