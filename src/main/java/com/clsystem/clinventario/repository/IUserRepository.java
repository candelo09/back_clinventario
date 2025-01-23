package com.clsystem.clinventario.repository;

import com.clsystem.clinventario.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    public Iterable<User> getUsers();

    public void addUser(User user);

    public void removeUser(Integer id);

    public void updateUser(User user);

    public Optional<User> loginUser(User user);
}
