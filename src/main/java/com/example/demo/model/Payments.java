package com.example.demo.model;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class Payments {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long paymentId;
private long userId;
private long transactionId;
private long amount;
@CreationTimestamp(source = SourceType.DB)
@Column(updatable = false)
private LocalDateTime paidDate;
private String status;

public long getPaymentId() {
	return paymentId;
}
public void setPaymentId(long paymentId) {
	this.paymentId = paymentId;
}
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public long getTransactionId() {
	return transactionId;
}
public void setTransactionId(long transactionId) {
	this.transactionId = transactionId;
}
public long getAmount() {
	return amount;
}
public void setAmount(long amount) {
	this.amount = amount;
}
public LocalDateTime getPaidDate() {
	return paidDate;
}
public void setPaidDate(LocalDateTime paidDate) {
	this.paidDate = paidDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Payments [paymentId=" + paymentId + ", userId=" + userId + ", transactionId=" + transactionId + ", amount="
			+ amount + ", paidDate=" + paidDate + ", status=" + status + "]";
}
public Payments(long paymentId, long userId, long transactionId, long amount, LocalDateTime paidDate, String status) {
	super();
	this.paymentId = paymentId;
	this.userId = userId;
	this.transactionId = transactionId;
	this.amount = amount;
	this.paidDate = paidDate;
	this.status = status;
}
public Payments() {
	super();
}



}
