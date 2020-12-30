package com.titowecz.appList.dto;

import com.titowecz.appList.models.Document;
import com.titowecz.appList.models.Mark;
import com.titowecz.appList.models.TypeMark;
import com.titowecz.appList.models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarkDTO {
  private Long id;

  private TypeMark mark;

  private Long documentId;

  private String userName;

  public MarkDTO() {}

  public MarkDTO(TypeMark typeMark, Long documentId, String userName) {
    this.mark = typeMark;
    this.documentId = documentId;
    this.userName = userName;
  }

  public Mark toMark(Document document, User user) {
    Mark mark = new Mark();
    mark.setId(id);
    mark.setTypeMark(this.mark);
    mark.setUser(user);
    mark.setDocument(document);
    return mark;
  }

  public static MarkDTO fromMark(Mark mark) {
    MarkDTO markDTO = new MarkDTO();
    markDTO.setId(mark.getId());
    markDTO.setMark(mark.getTypeMark());
    return markDTO;
  }
}
