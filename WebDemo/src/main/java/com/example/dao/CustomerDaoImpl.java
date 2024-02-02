package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.entity.Customer;
import com.example.rowmapper.CustomerRowMapper;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Customer> findAll() {
		String query = "select * from customers";
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(query);
//		List<Customer> customers = new ArrayList<Customer>();
//		for (Map m : queryForList) {
//			Customer c = new Customer();
//			c.setId((Integer) m.get("ID"));
//			c.setName((String) m.get("NAME"));
//			c.setEmail((String) m.get("EMAIL"));
//			c.setAge((Integer) m.get("AGE"));
//
//			customers.add(c);
//
//		}
		List<Customer> customer = jdbcTemplate.query(query, new CustomerRowMapper());
		return customer;
	}

	@Override
	public Customer findById(int id) {
		String query = "Select * from customers where ID = " + id;
		List<Customer> customer = jdbcTemplate.query(query, new CustomerRowMapper());
		if (!customer.isEmpty())
			return customer.get(0);

		return null;

	}

	@Override
	public Customer SaveCutsomer(Customer customer) {
		String query = "";
		Customer findById = findById(customer.getId());
		if (findById == null) {
			query = "INSERT into customers(ID,NAME,EMAIL,AGE)values(?,?,?,?)";
			Object[] args = { customer.getId(), customer.getName(), customer.getEmail(), customer.getAge() };
			int update = jdbcTemplate.update(query, args);
			if (update == 1) {
				Customer findById2 = findById(customer.getId());

				if (findById2 == null)
					return findById2;
			}

		} else {
			query = " UPDATE customers set NAME = '" + customer.getName() + "' ,EMAIL = '" + customer.getEmail()
					+ "',AGE =" + customer.getAge() + ",ID = " + customer.getId() + " where ID = " + customer.getId();
			int update = jdbcTemplate.update(query);
			if (update == 1) {
				Customer findById2 = findById(customer.getId());

				if (findById2 == null)
					return findById2;
			}
		}
		return null;
	}

	@Override
	public Customer deleteById(int id) {

		return null;

	}

	public void deleteFun(int id) {

		String deleteQuery = "delete from customers where id = ?";
		jdbcTemplate.update(deleteQuery, id);

	}
}
