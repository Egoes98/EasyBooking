package GUI;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.Controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	Controller controller;

	/**
	 * Create the application.
	 */
	public Login(Controller controller) {
		initialize();
		frame.setVisible(true);
		this.controller = controller;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(209, 56, 121, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(209, 87, 121, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Facebook");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Conectar con Facebook
				try {
					System.out.println(textField.getText());
					//Parametros de conecxion
					String email = textField.getText();
					String password = "" + textField_1.getText();
					controller.loginUser();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new Booking(controller);
				new Booked(controller);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(109, 157, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Register(controller);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(167, 203, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblEasybooking = new JLabel("EasyBooking");
		lblEasybooking.setBounds(153, 22, 144, 23);
		lblEasybooking.setFont(new Font("Serif", Font.PLAIN, 20));
		frame.getContentPane().add(lblEasybooking);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(135, 56, 64, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(135, 90, 64, 14);
		frame.getContentPane().add(lblPassword);
		
		JButton btnNewButton_2 = new JButton("Google+");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Conectar con google+
				try {
					System.out.println(textField.getText());
					//Parametros de conecxion
					String email = textField.getText();
					String password = "" + textField_1.getText();
					controller.loginUser();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new Booking(controller);
				new Booked(controller);
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(219, 157, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblAuthorizationMethod = new JLabel("Authorization method");
		lblAuthorizationMethod.setBounds(151, 130, 121, 14);
		frame.getContentPane().add(lblAuthorizationMethod);
	}
}
