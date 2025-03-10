package com.clsystem.clinventario.services;

import com.clsystem.clinventario.daorepository.IMembershipDaoRepository;
import com.clsystem.clinventario.entity.Membership;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Membership_Service")
@DataJpaTest
public class MembershipServiceTest {
    @Autowired
    IMembershipDaoRepository membershipDao;

    @BeforeEach
    void setUp() throws Exception {
        membershipDao.deleteAll();
        membershipDao.save(new Membership("Premium", 75000.0, 1, 1));
        membershipDao.save(new Membership("Gold", 45000.0, 1, 2));
    }

    @Test
    void findAll() {
        Iterable<Membership> memberships = membershipDao.findAll();
        assertEquals(2, ((Collection<?>) memberships).size());
    }

    @Test
    void testSave() {
        // Given
        Membership membership = new Membership("Premium", 75000.0, 1, 1);
        // When
        Membership membershipSaved = membershipDao.save(membership);
        // Then
        assertEquals(membershipSaved.getId(), membership.getId());
        assertEquals("Premium", membershipSaved.getType_membership());
        assertEquals(75000.0, membershipSaved.getPrice(), 0);
        assertEquals(1, membershipSaved.getState());
    }

}
