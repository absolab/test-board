package kr.co.dtaas.test.board.responseObject;

import kr.co.dtaas.test.board.dto.UserDto;

public class LoginResponseObject extends ResponseObject {

    public void success(UserDto user) {
        result = SUCCESS;
        data = user;
    }

    public void fail() {
        result = FAIL;
    }
}
