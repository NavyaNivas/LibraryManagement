package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Payments;

public interface PaymentsRepo extends JpaRepository<Payments, Long> {

}
