package kr.co.dtaas.test.board.responseObject;

import kr.co.dtaas.test.board.dto.UserDto;

public class LoginResponseObject extends ResponseObject {

    // Login
    public static final int LOGIN_SUCCESS    = 1000;
    public static final int ALREADY_LOGINED  = 1001;
    public static final int INVALID_PASSWORD = 1002;

    // Logout
    public static final int LOGOUT_SUCCESS   = 2001;
    public static final int NOT_LOGGED_IN    = 2002;


    public LoginResponseObject(int code, UserDto user) {

        switch(code) {
        case LOGIN_SUCCESS:
            result = SUCCESS;
            msg = LOGIN_SUCCESS;
            data = user;
            break;

        case ALREADY_LOGINED:
            result = FAIL;
            msg = ALREADY_LOGINED;
            break;

        case INVALID_PASSWORD:
            result = FAIL;
            msg = INVALID_PASSWORD;
            break;

        case LOGOUT_SUCCESS:
            result = SUCCESS;
            msg = LOGOUT_SUCCESS;

        case NOT_LOGGED_IN:
            result = FAIL;
            msg = NOT_LOGGED_IN;
        }
    }
}
