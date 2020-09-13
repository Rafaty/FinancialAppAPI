package com.example.financialApp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.financialApp.models.Wallet;
import com.example.financialApp.services.WalletService;

@RestController
@RequestMapping(path = "/wallets")
public class WalletController {

	@Autowired
	private WalletService service;

	@GetMapping
	public List<Wallet> findAll() {
		return service.findAll();

	}

	@PostMapping("/create")
	public ResponseEntity<Wallet> create(@RequestBody Wallet obj) {
		obj = service.insert(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Wallet>> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));

	}
	
	
	
	

}