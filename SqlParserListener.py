# Generated from SqlParser.g4 by ANTLR 4.13.1
from antlr4 import *
if "." in __name__:
    from .SqlParser import SqlParser
else:
    from SqlParser import SqlParser

# This class defines a complete listener for a parse tree produced by SqlParser.
class SqlParserListener(ParseTreeListener):

    # Enter a parse tree produced by SqlParser#sqlFile.
    def enterSqlFile(self, ctx:SqlParser.SqlFileContext):
        pass

    # Exit a parse tree produced by SqlParser#sqlFile.
    def exitSqlFile(self, ctx:SqlParser.SqlFileContext):
        pass


    # Enter a parse tree produced by SqlParser#sqlStatement.
    def enterSqlStatement(self, ctx:SqlParser.SqlStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#sqlStatement.
    def exitSqlStatement(self, ctx:SqlParser.SqlStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#cteStatement.
    def enterCteStatement(self, ctx:SqlParser.CteStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#cteStatement.
    def exitCteStatement(self, ctx:SqlParser.CteStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#cteDefinition.
    def enterCteDefinition(self, ctx:SqlParser.CteDefinitionContext):
        pass

    # Exit a parse tree produced by SqlParser#cteDefinition.
    def exitCteDefinition(self, ctx:SqlParser.CteDefinitionContext):
        pass


    # Enter a parse tree produced by SqlParser#dmlStatement.
    def enterDmlStatement(self, ctx:SqlParser.DmlStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#dmlStatement.
    def exitDmlStatement(self, ctx:SqlParser.DmlStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#selectStatement.
    def enterSelectStatement(self, ctx:SqlParser.SelectStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#selectStatement.
    def exitSelectStatement(self, ctx:SqlParser.SelectStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#selectList.
    def enterSelectList(self, ctx:SqlParser.SelectListContext):
        pass

    # Exit a parse tree produced by SqlParser#selectList.
    def exitSelectList(self, ctx:SqlParser.SelectListContext):
        pass


    # Enter a parse tree produced by SqlParser#selectElement.
    def enterSelectElement(self, ctx:SqlParser.SelectElementContext):
        pass

    # Exit a parse tree produced by SqlParser#selectElement.
    def exitSelectElement(self, ctx:SqlParser.SelectElementContext):
        pass


    # Enter a parse tree produced by SqlParser#tableSource.
    def enterTableSource(self, ctx:SqlParser.TableSourceContext):
        pass

    # Exit a parse tree produced by SqlParser#tableSource.
    def exitTableSource(self, ctx:SqlParser.TableSourceContext):
        pass


    # Enter a parse tree produced by SqlParser#tableName.
    def enterTableName(self, ctx:SqlParser.TableNameContext):
        pass

    # Exit a parse tree produced by SqlParser#tableName.
    def exitTableName(self, ctx:SqlParser.TableNameContext):
        pass


    # Enter a parse tree produced by SqlParser#joinClause.
    def enterJoinClause(self, ctx:SqlParser.JoinClauseContext):
        pass

    # Exit a parse tree produced by SqlParser#joinClause.
    def exitJoinClause(self, ctx:SqlParser.JoinClauseContext):
        pass


    # Enter a parse tree produced by SqlParser#joinType.
    def enterJoinType(self, ctx:SqlParser.JoinTypeContext):
        pass

    # Exit a parse tree produced by SqlParser#joinType.
    def exitJoinType(self, ctx:SqlParser.JoinTypeContext):
        pass


    # Enter a parse tree produced by SqlParser#columnName.
    def enterColumnName(self, ctx:SqlParser.ColumnNameContext):
        pass

    # Exit a parse tree produced by SqlParser#columnName.
    def exitColumnName(self, ctx:SqlParser.ColumnNameContext):
        pass


    # Enter a parse tree produced by SqlParser#whereClause.
    def enterWhereClause(self, ctx:SqlParser.WhereClauseContext):
        pass

    # Exit a parse tree produced by SqlParser#whereClause.
    def exitWhereClause(self, ctx:SqlParser.WhereClauseContext):
        pass


    # Enter a parse tree produced by SqlParser#groupByClause.
    def enterGroupByClause(self, ctx:SqlParser.GroupByClauseContext):
        pass

    # Exit a parse tree produced by SqlParser#groupByClause.
    def exitGroupByClause(self, ctx:SqlParser.GroupByClauseContext):
        pass


    # Enter a parse tree produced by SqlParser#orderByClause.
    def enterOrderByClause(self, ctx:SqlParser.OrderByClauseContext):
        pass

    # Exit a parse tree produced by SqlParser#orderByClause.
    def exitOrderByClause(self, ctx:SqlParser.OrderByClauseContext):
        pass


    # Enter a parse tree produced by SqlParser#orderElement.
    def enterOrderElement(self, ctx:SqlParser.OrderElementContext):
        pass

    # Exit a parse tree produced by SqlParser#orderElement.
    def exitOrderElement(self, ctx:SqlParser.OrderElementContext):
        pass


    # Enter a parse tree produced by SqlParser#searchCondition.
    def enterSearchCondition(self, ctx:SqlParser.SearchConditionContext):
        pass

    # Exit a parse tree produced by SqlParser#searchCondition.
    def exitSearchCondition(self, ctx:SqlParser.SearchConditionContext):
        pass


    # Enter a parse tree produced by SqlParser#orExpression.
    def enterOrExpression(self, ctx:SqlParser.OrExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#orExpression.
    def exitOrExpression(self, ctx:SqlParser.OrExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#andExpression.
    def enterAndExpression(self, ctx:SqlParser.AndExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#andExpression.
    def exitAndExpression(self, ctx:SqlParser.AndExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#notExpression.
    def enterNotExpression(self, ctx:SqlParser.NotExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#notExpression.
    def exitNotExpression(self, ctx:SqlParser.NotExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#predicate.
    def enterPredicate(self, ctx:SqlParser.PredicateContext):
        pass

    # Exit a parse tree produced by SqlParser#predicate.
    def exitPredicate(self, ctx:SqlParser.PredicateContext):
        pass


    # Enter a parse tree produced by SqlParser#comparisonOperator.
    def enterComparisonOperator(self, ctx:SqlParser.ComparisonOperatorContext):
        pass

    # Exit a parse tree produced by SqlParser#comparisonOperator.
    def exitComparisonOperator(self, ctx:SqlParser.ComparisonOperatorContext):
        pass


    # Enter a parse tree produced by SqlParser#expression.
    def enterExpression(self, ctx:SqlParser.ExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#expression.
    def exitExpression(self, ctx:SqlParser.ExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#assignmentExpression.
    def enterAssignmentExpression(self, ctx:SqlParser.AssignmentExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#assignmentExpression.
    def exitAssignmentExpression(self, ctx:SqlParser.AssignmentExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#additiveExpression.
    def enterAdditiveExpression(self, ctx:SqlParser.AdditiveExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#additiveExpression.
    def exitAdditiveExpression(self, ctx:SqlParser.AdditiveExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#multiplicativeExpression.
    def enterMultiplicativeExpression(self, ctx:SqlParser.MultiplicativeExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#multiplicativeExpression.
    def exitMultiplicativeExpression(self, ctx:SqlParser.MultiplicativeExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#unaryExpression.
    def enterUnaryExpression(self, ctx:SqlParser.UnaryExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#unaryExpression.
    def exitUnaryExpression(self, ctx:SqlParser.UnaryExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#primaryExpression.
    def enterPrimaryExpression(self, ctx:SqlParser.PrimaryExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#primaryExpression.
    def exitPrimaryExpression(self, ctx:SqlParser.PrimaryExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#caseExpression.
    def enterCaseExpression(self, ctx:SqlParser.CaseExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#caseExpression.
    def exitCaseExpression(self, ctx:SqlParser.CaseExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#whenClause.
    def enterWhenClause(self, ctx:SqlParser.WhenClauseContext):
        pass

    # Exit a parse tree produced by SqlParser#whenClause.
    def exitWhenClause(self, ctx:SqlParser.WhenClauseContext):
        pass


    # Enter a parse tree produced by SqlParser#literal.
    def enterLiteral(self, ctx:SqlParser.LiteralContext):
        pass

    # Exit a parse tree produced by SqlParser#literal.
    def exitLiteral(self, ctx:SqlParser.LiteralContext):
        pass


    # Enter a parse tree produced by SqlParser#functionCall.
    def enterFunctionCall(self, ctx:SqlParser.FunctionCallContext):
        pass

    # Exit a parse tree produced by SqlParser#functionCall.
    def exitFunctionCall(self, ctx:SqlParser.FunctionCallContext):
        pass


    # Enter a parse tree produced by SqlParser#functionName.
    def enterFunctionName(self, ctx:SqlParser.FunctionNameContext):
        pass

    # Exit a parse tree produced by SqlParser#functionName.
    def exitFunctionName(self, ctx:SqlParser.FunctionNameContext):
        pass


    # Enter a parse tree produced by SqlParser#keyword.
    def enterKeyword(self, ctx:SqlParser.KeywordContext):
        pass

    # Exit a parse tree produced by SqlParser#keyword.
    def exitKeyword(self, ctx:SqlParser.KeywordContext):
        pass


    # Enter a parse tree produced by SqlParser#insertStatement.
    def enterInsertStatement(self, ctx:SqlParser.InsertStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#insertStatement.
    def exitInsertStatement(self, ctx:SqlParser.InsertStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#updateStatement.
    def enterUpdateStatement(self, ctx:SqlParser.UpdateStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#updateStatement.
    def exitUpdateStatement(self, ctx:SqlParser.UpdateStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#assignment.
    def enterAssignment(self, ctx:SqlParser.AssignmentContext):
        pass

    # Exit a parse tree produced by SqlParser#assignment.
    def exitAssignment(self, ctx:SqlParser.AssignmentContext):
        pass


    # Enter a parse tree produced by SqlParser#deleteStatement.
    def enterDeleteStatement(self, ctx:SqlParser.DeleteStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#deleteStatement.
    def exitDeleteStatement(self, ctx:SqlParser.DeleteStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#ddlStatement.
    def enterDdlStatement(self, ctx:SqlParser.DdlStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#ddlStatement.
    def exitDdlStatement(self, ctx:SqlParser.DdlStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#createTableStatement.
    def enterCreateTableStatement(self, ctx:SqlParser.CreateTableStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#createTableStatement.
    def exitCreateTableStatement(self, ctx:SqlParser.CreateTableStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#columnDefinition.
    def enterColumnDefinition(self, ctx:SqlParser.ColumnDefinitionContext):
        pass

    # Exit a parse tree produced by SqlParser#columnDefinition.
    def exitColumnDefinition(self, ctx:SqlParser.ColumnDefinitionContext):
        pass


    # Enter a parse tree produced by SqlParser#tableConstraint.
    def enterTableConstraint(self, ctx:SqlParser.TableConstraintContext):
        pass

    # Exit a parse tree produced by SqlParser#tableConstraint.
    def exitTableConstraint(self, ctx:SqlParser.TableConstraintContext):
        pass


    # Enter a parse tree produced by SqlParser#tableElement.
    def enterTableElement(self, ctx:SqlParser.TableElementContext):
        pass

    # Exit a parse tree produced by SqlParser#tableElement.
    def exitTableElement(self, ctx:SqlParser.TableElementContext):
        pass


    # Enter a parse tree produced by SqlParser#constraintDefinition.
    def enterConstraintDefinition(self, ctx:SqlParser.ConstraintDefinitionContext):
        pass

    # Exit a parse tree produced by SqlParser#constraintDefinition.
    def exitConstraintDefinition(self, ctx:SqlParser.ConstraintDefinitionContext):
        pass


    # Enter a parse tree produced by SqlParser#primaryKeyConstraint.
    def enterPrimaryKeyConstraint(self, ctx:SqlParser.PrimaryKeyConstraintContext):
        pass

    # Exit a parse tree produced by SqlParser#primaryKeyConstraint.
    def exitPrimaryKeyConstraint(self, ctx:SqlParser.PrimaryKeyConstraintContext):
        pass


    # Enter a parse tree produced by SqlParser#uniqueConstraint.
    def enterUniqueConstraint(self, ctx:SqlParser.UniqueConstraintContext):
        pass

    # Exit a parse tree produced by SqlParser#uniqueConstraint.
    def exitUniqueConstraint(self, ctx:SqlParser.UniqueConstraintContext):
        pass


    # Enter a parse tree produced by SqlParser#clustered.
    def enterClustered(self, ctx:SqlParser.ClusteredContext):
        pass

    # Exit a parse tree produced by SqlParser#clustered.
    def exitClustered(self, ctx:SqlParser.ClusteredContext):
        pass


    # Enter a parse tree produced by SqlParser#foreignKeyConstraint.
    def enterForeignKeyConstraint(self, ctx:SqlParser.ForeignKeyConstraintContext):
        pass

    # Exit a parse tree produced by SqlParser#foreignKeyConstraint.
    def exitForeignKeyConstraint(self, ctx:SqlParser.ForeignKeyConstraintContext):
        pass


    # Enter a parse tree produced by SqlParser#checkConstraint.
    def enterCheckConstraint(self, ctx:SqlParser.CheckConstraintContext):
        pass

    # Exit a parse tree produced by SqlParser#checkConstraint.
    def exitCheckConstraint(self, ctx:SqlParser.CheckConstraintContext):
        pass


    # Enter a parse tree produced by SqlParser#columnOptions.
    def enterColumnOptions(self, ctx:SqlParser.ColumnOptionsContext):
        pass

    # Exit a parse tree produced by SqlParser#columnOptions.
    def exitColumnOptions(self, ctx:SqlParser.ColumnOptionsContext):
        pass


    # Enter a parse tree produced by SqlParser#dataType.
    def enterDataType(self, ctx:SqlParser.DataTypeContext):
        pass

    # Exit a parse tree produced by SqlParser#dataType.
    def exitDataType(self, ctx:SqlParser.DataTypeContext):
        pass


    # Enter a parse tree produced by SqlParser#typeParams.
    def enterTypeParams(self, ctx:SqlParser.TypeParamsContext):
        pass

    # Exit a parse tree produced by SqlParser#typeParams.
    def exitTypeParams(self, ctx:SqlParser.TypeParamsContext):
        pass


    # Enter a parse tree produced by SqlParser#dropTableStatement.
    def enterDropTableStatement(self, ctx:SqlParser.DropTableStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#dropTableStatement.
    def exitDropTableStatement(self, ctx:SqlParser.DropTableStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#alterTableStatement.
    def enterAlterTableStatement(self, ctx:SqlParser.AlterTableStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#alterTableStatement.
    def exitAlterTableStatement(self, ctx:SqlParser.AlterTableStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#alterAction.
    def enterAlterAction(self, ctx:SqlParser.AlterActionContext):
        pass

    # Exit a parse tree produced by SqlParser#alterAction.
    def exitAlterAction(self, ctx:SqlParser.AlterActionContext):
        pass


    # Enter a parse tree produced by SqlParser#cursorStatement.
    def enterCursorStatement(self, ctx:SqlParser.CursorStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#cursorStatement.
    def exitCursorStatement(self, ctx:SqlParser.CursorStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#declareCursor.
    def enterDeclareCursor(self, ctx:SqlParser.DeclareCursorContext):
        pass

    # Exit a parse tree produced by SqlParser#declareCursor.
    def exitDeclareCursor(self, ctx:SqlParser.DeclareCursorContext):
        pass


    # Enter a parse tree produced by SqlParser#openCursor.
    def enterOpenCursor(self, ctx:SqlParser.OpenCursorContext):
        pass

    # Exit a parse tree produced by SqlParser#openCursor.
    def exitOpenCursor(self, ctx:SqlParser.OpenCursorContext):
        pass


    # Enter a parse tree produced by SqlParser#fetchCursor.
    def enterFetchCursor(self, ctx:SqlParser.FetchCursorContext):
        pass

    # Exit a parse tree produced by SqlParser#fetchCursor.
    def exitFetchCursor(self, ctx:SqlParser.FetchCursorContext):
        pass


    # Enter a parse tree produced by SqlParser#closeCursor.
    def enterCloseCursor(self, ctx:SqlParser.CloseCursorContext):
        pass

    # Exit a parse tree produced by SqlParser#closeCursor.
    def exitCloseCursor(self, ctx:SqlParser.CloseCursorContext):
        pass


    # Enter a parse tree produced by SqlParser#blockStatement.
    def enterBlockStatement(self, ctx:SqlParser.BlockStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#blockStatement.
    def exitBlockStatement(self, ctx:SqlParser.BlockStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#blockContent.
    def enterBlockContent(self, ctx:SqlParser.BlockContentContext):
        pass

    # Exit a parse tree produced by SqlParser#blockContent.
    def exitBlockContent(self, ctx:SqlParser.BlockContentContext):
        pass


    # Enter a parse tree produced by SqlParser#execStatement.
    def enterExecStatement(self, ctx:SqlParser.ExecStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#execStatement.
    def exitExecStatement(self, ctx:SqlParser.ExecStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#tryCatchStatement.
    def enterTryCatchStatement(self, ctx:SqlParser.TryCatchStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#tryCatchStatement.
    def exitTryCatchStatement(self, ctx:SqlParser.TryCatchStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#ifStatement.
    def enterIfStatement(self, ctx:SqlParser.IfStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#ifStatement.
    def exitIfStatement(self, ctx:SqlParser.IfStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#declareStatement.
    def enterDeclareStatement(self, ctx:SqlParser.DeclareStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#declareStatement.
    def exitDeclareStatement(self, ctx:SqlParser.DeclareStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#setStatement.
    def enterSetStatement(self, ctx:SqlParser.SetStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#setStatement.
    def exitSetStatement(self, ctx:SqlParser.SetStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#havingClause.
    def enterHavingClause(self, ctx:SqlParser.HavingClauseContext):
        pass

    # Exit a parse tree produced by SqlParser#havingClause.
    def exitHavingClause(self, ctx:SqlParser.HavingClauseContext):
        pass


    # Enter a parse tree produced by SqlParser#useDatabaseStatement.
    def enterUseDatabaseStatement(self, ctx:SqlParser.UseDatabaseStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#useDatabaseStatement.
    def exitUseDatabaseStatement(self, ctx:SqlParser.UseDatabaseStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#truncateTableStatement.
    def enterTruncateTableStatement(self, ctx:SqlParser.TruncateTableStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#truncateTableStatement.
    def exitTruncateTableStatement(self, ctx:SqlParser.TruncateTableStatementContext):
        pass



del SqlParser