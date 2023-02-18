package com.example.compstore.repository;

import com.example.compstore.model.AllInOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllInOneRepository extends JpaRepository<AllInOne, Long> {
}
