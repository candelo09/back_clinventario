package com.clsystem.clinventario.daorepository;

import com.clsystem.clinventario.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserDaoRepository extends CrudRepository<User, Integer> {

    public Optional<User> findByUsernameAndPassword(@Param("user") String username,
                                          @Param("pass") String pass);

    public Optional<User> findByUsername(String username);


}
