package com.example.demo.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository
public interface BookRepo  extends JpaRepository<Book, Long>{

	@Query("SELECT b FROM Book b WHERE LOWER(b.genre) LIKE LOWER(CONCAT('%',:key,'%'))")
	List<Book> findBySearch(String key);
	
	@Query("SELECT bc.copyId FROM Book b JOIN b.bookCopies bc WHERE b.bookId = :bookId AND bc.status = 'Available'")
	List<Long> findAvailableCopies(Long bookId);


	@Query("SELECT bc.copyId FROM Book b JOIN b.bookCopies bc WHERE b.bookId = :bookId AND bc.status = 'Available'")
	List<Book> findByuserId(Long userId);
	

}
