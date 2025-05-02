package dev.onebuild.domain.model.ui;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.onebuild.domain.model.db.DatabaseInfo;
import lombok.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(of = {"webPath"}, callSuper = false)
public class OneBuildEndpoint extends DatabaseInfo {
  private ResourceType resourceType;
  private String webPath;
  private Set<DatabaseOpType> operations;

  public OneBuildEndpoint copy() {
    OneBuildEndpoint endpoint = new OneBuildEndpoint();
    endpoint.setResourceType(resourceType);
    endpoint.setWebPath(webPath);
    endpoint.setDataSource(dataSource);
    endpoint.setSchema(schema);
    endpoint.setTable(table);
    endpoint.setId(id);
    endpoint.setStatement(statement);
    return endpoint;
  }
}