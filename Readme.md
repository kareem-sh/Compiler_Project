# SQL Parser Project

This project uses **ANTLR4** to parse SQL queries. It is designed to support **both Python and Java** environments.
The repository contains only the **grammar files (`.g4`)**; generated lexer and parser files are **ignored**, so each developer can generate them locally for their language.

---

## Table of Contents

- [Requirements](#requirements)
- [Installation](#installation)
  - [Python Setup](#python-setup)
  - [Java Setup](#java-setup)
- [Generating Lexer and Parser](#generating-lexer-and-parser)
  - [Python](#python)
  - [Java](#java)
- [Running the Parser](#running-the-parser)
  - [Python](#python-1)
  - [Java](#java-1)
- [Semantic Phase](#semantic-phase)
- [Notes](#notes)

---

## Requirements

- Python 3.10+
- Java 8+
- ANTLR4 Tool (Java JAR)
- Git

---

## Installation

1. Download the ANTLR4 tool JAR from ANTLR website(https://www.antlr.org/download.html):

```bash
   antlr-4.13.2-complete.jar
```

2. Optionally, add an alias for easier usage:

   Windows (PowerShell):

   ```bash
   setx CLASSPATH ".;C:\path\to\antlr-4.13.2-complete.jar;%CLASSPATH%"
   ```

   Linux / Mac:

   ```bash
   export CLASSPATH=".:/path/to/antlr-4.13.2-complete.jar:$CLASSPATH"
   alias antlr4='java -jar /path/to/antlr-4.13.2-complete.jar'
   ```

### Python Setup

1. Create a virtual environment (optional but recommended):

```bash
python -m venv antrl4-env
```

2. Activate the environment:

Windows (PowerShell):

```bash
.\antrl4-env\Scripts\activate
```

Linux / Mac:

```bash
source antrl4-env/bin/activate
```

3. Install the ANTLR4 runtime for Python:

```bash
pip install antlr4-python3-runtime
```

4. Verify installation:

```bash
python -c "from antlr4 import \*; print('ANTLR4 runtime works!')"
```

Java Setup:

- If you applied the steps in the installation it should work fine.

## Generating Lexer and Parser

# Python

Generate Python lexer and parser from grammar files:

```bash
antlr4 -Dlanguage=Python3 SqlLexer.g4 SqlParser.g4
```

This creates SqlLexer.py, SqlParser.py, and other helper files.

# Java

Generate Java lexer and parser:

```bash
java -jar antlr-4.13.2-complete.jar SqlLexer.g4 SqlParser.g4
```

This creates SqlLexer.java, SqlParser.java, and other helper files.
Compile generated files:

```bash
javac \*.java
```

## Running the Parser

# Python

Run your main.py script with your virtual environment activated:

```bash
python main.py
```

The script reads train.sql (or any SQL file)

Prints all tokens

Prints parse tree (formatted tree is optional)

# Java

1. Compile the main parser class (if you have Main.java):

```bash
javac -cp .;antlr-4.13.2-complete.jar Main.java
```

2. Run it:

```bash
java -cp .;antlr-4.13.2-complete.jar Main
```

Make sure your generated .class files are in the same folder.

### Semantic Phase

The semantic phase is where you analyze the parse tree for correctness, types, or additional rules.
For example:

- Python: traverse the parse tree with visitor/listener patterns from ANTLR and implement semantic checks.

- Java: use ParseTreeWalker and custom listeners to perform semantic validations.

Example in Python:

     from SqlParserListener import SqlParserListener

    class MySemanticChecker(SqlParserListener):
        def enterSelectStatement(self, ctx):
            # check semantic rules here
            pass

## Notes

- Only .g4 files are tracked in Git. All generated files (.java, .py, .interp, .tokens) are ignored.

- Each developer should generate lexer/parser files locally depending on their preferred language.

- If you are switching between Python and Java, always regenerate the files to match the language runtime.

### Example Commands Summary:

- Python:

```bash
# Activate environment
.\antrl4-env\Scripts\activate

# Install ANTLR runtime
pip install antlr4-python3-runtime

# Generate lexer/parser
antlr4 -Dlanguage=Python3 SqlLexer.g4 SqlParser.g4

# Run parser
python main.py
```

- Java

```bash
# Generate lexer/parser
java -jar antlr-4.13.2-complete.jar SqlLexer.g4 SqlParser.g4

# Compile
javac *.java

# Run
java -cp .;antlr-4.13.2-complete.jar Main
```

# References:

- ANTLR Official Website(https://www.antlr.org/)
- ANTLR Python Runtime(https://pypi.org/project/antlr4-python3-runtime/)
- ANTLR4 GitHub(https://github.com/antlr/antlr4)
