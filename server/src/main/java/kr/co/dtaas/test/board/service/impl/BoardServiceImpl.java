package kr.co.dtaas.test.board.service.impl;

import java.util.ArrayList;

import kr.co.dtaas.test.board.dto.BoardEntity;
import kr.co.dtaas.test.board.dto.BoardVO;

public interface BoardServiceImpl {

    public ArrayList<BoardVO> boardList(int pageNumber);

    public BoardVO detailBoard(int bid);

    public int totalPageCount();

    public int writeBoard(BoardEntity board);

    public boolean editBoard(BoardEntity board);

    public boolean deleteBoard(BoardEntity board);
}
