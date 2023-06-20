package kr.co.dtaas.test.board.service.impl;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import kr.co.dtaas.test.board.responseObject.ResponseObject;

public interface AttachServiceImpl {

    public ResponseObject saveFiles(int bid, ArrayList<MultipartFile> multipartFiles);

    public ResponseObject listFiles(int bid);

    public ResponseObject deleteFiles(ArrayList<Integer> aid);
}
