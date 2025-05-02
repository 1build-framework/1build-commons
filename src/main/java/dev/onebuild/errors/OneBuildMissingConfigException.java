package dev.onebuild.errors;

public class OneBuildMissingConfigException extends OneBuildException {
  private final String message;

  public OneBuildMissingConfigException(String message) {
    super();
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}