package com.kosta.day07.interfaceTest;

public class TVUser {

	public static void main(String[] args) {
//		TV tv = new TV();	// interface는 instance화 할 수 없다.
		TV tv = new KostaTV();
		tv.powerOn();
		tv.powerOff();
		((KostaTV)tv).display();
		System.out.println("----------------------");
		TV tv2 = new GasanTV();
		tv2.powerOn();
		tv2.powerOff();
		((GasanTV)tv2).print();

	}

}
