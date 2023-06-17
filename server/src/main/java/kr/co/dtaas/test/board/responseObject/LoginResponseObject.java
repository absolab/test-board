package kr.co.dtaas.test.board.responseObject;

import kr.co.dtaas.test.board.dto.UserDto;

public class LoginResponseObject extends ResponseObject {

    // SUCCESS
    public static final int LOGIN_SUCCESS      = 1000;  // login
    public static final int LOGOUT_SUCCESS     = 1001;  // logout
    public static final int IS_LOGGED_IN       = 1002;  // check login

    // FAIL
    public static final int ALREADY_LOGGED_IN  = 2001;  // login
    public static final int INVALID_PASSWORD   = 2002;  // login
    public static final int NOT_LOGGED_IN      = 2003;  // logout
    public static final int IS_NOT_LOGGED_IN   = 2004;  // check login

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
