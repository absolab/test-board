package kr.co.dtaas.test.board.service.impl;

import kr.co.dtaas.test.board.dto.BoardDto;
import kr.co.dtaas.test.board.responseObject.ResponseObject;

public interface BoardServiceImpl {

    public ResponseObject boardList();

    public ResponseObject writeBoard(BoardDto board);

    public ResponseObject deleteBoard(BoardDto board);
}
