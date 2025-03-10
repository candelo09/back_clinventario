package com.clsystem.clinventario.services;

import com.clsystem.clinventario.daorepository.IClassTrainingDaoRepository;
import com.clsystem.clinventario.entity.ClassTraining;
import com.clsystem.clinventario.repository.IClassTrainingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Class_Training_Service")
@DataJpaTest
public class ClassTrainingServiceTest {

    @Autowired
    IClassTrainingDaoRepository classTrainingRepository;

    @BeforeEach
    void setUp() throws Exception {
        classTrainingRepository.deleteAll();
        classTrainingRepository.save(new ClassTraining(null, 15, new Date(), new Date(), "Clase test", 1, "Clase 1"));
        classTrainingRepository.save(new ClassTraining(null, 20, new Date(), new Date(), "Clase test 2", 1, "Clase 2"));
    }

    @Test()
    void testFindAll() {
        Iterable<ClassTraining> classTrainings = classTrainingRepository.findAll();
        assertEquals(2, ((Collection<?>) classTrainings).size());
    }

    @Test
    void testSave() {
        // Given
        ClassTraining training = new ClassTraining(null, 15, new Date(), new Date(), "Clase test 3", 1, "Clase 3");
        // When
        ClassTraining savedTraining = classTrainingRepository.save(training);
        // Then
        assertEquals(savedTraining.getId(), training.getId());
        assertEquals("Clase test 3", savedTraining.getDescription());
        assertEquals(15, savedTraining.getMax_capacity());
        assertEquals(1, savedTraining.getId_user());
        assertEquals("Clase 3", savedTraining.getType_class());
    }

    @Test
    void testFindById() {
        // Given
        ClassTraining training = new ClassTraining(null, 15, new Date(), new Date(), "Clase test 3", 1, "Clase 3");
        classTrainingRepository.save(training);
        // When
        Optional<ClassTraining> trainingFound = classTrainingRepository.findById(training.getId());
        // Then
        assertTrue(trainingFound.isPresent());
        assertEquals("Clase test 3", trainingFound.get().getDescription());
        assertEquals(15, trainingFound.get().getMax_capacity());
        assertEquals(1, trainingFound.get().getId_user());
        assertEquals("Clase 3", trainingFound.get().getType_class());
    }

    @Test
    void testDelete() {
        // Given
        ClassTraining training = classTrainingRepository.save(new ClassTraining(null, 15, new Date(), new Date(), "Clase test 3", 1, "Clase 3"));
        // When
        classTrainingRepository.delete(training);
        Optional<ClassTraining> trainingFound = classTrainingRepository.findById(training.getId());
        //Then
        assertFalse(trainingFound.isPresent());
    }

}
