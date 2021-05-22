package com.kosta.day12;

public interface Storage<T>{
	
	public T get(int index);

	public abstract void add(T item, int index);
}
