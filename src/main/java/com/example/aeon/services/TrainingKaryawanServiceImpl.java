package com.example.aeon.services;

import com.example.aeon.dtos.BasicPaginationOptions;
import com.example.aeon.dtos.training_karyawan.AddSingleTrainingKaryawanDto;
import com.example.aeon.entities.Karyawan;
import com.example.aeon.entities.Training;
import com.example.aeon.entities.TrainingKaryawan;
import com.example.aeon.repositories.KaryawanRepository;
import com.example.aeon.repositories.TrainingKaryawanRepository;
import com.example.aeon.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingKaryawanServiceImpl implements TrainingKaryawanService {
  
  @Autowired
  private TrainingKaryawanRepository trainingKaryawanRepository;
  
  @Autowired
  private KaryawanRepository karyawanRepository;
  
  @Autowired
  private TrainingRepository trainingRepository;
  
  @Override
  public TrainingKaryawan addNewTrainingKarywan(AddSingleTrainingKaryawanDto fields) {
  
    Optional<Karyawan> karyawan = karyawanRepository.findById(fields.getKaryawan_id());
    if (!karyawan.isPresent()) return null;
    
    Optional<Training> training = trainingRepository.findById(fields.getTraining_id());
    if (!training.isPresent()) return null;
    
    
    
    TrainingKaryawan newTrainingKaryawan = new TrainingKaryawan();
    newTrainingKaryawan.setKaryawan(karyawan.get());
    newTrainingKaryawan.setTraining(training.get());
    
    return trainingKaryawanRepository.save(newTrainingKaryawan);
  }
  
  @Override
  public List<TrainingKaryawan> getTKByNamaKaryawanAndTemaTraining(String namaKaryawan, String temaTraining, BasicPaginationOptions paginationOpts) {
  
    Pageable pagination = PageRequest.of(
      Math.toIntExact((paginationOpts.getPage() - 1)),
      Math.toIntExact(paginationOpts.getPageSize())
    );
    
    Page<TrainingKaryawan> trainingKaryawanList = trainingKaryawanRepository.findByNamaKaryawanAndTemaTraining(namaKaryawan, temaTraining, pagination);
    
    return trainingKaryawanList.toList();
  }
}
