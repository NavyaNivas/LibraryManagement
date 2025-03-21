package com.example.demo.model;
import java.time.LocalDateTime;




public class TransactionDTO {
	private long transactionId;
	private long bookId;
	private Long userId;
	private LocalDateTime issuedDate;
	private LocalDateTime returndate;
	private LocalDateTime dueDate;
	private long copyId;
	private String status;
	
	
	
	public TransactionDTO(long bookId, Long userId, LocalDateTime issuedDate, LocalDateTime returndate,
			LocalDateTime dueDate,long copyId,String status,long transactionID) {
		super();
		System.out.println( bookId+"\t"+ userId +"\t"+ issuedDate+"\t"+ returndate+"\t"+dueDate);
		this.bookId = bookId;
		this.userId = userId;
		this.issuedDate = issuedDate;
		this.returndate = returndate;
		this.dueDate = dueDate;
		this.copyId = copyId;
		this.status = status;
		this.transactionId= transactionID;
	}
	
	public TransactionDTO() {
		super();
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public LocalDateTime getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(LocalDateTime issuedDate) {
		this.issuedDate = issuedDate;
	}
	public LocalDateTime getReturndate() {
		return returndate;
	}
	public void setReturndate(LocalDateTime returndate) {
		this.returndate = returndate;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	public long getCopyId() {
		return copyId;
	}
	public void setCopyId(long copyId) {
		this.copyId = copyId;
	}
	
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	
	
	
    
			
	
    
	
    

}
