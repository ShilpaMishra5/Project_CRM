package com.example.dao1;

import java.util.List;

import com.example.entity.Customer;

public interface CustomerDao1 {
	
	public List<Customer> findAll();

	public Customer findById(int id);

	public Customer SaveCutsomer(Customer customer);

	public Customer deleteById(int id);

}
