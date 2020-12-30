package com.titowecz.appList.services;

import com.titowecz.appList.dto.DocumentDTO;
import com.titowecz.appList.models.Document;
import com.titowecz.appList.models.User;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DocumentService {
  List<DocumentDTO> getAll();

  List<DocumentDTO> getAllByDescription(String description);

  void addNewDoucment(DocumentDTO documentDTO, User user);

  void updateDoucment(Long id, DocumentDTO documentDTO);

  void deleteDoucmentById(Long id, String username) throws IOException;

  Resource loadFileAsResource(String fileName);

  String storeFile(MultipartFile file);

  Document findById(Long id);
}
