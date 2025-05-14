package dev.onebuild.commons.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import dev.onebuild.commons.errors.OneBuildExceptionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CommonConfiguration {

  @Primary
  @Bean("mapper")
  public ObjectMapper mapper() {
    return new ObjectMapper();
  }

  @Bean("yamlMapper")
  public YAMLMapper yamlMapper() {
    return new YAMLMapper();
  }

  @Bean
  public OneBuildExceptionFactory exceptionFactory(@Value("${onebuild.production.enabled:false}") boolean productEnabled,
                                                   @Qualifier("mapper") ObjectMapper objectMapper,
                                                   @Qualifier("yamlMapper") YAMLMapper yamlMapper) {
    return new OneBuildExceptionFactory(productEnabled, objectMapper, yamlMapper);
  }
}