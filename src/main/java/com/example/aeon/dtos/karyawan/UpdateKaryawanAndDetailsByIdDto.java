package com.example.aeon.dtos.karyawan;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UpdateKaryawanAndDetailsByIdDto {
  
  private String nama;
  
  private String jk;
  
  private String status;
  
  @Size(max = 128, message = "Max 128 characters")
  private String alamat;
  
  @Pattern(regexp = "[0-9]{16}", message = "Must be 16 numeric chars")
  private String nik;
  
  private String npwp;
  
}
