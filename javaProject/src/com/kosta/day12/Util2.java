package com.kosta.day12;

public class Util2 {
	
	public static <K, V> V getValue(Pair<K, V> p, K key) {
		if(p.getKey().equals(key)) {
			return p.getValue();
		} else {
			return null;
		}
		
	}
}
