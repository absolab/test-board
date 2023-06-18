package kr.co.dtaas.test.board.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
    @Column(insertable = true, updatable = false)
    private int uid;
    private String title;
    private String content;
    private int deleted;
    @Column(insertable = true, updatable = false)
    private LocalDateTime crtnDate;
    private LocalDateTime mdfdDate;

    @PrePersist
    public void prePersist() {
        crtnDate = LocalDateTime.now();
        mdfdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        mdfdDate = LocalDateTime.now();
    }
}
