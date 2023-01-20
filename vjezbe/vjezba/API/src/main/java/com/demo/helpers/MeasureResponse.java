package com.demo.helpers;

import java.util.List;

import com.demo.entities.Measure;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class MeasureResponse {
	private int consumption;
	private List<Measure> measures;
	private String description;
	public int getConsumption() {
		return consumption;
	}
	public void setConsumption(int consumption) {
		this.consumption = consumption;
	}
	public List<Measure> getMeasures() {
		return measures;
	}
	public void setMeasures(List<Measure> measures) {
		this.measures = measures;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
 
	
}
