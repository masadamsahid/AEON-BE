package com.example.aeon.services;

import com.example.aeon.dtos.rekening.AddSingleRekeningDto;
import com.example.aeon.entities.Rekening;

public interface RekeningService {
  Rekening addRekeningToKaryawan(Long karyawanId, AddSingleRekeningDto fields);
}
