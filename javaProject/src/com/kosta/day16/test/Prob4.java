package com.kosta.day16.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

public class Prob4 {

	public static void main(String[] args) {
		Product[] prodList = {
				new Product("NT450R5E-K24S",500000,"삼성전자"),
				new Product("15UD340-LX2CK",400000,"LG전자"),
				new Product("G2-K3T32AV",600000,"HP") };
		HashSet product_hs = makeHashSet(prodList, 500000);
		makeFile(product_hs);
		readFile();
		
	}

	
	private static HashSet makeHashSet(Product[] prodList, int price) {
		//구현하시오...return값 수정하기 
		HashSet hash = new HashSet();
		for(Product p : prodList) {
			if(p.getPrice() >= price) hash.add(p);
		}
		return hash;
	}


	private static void makeFile(HashSet resultList)  {
		//구현하시오.
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		System.out.println("*특정 금액 이상의 상품 결과입니다.******************");
		try {
			fos = new FileOutputStream("data.txt");
			oos = new ObjectOutputStream(fos);
			
			for(Object obj : resultList) {
				oos.writeObject(obj);
				System.out.println(obj);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if(oos != null) oos.close();
					if(fos != null) fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
	}
	private static void readFile()  {
		//구현하시오.
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		System.out.println("*readFile 결과입니다.******************");
		try {
			fis = new FileInputStream("data.txt");
			ois = new ObjectInputStream(fis);
			
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if(ois != null) ois.close();
					if(fis != null) fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}

}


class Product implements Serializable{
	private String model_name;
	private int price;
	private String company;
	
	
	public Product(String model_name, int price, String company) {
		super();
		this.model_name = model_name;
		this.price = price;
		this.company = company;
	}


	public String getModel_name() {
		return model_name;
	}


	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "Product [model_name=" + model_name + ", price=" + price
				+ ", company=" + company + "]";
	}
	
	

}