package com.clsystem.clinventario.repository;

import com.clsystem.clinventario.entity.PhysicalProgress;

import java.util.Optional;

public interface IPhysicalProgressRepository {

    public Iterable<PhysicalProgress> findAllPhysicalProgress();

    public Optional<PhysicalProgress> findByIdPhysicalProgress(Long id);

    public void addPhysicalProgress(PhysicalProgress category);

    public void removePhysicalProgress(Integer id);

    public void updatePhysicalProgress(PhysicalProgress category);

}
