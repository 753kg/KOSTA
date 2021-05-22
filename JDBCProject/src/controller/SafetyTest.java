package controller;

import java.util.List;

import model.SafetyDAO;

public class SafetyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SafetyDAO dao = new SafetyDAO();
		System.out.println(dao.countSafetyByLoc("연신내"));
		//List<String> names = dao.countSafetyByLoc("은평구");
		/*
		for(int i=0; i<10; i++) {
			System.out.println(names.get(i));
		}
		*/
	}

}
