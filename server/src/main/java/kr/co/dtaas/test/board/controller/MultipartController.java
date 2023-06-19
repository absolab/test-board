import org.springframework.web.bind.annotation.PutMapping;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.dtaas.test.board.dto.AttachDto;
import kr.co.dtaas.test.board.responseObject.ResponseObject;

public class MultipartController {

    @PutMapping("/uploadFiles")
    public ResponseObject uploadFile(HttpServletRequest req, MultipartController[] multipartControllers, AttachDto attachDto) {

        ResponseObject result;

        

        return result;
    }
}