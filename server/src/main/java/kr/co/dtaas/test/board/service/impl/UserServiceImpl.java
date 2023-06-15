package kr.co.dtaas.test.board.service.impl;

import kr.co.dtaas.test.board.responseObject.ResponseObject;

public interface UserServiceImpl {

    public ResponseObject login(String id, String pwd);
}
