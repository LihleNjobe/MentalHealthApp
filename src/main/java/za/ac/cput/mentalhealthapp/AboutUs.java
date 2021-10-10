package za.ac.cput.mentalhealthapp;

import javax.swing.*;
import java.awt.*;


public class AboutUs extends JFrame {

    private JButton btnBack;
    private JTextArea ourAimIsToTextArea;
    private JTextArea takingCareOfYourTextArea;
    private JLabel lblAbout;
    private JLabel imgLogo;
    private JPanel aboutPanel;
    private JTextArea goToTheSignTextArea;
    private JLabel lblTut;
    private JFrame frame;

    public AboutUs(String title){
            super(title);
        imgLogo = new JLabel(new ImageIcon("Affirmation.jpg"));
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(aboutPanel);
            this.pack();

    }
    public void setAboutUs(){
        frame.add(imgLogo);
    }

    public static void main(String[] args){
        JFrame frame = new AboutUs("About Us");
        frame.setVisible(true);
    }

}

