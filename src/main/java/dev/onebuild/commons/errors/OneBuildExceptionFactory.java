package dev.onebuild.commons.errors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class OneBuildExceptionFactory {
  private final boolean productionEnabled;
  private final ObjectMapper objectMapper;
  private final YAMLMapper mapper;

  public OneBuildExceptionFactory(boolean productionEnabled, ObjectMapper objectMapper, YAMLMapper mapper) {
    this.productionEnabled = productionEnabled;
    this.objectMapper = objectMapper;
    this.mapper = mapper;
  }

  public OneBuildMissingPropertyException createMissingPropertyException(Object config) {
    return new OneBuildMissingPropertyException(createMessage(config));
  }

  public OneBuildMissingConfigException createMissingConfigException(String path) {
    return new OneBuildMissingConfigException("Configuration not found to serve resources at " + path);
  }

  public OneBuildResourceNotFoundException createComponentNotFoundException(String componentName) {
    return new OneBuildResourceNotFoundException("Component " + componentName + " not found. Create a Bean OneBuildComponents and define the component");
  }

  public OneBuildResourceNotFoundException createServiceNotFoundException(String serviceName) {
    return new OneBuildResourceNotFoundException("Script " + serviceName + " not found. Create a Bean OneBuildServices and define the services");
  }

  public OneBuildResourceNotFoundException createStoreNotFoundException(String storeName) {
    return new OneBuildResourceNotFoundException("Script " + storeName + " not found. Create a Bean OneBuildStores and define the stores");
  }

  public OneBuildEndpointNotFoundException createEndpointNotFoundException(String path) {
    return new OneBuildEndpointNotFoundException("Endpoint " + path + " not found. Create Bean(s) of OneBuildEndpoint type to define the endpoint");
  }

  public OneBuildDataSourceNotFoundException createDataSourceNotFoundException(String path) {
    return new OneBuildDataSourceNotFoundException("Endpoint " + path + " not found. Create Bean(s) of OneBuildEndpoint type to define the endpoint");
  }

  private String createMessage(Object config) {
    try {
      return "Missing properties in config\n" + mapper.writeValueAsString(config);
    } catch (Exception e) {
      return "Failed to serialize config";
    }
  }
}