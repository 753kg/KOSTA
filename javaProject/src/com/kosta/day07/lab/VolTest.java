package com.kosta.day07.lab;

public class VolTest {

	public static void main(String[] args) {
		Volume[] volume = new Volume[3];
		volume[0] = new Speaker();
		volume[1] = new Radio();
		volume[2] = new TV();
		
		for(int i=0; i<volume.length; i++) {
			for(int j=1; j<=3; j++) {
				volume[i].volumeUp(200);				
			}
			for(int j=1; j<=3; j++) {
				volume[i].volumeDown(300);				
			}
		}

	}

}
