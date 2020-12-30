package com.titowecz.appList.rest;


import com.titowecz.appList.dto.CommentDTO;
import com.titowecz.appList.services.CommentService;
import com.titowecz.appList.services.DocumentService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1/documents/{id}/comments")
public class CommentRestControllerV1 {
  private final CommentService commentService;
  private final DocumentService documentService;
  public CommentRestControllerV1(CommentService commentService,DocumentService documentService) {
    this.commentService = commentService;
    this.documentService = documentService;
  }

  @PostMapping()
  public ResponseEntity addComment(
      Principal principal,
      @PathVariable(name = "id") Long id,
      @RequestBody CommentDTO commentDTO
  ){

    commentService.addNewComment(commentDTO,id,principal.getName());
    return ResponseEntity.ok("Comment add successfully");
  }
  @DeleteMapping()
  public ResponseEntity deleteComment(
      Principal principal,
      @Param(value = "commentId") Long commentId
  ){
    commentService.deleteComment(commentId, principal.getName());
    return ResponseEntity.ok("Comment delete successfully");
  }
}
