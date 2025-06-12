package com.example.demo.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.event.model.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}