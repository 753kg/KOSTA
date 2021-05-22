package com.kosta.day12;

// Object <---- Number <---- Integer, Double ...
public class Util{
	
	public static <T extends Machine> int compare2(T a, T b) {
		int result = a.compareTo(b);	// Machine의 compareTo
		return result;
	}
	
				// 타입에 제한을 건다.
				// Number를 상속받은 타입만 올 수 있다.
	public static <T extends Number> int compare(T a, T b) {
		
		double su1 = a.doubleValue();
		double su2 = b.doubleValue();
		int result = Double.compare(su1, su2);	// 같으면 0, 앞에값이 작으면 -1, 크면 1
//		int result = (int)(su1 - su2);
		return result;
	}
	
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		boolean result = p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
		return result;
		
	}
	
	public static <T> Box<T> boxing(T t) {
		Box<T> b = new Box<>();
		b.setObj(t);
		return b;
	}
}
