package com.earnin.flight_booking_service.models.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Flight {

	@JsonProperty("arrival_time")
	private String arrivalTime;

	@JsonProperty("departure_airport")
	private String departureAirport;

	@JsonProperty("arrival_airport")
	private String arrivalAirport;

	@JsonProperty("id")
	private String id;

	@JsonProperty("departure_time")
	private String departureTime;
}