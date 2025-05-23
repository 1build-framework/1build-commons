package dev.onebuild.commons.errors;

import java.util.Map;

public interface ErrorResponse {
  String getErrorCode();
  Map<String, Object> getDetails();
  String getMessage();
}