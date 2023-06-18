package kr.co.dtaas.test.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBoardVO {
    private int bid;
    private String title;
    private String content;
    private String crtnData;
    private String mdfdDate;
    private String name;
}
