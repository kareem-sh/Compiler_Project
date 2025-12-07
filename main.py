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

# Example usage:
# Read from a SQL file
tokenize_from_file('test.sql')

# Or tokenize a direct string
sql_string = "SELECT * FROM users;"
tokenize(sql_string)