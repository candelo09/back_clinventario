package com.clsystem.clinventario.services;

import com.clsystem.clinventario.daorepository.IUserDaoRepository;
import com.clsystem.clinventario.entity.User;
import com.clsystem.clinventario.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserRepository {

    @Autowired
    private IUserDaoRepository userDao;


    @Override
    public Iterable<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    public void addUser(User user) {

        userDao.save(user);
    }

    @Override
    public void removeUser(User user) {
        userDao.delete(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }
}
