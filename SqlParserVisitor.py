# Generated from SqlParser.g4 by ANTLR 4.7.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .SqlParser import SqlParser
else:
    from SqlParser import SqlParser

# This class defines a complete generic visitor for a parse tree produced by SqlParser.

class SqlParserVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by SqlParser#sqlFile.
    def visitSqlFile(self, ctx:SqlParser.SqlFileContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#sqlStatement.
    def visitSqlStatement(self, ctx:SqlParser.SqlStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#cteStatement.
    def visitCteStatement(self, ctx:SqlParser.CteStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#cteDefinition.
    def visitCteDefinition(self, ctx:SqlParser.CteDefinitionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#dmlStatement.
    def visitDmlStatement(self, ctx:SqlParser.DmlStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#selectStatement.
    def visitSelectStatement(self, ctx:SqlParser.SelectStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#selectList.
    def visitSelectList(self, ctx:SqlParser.SelectListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#selectElement.
    def visitSelectElement(self, ctx:SqlParser.SelectElementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#tableSource.
    def visitTableSource(self, ctx:SqlParser.TableSourceContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#tableName.
    def visitTableName(self, ctx:SqlParser.TableNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#joinClause.
    def visitJoinClause(self, ctx:SqlParser.JoinClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#joinType.
    def visitJoinType(self, ctx:SqlParser.JoinTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#columnName.
    def visitColumnName(self, ctx:SqlParser.ColumnNameContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#whereClause.
    def visitWhereClause(self, ctx:SqlParser.WhereClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#groupByClause.
    def visitGroupByClause(self, ctx:SqlParser.GroupByClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#orderByClause.
    def visitOrderByClause(self, ctx:SqlParser.OrderByClauseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#orderElement.
    def visitOrderElement(self, ctx:SqlParser.OrderElementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#searchCondition.
    def visitSearchCondition(self, ctx:SqlParser.SearchConditionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#predicate.
    def visitPredicate(self, ctx:SqlParser.PredicateContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#comparisonOperator.
    def visitComparisonOperator(self, ctx:SqlParser.ComparisonOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#expression.
    def visitExpression(self, ctx:SqlParser.ExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#literal.
    def visitLiteral(self, ctx:SqlParser.LiteralContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#insertStatement.
    def visitInsertStatement(self, ctx:SqlParser.InsertStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#updateStatement.
    def visitUpdateStatement(self, ctx:SqlParser.UpdateStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#assignment.
    def visitAssignment(self, ctx:SqlParser.AssignmentContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#deleteStatement.
    def visitDeleteStatement(self, ctx:SqlParser.DeleteStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#ddlStatement.
    def visitDdlStatement(self, ctx:SqlParser.DdlStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#createTableStatement.
    def visitCreateTableStatement(self, ctx:SqlParser.CreateTableStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#columnDefinition.
    def visitColumnDefinition(self, ctx:SqlParser.ColumnDefinitionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#dataType.
    def visitDataType(self, ctx:SqlParser.DataTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#dropTableStatement.
    def visitDropTableStatement(self, ctx:SqlParser.DropTableStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#alterTableStatement.
    def visitAlterTableStatement(self, ctx:SqlParser.AlterTableStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#alterAction.
    def visitAlterAction(self, ctx:SqlParser.AlterActionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#cursorStatement.
    def visitCursorStatement(self, ctx:SqlParser.CursorStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#declareCursor.
    def visitDeclareCursor(self, ctx:SqlParser.DeclareCursorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#openCursor.
    def visitOpenCursor(self, ctx:SqlParser.OpenCursorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#fetchCursor.
    def visitFetchCursor(self, ctx:SqlParser.FetchCursorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by SqlParser#closeCursor.
    def visitCloseCursor(self, ctx:SqlParser.CloseCursorContext):
        return self.visitChildren(ctx)



del SqlParser