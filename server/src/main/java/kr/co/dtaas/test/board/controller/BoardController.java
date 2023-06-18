package kr.co.dtaas.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import kr.co.dtaas.test.board.dto.BoardDto;
import kr.co.dtaas.test.board.dto.UserDto;
import kr.co.dtaas.test.board.responseObject.LoginResponseObject;
import kr.co.dtaas.test.board.responseObject.ResponseObject;
import kr.co.dtaas.test.board.service.BoardService;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/board/list")
    public ResponseObject boardList() {

        ResponseObject result = boardService.boardList();

        return result;
    }

    @Transactional
    @PostMapping("/board/write")
    public ResponseObject boardWrite(HttpServletRequest req, BoardDto boardDto) {

        ResponseObject result;

        Object data = req.getSession().getAttribute("login");
        if (data != null) {

            UserDto user = (UserDto) data;
            boardDto.setUid(user.getUid());
            result = boardService.writeBoard(boardDto);

        } else {
            result = new LoginResponseObject(LoginResponseObject.NOT_LOGGED_IN, null);
        }

        return result;
    }

    @Transactional
    @PostMapping("/board/edit")
    public ResponseObject boardEdit(HttpServletRequest req, BoardDto boardDto) {

        ResponseObject result;

        Object data = req.getSession().getAttribute("login");

        if (data == null) {
            result = new LoginResponseObject(LoginResponseObject.NOT_LOGGED_IN, null);
        } else {
            UserDto user = (UserDto) data;
            boardDto.setUid(user.getUid());
            result = boardService.editBoard(boardDto);
        }

        return result;
    }
}
