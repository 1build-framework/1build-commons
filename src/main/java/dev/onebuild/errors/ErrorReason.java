package dev.onebuild.errors;

import lombok.Getter;

@Getter
public enum ErrorReason {
  SYSTEM("system"),
  ZERO_UPDATE("ZU00"),
  ZERO_SELECT("ZS00");

  private final String code;

  ErrorReason(String code) {
    this.code = code;
  }
}