package com.example.aeon.services;

import com.example.aeon.dtos.training.AddSingleTrainingDto;
import com.example.aeon.entities.Training;

public interface TrainingService {
  Training addSingleTraining(AddSingleTrainingDto fields);
}
