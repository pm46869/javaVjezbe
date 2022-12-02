package com.example.vj4.service;

import com.example.vj4.repository.ClientRepository;
import com.example.vj4.repository.DeviceRepository;
import com.example.vj4.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private ClientRepository clientRepository;

    public Device saveDevice(Device device, long id) {
        Random rand = new Random();
        int random_value = rand.nextInt(100);
        device.setRandom(random_value);
        device.setClient(clientRepository.findById(id).get());
        return deviceRepository.save(device);
    }

    public Device getDevice(long id) {
        return deviceRepository.findById(id).get();
    }
}
