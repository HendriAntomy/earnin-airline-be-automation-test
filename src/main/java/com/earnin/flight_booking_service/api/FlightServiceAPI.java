package com.earnin.flight_booking_service.api;

import com.earnin.flight_booking_service.base.ResponseData;
import com.earnin.flight_booking_service.models.common.Passenger;
import com.earnin.flight_booking_service.models.response.CreateAndUpdatePassengerResponse;
import com.earnin.flight_booking_service.models.response.GetFlightPassengerDetailsResponse;
import com.earnin.flight_booking_service.models.response.GetFlightsResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;

import static com.earnin.flight_booking_service.endpoints.FlightService.*;

public class FlightServiceAPI {


    private FilterableRequestSpecification baseRequest(){
        return (FilterableRequestSpecification) RestAssured.given().baseUri(BASE_URL)
                .log().all()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json");
    }

    public ResponseData<GetFlightsResponse> getListOfFlight(){
        Response response = baseRequest().get(ENDPOINT_GET_LIST_OF_FLIGHTS);
        return new ResponseData<>(response, GetFlightsResponse.class);
    }

    public ResponseData<CreateAndUpdatePassengerResponse> createPassenger(Passenger passenger, String flightId) {
        Response response = baseRequest().body(passenger)
                .pathParam("flight_id", flightId)
                .post(ENDPOINT_CREATE_PASSENGERS);

        return new ResponseData<>(response, CreateAndUpdatePassengerResponse.class);

    }

    public ResponseData<GetFlightPassengerDetailsResponse> getFlightPassengerDetails(String flightID){
        Response response = baseRequest()
                .pathParam("flight_id", flightID)
                .get(ENDPOINT_GET_FLIGHT_DETAILS_LIST_PASSENGERS);

        return new ResponseData<>(response, GetFlightPassengerDetailsResponse.class);
    }

    public ResponseData<CreateAndUpdatePassengerResponse> updatePassengerData(String flightID, Integer customerID, Passenger passenger){
        Response response = baseRequest()
                .pathParam("flight_id", flightID)
                .pathParam("customer_id", customerID)
                .body(passenger)
                .put(ENDPOINT_UPDATE_PASSENGERS);

        return new ResponseData<>(response, CreateAndUpdatePassengerResponse.class);
    }

    public ResponseData<CreateAndUpdatePassengerResponse> deletePassengerData(String flightID, Integer customerID){
        Response response = baseRequest()
                .pathParam("flight_id", flightID)
                .pathParam("customer_id", customerID)
                .delete(ENDPOINT_DELETE_PASSENGERS);

        return new ResponseData<>(response, CreateAndUpdatePassengerResponse.class);
    }
}
