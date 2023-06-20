package kr.co.dtaas.test.board.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="TB_ATTACH")
public class AttachDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private int bid;
    private String name;
    @JsonIgnore
    private String path;
    private String type;
    private int size;
    @JsonIgnore
    private int deleted;
    @JsonIgnore
    private LocalDateTime crtnDate;
}