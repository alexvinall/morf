package org.alfasoftware.morf.jdbc.redshift;

import org.alfasoftware.morf.jdbc.DatabaseType;
import org.alfasoftware.morf.jdbc.postgresql.PostgreSQLDialect;

/**
 * SQL dialect for Amazon Redshift.
 */
public class RedshiftDialect extends PostgreSQLDialect {

  public RedshiftDialect(String schemaName) {
    super(schemaName);
  }

  @Override
  public DatabaseType getDatabaseType() {
    return DatabaseType.Registry.findByIdentifier(Redshift.IDENTIFIER);
  }
}
