package com.kosta.day08;

// extends : class를 상속받는다.
// implements : interface를 구현한다.
// 구현 안하면 abstract class가 되어야함.
public class Speaker implements Volume {
	int VolLevel;

	@Override
	public void volumeUp(int level) {
		VolLevel += level;
		if(VolLevel > 100) VolLevel = 100;
		System.out.println(getClass().getSimpleName() + "볼륨 올립니다. " + VolLevel);
	}

	@Override
	public void volumeDown(int level) {
		VolLevel -= level;
		if(VolLevel < 0) VolLevel = 0;
		System.out.println(getClass().getSimpleName() + "볼륨 내립니다. " + VolLevel);

	}

}
