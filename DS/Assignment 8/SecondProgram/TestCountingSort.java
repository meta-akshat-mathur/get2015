package SecondProgram;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class TestCountingSort {
	@Test
	public void testCountingSort1() {
		CountingSort countingSort=new CountingSort();
		ArrayList<Integer> array=new ArrayList<Integer>();
		array.add(21);
		array.add(99);
		array.add(29);
		array.add(6);
		array.add(23);
		array.add(28);
		array.add(90);
		array.add(89);
		ArrayList<Integer> arrayExpected=countingSort.countingSort(array);
		System.out.println(arrayExpected);
		Collections.sort(array);
		assertEquals(arrayExpected, array);
	}

	@Test
	public void testCountingSort2() {
		CountingSort countingSort=new CountingSort();
		ArrayList<Integer> array=new ArrayList<Integer>();
		array.add(21);
		array.add(49);
		array.add(9);
		array.add(67);
		array.add(20);
		array.add(29);
		array.add(9);
		array.add(89);
		ArrayList<Integer> arrayExpected=countingSort.countingSort(array);
		Collections.sort(array);
		assertEquals(arrayExpected, array);
	}

	
	@Test
	public void testCountingSort3() {
		CountingSort countingSort=new CountingSort();
		ArrayList<Integer> array=new ArrayList<Integer>();
		array.add(2);
		array.add(99);
		array.add(2);
		array.add(59);
		array.add(23);
		array.add(2);
		array.add(0);
		array.add(1);
		ArrayList<Integer> arrayExpected=countingSort.countingSort(array);
		Collections.sort(array);
		assertEquals(arrayExpected, array);
	}

	
	@Test
	public void testCountingSort4() {
		CountingSort countingSort=new CountingSort();
		ArrayList<Integer> array=new ArrayList<Integer>();
		array.add(21);
		array.add(99);
		array.add(29);
		array.add(65);
		array.add(28);
		array.add(20);
		array.add(8);
		array.add(89);
		ArrayList<Integer> arrayExpected=countingSort.countingSort(array);
		Collections.sort(array);
		assertEquals(arrayExpected, array);
	}

}
