package com.example.aeon.repositories;

import com.example.aeon.entities.Training;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
  Page<Training> findByNamaPengajarContainingOrTemaContaining(String namaPengajar, String tema, Pageable pagination);
}
