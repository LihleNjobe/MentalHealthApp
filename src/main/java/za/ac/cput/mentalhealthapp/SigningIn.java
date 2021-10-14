package za.ac.cput.mentalhealthapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SigningIn extends JFrame{
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JLabel lblForgo;
    private JLabel lblPassword;
    private JLabel lblUsername;
    private JPanel Main;
    private JButton signInButton;
    private JLabel lblLogin;


    public SigningIn(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(Main);
        this.pack();
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(360, 400);
    }

public static void main(String[]args){
        JFrame frame = new SigningIn("Sign In");
    frame.setVisible(true);
}

}
