package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.Param;

import com.example.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	List<Customer> findByEmail(String email);
	
	@Query("select cust from Customer cust where cust.name like %:name%")
	List<Customer> findByCustomerByName(@Param("name") String name);

}
