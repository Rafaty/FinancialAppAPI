package com.example.financialApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.financialApp.models.Client;
import com.example.financialApp.services.ClientService;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping
	public List<Client> findAll() {
		return service.findAll();

	}

	@PostMapping(path = "/create")
	public ResponseEntity<Client> create(@RequestBody Client obj) {
		obj = service.insert(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));

	}
	
	

}