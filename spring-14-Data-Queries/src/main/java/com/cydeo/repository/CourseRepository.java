package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

    //find all courses by category select  where category=
    List<Course> findByCategory(String category);

    //find all courses by category and order the entities by name

    List<Course> findByCategoryOrderByName(String category);

    //Checks if a course with the supplied name exists. Return true if exists, false otherwise
  boolean existsByName(String name);
    //Returns the count of courses for the given category
 int countByCategory(String category);

    //Finds all the courses that start with the given course name string
 List<Course> findByCategoryStartingWith(String name);
    //Find all courses by category and returns a stream
 List<Course> streamAllByCategory(String category);



}
