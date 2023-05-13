package com.example.aeon.repositories;

import com.example.aeon.entities.TrainingKaryawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingKaryawanRepository extends JpaRepository<TrainingKaryawan, Long> {
}
