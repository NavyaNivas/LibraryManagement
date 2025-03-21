package com.example.demo.service;

import java.time.LocalDateTime;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookCopy;
import com.example.demo.model.Payments;
import com.example.demo.model.Transaction;
import com.example.demo.model.TransactionDTO;
import com.example.demo.model.User;
import com.example.demo.repo.BookCopyRepo;
import com.example.demo.repo.BookRepo;
import com.example.demo.repo.PaymentsRepo;
import com.example.demo.repo.TransactionRepo;
import com.example.demo.repo.UserRepo;


@Service
public class TransactionService {
	@Autowired
	TransactionRepo txRepo;
	@Autowired
	BookRepo bookRepo;
	@Autowired 
	BookCopyRepo bookCopyRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	PaymentsRepo paymentRepo;
	

	//public ResponseEntity<Transaction> createTransaction(long userId,long bookId)
	public ResponseEntity<TransactionDTO> createTransaction(long userId,long bookId)

	{
		Transaction tx = new Transaction();
		
		LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime futureDateTime = currentDateTime.plusDays(7);
		
		List<Long> copyIds = bookRepo.findAvailableCopies(bookId);
		System.out.println(copyIds.size());
	
		if(copyIds.size()>0)
		{
			System.out.println("inside if..");
			BookCopy bkcpy = bookCopyRepo.findById(copyIds.get(0)).orElse(new BookCopy());
			System.out.println(bkcpy.getStatus());
			User user = userRepo.findById(userId).get();
			bkcpy.setStatus("Not Available");
			tx.setBookCopy(bkcpy);
			tx.setUser(user);
			tx.setIssuedDate(currentDateTime);
			tx.setDueDate(futureDateTime);
			tx.setStatus("Open");
			txRepo.save(tx);
			
			TransactionDTO txDto=new TransactionDTO(bookId,userId,tx.getIssuedDate(),tx.getReturndate(),tx.getDueDate(),bkcpy.getCopyId(),tx.getStatus(),tx.getTransactionId());

			return new ResponseEntity<>(txDto,HttpStatus.CREATED);
			//return new ResponseEntity<>(tx,HttpStatus.CREATED);
			
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
		
		
	}
	
	
	public ResponseEntity<TransactionDTO> closeTransaction(Long userId, long bookId) {
	    
		try {
	       
            Payments payment = new Payments() ;
            
	        Optional<Transaction> optionalTx = txRepo.getByUserIDNBookID(userId, bookId);
	        if (!optionalTx.isPresent()) {
	            System.err.println("Transaction not found for userId: " + userId + " and bookId: " + bookId);
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	        Transaction tx = optionalTx.get();
	        System.out.println("Transaction found: " + tx.getTransactionId());

	        BookCopy bkcpy = tx.getBookCopy();
	        bkcpy.setStatus("Available");
	        bookCopyRepo.save(bkcpy);

	        tx.setReturndate(LocalDateTime.now());
	        tx.setStatus("Close");
	        txRepo.save(tx);
	        long daysBetween = ChronoUnit.DAYS.between(tx.getDueDate(), tx.getReturndate());
	        if(daysBetween>0)
	        {
	        	payment.setAmount(daysBetween*10);
	        	payment.setPaidDate(tx.getReturndate());
	        	payment.setUserId(userId);
	        	payment.setStatus("Paid");
	        	payment.setTransactionId(tx.getTransactionId());
	        	paymentRepo.save(payment);
	        	
	        }

			TransactionDTO txDto=new TransactionDTO(bookId,userId,tx.getIssuedDate(),tx.getReturndate(),tx.getDueDate(),bkcpy.getCopyId(),tx.getStatus(),tx.getTransactionId());


	        return new ResponseEntity<>(txDto, HttpStatus.OK);
	    } catch (Exception e) {
	        System.err.println("Error closing transaction: " + e.getMessage());
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


	public List<TransactionDTO> getUserTransactions(long userid) {
		
		User user = userRepo.findById(userid).orElseThrow(()->new UsernameNotFoundException("User not found: " + userid));
		List<Transaction> transactions= txRepo.findByUser(user);
		List<TransactionDTO> txDTOS =new ArrayList<TransactionDTO>();
		
		for(Transaction t:transactions)
		{
			TransactionDTO txDTO = new TransactionDTO();
           
			txDTO.setBookId(t.getBookCopy().getBook().getBookId());
			txDTO.setUserId(userid);
			txDTO.setCopyId(t.getBookCopy().getCopyId());
			txDTO.setIssuedDate(t.getIssuedDate());
			txDTO.setReturndate(t.getReturndate());
			txDTO.setDueDate(t.getDueDate());
			txDTO.setStatus(t.getStatus());
			txDTO.setTransactionId(t.getTransactionId());
			txDTOS.add(txDTO);	
		
				
		
		}
		return txDTOS;
	}



	
	
}
