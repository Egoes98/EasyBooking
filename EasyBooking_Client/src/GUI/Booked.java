package GUI;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import controller.Controller;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Booked {

	private JFrame frame;
	Controller controller;

	/**
	 * Create the application.
	 */
	public Booked(Controller controller) {
		initialize();
		this.controller=controller;
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 372, 285);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 90, 336, 145);
		frame.getContentPane().add(list);
		
		JLabel lblBookedFlights = new JLabel("Booked Flights");
		lblBookedFlights.setBounds(130, 11, 141, 31);
		lblBookedFlights.setFont(new Font("Serif", Font.PLAIN, 20));
		frame.getContentPane().add(lblBookedFlights);
		
		JButton btnCancelFlight = new JButton("Cancel Flight");
		btnCancelFlight.setBounds(133, 56, 123, 23);
		frame.getContentPane().add(btnCancelFlight);
	}

}
