package com.kosta.day12;

public class Pair<K, V> {
	private K key;
	private V value;
	
	public Pair() {
		
	}
	
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pair [key=").append(key).append(", value=").append(value).append("]");
		return builder.toString();
	}
	
	
}
