package kr.co.dtaas.test.board.repository.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.dtaas.test.board.dto.UserBoardVO;

@Mapper
public interface UserBoardMapper {

    ArrayList<UserBoardVO> findAll();
}
