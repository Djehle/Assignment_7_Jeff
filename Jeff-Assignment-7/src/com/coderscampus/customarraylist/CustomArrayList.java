package com.coderscampus.customarraylist;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	int size = 0;

	@Override
	public boolean add(T item) {
		if (size == items.length) {
			int increasedSize = size * 2;
			items = Arrays.copyOf(items, increasedSize);
		}
		items[size++] = item;
		return true;
	}

	@Override
	public int getSize() {

		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index was out of bounds");
		}

		return (T) items[index];
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if (index > size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
		}
		 if (size == items.length) {
	            items= Arrays.copyOf(items, size * 2);
	        }
		for (int i = size; i > index; i--) {
			items[i] = items[i - 1];
		}
		items[index] = item;
		size++;

		return true;
	}
	

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		if (index > size) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
		}
		@SuppressWarnings("unchecked")
		T removeItem = (T) items[index];
		for (int i = index; i < size - 1; i++) {
			items[i] = items[i + 1];
		}
		size--;
		return removeItem;
	}

}
