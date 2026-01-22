from antlr4 import *
from SqlLexer import SqlLexer
from SqlParser import SqlParser
from antlr4.tree.Trees import Trees
from antlr4.tree.Tree import TerminalNodeImpl
from ASTBuilderVisitor import ASTBuilder
from ast_nodes import *


# PARSE TREE PRINTER
def print_parse_tree(node, parser, indent=""):
    if isinstance(node, TerminalNodeImpl):
        text = node.getText()
        if text.strip():
            print(f"{indent}|-- {text}")
        return

    rule_name = parser.ruleNames[node.getRuleIndex()]
    print(f"{indent}{rule_name}")

    for child in node.getChildren():
        print_parse_tree(child, parser, indent + "    ")



# AST PRINTER
def print_ast(node, indent=""):
    """Print the AST in a readable format."""
    if node is None:
        print(f"{indent}None")
        return

    if isinstance(node, SqlFile):
        print(f"{indent}SqlFile")
        for stmt in node.statements:
            print_ast(stmt, indent + "  ")

    elif isinstance(node, Block):
        print(f"{indent}Block")
        for stmt in node.statements:
            print_ast(stmt, indent + "  ")

    elif isinstance(node, SelectStatement):
        print(f"{indent}SelectStatement")
        print(f"{indent}  columns:")
        for col in node.columns:
            print_ast(col, indent + "    ")
        if node.from_clause:
            print(f"{indent}  from_clause:")
            print_ast(node.from_clause, indent + "    ")
        if node.joins:
            print(f"{indent}  joins:")
            for join in node.joins:
                print_ast(join, indent + "    ")
        if node.where:
            print(f"{indent}  where:")
            print_ast(node.where, indent + "    ")
        if node.group_by:
            print(f"{indent}  group_by:")
            print_ast(node.group_by, indent + "    ")
        if node.having:
            print(f"{indent}  having:")
            print_ast(node.having, indent + "    ")
        if node.order_by:
            print(f"{indent}  order_by:")
            print_ast(node.order_by, indent + "    ")

    elif isinstance(node, FromClause):
        print(f"{indent}FromClause")
        for table in node.tables:
            print_ast(table, indent + "  ")

    elif isinstance(node, TableSource):
        print(f"{indent}TableSource")
        print(f"{indent}  table_name: {node.table_name}")
        if node.alias:
            print(f"{indent}  alias: {node.alias}")
        if node.joins:
            print(f"{indent}  joins:")
            for join in node.joins:
                print_ast(join, indent + "    ")

    elif isinstance(node, Join):
        print(f"{indent}Join")
        print(f"{indent}  join_type: {node.join_type}")
        print(f"{indent}  table_source:")
        print_ast(node.table_source, indent + "    ")
        print(f"{indent}  condition:")
        print_ast(node.condition, indent + "    ")

    elif isinstance(node, WhereClause):
        print(f"{indent}WhereClause")
        print_ast(node.condition, indent + "  ")

    elif isinstance(node, GroupByClause):
        print(f"{indent}GroupByClause")
        for expr in node.expressions:
            print_ast(expr, indent + "  ")

    elif isinstance(node, HavingClause):
        print(f"{indent}HavingClause")
        print_ast(node.condition, indent + "  ")

    elif isinstance(node, OrderByClause):
        print(f"{indent}OrderByClause")
        for elem in node.order_elements:
            print_ast(elem, indent + "  ")

    elif isinstance(node, OrderByElement):
        print(f"{indent}OrderByElement")
        print(f"{indent}  order: {node.order}")
        print_ast(node.expression, indent + "  ")

    elif isinstance(node, SelectColumn):
        print(f"{indent}SelectColumn")
        if node.alias:
            print(f"{indent}  alias: {node.alias}")
        print_ast(node.expression, indent + "  ")

    elif isinstance(node, Column):
        print(f"{indent}Column")
        if node.table:
            print(f"{indent}  table: {node.table}")
        print(f"{indent}  name: {node.name}")

    elif isinstance(node, Literal):
        print(f"{indent}Literal")
        print(f"{indent}  value: {node.value}")
        if node.type:
            print(f"{indent}  type: {node.type}")

    elif isinstance(node, BinaryExpression):
        print(f"{indent}BinaryExpression")
        print(f"{indent}  operator: {node.operator}")
        print(f"{indent}  left:")
        print_ast(node.left, indent + "    ")
        print(f"{indent}  right:")
        print_ast(node.right, indent + "    ")

    elif isinstance(node, UnaryExpression):
        print(f"{indent}UnaryExpression")
        print(f"{indent}  operator: {node.operator}")
        print_ast(node.expression, indent + "  ")

    elif isinstance(node, FunctionCall):
        print(f"{indent}FunctionCall")
        print(f"{indent}  name: {node.name}")
        if node.args:
            print(f"{indent}  args:")
            for arg in node.args:
                print_ast(arg, indent + "    ")

    elif isinstance(node, InExpression):
        print(f"{indent}InExpression")
        print(f"{indent}  not_in: {node.not_in}")
        print(f"{indent}  value:")
        print_ast(node.value, indent + "    ")
        print(f"{indent}  options:")
        if isinstance(node.options, list):
            for opt in node.options:
                print_ast(opt, indent + "    ")
        else:
            print_ast(node.options, indent + "    ")

    elif isinstance(node, BetweenExpression):
        print(f"{indent}BetweenExpression")
        print(f"{indent}  not_between: {node.not_between}")
        print(f"{indent}  value:")
        print_ast(node.value, indent + "    ")
        print(f"{indent}  lower:")
        print_ast(node.lower, indent + "    ")
        print(f"{indent}  upper:")
        print_ast(node.upper, indent + "    ")

    elif isinstance(node, LikeExpression):
        print(f"{indent}LikeExpression")
        print(f"{indent}  not_like: {node.not_like}")
        print(f"{indent}  value:")
        print_ast(node.value, indent + "    ")
        print(f"{indent}  pattern:")
        print_ast(node.pattern, indent + "    ")

    elif isinstance(node, IsNullExpression):
        print(f"{indent}IsNullExpression")
        print(f"{indent}  not_null: {node.not_null}")
        print_ast(node.expression, indent + "  ")

    elif isinstance(node, ExistsExpression):
        print(f"{indent}ExistsExpression")
        print_ast(node.subquery, indent + "  ")

    elif isinstance(node, CaseExpression):
        print(f"{indent}CaseExpression")
        for cond, expr in node.whens:
            print(f"{indent}  when:")
            print_ast(cond, indent + "    ")
            print(f"{indent}  then:")
            print_ast(expr, indent + "    ")
        if node.else_expr:
            print(f"{indent}  else:")
            print_ast(node.else_expr, indent + "    ")

    elif isinstance(node, Variable):
        print(f"{indent}Variable")
        print(f"{indent}  name: {node.name}")

    else:
        print(f"{indent}{node.__class__.__name__}")
        for key, value in node.__dict__.items():
            print(f"{indent}  {key}: {value}")



