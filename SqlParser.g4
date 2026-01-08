parser grammar SqlParser;

options {
    tokenVocab = SqlLexer;
}

/*
=====================================================
  START RULE
=====================================================
*/

sqlFile
    : sqlStatement* EOF
    ;

sqlStatement
    : cteStatement? (
          dmlStatement
        | ddlStatement
        | cursorStatement
      ) SEMI?
    ;

/*
=====================================================
  COMMON TABLE EXPRESSION (CTE)
=====================================================
*/

cteStatement
    : WITH cteDefinition (COMMA cteDefinition)*
    ;

cteDefinition
    : IDENTIFIER AS LPAREN selectStatement RPAREN
    ;

/*
=====================================================
  DML STATEMENTS
=====================================================
*/

dmlStatement
    : selectStatement
    | insertStatement
    | updateStatement
    | deleteStatement
    ;

/*
-------------------
  SELECT
-------------------
*/

selectStatement
    : SELECT selectList
      FROM tableSource
      joinClause*
      whereClause?
      groupByClause?
      orderByClause?
    ;

selectList
    : STAR
    | selectElement (COMMA selectElement)*
    ;

selectElement
    : columnName
    ;

tableSource
    : tableName
    ;

tableName
    : IDENTIFIER
    ;

/*
-------------------
  JOIN
-------------------
*/

joinClause
    : joinType JOIN tableSource ON searchCondition
    ;

joinType
    : INNER
    | LEFT
    | RIGHT
    | FULL
    | /* empty = default INNER */
    ;

columnName
    : IDENTIFIER
    ;

/*
-------------------
  WHERE
-------------------
*/

whereClause
    : WHERE searchCondition
    ;

/*
-------------------
  GROUP BY
-------------------
*/

groupByClause
    : GROUP BY columnName (COMMA columnName)*
    ;

/*
-------------------
  ORDER BY
-------------------
*/

orderByClause
    : ORDER BY orderElement (COMMA orderElement)*
    ;

orderElement
    : columnName (ASC | DESC)?
    ;

/*
=====================================================
  SEARCH CONDITIONS
=====================================================
*/

searchCondition
    : searchCondition AND searchCondition
    | searchCondition OR searchCondition
    | LPAREN searchCondition RPAREN
    | predicate
    ;

predicate
    : expression comparisonOperator expression
    ;

comparisonOperator
    : EQ
    | NEQ
    | GT
    | GTE
    | LT
    | LTE
    ;

/*
=====================================================
  EXPRESSIONS
=====================================================
*/

expression
    : columnName
    | literal
    ;

literal
    : INT_LITERAL
    | FLOAT_LITERAL
    | STRING_LITERAL
    | TRUE_LITERAL
    | FALSE_LITERAL
    | NULL
    ;

/*
=====================================================
  INSERT
=====================================================
*/

insertStatement
    : INSERT INTO tableName
      LPAREN columnName (COMMA columnName)* RPAREN
      VALUES
      LPAREN literal (COMMA literal)* RPAREN
    ;

/*
=====================================================
  UPDATE
=====================================================
*/

updateStatement
    : UPDATE tableName
      SET assignment (COMMA assignment)*
      whereClause?
    ;

assignment
    : columnName EQ expression
    ;

/*
=====================================================
  DELETE
=====================================================
*/

deleteStatement
    : DELETE FROM tableName whereClause?
    ;

/*
=====================================================
  DDL STATEMENTS
=====================================================
*/

ddlStatement
    : createTableStatement
    | dropTableStatement
    | alterTableStatement
    ;

/*
-------------------
  CREATE TABLE
-------------------
*/

createTableStatement
    : CREATE TABLE tableName
      LPAREN columnDefinition (COMMA columnDefinition)* RPAREN
    ;

columnDefinition
    : columnName dataType
    ;

dataType
    : INT
    | IDENTIFIER
    ;

/*
-------------------
  DROP TABLE
-------------------
*/

dropTableStatement
    : DROP TABLE tableName
    ;

/*
-------------------
  ALTER TABLE (subset)
-------------------
*/

alterTableStatement
    : ALTER TABLE tableName alterAction
    ;

alterAction
    : ADD columnDefinition
    | DROP columnName
    ;

/*
=====================================================
  CURSOR MANIPULATION STATEMENTS (subset)
=====================================================
*/

cursorStatement
    : declareCursor
    | openCursor
    | fetchCursor
    | closeCursor
    ;

declareCursor
    : DECLARE IDENTIFIER CURSOR FOR selectStatement
    ;

openCursor
    : OPEN IDENTIFIER
    ;

fetchCursor
    : FETCH IDENTIFIER
    ;

closeCursor
    : CLOSE IDENTIFIER
    ;
