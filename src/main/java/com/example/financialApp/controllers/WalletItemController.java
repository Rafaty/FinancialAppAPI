package com.example.financialApp.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.financialApp.models.WalletItem;
import com.example.financialApp.services.WalletItemService;

@RestController
@RequestMapping(path = "/wallets")
public class WalletItemController {

	@Autowired
	private WalletItemService service;


	@PostMapping(path = "/{walletId}/items/create")
	public ResponseEntity<WalletItem> create(@PathVariable Long walletId, @RequestBody WalletItem obj) {
		obj = service.addItem(obj,walletId);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);

	}

	@GetMapping(path = "/{walletId}/items/{id}")
	public ResponseEntity<WalletItem> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));

	}
	
	@PutMapping(path = "/{walletId}/items/{itemId}")
	public ResponseEntity<WalletItem> delete(@PathVariable Long walletId,@PathVariable Long itemId) {
		service.removeItem(itemId, walletId);
		return ResponseEntity.ok().build();

	}
	
	

}