package com.kosta.day12;

public class ThreadTest {

	public static void main(String[] args) {
		method4();
	}

	private static void method4() {
		// 데몬쓰레드
		AutoSaveThread t = new AutoSaveThread("자동저장쓰레드");
		t.setDaemon(true);	// 데몬쓰레드로 설정하기... main 종료 시 같이 종료
		t.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main END");
	}

	private static void method3() {
		// interrupt로 종료
		Thread t1 = new PrintThread2();
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();		// InterruptedException 발생시켜 쓰레드 중단. 예외처리 부분에 쓴 코드가 수행된다.
	}

	private static void method2() {
		// stop 플래그
		
		PrintThread1 t1 = new PrintThread1();
		t1.start();
		
		try {
			Thread.sleep(2000);		//main thread를 2초 쉼
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.setStop(true);
		System.out.println("main END");
	}

	private static void method1() {
		MailBox box = new MailBox();
		
		String[] messages = {"하이~", "열공", "잘가!!"};
		
		Thread readerThread = new ReaderThread(box, messages.length);
		Runnable writer = new WriterThread(box, messages);
		Thread writerThread = new Thread(writer);
		
		readerThread.start();
		writerThread.start();
		
	}

}
