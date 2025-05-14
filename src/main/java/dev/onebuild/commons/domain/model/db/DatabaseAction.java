package dev.onebuild.commons.domain.model.db;

import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Collectors;

@Getter
public enum DatabaseAction {
  FIND("FIND", "find.sql.ftl"),
  INSERT_ONE("INSERT_ONE", "insert-one.sql.ftl"),
  INSERT_ALL("INSERT_ALL", "bulk-upsert-all.sql.ftl"),
  UPDATE_BY_ID("UPDATE_BY_ID", "update-by-id.sql.ftl"),
  DELETE_BY_ID("DELETE_BY_ID", "delete-by-id.sql.ftl"),
  DELETE("DELETE", "delete.sql.ftl");

  private final String name;
  private final String value;

  DatabaseAction(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public static DatabaseAction fromName(String name) {
    for (DatabaseAction statement : DatabaseAction.values()) {
      if (statement.name.equals(name)) {
        return statement;
      }
    }
    return null;
  }

  public static String listAllNames() {
    return Arrays.stream(DatabaseAction.values()).map(DatabaseAction::getName).collect(Collectors.joining(", "));
  }

  @Override
  public String toString() {
    return value;
  }
}