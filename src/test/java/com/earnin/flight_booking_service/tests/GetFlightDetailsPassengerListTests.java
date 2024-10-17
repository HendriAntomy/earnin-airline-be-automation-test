package com.earnin.flight_booking_service.tests;

import com.earnin.flight_booking_service.base.BaseTest;
import com.earnin.flight_booking_service.base.ResponseData;
import com.earnin.flight_booking_service.models.common.Flight;
import com.earnin.flight_booking_service.models.response.GetFlightPassengerDetailsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@Tag("get_flights_details")
public class GetFlightDetailsPassengerListTests extends BaseTest {

    @Tag("P1")
    @Test
    public void getFlightDetailsFromDifferentTimezones() {
        Flight flight = getFlightData(false);
        addPassenger(flight.getId());
        ResponseData<GetFlightPassengerDetailsResponse> response = getFlightServiceAPI().getFlightPassengerDetails(flight.getId());

        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        ZonedDateTime arrivalDateTime = ZonedDateTime.parse(flight.getArrivalTime(), formatter);
        ZonedDateTime departureDateTime = ZonedDateTime.parse(flight.getDepartureTime(), formatter);
        Assertions.assertNotEquals(arrivalDateTime.getZone(), departureDateTime.getZone());

        Assertions.assertEquals(200, response.getResponse().getStatusCode());
        Assertions.assertFalse(response.getResponseBody().getPassengers().isEmpty());

    }

    @Tag("P1")
    @Test
    public void getFlightDetailsFromSameTimezones() {
        Flight flight = getFlightData(true);
        addPassenger(flight.getId());
        ResponseData<GetFlightPassengerDetailsResponse> response = getFlightServiceAPI().getFlightPassengerDetails(flight.getId());

        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        ZonedDateTime arrivalDateTime = ZonedDateTime.parse(flight.getArrivalTime(), formatter);
        ZonedDateTime departureDateTime = ZonedDateTime.parse(flight.getDepartureTime(), formatter);
        Assertions.assertEquals(arrivalDateTime.getZone(), departureDateTime.getZone());

        Assertions.assertEquals(200, response.getResponse().getStatusCode());
        Assertions.assertFalse(response.getResponseBody().getPassengers().isEmpty());

    }


}
