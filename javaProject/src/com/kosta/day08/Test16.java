package com.kosta.day08;

class Outer{
	private Inner y;
	public void setY(Inner y) {	this.y = y;	}
	public Inner getY() { return y; }
	
	class Inner{
		private int x;
		public void setX(int x) { this.x = x; }
		public int getX() {	return x; }
	}
}

public class Test16 {
	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner i = o.new Inner();
//		Outer.Inner i2 = new Outer().new Inner();	// 가능
		int n = 10;
		i.setX(n);
		o.setY(i);
		
		// 결과가 100이 되게
		i.setX(100);			// 가능
		System.out.println(o.getY().getX());	
		
		o.getY().setX(100);		// 가능
		System.out.println(o.getY().getX());	
		
	}

}
