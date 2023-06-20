package kr.co.dtaas.test.board.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kr.co.dtaas.test.board.dto.BoardDto;
import kr.co.dtaas.test.board.dto.BoardUserVO;
import kr.co.dtaas.test.board.repository.jpa.BoardRepository;
import kr.co.dtaas.test.board.repository.jpa.BoardUserRepository;
import kr.co.dtaas.test.board.responseObject.BoardResponseObject;
import kr.co.dtaas.test.board.responseObject.ResponseObject;
import kr.co.dtaas.test.board.service.impl.BoardServiceImpl;

@Service
public class BoardService implements BoardServiceImpl {

    private final static int PAGE_SIZE = 10;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardUserRepository boardUserRepository;

    @Override
    public ResponseObject boardList(int pageNumber) {
        BoardResponseObject result;

        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by("bid").descending());

        ArrayList<BoardUserVO> data = boardUserRepository.findAllBoardWithUserName(pageable);

        if (data != null) {
            result = new BoardResponseObject(BoardResponseObject.LIST_SUCCESS, data);
        } else {
            result = new BoardResponseObject(BoardResponseObject.SEARCH_FAIL);
        }

        return result;
    }

    @Override
    public ResponseObject detailBoard(int bid) {

        BoardResponseObject result;

        BoardUserVO data = boardUserRepository.findOneBoardWithUserNameByBid(bid);

        if (data == null) {
            result = new BoardResponseObject(BoardResponseObject.SEARCH_FAIL);
        } else {
            result = new BoardResponseObject(BoardResponseObject.ONE_SUCCESS, data);
        }

        return result;
    }

    @Override
    public ResponseObject totalPageCount() {
        int data = boardRepository.countByDeleted(0);

        return new BoardResponseObject(BoardResponseObject.PAGE_SUCCESS, data / PAGE_SIZE + 1);
    }

    @Override
    public ResponseObject writeBoard(BoardDto board) {

        BoardResponseObject result;

        int data = boardRepository.insertBoard(board.getUid(), board.getTitle(), board.getContent());

        if (data == 1) {
            result = new BoardResponseObject(BoardResponseObject.WRITE_SUCCESS);
        } else {
            result = new BoardResponseObject(BoardResponseObject.SEARCH_FAIL);

        }

        return result;
    }

    @Override
    public ResponseObject editBoard(BoardDto board) {

        BoardResponseObject result;

        int data = boardRepository.updateBoard(board.getBid(), board.getUid(), board.getTitle(), board.getContent(), LocalDateTime.now());

        if (data == 1) {
            result = new BoardResponseObject(BoardResponseObject.EDIT_SUCCESS);
        } else {
            result = new BoardResponseObject(BoardResponseObject.SEARCH_FAIL);

        }

        return result;
    }

    @Override
    public ResponseObject deleteBoard(BoardDto board) {

        BoardResponseObject result;

        int data = boardRepository.dedeleteByBidAndUid(board.getBid(), board.getUid());

        if (data == 1) {
            result = new BoardResponseObject(BoardResponseObject.DELETE_SUCCESS);
        } else {
            result = new BoardResponseObject(BoardResponseObject.SEARCH_FAIL);
        }

        return result;
    }
}
