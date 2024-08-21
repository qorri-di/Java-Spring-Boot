package com.qodev.repository;

import com.qodev.domain.DataEnkripsi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataEnkripsiRepository extends JpaRepository<DataEnkripsi, Integer> {

    @Query(value = "select b from mst_encrypt b where b.encrypt = :enk",nativeQuery = true)
    List<DataEnkripsi> selectAll(@Param("enk") String enk);

    @Query(value = "select b from DataEnkripsi b where b.encryptData = :enk")
    List<DataEnkripsi> selectAllNon(@Param("enk") String enk);
}
