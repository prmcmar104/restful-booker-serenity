package com.herokuapp.booker.model;

/**
 * Created by Jay
 */
public class BookingPojo {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public static BookingPojo getRequestBody(String firstname, String lastname, Integer totalprice, Boolean depositpaid,
                                             BookingDates bookingDates, String additionalneeds) {
        BookingPojo bookingPojo = new BookingPojo();
        if (firstname != null) {
            bookingPojo.setFirstname(firstname);
        }
        if (lastname != null) {
            bookingPojo.setLastname(lastname);
        }
        if (totalprice != null) {
            bookingPojo.setTotalprice(totalprice);
        }
        if (depositpaid != null) {
            bookingPojo.setDepositpaid(depositpaid);
        }
        if (bookingDates != null) {
            bookingPojo.setBookingdates(bookingDates);
        }
        if (additionalneeds != null) {
            bookingPojo.setAdditionalneeds(additionalneeds);
        }
        return bookingPojo;
    }
}