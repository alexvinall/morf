/* Copyright 2017 Alfa Financial Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.alfasoftware.morf.sql;

import static org.alfasoftware.morf.sql.SelectFirstStatement.selectFirst;
import static org.alfasoftware.morf.sql.SqlUtils.literal;

import java.util.Arrays;
import java.util.List;

import org.alfasoftware.morf.sql.element.Criterion;
import org.alfasoftware.morf.sql.element.TableReference;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Checks that {@link SelectFirstStatement} satisfies equals, hashcode and deep copy contracts.
 *
 * @author Copyright (c) Alfa Financial Software 2017
 */
@RunWith(Parameterized.class)
public class TestSelectFirstStatementDeepCopyContractUsingBuilder extends AbstractShallowAndDeepCopyableTest<SelectFirstStatement> {

  private static final SelectStatement SELECT_1 = mockSelectStatement();
  private static final SelectStatement SELECT_2 = mockSelectStatement();
  private static final Criterion CRITERION_1 = mockOf(Criterion.class);
  private static final Criterion CRITERION_2 = mockOf(Criterion.class);
  private static final TableReference TABLE_1 = mockOf(TableReference.class);
  private static final TableReference TABLE_2 = mockOf(TableReference.class);


  @Parameters(name = "{0}")
  public static List<Object[]> data() {
    return Arrays.asList(
      testCaseWithBuilder("selectFirst(literal(1))", selectFirst(literal(1))),
      testCaseWithBuilder("selectFirst(literal(2))", selectFirst(literal(2))),
      testCaseWithBuilder("selectFirst(literal(1)).alias(\"A\")", selectFirst(literal(1)).alias("A")),
      testCaseWithBuilder("selectFirst(literal(1)).from(\"A\")", selectFirst(literal(1)).from("A")),
      testCaseWithBuilder("selectFirst(literal(1)).from(\"B\")", selectFirst(literal(1)).from("B")),
      testCaseWithBuilder("selectFirst(literal(1)).from(SELECT_1)", selectFirst(literal(1)).from(SELECT_1)),
      testCaseWithBuilder("selectFirst(literal(1)).from(SELECT_2)", selectFirst(literal(1)).from(SELECT_2)),
      testCaseWithBuilder("selectFirst(literal(1)).from(SELECT_1, SELECT_1)", selectFirst(literal(1)).from(SELECT_1, SELECT_1)),
      testCaseWithBuilder("selectFirst(literal(1)).from(SELECT_1, SELECT_2)", selectFirst(literal(1)).from(SELECT_1, SELECT_2)),
      testCaseWithBuilder("selectFirst(literal(1)).from(\"A\").where(CRITERION_1)", selectFirst(literal(1)).from("A").where(CRITERION_1)),
      testCaseWithBuilder("selectFirst(literal(1)).from(\"A\").where(CRITERION_2)", selectFirst(literal(1)).from("A").where(CRITERION_2)),
      testCaseWithBuilder("selectFirst(literal(1)).from(\"A\").innerJoin(TABLE_1)", selectFirst(literal(1)).from("A").innerJoin(TABLE_1)),
      testCaseWithBuilder("selectFirst(literal(1)).from(\"A\").innerJoin(TABLE_2)", selectFirst(literal(1)).from("A").innerJoin(TABLE_2)),
      testCaseWithBuilder("selectFirst(literal(1)).from(\"A\").innerJoin(TABLE_1).innerJoin(TABLE_2)", selectFirst(literal(1)).from("A").innerJoin(TABLE_1).innerJoin(TABLE_2)),
      testCaseWithBuilder("selectFirst(literal(1)).from(\"A\").innerJoin(TABLE_1, CRITERION_1).innerJoin(TABLE_2, CRITERION_1)", selectFirst(literal(1)).from("A").innerJoin(TABLE_1, CRITERION_1).innerJoin(TABLE_2, CRITERION_1)),
      testCaseWithBuilder("selectFirst(literal(1)).from(\"A\").leftOuterJoin(TABLE_1, CRITERION_1)", selectFirst(literal(1)).from("A").leftOuterJoin(TABLE_1, CRITERION_1)),
      testCaseWithBuilder("selectFirst(literal(1)).from(\"A\").leftOuterJoin(TABLE_1, CRITERION_2)", selectFirst(literal(1)).from("A").leftOuterJoin(TABLE_1, CRITERION_2)),
      testCaseWithBuilder("selectFirst(literal(1)).from(\"A\").leftOuterJoin(TABLE_2, CRITERION_1)", selectFirst(literal(1)).from("A").leftOuterJoin(TABLE_2, CRITERION_1)),
      testCaseWithBuilder("selectFirst(literal(1)).orderBy(literal(1), literal(2))", selectFirst(literal(1)).orderBy(literal(1), literal(2))),
      testCaseWithBuilder("selectFirst(literal(1)).orderBy(literal(1), literal(3))", selectFirst(literal(1)).orderBy(literal(1), literal(3)))
    );
  }

}