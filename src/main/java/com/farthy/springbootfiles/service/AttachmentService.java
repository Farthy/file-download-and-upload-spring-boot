package com.farthy.springbootfiles.service;

import com.farthy.springbootfiles.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
   public Attachment saveAttachment(MultipartFile file) throws Exception;

   Attachment getAttachment(String fileId) throws Exception;
}
