import static org.junit.Assert.*;

import org.junit.Test;

public class TestForLeftMostOccurance {

	@Test
	public void testBinarySearch1() {

		BinarySearch bSearch = new BinarySearch();
		bSearch.array.add(-1);
		bSearch.array.add(-2);
		bSearch.array.add(-2);
		bSearch.array.add(-2);
		bSearch.array.add(2);
		bSearch.array.add(3);
		bSearch.array.add(2);
		bSearch.array.add(4);
		bSearch.array.add(2);
		BinarySearch.setResult(-1);
		int valueExpected = 1;
		int valueActual = bSearch.binarySearch(0, bSearch.array.size() - 1, -2);
		assertEquals(valueActual, valueExpected);
	}
	@Test
	public void testBinarySearch2() {

		BinarySearch bSearch = new BinarySearch();
		bSearch.array.add(1);
		bSearch.array.add(2);
		bSearch.array.add(-2);
		bSearch.array.add(-2);
		bSearch.array.add(56);
		bSearch.array.add(8);
		bSearch.array.add(8);
		bSearch.array.add(68);
		bSearch.array.add(56);
		BinarySearch.setResult(-1);
		int valueExpected =-1;
		int valueActual = bSearch.binarySearch(0, bSearch.array.size() - 1, 12);
		assertEquals(valueActual, valueExpected);
	}
	
	@Test
	public void testBinarySearch3() {

		BinarySearch bSearch = new BinarySearch();
		bSearch.array.add(1);
		bSearch.array.add(-2);
		bSearch.array.add(2);
		bSearch.array.add(8);
		bSearch.array.add(6);
		bSearch.array.add(6);
		bSearch.array.add(6);
		bSearch.array.add(6);
		bSearch.array.add(9);
		BinarySearch.setResult(-1);
		int valueExpected = 4;
		int valueActual = bSearch.binarySearch(0, bSearch.array.size() - 1, 6);
		assertEquals(valueActual, valueExpected);
	}

}
