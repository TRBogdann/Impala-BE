package com.server.impala.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;

import com.server.impala.contract.AuthServiceInterface;
import com.server.impala.model.request.user.CreateUserModel;
import com.server.impala.model.response.ApiResponse;

import jakarta.validation.Valid;

@RestController
public class AuthController {
    private final AuthServiceInterface authService;
    private final MessageSource messageSource;

    public AuthController(
        AuthServiceInterface authService,
        MessageSource messageSource
    )
    {
        this.authService = authService;
        this.messageSource = messageSource;
    }

    @PostMapping("/auth/create_user")
    public ResponseEntity<ApiResponse<?>> createUser(@RequestBody @Valid CreateUserModel createUserModel) {
        Map<String, Object> conflictErrors = this.authService.getUserConflictErrors(createUserModel);

        if(!conflictErrors.isEmpty()){
            return ResponseEntity.status(409)
                .body(
                    new ApiResponse<>(
                        null,
                        messageSource.getMessage("user.error.create", null, LocaleContextHolder.getLocale()),
                        conflictErrors)
                );
        }

        return this.authService.createUser(createUserModel);
    }
}