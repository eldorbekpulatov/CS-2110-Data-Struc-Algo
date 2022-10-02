import java.io.*;
import java.net.*;

/** Demo IO */
public class IOProblems {

    public static String courseLinksPage=
        "http://www.cs.cornell.edu/courses/CS2110/2014sp/links.html";
    public static String clocktower= "https://en.wikipedia.org/wiki/Clock_tower";

    /** main method demos the methods below */
    public static void main(String[] pars) throws IOException {
        System.out.println(urlInstances(new URL(courseLinksPage), "Java"));
        
        // suggestion: change "tower.html" to a file you know how to find on your system
        customizeWebpage(new URL(clocktower), "tower.html", "Clock", "Bingalee");
    }
    
    /** Return the number of times String s appears in String line */
    public static int lineInstances(String line, String s) {
    	// we give you this helper method to make your life simpler.
        int count= 0;
        int ind= line.indexOf(s);
        // inv: all instances up to s[ind] have been counted
        while (ind != -1) {
            count += 1;
            ind = line.indexOf(s, ind+s.length());
        }
        return count;
    }

    /**  Return the number of times String s appears in webpage page */
    public static int urlInstances(URL url, String s) throws IOException {
        //TODO 1: implement me!
    	return 0;
    }


    
    /** read the webpage from inUrl, and write content out to outFn,
     * with all instances of from replaced by to. */
    public static void customizeWebpage(
    		URL inUrl, String outFn, String from, String to) throws IOException {
    	
    	// TODO 2: implement me!
    }
}
