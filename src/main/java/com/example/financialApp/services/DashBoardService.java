package com.example.financialApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.financialApp.models.DashBoard;

@Service
public class DashBoardService {
	
	
	@Autowired
	JobService jobService;
	
	
	@Autowired
	ClientService clientService;
	
	
	public DashBoard getDashboard() {
		
		DashBoard dashBoard = new DashBoard();
		
		dashBoard.setNextJobsToDelivery(jobService.getNextJobsToDo());
		dashBoard.setNumberOfJobs(jobService.getNumberOfJobs());
		dashBoard.setRevenue(jobService.getTotalRevenue());
		
		dashBoard.setNumberOfClients(clientService.getNumberOfClients());
		
		return dashBoard;
	}

}
