package com.example.financialApp.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.financialApp.models.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

	List<Job> findAllByFinalDateBetween(Date today, Date nextMonth);

	@Query("SELECT count(j.id) as amt from Job j ")
	Integer getNumberOfJobs();

	@Query("SELECT sum(j.budget) from Job j")
	Double getTotalRevenue();

}
