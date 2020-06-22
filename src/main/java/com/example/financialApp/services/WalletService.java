package com.example.financialApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.financialApp.models.Wallet;
import com.example.financialApp.models.WalletItem;
import com.example.financialApp.repositories.WalletRepository;

@Service
public class WalletService {

	@Autowired
	private WalletRepository repository;
	
	@Autowired
	private WalletItemService walletItemService;
	

	public List<Wallet> findAll() {
		return repository.findAll();
	}

	public Optional< Wallet> findById(Long id) {
		Optional<Wallet> obj = repository.findById(id);
		return obj;

	}

	public Wallet insert(Wallet obj) {
		
		
	  Wallet wallet =repository.save(obj);
		
		for (WalletItem x : obj.getItems()) {
		 walletItemService.insert(new WalletItem(null,x.getDescription(),x.getType(),x.getValue(),wallet));
		}
		return wallet;
		
	}

	
}
