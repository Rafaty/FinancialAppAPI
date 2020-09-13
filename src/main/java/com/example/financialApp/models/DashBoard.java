package com.example.financialApp.models;

import java.io.Serializable;
import java.util.List;

public class DashBoard implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer numberOfClients;

	private Integer numberOfJobs;

	private Double revenue;

	private List<Job> nextJobsToDelivery;

	public DashBoard() {
		
	}

	public DashBoard(Integer numberOfClients, Integer numberOfJobs, Double revenue, List<Job> nextJobsToDelivery) {
		super();
		this.numberOfClients = numberOfClients;
		this.numberOfJobs = numberOfJobs;
		this.revenue = revenue;
		this.nextJobsToDelivery = nextJobsToDelivery;
	}

	public List<Job> getNextJobsToDelivery() {
		return nextJobsToDelivery;
	}

	public void setNextJobsToDelivery(List<Job> nextJobsToDelivery) {
		this.nextJobsToDelivery = nextJobsToDelivery;
	}

	public Integer getNumberOfClients() {
		return numberOfClients;
	}

	public void setNumberOfClients(Integer numberOfClients) {
		this.numberOfClients = numberOfClients;
	}

	public Integer getNumberOfJobs() {
		return numberOfJobs;
	}

	public void setNumberOfJobs(Integer numberOfJobs) {
		this.numberOfJobs = numberOfJobs;
	}

	public Double getRevenue() {
		return revenue;
	}

	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}

	
	
}
