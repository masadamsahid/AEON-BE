package com.example.aeon.services;

import com.example.aeon.dtos.training.AddSingleTrainingDto;
import com.example.aeon.entities.Training;
import com.example.aeon.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingServiceImpl implements TrainingService {
  
  @Autowired
  private TrainingRepository trainingRepository;
  
  @Override
  public Training addSingleTraining(AddSingleTrainingDto fields) {
    
    Training newTraining = new Training();
    newTraining.setNamaPengajar(fields.getNamaPengajar());
    newTraining.setTema(fields.getTema());
    
    return trainingRepository.save(newTraining);
  }
}
