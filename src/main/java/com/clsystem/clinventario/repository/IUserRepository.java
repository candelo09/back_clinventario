package com.clsystem.clinventario.repository;

import com.clsystem.clinventario.entity.User;

import java.util.List;

public interface IUserRepository {

    public Iterable<User> getUsers();

    public void addUser(User user);

    public void removeUser(User user);

    public void updateUser(User user);
}
