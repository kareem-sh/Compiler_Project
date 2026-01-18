from antlr4 import *
from SqlLexer import SqlLexer
from SqlParser import SqlParser
from antlr4.tree.Trees import Trees
from antlr4.tree.Tree import TerminalNodeImpl

def print_tree(node, parser, indent=""):
    

    if isinstance(node, TerminalNodeImpl):
        # Leaf token
        text = node.getText()
        if text.strip():  # skip empty whitespace tokens
            print(f"{indent}|-- {text}")
        return

    # Non-terminal node
    rule_name = parser.ruleNames[node.getRuleIndex()] if hasattr(node, "getRuleIndex") else str(node)
    print(f"{indent}{rule_name}")

    # Recurse for children
    for child in node.getChildren():
        print_tree(child, parser, indent + "    ")

def parse_sql(code: str):
    print("========== SQL INPUT ==========")
    print(code)
    print("================================\n")

    # 1) Input stream
    input_stream = InputStream(code)

    # 2) Lexer
    lexer = SqlLexer(input_stream)

    # 3) Token stream
    token_stream = CommonTokenStream(lexer)
    token_stream.fill()

    print("========== TOKENS ==========")
    for token in token_stream.tokens:
        if token.type != Token.EOF:
            print(f"{lexer.symbolicNames[token.type]:<20} -> {token.text}")
    print("=============================\n")

    # 4) Parser
    parser = SqlParser(token_stream)

    # Start rule (مهم جدًا)
    tree = parser.sqlFile()

    print("========== PARSE TREE ==========")
    print(Trees.toStringTree(tree, None, parser))
    # print_tree(tree , parser)
    print("================================\n")


def parse_file(path: str):
    with open(path, "r", encoding="utf-8") as f:
        parse_sql(f.read())


# ===========================
# TEST CASES
# ===========================

sql1 = "SELECT name, age FROM users WHERE age > 10;"
sql2 = "SELECT 'It''s a beautiful day' AS msg;"
sql3 = "SELECT * FROM users INNER JOIN orders ON users.id = orders.user_id;"
sql4 = """
WITH t AS (SELECT id FROM users)
SELECT * FROM t ORDER BY id DESC;
"""

# Parse directly
# parse_sql(sql1)

# Or from file
parse_file("train.sql")
