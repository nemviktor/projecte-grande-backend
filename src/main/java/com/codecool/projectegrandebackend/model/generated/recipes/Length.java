package com.codecool.projectegrandebackend.model.generated.recipes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Length{

	@JsonProperty("number")
	private int number;

	@JsonProperty("unit")
	private String unit;

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	@Override
 	public String toString(){
		return 
			"Length{" + 
			"number = '" + number + '\'' + 
			",unit = '" + unit + '\'' + 
			"}";
		}
}