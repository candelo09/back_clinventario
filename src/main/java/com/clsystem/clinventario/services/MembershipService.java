package com.clsystem.clinventario.services;

import com.clsystem.clinventario.daorepository.IMembershipDaoRepository;
import com.clsystem.clinventario.entity.Membership;
import com.clsystem.clinventario.repository.IMembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MembershipService implements IMembershipRepository {

    @Autowired
    private IMembershipDaoRepository membershipDao;


    @Override
    public Iterable<Membership> findAllMemberships() {
        return membershipDao.findAll();
    }

    @Override
    public Optional<Membership> findByIdMembership(Long id) {
        return membershipDao.findById(id);
    }

    @Override
    public void addMembership(Membership membership) {

        membershipDao.save(membership);

    }

    @Override
    public void removeMembership(Membership membership) {

        membershipDao.delete(membership);

    }

    @Override
    public void updateMembership(Membership membership) {

        membershipDao.save(membership);

    }
}
