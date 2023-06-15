package kr.co.dtaas.test.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dtaas.test.board.repository.jpa.UserRepository;
import kr.co.dtaas.test.board.responseObject.LoginResponseObject;
import kr.co.dtaas.test.board.responseObject.ResponseObject;
import kr.co.dtaas.test.board.service.impl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseObject login(String id, String pwd) {

        LoginResponseObject result = new LoginResponseObject();
        int count = userRepository.countByIdAndPwd(id, pwd);

        if (count == 1) {
            result.success();
        } else {
            result.fail();
        }

        return result;
    }
}
