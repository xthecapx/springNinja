package com.udemy.controller;

import com.udemy.model.Person;
import com.udemy.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {

    private static final String PATH1_VIEW = "path1";
    private static final String PATH2_VIEW = "path2";

    @Autowired
    @Qualifier("exerciseService")
    private ExerciseService exerciseService;

    @GetMapping("/path1")
    public RedirectView path1topath2() {
        return new RedirectView("/ejercicio/path2");
    }

    @GetMapping("/path2")
    public ModelAndView path2() {
        ModelAndView mav = new ModelAndView(PATH2_VIEW);
        mav.addObject("logger", exerciseService.logger());

        return mav;
    }

}
