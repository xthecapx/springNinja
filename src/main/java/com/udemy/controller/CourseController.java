package com.udemy.controller;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private static final String COURSES_VIEW = "courses";
    private static final Log LOGGER = LogFactory.getLog(CourseController.class);

    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseService courseService;

    @Autowired
    @Qualifier("courseConverter")
    private CourseConverter courseConverter;

    @GetMapping("/listcourses")
    public ModelAndView listAllCourses() {
        LOGGER.info("Call: listAllCourses()" );
        ModelAndView mav = new ModelAndView(COURSES_VIEW);
        Course course = courseConverter.modelToEntity(new CourseModel());
        mav.addObject("course", course);
        mav.addObject("courses", courseService.listAllCourses());

        return mav;
    }

    @PostMapping("/addcourse")
    public String addCourses(@ModelAttribute("course") CourseModel courseModel) {
        // LOGGER.info("Call: addCourses -- " + course.toString() );
        courseService.addCourse(courseModel);
        return "redirect:/courses/listcourses";
    }
}
