package dev.onebuild.errors;

public class OneBuildResourceNotFoundException extends OneBuildException {
  private final String message;

  public OneBuildResourceNotFoundException(String message) {
    super();
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}