package kr.co.dtaas.test.board.repository.jpa;

import java.util.ArrayList;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.co.dtaas.test.board.dto.BoardUserVO;

public interface BoardUserRepository extends JpaRepository<BoardUserVO, Long> {

    @Query("SELECT new BoardUserVO(b.bid, b.title, b.crtnDate, b.mdfdDate, u.name) FROM BoardDto b JOIN UserDto u ON b.uid = u.uid WHERE b.deleted = 0")
    ArrayList<BoardUserVO> findAllBoardWithUserName(Pageable pageable);

    @Query("SELECT new BoardUserVO(b.bid, b.title, b.content, b.crtnDate, b.mdfdDate, u.name) FROM BoardDto b JOIN UserDto u ON b.uid = u.uid WHERE b.bid=:bid AND b.deleted = 0")
    BoardUserVO findOneBoardWithUserNameByBid(@Param("bid") int bid);
}