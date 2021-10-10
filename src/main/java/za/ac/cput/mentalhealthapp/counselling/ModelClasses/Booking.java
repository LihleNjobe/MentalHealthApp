package za.ac.cput.mentalhealthapp.counselling.ModelClasses;

import java.time.LocalDate;

public class Booking {
    String booking_id;
    String booking_type;
    LocalDate date;
    int student_number;

    public Booking(String booking_id, String booking_type, LocalDate date, int student_number) {
        this.booking_id = booking_id;
        this.booking_type = booking_type;
        this.date = date;
        this.student_number = student_number;
    }

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    public String getBooking_type() {
        return booking_type;
    }

    public void setBooking_type(String booking_type) {
        this.booking_type = booking_type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getStudent_number() {
        return student_number;
    }

    public void setStudent_number(int student_number) {
        this.student_number = student_number;
    }
}