package kr.co.dtaas.test.board.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kr.co.dtaas.test.board.dto.BoardEntity;
import kr.co.dtaas.test.board.dto.BoardVO;
import kr.co.dtaas.test.board.repository.jpa.BoardRepository;
import kr.co.dtaas.test.board.repository.jpa.BoardWithUserRepository;
import kr.co.dtaas.test.board.service.impl.BoardServiceImpl;

@Service
public class BoardService implements BoardServiceImpl {

    private final static int PAGE_SIZE = 10;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardWithUserRepository boardUserRepository;

    @Override
    public ArrayList<BoardVO> boardList(int pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by("bid").descending());

        ArrayList<BoardVO> data = boardUserRepository.findAllBoardWithUserName(pageable);

        return data;
    }

    @Override
    public BoardVO detailBoard(int bid) {

        BoardVO data = boardUserRepository.findOneBoardWithUserNameByBid(bid);

        return data;
    }

    @Override
    public int totalPageCount() {
        int data = boardRepository.countByDeleted(0);

        return data / PAGE_SIZE + 1;
    }

    @Override
    public boolean writeBoard(BoardEntity board) {

        int data = boardRepository.insertBoard(board.getUid(), board.getTitle(), board.getContent());

        return data == 1;
    }

    @Override
    public boolean editBoard(BoardEntity board) {

        int data = boardRepository.updateBoard(board.getBid(), board.getUid(), board.getTitle(), board.getContent(), LocalDateTime.now());

        return data == 1;
    }

    @Override
    public boolean deleteBoard(BoardEntity board) {

        int data = boardRepository.dedeleteByBidAndUid(board.getBid(), board.getUid());

        return data == 1;
    }
}
