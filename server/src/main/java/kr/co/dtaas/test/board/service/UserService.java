package kr.co.dtaas.test.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.dtaas.test.board.dto.UserDto;
import kr.co.dtaas.test.board.repository.jpa.UserRepository;
import kr.co.dtaas.test.board.responseObject.LoginResponseObject;
import kr.co.dtaas.test.board.responseObject.ResponseObject;
import kr.co.dtaas.test.board.service.impl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionService sessionService;

    @Override
    public ResponseObject login(HttpServletRequest req, UserDto user) {

        LoginResponseObject result;
        UserDto data = userRepository.findOneByIdAndPwd(user.getId(), user.getPwd());

        if (data != null) {
            sessionService.setSession(req, user);
            result = new LoginResponseObject(LoginResponseObject.LOGIN_SUCCESS, data);
        } else {
            result = new LoginResponseObject(LoginResponseObject.INVALID_PASSWORD, data);   // 이 부분을 어떻게 하면 깔끔할까
        }

        return result;
    }

    @Override
    public ResponseObject logout(HttpServletRequest req) {

        sessionService.deleteSessoin(req);
        LoginResponseObject result = new LoginResponseObject(LoginResponseObject.LOGOUT_SUCCESS, null);

        return result;
    }
}
