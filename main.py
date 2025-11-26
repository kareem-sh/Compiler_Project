from antlr4 import *
from SqlLexer import SqlLexer

def tokenize(code):
    input_stream = InputStream(code)
    lexer = SqlLexer(input_stream)
    tokens = lexer.getAllTokens()

    for token in tokens:
        print(f"Token: {lexer.symbolicNames[token.type]}, Text: {token.text}")

sql = "SELECT name, age FROM users;"
sql2 = "SELECT 'It''s a beautiful day' AS msg;"
sql3 = r"SELECT 'abc\
def' AS test;"
sql4 = "/* comment /* nested */ */ SELECT * FROM table1;"
sql5 = "SELECT 0xFF, 0b1101;"
sql6 = """DECLARE @x INT;
SELECT @x;"""
sql7 = "SELECT 0xabc\
def AS Name;"
tokenize(sql3)
