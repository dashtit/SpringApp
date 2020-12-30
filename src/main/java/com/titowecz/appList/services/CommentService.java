package com.titowecz.appList.services;

import com.titowecz.appList.dto.CommentDTO;

import java.util.List;

public interface CommentService {

  List<CommentDTO> getAllFromDocument(Long documentId);

  void addNewComment(CommentDTO commentDTO,Long id,String username);

  void deleteComment(Long id,String username);
}
