package com.example.aeon.services;

import com.example.aeon.dtos.BasicPaginationOptions;
import com.example.aeon.dtos.rekening.AddSingleRekeningDto;
import com.example.aeon.entities.Rekening;

import java.util.List;

public interface RekeningService {
  Rekening addRekeningToKaryawan(Long karyawanId, AddSingleRekeningDto fields);
  
  List<Rekening> getRekeningList(BasicPaginationOptions paginationOpts);
  
  Rekening getById(Long id);
}
