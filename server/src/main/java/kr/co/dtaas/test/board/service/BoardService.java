package kr.co.dtaas.test.board.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardUserRepository boardUserRepository;

    @Override
    public ResponseObject boardList() {

        BoardResponseObject result;

        ArrayList<BoardUserVO> data = boardUserRepository.findAllBoardWithUserName();

        if (data != null) {
            result = new BoardResponseObject(BoardResponseObject.GET_LIST, data);
        } else {
            result = new BoardResponseObject(BoardResponseObject.GET_LIST, null);
        }

        return result;
    }

    @Override
    public ResponseObject detailBoard(int bid) {
        
        BoardResponseObject result;

        BoardUserVO data = boardUserRepository.findOneBoardWithUserNameByBid(bid);

        if (data == null) {
            result = null;
        } else {
            result = new BoardResponseObject(BoardResponseObject.WRITE_SUCCESS, data);
        }

        return result;
    }

    @Override
    public ResponseObject writeBoard(BoardDto board) {

        BoardResponseObject result;

        int data = boardRepository.insertBoard(board.getUid(), board.getTitle(), board.getContent());

        if (data == 1) {
            result = new BoardResponseObject(BoardResponseObject.WRITE_SUCCESS, data);
        } else {
            result = null;
        }

        return result;
    }

    @Override
    public ResponseObject editBoard(BoardDto board) {

        BoardResponseObject result;

        int data = boardRepository.updateBoard(board.getBid(), board.getUid(), board.getTitle(), board.getContent(), LocalDateTime.now());

        if (data == 1) {
            result = new BoardResponseObject(BoardResponseObject.WRITE_SUCCESS, data);
        } else {
            result = null;
        }

        return result;
    }

    @Override
    public ResponseObject deleteBoard(BoardDto board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBoard'");
    }
}
