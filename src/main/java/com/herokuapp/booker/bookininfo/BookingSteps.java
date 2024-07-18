package com.herokuapp.booker.bookininfo;

import com.herokuapp.booker.constants.EndPoints;
import com.herokuapp.booker.model.BookingDates;
import com.herokuapp.booker.model.BookingPojo;
import com.herokuapp.booker.params.Headers;
import com.herokuapp.booker.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

/**
 * Created by Jay
 */
public class BookingSteps {

    @Step("Creating new booking with firstName: {0}, lastName: {1}, totalPrice: {2}, depositPaid: {3}, checkIn: {4}, " +
            "checkOut: {5} and additionalNeeds: {6}")
    public ValidatableResponse createBooking(String firstName, String lastName, int totalPrice, boolean depositPaid,
                                             String checkIn, String checkOut, String additionalNeeds) {
        BookingDates bookingDates = BookingDates.getBookingDates(checkIn, checkOut);
        BookingPojo requestBody = BookingPojo.getRequestBody(firstName, lastName, totalPrice, depositPaid, bookingDates,
                additionalNeeds);
        return SerenityRest.rest().given().log().all()
                .header(Headers.CONTENT_TYPE, "application/json")
                .body(TestUtils.jsonToString(requestBody))
                .when()
                .post(EndPoints.CREATE_BOOKING)
                .then();
    }

    @Step("Get bookings with BookingId: {0}")
    public ValidatableResponse getBookingWithBookingId(int bookingId) {
        return SerenityRest.given().log().ifValidationFails()
                .pathParam("bookingId", bookingId)
                .when()
                .get(EndPoints.GET_BOOKING)
                .then();
    }

    @Step("Get all booking Ids")
    public ValidatableResponse getAllBookingIds() {
        return SerenityRest.given().log().ifValidationFails()
                .when()
                .get(EndPoints.GET_ALL_BOOKING_IDS)
                .then();
    }

    @Step("Update booking with bookingId: {0}, firstName: {1}, lastName: {2}, totalPrice: {3}, depositPaid: {4}, " +
            "checkIn: {5}, checkOut: {6} and additionalNeeds: {7}")
    public ValidatableResponse updateBooking(int bookingId, String firstName, String lastName, int totalPrice,
                                             boolean depositPaid, String checkIn, String checkOut,
                                             String additionalNeeds, String token) {
        BookingDates bookingDates = BookingDates.getBookingDates(checkIn, checkOut);
        BookingPojo requestBody = BookingPojo.getRequestBody(firstName, lastName, totalPrice, depositPaid, bookingDates,
                additionalNeeds);
        return SerenityRest.rest().given().log().ifValidationFails()
                .headers(Headers.getHeaders(token))
                .pathParam("bookingId", bookingId)
                .body(TestUtils.jsonToString(requestBody))
                .when()
                .put(EndPoints.UPDATE_BOOKING)
                .then();
    }

    @Step("Update partial booking with bookingId: {0}, firstName: {1}, lastName: {2}, totalPrice: {3}, depositPaid: {4}, " +
            "checkIn: {5}, checkOut: {6} and additionalNeeds: {7}")
    public ValidatableResponse updatePartialBooking(int bookingId, String firstName, String lastName, Integer totalPrice,
                                                    Boolean depositPaid, String checkIn, String checkOut,
                                                    String additionalNeeds, String token) {
        BookingDates bookingDates = BookingDates.getBookingDates(checkIn, checkOut);
        BookingPojo requestBody = BookingPojo.getRequestBody(firstName, lastName, totalPrice, depositPaid, bookingDates,
                additionalNeeds);
        return SerenityRest.rest().given().log().all()
                .headers(Headers.getHeaders(token))
                .pathParam("bookingId", bookingId)
                .body(TestUtils.jsonToString(requestBody))
                .when()
                .patch(EndPoints.UPDATE_BOOKING)
                .then();
    }

    @Step("Delete bookings with BookingId: {0}")
    public ValidatableResponse deleteBookingWithBookingId(int bookingId, String token) {
        return SerenityRest.given().log().ifValidationFails()
                .headers(Headers.getHeaders(token))
                .pathParam("bookingId", bookingId)
                .when()
                .delete(EndPoints.DELETE_BOOKING)
                .then();
    }
}
