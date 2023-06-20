package kr.co.dtaas.test.board.responseObject;

import java.util.ArrayList;

import kr.co.dtaas.test.board.dto.BoardVO;

public class BoardResponseObject extends ResponseObject {

    // SUCCESS
    public static final int LIST_SUCCESS     = 1100;    // 리스트 가져오기
    public static final int WRITE_SUCCESS    = 1101;    // 글 작성
    public static final int EDIT_SUCCESS     = 1102;    // 글 수정
    public static final int DELETE_SUCCESS   = 1103;    // 글 삭제
    public static final int ONE_SUCCESS      = 1104;    // 글 1개 가져오기
    public static final int PAGE_SUCCESS     = 1105;    // 총 페이지 수

    // FAIL
    public static final int IS_NOT_LOGGEN_IN = 2101;
    public static final int SEARCH_FAIL      = 2102;    // 검색 값 없음

    public BoardResponseObject(int code, BoardVO board) {
        super(getResult(code), code, board);
        validateRequiredFields(code, board);
    }

    public BoardResponseObject(int code, ArrayList<BoardVO> list) {
        super(getResult(code), code, list);
        validateRequiredFields(code, list);
    }

    public BoardResponseObject(int code, Integer page) {
        super(getResult(code), code, page);
        validateRequiredFields(code, page);
    }

    public BoardResponseObject(Integer code) {
        super(getResult(code), code, null);
    }

    // 데이터가 있어야 하는 경우
    private void validateRequiredFields(int code, ArrayList<BoardVO> list) {
        if (code == LIST_SUCCESS && list == null) {
            throw new IllegalArgumentException("게시글 데이터가 필요 합니다");
        }
    }
    private void validateRequiredFields(int code, BoardVO board) {
        if (code == LIST_SUCCESS && board == null) {
            throw new IllegalArgumentException("게시글 데이터가 필요 합니다");
        }
    }
    private void validateRequiredFields(int code, Integer page) {
        if (code == LIST_SUCCESS && page == null) {
            throw new IllegalArgumentException("게시글 데이터가 필요 합니다");
        }
    }
}
