package com.server.impala.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.server.impala.entity.User;
import com.server.impala.model.request.user.CreateUserModel;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper(
            ModelMapper modelMapper
    ) {
        this.modelMapper = modelMapper;

        modelMapper.typeMap(CreateUserModel.class, User.class);
    }

    public <T> T map(Object source, Class<T> destination) {
        return modelMapper.map(source, destination);
    }
}