package com.vjezba5.demo.services;

import com.vjezba5.demo.entities.Client;
import com.vjezba5.demo.entities.Device;
import com.vjezba5.demo.repository.ClientRepository;
import com.vjezba5.demo.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class DeviceServiceImpl  implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Device saveDevice(Device device, long id) {
        device.setClient(clientRepository.findById(id).get());
        return deviceRepository.save(device);
    }

    @Override
    public Device getDevice(long id) {

        return deviceRepository.findById(id).get();
    }
}
