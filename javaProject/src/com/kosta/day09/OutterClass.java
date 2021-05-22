package com.kosta.day09;

								// 상속은 단일상속
public class OutterClass extends Object implements Comparable<OutterClass>{
	// 1. 필드 : non-static, static
	// 		static : class가 메모리에 올라갈 때 같이
	// 		non-static : new 할때 올라옴
	// 2. 생성자
	// 3. 메서드 : non-static, static
	// 4. static block, instance block
	// 5. inner class, inner interface
	class InstanceInnerClass{
		
	}
	
	static class StaticInnerClass2{
		
	}
	
	void test() {
		class LocalInnerClass3{
			// local class: static 안됨. 메서드 안에서만 존재할 수 있어서
			
		}
		LocalInnerClass3 a = new LocalInnerClass3();
		System.out.println(a);
	}

	@Override
	public int compareTo(OutterClass o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
