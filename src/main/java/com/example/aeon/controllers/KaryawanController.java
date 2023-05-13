package com.example.aeon.controllers;

import com.example.aeon.dtos.karyawan.AddSingleKaryawanAndDetailsDto;
import com.example.aeon.entities.ErrorMessage;
import com.example.aeon.entities.Karyawan;
import com.example.aeon.services.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/karyawan")
public class KaryawanController {
  
  @Autowired
  private KaryawanService karyawanService;
  
  @PostMapping
  public ResponseEntity add(@Valid @RequestBody AddSingleKaryawanAndDetailsDto body) {
    Optional<Karyawan> newKaryawan = Optional.ofNullable(karyawanService.addSingleKaryawanAndDetails(body));
    
    if (!newKaryawan.isPresent()) return new ResponseEntity<>(
      new ErrorMessage(HttpStatus.NOT_FOUND, "New karyawan is not found"),
      HttpStatus.NOT_FOUND
    );
    
    return new ResponseEntity<>(
      newKaryawan,
      HttpStatus.OK
    );
  }
  
  
}
