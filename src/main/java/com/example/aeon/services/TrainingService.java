package com.example.aeon.services;

import com.example.aeon.dtos.BasicPaginationOptions;
import com.example.aeon.dtos.training.AddSingleTrainingDto;
import com.example.aeon.dtos.training.UpdateTrainingByIdDto;
import com.example.aeon.entities.Training;

import java.util.List;
import java.util.Optional;

public interface TrainingService {
  Training addSingleTraining(AddSingleTrainingDto fields);
  
  List<Training> getTrainingListByNamaPengajarAndTema(String namaPengajar, String tema, BasicPaginationOptions paginationOpts);
  
  Optional<Training> getTrainingById(Long id);
  
  Optional<Training> updateTrainingById(Long id, UpdateTrainingByIdDto updatedFields);
}
