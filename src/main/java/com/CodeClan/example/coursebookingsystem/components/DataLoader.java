package com.CodeClan.example.coursebookingsystem.components;

import com.CodeClan.example.coursebookingsystem.models.Booking;
import com.CodeClan.example.coursebookingsystem.models.Course;
import com.CodeClan.example.coursebookingsystem.models.Customer;
import com.CodeClan.example.coursebookingsystem.repository.BookingRepository;
import com.CodeClan.example.coursebookingsystem.repository.CourseRepository;
import com.CodeClan.example.coursebookingsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){

        Course coursePython = new Course("Python", "Edinburgh", 4);
        courseRepository.save(coursePython);

        Course courseJava = new Course("Java", "Edinburgh", 5);
        courseRepository.save(courseJava);

        Customer customer1 = new Customer("Szymon", "Edinburgh", 30);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Mark", "Glasgow", 28);
        customerRepository.save(customer2);

        Booking booking1 = new Booking("01-06-2022", coursePython, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("01-07-2022", courseJava, customer2);
        bookingRepository.save(booking2);




    }
}
