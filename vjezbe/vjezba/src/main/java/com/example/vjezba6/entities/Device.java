package com.example.vjezba6.entities;


import lombok.Data;

import javax.persistence.*;

@Data @Entity
@Table(name = "device")
public class Device {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String name;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn (
            referencedColumnName = "id", unique = true
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
    
    
}
