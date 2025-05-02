package dev.onebuild.errors;

public class OneBuildEndpointNotFoundException extends OneBuildException {
  private final String message;
  public OneBuildEndpointNotFoundException(String message) {
    super();
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}