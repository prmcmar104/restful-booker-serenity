package com.herokuapp.booker.cucumber.steps;

import com.herokuapp.booker.bookininfo.BookingSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;

/**
 * Created by Jay
 */
public class MyStepdefs {

    static ValidatableResponse response;

    @Steps
    BookingSteps bookingSteps;

    @When("User sends a GET request to booking endpoints")
    public void userSendsAGETRequestToBookingEndpoints() {
        response = bookingSteps.getAllBookingIds();
    }

    @Then("User must get back with a valid status code {int}")
    public void userMustGetBackWithAValidStatusCode(int statusCode) {
        response.statusCode(statusCode);
    }
}
