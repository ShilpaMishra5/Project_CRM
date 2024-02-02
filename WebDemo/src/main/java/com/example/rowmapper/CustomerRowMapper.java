package com.example.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.entity.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

		Customer c = new Customer();
		c.setId((Integer) rs.getInt("ID"));
		c.setName((String) rs.getString("NAME"));
		c.setEmail((String) rs.getString("EMAIL"));
		c.setAge((Integer) rs.getInt("AGE"));
		return c;

	}

}
