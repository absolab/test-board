package kr.co.dtaas.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dtaas.test.board.responseObject.ResponseObject;
import kr.co.dtaas.test.board.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users/login")
    public ResponseObject login(String id, String pwd) {
        return userService.login(id, pwd);
    }

    // @GetMapping("/users/{uid}")
    // public UserDto testJPA(@PathVariable Long uid) {
    //     return userRepository.findOneByUid(uid);
    // }
}
