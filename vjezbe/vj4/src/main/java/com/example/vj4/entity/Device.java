package com.example.vj4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer random;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn (
            referencedColumnName = "id"
    )
    @JsonIgnore
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    Device() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRandom() {
        return random;
    }

    public void setRandom(Integer random) {
        this.random = random;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(id, device.id) && Objects.equals(name, device.name) && Objects.equals(random, device.random) && Objects.equals(client, device.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, random, client);
    }

    public Device(Long id, String name, Integer random, Client client) {
        this.id = id;
        this.name = name;
        this.random = random;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", random='" + random + '\'' +
                ", client=" + client +
                '}';
    }
}
