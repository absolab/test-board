package kr.co.dtaas.test.board.repository.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.dtaas.test.board.dto.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

    UserEntity findOneByIdAndPwd(String id, String pwd);
}
