package za.ac.cput.mentalhealthapp.counselling.GUIs;

import za.ac.cput.mentalhealthapp.counselling.DAO.BookingDAO;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import static za.ac.cput.mentalhealthapp.counselling.GUIs.CounsellingGUI.vecArr;

public class TableGUI extends JFrame implements ActionListener {

    private JPanel northPanel, centerPanel, southPanel;
    private JButton  btnBack, btnNewBooking;
    private JTable tblBookings;
    private JLabel lblHeading;
    private Font ft1, ft2, ft3;
    Connection con;
    PreparedStatement pst;

    public TableGUI(){
        super("Bookings");
        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        tblBookings = new JTable();
        btnBack = new JButton("<");
        btnNewBooking = new JButton("New Booking");
        lblHeading = new JLabel("Your Bookings", JLabel.CENTER);

        ft1 = new Font("Arial", Font.BOLD, 26);
        ft2 = new Font("Arial", Font.BOLD, 20);
        ft3 = new Font("Arial", Font.PLAIN, 18);
        new BookingDAO().Connect();

    }

    public void setGUI(){
        northPanel.setLayout(new FlowLayout());
        northPanel.add(lblHeading);
        lblHeading.setFont(ft2);
        //lblHeading.setPreferredSize(new Dimension(500,150));
        lblHeading.setForeground(Color.white);
        northPanel.setBackground(new Color(15, 160, 254));
        btnBack.setFont(ft1);
        btnBack.setBackground(new Color(15, 160, 254));
        northPanel.add(btnBack, BorderLayout.WEST);
        northPanel.add(lblHeading);

        btnBack.setForeground(Color.WHITE);
        btnBack.setHorizontalAlignment(SwingConstants.LEFT);

        centerPanel.setBackground(Color.WHITE);
        displayBookings();

        southPanel.setLayout(new GridLayout(1, 1));
        btnNewBooking.setFont(ft3);
        btnNewBooking.setBackground(new Color(15, 160, 254));
        btnNewBooking.addActionListener(this);
        btnBack.addActionListener(this);
        southPanel.add(btnNewBooking);

        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        this.setPreferredSize(new Dimension(360, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

    public void displayBookings(){

        //Set table title
        centerPanel.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                "Bookings",
                TitledBorder.CENTER,
                TitledBorder.TOP));

        String[] columnNames = { "booking_id", "booking_type", "date" };

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        // The 0 argument is number rows.
        Vector vect = new Vector();
        ArrayList<Vector> arrVec;

        arrVec = (ArrayList<Vector>) vecArr;

        for (int i = 0; i < arrVec.size(); i++) {
            vect = arrVec.get(i);
            tableModel.addRow(vect);
        }

        tblBookings = new JTable(tableModel);
        JScrollPane sp = new JScrollPane(tblBookings);
        centerPanel.add(sp);

        tblBookings.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                JFrame frame = new JFrame();
                JPanel panel = new JPanel();
                JButton btnDelete = new JButton("Delete row");
                JButton btnClose = new JButton("Close");
                panel.setLayout(new GridLayout(2, 1));
                panel.add(btnDelete);
                panel.add(btnClose);
                frame.add(panel);
                frame.pack();
                frame.setVisible(true);
                frame.setLocation(180, 300);

                btnDelete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String bid;
                        bid = tblBookings.getValueAt(tblBookings.getSelectedRow(), 0).toString();

                        new BookingDAO().deleteBooking(bid);


                    }
                });
                btnClose.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                    }
                });

            }
        });
        sp.setPreferredSize(new Dimension(340, 600));

    }

    public static void main(String[] args) {
        new TableGUI().setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New Booking")) {
            this.setVisible(false);
            new BookingGUI();
        }
        if (e.getActionCommand().equals("<")) {
            this.setVisible(false);
            new CounsellingGUI().setGUI();
        }
    }
}
