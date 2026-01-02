from antlr4 import *
from SqlLexer import SqlLexer
import os

def tokenize_from_file(filepath):
    """Read SQL from a file and tokenize it"""
    try:
        with open(filepath, 'r', encoding='utf-8') as f:
            sql_code = f.read()
        tokenize(sql_code)
    except FileNotFoundError:
        print(f"Error: File '{filepath}' not found.")
    except Exception as e:
        print(f"Error reading file: {e}")

def tokenize(code):
    """Tokenize SQL code"""
    input_stream = InputStream(code)
    lexer = SqlLexer(input_stream)
    tokens = lexer.getAllTokens()

    for token in tokens:
        print(f"Token: {lexer.symbolicNames[token.type]}, Text: {token.text}")

def tokenize_file(path):
    with open(path, "r", encoding="utf-8") as f:
        content = f.read()
    tokenize(content)

sql = "SELECT name, age FROM users WHERE age>10;"
sql2 = "SELECT 'It''s a beautiful day' AS msg;"
sql3 = r"SELECT 'abc\
def' AS test;"
sql4 = "/* comment /* nested */ */ SELECT * FROM table1;"
sql5 = "SELECT 0xFF, 0b1101;"
sql6 = """DECLARE @x INT;
SELECT @x;"""
sql7 = "SELECT 0xabc\
def AS Name;"
# tokenize(sql)
tokenize_file("testing.sql")
