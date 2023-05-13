package com.example.aeon.services;

import com.example.aeon.dtos.karyawan.AddSingleKaryawanAndDetailsDto;
import com.example.aeon.dtos.BasicPaginationOptions;
import com.example.aeon.dtos.karyawan.UpdateKaryawanAndDetailsByIdDto;
import com.example.aeon.entities.DetailKaryawan;
import com.example.aeon.entities.Karyawan;
import com.example.aeon.repositories.KaryawanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class KaryawanServiceImpl implements KaryawanService{
  
  @Autowired
  private KaryawanRepository karyawanRepository;
  
  
  @Override
  public Karyawan addSingleKaryawanAndDetails(AddSingleKaryawanAndDetailsDto body) {
    Karyawan karyawan = new Karyawan();
    
    karyawan.setNama(body.getNama());
    karyawan.setJk(body.getJk());
    karyawan.setStatus(body.getStatus());
    karyawan.setAlamat(body.getAlamat());
  
    DetailKaryawan detailKaryawan = new DetailKaryawan();
  
    karyawan.setDetailKaryawan(detailKaryawan);
    detailKaryawan.setKaryawan(karyawan);
    
    detailKaryawan.setNik(body.getNik());
    detailKaryawan.setNpwp(body.getNpwp());
    
    log.info("=================== BEFORE INSERTING ===================");
    Karyawan savedKaryawan = karyawanRepository.saveAndFlush(karyawan);
    log.info("=================== AFTER INSERTING ===================");
    
    log.info("=================== RETURNING ===================");
    return savedKaryawan;
  }
  
  @Override
  public List<Karyawan> getKaryawanListByNama(String nama, BasicPaginationOptions paginationOpts) {
  
    Pageable pagination = PageRequest.of(
      Math.toIntExact((paginationOpts.getPage() - 1) * paginationOpts.getPageSize()),
      Math.toIntExact(paginationOpts.getPageSize())
    );
    
    List<Karyawan> karyawanList = karyawanRepository.findByNamaContaining(nama, pagination).getContent();
    
    return karyawanList;
  }
  
  @Override
  public Optional<Karyawan> getKaryawanById(Long id) {
    return karyawanRepository.findById(id);
  }
  
  @Override
  public Optional<Karyawan> updateKaryawanById(Long id, UpdateKaryawanAndDetailsByIdDto updatedFields) {
    
    Optional<Karyawan> optKaryawan = karyawanRepository.findById(id);
    
    Karyawan karyawan;
    if (optKaryawan.isPresent()){
      karyawan = optKaryawan.get();
    } else {
      return Optional.empty();
    }
    
  
    if (updatedFields.getNama() != null) karyawan.setNama(updatedFields.getNama());
    if (updatedFields.getJk() != null) karyawan.setJk(updatedFields.getJk());
    if (updatedFields.getStatus() != null) karyawan.setStatus(updatedFields.getStatus());
    if (updatedFields.getAlamat() != null) karyawan.setAlamat(updatedFields.getAlamat());
    
    if (updatedFields.getNik() != null) karyawan.getDetailKaryawan().setNik(updatedFields.getNik());
    if (updatedFields.getNpwp() != null) karyawan.getDetailKaryawan().setNpwp(updatedFields.getNpwp());
    
    Karyawan updatedKaryawan = karyawanRepository.save(karyawan);
    
    return Optional.of(updatedKaryawan);
  }
}
