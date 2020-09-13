package com.example.financialApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.financialApp.models.DashBoard;
import com.example.financialApp.services.DashBoardService;

@RestController
@RequestMapping("/dashboard")
public class DashBoardController {

	@Autowired
	DashBoardService service; 
	
	@GetMapping()
	public ResponseEntity<DashBoard> getDashboard(){
		return ResponseEntity.ok().body(service.getDashboard());
	}
}
