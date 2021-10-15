package com.codecool.projectegrandebackend.model.generated.transport.flight;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Cost{

	@JsonProperty("total")
	private String total;

	@JsonProperty("offset")
	private String offset;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("transaction")
	private String transaction;

}