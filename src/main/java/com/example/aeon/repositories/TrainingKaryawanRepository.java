package com.example.aeon.repositories;

import com.example.aeon.entities.TrainingKaryawan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingKaryawanRepository extends JpaRepository<TrainingKaryawan, Long> {
  @Query(
    value = "select tk from TrainingKaryawan tk join tk.karyawan k join tk.training t where k.nama like %?1% and t.tema like %?2% order by tk.created_date",
    countQuery = "select count(tk) from TrainingKaryawan tk join tk.karyawan k join tk.training t where k.nama like %?1% and t.tema like %?2%"
  )
  Page<TrainingKaryawan> findByNamaKaryawanAndTemaTraining(String namaKaryawan, String temaTraining, Pageable paginationOpts);
}
