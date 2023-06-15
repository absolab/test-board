package kr.co.dtaas.test.board.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.dtaas.test.board.dto.UserDto;

public interface SessionServiceImpl {
    
    public boolean setSession(HttpServletRequest req, UserDto user);

    public UserDto getSession(HttpServletRequest req);

    public boolean deleteSessoin(HttpServletRequest req);

    public boolean isLogined(HttpServletRequest req);
}
