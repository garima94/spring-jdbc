package com.ca.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ca.bo.CustomerBO;
import com.ca.dao.CustomerDao;
import com.ca.dao.CustomerDaoSt;

public class CATest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ca/common/application-context.xml");
		/*CustomerDao cDao = context.getBean("customerDao", CustomerDao.class);
		List<CustomerBO> bos = cDao.getCustomer("v");
		for (CustomerBO c : bos) {
			System.out.println(c);
			
		}*/
	 
		/*CustomerDaoSt customerDaoSt=context.getBean("customerDaoSt",CustomerDaoSt.class);
		List<CustomerBO> bos=customerDaoSt.getCustomer();
		for (CustomerBO c : bos) {
			System.out.println(c);
			
		}*/
		
		//for inserting the row
		
		CustomerDao cDao = context.getBean("customerDao", CustomerDao.class);
		int  bos = cDao.addCustomer();
		
		System.out.println(bos);	
	}
}
