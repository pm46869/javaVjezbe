package com.vjezba5.demo.services;

import com.vjezba5.demo.entities.Client;
import com.vjezba5.demo.entities.Device;

public interface DeviceService {
    Device saveDevice(Device device, long id);
    Device getDevice(long id);
}
