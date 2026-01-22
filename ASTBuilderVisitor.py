from SqlParserVisitor import SqlParserVisitor
from ast_nodes import *


class ASTBuilder(SqlParserVisitor):

    def visitSqlFile(self, ctx):
        stmts = []
        for stmt in ctx.sqlStatement():
            result = self.visit(stmt)
            if result is not None:
                stmts.append(result)
        return SqlFile(stmts)

    def visitSqlStatement(self, ctx):
        if ctx.tryCatchStatement():
            return self.visit(ctx.tryCatchStatement())
        if ctx.dmlStatement():
            return self.visit(ctx.dmlStatement())
        if ctx.ddlStatement():
            return self.visit(ctx.ddlStatement())
        if ctx.ifStatement():
            return self.visit(ctx.ifStatement())
        if ctx.blockStatement():
            return self.visit(ctx.blockStatement())
        if ctx.execStatement():
            return self.visit(ctx.execStatement())
        if ctx.cursorStatement():
            return self.visit(ctx.cursorStatement())
        return None

    # CONTROL FLOW
    def visitTryCatchStatement(self, ctx):
        try_block = []
        catch_block = []
        contents = ctx.blockContent()
        children = list(ctx.children)
        end_try_index = -1
        begin_catch_index = -1

        for i, child in enumerate(children):
            text = child.getText() if hasattr(child, 'getText') else str(child)
            if text.upper() == 'END' and i+1 < len(children):
                next_text = children[i+1].getText() if hasattr(children[i+1], 'getText') else str(children[i+1])
                if next_text.upper() == 'TRY':
                    end_try_index = i
            elif text.upper() == 'BEGIN' and i+1 < len(children):
                next_text = children[i+1].getText() if hasattr(children[i+1], 'getText') else str(children[i+1])
                if next_text.upper() == 'CATCH':
                    begin_catch_index = i

        if end_try_index != -1 and begin_catch_index != -1:
            for i, content in enumerate(contents):
                if i < len(contents) // 2:
                    result = self.visit(content)
                    if result:
                        try_block.append(result)
                else:
                    result = self.visit(content)
                    if result:
                        catch_block.append(result)
        else:
            mid = len(contents) // 2
            for i in range(mid):
                result = self.visit(contents[i])
                if result:
                    try_block.append(result)
            for i in range(mid, len(contents)):
                result = self.visit(contents[i])
                if result:
                    catch_block.append(result)

        return TryCatchStatement(try_block, catch_block)

    def visitIfStatement(self, ctx):
        condition = self.visit(ctx.searchCondition())
        true_block = Block([self.visit(ctx.sqlStatement(0))])
        false_block = None
        if ctx.ELSE():
            false_block = Block([self.visit(ctx.sqlStatement(1))])
        return IfStatement(condition, true_block, false_block)

    def visitBlockStatement(self, ctx):
        statements = []
        for content in ctx.blockContent():
            result = self.visit(content)
            if result:
                statements.append(result)
        return Block(statements)

    def visitBlockContent(self, ctx):
        if ctx.sqlStatement():
            return self.visit(ctx.sqlStatement())
        return None

    # DML STATEMENTS
    def visitDmlStatement(self, ctx):
        if ctx.selectStatement():
            return self.visit(ctx.selectStatement())
        if ctx.insertStatement():
            return self.visit(ctx.insertStatement())
        if ctx.updateStatement():
            return self.visit(ctx.updateStatement())
        if ctx.deleteStatement():
            return self.visit(ctx.deleteStatement())
        if ctx.setStatement():
            return self.visit(ctx.setStatement())
        return None

    def visitDdlStatement(self, ctx):
        if ctx.declareStatement():
            return self.visit(ctx.declareStatement())
        if ctx.createTableStatement():
            return self.visit(ctx.createTableStatement())
        if ctx.dropTableStatement():
            return self.visit(ctx.dropTableStatement())
        if ctx.alterTableStatement():
            return self.visit(ctx.alterTableStatement())
        if ctx.useDatabaseStatement():
            return self.visit(ctx.useDatabaseStatement())
        if ctx.truncateTableStatement():
            return self.visit(ctx.truncateTableStatement())
        return None


    # SELECT STATEMENT
    def visitSelectStatement(self, ctx):
        columns = self.visit(ctx.selectList())

        from_clause = None
        if ctx.tableSource():
            # Create a FromClause with the table source
            table_source = self.visit(ctx.tableSource())
            from_clause = FromClause([table_source])

        joins = []
        for join_ctx in ctx.joinClause():
            join = self.visit(join_ctx)
            if join:
                joins.append(join)

        where = None
        if ctx.whereClause():
            where = self.visit(ctx.whereClause())

        group_by = None
        if ctx.groupByClause():
            group_by = self.visit(ctx.groupByClause())

        having = None
        if ctx.havingClause():
            having = self.visit(ctx.havingClause())

        order_by = None
        if ctx.orderByClause():
            order_by = self.visit(ctx.orderByClause())

        return SelectStatement(
            columns=columns,
            from_clause=from_clause,
            where=where,
            joins=joins,
            group_by=group_by,
            having=having,
            order_by=order_by,
            distinct=False,
            top=None
        )

    def visitSelectList(self, ctx):
        if ctx.STAR():
            return [SelectColumn(Column("*"))]
        else:
            return [self.visit(e) for e in ctx.selectElement()]

    def visitSelectElement(self, ctx):
        expression = self.visit(ctx.expression())
        alias = None

        if ctx.IDENTIFIER():
            alias = ctx.IDENTIFIER().getText()
        elif ctx.STRING_LITERAL():
            alias_text = ctx.STRING_LITERAL().getText()
            if alias_text.startswith("'") and alias_text.endswith("'"):
                alias = alias_text[1:-1]

        return SelectColumn(expression, alias)

    # FROM CLAUSE & JOINS
    def visitTableSource(self, ctx):
        table_name = ctx.tableName().getText()
        alias = None
        if ctx.IDENTIFIER():
            alias = ctx.IDENTIFIER().getText()
        return TableSource(table_name, alias)

    def visitJoinClause(self, ctx):
        join_type = "INNER"
        if ctx.joinType():
            if ctx.joinType().LEFT():
                join_type = "LEFT"
            elif ctx.joinType().RIGHT():
                join_type = "RIGHT"
            elif ctx.joinType().FULL():
                join_type = "FULL"

        table_source = self.visit(ctx.tableSource())
        condition = self.visit(ctx.searchCondition())

        return Join(join_type, table_source, condition)

    # WHERE, GROUP BY, HAVING, ORDER BY
    def visitWhereClause(self, ctx):
        condition = self.visit(ctx.searchCondition())
        return WhereClause(condition)

    def visitGroupByClause(self, ctx):
        columns = [self.visit(col) for col in ctx.columnName()]
        return GroupByClause(columns)

    def visitHavingClause(self, ctx):
        condition = self.visit(ctx.searchCondition())
        return HavingClause(condition)

    def visitOrderByClause(self, ctx):
        order_elements = [self.visit(elem) for elem in ctx.orderElement()]
        return OrderByClause(order_elements)

    def visitOrderElement(self, ctx):
        column = self.visit(ctx.columnName())
        order = "ASC"
        if ctx.DESC():
            order = "DESC"
        elif ctx.ASC():
            order = "ASC"
        return OrderByElement(column, order)

    # PREDICATES & EXPRESSIONS
    def visitPredicate(self, ctx):
        # EXISTS
        if ctx.EXISTS():
            select_stmt = ctx.selectStatement()
            if select_stmt:
                subquery = self.visit(select_stmt)
                return ExistsExpression(subquery)

        if ctx.IS():
            exprs = ctx.expression()
            if exprs:
                expr = self.visit(exprs[0])
                not_null = ctx.NOT() is not None
                return IsNullExpression(expr, not_null)

        # IN
        if ctx.IN():
            exprs = ctx.expression()
            if exprs:
                expr = self.visit(exprs[0])
                select_stmt = ctx.selectStatement()
                if select_stmt:
                    subquery = self.visit(select_stmt)
                    return InExpression(expr, subquery, ctx.NOT() is not None)
                elif len(exprs) > 1:
                    options = [self.visit(e) for e in exprs[1:]]
                    return InExpression(expr, options, ctx.NOT() is not None)

        # BETWEEN
        if ctx.BETWEEN():
            exprs = ctx.expression()
            if len(exprs) >= 3:
                expr = self.visit(exprs[0])
                lower = self.visit(exprs[1])
                upper = self.visit(exprs[2])
                return BetweenExpression(expr, lower, upper, ctx.NOT() is not None)

        # LIKE
        if ctx.LIKE():
            exprs = ctx.expression()
            if len(exprs) >= 2:
                value = self.visit(exprs[0])
                pattern = self.visit(exprs[1])
                return LikeExpression(value, pattern, ctx.NOT() is not None)

        # Comparison operator
        if ctx.comparisonOperator():
            exprs = ctx.expression()
            if len(exprs) >= 2:
                left = self.visit(exprs[0])
                right = self.visit(exprs[1])
                op = ctx.comparisonOperator().getText()
                return BinaryExpression(left, op, right)

        # Parenthesized condition
        if ctx.LPAREN() and ctx.searchCondition():
            return self.visit(ctx.searchCondition())

        exprs = ctx.expression()
        if exprs:
            return self.visit(exprs[0])

        return None

    def visitSearchCondition(self, ctx):
        return self.visit(ctx.orExpression())

    def visitOrExpression(self, ctx):
        if ctx.OR():
            left = self.visit(ctx.orExpression())
            right = self.visit(ctx.andExpression())
            return BinaryExpression(left, "OR", right)
        return self.visit(ctx.andExpression())

    def visitAndExpression(self, ctx):
        if ctx.AND():
            left = self.visit(ctx.andExpression())
            right = self.visit(ctx.notExpression())
            return BinaryExpression(left, "AND", right)
        return self.visit(ctx.notExpression())

    def visitNotExpression(self, ctx):
        if ctx.NOT():
            expr = self.visit(ctx.notExpression())
            return UnaryExpression("NOT", expr)
        return self.visit(ctx.predicate())

    # EXPRESSIONS
    def visitExpression(self, ctx):
        return self.visit(ctx.getChild(0))

    def visitAssignmentExpression(self, ctx):
        if ctx.USER_VAR():
            var = Variable(ctx.USER_VAR().getText())
            value = self.visit(ctx.additiveExpression())
            op = ctx.EQ().getText() if ctx.EQ() else ctx.PLUS_EQ().getText()
            return BinaryExpression(var, op, value)
        return self.visit(ctx.additiveExpression())

    def visitAdditiveExpression(self, ctx):
        if ctx.getChildCount() > 1:
            left = self.visit(ctx.additiveExpression())
            right = self.visit(ctx.multiplicativeExpression())
            op = ctx.PLUS().getText() if ctx.PLUS() else ctx.MINUS().getText()
            return BinaryExpression(left, op, right)
        return self.visit(ctx.multiplicativeExpression())

    def visitMultiplicativeExpression(self, ctx):
        if ctx.getChildCount() > 1:
            left = self.visit(ctx.multiplicativeExpression())
            right = self.visit(ctx.unaryExpression())
            op = ctx.STAR().getText() if ctx.STAR() else ctx.SLASH().getText()
            return BinaryExpression(left, op, right)
        return self.visit(ctx.unaryExpression())

    def visitUnaryExpression(self, ctx):
        if ctx.PLUS() or ctx.MINUS():
            expr = self.visit(ctx.unaryExpression())
            op = ctx.PLUS().getText() if ctx.PLUS() else ctx.MINUS().getText()
            return UnaryExpression(op, expr)
        return self.visit(ctx.primaryExpression())

    def visitPrimaryExpression(self, ctx):
        if ctx.literal():
            return self.visit(ctx.literal())
        if ctx.columnName():
            return self.visit(ctx.columnName())
        if ctx.functionCall():
            return self.visit(ctx.functionCall())
        if ctx.caseExpression():
            return self.visit(ctx.caseExpression())
        if ctx.USER_VAR():
            return Variable(ctx.USER_VAR().getText())
        if ctx.selectStatement():
            return self.visit(ctx.selectStatement())
        return self.visitChildren(ctx)

    def visitCaseExpression(self, ctx):
        whens = []
        for w in ctx.whenClause():
            cond = self.visit(w.searchCondition())
            expr = self.visit(w.expression())
            whens.append((cond, expr))

        else_expr = None
        if ctx.ELSE():
            exprs = ctx.expression()
            if exprs:
                if not isinstance(exprs, list):
                    else_expr = self.visit(exprs)
                else:
                    else_expr = self.visit(exprs[-1])

        return CaseExpression(whens, else_expr)

    def visitFunctionCall(self, ctx):
        name = ctx.functionName().getText()
        args = []

        if ctx.expression():
            args = [self.visit(e) for e in ctx.expression()]

        return FunctionCall(name, args)


    # INSERT, UPDATE, DELETE
    def visitInsertStatement(self, ctx):
        table = ctx.tableName().getText()

        columns = None
        if ctx.columnName():
            columns = [c.getText() for c in ctx.columnName()]

        if ctx.VALUES():
            values_list = []
            expr_lists = ctx.expression()
            if expr_lists:
                values_list = [self.visit(v) for v in expr_lists]
            return InsertStatement(table, columns, values_list, None)
        else:
            # SELECT case
            select_stmt = None
            if ctx.selectStatement():
                select_stmt = self.visit(ctx.selectStatement())
            return InsertStatement(table, columns, None, select_stmt)

    def visitUpdateStatement(self, ctx):
        table = ctx.tableName().getText()
        assignments = [self.visit(a) for a in ctx.assignment()]

        where = None
        if ctx.whereClause():
            where = self.visit(ctx.whereClause())

        return UpdateStatement(table, assignments, None, where)

    def visitDeleteStatement(self, ctx):
        table = ctx.tableName().getText()

        where = None
        if ctx.whereClause():
            where = self.visit(ctx.whereClause())

        return DeleteStatement(table, where)

    def visitAssignment(self, ctx):
        column = self.visit(ctx.columnName())
        value = self.visit(ctx.expression())
        op = ctx.EQ().getText() if ctx.EQ() else ctx.PLUS_EQ().getText()
        return Assignment(column, value, op)

    def visitCreateTableStatement(self, ctx):
        table = ctx.tableName().getText()
        columns = []
        constraints = []

        for elem in ctx.tableElement():
            if elem.columnDefinition():
                columns.append(self.visit(elem.columnDefinition()))
            elif elem.tableConstraint():
                constraints.append(self.visit(elem.tableConstraint()))

        return CreateTableStatement(table, columns, constraints)

    def visitColumnDefinition(self, ctx):
        name = ctx.columnName().getText()
        data_type = ctx.dataType().getText()

        options = []
        for opt in ctx.columnOptions():
            options.append(opt.getText())

        return ColumnDefinition(name, data_type, options)

    def visitTableConstraint(self, ctx):
        name = ctx.IDENTIFIER().getText() if ctx.IDENTIFIER() else None
        constraint_def = self.visit(ctx.constraintDefinition())
        return Constraint(
            name=name,
            constraint_type=constraint_def.constraint_type,
            columns=constraint_def.columns,
            references_table=constraint_def.references_table,
            references_columns=constraint_def.references_columns,
            check_condition=constraint_def.check_condition
        )

    def visitConstraintDefinition(self, ctx):
        if ctx.primaryKeyConstraint():
            return self.visit(ctx.primaryKeyConstraint())
        elif ctx.foreignKeyConstraint():
            return self.visit(ctx.foreignKeyConstraint())
        elif ctx.uniqueConstraint():
            return self.visit(ctx.uniqueConstraint())
        elif ctx.checkConstraint():
            return self.visit(ctx.checkConstraint())
        return None

    def visitPrimaryKeyConstraint(self, ctx):
        columns = [col.getText() for col in ctx.columnName()]
        class TempConstraint:
            def __init__(self):
                self.constraint_type = "PRIMARY KEY"
                self.columns = columns
                self.references_table = None
                self.references_columns = None
                self.check_condition = None
        return TempConstraint()

    def visitForeignKeyConstraint(self, ctx):
        all_columns = [col.getText() for col in ctx.columnName()]
        mid = len(all_columns) // 2
        columns = all_columns[:mid]
        ref_columns = all_columns[mid:]
        ref_table = ctx.tableName().getText()

        class TempConstraint:
            def __init__(self):
                self.constraint_type = "FOREIGN KEY"
                self.columns = columns
                self.references_table = ref_table
                self.references_columns = ref_columns
                self.check_condition = None
        return TempConstraint()

    def visitUniqueConstraint(self, ctx):
        columns = [col.getText() for col in ctx.columnName()]
        class TempConstraint:
            def __init__(self):
                self.constraint_type = "UNIQUE"
                self.columns = columns
                self.references_table = None
                self.references_columns = None
                self.check_condition = None
        return TempConstraint()

    def visitCheckConstraint(self, ctx):
        condition = self.visit(ctx.searchCondition())
        class TempConstraint:
            def __init__(self):
                self.constraint_type = "CHECK"
                self.columns = []
                self.references_table = None
                self.references_columns = None
                self.check_condition = condition
        return TempConstraint()

    def visitDropTableStatement(self, ctx):
        table = ctx.tableName().getText()
        return DropTableStatement(table)

    def visitAlterTableStatement(self, ctx):
        table = ctx.tableName().getText()
        action = self.visit(ctx.alterAction())
        return AlterTableStatement(table, action)

    def visitAlterAction(self, ctx):
        if ctx.ADD():
            column = self.visit(ctx.columnDefinition())
            return AlterAction("ADD", column=column)
        elif ctx.DROP():
            column_name = ctx.columnName().getText()
            return AlterAction("DROP", column=ColumnDefinition(column_name, None))
        return None

    # VARIABLES & SET
    def visitDeclareStatement(self, ctx):
        user_vars = ctx.USER_VAR()
        data_types = ctx.dataType()
        expressions = ctx.expression()

        declarations = []

        for i in range(len(user_vars)):
            var_name = user_vars[i].getText()
            data_type = data_types[i].getText()
            value = None
            if expressions and i < len(expressions):
                value = self.visit(expressions[i])

            declarations.append(
                DeclareStatement(Variable(var_name), data_type, value)
            )

        if len(declarations) == 1:
            return declarations[0]
        return Block(declarations)

    def visitSetStatement(self, ctx):
        variables = ctx.USER_VAR()
        expressions = ctx.expression()

        if len(variables) == 1:
            variable = Variable(variables[0].getText())
            value = self.visit(expressions[0])

            eq_tokens = ctx.EQ()
            plus_eq_tokens = ctx.PLUS_EQ()

            op = "="
            if eq_tokens:
                if isinstance(eq_tokens, list) and len(eq_tokens) > 0:
                    op = eq_tokens[0].getText()
                else:
                    op = eq_tokens.getText()
            elif plus_eq_tokens:
                if isinstance(plus_eq_tokens, list) and len(plus_eq_tokens) > 0:
                    op = plus_eq_tokens[0].getText()
                else:
                    op = plus_eq_tokens.getText()

            return SetStatement(variable, value, op)
        else:
            statements = []
            for var, expr in zip(variables, expressions):
                variable = Variable(var.getText())
                value = self.visit(expr)
                statements.append(SetStatement(variable, value))
            return Block(statements)

    # OTHER STATEMENTS
    def visitUseDatabaseStatement(self, ctx):
        database_name = ctx.IDENTIFIER().getText()
        return UseDatabaseStatement(database_name)

    def visitTruncateTableStatement(self, ctx):
        table = ctx.tableName().getText()
        return TruncateTableStatement(table)

    def visitExecStatement(self, ctx):
        proc_name = ctx.IDENTIFIER().getText() if ctx.IDENTIFIER() else ctx.BRACKET_IDENTIFIER().getText()
        args = []
        if ctx.expression():
            args = [self.visit(e) for e in ctx.expression()]
        return ExecStatement(proc_name, args)

    # CURSOR STATEMENTS
    def visitCursorStatement(self, ctx):
        if ctx.declareCursor():
            return self.visit(ctx.declareCursor())
        if ctx.openCursor():
            return self.visit(ctx.openCursor())
        if ctx.fetchCursor():
            return self.visit(ctx.fetchCursor())
        if ctx.closeCursor():
            return self.visit(ctx.closeCursor())
        return None

    def visitDeclareCursor(self, ctx):
        cursor_name = ctx.IDENTIFIER().getText()
        select_stmt = self.visit(ctx.selectStatement())
        return DeclareCursor(cursor_name, select_stmt)

    def visitOpenCursor(self, ctx):
        cursor_name = ctx.IDENTIFIER().getText()
        return OpenCursor(cursor_name)

    def visitFetchCursor(self, ctx):
        cursor_name = ctx.IDENTIFIER().getText()
        return FetchCursor(cursor_name)

    def visitCloseCursor(self, ctx):
        cursor_name = ctx.IDENTIFIER().getText()
        return CloseCursor(cursor_name)


    # LEAVES
    def visitColumnName(self, ctx):
        text = ctx.getText()
        text = text.replace('[', '').replace(']', '')
        parts = text.split('.')

        if len(parts) == 2:
            table = parts[0]
            name = parts[1]
            return Column(name, table)
        else:
            return Column(text)

    def visitLiteral(self, ctx):
        text = ctx.getText()
        if ctx.INT_LITERAL():
            return Literal(int(text), "INT")
        elif ctx.FLOAT_LITERAL():
            return Literal(float(text), "FLOAT")
        elif ctx.STRING_LITERAL():
            if text.startswith("'") and text.endswith("'"):
                text = text[1:-1]
            return Literal(text, "STRING")
        elif ctx.TRUE_LITERAL():
            return Literal(True, "BOOL")
        elif ctx.FALSE_LITERAL():
            return Literal(False, "BOOL")
        elif ctx.NULL():
            return Literal(None, "NULL")
        return Literal(text)
