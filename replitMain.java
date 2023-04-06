
/*import javax.swing.*;
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

        //event listener 
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
    }

    private void createAccount() {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        JOptionPane.showMessageDialog(this, "You have created a new account.");
    }

    public static void main(String[] args) {
        HotelReservationSystem app = new HotelReservationSystem();
        app.setVisible(true);
    }
}
 */
