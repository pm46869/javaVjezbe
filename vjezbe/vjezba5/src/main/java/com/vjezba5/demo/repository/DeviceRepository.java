package com.vjezba5.demo.repository;

import com.vjezba5.demo.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface DeviceRepository extends JpaRepository <Device, Long> {

    @Query(value= "select SUM(CAST(value AS INTEGER)) from data where year= :year", nativeQuery = true)
    String getTotalValuesByYear(@Param("year") String year);

    @Query(value= "select month, SUM(CAST(value AS INTEGER)) from data where year= :year group by month", nativeQuery = true)
    ArrayList<String> getTotalValuesByYearPerMonth(@Param("year") String year);

    @Query(value= "select SUM(CAST(value AS INTEGER)) from data where year= :year AND month = :month", nativeQuery = true)
    String getTotalValuesByYearAndMonth(@Param("year") String year, @Param("month") String month);

}