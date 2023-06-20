package kr.co.dtaas.test.board.repository.jpa;

import java.util.ArrayList;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.co.dtaas.test.board.dto.BoardVO;

public interface BoardWithUserRepository extends JpaRepository<BoardVO, Long> {

    // 글 한개
    @Query("SELECT new BoardVO(b.bid, b.title, b.content, b.crtnDate, b.mdfdDate, u.name) FROM BoardEntity b JOIN UserEntity u ON b.uid = u.uid WHERE b.bid=:bid AND b.deleted = 0")
    BoardVO findOneBoardWithUserNameByBid(@Param("bid") int bid);

    // 글 목록
    @Query("SELECT new BoardVO(b.bid, b.title, b.crtnDate, b.mdfdDate, u.name) FROM BoardEntity b JOIN UserEntity u ON b.uid = u.uid WHERE b.deleted = 0")
    ArrayList<BoardVO> findAllBoardWithUserName(Pageable pageable);
}