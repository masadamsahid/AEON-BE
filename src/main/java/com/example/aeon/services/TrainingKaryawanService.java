package com.example.aeon.services;

import com.example.aeon.dtos.training_karyawan.AddSingleTrainingKaryawanDto;
import com.example.aeon.entities.TrainingKaryawan;

public interface TrainingKaryawanService {
  TrainingKaryawan addNewTrainingKarywan(AddSingleTrainingKaryawanDto fields);
}
