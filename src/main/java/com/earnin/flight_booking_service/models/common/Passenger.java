package com.earnin.flight_booking_service.models.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Passenger {

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("passport_id")
	private String passportId;

	@JsonProperty("customer_id")
	private Integer customerId;

	@JsonProperty("flight_id")
	private String flightId;
}