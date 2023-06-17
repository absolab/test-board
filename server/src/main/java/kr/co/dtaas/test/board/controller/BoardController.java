package kr.co.dtaas.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
