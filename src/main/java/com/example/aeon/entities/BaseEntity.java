package com.example.aeon.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {
  
  @Column(updatable = false, nullable = false)
  @CreationTimestamp
  private LocalDateTime created_date;
  
  @Column(nullable = false)
  @UpdateTimestamp
  private LocalDateTime updated_date;
  
  private LocalDateTime deleted_date;
  
}
