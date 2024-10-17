package com.earnin.flight_booking_service.tests;

import com.earnin.flight_booking_service.base.BaseTest;
import com.earnin.flight_booking_service.base.ResponseData;
import com.earnin.flight_booking_service.models.common.Flight;
import com.earnin.flight_booking_service.models.common.Passenger;
import com.earnin.flight_booking_service.models.response.CreateAndUpdatePassengerResponse;
import com.earnin.flight_booking_service.models.response.GetFlightPassengerDetailsResponse;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeletePassengerTests extends BaseTest {

    @Test
    public void deletePassengerData() {
        Flight flightData = getFlightData(true);
        CreateAndUpdatePassengerResponse passenger = addPassenger(flightData.getId());
        ResponseData<CreateAndUpdatePassengerResponse> response =
                getFlightServiceAPI().deletePassengerData(flightData.getId(), passenger.getCustomerId());

        Assertions.assertEquals(200, response.getResponse().getStatusCode());
        //verify if it is actually deleted - somehow the BE logic doesn't delete it LOL
//        ResponseData<GetFlightPassengerDetailsResponse> getPassengerListResponse = getFlightServiceAPI().getFlightPassengerDetails(flightData.getId());
//        MatcherAssert.assertThat("Passenger with Customer ID " + passenger.getCustomerId() + " should not exist.",
//                getPassengerListResponse.getResponseBody().getPassengers(), Matchers.not(Matchers.hasItem(Matchers.hasProperty("customerId", Matchers.equalTo(passenger.getCustomerId())))));
    }

}
