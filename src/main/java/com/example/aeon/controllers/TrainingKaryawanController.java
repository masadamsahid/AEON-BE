package com.example.aeon.controllers;

import com.example.aeon.dtos.training_karyawan.AddSingleTrainingKaryawanDto;
import com.example.aeon.entities.ErrorMessage;
import com.example.aeon.entities.TrainingKaryawan;
import com.example.aeon.services.TrainingKaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/training-karyawan")
public class TrainingKaryawanController {
  
  @Autowired
  private TrainingKaryawanService trainingKaryawanService;
  
  @PostMapping
  public ResponseEntity addTrainingKaryawan(@Valid @RequestBody AddSingleTrainingKaryawanDto body){
    TrainingKaryawan newTrainingKaryawan = trainingKaryawanService.addNewTrainingKarywan(body);
    
    if (newTrainingKaryawan == null) return new ResponseEntity<>(
      new ErrorMessage(HttpStatus.NOT_FOUND, "Karyawan atau training tidak ditemukan"),
      HttpStatus.NOT_FOUND
    );
    
    return new ResponseEntity<>(
      newTrainingKaryawan,
      HttpStatus.OK
    );
  }
  
}
