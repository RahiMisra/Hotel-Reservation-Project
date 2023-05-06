import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.io.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class GUI implements ActionListener {
    //default constructor for Reservation needed
    private Reservation reservation = new Reservation();
    private final roomSearch getRatesFromRoomSrch = roomSearch.getInstance();


    private final JFrame frame = new JFrame("hotel");

    private final JPanel centerPanel = new JPanel();


    private final CardLayout cardlayout = new CardLayout();


    private  JButton dateSelectsBtn;
    private JButton kingBedrateBtn;
    private JButton queenBedrateBtn;
    private JButton suiteBedrateBtn;
    private final JButton payAsGuestButton = new JButton("confirm and pay");
    private final JButton homebtn = new JButton("home");
    private final JButton roomsbtn = new JButton("rooms");
    private final JButton bookbtn = new JButton("book");



    private JButton proceedBtn;
    private final JButton completeReservationAsMemberButton = new JButton("pay");
    private final JTextArea cartTextArea = new JTextArea();


    private final String[] roomtype = {"all","king","queen","suite"};

    private final ImageIcon kingBedImage = new ImageIcon( getClass().getResource("images/king.png"));
    private final ImageIcon  queenBedImage = new ImageIcon(getClass().getResource("images/queen.png"));
    private final ImageIcon suiteBedImage = new ImageIcon(getClass().getResource("images/suitecover.png"));
    private ImageIcon image;
    private ImageIcon image2;
    private ImageIcon image3;
    private ImageIcon image4;
    private ImageIcon image5;
    private JPanel btnPanel = new JPanel();

    private final JButton kingbedbutton = new JButton();
    private final JButton queenbedbutton = new JButton();
    private final JButton suitebedbutton = new JButton();
    private boolean isLogin = false;
    private GridBagConstraints gridbagConCart = new GridBagConstraints();
    private JButton cartloginBtn = new JButton("Login");

    private boolean camefromSummaryPanel = false;
    private JButton adminLogOutbtn;
    private JLabel kinglabel;
    private JLabel queenlabel;
    private JLabel suitelabel ;


    private final TextField searchbar = new TextField(20);
    private final JButton searchbtn = new JButton("search");
    private final JTextField usernameTextFiled = new JTextField();
    private final JPasswordField passwrdtextfield = new JPasswordField();

    private JPanel detailsPanel = new JPanel();

    private final JButton loginOrRegisterbtn = new JButton("log in/register");



    private  final JButton registerBtn = new JButton("register");
    private  final JButton logoutbtn = new JButton("log out");


    private JTextField kingratefield = new JTextField();
    private JTextField queenratefield = new JTextField();
    private JTextField suiteratefield = new JTextField();

    private JTextField checkinTextFiled = new JTextField();
    private JTextField checkoutTextField = new JTextField();
    private String[] num = {"1","2","3","4"};
    private JComboBox<String> partySizeComboBox = new JComboBox<>(num);
    private GridBagConstraints gridbagCon = new GridBagConstraints();
    private JPanel roomsPanel = new JPanel();
    private JComboBox<String> roomComboBox;
    private JTextArea guestListTextArea;
    private JTextField adminNameTextfield;
    private JPasswordField adminLoginTextfield;

    private JButton adminLoginBtn;
    private JTextArea completedReservationTextArea;
    private JTextArea accountTextArea;
    private int numberOfRoomClicks = 0;
    private  JTextField firstnameTextfield = new JTextField();
    private JTextField lastnameTextfield = new JTextField();
    private JTextField emailTextfield = new JTextField();
    private JTextField phoneTextfield = new JTextField();
    private JTextField NameOnCardtextfield = new JTextField();
    private JPasswordField CardNumberTextField = new JPasswordField();
    private JTextField ExperactionDatetextfield = new JTextField();
    private  JPasswordField CVCnumbertextfield = new JPasswordField();
    private  JTextField addressTextfield = new JTextField();
    private JTextField cityTextField = new JTextField();
    private  JTextField stateTextField = new JTextField();
    private  JTextField zipcodeTextField = new JTextField();
    private JButton loginButton, createAccountButton, contactStaffButton;
    private JLabel welcomeLabel, usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton UpcomingReservationsButton = new JButton("Upcoming Reservations");
    private JButton logOutButtonEditAccount = new JButton("LogOut");


    public GUI(){


        JPanel MainPanel = new JPanel(new BorderLayout(8,6));


        centerPanel.setLayout(cardlayout);
        centerPanel.add(homePanel(),"home");
        centerPanel.add(new JScrollPane(RoomsPanel()),"allrooms");
        centerPanel.add(SelectDatePanel(),"datePanel");
        centerPanel.add(new JScrollPane(ratesPanel()),"rates");
        centerPanel.add(CartSummaryPanel(),"summaryPanel");
        centerPanel.add(new JScrollPane(UserInfoAndPaymentPanel()) ,"infoPanel");
        centerPanel.add(completedReservationPanel(),"completedReservationPanel");
        centerPanel.add(HotelReservationSystem(),"logInOrRegister");
        centerPanel.add(accountPanel(),"UpcomingReservations");
        centerPanel.add(GuestList(), "guestList");
        centerPanel.add(adminLogin(),"addminLogin");






        MainPanel.setBackground (Color.darkGray);



        MainPanel.add(TopPanel(), BorderLayout.NORTH);
        MainPanel.add(centerPanel,BorderLayout.CENTER);

        frame.add(MainPanel);
        frame.pack();
        frame.setSize(1025, 500);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    private JPanel TopPanel(){
        //Panel Top
        JPanel topPanel = new JPanel();

        topPanel.setBackground (Color.lightGray);
        topPanel.setLayout (new FlowLayout (5));
        topPanel.add(homebtn);
        topPanel.add(roomsbtn);
        topPanel.add(bookbtn);
        topPanel.add(loginOrRegisterbtn);
        topPanel.add(searchbar);
        topPanel.add(searchbtn);
        homebtn.addActionListener(this);
        roomsbtn.addActionListener(this);
        bookbtn.addActionListener(this);
        loginOrRegisterbtn.addActionListener(this);
        searchbtn.addActionListener(this);

        return topPanel;
    }
    private JPanel homePanel(){
        JPanel home = new JPanel();
        JLabel homelbl = new JLabel("welcome ");
        home.add(homelbl);

        return home;

    }
    private JPanel adminLogin(){

        adminLoginBtn = new JButton("log-in");
        adminNameTextfield = new JTextField();
        adminLoginTextfield = new JPasswordField();
        adminNameTextfield.setPreferredSize(new Dimension(200, adminNameTextfield.getPreferredSize().height));
        adminLoginTextfield.setPreferredSize(new Dimension(200, adminLoginTextfield.getPreferredSize().height));






        JPanel addminLoginPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();


        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        addminLoginPanel.add(new JLabel("user "), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        addminLoginPanel.add(adminNameTextfield, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        addminLoginPanel.add(new JLabel("password "), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        addminLoginPanel.add(adminLoginTextfield, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        addminLoginPanel.add(adminLoginBtn, gridBagConstraints);





        adminLoginBtn.addActionListener(this);
        return addminLoginPanel;


    }
    private JPanel GuestList(){
        JPanel guestList = new JPanel();
        guestListTextArea = new JTextArea();
        guestListTextArea.setEditable(false);
        JScrollPane scrollPane  = new JScrollPane(guestListTextArea);
        adminLogOutbtn = new JButton("log-out");

        guestList.setLayout(new GridBagLayout());
        //guestListTextArea.setPreferredSize(new Dimension(426, 279));
        scrollPane.setPreferredSize(new Dimension(400, 300));


        JLabel guestSummaryLabel = new JLabel("Guest List");


        gridbagConCart.gridx = 0;
        gridbagConCart.gridy=0;
        gridbagConCart.anchor = GridBagConstraints.CENTER;
        guestList.add(guestSummaryLabel,gridbagConCart);
        gridbagConCart.gridx = 0;
        gridbagConCart.gridy = 1;
        gridbagConCart.anchor = GridBagConstraints.EAST;
        guestList.add(new JScrollPane(scrollPane), gridbagConCart);
        gridbagConCart.gridx = 0;
        gridbagConCart.gridy = 2;
        gridbagConCart.anchor = GridBagConstraints.CENTER;
        guestList.add(adminLogOutbtn, gridbagConCart);

        adminLogOutbtn.addActionListener(this);




        return guestList;


    }
    private JPanel ratesPanel(){



        kingratefield.setText("king bedroom rate $"+ getRatesFromRoomSrch.getPricePerNight("king"));
        queenratefield.setText("queen bedroom rate $"+ getRatesFromRoomSrch.getPricePerNight("queen"));
        suiteratefield.setText("suite bedroom rate $"+ getRatesFromRoomSrch.getPricePerNight("suite"));

        kingratefield.setEditable(false);
        queenratefield.setEditable(false);
        suiteratefield.setEditable(false);

        kingBedrateBtn = new JButton("select");
        queenBedrateBtn = new JButton("select");
        suiteBedrateBtn = new JButton("select");

        ImageIcon kingRateImage = new ImageIcon(getClass().getResource("images/kingrate.png"));
        ImageIcon queenRateImage = new ImageIcon(getClass().getResource("images/queenrate.png"));
        ImageIcon suiterateimage = new ImageIcon(getClass().getResource("images/suiterate.png"));
        JLabel kingimage = new JLabel();
        JLabel queenimage = new JLabel();
        JLabel suiteimage = new JLabel();
        kingimage.setIcon(kingRateImage);
        queenimage.setIcon(queenRateImage);
        suiteimage.setIcon(suiterateimage);

        JPanel ratesPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        ratesPanel.add(kingimage, constraints);

        constraints.gridy = 1;
        ratesPanel.add(queenimage, constraints);

        constraints.gridy = 2;
        ratesPanel.add(suiteimage, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        ratesPanel.add(kingratefield, constraints);

        constraints.gridy = 1;
        ratesPanel.add(queenratefield, constraints);

        constraints.gridy = 2;
        ratesPanel.add(suiteratefield, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.EAST;
        ratesPanel.add(kingBedrateBtn, constraints);

        constraints.gridy = 1;
        ratesPanel.add(queenBedrateBtn, constraints);

        constraints.gridy = 2;
        ratesPanel.add(suiteBedrateBtn, constraints);

        JPanel grid = new JPanel(new BorderLayout());
        grid.add(ratesPanel, BorderLayout.CENTER);
        grid.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        grid.setBounds(400, 250, 400, 300);


        kingBedrateBtn.addActionListener(this);
        queenBedrateBtn.addActionListener(this);
        suiteBedrateBtn.addActionListener(this);

        return ratesPanel;

    }

    private JPanel HotelReservationSystem() {
        //setTitle("Bug-Byte Hotel Reservation System");
        //setSize(1000, 600);
        //setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        welcomeLabel = new JLabel("Welcome to Bug-Byte Hotel Reservation System");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Log In");
        createAccountButton = new JButton("Create Account");
        contactStaffButton = new JButton("Contact Staff");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(10, 10, 30, 10);
        panel.add(welcomeLabel, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(10, 10, 10, 10);
        panel.add(usernameLabel, c);
        c.gridx = 1;
        panel.add(usernameField, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(passwordLabel, c);
        c.gridx = 1;
        panel.add(passwordField, c);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        panel.add(loginButton, c);
        c.gridx = 0;
        c.gridy = 4;
        panel.add(createAccountButton, c);
        c.gridx = 0;
        c.gridy = 5;
        panel.add(contactStaffButton, c);
        //add(panel);


        /**
         *Add action listeners to buttons
         */
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.add(login(),"login");
                cardlayout.show(centerPanel,"login");
                appendToTextAreaAndRemoveButtons();

            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });

        contactStaffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contactStaff();
            }
        });
        return panel;
    }

    /**
     *Opens a new window for editing the user's account information after successful *login.
     */
    private JPanel login() {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        JOptionPane.showMessageDialog(frame, "You have successfully logged in.");

        JFrame editAccountFrame = new JFrame("Edit Account Information");
        editAccountFrame.setSize(400, 400);
        editAccountFrame.setLocationRelativeTo(null);

        JPanel editAccountPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(10, 10, 30, 10);
        editAccountPanel.add(new JLabel("Edit Account Information"), c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(10, 10, 10, 10);
        editAccountPanel.add(new JLabel("Name:"), c);
        c.gridx = 1;
        editAccountPanel.add(new JTextField(20), c);
        c.gridx = 0;
        c.gridy = 2;
        editAccountPanel.add(new JLabel("Phone Number:"), c);
        c.gridx = 1;
        editAccountPanel.add(new JTextField(20), c);

        c.gridx = 0;
        c.gridy = 3;
        editAccountPanel.add(new JLabel("Email:"), c);
        c.gridx = 1;
        editAccountPanel.add(new JTextField(20), c);

        c.gridx = 0;
        c.gridy = 4;
        editAccountPanel.add(new JLabel("Payment Method:"), c);
        c.gridx = 1;
        editAccountPanel.add(new JComboBox<>(new String[]{"Credit Card", "PayPal"}), c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.WEST;
        editAccountPanel.add(new JButton("Save Changes"), c);
        c.gridx = 1;
        c.gridy = 5;
        c.anchor = GridBagConstraints.CENTER;
        editAccountPanel.add(UpcomingReservationsButton, c);
        c.gridx = 2;
        c.gridy = 5;
        c.anchor = GridBagConstraints.EAST;
        editAccountPanel.add(logOutButtonEditAccount, c);

        UpcomingReservationsButton.addActionListener(this);
        logOutButtonEditAccount.addActionListener(this);




        //editAccountFrame.add(editAccountPanel);

        //editAccountFrame.setVisible(true);
        return  editAccountPanel;
    }

    /**
     *Creates JFrame for creating account.
     *Creates a new account by prompting the user to enter their personal information *and payment method.
     *The information entered by the user is then displayed in the console temporarily *but will be used in SQL DB.
     */
    private void createAccount() {

        JTextField firstNameField = new JTextField(20);
        JTextField lastNameField = new JTextField(20);
        JTextField phoneNumberField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JComboBox<String> paymentMethodCombo = new JComboBox<>(new String[]{"Credit Card", "PayPal"});

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(10, 10, 30, 10);
        panel.add(new JLabel("Create Account"), c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(10, 10, 10, 10);
        panel.add(new JLabel("First Name:"), c);
        c.gridx = 1;
        panel.add(firstNameField, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(new JLabel("Last Name:"), c);
        c.gridx = 1;
        panel.add(lastNameField, c);

        c.gridx = 0;
        c.gridy = 3;
        panel.add(new JLabel("Phone Number:"), c);
        c.gridx = 1;
        panel.add(phoneNumberField, c);

        c.gridx = 0;
        c.gridy = 4;
        panel.add(new JLabel("Email:"), c);
        c.gridx = 1;
        panel.add(emailField, c);

        c.gridx = 0;
        c.gridy = 5;
        panel.add(new JLabel("Password:"), c);
        c.gridx = 1;
        panel.add(passwordField, c);

        c.gridx = 0;
        c.gridy = 6;
        panel.add(new JLabel("Payment Method:"), c);
        c.gridx = 1;
        panel.add(paymentMethodCombo, c);

        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 2;
        panel.add(new JButton("Create Account"), c);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Create Account",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String phoneNumber = phoneNumberField.getText();
            String email = emailField.getText();
            String password = String.valueOf(passwordField.getPassword());
            String paymentMethod = (String) paymentMethodCombo.getSelectedItem();

            // Add this to database
            System.out.println("Account created:");
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
            System.out.println("Payment Method: " + paymentMethod);
        }
    }

    /**
     *Creates a JFrame with a form to contact the staff.
     *Allows the user to input their name, email and message.
     *The message can be sent to the staff through the "Send Message" button.
     */



    private void contactStaff() {
        JFrame contactStaffFrame = new JFrame("Contact Staff");
        contactStaffFrame.setSize(600, 500);
        contactStaffFrame.setLocationRelativeTo(frame);

        JPanel contactStaffPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(10, 10, 30, 10);
        contactStaffPanel.add(new JLabel("Contact Staff"), c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(10, 10, 10, 10);
        contactStaffPanel.add(new JLabel("Name:"), c);
        c.gridx = 1;
        contactStaffPanel.add(new JTextField(20), c);

        c.gridx = 0;
        c.gridy = 2;
        contactStaffPanel.add(new JLabel("Email:"), c);
        c.gridx = 1;
        contactStaffPanel.add(new JTextField(20), c);

        c.gridx = 0;
        c.gridy = 3;
        contactStaffPanel.add(new JLabel("Message:"), c);
        c.gridx = 1;
        contactStaffPanel.add(new JTextArea(5, 20), c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        contactStaffPanel.add(new JButton("Send Message"), c);


        contactStaffFrame.add(contactStaffPanel);

        contactStaffFrame.setVisible(true);
    }




    private JPanel accountPanel(){
        JPanel reservationsPanel = new JPanel();
        accountTextArea = new JTextArea();
        accountTextArea.setEditable(false);

        GridBagConstraints constraints = new GridBagConstraints();
        JScrollPane scrollPane = new JScrollPane(accountTextArea);
        scrollPane.setPreferredSize(new Dimension(426, 279));

        reservationsPanel.setLayout(new GridBagLayout());


        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        reservationsPanel.add(logoutbtn, constraints);


        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        reservationsPanel.add(scrollPane, constraints);



        logoutbtn.addActionListener(this);




        return reservationsPanel;

    }
    private JPanel SelectDatePanel(){



        dateSelectsBtn = new JButton("check rates for selected dates");
        checkinTextFiled.setPreferredSize(new Dimension(150, checkinTextFiled.getPreferredSize().height));
        checkoutTextField.setPreferredSize(new Dimension(150,checkoutTextField.getPreferredSize().height));


        JPanel gridPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        gridPanel.add(new JLabel("number of guests:"), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridPanel.add(partySizeComboBox, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridPanel.add(new JLabel("check in date yyyy-mm-dd "), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridPanel.add(checkinTextFiled, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridPanel.add(new JLabel("check out date yyyy-mm-dd "), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridPanel.add(checkoutTextField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridPanel.add(dateSelectsBtn, gridBagConstraints);

        gridPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        gridPanel.setBounds(205, 150, 350, 170);



        dateSelectsBtn.addActionListener(this);

        return gridPanel;
    }
    private void appendToTextAreaAndRemoveButtons(){
        isLogin = true;



        File file = new File(  usernameField.getText()+".txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                accountTextArea.append(line + "\n");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("IO Exception: " + ex.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                System.err.println("Error closing reader: " + ex.getMessage());
            }
        }

        btnPanel.remove(cartloginBtn);
        btnPanel.remove(proceedBtn);
        btnPanel.add(completeReservationAsMemberButton);

        detailsPanel.repaint();
        //usernameTextFiled.setText("");
        passwrdtextfield.setText("");
        loginOrRegisterbtn.setText("account");

        if(!(camefromSummaryPanel)) {
            cardlayout.show(centerPanel, "account");
        }else {
            cartTextArea.append("\nCheck in date: "+ reservation.getCheckInDate() + "\nCheck out date: "+reservation.getCheckOutDate()+
                    "\nParty size: "+ reservation.getGuests());
            cartTextArea.append("\nroomtpye:"+ reservation.getRoomType()+ "\ntotal price: "+reservation.getTotalPrice());
            cardlayout.show(centerPanel, "summaryPanel");
        }


    }
    private JPanel CartSummaryPanel(){

        cartTextArea.setEditable(false);
        proceedBtn = new JButton("guest checkout");


        detailsPanel.setLayout(new GridBagLayout());
        cartTextArea.setPreferredSize(new Dimension(426, 279));


        JLabel cartSummaryLabel = new JLabel("Cart Summary");
        btnPanel.add(cartloginBtn);
        btnPanel.add(proceedBtn);
        btnPanel.add(completeReservationAsMemberButton);

        gridbagConCart.gridx = 0;
        gridbagConCart.gridy=0;
        gridbagConCart.anchor = GridBagConstraints.CENTER;
        detailsPanel.add(cartSummaryLabel,gridbagConCart);
        gridbagConCart.gridx = 0;
        gridbagConCart.gridy = 1;
        gridbagConCart.anchor = GridBagConstraints.EAST;
        detailsPanel.add(cartTextArea, gridbagConCart);

        gridbagConCart.gridx = 0;
        gridbagConCart.gridy = 2;
        gridbagConCart.anchor = GridBagConstraints.WEST;
        detailsPanel.add(btnPanel, gridbagConCart);

        proceedBtn.addActionListener(this);
        completeReservationAsMemberButton.addActionListener(this);
        cartloginBtn.addActionListener(this);

        return detailsPanel;

    }
    private JPanel UserInfoAndPaymentPanel(){
        JPanel gridPanel = new JPanel(new GridLayout(7,4,50,10));
        JPanel infoPanel = new JPanel();


        JLabel firstNamelnl = new JLabel("First Name:");
        JLabel lastNamelbl= new JLabel("Last Name:");

        JLabel emailAdrrLbl = new JLabel("e-mail:");
        JLabel phoneNumberlbl = new JLabel("phone number:");
        JLabel NameOnCardLbl = new JLabel("name on card:");
        JLabel CardNumberLbl = new JLabel("card number:");
        JLabel ExperationDateLbl = new JLabel("experation date MM/YY:");
        JLabel CVCnumberLbl = new JLabel("CVC code:");





        gridPanel.setBounds(205,150,300,500);

        gridPanel.add(firstNamelnl);
        gridPanel.add(firstnameTextfield);
        gridPanel.add(lastNamelbl);
        gridPanel.add(lastnameTextfield);
        gridPanel.add(new JLabel("Address:"));
        gridPanel.add(addressTextfield);
        gridPanel.add(new JLabel("City:"));
        gridPanel.add(cityTextField);
        gridPanel.add(new JLabel("State e.g, CA:"));
        gridPanel.add(stateTextField);
        gridPanel.add(new JLabel("Zip code:"));
        gridPanel.add(zipcodeTextField);
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
        gridPanel.add(payAsGuestButton);
        infoPanel.add(gridPanel);

        payAsGuestButton.addActionListener(this);



        return infoPanel;
    }
    private JPanel completedReservationPanel()
    {

        JPanel completReservationPanel = new JPanel();
        JLabel congratsOnResvLbl = new JLabel("reservation placed thank you!");
        completedReservationTextArea = new JTextArea();

        completedReservationTextArea.setEditable(false);

        GridBagConstraints constraints = new GridBagConstraints();


        completReservationPanel.setLayout(new GridBagLayout());
        completedReservationTextArea.setPreferredSize(new Dimension(426, 279));

        constraints.gridx = 0;
        constraints.gridy=0;
        constraints.anchor = GridBagConstraints.CENTER;
        completReservationPanel.add(congratsOnResvLbl,gridbagConCart);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.EAST;
        completReservationPanel.add(completedReservationTextArea, gridbagConCart);




        return completReservationPanel;
    }
    private JPanel RoomsPanel(){


        roomsPanel.setLayout(new GridBagLayout());

        //labels
        kingbedbutton.setText("view more king Bedroom images");
        queenbedbutton.setText("view more Queen Bedroom images");
        suitebedbutton.setText("view more suite bedroom images");
        kinglabel = new JLabel("<html>364 square feet of space<br>One King size bed <br>" +
                " 55 inch LED high definition television<br> In-room safe<br>Sofa<br>Maximum occupancy: 2 </html>");
        queenlabel = new JLabel("<html>364 square feet of space<br>two Queen beds <br>" +
                " 55 inch LED high definition television<br> In-room safe<br>Maximum occupancy: 4 </html>");
        suitelabel = new JLabel("<html>       756 square feet of space<br>Separated living and sleeping area<br>One King size bed <br>" +
                " 55 inch LED high definition television<br> In-room safe<br>Wireless Internet access<br>Sofa and seating area for 4 </html>");

        kinglabel.setIconTextGap(50);
        queenlabel.setIconTextGap(50);
        suitelabel.setIconTextGap(50);

        //get room images
        kinglabel.setIcon(kingBedImage);
        queenlabel.setIcon(queenBedImage);
        suitelabel.setIcon(suiteBedImage);
        roomComboBox = new JComboBox<>(roomtype);
        kingbedbutton.setPreferredSize(new Dimension(400, kingbedbutton.getPreferredSize().height));
        queenbedbutton.setPreferredSize(new Dimension(400, queenbedbutton.getPreferredSize().height));
        suitebedbutton.setPreferredSize(new Dimension(400, suitebedbutton.getPreferredSize().height));


        gridbagCon.gridx = 1;
        gridbagCon.gridy=0;
        gridbagCon.anchor = GridBagConstraints.EAST;
        roomsPanel.add(roomComboBox,gridbagCon);


        //action listeners
        kingbedbutton.addActionListener(this);
        queenbedbutton.addActionListener(this);
        suitebedbutton.addActionListener(this);
        roomComboBox.addActionListener(this);



        return roomsPanel;
    }
    private void addRoomToPanel(JLabel rooomLable, JButton btnName ){

        gridbagCon.gridx = 0;
        gridbagCon.gridy = 1;
        gridbagCon.anchor = GridBagConstraints.EAST;
        roomsPanel.add(rooomLable, gridbagCon);

        gridbagCon.gridx = 0;
        gridbagCon.gridy = 2;
        gridbagCon.anchor = GridBagConstraints.WEST;
        roomsPanel.add(btnName, gridbagCon);

        roomsPanel.revalidate();
        roomsPanel.repaint();

    }
    private void removeRoomsFromPanel(JLabel roomlbl1,JButton roombtn1,JLabel roomlbl2,JButton roombtn2)
    {
        roomsPanel.remove(roomlbl1);
        roomsPanel.remove(roombtn1);
        roomsPanel.remove(roomlbl2);
        roomsPanel.remove(roombtn2);
        roomsPanel.revalidate();
        roomsPanel.repaint();
    }
    private void showAlleooms()
    {
        gridbagCon.gridx = 0;
        gridbagCon.gridy = 1;
        gridbagCon.anchor = GridBagConstraints.EAST;
        roomsPanel.add(kinglabel, gridbagCon);

        gridbagCon.gridx = 0;
        gridbagCon.gridy = 2;
        gridbagCon.anchor = GridBagConstraints.WEST;
        roomsPanel.add(kingbedbutton, gridbagCon);



        gridbagCon.gridx = 0;
        gridbagCon.gridy = 3;
        gridbagCon.anchor = GridBagConstraints.EAST;
        roomsPanel.add(queenlabel, gridbagCon);

        gridbagCon.gridx = 0;
        gridbagCon.gridy = 4;
        gridbagCon.anchor = GridBagConstraints.WEST;
        roomsPanel.add(queenbedbutton, gridbagCon);


        gridbagCon.gridx = 0;
        gridbagCon.gridy = 5;
        gridbagCon.anchor = GridBagConstraints.EAST;
        roomsPanel.add(suitelabel, gridbagCon);
        gridbagCon.gridx = 0;
        gridbagCon.gridy = 6;
        gridbagCon.anchor = GridBagConstraints.WEST;
        roomsPanel.add(suitebedbutton, gridbagCon);
        roomsPanel.revalidate();
        roomsPanel.repaint();

    }


    // show additional room images
    private void RoomChoice(String name){

        JFrame popUpRoomTypeFrame = new JFrame("ROOMS");
        JPanel panel = new JPanel();


        if(name.equals("king"))
        {
            image = new ImageIcon(getClass().getResource("images/kingbedroom.png"));
            image2 = new ImageIcon(getClass().getResource("images/kingbedroom2.png"));
            image3 = new ImageIcon(getClass().getResource("images/kingrestroom.png"));
            image4 = new ImageIcon(getClass().getResource("images/kingrestroom2.png"));
        }
        if(name.equals("queen"))
        {
            image = new ImageIcon(getClass().getResource("images/queenbedroom.png"));
            image2 = new ImageIcon(getClass().getResource("images/queenbedroom2.png"));
            image3 = new ImageIcon(getClass().getResource("images/queenrestroom.png"));
            image4 = new ImageIcon(getClass().getResource("images/queenrestroom2.png"));
        }
        if(name.equals("suite"))
        {
            image = new ImageIcon(getClass().getResource("images/suitebedroom.png"));
            image2 = new ImageIcon(getClass().getResource("images/suitebedroom2.png"));
            image3 = new ImageIcon(getClass().getResource("images/suitelivingarea.png"));
            image4 = new ImageIcon(getClass().getResource("images/suitelivingarea2.png"));
            image5 = new ImageIcon(getClass().getResource("images/suiterestroom.png"));

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
        if(name.equals("suite"))
        {
            JLabel label5 = new JLabel();
            label5.setIcon(image5);
            panel.add(label5);
        }

        panel.setPreferredSize(new Dimension(1000,2800));

        JScrollPane scrollPane = new JScrollPane(panel);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        popUpRoomTypeFrame.getContentPane().add(scrollPane);
        popUpRoomTypeFrame.setSize(1025,500);
        popUpRoomTypeFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(numberOfRoomClicks>0){
            cartTextArea.setText("");
        }
        if(!(isLogin)){
            btnPanel.remove(completeReservationAsMemberButton);
        }

        if (e.getSource() == homebtn) {
            cardlayout.show(centerPanel, "home");
        } else if (e.getSource() == roomsbtn) {
            showAlleooms();
            cardlayout.show(centerPanel, "allrooms");
        } else if (e.getSource() == bookbtn) {
            cardlayout.show(centerPanel, "datePanel");
        } else if (e.getSource() == dateSelectsBtn) {
            try {
                LocalDate currentDate = LocalDate.now();
                LocalDate Indate = LocalDate.parse(checkinTextFiled.getText());
                LocalDate Outdate = LocalDate.parse(checkoutTextField.getText());

                int dateCompareCheckoutToIn = Outdate.compareTo(Indate);
                long daysBetween = ChronoUnit.DAYS.between(currentDate, Indate);
                if (daysBetween < 0 || daysBetween > 182) {
                    JOptionPane.showMessageDialog(frame, "can only make reservations in the next 6 months.");
                }

                else if(dateCompareCheckoutToIn <= 0){
                    JOptionPane.showMessageDialog(frame, "checkout date cannot be before check in date");
                }
                else {
                    // use method of Reservation to set data, make a constructor with no parameters and make methods to set data
                    reservation = new Reservation();
                    reservation.setCheckInDate(Indate);
                    reservation.setCheckOutDate(Outdate);
                    reservation.setGuests(partySizeComboBox.getSelectedIndex() + 1);
                    if (reservation.checkforroom("king") || reservation.checkforroom("queen") || reservation.checkforroom("suite")) {


                        cardlayout.show(centerPanel, "rates");
                    } else {
                        JOptionPane.showMessageDialog(frame, "No rooms available for dates selected");
                    }
                }
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(frame, "No date entered or bad input");
            }
        }

        // handle room selection buttons
        if (e.getSource() == kingBedrateBtn) {
            if (reservation.checkforroom("king")) {
                numberOfRoomClicks++;
                reservation.setRoomType("king");
                cartTextArea.append("\nCheck in date: "+ reservation.getCheckInDate() + "\nCheck out date: "+reservation.getCheckOutDate()+
                        "\nParty size: "+ reservation.getGuests());
                cartTextArea.append("\nroomtpye:"+ reservation.getRoomType()+ "\ntotal price: "+reservation.getTotalPrice());
                cardlayout.show(centerPanel, "summaryPanel");
            }
        } else if (e.getSource() == queenBedrateBtn) {
            if (reservation.checkforroom("queen")) {
                numberOfRoomClicks++;
                cartTextArea.append("\nCheck in date: "+ reservation.getCheckInDate() + "\nCheck out date: "+reservation.getCheckOutDate()+
                        "\nParty size: "+ reservation.getGuests());
                reservation.setRoomType("queen");
                cartTextArea.append("\nroomtpye:"+ reservation.getRoomType()+ "\ntotal price: "+reservation.getTotalPrice());
                cardlayout.show(centerPanel, "summaryPanel");
            }
        } else if (e.getSource() == suiteBedrateBtn) {
            numberOfRoomClicks++;
            if (reservation.checkforroom("suite")) {
                reservation.setRoomType("suite");
                cartTextArea.append("\nCheck in date: "+ reservation.getCheckInDate() + "\nCheck out date: "+reservation.getCheckOutDate()+
                        "\nParty size: "+ reservation.getGuests());
                cartTextArea.append("\nroomType:"+ reservation.getRoomType()+ "\ntotal price: "+reservation.getTotalPrice());
                cardlayout.show(centerPanel, "summaryPanel");
            }
        }


        // handle room availability buttons
        kingBedrateBtn.setEnabled(reservation.checkforroom("king"));
        kingBedrateBtn.setText(kingBedrateBtn.isEnabled() ? "Select" : "out");
        if (reservation.getGuests()>2) {
            kingBedrateBtn.setEnabled(false);
            kingBedrateBtn.setText("Max Party: 2");
        }

        queenBedrateBtn.setEnabled(reservation.checkforroom("queen"));
        queenBedrateBtn.setText(queenBedrateBtn.isEnabled() ? "Select" : "Out");

        suiteBedrateBtn.setEnabled(reservation.checkforroom("suite"));
        suiteBedrateBtn.setText(suiteBedrateBtn.isEnabled() ? "Select" : "Out");

        // show additional room images
        if (e.getSource() == kingbedbutton) {
            RoomChoice("king");
        } else if (e.getSource() == queenbedbutton) {
            RoomChoice("queen");
        } else if (e.getSource() == suitebedbutton) {
            RoomChoice("suite");
        }


        if (e.getSource() == proceedBtn) {

            cardlayout.show(centerPanel, "infoPanel");
        } else if (e.getSource() == loginOrRegisterbtn) {
            if(isLogin==false){

                cardlayout.show(centerPanel, "logInOrRegister");

            }
            else cardlayout.show(centerPanel, "login");

        }
        else if (e.getSource() == logoutbtn) {
            loginOrRegisterbtn.setText("log in/register");
            proceedBtn.setText("guest checkout");
            isLogin = false;
            camefromSummaryPanel=false;
            usernameTextFiled.setText("");

            btnPanel.add(cartloginBtn);
            btnPanel.add(proceedBtn);


            cardlayout.show(centerPanel, "home");
        }   else if (e.getSource()==cartloginBtn) {

            camefromSummaryPanel=true;
            cardlayout.show(centerPanel,"logInOrRegister");

        }
        if(e.getSource()==roomComboBox) {

            if (roomComboBox.getSelectedIndex() == 0) {
                showAlleooms();

            } else if (roomComboBox.getSelectedIndex() == 1) {

                addRoomToPanel(kinglabel,kingbedbutton);
                removeRoomsFromPanel(queenlabel,queenbedbutton,suitelabel,suitebedbutton);
            } else if (roomComboBox.getSelectedIndex() == 2) {
                addRoomToPanel(queenlabel,queenbedbutton);
                removeRoomsFromPanel(kinglabel,kingbedbutton,suitelabel,suitebedbutton);

            } else if (roomComboBox.getSelectedIndex() == 3) {
                addRoomToPanel(suitelabel,suitebedbutton);
                removeRoomsFromPanel(kinglabel,kingbedbutton,queenlabel,queenbedbutton);
            }

        }
        if ( e.getSource()==searchbtn) {
            String searchInput = searchbar.getText().toLowerCase();
            if( searchInput.contains("king")){
                roomComboBox.setSelectedIndex(1);
                addRoomToPanel(kinglabel,kingbedbutton);
                removeRoomsFromPanel(queenlabel,queenbedbutton,suitelabel,suitebedbutton);

                cardlayout.show(centerPanel, "allrooms");


            } else if (searchInput.contains("queen")) {
                roomComboBox.setSelectedIndex(2);
                addRoomToPanel(queenlabel,queenbedbutton);
                removeRoomsFromPanel(kinglabel,kingbedbutton,suitelabel,suitebedbutton);
                cardlayout.show(centerPanel, "allrooms");


            } else if (searchInput.contains("suite")) {
                roomComboBox.setSelectedIndex(3);
                addRoomToPanel(suitelabel,suitebedbutton);
                removeRoomsFromPanel(kinglabel,kingbedbutton,queenlabel,queenbedbutton);
                cardlayout.show(centerPanel, "allrooms");

            } else if (searchInput.contains("000")) {

                cardlayout.show(centerPanel,"addminLogin");

            }
            searchbar.setText("");

        }
        if(e.getSource()==adminLoginBtn){


            if(adminNameTextfield.getText().equals("csun") && adminLoginTextfield.getText().equals("123")){

                File file = new File("output.txt");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        guestListTextArea.append(line + "\n");
                    }
                } catch (FileNotFoundException ex) {
                    System.err.println("File not found: " + ex.getMessage());
                } catch (IOException ex) {
                    System.err.println("IO Exception: " + ex.getMessage());
                } finally {
                    try {
                        if (reader != null) {
                            reader.close();
                        }
                    } catch (IOException ex) {
                        System.err.println("Error closing reader: " + ex.getMessage());
                    }
                }

                adminNameTextfield.setText("");
                adminLoginTextfield.setText("");
                cardlayout.show(centerPanel, "guestList");
            }
            else{
                JOptionPane.showMessageDialog(frame, "wrong login Info.");
            }


        }
        if(e.getSource()==adminLogOutbtn){
            cardlayout.show(centerPanel,"home");
        }
        if(e.getSource()==UpcomingReservationsButton){
            cardlayout.show(centerPanel,"UpcomingReservations");
        }
        if(e.getSource()==logOutButtonEditAccount){
            cardlayout.show(centerPanel,"home");
            loginOrRegisterbtn.setText("log in/register");
            isLogin=false;
            btnPanel.add(cartloginBtn);
            btnPanel.add(proceedBtn);
        }
        if (e.getSource()==completeReservationAsMemberButton) {
            if(numberOfRoomClicks>0){
                completedReservationTextArea.setText("");
            }


            accountTextArea.append("\nCheck in date: "+ reservation.getCheckInDate() + "\nCheck out date: "
                    +reservation.getCheckOutDate()+ "\nParty size: "+ reservation.getGuests()+"\nRoomType: "+reservation.getRoomType()+
                    "\nreservation number: "+ reservation.getConfirmationNumber());


            completedReservationTextArea.append("\nCheck in date: "+ reservation.getCheckInDate() + "\nCheck out date: "
                    +reservation.getCheckOutDate()+ "\nParty size: "+ reservation.getGuests()+"\nRoomType: "+reservation.getRoomType()+
                    "\nreservation number: "+ reservation.getConfirmationNumber());
            reservation.reserveRoom(reservation.getRoomType());

            if(isLogin){

                File file2 = new File(usernameField.getText()+".txt");
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                FileWriter writer;
                try {
                    writer = new FileWriter(file2, true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                try {

                    writer.write("Check in date: " + reservation.getCheckInDate() + "\nCheck out date: " + reservation.getCheckOutDate() +
                            "\nParty size: " + reservation.getGuests() + "\nRoomType: " + reservation.getRoomType() +
                            "\nreservation number: " + reservation.getConfirmationNumber() + "\n\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                try {
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }



            cardlayout.show(centerPanel,"completedReservationPanel");

        }else if (e.getSource() == payAsGuestButton) {

            try {
                String firstName = firstnameTextfield.getText();
                String lastName = lastnameTextfield.getText();
                String address = addressTextfield.getText();
                String city = cityTextField.getText();
                String state = stateTextField.getText();
                String Zipcode = zipcodeTextField.getText();
                String email = emailTextfield.getText();
                String phone = phoneTextfield.getText();
                String nameOnCard = NameOnCardtextfield.getName();
                String cardNumber= CardNumberTextField.getText();
                String experationDate = ExperactionDatetextfield.getText();
                String CVC = CVCnumbertextfield.getText();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
                simpleDateFormat.setLenient(false);
                Date expiry = simpleDateFormat.parse(experationDate);
                boolean expired= expiry.before(new Date());


                if (!firstName.matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(frame, "enter a valid first name.");
                } else if (!lastName.matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(frame, " enter a valid last name.");
                } else if (!address.matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)")) {
                    JOptionPane.showMessageDialog(frame, "enter a valid address.");
                } else if (!city.matches( "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$")) {
                    JOptionPane.showMessageDialog(frame, "enter a valid city.");
                } else if (!state.matches("[a-zA-Z]{2}")) {
                    JOptionPane.showMessageDialog(frame, "enter a valid state abbreviation (e.g. CA).");
                } else if (!Zipcode.matches("\\d{5}")) {
                    JOptionPane.showMessageDialog(frame, "enter a valid 5-digit zip code.");
                } else if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                    JOptionPane.showMessageDialog(frame, "enter a valid email address.");
                } else if (!phone.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(frame, "enter a valid 10-digit phone number.");
                } else if (!CVC.matches("\\d{3}")) {
                    JOptionPane.showMessageDialog(frame, "enter a valid 3-digit CVC number.");
                } else if (expired) {
                    JOptionPane.showMessageDialog(frame, "The card has expired.");
                } else if(!cardNumber.matches("^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|)")){
                    JOptionPane.showMessageDialog(frame, "enter a valid card number Visa : 13 or 16 digits begins with 4");
                }
                else {
                    // Feed data to a class
                    reservation.reserveRoom(reservation.getRoomType());
                    cardlayout.show(centerPanel, "completedReservationPanel");

                    //clear textfields
                    firstnameTextfield.setText("");
                     lastnameTextfield.setText("");
                     addressTextfield.setText("");
                    cityTextField.setText("");
                    stateTextField.setText("");
                    zipcodeTextField.setText("");
                    emailTextfield.setText("");
                    phoneTextfield.setText("");
                    NameOnCardtextfield.setText("");
                    CardNumberTextField.setText("");
                    ExperactionDatetextfield.setText("");
                    CVCnumbertextfield.setText("");

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "missing one or more fields or wrong type of data entered.");
            }

            if(numberOfRoomClicks>0){
                completedReservationTextArea.setText("");
            }


            completedReservationTextArea.append("\nCheck in date: "+ reservation.getCheckInDate() + "\nCheck out date: "
                    +reservation.getCheckOutDate()+ "\nParty size: "+ reservation.getGuests()+"\nRoomType: "+reservation.getRoomType()+
                    "\nreservation number: "+ reservation.getConfirmationNumber());


            File file = new File("output.txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            FileWriter writer;
            try {
                writer = new FileWriter(file, true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


            try {
                writer.write("Check in date: " + reservation.getCheckInDate() + "\nCheck out date: " + reservation.getCheckOutDate() +
                        "\nParty size: " + reservation.getGuests() + "\nRoomType: " + reservation.getRoomType() +
                        "\nreservation number: " + reservation.getConfirmationNumber() + "\n\n");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


            try {
                writer.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

    }
    public static void main(String[] args){
        GUI h = new GUI();

    }


}
