package rec11;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

@SuppressWarnings("serial")
/** PairSorter is a toy GUI program to help get you used to using
 * anonymous functions. It has a sort button, a list of pairs, and
 * a radio button that decides whether the pairs are sorted by their
 * first element or second element.
 */
public class PairSorter extends JFrame {


	ArrayList<Pair> pairs; // list of Pairs; always displayed in listDisplay

	// true iff leftButton is enabled, false iff rightButton is enabled.
	// if true, the sort button sorts pairs by the first element of each pair
	// if false, it sorts by the second element
	boolean sortByFirst= true; 

	/** create the gui */
	public static void main(String[] pars) {
		PairSorter gui= new PairSorter();
	}

	/** constructor: set up the GUI and an empty tuple list */
	public PairSorter() {
		super("PairSorter");

		// setup the list
		pairs = new ArrayList<Pair>();

		// text area to display the list
		JTextArea listDisplay = new JTextArea("", 10, 5);

		// set up the radio buttons to choose which element to sort by
		JPanel chooserPanel= new JPanel();
		JRadioButton leftButton = new JRadioButton("Left", true);
		JRadioButton rightButton = new JRadioButton("Right");
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(leftButton);
		buttons.add(rightButton);
		leftButton.setEnabled(sortByFirst);
		chooserPanel.add(leftButton);
		chooserPanel.add(rightButton);

		// TODO 1: set up action listeners for the two radio buttons to
		// maintain the class invariant (in particular, see sortByFirst)
		leftButton.addActionListener(e -> leftButtonPressed()); 
		rightButton.addActionListener(e -> rightButtonPressed());



		// set up the add fields/button
		JPanel addPanel= new JPanel();
		JTextField firstField = new JTextField(3);
		JTextField secondField = new JTextField(3);
		JButton addButton = new JButton("Add");
		addPanel.add(firstField);
		addPanel.add(secondField);
		addPanel.add(addButton);

		// TODO 2: set up an actionlistener for the addButton.
		// It should add a new pair with the values given in firstField
		// and secondField to the list, then re-display the updated list.
		addButton.addActionListener(e -> addPair(firstField.getText(), secondField.getText(), listDisplay));


		// set up the sort button
		JButton sortButton= new JButton("Sort");

		// TODO 4: set up an actionlistener for the sort button.
		// it should sort the array and re-display the updated list.
		sortButton.addActionListener(e -> sort(listDisplay));



		// add components to gui and display
		Container cp= getContentPane();
		cp.add(addPanel, BorderLayout.WEST);
		cp.add(listDisplay, BorderLayout.CENTER);
		cp.add(sortButton, BorderLayout.SOUTH);
		cp.add(chooserPanel, BorderLayout.NORTH);

		setResizable(false);
		pack();
		setVisible(true);
	}

	/**when left button is pressed, sortByFirst is set to true */
	private void leftButtonPressed(){
		this.sortByFirst=true;
	}
	/**when right button is pressed, sortByFirst is set to false */
	private void rightButtonPressed(){
		this.sortByFirst=false;
	}

	/**add Pair to the ArrayList<Pair>. */
	private void addPair(String a, String b, JTextArea l){
		try {
			Pair hey=new Pair(a,b);
			this.pairs.add(hey);
			this.displayList(l);
		}catch (NumberFormatException e){ 
			System.out.println("Enter Something to the Text fields!");
		}
	}

	/** sort pairs by the first if sortByFirst is true, by
	 * second otherwise */
	private void sort(JTextArea l) {
		// TODO 3: sort the pairs array according to the spec.
		// Use Collections.sort and an anonymous function as the comparator
		if(!this.sortByFirst){
			for(int x=0; x<pairs.size()-1; x++){
				int j=pairs.get(x).second;
				int k=pairs.get(x+1).second;
				Collections.sort(pairs, (b, o)->k-j);
				this.displayList(l);
			}
		}else if (this.sortByFirst){
			for(int x=0; x<pairs.size()-1; x++){
				int j=pairs.get(x).first;
				int k=pairs.get(x+1).first;
				Collections.sort(pairs, (b, o)->k-j);
				this.displayList(l);
			}
		}
	}

	/** display the list elements separated by newlines in the given JTextArea */
	private void displayList(JTextArea ta) {
		String s = "";
		for (Pair p : pairs) {
			s = s + p + "\n";
		}
		ta.setText(s);
	}

	/** inner class representing pairs of integers */
	class Pair {
		private int first;
		private int second;

		/** constructor: create the pair (a, b) */
		public Pair(int a, int b) {
			first= a;
			second= b;
		}

		/** constructor: create pair (a,b), parsing integers from strings a,b
		 * precondition: a and b are strings that can be parsed to integers */
		public Pair(String a, String b) {
			this(Integer.parseInt(a), Integer.parseInt(b));
		}

		/** return parenthesized representation of the pair (first, second) */
		public String toString() {
			return "(" + first +  ", " + second + ")";
		}
	}


}