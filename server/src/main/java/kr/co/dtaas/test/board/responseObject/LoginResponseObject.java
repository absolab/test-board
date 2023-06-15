package kr.co.dtaas.test.board.responseObject;

import kr.co.dtaas.test.board.dto.UserDto;

public class LoginResponseObject extends ResponseObject {

    public static final int LOGIN_SUCCESS    = 0;
    public static final int ALREADY_LOGINED  = 1;
    public static final int INVALID_PASSWORD = 2;

    public LoginResponseObject(int code, UserDto user) {

        if (code == LOGIN_SUCCESS) {
            result = SUCCESS;
            data = user;
        } else if (code == ALREADY_LOGINED) {
            result = FAIL;
        } else if (code == INVALID_PASSWORD) {
            result = FAIL;
        }
    }
}
