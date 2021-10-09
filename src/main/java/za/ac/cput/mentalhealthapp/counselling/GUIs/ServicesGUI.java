package za.ac.cput.mentalhealthapp.counselling.GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServicesGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JButton button1;
    private JPanel centerPanel;
    private JTextArea TextArea;
    private JLabel txtHeading1;
    private JLabel txtHeading2;
    private JTextArea TextArea2;

    public ServicesGUI() {
        super("Services");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(360, 600);
        this.setVisible(true);

        TextArea.setLineWrap(true);

        TextArea.setBorder(BorderFactory.createCompoundBorder(
                centerPanel.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        TextArea.setForeground(Color.WHITE);

        txtHeading1.setForeground(Color.WHITE);

        txtHeading2.setForeground(Color.WHITE);

        txtHeading2.setBackground(new Color(19, 160, 254));

        TextArea2.setForeground(Color.WHITE);

        TextArea2.setBorder(BorderFactory.createCompoundBorder(
                centerPanel.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        button1.setBackground(new Color(19, 160, 254));
        button1.setForeground(Color.WHITE);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                ServicesGUI.this.dispose();
                new CounsellingGUI().setGUI();
            }
        });
    }

    public static void main(String[] args) {
        new ServicesGUI();
    }

}

