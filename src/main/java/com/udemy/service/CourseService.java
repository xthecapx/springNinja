package com.udemy.service;


import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

import java.util.List;

public interface CourseService {

    public abstract List<Course> listAllCourses();
    public abstract Course addCourse(CourseModel courseModel);
    public abstract int removeCourse(int id);
    public abstract Course updateCourse(CourseModel courseModel);

}
