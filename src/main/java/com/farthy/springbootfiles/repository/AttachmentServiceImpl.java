package com.farthy.springbootfiles.repository;

import com.farthy.springbootfiles.entity.Attachment;
import com.farthy.springbootfiles.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {
    private final AttachmentRepository repository;

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")){
               throw new Exception("FileName contains invalid path sequence" + fileName);
            }
            Attachment attachment
                    = new Attachment(fileName,
                    file.getContentType(),
                    file.getBytes());
            return repository.save(attachment);
        }catch (Exception e){
            throw new Exception("Could not save file: " + fileName);

        }

    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {

        return repository
                .findById(fileId)
                .orElseThrow(()->new Exception("File not Found with Id:" + fileId));
    }
}
