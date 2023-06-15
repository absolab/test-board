package kr.co.dtaas.test.board.repository.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.dtaas.test.board.dto.UserDto;

public interface UserRepository extends JpaRepository<UserDto, Long>{

    UserDto findOneByUid(Long uid);
}
