package com.clsystem.clinventario.services;

import com.clsystem.clinventario.daorepository.IUserDaoRepository;
import com.clsystem.clinventario.entity.AuthDto;
import com.clsystem.clinventario.entity.User;
import com.clsystem.clinventario.repository.IAuthRepository;
import com.clsystem.clinventario.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service("AuthServiceImpl")
@RequiredArgsConstructor
public class AuthServiceImpl implements UserDetailsService  {

    private final JwtUtil jwtUtil;

    private final  IUserDaoRepository userDaoRepository;

    private final UserService userService;

//    @Override
    public AuthDto login(Map<String, String> login) throws Exception {
        try {
//            authenticate(login.get("username"), login.get("password"));
//            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//            String passworEncrypString = encoder.encode(login.get("password"));


            User user = userDaoRepository.findByUsernameAndPassword(
                    login.get("username"), login.get("password"))
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            user.setLast_login(new Date());
            userService.updateUser(user);

            String token = jwtUtil.generateToken(user);
            return new AuthDto(user.getUsername(), user.getName(),token);
        } catch (BadCredentialsException | UsernameNotFoundException e) {
            System.out.println(e.getMessage());
            throw new BadCredentialsException("Incorrect username or password");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

//    private void authenticate(String username, String password) {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optionalUser = userDaoRepository.findByUsername(username);
        if(optionalUser.isPresent())
            return optionalUser.get();
        throw new UsernameNotFoundException("Invalid user with username: "+ username);
    }
}
