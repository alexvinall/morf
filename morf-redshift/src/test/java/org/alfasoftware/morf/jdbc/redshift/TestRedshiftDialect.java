package org.alfasoftware.morf.jdbc.redshift;

import org.alfasoftware.morf.jdbc.SqlDialect;
import org.alfasoftware.morf.jdbc.postgresql.TestPostgreSQLDialect;

import org.alfasoftware.morf.jdbc.redshift.RedshiftDialect;
/**
 * Runs PostgreSQL dialect tests using the Redshift dialect implementation.
 */
public class TestRedshiftDialect extends TestPostgreSQLDialect {

  @Override
  protected SqlDialect createTestDialect() {
    return new RedshiftDialect("testschema");
  }
}
