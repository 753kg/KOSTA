package com.kosta.day13;

import java.util.function.IntSupplier;

public class LAB4 {
	
	public static int method(int x, int y) {	
		
		IntSupplier supplier = () -> {
			// x *= 10;				// 로컬클래스에서 사용되는 로컬변수는 수정할수없다. final
			int result = x + y;		// 사용은 가능
			return result;
		};
		int result = supplier.getAsInt();
		return result;
	}

	public static void main(String[] args) {
		int result = method(3, 5);
		System.out.println(result);
	}
	
}

