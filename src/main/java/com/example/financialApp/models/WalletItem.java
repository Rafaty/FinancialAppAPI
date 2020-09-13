package com.example.financialApp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.financialApp.models.enums.WalletItemType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "wallet_items")
public class WalletItem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String description;
	
	private Integer type;

	private Double value;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wallet_id", referencedColumnName = "id")
	private Wallet wallet;
	
	
	public WalletItem() {
		
	}

	public WalletItem(Long id, String description, WalletItemType type, Double value ,Wallet wallet) {
		super();
		this.id = id;
		this.description =description;
		setType(type);
		this.value = value;
		this.wallet = wallet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public WalletItemType getType() {
		return WalletItemType.valueOf(type);
	}

	public void setType(WalletItemType type) {
		if (type != null) {
			this.type = type.getCode();
		}
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}


}
