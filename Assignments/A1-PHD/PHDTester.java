/** NetId: eb654, wjw97. Time spent: 6 hours, 15 minutes.
 A tester class used to check our work of PHD class */

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author eb654 (Eldor) and wjw97 (Billy)
 *
 */
public class PHDTester {
	//two PHD objects to be tested
	private PHD female = new PHD("Female PHDer", 'f', 2010, 5);
	private PHD male = new PHD("Male PHDer", 'm', 2008, 2);
	private PHD third = new PHD("Third PHDer", 'f', 2000, 5);
	private PHD fourth = new PHD("Fourth PHDer", 'm', 1989, 2);

	@Test
	public void test() {
		//assertEquals(expected val, computed val)
		testA();
		testB();
		testD();
	}
	
	public void testA() {
		getNameTest(); 
		isMaleTest();
		getYearTest();
		getMonthTest();
		advisor1Test();
		advisor2Test();	
		numAdvisesTest();
	}

	public void testB() {
		setAdvisor1Test(); 
		setAdvisor2Test();
	}
	
	public void testD() {
		gotBeforeTest(); 
		arePHDSiblingsTest();
	}
	
	public void getNameTest() {
		System.out.println("Testing getName()");
		//test one
		assertEquals("Female PHDer", female.getName());
		//test two
		assertEquals("Male PHDer", male.getName());
		System.out.println("getName() works");

		/**testing name preconditions*/
		System.out.println("Testing name precondition.");
		//length of 0 name
		try { new PHD("", 'm', 1942, 10);
		fail("");
		}
		catch (AssertionError e) {}
		System.out.println("Name precondition works.");

	}

	public void isMaleTest() {
		System.out.println("Testing isMale()");
		//test one
		assertEquals(false, female.isMale());
		//test two
		assertEquals(true, male.isMale());
		System.out.println("isMale() works");

		/** testing gender preconditions*/
		//not 'm' or 'f'
		System.out.println("Testing gender precondition");
		try { new PHD("", 'x', 2017, 9);
		fail("");
		}
		catch (AssertionError e) {}
		System.out.println("Gender precondition works.");
	}

	public void getYearTest() {
		System.out.println("Testing getYear()");
		//test one
		assertEquals(2010, female.getYear());
		//test two
		assertEquals(2008, male.getYear());
		System.out.println("getYear() works");
	}

	public void getMonthTest() {
		System.out.println("Testing getMonth()");
		//test one
		assertEquals(5, female.getMonth());
		//test two
		assertEquals(2, male.getMonth());
		System.out.println("getMonth() works");

		/**testing month preconditions*/

		//13th month
		System.out.println("Testing month precondition.");
		try { new PHD("Name Test", 'm', 1000, 13);
		fail("");
		}
		catch (AssertionError e) {}

		//0th month
		try { new PHD("Name Test", 'm', 2, 0);
		fail("");
		}
		catch (AssertionError e) {}
		System.out.println("Month precondition works");
	}

	public void advisor1Test() {
		System.out.println("Testing advisor1()");
		//test one
		assertEquals(null, female.advisor1());
		//test two
		assertEquals(null, male.advisor1());
		System.out.println("advisor1() works");
	}

	public void advisor2Test() {
		//testing advisor2()
		System.out.println("Testing advisor2()");
		assertEquals(null, female.advisor2());
		assertEquals(null, male.advisor2());
		System.out.println("advisor2() works");
	}

	public void setAdvisor1Test() {
		System.out.println("Testing setAdvisor1()");
		third.setAdvisor1(female);
		//test one
		assertEquals(female, third.advisor1());

		//test two
		male.setAdvisor1(third);
		assertEquals(third, male.advisor1());
		System.out.println("setAdvisor1() works");

		/**testing preconditions*/
		
		//already has an advisor1
		System.out.println("Testing setAdvisor1() preconditions.");
		PHD test1 = new PHD("Test 1", 'm', 1999, 5);
		test1.setAdvisor1(male);
		try { test1.setAdvisor1(female);
		fail("");
		}
		catch (AssertionError e) {}
		System.out.println("setAdvisor1() preconditions work");
	}

	public void setAdvisor2Test() {
		//testing setAdvisor2
		System.out.println("Testing setAdvisor2()");
		female.setAdvisor1(male); female.setAdvisor2(third);
		assertEquals(third, female.advisor2());

		//test two
		male.setAdvisor2(fourth);
		assertEquals(fourth, male.advisor2());
		System.out.println("setAdvisor2() works");

		//testing preconditions
		//already has an advisor1
		System.out.println("Testing setAdvisor2() preconditions.");
		PHD test2 = new PHD("Test 2", 'm', 1999, 5);

		try { test2.setAdvisor2(female);
		fail("");
		}
		catch (AssertionError e) {}


		try { male.setAdvisor2(female);
		fail("");
		}
		catch (AssertionError e) {}
		System.out.println("setAdvisor2() preconditions work");
	}

	public void numAdvisesTest() {
		//creating new PHDers to minimize confusion
		PHD guy1 = new PHD("Guy 1", 'm', 2000, 10);
		PHD guy2 = new PHD("Guy 2", 'm', 2001, 11);
		PHD guy3 = new PHD("Guy 3", 'm', 2002, 12);
		//testing numAdvises()
		System.out.println("Testing numAdvises()");
		assertEquals(0, guy1.numAdvises());
		assertEquals(0, guy2.numAdvises());

		guy3.setAdvisor1(guy1);
		guy3.setAdvisor2(guy2);
		guy2.setAdvisor1(guy1);

		assertEquals(2, guy1.numAdvises());
		assertEquals(1, guy2.numAdvises());
		System.out.println("numAdvises() works");
	}

	public void gotBeforeTest() {
		//testing gotBefore()
		//Return value of "this person got their PHD before p did."
		PHD younger = new PHD("Younger PHD", 'f', 2000, 5);
		PHD older = new PHD("Older PHD", 'm', 2000, 10);
		System.out.println("Testing gotBefore()");
		assertEquals(true, younger.gotBefore(older));
		assertEquals(false, older.gotBefore(younger));
		System.out.println("gotBefore() works");

		/** testing gotBefore() preconditions*/
		//send over null
		System.out.println("Testing gotBefore() preconditions.");
		try {younger.gotBefore(null);
		fail("");
		}
		catch (AssertionError e) {}
		System.out.println("gotBefore() preconditions work.");
	}

	public void arePHDSiblingsTest() {
		//testing gotBefore()
		//Return value of "this person got their PHD before p did."
		PHD one = new PHD("1", 'm', 2000, 2); 
		PHD two = new PHD("2", 'm', 2001, 3);
		PHD three = new PHD("3", 'm', 2002, 4);
		one.setAdvisor1(three); 
		two.setAdvisor1(one); two.setAdvisor2(three);

		System.out.println("Testing arePHDSiblings()");		
		assertEquals(true, one.arePHDSiblings(two));
		assertEquals(false, one.arePHDSiblings(three));
		System.out.println("arePHDSiblings() works");

		/** testing arePHDSiblings() preconditions*/
		//send over null
		System.out.println("Testing arePHDSiblings() preconditions.");
		try {three.arePHDSiblings(null);
		fail("");
		}
		catch (AssertionError e) {}
		System.out.println("arePHDSiblings() preconditions work.");
	}
}

