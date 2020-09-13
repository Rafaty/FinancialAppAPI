package com.example.financialApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.financialApp.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	@Query("SELECT count(c.id) as amt from Client c ")
	Integer getNumberOfClients();

}
