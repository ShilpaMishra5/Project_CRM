package com.example.dao1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Repository;

import com.example.entity.Customer;
import com.example.service.CustomerService;

@Repository
public class CustomerDao1Impl implements CustomerDao1 {

	Map<Integer, Customer> map;

	public CustomerDao1Impl() {

		map = new HashMap<Integer, Customer>();
		map.put(1, new Customer(1, "c1", "c1@gmail.com", 22));
		map.put(2, new Customer(2, "c2", "c2@gmail.com", 23));
		map.put(3, new Customer(3, "c3", "c3@gmail.com", 24));

	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<Customer>();
//		for (int id : map.keySet()) {
//			customers.add(map.get(id));
//		}

		for (Entry<Integer, Customer> e : map.entrySet()) {
			customers.add(e.getValue());

		}
		return customers;
	}

	@Override
	public Customer findById(int id) {
		if (map.containsKey(id)) {
			return map.get(id);
		}
		return null;
	}

	@Override
	public Customer SaveCutsomer(Customer customer) {

		map.put(customer.getId(), customer);

		return map.get(customer.getId());
	}

	@Override
	public Customer deleteById(int id) {
		Customer remove = map.remove(id);
		return remove;
	}

}
