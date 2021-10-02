package za.ac.cput.mentalhealthapp.counselling.GUIs;

import za.ac.cput.mentalhealthapp.counselling.DAO.BookingDAO;
import za.ac.cput.mentalhealthapp.counselling.ModelClasses.Booking;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.ByteBuffer;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;
import java.util.UUID;
import javax.mail.internet.MimeMessage;

public class BookingGUI extends JFrame {
    private JPanel topPanel;
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JButton submitButton;
    private JButton backBtn;
    private JPanel bookingReasonPanel;
    private JPanel optionsPanel;
    private JCheckBox anxietyCheckBox;
    private JCheckBox depressionCheckBox;
    private JCheckBox stressCheckBox;
    private JCheckBox pastTraumeticStressDisorderCheckBox;
    private JCheckBox otherCheckBox;
    private JTextField textField1;
    private JPanel counsellingDomainPanel;
    private JCheckBox academicCheckBox;
    private JCheckBox careerCheckBox;
    private JCheckBox personalSocialCheckBox;
    private JPanel counsellingTypePanel;
    private JCheckBox iCounsellingCheckBox;
    private JCheckBox gCounsellingCheckBox;
    private JPanel counsellingHistoryPanel;
    private JPanel radioBtnPanel;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private JPanel infoPanel;
    private JTextArea textArea1;
    private JButton submitBtn;
    private JTextField txtStudentNum;
    private JLabel heading;
    private JTextArea txtFromEmail;
    private JTextArea txtStudentName;
    private JTextArea txtStudentPhoneNumber;
    Connection con;
    PreparedStatement pst;
    String first_name, last_name, email, phone_number;
    int student_number;
    String booking_type;
    String student_name;
    public static int sNumber;

    public BookingGUI(){
        super("Book Session");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(360, 600);
        this.setVisible(true);
        centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        submitBtn.setPreferredSize(new Dimension(40, 30));
        //student_number = Integer.parseInt(txtStudentNum.getText());
        new BookingDAO().Connect();
        new BookingDAO().RetrieveStudentData();
        student_name = first_name + " " + last_name;

        //CheckBox for Individual Counselling
        iCounsellingCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                  booking_type = "Individual counselling";
                }
            }
        });

        backBtn.setForeground(Color.WHITE);
        heading.setForeground(Color.WHITE);

        //CheckBox for Group Counselling
        gCounsellingCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                    booking_type = "Group counselling";
                }
            }
        });

        //Add record to database and submit form
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String booking_id = Long.toString(ByteBuffer.wrap(UUID.randomUUID()
                        .toString().getBytes()).getLong(), Character.MAX_RADIX);
                LocalDate date;
                date = LocalDate.now();
                student_number = Integer.parseInt(txtStudentNum.getText());
                Booking booking = new Booking(booking_id, booking_type, date, student_number);
                new BookingDAO().AddBooking(booking, student_number);

                new BookingDAO().Connect();
                new BookingDAO().RetrieveBookings(218196504);
                new TableGUI().setGUI();
                //this.setVisible(false);
                BookingGUI.this.setVisible(false);
                try {
                    sendMail("lindokuhlepaul6@gmail.com");
                } catch (MessagingException messagingException) {
                    messagingException.printStackTrace();
                }
            }
        });

        //Return to counselling home page
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TableGUI().setGUI();
                this.setVisible(false);
            }

            private void setVisible(boolean b) {
            }
        });
    }

    //Send booking info via email
    public void sendMail(String recepient) throws MessagingException {

        JOptionPane.showMessageDialog(this,"Successfully Submitted!");

        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

//        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
//        properties.setProperty("mail.smtp.port", "465");
//        properties.setProperty("mail.smtp.socketFactory.port", "465");

        final String FromEmail = "cputproject3@gmail.com";
        final String FromEmailPassword = "FinalProject@2021";

        Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(FromEmail, FromEmailPassword);
            }
        });

        Message message = prepareMessage(session, FromEmail, recepient);

            Transport.send(message);
            System.out.println("Message sent successfully");


    }

    private Message prepareMessage(Session session, String FromEmail, String recepient){

        String subject = "Counselling Booking";
        String emailText = "Good day Ma'am / Sir" +
                "\n I would like to book a counseling session";

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(subject);
            message.setText(emailText);
            return message;
        } catch (Exception ex){
            System.out.println(""+ex);
        }
        return null;
    }

    public static void main(String[] args) {
        new BookingGUI();
    }



}
