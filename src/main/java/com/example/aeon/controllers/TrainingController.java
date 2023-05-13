package com.example.aeon.controllers;

import com.example.aeon.dtos.training.AddSingleTrainingDto;
import com.example.aeon.entities.ErrorMessage;
import com.example.aeon.entities.Training;
import com.example.aeon.services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/training")
public class TrainingController {
  
  @Autowired
  private TrainingService trainingService;
  
  @PostMapping
  public ResponseEntity add(@Valid @RequestBody AddSingleTrainingDto body){
    Training newTraining = trainingService.addSingleTraining(body);
    
    if (newTraining == null) return new ResponseEntity<>(
      new ErrorMessage(HttpStatus.NOT_FOUND, "New training is not found"),
      HttpStatus.NOT_FOUND
    );
  
    return new ResponseEntity<>(
      newTraining,
      HttpStatus.OK
    );
  }
  
}
