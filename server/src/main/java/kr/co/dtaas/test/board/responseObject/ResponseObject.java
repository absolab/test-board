package kr.co.dtaas.test.board.responseObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)  // NULL값은 빼고 보낸다
public abstract class ResponseObject {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL    = "FAIL";

    private final String result;
    private final int msg;
    private final Object data;

    protected static String getResult(int code) { return code < 2000 ?  SUCCESS : FAIL; }
}
