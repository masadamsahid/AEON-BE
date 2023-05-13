package com.example.aeon.services;

import com.example.aeon.dtos.karyawan.AddSingleKaryawanAndDetailsDto;
import com.example.aeon.dtos.karyawan.BasicPaginationOptions;
import com.example.aeon.entities.DetailKaryawan;
import com.example.aeon.entities.Karyawan;
import com.example.aeon.repositories.KaryawanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
