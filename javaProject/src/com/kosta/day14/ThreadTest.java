package com.kosta.day14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ThreadTest {

	public static void main(String[] args) {
		
		// Vector : 멀티 Thread 환경에서 안전하다.
		//			동기화 지원... 공유 자원을 여러쓰레드가 접근할 때 lock을 걸어준다.
		// ArrayList는 동기화 지원 안됨
		List<String> alist = new ArrayList<>();
//		List<String> alist = Collections.synchronizedList(new ArrayList<>());
		
		MyThreadA t1 = new MyThreadA("A-Thread", alist);
		MyThreadB t2 = new MyThreadB("B-Thread", alist);
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.stop = true;
	}

}
