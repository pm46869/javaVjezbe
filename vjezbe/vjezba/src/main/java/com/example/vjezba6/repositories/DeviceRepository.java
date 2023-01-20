package com.example.vjezba6.repositories;

import com.example.vjezba6.entities.Client;
import com.example.vjezba6.entities.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {

    Page<Device> findAll(Pageable pageable);

}
