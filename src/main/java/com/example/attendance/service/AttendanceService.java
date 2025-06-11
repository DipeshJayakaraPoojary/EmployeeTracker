package com.example.attendance.service;

import com.example.attendance.model.Attendance;
import com.example.attendance.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public void generateDailyReport() {
        List<Attendance> all = attendanceRepository.findAll();
        System.out.println("✅ Daily attendance entries: " + all.size());
    }

    public void archiveOldAttendance() {
        System.out.println("📦 Archiving old attendance data...");
    }

    public void detectAnomalies() {
        List<Attendance> absent = attendanceRepository.findAllByStatus("ABSENT");
        System.out.println("🚨 Absent entries: " + absent.size());
    }

    public void calculateSalaryAdjustments() {
        LocalDate start = LocalDate.now().minusMonths(1);
        LocalDate end = LocalDate.now();
        List<Attendance> records = attendanceRepository.findByDateBetween(start, end);
        System.out.println("💰 Salary adjustments calculated for: " + records.size() + " records");
    }
}
