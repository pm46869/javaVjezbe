package com.vjezba5.demo.repository;

import com.vjezba5.demo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository <Client, Long> {


}
