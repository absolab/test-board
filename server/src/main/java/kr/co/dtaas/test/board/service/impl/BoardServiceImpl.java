package kr.co.dtaas.test.board.service.impl;

import kr.co.dtaas.test.board.dto.BoardEntity;
import kr.co.dtaas.test.board.responseObject.ResponseObject;

public interface BoardServiceImpl {

    public ResponseObject boardList(int pageNumber);

    public ResponseObject detailBoard(int bid);

    public ResponseObject totalPageCount();

    public ResponseObject writeBoard(BoardEntity board);

    public ResponseObject editBoard(BoardEntity board);

    public ResponseObject deleteBoard(BoardEntity board);
}
