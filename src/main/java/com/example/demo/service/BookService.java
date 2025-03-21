package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookrepo;
	

	public List<Book> getAll() {
		
		return bookrepo.findAll();
		
	}

	public List<Book> getAllBySearch(String key) {
		
		return bookrepo.findBySearch(key);
	}

	public Book addBook(Book book) {
		
		/*
		 * if (book.getBookCopies() != null) { for (BookCopy copy :
		 * book.getBookCopies()) { copy.setBook(book); } }
		 */
		
		System.out.println("Calling repository");
		Book bk=bookrepo.save(book);
		if(bk==null)
		{
			System.out.println("saved book is null");
		}
		System.out.println(bk);
		return bk ;
		
		
	}

	public Book update(Book updatedbook) {
		
		Book existingBook = bookrepo.findById(updatedbook.getBookId()).get();
		existingBook.setAuthor(updatedbook.getAuthor());
		existingBook.setTitle(updatedbook.getTitle());
		existingBook.setGenre(updatedbook.getGenre());
		
		return bookrepo.save(existingBook);
			
	}
	
	public String delete(long id) {
		 try
		 {
			 bookrepo.deleteById(id);
			 return "deleted";
			 
		 }
		 catch (Exception e) {
			 return "Unable to dlete now";
			
		}
	}

	public List<Book> addBooks(List<Book> books) {
		
		return  bookrepo.saveAll(books);
		
	}
	
	public List<Long> availableCopies(Long bookId)
	{
		List<Long> copyIds = bookrepo.findAvailableCopies(bookId);
		return copyIds;
	}
	
	
	

}
