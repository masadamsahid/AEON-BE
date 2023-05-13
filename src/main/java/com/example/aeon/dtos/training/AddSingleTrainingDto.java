package com.example.aeon.dtos.training;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class AddSingleTrainingDto {
  
  @NotBlank
  private String namaPengajar;
  
  @NotBlank
  private String tema;
  
}
