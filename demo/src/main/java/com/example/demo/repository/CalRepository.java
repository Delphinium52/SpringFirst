package com.example.demo.repository;

import com.example.demo.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalRepository extends JpaRepository<Calendar, Long> {
}
