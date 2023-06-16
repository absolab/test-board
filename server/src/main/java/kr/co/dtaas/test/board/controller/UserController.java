package kr.co.dtaas.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.co.dtaas.test.board.dto.UserDto;
import kr.co.dtaas.test.board.responseObject.LoginResponseObject;
import kr.co.dtaas.test.board.responseObject.ResponseObject;
import kr.co.dtaas.test.board.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users/login")
    public ResponseObject login(HttpServletRequest req, UserDto user) {

        ResponseObject result;
        
        System.out.println("/users/login " + user.getId() + ", " + user.getPwd());
        
        result = userService.login(user);

        if (result.getResult() == ResponseObject.SUCCESS) {
            req.getSession().setAttribute("login", result.getData());
        }

        return result;
    }

    @GetMapping("/users/login")
    public String isLogined(HttpServletRequest req) {

        ResponseObject result;

        Object data = req.getSession().getAttribute("login");
        if (data == null) return "세션 없음";
        else return "세션 있음";
    }

    @PostMapping("/users/logout")
    public ResponseObject logout(HttpServletRequest req) {

        return userService.logout();
    }
}
