package com.example.aeon.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
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
  
  @JsonManagedReference(value = "karyawan")
  @OneToOne(
    mappedBy = "karyawan",
    cascade = CascadeType.ALL
  )
  @PrimaryKeyJoinColumn
  private DetailKaryawan detailKaryawan;
  
}
