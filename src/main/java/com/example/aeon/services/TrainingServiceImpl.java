package com.example.aeon.services;

import com.example.aeon.dtos.BasicPaginationOptions;
import com.example.aeon.dtos.training.AddSingleTrainingDto;
import com.example.aeon.dtos.training.UpdateTrainingByIdDto;
import com.example.aeon.entities.Training;
import com.example.aeon.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
  
  @Override
  public List<Training> getTrainingListByNamaPengajarAndTema(String namaPengajar, String tema, BasicPaginationOptions paginationOpts) {
  
    Pageable pagination = PageRequest.of(
      Math.toIntExact((paginationOpts.getPage() - 1)),
      Math.toIntExact(paginationOpts.getPageSize())
    );
    
    List<Training> trainingList = trainingRepository.findByNamaPengajarContainingAndTemaContaining(namaPengajar, tema, pagination).getContent();
    
    return trainingList;
  }
  
  @Override
  public Optional<Training> getTrainingById(Long id) {
    return trainingRepository.findById(id);
  }
  
  @Override
  public Optional<Training> updateTrainingById(Long id, UpdateTrainingByIdDto updatedFields) {
  
    Optional<Training> optTraining = trainingRepository.findById(id);
  
    Training training;
    if (optTraining.isPresent()){
      training = optTraining.get();
    } else {
      return Optional.empty();
    }
    
    
    if (updatedFields.getNamaPengajar() != null) training.setNamaPengajar(updatedFields.getNamaPengajar());
    if (updatedFields.getTema() != null) training.setTema(updatedFields.getTema());
    
    
    Training updatedTraining = trainingRepository.save(training);
  
    return Optional.of(updatedTraining);
  }
}
