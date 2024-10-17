package com.earnin.flight_booking_service.tests;

import com.earnin.flight_booking_service.base.BaseTest;
import com.earnin.flight_booking_service.base.ResponseData;
import com.earnin.flight_booking_service.models.common.Flight;
import com.earnin.flight_booking_service.models.common.Passenger;
import com.earnin.flight_booking_service.models.response.CreateAndUpdatePassengerResponse;
import com.earnin.flight_booking_service.models.response.GetFlightsResponse;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@Tag("update_passenger")
public class UpdatePassengerTests extends BaseTest {


    @Tag("P0")
    @Test
    public void updatePassengerDataWithValidData() {

        Flight flightData = getFlightData(true);
        CreateAndUpdatePassengerResponse passenger = addPassenger(flightData.getId());
        Passenger passengerRequestBody = generateValidPassengerData();
        ResponseData<CreateAndUpdatePassengerResponse> response =
                getFlightServiceAPI().updatePassengerData(flightData.getId(), passenger.getCustomerId(), passengerRequestBody);
        Assertions.assertEquals(200, response.getResponse().getStatusCode());
        Assertions.assertEquals(passengerRequestBody.getFirstName(), response.getResponseBody().getFirstName());
        Assertions.assertEquals(passengerRequestBody.getLastName(), response.getResponseBody().getLastName());
        Assertions.assertEquals(passengerRequestBody.getPassportId(), response.getResponseBody().getPassportId());
        Assertions.assertEquals(flightData.getId(), response.getResponseBody().getFlightId());
        Assertions.assertNotNull(response.getResponseBody().getCustomerId());
        MatcherAssert.assertThat(response.getResponse().asString(),
                JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/passengerresponse.json"));

    }

    @Tag("P1")
    @Test
    public void updatePassengerDataWithInvalidData() {
        Flight flightData = getFlightData(true);
        CreateAndUpdatePassengerResponse passenger = addPassenger(flightData.getId());
        Passenger passengerRequestBody = generateInValidPassengerData();
        ResponseData<CreateAndUpdatePassengerResponse> response =
                getFlightServiceAPI().updatePassengerData(flightData.getId(), passenger.getCustomerId(), passengerRequestBody);
        Assertions.assertEquals(400, response.getResponse().getStatusCode());
        Assertions.assertEquals("Firstname or Lastname is mismatch.", response.getResponse().path("detail"));
    }
}
