package com.example.compstore.repository;

import com.example.compstore.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ComputerRepository<Computer> extends
        JpaRepository<com.example.compstore.model.Computer, Long> {

    @Query(value = "SELECT* FROM COMPUTER WHERE COMPUTER_TYPE = 'LAPTOP'", nativeQuery = true)
    List<Laptop> findAllLaptops();
}
