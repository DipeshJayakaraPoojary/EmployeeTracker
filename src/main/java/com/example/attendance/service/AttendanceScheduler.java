package com.example.attendance.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AttendanceScheduler {

    private final AttendanceService service;

    public AttendanceScheduler(AttendanceService service) {
        this.service = service;
    }

    @Scheduled(cron = "0 0 6 * * *")
    public void generateDailyReport() {
        service.generateDailyReport();
    }

    @Scheduled(cron = "0 0 0 * * SUN")
    public void archiveOldData() {
        service.archiveOldAttendance();
    }

    @Scheduled(cron = "0 */15 * * * *")
    public void checkForAnomalies() {
        service.detectAnomalies();
    }

    @Scheduled(cron = "0 0 0 1 * *")
    public void calculateMonthlySalaryAdjustments() {
        service.calculateSalaryAdjustments();
    }
}
