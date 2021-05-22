package com.kosta.day09;
// 안드로이드 프로그램 짤 때 좋은 구조
								// Button 안에 있는 interface
class MessageListener implements Button.OnClickListener{
	@Override
	public void onClick() {
		System.out.println("MessageListener를 클릭한다.");
	}
}

class CallListener implements Button.OnClickListener{
	@Override
	public void onClick() {
		System.out.println("CallListener를 클릭한다.");
	}
}

public class Button {
	
	OnClickListener listener;
	
	void setListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	// 일반메서드
	void touch() {
		listener.onClick();
	}
	
	// inner interface
	// Button만 이 interface를 사용하려고
	interface OnClickListener{
		void onClick();
	}
}
