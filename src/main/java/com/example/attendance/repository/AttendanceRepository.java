package com.example.attendance.repository;

import com.example.attendance.model.Attendance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends MongoRepository<Attendance, String> {
    List<Attendance> findAllByStatus(String status);
    List<Attendance> findByDateBetween(LocalDate start, LocalDate end);
}
