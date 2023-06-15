package kr.co.dtaas.test.board.service;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.co.dtaas.test.board.dto.UserDto;
import kr.co.dtaas.test.board.service.impl.SessionServiceImpl;

@Service
public class SessionService implements SessionServiceImpl {

    private static final String USER = "USER";

    @Override
    public boolean setSession(HttpServletRequest req, UserDto user) {

        HttpSession session = req.getSession();

        session.setAttribute(USER, user);

        return true;
    }

    @Override
    public UserDto getSession(HttpServletRequest req) {

        HttpSession session = req.getSession();
        UserDto user = (UserDto) session.getAttribute(USER);

        return user;
    }

    @Override
    public boolean deleteSessoin(HttpServletRequest req) {

        HttpSession session = req.getSession();
        session.removeAttribute(USER);

        return true;
    }

    @Override
    public boolean isLogined(HttpServletRequest req) {

        UserDto user = getSession(req);

        return user != null;
    }
}
