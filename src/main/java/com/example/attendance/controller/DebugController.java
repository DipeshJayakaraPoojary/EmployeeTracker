package com.example.attendance.controller;

import com.example.attendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class DebugController {

    @Autowired
    private AttendanceService attendanceService;

    // Endpoint to trigger daily attendance report
    @GetMapping("/report")
    public String triggerDailyReport() {
        attendanceService.generateDailyReport();
        return "✅ Daily report triggered manually.";
    }

    // Endpoint to trigger anomaly detection
    @GetMapping("/anomalies")
    public String triggerAnomalyDetection() {
        attendanceService.detectAnomalies();
        return "🔍 Anomaly detection triggered manually.";
    }

    // Endpoint to simulate archiving old attendance records
    @GetMapping("/archive")
    public String archiveOldData() {
        attendanceService.archiveOldAttendance();
        return "📦 Archiving triggered manually.";
    }

    // Endpoint to trigger monthly salary adjustment logic
    @GetMapping("/salary")
    public String calculateSalaryAdjustments() {
        attendanceService.calculateSalaryAdjustments();
        return "💰 Salary adjustments triggered manually.";
    }
}
