package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.entity.Customer;

public interface CustomerService {

	public Page<Customer> findAll();

	public Page<Customer> findByPageNumber(int pageNumber);

	public Customer findById(int id);

	public Customer SaveCutsomer(Customer customer);

	public Customer deleteById(int id);

	public void deleteFun(int id);

	public List<Customer> searchByEmail(String email);

	public List<Customer> searchByName(String name);

}
