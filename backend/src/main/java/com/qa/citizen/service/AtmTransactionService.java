package com.qa.citizen.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.AtmPoint;
import com.qa.citizen.domain.AtmTransaction;
import com.qa.citizen.domain.Bankcard;
import com.qa.citizen.repo.AtmTransactionsRepo;
import com.qa.citizen.rest.DTOs.AtmPointDTO;
import com.qa.citizen.rest.DTOs.AtmTransactionsDTO;

@Service
public class AtmTransactionService {

	private AtmTransactionsRepo repo;
	
	public AtmTransactionService(AtmTransactionsRepo repo) {
		super();
		this.repo = repo;
	}
	
	public List<AtmTransaction> getAtmTransactionsByCard(Bankcard cardNumber) {
		List<AtmTransaction> cardTransactions = this.repo.findByBankCardNumber(cardNumber);
		return cardTransactions;
	}
	
	
	private AtmTransactionsDTO mapToDTO(AtmTransaction atmTransaction) {
		AtmTransactionsDTO atmTransactionDTO = new AtmTransactionsDTO();

		atmTransactionDTO.setTimestamp(atmTransaction.getTimestamp());
		atmTransactionDTO.setType(atmTransaction.getType());
		atmTransactionDTO.setAmount(atmTransaction.getAmount());
		
		AtmPoint atmPoint = atmTransaction.getAtmId();
		
		atmTransactionDTO.setStreetName(atmPoint.getStreetName());
		atmTransactionDTO.setPostcode(atmPoint.getPostcode());		
		
		return atmTransactionDTO;
	}
	
	public List<AtmTransactionsDTO> getDTO(Bankcard bankCardNumber) {
		List<AtmTransaction> cardTransactions = this.repo.findByBankCardNumber(bankCardNumber);
		List<AtmTransactionsDTO> dtos = new ArrayList<>();

		for (AtmTransaction atmTransaction : cardTransactions) {
			AtmTransactionsDTO dto = this.mapToDTO(atmTransaction);
			dtos.add(dto);
		}

		return dtos;
	}


}
