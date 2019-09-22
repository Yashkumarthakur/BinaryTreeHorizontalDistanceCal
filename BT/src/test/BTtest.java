package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.BT;
import main.BTNode;

class BTtest {
	BT bt = new BT();
	@Test
	void testSingleInsertioneNode() {
		assertEquals(5, (bt.insert(5)).getData());
		assertEquals(-1, (bt.insert(5)).getRight().getData());
		assertEquals(-1, (bt.insert(5)).getLeft().getData());
	}

	/**
	 * 			root
	 * 			  |
	 * 			  5	
	 * 		3			9
	 * 	2			7		10
	 * 
	 */
	@Test
	void testMultiInsertioneNode() {
		
		bt.insert(5);
		bt.insert(3);
		bt.insert(9);
		bt.insert(2);
		bt.insert(7);
		bt.insert(10);
		BTNode temp = bt.insert(10);
		assertEquals(true, get(temp, 5));
		assertEquals(true, get(temp, 3));
		assertEquals(true, get(temp, 9));
		assertEquals(true, get(temp, 2));
		assertEquals(true, get(temp, 7));
		assertEquals(true, get(temp, 10));
	}

	private boolean get(BTNode r, int val) {
		 if (r.getData() == val)
             return true;
         if (r.getLeft() != null)
             if (get(r.getLeft(), val))
                 return true;
         if (r.getRight() != null)
             if (get(r.getRight(), val))
                 return true;
         return false; 
	}
	
	/**
	 * 
	 * 			  root
	 * 			  	|
	 * 			  	9	
	 * 		|				|
	 * 		7				15
	 * 	|		|		|		|
	 * 	5		8		10		20
	 * |				  |			|
	 * 1				  12		25
	 * 
	 * 
	 * 
	 */
	@Test
	void testDistanceCalculation() {
		//		add nodes
		bt.insert(9);
		bt.insert(7);
		bt.insert(15);
		bt.insert(5);
		bt.insert(8);
		bt.insert(10);
		bt.insert(20);
		bt.insert(1);
		bt.insert(12);
		bt.insert(25);
		assertEquals(6, bt.findDistance(1, 25, 4));
		assertEquals(0, bt.findDistance(1, 29, 4));
	}
}
