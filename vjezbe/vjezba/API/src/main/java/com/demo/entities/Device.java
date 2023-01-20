package com.demo.entities;

import java.util.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device{
	private Long id;
	private Set<Measure> measures;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Measure> getMeasures() {
		return measures;
	}
	public void setMeasures(Set<Measure> measures) {
		this.measures = measures;
	}
	
	
}
