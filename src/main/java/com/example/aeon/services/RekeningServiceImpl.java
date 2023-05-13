package com.example.aeon.services;

import com.example.aeon.dtos.rekening.AddSingleRekeningDto;
import com.example.aeon.entities.Karyawan;
import com.example.aeon.entities.Rekening;
import com.example.aeon.repositories.KaryawanRepository;
import com.example.aeon.repositories.RekeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RekeningServiceImpl implements RekeningService {
  
  @Autowired
  private KaryawanRepository karyawanRepository;
  
  @Autowired
  private RekeningRepository rekeningRepository;
  
  @Override
  public Rekening addRekeningToKaryawan(Long karyawanId, AddSingleRekeningDto fields) {
    Optional<Karyawan> karyawan = karyawanRepository.findById(karyawanId);
    
    if (!karyawan.isPresent()) return null;
    
    Rekening newRekening = new Rekening();
    newRekening.setNama(fields.getNama());
    newRekening.setJenis(fields.getJenis());
    newRekening.setNomor(fields.getNomor());
    newRekening.setKaryawan(karyawan.get());
    
    return rekeningRepository.save(newRekening);
  }
}
