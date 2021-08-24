package za.ac.cput.mentalhealthapp.counselling;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;
import java.util.UUID;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;

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
    private JTextArea txtFromEmail;
    private JTextArea txtStudentName;
    private JTextArea txtStudentPhoneNumber;
    Connection con;
    PreparedStatement pst;
    String first_name, last_name, email, phone_number;
    int student_number;
    String booking_type;

    public BookingGUI(){
        super("Book Session");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(360, 600);
        centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        submitBtn.setPreferredSize(new Dimension(40, 30));
        Connect();
        Retrieve();

        //CheckBox for Individual Counselling
        iCounsellingCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1){
                  booking_type = "Individual counselling";
                }
            }
        });

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
                AddRecords();
                submitForm();
            }
        });

        //Return to counselling home page
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CounsellingGUI().setGUI();
                this.setVisible(false);
            }

            private void setVisible(boolean b) {
            }
        });
    }

    //Send booking info via email
    public void submitForm(){
        String ToEmail = "lindokuhlepaul6@gmail.com";
        final String FromEmail = "lindokuhlepaul6@gmail.com";
        final String FromEmailPassword = "as3minathi";
        String subject = "Counselling Booking";
        String emailText = "Good day Ma'am / Sir" +
                "\n I would like to book a counseling session";

        JOptionPane.showMessageDialog(this,"Successfully Submitted!");

        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(FromEmail, FromEmailPassword);
            }

        });

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail));
            message.setSubject(subject);
            message.setText(emailText);
            Transport.send(message);
        } catch (Exception ex){
            System.out.println(""+ex);
        }

    }

    //Connect to MySQL Database
    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/affirmation", "root","");
            System.out.println("Success");
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    //Add records to Bookings table in database
    public void AddRecords(){
        UUID booking_id = UUID.randomUUID();
        String student_name;
        LocalDate date;
        student_name = first_name + " " + last_name;
        date = LocalDate.now();

        try {
            pst = con.prepareStatement("insert into bookings(booking_id,booking_type,date,student_name,student_number)values(?,?,?,?,?)");
            pst.setString(1, String.valueOf(booking_id));
            pst.setString(2, booking_type);
            pst.setString(3, date+"");
            pst.setString(4, student_name);
            pst.setInt(5, student_number);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Record Added!!!!");
        }
        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }

    //Retrieve data from database
    public void Retrieve(){
        try {

            student_number = 218196504;
            pst = con.prepareStatement("select first_name,last_name,email,phone_number from students where student_number = ?");
            pst.setInt(1, student_number);
            ResultSet rs = pst.executeQuery();

            if(rs.next()==true)
            {
                first_name = rs.getString(1);
                last_name = rs.getString(2);
                email = rs.getString(3);
                phone_number = rs.getString(4);

                System.out.println(first_name);
                System.out.println(last_name);
                System.out.println(email);
                System.out.println(phone_number);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid Student");

            }
        }

        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }



}
