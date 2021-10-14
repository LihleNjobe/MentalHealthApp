package za.ac.cput.mentalhealthapp.counselling.GUIs;

import com.sun.org.apache.xpath.internal.operations.Div;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import org.jdatepicker.DateModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.springframework.ui.Model;
import sendinblue.ApiClient;
import sendinblue.Configuration;
import sendinblue.auth.ApiKeyAuth;
import sibApi.TransactionalEmailsApi;
import sibModel.*;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

public class BookingGUI {
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
    private JTextField txtOther;
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
    private JTextArea txtInfo;
    private JButton submitBtn;
    private JTextField txtStudentNum;
    private JLabel heading;
    private JTextField txtCounsellorName;
    private JLabel lblCounsellorName;
    private JPanel datePanel;
    private JTextArea txtFromEmail;
    private JTextArea txtStudentName;
    private JTextArea txtStudentPhoneNumber;
    Connection con;
    PreparedStatement pst;
    String first_name, last_name, email, phone_number;
    int student_number;
    String booking_type;
    String student_name;
    String name;
    public static int sNumber;
    String bookingReason;
    String counsellingDomain;
    String counsellingType;
    String counsellingExperience;
    private JFrame frame;
    Date selectedDate;

    public BookingGUI() {
        frame = new JFrame();
        frame.setTitle("Your bookings");
    }

