package com.kosta.day08.lab4;

public class DaoExample {

	public static void main(String[] args) {
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
		
		// 익명 클래스
		dbWork(new DataAccessObject() {
			
			@Override
			public void update() {
				System.out.println("DB2...update");
			}
			
			@Override
			public void select() {
				System.out.println("DB2...select");

			}
			
			@Override
			public void insert() {
				System.out.println("DB2...insert");

			}
			
			@Override
			public void delete() {
				System.out.println("DB2...delete");

			}
		});
	}

	private static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		System.out.println("--------------------");
	}

}
