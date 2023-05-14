package com.example.aeon.services;

import com.example.aeon.dtos.BasicPaginationOptions;
import com.example.aeon.dtos.rekening.AddSingleRekeningDto;
import com.example.aeon.entities.Karyawan;
import com.example.aeon.entities.Rekening;
import com.example.aeon.repositories.KaryawanRepository;
import com.example.aeon.repositories.RekeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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
  
  @Override
  public List<Rekening> getRekeningList(BasicPaginationOptions paginationOpts) {
  
    Pageable pagination = PageRequest.of(
      Math.toIntExact((paginationOpts.getPage() - 1)),
      Math.toIntExact(paginationOpts.getPageSize())
    );
    
    List<Rekening> rekeningList = rekeningRepository.findAll(pagination).toList();
    
    return rekeningList;
  }
  
  @Override
  public Rekening getById(Long id) {
    Optional<Rekening> rekening = rekeningRepository.findById(id);
    
    if (!rekening.isPresent()) return null;
    
    return rekening.get();
  }
}
