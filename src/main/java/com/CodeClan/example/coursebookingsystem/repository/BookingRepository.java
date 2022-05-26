package com.CodeClan.example.coursebookingsystem.repository;

import com.CodeClan.example.coursebookingsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByDate(String date);
}
