package com.example.financialApp.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "jobs")
public class Job implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "client_id")
	private Client client;

	@OneToOne()
	@JoinColumn(name = "wallet_id", referencedColumnName = "id")
	private Wallet wallet;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date initialDate;


	@Future
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date finalDate;

	
	@Column(nullable = false)
	private Double budget;

	@NotEmpty
	@Size(max = 300)
	@Column(nullable = false, length = 300)
	private String description;

	public Job() {

	}

	public Job(Long id, String description, Client client, Date initialDate, Date finalDate, Double budget, Wallet wallet) {
		super();
		this.id = id;
		this.description = description;
		this.client = client;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;
		this.wallet = wallet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

}
