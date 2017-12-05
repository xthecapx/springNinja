package com.udemy.converter;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import org.springframework.stereotype.Component;

@Component("courseConverter")
public class CourseConverter {
    // Entity -> Model
    public CourseModel entityToModel(Course course) {
        CourseModel courseModel = new CourseModel();
        courseModel.setName(course.getName());
        courseModel.setDescription(course.getDescription());
        courseModel.setPrice(course.getPrice());
        courseModel.setHours(course.getHours());

        return courseModel;
    }

    // Model -> Entity
    public Course modelToEntity(CourseModel courseModel) {
        Course course = new Course();
        course.setName(courseModel.getName());
        course.setDescription(courseModel.getDescription());
        course.setPrice(courseModel.getPrice());
        course.setHours(courseModel.getHours());

        return course;
    }
}
