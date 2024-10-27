package com.utp.edu.pe.proyectoxd.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringController {

    @GetMapping("/")
    public String index() {
        return "index"; // Redirige a index.html
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/booking")
    public String booking() {
        return "booking";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/feature")
    public String feature() {
        return "feature";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/single")
    public String single() {
        return "single";
    }

    @GetMapping("/team")
    public String team() {
        return "team";
    }




}

