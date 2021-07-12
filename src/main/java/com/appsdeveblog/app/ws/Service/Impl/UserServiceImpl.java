package com.appsdeveblog.app.ws.Service.Impl;

import com.appsdeveblog.app.ws.Service.UserService;
import com.appsdeveblog.app.ws.UserRepository;
import com.appsdeveblog.app.ws.io.Entity.UserEntity;
import com.appsdeveblog.app.ws.shared.dto.UserDto;
import com.appsdeveblog.app.ws.shared.dto.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {


        //UserEntity storedUserDetails = userRepository.findByEmail(user.getEmail());

        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record Already Exits");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        String publicUserId = utils.generateUserId(30);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId(publicUserId);

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }
}