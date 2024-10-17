package com.earnin.flight_booking_service.models.response;

import java.util.List;

import com.earnin.flight_booking_service.models.common.Flight;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetFlightsResponse {

	@JsonProperty("flights")
	private List<Flight> flights;
}