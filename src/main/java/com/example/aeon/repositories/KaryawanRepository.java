package com.example.aeon.repositories;

import com.example.aeon.entities.Karyawan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, Long> {
  Page<Karyawan> findByNamaContaining(String nama, Pageable pagination);
}
