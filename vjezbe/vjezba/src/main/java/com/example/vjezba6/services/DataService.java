package com.example.vjezba6.services;




import com.example.vjezba6.entities.Client;
import com.example.vjezba6.entities.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DataService {

    String saveData(Data data, long id);
    Data getDataById(long id);
    Page<Data> getAllData(Pageable pageable);
    Data updateData(Data data, Long id);
    void deleteDataById(long id);
    public List<String> filterData(Map<String,String> searchParams);
}
