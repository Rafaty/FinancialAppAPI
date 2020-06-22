package com.example.financialApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.financialApp.models.WalletItem;
import com.example.financialApp.repositories.WalletItemRepository;

@Service
public class WalletItemService {

	@Autowired
	private WalletItemRepository repository;

	@Autowired
	private WalletService walletService;

	public List<WalletItem> findAll() {
		return repository.findAll();
	}

	public WalletItem findById(Long id) {
		Optional<WalletItem> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException());

	}

	public WalletItem insert(WalletItem obj) {
		return repository.save(obj);
	}

	public WalletItem addItem(WalletItem obj, Long walletId) {
		return walletService.findById(walletId).map(wallet -> {
			obj.setWallet(wallet);
			return repository.save(obj);
		}).orElseThrow(() -> new RuntimeException());

	}

	public void removeItem(Long itemId, Long walletId) {
	try {
		 repository.findByIdAndWalletId(itemId, walletId).map(item  -> {
				repository.delete(item);
				return null;
			}).orElseThrow(() -> new RuntimeException());
			
	}catch (Exception e) {
		// TODO: handle exception
	}
	
}
}
