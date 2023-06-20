package kr.co.dtaas.test.board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.dtaas.test.board.dto.AttachDto;
import kr.co.dtaas.test.board.responseObject.ResponseObject;
import kr.co.dtaas.test.board.service.AttachService;

@Transactional
@RestController
public class MultipartController {

    @Autowired
    AttachService attachService;

    // 테스트를 위한 공간
    @PutMapping("/upload/file")
    public ResponseObject uploadFile(HttpServletRequest req, int bid, ArrayList<MultipartFile> files) {

        ResponseObject result;

        result = attachService.saveFiles(bid, files);

        return result;
    }

    @GetMapping("/upload/list/{bid}")
    public ResponseObject listFile(@PathVariable("bid") int bid) {

        ResponseObject result;

        result = attachService.listFiles(bid);

        return result;
    }
}