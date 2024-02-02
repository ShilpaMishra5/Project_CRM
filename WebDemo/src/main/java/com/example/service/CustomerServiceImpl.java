package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dao.CustomerDao;
import com.example.entity.Customer;
import com.example.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	CustomerDao customerDao;

	@Override
	public Page<Customer> findAll() {
		// List<Customer> customers = customerDao.findAll();
		Pageable request = PageRequest.of(0, 3);
		Page<Customer> page = customerRepo.findAll(request);
		return page;
	}

	@Override
	public Customer findById(int id) {
		// Customer customer = customerDao.findById(id);
		Optional<Customer> optional = customerRepo.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public Customer SaveCutsomer(Customer customer) {
		// Customer customer2 = customerDao.SaveCutsomer(customer);
		Customer customer2 = customerRepo.save(customer);
		return customer2;
	}

	@Override
	public Customer deleteById(int id) {
		return null;
	}

	@Override
	public void deleteFun(int id) {
		// customerDao.deleteFun(id);
		customerRepo.deleteById(id);
	}

	@Override
	public List<Customer> searchByEmail(String email) {

		List<Customer> customer = customerRepo.findByEmail(email);
		return customer;
	}

	@Override
	public List<Customer> searchByName(String name) {
		List<Customer> customer = customerRepo.findByCustomerByName(name);
		return customer;
	}

	@Override
	public Page<Customer> findByPageNumber(int pageNumber) {
		Pageable request = PageRequest.of(pageNumber-1, 3);
		Page<Customer> page = customerRepo.findAll(request);
		return page;
	}

}
