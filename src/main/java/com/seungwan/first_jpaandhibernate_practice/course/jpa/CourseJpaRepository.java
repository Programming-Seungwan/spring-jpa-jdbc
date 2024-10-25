package com.seungwan.first_jpaandhibernate_practice.course.jpa;


import com.seungwan.first_jpaandhibernate_practice.course.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

//    @Autowired
    @PersistenceContext // Autowired 대신에 사용할 수 있는 조금 더 구체적인 애너테이션
    private EntityManager entityManager; //jpa 라이브러리가 지원하는 데이터베이스 접근책

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }
}