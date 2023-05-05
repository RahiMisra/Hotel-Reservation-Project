import javax.swing.*;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelReservationSystem extends JFrame {
    private JButton loginButton, createAccountButton, contactStaffButton;
    private JLabel welcomeLabel, usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public HotelReservationSystem() {
        setTitle("Bug-Byte Hotel Reservation System");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

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
        add(panel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
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
    }

    private void login() {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
    
        Connection con = DatabaseMethods.getConnection(); // get a database connection
        if (DatabaseMethods.testDatabaseconnection(con)) { // check if the connection is successful
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            try {
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) { // user exists in database
                    JOptionPane.showMessageDialog(this, "You have successfully logged in.");
    
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
                    editAccountPanel.add(new JButton("Save Changes"), c);
    
                    editAccountFrame.add(editAccountPanel);
    
                    editAccountFrame.setVisible(true);
                } else { // user does not exist in database
                    JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    

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
    
        int result = JOptionPane.showConfirmDialog(null, panel, "Create Account",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
        if (result == JOptionPane.OK_OPTION) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String phoneNumber = phoneNumberField.getText();
            String email = emailField.getText();
            String password = String.valueOf(passwordField.getPassword());
            String paymentMethod = (String) paymentMethodCombo.getSelectedItem();

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    // code to save user information to database goes here
                    // this code will be executed when the createAccountButton is clicked
             
            Connection con = DatabaseMethods.getConnection(); // get a database connection
            if (DatabaseMethods.testDatabaseconnection(con)) { // check if the connection is successful
                String firstName = "";
                String lastName = "";
                String phoneNumber = "";
                String email = "";
                String password = "";
                String paymentMethod = "";
                DatabaseMethods.createAccount(con, firstName,lastName, phoneNumber, email, password, paymentMethod);
                JOptionPane.showMessageDialog(panel,"Account created successfully!");
            }
        }
    });

        }
    }
    
    private void contactStaff() {
        JFrame contactStaffFrame = new JFrame("Contact Staff");
        contactStaffFrame.setSize(600, 500);
        contactStaffFrame.setLocationRelativeTo(null);
    
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
    
    public static void main(String[] args) {
        HotelReservationSystem app = new HotelReservationSystem();
        app.setVisible(true);
    }
}    
