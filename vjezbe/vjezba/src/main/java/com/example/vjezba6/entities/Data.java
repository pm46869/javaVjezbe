package com.example.vjezba6.entities;


import javax.persistence.*;

@Entity
@lombok.Data
public class Data {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private long id;
    @Column
    private String year;
    @Column
    private String month;
    @Column
    private String value;

    @ManyToOne (

            cascade = CascadeType.ALL
    )
    @JoinColumn (
            referencedColumnName = "id"
    )
    private Device Device;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Device getDevice() {
		return Device;
	}

	public void setDevice(Device device) {
		Device = device;
	}

	public Data(long id, String year, String month, String value, com.example.vjezba6.entities.Device device) {
		super();
		this.id = id;
		this.year = year;
		this.month = month;
		this.value = value;
		Device = device;
	}

	public Data(Object object, int i, String string, String string2) {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
