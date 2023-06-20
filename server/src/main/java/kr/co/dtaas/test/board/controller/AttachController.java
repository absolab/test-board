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
import kr.co.dtaas.test.board.dto.AttachEntity;
import kr.co.dtaas.test.board.responseObject.AttachResponseObject;
import kr.co.dtaas.test.board.responseObject.ResponseObject;
import kr.co.dtaas.test.board.service.AttachService;

@Transactional
@RestController
public class AttachController {

    @Autowired
    AttachService attachService;

    // DEV
    @PutMapping("/upload/file")
    public ResponseObject uploadFile(HttpServletRequest req, int bid, ArrayList<MultipartFile> files) {

        ResponseObject response;

        boolean data = attachService.saveFiles(bid, files);

        if(data) {
            response = new AttachResponseObject(AttachResponseObject.UPLOAD_SUCCESS);
        } else {
            response = new AttachResponseObject(AttachResponseObject.UPLOAD_FAIL);
        }

        return response;
    }

    // DEV
    @GetMapping("/upload/list/{bid}")
    public ResponseObject listFile(@PathVariable("bid") int bid) {

        ResponseObject response;

        ArrayList<AttachEntity> data = attachService.listFiles(bid);

        if (data == null || data.isEmpty()) {
            response = new AttachResponseObject(AttachResponseObject.GET_LIST_SUCCESS, data);
        } else {
            response = new AttachResponseObject(AttachResponseObject.GET_LIST_FAIL);
        }

        return response;
    }
}