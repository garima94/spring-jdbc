package com.ca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.ca.bo.CustomerBO;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;

	public CustomerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<CustomerBO> getCustomer(String firstName) {
		GetCustomerPreparedStatementCreator gcpsc = new GetCustomerPreparedStatementCreator(firstName);
		GetCustomerPreparedStatementCallback gcpscb = new GetCustomerPreparedStatementCallback();
		return jdbcTemplate.execute(gcpsc, gcpscb);
		
}

	public int addCustomer()
	{
		return jdbcTemplate.update("INSERT INTO 'sdb'.'customer' (customer_no,first_nm,last_nm,contact_no,email_address) values ('5',garima','singh','7097057156','garima@gmail.com')");
	}
	
	
	// inner class
	private final class GetCustomerPreparedStatementCreator implements PreparedStatementCreator {
		private String firstName = null;
	
		// constructor to get the first nm
		public GetCustomerPreparedStatementCreator(String firstName) {
			this.firstName = firstName;
		}
		
		 
	  
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement pstmt = con.prepareStatement("select customer_no,first_nm,last_nm,contact_no,email_address from customer where first_nm like ?");
			pstmt.setString(1, "%"+firstName+"%");
			return pstmt;
		}
	}

	private final class GetCustomerPreparedStatementCallback implements PreparedStatementCallback<List<CustomerBO>> {

		@Override
		public List<CustomerBO> doInPreparedStatement(PreparedStatement pstmt)
				throws SQLException, DataAccessException {
			{
				List<CustomerBO> customer = new ArrayList();
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					CustomerBO customerBO = new CustomerBO();
					customerBO.setCutomerNo(rs.getInt(1));
					customerBO.setFirstNm(rs.getString(2));
					customerBO.setLastNm(rs.getString(3));
					customerBO.setContactNo(rs.getString(4));
					customerBO.setEmailAddress(rs.getString(5));
					customer.add(customerBO);

				}
				return customer;

			}

		}
	}
}
