/* NetIds: eb654, wjw97. Time spent: 4 hours, 41 minutes. */

/** A collection of static String utility functions.
 * All methods assume that String parameters are non-null.
 *
 * If any method is called with arguments that do not satisfy the preconditions,
 * the behavior is undefined (it can do anything you want). For example, you
 * could (but do not have to) use assert statements to test preconditions.
 */
public class A2 { 
	/* Implementation notes:
	 *
	 * Wherever possible, prefer library functions to writing your own loops.
	 *
	 * The more complicated your loops become, the more important it is to explain
	 * the logic in comments. We don't explain break and continue. We prefer that
	 * you don't use them.
	 *
	 * When writing comments within a method body, you may find it useful to
	 * use multi-line comments to describe WHAT the code doing, and single-line
	 * comments to describe HOW it is doing it. For example:
	 *
	 *    /* Remove the unfrobnicatable whizbangs * /
	 *    for (...)
	 *        // NOTE: a whizbang is frobnicatable if it has two or more tails
	 *        ...
	 *
	 *    /* Frobnicate all the remaining whizbangs * /
	 *    for (...)
	 *        ...
	 */

	/* Notes on Java if statements and loops:
	 *
	 * Write an if statement like this:
	 *
	 *     if (boolean-expression) {
	 *         do this if boolean-expression is true
	 *     }
	 *
	 * Write an if-else statement like this:
	 *
	 *     if (boolean-expression) {
	 *         do this if boolean-expression is true
	 *     } else {
	 *         do this if boolean-expression is false
	 *     }
	 *
	 * Write a while-loop like this:
	 *
	 *    while ( boolean-expression ) {
	 *        repetend (the loop body, "the thing to be repeated")
	 *    }
	 *
	 * To execute the while-loop, do the following:
	 *
	 *   1. Evaluate the boolean-expression; if it is false, stop.
	 *   2. Execute the repetend.
	 *   3. Continue again at step 1.
	 *
	 * Write a for-loop to do-something several times, with i having values in
	 * m..n-1 (i.e. with i being m, m+1, m+2, ..., n-1). 
	 *
	 *    for (int i= m; i < n; i= i+1) {
	 *        repetend
	 *    }
	 *
	 * The for-loop above is equivalent to the while-loop below, except that
	 * local variable i is NOT usable after the loop; its scope is its assignment
	 * together with the loop.
	 *
	 *    int i= m;
	 *    while (i < n) {
	 *        repetend
	 *        i= i+1;
	 *    }
	 */

	/** Return either s1 + s2 or s1 - s2, depending on b.
	 *  If b is true, return the sum, otherwise return the difference.
	 */
	public static int sumDif(boolean b, int s1, int s2) {
		// This method is already implemented; it is here to give you something
		// to test, and to show you different ways of writing return statements.
		if (b) {
			int s;
			s = s1 + s2;
			return s;

			// equivalently:
			// int s = s1 + s2;
			// return s;

			// or simply:    return s1 + s2;
		}

		// b is false;
		return s1 - s2;
	}

	/** Return true iff the first half of s is the same as the second half of s.
	 *  Examples: For s = "" return true
	 *            For s = "xxx" return false  (if the length is odd, it's false)
	 *            For s = "xxxx" return true
	 *            For s = "hellohello" return true
	 *            For s = "helloworld" return false
	 */
	public static boolean isDoubled(String s) {
		// TODO 1: There is no need for a loop. Do not use a loop.
		// Use s1.equals(s2) to test for equality of strings s1 and s2.
		// Do not use s1 == s2.
		if (s.length()==0){ //if length is zero, return true
			return true;
		}
		if (s.length()%2==0){ //if length is even, then
			int x=s.length()/2;	//divide the string into two halves
			String b=s.substring(0, x); 
			String e=s.substring(x, s.length());
			if (b.equals(e)){ 
				return true; //true if two halves contain each other
			}
		}
		return false; //false, otherwise
	}

	/** Return s with its characters reversed.
	 *  Examples: if s = "" return ""
	 *            if s = "b" return "b"
	 *            if s = "abc", return "cba"
	 *            if s = "xxx", return "xxx"
	 */
	public static String reverse(String s) {
		if (s.length()<=1){
			return s; //base case
		}
		else{
			String begin=s.substring(0, 1); //first index of string
			String end=s.substring(1); //rest of the string

			return reverse(end)+begin; //recursively break up, 
			//and put the end in the beginning
		}


	}

	/** Return s but with each occurrence of a character in input replaced
	 *  by the corresponding character in output.
	 *  A character that does not appear in input is unchanged.
	 *
	 * Precondition: input and output are the same length.
	 *               No character in input appears in output (otherwise,
	 *               the idea of replacement might be ambiguous, depending
	 *               on the order in which replacements are done).
	 *
	 * Examples: encode("hello world", "", "")       = "hello world"
	 *           encode("hello world", "abc", "lmn") = "hello world"
	 *           encode("hello world", "hod", "xyz") = "xelly wyrlz"
	 *           encode("hello world", "helowrd", ".......") = "..... ....."
	 */
	public static String encode(String s, String input, String output) {
		// TODO 3 This needs only ONE for-loop with a single statement in the loop
		//      body. Look for a suitable String method!
		for (int x=0; x<input.length(); x++){ //until the end of length of input
			//replace every iteration of char at input index x
			//with char at output index x.
			s=s.replace(input.charAt(x), output.charAt(x));
		}
		return s; //return the resulting string
	}

