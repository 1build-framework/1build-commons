package dev.onebuild.domain.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class OneBuildAppSettings {
  @Value("${onebuild.production.enabled:false}")
  private boolean prodEnabled;

  @Value("${onebuild.ui.main-component}")
  private String mainComponent;
}