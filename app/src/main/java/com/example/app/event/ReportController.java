package com.example.app.event;

import com.example.app.websocket.EventDTO;
import com.example.app.event.Report;
import com.example.app.event.ReportRepository;
import com.example.app.websocket.WebSocketNotificationService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/events")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<Report> getAll() {
        return reportService.getAllReports();
    }

    @PostMapping
    public Report create(@RequestBody Report report) {
        return reportService.createReport(report);
    }

    @GetMapping("/{id}")
    public Report getById(@PathVariable Long id) {
        return reportService.getReportById(id);
    }

    @PutMapping("/{id}")
    public Report update(@PathVariable Long id, @RequestBody Report updated) {
        return reportService.updateReport(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reportService.deleteReport(id);
    }
}