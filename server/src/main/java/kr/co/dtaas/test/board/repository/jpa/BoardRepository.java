package kr.co.dtaas.test.board.repository.jpa;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.dtaas.test.board.dto.BoardDto;

public interface BoardRepository extends JpaRepository<BoardDto, Long> {
    
    ArrayList<BoardDto> findAllByDeleted(int deleted);
}
