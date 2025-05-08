package dev.onebuild.errors;

public class OneBuildDataSourceNotFoundException extends RuntimeException implements OneBuildException {
  private String dataSource;
  public OneBuildDataSourceNotFoundException(String dataSource) {
    super();
    this.dataSource = dataSource;
  }

  @Override
  public ErrorCode getErrorCode() {
    return null;
  }

  @Override
  public String getMessage() {
    return "Data source or JdbcTemplate not found for " + dataSource;
  }
}