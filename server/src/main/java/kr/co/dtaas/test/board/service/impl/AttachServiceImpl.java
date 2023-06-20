package kr.co.dtaas.test.board.service.impl;

import java.util.ArrayList;

import kr.co.dtaas.test.board.dto.AttachDto;
import kr.co.dtaas.test.board.responseObject.ResponseObject;

public interface AttachServiceImpl {

    public ResponseObject saveFilesInfo(int bid, ArrayList<AttachDto> files);

    public ResponseObject listFiles(int bid);

    public ResponseObject deleteFiles(int bid, int aid);
}
