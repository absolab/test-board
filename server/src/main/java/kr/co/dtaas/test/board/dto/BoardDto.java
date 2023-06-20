package kr.co.dtaas.test.board.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
@AllArgsConstructor
public class BoardDto {
    private BoardVO board;
    private ArrayList<AttachEntity> files;
}
