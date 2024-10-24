package com.seungwan.first_jpaandhibernate_practice.course.jdbc;

import com.seungwan.first_jpaandhibernate_practice.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJdbcRepository repository;


    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn aws now!", "seungwanTeach"));
        repository.insert(new Course(2, "Learn react now!", "seungwanTeach"));
        repository.insert(new Course(3, "Learn docker now!", "seungwanTeach"));
        repository.delete(1);
    }
}
