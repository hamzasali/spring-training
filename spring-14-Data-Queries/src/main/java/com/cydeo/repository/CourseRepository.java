package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    //Find all courses by category
    List<Course> findByCategory(String category);

    //Find all courses by category and order the entity by name
    List<Course> findByCategoryOrderByName(String category);

    //checks if the course with supplied name exists.return true if exists, false otherwise
    boolean existsByName(String name);

    //returns the count of courses by given category
    Integer countByCategory(String category);

    //Find all courses that start with given course name string
    List<Course> findByNameStartingWith(String pattern);

    //find all courses by category and return stream
    Stream<Course> streamByCategory(String category);

    //

}
