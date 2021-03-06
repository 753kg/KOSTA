package com.kosta.sample1;

// Factory pattern : new는 여기서 처리
// new 방법이 달라졌을 경우 개발자가 여기만 수정
public class TVFactory {
	
	public static TV makeTV(String brand) {
		TV tv = null;
		if(brand.equals("SAMSUNG"))
			tv = new SamsungTV(brand);
		else if(brand.equals("LG"))
			tv = new LgTV(brand, "엘지");
		
		return tv;
	}
}
