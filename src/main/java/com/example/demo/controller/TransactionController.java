package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.TransactionDTO;
import com.example.demo.service.TransactionService;

@RestController
@RequestMapping("/library")
public class TransactionController {

	@Autowired
	TransactionService tranService;
	
	@PostMapping("/checkin")
	public ResponseEntity<TransactionDTO> bookCheckin(@RequestBody TransactionDTO dto)
	{
		return tranService.createTransaction(dto.getUserId(), dto.getBookId());
		
		
	}
	
	@PutMapping("/checkout")
	public ResponseEntity<TransactionDTO> bookCheckout(@RequestBody TransactionDTO dto)
	{
		
		return tranService.closeTransaction(dto.getUserId(), dto.getBookId());
		
		
	}
	
	@GetMapping("/alltransactions/{userid}")
	public List<TransactionDTO> getUserTransactions(@PathVariable("userid") long userid)
	{
		return tranService.getUserTransactions(userid);
		
	}
	
	

}
