package com.qa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qa.dao.CustomerDao;

public class QATest {
public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("com/qa/common/application-context.xml");
	CustomerDao cDao=context.getBean("customerDao",CustomerDao.class);
	System.out.println("No of customers: " + cDao.getCountOfCustomer());
}
}
