package com.herokuapp.booker.bookininfo;

import com.herokuapp.booker.constants.EndPoints;
import com.herokuapp.booker.model.AuthPojo;
import com.herokuapp.booker.params.Headers;
import com.herokuapp.booker.utils.TestUtils;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

/**
 * Created by Jay Vaghani
 */
public class AuthSteps {

    @Step("Get auth token with username: {0} and password: {1}")
    public String getAuthToken(String username, String password) {
        AuthPojo authPojo = AuthPojo.getAuthBody(username, password);
        return SerenityRest.given().log().ifValidationFails()
                .header(Headers.CONTENT_TYPE, "application/json")
                .body(TestUtils.jsonToString(authPojo))
                .when()
                .post(EndPoints.AUTH)
                .then().log().ifValidationFails()
                .statusCode(200).extract().path("token");
    }
}
