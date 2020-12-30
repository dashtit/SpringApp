package com.titowecz.appList.Repository;

import com.titowecz.appList.models.Mark;
import com.titowecz.appList.models.TypeMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {
  List<Mark> findAllByDocumentIdAndTypeMark(Long id, TypeMark typeMark);
}
