package kr.co.dtaas.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.dtaas.test.board.dto.UserEntity;
import kr.co.dtaas.test.board.responseObject.LoginResponseObject;
import kr.co.dtaas.test.board.responseObject.ResponseObject;
import kr.co.dtaas.test.board.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/login")
    public ResponseObject login(HttpServletRequest req, UserEntity user) {

        ResponseObject response;

        UserEntity data = userService.login(user);

        if (data == null) {
            response = new LoginResponseObject(LoginResponseObject.INVALID_PASSWORD);
        } else {
            response = new LoginResponseObject(LoginResponseObject.LOGIN_SUCCESS, data);
            req.getSession().setAttribute("login", data);
        }

        return response;
    }

    @GetMapping("/user/login")
    public ResponseObject isLogined(HttpServletRequest req) {

        ResponseObject response;

        Object data = req.getSession().getAttribute("login");

        if (data != null) {
            System.out.println(data);
            response = new LoginResponseObject(LoginResponseObject.IS_LOGGED_IN);
        } else {
            response = new LoginResponseObject(LoginResponseObject.IS_NOT_LOGGED_IN);
        }

        return response;
    }

    @PostMapping("/user/logout")
    public ResponseObject logout(HttpServletRequest req) {

        ResponseObject response;

        req.getSession().removeAttribute("login");

        response = new LoginResponseObject(LoginResponseObject.LOGOUT_SUCCESS);

        return response;
    }
}
