import java.awt.*;


import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
public class ViewRooms implements ActionListener{
 
 private JFrame frame = new JFrame();
 private JButton kingBedButton = new JButton();
 private JButton queenBedButton = new JButton();
 private JButton suiteBedButton = new JButton();
 
 private JPanel panel;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    private String Roomname;
    private String imageName;
   
 ViewRooms(){
  
       ImageIcon kingImage = new ImageIcon("king.png");
        ImageIcon queenImage = new ImageIcon("queen.png");
        ImageIcon suiteImage = new ImageIcon("suitecover.png");
        JLabel kingLabel = new JLabel();
        JLabel queenLabel = new JLabel();
        JLabel suiteLabel = new JLabel(); 
      
        
        kingLabel.setIcon(kingImage);
        queenLabel.setIcon(queenImage);
        suiteLabel.setIcon(suiteImage); 
       
        
        kingLabel.setVerticalAlignment(JLabel.TOP); //24:11
        queenLabel.setVerticalAlignment(JLabel.TOP);
        suiteLabel.setVerticalAlignment(JLabel.TOP);
        kingLabel.setHorizontalAlignment(JLabel.LEFT);
        queenLabel.setHorizontalAlignment(JLabel.LEFT);
        suiteLabel.setHorizontalAlignment(JLabel.LEFT);
        kingLabel.setBounds(100,50,500,500);
        queenLabel.setBounds(100,350,500,500);
        suiteLabel.setBounds(100,650,500,500);
        
        frame.setTitle(" HOTEL rooms");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2000,2000);
        frame.setLayout(null);
        frame.setVisible(true);
        //pack 29:00
        frame.add(kingLabel); // add label to gui
        frame.add(queenLabel);
        frame.add(suiteLabel);
        frame.getContentPane().setBackground(Color.white);
        
        
        kingBedButton.setBounds(550,210,100,50);
        kingBedButton.setText("KING Bedroom");
        frame.add(kingBedButton);
        
        
        queenBedButton.setBounds(550,450,150,50);
        queenBedButton.setText("Queen Bedroom");
        frame.add(queenBedButton);
        
        
        suiteBedButton.setBounds(550,750,150,50);
        suiteBedButton.setText("suite");
        frame.add(suiteBedButton);
        

  
  kingBedButton.setFocusable(false);
  kingBedButton.addActionListener(this);
  
  queenBedButton.setFocusable(false);
  queenBedButton.addActionListener(this);
  
  suiteBedButton.setFocusable(false);
  suiteBedButton.addActionListener(this);
  
 
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  frame.setLayout(null);
  frame.setVisible(true);
  
 }
 public void RoomChoice(String name){
      
  JFrame frame = new JFrame("ROOMS");
        JPanel panel = new JPanel();
        
         ImageIcon image = null;
         ImageIcon image2 = null; 
         ImageIcon image3 = null; 
         ImageIcon image4 = null; 
         ImageIcon image5 = null; 
       
        
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
        
        
        
        frame.getContentPane().add(scrollPane);
        frame.setSize(800,750);
        frame.setVisible(true);
       
 }
 @Override
 public void actionPerformed(ActionEvent e) {
  
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
 }
}
