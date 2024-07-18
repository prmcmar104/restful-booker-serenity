package com.herokuapp.booker.params;

import java.util.HashMap;

/**
 * Created by Jay Vaghani
 */
public class Headers {

    public static final String CONTENT_TYPE = "Content-Type";
    public static final String ACCEPT = "Accept";
    public static final String COOKIE = "Cookie";


    public static HashMap<String, String> getHeaders(String token) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE, "application/json");
        headers.put(ACCEPT, "application/json");
        headers.put(COOKIE, "token=" + token);
        return headers;
    }

    public static HashMap<String, String> getHeadersForUpdateBooking(String token,String grantType) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE, "application/json");
        headers.put(ACCEPT, "application/json");
        headers.put(ACCEPT, grantType);
        headers.put(COOKIE, "token=" + token);
        return headers;
    }
}
