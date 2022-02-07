package com.coderscampus.customarraylist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	private CustomList<Integer> sut;

	@BeforeEach
	void init () {
		sut = new CustomArrayList<>();

		for (int i=0; i<50; i++) {
			sut.add(i+1);
		}
	}

	@Test
	void add_into_middle_of_arraylist() {
		sut.add(9, 100);

		Integer actual = sut.get(9);
		Integer expected = 100;
		assertEquals(expected, actual);

	}

	@Test
	void add_into_middle_of_large_arraylist() {

		for (int i=0; i<100000; i++) {
			sut.add(i);
		}
		
		sut.add(90000, -25);

		assertEquals(-25, sut.get(90000));
		assertEquals(100051, sut.getSize());
	}

	@Test
	void add_into_beginning_of_arraylist() {
		
		sut.add(0, -15);

		
		assertEquals(-15, sut.get(0));
		assertEquals(51, sut.getSize());
	}

	@Test
	void add_into_end_of_arraylist() {
		sut.add(20, -25);

		assertEquals(-25, sut.get(20));
		assertEquals(51, sut.getSize());
	}

	@Test
	void remove_from_beginning_of_arraylist() {
		Integer itemRemoved = sut.remove(0);

		assertEquals(1, itemRemoved);
		assertEquals(49, sut.getSize());
		assertEquals(2, sut.get(0));
		assertEquals(50, sut.get(sut.getSize()-1));
	}

	@Test
	void remove_from_middle_of_arraylist() {
		Integer itemRemoved = sut.remove(11);

		assertEquals(12, itemRemoved);
		assertEquals(49, sut.getSize());
		assertEquals(1, sut.get(0));
		assertEquals(50, sut.get(sut.getSize()-1));
	}

	@Test
	void remove_from_middle_of_large_arraylist() {
		
		for (int i=0; i<100000; i++) {
			sut.add(i);
		}

		Integer itemRemoved = sut.remove(50000);

		assertEquals(49950, itemRemoved);
		assertEquals(100049, sut.getSize());
		assertEquals(1, sut.get(0));
		assertEquals(99999, sut.get(sut.getSize()-1));
	}

	@Test
	void remove_from_end_of_arraylist() {
		Integer itemRemoved = sut.remove(49);

		assertEquals(50, itemRemoved);
		assertEquals(49, sut.getSize());
		assertEquals(1, sut.get(0));
		assertEquals(49, sut.get(sut.getSize()-1));
	}

	@Test
	void exception_when_getting_out_of_bounds () {
		try {
			sut.get(59);
			fail("Expected an IndexOutOfBoundsException but did not get one.");
		} catch (IndexOutOfBoundsException e) {
			return;
		}
		fail("Expected an IndexOutOfBoundsException but did not get one.");

	}
	@Test
	void exception_when_removing_out_of_bounds () {
		try {
			sut.remove(69);
			fail("Expected an IndexOutOfBoundsException but did not get one.");
		} catch (IndexOutOfBoundsException e) {
			return;
		}
		fail("Expected an IndexOutOfBoundsException but did not get one.");

	}

	@Test
	void exception_when_adding_out_of_bounds () {
		try {
			sut.add(51, -10);
			fail("Expected an IndexOutOfBoundsException but did not get one.");
		} catch (IndexOutOfBoundsException e) {
			return;
		}
		fail("Expected an IndexOutOfBoundsException but did not get one.");

	}

}