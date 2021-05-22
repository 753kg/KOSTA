package com.kosta.day08;

public class MyClass {
	
	// 1. 필드
	RemoteControl rc;
	
	// 2. 생성자
	// 생성자의 접근지정자는 class의 접근지정자와 같게
	public MyClass(RemoteControl rc){
		this.rc = rc;
	}
	
	// 3. 메서드
	void methodA() {
		rc = new Audio();
	}
	void setRC(RemoteControl rc) {
		this.rc = rc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyClass [rc=").append(rc).append("]");
		return builder.toString();
	}
	
	

}
