package com.kosta.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kosta.business.DeptDAO;

public class DAOTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("sample3.xml");
		DeptDAO dao = context.getBean("deptdao2", DeptDAO.class);
		for(ManagerVO vo:dao.findAllManager()) {
			System.out.println(vo);
		}
	}

}
