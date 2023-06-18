package kr.co.dtaas.test.board.repository.jpa;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import kr.co.dtaas.test.board.dto.BoardUserVO;

public interface BoardUserRepository extends JpaRepository<BoardUserVO, Long> {

    @Query("SELECT new BoardUserVO(b.bid, b.title, b.content, b.crtnDate, b.mdfdDate, u.name) FROM BoardDto b JOIN UserDto u ON b.uid = u.uid WHERE b.deleted = 0")
    ArrayList<BoardUserVO> findAllBoardWithUserName();
}