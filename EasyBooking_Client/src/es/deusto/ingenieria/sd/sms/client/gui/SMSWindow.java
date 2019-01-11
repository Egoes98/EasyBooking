package es.deusto.ingenieria.sd.sms.client.gui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import controller.Controller;
import es.deusto.ingenieria.sd.sms.client.data.TVProgram;

public class SMSWindow extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private Controller controller;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField acronym;
	private javax.swing.JButton buttonCloseP;
	private javax.swing.JButton buttonSend;
	private javax.swing.JButton buttonReport;
	private javax.swing.JButton buttonLimit;
	private javax.swing.JButton buttonForbidden;
	private javax.swing.JButton buttonNewP;
	private javax.swing.JButton buttonOptions;
	private javax.swing.JTextField description;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JTextField limit;
	private javax.swing.JList<String> tvProgsList1;
	private javax.swing.JList<String> tvProgsList2;
	private javax.swing.JTextField options;
	private javax.swing.JTextField forbiddenWords;
	private javax.swing.JPanel panelButton;
	private javax.swing.JPanel panelButtonsP1;
	private javax.swing.JPanel panelPrograms;
	private javax.swing.JPanel panelControlP;
	private javax.swing.JPanel panelControlM;
	private javax.swing.JPanel panelListTvP1;
	private javax.swing.JPanel panelListTvP2;
	private javax.swing.JPanel panelMessages;
	private javax.swing.JPanel panelRForbidden;
	private javax.swing.JPanel panelRMaximum;
	private javax.swing.JPanel panelROptions;
	private javax.swing.JPanel panelPhone;
	private javax.swing.JPanel panelText;
	private javax.swing.JPanel panelbClose;
	private javax.swing.JScrollPane scrollTVProgs1;
	private javax.swing.JScrollPane scrollTVProgs2;
	private javax.swing.JScrollPane scrollText;
	private javax.swing.JTabbedPane tabsTable;
	private javax.swing.JTextField phone;
	private javax.swing.JTextArea text;
	// End of variables declaration//GEN-END:variables
	private javax.swing.DefaultListModel<String> tvProgsList;

	// LIST USED TO IMPLEMENT THE SELECTION STRATEGY IN LISTS
	private List<TVProgram> tvProgrs = new ArrayList<TVProgram>();
	
	public SMSWindow(Controller controller) {
		this.controller = controller;
		initComponents();
		tvProgsList = new DefaultListModel<String>();
		tvProgsList1.setModel(tvProgsList);
		tvProgsList2.setModel(tvProgsList);
		this.setSize(800, 600);
		this.setVisible(true);
		this.centreWindow();		
	}

	private void initComponents() {// GEN-BEGIN:initComponents
		panelPrograms = new javax.swing.JPanel();
		panelListTvP1 = new javax.swing.JPanel();
		scrollTVProgs1 = new javax.swing.JScrollPane();
		tvProgsList1 = new javax.swing.JList<String>();
		panelbClose = new javax.swing.JPanel();
		buttonReport = new javax.swing.JButton();
		buttonCloseP = new javax.swing.JButton();
		panelControlP = new javax.swing.JPanel();
		tabsTable = new javax.swing.JTabbedPane();
		panelRMaximum = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		limit = new javax.swing.JTextField();
		buttonLimit = new javax.swing.JButton();
		panelROptions = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		options = new javax.swing.JTextField();
		buttonOptions = new javax.swing.JButton();
		panelRForbidden = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		forbiddenWords = new javax.swing.JTextField();
		buttonForbidden = new javax.swing.JButton();
		panelButtonsP1 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		acronym = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		description = new javax.swing.JTextField();
		buttonNewP = new javax.swing.JButton();
		panelMessages = new javax.swing.JPanel();
		panelListTvP2 = new javax.swing.JPanel();
		scrollTVProgs2 = new javax.swing.JScrollPane();
		tvProgsList2 = new javax.swing.JList<String>();
		panelControlM = new javax.swing.JPanel();
		panelPhone = new javax.swing.JPanel();
		jLabel9 = new javax.swing.JLabel();
		phone = new javax.swing.JTextField();
		panelText = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		scrollText = new javax.swing.JScrollPane();
		text = new javax.swing.JTextArea();
		panelButton = new javax.swing.JPanel();
		buttonSend = new javax.swing.JButton();

		getContentPane().setLayout(new java.awt.GridLayout(2, 1));

		setTitle("SMS Window");
		setName("SMS Window");
		setResizable(false);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				exitForm(evt);
			}
		});

		panelPrograms.setLayout(new java.awt.GridLayout(1, 2));
		panelPrograms.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "TV Program Section"));

		tvProgsList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		scrollTVProgs1.setPreferredSize(new java.awt.Dimension(100, 110));	
		scrollTVProgs1.setViewportView(tvProgsList1);
		
		panelListTvP1.setLayout(new java.awt.BorderLayout());
		panelListTvP1.setBorder(new javax.swing.border.TitledBorder("TV Program List"));
		panelListTvP1.add(scrollTVProgs1, java.awt.BorderLayout.CENTER);

		buttonReport.setText("Report");
		buttonReport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonReportActionPerformed(evt);
			}
		});

		panelbClose.add(buttonReport);

		buttonCloseP.setText("Close");
		buttonCloseP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonClosePActionPerformed(evt);
			}
		});

		panelbClose.add(buttonCloseP);
		panelListTvP1.add(panelbClose, java.awt.BorderLayout.SOUTH);
		panelPrograms.add(panelListTvP1);
		panelControlP.setLayout(new java.awt.BorderLayout());
		panelControlP.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.TitledBorder(""), "TV Program Settings"));
		jLabel3.setText("Message Limit:");
		panelRMaximum.add(jLabel3);

		limit.setColumns(5);
		panelRMaximum.add(limit);

		buttonLimit.setText("Add");
		buttonLimit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonLimitActionPerformed(evt);
			}
		});

		panelRMaximum.add(buttonLimit);

		tabsTable.addTab("Maximum #", panelRMaximum);

		jLabel2.setText("Options: ");
		panelROptions.add(jLabel2);

		options.setColumns(15);
		panelROptions.add(options);

		buttonOptions.setText("Add");
		buttonOptions.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonOptionsActionPerformed(evt);
			}
		});

		panelROptions.add(buttonOptions);

		tabsTable.addTab("Valid Options", panelROptions);

		jLabel1.setText("Words: ");
		panelRForbidden.add(jLabel1);

		forbiddenWords.setColumns(15);
		panelRForbidden.add(forbiddenWords);

		buttonForbidden.setText("Add");
		buttonForbidden.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonForbiddenActionPerformed(evt);
			}
		});

		panelRForbidden.add(buttonForbidden);

		tabsTable.addTab("Forbidden Words", panelRForbidden);

		panelControlP.add(tabsTable, java.awt.BorderLayout.CENTER);

		jLabel5.setText("Acron:");
		panelButtonsP1.add(jLabel5);

		acronym.setColumns(3);
		panelButtonsP1.add(acronym);

		jLabel4.setText("Desc:");
		panelButtonsP1.add(jLabel4);

		description.setColumns(10);
		panelButtonsP1.add(description);

		buttonNewP.setText("New");
		buttonNewP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonNewPActionPerformed(evt);
			}
		});

		panelButtonsP1.add(buttonNewP);
		panelControlP.add(panelButtonsP1, java.awt.BorderLayout.SOUTH);
		panelPrograms.add(panelControlP);
		getContentPane().add(panelPrograms);

		panelMessages.setLayout(new java.awt.GridLayout(1, 2));
		panelMessages.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Message Section")); 
		panelListTvP2.setLayout(new java.awt.BorderLayout());
		panelListTvP2.setBorder(new javax.swing.border.TitledBorder("Available TV Programs"));
		scrollTVProgs2.setPreferredSize(new java.awt.Dimension(100, 110));
		tvProgsList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tvProgsList2.setFocusable(false);
		tvProgsList2.setEnabled(false);
		scrollTVProgs2.setViewportView(tvProgsList2);
		panelListTvP2.add(scrollTVProgs2, java.awt.BorderLayout.CENTER);
		panelMessages.add(panelListTvP2);

		panelControlM.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.TitledBorder(""), "Message Sending"));
		panelPhone.setPreferredSize(new java.awt.Dimension(320, 100));
		jLabel9.setText("Phone #: ");
		jLabel9.setPreferredSize(new java.awt.Dimension(75, 16));
		panelPhone.add(jLabel9);

		phone.setColumns(20);
		phone.setPreferredSize(new java.awt.Dimension(90, 16));
		panelPhone.add(phone);

		panelControlM.add(panelPhone);

		panelText.setPreferredSize(new java.awt.Dimension(320, 60));
		jLabel6.setText("Text: ");
		jLabel6.setPreferredSize(new java.awt.Dimension(75, 16));
		panelText.add(jLabel6);

		text.setColumns(20);
		text.setLineWrap(true);
		text.setRows(3);
		scrollText.setViewportView(text);

		panelText.add(scrollText);

		panelControlM.add(panelText);

		panelButton.setPreferredSize(new java.awt.Dimension(320, 36));
		buttonSend.setText("Send");
		buttonSend.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonSendActionPerformed(evt);
			}
		});

		panelButton.add(buttonSend);
		panelControlM.add(panelButton);
		panelMessages.add(panelControlM);
		getContentPane().add(panelMessages);

		pack();
	}
	
	public void centreWindow() {
		Dimension dim = getToolkit().getScreenSize();
		Rectangle abounds = getBounds();
		setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
	}
	
	private void buttonNewPActionPerformed(ActionEvent evt) {
		String ac = acronym.getText().trim().toUpperCase();
		String des = description.getText().trim().toUpperCase();
		// Calling the Controller
		controller.newTVProgram(ac, des);
		TVProgram tvp = new TVProgram(ac, des);
		this.updateLists(tvp);
		this.cleanProgramDetails();
	}

	private void buttonSendActionPerformed(ActionEvent evt) {
		// Calling the Controller
		controller.sendMessage(phone.getText().trim().toUpperCase(), text.getText().trim().toUpperCase());
		this.cleanMessageDetails();
	}

	private void buttonReportActionPerformed(ActionEvent evt) {
	}

	private void buttonForbiddenActionPerformed(ActionEvent evt) {
	}

	private void buttonOptionsActionPerformed(ActionEvent evt) {
	}

	private void buttonLimitActionPerformed(ActionEvent evt) {
	}

	private void buttonClosePActionPerformed(ActionEvent evt) {
	}

	/** Exit the Application */
	private void exitForm(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_exitForm
		controller.exit();
	}


	// METHODS FOR DATA DISPLAY IN THE GUI WINDOW
	private void updateLists(TVProgram tvp) {
		tvProgrs.add(tvp);
		tvProgsList.clear();
		for (int i = 0; i < tvProgrs.size(); i++) {
			TVProgram p = (TVProgram) tvProgrs.get(i);
			tvProgsList.addElement(p.getAcronym() + " - " + p.getDescription());
		}
		tvProgsList1.setSelectedIndex(0);
	}

	private void cleanProgramDetails() {
		limit.setText("");
		options.setText("");
		forbiddenWords.setText("");
		description.setText("");
		acronym.setText("");
	}

	private void cleanMessageDetails() {
		phone.setText("");
		text.setText("");
	}
}