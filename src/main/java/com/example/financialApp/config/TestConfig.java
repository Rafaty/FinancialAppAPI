package com.example.financialApp.config;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.financialApp.models.Client;
import com.example.financialApp.models.Job;
import com.example.financialApp.models.Wallet;
import com.example.financialApp.models.WalletItem;
import com.example.financialApp.models.enums.WalletItemType;
import com.example.financialApp.repositories.ClientRepository;
import com.example.financialApp.repositories.JobRepository;
import com.example.financialApp.repositories.WalletItemRepository;
import com.example.financialApp.repositories.WalletRepository;
import com.sun.el.parser.ParseException;

@Profile("test")
@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	JobRepository jobRepository;

	@Autowired
	WalletRepository walletRepository;

	@Autowired
	WalletItemRepository walletItemRepository;

	 public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("dd/MM/yyyy").parse(date);
	     } catch (Exception e) {
	         return null;
	     }
	  }
	@Override
	public void run(String... args) throws Exception {

		Date initialDate = new Date();
		Date finalDate =  parseDate("10/02/2021");
		Client c1 = new Client(null, "Carlos Santos","(24)2222-2222");
		Client c2 = new Client(null, "Augusto Ferreira","(24)3333-3333");
		Client c3 = new Client(null, "Paulo da Silva","(24)4444-44444");

		

		Wallet w1 = new Wallet(null);
		Wallet w2 = new Wallet(null);
		Wallet w3 = new Wallet(null);
		Wallet w4 = new Wallet(null);
		
		
		Job j1 = new Job(null, "Construção de um predio em Areal", c1, initialDate, finalDate, 150000.0,w1);
		Job j2 = new Job(null, "Pintura da casa", c2, initialDate, parseDate("30/09/2020"), 2500.0,w2);
		Job j3 = new Job(null, "Construção da psicina e área de lazer", c3, initialDate, parseDate("10/12/2020"), 30000.0,w3);

		WalletItem wi1 = new WalletItem(null, "pagamento dos funcionarios", WalletItemType.EXIT, 1500.00, w1);
		WalletItem wi2 = new WalletItem(null, "medição quinzenal", WalletItemType.ENTRY, 1000.00, w2);
		WalletItem wi3 = new WalletItem(null, "aluguel de maquinas", WalletItemType.EXIT, 230.00, w3);
		WalletItem wi4 = new WalletItem(null, "pagamento funcionarios", WalletItemType.EXIT, 1500.00, w4);

		clientRepository.saveAll(Arrays.asList(c1, c2, c3));
		walletRepository.saveAll(Arrays.asList(w1, w2, w3, w4));


		jobRepository.saveAll(Arrays.asList(j1, j2, j3));

		
		walletItemRepository.saveAll(Arrays.asList(wi1, wi2, wi3, wi4));

	}

}
