package kr.co.dtaas.test.board.responseObject;

public class BoardResponseObject extends ResponseObject {
    
    // SUCCESS
    public static final int GET_LIST = 1100;
    public static final int WRITE_SUCCESS = 1101;

    // FAIL
    public static final int IS_NOT_LOGGEN_IN = 2101;

    public BoardResponseObject(int code, Object item) {
        result = SUCCESS;
        msg = code;
        data = item;
    }
}
