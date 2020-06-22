package com.example.financialApp.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.financialApp.model.enums.WalletItemType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "wallets")
public class Wallet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(mappedBy = "wallet")
	private Job job;

	@OneToMany(mappedBy = "wallet")
	private List<WalletItem> items = new ArrayList<WalletItem>();

	public Wallet() {

	}

	public Wallet(Long id, Job job, List<WalletItem> items) {
		super();
		this.id = id;
		this.job = job;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<WalletItem> getItems() {
		return items;
	}

	public Double getTotal() {
		Double total = 0.0;
		for (WalletItem x : items) {
			
			if (x.getType() == WalletItemType.ENTRY) {
				total += x.getValue();

			} else if (x.getType() == WalletItemType.EXIT) {
				total -= x.getValue();
			}

		}
		return total;

	}

	public void setItems(List<WalletItem> items) {
		this.items = items;
	}

}
