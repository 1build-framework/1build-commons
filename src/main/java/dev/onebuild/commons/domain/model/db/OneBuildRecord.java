package dev.onebuild.commons.domain.model.db;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import java.util.List;

public interface OneBuildRecord {
  DefaultOneBuildRecord add(String name, Object value);
  DefaultOneBuildRecord remove(String name);
  Object getId();
  void setId(Object id);
  Object get(String name);
  Object getFirst();
  int getColumnCount();
  String getIdName();
  OneBuildType getOneBuildType(String name);
  int getSqlType(String name);
  List<String> getColumnNames();
  SqlParameterSource getSqlParameterSource();
}