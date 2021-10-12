package za.ac.cput.mentalhealthapp.profile;

import javax.swing.*;

public class UserProfileGUI extends JFrame{

    private JPanel mainPanel;
    private JButton button1;
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


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
