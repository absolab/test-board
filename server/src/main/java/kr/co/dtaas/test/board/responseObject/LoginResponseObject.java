package kr.co.dtaas.test.board.responseObject;

public class LoginResponseObject extends ResponseObject {

    public void success() {
        result = SUCCESS;
    }

    public void fail() {
        result = FAIL;
    }
}
