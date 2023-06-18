package kr.co.dtaas.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.dtaas.test.board.dto.BoardDto;
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

    @PostMapping("/board/write")
    public ResponseObject boardWrite(HttpServletRequest req, BoardDto boardDto) {

        ResponseObject result;

        Object data = req.getSession().getAttribute("login");
        if (data != null) {

            // TODO: 보안적인 문제를 고민해보자?

            result = boardService.writeBoard(boardDto);

        } else {

            result = new LoginResponseObject(LoginResponseObject.NOT_LOGGED_IN, null);

        }

        return result;
    }
}
