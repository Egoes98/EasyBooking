package GUI;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Payment {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Payment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Serif", Font.PLAIN, 20));
		lblPayment.setBounds(189, 11, 135, 21);
		frame.getContentPane().add(lblPayment);
		
		JTextField textField_cardNumber = new JTextField();
		textField_cardNumber.setBounds(143, 197, 121, 20);
		frame.getContentPane().add(textField_cardNumber);
		textField_cardNumber.setColumns(10);
		textField_cardNumber.setVisible(false);
		
		JTextField textField_name = new JTextField();
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
		
		JTextField textField_username = new JTextField();
		textField_username.setBounds(104, 197, 121, 20);
		frame.getContentPane().add(textField_username);
		textField_username.setColumns(10);
		textField_username.setVisible(false);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(39, 183, 63, 14);
		frame.getContentPane().add(lblName);
		lblName.setVisible(false);
		
		JTextField textField_password = new JTextField();
		textField_password.setBounds(241, 197, 121, 20);
		frame.getContentPane().add(textField_password);
		textField_password.setColumns(10);
		textField_password.setVisible(false);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(167, 183, 87, 14);
		frame.getContentPane().add(lblCardNumber);
		lblCardNumber.setVisible(false);
		
		JTextField textField_CVV = new JTextField();
		textField_CVV.setBounds(299, 197, 57, 20);
		frame.getContentPane().add(textField_CVV);
		textField_CVV.setColumns(10);
		textField_CVV.setVisible(false);
		
		JLabel lblCvv = new JLabel("CVV");
		lblCvv.setBounds(316, 183, 46, 14);
		frame.getContentPane().add(lblCvv);
		lblCvv.setVisible(false);
		
		
		JRadioButton rdbtnVisa = new JRadioButton("Visa");
		rdbtnVisa.setBounds(134, 124, 65, 23);
		frame.getContentPane().add(rdbtnVisa);
		rdbtnVisa.setVisible(false);
		
		JRadioButton rdbtnPaypal = new JRadioButton("Paypal");
		rdbtnPaypal.setBounds(241, 124, 109, 23);
		frame.getContentPane().add(rdbtnPaypal);
		rdbtnPaypal.setVisible(false);
		
		JRadioButton rdbtnPayWithPreferred = new JRadioButton("Pay with preferred method");
		rdbtnPayWithPreferred.setBounds(22, 43, 177, 23);
		frame.getContentPane().add(rdbtnPayWithPreferred);
		
		JRadioButton rdbtnOtherMethod = new JRadioButton("Other Method");
		rdbtnOtherMethod.setBounds(277, 43, 151, 23);
		frame.getContentPane().add(rdbtnOtherMethod);
		
		JButton btnPay = new JButton("Pay");
		btnPay.setBounds(191, 73, 63, 23);
		frame.getContentPane().add(btnPay);
		
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
		
		rdbtnPayWithPreferred.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnPayWithPreferred.isSelected()) { 
					rdbtnOtherMethod.setSelected(false);
					
					rdbtnPaypal.setVisible(false);
					lblUsername.setVisible(false);
					textField_username.setVisible(false);
					lblPassword_1.setVisible(false);
					textField_password.setVisible(false);
					
					rdbtnVisa.setVisible(false);
					lblName.setVisible(false);
					textField_name.setVisible(false);					
					lblCardNumber.setVisible(false);
					textField_cardNumber.setVisible(false);					
					lblCvv.setVisible(false);
					textField_CVV.setVisible(false);
				}
			}
		});
		
		rdbtnOtherMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnOtherMethod.isSelected()) {
					rdbtnPayWithPreferred.setSelected(false);
					
					rdbtnPaypal.setVisible(true);
					rdbtnVisa.setVisible(true);
					
				}else{
					rdbtnPaypal.setVisible(false);
					lblUsername.setVisible(false);
					textField_username.setVisible(false);
					lblPassword_1.setVisible(false);
					textField_password.setVisible(false);
					
					rdbtnVisa.setVisible(false);
					lblName.setVisible(false);
					textField_name.setVisible(false);					
					lblCardNumber.setVisible(false);
					textField_cardNumber.setVisible(false);					
					lblCvv.setVisible(false);
					textField_CVV.setVisible(false);
				}
			}
		});
	}

}
