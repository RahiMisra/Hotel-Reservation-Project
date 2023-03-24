import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {
	int count = 0;
	private JLabel label;
	private JPanel panel;
	private JFrame frame;
	private JButton button;

	public GUI() {

		frame = new JFrame();
		button = new JButton("Click me test");
		panel = new JPanel();
		label = new JLabel("Number of clicks: 0");

		panel.setBorder(BorderFactory.createEmptyBorder(500, 500, 150, 500));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button);
		panel.add(label);

		button.addActionListener(this);

		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Welcome to the Bug Byte League's Hotel Reservation System!");
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of clicks: " + count);
	}

}
