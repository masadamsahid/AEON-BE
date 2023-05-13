package com.example.aeon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Training extends BaseEntity{
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(nullable = false)
  private String namaPengajar;
  
  @Column(nullable = false)
  private String tema;
  
  @JsonIgnore
  @OneToMany(
    mappedBy = "training",
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  private List<TrainingKaryawan> trainingKaryawanList;
  
}
