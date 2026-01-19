// Generated from c:/Users/salah/Programming_Tests/Java/Compilrt_Project/SqlParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlParser}.
 */
public interface SqlParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlFile}.
	 * @param ctx the parse tree
	 */
	void enterSqlFile(SqlParser.SqlFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlFile}.
	 * @param ctx the parse tree
	 */
	void exitSqlFile(SqlParser.SqlFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void enterSqlStatement(SqlParser.SqlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void exitSqlStatement(SqlParser.SqlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#cteStatement}.
	 * @param ctx the parse tree
	 */
	void enterCteStatement(SqlParser.CteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#cteStatement}.
	 * @param ctx the parse tree
	 */
	void exitCteStatement(SqlParser.CteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#cteDefinition}.
	 * @param ctx the parse tree
	 */
	void enterCteDefinition(SqlParser.CteDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#cteDefinition}.
	 * @param ctx the parse tree
	 */
	void exitCteDefinition(SqlParser.CteDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#dmlStatement}.
	 * @param ctx the parse tree
	 */
	void enterDmlStatement(SqlParser.DmlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#dmlStatement}.
	 * @param ctx the parse tree
	 */
	void exitDmlStatement(SqlParser.DmlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatement(SqlParser.SelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatement(SqlParser.SelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#selectList}.
	 * @param ctx the parse tree
	 */
	void enterSelectList(SqlParser.SelectListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#selectList}.
	 * @param ctx the parse tree
	 */
	void exitSelectList(SqlParser.SelectListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void enterSelectElement(SqlParser.SelectElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void exitSelectElement(SqlParser.SelectElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#tableSource}.
	 * @param ctx the parse tree
	 */
	void enterTableSource(SqlParser.TableSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#tableSource}.
	 * @param ctx the parse tree
	 */
	void exitTableSource(SqlParser.TableSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(SqlParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(SqlParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void enterJoinClause(SqlParser.JoinClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void exitJoinClause(SqlParser.JoinClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#joinType}.
	 * @param ctx the parse tree
	 */
	void enterJoinType(SqlParser.JoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#joinType}.
	 * @param ctx the parse tree
	 */
	void exitJoinType(SqlParser.JoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(SqlParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(SqlParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(SqlParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(SqlParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupByClause(SqlParser.GroupByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupByClause(SqlParser.GroupByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderByClause(SqlParser.OrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderByClause(SqlParser.OrderByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#orderElement}.
	 * @param ctx the parse tree
	 */
	void enterOrderElement(SqlParser.OrderElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#orderElement}.
	 * @param ctx the parse tree
	 */
	void exitOrderElement(SqlParser.OrderElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#searchCondition}.
	 * @param ctx the parse tree
	 */
	void enterSearchCondition(SqlParser.SearchConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#searchCondition}.
	 * @param ctx the parse tree
	 */
	void exitSearchCondition(SqlParser.SearchConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(SqlParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(SqlParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(SqlParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(SqlParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(SqlParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(SqlParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(SqlParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(SqlParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(SqlParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(SqlParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SqlParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SqlParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(SqlParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(SqlParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(SqlParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(SqlParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(SqlParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(SqlParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(SqlParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(SqlParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(SqlParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(SqlParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#caseExpression}.
	 * @param ctx the parse tree
	 */
	void enterCaseExpression(SqlParser.CaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#caseExpression}.
	 * @param ctx the parse tree
	 */
	void exitCaseExpression(SqlParser.CaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#whenClause}.
	 * @param ctx the parse tree
	 */
	void enterWhenClause(SqlParser.WhenClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#whenClause}.
	 * @param ctx the parse tree
	 */
	void exitWhenClause(SqlParser.WhenClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SqlParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SqlParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SqlParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SqlParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void enterInsertStatement(SqlParser.InsertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void exitInsertStatement(SqlParser.InsertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void enterUpdateStatement(SqlParser.UpdateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void exitUpdateStatement(SqlParser.UpdateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SqlParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SqlParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeleteStatement(SqlParser.DeleteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeleteStatement(SqlParser.DeleteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#ddlStatement}.
	 * @param ctx the parse tree
	 */
	void enterDdlStatement(SqlParser.DdlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#ddlStatement}.
	 * @param ctx the parse tree
	 */
	void exitDdlStatement(SqlParser.DdlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#createTableStatement}.
	 * @param ctx the parse tree
	 */
	void enterCreateTableStatement(SqlParser.CreateTableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#createTableStatement}.
	 * @param ctx the parse tree
	 */
	void exitCreateTableStatement(SqlParser.CreateTableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#columnDefinition}.
	 * @param ctx the parse tree
	 */
	void enterColumnDefinition(SqlParser.ColumnDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#columnDefinition}.
	 * @param ctx the parse tree
	 */
	void exitColumnDefinition(SqlParser.ColumnDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#columnOptions}.
	 * @param ctx the parse tree
	 */
	void enterColumnOptions(SqlParser.ColumnOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#columnOptions}.
	 * @param ctx the parse tree
	 */
	void exitColumnOptions(SqlParser.ColumnOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(SqlParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(SqlParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#typeParams}.
	 * @param ctx the parse tree
	 */
	void enterTypeParams(SqlParser.TypeParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#typeParams}.
	 * @param ctx the parse tree
	 */
	void exitTypeParams(SqlParser.TypeParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#dropTableStatement}.
	 * @param ctx the parse tree
	 */
	void enterDropTableStatement(SqlParser.DropTableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#dropTableStatement}.
	 * @param ctx the parse tree
	 */
	void exitDropTableStatement(SqlParser.DropTableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#alterTableStatement}.
	 * @param ctx the parse tree
	 */
	void enterAlterTableStatement(SqlParser.AlterTableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#alterTableStatement}.
	 * @param ctx the parse tree
	 */
	void exitAlterTableStatement(SqlParser.AlterTableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#alterAction}.
	 * @param ctx the parse tree
	 */
	void enterAlterAction(SqlParser.AlterActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#alterAction}.
	 * @param ctx the parse tree
	 */
	void exitAlterAction(SqlParser.AlterActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#cursorStatement}.
	 * @param ctx the parse tree
	 */
	void enterCursorStatement(SqlParser.CursorStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#cursorStatement}.
	 * @param ctx the parse tree
	 */
	void exitCursorStatement(SqlParser.CursorStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#declareCursor}.
	 * @param ctx the parse tree
	 */
	void enterDeclareCursor(SqlParser.DeclareCursorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#declareCursor}.
	 * @param ctx the parse tree
	 */
	void exitDeclareCursor(SqlParser.DeclareCursorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#openCursor}.
	 * @param ctx the parse tree
	 */
	void enterOpenCursor(SqlParser.OpenCursorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#openCursor}.
	 * @param ctx the parse tree
	 */
	void exitOpenCursor(SqlParser.OpenCursorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#fetchCursor}.
	 * @param ctx the parse tree
	 */
	void enterFetchCursor(SqlParser.FetchCursorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#fetchCursor}.
	 * @param ctx the parse tree
	 */
	void exitFetchCursor(SqlParser.FetchCursorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#closeCursor}.
	 * @param ctx the parse tree
	 */
	void enterCloseCursor(SqlParser.CloseCursorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#closeCursor}.
	 * @param ctx the parse tree
	 */
	void exitCloseCursor(SqlParser.CloseCursorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(SqlParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(SqlParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#blockContent}.
	 * @param ctx the parse tree
	 */
	void enterBlockContent(SqlParser.BlockContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#blockContent}.
	 * @param ctx the parse tree
	 */
	void exitBlockContent(SqlParser.BlockContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#execStatement}.
	 * @param ctx the parse tree
	 */
	void enterExecStatement(SqlParser.ExecStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#execStatement}.
	 * @param ctx the parse tree
	 */
	void exitExecStatement(SqlParser.ExecStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#tryCatchStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryCatchStatement(SqlParser.TryCatchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#tryCatchStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryCatchStatement(SqlParser.TryCatchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SqlParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SqlParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#declareStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclareStatement(SqlParser.DeclareStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#declareStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclareStatement(SqlParser.DeclareStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void enterSetStatement(SqlParser.SetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void exitSetStatement(SqlParser.SetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void enterHavingClause(SqlParser.HavingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void exitHavingClause(SqlParser.HavingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#useDatabaseStatement}.
	 * @param ctx the parse tree
	 */
	void enterUseDatabaseStatement(SqlParser.UseDatabaseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#useDatabaseStatement}.
	 * @param ctx the parse tree
	 */
	void exitUseDatabaseStatement(SqlParser.UseDatabaseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#truncateTableStatement}.
	 * @param ctx the parse tree
	 */
	void enterTruncateTableStatement(SqlParser.TruncateTableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#truncateTableStatement}.
	 * @param ctx the parse tree
	 */
	void exitTruncateTableStatement(SqlParser.TruncateTableStatementContext ctx);
}