package kr.co.dtaas.test.board.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class BoardUserVO {
    @Id
    private int bid;
    private String title;
    private String content;
    private String crtnDate;
    private String mdfdDate;
    private String name;
}
