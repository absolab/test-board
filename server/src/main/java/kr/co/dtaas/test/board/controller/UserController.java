package kr.co.dtaas.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dtaas.test.board.dto.UserDto;
import kr.co.dtaas.test.board.repository.jpa.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/users/login")
    public String login(String id, String pwd) {
        return id + " " + pwd;
    }

    @GetMapping("/users/{uid}")
    public UserDto testJPA(@PathVariable Long uid) {
        return userRepository.findOneByUid(uid);
    }
}
