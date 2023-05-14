package com.example.aeon.controllers;

import com.example.aeon.dtos.BasicPaginationOptions;
import com.example.aeon.dtos.rekening.AddSingleRekeningDto;
import com.example.aeon.entities.ErrorMessage;
import com.example.aeon.entities.Rekening;
import com.example.aeon.services.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/rekening")
public class RekeningController {
  
  @Autowired
  private RekeningService rekeningService;
  
  @PostMapping("/{karyawanId}")
  public ResponseEntity addRekeningToKaryawan(@PathVariable("karyawanId") String karyawanId,
                                    @Valid @RequestBody AddSingleRekeningDto fields){
    
    Rekening newRekening = rekeningService.addRekeningToKaryawan(Long.valueOf(karyawanId), fields);
    
    if (newRekening == null) return new ResponseEntity<>(
      new ErrorMessage(HttpStatus.NOT_FOUND, "Rekening gagal dibuat"),
      HttpStatus.BAD_REQUEST
    );
  
    return new ResponseEntity<>(
      newRekening,
      HttpStatus.OK
    );
    
  }
  
  @GetMapping
  public ResponseEntity getRekeningList(@Valid @RequestBody BasicPaginationOptions paginationOptions){
    List<Rekening> rekeningList = rekeningService.getRekeningList(paginationOptions);
  
    if (rekeningList.size() == 0){
      return new ResponseEntity<>(
        new ErrorMessage(HttpStatus.NOT_FOUND, "Rekening tidak ditemukan."),
        HttpStatus.NOT_FOUND
      );
    }
  
    return new ResponseEntity<>(
      rekeningList,
      HttpStatus.OK
    );
  }
  
  @GetMapping("/{id}")
  public ResponseEntity getRekeningById(@PathVariable("id") String id){
    Rekening rekening = rekeningService.getById(Long.valueOf(id));
    
    if (rekening == null) return new ResponseEntity<>(
      new ErrorMessage(HttpStatus.NOT_FOUND, "Rekening tidak ditemukan."),
      HttpStatus.NOT_FOUND
    );
  
    return new ResponseEntity<>(
      rekening,
      HttpStatus.OK
    );
  }
  
}
