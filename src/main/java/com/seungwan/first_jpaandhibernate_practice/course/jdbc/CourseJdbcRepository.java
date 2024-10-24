package com.seungwan.first_jpaandhibernate_practice.course.jdbc;

import com.seungwan.first_jpaandhibernate_practice.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate  springJdbcTemplate;

    private static String INSERT_QUERY=

            """
             insert into course (id,name,author) values(?, ?, ?);       """;

    private static String DELETE_QUERY =
            """
               DELETE from course where id = ?;
            """;

    private static String SELECT_QUERY =
            """
               SELECT * from course where id = ?;
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        // 2 번째 인자는 데이터베이스의 로우(tuple)을 조회한 뒤, 이를 Java 객체로 매핑해주는 역할임
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
