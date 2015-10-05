package SecondProgram;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class TestRadixSort {

	@Test
	public void testRadixSort1() {
		RadixSort radixSort=new RadixSort();
		ArrayList<Integer> array=new ArrayList<Integer>();
		array.add(21);
		array.add(999);
		array.add(29);
		array.add(65);
		array.add(23);
		array.add(28);
		array.add(90);
		array.add(389);
		ArrayList<Integer> arrayExpected=radixSort.radixSort(array, 3);
		Collections.sort(array);
		assertEquals(arrayExpected, array);
	}

	@Test
	public void testRadixSort2() {
		RadixSort radixSort=new RadixSort();
		ArrayList<Integer> array=new ArrayList<Integer>();
		array.add(21);
		array.add(999);
		array.add(9);
		array.add(675);
		array.add(230);
		array.add(289);
		array.add(909);
		array.add(389);
		ArrayList<Integer> arrayExpected=radixSort.radixSort(array, 3);
		Collections.sort(array);
		assertEquals(arrayExpected, array);
	}

	
	@Test
	public void testRadixSort3() {
		RadixSort radixSort=new RadixSort();
		ArrayList<Integer> array=new ArrayList<Integer>();
		array.add(2);
		array.add(99);
		array.add(2);
		array.add(659);
		array.add(23);
		array.add(2856);
		array.add(9090);
		array.add(3891);
		ArrayList<Integer> arrayExpected=radixSort.radixSort(array, 4);
		Collections.sort(array);
		assertEquals(arrayExpected, array);
	}

	
	@Test
	public void testRadixSort4() {
		RadixSort radixSort=new RadixSort();
		ArrayList<Integer> array=new ArrayList<Integer>();
		array.add(21);
		array.add(99);
		array.add(29);
		array.add(65);
		array.add(283);
		array.add(200);
		array.add(90898);
		array.add(389);
		ArrayList<Integer> arrayExpected=radixSort.radixSort(array, 5);
		Collections.sort(array);
		assertEquals(arrayExpected, array);
	}

}
