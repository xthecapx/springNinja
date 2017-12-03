package com.udemy.controller;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_VIEW = "example";
    public static final String ARRAY_VIEW = "array";

    @Autowired
    @Qualifier("exampleService")
    private ExampleService exampleService;

    // Primera forma
    @GetMapping("/exampleString") // @RequestMapping(value="/exampleString", method= RequestMethod.GET)
    public String exampleString(Model model) {
        model.addAttribute("person", new Person("John", 23));

        return EXAMPLE_VIEW;
    }

    // Segunda forma
    @GetMapping("/exampleMAV") // @RequestMapping(value="/exampleMAV", method= RequestMethod.GET)
    public ModelAndView exampleMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("person", new Person("Cristian", 28));

        return mav;
    }

    // Arreglos
    @GetMapping("/exampleARREGLOS") // @RequestMapping(value="/exampleMAV", method= RequestMethod.GET)
    public ModelAndView exampleARREGLOS() {
        ModelAndView mav = new ModelAndView(ARRAY_VIEW);
        mav.addObject("people", exampleService.getListPeople());

        return mav;
    }

}
