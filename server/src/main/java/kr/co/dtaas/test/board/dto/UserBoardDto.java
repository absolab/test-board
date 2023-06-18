package kr.co.dtaas.test.board.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="TB_BOARD")
public class UserBoardDto {

    @Id
    private int bid;

    private String title;
    private String content;
    private String crtnDate;
    private String mdfdDate;

    @ManyToOne
    @JoinColumn(name="uid")
    private UserDto userDto;
}
