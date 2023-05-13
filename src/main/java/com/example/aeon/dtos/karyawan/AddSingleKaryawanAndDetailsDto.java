package com.example.aeon.dtos.karyawan;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class AddSingleKaryawanAndDetailsDto {
  
  @NotBlank
  private String nama;
  
  @NotBlank
  private String jk;
  
  @NotBlank
  private String status;
  
  @Max(value = 128, message = "Max 128 characters")
  private String alamat;
  
  @NotBlank
  @Pattern(regexp = "[0-9]{16}", message = "Must be 16 numeric chars")
  private String nik;
  
  private String npwp;
}
