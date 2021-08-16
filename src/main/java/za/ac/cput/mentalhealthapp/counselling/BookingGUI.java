package za.ac.cput.mentalhealthapp.counselling;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookingGUI extends JFrame implements ActionListener {
    private JPanel topPanel;
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JCheckBox eMailCheckBox;
    private JCheckBox homePhoneCheckBox;
    private JCheckBox cellPhoneCheckBox;
    private JTextArea textArea1;
    private JCheckBox yesCheckBox;
    private JCheckBox noCheckBox;
    private JTextArea haveYouSeenATextArea;
    private JTextArea textArea2;
    private JTextField textField6;
    private JTextArea pleaseDescribeAnyOtherTextArea;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JButton submitButton;
    private JScrollPane scroller;
    private JButton backBtn;

    public BookingGUI(){
        super("Book Session");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(360, 600);
        centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        textArea1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        submitButton.setPreferredSize(new Dimension(40, 30));
        backBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("<")){
            new CounsellingGUI().setGUI();
            this.setVisible(false);
        }

    }


}
