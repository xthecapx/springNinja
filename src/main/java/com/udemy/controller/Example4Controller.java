package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
    private static final String ERROR_VIEW = "404";

    @GetMapping("/404")
    public ModelAndView errors() {
        ModelAndView mva = new ModelAndView(ERROR_VIEW);
        return mva;
    }
}
