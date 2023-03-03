package _00_JButtons_with_Lambdas;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * The documentation for the addActionListener method lists a single input
 * parameter, a variable of type ActionListener:
 * 
 *   public void addActionListener(ActionListener l)
 * 
 * ActionListener is a functional interface with 1 unimplemented method with
 * a single input parameter,
 * 
 *   void actionPerformed(ActionEvent e)
 * 
 * As a result, the lambda expression to implement the actionPerformed method
 * can be written as:
 * 
 *   button.addActionListener( (e) -> {
 *       // code to execute when button is clicked
 *   });
 * 
 * References:
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/AbstractButton.html#addActionListener-java.awt.event.ActionListener-
 * https://docs.oracle.com/javase/8/docs/api/java/awt/event/ActionListener.html
 */
public class LambdaButtons {
	private JFrame window = new JFrame();
	private JButton addNumbers = new JButton("ADD 2 Numbers");
	private JButton randNumber = new JButton("RANDOM NUMBER");
	private JButton tellAJoke = new JButton("TELL A JOKE");
	
	public LambdaButtons() {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new FlowLayout());
		window.add(addNumbers);
		window.add(randNumber);
		window.add(tellAJoke);
		
		//1. Call the addActionListener methods for each button. Use lambdas
		//   to define to functionality of the buttons.
		
		window.setVisible(true);
		window.pack();
	}
	
	public static void main(String[] args) {
		new LambdaButtons();
	}
	
	
}
