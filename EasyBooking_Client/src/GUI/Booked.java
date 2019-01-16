package GUI;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import controller.Controller;
import dto.FlightDTO;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Booked {

	private JFrame frame;
	Controller controller;
	List<FlightDTO> flights = new ArrayList<>();
	DefaultListModel listModel = new DefaultListModel();
	JList list;


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
		
		list = new JList();
		list.setBounds(10, 90, 336, 145);
		frame.getContentPane().add(list);
		
		JLabel lblBookedFlights = new JLabel("Booked Flights");
		lblBookedFlights.setBounds(130, 11, 141, 31);
		lblBookedFlights.setFont(new Font("Serif", Font.PLAIN, 20));
		frame.getContentPane().add(lblBookedFlights);
		
		JButton btnCancelFlight = new JButton("Cancel Flight");
		btnCancelFlight.addActionListener(new ActionListener() {
			try {
				controller.cancelFlight(list.getAnchorSelectionIndex());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		btnCancelFlight.setBounds(133, 56, 123, 23);
		frame.getContentPane().add(btnCancelFlight);
	}
	
	public void updateList() {
		try {
			this.flights = controller.getReservation();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < this.flights.size(); i++)
		{
		    listModel.addElement(this.flights.get(i));
		}
		list.setModel(listModel);
	}

}
