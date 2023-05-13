package com.example.aeon.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DetailKaryawan {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(unique = true, nullable = false)
  private String nik;
  
  @Column(unique = true)
  private String npwp;
  
  @JsonBackReference(value = "id_karyawan")
  @OneToOne(
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    optional = false
  )
  @JoinColumn(
    name = "id_karyawan",
    referencedColumnName = "id"
  )
  @MapsId
  private Karyawan karyawan;
  
}
