package kr.co.dtaas.test.board.repository.jpa;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.co.dtaas.test.board.dto.AttachDto;

public interface AttachRepository extends JpaRepository<AttachDto, Long> {

    // 파일 저장
    @Modifying
    @Query("INSERT INTO AttachDto(bid, name, path, type, size) VALUES(:bid, :name, :path, :type, :size)")
    int saveFile(@Param("bid")int bid, @Param("name")String name, @Param("path")String path, @Param("type")String type, @Param("size")int size);

    // 파일 제거
    @Modifying
    @Query("Update AttachDto a SET a.deleted=1 WHERE aid=:aid")
    int deleteFile(@Param("aid")int aid);

    // 파일 목록
    ArrayList<AttachDto> findAllByBid(int bid);
}
