package dev.onebuild.domain.model.ui;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UiScript {
  private String name;
  private String home;
  private String resource;
  private List<UiPagelet> pagelets;

  public String getResource() {
    if(StringUtils.isBlank(resource)) {
      return name + ".js";
    }
    return resource;
  }
}