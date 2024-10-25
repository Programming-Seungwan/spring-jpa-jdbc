package com.seungwan.first_jpaandhibernate_practice.course;

import com.seungwan.first_jpaandhibernate_practice.course.jdbc.CourseJdbcRepository;
import com.seungwan.first_jpaandhibernate_practice.course.jpa.CourseJpaRepository;
import com.seungwan.first_jpaandhibernate_practice.course.springDataJpa.CourseSpringDataJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired // spring jdbc를 사용
//    private CourseJdbcRepository repository;

//    @Autowired // 그냥 jpa를 사용
//    private CourseJpaRepository repository;
    @Autowired
    private CourseSpringDataJpa repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn aws now!", "seungwanTeach"));
        repository.save(new Course(2, "Learn react now!", "seungwanTeach"));
        repository.save(new Course(3, "Learn docker now!", "seungwanTeach"));
        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));
    }
}
