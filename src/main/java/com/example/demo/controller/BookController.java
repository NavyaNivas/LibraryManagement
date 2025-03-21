package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	@PostMapping("/addbook")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		System.out.println("Inside the book controller");
		System.out.println(book);
		try
		{
			
			return  new ResponseEntity<>(bookService.addBook(book),HttpStatus.OK);
		}
		
		catch (Exception e) {
			
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/addbooks")
	private ResponseEntity<List<Book>> addBooks(@RequestBody List<Book> books)
	{
		System.out.println("add books method..");
		try
		{
			return  new ResponseEntity<>(bookService.addBooks(books),HttpStatus.OK);
		}
		
		catch (Exception e) {
			
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@GetMapping("/getall")
	private ResponseEntity<List<Book>> getAllBooks()
	{
		try
		{
			return  new ResponseEntity<>(bookService.getAll(),HttpStatus.OK);
		}
		
		catch (Exception e) {
			
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
     }
	
	@GetMapping("/getallbykey")
	private ResponseEntity<List<Book>> getBooksBykey(@RequestParam String searchkey)
	{
		try
		{
			return  new ResponseEntity<>(bookService.getAllBySearch(searchkey),HttpStatus.OK);
		}
		
		catch (Exception e) {
			
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	@PutMapping("update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book book) {
		
		try
		{
			return  new ResponseEntity<>(bookService.update(book),HttpStatus.OK);
		}
		
		catch (Exception e) {
			
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("delete/{id}")
     public ResponseEntity<String> deleteBook(@PathVariable long id) {
		
		try
		{
			return  new ResponseEntity<>(bookService.delete(id),HttpStatus.OK);
		}
		
		catch (Exception e) {
			
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
