
/*

import javax.swing.*;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;

public class HotelReservationSystem extends JFrame {
    private JButton loginButton, createAccountButton;
    private JLabel welcomeLabel, usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public HotelReservationSystem() {
        setTitle("Bug-Byte Hotel Reservation System");
        setSize(400, 300);
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
    }

    private void login() {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        
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
    }
    
    public static void main(String[] args) {
        HotelReservationSystem app = new HotelReservationSystem();
        app.setVisible(true);
    }
}
    
 */
