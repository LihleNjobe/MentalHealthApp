package za.ac.cput.mentalhealthapp.DAO;

import javax.swing.*;
import java.sql.*;

public class StudentDatabase {

    public static final String CONNECTION = "jdbc:ucanaccess://student_database.accdb";

    private static Connection connection;

    public static boolean connectToDatabase(){

        try {
            connection = DriverManager.getConnection(CONNECTION);
            return true;

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean insertToTable(String id, String fname, String lname, String email, char[] pword){

        try {

            String insertData = "INSERT INTO STUDENT_DETAILS (StudentNumber, FirstName, LastNAme, Email, Password)" +
                    " VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(insertData);

            ps.setString(1, id);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, email);
            ps.setString(5, pword.toString());

            int row = ps.executeUpdate();

            if (row == 1){

                return true;
            }
            return false;

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean checkUserExistence(String studentNumber) {

        try {
            connection = DriverManager.getConnection(CONNECTION);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String query = "SELECT 1 FROM STUDENT_DETAILS WHERE StudentNumber = ? ";

        try{
            PreparedStatement ps = connection.prepareStatement(query);

            if (ps != null){
                ps.setString(1, studentNumber);

                try{
                    ResultSet resultSet = ps.executeQuery();
                    if (resultSet != null){
                        try {
                            if (resultSet.next()){
                                return true;
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                ps.close();
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    public static String createTable(){

        String create_table_statement = "create table STUDENT_DETAILS (StudentNumber VARCHAR(30), FirstName VARCHAR(30)," +
                "LastName VARCHAR(30), Email VARCHAR(30), Password VARCHAR(30))";

        return create_table_statement;

    }


}