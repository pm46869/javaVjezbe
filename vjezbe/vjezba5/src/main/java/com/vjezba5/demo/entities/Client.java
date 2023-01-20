package com.vjezba5.demo.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;
    public String name;
    public String address;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", address=" + address + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getAddress()=" + getAddress() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Client(long id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
