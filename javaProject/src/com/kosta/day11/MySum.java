package com.kosta.day11;

public class MySum {
	int first;
    int second;
    
    MySum (int first, int second){
        this.first = first;
        this.second = second;
    }

    /* 조건1 */
	@Override
	public String toString() {
//		return first + second + "";
		return String.valueOf(first + second);
	}

	/* 조건2 */
	@Override
	public boolean equals(Object obj) {
//		if((obj instanceof MySum) &&
//				this.toString().equals(obj.toString())) return true;
//		return false;

		if(obj == null || !(obj instanceof MySum)) return false;
		MySum my = (MySum)obj;
//		return first+second == my.first+my.second;
		return this.toString().equals(my.toString());
	}

    



}
