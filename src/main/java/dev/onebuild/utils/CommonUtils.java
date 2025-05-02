package dev.onebuild.utils;

import org.springframework.dao.*;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.UncategorizedSQLException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

public class CommonUtils {
  public static final Map<Class<? extends Throwable>, String> exceptionMessages = Map.ofEntries(
      Map.entry(DataIntegrityViolationException.class, "The data you entered already exists or violates a constraint."),
      Map.entry(DuplicateKeyException.class, "One or more data items already exists with unique constraint."),
      Map.entry(DataAccessResourceFailureException.class, "Database service is temporarily unavailable. Please try again later."),
      Map.entry(CannotAcquireLockException.class, "The requested resource is temporarily locked. Please try again later."),
      Map.entry(QueryTimeoutException.class, "The database query timed out. Please try again later."),
      Map.entry(BadSqlGrammarException.class, "An internal error occurred. Please contact support."),
      Map.entry(InvalidResultSetAccessException.class, "An unexpected data format was encountered. Please contact support."),
      Map.entry(EmptyResultDataAccessException.class, "No results found for your query."),
      Map.entry(PermissionDeniedDataAccessException.class, "You do not have permission to perform this operation."),
      Map.entry(InvalidDataAccessResourceUsageException.class, "The database operation could not be completed. Please contact support."),
      Map.entry(NonTransientDataAccessException.class, "An error occurred while accessing data. Please try again."),
      Map.entry(ConcurrencyFailureException.class, "The data was modified by another transaction. Please refresh and try again."),
      Map.entry(UncategorizedSQLException.class, "An unexpected database error occurred. Please contact support.")
  );

  public static String getUserMessage(Exception e) {
    return exceptionMessages.getOrDefault(
        e.getClass(), "An unexpected error occurred. Please contact support."
    );
  }

  public static String toString(Throwable t) {
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    t.printStackTrace(printWriter);
    return stringWriter.toString();
  }
}