package com.example.aeon.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Karyawan extends BaseEntity{
  
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(nullable = false)
  private String nama; // Name
  
  @Column(nullable = false)
  private String jk; // Jenis kelamin (sex)
  
  @Column(nullable = false)
  private String status; // Marriage status
  
  private String alamat; // Address
  
}