	/** Return the shortest substring x of s such that s = x + x + ⋯ + x.
	 * Examples: For s = "" return ""
	 *           For s = "xxxxxxxxx" return "x"
	 *           For s = "xyxyxyxy" return "xy"
	 *           For s = "hellohellohello" return "hello"
	 *           For s = "hellohelloworld" return "hellohelloworld"
	 *           For s = "hellohel" return "hellohel"
	 */
	public static String deduplicate(String s) {
		//TODO This, no doubt, requires nested loops But you can add
		// another function, with a suitable specification, of course, in
		// order to remove the need for nested loops.

		if (s.length()<=0) return s; //if the length is <=1, return itself
		else {
			String sub; //else create an empty substring
			for (int x=0; x<=s.length()/2; x++){ //until we get to halfway of string
				sub=s.substring(0, x);	//update/increment the length of the substring
				if (onlySubs(s, sub)) return sub; //check @this length, if substring repeats
			}						// if repeats, return substring @length
		}
		return s;		//if doesn't repeat, return the whole thing
	}


	/**Returns True if a string s consists only of series of substrings d.
	 * A string is not an of length 0 or 1, and not null.
	 * 
	 * Form: 
	 *   string= sub + sub + sub;
	 * examples:
	 *   onlySubs("hehehe", "he")   returns true
	 *   onlySubs("hellohelloh", "hello") returns false
	 *   onlySubs("lolololol", "lo")   returns false
	 */
	public static boolean onlySubs(String s, String sub){
		//check if the substring divides evenly
		//if yes then execute the following, else return false
		if (((s.length()/1.0)/(sub.length()/1.0))%1==0){
			int beg=0; //finds the indexes of the beginning of substring in string
			int end=sub.length(); // finds the end indexes
			int num=s.length()/sub.length(); //number of iterations of substring
			String [] subs= new String [num]; //create an array of length stated above
			for (int x=0; x<num; x++){
				subs[x]=s.substring(beg, end); //assign substring to each array box
				beg+=sub.length(); //increment both beginning 
				end+=sub.length(); // and end by the length of substring
			}
			for (int y=0; y<subs.length; y++){ //for each element in the array
				if (!(subs[y].contains(sub))){ //check if matches with substring
					return false; //if does not match, immediately return false
				}
			}
			return true; //if all the comparisons passed, return true
		}
		return false; // this is from the evenly division (top)
	}

	/** Interpret a string as a formula and evaluate it.
	 *
	 * Formulas consist of a series of numbers separated by the
	 * operators '+' or '-'.  Formulas may  contain space characters
	 * between the numbers and the operators.
	 *
	 * Precondition: s is a valid formula and contain at least one number
	 *
	 * Examples: evaluate("3")             returns 3
	 *           evaluate("3 + 4")         returns 7
	 *           evaluate("100 - 25+50")   returns 125
	 *           evaluate("9")             returns 9
	 *           evaluate("   7   +   7   +    7  ") returns 21
	 */
	public static int evaluate(String s) {
		// TODO You can use Integer.parseInt to convert a string
		// (like "12345") to the corresponding integer (12345).

		s=s.replace(" ", ""); //Remove all the spaces.
		if (!(s.contains("+") || s.contains("-"))){ 
			//Base case: if the string is only numbers
			return Integer.parseInt(s); //returns the number
		}
		// plus and minus are the indexes of the operators
		int plus=s.lastIndexOf("+");
		int minus=s.lastIndexOf("-");

		//if the string has both operators
		if ((minus!= -1) && (plus!=-1)){
			//split the string at the rightmost operator
			if (plus>minus){
				String left=s.substring(0, plus);
				String right=s.substring(plus+1);
				//evaluate the left section and add the result to right section
				return evaluate(left)+Integer.parseInt(right);
			}else{
				String left=s.substring(0, minus);
				String right=s.substring(minus+1);
				//evaluate the left section and subtract the right section
				return evaluate(left)-Integer.parseInt(right);
			} 
		}
		if (minus==-1){
			// string only has (+) summation operator
			//so, split the string at the rightmost (+) operator
			String left=s.substring(0, plus);
			String right=s.substring(plus+1);
			//evaluate the left section and add the result to right section
			return evaluate(left)+Integer.parseInt(right);
		}else{
			// string only has (-) subtraction operator
			//so, split the string at the rightmost (-) operator
			String left=s.substring(0, minus);
			String right=s.substring(minus+1);
			//evaluate the left section and subtract the right section
			return evaluate(left)-Integer.parseInt(right);
		}
	}

}



