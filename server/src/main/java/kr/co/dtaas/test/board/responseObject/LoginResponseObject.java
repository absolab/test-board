package kr.co.dtaas.test.board.responseObject;

import kr.co.dtaas.test.board.dto.UserDto;

public class LoginResponseObject extends ResponseObject {

    // Login
    public static final int LOGIN_SUCCESS    = 1000;
    public static final int ALREADY_LOGGED_IN  = 1001;
    public static final int INVALID_PASSWORD = 1002;

    // Logout
    public static final int LOGOUT_SUCCESS   = 2000;
    public static final int NOT_LOGGED_IN    = 2001;

    // IsLogined
    public static final int IS_LOGGED_IN     = 3000;
    public static final int IS_NOT_LOGGED_IN = 3001;


    public LoginResponseObject(int code, UserDto user) {

        switch(code) {
        case LOGIN_SUCCESS:
            result = SUCCESS;
            msg = LOGIN_SUCCESS;
            data = user;
            break;

        case ALREADY_LOGGED_IN:
            result = FAIL;
            msg = ALREADY_LOGGED_IN;
            break;

        case INVALID_PASSWORD:
            result = FAIL;
            msg = INVALID_PASSWORD;
            break;

        case LOGOUT_SUCCESS:
            result = SUCCESS;
            msg = LOGOUT_SUCCESS;
            break;

        case NOT_LOGGED_IN:
            result = FAIL;
            msg = NOT_LOGGED_IN;
            break;

        case IS_LOGGED_IN:
            result = SUCCESS;
            msg = IS_LOGGED_IN;
            break;

        case IS_NOT_LOGGED_IN:
            result = FAIL;
            msg = IS_NOT_LOGGED_IN;
            break;
        }
    }
}
