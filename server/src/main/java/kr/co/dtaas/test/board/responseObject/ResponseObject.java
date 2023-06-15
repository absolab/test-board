package kr.co.dtaas.test.board.responseObject;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class ResponseObject {

    @Getter
    String result;
    @Getter
    String msg;
    @Getter
    Object data;

    final String SUCCESS = "SUCCESS";
    final String FAIL    = "FAIL";
}
