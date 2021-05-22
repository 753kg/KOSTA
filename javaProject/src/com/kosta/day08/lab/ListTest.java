package com.kosta.day08.lab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		
		// 배열: 하나의 이름으로 
		//		"같은 종류"의 여러 개의 값을 저장하기 위한 연속 공간을 만드는 자료구조
		// 		(장점) 속도가 빠름 | (단점) 갯수를 알아야 생성가능
		Shape[] arr = new Shape[5];
		arr[0] = new Rectangle(10, 20);
		arr[1] = new Rectangle(10, 20);
		
		// Collection(List, Set, Map interface) ==> 배열의 단점 보완
		// List : 순서O, 중복O, 초기값이 없으면 default 갯수만큼 생성(10개)
		// 		  공간이 없으면(default 개수 초과)자동으로 추가됨
		// 인터페이스여서 인스턴스화할수없음. => 인터페이스를 구현한 클래스를 사용해야함(ArrayList)
		// <Ractangle> : Rectangle만 들어오게하겠다. (같은 종류만 넣어라)
		List<Rectangle> alist = new LinkedList<>();	// java.util에 있음
		alist.add(new Rectangle(10, 20));
		alist.add(new Rectangle(10, 20));
		System.out.println(alist.size());	// 몇개있는지
		
		for(Rectangle r:alist) {
			System.out.println(r.getArea());
			System.out.println(r.getPerimeter());
		}
	}

}
