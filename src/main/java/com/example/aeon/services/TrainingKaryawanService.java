package com.example.aeon.services;

import com.example.aeon.dtos.BasicPaginationOptions;
import com.example.aeon.dtos.training_karyawan.AddSingleTrainingKaryawanDto;
import com.example.aeon.entities.TrainingKaryawan;

import java.util.List;

public interface TrainingKaryawanService {
  TrainingKaryawan addNewTrainingKarywan(AddSingleTrainingKaryawanDto fields);
  
  List<TrainingKaryawan> getTKByNamaKaryawanAndTemaTraining(String namaKaryawan, String temaTraining, BasicPaginationOptions paginationOpts);
}
