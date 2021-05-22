package com.kosta.day05;

/*<<class>>
 * public:모든패키지에서 접근가능 
 * 생략(default) : 현재패키지에서만 접근가능
 * <<변수, 메서드, 생성자>>
 * public:모든패키지에서 접근가능 
 * protected : 현재패키지에서접근가능 
 *           : 다른패키지에서는 상속받으면 접근가능 
 * 생략(default) : 현재패키지에서만 접근가능 
 * private : 현재class에서만 접근가능
 */
public class Person {
	//final : 1번만 할당가능,수정불가  
	public final String nation="한국";//1)선언시 초기화한다.
	public final String ssn;
	//상수 
	public static final String COUNTRY = "대한민국"; 
	protected String name;
	private int age;
	int score=100;
	
	public Person(){
		this.ssn = "";
	}
	Person(String ssn,String name,int age){
		this.ssn = ssn;//2)생성시 초기화한다. 
		this.name = name;
		this.age = age;
	}
	void test() {
		name = "이름수정";
		age = 20;
		//------------final은 수정불가
		//nation="한국";
		//ssn = "12345";
		//COUNTRY = "대한민국";
	}
	void test2() {
		//Integer.MAX_VALUE = 100;
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.class);
		
		//bitCount() ->2진수로 바꾸어서 1의갯수 몇개?
		System.out.println(Integer.bitCount(10));
		
	}
	
	public static void main(String[] args) {
	 
		new Person().test2();
		System.out.println(
			new String("자바프로그램").substring(0, 2).charAt(0) );
	}
	
}