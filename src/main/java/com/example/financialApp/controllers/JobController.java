package com.example.financialApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.financialApp.models.Job;
import com.example.financialApp.services.JobService;

@RestController
@RequestMapping(path = "/jobs")
public class JobController {

	@Autowired
	private JobService service;

	@GetMapping
	public List<Job> findAll() {
		return service.findAll();

	}

	@PostMapping(path = "/create")
	public ResponseEntity<Job> create(@RequestBody Job obj) {
		obj = service.insert(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Job> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));

	}
	
	

}