    public void setGUI(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setSize(360, 600);
        frame.setVisible(true);
        centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        submitBtn.setPreferredSize(new Dimension(40, 30));
        student_name = first_name + " " + last_name;

        lblCounsellorName.setVisible(false);
        txtCounsellorName.setVisible(false);

        //CheckBox for Individual Counselling
        iCounsellingCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
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
                if (e.getStateChange() == 1) {
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
//                frame.dispose();
                new TableGUI().setGUI();
                new BookingDAO().RetrieveBookings(student_number);
//                sendEmailToStudent();
                sendEmailToCounsellor();
//                createEmailTemplate();
            }
        });

        //Return to counselling home page
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TableGUI().setGUI();
//                frame.dispose();
            }
        });
        anxietyCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookingReason = anxietyCheckBox.getText();
                depressionCheckBox.setSelected(false);
                stressCheckBox.setSelected(false);
                pastTraumeticStressDisorderCheckBox.setSelected(false);
                otherCheckBox.setSelected(false);
                System.out.println(bookingReason);
            }
        });
        depressionCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookingReason = depressionCheckBox.getText();
                anxietyCheckBox.setSelected(false);
                stressCheckBox.setSelected(false);
                pastTraumeticStressDisorderCheckBox.setSelected(false);
                otherCheckBox.setSelected(false);
            }
        });
        stressCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookingReason = stressCheckBox.getText();
                anxietyCheckBox.setSelected(false);
                depressionCheckBox.setSelected(false);
                pastTraumeticStressDisorderCheckBox.setSelected(false);
                otherCheckBox.setSelected(false);
            }
        });
        pastTraumeticStressDisorderCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookingReason = pastTraumeticStressDisorderCheckBox.getText();
                depressionCheckBox.setSelected(false);
                stressCheckBox.setSelected(false);
                anxietyCheckBox.setSelected(false);
                otherCheckBox.setSelected(false);
            }
        });
        otherCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookingReason = txtOther.getText();
                depressionCheckBox.setSelected(false);
                stressCheckBox.setSelected(false);
                pastTraumeticStressDisorderCheckBox.setSelected(false);
                anxietyCheckBox.setSelected(false);
            }
        });
        academicCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counsellingDomain = academicCheckBox.getText();
                careerCheckBox.setSelected(false);
                personalSocialCheckBox.setSelected(false);
            }
        });
        careerCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counsellingDomain = careerCheckBox.getText();
                academicCheckBox.setSelected(false);
                personalSocialCheckBox.setSelected(false);
            }
        });
        personalSocialCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counsellingDomain = personalSocialCheckBox.getText();
                careerCheckBox.setSelected(false);
                academicCheckBox.setSelected(false);
            }
        });
        iCounsellingCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counsellingType = iCounsellingCheckBox.getText();
                gCounsellingCheckBox.setSelected(false);
            }
        });
        gCounsellingCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counsellingType = gCounsellingCheckBox.getText();
                iCounsellingCheckBox.setSelected(false);
            }
        });
        yesRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String counsellor =  txtCounsellorName.getText();
                counsellingExperience = "Previously counselled by "+counsellor;
                noRadioButton.setSelected(false);
                lblCounsellorName.setVisible(true);
                txtCounsellorName.setVisible(true);
            }
        });
        noRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counsellingExperience = "None";
                yesRadioButton.setSelected(false);
                lblCounsellorName.setVisible(false);
                txtCounsellorName.setVisible(false);
            }
        });
    }

    public void sendEmailToStudent() {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        String studentName = new BookingDAO().RetrieveStudentName(student_number);
        System.out.println(studentName);
        // Configure API key authorization: api-key
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("api-key");
        apiKey.setApiKey("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");

        try {
            TransactionalEmailsApi api = new TransactionalEmailsApi();
            SendSmtpEmailSender sender = new SendSmtpEmailSender();
            sender.setEmail("cputproject3@gmail.com");
            sender.setName("Affirmations");
            java.util.List<SendSmtpEmailTo> toList = new ArrayList<SendSmtpEmailTo>();
            SendSmtpEmailTo to = new SendSmtpEmailTo();
            to.setEmail("lindokuhlepaul6@gmail.com");
            to.setName("Lindokuhle");
            toList.add(to);
            SendSmtpEmailReplyTo replyTo = new SendSmtpEmailReplyTo();
            replyTo.setEmail("replyto@domain.com");
            replyTo.setName("John Doe");
            Properties headers = new Properties();
            headers.setProperty("Some-Custom-Name", "unique-id-1234");
            Properties params = new Properties();
            params.setProperty("parameter", "My param value");
            params.setProperty("subject", "Booking Confirmation");
            params.setProperty("name", studentName);
            params.setProperty("bookingReason", bookingReason);
            params.setProperty("counsellingDomain", counsellingDomain);
            params.setProperty("counsellingType", counsellingType);
            params.setProperty("counsellingExperience", counsellingExperience);
            SendSmtpEmail sendSmtpEmail = new SendSmtpEmail();
            sendSmtpEmail.setSender(sender);
            sendSmtpEmail.setTo(toList);
            sendSmtpEmail.setTextContent("Hi " + student_name);
            sendSmtpEmail.setHtmlContent("<html>" +
                    "<body>" +
                    "<h1>Hi {{params.name}}</h1>" +
                    "<p>Thanks for booking a counselling session with CPUT. You've just taken an exciting " +
                    "wellness journey, and we're so glad to be part of if. Once your booking has reviewed, " +
                    "you will receive an email from the CPUT student counselling department with all " +
                    "the information you need for your appointment.</p>" +
                    "</body></html>");
            sendSmtpEmail.setSubject("{{params.subject}}");
            sendSmtpEmail.setReplyTo(replyTo);
            sendSmtpEmail.setHeaders(headers);
            sendSmtpEmail.setParams(params);
            sendSmtpEmail.setTemplateId(6L);
            CreateSmtpEmail response = api.sendTransacEmail(sendSmtpEmail);
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println("Exception occurred:- " + e.getMessage());
        }
    }

    public void sendEmailToCounsellor() {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        String studentName = new BookingDAO().RetrieveStudentName(student_number);
        String studentSurname = new BookingDAO().RetrieveStudentSurname(student_number);
        // Configure API key authorization: api-key
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("api-key");
        apiKey.setApiKey("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");

        try {
            TransactionalEmailsApi api = new TransactionalEmailsApi();
            SendSmtpEmailSender sender = new SendSmtpEmailSender();
            sender.setEmail("cputproject3@gmail.com");
            sender.setName("Affirmations");
            java.util.List<SendSmtpEmailTo> toList = new ArrayList<SendSmtpEmailTo>();
            SendSmtpEmailTo to = new SendSmtpEmailTo();
            to.setEmail("lindokuhlepaul6@gmail.com");
            to.setName("CPUT Student Counselling");
            toList.add(to);
            SendSmtpEmailReplyTo replyTo = new SendSmtpEmailReplyTo();
            replyTo.setEmail("replyto@domain.com");
            replyTo.setName("John Doe");
            Properties headers = new Properties();
            headers.setProperty("Some-Custom-Name", "unique-id-1234");
            Properties params = new Properties();
            params.setProperty("parameter", "My param value");
            params.setProperty("subject", "Request for counselling");
            params.setProperty("studentName", studentName);
            params.setProperty("studentSurname", studentSurname);
            params.setProperty("studentNumber", student_number+"");
            params.setProperty("bookingReason", bookingReason);
            params.setProperty("counsellingDomain", counsellingDomain);
            params.setProperty("counsellingType", counsellingType);
            params.setProperty("counsellingExperience", counsellingExperience);
            params.setProperty("date", String.valueOf(selectedDate));
            SendSmtpEmail sendSmtpEmail = new SendSmtpEmail();
            sendSmtpEmail.setSender(sender);
            sendSmtpEmail.setTo(toList);
            sendSmtpEmail.setTextContent("Hi " + student_name);
            sendSmtpEmail.setHtmlContent("<html>" +
                    "<body>" +
                    "<h1>Hi {{params.name}}</h1>" +
                    "<p>Thanks for booking a counselling session with CPUT. You've just taken an exciting " +
                    "wellness journey, and we're so glad to be part of if. Once your booking has reviewed, " +
                    "you will receive an email from the CPUT student counselling department with all " +
                    "the information you need for your appointment.</p>" +
                    "</body></html>");
            sendSmtpEmail.setSubject("{{params.subject}}");
            sendSmtpEmail.setReplyTo(replyTo);
            sendSmtpEmail.setHeaders(headers);
            sendSmtpEmail.setParams(params);
            sendSmtpEmail.setTemplateId(7L);
            CreateSmtpEmail response = api.sendTransacEmail(sendSmtpEmail);
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println("Exception occurred:- " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new BookingGUI().setGUI();
    }

    public static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

        private final String datePattern = "yyyy-MM-dd";
        private final SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        JLabel label = new JLabel("Select date");

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl dateP = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(dateP, new DateLabelFormatter());
        selectedDate = (Date) datePicker.getModel().getValue();
        datePanel = new JPanel();
        datePanel.add(label);
        datePanel.add(datePicker);

    }
}
