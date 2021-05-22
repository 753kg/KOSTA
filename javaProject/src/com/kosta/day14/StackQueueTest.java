package com.kosta.day14;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {

	public static void main(String[] args) {
		method2();
	}

	private static void method2() {
		// Queue : FIFO(First In First Out)
		// Queue : interface
		Queue<String> queue = new LinkedList<String>();
		queue.offer("월");
		queue.offer("화");
		queue.offer("수");
		queue.offer("목");
		
		System.out.println(queue.size());
//		System.out.println("맨처음넣은값:" + queue.peek());
//		System.out.println("맨처음넣은값:" + queue.peek());
		//System.out.println(queue.size());
		//System.out.println("맨처음넣은값:" + queue.poll());
		//System.out.println(queue.size());
		
		/* 방법1
		int count = queue.size();
		for(int i=0; i<count; i++) {
			System.out.println(queue.poll());
		}
		*/
		
		/* 방법2 */
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		System.out.println(queue.size()); 
	}

	private static void method1() {
		// Stack (LIFO : Last In First Out)
		Stack<String> st = new Stack<>();		// Stack은 add, push 다 가능하지만 push 쓴다.
		st.push("월");
		st.push("화");
		st.push("수");
		st.add("토");
		st.add("일");
		
		System.out.println(st.size() + "건");
		System.out.println("1.마지막값:" + st.get(st.size()-1));
		System.out.println("2.마지막값:" + st.peek());	// 마지막에 넣은 거 가져옴
		System.out.println(st.size() + "건");
		System.out.println("3.마지막값:" + st.pop());	// 마지막 값 가져오고 제거
		System.out.println(st.size() + "건");
		System.out.println("3.마지막값:" + st.pop());
		System.out.println(st.size() + "건");

	}

}
