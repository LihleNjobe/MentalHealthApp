package za.ac.cput.mentalhealthapp.counselling.GUIs;

import za.ac.cput.mentalhealthapp.counselling.DAO.BookingDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class CounsellingGUI extends JFrame{
    private JPanel mainPanel;
    private JPanel topPanel;
    private JLabel logoLabel;
    private JPanel centerPanel;
    private JLabel introLabel;
    private JTextPane introText;
    private JButton servicesButton;
    private JButton bookingsBtn;
    private JButton supportGroupsButton;
    Connection con;
    PreparedStatement pst;
    String first_name, last_name, email, phone_number;
    int student_number;
    String booking_type;
    Date date;
    String student_name;
    public static String bookingData;
    public static ArrayList<Vector> vecArr = new ArrayList<>();


    public CounsellingGUI(){
        super("Student Counselling");

        bookingsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookingDAO().Connect();
                new BookingDAO().RetrieveBookings(218896555);
                new TableGUI().setGUI();
                //this.setVisible(false);
                CounsellingGUI.this.setVisible(false);
            }
        });
    }

    public void setGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(360, 600);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CounsellingGUI().setGUI();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //logoLabel = new JLabel(new ImageIcon("images/logo.png"));
        logoLabel = new JLabel();
        ImageIcon logoIcon = new ImageIcon(new ImageIcon("images/logo.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        logoLabel.setIcon(logoIcon);

    }

}
