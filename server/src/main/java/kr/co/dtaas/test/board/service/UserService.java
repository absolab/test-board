package kr.co.dtaas.test.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dtaas.test.board.dto.UserEntity;
import kr.co.dtaas.test.board.repository.jpa.UserRepository;
import kr.co.dtaas.test.board.service.impl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity login(UserEntity user) {

        UserEntity data = userRepository.findOneByIdAndPwd(user.getId(), user.getPwd());

        return data;
    }

    @Override
    public boolean logout() {

        return true;
    }
}
