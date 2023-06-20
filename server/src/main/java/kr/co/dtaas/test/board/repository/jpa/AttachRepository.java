package kr.co.dtaas.test.board.repository.jpa;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.co.dtaas.test.board.dto.AttachEntity;

public interface AttachRepository extends JpaRepository<AttachEntity, Long> {

    // 파일 저장
    @Modifying
    @Query("INSERT INTO AttachEntity(bid, name, path, type, size) VALUES(:bid, :name, :path, :type, :size)")
    int saveFile(@Param("bid")int bid, @Param("name")String name, @Param("path")String path, @Param("type")String type, @Param("size")int size);

    // 파일 제거
    @Modifying
    @Query("Update AttachEntity a SET a.deleted=1 WHERE aid=:aid")
    int deleteFile(@Param("aid")int aid);

    // 파일 목록
    ArrayList<AttachEntity> findAllByBidAndDeleted(int bid, int deleted);

    // 파일 정보
    AttachEntity findOneByAid(int aid);
}
