# ast_nodes.py

class ASTNode:
    def __str__(self):
        return self._str()

    def __repr__(self):
        return self._str()

    def _str(self, indent=0):
        pad = "  " * indent
        lines = [f"{pad}{self.__class__.__name__}"]

        for key, value in self.__dict__.items():
            if value is None:
                lines.append(f"{pad}  {key}: None")

            elif isinstance(value, ASTNode):
                lines.append(f"{pad}  {key}:")
                lines.append(value._str(indent + 2))

            elif isinstance(value, list):
                lines.append(f"{pad}  {key}:")
                if not value:
                    lines.append(f"{pad}    []")
                else:
                    for item in value:
                        if isinstance(item, ASTNode):
                            lines.append(item._str(indent + 2))
                        elif isinstance(item, tuple):
                            lines.append(f"{pad}    tuple:")
                            for t in item:
                                if isinstance(t, ASTNode):
                                    lines.append(t._str(indent + 3))
                                else:
                                    lines.append(f"{pad}      {t}")
                        else:
                            lines.append(f"{pad}    {item}")

            elif isinstance(value, tuple):
                lines.append(f"{pad}  {key}: tuple")
                for t in value:
                    if isinstance(t, ASTNode):
                        lines.append(t._str(indent + 2))
                    else:
                        lines.append(f"{pad}    {t}")

            else:
                lines.append(f"{pad}  {key}: {value}")

        return "\n".join(lines)



# SQL FILE & STATEMENTS
# ---------------------
class SqlFile(ASTNode):
    def __init__(self, statements):
        self.statements = statements



# SELECT STATEMENTS
# -----------------

class SelectStatement(ASTNode):
    def __init__(self, columns, from_clause=None, where=None, joins=None, group_by=None,
                 having=None, order_by=None, distinct=False, top=None):
        self.columns = columns
        self.from_clause = from_clause
        self.where = where
        self.joins = joins or []
        self.group_by = group_by
        self.having = having
        self.order_by = order_by
        self.distinct = distinct
        self.top = top


class SelectColumn(ASTNode):
    def __init__(self, expression, alias=None):
        self.expression = expression
        self.alias = alias


class FromClause(ASTNode):
    def __init__(self, tables):
        self.tables = tables


class TableSource(ASTNode):
    def __init__(self, table_name, alias=None, joins=None):
        self.table_name = table_name
        self.alias = alias
        self.joins = joins or []


class Join(ASTNode):
    def __init__(self, join_type, table_source, condition):
        self.join_type = join_type
        self.table_source = table_source
        self.condition = condition


class WhereClause(ASTNode):
    def __init__(self, condition):
        self.condition = condition


class GroupByClause(ASTNode):
    def __init__(self, expressions, having=None):
        self.expressions = expressions
        self.having = having


class HavingClause(ASTNode):
    def __init__(self, condition):
        self.condition = condition


class OrderByClause(ASTNode):
    def __init__(self, order_elements):
        self.order_elements = order_elements


class OrderByElement(ASTNode):
    def __init__(self, expression, order="ASC"):
        self.expression = expression
        self.order = order


class TopClause(ASTNode):
    def __init__(self, value, percent=False, with_ties=False):
        self.value = value
        self.percent = percent
        self.with_ties = with_ties



# DML STATEMENTS
# --------------

class InsertStatement(ASTNode):
    def __init__(self, table, columns=None, values=None, select=None):
        self.table = table
        self.columns = columns
        self.values = values
        self.select = select


class UpdateStatement(ASTNode):
    def __init__(self, table, assignments, from_clause=None, where=None):
        self.table = table
        self.assignments = assignments
        self.from_clause = from_clause
        self.where = where


class DeleteStatement(ASTNode):
    def __init__(self, table, where=None):
        self.table = table
        self.where = where


class Assignment(ASTNode):
    def __init__(self, column, value, operator="="):
        self.column = column
        self.value = value
        self.operator = operator



# DDL STATEMENTS
# --------------

class CreateTableStatement(ASTNode):
    def __init__(self, table, columns, constraints=None):
        self.table = table
        self.columns = columns
        self.constraints = constraints or []


class DropTableStatement(ASTNode):
    def __init__(self, table):
        self.table = table


class AlterTableStatement(ASTNode):
    def __init__(self, table, action):
        self.table = table
        self.action = action


