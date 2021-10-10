package za.ac.cput.mentalhealthapp.counselling.GUIs;

import za.ac.cput.mentalhealthapp.counselling.DAO.BookingDAO;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class CounsellingGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JLabel logoLabel;
    private JPanel centerPanel;
    private JLabel introLabel;
    private JTextPane introText;
    private JButton servicesButton;
    private JButton bookingsBtn;
    private JButton supportGroupsButton;
    private JPanel southPanel;
    private JPanel navPanel;
    private JButton homeButton;
    private JButton profileButton;
    private JButton counsellingButton;
    public static ArrayList<Vector> vecArr = new ArrayList<>();

    public CounsellingGUI() {
        super("Student Counselling");

    }

    public void setGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        StyledDocument doc = introText.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        introText.setForeground(Color.WHITE);
        introLabel.setForeground(Color.WHITE);

        this.pack();
        this.setSize(360, 600);
        this.setVisible(true);

        bookingsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                CounsellingGUI.this.dispose();
                new BookingDAO().Connect();
                new BookingDAO().RetrieveBookings(218196504);
                new TableGUI().setGUI();
            }
        });
        servicesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ServicesGUI();
            }
        });
        supportGroupsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SadagGUI().setupUI();
            }
        });
    }

    public static void main(String[] args) {
        new CounsellingGUI().setGUI();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        logoLabel = new JLabel();
        ImageIcon logoIcon = new ImageIcon(new ImageIcon("images/logo.png").getImage().
                getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        logoLabel.setIcon(logoIcon);

    }

}
