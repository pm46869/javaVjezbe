package com.vjezba5.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Device {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;
    public String name;
    public int random;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn (
            referencedColumnName = "id"
    )
    private Client client;

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

	public int getRandom() {
		return random;
	}

	public void setRandom(int random) {
		this.random = random;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", random=" + random + ", client=" + client + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getRandom()=" + getRandom() + ", getClient()=" + getClient()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public Device(long id, String name, int random, Client client) {
		super();
		this.id = id;
		this.name = name;
		this.random = random;
		this.client = client;
	}

	public Device() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
}
