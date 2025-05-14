package dev.onebuild.commons.errors;

public class OneBuildEndpointNotFoundException extends RuntimeException implements OneBuildException {
  private final String message;
  public OneBuildEndpointNotFoundException(String message) {
    super();
    this.message = message;
  }

  @Override
  public ErrorCode getErrorCode() {
    return null;
  }

  @Override
  public String getMessage() {
    return message;
  }
}