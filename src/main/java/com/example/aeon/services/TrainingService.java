package com.example.aeon.services;

import com.example.aeon.dtos.BasicPaginationOptions;
import com.example.aeon.dtos.training.AddSingleTrainingDto;
import com.example.aeon.entities.Training;

import java.util.List;

public interface TrainingService {
  Training addSingleTraining(AddSingleTrainingDto fields);
  
  List<Training> getTrainingListByNamaPengajarOrTema(String namaPengajar, String tema, BasicPaginationOptions paginationOpts);
}
