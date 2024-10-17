package com.earnin.flight_booking_service.endpoints;

public interface FlightService {

    String BASE_URL = "http://localhost:8000";
    String ENDPOINT_GET_LIST_OF_FLIGHTS = "/flights";
    String ENDPOINT_GET_FLIGHT_DETAILS_LIST_PASSENGERS = "/flights/{flight_id}/passengers";
    String ENDPOINT_CREATE_PASSENGERS = ENDPOINT_GET_FLIGHT_DETAILS_LIST_PASSENGERS;
    String ENDPOINT_UPDATE_PASSENGERS = "/flights/{flight_id}/passengers/{customer_id}";
    String ENDPOINT_DELETE_PASSENGERS = ENDPOINT_UPDATE_PASSENGERS;
}
