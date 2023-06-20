package kr.co.dtaas.test.board.service.impl;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import kr.co.dtaas.test.board.dto.AttachEntity;

public interface AttachServiceImpl {

    public boolean saveFiles(int bid, ArrayList<MultipartFile> multipartFiles);

    public ArrayList<AttachEntity> listFiles(int bid);

    public boolean deleteFiles(ArrayList<Integer> aid);
}
