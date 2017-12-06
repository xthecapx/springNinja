package com.udemy.service.impl;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.repository.CourseRepository;
import com.udemy.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

    private static final Log LOGGER = LogFactory.getLog(CourseServiceImpl.class);

    @Autowired
    @Qualifier("courseJpaRepository")
    private CourseRepository courseJpaRepository;

    @Autowired
    @Qualifier("courseConverter")
    private CourseConverter courseConverter;

    @Override
    public List<Course> listAllCourses() {
        LOGGER.info("call -> listAllCourses()");
        return courseJpaRepository.findAll();
    }

    @Override
    public Course addCourse(CourseModel courseModel) {
        Course course = courseConverter.modelToEntity(courseModel);
        LOGGER.info("Call addCourse() -- " + course);
        return courseJpaRepository.save(course);
    }

    @Override
    public void removeCourse(int id) {
        courseJpaRepository.delete(id);
    }

    @Override
    public Course updateCourse(int id, CourseModel courseModel) {
        Course course = courseConverter.modelToEntity(courseModel);
        course.setId(id);
        return courseJpaRepository.save(course);
    }

    @Override
    public Course findById(int id) {
        return courseJpaRepository.findById(id);
    }
}
