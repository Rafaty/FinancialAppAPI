package com.example.financialApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.financialApp.models.WalletItem;

public interface WalletItemRepository extends JpaRepository<WalletItem, Long> {
	
	Optional<WalletItem> findByIdAndWalletId(Long id, Long walletId);

}
