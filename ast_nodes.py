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


# =========================
# SQL FILE & STATEMENTS
# =========================

class SqlFile(ASTNode):
    def __init__(self, statements):
        self.statements = statements    # list[ASTNode]


# =========================
# SELECT STATEMENTS
# =========================

class SelectStatement(ASTNode):
    def __init__(self, columns, from_clause=None, where=None, joins=None, group_by=None,
                 having=None, order_by=None, distinct=False, top=None):
        self.columns = columns          # list[SelectColumn]
        self.from_clause = from_clause  # FromClause | None
        self.where = where              # WhereClause | None
        self.joins = joins or []        # list[Join] - FIXED: Added joins parameter
        self.group_by = group_by        # GroupByClause | None
        self.having = having            # HavingClause | None
        self.order_by = order_by        # OrderByClause | None
        self.distinct = distinct        # bool
        self.top = top                  # TopClause | None


class SelectColumn(ASTNode):
    def __init__(self, expression, alias=None):
        self.expression = expression    # Expression (Column, FunctionCall, etc.)
        self.alias = alias              # str | None


class FromClause(ASTNode):
    def __init__(self, tables):
        self.tables = tables            # list[TableSource]


class TableSource(ASTNode):
    def __init__(self, table_name, alias=None, joins=None):
        self.table_name = table_name    # str
        self.alias = alias              # str | None
        self.joins = joins or []        # list[Join]


class Join(ASTNode):
    def __init__(self, join_type, table_source, condition):
        self.join_type = join_type      # str: "INNER", "LEFT", "RIGHT", "FULL", "CROSS"
        self.table_source = table_source  # TableSource
        self.condition = condition      # Expression (ON condition)


class WhereClause(ASTNode):
    def __init__(self, condition):
        self.condition = condition      # Expression


class GroupByClause(ASTNode):
    def __init__(self, expressions, having=None):
        self.expressions = expressions  # list[Expression]
        self.having = having            # HavingClause | None


class HavingClause(ASTNode):
    def __init__(self, condition):
        self.condition = condition      # Expression


class OrderByClause(ASTNode):
    def __init__(self, order_elements):
        self.order_elements = order_elements  # list[OrderByElement]


class OrderByElement(ASTNode):
    def __init__(self, expression, order="ASC"):
        self.expression = expression    # Expression
        self.order = order              # "ASC" or "DESC"


class TopClause(ASTNode):
    def __init__(self, value, percent=False, with_ties=False):
        self.value = value              # Expression (usually INT_LITERAL)
        self.percent = percent          # bool
        self.with_ties = with_ties      # bool


# =========================
# DML STATEMENTS
# =========================

class InsertStatement(ASTNode):
    def __init__(self, table, columns=None, values=None, select=None):
        self.table = table              # str
        self.columns = columns          # list[str] | None
        self.values = values            # list[list[Expression]] | None (for multiple rows)
        self.select = select            # SelectStatement | None


class UpdateStatement(ASTNode):
    def __init__(self, table, assignments, from_clause=None, where=None):
        self.table = table              # str
        self.assignments = assignments  # list[Assignment]
        self.from_clause = from_clause  # FromClause | None
        self.where = where              # WhereClause | None


class DeleteStatement(ASTNode):
    def __init__(self, table, where=None):
        self.table = table              # str
        self.where = where              # WhereClause | None


class Assignment(ASTNode):
    def __init__(self, column, value, operator="="):
        self.column = column            # Column
        self.value = value              # Expression
        self.operator = operator        # "=" or "+="


# =========================
# DDL STATEMENTS
# =========================

class CreateTableStatement(ASTNode):
    def __init__(self, table, columns, constraints=None):
        self.table = table              # str
        self.columns = columns          # list[ColumnDefinition]
        self.constraints = constraints or []  # list[Constraint]


class DropTableStatement(ASTNode):
    def __init__(self, table):
        self.table = table              # str


class AlterTableStatement(ASTNode):
    def __init__(self, table, action):
        self.table = table              # str
        self.action = action            # AlterAction


class AlterAction(ASTNode):
    def __init__(self, action_type, column=None, constraint=None):
        self.action_type = action_type  # "ADD", "DROP", "MODIFY", etc.
        self.column = column            # ColumnDefinition | None
        self.constraint = constraint    # Constraint | None


class ColumnDefinition(ASTNode):
    def __init__(self, name, data_type, options=None, constraints=None):
        self.name = name                # str
        self.data_type = data_type      # str
        self.options = options or []    # list[str]
        self.constraints = constraints or []  # list[Constraint]


class Constraint(ASTNode):
    def __init__(self, name, constraint_type, columns=None,
                 references_table=None, references_columns=None,
                 check_condition=None):
        self.name = name                # str
        self.constraint_type = constraint_type  # "PRIMARY KEY", "FOREIGN KEY", "UNIQUE", "CHECK"
        self.columns = columns or []    # list[str]
        self.references_table = references_table  # str | None
        self.references_columns = references_columns or []  # list[str]
        self.check_condition = check_condition  # Expression | None


