package es.deusto.ingenieria.sd.sms.client.gui;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Controller;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwitchServerGUI {
	private JFrame frmSwitchingServers;
	private JTextField IP;
	private JTextField port;
	private JTextField name;
	private Controller my_controller;

	public SwitchServerGUI(Controller controller) {
		my_controller = controller;
		initialize();
		frmSwitchingServers.setLocation(0, 0);
		frmSwitchingServers.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSwitchingServers = new JFrame();
		frmSwitchingServers.setTitle("Switching Servers");
		frmSwitchingServers.setBounds(270, 420, 312, 207);
		frmSwitchingServers.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JPanel panelData = new JPanel();
		frmSwitchingServers.getContentPane().add(panelData, BorderLayout.CENTER);
		panelData.setLayout(null);

		JLabel lblServerIp = new JLabel("Server IP");
		lblServerIp.setBounds(55, 26, 71, 14);
		panelData.add(lblServerIp);

		IP = new JTextField();
		IP.setBounds(153, 23, 86, 20);
		IP.setText("127.0.0.1");
		panelData.add(IP);
		
		JLabel lblServerPort = new JLabel("Server Port");
		lblServerPort.setBounds(55, 58, 71, 14);
		panelData.add(lblServerPort);

		port = new JTextField();
		port.setBounds(153, 55, 86, 20);
		port.setText("1099");
		panelData.add(port);
		
		JLabel lblServerName = new JLabel("Server Name");
		lblServerName.setBounds(55, 91, 76, 14);
		panelData.add(lblServerName);

		name = new JTextField();
		name.setBounds(153, 88, 86, 20);
		panelData.add(name);
		
		JPanel panelButton = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButton.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		frmSwitchingServers.getContentPane().add(panelButton, BorderLayout.SOUTH);

		JButton btnSwitchServer = new JButton("Switch Server");
		btnSwitchServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String serverIP = IP.getText().trim();
				String serverPort = port.getText().trim();
				String serverName = name.getText().trim();
				// Calling the controller
				//my_controller.switchServer(serverIP, serverPort, serverName);
			}
		});
		panelButton.add(btnSwitchServer);

		frmSwitchingServers.getContentPane().add(panelButton, BorderLayout.SOUTH);
	}
}