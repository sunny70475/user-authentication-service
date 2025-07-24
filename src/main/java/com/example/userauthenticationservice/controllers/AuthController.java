package com.example.userauthenticationservice.controllers;

import com.example.userauthenticationservice.dtos.LoginRequestDto;
import com.example.userauthenticationservice.dtos.SignUpRequestDto;
import com.example.userauthenticationservice.dtos.UserDto;
import com.example.userauthenticationservice.dtos.ValidateTokenRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignUpRequestDto signUpRequestDto) {
        return null;
    }


    @PostMapping("/login")
    public UserDto login(@RequestBody LoginRequestDto loginRequestDto) {
        return null;
    }

    @PostMapping("/validateToken")
    public Boolean validateToken(@RequestBody ValidateTokenRequestDto validateTokenRequestDto) {
        return null;
    }

    //ToDO
    //logout
    //forgetPassword

}