# =========================
# CONTROL FLOW
# =========================

class TryCatchStatement(ASTNode):
    def __init__(self, try_block, catch_block):
        self.try_block = try_block      # list[ASTNode]
        self.catch_block = catch_block  # list[ASTNode]


class Block(ASTNode):
    def __init__(self, statements):
        self.statements = statements    # list[ASTNode]


class IfStatement(ASTNode):
    def __init__(self, condition, true_block, false_block=None):
        self.condition = condition      # Expression
        self.true_block = true_block    # Block
        self.false_block = false_block  # Block | None


# =========================
# EXPRESSIONS
# =========================

class Column(ASTNode):
    def __init__(self, name, table=None):
        self.name = name                # str
        self.table = table              # str | None (table alias)


class Literal(ASTNode):
    def __init__(self, value, type=None):
        self.value = value              # int, float, str, bool, None
        self.type = type                # "INT", "FLOAT", "STRING", "BOOL", "NULL"


class BinaryExpression(ASTNode):
    def __init__(self, left, operator, right):
        self.left = left                # Expression
        self.operator = operator        # str: "=", "<>", ">", "<", ">=", "<=", "+", "-", "*", "/", "AND", "OR"
        self.right = right              # Expression


class UnaryExpression(ASTNode):
    def __init__(self, operator, expression):
        self.operator = operator        # str: "NOT", "+", "-"
        self.expression = expression    # Expression


class CaseExpression(ASTNode):
    def __init__(self, whens, else_expr=None):
        self.whens = whens              # list[(condition, expr)]
        self.else_expr = else_expr      # Expression | None


class FunctionCall(ASTNode):
    def __init__(self, name, args, distinct=False):
        self.name = name                # str
        self.args = args                # list[Expression]
        self.distinct = distinct        # bool


class ExistsExpression(ASTNode):
    def __init__(self, subquery):
        self.subquery = subquery        # SelectStatement


class InExpression(ASTNode):
    def __init__(self, value, options, not_in=False):
        self.value = value              # Expression
        self.options = options          # list[Expression] | SelectStatement
        self.not_in = not_in            # bool


class BetweenExpression(ASTNode):
    def __init__(self, value, lower, upper, not_between=False):
        self.value = value              # Expression
        self.lower = lower              # Expression
        self.upper = upper              # Expression
        self.not_between = not_between  # bool


class LikeExpression(ASTNode):
    def __init__(self, value, pattern, not_like=False):
        self.value = value              # Expression
        self.pattern = pattern          # Expression
        self.not_like = not_like        # bool


class IsNullExpression(ASTNode):
    def __init__(self, expression, not_null=False):
        self.expression = expression    # Expression
        self.not_null = not_null        # bool


# =========================
# VARIABLES & DECLARATIONS
# =========================

class Variable(ASTNode):
    def __init__(self, name):
        self.name = name                # str (starts with @)


class DeclareStatement(ASTNode):
    def __init__(self, variable, data_type, value=None):
        self.variable = variable        # Variable
        self.data_type = data_type      # str
        self.value = value              # Expression | None


class SetStatement(ASTNode):
    def __init__(self, variable, value, operator="="):
        self.variable = variable        # Variable
        self.value = value              # Expression
        self.operator = operator        # "=" or "+="


# =========================
# OTHER STATEMENTS
# =========================

class UseDatabaseStatement(ASTNode):
    def __init__(self, database_name):
        self.database_name = database_name  # str


class TruncateTableStatement(ASTNode):
    def __init__(self, table):
        self.table = table              # str


class ExecStatement(ASTNode):
    def __init__(self, procedure_name, args=None):
        self.procedure_name = procedure_name  # str
        self.args = args or []          # list[Expression]


# =========================
# CURSOR STATEMENTS
# =========================

class DeclareCursor(ASTNode):
    def __init__(self, cursor_name, select_statement):
        self.cursor_name = cursor_name  # str
        self.select_statement = select_statement  # SelectStatement


class OpenCursor(ASTNode):
    def __init__(self, cursor_name):
        self.cursor_name = cursor_name  # str


class FetchCursor(ASTNode):
    def __init__(self, cursor_name, into_variables=None):
        self.cursor_name = cursor_name  # str
        self.into_variables = into_variables or []  # list[Variable]


class CloseCursor(ASTNode):
    def __init__(self, cursor_name):
        self.cursor_name = cursor_name  # str


# =========================
# CTE (Common Table Expression)
# =========================

class WithClause(ASTNode):
    def __init__(self, ctes):
        self.ctes = ctes                # list[CommonTableExpression]


class CommonTableExpression(ASTNode):
    def __init__(self, name, columns, select_statement):
        self.name = name                # str
        self.columns = columns or []    # list[str]
        self.select_statement = select_statement  # SelectStatement
