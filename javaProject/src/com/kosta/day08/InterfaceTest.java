package com.kosta.day08;

interface SuperInterface{
	void method5();
}

interface A extends SuperInterface{	//인터페이스를 상속받음
	void method1();
	void method2();
}

interface B{
	void method3();
	void method4();
}

class ImplementClass implements A, B{

	@Override
	public void method3() {
		System.out.println("구현class method3");
	}

	@Override
	public void method4() {
		System.out.println("구현class method4");

	}

	@Override
	public void method1() {
		System.out.println("구현class method1");

	}

	@Override
	public void method2() {
		System.out.println("구현class method2");

	}
	public void method5() {
		System.out.println("구현class method5");

	}
	
}

class ImplementClass2 implements A, B{

	@Override
	public void method3() {
		System.out.println("구현class2 method3");
	}

	@Override
	public void method4() {
		System.out.println("구현class2 method4");

	}

	@Override
	public void method1() {
		System.out.println("구현class2 method1");

	}

	@Override
	public void method2() {
		System.out.println("구현class2 method2");

	}
	public void method5() {
		System.out.println("구현class2 method5");

	}
	
}

public class InterfaceTest {

	public static void main(String[] args) {
		infoPrint(new ImplementClass());
		infoPrint(new ImplementClass2());
		infoPrint(makeAnonymous());
		infoPrintB(makeAnonymousB());

	}
	
	private static B makeAnonymousB() {
		return new B() {

			@Override
			public void method3() {
				System.out.println("익명class method3");
			}

			@Override
			public void method4() {
				System.out.println("익명class method4");
			}
			
		};
		
	}

	private static A makeAnonymous() {
		return new A() {

			@Override
			public void method1() {
				System.out.println("익명class method1");
			}

			@Override
			public void method2() {
				System.out.println("익명class method1");
			}
			
			public void method5() {
				System.out.println("익명class method5");

			}
			
		};
		
	}
	
	private static void infoPrintB(B b) {
		b.method3();
		b.method4();
		
		if(b instanceof A) {
			A a = (A)b;
			a.method1();
			a.method2();
			a.method5();
		}
		System.out.println("********************");
		
	}

	private static void infoPrint(A a) {
		a.method1();
		a.method2();
		a.method5();
		
		if(a instanceof B) {
			B b = (B)a;
			b.method3();
			b.method4();
		}
		System.out.println("********************");
		
	}

}
