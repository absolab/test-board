package kr.co.dtaas.test.board.responseObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
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
