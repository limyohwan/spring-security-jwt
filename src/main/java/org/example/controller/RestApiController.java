package org.example.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RestApiController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @GetMapping("/home")
    public String home(){
        return "<h1>home</h1>";
    }

    @PostMapping("/token")
    public String token(){
        return "<h1>token</h1>";
    }

    @PostMapping("/join")
    public String join(@RequestBody User user){
        String encPassword = passwordEncoder.encode(user.getPassword());
        user.changeEncPassword(encPassword);
        user.setUserRole();
        userRepository.save(user);

        return "회원가입완료";
    }

    @GetMapping("/api/v1/user")
    public String user(){
        return "user";
    }

    @GetMapping("/api/v1/manager")
    public String manager(){
        return "manager";
    }

    @GetMapping("/api/v1/admin")
    public String admin(){
        return "admin";
    }
}
