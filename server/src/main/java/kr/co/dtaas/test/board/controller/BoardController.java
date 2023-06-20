package kr.co.dtaas.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import kr.co.dtaas.test.board.dto.BoardEntity;
import kr.co.dtaas.test.board.dto.UserEntity;
import kr.co.dtaas.test.board.responseObject.LoginResponseObject;
import kr.co.dtaas.test.board.responseObject.ResponseObject;
import kr.co.dtaas.test.board.service.BoardService;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/board/list")
    public ResponseObject boardList(int pageNumber) {

        ResponseObject result = boardService.boardList(pageNumber);

        return result;
    }

    @GetMapping("/board/page")
    public ResponseObject totalPage() {

        ResponseObject result = boardService.totalPageCount();

        return result;
    }

    @GetMapping("/board/detail/{bid}")
    public ResponseObject boardDetail(@PathVariable("bid") int bid) {

        ResponseObject result = boardService.detailBoard(bid);
        return result;
    }

    @Transactional
    @PostMapping("/board/write")
    public ResponseObject boardWrite(HttpServletRequest req, BoardEntity board) {

        ResponseObject result;

        Object data = req.getSession().getAttribute("login");
        if (data != null) {

            UserEntity user = (UserEntity) data;
            board.setUid(user.getUid());
            result = boardService.writeBoard(board);

        } else {
            result = new LoginResponseObject(LoginResponseObject.NOT_LOGGED_IN);
        }

        return result;
    }

    @Transactional
    @PostMapping("/board/edit")
    public ResponseObject boardEdit(HttpServletRequest req, BoardEntity board) {

        ResponseObject result;

        Object data = req.getSession().getAttribute("login");

        if (data == null) {
            result = new LoginResponseObject(LoginResponseObject.NOT_LOGGED_IN);
        } else {
            UserEntity user = (UserEntity) data;
            board.setUid(user.getUid());
            result = boardService.editBoard(board);
        }

        return result;
    }

    @Transactional
    @PostMapping("/board/delete")
    public ResponseObject boardDelete(HttpServletRequest req, BoardEntity board) {

        ResponseObject result;

        Object data = req.getSession().getAttribute("login");

        if (data == null) {
            result = new LoginResponseObject(LoginResponseObject.NOT_LOGGED_IN);
        } else {
            UserEntity user = (UserEntity) data;
            board.setUid(user.getUid());
            result = boardService.deleteBoard(board);
        }

        return result;
    }
}
