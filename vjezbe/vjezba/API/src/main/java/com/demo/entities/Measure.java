package com.demo.entities;

import java.sql.Date;
import java.time.LocalDate;

import com.example.vjezba6.helpers.MyDateClass;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Measure {
	Long id;
	private int value;
	private String unit;
	private Long device_id;
	MyDateClass date;
	public MyDateClass getDate() {
		return date;
	}
	public void setDate(MyDateClass date) {
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Long getDevice_id() {
		return device_id;
	}
	public void setDevice_id(Long device_id) {
		this.device_id = device_id;
	}
	
	
}
