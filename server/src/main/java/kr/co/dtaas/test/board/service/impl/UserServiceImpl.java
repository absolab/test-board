package kr.co.dtaas.test.board.service.impl;

import kr.co.dtaas.test.board.dto.UserEntity;

public interface UserServiceImpl {

    public UserEntity login(UserEntity user);

    public boolean logout();
}
