package com.earnin.flight_booking_service.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateAndUpdatePassengerResponse{

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("customer_id")
	private Integer customerId;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("flight_id")
	private String flightId;

	@JsonProperty("passport_id")
	private String passportId;
}