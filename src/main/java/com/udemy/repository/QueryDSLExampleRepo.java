package com.udemy.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Course;
import com.udemy.entity.QCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

    private QCourse qCourse = QCourse.course;

    @PersistenceContext
    private EntityManager em;

    private Course find(boolean exist) {

        JPAQuery<Course> query = new JPAQuery<Course>(em);

        BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));

        if (exist) {
            Predicate predicate2 = qCourse.id.eq(23);
            predicateBuilder.and(predicate2);
        } else {
            Predicate predicate3 = qCourse.name.endsWith("OP");
            predicateBuilder.or(predicate3);
        }

        return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();

        // Course course1 = (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(qCourse.id.eq(23)).fetchOne();

        // List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20,50)).fetch();

    }
}
