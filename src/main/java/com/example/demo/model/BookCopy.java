package com.example.demo.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Component
public class BookCopy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "copyid")
	private long copyId;
	
	private String status;
	@ManyToOne
    @JoinColumn(name = "bookid", referencedColumnName = "bookid",nullable = false)
	@JsonBackReference
	private Book book;
	public long getCopyId() {
		return copyId;
	}
	public void setCopyId(long copyId) {
		this.copyId = copyId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BookCopy(long copyId, String status, Book book) {
		super();
		this.copyId = copyId;
		this.status = status;
		this.book = book;
	}

	/*
	 * @Override public String toString() { return "BookCopy [copyId=" + copyId +
	 * ", status=" + status + ", book=" + book + "]"; }
	 */
	public BookCopy() {
		super();
	}
	
	
	

}
