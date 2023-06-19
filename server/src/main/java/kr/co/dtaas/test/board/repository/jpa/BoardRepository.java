package kr.co.dtaas.test.board.repository.jpa;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.co.dtaas.test.board.dto.BoardDto;

public interface BoardRepository extends JpaRepository<BoardDto, Long> {

    int countByDeleted(int deleted);

    @Modifying
    @Query("insert into BoardDto(uid, title, content) VALUES (:uid, :title, :content)")
    int insertBoard(@Param("uid") int uid, @Param("title") String title, @Param("content") String content);

    @Modifying
    @Query("update BoardDto b set b.title=:title, b.content=:content, b.mdfdDate=:mdfdDate where b.bid=:bid and b.uid=:uid")
    int updateBoard(@Param("bid") int bid, @Param("uid") int uid, @Param("title") String title, @Param("content") String content, @Param("mdfdDate") LocalDateTime mdfdDate);
}
