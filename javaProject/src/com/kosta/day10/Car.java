package com.kosta.day10;
							// 나와 Car를 비교
public class Car implements Comparable<Car>{	// <> : 제네릭스
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
//	@Override
//	public boolean equals(Object obj) {
//		if(obj == null || !(obj instanceof Car)) return false;
//		Car otherCar = (Car)obj;
//		return model.equals(otherCar.model) && price == otherCar.price;
//	}
//	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + price;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Car가 소멸됩니다.");
		super.finalize();
	}
	@Override
	public int compareTo(Car obj) {		// <Car> 해서 형변환 안해도됨
		// 앞에거기준, 음수:작다, 양수:크다, 0:같다
		// 1. 모델로 비교
		// 2. 모델이 같으면 price로 비교
		int a = model.compareTo(obj.model); // String은 compareTo로 비교
		if(a == 0) {
			return price - obj.price;
		}
		return a;		
		
	}
	
	
	
	
	
}
