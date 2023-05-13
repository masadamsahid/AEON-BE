package com.example.aeon.dtos.karyawan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicPaginationOptions {
  
  @NotNull
  private Long page;
  
  @NotNull
  private Long pageSize;
  
}
