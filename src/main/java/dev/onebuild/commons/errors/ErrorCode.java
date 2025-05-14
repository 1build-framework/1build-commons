package dev.onebuild.commons.errors;

import lombok.Getter;

@Getter
public enum ErrorCode {
  DB_ERROR("DB00"),
  UI_ERROR("UI00"),
  WEB_ERROR("WB00"),
  DOMAIN_ERROR("D000"),
  SERVER_ERROR("SE00");

  private final String code;

  ErrorCode(String code) {
    this.code = code;
  }
}