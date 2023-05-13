package com.example.aeon.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(
  uniqueConstraints = @UniqueConstraint(columnNames = {"karyawan_id", "training_id"})
)
public class TrainingKaryawan extends BaseEntity{
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @ManyToOne
  @JoinColumn(name = "karyawan_id", nullable = false)
  private Karyawan karyawan;
  
  @ManyToOne
  @JoinColumn(name = "training_id", nullable = false)
  private Training training;
  
}
