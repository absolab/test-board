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

    private static String getResult(int code) { return code < 2000 ?  SUCCESS : FAIL; }

    public LoginResponseObject(int code, UserDto user) {
        super(getResult(code), code, user);
        validateRequiredFields(code, user);
    }

    public LoginResponseObject(int code) {
        super(getResult(code), code, null);
        validateRequiredFields(code, null);
    }

    // 데이터가 있어야 하는 경우
    private void validateRequiredFields(int code, UserDto user) {
        if (code == LOGIN_SUCCESS && user == null) {
            throw new IllegalArgumentException("User객체를 넣어줘야 합니다.");
        }
    }
}
