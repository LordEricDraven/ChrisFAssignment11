package com.codercampus.Assignment11.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepo;
	
	public List<Transaction> findAll(){
		return transactionRepo.findAll()
							  .stream()
							  .sorted(Comparator.comparing(Transaction::getDate))
							  .collect(Collectors.toList());
	}
	
	public Transaction findById(Long transactionId) {
		return transactionRepo.findById(transactionId);
	}
}
