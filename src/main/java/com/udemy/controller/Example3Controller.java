package com.udemy.controller;

import com.udemy.component.ExampleComponent;
import com.udemy.model.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
    private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);

    @Autowired
    @Qualifier("exampleComponent")
    private ExampleComponent exampleComponent;

    public static final String FORM_VIEW = "form";
    public static final String RESULT_VIEW = "result";

    // #1 Redirect to /example3/showform when /example3
    /*@GetMapping("/")
    public String redirect() {
        return "redirect:/example3/showform";
    }*/

    // #2 Objecto redirect
    @GetMapping("/")
    public RedirectView redirect() {
        return new RedirectView("/example3/showform");
    }

    @GetMapping("/showform")
    public String showForm(Model model) {
        /*LOGGER.info("INFO TRACE");
        LOGGER.warn("WARNING TRACE");
        LOGGER.error("ERROR TRACE");
        LOGGER.debug("DEBUG");*/
        exampleComponent.sayHellow();
        model.addAttribute("person", new Person());

        return FORM_VIEW;
    }

    @PostMapping("/addperson")
    public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {

        ModelAndView mva = new ModelAndView();

        if (bindingResult.hasErrors()) {
            mva.setViewName(FORM_VIEW);
        } else {
            mva.setViewName(RESULT_VIEW);
            mva.addObject("person", person);
        }


        // LOGGER.info("TEMPLATE: " + RESULT_VIEW + " DATA: " + person);

        return mva;
    }


}
