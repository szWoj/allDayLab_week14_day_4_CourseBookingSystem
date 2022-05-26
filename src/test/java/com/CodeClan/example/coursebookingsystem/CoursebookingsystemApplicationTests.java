package com.CodeClan.example.coursebookingsystem;

import com.CodeClan.example.coursebookingsystem.models.Booking;
import com.CodeClan.example.coursebookingsystem.models.Course;
import com.CodeClan.example.coursebookingsystem.models.Customer;
import com.CodeClan.example.coursebookingsystem.repository.BookingRepository;
import com.CodeClan.example.coursebookingsystem.repository.CourseRepository;
import com.CodeClan.example.coursebookingsystem.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CoursebookingsystemApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllCoursesByRating(){
		List<Course> courses = courseRepository.findByRating(5);
		assertEquals(1, courses.size());
	}

	@Test
	public void getAllCustomersForGivenCourse(){
		Course course = courseRepository.getOne(1L);
		List<Customer> foundCustomers = customerRepository.findByBookingsCourse(course);
		assertEquals(1, foundCustomers.size());
	}

	@Test
	public void getAllCoursesForCustomer(){
		Customer customer = customerRepository.getOne(1L);
		List<Course> courses = courseRepository.findByBookingsCustomer(customer);
		assertEquals(1, courses.size());
	}

	@Test
	public void getAllBookingsForGivenDate(){
		List<Booking> bookings = bookingRepository.findByDate("01-06-2022");
		assertEquals(1, bookings.size());
	}

}
