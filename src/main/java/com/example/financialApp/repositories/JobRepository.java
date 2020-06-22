package com.example.financialApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.financialApp.models.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}
