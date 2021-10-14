package za.ac.cput.mentalhealthapp.profile;

import za.ac.cput.mentalhealthapp.auth.SignIn;
import za.ac.cput.mentalhealthapp.counselling.GUIs.CounsellingGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfileGUI extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JLabel profilePic;
    private JButton logOutButton;
    private JButton aboutUsButton;


    public UserProfileGUI() {
        super("User Profile");

    }

    public void setGUI() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(360, 650);
        this.setContentPane(mainPanel);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Log Out")) {


            JFrame frame = new SignIn();
            new SignIn().SignIn();

            this.setVisible(false);

        }
/*
        if (e.getActionCommand().equals("About Us")) {


            JFrame frame = new

            this.setVisible(false);

        }
        if (e.getActionCommand().equals("About Us")) {


            JFrame frame = new SignIn();
            new SignIn().SignIn();

            this.setVisible(false);

        }

*/

    }
}
