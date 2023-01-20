package com.example.vjezba6.services;

import com.example.vjezba6.entities.Client;
import com.example.vjezba6.entities.Data;
import com.example.vjezba6.repositories.DataRepository;
import com.example.vjezba6.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class DataServiceImplementation implements DataService {

    @Autowired
    private DataRepository dataRepository;
    @Autowired
   private DeviceRepository deviceRepository;

    @Override
    public String saveData(Data data, long id) {

        List<String> months = new ArrayList<>();
        months = dataRepository.getDataMonthForId(id, data.getYear());

        for(String m : months)
        {
            if(Objects.equals(m, data.getMonth()))
            {
                return "Month already included!";
            }
        }
        data.setDevice(deviceRepository.findById(id).get());
        dataRepository.save(data);
        return "Data saved";
    }

    @Override
    public Data getDataById(long id) {
        return dataRepository.findById(id).get();
    }
    @Override
    public Page<Data> getAllData(Pageable pageable) {
        return dataRepository.findAll(pageable);
    }

    @Override
    public Data updateData(Data data, Long id) {
        Data dataDB = dataRepository.findById(id).get();

        if (Objects.nonNull(data.getMonth())
                && !"".equalsIgnoreCase(
                data.getMonth())) {
            dataDB.setMonth(
                    data.getMonth());
        }

        if (Objects.nonNull(
                data.getYear())
                && !"".equalsIgnoreCase(
                data.getYear())) {
            dataDB.setYear(
                    data.getYear());
        }

        if (Objects.nonNull(
                data.getValue())
                && !"".equalsIgnoreCase(
                data.getValue())) {
            dataDB.setValue(
                    data.getValue());
        }
        return dataRepository.save(dataDB);
    }

    @Override
    public void deleteDataById(long id) {
       dataRepository.deleteById(id);

    }


    @Override
    public List<String> filterData(Map<String, String> searchParams) {
        List<String> result = new ArrayList<>();
        if (searchParams.containsKey("year") && !searchParams.containsKey("month"))
        {
            result = (dataRepository.getTotalValuesByYearPerMonth(searchParams.get("year")));
            return result;
        }
        else if (searchParams.containsKey("year") && searchParams.containsKey("month"))
        {
            result = Collections.singletonList(dataRepository.getTotalValuesByYearAndMonth(searchParams.get("year"), searchParams.get("month")));
            return result;

        }
        else if (searchParams.containsKey("accumulate"))
        {
            result = Collections.singletonList(dataRepository.getTotalValuesByYear(searchParams.get("accumulate")));

            return result;

        }
        else
        {
            result.add("Bad request: Parameter " + searchParams.keySet() + " does not exist");
            return result;
        }
    }


}
