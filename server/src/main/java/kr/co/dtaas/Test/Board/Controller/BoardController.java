package kr.co.dtaas.Test.Board.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    
    @GetMapping("/")
    public String hello() {
        return "hello world";
    }
}
