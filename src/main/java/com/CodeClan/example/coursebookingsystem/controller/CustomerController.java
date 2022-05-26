package com.CodeClan.example.coursebookingsystem.controller;

import com.CodeClan.example.coursebookingsystem.models.Course;
import com.CodeClan.example.coursebookingsystem.models.Customer;
import com.CodeClan.example.coursebookingsystem.repository.CourseRepository;
import com.CodeClan.example.coursebookingsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

//    @GetMapping(value="/customers")
//    public ResponseEntity<List<Customer>> getAllCustomers(){
//        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/customers")
    public ResponseEntity findByBookingsCourse(@RequestParam(name = "course", required = false) String course){
        if(course != null){
            Course newCourse = courseRepository.findByName(course);
            return new ResponseEntity<>(customerRepository.findByBookingsCourse(newCourse), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);

    }
}

