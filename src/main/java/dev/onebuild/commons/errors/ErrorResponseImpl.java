package dev.onebuild.commons.errors;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Builder
@Data
public class ErrorResponseImpl implements ErrorResponse {
  private String errorCode;
  private Map<String, Object> details;
  private String message;
}