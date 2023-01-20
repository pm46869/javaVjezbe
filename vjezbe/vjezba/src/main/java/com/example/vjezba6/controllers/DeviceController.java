package com.example.vjezba6.controllers;


import com.example.vjezba6.entities.Data;
import com.example.vjezba6.entities.Device;
import com.example.vjezba6.exceptionHandler.BadRequestException;
import com.example.vjezba6.exceptionHandler.DataNotFoundException;
import com.example.vjezba6.services.DeviceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {


    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("/{deviceId}")
    ResponseEntity<Device> saveDevice(@RequestBody Device device, long deviceId) {
        try {
            return new ResponseEntity<>(deviceService.saveDevice(device, deviceId),HttpStatus.OK);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("")
     ResponseEntity<Device> getDevice( @RequestParam(required = true, name = "deviceId")long id) {
        try {
            return new ResponseEntity<>(deviceService.getDeviceById(id), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/all")
    public ResponseEntity<Page<Device>> getAllDevices(@PageableDefault(page = 1, size = 5) Pageable pageable,
                                                 @RequestParam(required = false)String sortBy) {
        try {
            Sort sort = Sort.by(sortBy);
            Pageable sortPage = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
            return new ResponseEntity<>(deviceService.getAllDevices(sortPage), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("")
    ResponseEntity<Device> updateDevice(@RequestBody Device device, @RequestParam(required = true, name = "deviceId")long id)
    {
        try {
            return new ResponseEntity<>(deviceService.updateDevice(device, id),HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (BadRequestException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("")
    ResponseEntity<String> deleteDeviceById(@RequestParam(required = true, name = "deviceId")long id)
    {
        try {
            deviceService.deleteDeviceById(id);
            return new ResponseEntity<>("Deleted!",HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


