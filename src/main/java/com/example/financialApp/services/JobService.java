package com.example.financialApp.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.financialApp.models.Job;
import com.example.financialApp.models.Wallet;
import com.example.financialApp.repositories.JobRepository;

@Service
public class JobService {

	@Autowired
	private JobRepository repository;
	@Autowired
	private WalletService walletService;

	public List<Job> findAll() {
		return repository.findAll();
	}

	public Job findById(Long id) {
		Optional<Job> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException());

	}

	public Job insert(Job obj) {
		repository.save(obj);

		Wallet wallet = new Wallet();
		
		walletService.insert(wallet);

		obj.setWallet(wallet);

		return repository.save(obj);
	}

	public Double getTotalRevenue() {
		return repository.getTotalRevenue();
	}

	public Integer getNumberOfJobs() {
		return repository.getNumberOfJobs();
	}

	public List<Job> getNextJobsToDo() {
		Date today = new Date();
		
		
		Date nextMonth = Date
				.from((LocalDate.now().plusMonths(1)).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

		return repository.findAllByFinalDateBetween(today, nextMonth);
	}

}
