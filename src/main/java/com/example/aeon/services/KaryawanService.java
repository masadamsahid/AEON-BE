package com.example.aeon.services;


import com.example.aeon.dtos.karyawan.AddSingleKaryawanAndDetailsDto;
import com.example.aeon.dtos.karyawan.BasicPaginationOptions;
import com.example.aeon.entities.Karyawan;

import java.util.List;

public interface KaryawanService {
  Karyawan addSingleKaryawanAndDetails(AddSingleKaryawanAndDetailsDto body);
  
  List<Karyawan> getKaryawanListByNama(String nama, BasicPaginationOptions paginationOpts);
}
