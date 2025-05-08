package dev.onebuild.errors;

public interface OneBuildException {
  ErrorCode getErrorCode();
  String getMessage();
}