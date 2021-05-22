package com.kosta.day08;

public class ClassRoomTest {

	public static void main(String[] args) {
		
//		useInstanceInnerClass();
//		useStaticInnerClass();
		useLocalInnerClass();

	}

	private static void useLocalInnerClass() {
		ClassRoom c = new ClassRoom();
		c.test("가산", "코스타");	
		// test 함수 안에서 local inner class 접근해져있음.
		// 함수를 부르기만 하면 된다.
		
	}

	private static void useStaticInnerClass() {
		// static 변수 접근은 객체 생성 없이 가능
		System.out.println(ClassRoom.Chair.title6);
		
		ClassRoom.Chair chair = new ClassRoom.Chair();
		System.out.println(chair.title5);
		
	}

	private static void useInstanceInnerClass() {
		// 1. instance inner class 연습		
		// ClassRoom$Desk.class
		
		// 타입			변수		바깥쪽new			안쪽new
		ClassRoom.Desk desk = new ClassRoom().new Desk();
//		ClassRoom c = new ClassRoom();
//		ClassRoom.Desk desk = c.new Desk();
		System.out.println(desk.title3);
		
		
		
	}

}
