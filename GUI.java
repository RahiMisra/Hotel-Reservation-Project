import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class GUI implements ActionListener {
    //default constructor for Reservation needed
    Reservation reservation = new Reservation();

    roomRates rates = new roomRates();




    JFrame frame = new JFrame("hotel");

    JPanel centerPanel = new JPanel();


    CardLayout cardlayout = new CardLayout();


    private JButton dateSelectsBtn;
    private JButton kingBedrateBtn;
    private JButton queenBedrateBtn;
    private JButton suiteBedrateBtn;
    private final JButton confirmButton = new JButton("confirm and pay");
    private final JButton homebtn = new JButton("home");
    private final JButton roomsbtn = new JButton("rooms");
    private final JButton bookbtn = new JButton("book");



    private JButton proceedBtn;
    private JTextArea cartTextArea = new JTextArea();


    private final String[] roomtype = {"all","king","queen","suite"};

    private final ImageIcon kingBedImage = new ImageIcon( getClass().getResource("images/king.png"));
    private final ImageIcon  queenBedImage = new ImageIcon(getClass().getResource("images/queen.png"));
    private final ImageIcon suiteBedImage = new ImageIcon(getClass().getResource("images/suitecover.png"));
    private ImageIcon image;
    private ImageIcon image2;
    private ImageIcon image3;
    private ImageIcon image4;
    private ImageIcon image5;
    JPanel btnPanel = new JPanel();

    private final JButton kingbedbutton = new JButton();
    private final JButton queenbedbutton = new JButton();
    private final JButton suitebedbutton = new JButton();
    private boolean isLogin = false;
    GridBagConstraints gridbagConCart = new GridBagConstraints();
    JButton cartloginBtn = new JButton("Login");

    private boolean camefromSummaryPanel = false;
    JLabel kinglabel;
    JLabel queenlabel;
    JLabel suitelabel ;


    private final TextField searchbar = new TextField(20);
    private final JButton searchbtn = new JButton("search");
    private JTextField usernameTextFiled = new JTextField();
    private JPasswordField passwrdtextfield = new JPasswordField();

    JPanel detailsPanel = new JPanel();

    private final JButton loginOrRegisterbtn = new JButton("log in/register");
    private  final JButton logInbtn = new JButton("log in");
    private final JButton forgotPasswordbtn = new JButton("forgot password");

    private  final JButton registerBtn = new JButton("register");
    private  final JButton logoutbtn = new JButton("log out");

    JTextField kingratefield = new JTextField();
    JTextField queenratefield = new JTextField();
    JTextField suiteratefield = new JTextField();

    JTextField checkinTextFiled = new JTextField();
    JTextField checkoutTextField = new JTextField();
    String[] num = {"1","2","3","4"};
    JComboBox<String> partySizeComboBox = new JComboBox<>(num);
    GridBagConstraints gridbagCon = new GridBagConstraints();
    JPanel roomsPanel = new JPanel();
    JComboBox<String> roomComboBox;


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
        centerPanel.add(logInOrRegisterPanel(),"logInOrRegister");
        centerPanel.add(accountPanel(),"account");




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
    public JPanel TopPanel(){
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
    public JPanel homePanel(){
        JPanel home = new JPanel();
        JLabel homelbl = new JLabel("welcome ");
        home.add(homelbl);

        return home;

    }
    public JPanel ratesPanel(){
        kingratefield.setText("king bedroom rate $"+ rates.getKingBedroomPrice());
        queenratefield.setText("queen bedroom rate $"+ rates.getQueenBedroomPrice());
        suiteratefield.setText("suite bedroom rate $"+ rates.getSuiteBedroomPrice());

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
    public JPanel logInOrRegisterPanel()
    {
        JPanel Panel = new JPanel(new GridLayout(3,2));
        JPanel loginOrRegPanel = new JPanel();
        loginOrRegPanel.setLayout(null);



        JLabel emailaddr = new JLabel("username ");
        JLabel userpasswordlbl = new JLabel("password ");


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
    public JPanel accountPanel(){
        JPanel reservationsPanel = new JPanel();
        reservationsPanel.add(logoutbtn);
        logoutbtn.addActionListener(this);




        return reservationsPanel;

    }
    public JPanel SelectDatePanel(){



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
    public JPanel CartSummaryPanel(){

        cartTextArea.setEditable(false);
        proceedBtn = new JButton("guest checkout");

        detailsPanel.setLayout(new GridBagLayout());
        cartTextArea.setPreferredSize(new Dimension(426, 279));


        JLabel cartSummaryLabel = new JLabel("Cart Summary");
        btnPanel.add(cartloginBtn);
        btnPanel.add(proceedBtn);

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
        cartloginBtn.addActionListener(this);

        return detailsPanel;

    }
    public JPanel UserInfoAndPaymentPanel(){
        JPanel gridPanel = new JPanel(new GridLayout(17,1,10,10));
        JPanel infoPanel = new JPanel();


        JLabel firstNamelnl = new JLabel("First Name");
        JLabel lastNamelbl= new JLabel("Lat Name");
        JLabel emailAdrrLbl = new JLabel("e-mail");
        JLabel phoneNumberlbl = new JLabel("phone number");
        JLabel NameOnCardLbl = new JLabel("name on card:");
        JLabel CardNumberLbl = new JLabel("card number:");
        JLabel ExperationDateLbl = new JLabel("experation date:");
        JLabel CVCnumberLbl = new JLabel("CVC code:");

        JTextField firstnameTextfield = new JTextField();
        JTextField lastnameTextfield = new JTextField();
        JTextField emailTextfield = new JTextField();
        JTextField phoneTextfield = new JTextField();
        JTextField NameOnCardtextfield = new JTextField();
        JPasswordField CardNumberTextField = new JPasswordField();
        JTextField ExperactionDatetextfield = new JTextField();
        JTextField CVCnumbertextfield = new JTextField();



        gridPanel.setBounds(205,150,300,500);

        gridPanel.add(firstNamelnl);
        gridPanel.add(firstnameTextfield);
        gridPanel.add(lastNamelbl);
        gridPanel.add(lastnameTextfield);
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
        gridPanel.add(confirmButton);
        infoPanel.add(gridPanel);

        confirmButton.addActionListener(this);


        return infoPanel;
    }
    public JPanel completedReservationPanel()
    {
        JPanel completReservationPanel = new JPanel();
        JLabel congratsOnResvLbl = new JLabel("reservation placed thank you!");


        completReservationPanel.add(congratsOnResvLbl);


        return completReservationPanel;
    }
    public JPanel RoomsPanel(){


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
    public void addRoomToPanel(JLabel rooomLable, JButton btnName ){

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
    public void removeRoomsFromPanel(JLabel roomlbl1,JButton roombtn1,JLabel roomlbl2,JButton roombtn2)
    {
        roomsPanel.remove(roomlbl1);
        roomsPanel.remove(roombtn1);
        roomsPanel.remove(roomlbl2);
        roomsPanel.remove(roombtn2);
        roomsPanel.revalidate();
        roomsPanel.repaint();
    }
    public void showAlleooms()
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
    public void RoomChoice(String name){

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
                int dateCompareCheckinToCurrent = Indate.compareTo(currentDate);
                int dateCompareCheckoutToIn = Outdate.compareTo(Indate);
                if (dateCompareCheckinToCurrent < 0 || dateCompareCheckoutToIn <= 0) {
                    JOptionPane.showMessageDialog(frame, "Date passed or checkout <= checkin");
                } else {
                    // use method of Reservation to set data, make a constructor with no parameters and make methods to set data
                    reservation.setCheckInDateAndchecoutdayAndGuestSize(Indate, Outdate, partySizeComboBox.getSelectedIndex() + 1);
                    if (reservation.checkforroom("king") || reservation.checkforroom("queen") || reservation.checkforroom("suite")) {
                        cartTextArea.append("\nCheck in date: "+ reservation.getCheckInDate() + "\nCheck out date: "+reservation.getCheckOutDate()+
                                "\nParty size: "+ reservation.getGuests());
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
                reservation.setroomtypeChoice("king");
                cartTextArea.append("\nroomtpye:"+ reservation.getroomtypeChoice()+ "\ntotal price: "+reservation.getTotalPrice());
                cardlayout.show(centerPanel, "summaryPanel");
            }
        } else if (e.getSource() == queenBedrateBtn) {
            if (reservation.checkforroom("queen")) {
                reservation.setroomtypeChoice("queen");
                cartTextArea.append("\nroomtpye:"+ reservation.getroomtypeChoice()+ "\ntotal price: "+reservation.getTotalPrice());
                cardlayout.show(centerPanel, "summaryPanel");
            }
        } else if (e.getSource() == suiteBedrateBtn) {
            if (reservation.checkforroom("suite")) {
                reservation.setroomtypeChoice("suite");
                cartTextArea.append("\nroomtpye:"+ reservation.getroomtypeChoice()+ "\ntotal price: "+reservation.getTotalPrice());
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
            if(isLogin){
                cardlayout.show(centerPanel, "completedReservationPanel");
            }else
            cardlayout.show(centerPanel, "infoPanel");
        } else if (e.getSource() == loginOrRegisterbtn) {
            if(isLogin==false){

                cardlayout.show(centerPanel, "logInOrRegister");

            }
            else cardlayout.show(centerPanel, "account");

        } else if (e.getSource() == logInbtn) {
            String usernameInput = usernameTextFiled.getText();
            String passwordInput = passwrdtextfield.getText();
            if ("abc".equals(usernameInput) && "123".equals(passwordInput)) {
                isLogin = true;
                btnPanel.remove(cartloginBtn);
                detailsPanel.repaint();
                usernameTextFiled.setText("");
                passwrdtextfield.setText("");
                loginOrRegisterbtn.setText("account");
                proceedBtn.setText("complete");
                if(!(camefromSummaryPanel)) {
                    cardlayout.show(centerPanel, "account");
                }else cardlayout.show(centerPanel,"summaryPanel");


            } else {
                JOptionPane.showMessageDialog(frame, "Wrong username or password. To test login, use username: abc, password: 123.");
            }
        } else if (e.getSource() == logoutbtn) {
            loginOrRegisterbtn.setText("log in/register");
            proceedBtn.setText("guest checkout");
            isLogin = false;
            camefromSummaryPanel=false;
            btnPanel.remove(proceedBtn);
            btnPanel.add(cartloginBtn);
            btnPanel.add(proceedBtn);


            cardlayout.show(centerPanel, "home");
        }  else if (e.getSource() == confirmButton) {
            reservation.reserveRoom(reservation.getroomtypeChoice());
            cardlayout.show(centerPanel, "completedReservationPanel");
        } else if (e.getSource()==cartloginBtn) {
            cardlayout.show(centerPanel,"logInOrRegister");
            camefromSummaryPanel=true;

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
            System.out.println(searchInput);
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

            }

        }
    }
    public static void main(String[] args)
    {
        GUI h = new GUI();


    }
}
