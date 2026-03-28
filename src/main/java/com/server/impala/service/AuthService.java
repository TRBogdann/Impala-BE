package com.server.impala.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.server.impala.contract.AuthServiceInterface;
import com.server.impala.entity.User;
import com.server.impala.mapper.UserMapper;
import com.server.impala.model.request.user.CreateUserModel;
import com.server.impala.model.response.ApiResponse;
import com.server.impala.repository.UserRepository;

@Service
public class AuthService implements AuthServiceInterface{
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final MessageSource messageSource;
    private final UserMapper userMapper;

    public AuthService(
        PasswordEncoder passwordEncoder,
        UserRepository userRepository,
        MessageSource messageSource,
        UserMapper userMapper
    ){  
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.messageSource = messageSource;
        this.userMapper = userMapper;
    }

    @Override
    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean checkPassword(String password, String hash) {
        return passwordEncoder.matches(password, hash);
    }

    @Override
    public Map<String, Object> getUserConflictErrors(CreateUserModel model) {
        Map<String, Object> errors= new HashMap<>();

        if(userRepository.existsByEmail(model.getEmail())){
            errors.put(
                "email",
                messageSource.getMessage("user.error.email_taken", null, LocaleContextHolder.getLocale())
            );
        }

        if(userRepository.existsByUsername(model.getUsername())){
            errors.put(
                "username",
                messageSource.getMessage("user.error.username_taken", null, LocaleContextHolder.getLocale())
            );
        }

        return errors;
    }

    @Override
    public ResponseEntity<ApiResponse<?>> createUser(CreateUserModel createUserModel) {
        User newUser= this.userMapper.map(createUserModel, User.class);
        newUser.setPassword(this.encryptPassword(createUserModel.getPassword()));
        this.userRepository.save(newUser);

        return ResponseEntity.ok(
            new ApiResponse<>(
                null, 
                messageSource.getMessage("user.message.await_confirmation", null, LocaleContextHolder.getLocale()),
                null
        ));
    }

    
}
