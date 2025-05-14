package dev.onebuild.commons.domain.model.ui;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(of = {"resourceType", "webPath"}, callSuper = false)
public class OneBuildValidator {
  private ResourceType resourceType;
  private String webPath;

  private List<UiValidator> list;
}