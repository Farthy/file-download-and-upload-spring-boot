package com.farthy.springbootfiles.repository;

import com.farthy.springbootfiles.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,String > {
}
