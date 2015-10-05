package SecondProgram;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class TestBubbleSort {

	@Test
	public void testBubbleSort1() {
		BubbleSort bubbleSort=new BubbleSort();
		ArrayList<Integer> array=new ArrayList<Integer>();
		array.add(21);
		array.add(999);
		array.add(29);
		array.add(65);
		array.add(23);
		array.add(28);
		array.add(90);
		array.add(389);
		ArrayList<Integer> arrayExpected=bubbleSort.bubbleSort(array);
		Collections.sort(array);
		assertEquals(arrayExpected, array);
	}

	@Test
	public void testBubbleSort2() {
		BubbleSort bubbleSort=new BubbleSort();
		ArrayList<Integer> array=new ArrayList<Integer>();
		array.add(21);
		array.add(999);
		array.add(9);
		array.add(675);
		array.add(230);
		array.add(289);
		array.add(909);
		array.add(389);
		ArrayList<Integer> arrayExpected=bubbleSort.bubbleSort(array);
		Collections.sort(array);
		assertEquals(arrayExpected, array);
	}

	
	@Test
	public void testBubbleSort3() {
		BubbleSort bubbleSort=new BubbleSort();
		ArrayList<Integer> array=new ArrayList<Integer>();
		array.add(2);
		array.add(99);
		array.add(2);
		array.add(659);
		array.add(23);
		array.add(2856);
		array.add(9090);
		array.add(3891);
		ArrayList<Integer> arrayExpected=bubbleSort.bubbleSort(array);
		Collections.sort(array);
		assertEquals(arrayExpected, array);
	}

	
	@Test
	public void testBubbleSort4() {
		BubbleSort bubbleSort=new BubbleSort();
		ArrayList<Integer> array=new ArrayList<Integer>();
		array.add(21);
		array.add(99);
		array.add(29);
		array.add(65);
		array.add(283);
		array.add(200);
		array.add(90898);
		array.add(389);
		ArrayList<Integer> arrayExpected=bubbleSort.bubbleSort(array);
		Collections.sort(array);
		assertEquals(arrayExpected, array);
	}


}
