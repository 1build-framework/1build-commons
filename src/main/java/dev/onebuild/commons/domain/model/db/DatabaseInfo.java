package dev.onebuild.commons.domain.model.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseInfo {
  protected String dataSource;
  protected String schema;
  protected String table;
  protected String id;
  protected String statement;
}