package com.titowecz.appList.services;

import com.titowecz.appList.dto.MarkDTO;
import com.titowecz.appList.models.TypeMark;

import java.util.List;

public interface MarkService {
  List<MarkDTO> getAllFromDocumentByTypeMark(Long documentId, TypeMark typeMark);

  void addNewMark(MarkDTO markDTO);

  void deleteMarkById(Long id);
}
