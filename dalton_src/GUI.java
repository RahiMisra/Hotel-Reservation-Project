import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GUI implements ActionListener {

	roomSearch roomtester = new roomSearch();
	// logintester = new login();
	roomRates rates = new roomRates();

	JFrame frame = new JFrame("Bug-Byte League Hotel");

	JPanel centerPanel = new JPanel();

	CardLayout cardlayout = new CardLayout();

	JComboBox<String> comboBoxForAllRoomsPanel;
	JComboBox<String> comboBoxForKingBedroomPanel;
	JComboBox<String> comboBoxForQueenBedroomPanel;
	JComboBox<String> comboBoxForSuiteBedroomPanel;
	private JButton dateSelectsBtn;
	private JButton kingBedrateBtn;
	private JButton queenBedrateBtn;
	private JButton suiteBedrateBtn;
	private final JButton confirmButton = new JButton("Confirm and Pay");
	private final JButton homebtn = new JButton("Home");
	private final JButton roomsbtn = new JButton("Rooms");
	private final JButton bookbtn = new JButton("Book");
	private final JButton kingBedButton = new JButton();
	private final JButton queenBedButton = new JButton();
	private final JButton suiteBedButton = new JButton();
	private JButton proceedBtn;

	private final JButton kingBedButton2 = new JButton();
	private final JButton queenBedButton2 = new JButton();
	private final JButton suiteBedButton2 = new JButton();
	private final String[] roomtype = { "all", "king", "queen", "suite" };

	private final ImageIcon kingBedImage = new ImageIcon("king.png");
	private final ImageIcon queenBedImage = new ImageIcon("queen.png");
	private final ImageIcon suiteBedImage = new ImageIcon("suitecover.png");
	private ImageIcon image;
	private ImageIcon image2;
	private ImageIcon image3;
	private ImageIcon image4;
	private ImageIcon image5;

	private final TextField searchbar = new TextField(20);
	private final JButton searchbtn = new JButton("Search");
	private JTextField usernameTextFiled = new JTextField();
	private JPasswordField passwrdtextfield = new JPasswordField();

	private final JButton loginOrRegisterbtn = new JButton("Log In/Register");
	private final JButton logInbtn = new JButton("Log In");
	private final JButton forgotPasswordbtn = new JButton("Forgot Password");

	private final JButton registerBtn = new JButton("Register");
	private final JButton logoutbtn = new JButton("Log Out");
	private String Panelmanipulation = "logout";

	JTextField kingratefield = new JTextField();
	JTextField queenratefield = new JTextField();
	JTextField suiteratefield = new JTextField();

	private String username;
	private String password;
	private int roomNumber;
	JTextField checkinTextFiled = new JTextField();
	JTextField checkoutTextField = new JTextField();
	String[] num = { "1", "2", "3", "4" };
	JComboBox<String> guestnum = new JComboBox<>(num);

	public GUI() {

		JPanel MainPanel = new JPanel(new BorderLayout(8, 6));

		centerPanel.setLayout(cardlayout);
		centerPanel.add(homePanel(), "home");
		centerPanel.add(AllroomsPannel(), "allrooms");
		centerPanel.add(kingOnlyPannel(), "kingroom");
		centerPanel.add(queenOnlyPannel(), "queenroom");
		centerPanel.add(suiteOnlyPannel(), "suiteroom");
		centerPanel.add(SelectDatePanel(), "datePanel");
		centerPanel.add(ratesPanel(), "rates");
		centerPanel.add(reservationDetailPanel(), "summaryPanel");
		centerPanel.add(UserInfoAndPaymentPanel(), "infoPanel");
		centerPanel.add(completedReservationPanel(), "completedReservationPanel");
		centerPanel.add(logInOrRegisterPanel(), Panelmanipulation);
		centerPanel.add(accountPanel(), "account");

		MainPanel.setBackground(Color.green);

		MainPanel.add(TopPanel(), BorderLayout.NORTH);
		MainPanel.add(centerPanel, BorderLayout.CENTER);

		frame.add(MainPanel);
		frame.pack();
		frame.setSize(1025, 1000);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public JPanel TopPanel() {
		// Panel Top
		JPanel topPanel = new JPanel();

		topPanel.setBackground(Color.ORANGE);
		topPanel.setLayout(new FlowLayout(5));
		topPanel.add(homebtn);
		topPanel.add(roomsbtn);
		topPanel.add(bookbtn);
		topPanel.add(loginOrRegisterbtn);
		topPanel.add(searchbar);
		topPanel.add(searchbtn);

		homebtn.addActionListener(this);
		roomsbtn.addActionListener(this);
		bookbtn.addActionListener(this);
		searchbtn.addActionListener(this);
		loginOrRegisterbtn.addActionListener(this);

		return topPanel;
	}

	public JPanel homePanel() {
		JPanel home = new JPanel();
		JLabel homelbl = new JLabel("Welcome to the Bug-Byte League Hotel, we hope you enjoy your stay!");
		home.add(homelbl);

		return home;

	}

	public JPanel ratesPanel() {
		// kingratefield.setText("king bedroom rate $"+ rates.getKingBedroomPrice());
		// queenratefield.setText("queen bedroom rate $"+ rates.getQueenBedroomPrice());
		// suiteratefield.setText("suite bedroom rate $"+ rates.getSuiteBedroomPrice());

		kingratefield.setEditable(false);
		queenratefield.setEditable(false);
		suiteratefield.setEditable(false);
		ImageIcon kingRateImage = new ImageIcon("kingrate.png");
		ImageIcon queenRateImage = new ImageIcon("queenrate.png");
		ImageIcon suiterateimage = new ImageIcon("suiterate.png");
		JLabel kingimage = new JLabel();
		JLabel queenimage = new JLabel();
		JLabel suiteimage = new JLabel();
		kingimage.setIcon(kingRateImage);
		queenimage.setIcon(queenRateImage);
		suiteimage.setIcon(suiterateimage);
		JPanel grid = new JPanel(new GridLayout(3, 2, 10, 120));
		JPanel ratesPanel = new JPanel();
		ratesPanel.setLayout(null);

		kingBedrateBtn = new JButton("Select");
		queenBedrateBtn = new JButton("Select");
		suiteBedrateBtn = new JButton("Select");
		kingimage.setBounds(150, 150, 200, 200);
		queenimage.setBounds(150, 300, 200, 200);
		suiteimage.setBounds(150, 450, 200, 200);
		ratesPanel.add(kingimage);
		ratesPanel.add(queenimage);
		ratesPanel.add(suiteimage);
		ratesPanel.add(kingimage);
		grid.setBounds(400, 250, 400, 300);

		grid.add(kingratefield);
		grid.add(kingBedrateBtn);

		grid.add(queenratefield);
		grid.add(queenBedrateBtn);

		grid.add(suiteratefield);
		grid.add(suiteBedrateBtn);
		ratesPanel.add(grid);
		kingBedrateBtn.addActionListener(this);
		queenBedrateBtn.addActionListener(this);
		suiteBedrateBtn.addActionListener(this);

		return ratesPanel;

	}

	public JPanel logInOrRegisterPanel() {
		JPanel Panel = new JPanel(new GridLayout(3, 2));
		JPanel loginOrRegPanel = new JPanel();
		loginOrRegPanel.setLayout(null);

		JLabel emailaddr = new JLabel("Username: ");
		JLabel userpasswordlbl = new JLabel("Password: ");

		registerBtn.setBounds(205, 500, 100, 50);
		Panel.setBounds(205, 150, 250, 100);
		Panel.add(emailaddr);
		Panel.add(usernameTextFiled);
		Panel.add(userpasswordlbl);
		Panel.add(passwrdtextfield);
		Panel.add(logInbtn);
		Panel.add(forgotPasswordbtn);
		loginOrRegPanel.add(registerBtn);
		logInbtn.addActionListener(this);

		loginOrRegPanel.add(Panel);
		return loginOrRegPanel;

	}

	public JPanel accountPanel() {
		JPanel reservationsPanel = new JPanel();
		reservationsPanel.add(logoutbtn);
		logoutbtn.addActionListener(this);

		return reservationsPanel;

	}

	public JPanel SelectDatePanel() {

		JPanel gridPanel = new JPanel(new GridLayout(6, 1));

		JPanel datePanel = new JPanel();
		datePanel.setLayout(null);

		JLabel numberOfGuest = new JLabel("Number of Guests:");
		JLabel checkindate = new JLabel("Check in Date: ");
		JLabel checkoutdate = new JLabel("Checkout Date: ");

		dateSelectsBtn = new JButton("See Available Rooms");

		gridPanel.setBounds(205, 150, 350, 170);
		gridPanel.add(numberOfGuest);
		gridPanel.add(guestnum);
		gridPanel.add(checkindate);
		gridPanel.add(checkindate);
		gridPanel.add(checkinTextFiled);
		gridPanel.add(checkoutdate);
		gridPanel.add(checkoutTextField);
		gridPanel.add(dateSelectsBtn);
		datePanel.add(gridPanel);
		dateSelectsBtn.addActionListener(this);

		return datePanel;
	}

	public JPanel reservationDetailPanel() {
		JPanel gdpanel = new JPanel(new GridLayout(4, 1));
		JPanel detailPanel = new JPanel();
		detailPanel.setLayout(null);
		JLabel reservationlbl = new JLabel("Room Reservation Details");
		proceedBtn = new JButton("Proceed to Payment");

		gdpanel.setBounds(205, 150, 300, 200);

		gdpanel.add(reservationlbl);
		gdpanel.add(proceedBtn);
		detailPanel.add(gdpanel);
		proceedBtn.addActionListener(this);

		return detailPanel;

	}

	public JPanel UserInfoAndPaymentPanel() {
		JPanel gridPanel = new JPanel(new GridLayout(17, 1, 10, 10));
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(null);

		JLabel firstNamelnl = new JLabel("First Name: ");
		JLabel lastNamelbl = new JLabel("Last Name: ");
		JLabel emailAdrrLbl = new JLabel("Email Address: ");
		JLabel passwordLabel = new JLabel("Password: ");
		JLabel phoneNumberlbl = new JLabel("Phone Number: ");
		JLabel NameOnCardLbl = new JLabel("Name on Card: ");
		JLabel CardNumberLbl = new JLabel("Card Number: ");
		JLabel ExperationDateLbl = new JLabel("Expiration Date:");
		JLabel CVCnumberLbl = new JLabel("CVC Code: ");
		JLabel billingAddressLbl = new JLabel("Billing Address: ");
		JLabel shippingAddressLbl = new JLabel("Shipping Address: ");

		JTextField firstnameTextfield = new JTextField();
		JTextField lastnameTextfield = new JTextField();
		JPasswordField emailTextfield = new JPasswordField();
		JTextField passwordTextField = new JTextField();
		JTextField phoneTextfield = new JTextField();
		JTextField NameOnCardtextfield = new JTextField();
		JPasswordField CardNumberTextField = new JPasswordField();
		JTextField ExperactionDatetextfield = new JTextField();
		JTextField CVCnumbertextfield = new JTextField();
		JTextField billingAddressTextField = new JTextField();
		JTextField shippingAddressTextField = new JTextField();

		String firstNameText = firstnameTextfield.getText();
		String lastNameText = lastnameTextfield.getText();
		char[] emailCharText = emailTextfield.getPassword();
		String emailText = new String(emailCharText);
		char[] passwordCharText = CardNumberTextField.getPassword();
		String passwordText = passwordTextField.getText();
		String phoneNumberText = phoneTextfield.getText();
		String cardNameText = NameOnCardtextfield.getText();
		String cardNumberText = new String(passwordCharText);
		String expirationText = ExperactionDatetextfield.getText();
		String cvcText = CVCnumbertextfield.getText();
		String billingAddressText = billingAddressTextField.getText();
		String shippingAddressText = shippingAddressTextField.getText();

		UserInfo tempUser = new UserInfo(firstNameText, lastNameText, emailText, passwordText, phoneNumberText);
		PaymentInfo tempPaymentInfo = new PaymentInfo(cardNameText, cardNumberText, cvcText, expirationText,
				billingAddressText, shippingAddressText);

		gridPanel.setBounds(205, 150, 300, 500);

		gridPanel.add(firstNamelnl);
		gridPanel.add(firstnameTextfield);
		gridPanel.add(lastNamelbl);
		gridPanel.add(lastnameTextfield);
		gridPanel.add(passwordLabel);
		gridPanel.add(passwordTextField);
		gridPanel.add(emailAdrrLbl);
		gridPanel.add(emailTextfield);
		gridPanel.add(phoneNumberlbl);
		gridPanel.add(phoneTextfield);
		gridPanel.add(NameOnCardLbl);
		gridPanel.add(NameOnCardtextfield);
		gridPanel.add(CardNumberLbl);
		gridPanel.add(CardNumberTextField);
		gridPanel.add(ExperationDateLbl);
		gridPanel.add(ExperactionDatetextfield);
		gridPanel.add(CVCnumberLbl);
		gridPanel.add(CVCnumbertextfield);
		gridPanel.add(billingAddressLbl);
		gridPanel.add(billingAddressTextField);
		gridPanel.add(shippingAddressLbl);
		gridPanel.add(shippingAddressTextField);
		gridPanel.add(confirmButton);
		infoPanel.add(gridPanel);

		confirmButton.addActionListener(this);

		return infoPanel;
	}

	public JPanel completedReservationPanel() {
		JPanel completPanel = new JPanel();
		JLabel congratsOnResvLbl = new JLabel("resevation placed");
		completPanel.setLayout(null);
		congratsOnResvLbl.setBounds(100, 500, 200, 35);
		completPanel.add(congratsOnResvLbl);

		return completPanel;
	}

	private JPanel AllroomsPannel() {
		JPanel panelAllRooms = new JPanel();
		// labels
		kingBedButton2.setText("KING Bedroom");
		queenBedButton2.setText("Queen Bedroom");
		suiteBedButton2.setText("suite");
		JLabel kinglabel = new JLabel();
		JLabel queenlabel = new JLabel();
		JLabel suitelabel = new JLabel();
		JLabel kingDescriptionLabel = new JLabel("<html>364 square feet of space<br>One King size bed <br>"
				+ " 55 inch LED high definition television<br> In-room safe<br>Sofa<br>Maximum occupancy: 2 </html>");
		JLabel queenDescriptionLaabel = new JLabel("<html>364 square feet of space<br>two Queen beds <br>"
				+ " 55 inch LED high definition television<br> In-room safe<br>Maximum occupancy: 4 </html>");
		JLabel suiteDescriptionLabel = new JLabel(
				"<html>756 square feet of space<br>Separated living and sleeping area<br>One King size bed <br>"
						+ " 55 inch LED high definition television<br> In-room safe<br>Wireless Internet access<br>Sofa and seating area for 4 </html>");
		// get room images
		kinglabel.setIcon(kingBedImage);
		queenlabel.setIcon(queenBedImage);
		suitelabel.setIcon(suiteBedImage);
		comboBoxForAllRoomsPanel = new JComboBox<>(roomtype);

		// combobox
		comboBoxForAllRoomsPanel.setSelectedIndex(0);

		// bounds
		comboBoxForAllRoomsPanel.setBounds(800, 0, 100, 50);
		kingBedButton2.setBounds(265, 275, 100, 15);
		queenBedButton2.setBounds(225, 575, 150, 15);
		suiteBedButton2.setBounds(225, 875, 150, 15);
		kinglabel.setBounds(100, 0, 500, 280);
		queenlabel.setBounds(100, 200, 500, 475);
		suitelabel.setBounds(100, 495, 500, 500);
		kingDescriptionLabel.setBounds(600, 0, 500, 300);
		queenDescriptionLaabel.setBounds(600, 200, 500, 500);
		suiteDescriptionLabel.setBounds(600, 500, 500, 500);
		panelAllRooms.setBackground(new Color(255, 218, 185));

		// add buttons, box, and description label to panel
		panelAllRooms.add(kingBedButton2);
		panelAllRooms.add(queenBedButton2);
		panelAllRooms.add(suiteBedButton2);
		panelAllRooms.add(kinglabel);
		panelAllRooms.add(queenlabel);
		panelAllRooms.add(suitelabel);
		panelAllRooms.add(kingDescriptionLabel);
		panelAllRooms.add(queenDescriptionLaabel);
		panelAllRooms.add(suiteDescriptionLabel);
		panelAllRooms.add(comboBoxForAllRoomsPanel);

		panelAllRooms.setLayout(null);

		// action listeners
		kingBedButton2.addActionListener(this);
		queenBedButton2.addActionListener(this);
		suiteBedButton2.addActionListener(this);
		comboBoxForAllRoomsPanel.addActionListener(this);

		return panelAllRooms;
	}

	private JPanel kingOnlyPannel() {
		JPanel panelkingOnly = new JPanel();
		// labels
		JLabel kinglabel = new JLabel();

		JLabel kingDescriptionLaabel = new JLabel("<html>364 square feet of space<br>king bed <br>"
				+ " 55 inch LED high definition television<br> In-room safe<br>Maximum occupancy: 2 </html>");

		// get image for kingbedroom
		kinglabel.setIcon(kingBedImage);

		// combobox for king panel
		comboBoxForKingBedroomPanel = new JComboBox<>((roomtype));
		comboBoxForKingBedroomPanel.setSelectedIndex(1);
		// bounds
		comboBoxForKingBedroomPanel.setBounds(800, 0, 100, 50);
		kingBedButton.setBounds(265, 285, 125, 25);
		kinglabel.setBounds(100, 0, 500, 300);
		kingDescriptionLaabel.setBounds(600, 0, 500, 300);
		panelkingOnly.setBackground(new Color(255, 218, 185));

		kingBedButton.setText("king Bedroom");

		// add to panel
		panelkingOnly.add(kingBedButton);
		panelkingOnly.add(kinglabel);
		panelkingOnly.add(kingDescriptionLaabel);
		panelkingOnly.add(comboBoxForKingBedroomPanel);

		panelkingOnly.setLayout(null);

		// action listeners
		kingBedButton.addActionListener(this);
		comboBoxForKingBedroomPanel.addActionListener(this);

		return panelkingOnly;

	}

	private JPanel queenOnlyPannel() {
		JPanel panelQueenOnly = new JPanel();
		// labels

		JLabel queenlabel = new JLabel();
		JLabel queenDescriptionLaabel = new JLabel("<html>364 square feet of space<br>two Queen beds <br>"
				+ " 55 inch LED high definition television<br> In-room safe<br>Maximum occupancy: 4 </html>");
		queenlabel.setIcon(queenBedImage);
		// combobox
		comboBoxForQueenBedroomPanel = new JComboBox<>((roomtype));
		comboBoxForQueenBedroomPanel.setSelectedIndex(2);

		// bounds
		comboBoxForQueenBedroomPanel.setBounds(800, 0, 100, 50);
		queenBedButton.setBounds(265, 285, 125, 25);
		queenlabel.setBounds(100, 0, 500, 300);
		queenDescriptionLaabel.setBounds(600, 0, 500, 300);
		panelQueenOnly.setBackground(new Color(255, 218, 185));

		// button & add to panel
		queenBedButton.setText("Queen Bedroom");
		panelQueenOnly.add(queenBedButton);

		panelQueenOnly.setLayout(null);

		panelQueenOnly.add(queenlabel);
		panelQueenOnly.add(queenDescriptionLaabel);
		panelQueenOnly.add(comboBoxForQueenBedroomPanel);

		// listeners
		queenBedButton.addActionListener(this);
		comboBoxForQueenBedroomPanel.addActionListener(this);

		return panelQueenOnly;

	}

	private JPanel suiteOnlyPannel() {
		JPanel panelSuiteOnly = new JPanel();
		// labels
		JLabel suitelabel = new JLabel();

		JLabel suiteDescriptionLabel = new JLabel(
				"<html>756 square feet of space<br>Separated living and sleeping area<br>One King size bed <br>"
						+ " 55 inch LED high definition television<br> In-room safe<br>Wireless Internet access<br>Sofa and seating area for 4 </html>");

		// combobox for suite panel
		comboBoxForSuiteBedroomPanel = new JComboBox<>(roomtype);
		comboBoxForSuiteBedroomPanel.setSelectedIndex(3);
		// bounds
		comboBoxForSuiteBedroomPanel.setBounds(800, 0, 100, 50);
		suitelabel.setBounds(100, 0, 500, 300);
		panelSuiteOnly.setBackground(new Color(255, 218, 185));
		suiteDescriptionLabel.setBounds(600, 0, 500, 300);
		suiteBedButton.setBounds(265, 285, 125, 25);

		// adding buttons,box, descriptions to panel
		suiteBedButton.setText("suite");
		panelSuiteOnly.add(suiteBedButton);
		suitelabel.setIcon(suiteBedImage);
		// add combobox to suite panel
		panelSuiteOnly.add(comboBoxForSuiteBedroomPanel);
		panelSuiteOnly.add(suitelabel);
		panelSuiteOnly.add(suiteDescriptionLabel);

		panelSuiteOnly.setLayout(null);

		// action listeners
		suiteBedButton.addActionListener(this);

		comboBoxForSuiteBedroomPanel.addActionListener(this);

		return panelSuiteOnly;
	}

	public void RoomChoice(String name) {

		JFrame popUpRoomTypeFrame = new JFrame("ROOMS");
		JPanel panel = new JPanel();

		if (name.equals("king")) {
			image = new ImageIcon("kingbedroom.png");
			image2 = new ImageIcon("kingbedroom2.png");
			image3 = new ImageIcon("kingrestroom.png");
			image4 = new ImageIcon("kingrestroom2.png");
		}
		if (name.equals("queen")) {
			image = new ImageIcon("queenbedroom.png");
			image2 = new ImageIcon("queenbedroom2.png");
			image3 = new ImageIcon("queenrestroom.png");
			image4 = new ImageIcon("queenrestroom2.png");
		}
		if (name.equals("suite")) {
			image = new ImageIcon("suitebedroom.png");
			image2 = new ImageIcon("suitebedroom2.png");
			image3 = new ImageIcon("suitelivingarea.png");
			image4 = new ImageIcon("suitelivingarea2.png");
			image5 = new ImageIcon("suiterestroom.png");

		}

		JLabel label = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		JLabel label4 = new JLabel();

		label.setIcon(image);
		label2.setIcon(image2);
		label3.setIcon(image3);
		label4.setIcon(image4);

		panel.add(label);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		if (name.equals("suite")) {
			JLabel label5 = new JLabel();
			label5.setIcon(image5);
			panel.add(label5);
		}

		panel.setPreferredSize(new Dimension(1000, 2800));

		JScrollPane scrollPane = new JScrollPane(panel);

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		popUpRoomTypeFrame.getContentPane().add(scrollPane);
		popUpRoomTypeFrame.setSize(800, 750);
		popUpRoomTypeFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// switch pannels base on selection
		if (e.getSource() == homebtn) {
			cardlayout.show(centerPanel, "home");
		} else if (e.getSource() == roomsbtn) {
			cardlayout.show(centerPanel, "allrooms");
		} else if (e.getSource() == bookbtn) {
			cardlayout.show(centerPanel, "datePanel");
		}
		if (e.getSource() == dateSelectsBtn) {

			try {
				LocalDate currentDate = LocalDate.now();
				LocalDate Indate = LocalDate.parse(checkinTextFiled.getText());
				LocalDate Outdate = LocalDate.parse(checkoutTextField.getText());
				int dateCompareCheckinToCurrent = Indate.compareTo(currentDate);
				int dateComapreCheckoutToIn = Outdate.compareTo(Indate);
				if (dateCompareCheckinToCurrent < 0 || dateComapreCheckoutToIn < 0 || dateComapreCheckoutToIn == 0) {
					JOptionPane.showMessageDialog(frame, "date passed or checkout<checkin or equal dates");
				} else {
					roomtester.setCheckInCheckOut(Indate, Outdate);
					if (roomtester.checkForAllroomTypes()) {

						cardlayout.show(centerPanel, "rates");

					} else {
						JOptionPane.showMessageDialog(frame, "no rooms available for dates selected");
					}

				}

			} catch (DateTimeParseException ex) {
				JOptionPane.showMessageDialog(frame, "no date entered or bad input");
			}

		}

		if (roomtester.checkForIndividalroom("king")) {
			kingBedrateBtn.setText("select");
			if (e.getSource() == kingBedrateBtn) {
				roomtester.setroomchoice(1);
				cardlayout.show(centerPanel, "summaryPanel");

			}
		} else
			kingBedrateBtn.setText("out");

		if (roomtester.checkForIndividalroom("queen")) {
			queenBedrateBtn.setText("select");
			if (e.getSource() == queenBedrateBtn) {
				roomtester.setroomchoice(2);
				cardlayout.show(centerPanel, "summaryPanel");

			}
		} else
			queenBedrateBtn.setText("out");

		if (roomtester.checkForIndividalroom("suite")) {
			suiteBedrateBtn.setText("select");
			if (e.getSource() == suiteBedrateBtn) {
				roomtester.setroomchoice(3);
				cardlayout.show(centerPanel, "summaryPanel");

			}
		} else
			suiteBedrateBtn.setText("out");

		// for when user wants to see more photos of roomtype
		if (e.getSource() == kingBedButton2) {

			RoomChoice("king");
		} else if (e.getSource() == queenBedButton2) {

			RoomChoice("queen");
		} else if (e.getSource() == suiteBedButton2) {

			RoomChoice("suite");
		} else if (e.getSource() == kingBedButton) {

			RoomChoice("king");
		} else if (e.getSource() == queenBedButton) {

			RoomChoice("queen");
		} else if (e.getSource() == suiteBedButton) {

			RoomChoice("suite");
		}

		// combobox listeners, dropdown room view choice.
		if (e.getSource() == comboBoxForAllRoomsPanel) {
			if (comboBoxForAllRoomsPanel.getSelectedIndex() == 0) {
				cardlayout.show(centerPanel, "allrooms");
				// comboBox.setSelectedIndex(0);
			} else if (comboBoxForAllRoomsPanel.getSelectedIndex() == 1) {
				cardlayout.show(centerPanel, "kingroom");
				comboBoxForAllRoomsPanel.setSelectedIndex(0);
			} else if (comboBoxForAllRoomsPanel.getSelectedIndex() == 2) {
				cardlayout.show(centerPanel, "queenroom");
				comboBoxForAllRoomsPanel.setSelectedIndex(0);
			} else if (comboBoxForAllRoomsPanel.getSelectedIndex() == 3) {
				cardlayout.show(centerPanel, "suiteroom");
				comboBoxForAllRoomsPanel.setSelectedIndex(0);
			}

		} else if (e.getSource() == comboBoxForKingBedroomPanel) {
			if (comboBoxForKingBedroomPanel.getSelectedIndex() == 0) {
				cardlayout.show(centerPanel, "allrooms");
				comboBoxForKingBedroomPanel.setSelectedIndex(1);
			} else if (comboBoxForKingBedroomPanel.getSelectedIndex() == 1) {
				cardlayout.show(centerPanel, "kingroom");
				comboBoxForKingBedroomPanel.setSelectedIndex(1);
			} else if (comboBoxForKingBedroomPanel.getSelectedIndex() == 2) {
				cardlayout.show(centerPanel, "queenroom");
				comboBoxForKingBedroomPanel.setSelectedIndex(1);
			} else if (comboBoxForKingBedroomPanel.getSelectedIndex() == 3) {
				cardlayout.show(centerPanel, "suiteroom");
				comboBoxForKingBedroomPanel.setSelectedIndex(1);
			}

		} else if (e.getSource() == comboBoxForQueenBedroomPanel) {
			if (comboBoxForQueenBedroomPanel.getSelectedIndex() == 0) {
				cardlayout.show(centerPanel, "allrooms");
				comboBoxForQueenBedroomPanel.setSelectedIndex(2);
			} else if (comboBoxForQueenBedroomPanel.getSelectedIndex() == 1) {
				cardlayout.show(centerPanel, "kingroom");
				comboBoxForQueenBedroomPanel.setSelectedIndex(2);
			} else if (comboBoxForQueenBedroomPanel.getSelectedIndex() == 2) {
				cardlayout.show(centerPanel, "queenroom");
				comboBoxForQueenBedroomPanel.setSelectedIndex(2);
			} else if (comboBoxForQueenBedroomPanel.getSelectedIndex() == 3) {
				cardlayout.show(centerPanel, "suiteroom");
				comboBoxForQueenBedroomPanel.setSelectedIndex(2);
			}

		} else if (e.getSource() == comboBoxForSuiteBedroomPanel) {
			if (comboBoxForSuiteBedroomPanel.getSelectedIndex() == 0) {
				cardlayout.show(centerPanel, "allrooms");
				comboBoxForSuiteBedroomPanel.setSelectedIndex(3);
			} else if (comboBoxForSuiteBedroomPanel.getSelectedIndex() == 1) {
				cardlayout.show(centerPanel, "kingroom");
				comboBoxForSuiteBedroomPanel.setSelectedIndex(3);
			} else if (comboBoxForSuiteBedroomPanel.getSelectedIndex() == 2) {
				cardlayout.show(centerPanel, "queenroom");
				comboBoxForSuiteBedroomPanel.setSelectedIndex(3);
			} else if (comboBoxForSuiteBedroomPanel.getSelectedIndex() == 3) {
				cardlayout.show(centerPanel, "suiteroom");
				comboBoxForSuiteBedroomPanel.setSelectedIndex(3);
			}

		}
		// button selections
		if (e.getSource() == proceedBtn) {
			cardlayout.show(centerPanel, "infoPanel");
		}

		if (e.getSource() == loginOrRegisterbtn) {

			cardlayout.show(centerPanel, Panelmanipulation);
		}
		if (e.getSource() == logInbtn) {
			username = "abc";
			password = "123";

			if (username.equals(usernameTextFiled.getText()) && password.equals(passwrdtextfield.getText())) {
				usernameTextFiled.setText("");
				passwrdtextfield.setText("");
				cardlayout.show(centerPanel, "account");
				loginOrRegisterbtn.setText("account");
				Panelmanipulation = "account";
			} else {
				JOptionPane.showMessageDialog(frame,
						"wrong ussername or password to test login use username:abc password:123");

			}

		}
		if (e.getSource() == logoutbtn) {
			Panelmanipulation = "logout";
			loginOrRegisterbtn.setText("log in/register");
			cardlayout.show(centerPanel, "home");
		}
		if (e.getSource() == searchbtn) {

			if (searchbar.getText().toLowerCase().contains("king")) {
				cardlayout.show(centerPanel, "kingroom");
			} else if (searchbar.getText().toLowerCase().contains("queen")) {
				cardlayout.show(centerPanel, "queenroom");
			} else if (searchbar.getText().toLowerCase().contains("suite")) {
				cardlayout.show(centerPanel, "suiteroom");

			}
		}
		if (e.getSource() == confirmButton) {
			roomtester.reserveRoom(roomtester.getroomtypeChoice());

			cardlayout.show(centerPanel, "completedReservationPanel");
		}

	}

	public static void main(String[] args) {
		GUI h = new GUI();

	}
}