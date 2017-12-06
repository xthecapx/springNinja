package com.udemy.service;


import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

import java.util.List;

public interface CourseService {

    public abstract List<Course> listAllCourses();
    public abstract Course addCourse(CourseModel courseModel);
    public abstract void removeCourse(int id);
    public abstract Course updateCourse(int id, CourseModel courseModel);
    public abstract Course findById(int id);

}
