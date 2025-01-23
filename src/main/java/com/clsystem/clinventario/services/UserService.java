package com.clsystem.clinventario.services;

import com.clsystem.clinventario.daorepository.IUserDaoRepository;
import com.clsystem.clinventario.entity.User;
import com.clsystem.clinventario.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


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
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        String passworEncrypString = encoder.encode(user.getPassword());
//
//        user.setPassword(passworEncrypString);
        userDao.save(user);
    }

    @Override
    public void removeUser(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        String passworEncrypString = encoder.encode(user.getPassword());
//
//        user.setPassword(passworEncrypString);
        userDao.save(user);
    }

    @Override
    public Optional<User> loginUser(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
