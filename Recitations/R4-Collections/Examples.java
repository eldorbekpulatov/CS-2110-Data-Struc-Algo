import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.EmptyStackException;


public class Examples {
  public static void main(String[] args) {
    int[] ho= new int[25];
    ho[0]= 1;
    ho[2]= 1;
    ho[4]= 5;
    System.out.println(Arrays.toString(removeDuplicates(ho)));
    
    int[] findNegTest = {110, -1, 11, 101, -101};
    for (Integer i : findNegatives(findNegTest)) {
      System.out.print(i + " ");
    }
    System.out.println();
    
    String foo = "[()()([]][]";
    String bar = "[]([()()])[]";
    System.out.println(checkBraces(foo));
    System.out.println(checkBraces(bar));
  }
  
  //problem 1: Remove duplicates
  /** Return a new array with all unique values in array */
  public static Integer[] removeDuplicates(int[] array) {
    ArrayList<Integer> a= new ArrayList<Integer>();
    for (int x: array){
      if (!a.contains(x)) {
        a.add(x);
      }
    }
    System.out.println(""+a);
    return  a.toArray(new Integer[a.size()]);
  }
  
  // problem 2: find all negative numbers in an array
  /** return a new array with all negative values in the input array */
  public static Integer[] findNegatives(int[] array) {
    ArrayList<Integer> neg=new ArrayList<Integer>(0);
    for (int x:array){
      if (x<0) neg.add(x);
    }
    return neg.toArray(new Integer[neg.size()]);
  }
  
  // problem 3: validate braces in a string
  /** return true iff all parens and square braces, i.e., ( and [
    * are properly matched and legally nested.  */
  public static boolean checkBraces(String s) {
    try {
      Stack<Character> st = new Stack<Character>();
      int x=0;
      while (x<s.length()){
        if (s.charAt(x)=='(' | s.charAt(x)== '[' ){
          st.push(s.charAt(x)); 
        }
        else if (s.charAt(x)==']' && st.peek()=='['){
          st.pop();
        }
        else if (s.charAt(x)==')' && st.peek()=='('){
          st.pop();
        }
        x++;
      }
      return st.empty();
    } 
    catch (EmptyStackException e){
      return false;
    }
  }
}
