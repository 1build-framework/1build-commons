package dev.onebuild.errors;

public class OneBuildDataSourceNotFoundException extends OneBuildException {
  private String dataSource;
  public OneBuildDataSourceNotFoundException(String dataSource) {
    super();
    this.dataSource = dataSource;
  }

  @Override
  public String getMessage() {
    return "Data source or JdbcTemplate not found for " + dataSource;
  }
}