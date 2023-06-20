package kr.co.dtaas.test.board.responseObject;

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

    public BoardResponseObject(int code, Object board) {
        super(getResult(code), code, board);
        validateRequiredFields(code, board);
    }

    public BoardResponseObject(int code) {
        super(getResult(code), code, null);
    }

    // 데이터가 있어야 하는 경우
    private void validateRequiredFields(int code, Object data) {
        if (code == LIST_SUCCESS && data == null) {
            throw new IllegalArgumentException("게시글 데이터가 필요 합니다");
        }
    }
}
