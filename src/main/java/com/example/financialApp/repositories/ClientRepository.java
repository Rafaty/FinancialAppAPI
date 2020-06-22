package com.example.financialApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.financialApp.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
