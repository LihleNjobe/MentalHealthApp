package za.ac.cput.mentalhealthapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel lbluserName = new JLabel("Username");
    JLabel lblPassword = new JLabel("Password");
    JLabel lblForgot = new JLabel("Forgot Password?");
    JLabel lblMessage = new JLabel();

    HashMap<Integer, String> loginInfo = new HashMap<Integer, String>();

    Login(HashMap<Integer, String>loginInfoMain){

        loginInfo = loginInfoMain;

        lbluserName.setBounds(50,100,75,25);
        lblPassword.setBounds(50,150,75,25);
        lblForgot.setBounds(50,200,120,25);

        lblMessage.setBounds(125,300,250,35);

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,250,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        frame.add(lbluserName);
        frame.add(lblPassword);
        frame.add(lblMessage);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(lblForgot);
        frame.add(loginButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()== loginButton){
            int userID = Integer.parseInt(userIDField.getText());
            String password = String.valueOf(userPasswordField.getPassword());

            if(loginInfo.containsKey(userID)){
                if(loginInfo.get(userID).equals(password)){
                    lblMessage.setForeground(Color.green);
                    lblMessage.setText("Login Successful");
                    //frame.dispose();
                    //SymptomsPage symptoms = new SymptomsPage();

                }
                else{
                    lblMessage.setForeground(Color.red);
                    lblMessage.setText("Incorrect credentials");
                }
            }
            else{
                lblMessage.setForeground(Color.ORANGE);
                lblMessage.setText("User not found");
            }
        }
    }


}
