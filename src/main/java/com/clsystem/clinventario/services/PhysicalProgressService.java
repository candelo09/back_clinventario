package com.clsystem.clinventario.services;


import com.clsystem.clinventario.daorepository.IPhysicalProgressDaoRepository;
import com.clsystem.clinventario.entity.PhysicalProgress;
import com.clsystem.clinventario.repository.IPhysicalProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhysicalProgressService implements IPhysicalProgressRepository {

    @Autowired
    private IPhysicalProgressDaoRepository physicalProgressDao;

    @Override
    public Iterable<PhysicalProgress> findAllPhysicalProgress() {
        return physicalProgressDao.findAll();
    }

    @Override
    public Optional<PhysicalProgress> findByIdPhysicalProgress(Long id) {
        return physicalProgressDao.findById(id);
    }

    @Override
    public void addPhysicalProgress(PhysicalProgress category) {
        physicalProgressDao.save(category);
    }

    @Override
    public void removePhysicalProgress(Integer id) {
        physicalProgressDao.deleteById(Long.valueOf(id));
    }

    @Override
    public void updatePhysicalProgress(PhysicalProgress category) {
        physicalProgressDao.save(category);
    }
}
