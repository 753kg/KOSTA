package com.kosta.day07.lab;

public class Speaker implements Volume {
	int VolLevel;

	@Override
	public void volumeUp(int level) {
		VolLevel += level;
		if(VolLevel > 100)
			VolLevel = 100;
		System.out.println(getClass().getSimpleName() + "볼륨 올립니다. " + VolLevel);
	}

	@Override
	public void volumeDown(int level) {
		VolLevel -= level;
		if(VolLevel < 0)
			VolLevel = 0;
		System.out.println(getClass().getSimpleName() + "볼륨 내립니다. " + VolLevel);

	}

}
