package com.example.aeon.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Rekening extends BaseEntity{
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String nama;
  
  private String jenis;
  
  private String nomor;
  
  @ManyToOne
  @JoinColumn(name = "karyawan_id", nullable = false)
  private Karyawan karyawan;
  
}
