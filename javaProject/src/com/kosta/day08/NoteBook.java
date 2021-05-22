package com.kosta.day08;

public class NoteBook implements Volume{
	int volLevel;
	
	void test() {
		System.out.println("----상수값 접근----");
		System.out.println(TITLE);
		volumeUp(100);
		volumeDown(10);
		Volume.volumeInfo();
		System.out.println("-----------------");
	}

	@Override
	public void volumeUp(int level) {
		volLevel += level;
		System.out.println(getClass().getSimpleName() + ":" + volLevel);
	}

	@Override
	public void volumeDown(int level) {
		volLevel -= level;
		System.out.println(getClass().getSimpleName() + ":" + volLevel);
	}
	
	@Override
	public void close() {
		// default method는 구현 class에서 재정의가 가능하다.
		System.out.println(getClass().getSimpleName() + "에서 close() 함수 재정의");
	}
	
	

}
