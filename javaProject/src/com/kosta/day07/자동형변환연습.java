package com.kosta.day07;

class A{}
class B extends A{}
class C extends A{}
class D extends B{}
class E extends C{}

public class 자동형변환연습 {

	public static void main(String[] args) {
//		method1();
		method2();
//		method3();
//		method4();
//		method5();
//		method6();
//		method7();
//		method8();

	}

	private static void method8() {
		// 타입에 따라 변수가 보인다.
		// Tire의 멤버변수에만 접근 가능
		Tire t = new KumhoTire();
		System.out.println(t.a);
		// KumhoTire의 변수에 접근하려면 다시 형변환
		System.out.println( ((KumhoTire)t).kumho );
		
		printTire(new KumhoTire());
		printTire(new HanKookTire());
		
	}

	private static void printTire(Tire tire) {
		System.out.println(tire.a);
		if(tire instanceof KumhoTire)
			System.out.println( ((KumhoTire)tire).kumho );
		if(tire instanceof HanKookTire)
			System.out.println( ((HanKookTire)tire).hankook );
		
	}

	private static void method7() {
//		Tire t = new HanKookTire();
		Tire t = new KumhoTire();		//강제형변환불가능
		if(t instanceof HanKookTire) {	// t가 hankooktire이면			
			HanKookTire h = (HanKookTire)t;
			System.out.println(h);
		}
		
	}

	private static void method6() {
		// 강제형변환은 본래의 객체로 돌아가는 것만 가능하다.
		// 본래의 객체로 casting만 가능하다.
		Account acc = new CheckingAccount();
		//Account acc = new CreditLineAccount(null, null, 0, 0);	//강제형변환불가능
		CheckingAccount acc2 = (CheckingAccount)acc;
		
	}

	private static void method5() {
		Account acc = new Account();
		//잘못됐지만 컴파일시 오류없음, 실행시 오류
		CheckingAccount acc2 = (CheckingAccount)acc;	
		
	}

	private static void method4() {
		Account acc = new CheckingAccount();			// 자동형변환
		CheckingAccount acc2 = (CheckingAccount)acc;	//강제형변환
		System.out.println(acc2);
		
	}

	private static void method3() {
		/* 불가능
		B b2 = (B) new E();
		D d = (D) new E();
		*/
		
	}

	private static void method2() {
		// 객체의 자동형변환 	==> 	부모타입 = 자식객체
		// 객체의 강제형변환 	==> 	자식타입 = (자식타입)부모객체
		// 기본형의 강제형변환	==>		작은방 = (작은방타입)큰값
		int a = 10;
		double d = 3.14;
		a = (int)d;			// a = 3
		
		Account acc = new CheckingAccount();	// 자동형변환
		CheckingAccount acc2 = (CheckingAccount) new Account();	// 강제형변환
		
	}

	private static void method1() {
		A a = new B();
		A a2 = new C();
		
		A a3 = new D();
		B b = new D();
		
		C c = new E();
		A a4 = new E();
		Object obj = new E();	// A의 부모class
		
		/* 불가능
		B b2 = new E();
		D d = new E();
		*/
	}

}
