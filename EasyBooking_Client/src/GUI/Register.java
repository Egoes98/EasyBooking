package GUI;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import controller.Controller;

import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Register {

	private JFrame frame;
	private JTextField textField;
	private JTextField password_account;
	private JTextField textField_cardNumber;
	private JTextField textField_name;
	private JTextField textField_username;
	private JTextField textField_password;
	private JTextField textField_CVV;
	private JTextField textField_1;
	Controller controller;

	/**
	 * Create the application.
	 */
	public Register(Controller controller) {
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
		
		JLabel lblRegisterUser = new JLabel("Register User");
		lblRegisterUser.setFont(new Font("Serif", Font.PLAIN, 20));
		lblRegisterUser.setBounds(10, 11, 121, 27);
		frame.getContentPane().add(lblRegisterUser);
		
		JLabel lblNewLabel = new JLabel("E-mail");
		lblNewLabel.setBounds(51, 49, 63, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(145, 46, 175, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAuthorizationMethod = new JLabel("Authorization method");
		lblAuthorizationMethod.setBounds(10, 120, 139, 14);
		frame.getContentPane().add(lblAuthorizationMethod);
		
		JRadioButton GoogleRadioButton = new JRadioButton("Google+");
		JRadioButton FacebookRadioButton = new JRadioButton("Facebook");
		FacebookRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(FacebookRadioButton.isSelected()) GoogleRadioButton.setSelected(false);
			}
		});
		FacebookRadioButton.setBounds(145, 116, 109, 23);
		frame.getContentPane().add(FacebookRadioButton);
		
		GoogleRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GoogleRadioButton.isSelected()) FacebookRadioButton.setSelected(false);
			}
		});
		GoogleRadioButton.setBounds(280, 116, 109, 23);
		frame.getContentPane().add(GoogleRadioButton);
		
		password_account = new JTextField();
		password_account.setBounds(145, 77, 175, 20);
		frame.getContentPane().add(password_account);
		password_account.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(51, 80, 63, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblPreferredPayment = new JLabel("Payment method");
		lblPreferredPayment.setBounds(10, 145, 139, 14);
		frame.getContentPane().add(lblPreferredPayment);
		
		textField_cardNumber = new JTextField();
		textField_cardNumber.setBounds(143, 197, 121, 20);
		frame.getContentPane().add(textField_cardNumber);
		textField_cardNumber.setColumns(10);
		textField_cardNumber.setVisible(false);
		
		textField_name = new JTextField();
		textField_name.setBounds(10, 197, 121, 20);
		frame.getContentPane().add(textField_name);
		textField_name.setColumns(10);
		textField_name.setVisible(false);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(156, 183, 81, 14);
		frame.getContentPane().add(lblUsername);
		lblUsername.setVisible(false);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(274, 183, 81, 14);
		frame.getContentPane().add(lblPassword_1);
		lblPassword_1.setVisible(false);
		
		textField_username = new JTextField();
		textField_username.setBounds(104, 197, 121, 20);
		frame.getContentPane().add(textField_username);
		textField_username.setColumns(10);
		textField_username.setVisible(false);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(39, 183, 63, 14);
		frame.getContentPane().add(lblName);
		lblName.setVisible(false);
		
		textField_password = new JTextField();
		textField_password.setBounds(241, 197, 121, 20);
		frame.getContentPane().add(textField_password);
		textField_password.setColumns(10);
		textField_password.setVisible(false);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(167, 183, 87, 14);
		frame.getContentPane().add(lblCardNumber);
		lblCardNumber.setVisible(false);
		
		textField_CVV = new JTextField();
		textField_CVV.setBounds(299, 197, 57, 20);
		frame.getContentPane().add(textField_CVV);
		textField_CVV.setColumns(10);
		textField_CVV.setVisible(false);
		
		JLabel lblCvv = new JLabel("CVV");
		lblCvv.setBounds(316, 183, 46, 14);
		frame.getContentPane().add(lblCvv);
		lblCvv.setVisible(false);
		
		JRadioButton rdbtnPaypal = new JRadioButton("Paypal");
		
		JRadioButton rdbtnVisa = new JRadioButton("Visa");
		rdbtnVisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnVisa.isSelected()){
					rdbtnPaypal.setSelected(false);
					lblName.setVisible(true);
					textField_name.setVisible(true);					
					lblCardNumber.setVisible(true);
					textField_cardNumber.setVisible(true);
					lblCvv.setVisible(true);
					textField_CVV.setVisible(true);
					
					lblUsername.setVisible(false);
					textField_username.setVisible(false);
					lblPassword_1.setVisible(false);
					textField_password.setVisible(false);
					
				}else {
					lblName.setVisible(false);
					textField_name.setVisible(false);					
					lblCardNumber.setVisible(false);
					textField_cardNumber.setVisible(false);					
					lblCvv.setVisible(false);
					textField_CVV.setVisible(false);
				}
			}
		});

		rdbtnVisa.setBounds(145, 142, 109, 23);
		frame.getContentPane().add(rdbtnVisa);
		
		rdbtnPaypal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnPaypal.isSelected()){
					rdbtnVisa.setSelected(false);
					lblUsername.setVisible(true);
					textField_username.setVisible(true);
					lblPassword_1.setVisible(true);
					textField_password.setVisible(true);
					
					lblName.setVisible(false);
					textField_name.setVisible(false);					
					lblCardNumber.setVisible(false);
					textField_cardNumber.setVisible(false);					
					lblCvv.setVisible(false);
					textField_CVV.setVisible(false);
				}else {
					lblUsername.setVisible(false);
					textField_username.setVisible(false);
					lblPassword_1.setVisible(false);
					textField_password.setVisible(false);
				}
			}
		});
		rdbtnPaypal.setBounds(280, 142, 109, 23);
		frame.getContentPane().add(rdbtnPaypal);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					//Registrar usuario
					//Datos de Registro
					String email = textField.getText();
					String password = textField_1.getText();
					String lMethod;
					if(GoogleRadioButton.isSelected()) {
						lMethod="Google";
					}else {
						lMethod="Facebook";
					}
					if(rdbtnPaypal.isSelected()) {
						String username=textField_username.getText();
						String pPassword=textField_password.getText();
					}else {
						String name=textField_name.getText();
						String cardNumber=textField_cardNumber.getText();
						String cvv=textField_CVV.getText();
					}
					controller.registerUser();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				new Login(controller);
				frame.dispose();
			}
		});
		btnRegister.setBounds(175, 228, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		textField_1 = new JTextField();
		textField_1.setBounds(330, 77, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDefaultAirport = new JLabel("Default Airport");
		lblDefaultAirport.setBounds(340, 49, 94, 14);
		frame.getContentPane().add(lblDefaultAirport);
	}
}
