package com.example.aeon.dtos.training_karyawan;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class AddSingleTrainingKaryawanDto {
  
  @NotNull
  @Min(1)
  private Long karyawan_id;
  
  @NotNull
  @Min(1)
  private Long training_id;
  
}
