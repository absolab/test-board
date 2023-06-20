package kr.co.dtaas.test.board.service.impl;

import kr.co.dtaas.test.board.dto.UserEntity;
import kr.co.dtaas.test.board.responseObject.ResponseObject;

public interface UserServiceImpl {

    public ResponseObject login(UserEntity user);

    public ResponseObject logout();
}
