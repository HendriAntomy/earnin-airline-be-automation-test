package com.earnin.flight_booking_service.base;

import com.earnin.flight_booking_service.api.FlightServiceAPI;
import com.earnin.flight_booking_service.models.common.Flight;
import com.earnin.flight_booking_service.models.common.Passenger;
import com.earnin.flight_booking_service.models.response.CreateAndUpdatePassengerResponse;
import com.github.javafaker.Faker;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Getter
public class BaseTest {

    private final FlightServiceAPI flightServiceAPI;
    private final Faker faker;
    private final List<Passenger> validPassengerData = Arrays.asList(
                Passenger.builder().passportId("BC1500").firstName("Shauna").lastName("Davila").build()
//                Passenger.builder().passportId("BC1501").firstName("John").lastName("Doe").build(),
//                Passenger.builder().passportId("BC1502").firstName("Alice").lastName("Johnson").build(),
//                Passenger.builder().passportId("BC1503").firstName("Robert").lastName("Williams").build(),
//                Passenger.builder().passportId("BC1504").firstName("Emily").lastName("Brown").build(),
//                Passenger.builder().passportId("BC1505").firstName("David").lastName("Smith").build(),
//                Passenger.builder().passportId("BC1506").firstName("Sophia").lastName("Miller").build(),
//                Passenger.builder().passportId("BC1507").firstName("James").lastName("Taylor").build(),
//                Passenger.builder().passportId("BC1508").firstName("Michael").lastName("Wilson").build(),
//                Passenger.builder().passportId("BC1509").firstName("Linda").lastName("Davis").build()
        );

    public BaseTest() {
        this.flightServiceAPI = new FlightServiceAPI();
        this.faker = new Faker();
    }

//    public Passenger generateValidPassengerData(){
//        Random random = new Random();
//        return validPassengerData.get(random.nextInt(validPassengerData.size()));
//    }

    public Passenger generateValidPassengerData(){
        return Passenger.builder()
                .passportId(faker.bothify("EN######"))
                .firstName("Hendri")
                .lastName("Antomy")
                .build();
    }

    public Passenger generateInValidPassengerData(){
        return Passenger.builder()
                .passportId(faker.bothify("EN######"))
                .firstName("Nattapol")
                .lastName("Wilarat")
                .build();
    }

    public Flight getFlightData(boolean isSameTimezone){
        //get Flight data from diff timezones
        Optional<Flight> flightData = getFlightServiceAPI().getListOfFlight().getResponseBody().getFlights().stream().filter(flight -> {
            // Parse the strings into ZonedDateTime objects
            DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
            ZonedDateTime arrivalDateTime = ZonedDateTime.parse(flight.getArrivalTime(), formatter);
            ZonedDateTime departureDateTime = ZonedDateTime.parse(flight.getDepartureTime(), formatter);
            if(isSameTimezone){
                return arrivalDateTime.getZone().equals(departureDateTime.getZone());
            }
            return !arrivalDateTime.getZone().equals(departureDateTime.getZone());

        }).findFirst();

        if(flightData.isPresent()) {
            return flightData.get();
        }
        Assertions.fail("Flight data with different timezones is not found");
        return null;
    }

    public CreateAndUpdatePassengerResponse addPassenger(String flightID){
        ResponseData<CreateAndUpdatePassengerResponse> response =
                getFlightServiceAPI().createPassenger(generateValidPassengerData(), flightID);
        Assertions.assertEquals(200, response.getResponse().getStatusCode());
        return response.getResponseBody();
    }

}
