package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name = "app_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private long userId;
	private String userName;
	private String password;
	private String role;
	private String emailId;
	@CreationTimestamp(source = SourceType.DB)
	@Column(updatable = false)
	private Date createdDate;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true )
    @JsonManagedReference
    
	private List<Transaction> transactions = new ArrayList<>();
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCretaedDate(Date cretaedDate) {
		this.createdDate = cretaedDate;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public User(long userId, String userName, String password, String role, String emailId, Date cretaedDate,
			List<Transaction> transactions) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.emailId = emailId;
		this.createdDate = cretaedDate;
		this.transactions = transactions;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", emailId=" + emailId + ", cretaedDate=" + createdDate + ", transactions=" + transactions + "]";
	}
	public User() {
		super();
	}
	
	
	
	

}
