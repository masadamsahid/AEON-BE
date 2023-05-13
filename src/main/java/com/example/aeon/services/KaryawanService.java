package com.example.aeon.services;


import com.example.aeon.dtos.karyawan.AddSingleKaryawanAndDetailsDto;
import com.example.aeon.entities.Karyawan;

public interface KaryawanService {
  Karyawan addSingleKaryawanAndDetails(AddSingleKaryawanAndDetailsDto body);
}
