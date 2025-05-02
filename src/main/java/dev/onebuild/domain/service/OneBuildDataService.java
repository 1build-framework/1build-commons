package dev.onebuild.domain.service;

import dev.onebuild.domain.model.db.DatabaseInfo;
import dev.onebuild.domain.model.db.OneBuildRecord;

import java.util.List;
import java.util.Map;

public interface OneBuildDataService {
  List<OneBuildRecord> find(String path, Map<String, Object> params);
  void save(DatabaseInfo databaseInfo, OneBuildRecord record);
  void save(String contextPath, String path, OneBuildRecord record);
  void deleteById(String contextPath, String path, Long id);
  void delete(String path, List<Long> ids);
}