package com.example.tesy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (path ="/")
public class TemplateController {

    @GetMapping("login")
    public String getLogin(){
        return "login";
    }
    @GetMapping("tesy-main-page")
    public String getTesyMainPage(){
        return "tesy-main-page";
    }
}
