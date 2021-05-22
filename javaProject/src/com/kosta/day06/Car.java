package com.kosta.day06;

/**
 * 
 * @author KOSTA
 * 복습 (document 주석)
 */

public class Car {
	// 1. 멤버변수(field) : non-static(instance변수), static(class변수)
	private int speed;			// private : 정보은닉, 외부에서 접근 불가
	private boolean stop;
	private static int count;	// object 공유 변수
	private final int year;		// instance변수, final은 한번만 setting(선언시or생성자), 변경불가
	private static final String COMPANY = "현대자동차";	// 상수
	
	// 2. 생성자메서드... new시에 자동 호출되는 메서드
	// source > generate constructor
	public Car() {
		this(0, false, 2021);	
		// this: 생성자 overloading 사용 시 하나의 생성자가 다른 생성자 호출시 사용 
		// year = 2021;
		// instance변수 자동초기화. 생성할 때 초기화됨.
		// speed = 0; stop = false;
	}
	public Car(int speed, boolean stop, int year) {
		super();
		// this: 매개변수와 멤버변수 이름충돌시 구별하기 위해 사용
		this.speed = speed;
		this.stop = stop;
		this.year = year;
		count++;
		//현재 객체의 class 이름 얻기
		System.out.println(this.getClass().getSimpleName()+"생성");	
	}
	

	// 3. 일반메서드
	// Getter, Setter : 외부에서 값을 읽거나 수정시 사용
	// source > generate getters and setters
	// final은 setter 없음.
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	public static int getCount() {
		return count;
	}

	/* ctrl+shift+/
	 * private static void setCount(int count) { Car.count = count; }
	 */
	public int getYear() {
		return year;
	}
	// static method : 객체를 생성하지 않고도 호출이 가능하다.
	public static String getCompany() {	
		return COMPANY;
	}
	public void print() {
		System.out.println("-----Car정보-----");
		System.out.println("speed:\t" + speed);
		System.out.println("stop:\t" + stop);
		System.out.println("year:\t" + year);
		System.out.println("count:\t" + count);
		System.out.println("company:\t" + COMPANY);
	}
	
	
	// 4. instance block, static block
	// instance block
	{
		System.out.println("instance 생성시 마다 수행됨");
		System.out.println("*****************************");
	}
	// static block
	static {
		// 한번만 됨. load는 한번만 되기 때문에
		System.out.println("class가 메모리에 load될 때 한 번 수행됨.");	
		System.out.println("################################");
	}
	
	// 5. inner class : class 안에 class 만들때
}

//class : object를 만드는 틀이다. template, 설계도
/*
object: class를 이용해서 만든 독립된 개체이다.
*/

