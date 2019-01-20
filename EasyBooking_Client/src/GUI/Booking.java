package GUI;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.Controller;
import dto.FlightDTO;

import javax.swing.JComboBox;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Booking {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	Controller controller;
	List<FlightDTO> flights = new ArrayList<>();
	DefaultListModel listModel = new DefaultListModel();
	Booked b;
	/**
	 * Create the application.
	 */
	public Booking(Controller controller, Booked b) {
		initialize();
		frame.setVisible(true);
		this.controller = controller;
		this.b = b;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEasybooking = new JLabel("EasyBooking");
		lblEasybooking.setFont(new Font("Serif", Font.PLAIN, 20));
		lblEasybooking.setBounds(155, 0, 183, 27);
		frame.getContentPane().add(lblEasybooking);
		
		JList list = new JList();
		list.setBounds(10, 125, 414, 125);
		frame.getContentPane().add(list);
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FlightDTO f = (FlightDTO) list.getSelectedValue();
				try {
					if(controller.bookFlight(f)) {
						//b.updateList();
					}else {
						System.out.println("Cant book");
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBook.setBounds(243, 91, 68, 23);
		frame.getContentPane().add(btnBook);
		
		textField = new JTextField();
		textField.setBounds(98, 65, 77, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 65, 77, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("From:");
		lblNewLabel_1.setBounds(20, 50, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(99, 50, 46, 14);
		frame.getContentPane().add(lblTo);
		
		Choice day = new Choice();
		day.setBounds(181, 65, 46, 20);
		for(int n = 1; n < 32; n++) {
			day.add(""+n);
		}
		frame.getContentPane().add(day);
		
		Choice month = new Choice();
		month.setBounds(233, 65, 46, 20);
		for(int n = 1; n < 13; n++) {
			month.add(""+n);
		}
		frame.getContentPane().add(month);
		
		Choice year = new Choice();
		year.setBounds(285, 65, 55, 20);
		for(int n = 2019; n < 2023; n++) {
			year.add(""+n);
		}
		frame.getContentPane().add(year);
		
		Label label = new Label("Date");
		label.setBounds(217, 42, 62, 22);
		frame.getContentPane().add(label);
		
		textField_2 = new JTextField();
		textField_2.setBounds(361, 65, 46, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Number of");
		lblNewLabel_2.setBounds(360, 31, 64, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblPassengers = new JLabel("Passengers");
		lblPassengers.setBounds(361, 50, 77, 14);
		frame.getContentPane().add(lblPassengers);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String origin = textField_1.getText().toLowerCase();
				String destiny = textField.getText().toLowerCase();
				String date = day.getSelectedItem() + "/" + month.getSelectedItem() + "/" + year.getSelectedItem();
				int seats = Integer.parseInt(textField_2.getText());
				flights = controller.searchForFlight(origin,destiny,date,seats);
				
				if(flights == null) {
					listModel.clear();
					list.setModel(listModel);
					System.out.println("No results");
					return;
				}
				listModel.clear();
				for (int i = 0; i < flights.size(); i++)
				{
				    listModel.addElement(flights.get(i));
				}
				list.setModel(listModel);
			}
		});
		btnSearch.setBounds(119, 91, 89, 23);
		frame.getContentPane().add(btnSearch);
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
