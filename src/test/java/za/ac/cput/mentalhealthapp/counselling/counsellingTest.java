package za.ac.cput.mentalhealthapp.counselling;

import org.junit.jupiter.api.*;
import za.ac.cput.mentalhealthapp.counselling.DAO.BookingDAO;
import za.ac.cput.mentalhealthapp.counselling.GUIs.BookingGUI;
import za.ac.cput.mentalhealthapp.counselling.GUIs.CounsellingGUI;
import za.ac.cput.mentalhealthapp.counselling.ModelClasses.Booking;

import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
class counsellingTest {

    String booking_id;
    LocalDate date;

    @BeforeEach
    void setUp() {
        booking_id = Long.toString(ByteBuffer.wrap(UUID.randomUUID()
                .toString().getBytes()).getLong(), Character.MAX_RADIX);
        date = LocalDate.now();
    }

    @Test
    void a_create() throws SQLException {

        //count number of rows in current table
        int currentRows = new BookingDAO().countRows();
        System.out.println("Number of rows previously: "+currentRows);

        //Create new booking
        Booking booking = new Booking(booking_id, "Group counselling", date, 235586956);
        new BookingDAO().AddBooking(booking, 235586956);

        //Number of records in new table
        int updatedRows = new BookingDAO().countRows();
        System.out.println("Number of rows after: "+updatedRows);

        assertEquals(currentRows+1, updatedRows);
    }

    @Test
    void b_retrieve(){
        //Create new booking
        Booking booking = new Booking(booking_id, "Group counselling", date, 218896555);
        new BookingDAO().AddBooking(booking, 218896555);

        //Retrieve booking
        new BookingDAO().RetrieveBookings(218896555);

        assertNotNull(booking);
    }

    @Test
    void c_delete() throws SQLException {
        //Records in table
        int currentRows = new BookingDAO().countRows();
        System.out.println("Number of bookings: "+currentRows);

        //Delete a record
        new BookingDAO().deleteBooking("1jxzf0njuauk6");
        new BookingDAO().deleteBooking("urund2mktppg");

        //Number of records after deleting
        int updatedRows = new BookingDAO().countRows();
        System.out.println("Number of bookings after delete: "+updatedRows);

        assertEquals(currentRows-2, updatedRows);

    }

    @Test
    void d_failTest() throws SQLException {
        //count number of rows in current table
        int currentRows = new BookingDAO().countRows();
        System.out.println("Number of rows previously: "+currentRows);

        //Create new booking
        Booking booking = new Booking(booking_id, "Group counselling", date, 123456789);
        new BookingDAO().AddBooking(booking, 123456789);

        //Number of records in new table
        int updatedRows = new BookingDAO().countRows();
        System.out.println("Number of rows after: "+updatedRows);

        assertEquals(currentRows+1, updatedRows);
    }


}