package com.titowecz.appList.services.impl;

import com.titowecz.appList.Repository.DocumentRepository;
import com.titowecz.appList.Repository.MarkRepository;
import com.titowecz.appList.Repository.UserRepository;
import com.titowecz.appList.dto.MarkDTO;
import com.titowecz.appList.models.Mark;
import com.titowecz.appList.models.TypeMark;
import com.titowecz.appList.services.MarkService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class MarkServiceImpl implements MarkService {
  private final MarkRepository markRepository;
  private final UserRepository userRepository;
  private final DocumentRepository documentRepository;

  public MarkServiceImpl(MarkRepository markRepository, DocumentRepository documentService, UserRepository userRepository) {
    this.markRepository = markRepository;
    this.documentRepository = documentService;
    this.userRepository = userRepository;
  }

  @Override
  public List<MarkDTO> getAllFromDocumentByTypeMark(Long documentId, TypeMark typeMark) {
    return markRepository.findAllByDocumentIdAndTypeMark(documentId,typeMark).stream()
        .map((MarkDTO::fromMark)).collect(Collectors.toList());
  }

  @Override
  public void addNewMark(MarkDTO markDTO) {
    Mark mark = markDTO.toMark(
        documentRepository.findById(markDTO.getDocumentId()).get(),
        userRepository.findByUsername(markDTO.getUserName()));
    markRepository.save(mark);
    log.info("IN addNewComment - comment added successfully");
  }

  @Override
  public void deleteMarkById(Long id) {
    markRepository.deleteById(id);
    log.info("IN delete - mark with id: ${id} successfully deleted");
  }
}
