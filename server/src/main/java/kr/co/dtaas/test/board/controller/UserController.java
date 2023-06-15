package kr.co.dtaas.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.dtaas.test.board.dto.UserDto;
import kr.co.dtaas.test.board.responseObject.ResponseObject;
import kr.co.dtaas.test.board.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users/login")
    public ResponseObject login(HttpServletRequest req, UserDto user) {

        return userService.login(req, user);
    }

    @PostMapping("/users/logout")
    public ResponseObject logout(HttpServletRequest req) {

        return userService.logout(req);
    }
}
