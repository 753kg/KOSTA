package com.kosta.day12;

public class GenericInheritExample {

	public static void main(String[] args) {
		ChildProduct<TV, String, String> p = new ChildProduct(new TV(), "ABC100", 2000, "삼성");
		System.out.println(p.getCompany());
		System.out.println(p.toString());
		
		System.out.println("--------------------------------");
		
		StorageImpl<String, Integer> st = new StorageImpl<>(3, 1000);
		st.add("Hello1", 0);
		st.add("Hello2", 1);
		st.add("Hello3", 2);
		
		System.out.println(st.get(1));
		
	}

}
