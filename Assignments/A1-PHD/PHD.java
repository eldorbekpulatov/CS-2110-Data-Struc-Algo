/** NetId: eb654, wjw97. Time spent: 6 hours, 15 minutes.
 An instance maintains info about the PHD of a person. */
//We have checked the javadoc, and it looks OK

public class PHD {
	private String name; 
	// Name of the person with a PHD, length > 0

	private char gender; 
	// gender of person, 'f' for female, 'm' for male

	private int year; 
	//year PHD was awarded

	private int month; 
	//month PHD was awarded, range of 1 to 12, 1 = Jan. and 12 = Dec.

	private PHD adv1 = null; 
	//first PHD advisor of this person -- null if unknown

	private PHD adv2 = null; 
	//second PHD advisor of this person -- null if unknown, 
	//or person only has one advisor or no advisors

	private int numAdvises = 0; 
	//number of advisees this person has (people they advise over)

	/** Constructor: an instance for a person with name n, gender g, PHD y
	 * ear y, and PHD month m. Its advisors are unknown, and it has no 
	 * advisees. Precondition: n has at least 1 char. m is in 1..12. g is
	 *  'f' for female or 'm' for male */
	PHD(String n, char g, int y, int m, PHD advisor1, PHD advisor2) {
		assert (n instanceof String): "Name received is not of type String.";
		assert (n.length() > 0): "Invalid name received.";
		assert ((g == 'm') || (g == 'f')) : "Invalid gender received.";
		assert ((m > 0) && (m < 13)): "Invalid month received.";
		assert (advisor1 instanceof PHD): "advisor1 was not of type PHD";
		assert (advisor2 instanceof PHD): "advisor2 was not of type PHD";

		this.name = n;
		this.gender = g;
		this.year = y;
		this.month = m;
		this.adv1 = advisor1;
		this.adv2 = advisor2;
	}

	/** Constructor: an instance for a person with name n, gender g, PHD y
	 * ear y, and PHD month m. Its advisors are unknown, and it has no 
	 * advisees. Precondition: n has at least 1 char. m is in 1..12. g is
	 *  'f' for female or 'm' for male */
	PHD(String n, char g, int y, int m, PHD advisor1) {
		assert (n instanceof String): "Name received is not of type String.";
		assert (n.length() > 0): "Invalid name length received.";
		assert ((g == 'm') || (g == 'f')) : "Invalid gender received.";
		assert ((m > 0) && (m < 13)): "Invalid month received.";
		assert (advisor1 instanceof PHD): "advisor1 was not of type PHD";

		this.name = n;
		this.gender = g;
		this.year = y;
		this.month = m;
		this.adv1 = advisor1;
		this.adv2 = null;
	}

	/** Constructor: an instance for a person with name n, gender g, PHD y
	 * ear y, and PHD month m. Its advisors are unknown, and it has no 
	 * advisees. Precondition: n has at least 1 char. m is in 1..12. g is
	 *  'f' for female or 'm' for male */
	PHD(String n, char g, int y, int m) {
		assert (n instanceof String): "Name received is not of type String.";
		assert (n.length() > 0): "Invalid name received.";
		assert ((g == 'm') || (g == 'f')) : "Invalid gender received.";
		assert ((m > 0) && (m < 13)): "Invalid month received.";

		this.name = n;
		this.gender = g;
		this.year = y;
		this.month = m;
		this.adv1 = null;
		this.adv2 = null;
	}
	
	/** Return the name of this person */
	public String getName() {
		return this.name;
	}
	
	
	/** Return the value of the sentence "This person is male." */
	public boolean isMale() {
		
		return (((int)this.gender) == 109);
	}

	/** Return the year this person got their PHD.*/
	public int getYear() {
		return this.year;
	}

	/** Return the month this person got their PHD */
	public int getMonth() {
		return this.month;
	}

	/** Return the 1st advisor of this PHD (null if unknown) 
	 * Precondition: the first advisor is unknown and p is not null. */
	public PHD advisor1() {
		return this.adv1;
	}

	/** Return the 2nd advisor of this PHD (null if unknown or non-existent) 
	 * Precondition: The first advisor (of this person) is known, the second 
	 * advisor is unknown, p is not null, and p is different from the first
	 *  advisor.*/
	public PHD advisor2() {
		return this.adv2;
	}

	/** Return the number of PHD advisees of this person. */
	public int numAdvises() {
		return this.numAdvises;
	}

	/**Add p as the first advisor of this person.
	 * Precondition: the first advisor is unknown and p is not null. */
	public void setAdvisor1(PHD p) {
		assert (p instanceof PHD): "Invalid advisor received.";
		assert (this.adv1 == null): "Advisor1 is already defined.";
		assert (p != null): "Invalid advisor received.";

		this.adv1 = p;
		p.numAdvises += 1;

	}

	/**Add p as the second advisor of this person.
	 * Precondition: The first advisor (of this person) is known, the second
	 * advisor is unknown, p is not null, and p is different 
	 * from the first advisor. */
	public void setAdvisor2(PHD p) {
		assert (p instanceof PHD): "Invalid advisor received.";
		assert (this.adv1 instanceof PHD) && (this.adv1 != null): 
			"Advisor1 is undefined.";
		assert this.adv1 != p: "Received PHD is already Advisor1";
		assert (this.adv2 == null): "Advisor2 is already defined.";
		assert (p != null): "Invalid advisor received.";

		this.adv2 = p;
		p.numAdvises += 1;
	}

	/**Return value of "this person got their PHD before p did."
	 * Precondition: p is not null. */
	public boolean gotBefore(PHD p) {
		assert (p!= null): "Invalid PHD recepient received.";
		
		return ((this.year < p.year) || ((this.year <= p.year) && (this.month < p.month)));
	}

	/**Return value of “p is not null and this person and p are
	 * intellectual siblings." */
	public boolean arePHDSiblings(PHD that) {
		assert (that != null): "Invalid PHD recipient received.";

		return ((this.adv1 == (that.adv1)) && (this.adv1 != null) || 
				(this.adv2 == (that.adv2)) && (this.adv2 != null) || 
				(this.adv1 == (that.adv2)) && (this.adv1 != null) || 
				(this.adv2 == (that.adv1)) && (this.adv2 != null));
	}
}
