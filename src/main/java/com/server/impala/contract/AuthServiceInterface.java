package com.server.impala.contract;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.server.impala.model.request.user.CreateUserModel;
import com.server.impala.model.response.ApiResponse;

public interface AuthServiceInterface {
    String encryptPassword(String password);
    boolean checkPassword(String password, String hash);
    Map<String, Object> getUserConflictErrors(CreateUserModel model);
    ResponseEntity<ApiResponse<?>> createUser(CreateUserModel createUserModel);
}
