package com.example.aeon.controllers;

import com.example.aeon.dtos.BasicPaginationOptions;
import com.example.aeon.dtos.training.AddSingleTrainingDto;
import com.example.aeon.entities.ErrorMessage;
import com.example.aeon.entities.Training;
import com.example.aeon.services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
  
  @GetMapping
  public ResponseEntity getTrainingListByNamaPengajarAndTema(@RequestParam(name = "namaPengajar", defaultValue = "") String namaPengajar,
                                                             @RequestParam(name = "tema", defaultValue = "") String tema,
                                                             @Valid @RequestBody BasicPaginationOptions paginationOpts){
    List<Training> trainingList = trainingService.getTrainingListByNamaPengajarAndTema(namaPengajar, tema, paginationOpts);
    
    if (trainingList.size() == 0){
      return new ResponseEntity<>(
        new ErrorMessage(HttpStatus.NOT_FOUND, "Training tidak ditemukan."),
        HttpStatus.NOT_FOUND
      );
    }
  
    return new ResponseEntity<>(
      trainingList,
      HttpStatus.OK
    );
  }
  
  @GetMapping("/{id}")
  public ResponseEntity getTrainingById(@PathVariable("id") String id){
    
    Optional<Training> training = trainingService.getTrainingById(Long.valueOf(id));
  
    if (!training.isPresent()){
      return new ResponseEntity<>(
        new ErrorMessage(HttpStatus.NOT_FOUND, "Training tidak ditemukan."),
        HttpStatus.NOT_FOUND
      );
    }
  
    return new ResponseEntity<>(
      training,
      HttpStatus.OK
    );
  }
  
}
