package kr.co.dtaas.test.board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import kr.co.dtaas.test.board.dto.AttachEntity;
import kr.co.dtaas.test.board.dto.BoardDto;
import kr.co.dtaas.test.board.dto.BoardEntity;
import kr.co.dtaas.test.board.dto.BoardVO;
import kr.co.dtaas.test.board.dto.UserEntity;
import kr.co.dtaas.test.board.responseObject.BoardResponseObject;
import kr.co.dtaas.test.board.responseObject.ResponseObject;
import kr.co.dtaas.test.board.service.AttachService;
import kr.co.dtaas.test.board.service.BoardService;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    AttachService attachService;

    @GetMapping("/board/list")
    public ResponseObject boardList(int pageNumber) {

        ResponseObject response;
        ArrayList<BoardVO> data = boardService.boardList(pageNumber);

        if (data == null || data.isEmpty()) {
            response = new BoardResponseObject(BoardResponseObject.SEARCH_FAIL);
        } else {
            response = new BoardResponseObject(BoardResponseObject.LIST_SUCCESS, data);
        }

        return response;
    }

    @GetMapping("/board/page")
    public ResponseObject totalPage() {

        ResponseObject response;

        int data = boardService.totalPageCount();

        response = new BoardResponseObject(BoardResponseObject.PAGE_SUCCESS, data);

        return response;
    }

    @GetMapping("/board/detail/{bid}")
    public ResponseObject boardDetail(@PathVariable("bid") int bid) {

        ResponseObject response;
        BoardVO data = boardService.detailBoard(bid);
        ArrayList<AttachEntity> fileData = attachService.listFiles(bid);

        BoardDto totalData = new BoardDto(data, fileData);

        if (data == null) {
            response = new BoardResponseObject(BoardResponseObject.SEARCH_FAIL);
        } else {
            response = new BoardResponseObject(BoardResponseObject.ONE_SUCCESS, totalData);
        }

        return response;
    }

    @Transactional
    @PostMapping("/board/write")
    public ResponseObject boardWrite(HttpServletRequest req, BoardEntity board) {

        ResponseObject response;

        Object userObject = req.getSession().getAttribute("login");
        if (userObject != null) {

            UserEntity user = (UserEntity) userObject;
            board.setUid(user.getUid());

            boolean data = boardService.writeBoard(board);

            if (data) {
                response = new BoardResponseObject(BoardResponseObject.WRITE_SUCCESS);
            } else {
                response = new BoardResponseObject(BoardResponseObject.IS_NOT_LOGGEN_IN);
            }
        } else {
            response = new BoardResponseObject(BoardResponseObject.IS_NOT_LOGGEN_IN);
        }

        return response;
    }

    @Transactional
    @PostMapping("/board/edit")
    public ResponseObject boardEdit(HttpServletRequest req, BoardEntity board) {

        ResponseObject response;

        Object userObject = req.getSession().getAttribute("login");

        if (userObject == null) {
            response = new BoardResponseObject(BoardResponseObject.IS_NOT_LOGGEN_IN);
        } else {
            UserEntity user = (UserEntity) userObject;
            board.setUid(user.getUid());
            boolean data = boardService.editBoard(board);

            if (data) {
                response = new BoardResponseObject(BoardResponseObject.EDIT_SUCCESS);
            } else {
                response = new BoardResponseObject(BoardResponseObject.IS_NOT_LOGGEN_IN);
            }
        }

        return response;
    }

    @Transactional
    @PostMapping("/board/delete")
    public ResponseObject boardDelete(HttpServletRequest req, BoardEntity board) {

        ResponseObject response;

         Object userObject = req.getSession().getAttribute("login");

        if (userObject == null) {
            response = new BoardResponseObject(BoardResponseObject.IS_NOT_LOGGEN_IN);
        } else {
            UserEntity user = (UserEntity) userObject;
            board.setUid(user.getUid());
            boolean data = boardService.deleteBoard(board);

            if (data) {
                response = new BoardResponseObject(BoardResponseObject.DELETE_SUCCESS);
            } else {
                response = new BoardResponseObject(BoardResponseObject.IS_NOT_LOGGEN_IN);
            }
        }

        return response;
    }
}
