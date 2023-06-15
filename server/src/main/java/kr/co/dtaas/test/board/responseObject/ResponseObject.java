package kr.co.dtaas.test.board.responseObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public abstract class ResponseObject {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL    = "FAIL";

    String result;
    String msg;
    Object data;
}
