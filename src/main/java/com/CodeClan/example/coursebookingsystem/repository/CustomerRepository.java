package com.CodeClan.example.coursebookingsystem.repository;

import com.CodeClan.example.coursebookingsystem.models.Course;
import com.CodeClan.example.coursebookingsystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourse(Course course);

    Customer findByName(String name);

    List<Customer> findByTownAndBookingsCourse(String town, Course course);
}