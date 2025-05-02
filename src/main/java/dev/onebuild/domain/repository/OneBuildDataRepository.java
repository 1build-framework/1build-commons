package dev.onebuild.domain.repository;

import dev.onebuild.domain.model.db.DatabaseInfo;
import dev.onebuild.domain.model.db.OneBuildRecord;

import java.util.List;
import java.util.Map;

public interface OneBuildDataRepository {
  void save(DatabaseInfo database, OneBuildRecord record);
  List<OneBuildRecord> find(DatabaseInfo database, Map<String, Object> params);
  void deleteById(DatabaseInfo database, Long id);
  void delete(DatabaseInfo database, List<Long> ids);
  void saveAll(DatabaseInfo database, List<OneBuildRecord> records, List<String> conflictColumns);
}