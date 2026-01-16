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
        | ifStatement
        | blockStatement
        | execStatement 
        | tryCatchStatement
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
    | setStatement
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
    | literal
    | functionCall
    | USER_VAR (EQ | PLUS_EQ) expression
    ;

tableSource
    : tableName
    ;

tableName
    : (BRACKET_IDENTIFIER | IDENTIFIER) (DOT (BRACKET_IDENTIFIER | IDENTIFIER))*
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
    | BRACKET_IDENTIFIER
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
    | expression IN LPAREN expression (COMMA expression)* RPAREN
    | expression IS NULL
    | expression IS NOT NULL
    | EXISTS LPAREN selectStatement RPAREN
    | NOT EXISTS LPAREN selectStatement RPAREN  
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
    : assignmentExpression
    ;

assignmentExpression
    : USER_VAR (EQ | PLUS_EQ) additiveExpression  
    | additiveExpression
    ;

additiveExpression
    : additiveExpression PLUS multiplicativeExpression
    | additiveExpression MINUS multiplicativeExpression
    | multiplicativeExpression
    ;

multiplicativeExpression
    : multiplicativeExpression STAR unaryExpression
    | multiplicativeExpression SLASH unaryExpression
    | unaryExpression
    ;

unaryExpression
    : PLUS unaryExpression
    | MINUS unaryExpression
    | primaryExpression
    ;

primaryExpression
    : columnName
    | literal
    | USER_VAR
    | functionCall
    | LPAREN expression RPAREN
    ;

caseExpression
    : CASE whenClause+ (ELSE expression)? END
    ;

whenClause
    : WHEN searchCondition THEN expression
    ;

literal
    : INT_LITERAL
    | FLOAT_LITERAL
    | STRING_LITERAL
    | TRUE_LITERAL
    | FALSE_LITERAL
    | NULL
    ;

functionCall
    : IDENTIFIER LPAREN (expression (COMMA expression)*)? RPAREN
    | BRACKET_IDENTIFIER LPAREN (expression (COMMA expression)*)? RPAREN
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
    : columnName (EQ | PLUS_EQ) expression
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
    | declareStatement
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
    : columnName dataType nullability?
    ;


nullability
    : NULL
    | NOT NULL
    ;

dataType
    :( INT
    | NVARCHAR LPAREN (MAX | INT_LITERAL) RPAREN
    | VARCHAR LPAREN (MAX | INT_LITERAL) RPAREN
    | BRACKET_IDENTIFIER 
    | IDENTIFIER) typeParams?
    ;


typeParams
    : LPAREN (MAX | INT_LITERAL) RPAREN
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

/*
=====================================================
  Block STATEMENT
=====================================================
*/

blockStatement
    : BEGIN blockContent* END
    ;

blockContent
    : sqlStatement
    | tryCatchStatement 
    ;

/*
=====================================================
  Exeception STATEMENT
=====================================================
*/

execStatement
    // : (EXEC | EXECUTE) (tableName | STRING_LITERAL) (expression (COMMA expression)*)?
    : (EXEC | EXECUTE) expression (COMMA expression)*
    ;

tryCatchStatement
    : BEGIN TRY blockContent* END TRY
      BEGIN CATCH blockContent* END CATCH
    ;

/*
=====================================================
  IF STATEMENT
=====================================================
*/

    ifStatement
    : IF searchCondition sqlStatement (ELSE sqlStatement)?
    ;

/*
=====================================================
  Declare STATEMENT
=====================================================
*/

declareStatement
    : DECLARE USER_VAR dataType (EQ expression)? (COMMA USER_VAR dataType (EQ expression)?)*
    ;

setStatement
    : SET USER_VAR (EQ | PLUS_EQ) expression (COMMA USER_VAR (EQ | PLUS_EQ) expression)* SEMI?
    ;

    