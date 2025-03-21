package com.example.demo.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Component
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	 
	@ManyToOne
    @JoinColumn(name = "copyid", nullable = false)
	private BookCopy bookCopy;
	@CreationTimestamp(source = SourceType.DB)
	@Column(updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:MM:SS")
	private LocalDateTime issuedDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:MM:SS")
	private LocalDateTime returndate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:MM:SS")
	private LocalDateTime dueDate;
	private String status;
	@ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    @JsonBackReference
	private User user;
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public BookCopy getBookCopy() {
		return bookCopy;
	}
	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}
	public LocalDateTime getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(LocalDateTime currentDateTime) {
		this.issuedDate = currentDateTime;
	}
	public LocalDateTime getReturndate() {
		return returndate;
	}
	public void setReturndate(LocalDateTime futureDateTime) {
		this.returndate = futureDateTime;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime due_date) {
		this.dueDate = due_date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Transaction(BookCopy bookCopy, LocalDateTime issuedDate, LocalDateTime returndate, LocalDateTime dueDate,
			String status, User user) {
		super();
		this.bookCopy = bookCopy;
		this.issuedDate = issuedDate;
		this.returndate = returndate;
		this.dueDate = dueDate;
		this.status = status;
		this.user = user;
	}
	public Transaction() {
		super();
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", bookCopy=" + bookCopy + ", issuedDate=" + issuedDate
				+ ", returndate=" + returndate + ", dueDate=" + dueDate + ", status=" + status + ", user=" + user + "]";
	}
	
	

}
