package com.clsystem.clinventario.repository;


import com.clsystem.clinventario.entity.ClassTraining;

import java.util.Optional;

public interface IClassTrainingRepository {

    public Iterable<ClassTraining> findAllClassesTraining();

    public Optional<ClassTraining> findByIdClassTraining(Integer id);

    public void addClassTraining(ClassTraining class_training);

    public void removeClassTraining(ClassTraining class_training);

    public void updateClassTraining(ClassTraining class_training);
}
