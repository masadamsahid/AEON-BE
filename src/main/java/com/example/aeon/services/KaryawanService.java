package com.example.aeon.services;


import com.example.aeon.dtos.karyawan.AddSingleKaryawanAndDetailsDto;
import com.example.aeon.dtos.BasicPaginationOptions;
import com.example.aeon.dtos.karyawan.UpdateKaryawanAndDetailsByIdDto;
import com.example.aeon.entities.Karyawan;

import java.util.List;
import java.util.Optional;

public interface KaryawanService {
  Karyawan addSingleKaryawanAndDetails(AddSingleKaryawanAndDetailsDto body);
  
  List<Karyawan> getKaryawanListByNama(String nama, BasicPaginationOptions paginationOpts);
  
  Optional<Karyawan> getKaryawanById(Long id);
  
  Optional<Karyawan> updateKaryawanById(Long id, UpdateKaryawanAndDetailsByIdDto updatedFields);
}
