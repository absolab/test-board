package kr.co.dtaas.test.board.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.dtaas.test.board.dto.UserDto;
import kr.co.dtaas.test.board.responseObject.ResponseObject;

public interface UserServiceImpl {

    public ResponseObject login(HttpServletRequest req, UserDto user);

    public ResponseObject logout(HttpServletRequest req);
}
