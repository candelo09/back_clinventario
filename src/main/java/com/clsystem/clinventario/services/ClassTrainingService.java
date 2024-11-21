package com.clsystem.clinventario.services;

import com.clsystem.clinventario.daorepository.IClassTrainingDaoRepository;
import com.clsystem.clinventario.entity.ClassTraining;
import com.clsystem.clinventario.repository.IClassTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassTrainingService implements IClassTrainingRepository {

    @Autowired
    private IClassTrainingDaoRepository classTrainingDaoRepository;
    @Override
    public Iterable<ClassTraining> findAllClassesTraining() {
        return classTrainingDaoRepository.findAll();
    }

    @Override
    public Optional<ClassTraining> findByIdClassTraining(Integer id) {
        return classTrainingDaoRepository.findById(id);
    }

    @Override
    public void addClassTraining(ClassTraining class_training) {

        classTrainingDaoRepository.save(class_training);

    }

    @Override
    public void removeClassTraining(ClassTraining class_training) {

        classTrainingDaoRepository.delete(class_training);

    }

    @Override
    public void updateClassTraining(ClassTraining class_training) {

        classTrainingDaoRepository.save(class_training);

    }
}
