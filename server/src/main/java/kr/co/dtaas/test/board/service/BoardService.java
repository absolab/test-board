package kr.co.dtaas.test.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.inject.Inject;
import kr.co.dtaas.test.board.dto.BoardDto;
import kr.co.dtaas.test.board.dto.UserBoardDto;
import kr.co.dtaas.test.board.dto.UserBoardVO;
import kr.co.dtaas.test.board.repository.jpa.BoardRepository;
// import kr.co.dtaas.test.board.repository.jpa.UserBoardRepository;
import kr.co.dtaas.test.board.repository.mapper.UserBoardMapper;
import kr.co.dtaas.test.board.responseObject.BoardResponseObject;
import kr.co.dtaas.test.board.responseObject.ResponseObject;
import kr.co.dtaas.test.board.service.impl.BoardServiceImpl;

@Service
public class BoardService implements BoardServiceImpl {

    // @Autowired
    // UserBoardRepository userBoardRepository;

    @Autowired
    UserBoardMapper userBoardMapper;

    @Override
    public ResponseObject boardList() {

        BoardResponseObject result;

        // ArrayList<NameBoardDto> data = userBoardRepository.findAllBoardsWithUser();
        // System.out.println(data);

        // ArrayList<UserBoardDto> data = userBoardRepository.findAllBoardsWithUser();
        ArrayList<UserBoardVO> data = userBoardMapper.findAll();

        if (data != null) {
            result = new BoardResponseObject(BoardResponseObject.GET_LIST, data);
        } else {
            result = new BoardResponseObject(BoardResponseObject.GET_LIST, null);
        }

        return result;
    }

    @Override
    public ResponseObject writeBoard(BoardDto board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeBoard'");
    }

    @Override
    public ResponseObject editBoard(BoardDto board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editBoard'");
    }

    @Override
    public ResponseObject deleteBoard(BoardDto board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBoard'");
    }
    
}
