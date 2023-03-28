import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI implements ActionListener {
    JFrame frame = new JFrame("hotel");

    JPanel MainPanel = new JPanel();


    CardLayout cardlayout = new CardLayout();

    JComboBox comboBox;
    JComboBox comboBox2;
    JComboBox comboBox3;
    JComboBox comboBox4;
    private JButton dateSelectsBtn;
    private JButton kingBedrateBtn;
    private JButton queenBedrateBtn;
    private JButton suiteBedrateBtn;
    private JButton confirmButton;
    private JButton homebtn = new JButton("home");
    private  JButton roomsbtn = new JButton("rooms");
    private  JButton bookbtn = new JButton("book");
    private JButton kingBedButton = new JButton();
    private JButton queenBedButton = new JButton();
    private JButton suiteBedButton = new JButton();
    private JButton proceedBtn;

    private JButton kingBedButton2 = new JButton();
    private JButton queenBedButton2 = new JButton();
    private JButton suiteBedButton2 = new JButton();
    private String[] roomtype = {"all","king","queen","suite"};

    private ImageIcon kingBedImage;
    private ImageIcon  queenBedImage;
    private ImageIcon suiteBedImage;
    private ImageIcon image;
    private ImageIcon image2;
    private ImageIcon image3;
    private ImageIcon image4;
    private ImageIcon image5;




    public GUI(){




        kingBedImage = new ImageIcon("king.png");
        queenBedImage = new ImageIcon("queen.png");
        suiteBedImage = new ImageIcon("suitecover.png");

        MainPanel.setLayout(cardlayout);

        MainPanel.add(homePanel(),"0");
        MainPanel.add(AllroomsPannel(),"1");
        MainPanel.add(kingOnlyPannel(),"2");
        MainPanel.add(queenOnlyPannel(),"3");
        MainPanel.add(suiteOnlyPannel(),"4");
        MainPanel.add(bookDatePanel(),"5");
        MainPanel.add(ratePanel(),"6");
        MainPanel.add(reservationDetailPanel(),"7");
        MainPanel.add(UserInfoPanel(),"8");
        MainPanel.add(completedReservationPanel(),"9");


        frame.pack();
        frame.setSize(1025, 1000);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);




        Container mainContainer= frame.getContentPane();
        mainContainer.setLayout(new BorderLayout(8,6));
        mainContainer.setBackground (Color.green);

        //Panel Top
        JPanel topPanel = new JPanel();

        topPanel.setBackground (Color.ORANGE);
        topPanel.setLayout (new FlowLayout (5));
        topPanel.add(homebtn);
        topPanel.add(roomsbtn);
        topPanel.add(bookbtn);

        mainContainer.add(topPanel, BorderLayout.NORTH);
        mainContainer.add(MainPanel,BorderLayout.CENTER);

        homebtn.addActionListener(this);
        roomsbtn.addActionListener(this);
        bookbtn.addActionListener(this);
        frame.setVisible(true);

    }
    public JPanel homePanel(){
        JPanel home = new JPanel();
        JLabel homelbl = new JLabel("welcome ");
        home.add(homelbl);

        return home;

    }
    public JPanel ratePanel(){
        ImageIcon kingRateImage = new ImageIcon("kingrate.png");
        ImageIcon queenRateImage = new ImageIcon("queenrate.png");
        ImageIcon suiterateimage = new ImageIcon("suiterate.png");
        JLabel kingimage = new JLabel();
        JLabel queenimage = new JLabel();
        JLabel suiteimage = new JLabel();
        kingimage.setIcon(kingRateImage);
        queenimage.setIcon(queenRateImage);
        suiteimage.setIcon(suiterateimage);
        JPanel grid = new JPanel(new GridLayout(3,2,100,100));
        JPanel ratesPanel = new JPanel();
        ratesPanel.setLayout(null);
        JLabel kingBedratelnl = new JLabel("king bedroom rate?? ");
        JLabel queenBedratelbl = new JLabel("queen bedroom rate?? ");
        JLabel suiteBedratelbl = new JLabel("suite bedroom rate??");

        kingBedrateBtn = new JButton("select");
        queenBedrateBtn = new JButton("select");
        suiteBedrateBtn = new JButton("select");
        kingimage.setBounds(50,150,200,200);
        queenimage.setBounds(50,270,200,200);
        suiteimage.setBounds(50,385,200,200);
        ratesPanel.add(kingimage);
        ratesPanel.add(queenimage);
        ratesPanel.add(suiteimage);
        ratesPanel.add(kingimage);
        grid.setBounds(300,170,400,400);

        grid.add(kingBedratelnl);
        grid.add(kingBedrateBtn);
        grid.add(queenBedratelbl);
        grid.add(queenBedrateBtn);
        grid.add(suiteBedratelbl);
        grid.add(suiteBedrateBtn);
        ratesPanel.add(grid);
        kingBedrateBtn.addActionListener(this);
        queenBedrateBtn.addActionListener(this);
        suiteBedrateBtn.addActionListener(this);
        return ratesPanel;

    }
    public JPanel bookDatePanel(){

        JPanel gridPanel = new JPanel(new GridLayout(6,1));
        JPanel datePanel = new JPanel();
        datePanel.setLayout(null);
        String[] num = {"1","2","3","4"};
        JComboBox guestnum = new JComboBox(num);

        JLabel numberOfGuest = new JLabel("number of guest");
        JLabel checkindate = new JLabel("check in date ");
        JLabel checkoutdate = new JLabel("checkout date ");
        JTextField checkinTextFiled = new JTextField();
        JTextField checkoutTextField = new JTextField();
        dateSelectsBtn = new JButton("check rates for selected dates");


        gridPanel.setBounds(205,150,350,170);
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
    public JPanel reservationDetailPanel(){
        JPanel gdpanel = new JPanel(new GridLayout(4,1));
        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(null);
        JLabel reservationlbl = new JLabel("room reservation details");
        proceedBtn = new JButton("proceed to payment");


        gdpanel.setBounds(205,150,300,200);

        gdpanel.add(reservationlbl);
        gdpanel.add(proceedBtn);
        detailPanel.add(gdpanel);
        proceedBtn.addActionListener(this);

        return detailPanel;


    }
    public JPanel UserInfoPanel(){
        JPanel gridPanel = new JPanel(new GridLayout(17,1,10,10));
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(null);

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

        confirmButton = new JButton("confirm and pay");

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
        JPanel completPanel = new JPanel();
        JLabel congratsOnResvLbl = new JLabel("resevation placed");
        completPanel.setLayout(null);
        congratsOnResvLbl.setBounds(100,500,200,35);
        completPanel.add(congratsOnResvLbl);


        return completPanel;
    }
    private JPanel AllroomsPannel(){
        JPanel panelAllRooms = new JPanel();
        //labels
        kingBedButton2.setText("KING Bedroom");
        queenBedButton2.setText("Queen Bedroom");
        suiteBedButton2.setText("suite");
        JLabel kinglabel = new JLabel();
        JLabel queenlabel = new JLabel();
        JLabel suitelabel = new JLabel();
        JLabel kingDescriptionLabel = new JLabel("<html>364 square feet of space<br>One King size bed <br>" +
                " 55 inch LED high definition television<br> In-room safe<br>Sofa<br>Maximum occupancy: 2 </html>");
        JLabel queenDescriptionLaabel = new JLabel("<html>364 square feet of space<br>two Queen beds <br>" +
                " 55 inch LED high definition television<br> In-room safe<br>Maximum occupancy: 4 </html>");
        JLabel suiteDescriptionLabel= new JLabel("<html>756 square feet of space<br>Separated living and sleeping area<br>One King size bed <br>" +
                " 55 inch LED high definition television<br> In-room safe<br>Wireless Internet access<br>Sofa and seating area for 4 </html>");
        //get room images
        kinglabel.setIcon(kingBedImage);
        queenlabel.setIcon(queenBedImage);
        suitelabel.setIcon(suiteBedImage);
        comboBox = new JComboBox(roomtype);

        //combobox
        comboBox.setSelectedIndex(0);

        //bounds
        comboBox.setBounds(800,0,100,50);
        kingBedButton2.setBounds(265,275,100,15);
        queenBedButton2.setBounds(225,575,150,15);
        suiteBedButton2.setBounds(225,875,150,15);
        kinglabel.setBounds(100,0,500,280);
        queenlabel.setBounds(100,200,500,475);
        suitelabel.setBounds(100,495,500,500);
        kingDescriptionLabel.setBounds(600,0,500,300);
        queenDescriptionLaabel.setBounds(600,200,500,500);
        suiteDescriptionLabel.setBounds(600,500,500,500);
        panelAllRooms.setBackground(new Color(255,218,185));

        //add buttons, box, and description label to panel
        panelAllRooms.add(kingBedButton2);
        panelAllRooms.add(queenBedButton2);
        panelAllRooms.add(suiteBedButton2);
        panelAllRooms.add(kinglabel);
        panelAllRooms.add(queenlabel);
        panelAllRooms.add(suitelabel);
        panelAllRooms.add(kingDescriptionLabel);
        panelAllRooms.add(queenDescriptionLaabel);
        panelAllRooms.add(suiteDescriptionLabel);
        panelAllRooms.add(comboBox);

        panelAllRooms.setLayout(null);

        //action listeners
        kingBedButton2.addActionListener(this);
        queenBedButton2.addActionListener(this);
        suiteBedButton2.addActionListener(this);
        comboBox.addActionListener(this);

        return panelAllRooms;
    }
    private JPanel kingOnlyPannel()
    {
        JPanel panelkingOnly = new JPanel();
        //labels
        JLabel kinglabel = new JLabel();

        JLabel kingDescriptionLaabel = new JLabel("<html>364 square feet of space<br>king bed <br>" +
                " 55 inch LED high definition television<br> In-room safe<br>Maximum occupancy: 2 </html>");

        //get image for kingbedroom
        kinglabel.setIcon(kingBedImage);

        //combobox for king panel
        comboBox2 = new JComboBox((roomtype));
        comboBox2.setSelectedIndex(1);
        //bounds
        comboBox2.setBounds(800,0,100,50);
        kingBedButton.setBounds(265,285,125,25);
        kinglabel.setBounds(100,0,500,300);
        kingDescriptionLaabel.setBounds(600,0,500,300);
        panelkingOnly.setBackground(new Color(255,218,185));



        kingBedButton.setText("king Bedroom");

        //add to panel
        panelkingOnly.add(kingBedButton);
        panelkingOnly.add(kinglabel);
        panelkingOnly.add(kingDescriptionLaabel);
        panelkingOnly.add(comboBox2);

        panelkingOnly.setLayout(null);


        //action listeners
        kingBedButton.addActionListener(this);
        comboBox2.addActionListener(this);

        return panelkingOnly;

    }
    private JPanel queenOnlyPannel()
    {
        JPanel panelQueenOnly = new JPanel();
        //labels
        JLabel RoomBannerLabel = new JLabel();
        JLabel queenlabel = new JLabel();
        JLabel queenDescriptionLaabel = new JLabel("<html>364 square feet of space<br>two Queen beds <br>" +
                " 55 inch LED high definition television<br> In-room safe<br>Maximum occupancy: 4 </html>");
        queenlabel.setIcon(queenBedImage);
        //combobox
        comboBox3 = new JComboBox((roomtype));
        comboBox3.setSelectedIndex(2);

        // bounds
        comboBox3.setBounds(800,0,100,50);
        queenBedButton.setBounds(265,285,125,25);
        queenlabel.setBounds(100,0,500,300);
        queenDescriptionLaabel.setBounds(600,0,500,300);
        panelQueenOnly.setBackground(new Color(255,218,185));

        //button & add to panel
        queenBedButton.setText("Queen Bedroom");
        panelQueenOnly.add(queenBedButton);

        panelQueenOnly.setLayout(null);

        panelQueenOnly.add(queenlabel);
        panelQueenOnly.add(queenDescriptionLaabel);
        panelQueenOnly.add(comboBox3);

        // listeners
        queenBedButton.addActionListener(this);
        comboBox3.addActionListener(this);

        return panelQueenOnly;

    }
    private JPanel suiteOnlyPannel(){
        JPanel panelSuiteOnly = new JPanel();
        //labels
        JLabel suitelabel = new JLabel();

        JLabel suiteDescriptionLabel= new JLabel("<html>756 square feet of space<br>Separated living and sleeping area<br>One King size bed <br>" +
                " 55 inch LED high definition television<br> In-room safe<br>Wireless Internet access<br>Sofa and seating area for 4 </html>");

        //combobox for suite panel
        comboBox4 = new JComboBox(roomtype);
        comboBox4.setSelectedIndex(3);
        //bounds
        comboBox4.setBounds(800,0,100,50);
        suitelabel.setBounds(100,0,500,300);
        panelSuiteOnly.setBackground(new Color(255,218,185));
        suiteDescriptionLabel.setBounds(600,0,500,300);
        suiteBedButton.setBounds(265,285,125,25);

        //adding buttons,box, descriptions to panel
        suiteBedButton.setText("suite");
        panelSuiteOnly.add(suiteBedButton);
        suitelabel.setIcon(suiteBedImage);
        //add combobox to suite panel
        panelSuiteOnly.add(comboBox4);
        panelSuiteOnly.add(suitelabel);
        panelSuiteOnly.add(suiteDescriptionLabel);


        panelSuiteOnly.setLayout(null);

        //action listeners
        suiteBedButton.addActionListener(this);

        comboBox4.addActionListener(this);

        return panelSuiteOnly;
    }

    public void RoomChoice(String name){

        JFrame popUpRoomTypeFrame = new JFrame("ROOMS");
        JPanel panel = new JPanel();


        if(name == "king")
        {
            image = new ImageIcon("kingbedroom.png");
            image2 = new ImageIcon("kingbedroom2.png");
            image3 = new ImageIcon("kingrestroom.png");
            image4 = new ImageIcon("kingrestroom2.png");
        }
        if(name == "queen")
        {
            image = new ImageIcon("queenbedroom.png");
            image2 = new ImageIcon("queenbedroom2.png");
            image3 = new ImageIcon("queenrestroom.png");
            image4 = new ImageIcon("queenrestroom2.png");
        }
        if(name == "suite")
        {
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
        if(name == "suite")
        {
            JLabel label5 = new JLabel();
            label5.setIcon(image5);
            panel.add(label5);
        }

        panel.setPreferredSize(new Dimension(1000,2800));

        JScrollPane scrollPane = new JScrollPane(panel);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        popUpRoomTypeFrame.getContentPane().add(scrollPane);
        popUpRoomTypeFrame.setSize(800,750);
        popUpRoomTypeFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==homebtn){
            cardlayout.show(MainPanel, "0");
        }
        if(e.getSource()==roomsbtn){
            cardlayout.show(MainPanel, "1");
        }
        if(e.getSource()==bookbtn){
            cardlayout.show(MainPanel,"5");
        }
        if(e.getSource()==dateSelectsBtn){
            cardlayout.show(MainPanel,"6");
        }
        if(e.getSource()==kingBedrateBtn){
            cardlayout.show(MainPanel,"7");
        }
        if(e.getSource()==queenBedrateBtn){
            cardlayout.show(MainPanel,"7");
        }
        if(e.getSource()==suiteBedrateBtn){
            cardlayout.show(MainPanel,"7");
        }
        if(e.getSource()==proceedBtn){
            cardlayout.show(MainPanel,"8");
        }
        if(e.getSource()==confirmButton){
            cardlayout.show(MainPanel,"9");
        }




        if(e.getSource()==kingBedButton2) {
            //frame.dispose();
            RoomChoice("king");
        }
        if(e.getSource()==queenBedButton2) {
            //frame.dispose();
            RoomChoice("queen");
        }
        if(e.getSource()==suiteBedButton2) {
            //frame.dispose();
            RoomChoice("suite");
        }
        if(e.getSource()==kingBedButton) {
            //frame.dispose();
            RoomChoice("king");
        }
        if(e.getSource()==queenBedButton) {
            //frame.dispose();
            RoomChoice("queen");
        }
        if(e.getSource()==suiteBedButton) {
            //frame.dispose();
            RoomChoice("suite");
        }
        if(e.getSource()==comboBox) {
            if (comboBox.getSelectedIndex() == 0) {
                cardlayout.show(MainPanel, "1");
                //comboBox.setSelectedIndex(0);
            } else if (comboBox.getSelectedIndex() == 1) {
                cardlayout.show(MainPanel, "2");
                comboBox.setSelectedIndex(0);
            } else if (comboBox.getSelectedIndex() == 2) {
                cardlayout.show(MainPanel, "3");
                comboBox.setSelectedIndex(0);
            } else if (comboBox.getSelectedIndex() == 3) {
                cardlayout.show(MainPanel, "4");
                comboBox.setSelectedIndex(0);
            }
            if(e.getSource()==proceedBtn){
                cardlayout.show(MainPanel,"7");
            }
        }
        if(e.getSource()==comboBox2){
            if(comboBox2.getSelectedIndex()==0)
            {
                cardlayout.show(MainPanel, "1");
                comboBox2.setSelectedIndex(1);
            }
            else if(comboBox2.getSelectedIndex()==1){
                cardlayout.show(MainPanel, "2");
                comboBox2.setSelectedIndex(1);
            }
            else if(comboBox2.getSelectedIndex()==2){
                cardlayout.show(MainPanel, "3");
                comboBox2.setSelectedIndex(1);
            }
            else if(comboBox2.getSelectedIndex()==3){
                cardlayout.show(MainPanel, "4");
                comboBox2.setSelectedIndex(1);
            }

        }
        if(e.getSource()==comboBox3){
            if(comboBox3.getSelectedIndex()==0)
            {
                cardlayout.show(MainPanel, "1");
                comboBox3.setSelectedIndex(2);
            }
            else if(comboBox3.getSelectedIndex()==1){
                cardlayout.show(MainPanel, "2");
                comboBox3.setSelectedIndex(2);
            }
            else if(comboBox3.getSelectedIndex()==2){
                cardlayout.show(MainPanel, "3");
                comboBox3.setSelectedIndex(2);
            }
            else if(comboBox3.getSelectedIndex()==3){
                cardlayout.show(MainPanel, "4");
                comboBox3.setSelectedIndex(2);
            }

        }
        if(e.getSource()==comboBox4){
            if(comboBox4.getSelectedIndex()==0)
            {
                cardlayout.show(MainPanel, "1");
                comboBox4.setSelectedIndex(3);
            }
            else if(comboBox4.getSelectedIndex()==1){
                cardlayout.show(MainPanel, "2");
                comboBox4.setSelectedIndex(3);
            }
            else if(comboBox4.getSelectedIndex()==2){
                cardlayout.show(MainPanel, "3");
                comboBox4.setSelectedIndex(3);
            }
            else if(comboBox4.getSelectedIndex()==3){
                cardlayout.show(MainPanel, "4");
                comboBox4.setSelectedIndex(3);
            }

        }

    }
    public static void main(String[] args)
    {
        HotelGUI h = new HotelGUI();


    }
}
