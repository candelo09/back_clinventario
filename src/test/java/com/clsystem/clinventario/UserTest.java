package com.clsystem.clinventario;

import com.clsystem.clinventario.controller.UserController;
import com.clsystem.clinventario.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserController userController;

    /**
     * TEST USERNAME
     */
    @Test
    public void testUserName(){
        String username = "admin";

        ResponseEntity<?> testUserRes = userController.getAllUsers();

        List<User> users = (List<User>) testUserRes.getBody();

        assertThat(testUserRes).isNotNull();
        assert users != null;
        assertThat(users.get(0).getUsername()).isEqualTo("TEST");
    }
}
