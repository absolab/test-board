package kr.co.dtaas.test.board.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="TB_BOARD")
public class BoardDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid;
    private int uid;
    private String title;
    private String content;
    private int deleted;
    private String crtnDate;
    private String mdfdDate;
}