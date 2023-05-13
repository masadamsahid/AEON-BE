package com.example.aeon.services;

import com.example.aeon.dtos.karyawan.AddSingleKaryawanAndDetailsDto;
import com.example.aeon.entities.DetailKaryawan;
import com.example.aeon.entities.Karyawan;
import com.example.aeon.repositories.DetailKaryawanRepository;
import com.example.aeon.repositories.KaryawanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KaryawanServiceImpl implements KaryawanService{
  
  @Autowired
  private KaryawanRepository karyawanRepository;
  
  @Autowired
  private DetailKaryawanRepository detailKaryawanRepository;
  
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
}
