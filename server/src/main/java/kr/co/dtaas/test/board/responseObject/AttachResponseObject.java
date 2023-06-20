package kr.co.dtaas.test.board.responseObject;

public class AttachResponseObject extends ResponseObject {
    
    // SUCCESS
    public static final int UPLOAD_SUCCESS   = 1200;
    public static final int DELETE_SUCCESS   = 1201;
    public static final int GET_LIST_SUCCESS = 1203;

    // FAIL
    public static final int UPLOAD_FAIL      = 2200;
    public static final int DELETE_FAIL      = 2201;
    public static final int GET_LIST_FAIL    = 2202;    // 파일 없음

    public AttachResponseObject(int code, Object item) {
        super(getResult(code), code, item);
    }

    public AttachResponseObject(int code) {
        super(getResult(code), code, null);
    }
}
