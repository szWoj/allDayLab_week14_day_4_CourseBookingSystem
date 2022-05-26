package com.CodeClan.example.coursebookingsystem.repository;

import com.CodeClan.example.coursebookingsystem.models.Course;
import com.CodeClan.example.coursebookingsystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByRating(int rating);
    Course findByName(String name);
    List<Course> findByBookingsCustomer(Customer customer);
//    List<Course> findByCustomer(String name);
}
