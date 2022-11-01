
/**
 * Write a description of class DistanceConverter here.
 *
 * @author (Hanif Yuli Abdillah P)
 * @version (Lab 7 - GUI No Event Listener 2/5/2019)
 * @version (Lab 8 - GUI With Event Listener 16/5/2019)
 */

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class DistanceConverter
{
   /// Atribute dalam aplikasi
   private JPanel panel1,panel2,panel3; 
   private JLabel label1;
   private JTextField tfDistance;
   private JRadioButton rbToMiles, rbToFeet, rbToInches;
   private ButtonGroup bg;
   private JButton btnCalculate, btnClose;
   
   
   //Membuat Frame 
   public DistanceConverter() {
       JFrame frame = new JFrame("Distance Converter");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       createAndShowGUI();
       frame.add(panel1,BorderLayout.NORTH);
       frame.add(panel2,BorderLayout.CENTER);
       frame.add(panel3,BorderLayout.SOUTH);
       frame.pack();
       frame.setSize(400,150);
       frame.setVisible(true);
   }
   
   //Untuk menampilkan semua attribute
   public void createAndShowGUI() {
       //PANEL 1==========================
       panel1 = new JPanel();
       label1 = new JLabel("Enter the distance in kilometers: ");
       tfDistance = new JTextField(15);
       
       panel1.add(label1,BorderLayout.WEST);
       panel1.add(tfDistance,BorderLayout.WEST);
       
       //PANEL 2==========================
       panel2 = new JPanel();  
       rbToMiles = new JRadioButton("Convert To Miles");
       rbToFeet = new JRadioButton("Convert To Feet");
       rbToInches = new JRadioButton("Convert To Inches");
       
       bg = new ButtonGroup();
       bg.add(rbToMiles);
       bg.add(rbToFeet);
       bg.add(rbToInches);
       
       //Mengatur warna background panel2
       //panel2.setBackground(Color.white);
       
       panel2.add(rbToMiles);
       panel2.add(rbToFeet);
       panel2.add(rbToInches);
       
       //PANEL 3==========================       
       panel3 = new JPanel();
       btnCalculate = new JButton("Calculate");
       btnClose = new JButton("Close");
       
       bg = new ButtonGroup();
       bg.add(btnCalculate);
       bg.add(btnClose); 
       
       panel3.add(btnCalculate);
       panel3.add(btnClose);
       
       //MENAMPUNG DATA DARI TEXT FIELD DISTANCE
       String text = tfDistance.getText();
       
       //Add listener to element
       btnCalculate.addActionListener(new CalculateButtonListener());
       btnClose.addActionListener(new CloseButtonListener());
   }
   
   //ADD LISTENER FOR CLOSE BUTTON
   public static class CloseButtonListener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           System.exit(0);
       }
   }
   
   // ADD LISTENER FOR CALCULATE BUTTON
   public class CalculateButtonListener implements ActionListener {       
       public void actionPerformed(ActionEvent e) {
           String distance = tfDistance.getText();
           double convertedDistance = 0.0;
           
           //if(distance.equals(null)) {
               //JOptionPane.showMessageDialog(null,"Choose One Of The Radio Button, Please");
           //}
           
           if(rbToMiles.isSelected()) {
               convertedDistance = Double.parseDouble(distance)*0.6214;
               JOptionPane.showMessageDialog(null,distance + " Km = " + convertedDistance + " Miles","Conversion",JOptionPane.PLAIN_MESSAGE);
           }
           else if(rbToFeet.isSelected()) {
               convertedDistance = Double.parseDouble(distance)*3281.0;
               JOptionPane.showMessageDialog(null,distance + " Km = " + convertedDistance + " Feet","Conversion",JOptionPane.PLAIN_MESSAGE);
           }
           else if(rbToInches.isSelected()) {
               convertedDistance = Double.parseDouble(distance)*39370.0;
               JOptionPane.showMessageDialog(null,distance + " Km = " + convertedDistance + " Inches","Conversion",JOptionPane.PLAIN_MESSAGE);
           }
           else {
               JOptionPane.showMessageDialog(null,"Choose One Of The Radio Button, Please","Conversion",JOptionPane.PLAIN_MESSAGE);
           }
       }
   }
   
   // SHOW THE PROGRAM
   public static void main(String[] args) {
       new DistanceConverter();
   }
}
