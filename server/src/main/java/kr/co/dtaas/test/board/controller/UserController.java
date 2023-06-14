package kr.co.dtaas.test.board.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/users/login")
    public String login(String id, String pwd) {
        return id + " " + pwd;
    }
}
