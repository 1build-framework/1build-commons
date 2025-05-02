package dev.onebuild.errors;

public abstract class OneBuildException extends RuntimeException {
  public OneBuildException() {
    super();
  }

  public abstract String getMessage();
}