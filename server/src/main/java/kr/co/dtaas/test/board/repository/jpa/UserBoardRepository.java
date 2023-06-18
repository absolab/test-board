// package kr.co.dtaas.test.board.repository.jpa;

// import java.util.ArrayList;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

// import kr.co.dtaas.test.board.dto.UserBoardDto;

// public interface UserBoardRepository extends JpaRepository<UserBoardDto, Long> {

//     // @Query("SELECT b.bid, b.title, b.content, b.crtn_date, b.mdfd_date, u.name FROM UserBoardDto b INNER JOIN b.userDto u WHERE b.deleted = 0")
//     @Query("SELECT b FROM UserBoardDto b")  // 진짜 진짜 최후의 수단
//     ArrayList<UserBoardDto> findAllBoardsWithUser();
// }