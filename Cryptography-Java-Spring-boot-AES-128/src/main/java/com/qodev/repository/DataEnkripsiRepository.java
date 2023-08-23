package com.qodev.repository;

import com.qodev.domain.DataEnkripsi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataEnkripsiRepository extends JpaRepository<DataEnkripsi, Integer> {

}
