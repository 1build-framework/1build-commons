package dev.onebuild.commons.errors;

public interface OneBuildException {
  ErrorCode getErrorCode();
  String getMessage();
}