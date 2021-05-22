package com.kosta.day11;

public class Car implements Comparable<Car>{
	private String model;
	private int price;
	
	public Car() {
		
	}

	public Car(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [model=").append(model).append(", price=").append(price).append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Car obj) {
		// model 이름으로 ascending sort
		return model.compareTo(obj.model);
	}
	
	
}
