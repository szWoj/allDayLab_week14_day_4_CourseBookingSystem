package com.CodeClan.example.coursebookingsystem.controller;

import com.CodeClan.example.coursebookingsystem.models.Booking;
import com.CodeClan.example.coursebookingsystem.models.Course;
import com.CodeClan.example.coursebookingsystem.models.Customer;
import com.CodeClan.example.coursebookingsystem.repository.BookingRepository;
import com.CodeClan.example.coursebookingsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

//    @GetMapping(value="/bookings")
//    public ResponseEntity<List<Booking>> getAllBookings(){
//        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity getBookings(@PathVariable Long id){
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> findBookingsByDate(@RequestParam(name = "date", required = false) String date
                                                           ){
        if(date != null){
            return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
        }

        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }
}
