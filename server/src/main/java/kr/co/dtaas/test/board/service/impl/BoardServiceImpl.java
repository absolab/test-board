package kr.co.dtaas.test.board.service.impl;

import kr.co.dtaas.test.board.dto.BoardDto;
import kr.co.dtaas.test.board.responseObject.ResponseObject;

public interface BoardServiceImpl {

    public ResponseObject boardList(int pageNumber);

    public ResponseObject detailBoard(int bid);

    public ResponseObject writeBoard(BoardDto board);

    public ResponseObject editBoard(BoardDto board);

    public ResponseObject deleteBoard(BoardDto board);
}
