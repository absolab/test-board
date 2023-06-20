package kr.co.dtaas.test.board.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Entity
@AllArgsConstructor
public class BoardVO {
    @Id
    private int bid;
    private String title;
    private String content;
    private LocalDateTime crtnDate;
    private LocalDateTime mdfdDate;
    private String name;

    // content가 빠진 생성자 (list용)
    public BoardVO(int bid, String title, LocalDateTime crtnDate, LocalDateTime mdfdDate, String name) {
        this.bid = bid;
        this.title = title;
        this.crtnDate = crtnDate;
        this.mdfdDate = mdfdDate;
        this.name = name;
    }
}
