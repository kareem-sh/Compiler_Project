from antlr4 import *
from SqlLexer import SqlLexer
from SqlParser import SqlParser
from antlr4.tree.Trees import Trees

# AST Visitor
from ASTBuilderVisitor import ASTBuilderVisitor


def parse_sql(code: str):
    print("========== SQL INPUT ==========")
    print(code)
    print("================================\n")

    # 1) Input stream
    input_stream = InputStream(code)

    # 2) Lexer
    lexer = SqlLexer(input_stream)

    # 3) Token stream
    tokens = CommonTokenStream(lexer)
    tokens.fill()

    print("========== TOKENS ==========")
    for token in tokens.tokens:
        if token.type != Token.EOF:
            print(f"{lexer.symbolicNames[token.type]:<20} -> {token.text}")
    print("=============================\n")

    # 4) Parser
    parser = SqlParser(tokens)

    # Start rule
    tree = parser.sqlFile()

    print("========== PARSE TREE ==========")
    print(Trees.toStringTree(tree, None, parser))
    print("================================\n")

    # 5) Build AST using Visitor
    print("========== AST ==========")
    visitor = ASTBuilderVisitor()
    ast = visitor.visit(tree)

    if ast:
        # في حال كان هناك أكثر من statement
        if isinstance(ast, list):
            for node in ast:
                node.print()
        else:
            ast.print()

    print("==========================\n")


def parse_file(path: str):
    with open(path, "r", encoding="utf-8") as f:
        parse_sql(f.read())


# ===========================
# TEST
# ===========================
parse_file("testing.sql")
