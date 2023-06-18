package kr.co.dtaas.test.board.dto;

import java.time.LocalDateTime;

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
    private LocalDateTime crtnDate;
    private LocalDateTime mdfdDate;
    private String name;
}
