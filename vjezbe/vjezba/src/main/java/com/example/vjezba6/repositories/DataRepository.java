package com.example.vjezba6.repositories;


import com.example.vjezba6.entities.Client;
import com.example.vjezba6.entities.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;


public interface DataRepository extends JpaRepository<Data, Long> {


    Page<Data> findAll(Pageable pageable);
    @Query(value= "select SUM(CAST(value AS INTEGER)) from data where year= :year", nativeQuery = true)
    String getTotalValuesByYear(@Param("year") String year);

    @Query(value= "select month, SUM(CAST(value AS INTEGER)) from data where year= :year group by month", nativeQuery = true)
    ArrayList<String> getTotalValuesByYearPerMonth(@Param("year") String year);


    @Query(value= "select SUM(CAST(value AS INTEGER)) from data where year= :year AND month = :month", nativeQuery = true)
    String getTotalValuesByYearAndMonth(@Param("year") String year, @Param("month") String month);

    @Query(value = "SELECT month FROM DATA where device_id= :deviceId AND year= :year", nativeQuery = true)
    ArrayList<String> getDataMonthForId(@Param("deviceId")long device_id, @Param("year") String year);

}
