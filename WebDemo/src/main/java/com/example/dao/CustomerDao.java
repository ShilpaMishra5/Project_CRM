package com.example.dao;

import java.util.List;

import com.example.entity.Customer;

public interface CustomerDao {

	public List<Customer> findAll();

	public Customer findById(int id);

	public Customer SaveCutsomer(Customer customer);

	public Customer deleteById(int id);

	public void deleteFun(int id);

}
