package za.ac.cput.mentalhealthapp.counselling.DAO;

import za.ac.cput.mentalhealthapp.counselling.ModelClasses.Student;

import javax.swing.*;
import java.sql.*;

public class StudentDAO {
    Connection con;
    PreparedStatement pst;
    String first_name, last_name, email, phone_number;
    int student_number;

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

    //Retrieve data from database
    public void RetrieveStudentData(){
        try {

//            student_number = Integer.parseInt(txtStudentNum.getText());
//            pst = con.prepareStatement("select first_name,last_name,email,phone_number from students where student_number = ?");
            pst = con.prepareStatement("select student_number,first_name,last_name,email,phone_number from students");
//            pst.setInt(1, student_number);
            ResultSet rs = pst.executeQuery();

            if(rs.next())
            {
                student_number = rs.getInt(1);
                first_name = rs.getString(2);
                last_name = rs.getString(3);
                email = rs.getString(4);
                phone_number = rs.getString(5);


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
