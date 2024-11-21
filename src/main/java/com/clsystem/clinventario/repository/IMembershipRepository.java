package com.clsystem.clinventario.repository;

import com.clsystem.clinventario.entity.Membership;

import java.util.Optional;

public interface IMembershipRepository {

    public Iterable<Membership> findAllMemberships();

    public Optional<Membership> findByIdMembership(Long id);

    public void addMembership(Membership membership);

    public void removeMembership(Membership membership);

    public void updateMembership(Membership membership);
}
