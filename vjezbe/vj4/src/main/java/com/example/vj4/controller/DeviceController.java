package com.example.vj4.controller;

import com.example.vj4.entity.Device;
import com.example.vj4.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeviceController {

    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @PostMapping("/devices/{id}")
    public ResponseEntity<Device> saveDevice(@RequestBody Device device, @PathVariable("id")long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(deviceService.saveDevice(device, id));
    }

    @GetMapping("/devices/{id}")
    public ResponseEntity<Device> getDevice(@PathVariable("id")long id) {
        //return deviceService.saveDevice(device, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(deviceService.getDevice(id));
    }


}
