package com.seungwan.first_jpaandhibernate_practice.course.springDataJpa;

import com.seungwan.first_jpaandhibernate_practice.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpa extends JpaRepository<Course, Long> {
}
