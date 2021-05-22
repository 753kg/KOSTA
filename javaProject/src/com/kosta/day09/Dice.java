package com.kosta.day09;

public class Dice {
	int size;
	Dice(int size){
		this.size = size;
	}
    int play(){
 	int number = (int)(Math.random() * size) + 1;
        return number;
    }
	@Override
	public boolean equals(Object obj) {
		// d2는 Dice -> Object -> Dice
		Dice d = (Dice)obj;
		
		return size == d.size;		// true or false가 return됨
		// size는 int니까 값비교
		//return super.equals(obj);	// 주소비교
	}
    
    

}
