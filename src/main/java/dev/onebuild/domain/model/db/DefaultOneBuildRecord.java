package dev.onebuild.domain.model.db;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.io.Serial;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DefaultOneBuildRecord implements OneBuildRecord, Serializable {
  @Serial
  private static final long serialVersionUID = 20240830L;
  private final LinkedHashMap<String, Object> record;
  private static final String DEFAULT_ID_NAME = "id";
  private static final int DEFAULT_COLUMN_COUNT = 25;
  @Getter
  private final String idName;
  private final int columnCount;

  public DefaultOneBuildRecord() {
    this.idName = DEFAULT_ID_NAME;
    this.columnCount = DEFAULT_COLUMN_COUNT;
    this.record = new LinkedHashMap<>(columnCount + 1, 1.0f);
  }

  public DefaultOneBuildRecord(String idName) {
    this.idName = StringUtils.isBlank(idName) ? DEFAULT_ID_NAME : idName;
    this.columnCount = DEFAULT_COLUMN_COUNT;
    this.record = new LinkedHashMap<>(columnCount + 1, 1.0f);
  }

  public DefaultOneBuildRecord(int columnCount) {
    this.idName = DEFAULT_ID_NAME;
    this.columnCount = columnCount == 0 ? DEFAULT_COLUMN_COUNT : columnCount;
    this.record = new LinkedHashMap<>(columnCount + 1, 1.0f);
  }

  public DefaultOneBuildRecord(String idName, int columnCount) {
    this.idName = StringUtils.isBlank(idName) ? DEFAULT_ID_NAME : idName;
    this.columnCount = columnCount == 0 ? DEFAULT_COLUMN_COUNT : columnCount;
    this.record = new LinkedHashMap<>(columnCount + 1, 1.0f);
  }

  @Override
  public DefaultOneBuildRecord add(String name, Object value) {
    record.put(name, value);
    return this;
  }

  @Override
  public DefaultOneBuildRecord remove(String name) {
    record.remove(name);
    return this;
  }

  @Override
  public Object getId() {
    return record.get(idName);
  }

  @Override
  public void setId(Object id) {
    record.put(idName, id);
  }

  @Override
  public Object get(String name) {
    return record.get(name);
  }

  @Override
  public Object getFirst() {
    if(record.isEmpty()) return null;
    return record.get(getColumnNames().getFirst());
  }

  @Override
  public int getColumnCount() {
    return this.record.size();
  }

  @Override
  public OneBuildType getOneBuildType(String name) {
    Object value = record.get(name);
    if(value == null) {
      return OneBuildType.NULL;
    }
    return OneBuildTypeMappings.getOneBuildType(value.getClass());
  }

  @Override
  public int getSqlType(String name) {
    Object value = record.get(name);
    if(value == null) {
      return Types.NULL;
    }
    return OneBuildTypeMappings.getSqlType(value.getClass());
  }

  @Override
  public List<String> getColumnNames() {
    return List.copyOf(record.keySet());
  }

  @Override
  public SqlParameterSource getSqlParameterSource() {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    getColumnNames()
        .forEach(name -> parameters
            .addValue(name, record.get(name), getSqlType(name)));
    return parameters;
  }

  public static OneBuildRecord from(DatabaseInfo database, ResultSet rs) {
    DefaultOneBuildRecord record = null;

    try {
      ResultSetMetaData metadata = rs.getMetaData();
      record = new DefaultOneBuildRecord(database.getId(), metadata.getColumnCount());
      for(int i = 1; i <= metadata.getColumnCount(); i++) {
        String name = metadata.getColumnName(i);
        Object value = rs.getObject(i);
        record.add(name, value);
      }
    } catch(Exception e) {
      return null;
    }
    return record;
  }

  public static OneBuildRecord from(ResultSet rs) {
    DefaultOneBuildRecord record;
    try {
      ResultSetMetaData metadata = rs.getMetaData();
      record = new DefaultOneBuildRecord(metadata.getColumnCount());
      for(int i = 1; i <= metadata.getColumnCount(); i++) {
        String name = metadata.getColumnName(i);
        Object value = rs.getObject(i);
        record.add(name, value);
      }
    } catch(Exception e) {
      return null;
    }
    return record;
  }

  public static OneBuildRecord from(Map<String, Object> data) {
    DefaultOneBuildRecord record = new DefaultOneBuildRecord();
    data.forEach(record::add);
    return record;
  }

  @JsonValue
  public Map<String, Object> getData() {
    return record;
  }

  @JsonAnySetter
  public void setData(String name, Object value) {
    this.record.put(name, value);
  }
}
