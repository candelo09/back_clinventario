package com.clsystem.clinventario.daorepository;

import com.clsystem.clinventario.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserDaoRepository extends CrudRepository<User, Integer> {


}
