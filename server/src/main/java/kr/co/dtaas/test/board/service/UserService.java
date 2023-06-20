package kr.co.dtaas.test.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dtaas.test.board.dto.UserEntity;
import kr.co.dtaas.test.board.repository.jpa.UserRepository;
import kr.co.dtaas.test.board.responseObject.LoginResponseObject;
import kr.co.dtaas.test.board.responseObject.ResponseObject;
import kr.co.dtaas.test.board.service.impl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseObject login(UserEntity user) {

        LoginResponseObject result;

        UserEntity data = userRepository.findOneByIdAndPwd(user.getId(), user.getPwd());

        if (data != null) {
            result = new LoginResponseObject(LoginResponseObject.LOGIN_SUCCESS, data);
        } else {
            result = new LoginResponseObject(LoginResponseObject.INVALID_PASSWORD);
        }

        return result;
    }

    @Override
    public ResponseObject logout() {

        LoginResponseObject result = new LoginResponseObject(LoginResponseObject.LOGOUT_SUCCESS);

        return result;
    }
}
