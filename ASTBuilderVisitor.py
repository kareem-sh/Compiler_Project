# ASTBuilderVisitor.py

from SqlParserVisitor import SqlParserVisitor
from ast_nodes.CreateTableNode import CreateTableNode
from ast_nodes.ColumnNode import ColumnNode
from ast_nodes.SelectNode import SelectNode
from ast_nodes.WhereNode import WhereNode
from ast_nodes.AlterTableNode import AlterTableNode
from ast_nodes.AlterTableNode import UpdateNode
from ast_nodes.AlterTableNode import DeclareNode
from ast_nodes.AlterTableNode import IfNode
from ast_nodes.AlterTableNode import BlockNode


class ASTBuilderVisitor(SqlParserVisitor):

    # ----------------------
    # Entry point: SQL file
    # ----------------------
    def visitSqlFile(self, ctx):
        statements = []
        for stmt in ctx.sqlStatement():
            node = self.visit(stmt)
            if node:
                statements.append(node)
        return statements

    # ----------------------
    # Single SQL statement
    # ----------------------
    def visitSqlStatement(self, ctx):
        if ctx.ddlStatement():
            return self.visit(ctx.ddlStatement())
        if ctx.dmlStatement():
            return self.visit(ctx.dmlStatement())
        if ctx.cursorStatement():
            return self.visit(ctx.cursorStatement())
        if ctx.ifStatement():
            return self.visit(ctx.ifStatement())
        if ctx.beginEndBlock():
            return self.visit(ctx.beginEndBlock())
        return None

    # ----------------------
    # CREATE TABLE
    # ----------------------
    def visitCreateTableStatement(self, ctx):
        table_name = ctx.tableName().getText()
        columns = [self.visit(col_ctx) for col_ctx in ctx.columnDefinition()]
        return CreateTableNode(table_name, columns)

    def visitColumnDefinition(self, ctx):
        name = ctx.columnName().getText()
        datatype = ctx.dataType().getText() if ctx.dataType() else None
        return ColumnNode(name, datatype)

    # ----------------------
    # SELECT statement
    # ----------------------
    def visitSelectStatement(self, ctx):
        columns = [self.visit(elem) for elem in ctx.selectList(
        ).selectElement()] if ctx.selectList() else []
        table = ctx.tableSource().getText() if ctx.tableSource() else None

        where = self.visit(ctx.whereClause()) if ctx.whereClause() else None

        order_by = []
        if ctx.orderByClause():
            for order_elem in ctx.orderByClause().orderElement():
                col = order_elem.columnName().getText()
                direction = order_elem.ASC().getText() if order_elem.ASC() else \
                    order_elem.DESC().getText() if order_elem.DESC() else "ASC"
                order_by.append((col, direction))

        return SelectNode(columns, table, where, order_by or None)

    # ----------------------
    # SELECT element
    # ----------------------
    def visitSelectElement(self, ctx):
        # Get the main column name
        col_name = ctx.columnName().getText()
        alias = None

    # Try explicit alias (ctx.alias may exist in your grammar)
        if hasattr(ctx, "alias") and ctx.alias():
            alias_node = ctx.alias()
            if hasattr(alias_node, "getText"):
                alias = alias_node.getText()
    # Fallback: find IDENTIFIER tokens (ignore "AS")
        elif hasattr(ctx, "IDENTIFIER") and ctx.IDENTIFIER():
            idents = ctx.IDENTIFIER()
            # Ensure it's always a list
            if not isinstance(idents, list):
                idents = [idents]
            for ident in reversed(idents):
                name = ident.getText()
                if name.lower() != "as":
                    alias = name
                    break

        return f"{col_name} AS {alias}" if alias else col_name

    # ----------------------
    # WHERE clause
    # ----------------------

    def visitWhereClause(self, ctx):
        if not ctx.searchCondition():
            return None

        predicate = ctx.searchCondition().predicate()
        left = predicate.expression(0).getText(
        ) if predicate.expression(0) else predicate.getText()
        operator = None
        if predicate.comparisonOperator():
            operator = predicate.comparisonOperator().getText()
        elif predicate.LIKE():
            operator = "LIKE"
        right = predicate.expression(1).getText(
        ) if predicate.expression(1) else None
        return WhereNode(left, operator, right)

    # ----------------------
    # ALTER TABLE
    # ----------------------
    def visitAlterTableStatement(self, ctx):
        table = ctx.tableName().getText()
        columns_ctx = ctx.alterAction().columnDefinition()
        columns = [self.visit(c) for c in (columns_ctx if isinstance(
            columns_ctx, list) else [columns_ctx])] if columns_ctx else []
        return AlterTableNode(table, columns)

    # ----------------------
    # UPDATE
    # ----------------------
    def visitUpdateStatement(self, ctx):
        table = ctx.tableName().getText()
        assignments = [(a.columnName().getText(), a.expression().getText())
                       for a in ctx.assignment()]
        where = self.visit(ctx.whereClause()) if ctx.whereClause() else None
        return UpdateNode(table, assignments, where)

    # ----------------------
    # DECLARE variable / cursor
    # ----------------------

    # ----------------------
    # IF / ELSE
    # ----------------------
    def visitIfStatement(self, ctx):
        condition = ctx.booleanExpression().getText(
        ) if ctx.booleanExpression() else "UNKNOWN"
        then_block = [self.visit(s) for s in ctx.sqlStatement()]
        else_block = [self.visit(s) for s in ctx.elseBlock(
        ).sqlStatement()] if ctx.elseBlock() else []
        return IfNode(condition, then_block, else_block)

    # ----------------------
    # BEGIN / END blocks
    # ----------------------
    def visitBeginEndBlock(self, ctx):
        statements = [self.visit(s) for s in ctx.sqlStatement()]
        return BlockNode(statements)


def visitDeclareCursor(self, ctx):
    """
    Visit DECLARE statements (variables / cursors).
    Works for @USER_VAR, IDENTIFIER, BRACKET_IDENTIFIER
    """
    # Try USER_VAR
    if hasattr(ctx, "USER_VAR") and ctx.USER_VAR():
        name = ctx.USER_VAR().getText()
    # Try IDENTIFIER
    elif hasattr(ctx, "IDENTIFIER") and ctx.IDENTIFIER():
        # ctx.IDENTIFIER() returns list-like if called without args
        idents = ctx.IDENTIFIER()
        # ensure it's a list
        if not isinstance(idents, list):
            idents = [idents]
        name = idents[0].getText()  # first identifier
    # Try BRACKET_IDENTIFIER
    elif hasattr(ctx, "BRACKET_IDENTIFIER") and ctx.BRACKET_IDENTIFIER():
        braces = ctx.BRACKET_IDENTIFIER()
        if not isinstance(braces, list):
            braces = [braces]
        name = braces[0].getText()
    else:
        # fallback
        name = ctx.getText()

    # datatype may not exist (like for cursors)
    datatype = ctx.dataType().getText() if hasattr(
        ctx, "dataType") and ctx.dataType() else None

    return DeclareNode(name, datatype)
