package dev.onebuild.errors;

public class OneBuildMissingPropertyException extends RuntimeException implements OneBuildException {
  private final String message;

  public OneBuildMissingPropertyException(String message) {
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