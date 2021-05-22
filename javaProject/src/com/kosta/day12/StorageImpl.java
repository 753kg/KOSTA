package com.kosta.day12;

public class StorageImpl<T, A> implements Storage<T>{
	T[] array;
	A price;
	
	@SuppressWarnings("unchecked")
	public StorageImpl(int capacity, A Price) {
		array = (T[]) new Object[capacity];
		this.price = price;
	}
	
	@Override
	public void add(T item, int index) {
		array[index] = item;
	}

	@Override
	public T get(int index) {
		return array[index];
	}

}
