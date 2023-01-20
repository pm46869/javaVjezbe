package com.example.vjezba6.services;



import com.example.vjezba6.entities.Client;
import com.example.vjezba6.entities.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DeviceService {

    Device saveDevice(Device device, long id);
    Device getDeviceById(long id);
    Page<Device> getAllDevices(Pageable pageable);
    Device updateDevice(Device device, long id);
    void deleteDeviceById(long id);


}
