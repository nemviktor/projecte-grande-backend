package com.codecool.projectegrandebackend.model.generated.transport.flight.flightPostInput_generated;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class FlightPostInput{

	@JsonProperty("airports")
	private List<String> airports;

}