package kr.co.dtaas.test.board.repository.jpa;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.co.dtaas.test.board.dto.BoardDto;

public interface BoardRepository extends JpaRepository<BoardDto, Long> {

    // 게시글 수
    int countByDeleted(int deleted);

    // 게시글 삭제
    @Modifying
    @Query("UPDATE BoardDto b SET b.deleted=1 WHERE b.bid=:bid AND b.uid=:uid")
    int dedeleteByBidAndUid(@Param("bid") int bid, @Param("uid") int uid);

    // 글 작성
    @Modifying
    @Query("insert into BoardDto(uid, title, content) VALUES (:uid, :title, :content)")
    int insertBoard(@Param("uid") int uid, @Param("title") String title, @Param("content") String content);

    // 직접 접근했을 때 deleted값이 1인 애들은 수정을 못하게 해야하지 않으려나
    @Modifying
    @Query("update BoardDto b set b.title=:title, b.content=:content, b.mdfdDate=:mdfdDate where b.bid=:bid and b.uid=:uid")
    int updateBoard(@Param("bid") int bid, @Param("uid") int uid, @Param("title") String title, @Param("content") String content, @Param("mdfdDate") LocalDateTime mdfdDate);
}
