package dev.onebuild.commons.domain.model.ui;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"webPath", "sourcePath"})
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractOneBuildLocation implements OneBuildLocation{
  @JsonProperty("web-path")
  protected String webPath;
  @JsonProperty("source-path")
  protected String sourcePath;
  @JsonProperty("resource-type")
  protected ResourceType resourceType;
}