class AlterAction(ASTNode):
    def __init__(self, action_type, column=None, constraint=None):
        self.action_type = action_type
        self.column = column
        self.constraint = constraint


class ColumnDefinition(ASTNode):
    def __init__(self, name, data_type, options=None, constraints=None):
        self.name = name
        self.data_type = data_type
        self.options = options or []
        self.constraints = constraints or []


class Constraint(ASTNode):
    def __init__(self, name, constraint_type, columns=None,
                 references_table=None, references_columns=None,
                 check_condition=None):
        self.name = name
        self.constraint_type = constraint_type
        self.columns = columns or []
        self.references_table = references_table
        self.references_columns = references_columns or []
        self.check_condition = check_condition



# CONTROL FLOW
# ------------

class TryCatchStatement(ASTNode):
    def __init__(self, try_block, catch_block):
        self.try_block = try_block
        self.catch_block = catch_block


class Block(ASTNode):
    def __init__(self, statements):
        self.statements = statements


class IfStatement(ASTNode):
    def __init__(self, condition, true_block, false_block=None):
        self.condition = condition
        self.true_block = true_block
        self.false_block = false_block



# EXPRESSIONS
# -----------

class Column(ASTNode):
    def __init__(self, name, table=None):
        self.name = name
        self.table = table


class Literal(ASTNode):
    def __init__(self, value, type=None):
        self.value = value
        self.type = type


class BinaryExpression(ASTNode):
    def __init__(self, left, operator, right):
        self.left = left
        self.operator = operator
        self.right = right


class UnaryExpression(ASTNode):
    def __init__(self, operator, expression):
        self.operator = operator
        self.expression = expression


class CaseExpression(ASTNode):
    def __init__(self, whens, else_expr=None):
        self.whens = whens
        self.else_expr = else_expr


class FunctionCall(ASTNode):
    def __init__(self, name, args, distinct=False):
        self.name = name
        self.args = args
        self.distinct = distinct


class ExistsExpression(ASTNode):
    def __init__(self, subquery):
        self.subquery = subquery


class InExpression(ASTNode):
    def __init__(self, value, options, not_in=False):
        self.value = value
        self.options = options
        self.not_in = not_in


class BetweenExpression(ASTNode):
    def __init__(self, value, lower, upper, not_between=False):
        self.value = value
        self.lower = lower
        self.upper = upper
        self.not_between = not_between


class LikeExpression(ASTNode):
    def __init__(self, value, pattern, not_like=False):
        self.value = value
        self.pattern = pattern
        self.not_like = not_like


class IsNullExpression(ASTNode):
    def __init__(self, expression, not_null=False):
        self.expression = expression
        self.not_null = not_null



# VARIABLES & DECLARATIONS
# ------------------------

class Variable(ASTNode):
    def __init__(self, name):
        self.name = name


class DeclareStatement(ASTNode):
    def __init__(self, variable, data_type, value=None):
        self.variable = variable
        self.data_type = data_type
        self.value = value


class SetStatement(ASTNode):
    def __init__(self, variable, value, operator="="):
        self.variable = variable
        self.value = value
        self.operator = operator


# OTHER STATEMENTS
# ----------------

class UseDatabaseStatement(ASTNode):
    def __init__(self, database_name):
        self.database_name = database_name


class TruncateTableStatement(ASTNode):
    def __init__(self, table):
        self.table = table


class ExecStatement(ASTNode):
    def __init__(self, procedure_name, args=None):
        self.procedure_name = procedure_name
        self.args = args or []



# CURSOR STATEMENTS
# -----------------

class DeclareCursor(ASTNode):
    def __init__(self, cursor_name, select_statement):
        self.cursor_name = cursor_name
        self.select_statement = select_statement


class OpenCursor(ASTNode):
    def __init__(self, cursor_name):
        self.cursor_name = cursor_name


class FetchCursor(ASTNode):
    def __init__(self, cursor_name, into_variables=None):
        self.cursor_name = cursor_name
        self.into_variables = into_variables or []  # list[Variable]


class CloseCursor(ASTNode):
    def __init__(self, cursor_name):
        self.cursor_name = cursor_name



# CTE (Common Table Expression)
# -----------------------------

class WithClause(ASTNode):
    def __init__(self, ctes):
        self.ctes = ctes


class CommonTableExpression(ASTNode):
    def __init__(self, name, columns, select_statement):
        self.name = name
        self.columns = columns or []
        self.select_statement = select_statement
