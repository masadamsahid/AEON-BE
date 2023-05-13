package com.example.aeon.controllers;

import com.example.aeon.dtos.karyawan.AddSingleKaryawanAndDetailsDto;
import com.example.aeon.dtos.BasicPaginationOptions;
import com.example.aeon.dtos.karyawan.UpdateKaryawanAndDetailsByIdDto;
import com.example.aeon.entities.ErrorMessage;
import com.example.aeon.entities.Karyawan;
import com.example.aeon.services.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
  
  @GetMapping
  public ResponseEntity getKaryawanListByNama(@RequestParam("nama") String nama,
                                              @Valid @RequestBody BasicPaginationOptions paginationOpts){
    
    Optional<List<Karyawan>> karyawanList = Optional.ofNullable(karyawanService.getKaryawanListByNama(nama, paginationOpts));
    
    if (!karyawanList.isPresent() || karyawanList.get().isEmpty()){
      return new ResponseEntity<>(
        new ErrorMessage(HttpStatus.NOT_FOUND, "Karyawan tidak ditemukan."),
        HttpStatus.NOT_FOUND
      );
    }
    
    return new ResponseEntity<>(
      karyawanList,
      HttpStatus.OK
    );
  }
  
  @GetMapping("/{id}")
  public ResponseEntity getKaryawanById(@PathVariable("id") String id){
    
    Optional<Karyawan> karyawan = karyawanService.getKaryawanById(Long.valueOf(id));
    
    if (!karyawan.isPresent()){
      return new ResponseEntity<>(
        new ErrorMessage(HttpStatus.NOT_FOUND, "Karyawan tidak ditemukan."),
        HttpStatus.NOT_FOUND
      );
    }
    
    return new ResponseEntity<>(
      karyawan,
      HttpStatus.OK
    );
  }
  
  @PutMapping("/{id}")
  public ResponseEntity updateKaryawanAndDetailsById(@PathVariable("id") String id,
                                                     @Valid @RequestBody UpdateKaryawanAndDetailsByIdDto body){
    
    Optional<Karyawan> updatedKaryawan = karyawanService.updateKaryawanById(Long.valueOf(id), body);
  
    if (!updatedKaryawan.isPresent()){
      return new ResponseEntity<>(
        new ErrorMessage(HttpStatus.NOT_FOUND, "Karyawan tidak ditemukan."),
        HttpStatus.NOT_FOUND
      );
    }
  
    return new ResponseEntity<>(
      updatedKaryawan,
      HttpStatus.OK
    );
    
  }
  
  
}
