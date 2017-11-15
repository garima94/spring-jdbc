package com.ca.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;

import com.ca.bo.CustomerBO;

public class CustomerDaoSt {
	private JdbcTemplate jdbcTemplate;

	public CustomerDaoSt(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<CustomerBO> getCustomer(){
		GetCustomerCallback gccb=new GetCustomerCallback();
		return jdbcTemplate.execute(gccb);
		
	}
	private final class GetCustomerCallback implements StatementCallback<List<CustomerBO>>
	{

		@Override
		public List<CustomerBO> doInStatement(Statement stmt) throws SQLException, DataAccessException {
			ResultSet rs=stmt.executeQuery("select * from customer");
			
			CustomerBO bo=null;
			List<CustomerBO> cutomers= new ArrayList<>();
			while(rs.next())
			{
				bo=new CustomerBO();
				bo.setCutomerNo(rs.getInt(1));
				bo.setFirstNm(rs.getString(2));
				bo.setLastNm(rs.getString(3));
				bo.setContactNo(rs.getString(4));
				bo.setEmailAddress(rs.getString(5));
				
				cutomers.add(bo);
			}
			return cutomers;
		}
		
	}
}
