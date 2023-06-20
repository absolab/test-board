package kr.co.dtaas.test.board.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import kr.co.dtaas.test.board.dto.AttachEntity;
import kr.co.dtaas.test.board.repository.jpa.AttachRepository;
import kr.co.dtaas.test.board.service.impl.AttachServiceImpl;

@Service
public class AttachService implements AttachServiceImpl {

    @Autowired
    AttachRepository attachRepository;

    public boolean saveFiles(int bid, ArrayList<MultipartFile> multipartFiles) {

        ArrayList<AttachEntity> files = new ArrayList<>();
        for (final MultipartFile item: multipartFiles) {
            if (item.isEmpty()) { continue; }
            files.add(saveFile(item));
        }

        int cnt = 0;
        for (final AttachEntity item: files) {
            cnt += attachRepository.saveFile(bid, item.getName(), item.getPath(), item.getType(), item.getSize());
        }

        return files.size() == cnt;
    }

    @Override
    public ArrayList<AttachEntity> listFiles(int bid) {

        ArrayList<AttachEntity> data = attachRepository.findAllByBidAndDeleted(bid, 0);

        return data;
    }

    @Override
    public boolean deleteFiles(ArrayList<Integer> aid) {

        boolean result;

        int cnt = 0;
        for (int item : aid) {
            cnt += attachRepository.deleteFile(item);
        }

        result = cnt == aid.size();

        return result;
    }

    public AttachEntity getFileInfo(int aid) {
        AttachEntity data = attachRepository.findOneByAid(aid);
        return data;
    }

    // Utils
    // 실제 저장
    private AttachEntity saveFile(MultipartFile file) {

        String name = file.getOriginalFilename();
        String path = generateHashName(name);   // String path = 새로운 이름 + 확장자
        String uploadPath = "C:/Dev/uploads/" + path;
        File uploadFile = new File(uploadPath);

        try {
            file.transferTo(uploadFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        AttachEntity result = new AttachEntity();
        result.setName(name);
        result.setPath(uploadPath);
        result.setSize((int) file.getSize());       // 문제 소지 有
        result.setType(file.getContentType());

        return result;
    }

    // 새로운 파일명
    private String generateHashName(String name) {
        String newFileName = StringUtils.getFilename(name) + "_" + (LocalDateTime.now()).format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String hashName = DigestUtils.md5DigestAsHex(newFileName.getBytes());
        String extension = StringUtils.getFilenameExtension(name);
        return hashName + "." + extension;
    }

}
