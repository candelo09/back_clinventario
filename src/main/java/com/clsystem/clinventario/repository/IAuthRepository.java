package com.clsystem.clinventario.repository;

import com.clsystem.clinventario.entity.AuthDto;
import com.clsystem.clinventario.entity.User;

import java.util.Map;

public interface IAuthRepository {

    AuthDto login(Map<String, String> login) throws Exception;
}
