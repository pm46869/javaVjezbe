package com.vjezba5.demo.controllers;

import com.vjezba5.demo.entities.Client;
import com.vjezba5.demo.entities.Device;
import com.vjezba5.demo.repository.DeviceRepository;
import com.vjezba5.demo.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private DeviceRepository repository;

    public DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @Valid
    @PostMapping("/devices/{id}")
    public ResponseEntity<Device> saveDevice(@RequestBody Device device, @PathVariable("id")long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(deviceService.saveDevice(device, id));
    }

    @Valid
    @GetMapping("/devices/{id}")
    public ResponseEntity<Device> getDevice(@PathVariable("id")long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(deviceService.getDevice(id));
    }

    @PutMapping("/devices/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @Valid
    public ResponseEntity<Device> replaceDevice(@RequestBody Device device, @PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.CREATED).body((repository.findById(id))
                .map(client1 -> {
                    client1.setName(device.getName());
                    client1.setRandom(device.getRandom());
                    return repository.save(client1);
                })
                .orElseGet(() -> {
                    device.setId(id);
                    return repository.save(device);
                }));
    }

    @DeleteMapping("/devices/{id}")
    void deleteDevice(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