# SQL PARSER
def parse_sql(code: str):
    print("========== SQL INPUT ==========")
    print(code)
    print("================================\n")

    # Input
    input_stream = InputStream(code)

    # Lexer
    lexer = SqlLexer(input_stream)

    # Tokens
    token_stream = CommonTokenStream(lexer)
    token_stream.fill()

    print("========== TOKENS ==========")
    for token in token_stream.tokens:
        if token.type != Token.EOF:
            print(f"{lexer.symbolicNames[token.type]:<20} -> {token.text}")
    print("=============================\n")

    # Parser
    parser = SqlParser(token_stream)
    tree = parser.sqlFile()

    print("========== PARSE TREE ==========")
    print(Trees.toStringTree(tree, None, parser))
    print("================================\n")

    print("========== FORMATTED PARSE TREE ==========")
    print_parse_tree(tree, parser)
    print("================================\n")

    # BUILD AST
    builder = ASTBuilder()
    ast = builder.visit(tree)

    print("========== AST ==========")
    print_ast(ast)
    print("=========================\n")


def parse_file(path: str):
    with open(path, "r", encoding="utf-8") as f:
        code = f.read()
    parse_sql(code)



# TESTING
if __name__ == "__main__":
    sql1 = "SELECT name, age FROM users WHERE age > 10;"
    # parse_file("Train2-1.sql")
    parse_sql(sql1)
