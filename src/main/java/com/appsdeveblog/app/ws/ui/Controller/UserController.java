package com.appsdeveblog.app.ws.ui.Controller;

import com.appsdeveblog.app.ws.Service.UserService;
import com.appsdeveblog.app.ws.shared.dto.UserDto;
import com.appsdeveblog.app.ws.ui.model.Request.UserDetailsRequestModel;
import com.appsdeveblog.app.ws.ui.model.Response.UserRest;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){
        return "get user is called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){

        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @PutMapping
    public String updatetUser(){
        return "update user is called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user is called";
    }

}
