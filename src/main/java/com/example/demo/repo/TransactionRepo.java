package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Transaction;
import com.example.demo.model.User;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
	

	public List<Transaction>  findByUser(User user);
	
	
	//@Query("SELECT tx FROM Transaction tx JOIN tx.bookCopy bc WHERE tx.user.userId = :userId AND bc.book.bookId = :bookId")
	//@Query("SELECT tx FROM Transaction tx JOIN tx.bookCopy bc JOIN bc.book b WHERE tx.user.userId = :userId AND b.bookId = :bookId")
	/*
	 * @Query("SELECT tx FROM Transaction tx JOIN tx.bookCopy bc WHERE tx.user.userId = :userId AND bc.book.bookId = :bookId"
	 * ) public Optional<Transaction> getByUserIDNBookID(Long userId, Long bookId);
	 */
	
	@Query("SELECT tx FROM Transaction tx LEFT JOIN FETCH tx.bookCopy bc LEFT JOIN FETCH tx.user WHERE tx.user.userId = :userId AND bc.book.bookId = :bookId and tx.status='Open'")
	Optional<Transaction> getByUserIDNBookID(Long userId,  Long bookId);



	
	

}
