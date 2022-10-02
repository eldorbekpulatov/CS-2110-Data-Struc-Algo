/* Time spent on a3:  4 hours and 00 minutes.
 * Name:Eldor Bekpulatov, Billy Wilkinson
 * Netid: eb654, wjw97
 * What I thought about this assignment:
 * We had a blast!
 */

package LinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class CLLTest {
	
	@Test
	public void test() {
		testConstructor();
		testAppend();
		testGetNode();
		testInsertAfter();
		testRemove();
	}
	
	
	public void testConstructor() {
		System.out.println("testing Constructor");
		CLL<Integer> b= new CLL<Integer>();
		assertEquals("[]", b.toString());
		assertEquals("[]", b.toStringRev());
		assertEquals(0, b.size());
		assertEquals(null, b.getFirst());
		System.out.println("constructor passed the test");
	} 
	
	
	public void testAppend() {
		System.out.println("testing Append");
		CLL<Integer> c= new CLL<Integer>();
		c.append(5);
		assertEquals("[5]", c.toString());
		assertEquals("[5]", c.toStringRev());
		assertEquals(1, c.size());
		assertEquals(c.getLast(), c.getFirst());
		c.append(6);
		assertEquals("[5, 6]", c.toString());
		assertEquals("[6, 5]", c.toStringRev());
		assertEquals(2, c.size());
		assertEquals(new Integer(5), c.getFirst().getValue());
		c.append(7);
		assertEquals("[5, 6, 7]", c.toString());
		assertEquals("[7, 6, 5]", c.toStringRev());
		assertEquals(3, c.size());
		assertEquals(new Integer(5), c.getFirst().getValue());
		System.out.println("passed Append");
	}
	
	public void testPrepend() {
		System.out.println("testing Append");
		CLL<Integer> c= new CLL<Integer>();
		c.prepend(5);
		assertEquals("[5]", c.toString());
		assertEquals("[5]", c.toStringRev());
		assertEquals(1, c.size());
		assertEquals(c.getLast(), c.getFirst());
		c.prepend(6);
		assertEquals("[6, 5]", c.toString());
		assertEquals("[5, 6]", c.toStringRev());
		assertEquals(2, c.size());
		assertEquals(new Integer(6), c.getFirst().getValue());
		c.prepend(7);
		assertEquals("[7, 6, 5]", c.toString());
		assertEquals("[5, 6, 7]", c.toStringRev());
		assertEquals(3, c.size());
		assertEquals(new Integer(7), c.getFirst().getValue());
		System.out.println("passed Append");
	}
	
	public void testGetNode(){
		System.out.println("testing getNode");
		CLL<Integer> c= new CLL<Integer>();
		c.append(0);
		c.append(1);
		c.append(2);
		c.append(3);
		c.append(4);
		assertEquals(5, c.size());
		assertEquals(new Integer(2), c.getNode(2).getValue());
		assertEquals(new Integer(0), c.getNode(0).getValue());
		assertEquals(new Integer(4), c.getNode(4).getValue());
		c.append(5);
		assertEquals(6, c.size());
		assertEquals(new Integer(3), c.getNode(3).getValue());
		assertEquals(new Integer(0), c.getNode(0).getValue());
		assertEquals(new Integer(4), c.getNode(4).getValue());
		assertEquals(new Integer(5), c.getNode(5).getValue());
		try {
	        c.getNode(-1);
	        fail();}
	    catch (IndexOutOfBoundsException e) {}
		
		try{
			c.getNode(7);
			fail();}
		catch (IndexOutOfBoundsException d){}

		System.out.println("passed getNode");
	}
	
	public void testInsertAfter(){
		System.out.println("testing insertAfter");
		CLL<Integer> c=new CLL<Integer>();
		c.append(0);
		c.insertAfter(1, c.getFirst());
		assertEquals(2, c.size());
		assertEquals(new Integer(0), c.getFirst().getValue());
		assertEquals("[0, 1]", c.toString());
		assertEquals("[1, 0]", c.toStringRev());
		assertEquals(new Integer(0), c.getFirst().getValue());
		c.insertAfter(1, c.getLast());
		assertEquals(3, c.size());
		assertEquals("[0, 1, 1]", c.toString());
		assertEquals("[1, 1, 0]", c.toStringRev());
		assertEquals(new Integer(0), c.getFirst().getValue());
		c.insertAfter(3, c.getNode(1));
		assertEquals("[0, 1, 3, 1]", c.toString());
		assertEquals("[1, 3, 1, 0]", c.toStringRev());
		assertEquals(new Integer(0), c.getFirst().getValue());
		assertEquals(4, c.size());
		System.out.println("passed inserAfter");
	}
	
	public void testRemove(){
		System.out.println("testing Remove");
		CLL<Integer> c=new CLL<Integer>();
		c.append(0);
		c.remove(c.getFirst());
		assertEquals(0,c.size());
		assertEquals(null, c.getFirst());
		assertEquals(null, c.getLast());
		assertEquals("[]", c.toString());
		c.append(1);
		c.append(2);
		c.append(3);
		c.remove(c.getNode(0));
		assertEquals(2, c.size());
		assertEquals(new Integer(2), c.getFirst().getValue());
		assertEquals("[2, 3]", c.toString());
		assertEquals("[3, 2]", c.toStringRev());
		System.out.println("passed Remove");
	}
}
