package com.earnin.flight_booking_service.base;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import lombok.Getter;

@Getter
public class ResponseData<T>{

    private T responseBody;
    private final Response response;

    private ResponseData(Response response) {
        this.response = response;
        this.response.then().log().all();
    }
    public ResponseData(Response response, Class<T> type) {
        this(response);
        try {
            this.responseBody = response.as(type);
        }catch (Exception e) {
            //TODO : add logging
            e.printStackTrace();
            System.out.println("Warn : Error when parsing the response body data");
        }

    }

    public ResponseData(Response response, TypeRef<T> typeRef) {
        this(response);
        this.responseBody = response.as(typeRef);
    }

}
