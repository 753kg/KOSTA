package com.kosta.day17;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		HashSet hs = new HashSet();
		System.out.println("*특정 금액 이상의 상품 결과입니다.******************");
		for(Product p:prodList) {
			if(p.getPrice() >= price) {
				System.out.println(p);
				hs.add(p);
			}
		}
		
		return hs;
	}


	private static void makeFile(HashSet resultList)  {
		//구현하시오.
		String fname = "resultList.ddd";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;	// 객체를 출력
		try {
			fos = new FileOutputStream(fname);
			oos = new ObjectOutputStream(fos);
//			oos.writeObject(resultList);	// HashSet이 Serializable 이다.
			
			for(Object obj:resultList) {	// 제네릭을 안썼기 때문에 Object타입이다.
				oos.writeObject(obj);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	private static void readFile()  {
		//구현하시오. 
		String fname = "resultList.ddd";
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		System.out.println("*readFile 결과입니다.******************");

		try {
			fis = new FileInputStream(fname);
			ois = new ObjectInputStream(fis);
			
			while(true) {
				Object obj = ois.readObject();
				if(obj == null) break;
				System.out.println(obj);
			}
			
		} catch (EOFException e) {
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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