package com.seungwan.first_jpaandhibernate_practice.course;

import com.seungwan.first_jpaandhibernate_practice.course.jdbc.CourseJdbcRepository;
import com.seungwan.first_jpaandhibernate_practice.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJdbcRepository repository;

    @Autowired
    private CourseJpaRepository repository;


    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn aws now!", "seungwanTeach"));
        repository.insert(new Course(2, "Learn react now!", "seungwanTeach"));
        repository.insert(new Course(3, "Learn docker now!", "seungwanTeach"));
        repository.deleteById(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }
}
