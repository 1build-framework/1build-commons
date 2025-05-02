package dev.onebuild.errors;

public class OneBuildMissingPropertyException extends OneBuildException {
  private final String message;

  public OneBuildMissingPropertyException(String message) {
    super();
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}