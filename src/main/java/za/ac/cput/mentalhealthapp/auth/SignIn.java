package za.ac.cput.mentalhealthapp.auth;

import javax.swing.*;
import java.awt.*;

public class SignIn extends JFrame {
    private JFrame mainFrame;
    private JPanel panelNorth, panelCenter, panelSouth;
    private JLabel lblUsername;
    private JLabel lblAffirm,lblForgot;
    private JLabel lblSign;
    private JTextField txtUsername;
    private JLabel lblPassword;
    private JTextField txtPassword;
    private JButton btnSignIn;
    private Font ft1, ft2;

    public SignIn() {
        super("Sign In");
        mainFrame = new JFrame("Sign In");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        lblAffirm = new JLabel("Affirmation");
        lblSign = new JLabel("Sign In");
        lblUsername = new JLabel("Username");
        txtUsername = new JTextField();
        lblPassword = new JLabel("Password");
        txtPassword = new JTextField();
        btnSignIn = new JButton("Continue");
        lblForgot = new JLabel("Forgot Password?");

        ft1 = new Font("Arial", Font.BOLD, 30);
        ft2 = new Font("Arial", Font.PLAIN, 20);

    }

    public void SignIn() {
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(new Color(19, 162, 254));
        panelCenter.setLayout(new GridLayout(6, 1));
        panelCenter.setBackground(new Color(19, 162, 254));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelSouth.setBackground(new Color(19, 162, 254));

        panelNorth.add(lblAffirm);
        lblAffirm.setFont(ft1);
        panelCenter.add(lblSign);
        lblSign.setFont(ft1);
        panelCenter.add(lblUsername);
        panelCenter.add(txtUsername);
        panelCenter.add(lblPassword);
        panelCenter.add(txtPassword);
        panelCenter.add(lblForgot);
        txtUsername.setBackground(new Color(19, 162, 254));
        txtPassword.setBackground(new Color(19, 162, 254));
        panelSouth.add(btnSignIn);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setPreferredSize(new Dimension(600, 300));
        this.pack();
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new SignIn().SignIn();
    }
}
