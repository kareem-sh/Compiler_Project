# 📁 PROJECT EXPORT FOR LLMs

## 📊 Project Information

- **Project Name**: `Compilrt_Project`
- **Generated On**: 2026-01-18 10:22:34 (Asia/Damascus / GMT+03:00)
- **Total Files Processed**: 18
- **Export Tool**: Easy Whole Project to Single Text File for LLMs v1.1.0
- **Tool Author**: Jota / José Guilherme Pandolfi

### ⚙️ Export Configuration

| Setting | Value |
|---------|-------|
| Language | `en` |
| Max File Size | `1 MB` |
| Include Hidden Files | `false` |
| Output Format | `both` |

## 🌳 Project Structure

```
├── 📁 __pycache__/
│   ├── 📄 SqlLexer.cpython-313.pyc (97.61 KB)
│   └── 📄 SqlParser.cpython-313.pyc (299.26 KB)
├── 📄 main.py (2.11 KB)
├── 📄 SqlLexer.g4 (5.08 KB)
├── 📄 SqlLexer.java (116.5 KB)
├── 📄 SqlLexer.py (70.86 KB)
├── 📄 SqlLexer.tokens (5.43 KB)
├── 📄 SqlParser.g4 (8.96 KB)
├── 📄 SqlParser.java (187.25 KB)
├── 📄 SqlParser.py (194.19 KB)
├── 📄 SqlParser.tokens (5.43 KB)
├── 📄 SqlParserBaseListener.java (21.63 KB)
├── 📄 SqlParserListener.java (21.14 KB)
├── 📄 SqlParserListener.py (18.26 KB)
├── 📄 test.sql (2.39 KB)
├── 📄 testing.sql (2.39 KB)
├── 📄 train.sql (4.34 KB)
└── 📄 train2.sql (1.64 KB)
```

## 📑 Table of Contents

**Project Files:**

- [📄 main.py](#📄-main-py)
- [📄 SqlLexer.java](#📄-sqllexer-java)
- [📄 SqlLexer.py](#📄-sqllexer-py)
- [📄 SqlParser.java](#📄-sqlparser-java)
- [📄 SqlParser.py](#📄-sqlparser-py)
- [📄 SqlParserBaseListener.java](#📄-sqlparserbaselistener-java)
- [📄 SqlParserListener.java](#📄-sqlparserlistener-java)
- [📄 SqlParserListener.py](#📄-sqlparserlistener-py)
- [📄 test.sql](#📄-test-sql)
- [📄 testing.sql](#📄-testing-sql)
- [📄 train.sql](#📄-train-sql)
- [📄 train2.sql](#📄-train2-sql)

---

## 📈 Project Statistics

| Metric | Count |
|--------|-------|
| Total Files | 18 |
| Total Directories | 1 |
| Text Files | 12 |
| Binary Files | 6 |
| Total Size | 1.04 MB |

### 📄 File Types Distribution

| Extension | Count |
|-----------|-------|
| `.py` | 4 |
| `.java` | 4 |
| `.sql` | 4 |
| `.pyc` | 2 |
| `.g4` | 2 |
| `.tokens` | 2 |

## 💻 File Code Contents

## 🚫 Binary/Excluded Files

The following files were not included in the text content:

- `__pycache__/SqlLexer.cpython-313.pyc`
- `__pycache__/SqlParser.cpython-313.pyc`

### <a id="📄-main-py"></a>📄 `main.py`

**File Info:**
- **Size**: 2.11 KB
- **Extension**: `.py`
- **Language**: `python`
- **Location**: `main.py`
- **Relative Path**: `root`
- **Created**: 2025-11-27 05:06:21 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-18 10:08:19 (Asia/Damascus / GMT+03:00)
- **MD5**: `baf10534a8b3cdfbbfe712c608b5a6e2`
- **SHA256**: `cb9eecfc6608711cd0a8c902f31759cf719044ebe814932b433f0ec39c764a14`
- **Encoding**: ASCII

**File code content:**

```python
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

```

---

### <a id="📄-sqllexer-java"></a>📄 `SqlLexer.java`

**File Info:**
- **Size**: 116.5 KB
- **Extension**: `.java`
- **Language**: `java`
- **Location**: `SqlLexer.java`
- **Relative Path**: `root`
- **Created**: 2025-11-27 05:08:16 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-18 10:22:32 (Asia/Damascus / GMT+03:00)
- **MD5**: `e08bedf76b9bfafb1d563f7ab20d0ac1`
- **SHA256**: `fe220c9e66aa67b054384caf67ef5ffca180d84ffe68a5e5517d4daf44188691`
- **Encoding**: ASCII

**File code content:**

```java
// Generated from c:/Users/salah/Programming_Tests/Java/Compilrt_Project/SqlLexer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SqlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ADD=1, EXTERNAL=2, PROCEDURE=3, ALL=4, FETCH=5, PUBLIC=6, ALTER=7, FILE=8, 
		RAISERROR=9, AND=10, FILLFACTOR=11, READ=12, ANY=13, FOR=14, READTEXT=15, 
		AS=16, FOREIGN=17, RECONFIGURE=18, ASC=19, FREETEXT=20, REFERENCES=21, 
		AUTHORIZATION=22, FREETEXTTABLE=23, REPLICATION=24, BACKUP=25, FROM=26, 
		RESTORE=27, BEGIN=28, FULL=29, RESTRICT=30, BETWEEN=31, FUNCTION=32, RETURN=33, 
		BREAK=34, GOTO=35, GO=36, REVERT=37, BROWSE=38, GRANT=39, REVOKE=40, BULK=41, 
		GROUP=42, RIGHT=43, BY=44, HAVING=45, ROLLBACK=46, CASCADE=47, HOLDLOCK=48, 
		ROWCOUNT=49, CASE=50, IDENTITY=51, ROWGUIDCOL=52, CHECK=53, IDENTITY_INSERT=54, 
		RULE=55, CHECKPOINT=56, IDENTITYCOL=57, SAVE=58, CLOSE=59, IF=60, SCHEMA=61, 
		CLUSTERED=62, IN=63, SECURITYAUDIT=64, COALESCE=65, INDEX=66, SELECT=67, 
		COLLATE=68, INNER=69, SEMANTICKEYPHRASETABLE=70, COLUMN=71, INSERT=72, 
		SEMANTICSIMILARITYDETAILSTABLE=73, COMMIT=74, INTERSECT=75, SEMANTICSIMILARITYTABLE=76, 
		COMPUTE=77, INTO=78, SESSION_USER=79, CONSTRAINT=80, IS=81, SET=82, CONTAINS=83, 
		JOIN=84, SETUSER=85, CONTAINSTABLE=86, KEY=87, SHUTDOWN=88, CONTINUE=89, 
		KILL=90, SOME=91, CONVERT=92, LEFT=93, STATISTICS=94, CREATE=95, LIKE=96, 
		SYSTEM_USER=97, CROSS=98, LINENO=99, TABLE=100, CURRENT=101, LOAD=102, 
		TABLESAMPLE=103, CURRENT_DATE=104, MERGE=105, TEXTSIZE=106, CURRENT_TIME=107, 
		NATIONAL=108, THEN=109, CURRENT_TIMESTAMP=110, NOCHECK=111, TO=112, CURRENT_USER=113, 
		NONCLUSTERED=114, TOP=115, CURSOR=116, NOT=117, TRAN=118, DATABASE=119, 
		NULL=120, TRANSACTION=121, DBCC=122, NULLIF=123, TRIGGER=124, DEALLOCATE=125, 
		OF=126, TRUNCATE=127, DECLARE=128, OFF=129, TRY_CONVERT=130, DEFAULT=131, 
		OFFSETS=132, TSEQUAL=133, DELETE=134, ON=135, UNION=136, DENY=137, OPEN=138, 
		UNIQUE=139, DESC=140, OPENDATASOURCE=141, UPDATE=142, DISK=143, OPENQUERY=144, 
		UPDATETEXT=145, DISTINCT=146, OPENROWSET=147, USE=148, DISTRIBUTED=149, 
		OPENXML=150, USER=151, DOUBLE=152, OPTION=153, VALUES=154, DROP=155, OR=156, 
		VARYING=157, DUMP=158, ORDER=159, VIEW=160, ELSE=161, OUTER=162, WAITFOR=163, 
		END=164, OVER=165, WHEN=166, ERRLVL=167, PERCENT=168, WHERE=169, ESCAPE=170, 
		PIVOT=171, WHILE=172, EXCEPT=173, PLAN=174, WITH=175, EXEC=176, PRECISION=177, 
		WRITETEXT=178, EXECUTE=179, PRIMARY=180, INT=181, NVARCHAR=182, VARCHAR=183, 
		MAX=184, MIN=185, AVG=186, SUM=187, COUNT=188, TRY=189, CATCH=190, EXISTS=191, 
		INT_LITERAL=192, FLOAT_LITERAL=193, HEX_LITERAL=194, BIT_LITERAL=195, 
		TRUE_LITERAL=196, FALSE_LITERAL=197, STRING_LITERAL=198, BRACKET_IDENTIFIER=199, 
		IDENTIFIER=200, USER_VAR=201, EQ=202, NEQ=203, GT=204, LT=205, GTE=206, 
		LTE=207, PLUS=208, MINUS=209, STAR=210, SLASH=211, PLUS_EQ=212, COMMA=213, 
		DOT=214, LPAREN=215, RPAREN=216, SPAREN=217, ZPAREN=218, SEMI=219, LINE_COMMENT=220, 
		COMMENT=221, WS=222;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGIT", "LETTER", "HEXDIGIT", "ADD", "EXTERNAL", "PROCEDURE", "ALL", 
			"FETCH", "PUBLIC", "ALTER", "FILE", "RAISERROR", "AND", "FILLFACTOR", 
			"READ", "ANY", "FOR", "READTEXT", "AS", "FOREIGN", "RECONFIGURE", "ASC", 
			"FREETEXT", "REFERENCES", "AUTHORIZATION", "FREETEXTTABLE", "REPLICATION", 
			"BACKUP", "FROM", "RESTORE", "BEGIN", "FULL", "RESTRICT", "BETWEEN", 
			"FUNCTION", "RETURN", "BREAK", "GOTO", "GO", "REVERT", "BROWSE", "GRANT", 
			"REVOKE", "BULK", "GROUP", "RIGHT", "BY", "HAVING", "ROLLBACK", "CASCADE", 
			"HOLDLOCK", "ROWCOUNT", "CASE", "IDENTITY", "ROWGUIDCOL", "CHECK", "IDENTITY_INSERT", 
			"RULE", "CHECKPOINT", "IDENTITYCOL", "SAVE", "CLOSE", "IF", "SCHEMA", 
			"CLUSTERED", "IN", "SECURITYAUDIT", "COALESCE", "INDEX", "SELECT", "COLLATE", 
			"INNER", "SEMANTICKEYPHRASETABLE", "COLUMN", "INSERT", "SEMANTICSIMILARITYDETAILSTABLE", 
			"COMMIT", "INTERSECT", "SEMANTICSIMILARITYTABLE", "COMPUTE", "INTO", 
			"SESSION_USER", "CONSTRAINT", "IS", "SET", "CONTAINS", "JOIN", "SETUSER", 
			"CONTAINSTABLE", "KEY", "SHUTDOWN", "CONTINUE", "KILL", "SOME", "CONVERT", 
			"LEFT", "STATISTICS", "CREATE", "LIKE", "SYSTEM_USER", "CROSS", "LINENO", 
			"TABLE", "CURRENT", "LOAD", "TABLESAMPLE", "CURRENT_DATE", "MERGE", "TEXTSIZE", 
			"CURRENT_TIME", "NATIONAL", "THEN", "CURRENT_TIMESTAMP", "NOCHECK", "TO", 
			"CURRENT_USER", "NONCLUSTERED", "TOP", "CURSOR", "NOT", "TRAN", "DATABASE", 
			"NULL", "TRANSACTION", "DBCC", "NULLIF", "TRIGGER", "DEALLOCATE", "OF", 
			"TRUNCATE", "DECLARE", "OFF", "TRY_CONVERT", "DEFAULT", "OFFSETS", "TSEQUAL", 
			"DELETE", "ON", "UNION", "DENY", "OPEN", "UNIQUE", "DESC", "OPENDATASOURCE", 
			"UPDATE", "DISK", "OPENQUERY", "UPDATETEXT", "DISTINCT", "OPENROWSET", 
			"USE", "DISTRIBUTED", "OPENXML", "USER", "DOUBLE", "OPTION", "VALUES", 
			"DROP", "OR", "VARYING", "DUMP", "ORDER", "VIEW", "ELSE", "OUTER", "WAITFOR", 
			"END", "OVER", "WHEN", "ERRLVL", "PERCENT", "WHERE", "ESCAPE", "PIVOT", 
			"WHILE", "EXCEPT", "PLAN", "WITH", "EXEC", "PRECISION", "WRITETEXT", 
			"EXECUTE", "PRIMARY", "INT", "NVARCHAR", "VARCHAR", "MAX", "MIN", "AVG", 
			"SUM", "COUNT", "TRY", "CATCH", "EXISTS", "INT_LITERAL", "FLOAT_LITERAL", 
			"HEX_LITERAL", "BIT_LITERAL", "TRUE_LITERAL", "FALSE_LITERAL", "STRING_LITERAL", 
			"BRACKET_IDENTIFIER", "IDENTIFIER", "USER_VAR", "EQ", "NEQ", "GT", "LT", 
			"GTE", "LTE", "PLUS", "MINUS", "STAR", "SLASH", "PLUS_EQ", "COMMA", "DOT", 
			"LPAREN", "RPAREN", "SPAREN", "ZPAREN", "SEMI", "LINE_COMMENT", "COMMENT", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ADD'", "'EXTERNAL'", "'PROCEDURE'", "'ALL'", "'FETCH'", "'PUBLIC'", 
			"'ALTER'", "'FILE'", "'RAISERROR'", "'AND'", "'FILLFACTOR'", "'READ'", 
			"'ANY'", "'FOR'", "'READTEXT'", "'AS'", "'FOREIGN'", "'RECONFIGURE'", 
			"'ASC'", "'FREETEXT'", "'REFERENCES'", "'AUTHORIZATION'", "'FREETEXTTABLE'", 
			"'REPLICATION'", "'BACKUP'", "'FROM'", "'RESTORE'", "'BEGIN'", "'FULL'", 
			"'RESTRICT'", "'BETWEEN'", "'FUNCTION'", "'RETURN'", "'BREAK'", "'GOTO'", 
			"'GO'", "'REVERT'", "'BROWSE'", "'GRANT'", "'REVOKE'", "'BULK'", "'GROUP'", 
			"'RIGHT'", "'BY'", "'HAVING'", "'ROLLBACK'", "'CASCADE'", "'HOLDLOCK'", 
			"'ROWCOUNT'", "'CASE'", "'IDENTITY'", "'ROWGUIDCOL'", "'CHECK'", "'IDENTITY_INSERT'", 
			"'RULE'", "'CHECKPOINT'", "'IDENTITYCOL'", "'SAVE'", "'CLOSE'", "'IF'", 
			"'SCHEMA'", "'CLUSTERED'", "'IN'", "'SECURITYAUDIT'", "'COALESCE'", "'INDEX'", 
			"'SELECT'", "'COLLATE'", "'INNER'", "'SEMANTICKEYPHRASETABLE'", "'COLUMN'", 
			"'INSERT'", "'SEMANTICSIMILARITYDETAILSTABLE'", "'COMMIT'", "'INTERSECT'", 
			"'SEMANTICSIMILARITYTABLE'", "'COMPUTE'", "'INTO'", "'SESSION_USER'", 
			"'CONSTRAINT'", "'IS'", "'SET'", "'CONTAINS'", "'JOIN'", "'SETUSER'", 
			"'CONTAINSTABLE'", "'KEY'", "'SHUTDOWN'", "'CONTINUE'", "'KILL'", "'SOME'", 
			"'CONVERT'", "'LEFT'", "'STATISTICS'", "'CREATE'", "'LIKE'", "'SYSTEM_USER'", 
			"'CROSS'", "'LINENO'", "'TABLE'", "'CURRENT'", "'LOAD'", "'TABLESAMPLE'", 
			"'CURRENT_DATE'", "'MERGE'", "'TEXTSIZE'", "'CURRENT_TIME'", "'NATIONAL'", 
			"'THEN'", "'CURRENT_TIMESTAMP'", "'NOCHECK'", "'TO'", "'CURRENT_USER'", 
			"'NONCLUSTERED'", "'TOP'", "'CURSOR'", "'NOT'", "'TRAN'", "'DATABASE'", 
			"'NULL'", "'TRANSACTION'", "'DBCC'", "'NULLIF'", "'TRIGGER'", "'DEALLOCATE'", 
			"'OF'", "'TRUNCATE'", "'DECLARE'", "'OFF'", "'TRY_CONVERT'", "'DEFAULT'", 
			"'OFFSETS'", "'TSEQUAL'", "'DELETE'", "'ON'", "'UNION'", "'DENY'", "'OPEN'", 
			"'UNIQUE'", "'DESC'", "'OPENDATASOURCE'", "'UPDATE'", "'DISK'", "'OPENQUERY'", 
			"'UPDATETEXT'", "'DISTINCT'", "'OPENROWSET'", "'USE'", "'DISTRIBUTED'", 
			"'OPENXML'", "'USER'", "'DOUBLE'", "'OPTION'", "'VALUES'", "'DROP'", 
			"'OR'", "'VARYING'", "'DUMP'", "'ORDER'", "'VIEW'", "'ELSE'", "'OUTER'", 
			"'WAITFOR'", "'END'", "'OVER'", "'WHEN'", "'ERRLVL'", "'PERCENT'", "'WHERE'", 
			"'ESCAPE'", "'PIVOT'", "'WHILE'", "'EXCEPT'", "'PLAN'", "'WITH'", "'EXEC'", 
			"'PRECISION'", "'WRITETEXT'", "'EXECUTE'", "'PRIMARY'", "'INTEGER'", 
			"'NVARCHAR'", "'VARCHAR'", "'MAX'", "'MIN'", "'AVG'", "'SUM'", "'COUNT'", 
			"'TRY'", "'CATCH'", "'EXISTS'", null, null, null, null, "'TRUE'", "'FALSE'", 
			null, null, null, null, "'='", null, "'>'", "'<'", "'>='", "'<='", "'+'", 
			"'-'", "'*'", "'/'", "'+='", "','", "'.'", "'('", "')'", "'['", "']'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ADD", "EXTERNAL", "PROCEDURE", "ALL", "FETCH", "PUBLIC", "ALTER", 
			"FILE", "RAISERROR", "AND", "FILLFACTOR", "READ", "ANY", "FOR", "READTEXT", 
			"AS", "FOREIGN", "RECONFIGURE", "ASC", "FREETEXT", "REFERENCES", "AUTHORIZATION", 
			"FREETEXTTABLE", "REPLICATION", "BACKUP", "FROM", "RESTORE", "BEGIN", 
			"FULL", "RESTRICT", "BETWEEN", "FUNCTION", "RETURN", "BREAK", "GOTO", 
			"GO", "REVERT", "BROWSE", "GRANT", "REVOKE", "BULK", "GROUP", "RIGHT", 
			"BY", "HAVING", "ROLLBACK", "CASCADE", "HOLDLOCK", "ROWCOUNT", "CASE", 
			"IDENTITY", "ROWGUIDCOL", "CHECK", "IDENTITY_INSERT", "RULE", "CHECKPOINT", 
			"IDENTITYCOL", "SAVE", "CLOSE", "IF", "SCHEMA", "CLUSTERED", "IN", "SECURITYAUDIT", 
			"COALESCE", "INDEX", "SELECT", "COLLATE", "INNER", "SEMANTICKEYPHRASETABLE", 
			"COLUMN", "INSERT", "SEMANTICSIMILARITYDETAILSTABLE", "COMMIT", "INTERSECT", 
			"SEMANTICSIMILARITYTABLE", "COMPUTE", "INTO", "SESSION_USER", "CONSTRAINT", 
			"IS", "SET", "CONTAINS", "JOIN", "SETUSER", "CONTAINSTABLE", "KEY", "SHUTDOWN", 
			"CONTINUE", "KILL", "SOME", "CONVERT", "LEFT", "STATISTICS", "CREATE", 
			"LIKE", "SYSTEM_USER", "CROSS", "LINENO", "TABLE", "CURRENT", "LOAD", 
			"TABLESAMPLE", "CURRENT_DATE", "MERGE", "TEXTSIZE", "CURRENT_TIME", "NATIONAL", 
			"THEN", "CURRENT_TIMESTAMP", "NOCHECK", "TO", "CURRENT_USER", "NONCLUSTERED", 
			"TOP", "CURSOR", "NOT", "TRAN", "DATABASE", "NULL", "TRANSACTION", "DBCC", 
			"NULLIF", "TRIGGER", "DEALLOCATE", "OF", "TRUNCATE", "DECLARE", "OFF", 
			"TRY_CONVERT", "DEFAULT", "OFFSETS", "TSEQUAL", "DELETE", "ON", "UNION", 
			"DENY", "OPEN", "UNIQUE", "DESC", "OPENDATASOURCE", "UPDATE", "DISK", 
			"OPENQUERY", "UPDATETEXT", "DISTINCT", "OPENROWSET", "USE", "DISTRIBUTED", 
			"OPENXML", "USER", "DOUBLE", "OPTION", "VALUES", "DROP", "OR", "VARYING", 
			"DUMP", "ORDER", "VIEW", "ELSE", "OUTER", "WAITFOR", "END", "OVER", "WHEN", 
			"ERRLVL", "PERCENT", "WHERE", "ESCAPE", "PIVOT", "WHILE", "EXCEPT", "PLAN", 
			"WITH", "EXEC", "PRECISION", "WRITETEXT", "EXECUTE", "PRIMARY", "INT", 
			"NVARCHAR", "VARCHAR", "MAX", "MIN", "AVG", "SUM", "COUNT", "TRY", "CATCH", 
			"EXISTS", "INT_LITERAL", "FLOAT_LITERAL", "HEX_LITERAL", "BIT_LITERAL", 
			"TRUE_LITERAL", "FALSE_LITERAL", "STRING_LITERAL", "BRACKET_IDENTIFIER", 
			"IDENTIFIER", "USER_VAR", "EQ", "NEQ", "GT", "LT", "GTE", "LTE", "PLUS", 
			"MINUS", "STAR", "SLASH", "PLUS_EQ", "COMMA", "DOT", "LPAREN", "RPAREN", 
			"SPAREN", "ZPAREN", "SEMI", "LINE_COMMENT", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public SqlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SqlLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 200:
			STRING_LITERAL_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STRING_LITERAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			          import re
			          # replace line-continuation backslashes with space
			          self.text = re.sub(r'\\[ \t]*\r?\n[ \t]*', ' ', self.text)
			      
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\u00de\u0824\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!"+
		"\u0007!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002"+
		"&\u0007&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002"+
		"+\u0007+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u0002"+
		"0\u00070\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u0002"+
		"5\u00075\u00026\u00076\u00027\u00077\u00028\u00078\u00029\u00079\u0002"+
		":\u0007:\u0002;\u0007;\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002"+
		"?\u0007?\u0002@\u0007@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002"+
		"D\u0007D\u0002E\u0007E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002"+
		"I\u0007I\u0002J\u0007J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002"+
		"N\u0007N\u0002O\u0007O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002"+
		"S\u0007S\u0002T\u0007T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002"+
		"X\u0007X\u0002Y\u0007Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002"+
		"]\u0007]\u0002^\u0007^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002"+
		"b\u0007b\u0002c\u0007c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002"+
		"g\u0007g\u0002h\u0007h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002"+
		"l\u0007l\u0002m\u0007m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002"+
		"q\u0007q\u0002r\u0007r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002"+
		"v\u0007v\u0002w\u0007w\u0002x\u0007x\u0002y\u0007y\u0002z\u0007z\u0002"+
		"{\u0007{\u0002|\u0007|\u0002}\u0007}\u0002~\u0007~\u0002\u007f\u0007\u007f"+
		"\u0002\u0080\u0007\u0080\u0002\u0081\u0007\u0081\u0002\u0082\u0007\u0082"+
		"\u0002\u0083\u0007\u0083\u0002\u0084\u0007\u0084\u0002\u0085\u0007\u0085"+
		"\u0002\u0086\u0007\u0086\u0002\u0087\u0007\u0087\u0002\u0088\u0007\u0088"+
		"\u0002\u0089\u0007\u0089\u0002\u008a\u0007\u008a\u0002\u008b\u0007\u008b"+
		"\u0002\u008c\u0007\u008c\u0002\u008d\u0007\u008d\u0002\u008e\u0007\u008e"+
		"\u0002\u008f\u0007\u008f\u0002\u0090\u0007\u0090\u0002\u0091\u0007\u0091"+
		"\u0002\u0092\u0007\u0092\u0002\u0093\u0007\u0093\u0002\u0094\u0007\u0094"+
		"\u0002\u0095\u0007\u0095\u0002\u0096\u0007\u0096\u0002\u0097\u0007\u0097"+
		"\u0002\u0098\u0007\u0098\u0002\u0099\u0007\u0099\u0002\u009a\u0007\u009a"+
		"\u0002\u009b\u0007\u009b\u0002\u009c\u0007\u009c\u0002\u009d\u0007\u009d"+
		"\u0002\u009e\u0007\u009e\u0002\u009f\u0007\u009f\u0002\u00a0\u0007\u00a0"+
		"\u0002\u00a1\u0007\u00a1\u0002\u00a2\u0007\u00a2\u0002\u00a3\u0007\u00a3"+
		"\u0002\u00a4\u0007\u00a4\u0002\u00a5\u0007\u00a5\u0002\u00a6\u0007\u00a6"+
		"\u0002\u00a7\u0007\u00a7\u0002\u00a8\u0007\u00a8\u0002\u00a9\u0007\u00a9"+
		"\u0002\u00aa\u0007\u00aa\u0002\u00ab\u0007\u00ab\u0002\u00ac\u0007\u00ac"+
		"\u0002\u00ad\u0007\u00ad\u0002\u00ae\u0007\u00ae\u0002\u00af\u0007\u00af"+
		"\u0002\u00b0\u0007\u00b0\u0002\u00b1\u0007\u00b1\u0002\u00b2\u0007\u00b2"+
		"\u0002\u00b3\u0007\u00b3\u0002\u00b4\u0007\u00b4\u0002\u00b5\u0007\u00b5"+
		"\u0002\u00b6\u0007\u00b6\u0002\u00b7\u0007\u00b7\u0002\u00b8\u0007\u00b8"+
		"\u0002\u00b9\u0007\u00b9\u0002\u00ba\u0007\u00ba\u0002\u00bb\u0007\u00bb"+
		"\u0002\u00bc\u0007\u00bc\u0002\u00bd\u0007\u00bd\u0002\u00be\u0007\u00be"+
		"\u0002\u00bf\u0007\u00bf\u0002\u00c0\u0007\u00c0\u0002\u00c1\u0007\u00c1"+
		"\u0002\u00c2\u0007\u00c2\u0002\u00c3\u0007\u00c3\u0002\u00c4\u0007\u00c4"+
		"\u0002\u00c5\u0007\u00c5\u0002\u00c6\u0007\u00c6\u0002\u00c7\u0007\u00c7"+
		"\u0002\u00c8\u0007\u00c8\u0002\u00c9\u0007\u00c9\u0002\u00ca\u0007\u00ca"+
		"\u0002\u00cb\u0007\u00cb\u0002\u00cc\u0007\u00cc\u0002\u00cd\u0007\u00cd"+
		"\u0002\u00ce\u0007\u00ce\u0002\u00cf\u0007\u00cf\u0002\u00d0\u0007\u00d0"+
		"\u0002\u00d1\u0007\u00d1\u0002\u00d2\u0007\u00d2\u0002\u00d3\u0007\u00d3"+
		"\u0002\u00d4\u0007\u00d4\u0002\u00d5\u0007\u00d5\u0002\u00d6\u0007\u00d6"+
		"\u0002\u00d7\u0007\u00d7\u0002\u00d8\u0007\u00d8\u0002\u00d9\u0007\u00d9"+
		"\u0002\u00da\u0007\u00da\u0002\u00db\u0007\u00db\u0002\u00dc\u0007\u00dc"+
		"\u0002\u00dd\u0007\u00dd\u0002\u00de\u0007\u00de\u0002\u00df\u0007\u00df"+
		"\u0002\u00e0\u0007\u00e0\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001,\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		".\u0001.\u0001.\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"0\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00011\u0001"+
		"1\u00011\u00011\u00011\u00011\u00011\u00011\u00012\u00012\u00012\u0001"+
		"2\u00012\u00012\u00012\u00012\u00012\u00013\u00013\u00013\u00013\u0001"+
		"3\u00013\u00013\u00013\u00013\u00014\u00014\u00014\u00014\u00014\u0001"+
		"5\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001"+
		"7\u00017\u00017\u00017\u00017\u00017\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00019\u00019\u00019\u00019\u00019\u0001:\u0001:\u0001:\u0001"+
		":\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001"+
		"<\u0001<\u0001<\u0001<\u0001<\u0001=\u0001=\u0001=\u0001=\u0001=\u0001"+
		"=\u0001>\u0001>\u0001>\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001"+
		"?\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001"+
		"@\u0001A\u0001A\u0001A\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001"+
		"B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001C\u0001C\u0001"+
		"C\u0001C\u0001C\u0001C\u0001C\u0001C\u0001C\u0001D\u0001D\u0001D\u0001"+
		"D\u0001D\u0001D\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001"+
		"F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001G\u0001G\u0001"+
		"G\u0001G\u0001G\u0001G\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001"+
		"H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001"+
		"H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001I\u0001I\u0001I\u0001"+
		"I\u0001I\u0001I\u0001I\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001"+
		"J\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001M\u0001"+
		"M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001N\u0001"+
		"N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001"+
		"N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001"+
		"N\u0001N\u0001N\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001"+
		"O\u0001P\u0001P\u0001P\u0001P\u0001P\u0001Q\u0001Q\u0001Q\u0001Q\u0001"+
		"Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001R\u0001"+
		"R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001"+
		"S\u0001S\u0001S\u0001T\u0001T\u0001T\u0001T\u0001U\u0001U\u0001U\u0001"+
		"U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001V\u0001V\u0001V\u0001V\u0001"+
		"V\u0001W\u0001W\u0001W\u0001W\u0001W\u0001W\u0001W\u0001W\u0001X\u0001"+
		"X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001"+
		"X\u0001X\u0001X\u0001Y\u0001Y\u0001Y\u0001Y\u0001Z\u0001Z\u0001Z\u0001"+
		"Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001[\u0001[\u0001[\u0001[\u0001"+
		"[\u0001[\u0001[\u0001[\u0001[\u0001\\\u0001\\\u0001\\\u0001\\\u0001\\"+
		"\u0001]\u0001]\u0001]\u0001]\u0001]\u0001^\u0001^\u0001^\u0001^\u0001"+
		"^\u0001^\u0001^\u0001^\u0001_\u0001_\u0001_\u0001_\u0001_\u0001`\u0001"+
		"`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001"+
		"a\u0001a\u0001a\u0001a\u0001a\u0001a\u0001a\u0001b\u0001b\u0001b\u0001"+
		"b\u0001b\u0001c\u0001c\u0001c\u0001c\u0001c\u0001c\u0001c\u0001c\u0001"+
		"c\u0001c\u0001c\u0001c\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001"+
		"e\u0001e\u0001e\u0001e\u0001e\u0001e\u0001e\u0001f\u0001f\u0001f\u0001"+
		"f\u0001f\u0001f\u0001g\u0001g\u0001g\u0001g\u0001g\u0001g\u0001g\u0001"+
		"g\u0001h\u0001h\u0001h\u0001h\u0001h\u0001i\u0001i\u0001i\u0001i\u0001"+
		"i\u0001i\u0001i\u0001i\u0001i\u0001i\u0001i\u0001i\u0001j\u0001j\u0001"+
		"j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001"+
		"j\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001l\u0001l\u0001l\u0001"+
		"l\u0001l\u0001l\u0001l\u0001l\u0001l\u0001m\u0001m\u0001m\u0001m\u0001"+
		"m\u0001m\u0001m\u0001m\u0001m\u0001m\u0001m\u0001m\u0001m\u0001n\u0001"+
		"n\u0001n\u0001n\u0001n\u0001n\u0001n\u0001n\u0001n\u0001o\u0001o\u0001"+
		"o\u0001o\u0001o\u0001p\u0001p\u0001p\u0001p\u0001p\u0001p\u0001p\u0001"+
		"p\u0001p\u0001p\u0001p\u0001p\u0001p\u0001p\u0001p\u0001p\u0001p\u0001"+
		"p\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001r\u0001"+
		"r\u0001r\u0001s\u0001s\u0001s\u0001s\u0001s\u0001s\u0001s\u0001s\u0001"+
		"s\u0001s\u0001s\u0001s\u0001s\u0001t\u0001t\u0001t\u0001t\u0001t\u0001"+
		"t\u0001t\u0001t\u0001t\u0001t\u0001t\u0001t\u0001t\u0001u\u0001u\u0001"+
		"u\u0001u\u0001v\u0001v\u0001v\u0001v\u0001v\u0001v\u0001v\u0001w\u0001"+
		"w\u0001w\u0001w\u0001x\u0001x\u0001x\u0001x\u0001x\u0001y\u0001y\u0001"+
		"y\u0001y\u0001y\u0001y\u0001y\u0001y\u0001y\u0001z\u0001z\u0001z\u0001"+
		"z\u0001z\u0001{\u0001{\u0001{\u0001{\u0001{\u0001{\u0001{\u0001{\u0001"+
		"{\u0001{\u0001{\u0001{\u0001|\u0001|\u0001|\u0001|\u0001|\u0001}\u0001"+
		"}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001~\u0001~\u0001~\u0001~\u0001"+
		"~\u0001~\u0001~\u0001~\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u007f"+
		"\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u007f"+
		"\u0001\u007f\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0081\u0001\u0081"+
		"\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081"+
		"\u0001\u0081\u0001\u0082\u0001\u0082\u0001\u0082\u0001\u0082\u0001\u0082"+
		"\u0001\u0082\u0001\u0082\u0001\u0082\u0001\u0083\u0001\u0083\u0001\u0083"+
		"\u0001\u0083\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084"+
		"\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084"+
		"\u0001\u0084\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085"+
		"\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0086\u0001\u0086\u0001\u0086"+
		"\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0087"+
		"\u0001\u0087\u0001\u0087\u0001\u0087\u0001\u0087\u0001\u0087\u0001\u0087"+
		"\u0001\u0087\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0088"+
		"\u0001\u0088\u0001\u0088\u0001\u0089\u0001\u0089\u0001\u0089\u0001\u008a"+
		"\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008b"+
		"\u0001\u008b\u0001\u008b\u0001\u008b\u0001\u008b\u0001\u008c\u0001\u008c"+
		"\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008d\u0001\u008d\u0001\u008d"+
		"\u0001\u008d\u0001\u008d\u0001\u008d\u0001\u008d\u0001\u008e\u0001\u008e"+
		"\u0001\u008e\u0001\u008e\u0001\u008e\u0001\u008f\u0001\u008f\u0001\u008f"+
		"\u0001\u008f\u0001\u008f\u0001\u008f\u0001\u008f\u0001\u008f\u0001\u008f"+
		"\u0001\u008f\u0001\u008f\u0001\u008f\u0001\u008f\u0001\u008f\u0001\u008f"+
		"\u0001\u0090\u0001\u0090\u0001\u0090\u0001\u0090\u0001\u0090\u0001\u0090"+
		"\u0001\u0090\u0001\u0091\u0001\u0091\u0001\u0091\u0001\u0091\u0001\u0091"+
		"\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0092"+
		"\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0093\u0001\u0093"+
		"\u0001\u0093\u0001\u0093\u0001\u0093\u0001\u0093\u0001\u0093\u0001\u0093"+
		"\u0001\u0093\u0001\u0093\u0001\u0093\u0001\u0094\u0001\u0094\u0001\u0094"+
		"\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094"+
		"\u0001\u0095\u0001\u0095\u0001\u0095\u0001\u0095\u0001\u0095\u0001\u0095"+
		"\u0001\u0095\u0001\u0095\u0001\u0095\u0001\u0095\u0001\u0095\u0001\u0096"+
		"\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0097\u0001\u0097\u0001\u0097"+
		"\u0001\u0097\u0001\u0097\u0001\u0097\u0001\u0097\u0001\u0097\u0001\u0097"+
		"\u0001\u0097\u0001\u0097\u0001\u0097\u0001\u0098\u0001\u0098\u0001\u0098"+
		"\u0001\u0098\u0001\u0098\u0001\u0098\u0001\u0098\u0001\u0098\u0001\u0099"+
		"\u0001\u0099\u0001\u0099\u0001\u0099\u0001\u0099\u0001\u009a\u0001\u009a"+
		"\u0001\u009a\u0001\u009a\u0001\u009a\u0001\u009a\u0001\u009a\u0001\u009b"+
		"\u0001\u009b\u0001\u009b\u0001\u009b\u0001\u009b\u0001\u009b\u0001\u009b"+
		"\u0001\u009c\u0001\u009c\u0001\u009c\u0001\u009c\u0001\u009c\u0001\u009c"+
		"\u0001\u009c\u0001\u009d\u0001\u009d\u0001\u009d\u0001\u009d\u0001\u009d"+
		"\u0001\u009e\u0001\u009e\u0001\u009e\u0001\u009f\u0001\u009f\u0001\u009f"+
		"\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u00a0"+
		"\u0001\u00a0\u0001\u00a0\u0001\u00a0\u0001\u00a0\u0001\u00a1\u0001\u00a1"+
		"\u0001\u00a1\u0001\u00a1\u0001\u00a1\u0001\u00a1\u0001\u00a2\u0001\u00a2"+
		"\u0001\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a3\u0001\u00a3\u0001\u00a3"+
		"\u0001\u00a3\u0001\u00a3\u0001\u00a4\u0001\u00a4\u0001\u00a4\u0001\u00a4"+
		"\u0001\u00a4\u0001\u00a4\u0001\u00a5\u0001\u00a5\u0001\u00a5\u0001\u00a5"+
		"\u0001\u00a5\u0001\u00a5\u0001\u00a5\u0001\u00a5\u0001\u00a6\u0001\u00a6"+
		"\u0001\u00a6\u0001\u00a6\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a7"+
		"\u0001\u00a7\u0001\u00a8\u0001\u00a8\u0001\u00a8\u0001\u00a8\u0001\u00a8"+
		"\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9"+
		"\u0001\u00a9\u0001\u00aa\u0001\u00aa\u0001\u00aa\u0001\u00aa\u0001\u00aa"+
		"\u0001\u00aa\u0001\u00aa\u0001\u00aa\u0001\u00ab\u0001\u00ab\u0001\u00ab"+
		"\u0001\u00ab\u0001\u00ab\u0001\u00ab\u0001\u00ac\u0001\u00ac\u0001\u00ac"+
		"\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ad\u0001\u00ad"+
		"\u0001\u00ad\u0001\u00ad\u0001\u00ad\u0001\u00ad\u0001\u00ae\u0001\u00ae"+
		"\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0001\u00af\u0001\u00af"+
		"\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00b0"+
		"\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b1\u0001\u00b1"+
		"\u0001\u00b1\u0001\u00b1\u0001\u00b1\u0001\u00b2\u0001\u00b2\u0001\u00b2"+
		"\u0001\u00b2\u0001\u00b2\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3"+
		"\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3"+
		"\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0001\u00b4"+
		"\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0001\u00b5\u0001\u00b5"+
		"\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5"+
		"\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6"+
		"\u0001\u00b6\u0001\u00b6\u0001\u00b7\u0001\u00b7\u0001\u00b7\u0001\u00b7"+
		"\u0001\u00b7\u0001\u00b7\u0001\u00b7\u0001\u00b7\u0001\u00b8\u0001\u00b8"+
		"\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8"+
		"\u0001\u00b8\u0001\u00b9\u0001\u00b9\u0001\u00b9\u0001\u00b9\u0001\u00b9"+
		"\u0001\u00b9\u0001\u00b9\u0001\u00b9\u0001\u00ba\u0001\u00ba\u0001\u00ba"+
		"\u0001\u00ba\u0001\u00bb\u0001\u00bb\u0001\u00bb\u0001\u00bb\u0001\u00bc"+
		"\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bd\u0001\u00bd\u0001\u00bd"+
		"\u0001\u00bd\u0001\u00be\u0001\u00be\u0001\u00be\u0001\u00be\u0001\u00be"+
		"\u0001\u00be\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00c0"+
		"\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0001\u00c1"+
		"\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0001\u00c1"+
		"\u0001\u00c2\u0004\u00c2\u077b\b\u00c2\u000b\u00c2\f\u00c2\u077c\u0001"+
		"\u00c3\u0004\u00c3\u0780\b\u00c3\u000b\u00c3\f\u00c3\u0781\u0001\u00c3"+
		"\u0001\u00c3\u0004\u00c3\u0786\b\u00c3\u000b\u00c3\f\u00c3\u0787\u0001"+
		"\u00c4\u0001\u00c4\u0004\u00c4\u078c\b\u00c4\u000b\u00c4\f\u00c4\u078d"+
		"\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0004\u00c5\u0794\b\u00c5"+
		"\u000b\u00c5\f\u00c5\u0795\u0001\u00c6\u0001\u00c6\u0001\u00c6\u0001\u00c6"+
		"\u0001\u00c6\u0001\u00c7\u0001\u00c7\u0001\u00c7\u0001\u00c7\u0001\u00c7"+
		"\u0001\u00c7\u0001\u00c8\u0003\u00c8\u07a4\b\u00c8\u0001\u00c8\u0001\u00c8"+
		"\u0001\u00c8\u0001\u00c8\u0001\u00c8\u0001\u00c8\u0001\u00c8\u0001\u00c8"+
		"\u0005\u00c8\u07ae\b\u00c8\n\u00c8\f\u00c8\u07b1\t\u00c8\u0001\u00c8\u0003"+
		"\u00c8\u07b4\b\u00c8\u0001\u00c8\u0001\u00c8\u0005\u00c8\u07b8\b\u00c8"+
		"\n\u00c8\f\u00c8\u07bb\t\u00c8\u0005\u00c8\u07bd\b\u00c8\n\u00c8\f\u00c8"+
		"\u07c0\t\u00c8\u0001\u00c8\u0001\u00c8\u0001\u00c8\u0001\u00c9\u0001\u00c9"+
		"\u0005\u00c9\u07c7\b\u00c9\n\u00c9\f\u00c9\u07ca\t\u00c9\u0001\u00c9\u0001"+
		"\u00c9\u0001\u00ca\u0001\u00ca\u0001\u00ca\u0005\u00ca\u07d1\b\u00ca\n"+
		"\u00ca\f\u00ca\u07d4\t\u00ca\u0001\u00cb\u0001\u00cb\u0001\u00cb\u0001"+
		"\u00cc\u0001\u00cc\u0001\u00cd\u0001\u00cd\u0001\u00cd\u0001\u00cd\u0003"+
		"\u00cd\u07df\b\u00cd\u0001\u00ce\u0001\u00ce\u0001\u00cf\u0001\u00cf\u0001"+
		"\u00d0\u0001\u00d0\u0001\u00d0\u0001\u00d1\u0001\u00d1\u0001\u00d1\u0001"+
		"\u00d2\u0001\u00d2\u0001\u00d3\u0001\u00d3\u0001\u00d4\u0001\u00d4\u0001"+
		"\u00d5\u0001\u00d5\u0001\u00d6\u0001\u00d6\u0001\u00d6\u0001\u00d7\u0001"+
		"\u00d7\u0001\u00d8\u0001\u00d8\u0001\u00d9\u0001\u00d9\u0001\u00da\u0001"+
		"\u00da\u0001\u00db\u0001\u00db\u0001\u00dc\u0001\u00dc\u0001\u00dd\u0001"+
		"\u00dd\u0001\u00de\u0001\u00de\u0001\u00de\u0001\u00de\u0005\u00de\u0808"+
		"\b\u00de\n\u00de\f\u00de\u080b\t\u00de\u0001\u00de\u0001\u00de\u0001\u00df"+
		"\u0001\u00df\u0001\u00df\u0001\u00df\u0001\u00df\u0005\u00df\u0814\b\u00df"+
		"\n\u00df\f\u00df\u0817\t\u00df\u0001\u00df\u0001\u00df\u0001\u00df\u0001"+
		"\u00df\u0001\u00df\u0001\u00e0\u0004\u00e0\u081f\b\u00e0\u000b\u00e0\f"+
		"\u00e0\u0820\u0001\u00e0\u0001\u00e0\u0001\u0815\u0000\u00e1\u0001\u0000"+
		"\u0003\u0000\u0005\u0000\u0007\u0001\t\u0002\u000b\u0003\r\u0004\u000f"+
		"\u0005\u0011\u0006\u0013\u0007\u0015\b\u0017\t\u0019\n\u001b\u000b\u001d"+
		"\f\u001f\r!\u000e#\u000f%\u0010\'\u0011)\u0012+\u0013-\u0014/\u00151\u0016"+
		"3\u00175\u00187\u00199\u001a;\u001b=\u001c?\u001dA\u001eC\u001fE G!I\""+
		"K#M$O%Q&S\'U(W)Y*[+],_-a.c/e0g1i2k3m4o5q6s7u8w9y:{;}<\u007f=\u0081>\u0083"+
		"?\u0085@\u0087A\u0089B\u008bC\u008dD\u008fE\u0091F\u0093G\u0095H\u0097"+
		"I\u0099J\u009bK\u009dL\u009fM\u00a1N\u00a3O\u00a5P\u00a7Q\u00a9R\u00ab"+
		"S\u00adT\u00afU\u00b1V\u00b3W\u00b5X\u00b7Y\u00b9Z\u00bb[\u00bd\\\u00bf"+
		"]\u00c1^\u00c3_\u00c5`\u00c7a\u00c9b\u00cbc\u00cdd\u00cfe\u00d1f\u00d3"+
		"g\u00d5h\u00d7i\u00d9j\u00dbk\u00ddl\u00dfm\u00e1n\u00e3o\u00e5p\u00e7"+
		"q\u00e9r\u00ebs\u00edt\u00efu\u00f1v\u00f3w\u00f5x\u00f7y\u00f9z\u00fb"+
		"{\u00fd|\u00ff}\u0101~\u0103\u007f\u0105\u0080\u0107\u0081\u0109\u0082"+
		"\u010b\u0083\u010d\u0084\u010f\u0085\u0111\u0086\u0113\u0087\u0115\u0088"+
		"\u0117\u0089\u0119\u008a\u011b\u008b\u011d\u008c\u011f\u008d\u0121\u008e"+
		"\u0123\u008f\u0125\u0090\u0127\u0091\u0129\u0092\u012b\u0093\u012d\u0094"+
		"\u012f\u0095\u0131\u0096\u0133\u0097\u0135\u0098\u0137\u0099\u0139\u009a"+
		"\u013b\u009b\u013d\u009c\u013f\u009d\u0141\u009e\u0143\u009f\u0145\u00a0"+
		"\u0147\u00a1\u0149\u00a2\u014b\u00a3\u014d\u00a4\u014f\u00a5\u0151\u00a6"+
		"\u0153\u00a7\u0155\u00a8\u0157\u00a9\u0159\u00aa\u015b\u00ab\u015d\u00ac"+
		"\u015f\u00ad\u0161\u00ae\u0163\u00af\u0165\u00b0\u0167\u00b1\u0169\u00b2"+
		"\u016b\u00b3\u016d\u00b4\u016f\u00b5\u0171\u00b6\u0173\u00b7\u0175\u00b8"+
		"\u0177\u00b9\u0179\u00ba\u017b\u00bb\u017d\u00bc\u017f\u00bd\u0181\u00be"+
		"\u0183\u00bf\u0185\u00c0\u0187\u00c1\u0189\u00c2\u018b\u00c3\u018d\u00c4"+
		"\u018f\u00c5\u0191\u00c6\u0193\u00c7\u0195\u00c8\u0197\u00c9\u0199\u00ca"+
		"\u019b\u00cb\u019d\u00cc\u019f\u00cd\u01a1\u00ce\u01a3\u00cf\u01a5\u00d0"+
		"\u01a7\u00d1\u01a9\u00d2\u01ab\u00d3\u01ad\u00d4\u01af\u00d5\u01b1\u00d6"+
		"\u01b3\u00d7\u01b5\u00d8\u01b7\u00d9\u01b9\u00da\u01bb\u00db\u01bd\u00dc"+
		"\u01bf\u00dd\u01c1\u00de\u0001\u0000#\u0001\u000009\u0003\u0000AZ__az"+
		"\u0003\u000009AFaf\u0002\u0000AAaa\u0002\u0000DDdd\u0002\u0000EEee\u0002"+
		"\u0000XXxx\u0002\u0000TTtt\u0002\u0000RRrr\u0002\u0000NNnn\u0002\u0000"+
		"LLll\u0002\u0000PPpp\u0002\u0000OOoo\u0002\u0000CCcc\u0002\u0000UUuu\u0002"+
		"\u0000FFff\u0002\u0000HHhh\u0002\u0000BBbb\u0002\u0000IIii\u0002\u0000"+
		"SSss\u0002\u0000YYyy\u0002\u0000GGgg\u0002\u0000ZZzz\u0002\u0000KKkk\u0002"+
		"\u0000MMmm\u0002\u0000WWww\u0002\u0000VVvv\u0002\u0000JJjj\u0002\u0000"+
		"QQqq\u0001\u000001\u0002\u0000\'\'\\\\\u0002\u0000\t\t  \u0003\u0000\n"+
		"\n\r\r]]\u0002\u0000\n\n\r\r\u0003\u0000\t\n\r\r  \u0835\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000"+
		"%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001"+
		"\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000"+
		"\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000"+
		"A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001"+
		"\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000"+
		"\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000"+
		"O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001"+
		"\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001\u0000\u0000"+
		"\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000\u0000\u0000"+
		"]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0000a\u0001"+
		"\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000e\u0001\u0000\u0000"+
		"\u0000\u0000g\u0001\u0000\u0000\u0000\u0000i\u0001\u0000\u0000\u0000\u0000"+
		"k\u0001\u0000\u0000\u0000\u0000m\u0001\u0000\u0000\u0000\u0000o\u0001"+
		"\u0000\u0000\u0000\u0000q\u0001\u0000\u0000\u0000\u0000s\u0001\u0000\u0000"+
		"\u0000\u0000u\u0001\u0000\u0000\u0000\u0000w\u0001\u0000\u0000\u0000\u0000"+
		"y\u0001\u0000\u0000\u0000\u0000{\u0001\u0000\u0000\u0000\u0000}\u0001"+
		"\u0000\u0000\u0000\u0000\u007f\u0001\u0000\u0000\u0000\u0000\u0081\u0001"+
		"\u0000\u0000\u0000\u0000\u0083\u0001\u0000\u0000\u0000\u0000\u0085\u0001"+
		"\u0000\u0000\u0000\u0000\u0087\u0001\u0000\u0000\u0000\u0000\u0089\u0001"+
		"\u0000\u0000\u0000\u0000\u008b\u0001\u0000\u0000\u0000\u0000\u008d\u0001"+
		"\u0000\u0000\u0000\u0000\u008f\u0001\u0000\u0000\u0000\u0000\u0091\u0001"+
		"\u0000\u0000\u0000\u0000\u0093\u0001\u0000\u0000\u0000\u0000\u0095\u0001"+
		"\u0000\u0000\u0000\u0000\u0097\u0001\u0000\u0000\u0000\u0000\u0099\u0001"+
		"\u0000\u0000\u0000\u0000\u009b\u0001\u0000\u0000\u0000\u0000\u009d\u0001"+
		"\u0000\u0000\u0000\u0000\u009f\u0001\u0000\u0000\u0000\u0000\u00a1\u0001"+
		"\u0000\u0000\u0000\u0000\u00a3\u0001\u0000\u0000\u0000\u0000\u00a5\u0001"+
		"\u0000\u0000\u0000\u0000\u00a7\u0001\u0000\u0000\u0000\u0000\u00a9\u0001"+
		"\u0000\u0000\u0000\u0000\u00ab\u0001\u0000\u0000\u0000\u0000\u00ad\u0001"+
		"\u0000\u0000\u0000\u0000\u00af\u0001\u0000\u0000\u0000\u0000\u00b1\u0001"+
		"\u0000\u0000\u0000\u0000\u00b3\u0001\u0000\u0000\u0000\u0000\u00b5\u0001"+
		"\u0000\u0000\u0000\u0000\u00b7\u0001\u0000\u0000\u0000\u0000\u00b9\u0001"+
		"\u0000\u0000\u0000\u0000\u00bb\u0001\u0000\u0000\u0000\u0000\u00bd\u0001"+
		"\u0000\u0000\u0000\u0000\u00bf\u0001\u0000\u0000\u0000\u0000\u00c1\u0001"+
		"\u0000\u0000\u0000\u0000\u00c3\u0001\u0000\u0000\u0000\u0000\u00c5\u0001"+
		"\u0000\u0000\u0000\u0000\u00c7\u0001\u0000\u0000\u0000\u0000\u00c9\u0001"+
		"\u0000\u0000\u0000\u0000\u00cb\u0001\u0000\u0000\u0000\u0000\u00cd\u0001"+
		"\u0000\u0000\u0000\u0000\u00cf\u0001\u0000\u0000\u0000\u0000\u00d1\u0001"+
		"\u0000\u0000\u0000\u0000\u00d3\u0001\u0000\u0000\u0000\u0000\u00d5\u0001"+
		"\u0000\u0000\u0000\u0000\u00d7\u0001\u0000\u0000\u0000\u0000\u00d9\u0001"+
		"\u0000\u0000\u0000\u0000\u00db\u0001\u0000\u0000\u0000\u0000\u00dd\u0001"+
		"\u0000\u0000\u0000\u0000\u00df\u0001\u0000\u0000\u0000\u0000\u00e1\u0001"+
		"\u0000\u0000\u0000\u0000\u00e3\u0001\u0000\u0000\u0000\u0000\u00e5\u0001"+
		"\u0000\u0000\u0000\u0000\u00e7\u0001\u0000\u0000\u0000\u0000\u00e9\u0001"+
		"\u0000\u0000\u0000\u0000\u00eb\u0001\u0000\u0000\u0000\u0000\u00ed\u0001"+
		"\u0000\u0000\u0000\u0000\u00ef\u0001\u0000\u0000\u0000\u0000\u00f1\u0001"+
		"\u0000\u0000\u0000\u0000\u00f3\u0001\u0000\u0000\u0000\u0000\u00f5\u0001"+
		"\u0000\u0000\u0000\u0000\u00f7\u0001\u0000\u0000\u0000\u0000\u00f9\u0001"+
		"\u0000\u0000\u0000\u0000\u00fb\u0001\u0000\u0000\u0000\u0000\u00fd\u0001"+
		"\u0000\u0000\u0000\u0000\u00ff\u0001\u0000\u0000\u0000\u0000\u0101\u0001"+
		"\u0000\u0000\u0000\u0000\u0103\u0001\u0000\u0000\u0000\u0000\u0105\u0001"+
		"\u0000\u0000\u0000\u0000\u0107\u0001\u0000\u0000\u0000\u0000\u0109\u0001"+
		"\u0000\u0000\u0000\u0000\u010b\u0001\u0000\u0000\u0000\u0000\u010d\u0001"+
		"\u0000\u0000\u0000\u0000\u010f\u0001\u0000\u0000\u0000\u0000\u0111\u0001"+
		"\u0000\u0000\u0000\u0000\u0113\u0001\u0000\u0000\u0000\u0000\u0115\u0001"+
		"\u0000\u0000\u0000\u0000\u0117\u0001\u0000\u0000\u0000\u0000\u0119\u0001"+
		"\u0000\u0000\u0000\u0000\u011b\u0001\u0000\u0000\u0000\u0000\u011d\u0001"+
		"\u0000\u0000\u0000\u0000\u011f\u0001\u0000\u0000\u0000\u0000\u0121\u0001"+
		"\u0000\u0000\u0000\u0000\u0123\u0001\u0000\u0000\u0000\u0000\u0125\u0001"+
		"\u0000\u0000\u0000\u0000\u0127\u0001\u0000\u0000\u0000\u0000\u0129\u0001"+
		"\u0000\u0000\u0000\u0000\u012b\u0001\u0000\u0000\u0000\u0000\u012d\u0001"+
		"\u0000\u0000\u0000\u0000\u012f\u0001\u0000\u0000\u0000\u0000\u0131\u0001"+
		"\u0000\u0000\u0000\u0000\u0133\u0001\u0000\u0000\u0000\u0000\u0135\u0001"+
		"\u0000\u0000\u0000\u0000\u0137\u0001\u0000\u0000\u0000\u0000\u0139\u0001"+
		"\u0000\u0000\u0000\u0000\u013b\u0001\u0000\u0000\u0000\u0000\u013d\u0001"+
		"\u0000\u0000\u0000\u0000\u013f\u0001\u0000\u0000\u0000\u0000\u0141\u0001"+
		"\u0000\u0000\u0000\u0000\u0143\u0001\u0000\u0000\u0000\u0000\u0145\u0001"+
		"\u0000\u0000\u0000\u0000\u0147\u0001\u0000\u0000\u0000\u0000\u0149\u0001"+
		"\u0000\u0000\u0000\u0000\u014b\u0001\u0000\u0000\u0000\u0000\u014d\u0001"+
		"\u0000\u0000\u0000\u0000\u014f\u0001\u0000\u0000\u0000\u0000\u0151\u0001"+
		"\u0000\u0000\u0000\u0000\u0153\u0001\u0000\u0000\u0000\u0000\u0155\u0001"+
		"\u0000\u0000\u0000\u0000\u0157\u0001\u0000\u0000\u0000\u0000\u0159\u0001"+
		"\u0000\u0000\u0000\u0000\u015b\u0001\u0000\u0000\u0000\u0000\u015d\u0001"+
		"\u0000\u0000\u0000\u0000\u015f\u0001\u0000\u0000\u0000\u0000\u0161\u0001"+
		"\u0000\u0000\u0000\u0000\u0163\u0001\u0000\u0000\u0000\u0000\u0165\u0001"+
		"\u0000\u0000\u0000\u0000\u0167\u0001\u0000\u0000\u0000\u0000\u0169\u0001"+
		"\u0000\u0000\u0000\u0000\u016b\u0001\u0000\u0000\u0000\u0000\u016d\u0001"+
		"\u0000\u0000\u0000\u0000\u016f\u0001\u0000\u0000\u0000\u0000\u0171\u0001"+
		"\u0000\u0000\u0000\u0000\u0173\u0001\u0000\u0000\u0000\u0000\u0175\u0001"+
		"\u0000\u0000\u0000\u0000\u0177\u0001\u0000\u0000\u0000\u0000\u0179\u0001"+
		"\u0000\u0000\u0000\u0000\u017b\u0001\u0000\u0000\u0000\u0000\u017d\u0001"+
		"\u0000\u0000\u0000\u0000\u017f\u0001\u0000\u0000\u0000\u0000\u0181\u0001"+
		"\u0000\u0000\u0000\u0000\u0183\u0001\u0000\u0000\u0000\u0000\u0185\u0001"+
		"\u0000\u0000\u0000\u0000\u0187\u0001\u0000\u0000\u0000\u0000\u0189\u0001"+
		"\u0000\u0000\u0000\u0000\u018b\u0001\u0000\u0000\u0000\u0000\u018d\u0001"+
		"\u0000\u0000\u0000\u0000\u018f\u0001\u0000\u0000\u0000\u0000\u0191\u0001"+
		"\u0000\u0000\u0000\u0000\u0193\u0001\u0000\u0000\u0000\u0000\u0195\u0001"+
		"\u0000\u0000\u0000\u0000\u0197\u0001\u0000\u0000\u0000\u0000\u0199\u0001"+
		"\u0000\u0000\u0000\u0000\u019b\u0001\u0000\u0000\u0000\u0000\u019d\u0001"+
		"\u0000\u0000\u0000\u0000\u019f\u0001\u0000\u0000\u0000\u0000\u01a1\u0001"+
		"\u0000\u0000\u0000\u0000\u01a3\u0001\u0000\u0000\u0000\u0000\u01a5\u0001"+
		"\u0000\u0000\u0000\u0000\u01a7\u0001\u0000\u0000\u0000\u0000\u01a9\u0001"+
		"\u0000\u0000\u0000\u0000\u01ab\u0001\u0000\u0000\u0000\u0000\u01ad\u0001"+
		"\u0000\u0000\u0000\u0000\u01af\u0001\u0000\u0000\u0000\u0000\u01b1\u0001"+
		"\u0000\u0000\u0000\u0000\u01b3\u0001\u0000\u0000\u0000\u0000\u01b5\u0001"+
		"\u0000\u0000\u0000\u0000\u01b7\u0001\u0000\u0000\u0000\u0000\u01b9\u0001"+
		"\u0000\u0000\u0000\u0000\u01bb\u0001\u0000\u0000\u0000\u0000\u01bd\u0001"+
		"\u0000\u0000\u0000\u0000\u01bf\u0001\u0000\u0000\u0000\u0000\u01c1\u0001"+
		"\u0000\u0000\u0000\u0001\u01c3\u0001\u0000\u0000\u0000\u0003\u01c5\u0001"+
		"\u0000\u0000\u0000\u0005\u01c7\u0001\u0000\u0000\u0000\u0007\u01c9\u0001"+
		"\u0000\u0000\u0000\t\u01cd\u0001\u0000\u0000\u0000\u000b\u01d6\u0001\u0000"+
		"\u0000\u0000\r\u01e0\u0001\u0000\u0000\u0000\u000f\u01e4\u0001\u0000\u0000"+
		"\u0000\u0011\u01ea\u0001\u0000\u0000\u0000\u0013\u01f1\u0001\u0000\u0000"+
		"\u0000\u0015\u01f7\u0001\u0000\u0000\u0000\u0017\u01fc\u0001\u0000\u0000"+
		"\u0000\u0019\u0206\u0001\u0000\u0000\u0000\u001b\u020a\u0001\u0000\u0000"+
		"\u0000\u001d\u0215\u0001\u0000\u0000\u0000\u001f\u021a\u0001\u0000\u0000"+
		"\u0000!\u021e\u0001\u0000\u0000\u0000#\u0222\u0001\u0000\u0000\u0000%"+
		"\u022b\u0001\u0000\u0000\u0000\'\u022e\u0001\u0000\u0000\u0000)\u0236"+
		"\u0001\u0000\u0000\u0000+\u0242\u0001\u0000\u0000\u0000-\u0246\u0001\u0000"+
		"\u0000\u0000/\u024f\u0001\u0000\u0000\u00001\u025a\u0001\u0000\u0000\u0000"+
		"3\u0268\u0001\u0000\u0000\u00005\u0276\u0001\u0000\u0000\u00007\u0282"+
		"\u0001\u0000\u0000\u00009\u0289\u0001\u0000\u0000\u0000;\u028e\u0001\u0000"+
		"\u0000\u0000=\u0296\u0001\u0000\u0000\u0000?\u029c\u0001\u0000\u0000\u0000"+
		"A\u02a1\u0001\u0000\u0000\u0000C\u02aa\u0001\u0000\u0000\u0000E\u02b2"+
		"\u0001\u0000\u0000\u0000G\u02bb\u0001\u0000\u0000\u0000I\u02c2\u0001\u0000"+
		"\u0000\u0000K\u02c8\u0001\u0000\u0000\u0000M\u02cd\u0001\u0000\u0000\u0000"+
		"O\u02d2\u0001\u0000\u0000\u0000Q\u02d9\u0001\u0000\u0000\u0000S\u02e0"+
		"\u0001\u0000\u0000\u0000U\u02e6\u0001\u0000\u0000\u0000W\u02ed\u0001\u0000"+
		"\u0000\u0000Y\u02f2\u0001\u0000\u0000\u0000[\u02f8\u0001\u0000\u0000\u0000"+
		"]\u02fe\u0001\u0000\u0000\u0000_\u0301\u0001\u0000\u0000\u0000a\u0308"+
		"\u0001\u0000\u0000\u0000c\u0311\u0001\u0000\u0000\u0000e\u0319\u0001\u0000"+
		"\u0000\u0000g\u0322\u0001\u0000\u0000\u0000i\u032b\u0001\u0000\u0000\u0000"+
		"k\u0330\u0001\u0000\u0000\u0000m\u0339\u0001\u0000\u0000\u0000o\u0344"+
		"\u0001\u0000\u0000\u0000q\u034a\u0001\u0000\u0000\u0000s\u035a\u0001\u0000"+
		"\u0000\u0000u\u035f\u0001\u0000\u0000\u0000w\u036a\u0001\u0000\u0000\u0000"+
		"y\u0376\u0001\u0000\u0000\u0000{\u037b\u0001\u0000\u0000\u0000}\u0381"+
		"\u0001\u0000\u0000\u0000\u007f\u0384\u0001\u0000\u0000\u0000\u0081\u038b"+
		"\u0001\u0000\u0000\u0000\u0083\u0395\u0001\u0000\u0000\u0000\u0085\u0398"+
		"\u0001\u0000\u0000\u0000\u0087\u03a6\u0001\u0000\u0000\u0000\u0089\u03af"+
		"\u0001\u0000\u0000\u0000\u008b\u03b5\u0001\u0000\u0000\u0000\u008d\u03bc"+
		"\u0001\u0000\u0000\u0000\u008f\u03c4\u0001\u0000\u0000\u0000\u0091\u03ca"+
		"\u0001\u0000\u0000\u0000\u0093\u03e1\u0001\u0000\u0000\u0000\u0095\u03e8"+
		"\u0001\u0000\u0000\u0000\u0097\u03ef\u0001\u0000\u0000\u0000\u0099\u040e"+
		"\u0001\u0000\u0000\u0000\u009b\u0415\u0001\u0000\u0000\u0000\u009d\u041f"+
		"\u0001\u0000\u0000\u0000\u009f\u0437\u0001\u0000\u0000\u0000\u00a1\u043f"+
		"\u0001\u0000\u0000\u0000\u00a3\u0444\u0001\u0000\u0000\u0000\u00a5\u0451"+
		"\u0001\u0000\u0000\u0000\u00a7\u045c\u0001\u0000\u0000\u0000\u00a9\u045f"+
		"\u0001\u0000\u0000\u0000\u00ab\u0463\u0001\u0000\u0000\u0000\u00ad\u046c"+
		"\u0001\u0000\u0000\u0000\u00af\u0471\u0001\u0000\u0000\u0000\u00b1\u0479"+
		"\u0001\u0000\u0000\u0000\u00b3\u0487\u0001\u0000\u0000\u0000\u00b5\u048b"+
		"\u0001\u0000\u0000\u0000\u00b7\u0494\u0001\u0000\u0000\u0000\u00b9\u049d"+
		"\u0001\u0000\u0000\u0000\u00bb\u04a2\u0001\u0000\u0000\u0000\u00bd\u04a7"+
		"\u0001\u0000\u0000\u0000\u00bf\u04af\u0001\u0000\u0000\u0000\u00c1\u04b4"+
		"\u0001\u0000\u0000\u0000\u00c3\u04bf\u0001\u0000\u0000\u0000\u00c5\u04c6"+
		"\u0001\u0000\u0000\u0000\u00c7\u04cb\u0001\u0000\u0000\u0000\u00c9\u04d7"+
		"\u0001\u0000\u0000\u0000\u00cb\u04dd\u0001\u0000\u0000\u0000\u00cd\u04e4"+
		"\u0001\u0000\u0000\u0000\u00cf\u04ea\u0001\u0000\u0000\u0000\u00d1\u04f2"+
		"\u0001\u0000\u0000\u0000\u00d3\u04f7\u0001\u0000\u0000\u0000\u00d5\u0503"+
		"\u0001\u0000\u0000\u0000\u00d7\u0510\u0001\u0000\u0000\u0000\u00d9\u0516"+
		"\u0001\u0000\u0000\u0000\u00db\u051f\u0001\u0000\u0000\u0000\u00dd\u052c"+
		"\u0001\u0000\u0000\u0000\u00df\u0535\u0001\u0000\u0000\u0000\u00e1\u053a"+
		"\u0001\u0000\u0000\u0000\u00e3\u054c\u0001\u0000\u0000\u0000\u00e5\u0554"+
		"\u0001\u0000\u0000\u0000\u00e7\u0557\u0001\u0000\u0000\u0000\u00e9\u0564"+
		"\u0001\u0000\u0000\u0000\u00eb\u0571\u0001\u0000\u0000\u0000\u00ed\u0575"+
		"\u0001\u0000\u0000\u0000\u00ef\u057c\u0001\u0000\u0000\u0000\u00f1\u0580"+
		"\u0001\u0000\u0000\u0000\u00f3\u0585\u0001\u0000\u0000\u0000\u00f5\u058e"+
		"\u0001\u0000\u0000\u0000\u00f7\u0593\u0001\u0000\u0000\u0000\u00f9\u059f"+
		"\u0001\u0000\u0000\u0000\u00fb\u05a4\u0001\u0000\u0000\u0000\u00fd\u05ab"+
		"\u0001\u0000\u0000\u0000\u00ff\u05b3\u0001\u0000\u0000\u0000\u0101\u05be"+
		"\u0001\u0000\u0000\u0000\u0103\u05c1\u0001\u0000\u0000\u0000\u0105\u05ca"+
		"\u0001\u0000\u0000\u0000\u0107\u05d2\u0001\u0000\u0000\u0000\u0109\u05d6"+
		"\u0001\u0000\u0000\u0000\u010b\u05e2\u0001\u0000\u0000\u0000\u010d\u05ea"+
		"\u0001\u0000\u0000\u0000\u010f\u05f2\u0001\u0000\u0000\u0000\u0111\u05fa"+
		"\u0001\u0000\u0000\u0000\u0113\u0601\u0001\u0000\u0000\u0000\u0115\u0604"+
		"\u0001\u0000\u0000\u0000\u0117\u060a\u0001\u0000\u0000\u0000\u0119\u060f"+
		"\u0001\u0000\u0000\u0000\u011b\u0614\u0001\u0000\u0000\u0000\u011d\u061b"+
		"\u0001\u0000\u0000\u0000\u011f\u0620\u0001\u0000\u0000\u0000\u0121\u062f"+
		"\u0001\u0000\u0000\u0000\u0123\u0636\u0001\u0000\u0000\u0000\u0125\u063b"+
		"\u0001\u0000\u0000\u0000\u0127\u0645\u0001\u0000\u0000\u0000\u0129\u0650"+
		"\u0001\u0000\u0000\u0000\u012b\u0659\u0001\u0000\u0000\u0000\u012d\u0664"+
		"\u0001\u0000\u0000\u0000\u012f\u0668\u0001\u0000\u0000\u0000\u0131\u0674"+
		"\u0001\u0000\u0000\u0000\u0133\u067c\u0001\u0000\u0000\u0000\u0135\u0681"+
		"\u0001\u0000\u0000\u0000\u0137\u0688\u0001\u0000\u0000\u0000\u0139\u068f"+
		"\u0001\u0000\u0000\u0000\u013b\u0696\u0001\u0000\u0000\u0000\u013d\u069b"+
		"\u0001\u0000\u0000\u0000\u013f\u069e\u0001\u0000\u0000\u0000\u0141\u06a6"+
		"\u0001\u0000\u0000\u0000\u0143\u06ab\u0001\u0000\u0000\u0000\u0145\u06b1"+
		"\u0001\u0000\u0000\u0000\u0147\u06b6\u0001\u0000\u0000\u0000\u0149\u06bb"+
		"\u0001\u0000\u0000\u0000\u014b\u06c1\u0001\u0000\u0000\u0000\u014d\u06c9"+
		"\u0001\u0000\u0000\u0000\u014f\u06cd\u0001\u0000\u0000\u0000\u0151\u06d2"+
		"\u0001\u0000\u0000\u0000\u0153\u06d7\u0001\u0000\u0000\u0000\u0155\u06de"+
		"\u0001\u0000\u0000\u0000\u0157\u06e6\u0001\u0000\u0000\u0000\u0159\u06ec"+
		"\u0001\u0000\u0000\u0000\u015b\u06f3\u0001\u0000\u0000\u0000\u015d\u06f9"+
		"\u0001\u0000\u0000\u0000\u015f\u06ff\u0001\u0000\u0000\u0000\u0161\u0706"+
		"\u0001\u0000\u0000\u0000\u0163\u070b\u0001\u0000\u0000\u0000\u0165\u0710"+
		"\u0001\u0000\u0000\u0000\u0167\u0715\u0001\u0000\u0000\u0000\u0169\u071f"+
		"\u0001\u0000\u0000\u0000\u016b\u0729\u0001\u0000\u0000\u0000\u016d\u0731"+
		"\u0001\u0000\u0000\u0000\u016f\u0739\u0001\u0000\u0000\u0000\u0171\u0741"+
		"\u0001\u0000\u0000\u0000\u0173\u074a\u0001\u0000\u0000\u0000\u0175\u0752"+
		"\u0001\u0000\u0000\u0000\u0177\u0756\u0001\u0000\u0000\u0000\u0179\u075a"+
		"\u0001\u0000\u0000\u0000\u017b\u075e\u0001\u0000\u0000\u0000\u017d\u0762"+
		"\u0001\u0000\u0000\u0000\u017f\u0768\u0001\u0000\u0000\u0000\u0181\u076c"+
		"\u0001\u0000\u0000\u0000\u0183\u0772\u0001\u0000\u0000\u0000\u0185\u077a"+
		"\u0001\u0000\u0000\u0000\u0187\u077f\u0001\u0000\u0000\u0000\u0189\u078b"+
		"\u0001\u0000\u0000\u0000\u018b\u078f\u0001\u0000\u0000\u0000\u018d\u0797"+
		"\u0001\u0000\u0000\u0000\u018f\u079c\u0001\u0000\u0000\u0000\u0191\u07a3"+
		"\u0001\u0000\u0000\u0000\u0193\u07c4\u0001\u0000\u0000\u0000\u0195\u07cd"+
		"\u0001\u0000\u0000\u0000\u0197\u07d5\u0001\u0000\u0000\u0000\u0199\u07d8"+
		"\u0001\u0000\u0000\u0000\u019b\u07de\u0001\u0000\u0000\u0000\u019d\u07e0"+
		"\u0001\u0000\u0000\u0000\u019f\u07e2\u0001\u0000\u0000\u0000\u01a1\u07e4"+
		"\u0001\u0000\u0000\u0000\u01a3\u07e7\u0001\u0000\u0000\u0000\u01a5\u07ea"+
		"\u0001\u0000\u0000\u0000\u01a7\u07ec\u0001\u0000\u0000\u0000\u01a9\u07ee"+
		"\u0001\u0000\u0000\u0000\u01ab\u07f0\u0001\u0000\u0000\u0000\u01ad\u07f2"+
		"\u0001\u0000\u0000\u0000\u01af\u07f5\u0001\u0000\u0000\u0000\u01b1\u07f7"+
		"\u0001\u0000\u0000\u0000\u01b3\u07f9\u0001\u0000\u0000\u0000\u01b5\u07fb"+
		"\u0001\u0000\u0000\u0000\u01b7\u07fd\u0001\u0000\u0000\u0000\u01b9\u07ff"+
		"\u0001\u0000\u0000\u0000\u01bb\u0801\u0001\u0000\u0000\u0000\u01bd\u0803"+
		"\u0001\u0000\u0000\u0000\u01bf\u080e\u0001\u0000\u0000\u0000\u01c1\u081e"+
		"\u0001\u0000\u0000\u0000\u01c3\u01c4\u0007\u0000\u0000\u0000\u01c4\u0002"+
		"\u0001\u0000\u0000\u0000\u01c5\u01c6\u0007\u0001\u0000\u0000\u01c6\u0004"+
		"\u0001\u0000\u0000\u0000\u01c7\u01c8\u0007\u0002\u0000\u0000\u01c8\u0006"+
		"\u0001\u0000\u0000\u0000\u01c9\u01ca\u0007\u0003\u0000\u0000\u01ca\u01cb"+
		"\u0007\u0004\u0000\u0000\u01cb\u01cc\u0007\u0004\u0000\u0000\u01cc\b\u0001"+
		"\u0000\u0000\u0000\u01cd\u01ce\u0007\u0005\u0000\u0000\u01ce\u01cf\u0007"+
		"\u0006\u0000\u0000\u01cf\u01d0\u0007\u0007\u0000\u0000\u01d0\u01d1\u0007"+
		"\u0005\u0000\u0000\u01d1\u01d2\u0007\b\u0000\u0000\u01d2\u01d3\u0007\t"+
		"\u0000\u0000\u01d3\u01d4\u0007\u0003\u0000\u0000\u01d4\u01d5\u0007\n\u0000"+
		"\u0000\u01d5\n\u0001\u0000\u0000\u0000\u01d6\u01d7\u0007\u000b\u0000\u0000"+
		"\u01d7\u01d8\u0007\b\u0000\u0000\u01d8\u01d9\u0007\f\u0000\u0000\u01d9"+
		"\u01da\u0007\r\u0000\u0000\u01da\u01db\u0007\u0005\u0000\u0000\u01db\u01dc"+
		"\u0007\u0004\u0000\u0000\u01dc\u01dd\u0007\u000e\u0000\u0000\u01dd\u01de"+
		"\u0007\b\u0000\u0000\u01de\u01df\u0007\u0005\u0000\u0000\u01df\f\u0001"+
		"\u0000\u0000\u0000\u01e0\u01e1\u0007\u0003\u0000\u0000\u01e1\u01e2\u0007"+
		"\n\u0000\u0000\u01e2\u01e3\u0007\n\u0000\u0000\u01e3\u000e\u0001\u0000"+
		"\u0000\u0000\u01e4\u01e5\u0007\u000f\u0000\u0000\u01e5\u01e6\u0007\u0005"+
		"\u0000\u0000\u01e6\u01e7\u0007\u0007\u0000\u0000\u01e7\u01e8\u0007\r\u0000"+
		"\u0000\u01e8\u01e9\u0007\u0010\u0000\u0000\u01e9\u0010\u0001\u0000\u0000"+
		"\u0000\u01ea\u01eb\u0007\u000b\u0000\u0000\u01eb\u01ec\u0007\u000e\u0000"+
		"\u0000\u01ec\u01ed\u0007\u0011\u0000\u0000\u01ed\u01ee\u0007\n\u0000\u0000"+
		"\u01ee\u01ef\u0007\u0012\u0000\u0000\u01ef\u01f0\u0007\r\u0000\u0000\u01f0"+
		"\u0012\u0001\u0000\u0000\u0000\u01f1\u01f2\u0007\u0003\u0000\u0000\u01f2"+
		"\u01f3\u0007\n\u0000\u0000\u01f3\u01f4\u0007\u0007\u0000\u0000\u01f4\u01f5"+
		"\u0007\u0005\u0000\u0000\u01f5\u01f6\u0007\b\u0000\u0000\u01f6\u0014\u0001"+
		"\u0000\u0000\u0000\u01f7\u01f8\u0007\u000f\u0000\u0000\u01f8\u01f9\u0007"+
		"\u0012\u0000\u0000\u01f9\u01fa\u0007\n\u0000\u0000\u01fa\u01fb\u0007\u0005"+
		"\u0000\u0000\u01fb\u0016\u0001\u0000\u0000\u0000\u01fc\u01fd\u0007\b\u0000"+
		"\u0000\u01fd\u01fe\u0007\u0003\u0000\u0000\u01fe\u01ff\u0007\u0012\u0000"+
		"\u0000\u01ff\u0200\u0007\u0013\u0000\u0000\u0200\u0201\u0007\u0005\u0000"+
		"\u0000\u0201\u0202\u0007\b\u0000\u0000\u0202\u0203\u0007\b\u0000\u0000"+
		"\u0203\u0204\u0007\f\u0000\u0000\u0204\u0205\u0007\b\u0000\u0000\u0205"+
		"\u0018\u0001\u0000\u0000\u0000\u0206\u0207\u0007\u0003\u0000\u0000\u0207"+
		"\u0208\u0007\t\u0000\u0000\u0208\u0209\u0007\u0004\u0000\u0000\u0209\u001a"+
		"\u0001\u0000\u0000\u0000\u020a\u020b\u0007\u000f\u0000\u0000\u020b\u020c"+
		"\u0007\u0012\u0000\u0000\u020c\u020d\u0007\n\u0000\u0000\u020d\u020e\u0007"+
		"\n\u0000\u0000\u020e\u020f\u0007\u000f\u0000\u0000\u020f\u0210\u0007\u0003"+
		"\u0000\u0000\u0210\u0211\u0007\r\u0000\u0000\u0211\u0212\u0007\u0007\u0000"+
		"\u0000\u0212\u0213\u0007\f\u0000\u0000\u0213\u0214\u0007\b\u0000\u0000"+
		"\u0214\u001c\u0001\u0000\u0000\u0000\u0215\u0216\u0007\b\u0000\u0000\u0216"+
		"\u0217\u0007\u0005\u0000\u0000\u0217\u0218\u0007\u0003\u0000\u0000\u0218"+
		"\u0219\u0007\u0004\u0000\u0000\u0219\u001e\u0001\u0000\u0000\u0000\u021a"+
		"\u021b\u0007\u0003\u0000\u0000\u021b\u021c\u0007\t\u0000\u0000\u021c\u021d"+
		"\u0007\u0014\u0000\u0000\u021d \u0001\u0000\u0000\u0000\u021e\u021f\u0007"+
		"\u000f\u0000\u0000\u021f\u0220\u0007\f\u0000\u0000\u0220\u0221\u0007\b"+
		"\u0000\u0000\u0221\"\u0001\u0000\u0000\u0000\u0222\u0223\u0007\b\u0000"+
		"\u0000\u0223\u0224\u0007\u0005\u0000\u0000\u0224\u0225\u0007\u0003\u0000"+
		"\u0000\u0225\u0226\u0007\u0004\u0000\u0000\u0226\u0227\u0007\u0007\u0000"+
		"\u0000\u0227\u0228\u0007\u0005\u0000\u0000\u0228\u0229\u0007\u0006\u0000"+
		"\u0000\u0229\u022a\u0007\u0007\u0000\u0000\u022a$\u0001\u0000\u0000\u0000"+
		"\u022b\u022c\u0007\u0003\u0000\u0000\u022c\u022d\u0007\u0013\u0000\u0000"+
		"\u022d&\u0001\u0000\u0000\u0000\u022e\u022f\u0007\u000f\u0000\u0000\u022f"+
		"\u0230\u0007\f\u0000\u0000\u0230\u0231\u0007\b\u0000\u0000\u0231\u0232"+
		"\u0007\u0005\u0000\u0000\u0232\u0233\u0007\u0012\u0000\u0000\u0233\u0234"+
		"\u0007\u0015\u0000\u0000\u0234\u0235\u0007\t\u0000\u0000\u0235(\u0001"+
		"\u0000\u0000\u0000\u0236\u0237\u0007\b\u0000\u0000\u0237\u0238\u0007\u0005"+
		"\u0000\u0000\u0238\u0239\u0007\r\u0000\u0000\u0239\u023a\u0007\f\u0000"+
		"\u0000\u023a\u023b\u0007\t\u0000\u0000\u023b\u023c\u0007\u000f\u0000\u0000"+
		"\u023c\u023d\u0007\u0012\u0000\u0000\u023d\u023e\u0007\u0015\u0000\u0000"+
		"\u023e\u023f\u0007\u000e\u0000\u0000\u023f\u0240\u0007\b\u0000\u0000\u0240"+
		"\u0241\u0007\u0005\u0000\u0000\u0241*\u0001\u0000\u0000\u0000\u0242\u0243"+
		"\u0007\u0003\u0000\u0000\u0243\u0244\u0007\u0013\u0000\u0000\u0244\u0245"+
		"\u0007\r\u0000\u0000\u0245,\u0001\u0000\u0000\u0000\u0246\u0247\u0007"+
		"\u000f\u0000\u0000\u0247\u0248\u0007\b\u0000\u0000\u0248\u0249\u0007\u0005"+
		"\u0000\u0000\u0249\u024a\u0007\u0005\u0000\u0000\u024a\u024b\u0007\u0007"+
		"\u0000\u0000\u024b\u024c\u0007\u0005\u0000\u0000\u024c\u024d\u0007\u0006"+
		"\u0000\u0000\u024d\u024e\u0007\u0007\u0000\u0000\u024e.\u0001\u0000\u0000"+
		"\u0000\u024f\u0250\u0007\b\u0000\u0000\u0250\u0251\u0007\u0005\u0000\u0000"+
		"\u0251\u0252\u0007\u000f\u0000\u0000\u0252\u0253\u0007\u0005\u0000\u0000"+
		"\u0253\u0254\u0007\b\u0000\u0000\u0254\u0255\u0007\u0005\u0000\u0000\u0255"+
		"\u0256\u0007\t\u0000\u0000\u0256\u0257\u0007\r\u0000\u0000\u0257\u0258"+
		"\u0007\u0005\u0000\u0000\u0258\u0259\u0007\u0013\u0000\u0000\u02590\u0001"+
		"\u0000\u0000\u0000\u025a\u025b\u0007\u0003\u0000\u0000\u025b\u025c\u0007"+
		"\u000e\u0000\u0000\u025c\u025d\u0007\u0007\u0000\u0000\u025d\u025e\u0007"+
		"\u0010\u0000\u0000\u025e\u025f\u0007\f\u0000\u0000\u025f\u0260\u0007\b"+
		"\u0000\u0000\u0260\u0261\u0007\u0012\u0000\u0000\u0261\u0262\u0007\u0016"+
		"\u0000\u0000\u0262\u0263\u0007\u0003\u0000\u0000\u0263\u0264\u0007\u0007"+
		"\u0000\u0000\u0264\u0265\u0007\u0012\u0000\u0000\u0265\u0266\u0007\f\u0000"+
		"\u0000\u0266\u0267\u0007\t\u0000\u0000\u02672\u0001\u0000\u0000\u0000"+
		"\u0268\u0269\u0007\u000f\u0000\u0000\u0269\u026a\u0007\b\u0000\u0000\u026a"+
		"\u026b\u0007\u0005\u0000\u0000\u026b\u026c\u0007\u0005\u0000\u0000\u026c"+
		"\u026d\u0007\u0007\u0000\u0000\u026d\u026e\u0007\u0005\u0000\u0000\u026e"+
		"\u026f\u0007\u0006\u0000\u0000\u026f\u0270\u0007\u0007\u0000\u0000\u0270"+
		"\u0271\u0007\u0007\u0000\u0000\u0271\u0272\u0007\u0003\u0000\u0000\u0272"+
		"\u0273\u0007\u0011\u0000\u0000\u0273\u0274\u0007\n\u0000\u0000\u0274\u0275"+
		"\u0007\u0005\u0000\u0000\u02754\u0001\u0000\u0000\u0000\u0276\u0277\u0007"+
		"\b\u0000\u0000\u0277\u0278\u0007\u0005\u0000\u0000\u0278\u0279\u0007\u000b"+
		"\u0000\u0000\u0279\u027a\u0007\n\u0000\u0000\u027a\u027b\u0007\u0012\u0000"+
		"\u0000\u027b\u027c\u0007\r\u0000\u0000\u027c\u027d\u0007\u0003\u0000\u0000"+
		"\u027d\u027e\u0007\u0007\u0000\u0000\u027e\u027f\u0007\u0012\u0000\u0000"+
		"\u027f\u0280\u0007\f\u0000\u0000\u0280\u0281\u0007\t\u0000\u0000\u0281"+
		"6\u0001\u0000\u0000\u0000\u0282\u0283\u0007\u0011\u0000\u0000\u0283\u0284"+
		"\u0007\u0003\u0000\u0000\u0284\u0285\u0007\r\u0000\u0000\u0285\u0286\u0007"+
		"\u0017\u0000\u0000\u0286\u0287\u0007\u000e\u0000\u0000\u0287\u0288\u0007"+
		"\u000b\u0000\u0000\u02888\u0001\u0000\u0000\u0000\u0289\u028a\u0007\u000f"+
		"\u0000\u0000\u028a\u028b\u0007\b\u0000\u0000\u028b\u028c\u0007\f\u0000"+
		"\u0000\u028c\u028d\u0007\u0018\u0000\u0000\u028d:\u0001\u0000\u0000\u0000"+
		"\u028e\u028f\u0007\b\u0000\u0000\u028f\u0290\u0007\u0005\u0000\u0000\u0290"+
		"\u0291\u0007\u0013\u0000\u0000\u0291\u0292\u0007\u0007\u0000\u0000\u0292"+
		"\u0293\u0007\f\u0000\u0000\u0293\u0294\u0007\b\u0000\u0000\u0294\u0295"+
		"\u0007\u0005\u0000\u0000\u0295<\u0001\u0000\u0000\u0000\u0296\u0297\u0007"+
		"\u0011\u0000\u0000\u0297\u0298\u0007\u0005\u0000\u0000\u0298\u0299\u0007"+
		"\u0015\u0000\u0000\u0299\u029a\u0007\u0012\u0000\u0000\u029a\u029b\u0007"+
		"\t\u0000\u0000\u029b>\u0001\u0000\u0000\u0000\u029c\u029d\u0007\u000f"+
		"\u0000\u0000\u029d\u029e\u0007\u000e\u0000\u0000\u029e\u029f\u0007\n\u0000"+
		"\u0000\u029f\u02a0\u0007\n\u0000\u0000\u02a0@\u0001\u0000\u0000\u0000"+
		"\u02a1\u02a2\u0007\b\u0000\u0000\u02a2\u02a3\u0007\u0005\u0000\u0000\u02a3"+
		"\u02a4\u0007\u0013\u0000\u0000\u02a4\u02a5\u0007\u0007\u0000\u0000\u02a5"+
		"\u02a6\u0007\b\u0000\u0000\u02a6\u02a7\u0007\u0012\u0000\u0000\u02a7\u02a8"+
		"\u0007\r\u0000\u0000\u02a8\u02a9\u0007\u0007\u0000\u0000\u02a9B\u0001"+
		"\u0000\u0000\u0000\u02aa\u02ab\u0007\u0011\u0000\u0000\u02ab\u02ac\u0007"+
		"\u0005\u0000\u0000\u02ac\u02ad\u0007\u0007\u0000\u0000\u02ad\u02ae\u0007"+
		"\u0019\u0000\u0000\u02ae\u02af\u0007\u0005\u0000\u0000\u02af\u02b0\u0007"+
		"\u0005\u0000\u0000\u02b0\u02b1\u0007\t\u0000\u0000\u02b1D\u0001\u0000"+
		"\u0000\u0000\u02b2\u02b3\u0007\u000f\u0000\u0000\u02b3\u02b4\u0007\u000e"+
		"\u0000\u0000\u02b4\u02b5\u0007\t\u0000\u0000\u02b5\u02b6\u0007\r\u0000"+
		"\u0000\u02b6\u02b7\u0007\u0007\u0000\u0000\u02b7\u02b8\u0007\u0012\u0000"+
		"\u0000\u02b8\u02b9\u0007\f\u0000\u0000\u02b9\u02ba\u0007\t\u0000\u0000"+
		"\u02baF\u0001\u0000\u0000\u0000\u02bb\u02bc\u0007\b\u0000\u0000\u02bc"+
		"\u02bd\u0007\u0005\u0000\u0000\u02bd\u02be\u0007\u0007\u0000\u0000\u02be"+
		"\u02bf\u0007\u000e\u0000\u0000\u02bf\u02c0\u0007\b\u0000\u0000\u02c0\u02c1"+
		"\u0007\t\u0000\u0000\u02c1H\u0001\u0000\u0000\u0000\u02c2\u02c3\u0007"+
		"\u0011\u0000\u0000\u02c3\u02c4\u0007\b\u0000\u0000\u02c4\u02c5\u0007\u0005"+
		"\u0000\u0000\u02c5\u02c6\u0007\u0003\u0000\u0000\u02c6\u02c7\u0007\u0017"+
		"\u0000\u0000\u02c7J\u0001\u0000\u0000\u0000\u02c8\u02c9\u0007\u0015\u0000"+
		"\u0000\u02c9\u02ca\u0007\f\u0000\u0000\u02ca\u02cb\u0007\u0007\u0000\u0000"+
		"\u02cb\u02cc\u0007\f\u0000\u0000\u02ccL\u0001\u0000\u0000\u0000\u02cd"+
		"\u02ce\u0007\u0015\u0000\u0000\u02ce\u02cf\u0007\f\u0000\u0000\u02cf\u02d0"+
		"\u0001\u0000\u0000\u0000\u02d0\u02d1\u0006&\u0000\u0000\u02d1N\u0001\u0000"+
		"\u0000\u0000\u02d2\u02d3\u0007\b\u0000\u0000\u02d3\u02d4\u0007\u0005\u0000"+
		"\u0000\u02d4\u02d5\u0007\u001a\u0000\u0000\u02d5\u02d6\u0007\u0005\u0000"+
		"\u0000\u02d6\u02d7\u0007\b\u0000\u0000\u02d7\u02d8\u0007\u0007\u0000\u0000"+
		"\u02d8P\u0001\u0000\u0000\u0000\u02d9\u02da\u0007\u0011\u0000\u0000\u02da"+
		"\u02db\u0007\b\u0000\u0000\u02db\u02dc\u0007\f\u0000\u0000\u02dc\u02dd"+
		"\u0007\u0019\u0000\u0000\u02dd\u02de\u0007\u0013\u0000\u0000\u02de\u02df"+
		"\u0007\u0005\u0000\u0000\u02dfR\u0001\u0000\u0000\u0000\u02e0\u02e1\u0007"+
		"\u0015\u0000\u0000\u02e1\u02e2\u0007\b\u0000\u0000\u02e2\u02e3\u0007\u0003"+
		"\u0000\u0000\u02e3\u02e4\u0007\t\u0000\u0000\u02e4\u02e5\u0007\u0007\u0000"+
		"\u0000\u02e5T\u0001\u0000\u0000\u0000\u02e6\u02e7\u0007\b\u0000\u0000"+
		"\u02e7\u02e8\u0007\u0005\u0000\u0000\u02e8\u02e9\u0007\u001a\u0000\u0000"+
		"\u02e9\u02ea\u0007\f\u0000\u0000\u02ea\u02eb\u0007\u0017\u0000\u0000\u02eb"+
		"\u02ec\u0007\u0005\u0000\u0000\u02ecV\u0001\u0000\u0000\u0000\u02ed\u02ee"+
		"\u0007\u0011\u0000\u0000\u02ee\u02ef\u0007\u000e\u0000\u0000\u02ef\u02f0"+
		"\u0007\n\u0000\u0000\u02f0\u02f1\u0007\u0017\u0000\u0000\u02f1X\u0001"+
		"\u0000\u0000\u0000\u02f2\u02f3\u0007\u0015\u0000\u0000\u02f3\u02f4\u0007"+
		"\b\u0000\u0000\u02f4\u02f5\u0007\f\u0000\u0000\u02f5\u02f6\u0007\u000e"+
		"\u0000\u0000\u02f6\u02f7\u0007\u000b\u0000\u0000\u02f7Z\u0001\u0000\u0000"+
		"\u0000\u02f8\u02f9\u0007\b\u0000\u0000\u02f9\u02fa\u0007\u0012\u0000\u0000"+
		"\u02fa\u02fb\u0007\u0015\u0000\u0000\u02fb\u02fc\u0007\u0010\u0000\u0000"+
		"\u02fc\u02fd\u0007\u0007\u0000\u0000\u02fd\\\u0001\u0000\u0000\u0000\u02fe"+
		"\u02ff\u0007\u0011\u0000\u0000\u02ff\u0300\u0007\u0014\u0000\u0000\u0300"+
		"^\u0001\u0000\u0000\u0000\u0301\u0302\u0007\u0010\u0000\u0000\u0302\u0303"+
		"\u0007\u0003\u0000\u0000\u0303\u0304\u0007\u001a\u0000\u0000\u0304\u0305"+
		"\u0007\u0012\u0000\u0000\u0305\u0306\u0007\t\u0000\u0000\u0306\u0307\u0007"+
		"\u0015\u0000\u0000\u0307`\u0001\u0000\u0000\u0000\u0308\u0309\u0007\b"+
		"\u0000\u0000\u0309\u030a\u0007\f\u0000\u0000\u030a\u030b\u0007\n\u0000"+
		"\u0000\u030b\u030c\u0007\n\u0000\u0000\u030c\u030d\u0007\u0011\u0000\u0000"+
		"\u030d\u030e\u0007\u0003\u0000\u0000\u030e\u030f\u0007\r\u0000\u0000\u030f"+
		"\u0310\u0007\u0017\u0000\u0000\u0310b\u0001\u0000\u0000\u0000\u0311\u0312"+
		"\u0007\r\u0000\u0000\u0312\u0313\u0007\u0003\u0000\u0000\u0313\u0314\u0007"+
		"\u0013\u0000\u0000\u0314\u0315\u0007\r\u0000\u0000\u0315\u0316\u0007\u0003"+
		"\u0000\u0000\u0316\u0317\u0007\u0004\u0000\u0000\u0317\u0318\u0007\u0005"+
		"\u0000\u0000\u0318d\u0001\u0000\u0000\u0000\u0319\u031a\u0007\u0010\u0000"+
		"\u0000\u031a\u031b\u0007\f\u0000\u0000\u031b\u031c\u0007\n\u0000\u0000"+
		"\u031c\u031d\u0007\u0004\u0000\u0000\u031d\u031e\u0007\n\u0000\u0000\u031e"+
		"\u031f\u0007\f\u0000\u0000\u031f\u0320\u0007\r\u0000\u0000\u0320\u0321"+
		"\u0007\u0017\u0000\u0000\u0321f\u0001\u0000\u0000\u0000\u0322\u0323\u0007"+
		"\b\u0000\u0000\u0323\u0324\u0007\f\u0000\u0000\u0324\u0325\u0007\u0019"+
		"\u0000\u0000\u0325\u0326\u0007\r\u0000\u0000\u0326\u0327\u0007\f\u0000"+
		"\u0000\u0327\u0328\u0007\u000e\u0000\u0000\u0328\u0329\u0007\t\u0000\u0000"+
		"\u0329\u032a\u0007\u0007\u0000\u0000\u032ah\u0001\u0000\u0000\u0000\u032b"+
		"\u032c\u0007\r\u0000\u0000\u032c\u032d\u0007\u0003\u0000\u0000\u032d\u032e"+
		"\u0007\u0013\u0000\u0000\u032e\u032f\u0007\u0005\u0000\u0000\u032fj\u0001"+
		"\u0000\u0000\u0000\u0330\u0331\u0007\u0012\u0000\u0000\u0331\u0332\u0007"+
		"\u0004\u0000\u0000\u0332\u0333\u0007\u0005\u0000\u0000\u0333\u0334\u0007"+
		"\t\u0000\u0000\u0334\u0335\u0007\u0007\u0000\u0000\u0335\u0336\u0007\u0012"+
		"\u0000\u0000\u0336\u0337\u0007\u0007\u0000\u0000\u0337\u0338\u0007\u0014"+
		"\u0000\u0000\u0338l\u0001\u0000\u0000\u0000\u0339\u033a\u0007\b\u0000"+
		"\u0000\u033a\u033b\u0007\f\u0000\u0000\u033b\u033c\u0007\u0019\u0000\u0000"+
		"\u033c\u033d\u0007\u0015\u0000\u0000\u033d\u033e\u0007\u000e\u0000\u0000"+
		"\u033e\u033f\u0007\u0012\u0000\u0000\u033f\u0340\u0007\u0004\u0000\u0000"+
		"\u0340\u0341\u0007\r\u0000\u0000\u0341\u0342\u0007\f\u0000\u0000\u0342"+
		"\u0343\u0007\n\u0000\u0000\u0343n\u0001\u0000\u0000\u0000\u0344\u0345"+
		"\u0007\r\u0000\u0000\u0345\u0346\u0007\u0010\u0000\u0000\u0346\u0347\u0007"+
		"\u0005\u0000\u0000\u0347\u0348\u0007\r\u0000\u0000\u0348\u0349\u0007\u0017"+
		"\u0000\u0000\u0349p\u0001\u0000\u0000\u0000\u034a\u034b\u0007\u0012\u0000"+
		"\u0000\u034b\u034c\u0007\u0004\u0000\u0000\u034c\u034d\u0007\u0005\u0000"+
		"\u0000\u034d\u034e\u0007\t\u0000\u0000\u034e\u034f\u0007\u0007\u0000\u0000"+
		"\u034f\u0350\u0007\u0012\u0000\u0000\u0350\u0351\u0007\u0007\u0000\u0000"+
		"\u0351\u0352\u0007\u0014\u0000\u0000\u0352\u0353\u0005_\u0000\u0000\u0353"+
		"\u0354\u0007\u0012\u0000\u0000\u0354\u0355\u0007\t\u0000\u0000\u0355\u0356"+
		"\u0007\u0013\u0000\u0000\u0356\u0357\u0007\u0005\u0000\u0000\u0357\u0358"+
		"\u0007\b\u0000\u0000\u0358\u0359\u0007\u0007\u0000\u0000\u0359r\u0001"+
		"\u0000\u0000\u0000\u035a\u035b\u0007\b\u0000\u0000\u035b\u035c\u0007\u000e"+
		"\u0000\u0000\u035c\u035d\u0007\n\u0000\u0000\u035d\u035e\u0007\u0005\u0000"+
		"\u0000\u035et\u0001\u0000\u0000\u0000\u035f\u0360\u0007\r\u0000\u0000"+
		"\u0360\u0361\u0007\u0010\u0000\u0000\u0361\u0362\u0007\u0005\u0000\u0000"+
		"\u0362\u0363\u0007\r\u0000\u0000\u0363\u0364\u0007\u0017\u0000\u0000\u0364"+
		"\u0365\u0007\u000b\u0000\u0000\u0365\u0366\u0007\f\u0000\u0000\u0366\u0367"+
		"\u0007\u0012\u0000\u0000\u0367\u0368\u0007\t\u0000\u0000\u0368\u0369\u0007"+
		"\u0007\u0000\u0000\u0369v\u0001\u0000\u0000\u0000\u036a\u036b\u0007\u0012"+
		"\u0000\u0000\u036b\u036c\u0007\u0004\u0000\u0000\u036c\u036d\u0007\u0005"+
		"\u0000\u0000\u036d\u036e\u0007\t\u0000\u0000\u036e\u036f\u0007\u0007\u0000"+
		"\u0000\u036f\u0370\u0007\u0012\u0000\u0000\u0370\u0371\u0007\u0007\u0000"+
		"\u0000\u0371\u0372\u0007\u0014\u0000\u0000\u0372\u0373\u0007\r\u0000\u0000"+
		"\u0373\u0374\u0007\f\u0000\u0000\u0374\u0375\u0007\n\u0000\u0000\u0375"+
		"x\u0001\u0000\u0000\u0000\u0376\u0377\u0007\u0013\u0000\u0000\u0377\u0378"+
		"\u0007\u0003\u0000\u0000\u0378\u0379\u0007\u001a\u0000\u0000\u0379\u037a"+
		"\u0007\u0005\u0000\u0000\u037az\u0001\u0000\u0000\u0000\u037b\u037c\u0007"+
		"\r\u0000\u0000\u037c\u037d\u0007\n\u0000\u0000\u037d\u037e\u0007\f\u0000"+
		"\u0000\u037e\u037f\u0007\u0013\u0000\u0000\u037f\u0380\u0007\u0005\u0000"+
		"\u0000\u0380|\u0001\u0000\u0000\u0000\u0381\u0382\u0007\u0012\u0000\u0000"+
		"\u0382\u0383\u0007\u000f\u0000\u0000\u0383~\u0001\u0000\u0000\u0000\u0384"+
		"\u0385\u0007\u0013\u0000\u0000\u0385\u0386\u0007\r\u0000\u0000\u0386\u0387"+
		"\u0007\u0010\u0000\u0000\u0387\u0388\u0007\u0005\u0000\u0000\u0388\u0389"+
		"\u0007\u0018\u0000\u0000\u0389\u038a\u0007\u0003\u0000\u0000\u038a\u0080"+
		"\u0001\u0000\u0000\u0000\u038b\u038c\u0007\r\u0000\u0000\u038c\u038d\u0007"+
		"\n\u0000\u0000\u038d\u038e\u0007\u000e\u0000\u0000\u038e\u038f\u0007\u0013"+
		"\u0000\u0000\u038f\u0390\u0007\u0007\u0000\u0000\u0390\u0391\u0007\u0005"+
		"\u0000\u0000\u0391\u0392\u0007\b\u0000\u0000\u0392\u0393\u0007\u0005\u0000"+
		"\u0000\u0393\u0394\u0007\u0004\u0000\u0000\u0394\u0082\u0001\u0000\u0000"+
		"\u0000\u0395\u0396\u0007\u0012\u0000\u0000\u0396\u0397\u0007\t\u0000\u0000"+
		"\u0397\u0084\u0001\u0000\u0000\u0000\u0398\u0399\u0007\u0013\u0000\u0000"+
		"\u0399\u039a\u0007\u0005\u0000\u0000\u039a\u039b\u0007\r\u0000\u0000\u039b"+
		"\u039c\u0007\u000e\u0000\u0000\u039c\u039d\u0007\b\u0000\u0000\u039d\u039e"+
		"\u0007\u0012\u0000\u0000\u039e\u039f\u0007\u0007\u0000\u0000\u039f\u03a0"+
		"\u0007\u0014\u0000\u0000\u03a0\u03a1\u0007\u0003\u0000\u0000\u03a1\u03a2"+
		"\u0007\u000e\u0000\u0000\u03a2\u03a3\u0007\u0004\u0000\u0000\u03a3\u03a4"+
		"\u0007\u0012\u0000\u0000\u03a4\u03a5\u0007\u0007\u0000\u0000\u03a5\u0086"+
		"\u0001\u0000\u0000\u0000\u03a6\u03a7\u0007\r\u0000\u0000\u03a7\u03a8\u0007"+
		"\f\u0000\u0000\u03a8\u03a9\u0007\u0003\u0000\u0000\u03a9\u03aa\u0007\n"+
		"\u0000\u0000\u03aa\u03ab\u0007\u0005\u0000\u0000\u03ab\u03ac\u0007\u0013"+
		"\u0000\u0000\u03ac\u03ad\u0007\r\u0000\u0000\u03ad\u03ae\u0007\u0005\u0000"+
		"\u0000\u03ae\u0088\u0001\u0000\u0000\u0000\u03af\u03b0\u0007\u0012\u0000"+
		"\u0000\u03b0\u03b1\u0007\t\u0000\u0000\u03b1\u03b2\u0007\u0004\u0000\u0000"+
		"\u03b2\u03b3\u0007\u0005\u0000\u0000\u03b3\u03b4\u0007\u0006\u0000\u0000"+
		"\u03b4\u008a\u0001\u0000\u0000\u0000\u03b5\u03b6\u0007\u0013\u0000\u0000"+
		"\u03b6\u03b7\u0007\u0005\u0000\u0000\u03b7\u03b8\u0007\n\u0000\u0000\u03b8"+
		"\u03b9\u0007\u0005\u0000\u0000\u03b9\u03ba\u0007\r\u0000\u0000\u03ba\u03bb"+
		"\u0007\u0007\u0000\u0000\u03bb\u008c\u0001\u0000\u0000\u0000\u03bc\u03bd"+
		"\u0007\r\u0000\u0000\u03bd\u03be\u0007\f\u0000\u0000\u03be\u03bf\u0007"+
		"\n\u0000\u0000\u03bf\u03c0\u0007\n\u0000\u0000\u03c0\u03c1\u0007\u0003"+
		"\u0000\u0000\u03c1\u03c2\u0007\u0007\u0000\u0000\u03c2\u03c3\u0007\u0005"+
		"\u0000\u0000\u03c3\u008e\u0001\u0000\u0000\u0000\u03c4\u03c5\u0007\u0012"+
		"\u0000\u0000\u03c5\u03c6\u0007\t\u0000\u0000\u03c6\u03c7\u0007\t\u0000"+
		"\u0000\u03c7\u03c8\u0007\u0005\u0000\u0000\u03c8\u03c9\u0007\b\u0000\u0000"+
		"\u03c9\u0090\u0001\u0000\u0000\u0000\u03ca\u03cb\u0007\u0013\u0000\u0000"+
		"\u03cb\u03cc\u0007\u0005\u0000\u0000\u03cc\u03cd\u0007\u0018\u0000\u0000"+
		"\u03cd\u03ce\u0007\u0003\u0000\u0000\u03ce\u03cf\u0007\t\u0000\u0000\u03cf"+
		"\u03d0\u0007\u0007\u0000\u0000\u03d0\u03d1\u0007\u0012\u0000\u0000\u03d1"+
		"\u03d2\u0007\r\u0000\u0000\u03d2\u03d3\u0007\u0017\u0000\u0000\u03d3\u03d4"+
		"\u0007\u0005\u0000\u0000\u03d4\u03d5\u0007\u0014\u0000\u0000\u03d5\u03d6"+
		"\u0007\u000b\u0000\u0000\u03d6\u03d7\u0007\u0010\u0000\u0000\u03d7\u03d8"+
		"\u0007\b\u0000\u0000\u03d8\u03d9\u0007\u0003\u0000\u0000\u03d9\u03da\u0007"+
		"\u0013\u0000\u0000\u03da\u03db\u0007\u0005\u0000\u0000\u03db\u03dc\u0007"+
		"\u0007\u0000\u0000\u03dc\u03dd\u0007\u0003\u0000\u0000\u03dd\u03de\u0007"+
		"\u0011\u0000\u0000\u03de\u03df\u0007\n\u0000\u0000\u03df\u03e0\u0007\u0005"+
		"\u0000\u0000\u03e0\u0092\u0001\u0000\u0000\u0000\u03e1\u03e2\u0007\r\u0000"+
		"\u0000\u03e2\u03e3\u0007\f\u0000\u0000\u03e3\u03e4\u0007\n\u0000\u0000"+
		"\u03e4\u03e5\u0007\u000e\u0000\u0000\u03e5\u03e6\u0007\u0018\u0000\u0000"+
		"\u03e6\u03e7\u0007\t\u0000\u0000\u03e7\u0094\u0001\u0000\u0000\u0000\u03e8"+
		"\u03e9\u0007\u0012\u0000\u0000\u03e9\u03ea\u0007\t\u0000\u0000\u03ea\u03eb"+
		"\u0007\u0013\u0000\u0000\u03eb\u03ec\u0007\u0005\u0000\u0000\u03ec\u03ed"+
		"\u0007\b\u0000\u0000\u03ed\u03ee\u0007\u0007\u0000\u0000\u03ee\u0096\u0001"+
		"\u0000\u0000\u0000\u03ef\u03f0\u0007\u0013\u0000\u0000\u03f0\u03f1\u0007"+
		"\u0005\u0000\u0000\u03f1\u03f2\u0007\u0018\u0000\u0000\u03f2\u03f3\u0007"+
		"\u0003\u0000\u0000\u03f3\u03f4\u0007\t\u0000\u0000\u03f4\u03f5\u0007\u0007"+
		"\u0000\u0000\u03f5\u03f6\u0007\u0012\u0000\u0000\u03f6\u03f7\u0007\r\u0000"+
		"\u0000\u03f7\u03f8\u0007\u0013\u0000\u0000\u03f8\u03f9\u0007\u0012\u0000"+
		"\u0000\u03f9\u03fa\u0007\u0018\u0000\u0000\u03fa\u03fb\u0007\u0012\u0000"+
		"\u0000\u03fb\u03fc\u0007\n\u0000\u0000\u03fc\u03fd\u0007\u0003\u0000\u0000"+
		"\u03fd\u03fe\u0007\b\u0000\u0000\u03fe\u03ff\u0007\u0012\u0000\u0000\u03ff"+
		"\u0400\u0007\u0007\u0000\u0000\u0400\u0401\u0007\u0014\u0000\u0000\u0401"+
		"\u0402\u0007\u0004\u0000\u0000\u0402\u0403\u0007\u0005\u0000\u0000\u0403"+
		"\u0404\u0007\u0007\u0000\u0000\u0404\u0405\u0007\u0003\u0000\u0000\u0405"+
		"\u0406\u0007\u0012\u0000\u0000\u0406\u0407\u0007\n\u0000\u0000\u0407\u0408"+
		"\u0007\u0013\u0000\u0000\u0408\u0409\u0007\u0007\u0000\u0000\u0409\u040a"+
		"\u0007\u0003\u0000\u0000\u040a\u040b\u0007\u0011\u0000\u0000\u040b\u040c"+
		"\u0007\n\u0000\u0000\u040c\u040d\u0007\u0005\u0000\u0000\u040d\u0098\u0001"+
		"\u0000\u0000\u0000\u040e\u040f\u0007\r\u0000\u0000\u040f\u0410\u0007\f"+
		"\u0000\u0000\u0410\u0411\u0007\u0018\u0000\u0000\u0411\u0412\u0007\u0018"+
		"\u0000\u0000\u0412\u0413\u0007\u0012\u0000\u0000\u0413\u0414\u0007\u0007"+
		"\u0000\u0000\u0414\u009a\u0001\u0000\u0000\u0000\u0415\u0416\u0007\u0012"+
		"\u0000\u0000\u0416\u0417\u0007\t\u0000\u0000\u0417\u0418\u0007\u0007\u0000"+
		"\u0000\u0418\u0419\u0007\u0005\u0000\u0000\u0419\u041a\u0007\b\u0000\u0000"+
		"\u041a\u041b\u0007\u0013\u0000\u0000\u041b\u041c\u0007\u0005\u0000\u0000"+
		"\u041c\u041d\u0007\r\u0000\u0000\u041d\u041e\u0007\u0007\u0000\u0000\u041e"+
		"\u009c\u0001\u0000\u0000\u0000\u041f\u0420\u0007\u0013\u0000\u0000\u0420"+
		"\u0421\u0007\u0005\u0000\u0000\u0421\u0422\u0007\u0018\u0000\u0000\u0422"+
		"\u0423\u0007\u0003\u0000\u0000\u0423\u0424\u0007\t\u0000\u0000\u0424\u0425"+
		"\u0007\u0007\u0000\u0000\u0425\u0426\u0007\u0012\u0000\u0000\u0426\u0427"+
		"\u0007\r\u0000\u0000\u0427\u0428\u0007\u0013\u0000\u0000\u0428\u0429\u0007"+
		"\u0012\u0000\u0000\u0429\u042a\u0007\u0018\u0000\u0000\u042a\u042b\u0007"+
		"\u0012\u0000\u0000\u042b\u042c\u0007\n\u0000\u0000\u042c\u042d\u0007\u0003"+
		"\u0000\u0000\u042d\u042e\u0007\b\u0000\u0000\u042e\u042f\u0007\u0012\u0000"+
		"\u0000\u042f\u0430\u0007\u0007\u0000\u0000\u0430\u0431\u0007\u0014\u0000"+
		"\u0000\u0431\u0432\u0007\u0007\u0000\u0000\u0432\u0433\u0007\u0003\u0000"+
		"\u0000\u0433\u0434\u0007\u0011\u0000\u0000\u0434\u0435\u0007\n\u0000\u0000"+
		"\u0435\u0436\u0007\u0005\u0000\u0000\u0436\u009e\u0001\u0000\u0000\u0000"+
		"\u0437\u0438\u0007\r\u0000\u0000\u0438\u0439\u0007\f\u0000\u0000\u0439"+
		"\u043a\u0007\u0018\u0000\u0000\u043a\u043b\u0007\u000b\u0000\u0000\u043b"+
		"\u043c\u0007\u000e\u0000\u0000\u043c\u043d\u0007\u0007\u0000\u0000\u043d"+
		"\u043e\u0007\u0005\u0000\u0000\u043e\u00a0\u0001\u0000\u0000\u0000\u043f"+
		"\u0440\u0007\u0012\u0000\u0000\u0440\u0441\u0007\t\u0000\u0000\u0441\u0442"+
		"\u0007\u0007\u0000\u0000\u0442\u0443\u0007\f\u0000\u0000\u0443\u00a2\u0001"+
		"\u0000\u0000\u0000\u0444\u0445\u0007\u0013\u0000\u0000\u0445\u0446\u0007"+
		"\u0005\u0000\u0000\u0446\u0447\u0007\u0013\u0000\u0000\u0447\u0448\u0007"+
		"\u0013\u0000\u0000\u0448\u0449\u0007\u0012\u0000\u0000\u0449\u044a\u0007"+
		"\f\u0000\u0000\u044a\u044b\u0007\t\u0000\u0000\u044b\u044c\u0005_\u0000"+
		"\u0000\u044c\u044d\u0007\u000e\u0000\u0000\u044d\u044e\u0007\u0013\u0000"+
		"\u0000\u044e\u044f\u0007\u0005\u0000\u0000\u044f\u0450\u0007\b\u0000\u0000"+
		"\u0450\u00a4\u0001\u0000\u0000\u0000\u0451\u0452\u0007\r\u0000\u0000\u0452"+
		"\u0453\u0007\f\u0000\u0000\u0453\u0454\u0007\t\u0000\u0000\u0454\u0455"+
		"\u0007\u0013\u0000\u0000\u0455\u0456\u0007\u0007\u0000\u0000\u0456\u0457"+
		"\u0007\b\u0000\u0000\u0457\u0458\u0007\u0003\u0000\u0000\u0458\u0459\u0007"+
		"\u0012\u0000\u0000\u0459\u045a\u0007\t\u0000\u0000\u045a\u045b\u0007\u0007"+
		"\u0000\u0000\u045b\u00a6\u0001\u0000\u0000\u0000\u045c\u045d\u0007\u0012"+
		"\u0000\u0000\u045d\u045e\u0007\u0013\u0000\u0000\u045e\u00a8\u0001\u0000"+
		"\u0000\u0000\u045f\u0460\u0007\u0013\u0000\u0000\u0460\u0461\u0007\u0005"+
		"\u0000\u0000\u0461\u0462\u0007\u0007\u0000\u0000\u0462\u00aa\u0001\u0000"+
		"\u0000\u0000\u0463\u0464\u0007\r\u0000\u0000\u0464\u0465\u0007\f\u0000"+
		"\u0000\u0465\u0466\u0007\t\u0000\u0000\u0466\u0467\u0007\u0007\u0000\u0000"+
		"\u0467\u0468\u0007\u0003\u0000\u0000\u0468\u0469\u0007\u0012\u0000\u0000"+
		"\u0469\u046a\u0007\t\u0000\u0000\u046a\u046b\u0007\u0013\u0000\u0000\u046b"+
		"\u00ac\u0001\u0000\u0000\u0000\u046c\u046d\u0007\u001b\u0000\u0000\u046d"+
		"\u046e\u0007\f\u0000\u0000\u046e\u046f\u0007\u0012\u0000\u0000\u046f\u0470"+
		"\u0007\t\u0000\u0000\u0470\u00ae\u0001\u0000\u0000\u0000\u0471\u0472\u0007"+
		"\u0013\u0000\u0000\u0472\u0473\u0007\u0005\u0000\u0000\u0473\u0474\u0007"+
		"\u0007\u0000\u0000\u0474\u0475\u0007\u000e\u0000\u0000\u0475\u0476\u0007"+
		"\u0013\u0000\u0000\u0476\u0477\u0007\u0005\u0000\u0000\u0477\u0478\u0007"+
		"\b\u0000\u0000\u0478\u00b0\u0001\u0000\u0000\u0000\u0479\u047a\u0007\r"+
		"\u0000\u0000\u047a\u047b\u0007\f\u0000\u0000\u047b\u047c\u0007\t\u0000"+
		"\u0000\u047c\u047d\u0007\u0007\u0000\u0000\u047d\u047e\u0007\u0003\u0000"+
		"\u0000\u047e\u047f\u0007\u0012\u0000\u0000\u047f\u0480\u0007\t\u0000\u0000"+
		"\u0480\u0481\u0007\u0013\u0000\u0000\u0481\u0482\u0007\u0007\u0000\u0000"+
		"\u0482\u0483\u0007\u0003\u0000\u0000\u0483\u0484\u0007\u0011\u0000\u0000"+
		"\u0484\u0485\u0007\n\u0000\u0000\u0485\u0486\u0007\u0005\u0000\u0000\u0486"+
		"\u00b2\u0001\u0000\u0000\u0000\u0487\u0488\u0007\u0017\u0000\u0000\u0488"+
		"\u0489\u0007\u0005\u0000\u0000\u0489\u048a\u0007\u0014\u0000\u0000\u048a"+
		"\u00b4\u0001\u0000\u0000\u0000\u048b\u048c\u0007\u0013\u0000\u0000\u048c"+
		"\u048d\u0007\u0010\u0000\u0000\u048d\u048e\u0007\u000e\u0000\u0000\u048e"+
		"\u048f\u0007\u0007\u0000\u0000\u048f\u0490\u0007\u0004\u0000\u0000\u0490"+
		"\u0491\u0007\f\u0000\u0000\u0491\u0492\u0007\u0019\u0000\u0000\u0492\u0493"+
		"\u0007\t\u0000\u0000\u0493\u00b6\u0001\u0000\u0000\u0000\u0494\u0495\u0007"+
		"\r\u0000\u0000\u0495\u0496\u0007\f\u0000\u0000\u0496\u0497\u0007\t\u0000"+
		"\u0000\u0497\u0498\u0007\u0007\u0000\u0000\u0498\u0499\u0007\u0012\u0000"+
		"\u0000\u0499\u049a\u0007\t\u0000\u0000\u049a\u049b\u0007\u000e\u0000\u0000"+
		"\u049b\u049c\u0007\u0005\u0000\u0000\u049c\u00b8\u0001\u0000\u0000\u0000"+
		"\u049d\u049e\u0007\u0017\u0000\u0000\u049e\u049f\u0007\u0012\u0000\u0000"+
		"\u049f\u04a0\u0007\n\u0000\u0000\u04a0\u04a1\u0007\n\u0000\u0000\u04a1"+
		"\u00ba\u0001\u0000\u0000\u0000\u04a2\u04a3\u0007\u0013\u0000\u0000\u04a3"+
		"\u04a4\u0007\f\u0000\u0000\u04a4\u04a5\u0007\u0018\u0000\u0000\u04a5\u04a6"+
		"\u0007\u0005\u0000\u0000\u04a6\u00bc\u0001\u0000\u0000\u0000\u04a7\u04a8"+
		"\u0007\r\u0000\u0000\u04a8\u04a9\u0007\f\u0000\u0000\u04a9\u04aa\u0007"+
		"\t\u0000\u0000\u04aa\u04ab\u0007\u001a\u0000\u0000\u04ab\u04ac\u0007\u0005"+
		"\u0000\u0000\u04ac\u04ad\u0007\b\u0000\u0000\u04ad\u04ae\u0007\u0007\u0000"+
		"\u0000\u04ae\u00be\u0001\u0000\u0000\u0000\u04af\u04b0\u0007\n\u0000\u0000"+
		"\u04b0\u04b1\u0007\u0005\u0000\u0000\u04b1\u04b2\u0007\u000f\u0000\u0000"+
		"\u04b2\u04b3\u0007\u0007\u0000\u0000\u04b3\u00c0\u0001\u0000\u0000\u0000"+
		"\u04b4\u04b5\u0007\u0013\u0000\u0000\u04b5\u04b6\u0007\u0007\u0000\u0000"+
		"\u04b6\u04b7\u0007\u0003\u0000\u0000\u04b7\u04b8\u0007\u0007\u0000\u0000"+
		"\u04b8\u04b9\u0007\u0012\u0000\u0000\u04b9\u04ba\u0007\u0013\u0000\u0000"+
		"\u04ba\u04bb\u0007\u0007\u0000\u0000\u04bb\u04bc\u0007\u0012\u0000\u0000"+
		"\u04bc\u04bd\u0007\r\u0000\u0000\u04bd\u04be\u0007\u0013\u0000\u0000\u04be"+
		"\u00c2\u0001\u0000\u0000\u0000\u04bf\u04c0\u0007\r\u0000\u0000\u04c0\u04c1"+
		"\u0007\b\u0000\u0000\u04c1\u04c2\u0007\u0005\u0000\u0000\u04c2\u04c3\u0007"+
		"\u0003\u0000\u0000\u04c3\u04c4\u0007\u0007\u0000\u0000\u04c4\u04c5\u0007"+
		"\u0005\u0000\u0000\u04c5\u00c4\u0001\u0000\u0000\u0000\u04c6\u04c7\u0007"+
		"\n\u0000\u0000\u04c7\u04c8\u0007\u0012\u0000\u0000\u04c8\u04c9\u0007\u0017"+
		"\u0000\u0000\u04c9\u04ca\u0007\u0005\u0000\u0000\u04ca\u00c6\u0001\u0000"+
		"\u0000\u0000\u04cb\u04cc\u0007\u0013\u0000\u0000\u04cc\u04cd\u0007\u0014"+
		"\u0000\u0000\u04cd\u04ce\u0007\u0013\u0000\u0000\u04ce\u04cf\u0007\u0007"+
		"\u0000\u0000\u04cf\u04d0\u0007\u0005\u0000\u0000\u04d0\u04d1\u0007\u0018"+
		"\u0000\u0000\u04d1\u04d2\u0005_\u0000\u0000\u04d2\u04d3\u0007\u000e\u0000"+
		"\u0000\u04d3\u04d4\u0007\u0013\u0000\u0000\u04d4\u04d5\u0007\u0005\u0000"+
		"\u0000\u04d5\u04d6\u0007\b\u0000\u0000\u04d6\u00c8\u0001\u0000\u0000\u0000"+
		"\u04d7\u04d8\u0007\r\u0000\u0000\u04d8\u04d9\u0007\b\u0000\u0000\u04d9"+
		"\u04da\u0007\f\u0000\u0000\u04da\u04db\u0007\u0013\u0000\u0000\u04db\u04dc"+
		"\u0007\u0013\u0000\u0000\u04dc\u00ca\u0001\u0000\u0000\u0000\u04dd\u04de"+
		"\u0007\n\u0000\u0000\u04de\u04df\u0007\u0012\u0000\u0000\u04df\u04e0\u0007"+
		"\t\u0000\u0000\u04e0\u04e1\u0007\u0005\u0000\u0000\u04e1\u04e2\u0007\t"+
		"\u0000\u0000\u04e2\u04e3\u0007\f\u0000\u0000\u04e3\u00cc\u0001\u0000\u0000"+
		"\u0000\u04e4\u04e5\u0007\u0007\u0000\u0000\u04e5\u04e6\u0007\u0003\u0000"+
		"\u0000\u04e6\u04e7\u0007\u0011\u0000\u0000\u04e7\u04e8\u0007\n\u0000\u0000"+
		"\u04e8\u04e9\u0007\u0005\u0000\u0000\u04e9\u00ce\u0001\u0000\u0000\u0000"+
		"\u04ea\u04eb\u0007\r\u0000\u0000\u04eb\u04ec\u0007\u000e\u0000\u0000\u04ec"+
		"\u04ed\u0007\b\u0000\u0000\u04ed\u04ee\u0007\b\u0000\u0000\u04ee\u04ef"+
		"\u0007\u0005\u0000\u0000\u04ef\u04f0\u0007\t\u0000\u0000\u04f0\u04f1\u0007"+
		"\u0007\u0000\u0000\u04f1\u00d0\u0001\u0000\u0000\u0000\u04f2\u04f3\u0007"+
		"\n\u0000\u0000\u04f3\u04f4\u0007\f\u0000\u0000\u04f4\u04f5\u0007\u0003"+
		"\u0000\u0000\u04f5\u04f6\u0007\u0004\u0000\u0000\u04f6\u00d2\u0001\u0000"+
		"\u0000\u0000\u04f7\u04f8\u0007\u0007\u0000\u0000\u04f8\u04f9\u0007\u0003"+
		"\u0000\u0000\u04f9\u04fa\u0007\u0011\u0000\u0000\u04fa\u04fb\u0007\n\u0000"+
		"\u0000\u04fb\u04fc\u0007\u0005\u0000\u0000\u04fc\u04fd\u0007\u0013\u0000"+
		"\u0000\u04fd\u04fe\u0007\u0003\u0000\u0000\u04fe\u04ff\u0007\u0018\u0000"+
		"\u0000\u04ff\u0500\u0007\u000b\u0000\u0000\u0500\u0501\u0007\n\u0000\u0000"+
		"\u0501\u0502\u0007\u0005\u0000\u0000\u0502\u00d4\u0001\u0000\u0000\u0000"+
		"\u0503\u0504\u0007\r\u0000\u0000\u0504\u0505\u0007\u000e\u0000\u0000\u0505"+
		"\u0506\u0007\b\u0000\u0000\u0506\u0507\u0007\b\u0000\u0000\u0507\u0508"+
		"\u0007\u0005\u0000\u0000\u0508\u0509\u0007\t\u0000\u0000\u0509\u050a\u0007"+
		"\u0007\u0000\u0000\u050a\u050b\u0005_\u0000\u0000\u050b\u050c\u0007\u0004"+
		"\u0000\u0000\u050c\u050d\u0007\u0003\u0000\u0000\u050d\u050e\u0007\u0007"+
		"\u0000\u0000\u050e\u050f\u0007\u0005\u0000\u0000\u050f\u00d6\u0001\u0000"+
		"\u0000\u0000\u0510\u0511\u0007\u0018\u0000\u0000\u0511\u0512\u0007\u0005"+
		"\u0000\u0000\u0512\u0513\u0007\b\u0000\u0000\u0513\u0514\u0007\u0015\u0000"+
		"\u0000\u0514\u0515\u0007\u0005\u0000\u0000\u0515\u00d8\u0001\u0000\u0000"+
		"\u0000\u0516\u0517\u0007\u0007\u0000\u0000\u0517\u0518\u0007\u0005\u0000"+
		"\u0000\u0518\u0519\u0007\u0006\u0000\u0000\u0519\u051a\u0007\u0007\u0000"+
		"\u0000\u051a\u051b\u0007\u0013\u0000\u0000\u051b\u051c\u0007\u0012\u0000"+
		"\u0000\u051c\u051d\u0007\u0016\u0000\u0000\u051d\u051e\u0007\u0005\u0000"+
		"\u0000\u051e\u00da\u0001\u0000\u0000\u0000\u051f\u0520\u0007\r\u0000\u0000"+
		"\u0520\u0521\u0007\u000e\u0000\u0000\u0521\u0522\u0007\b\u0000\u0000\u0522"+
		"\u0523\u0007\b\u0000\u0000\u0523\u0524\u0007\u0005\u0000\u0000\u0524\u0525"+
		"\u0007\t\u0000\u0000\u0525\u0526\u0007\u0007\u0000\u0000\u0526\u0527\u0005"+
		"_\u0000\u0000\u0527\u0528\u0007\u0007\u0000\u0000\u0528\u0529\u0007\u0012"+
		"\u0000\u0000\u0529\u052a\u0007\u0018\u0000\u0000\u052a\u052b\u0007\u0005"+
		"\u0000\u0000\u052b\u00dc\u0001\u0000\u0000\u0000\u052c\u052d\u0007\t\u0000"+
		"\u0000\u052d\u052e\u0007\u0003\u0000\u0000\u052e\u052f\u0007\u0007\u0000"+
		"\u0000\u052f\u0530\u0007\u0012\u0000\u0000\u0530\u0531\u0007\f\u0000\u0000"+
		"\u0531\u0532\u0007\t\u0000\u0000\u0532\u0533\u0007\u0003\u0000\u0000\u0533"+
		"\u0534\u0007\n\u0000\u0000\u0534\u00de\u0001\u0000\u0000\u0000\u0535\u0536"+
		"\u0007\u0007\u0000\u0000\u0536\u0537\u0007\u0010\u0000\u0000\u0537\u0538"+
		"\u0007\u0005\u0000\u0000\u0538\u0539\u0007\t\u0000\u0000\u0539\u00e0\u0001"+
		"\u0000\u0000\u0000\u053a\u053b\u0007\r\u0000\u0000\u053b\u053c\u0007\u000e"+
		"\u0000\u0000\u053c\u053d\u0007\b\u0000\u0000\u053d\u053e\u0007\b\u0000"+
		"\u0000\u053e\u053f\u0007\u0005\u0000\u0000\u053f\u0540\u0007\t\u0000\u0000"+
		"\u0540\u0541\u0007\u0007\u0000\u0000\u0541\u0542\u0005_\u0000\u0000\u0542"+
		"\u0543\u0007\u0007\u0000\u0000\u0543\u0544\u0007\u0012\u0000\u0000\u0544"+
		"\u0545\u0007\u0018\u0000\u0000\u0545\u0546\u0007\u0005\u0000\u0000\u0546"+
		"\u0547\u0007\u0013\u0000\u0000\u0547\u0548\u0007\u0007\u0000\u0000\u0548"+
		"\u0549\u0007\u0003\u0000\u0000\u0549\u054a\u0007\u0018\u0000\u0000\u054a"+
		"\u054b\u0007\u000b\u0000\u0000\u054b\u00e2\u0001\u0000\u0000\u0000\u054c"+
		"\u054d\u0007\t\u0000\u0000\u054d\u054e\u0007\f\u0000\u0000\u054e\u054f"+
		"\u0007\r\u0000\u0000\u054f\u0550\u0007\u0010\u0000\u0000\u0550\u0551\u0007"+
		"\u0005\u0000\u0000\u0551\u0552\u0007\r\u0000\u0000\u0552\u0553\u0007\u0017"+
		"\u0000\u0000\u0553\u00e4\u0001\u0000\u0000\u0000\u0554\u0555\u0007\u0007"+
		"\u0000\u0000\u0555\u0556\u0007\f\u0000\u0000\u0556\u00e6\u0001\u0000\u0000"+
		"\u0000\u0557\u0558\u0007\r\u0000\u0000\u0558\u0559\u0007\u000e\u0000\u0000"+
		"\u0559\u055a\u0007\b\u0000\u0000\u055a\u055b\u0007\b\u0000\u0000\u055b"+
		"\u055c\u0007\u0005\u0000\u0000\u055c\u055d\u0007\t\u0000\u0000\u055d\u055e"+
		"\u0007\u0007\u0000\u0000\u055e\u055f\u0005_\u0000\u0000\u055f\u0560\u0007"+
		"\u000e\u0000\u0000\u0560\u0561\u0007\u0013\u0000\u0000\u0561\u0562\u0007"+
		"\u0005\u0000\u0000\u0562\u0563\u0007\b\u0000\u0000\u0563\u00e8\u0001\u0000"+
		"\u0000\u0000\u0564\u0565\u0007\t\u0000\u0000\u0565\u0566\u0007\f\u0000"+
		"\u0000\u0566\u0567\u0007\t\u0000\u0000\u0567\u0568\u0007\r\u0000\u0000"+
		"\u0568\u0569\u0007\n\u0000\u0000\u0569\u056a\u0007\u000e\u0000\u0000\u056a"+
		"\u056b\u0007\u0013\u0000\u0000\u056b\u056c\u0007\u0007\u0000\u0000\u056c"+
		"\u056d\u0007\u0005\u0000\u0000\u056d\u056e\u0007\b\u0000\u0000\u056e\u056f"+
		"\u0007\u0005\u0000\u0000\u056f\u0570\u0007\u0004\u0000\u0000\u0570\u00ea"+
		"\u0001\u0000\u0000\u0000\u0571\u0572\u0007\u0007\u0000\u0000\u0572\u0573"+
		"\u0007\f\u0000\u0000\u0573\u0574\u0007\u000b\u0000\u0000\u0574\u00ec\u0001"+
		"\u0000\u0000\u0000\u0575\u0576\u0007\r\u0000\u0000\u0576\u0577\u0007\u000e"+
		"\u0000\u0000\u0577\u0578\u0007\b\u0000\u0000\u0578\u0579\u0007\u0013\u0000"+
		"\u0000\u0579\u057a\u0007\f\u0000\u0000\u057a\u057b\u0007\b\u0000\u0000"+
		"\u057b\u00ee\u0001\u0000\u0000\u0000\u057c\u057d\u0007\t\u0000\u0000\u057d"+
		"\u057e\u0007\f\u0000\u0000\u057e\u057f\u0007\u0007\u0000\u0000\u057f\u00f0"+
		"\u0001\u0000\u0000\u0000\u0580\u0581\u0007\u0007\u0000\u0000\u0581\u0582"+
		"\u0007\b\u0000\u0000\u0582\u0583\u0007\u0003\u0000\u0000\u0583\u0584\u0007"+
		"\t\u0000\u0000\u0584\u00f2\u0001\u0000\u0000\u0000\u0585\u0586\u0007\u0004"+
		"\u0000\u0000\u0586\u0587\u0007\u0003\u0000\u0000\u0587\u0588\u0007\u0007"+
		"\u0000\u0000\u0588\u0589\u0007\u0003\u0000\u0000\u0589\u058a\u0007\u0011"+
		"\u0000\u0000\u058a\u058b\u0007\u0003\u0000\u0000\u058b\u058c\u0007\u0013"+
		"\u0000\u0000\u058c\u058d\u0007\u0005\u0000\u0000\u058d\u00f4\u0001\u0000"+
		"\u0000\u0000\u058e\u058f\u0007\t\u0000\u0000\u058f\u0590\u0007\u000e\u0000"+
		"\u0000\u0590\u0591\u0007\n\u0000\u0000\u0591\u0592\u0007\n\u0000\u0000"+
		"\u0592\u00f6\u0001\u0000\u0000\u0000\u0593\u0594\u0007\u0007\u0000\u0000"+
		"\u0594\u0595\u0007\b\u0000\u0000\u0595\u0596\u0007\u0003\u0000\u0000\u0596"+
		"\u0597\u0007\t\u0000\u0000\u0597\u0598\u0007\u0013\u0000\u0000\u0598\u0599"+
		"\u0007\u0003\u0000\u0000\u0599\u059a\u0007\r\u0000\u0000\u059a\u059b\u0007"+
		"\u0007\u0000\u0000\u059b\u059c\u0007\u0012\u0000\u0000\u059c\u059d\u0007"+
		"\f\u0000\u0000\u059d\u059e\u0007\t\u0000\u0000\u059e\u00f8\u0001\u0000"+
		"\u0000\u0000\u059f\u05a0\u0007\u0004\u0000\u0000\u05a0\u05a1\u0007\u0011"+
		"\u0000\u0000\u05a1\u05a2\u0007\r\u0000\u0000\u05a2\u05a3\u0007\r\u0000"+
		"\u0000\u05a3\u00fa\u0001\u0000\u0000\u0000\u05a4\u05a5\u0007\t\u0000\u0000"+
		"\u05a5\u05a6\u0007\u000e\u0000\u0000\u05a6\u05a7\u0007\n\u0000\u0000\u05a7"+
		"\u05a8\u0007\n\u0000\u0000\u05a8\u05a9\u0007\u0012\u0000\u0000\u05a9\u05aa"+
		"\u0007\u000f\u0000\u0000\u05aa\u00fc\u0001\u0000\u0000\u0000\u05ab\u05ac"+
		"\u0007\u0007\u0000\u0000\u05ac\u05ad\u0007\b\u0000\u0000\u05ad\u05ae\u0007"+
		"\u0012\u0000\u0000\u05ae\u05af\u0007\u0015\u0000\u0000\u05af\u05b0\u0007"+
		"\u0015\u0000\u0000\u05b0\u05b1\u0007\u0005\u0000\u0000\u05b1\u05b2\u0007"+
		"\b\u0000\u0000\u05b2\u00fe\u0001\u0000\u0000\u0000\u05b3\u05b4\u0007\u0004"+
		"\u0000\u0000\u05b4\u05b5\u0007\u0005\u0000\u0000\u05b5\u05b6\u0007\u0003"+
		"\u0000\u0000\u05b6\u05b7\u0007\n\u0000\u0000\u05b7\u05b8\u0007\n\u0000"+
		"\u0000\u05b8\u05b9\u0007\f\u0000\u0000\u05b9\u05ba\u0007\r\u0000\u0000"+
		"\u05ba\u05bb\u0007\u0003\u0000\u0000\u05bb\u05bc\u0007\u0007\u0000\u0000"+
		"\u05bc\u05bd\u0007\u0005\u0000\u0000\u05bd\u0100\u0001\u0000\u0000\u0000"+
		"\u05be\u05bf\u0007\f\u0000\u0000\u05bf\u05c0\u0007\u000f\u0000\u0000\u05c0"+
		"\u0102\u0001\u0000\u0000\u0000\u05c1\u05c2\u0007\u0007\u0000\u0000\u05c2"+
		"\u05c3\u0007\b\u0000\u0000\u05c3\u05c4\u0007\u000e\u0000\u0000\u05c4\u05c5"+
		"\u0007\t\u0000\u0000\u05c5\u05c6\u0007\r\u0000\u0000\u05c6\u05c7\u0007"+
		"\u0003\u0000\u0000\u05c7\u05c8\u0007\u0007\u0000\u0000\u05c8\u05c9\u0007"+
		"\u0005\u0000\u0000\u05c9\u0104\u0001\u0000\u0000\u0000\u05ca\u05cb\u0007"+
		"\u0004\u0000\u0000\u05cb\u05cc\u0007\u0005\u0000\u0000\u05cc\u05cd\u0007"+
		"\r\u0000\u0000\u05cd\u05ce\u0007\n\u0000\u0000\u05ce\u05cf\u0007\u0003"+
		"\u0000\u0000\u05cf\u05d0\u0007\b\u0000\u0000\u05d0\u05d1\u0007\u0005\u0000"+
		"\u0000\u05d1\u0106\u0001\u0000\u0000\u0000\u05d2\u05d3\u0007\f\u0000\u0000"+
		"\u05d3\u05d4\u0007\u000f\u0000\u0000\u05d4\u05d5\u0007\u000f\u0000\u0000"+
		"\u05d5\u0108\u0001\u0000\u0000\u0000\u05d6\u05d7\u0007\u0007\u0000\u0000"+
		"\u05d7\u05d8\u0007\b\u0000\u0000\u05d8\u05d9\u0007\u0014\u0000\u0000\u05d9"+
		"\u05da\u0005_\u0000\u0000\u05da\u05db\u0007\r\u0000\u0000\u05db\u05dc"+
		"\u0007\f\u0000\u0000\u05dc\u05dd\u0007\t\u0000\u0000\u05dd\u05de\u0007"+
		"\u001a\u0000\u0000\u05de\u05df\u0007\u0005\u0000\u0000\u05df\u05e0\u0007"+
		"\b\u0000\u0000\u05e0\u05e1\u0007\u0007\u0000\u0000\u05e1\u010a\u0001\u0000"+
		"\u0000\u0000\u05e2\u05e3\u0007\u0004\u0000\u0000\u05e3\u05e4\u0007\u0005"+
		"\u0000\u0000\u05e4\u05e5\u0007\u000f\u0000\u0000\u05e5\u05e6\u0007\u0003"+
		"\u0000\u0000\u05e6\u05e7\u0007\u000e\u0000\u0000\u05e7\u05e8\u0007\n\u0000"+
		"\u0000\u05e8\u05e9\u0007\u0007\u0000\u0000\u05e9\u010c\u0001\u0000\u0000"+
		"\u0000\u05ea\u05eb\u0007\f\u0000\u0000\u05eb\u05ec\u0007\u000f\u0000\u0000"+
		"\u05ec\u05ed\u0007\u000f\u0000\u0000\u05ed\u05ee\u0007\u0013\u0000\u0000"+
		"\u05ee\u05ef\u0007\u0005\u0000\u0000\u05ef\u05f0\u0007\u0007\u0000\u0000"+
		"\u05f0\u05f1\u0007\u0013\u0000\u0000\u05f1\u010e\u0001\u0000\u0000\u0000"+
		"\u05f2\u05f3\u0007\u0007\u0000\u0000\u05f3\u05f4\u0007\u0013\u0000\u0000"+
		"\u05f4\u05f5\u0007\u0005\u0000\u0000\u05f5\u05f6\u0007\u001c\u0000\u0000"+
		"\u05f6\u05f7\u0007\u000e\u0000\u0000\u05f7\u05f8\u0007\u0003\u0000\u0000"+
		"\u05f8\u05f9\u0007\n\u0000\u0000\u05f9\u0110\u0001\u0000\u0000\u0000\u05fa"+
		"\u05fb\u0007\u0004\u0000\u0000\u05fb\u05fc\u0007\u0005\u0000\u0000\u05fc"+
		"\u05fd\u0007\n\u0000\u0000\u05fd\u05fe\u0007\u0005\u0000\u0000\u05fe\u05ff"+
		"\u0007\u0007\u0000\u0000\u05ff\u0600\u0007\u0005\u0000\u0000\u0600\u0112"+
		"\u0001\u0000\u0000\u0000\u0601\u0602\u0007\f\u0000\u0000\u0602\u0603\u0007"+
		"\t\u0000\u0000\u0603\u0114\u0001\u0000\u0000\u0000\u0604\u0605\u0007\u000e"+
		"\u0000\u0000\u0605\u0606\u0007\t\u0000\u0000\u0606\u0607\u0007\u0012\u0000"+
		"\u0000\u0607\u0608\u0007\f\u0000\u0000\u0608\u0609\u0007\t\u0000\u0000"+
		"\u0609\u0116\u0001\u0000\u0000\u0000\u060a\u060b\u0007\u0004\u0000\u0000"+
		"\u060b\u060c\u0007\u0005\u0000\u0000\u060c\u060d\u0007\t\u0000\u0000\u060d"+
		"\u060e\u0007\u0014\u0000\u0000\u060e\u0118\u0001\u0000\u0000\u0000\u060f"+
		"\u0610\u0007\f\u0000\u0000\u0610\u0611\u0007\u000b\u0000\u0000\u0611\u0612"+
		"\u0007\u0005\u0000\u0000\u0612\u0613\u0007\t\u0000\u0000\u0613\u011a\u0001"+
		"\u0000\u0000\u0000\u0614\u0615\u0007\u000e\u0000\u0000\u0615\u0616\u0007"+
		"\t\u0000\u0000\u0616\u0617\u0007\u0012\u0000\u0000\u0617\u0618\u0007\u001c"+
		"\u0000\u0000\u0618\u0619\u0007\u000e\u0000\u0000\u0619\u061a\u0007\u0005"+
		"\u0000\u0000\u061a\u011c\u0001\u0000\u0000\u0000\u061b\u061c\u0007\u0004"+
		"\u0000\u0000\u061c\u061d\u0007\u0005\u0000\u0000\u061d\u061e\u0007\u0013"+
		"\u0000\u0000\u061e\u061f\u0007\r\u0000\u0000\u061f\u011e\u0001\u0000\u0000"+
		"\u0000\u0620\u0621\u0007\f\u0000\u0000\u0621\u0622\u0007\u000b\u0000\u0000"+
		"\u0622\u0623\u0007\u0005\u0000\u0000\u0623\u0624\u0007\t\u0000\u0000\u0624"+
		"\u0625\u0007\u0004\u0000\u0000\u0625\u0626\u0007\u0003\u0000\u0000\u0626"+
		"\u0627\u0007\u0007\u0000\u0000\u0627\u0628\u0007\u0003\u0000\u0000\u0628"+
		"\u0629\u0007\u0013\u0000\u0000\u0629\u062a\u0007\f\u0000\u0000\u062a\u062b"+
		"\u0007\u000e\u0000\u0000\u062b\u062c\u0007\b\u0000\u0000\u062c\u062d\u0007"+
		"\r\u0000\u0000\u062d\u062e\u0007\u0005\u0000\u0000\u062e\u0120\u0001\u0000"+
		"\u0000\u0000\u062f\u0630\u0007\u000e\u0000\u0000\u0630\u0631\u0007\u000b"+
		"\u0000\u0000\u0631\u0632\u0007\u0004\u0000\u0000\u0632\u0633\u0007\u0003"+
		"\u0000\u0000\u0633\u0634\u0007\u0007\u0000\u0000\u0634\u0635\u0007\u0005"+
		"\u0000\u0000\u0635\u0122\u0001\u0000\u0000\u0000\u0636\u0637\u0007\u0004"+
		"\u0000\u0000\u0637\u0638\u0007\u0012\u0000\u0000\u0638\u0639\u0007\u0013"+
		"\u0000\u0000\u0639\u063a\u0007\u0017\u0000\u0000\u063a\u0124\u0001\u0000"+
		"\u0000\u0000\u063b\u063c\u0007\f\u0000\u0000\u063c\u063d\u0007\u000b\u0000"+
		"\u0000\u063d\u063e\u0007\u0005\u0000\u0000\u063e\u063f\u0007\t\u0000\u0000"+
		"\u063f\u0640\u0007\u001c\u0000\u0000\u0640\u0641\u0007\u000e\u0000\u0000"+
		"\u0641\u0642\u0007\u0005\u0000\u0000\u0642\u0643\u0007\b\u0000\u0000\u0643"+
		"\u0644\u0007\u0014\u0000\u0000\u0644\u0126\u0001\u0000\u0000\u0000\u0645"+
		"\u0646\u0007\u000e\u0000\u0000\u0646\u0647\u0007\u000b\u0000\u0000\u0647"+
		"\u0648\u0007\u0004\u0000\u0000\u0648\u0649\u0007\u0003\u0000\u0000\u0649"+
		"\u064a\u0007\u0007\u0000\u0000\u064a\u064b\u0007\u0005\u0000\u0000\u064b"+
		"\u064c\u0007\u0007\u0000\u0000\u064c\u064d\u0007\u0005\u0000\u0000\u064d"+
		"\u064e\u0007\u0006\u0000\u0000\u064e\u064f\u0007\u0007\u0000\u0000\u064f"+
		"\u0128\u0001\u0000\u0000\u0000\u0650\u0651\u0007\u0004\u0000\u0000\u0651"+
		"\u0652\u0007\u0012\u0000\u0000\u0652\u0653\u0007\u0013\u0000\u0000\u0653"+
		"\u0654\u0007\u0007\u0000\u0000\u0654\u0655\u0007\u0012\u0000\u0000\u0655"+
		"\u0656\u0007\t\u0000\u0000\u0656\u0657\u0007\r\u0000\u0000\u0657\u0658"+
		"\u0007\u0007\u0000\u0000\u0658\u012a\u0001\u0000\u0000\u0000\u0659\u065a"+
		"\u0007\f\u0000\u0000\u065a\u065b\u0007\u000b\u0000\u0000\u065b\u065c\u0007"+
		"\u0005\u0000\u0000\u065c\u065d\u0007\t\u0000\u0000\u065d\u065e\u0007\b"+
		"\u0000\u0000\u065e\u065f\u0007\f\u0000\u0000\u065f\u0660\u0007\u0019\u0000"+
		"\u0000\u0660\u0661\u0007\u0013\u0000\u0000\u0661\u0662\u0007\u0005\u0000"+
		"\u0000\u0662\u0663\u0007\u0007\u0000\u0000\u0663\u012c\u0001\u0000\u0000"+
		"\u0000\u0664\u0665\u0007\u000e\u0000\u0000\u0665\u0666\u0007\u0013\u0000"+
		"\u0000\u0666\u0667\u0007\u0005\u0000\u0000\u0667\u012e\u0001\u0000\u0000"+
		"\u0000\u0668\u0669\u0007\u0004\u0000\u0000\u0669\u066a\u0007\u0012\u0000"+
		"\u0000\u066a\u066b\u0007\u0013\u0000\u0000\u066b\u066c\u0007\u0007\u0000"+
		"\u0000\u066c\u066d\u0007\b\u0000\u0000\u066d\u066e\u0007\u0012\u0000\u0000"+
		"\u066e\u066f\u0007\u0011\u0000\u0000\u066f\u0670\u0007\u000e\u0000\u0000"+
		"\u0670\u0671\u0007\u0007\u0000\u0000\u0671\u0672\u0007\u0005\u0000\u0000"+
		"\u0672\u0673\u0007\u0004\u0000\u0000\u0673\u0130\u0001\u0000\u0000\u0000"+
		"\u0674\u0675\u0007\f\u0000\u0000\u0675\u0676\u0007\u000b\u0000\u0000\u0676"+
		"\u0677\u0007\u0005\u0000\u0000\u0677\u0678\u0007\t\u0000\u0000\u0678\u0679"+
		"\u0007\u0006\u0000\u0000\u0679\u067a\u0007\u0018\u0000\u0000\u067a\u067b"+
		"\u0007\n\u0000\u0000\u067b\u0132\u0001\u0000\u0000\u0000\u067c\u067d\u0007"+
		"\u000e\u0000\u0000\u067d\u067e\u0007\u0013\u0000\u0000\u067e\u067f\u0007"+
		"\u0005\u0000\u0000\u067f\u0680\u0007\b\u0000\u0000\u0680\u0134\u0001\u0000"+
		"\u0000\u0000\u0681\u0682\u0007\u0004\u0000\u0000\u0682\u0683\u0007\f\u0000"+
		"\u0000\u0683\u0684\u0007\u000e\u0000\u0000\u0684\u0685\u0007\u0011\u0000"+
		"\u0000\u0685\u0686\u0007\n\u0000\u0000\u0686\u0687\u0007\u0005\u0000\u0000"+
		"\u0687\u0136\u0001\u0000\u0000\u0000\u0688\u0689\u0007\f\u0000\u0000\u0689"+
		"\u068a\u0007\u000b\u0000\u0000\u068a\u068b\u0007\u0007\u0000\u0000\u068b"+
		"\u068c\u0007\u0012\u0000\u0000\u068c\u068d\u0007\f\u0000\u0000\u068d\u068e"+
		"\u0007\t\u0000\u0000\u068e\u0138\u0001\u0000\u0000\u0000\u068f\u0690\u0007"+
		"\u001a\u0000\u0000\u0690\u0691\u0007\u0003\u0000\u0000\u0691\u0692\u0007"+
		"\n\u0000\u0000\u0692\u0693\u0007\u000e\u0000\u0000\u0693\u0694\u0007\u0005"+
		"\u0000\u0000\u0694\u0695\u0007\u0013\u0000\u0000\u0695\u013a\u0001\u0000"+
		"\u0000\u0000\u0696\u0697\u0007\u0004\u0000\u0000\u0697\u0698\u0007\b\u0000"+
		"\u0000\u0698\u0699\u0007\f\u0000\u0000\u0699\u069a\u0007\u000b\u0000\u0000"+
		"\u069a\u013c\u0001\u0000\u0000\u0000\u069b\u069c\u0007\f\u0000\u0000\u069c"+
		"\u069d\u0007\b\u0000\u0000\u069d\u013e\u0001\u0000\u0000\u0000\u069e\u069f"+
		"\u0007\u001a\u0000\u0000\u069f\u06a0\u0007\u0003\u0000\u0000\u06a0\u06a1"+
		"\u0007\b\u0000\u0000\u06a1\u06a2\u0007\u0014\u0000\u0000\u06a2\u06a3\u0007"+
		"\u0012\u0000\u0000\u06a3\u06a4\u0007\t\u0000\u0000\u06a4\u06a5\u0007\u0015"+
		"\u0000\u0000\u06a5\u0140\u0001\u0000\u0000\u0000\u06a6\u06a7\u0007\u0004"+
		"\u0000\u0000\u06a7\u06a8\u0007\u000e\u0000\u0000\u06a8\u06a9\u0007\u0018"+
		"\u0000\u0000\u06a9\u06aa\u0007\u000b\u0000\u0000\u06aa\u0142\u0001\u0000"+
		"\u0000\u0000\u06ab\u06ac\u0007\f\u0000\u0000\u06ac\u06ad\u0007\b\u0000"+
		"\u0000\u06ad\u06ae\u0007\u0004\u0000\u0000\u06ae\u06af\u0007\u0005\u0000"+
		"\u0000\u06af\u06b0\u0007\b\u0000\u0000\u06b0\u0144\u0001\u0000\u0000\u0000"+
		"\u06b1\u06b2\u0007\u001a\u0000\u0000\u06b2\u06b3\u0007\u0012\u0000\u0000"+
		"\u06b3\u06b4\u0007\u0005\u0000\u0000\u06b4\u06b5\u0007\u0019\u0000\u0000"+
		"\u06b5\u0146\u0001\u0000\u0000\u0000\u06b6\u06b7\u0007\u0005\u0000\u0000"+
		"\u06b7\u06b8\u0007\n\u0000\u0000\u06b8\u06b9\u0007\u0013\u0000\u0000\u06b9"+
		"\u06ba\u0007\u0005\u0000\u0000\u06ba\u0148\u0001\u0000\u0000\u0000\u06bb"+
		"\u06bc\u0007\f\u0000\u0000\u06bc\u06bd\u0007\u000e\u0000\u0000\u06bd\u06be"+
		"\u0007\u0007\u0000\u0000\u06be\u06bf\u0007\u0005\u0000\u0000\u06bf\u06c0"+
		"\u0007\b\u0000\u0000\u06c0\u014a\u0001\u0000\u0000\u0000\u06c1\u06c2\u0007"+
		"\u0019\u0000\u0000\u06c2\u06c3\u0007\u0003\u0000\u0000\u06c3\u06c4\u0007"+
		"\u0012\u0000\u0000\u06c4\u06c5\u0007\u0007\u0000\u0000\u06c5\u06c6\u0007"+
		"\u000f\u0000\u0000\u06c6\u06c7\u0007\f\u0000\u0000\u06c7\u06c8\u0007\b"+
		"\u0000\u0000\u06c8\u014c\u0001\u0000\u0000\u0000\u06c9\u06ca\u0007\u0005"+
		"\u0000\u0000\u06ca\u06cb\u0007\t\u0000\u0000\u06cb\u06cc\u0007\u0004\u0000"+
		"\u0000\u06cc\u014e\u0001\u0000\u0000\u0000\u06cd\u06ce\u0007\f\u0000\u0000"+
		"\u06ce\u06cf\u0007\u001a\u0000\u0000\u06cf\u06d0\u0007\u0005\u0000\u0000"+
		"\u06d0\u06d1\u0007\b\u0000\u0000\u06d1\u0150\u0001\u0000\u0000\u0000\u06d2"+
		"\u06d3\u0007\u0019\u0000\u0000\u06d3\u06d4\u0007\u0010\u0000\u0000\u06d4"+
		"\u06d5\u0007\u0005\u0000\u0000\u06d5\u06d6\u0007\t\u0000\u0000\u06d6\u0152"+
		"\u0001\u0000\u0000\u0000\u06d7\u06d8\u0007\u0005\u0000\u0000\u06d8\u06d9"+
		"\u0007\b\u0000\u0000\u06d9\u06da\u0007\b\u0000\u0000\u06da\u06db\u0007"+
		"\n\u0000\u0000\u06db\u06dc\u0007\u001a\u0000\u0000\u06dc\u06dd\u0007\n"+
		"\u0000\u0000\u06dd\u0154\u0001\u0000\u0000\u0000\u06de\u06df\u0007\u000b"+
		"\u0000\u0000\u06df\u06e0\u0007\u0005\u0000\u0000\u06e0\u06e1\u0007\b\u0000"+
		"\u0000\u06e1\u06e2\u0007\r\u0000\u0000\u06e2\u06e3\u0007\u0005\u0000\u0000"+
		"\u06e3\u06e4\u0007\t\u0000\u0000\u06e4\u06e5\u0007\u0007\u0000\u0000\u06e5"+
		"\u0156\u0001\u0000\u0000\u0000\u06e6\u06e7\u0007\u0019\u0000\u0000\u06e7"+
		"\u06e8\u0007\u0010\u0000\u0000\u06e8\u06e9\u0007\u0005\u0000\u0000\u06e9"+
		"\u06ea\u0007\b\u0000\u0000\u06ea\u06eb\u0007\u0005\u0000\u0000\u06eb\u0158"+
		"\u0001\u0000\u0000\u0000\u06ec\u06ed\u0007\u0005\u0000\u0000\u06ed\u06ee"+
		"\u0007\u0013\u0000\u0000\u06ee\u06ef\u0007\r\u0000\u0000\u06ef\u06f0\u0007"+
		"\u0003\u0000\u0000\u06f0\u06f1\u0007\u000b\u0000\u0000\u06f1\u06f2\u0007"+
		"\u0005\u0000\u0000\u06f2\u015a\u0001\u0000\u0000\u0000\u06f3\u06f4\u0007"+
		"\u000b\u0000\u0000\u06f4\u06f5\u0007\u0012\u0000\u0000\u06f5\u06f6\u0007"+
		"\u001a\u0000\u0000\u06f6\u06f7\u0007\f\u0000\u0000\u06f7\u06f8\u0007\u0007"+
		"\u0000\u0000\u06f8\u015c\u0001\u0000\u0000\u0000\u06f9\u06fa\u0007\u0019"+
		"\u0000\u0000\u06fa\u06fb\u0007\u0010\u0000\u0000\u06fb\u06fc\u0007\u0012"+
		"\u0000\u0000\u06fc\u06fd\u0007\n\u0000\u0000\u06fd\u06fe\u0007\u0005\u0000"+
		"\u0000\u06fe\u015e\u0001\u0000\u0000\u0000\u06ff\u0700\u0007\u0005\u0000"+
		"\u0000\u0700\u0701\u0007\u0006\u0000\u0000\u0701\u0702\u0007\r\u0000\u0000"+
		"\u0702\u0703\u0007\u0005\u0000\u0000\u0703\u0704\u0007\u000b\u0000\u0000"+
		"\u0704\u0705\u0007\u0007\u0000\u0000\u0705\u0160\u0001\u0000\u0000\u0000"+
		"\u0706\u0707\u0007\u000b\u0000\u0000\u0707\u0708\u0007\n\u0000\u0000\u0708"+
		"\u0709\u0007\u0003\u0000\u0000\u0709\u070a\u0007\t\u0000\u0000\u070a\u0162"+
		"\u0001\u0000\u0000\u0000\u070b\u070c\u0007\u0019\u0000\u0000\u070c\u070d"+
		"\u0007\u0012\u0000\u0000\u070d\u070e\u0007\u0007\u0000\u0000\u070e\u070f"+
		"\u0007\u0010\u0000\u0000\u070f\u0164\u0001\u0000\u0000\u0000\u0710\u0711"+
		"\u0007\u0005\u0000\u0000\u0711\u0712\u0007\u0006\u0000\u0000\u0712\u0713"+
		"\u0007\u0005\u0000\u0000\u0713\u0714\u0007\r\u0000\u0000\u0714\u0166\u0001"+
		"\u0000\u0000\u0000\u0715\u0716\u0007\u000b\u0000\u0000\u0716\u0717\u0007"+
		"\b\u0000\u0000\u0717\u0718\u0007\u0005\u0000\u0000\u0718\u0719\u0007\r"+
		"\u0000\u0000\u0719\u071a\u0007\u0012\u0000\u0000\u071a\u071b\u0007\u0013"+
		"\u0000\u0000\u071b\u071c\u0007\u0012\u0000\u0000\u071c\u071d\u0007\f\u0000"+
		"\u0000\u071d\u071e\u0007\t\u0000\u0000\u071e\u0168\u0001\u0000\u0000\u0000"+
		"\u071f\u0720\u0007\u0019\u0000\u0000\u0720\u0721\u0007\b\u0000\u0000\u0721"+
		"\u0722\u0007\u0012\u0000\u0000\u0722\u0723\u0007\u0007\u0000\u0000\u0723"+
		"\u0724\u0007\u0005\u0000\u0000\u0724\u0725\u0007\u0007\u0000\u0000\u0725"+
		"\u0726\u0007\u0005\u0000\u0000\u0726\u0727\u0007\u0006\u0000\u0000\u0727"+
		"\u0728\u0007\u0007\u0000\u0000\u0728\u016a\u0001\u0000\u0000\u0000\u0729"+
		"\u072a\u0007\u0005\u0000\u0000\u072a\u072b\u0007\u0006\u0000\u0000\u072b"+
		"\u072c\u0007\u0005\u0000\u0000\u072c\u072d\u0007\r\u0000\u0000\u072d\u072e"+
		"\u0007\u000e\u0000\u0000\u072e\u072f\u0007\u0007\u0000\u0000\u072f\u0730"+
		"\u0007\u0005\u0000\u0000\u0730\u016c\u0001\u0000\u0000\u0000\u0731\u0732"+
		"\u0007\u000b\u0000\u0000\u0732\u0733\u0007\b\u0000\u0000\u0733\u0734\u0007"+
		"\u0012\u0000\u0000\u0734\u0735\u0007\u0018\u0000\u0000\u0735\u0736\u0007"+
		"\u0003\u0000\u0000\u0736\u0737\u0007\b\u0000\u0000\u0737\u0738\u0007\u0014"+
		"\u0000\u0000\u0738\u016e\u0001\u0000\u0000\u0000\u0739\u073a\u0007\u0012"+
		"\u0000\u0000\u073a\u073b\u0007\t\u0000\u0000\u073b\u073c\u0007\u0007\u0000"+
		"\u0000\u073c\u073d\u0007\u0005\u0000\u0000\u073d\u073e\u0007\u0015\u0000"+
		"\u0000\u073e\u073f\u0007\u0005\u0000\u0000\u073f\u0740\u0007\b\u0000\u0000"+
		"\u0740\u0170\u0001\u0000\u0000\u0000\u0741\u0742\u0007\t\u0000\u0000\u0742"+
		"\u0743\u0007\u001a\u0000\u0000\u0743\u0744\u0007\u0003\u0000\u0000\u0744"+
		"\u0745\u0007\b\u0000\u0000\u0745\u0746\u0007\r\u0000\u0000\u0746\u0747"+
		"\u0007\u0010\u0000\u0000\u0747\u0748\u0007\u0003\u0000\u0000\u0748\u0749"+
		"\u0007\b\u0000\u0000\u0749\u0172\u0001\u0000\u0000\u0000\u074a\u074b\u0007"+
		"\u001a\u0000\u0000\u074b\u074c\u0007\u0003\u0000\u0000\u074c\u074d\u0007"+
		"\b\u0000\u0000\u074d\u074e\u0007\r\u0000\u0000\u074e\u074f\u0007\u0010"+
		"\u0000\u0000\u074f\u0750\u0007\u0003\u0000\u0000\u0750\u0751\u0007\b\u0000"+
		"\u0000\u0751\u0174\u0001\u0000\u0000\u0000\u0752\u0753\u0007\u0018\u0000"+
		"\u0000\u0753\u0754\u0007\u0003\u0000\u0000\u0754\u0755\u0007\u0006\u0000"+
		"\u0000\u0755\u0176\u0001\u0000\u0000\u0000\u0756\u0757\u0007\u0018\u0000"+
		"\u0000\u0757\u0758\u0007\u0012\u0000\u0000\u0758\u0759\u0007\t\u0000\u0000"+
		"\u0759\u0178\u0001\u0000\u0000\u0000\u075a\u075b\u0007\u0003\u0000\u0000"+
		"\u075b\u075c\u0007\u001a\u0000\u0000\u075c\u075d\u0007\u0015\u0000\u0000"+
		"\u075d\u017a\u0001\u0000\u0000\u0000\u075e\u075f\u0007\u0013\u0000\u0000"+
		"\u075f\u0760\u0007\u000e\u0000\u0000\u0760\u0761\u0007\u0018\u0000\u0000"+
		"\u0761\u017c\u0001\u0000\u0000\u0000\u0762\u0763\u0007\r\u0000\u0000\u0763"+
		"\u0764\u0007\f\u0000\u0000\u0764\u0765\u0007\u000e\u0000\u0000\u0765\u0766"+
		"\u0007\t\u0000\u0000\u0766\u0767\u0007\u0007\u0000\u0000\u0767\u017e\u0001"+
		"\u0000\u0000\u0000\u0768\u0769\u0007\u0007\u0000\u0000\u0769\u076a\u0007"+
		"\b\u0000\u0000\u076a\u076b\u0007\u0014\u0000\u0000\u076b\u0180\u0001\u0000"+
		"\u0000\u0000\u076c\u076d\u0007\r\u0000\u0000\u076d\u076e\u0007\u0003\u0000"+
		"\u0000\u076e\u076f\u0007\u0007\u0000\u0000\u076f\u0770\u0007\r\u0000\u0000"+
		"\u0770\u0771\u0007\u0010\u0000\u0000\u0771\u0182\u0001\u0000\u0000\u0000"+
		"\u0772\u0773\u0007\u0005\u0000\u0000\u0773\u0774\u0007\u0006\u0000\u0000"+
		"\u0774\u0775\u0007\u0012\u0000\u0000\u0775\u0776\u0007\u0013\u0000\u0000"+
		"\u0776\u0777\u0007\u0007\u0000\u0000\u0777\u0778\u0007\u0013\u0000\u0000"+
		"\u0778\u0184\u0001\u0000\u0000\u0000\u0779\u077b\u0003\u0001\u0000\u0000"+
		"\u077a\u0779\u0001\u0000\u0000\u0000\u077b\u077c\u0001\u0000\u0000\u0000"+
		"\u077c\u077a\u0001\u0000\u0000\u0000\u077c\u077d\u0001\u0000\u0000\u0000"+
		"\u077d\u0186\u0001\u0000\u0000\u0000\u077e\u0780\u0003\u0001\u0000\u0000"+
		"\u077f\u077e\u0001\u0000\u0000\u0000\u0780\u0781\u0001\u0000\u0000\u0000"+
		"\u0781\u077f\u0001\u0000\u0000\u0000\u0781\u0782\u0001\u0000\u0000\u0000"+
		"\u0782\u0783\u0001\u0000\u0000\u0000\u0783\u0785\u0005.\u0000\u0000\u0784"+
		"\u0786\u0003\u0001\u0000\u0000\u0785\u0784\u0001\u0000\u0000\u0000\u0786"+
		"\u0787\u0001\u0000\u0000\u0000\u0787\u0785\u0001\u0000\u0000\u0000\u0787"+
		"\u0788\u0001\u0000\u0000\u0000\u0788\u0188\u0001\u0000\u0000\u0000\u0789"+
		"\u078a\u00050\u0000\u0000\u078a\u078c\u0007\u0006\u0000\u0000\u078b\u0789"+
		"\u0001\u0000\u0000\u0000\u078c\u078d\u0001\u0000\u0000\u0000\u078d\u078b"+
		"\u0001\u0000\u0000\u0000\u078d\u078e\u0001\u0000\u0000\u0000\u078e\u018a"+
		"\u0001\u0000\u0000\u0000\u078f\u0790\u00050\u0000\u0000\u0790\u0791\u0007"+
		"\u0011\u0000\u0000\u0791\u0793\u0001\u0000\u0000\u0000\u0792\u0794\u0007"+
		"\u001d\u0000\u0000\u0793\u0792\u0001\u0000\u0000\u0000\u0794\u0795\u0001"+
		"\u0000\u0000\u0000\u0795\u0793\u0001\u0000\u0000\u0000\u0795\u0796\u0001"+
		"\u0000\u0000\u0000\u0796\u018c\u0001\u0000\u0000\u0000\u0797\u0798\u0007"+
		"\u0007\u0000\u0000\u0798\u0799\u0007\b\u0000\u0000\u0799\u079a\u0007\u000e"+
		"\u0000\u0000\u079a\u079b\u0007\u0005\u0000\u0000\u079b\u018e\u0001\u0000"+
		"\u0000\u0000\u079c\u079d\u0007\u000f\u0000\u0000\u079d\u079e\u0007\u0003"+
		"\u0000\u0000\u079e\u079f\u0007\n\u0000\u0000\u079f\u07a0\u0007\u0013\u0000"+
		"\u0000\u07a0\u07a1\u0007\u0005\u0000\u0000\u07a1\u0190\u0001\u0000\u0000"+
		"\u0000\u07a2\u07a4\u0007\t\u0000\u0000\u07a3\u07a2\u0001\u0000\u0000\u0000"+
		"\u07a3\u07a4\u0001\u0000\u0000\u0000\u07a4\u07a5\u0001\u0000\u0000\u0000"+
		"\u07a5\u07be\u0005\'\u0000\u0000\u07a6\u07bd\b\u001e\u0000\u0000\u07a7"+
		"\u07a8\u0005\\\u0000\u0000\u07a8\u07bd\t\u0000\u0000\u0000\u07a9\u07aa"+
		"\u0005\'\u0000\u0000\u07aa\u07bd\u0005\'\u0000\u0000\u07ab\u07af\u0005"+
		"\\\u0000\u0000\u07ac\u07ae\u0007\u001f\u0000\u0000\u07ad\u07ac\u0001\u0000"+
		"\u0000\u0000\u07ae\u07b1\u0001\u0000\u0000\u0000\u07af\u07ad\u0001\u0000"+
		"\u0000\u0000\u07af\u07b0\u0001\u0000\u0000\u0000\u07b0\u07b3\u0001\u0000"+
		"\u0000\u0000\u07b1\u07af\u0001\u0000\u0000\u0000\u07b2\u07b4\u0005\r\u0000"+
		"\u0000\u07b3\u07b2\u0001\u0000\u0000\u0000\u07b3\u07b4\u0001\u0000\u0000"+
		"\u0000\u07b4\u07b5\u0001\u0000\u0000\u0000\u07b5\u07b9\u0005\n\u0000\u0000"+
		"\u07b6\u07b8\u0007\u001f\u0000\u0000\u07b7\u07b6\u0001\u0000\u0000\u0000"+
		"\u07b8\u07bb\u0001\u0000\u0000\u0000\u07b9\u07b7\u0001\u0000\u0000\u0000"+
		"\u07b9\u07ba\u0001\u0000\u0000\u0000\u07ba\u07bd\u0001\u0000\u0000\u0000"+
		"\u07bb\u07b9\u0001\u0000\u0000\u0000\u07bc\u07a6\u0001\u0000\u0000\u0000"+
		"\u07bc\u07a7\u0001\u0000\u0000\u0000\u07bc\u07a9\u0001\u0000\u0000\u0000"+
		"\u07bc\u07ab\u0001\u0000\u0000\u0000\u07bd\u07c0\u0001\u0000\u0000\u0000"+
		"\u07be\u07bc\u0001\u0000\u0000\u0000\u07be\u07bf\u0001\u0000\u0000\u0000"+
		"\u07bf\u07c1\u0001\u0000\u0000\u0000\u07c0\u07be\u0001\u0000\u0000\u0000"+
		"\u07c1\u07c2\u0005\'\u0000\u0000\u07c2\u07c3\u0006\u00c8\u0001\u0000\u07c3"+
		"\u0192\u0001\u0000\u0000\u0000\u07c4\u07c8\u0005[\u0000\u0000\u07c5\u07c7"+
		"\b \u0000\u0000\u07c6\u07c5\u0001\u0000\u0000\u0000\u07c7\u07ca\u0001"+
		"\u0000\u0000\u0000\u07c8\u07c6\u0001\u0000\u0000\u0000\u07c8\u07c9\u0001"+
		"\u0000\u0000\u0000\u07c9\u07cb\u0001\u0000\u0000\u0000\u07ca\u07c8\u0001"+
		"\u0000\u0000\u0000\u07cb\u07cc\u0005]\u0000\u0000\u07cc\u0194\u0001\u0000"+
		"\u0000\u0000\u07cd\u07d2\u0003\u0003\u0001\u0000\u07ce\u07d1\u0003\u0003"+
		"\u0001\u0000\u07cf\u07d1\u0003\u0001\u0000\u0000\u07d0\u07ce\u0001\u0000"+
		"\u0000\u0000\u07d0\u07cf\u0001\u0000\u0000\u0000\u07d1\u07d4\u0001\u0000"+
		"\u0000\u0000\u07d2\u07d0\u0001\u0000\u0000\u0000\u07d2\u07d3\u0001\u0000"+
		"\u0000\u0000\u07d3\u0196\u0001\u0000\u0000\u0000\u07d4\u07d2\u0001\u0000"+
		"\u0000\u0000\u07d5\u07d6\u0005@\u0000\u0000\u07d6\u07d7\u0003\u0195\u00ca"+
		"\u0000\u07d7\u0198\u0001\u0000\u0000\u0000\u07d8\u07d9\u0005=\u0000\u0000"+
		"\u07d9\u019a\u0001\u0000\u0000\u0000\u07da\u07db\u0005<\u0000\u0000\u07db"+
		"\u07df\u0005>\u0000\u0000\u07dc\u07dd\u0005!\u0000\u0000\u07dd\u07df\u0005"+
		"=\u0000\u0000\u07de\u07da\u0001\u0000\u0000\u0000\u07de\u07dc\u0001\u0000"+
		"\u0000\u0000\u07df\u019c\u0001\u0000\u0000\u0000\u07e0\u07e1\u0005>\u0000"+
		"\u0000\u07e1\u019e\u0001\u0000\u0000\u0000\u07e2\u07e3\u0005<\u0000\u0000"+
		"\u07e3\u01a0\u0001\u0000\u0000\u0000\u07e4\u07e5\u0005>\u0000\u0000\u07e5"+
		"\u07e6\u0005=\u0000\u0000\u07e6\u01a2\u0001\u0000\u0000\u0000\u07e7\u07e8"+
		"\u0005<\u0000\u0000\u07e8\u07e9\u0005=\u0000\u0000\u07e9\u01a4\u0001\u0000"+
		"\u0000\u0000\u07ea\u07eb\u0005+\u0000\u0000\u07eb\u01a6\u0001\u0000\u0000"+
		"\u0000\u07ec\u07ed\u0005-\u0000\u0000\u07ed\u01a8\u0001\u0000\u0000\u0000"+
		"\u07ee\u07ef\u0005*\u0000\u0000\u07ef\u01aa\u0001\u0000\u0000\u0000\u07f0"+
		"\u07f1\u0005/\u0000\u0000\u07f1\u01ac\u0001\u0000\u0000\u0000\u07f2\u07f3"+
		"\u0005+\u0000\u0000\u07f3\u07f4\u0005=\u0000\u0000\u07f4\u01ae\u0001\u0000"+
		"\u0000\u0000\u07f5\u07f6\u0005,\u0000\u0000\u07f6\u01b0\u0001\u0000\u0000"+
		"\u0000\u07f7\u07f8\u0005.\u0000\u0000\u07f8\u01b2\u0001\u0000\u0000\u0000"+
		"\u07f9\u07fa\u0005(\u0000\u0000\u07fa\u01b4\u0001\u0000\u0000\u0000\u07fb"+
		"\u07fc\u0005)\u0000\u0000\u07fc\u01b6\u0001\u0000\u0000\u0000\u07fd\u07fe"+
		"\u0005[\u0000\u0000\u07fe\u01b8\u0001\u0000\u0000\u0000\u07ff\u0800\u0005"+
		"]\u0000\u0000\u0800\u01ba\u0001\u0000\u0000\u0000\u0801\u0802\u0005;\u0000"+
		"\u0000\u0802\u01bc\u0001\u0000\u0000\u0000\u0803\u0804\u0005-\u0000\u0000"+
		"\u0804\u0805\u0005-\u0000\u0000\u0805\u0809\u0001\u0000\u0000\u0000\u0806"+
		"\u0808\b!\u0000\u0000\u0807\u0806\u0001\u0000\u0000\u0000\u0808\u080b"+
		"\u0001\u0000\u0000\u0000\u0809\u0807\u0001\u0000\u0000\u0000\u0809\u080a"+
		"\u0001\u0000\u0000\u0000\u080a\u080c\u0001\u0000\u0000\u0000\u080b\u0809"+
		"\u0001\u0000\u0000\u0000\u080c\u080d\u0006\u00de\u0000\u0000\u080d\u01be"+
		"\u0001\u0000\u0000\u0000\u080e\u080f\u0005/\u0000\u0000\u080f\u0810\u0005"+
		"*\u0000\u0000\u0810\u0815\u0001\u0000\u0000\u0000\u0811\u0814\u0003\u01bf"+
		"\u00df\u0000\u0812\u0814\t\u0000\u0000\u0000\u0813\u0811\u0001\u0000\u0000"+
		"\u0000\u0813\u0812\u0001\u0000\u0000\u0000\u0814\u0817\u0001\u0000\u0000"+
		"\u0000\u0815\u0816\u0001\u0000\u0000\u0000\u0815\u0813\u0001\u0000\u0000"+
		"\u0000\u0816\u0818\u0001\u0000\u0000\u0000\u0817\u0815\u0001\u0000\u0000"+
		"\u0000\u0818\u0819\u0005*\u0000\u0000\u0819\u081a\u0005/\u0000\u0000\u081a"+
		"\u081b\u0001\u0000\u0000\u0000\u081b\u081c\u0006\u00df\u0000\u0000\u081c"+
		"\u01c0\u0001\u0000\u0000\u0000\u081d\u081f\u0007\"\u0000\u0000\u081e\u081d"+
		"\u0001\u0000\u0000\u0000\u081f\u0820\u0001\u0000\u0000\u0000\u0820\u081e"+
		"\u0001\u0000\u0000\u0000\u0820\u0821\u0001\u0000\u0000\u0000\u0821\u0822"+
		"\u0001\u0000\u0000\u0000\u0822\u0823\u0006\u00e0\u0000\u0000\u0823\u01c2"+
		"\u0001\u0000\u0000\u0000\u0014\u0000\u077c\u0781\u0787\u078d\u0795\u07a3"+
		"\u07af\u07b3\u07b9\u07bc\u07be\u07c8\u07d0\u07d2\u07de\u0809\u0813\u0815"+
		"\u0820\u0002\u0006\u0000\u0000\u0001\u00c8\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
```

---

### <a id="📄-sqllexer-py"></a>📄 `SqlLexer.py`

**File Info:**
- **Size**: 70.86 KB
- **Extension**: `.py`
- **Language**: `python`
- **Location**: `SqlLexer.py`
- **Relative Path**: `root`
- **Created**: 2025-11-27 05:06:21 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-18 09:51:33 (Asia/Damascus / GMT+03:00)
- **MD5**: `c6f72e648e2cbd3af28838655423efdc`
- **SHA256**: `d8ddc90846986e39d71f5f9cae1186f4662a35187012caf5b9c34db1e137f0ac`
- **Encoding**: ASCII

**File code content:**

```python
# Generated from SqlLexer.g4 by ANTLR 4.13.2
from antlr4 import *
from io import StringIO
import sys
if sys.version_info[1] > 5:
    from typing import TextIO
else:
    from typing.io import TextIO


def serializedATN():
    return [
        4,0,222,2084,6,-1,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,
        5,2,6,7,6,2,7,7,7,2,8,7,8,2,9,7,9,2,10,7,10,2,11,7,11,2,12,7,12,
        2,13,7,13,2,14,7,14,2,15,7,15,2,16,7,16,2,17,7,17,2,18,7,18,2,19,
        7,19,2,20,7,20,2,21,7,21,2,22,7,22,2,23,7,23,2,24,7,24,2,25,7,25,
        2,26,7,26,2,27,7,27,2,28,7,28,2,29,7,29,2,30,7,30,2,31,7,31,2,32,
        7,32,2,33,7,33,2,34,7,34,2,35,7,35,2,36,7,36,2,37,7,37,2,38,7,38,
        2,39,7,39,2,40,7,40,2,41,7,41,2,42,7,42,2,43,7,43,2,44,7,44,2,45,
        7,45,2,46,7,46,2,47,7,47,2,48,7,48,2,49,7,49,2,50,7,50,2,51,7,51,
        2,52,7,52,2,53,7,53,2,54,7,54,2,55,7,55,2,56,7,56,2,57,7,57,2,58,
        7,58,2,59,7,59,2,60,7,60,2,61,7,61,2,62,7,62,2,63,7,63,2,64,7,64,
        2,65,7,65,2,66,7,66,2,67,7,67,2,68,7,68,2,69,7,69,2,70,7,70,2,71,
        7,71,2,72,7,72,2,73,7,73,2,74,7,74,2,75,7,75,2,76,7,76,2,77,7,77,
        2,78,7,78,2,79,7,79,2,80,7,80,2,81,7,81,2,82,7,82,2,83,7,83,2,84,
        7,84,2,85,7,85,2,86,7,86,2,87,7,87,2,88,7,88,2,89,7,89,2,90,7,90,
        2,91,7,91,2,92,7,92,2,93,7,93,2,94,7,94,2,95,7,95,2,96,7,96,2,97,
        7,97,2,98,7,98,2,99,7,99,2,100,7,100,2,101,7,101,2,102,7,102,2,103,
        7,103,2,104,7,104,2,105,7,105,2,106,7,106,2,107,7,107,2,108,7,108,
        2,109,7,109,2,110,7,110,2,111,7,111,2,112,7,112,2,113,7,113,2,114,
        7,114,2,115,7,115,2,116,7,116,2,117,7,117,2,118,7,118,2,119,7,119,
        2,120,7,120,2,121,7,121,2,122,7,122,2,123,7,123,2,124,7,124,2,125,
        7,125,2,126,7,126,2,127,7,127,2,128,7,128,2,129,7,129,2,130,7,130,
        2,131,7,131,2,132,7,132,2,133,7,133,2,134,7,134,2,135,7,135,2,136,
        7,136,2,137,7,137,2,138,7,138,2,139,7,139,2,140,7,140,2,141,7,141,
        2,142,7,142,2,143,7,143,2,144,7,144,2,145,7,145,2,146,7,146,2,147,
        7,147,2,148,7,148,2,149,7,149,2,150,7,150,2,151,7,151,2,152,7,152,
        2,153,7,153,2,154,7,154,2,155,7,155,2,156,7,156,2,157,7,157,2,158,
        7,158,2,159,7,159,2,160,7,160,2,161,7,161,2,162,7,162,2,163,7,163,
        2,164,7,164,2,165,7,165,2,166,7,166,2,167,7,167,2,168,7,168,2,169,
        7,169,2,170,7,170,2,171,7,171,2,172,7,172,2,173,7,173,2,174,7,174,
        2,175,7,175,2,176,7,176,2,177,7,177,2,178,7,178,2,179,7,179,2,180,
        7,180,2,181,7,181,2,182,7,182,2,183,7,183,2,184,7,184,2,185,7,185,
        2,186,7,186,2,187,7,187,2,188,7,188,2,189,7,189,2,190,7,190,2,191,
        7,191,2,192,7,192,2,193,7,193,2,194,7,194,2,195,7,195,2,196,7,196,
        2,197,7,197,2,198,7,198,2,199,7,199,2,200,7,200,2,201,7,201,2,202,
        7,202,2,203,7,203,2,204,7,204,2,205,7,205,2,206,7,206,2,207,7,207,
        2,208,7,208,2,209,7,209,2,210,7,210,2,211,7,211,2,212,7,212,2,213,
        7,213,2,214,7,214,2,215,7,215,2,216,7,216,2,217,7,217,2,218,7,218,
        2,219,7,219,2,220,7,220,2,221,7,221,2,222,7,222,2,223,7,223,2,224,
        7,224,1,0,1,0,1,1,1,1,1,2,1,2,1,3,1,3,1,3,1,3,1,4,1,4,1,4,1,4,1,
        4,1,4,1,4,1,4,1,4,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,6,1,
        6,1,6,1,6,1,7,1,7,1,7,1,7,1,7,1,7,1,8,1,8,1,8,1,8,1,8,1,8,1,8,1,
        9,1,9,1,9,1,9,1,9,1,9,1,10,1,10,1,10,1,10,1,10,1,11,1,11,1,11,1,
        11,1,11,1,11,1,11,1,11,1,11,1,11,1,12,1,12,1,12,1,12,1,13,1,13,1,
        13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,14,1,14,1,14,1,14,1,
        14,1,15,1,15,1,15,1,15,1,16,1,16,1,16,1,16,1,17,1,17,1,17,1,17,1,
        17,1,17,1,17,1,17,1,17,1,18,1,18,1,18,1,19,1,19,1,19,1,19,1,19,1,
        19,1,19,1,19,1,20,1,20,1,20,1,20,1,20,1,20,1,20,1,20,1,20,1,20,1,
        20,1,20,1,21,1,21,1,21,1,21,1,22,1,22,1,22,1,22,1,22,1,22,1,22,1,
        22,1,22,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,
        24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,
        24,1,25,1,25,1,25,1,25,1,25,1,25,1,25,1,25,1,25,1,25,1,25,1,25,1,
        25,1,25,1,26,1,26,1,26,1,26,1,26,1,26,1,26,1,26,1,26,1,26,1,26,1,
        26,1,27,1,27,1,27,1,27,1,27,1,27,1,27,1,28,1,28,1,28,1,28,1,28,1,
        29,1,29,1,29,1,29,1,29,1,29,1,29,1,29,1,30,1,30,1,30,1,30,1,30,1,
        30,1,31,1,31,1,31,1,31,1,31,1,32,1,32,1,32,1,32,1,32,1,32,1,32,1,
        32,1,32,1,33,1,33,1,33,1,33,1,33,1,33,1,33,1,33,1,34,1,34,1,34,1,
        34,1,34,1,34,1,34,1,34,1,34,1,35,1,35,1,35,1,35,1,35,1,35,1,35,1,
        36,1,36,1,36,1,36,1,36,1,36,1,37,1,37,1,37,1,37,1,37,1,38,1,38,1,
        38,1,38,1,38,1,39,1,39,1,39,1,39,1,39,1,39,1,39,1,40,1,40,1,40,1,
        40,1,40,1,40,1,40,1,41,1,41,1,41,1,41,1,41,1,41,1,42,1,42,1,42,1,
        42,1,42,1,42,1,42,1,43,1,43,1,43,1,43,1,43,1,44,1,44,1,44,1,44,1,
        44,1,44,1,45,1,45,1,45,1,45,1,45,1,45,1,46,1,46,1,46,1,47,1,47,1,
        47,1,47,1,47,1,47,1,47,1,48,1,48,1,48,1,48,1,48,1,48,1,48,1,48,1,
        48,1,49,1,49,1,49,1,49,1,49,1,49,1,49,1,49,1,50,1,50,1,50,1,50,1,
        50,1,50,1,50,1,50,1,50,1,51,1,51,1,51,1,51,1,51,1,51,1,51,1,51,1,
        51,1,52,1,52,1,52,1,52,1,52,1,53,1,53,1,53,1,53,1,53,1,53,1,53,1,
        53,1,53,1,54,1,54,1,54,1,54,1,54,1,54,1,54,1,54,1,54,1,54,1,54,1,
        55,1,55,1,55,1,55,1,55,1,55,1,56,1,56,1,56,1,56,1,56,1,56,1,56,1,
        56,1,56,1,56,1,56,1,56,1,56,1,56,1,56,1,56,1,57,1,57,1,57,1,57,1,
        57,1,58,1,58,1,58,1,58,1,58,1,58,1,58,1,58,1,58,1,58,1,58,1,59,1,
        59,1,59,1,59,1,59,1,59,1,59,1,59,1,59,1,59,1,59,1,59,1,60,1,60,1,
        60,1,60,1,60,1,61,1,61,1,61,1,61,1,61,1,61,1,62,1,62,1,62,1,63,1,
        63,1,63,1,63,1,63,1,63,1,63,1,64,1,64,1,64,1,64,1,64,1,64,1,64,1,
        64,1,64,1,64,1,65,1,65,1,65,1,66,1,66,1,66,1,66,1,66,1,66,1,66,1,
        66,1,66,1,66,1,66,1,66,1,66,1,66,1,67,1,67,1,67,1,67,1,67,1,67,1,
        67,1,67,1,67,1,68,1,68,1,68,1,68,1,68,1,68,1,69,1,69,1,69,1,69,1,
        69,1,69,1,69,1,70,1,70,1,70,1,70,1,70,1,70,1,70,1,70,1,71,1,71,1,
        71,1,71,1,71,1,71,1,72,1,72,1,72,1,72,1,72,1,72,1,72,1,72,1,72,1,
        72,1,72,1,72,1,72,1,72,1,72,1,72,1,72,1,72,1,72,1,72,1,72,1,72,1,
        72,1,73,1,73,1,73,1,73,1,73,1,73,1,73,1,74,1,74,1,74,1,74,1,74,1,
        74,1,74,1,75,1,75,1,75,1,75,1,75,1,75,1,75,1,75,1,75,1,75,1,75,1,
        75,1,75,1,75,1,75,1,75,1,75,1,75,1,75,1,75,1,75,1,75,1,75,1,75,1,
        75,1,75,1,75,1,75,1,75,1,75,1,75,1,76,1,76,1,76,1,76,1,76,1,76,1,
        76,1,77,1,77,1,77,1,77,1,77,1,77,1,77,1,77,1,77,1,77,1,78,1,78,1,
        78,1,78,1,78,1,78,1,78,1,78,1,78,1,78,1,78,1,78,1,78,1,78,1,78,1,
        78,1,78,1,78,1,78,1,78,1,78,1,78,1,78,1,78,1,79,1,79,1,79,1,79,1,
        79,1,79,1,79,1,79,1,80,1,80,1,80,1,80,1,80,1,81,1,81,1,81,1,81,1,
        81,1,81,1,81,1,81,1,81,1,81,1,81,1,81,1,81,1,82,1,82,1,82,1,82,1,
        82,1,82,1,82,1,82,1,82,1,82,1,82,1,83,1,83,1,83,1,84,1,84,1,84,1,
        84,1,85,1,85,1,85,1,85,1,85,1,85,1,85,1,85,1,85,1,86,1,86,1,86,1,
        86,1,86,1,87,1,87,1,87,1,87,1,87,1,87,1,87,1,87,1,88,1,88,1,88,1,
        88,1,88,1,88,1,88,1,88,1,88,1,88,1,88,1,88,1,88,1,88,1,89,1,89,1,
        89,1,89,1,90,1,90,1,90,1,90,1,90,1,90,1,90,1,90,1,90,1,91,1,91,1,
        91,1,91,1,91,1,91,1,91,1,91,1,91,1,92,1,92,1,92,1,92,1,92,1,93,1,
        93,1,93,1,93,1,93,1,94,1,94,1,94,1,94,1,94,1,94,1,94,1,94,1,95,1,
        95,1,95,1,95,1,95,1,96,1,96,1,96,1,96,1,96,1,96,1,96,1,96,1,96,1,
        96,1,96,1,97,1,97,1,97,1,97,1,97,1,97,1,97,1,98,1,98,1,98,1,98,1,
        98,1,99,1,99,1,99,1,99,1,99,1,99,1,99,1,99,1,99,1,99,1,99,1,99,1,
        100,1,100,1,100,1,100,1,100,1,100,1,101,1,101,1,101,1,101,1,101,
        1,101,1,101,1,102,1,102,1,102,1,102,1,102,1,102,1,103,1,103,1,103,
        1,103,1,103,1,103,1,103,1,103,1,104,1,104,1,104,1,104,1,104,1,105,
        1,105,1,105,1,105,1,105,1,105,1,105,1,105,1,105,1,105,1,105,1,105,
        1,106,1,106,1,106,1,106,1,106,1,106,1,106,1,106,1,106,1,106,1,106,
        1,106,1,106,1,107,1,107,1,107,1,107,1,107,1,107,1,108,1,108,1,108,
        1,108,1,108,1,108,1,108,1,108,1,108,1,109,1,109,1,109,1,109,1,109,
        1,109,1,109,1,109,1,109,1,109,1,109,1,109,1,109,1,110,1,110,1,110,
        1,110,1,110,1,110,1,110,1,110,1,110,1,111,1,111,1,111,1,111,1,111,
        1,112,1,112,1,112,1,112,1,112,1,112,1,112,1,112,1,112,1,112,1,112,
        1,112,1,112,1,112,1,112,1,112,1,112,1,112,1,113,1,113,1,113,1,113,
        1,113,1,113,1,113,1,113,1,114,1,114,1,114,1,115,1,115,1,115,1,115,
        1,115,1,115,1,115,1,115,1,115,1,115,1,115,1,115,1,115,1,116,1,116,
        1,116,1,116,1,116,1,116,1,116,1,116,1,116,1,116,1,116,1,116,1,116,
        1,117,1,117,1,117,1,117,1,118,1,118,1,118,1,118,1,118,1,118,1,118,
        1,119,1,119,1,119,1,119,1,120,1,120,1,120,1,120,1,120,1,121,1,121,
        1,121,1,121,1,121,1,121,1,121,1,121,1,121,1,122,1,122,1,122,1,122,
        1,122,1,123,1,123,1,123,1,123,1,123,1,123,1,123,1,123,1,123,1,123,
        1,123,1,123,1,124,1,124,1,124,1,124,1,124,1,125,1,125,1,125,1,125,
        1,125,1,125,1,125,1,126,1,126,1,126,1,126,1,126,1,126,1,126,1,126,
        1,127,1,127,1,127,1,127,1,127,1,127,1,127,1,127,1,127,1,127,1,127,
        1,128,1,128,1,128,1,129,1,129,1,129,1,129,1,129,1,129,1,129,1,129,
        1,129,1,130,1,130,1,130,1,130,1,130,1,130,1,130,1,130,1,131,1,131,
        1,131,1,131,1,132,1,132,1,132,1,132,1,132,1,132,1,132,1,132,1,132,
        1,132,1,132,1,132,1,133,1,133,1,133,1,133,1,133,1,133,1,133,1,133,
        1,134,1,134,1,134,1,134,1,134,1,134,1,134,1,134,1,135,1,135,1,135,
        1,135,1,135,1,135,1,135,1,135,1,136,1,136,1,136,1,136,1,136,1,136,
        1,136,1,137,1,137,1,137,1,138,1,138,1,138,1,138,1,138,1,138,1,139,
        1,139,1,139,1,139,1,139,1,140,1,140,1,140,1,140,1,140,1,141,1,141,
        1,141,1,141,1,141,1,141,1,141,1,142,1,142,1,142,1,142,1,142,1,143,
        1,143,1,143,1,143,1,143,1,143,1,143,1,143,1,143,1,143,1,143,1,143,
        1,143,1,143,1,143,1,144,1,144,1,144,1,144,1,144,1,144,1,144,1,145,
        1,145,1,145,1,145,1,145,1,146,1,146,1,146,1,146,1,146,1,146,1,146,
        1,146,1,146,1,146,1,147,1,147,1,147,1,147,1,147,1,147,1,147,1,147,
        1,147,1,147,1,147,1,148,1,148,1,148,1,148,1,148,1,148,1,148,1,148,
        1,148,1,149,1,149,1,149,1,149,1,149,1,149,1,149,1,149,1,149,1,149,
        1,149,1,150,1,150,1,150,1,150,1,151,1,151,1,151,1,151,1,151,1,151,
        1,151,1,151,1,151,1,151,1,151,1,151,1,152,1,152,1,152,1,152,1,152,
        1,152,1,152,1,152,1,153,1,153,1,153,1,153,1,153,1,154,1,154,1,154,
        1,154,1,154,1,154,1,154,1,155,1,155,1,155,1,155,1,155,1,155,1,155,
        1,156,1,156,1,156,1,156,1,156,1,156,1,156,1,157,1,157,1,157,1,157,
        1,157,1,158,1,158,1,158,1,159,1,159,1,159,1,159,1,159,1,159,1,159,
        1,159,1,160,1,160,1,160,1,160,1,160,1,161,1,161,1,161,1,161,1,161,
        1,161,1,162,1,162,1,162,1,162,1,162,1,163,1,163,1,163,1,163,1,163,
        1,164,1,164,1,164,1,164,1,164,1,164,1,165,1,165,1,165,1,165,1,165,
        1,165,1,165,1,165,1,166,1,166,1,166,1,166,1,167,1,167,1,167,1,167,
        1,167,1,168,1,168,1,168,1,168,1,168,1,169,1,169,1,169,1,169,1,169,
        1,169,1,169,1,170,1,170,1,170,1,170,1,170,1,170,1,170,1,170,1,171,
        1,171,1,171,1,171,1,171,1,171,1,172,1,172,1,172,1,172,1,172,1,172,
        1,172,1,173,1,173,1,173,1,173,1,173,1,173,1,174,1,174,1,174,1,174,
        1,174,1,174,1,175,1,175,1,175,1,175,1,175,1,175,1,175,1,176,1,176,
        1,176,1,176,1,176,1,177,1,177,1,177,1,177,1,177,1,178,1,178,1,178,
        1,178,1,178,1,179,1,179,1,179,1,179,1,179,1,179,1,179,1,179,1,179,
        1,179,1,180,1,180,1,180,1,180,1,180,1,180,1,180,1,180,1,180,1,180,
        1,181,1,181,1,181,1,181,1,181,1,181,1,181,1,181,1,182,1,182,1,182,
        1,182,1,182,1,182,1,182,1,182,1,183,1,183,1,183,1,183,1,183,1,183,
        1,183,1,183,1,184,1,184,1,184,1,184,1,184,1,184,1,184,1,184,1,184,
        1,185,1,185,1,185,1,185,1,185,1,185,1,185,1,185,1,186,1,186,1,186,
        1,186,1,187,1,187,1,187,1,187,1,188,1,188,1,188,1,188,1,189,1,189,
        1,189,1,189,1,190,1,190,1,190,1,190,1,190,1,190,1,191,1,191,1,191,
        1,191,1,192,1,192,1,192,1,192,1,192,1,192,1,193,1,193,1,193,1,193,
        1,193,1,193,1,193,1,194,4,194,1915,8,194,11,194,12,194,1916,1,195,
        4,195,1920,8,195,11,195,12,195,1921,1,195,1,195,4,195,1926,8,195,
        11,195,12,195,1927,1,196,1,196,4,196,1932,8,196,11,196,12,196,1933,
        1,197,1,197,1,197,1,197,4,197,1940,8,197,11,197,12,197,1941,1,198,
        1,198,1,198,1,198,1,198,1,199,1,199,1,199,1,199,1,199,1,199,1,200,
        3,200,1956,8,200,1,200,1,200,1,200,1,200,1,200,1,200,1,200,1,200,
        5,200,1966,8,200,10,200,12,200,1969,9,200,1,200,3,200,1972,8,200,
        1,200,1,200,5,200,1976,8,200,10,200,12,200,1979,9,200,5,200,1981,
        8,200,10,200,12,200,1984,9,200,1,200,1,200,1,200,1,201,1,201,5,201,
        1991,8,201,10,201,12,201,1994,9,201,1,201,1,201,1,202,1,202,1,202,
        5,202,2001,8,202,10,202,12,202,2004,9,202,1,203,1,203,1,203,1,204,
        1,204,1,205,1,205,1,205,1,205,3,205,2015,8,205,1,206,1,206,1,207,
        1,207,1,208,1,208,1,208,1,209,1,209,1,209,1,210,1,210,1,211,1,211,
        1,212,1,212,1,213,1,213,1,214,1,214,1,214,1,215,1,215,1,216,1,216,
        1,217,1,217,1,218,1,218,1,219,1,219,1,220,1,220,1,221,1,221,1,222,
        1,222,1,222,1,222,5,222,2056,8,222,10,222,12,222,2059,9,222,1,222,
        1,222,1,223,1,223,1,223,1,223,1,223,5,223,2068,8,223,10,223,12,223,
        2071,9,223,1,223,1,223,1,223,1,223,1,223,1,224,4,224,2079,8,224,
        11,224,12,224,2080,1,224,1,224,1,2069,0,225,1,0,3,0,5,0,7,1,9,2,
        11,3,13,4,15,5,17,6,19,7,21,8,23,9,25,10,27,11,29,12,31,13,33,14,
        35,15,37,16,39,17,41,18,43,19,45,20,47,21,49,22,51,23,53,24,55,25,
        57,26,59,27,61,28,63,29,65,30,67,31,69,32,71,33,73,34,75,35,77,36,
        79,37,81,38,83,39,85,40,87,41,89,42,91,43,93,44,95,45,97,46,99,47,
        101,48,103,49,105,50,107,51,109,52,111,53,113,54,115,55,117,56,119,
        57,121,58,123,59,125,60,127,61,129,62,131,63,133,64,135,65,137,66,
        139,67,141,68,143,69,145,70,147,71,149,72,151,73,153,74,155,75,157,
        76,159,77,161,78,163,79,165,80,167,81,169,82,171,83,173,84,175,85,
        177,86,179,87,181,88,183,89,185,90,187,91,189,92,191,93,193,94,195,
        95,197,96,199,97,201,98,203,99,205,100,207,101,209,102,211,103,213,
        104,215,105,217,106,219,107,221,108,223,109,225,110,227,111,229,
        112,231,113,233,114,235,115,237,116,239,117,241,118,243,119,245,
        120,247,121,249,122,251,123,253,124,255,125,257,126,259,127,261,
        128,263,129,265,130,267,131,269,132,271,133,273,134,275,135,277,
        136,279,137,281,138,283,139,285,140,287,141,289,142,291,143,293,
        144,295,145,297,146,299,147,301,148,303,149,305,150,307,151,309,
        152,311,153,313,154,315,155,317,156,319,157,321,158,323,159,325,
        160,327,161,329,162,331,163,333,164,335,165,337,166,339,167,341,
        168,343,169,345,170,347,171,349,172,351,173,353,174,355,175,357,
        176,359,177,361,178,363,179,365,180,367,181,369,182,371,183,373,
        184,375,185,377,186,379,187,381,188,383,189,385,190,387,191,389,
        192,391,193,393,194,395,195,397,196,399,197,401,198,403,199,405,
        200,407,201,409,202,411,203,413,204,415,205,417,206,419,207,421,
        208,423,209,425,210,427,211,429,212,431,213,433,214,435,215,437,
        216,439,217,441,218,443,219,445,220,447,221,449,222,1,0,35,1,0,48,
        57,3,0,65,90,95,95,97,122,3,0,48,57,65,70,97,102,2,0,65,65,97,97,
        2,0,68,68,100,100,2,0,69,69,101,101,2,0,88,88,120,120,2,0,84,84,
        116,116,2,0,82,82,114,114,2,0,78,78,110,110,2,0,76,76,108,108,2,
        0,80,80,112,112,2,0,79,79,111,111,2,0,67,67,99,99,2,0,85,85,117,
        117,2,0,70,70,102,102,2,0,72,72,104,104,2,0,66,66,98,98,2,0,73,73,
        105,105,2,0,83,83,115,115,2,0,89,89,121,121,2,0,71,71,103,103,2,
        0,90,90,122,122,2,0,75,75,107,107,2,0,77,77,109,109,2,0,87,87,119,
        119,2,0,86,86,118,118,2,0,74,74,106,106,2,0,81,81,113,113,1,0,48,
        49,2,0,39,39,92,92,2,0,9,9,32,32,3,0,10,10,13,13,93,93,2,0,10,10,
        13,13,3,0,9,10,13,13,32,32,2101,0,7,1,0,0,0,0,9,1,0,0,0,0,11,1,0,
        0,0,0,13,1,0,0,0,0,15,1,0,0,0,0,17,1,0,0,0,0,19,1,0,0,0,0,21,1,0,
        0,0,0,23,1,0,0,0,0,25,1,0,0,0,0,27,1,0,0,0,0,29,1,0,0,0,0,31,1,0,
        0,0,0,33,1,0,0,0,0,35,1,0,0,0,0,37,1,0,0,0,0,39,1,0,0,0,0,41,1,0,
        0,0,0,43,1,0,0,0,0,45,1,0,0,0,0,47,1,0,0,0,0,49,1,0,0,0,0,51,1,0,
        0,0,0,53,1,0,0,0,0,55,1,0,0,0,0,57,1,0,0,0,0,59,1,0,0,0,0,61,1,0,
        0,0,0,63,1,0,0,0,0,65,1,0,0,0,0,67,1,0,0,0,0,69,1,0,0,0,0,71,1,0,
        0,0,0,73,1,0,0,0,0,75,1,0,0,0,0,77,1,0,0,0,0,79,1,0,0,0,0,81,1,0,
        0,0,0,83,1,0,0,0,0,85,1,0,0,0,0,87,1,0,0,0,0,89,1,0,0,0,0,91,1,0,
        0,0,0,93,1,0,0,0,0,95,1,0,0,0,0,97,1,0,0,0,0,99,1,0,0,0,0,101,1,
        0,0,0,0,103,1,0,0,0,0,105,1,0,0,0,0,107,1,0,0,0,0,109,1,0,0,0,0,
        111,1,0,0,0,0,113,1,0,0,0,0,115,1,0,0,0,0,117,1,0,0,0,0,119,1,0,
        0,0,0,121,1,0,0,0,0,123,1,0,0,0,0,125,1,0,0,0,0,127,1,0,0,0,0,129,
        1,0,0,0,0,131,1,0,0,0,0,133,1,0,0,0,0,135,1,0,0,0,0,137,1,0,0,0,
        0,139,1,0,0,0,0,141,1,0,0,0,0,143,1,0,0,0,0,145,1,0,0,0,0,147,1,
        0,0,0,0,149,1,0,0,0,0,151,1,0,0,0,0,153,1,0,0,0,0,155,1,0,0,0,0,
        157,1,0,0,0,0,159,1,0,0,0,0,161,1,0,0,0,0,163,1,0,0,0,0,165,1,0,
        0,0,0,167,1,0,0,0,0,169,1,0,0,0,0,171,1,0,0,0,0,173,1,0,0,0,0,175,
        1,0,0,0,0,177,1,0,0,0,0,179,1,0,0,0,0,181,1,0,0,0,0,183,1,0,0,0,
        0,185,1,0,0,0,0,187,1,0,0,0,0,189,1,0,0,0,0,191,1,0,0,0,0,193,1,
        0,0,0,0,195,1,0,0,0,0,197,1,0,0,0,0,199,1,0,0,0,0,201,1,0,0,0,0,
        203,1,0,0,0,0,205,1,0,0,0,0,207,1,0,0,0,0,209,1,0,0,0,0,211,1,0,
        0,0,0,213,1,0,0,0,0,215,1,0,0,0,0,217,1,0,0,0,0,219,1,0,0,0,0,221,
        1,0,0,0,0,223,1,0,0,0,0,225,1,0,0,0,0,227,1,0,0,0,0,229,1,0,0,0,
        0,231,1,0,0,0,0,233,1,0,0,0,0,235,1,0,0,0,0,237,1,0,0,0,0,239,1,
        0,0,0,0,241,1,0,0,0,0,243,1,0,0,0,0,245,1,0,0,0,0,247,1,0,0,0,0,
        249,1,0,0,0,0,251,1,0,0,0,0,253,1,0,0,0,0,255,1,0,0,0,0,257,1,0,
        0,0,0,259,1,0,0,0,0,261,1,0,0,0,0,263,1,0,0,0,0,265,1,0,0,0,0,267,
        1,0,0,0,0,269,1,0,0,0,0,271,1,0,0,0,0,273,1,0,0,0,0,275,1,0,0,0,
        0,277,1,0,0,0,0,279,1,0,0,0,0,281,1,0,0,0,0,283,1,0,0,0,0,285,1,
        0,0,0,0,287,1,0,0,0,0,289,1,0,0,0,0,291,1,0,0,0,0,293,1,0,0,0,0,
        295,1,0,0,0,0,297,1,0,0,0,0,299,1,0,0,0,0,301,1,0,0,0,0,303,1,0,
        0,0,0,305,1,0,0,0,0,307,1,0,0,0,0,309,1,0,0,0,0,311,1,0,0,0,0,313,
        1,0,0,0,0,315,1,0,0,0,0,317,1,0,0,0,0,319,1,0,0,0,0,321,1,0,0,0,
        0,323,1,0,0,0,0,325,1,0,0,0,0,327,1,0,0,0,0,329,1,0,0,0,0,331,1,
        0,0,0,0,333,1,0,0,0,0,335,1,0,0,0,0,337,1,0,0,0,0,339,1,0,0,0,0,
        341,1,0,0,0,0,343,1,0,0,0,0,345,1,0,0,0,0,347,1,0,0,0,0,349,1,0,
        0,0,0,351,1,0,0,0,0,353,1,0,0,0,0,355,1,0,0,0,0,357,1,0,0,0,0,359,
        1,0,0,0,0,361,1,0,0,0,0,363,1,0,0,0,0,365,1,0,0,0,0,367,1,0,0,0,
        0,369,1,0,0,0,0,371,1,0,0,0,0,373,1,0,0,0,0,375,1,0,0,0,0,377,1,
        0,0,0,0,379,1,0,0,0,0,381,1,0,0,0,0,383,1,0,0,0,0,385,1,0,0,0,0,
        387,1,0,0,0,0,389,1,0,0,0,0,391,1,0,0,0,0,393,1,0,0,0,0,395,1,0,
        0,0,0,397,1,0,0,0,0,399,1,0,0,0,0,401,1,0,0,0,0,403,1,0,0,0,0,405,
        1,0,0,0,0,407,1,0,0,0,0,409,1,0,0,0,0,411,1,0,0,0,0,413,1,0,0,0,
        0,415,1,0,0,0,0,417,1,0,0,0,0,419,1,0,0,0,0,421,1,0,0,0,0,423,1,
        0,0,0,0,425,1,0,0,0,0,427,1,0,0,0,0,429,1,0,0,0,0,431,1,0,0,0,0,
        433,1,0,0,0,0,435,1,0,0,0,0,437,1,0,0,0,0,439,1,0,0,0,0,441,1,0,
        0,0,0,443,1,0,0,0,0,445,1,0,0,0,0,447,1,0,0,0,0,449,1,0,0,0,1,451,
        1,0,0,0,3,453,1,0,0,0,5,455,1,0,0,0,7,457,1,0,0,0,9,461,1,0,0,0,
        11,470,1,0,0,0,13,480,1,0,0,0,15,484,1,0,0,0,17,490,1,0,0,0,19,497,
        1,0,0,0,21,503,1,0,0,0,23,508,1,0,0,0,25,518,1,0,0,0,27,522,1,0,
        0,0,29,533,1,0,0,0,31,538,1,0,0,0,33,542,1,0,0,0,35,546,1,0,0,0,
        37,555,1,0,0,0,39,558,1,0,0,0,41,566,1,0,0,0,43,578,1,0,0,0,45,582,
        1,0,0,0,47,591,1,0,0,0,49,602,1,0,0,0,51,616,1,0,0,0,53,630,1,0,
        0,0,55,642,1,0,0,0,57,649,1,0,0,0,59,654,1,0,0,0,61,662,1,0,0,0,
        63,668,1,0,0,0,65,673,1,0,0,0,67,682,1,0,0,0,69,690,1,0,0,0,71,699,
        1,0,0,0,73,706,1,0,0,0,75,712,1,0,0,0,77,717,1,0,0,0,79,722,1,0,
        0,0,81,729,1,0,0,0,83,736,1,0,0,0,85,742,1,0,0,0,87,749,1,0,0,0,
        89,754,1,0,0,0,91,760,1,0,0,0,93,766,1,0,0,0,95,769,1,0,0,0,97,776,
        1,0,0,0,99,785,1,0,0,0,101,793,1,0,0,0,103,802,1,0,0,0,105,811,1,
        0,0,0,107,816,1,0,0,0,109,825,1,0,0,0,111,836,1,0,0,0,113,842,1,
        0,0,0,115,858,1,0,0,0,117,863,1,0,0,0,119,874,1,0,0,0,121,886,1,
        0,0,0,123,891,1,0,0,0,125,897,1,0,0,0,127,900,1,0,0,0,129,907,1,
        0,0,0,131,917,1,0,0,0,133,920,1,0,0,0,135,934,1,0,0,0,137,943,1,
        0,0,0,139,949,1,0,0,0,141,956,1,0,0,0,143,964,1,0,0,0,145,970,1,
        0,0,0,147,993,1,0,0,0,149,1000,1,0,0,0,151,1007,1,0,0,0,153,1038,
        1,0,0,0,155,1045,1,0,0,0,157,1055,1,0,0,0,159,1079,1,0,0,0,161,1087,
        1,0,0,0,163,1092,1,0,0,0,165,1105,1,0,0,0,167,1116,1,0,0,0,169,1119,
        1,0,0,0,171,1123,1,0,0,0,173,1132,1,0,0,0,175,1137,1,0,0,0,177,1145,
        1,0,0,0,179,1159,1,0,0,0,181,1163,1,0,0,0,183,1172,1,0,0,0,185,1181,
        1,0,0,0,187,1186,1,0,0,0,189,1191,1,0,0,0,191,1199,1,0,0,0,193,1204,
        1,0,0,0,195,1215,1,0,0,0,197,1222,1,0,0,0,199,1227,1,0,0,0,201,1239,
        1,0,0,0,203,1245,1,0,0,0,205,1252,1,0,0,0,207,1258,1,0,0,0,209,1266,
        1,0,0,0,211,1271,1,0,0,0,213,1283,1,0,0,0,215,1296,1,0,0,0,217,1302,
        1,0,0,0,219,1311,1,0,0,0,221,1324,1,0,0,0,223,1333,1,0,0,0,225,1338,
        1,0,0,0,227,1356,1,0,0,0,229,1364,1,0,0,0,231,1367,1,0,0,0,233,1380,
        1,0,0,0,235,1393,1,0,0,0,237,1397,1,0,0,0,239,1404,1,0,0,0,241,1408,
        1,0,0,0,243,1413,1,0,0,0,245,1422,1,0,0,0,247,1427,1,0,0,0,249,1439,
        1,0,0,0,251,1444,1,0,0,0,253,1451,1,0,0,0,255,1459,1,0,0,0,257,1470,
        1,0,0,0,259,1473,1,0,0,0,261,1482,1,0,0,0,263,1490,1,0,0,0,265,1494,
        1,0,0,0,267,1506,1,0,0,0,269,1514,1,0,0,0,271,1522,1,0,0,0,273,1530,
        1,0,0,0,275,1537,1,0,0,0,277,1540,1,0,0,0,279,1546,1,0,0,0,281,1551,
        1,0,0,0,283,1556,1,0,0,0,285,1563,1,0,0,0,287,1568,1,0,0,0,289,1583,
        1,0,0,0,291,1590,1,0,0,0,293,1595,1,0,0,0,295,1605,1,0,0,0,297,1616,
        1,0,0,0,299,1625,1,0,0,0,301,1636,1,0,0,0,303,1640,1,0,0,0,305,1652,
        1,0,0,0,307,1660,1,0,0,0,309,1665,1,0,0,0,311,1672,1,0,0,0,313,1679,
        1,0,0,0,315,1686,1,0,0,0,317,1691,1,0,0,0,319,1694,1,0,0,0,321,1702,
        1,0,0,0,323,1707,1,0,0,0,325,1713,1,0,0,0,327,1718,1,0,0,0,329,1723,
        1,0,0,0,331,1729,1,0,0,0,333,1737,1,0,0,0,335,1741,1,0,0,0,337,1746,
        1,0,0,0,339,1751,1,0,0,0,341,1758,1,0,0,0,343,1766,1,0,0,0,345,1772,
        1,0,0,0,347,1779,1,0,0,0,349,1785,1,0,0,0,351,1791,1,0,0,0,353,1798,
        1,0,0,0,355,1803,1,0,0,0,357,1808,1,0,0,0,359,1813,1,0,0,0,361,1823,
        1,0,0,0,363,1833,1,0,0,0,365,1841,1,0,0,0,367,1849,1,0,0,0,369,1857,
        1,0,0,0,371,1866,1,0,0,0,373,1874,1,0,0,0,375,1878,1,0,0,0,377,1882,
        1,0,0,0,379,1886,1,0,0,0,381,1890,1,0,0,0,383,1896,1,0,0,0,385,1900,
        1,0,0,0,387,1906,1,0,0,0,389,1914,1,0,0,0,391,1919,1,0,0,0,393,1931,
        1,0,0,0,395,1935,1,0,0,0,397,1943,1,0,0,0,399,1948,1,0,0,0,401,1955,
        1,0,0,0,403,1988,1,0,0,0,405,1997,1,0,0,0,407,2005,1,0,0,0,409,2008,
        1,0,0,0,411,2014,1,0,0,0,413,2016,1,0,0,0,415,2018,1,0,0,0,417,2020,
        1,0,0,0,419,2023,1,0,0,0,421,2026,1,0,0,0,423,2028,1,0,0,0,425,2030,
        1,0,0,0,427,2032,1,0,0,0,429,2034,1,0,0,0,431,2037,1,0,0,0,433,2039,
        1,0,0,0,435,2041,1,0,0,0,437,2043,1,0,0,0,439,2045,1,0,0,0,441,2047,
        1,0,0,0,443,2049,1,0,0,0,445,2051,1,0,0,0,447,2062,1,0,0,0,449,2078,
        1,0,0,0,451,452,7,0,0,0,452,2,1,0,0,0,453,454,7,1,0,0,454,4,1,0,
        0,0,455,456,7,2,0,0,456,6,1,0,0,0,457,458,7,3,0,0,458,459,7,4,0,
        0,459,460,7,4,0,0,460,8,1,0,0,0,461,462,7,5,0,0,462,463,7,6,0,0,
        463,464,7,7,0,0,464,465,7,5,0,0,465,466,7,8,0,0,466,467,7,9,0,0,
        467,468,7,3,0,0,468,469,7,10,0,0,469,10,1,0,0,0,470,471,7,11,0,0,
        471,472,7,8,0,0,472,473,7,12,0,0,473,474,7,13,0,0,474,475,7,5,0,
        0,475,476,7,4,0,0,476,477,7,14,0,0,477,478,7,8,0,0,478,479,7,5,0,
        0,479,12,1,0,0,0,480,481,7,3,0,0,481,482,7,10,0,0,482,483,7,10,0,
        0,483,14,1,0,0,0,484,485,7,15,0,0,485,486,7,5,0,0,486,487,7,7,0,
        0,487,488,7,13,0,0,488,489,7,16,0,0,489,16,1,0,0,0,490,491,7,11,
        0,0,491,492,7,14,0,0,492,493,7,17,0,0,493,494,7,10,0,0,494,495,7,
        18,0,0,495,496,7,13,0,0,496,18,1,0,0,0,497,498,7,3,0,0,498,499,7,
        10,0,0,499,500,7,7,0,0,500,501,7,5,0,0,501,502,7,8,0,0,502,20,1,
        0,0,0,503,504,7,15,0,0,504,505,7,18,0,0,505,506,7,10,0,0,506,507,
        7,5,0,0,507,22,1,0,0,0,508,509,7,8,0,0,509,510,7,3,0,0,510,511,7,
        18,0,0,511,512,7,19,0,0,512,513,7,5,0,0,513,514,7,8,0,0,514,515,
        7,8,0,0,515,516,7,12,0,0,516,517,7,8,0,0,517,24,1,0,0,0,518,519,
        7,3,0,0,519,520,7,9,0,0,520,521,7,4,0,0,521,26,1,0,0,0,522,523,7,
        15,0,0,523,524,7,18,0,0,524,525,7,10,0,0,525,526,7,10,0,0,526,527,
        7,15,0,0,527,528,7,3,0,0,528,529,7,13,0,0,529,530,7,7,0,0,530,531,
        7,12,0,0,531,532,7,8,0,0,532,28,1,0,0,0,533,534,7,8,0,0,534,535,
        7,5,0,0,535,536,7,3,0,0,536,537,7,4,0,0,537,30,1,0,0,0,538,539,7,
        3,0,0,539,540,7,9,0,0,540,541,7,20,0,0,541,32,1,0,0,0,542,543,7,
        15,0,0,543,544,7,12,0,0,544,545,7,8,0,0,545,34,1,0,0,0,546,547,7,
        8,0,0,547,548,7,5,0,0,548,549,7,3,0,0,549,550,7,4,0,0,550,551,7,
        7,0,0,551,552,7,5,0,0,552,553,7,6,0,0,553,554,7,7,0,0,554,36,1,0,
        0,0,555,556,7,3,0,0,556,557,7,19,0,0,557,38,1,0,0,0,558,559,7,15,
        0,0,559,560,7,12,0,0,560,561,7,8,0,0,561,562,7,5,0,0,562,563,7,18,
        0,0,563,564,7,21,0,0,564,565,7,9,0,0,565,40,1,0,0,0,566,567,7,8,
        0,0,567,568,7,5,0,0,568,569,7,13,0,0,569,570,7,12,0,0,570,571,7,
        9,0,0,571,572,7,15,0,0,572,573,7,18,0,0,573,574,7,21,0,0,574,575,
        7,14,0,0,575,576,7,8,0,0,576,577,7,5,0,0,577,42,1,0,0,0,578,579,
        7,3,0,0,579,580,7,19,0,0,580,581,7,13,0,0,581,44,1,0,0,0,582,583,
        7,15,0,0,583,584,7,8,0,0,584,585,7,5,0,0,585,586,7,5,0,0,586,587,
        7,7,0,0,587,588,7,5,0,0,588,589,7,6,0,0,589,590,7,7,0,0,590,46,1,
        0,0,0,591,592,7,8,0,0,592,593,7,5,0,0,593,594,7,15,0,0,594,595,7,
        5,0,0,595,596,7,8,0,0,596,597,7,5,0,0,597,598,7,9,0,0,598,599,7,
        13,0,0,599,600,7,5,0,0,600,601,7,19,0,0,601,48,1,0,0,0,602,603,7,
        3,0,0,603,604,7,14,0,0,604,605,7,7,0,0,605,606,7,16,0,0,606,607,
        7,12,0,0,607,608,7,8,0,0,608,609,7,18,0,0,609,610,7,22,0,0,610,611,
        7,3,0,0,611,612,7,7,0,0,612,613,7,18,0,0,613,614,7,12,0,0,614,615,
        7,9,0,0,615,50,1,0,0,0,616,617,7,15,0,0,617,618,7,8,0,0,618,619,
        7,5,0,0,619,620,7,5,0,0,620,621,7,7,0,0,621,622,7,5,0,0,622,623,
        7,6,0,0,623,624,7,7,0,0,624,625,7,7,0,0,625,626,7,3,0,0,626,627,
        7,17,0,0,627,628,7,10,0,0,628,629,7,5,0,0,629,52,1,0,0,0,630,631,
        7,8,0,0,631,632,7,5,0,0,632,633,7,11,0,0,633,634,7,10,0,0,634,635,
        7,18,0,0,635,636,7,13,0,0,636,637,7,3,0,0,637,638,7,7,0,0,638,639,
        7,18,0,0,639,640,7,12,0,0,640,641,7,9,0,0,641,54,1,0,0,0,642,643,
        7,17,0,0,643,644,7,3,0,0,644,645,7,13,0,0,645,646,7,23,0,0,646,647,
        7,14,0,0,647,648,7,11,0,0,648,56,1,0,0,0,649,650,7,15,0,0,650,651,
        7,8,0,0,651,652,7,12,0,0,652,653,7,24,0,0,653,58,1,0,0,0,654,655,
        7,8,0,0,655,656,7,5,0,0,656,657,7,19,0,0,657,658,7,7,0,0,658,659,
        7,12,0,0,659,660,7,8,0,0,660,661,7,5,0,0,661,60,1,0,0,0,662,663,
        7,17,0,0,663,664,7,5,0,0,664,665,7,21,0,0,665,666,7,18,0,0,666,667,
        7,9,0,0,667,62,1,0,0,0,668,669,7,15,0,0,669,670,7,14,0,0,670,671,
        7,10,0,0,671,672,7,10,0,0,672,64,1,0,0,0,673,674,7,8,0,0,674,675,
        7,5,0,0,675,676,7,19,0,0,676,677,7,7,0,0,677,678,7,8,0,0,678,679,
        7,18,0,0,679,680,7,13,0,0,680,681,7,7,0,0,681,66,1,0,0,0,682,683,
        7,17,0,0,683,684,7,5,0,0,684,685,7,7,0,0,685,686,7,25,0,0,686,687,
        7,5,0,0,687,688,7,5,0,0,688,689,7,9,0,0,689,68,1,0,0,0,690,691,7,
        15,0,0,691,692,7,14,0,0,692,693,7,9,0,0,693,694,7,13,0,0,694,695,
        7,7,0,0,695,696,7,18,0,0,696,697,7,12,0,0,697,698,7,9,0,0,698,70,
        1,0,0,0,699,700,7,8,0,0,700,701,7,5,0,0,701,702,7,7,0,0,702,703,
        7,14,0,0,703,704,7,8,0,0,704,705,7,9,0,0,705,72,1,0,0,0,706,707,
        7,17,0,0,707,708,7,8,0,0,708,709,7,5,0,0,709,710,7,3,0,0,710,711,
        7,23,0,0,711,74,1,0,0,0,712,713,7,21,0,0,713,714,7,12,0,0,714,715,
        7,7,0,0,715,716,7,12,0,0,716,76,1,0,0,0,717,718,7,21,0,0,718,719,
        7,12,0,0,719,720,1,0,0,0,720,721,6,38,0,0,721,78,1,0,0,0,722,723,
        7,8,0,0,723,724,7,5,0,0,724,725,7,26,0,0,725,726,7,5,0,0,726,727,
        7,8,0,0,727,728,7,7,0,0,728,80,1,0,0,0,729,730,7,17,0,0,730,731,
        7,8,0,0,731,732,7,12,0,0,732,733,7,25,0,0,733,734,7,19,0,0,734,735,
        7,5,0,0,735,82,1,0,0,0,736,737,7,21,0,0,737,738,7,8,0,0,738,739,
        7,3,0,0,739,740,7,9,0,0,740,741,7,7,0,0,741,84,1,0,0,0,742,743,7,
        8,0,0,743,744,7,5,0,0,744,745,7,26,0,0,745,746,7,12,0,0,746,747,
        7,23,0,0,747,748,7,5,0,0,748,86,1,0,0,0,749,750,7,17,0,0,750,751,
        7,14,0,0,751,752,7,10,0,0,752,753,7,23,0,0,753,88,1,0,0,0,754,755,
        7,21,0,0,755,756,7,8,0,0,756,757,7,12,0,0,757,758,7,14,0,0,758,759,
        7,11,0,0,759,90,1,0,0,0,760,761,7,8,0,0,761,762,7,18,0,0,762,763,
        7,21,0,0,763,764,7,16,0,0,764,765,7,7,0,0,765,92,1,0,0,0,766,767,
        7,17,0,0,767,768,7,20,0,0,768,94,1,0,0,0,769,770,7,16,0,0,770,771,
        7,3,0,0,771,772,7,26,0,0,772,773,7,18,0,0,773,774,7,9,0,0,774,775,
        7,21,0,0,775,96,1,0,0,0,776,777,7,8,0,0,777,778,7,12,0,0,778,779,
        7,10,0,0,779,780,7,10,0,0,780,781,7,17,0,0,781,782,7,3,0,0,782,783,
        7,13,0,0,783,784,7,23,0,0,784,98,1,0,0,0,785,786,7,13,0,0,786,787,
        7,3,0,0,787,788,7,19,0,0,788,789,7,13,0,0,789,790,7,3,0,0,790,791,
        7,4,0,0,791,792,7,5,0,0,792,100,1,0,0,0,793,794,7,16,0,0,794,795,
        7,12,0,0,795,796,7,10,0,0,796,797,7,4,0,0,797,798,7,10,0,0,798,799,
        7,12,0,0,799,800,7,13,0,0,800,801,7,23,0,0,801,102,1,0,0,0,802,803,
        7,8,0,0,803,804,7,12,0,0,804,805,7,25,0,0,805,806,7,13,0,0,806,807,
        7,12,0,0,807,808,7,14,0,0,808,809,7,9,0,0,809,810,7,7,0,0,810,104,
        1,0,0,0,811,812,7,13,0,0,812,813,7,3,0,0,813,814,7,19,0,0,814,815,
        7,5,0,0,815,106,1,0,0,0,816,817,7,18,0,0,817,818,7,4,0,0,818,819,
        7,5,0,0,819,820,7,9,0,0,820,821,7,7,0,0,821,822,7,18,0,0,822,823,
        7,7,0,0,823,824,7,20,0,0,824,108,1,0,0,0,825,826,7,8,0,0,826,827,
        7,12,0,0,827,828,7,25,0,0,828,829,7,21,0,0,829,830,7,14,0,0,830,
        831,7,18,0,0,831,832,7,4,0,0,832,833,7,13,0,0,833,834,7,12,0,0,834,
        835,7,10,0,0,835,110,1,0,0,0,836,837,7,13,0,0,837,838,7,16,0,0,838,
        839,7,5,0,0,839,840,7,13,0,0,840,841,7,23,0,0,841,112,1,0,0,0,842,
        843,7,18,0,0,843,844,7,4,0,0,844,845,7,5,0,0,845,846,7,9,0,0,846,
        847,7,7,0,0,847,848,7,18,0,0,848,849,7,7,0,0,849,850,7,20,0,0,850,
        851,5,95,0,0,851,852,7,18,0,0,852,853,7,9,0,0,853,854,7,19,0,0,854,
        855,7,5,0,0,855,856,7,8,0,0,856,857,7,7,0,0,857,114,1,0,0,0,858,
        859,7,8,0,0,859,860,7,14,0,0,860,861,7,10,0,0,861,862,7,5,0,0,862,
        116,1,0,0,0,863,864,7,13,0,0,864,865,7,16,0,0,865,866,7,5,0,0,866,
        867,7,13,0,0,867,868,7,23,0,0,868,869,7,11,0,0,869,870,7,12,0,0,
        870,871,7,18,0,0,871,872,7,9,0,0,872,873,7,7,0,0,873,118,1,0,0,0,
        874,875,7,18,0,0,875,876,7,4,0,0,876,877,7,5,0,0,877,878,7,9,0,0,
        878,879,7,7,0,0,879,880,7,18,0,0,880,881,7,7,0,0,881,882,7,20,0,
        0,882,883,7,13,0,0,883,884,7,12,0,0,884,885,7,10,0,0,885,120,1,0,
        0,0,886,887,7,19,0,0,887,888,7,3,0,0,888,889,7,26,0,0,889,890,7,
        5,0,0,890,122,1,0,0,0,891,892,7,13,0,0,892,893,7,10,0,0,893,894,
        7,12,0,0,894,895,7,19,0,0,895,896,7,5,0,0,896,124,1,0,0,0,897,898,
        7,18,0,0,898,899,7,15,0,0,899,126,1,0,0,0,900,901,7,19,0,0,901,902,
        7,13,0,0,902,903,7,16,0,0,903,904,7,5,0,0,904,905,7,24,0,0,905,906,
        7,3,0,0,906,128,1,0,0,0,907,908,7,13,0,0,908,909,7,10,0,0,909,910,
        7,14,0,0,910,911,7,19,0,0,911,912,7,7,0,0,912,913,7,5,0,0,913,914,
        7,8,0,0,914,915,7,5,0,0,915,916,7,4,0,0,916,130,1,0,0,0,917,918,
        7,18,0,0,918,919,7,9,0,0,919,132,1,0,0,0,920,921,7,19,0,0,921,922,
        7,5,0,0,922,923,7,13,0,0,923,924,7,14,0,0,924,925,7,8,0,0,925,926,
        7,18,0,0,926,927,7,7,0,0,927,928,7,20,0,0,928,929,7,3,0,0,929,930,
        7,14,0,0,930,931,7,4,0,0,931,932,7,18,0,0,932,933,7,7,0,0,933,134,
        1,0,0,0,934,935,7,13,0,0,935,936,7,12,0,0,936,937,7,3,0,0,937,938,
        7,10,0,0,938,939,7,5,0,0,939,940,7,19,0,0,940,941,7,13,0,0,941,942,
        7,5,0,0,942,136,1,0,0,0,943,944,7,18,0,0,944,945,7,9,0,0,945,946,
        7,4,0,0,946,947,7,5,0,0,947,948,7,6,0,0,948,138,1,0,0,0,949,950,
        7,19,0,0,950,951,7,5,0,0,951,952,7,10,0,0,952,953,7,5,0,0,953,954,
        7,13,0,0,954,955,7,7,0,0,955,140,1,0,0,0,956,957,7,13,0,0,957,958,
        7,12,0,0,958,959,7,10,0,0,959,960,7,10,0,0,960,961,7,3,0,0,961,962,
        7,7,0,0,962,963,7,5,0,0,963,142,1,0,0,0,964,965,7,18,0,0,965,966,
        7,9,0,0,966,967,7,9,0,0,967,968,7,5,0,0,968,969,7,8,0,0,969,144,
        1,0,0,0,970,971,7,19,0,0,971,972,7,5,0,0,972,973,7,24,0,0,973,974,
        7,3,0,0,974,975,7,9,0,0,975,976,7,7,0,0,976,977,7,18,0,0,977,978,
        7,13,0,0,978,979,7,23,0,0,979,980,7,5,0,0,980,981,7,20,0,0,981,982,
        7,11,0,0,982,983,7,16,0,0,983,984,7,8,0,0,984,985,7,3,0,0,985,986,
        7,19,0,0,986,987,7,5,0,0,987,988,7,7,0,0,988,989,7,3,0,0,989,990,
        7,17,0,0,990,991,7,10,0,0,991,992,7,5,0,0,992,146,1,0,0,0,993,994,
        7,13,0,0,994,995,7,12,0,0,995,996,7,10,0,0,996,997,7,14,0,0,997,
        998,7,24,0,0,998,999,7,9,0,0,999,148,1,0,0,0,1000,1001,7,18,0,0,
        1001,1002,7,9,0,0,1002,1003,7,19,0,0,1003,1004,7,5,0,0,1004,1005,
        7,8,0,0,1005,1006,7,7,0,0,1006,150,1,0,0,0,1007,1008,7,19,0,0,1008,
        1009,7,5,0,0,1009,1010,7,24,0,0,1010,1011,7,3,0,0,1011,1012,7,9,
        0,0,1012,1013,7,7,0,0,1013,1014,7,18,0,0,1014,1015,7,13,0,0,1015,
        1016,7,19,0,0,1016,1017,7,18,0,0,1017,1018,7,24,0,0,1018,1019,7,
        18,0,0,1019,1020,7,10,0,0,1020,1021,7,3,0,0,1021,1022,7,8,0,0,1022,
        1023,7,18,0,0,1023,1024,7,7,0,0,1024,1025,7,20,0,0,1025,1026,7,4,
        0,0,1026,1027,7,5,0,0,1027,1028,7,7,0,0,1028,1029,7,3,0,0,1029,1030,
        7,18,0,0,1030,1031,7,10,0,0,1031,1032,7,19,0,0,1032,1033,7,7,0,0,
        1033,1034,7,3,0,0,1034,1035,7,17,0,0,1035,1036,7,10,0,0,1036,1037,
        7,5,0,0,1037,152,1,0,0,0,1038,1039,7,13,0,0,1039,1040,7,12,0,0,1040,
        1041,7,24,0,0,1041,1042,7,24,0,0,1042,1043,7,18,0,0,1043,1044,7,
        7,0,0,1044,154,1,0,0,0,1045,1046,7,18,0,0,1046,1047,7,9,0,0,1047,
        1048,7,7,0,0,1048,1049,7,5,0,0,1049,1050,7,8,0,0,1050,1051,7,19,
        0,0,1051,1052,7,5,0,0,1052,1053,7,13,0,0,1053,1054,7,7,0,0,1054,
        156,1,0,0,0,1055,1056,7,19,0,0,1056,1057,7,5,0,0,1057,1058,7,24,
        0,0,1058,1059,7,3,0,0,1059,1060,7,9,0,0,1060,1061,7,7,0,0,1061,1062,
        7,18,0,0,1062,1063,7,13,0,0,1063,1064,7,19,0,0,1064,1065,7,18,0,
        0,1065,1066,7,24,0,0,1066,1067,7,18,0,0,1067,1068,7,10,0,0,1068,
        1069,7,3,0,0,1069,1070,7,8,0,0,1070,1071,7,18,0,0,1071,1072,7,7,
        0,0,1072,1073,7,20,0,0,1073,1074,7,7,0,0,1074,1075,7,3,0,0,1075,
        1076,7,17,0,0,1076,1077,7,10,0,0,1077,1078,7,5,0,0,1078,158,1,0,
        0,0,1079,1080,7,13,0,0,1080,1081,7,12,0,0,1081,1082,7,24,0,0,1082,
        1083,7,11,0,0,1083,1084,7,14,0,0,1084,1085,7,7,0,0,1085,1086,7,5,
        0,0,1086,160,1,0,0,0,1087,1088,7,18,0,0,1088,1089,7,9,0,0,1089,1090,
        7,7,0,0,1090,1091,7,12,0,0,1091,162,1,0,0,0,1092,1093,7,19,0,0,1093,
        1094,7,5,0,0,1094,1095,7,19,0,0,1095,1096,7,19,0,0,1096,1097,7,18,
        0,0,1097,1098,7,12,0,0,1098,1099,7,9,0,0,1099,1100,5,95,0,0,1100,
        1101,7,14,0,0,1101,1102,7,19,0,0,1102,1103,7,5,0,0,1103,1104,7,8,
        0,0,1104,164,1,0,0,0,1105,1106,7,13,0,0,1106,1107,7,12,0,0,1107,
        1108,7,9,0,0,1108,1109,7,19,0,0,1109,1110,7,7,0,0,1110,1111,7,8,
        0,0,1111,1112,7,3,0,0,1112,1113,7,18,0,0,1113,1114,7,9,0,0,1114,
        1115,7,7,0,0,1115,166,1,0,0,0,1116,1117,7,18,0,0,1117,1118,7,19,
        0,0,1118,168,1,0,0,0,1119,1120,7,19,0,0,1120,1121,7,5,0,0,1121,1122,
        7,7,0,0,1122,170,1,0,0,0,1123,1124,7,13,0,0,1124,1125,7,12,0,0,1125,
        1126,7,9,0,0,1126,1127,7,7,0,0,1127,1128,7,3,0,0,1128,1129,7,18,
        0,0,1129,1130,7,9,0,0,1130,1131,7,19,0,0,1131,172,1,0,0,0,1132,1133,
        7,27,0,0,1133,1134,7,12,0,0,1134,1135,7,18,0,0,1135,1136,7,9,0,0,
        1136,174,1,0,0,0,1137,1138,7,19,0,0,1138,1139,7,5,0,0,1139,1140,
        7,7,0,0,1140,1141,7,14,0,0,1141,1142,7,19,0,0,1142,1143,7,5,0,0,
        1143,1144,7,8,0,0,1144,176,1,0,0,0,1145,1146,7,13,0,0,1146,1147,
        7,12,0,0,1147,1148,7,9,0,0,1148,1149,7,7,0,0,1149,1150,7,3,0,0,1150,
        1151,7,18,0,0,1151,1152,7,9,0,0,1152,1153,7,19,0,0,1153,1154,7,7,
        0,0,1154,1155,7,3,0,0,1155,1156,7,17,0,0,1156,1157,7,10,0,0,1157,
        1158,7,5,0,0,1158,178,1,0,0,0,1159,1160,7,23,0,0,1160,1161,7,5,0,
        0,1161,1162,7,20,0,0,1162,180,1,0,0,0,1163,1164,7,19,0,0,1164,1165,
        7,16,0,0,1165,1166,7,14,0,0,1166,1167,7,7,0,0,1167,1168,7,4,0,0,
        1168,1169,7,12,0,0,1169,1170,7,25,0,0,1170,1171,7,9,0,0,1171,182,
        1,0,0,0,1172,1173,7,13,0,0,1173,1174,7,12,0,0,1174,1175,7,9,0,0,
        1175,1176,7,7,0,0,1176,1177,7,18,0,0,1177,1178,7,9,0,0,1178,1179,
        7,14,0,0,1179,1180,7,5,0,0,1180,184,1,0,0,0,1181,1182,7,23,0,0,1182,
        1183,7,18,0,0,1183,1184,7,10,0,0,1184,1185,7,10,0,0,1185,186,1,0,
        0,0,1186,1187,7,19,0,0,1187,1188,7,12,0,0,1188,1189,7,24,0,0,1189,
        1190,7,5,0,0,1190,188,1,0,0,0,1191,1192,7,13,0,0,1192,1193,7,12,
        0,0,1193,1194,7,9,0,0,1194,1195,7,26,0,0,1195,1196,7,5,0,0,1196,
        1197,7,8,0,0,1197,1198,7,7,0,0,1198,190,1,0,0,0,1199,1200,7,10,0,
        0,1200,1201,7,5,0,0,1201,1202,7,15,0,0,1202,1203,7,7,0,0,1203,192,
        1,0,0,0,1204,1205,7,19,0,0,1205,1206,7,7,0,0,1206,1207,7,3,0,0,1207,
        1208,7,7,0,0,1208,1209,7,18,0,0,1209,1210,7,19,0,0,1210,1211,7,7,
        0,0,1211,1212,7,18,0,0,1212,1213,7,13,0,0,1213,1214,7,19,0,0,1214,
        194,1,0,0,0,1215,1216,7,13,0,0,1216,1217,7,8,0,0,1217,1218,7,5,0,
        0,1218,1219,7,3,0,0,1219,1220,7,7,0,0,1220,1221,7,5,0,0,1221,196,
        1,0,0,0,1222,1223,7,10,0,0,1223,1224,7,18,0,0,1224,1225,7,23,0,0,
        1225,1226,7,5,0,0,1226,198,1,0,0,0,1227,1228,7,19,0,0,1228,1229,
        7,20,0,0,1229,1230,7,19,0,0,1230,1231,7,7,0,0,1231,1232,7,5,0,0,
        1232,1233,7,24,0,0,1233,1234,5,95,0,0,1234,1235,7,14,0,0,1235,1236,
        7,19,0,0,1236,1237,7,5,0,0,1237,1238,7,8,0,0,1238,200,1,0,0,0,1239,
        1240,7,13,0,0,1240,1241,7,8,0,0,1241,1242,7,12,0,0,1242,1243,7,19,
        0,0,1243,1244,7,19,0,0,1244,202,1,0,0,0,1245,1246,7,10,0,0,1246,
        1247,7,18,0,0,1247,1248,7,9,0,0,1248,1249,7,5,0,0,1249,1250,7,9,
        0,0,1250,1251,7,12,0,0,1251,204,1,0,0,0,1252,1253,7,7,0,0,1253,1254,
        7,3,0,0,1254,1255,7,17,0,0,1255,1256,7,10,0,0,1256,1257,7,5,0,0,
        1257,206,1,0,0,0,1258,1259,7,13,0,0,1259,1260,7,14,0,0,1260,1261,
        7,8,0,0,1261,1262,7,8,0,0,1262,1263,7,5,0,0,1263,1264,7,9,0,0,1264,
        1265,7,7,0,0,1265,208,1,0,0,0,1266,1267,7,10,0,0,1267,1268,7,12,
        0,0,1268,1269,7,3,0,0,1269,1270,7,4,0,0,1270,210,1,0,0,0,1271,1272,
        7,7,0,0,1272,1273,7,3,0,0,1273,1274,7,17,0,0,1274,1275,7,10,0,0,
        1275,1276,7,5,0,0,1276,1277,7,19,0,0,1277,1278,7,3,0,0,1278,1279,
        7,24,0,0,1279,1280,7,11,0,0,1280,1281,7,10,0,0,1281,1282,7,5,0,0,
        1282,212,1,0,0,0,1283,1284,7,13,0,0,1284,1285,7,14,0,0,1285,1286,
        7,8,0,0,1286,1287,7,8,0,0,1287,1288,7,5,0,0,1288,1289,7,9,0,0,1289,
        1290,7,7,0,0,1290,1291,5,95,0,0,1291,1292,7,4,0,0,1292,1293,7,3,
        0,0,1293,1294,7,7,0,0,1294,1295,7,5,0,0,1295,214,1,0,0,0,1296,1297,
        7,24,0,0,1297,1298,7,5,0,0,1298,1299,7,8,0,0,1299,1300,7,21,0,0,
        1300,1301,7,5,0,0,1301,216,1,0,0,0,1302,1303,7,7,0,0,1303,1304,7,
        5,0,0,1304,1305,7,6,0,0,1305,1306,7,7,0,0,1306,1307,7,19,0,0,1307,
        1308,7,18,0,0,1308,1309,7,22,0,0,1309,1310,7,5,0,0,1310,218,1,0,
        0,0,1311,1312,7,13,0,0,1312,1313,7,14,0,0,1313,1314,7,8,0,0,1314,
        1315,7,8,0,0,1315,1316,7,5,0,0,1316,1317,7,9,0,0,1317,1318,7,7,0,
        0,1318,1319,5,95,0,0,1319,1320,7,7,0,0,1320,1321,7,18,0,0,1321,1322,
        7,24,0,0,1322,1323,7,5,0,0,1323,220,1,0,0,0,1324,1325,7,9,0,0,1325,
        1326,7,3,0,0,1326,1327,7,7,0,0,1327,1328,7,18,0,0,1328,1329,7,12,
        0,0,1329,1330,7,9,0,0,1330,1331,7,3,0,0,1331,1332,7,10,0,0,1332,
        222,1,0,0,0,1333,1334,7,7,0,0,1334,1335,7,16,0,0,1335,1336,7,5,0,
        0,1336,1337,7,9,0,0,1337,224,1,0,0,0,1338,1339,7,13,0,0,1339,1340,
        7,14,0,0,1340,1341,7,8,0,0,1341,1342,7,8,0,0,1342,1343,7,5,0,0,1343,
        1344,7,9,0,0,1344,1345,7,7,0,0,1345,1346,5,95,0,0,1346,1347,7,7,
        0,0,1347,1348,7,18,0,0,1348,1349,7,24,0,0,1349,1350,7,5,0,0,1350,
        1351,7,19,0,0,1351,1352,7,7,0,0,1352,1353,7,3,0,0,1353,1354,7,24,
        0,0,1354,1355,7,11,0,0,1355,226,1,0,0,0,1356,1357,7,9,0,0,1357,1358,
        7,12,0,0,1358,1359,7,13,0,0,1359,1360,7,16,0,0,1360,1361,7,5,0,0,
        1361,1362,7,13,0,0,1362,1363,7,23,0,0,1363,228,1,0,0,0,1364,1365,
        7,7,0,0,1365,1366,7,12,0,0,1366,230,1,0,0,0,1367,1368,7,13,0,0,1368,
        1369,7,14,0,0,1369,1370,7,8,0,0,1370,1371,7,8,0,0,1371,1372,7,5,
        0,0,1372,1373,7,9,0,0,1373,1374,7,7,0,0,1374,1375,5,95,0,0,1375,
        1376,7,14,0,0,1376,1377,7,19,0,0,1377,1378,7,5,0,0,1378,1379,7,8,
        0,0,1379,232,1,0,0,0,1380,1381,7,9,0,0,1381,1382,7,12,0,0,1382,1383,
        7,9,0,0,1383,1384,7,13,0,0,1384,1385,7,10,0,0,1385,1386,7,14,0,0,
        1386,1387,7,19,0,0,1387,1388,7,7,0,0,1388,1389,7,5,0,0,1389,1390,
        7,8,0,0,1390,1391,7,5,0,0,1391,1392,7,4,0,0,1392,234,1,0,0,0,1393,
        1394,7,7,0,0,1394,1395,7,12,0,0,1395,1396,7,11,0,0,1396,236,1,0,
        0,0,1397,1398,7,13,0,0,1398,1399,7,14,0,0,1399,1400,7,8,0,0,1400,
        1401,7,19,0,0,1401,1402,7,12,0,0,1402,1403,7,8,0,0,1403,238,1,0,
        0,0,1404,1405,7,9,0,0,1405,1406,7,12,0,0,1406,1407,7,7,0,0,1407,
        240,1,0,0,0,1408,1409,7,7,0,0,1409,1410,7,8,0,0,1410,1411,7,3,0,
        0,1411,1412,7,9,0,0,1412,242,1,0,0,0,1413,1414,7,4,0,0,1414,1415,
        7,3,0,0,1415,1416,7,7,0,0,1416,1417,7,3,0,0,1417,1418,7,17,0,0,1418,
        1419,7,3,0,0,1419,1420,7,19,0,0,1420,1421,7,5,0,0,1421,244,1,0,0,
        0,1422,1423,7,9,0,0,1423,1424,7,14,0,0,1424,1425,7,10,0,0,1425,1426,
        7,10,0,0,1426,246,1,0,0,0,1427,1428,7,7,0,0,1428,1429,7,8,0,0,1429,
        1430,7,3,0,0,1430,1431,7,9,0,0,1431,1432,7,19,0,0,1432,1433,7,3,
        0,0,1433,1434,7,13,0,0,1434,1435,7,7,0,0,1435,1436,7,18,0,0,1436,
        1437,7,12,0,0,1437,1438,7,9,0,0,1438,248,1,0,0,0,1439,1440,7,4,0,
        0,1440,1441,7,17,0,0,1441,1442,7,13,0,0,1442,1443,7,13,0,0,1443,
        250,1,0,0,0,1444,1445,7,9,0,0,1445,1446,7,14,0,0,1446,1447,7,10,
        0,0,1447,1448,7,10,0,0,1448,1449,7,18,0,0,1449,1450,7,15,0,0,1450,
        252,1,0,0,0,1451,1452,7,7,0,0,1452,1453,7,8,0,0,1453,1454,7,18,0,
        0,1454,1455,7,21,0,0,1455,1456,7,21,0,0,1456,1457,7,5,0,0,1457,1458,
        7,8,0,0,1458,254,1,0,0,0,1459,1460,7,4,0,0,1460,1461,7,5,0,0,1461,
        1462,7,3,0,0,1462,1463,7,10,0,0,1463,1464,7,10,0,0,1464,1465,7,12,
        0,0,1465,1466,7,13,0,0,1466,1467,7,3,0,0,1467,1468,7,7,0,0,1468,
        1469,7,5,0,0,1469,256,1,0,0,0,1470,1471,7,12,0,0,1471,1472,7,15,
        0,0,1472,258,1,0,0,0,1473,1474,7,7,0,0,1474,1475,7,8,0,0,1475,1476,
        7,14,0,0,1476,1477,7,9,0,0,1477,1478,7,13,0,0,1478,1479,7,3,0,0,
        1479,1480,7,7,0,0,1480,1481,7,5,0,0,1481,260,1,0,0,0,1482,1483,7,
        4,0,0,1483,1484,7,5,0,0,1484,1485,7,13,0,0,1485,1486,7,10,0,0,1486,
        1487,7,3,0,0,1487,1488,7,8,0,0,1488,1489,7,5,0,0,1489,262,1,0,0,
        0,1490,1491,7,12,0,0,1491,1492,7,15,0,0,1492,1493,7,15,0,0,1493,
        264,1,0,0,0,1494,1495,7,7,0,0,1495,1496,7,8,0,0,1496,1497,7,20,0,
        0,1497,1498,5,95,0,0,1498,1499,7,13,0,0,1499,1500,7,12,0,0,1500,
        1501,7,9,0,0,1501,1502,7,26,0,0,1502,1503,7,5,0,0,1503,1504,7,8,
        0,0,1504,1505,7,7,0,0,1505,266,1,0,0,0,1506,1507,7,4,0,0,1507,1508,
        7,5,0,0,1508,1509,7,15,0,0,1509,1510,7,3,0,0,1510,1511,7,14,0,0,
        1511,1512,7,10,0,0,1512,1513,7,7,0,0,1513,268,1,0,0,0,1514,1515,
        7,12,0,0,1515,1516,7,15,0,0,1516,1517,7,15,0,0,1517,1518,7,19,0,
        0,1518,1519,7,5,0,0,1519,1520,7,7,0,0,1520,1521,7,19,0,0,1521,270,
        1,0,0,0,1522,1523,7,7,0,0,1523,1524,7,19,0,0,1524,1525,7,5,0,0,1525,
        1526,7,28,0,0,1526,1527,7,14,0,0,1527,1528,7,3,0,0,1528,1529,7,10,
        0,0,1529,272,1,0,0,0,1530,1531,7,4,0,0,1531,1532,7,5,0,0,1532,1533,
        7,10,0,0,1533,1534,7,5,0,0,1534,1535,7,7,0,0,1535,1536,7,5,0,0,1536,
        274,1,0,0,0,1537,1538,7,12,0,0,1538,1539,7,9,0,0,1539,276,1,0,0,
        0,1540,1541,7,14,0,0,1541,1542,7,9,0,0,1542,1543,7,18,0,0,1543,1544,
        7,12,0,0,1544,1545,7,9,0,0,1545,278,1,0,0,0,1546,1547,7,4,0,0,1547,
        1548,7,5,0,0,1548,1549,7,9,0,0,1549,1550,7,20,0,0,1550,280,1,0,0,
        0,1551,1552,7,12,0,0,1552,1553,7,11,0,0,1553,1554,7,5,0,0,1554,1555,
        7,9,0,0,1555,282,1,0,0,0,1556,1557,7,14,0,0,1557,1558,7,9,0,0,1558,
        1559,7,18,0,0,1559,1560,7,28,0,0,1560,1561,7,14,0,0,1561,1562,7,
        5,0,0,1562,284,1,0,0,0,1563,1564,7,4,0,0,1564,1565,7,5,0,0,1565,
        1566,7,19,0,0,1566,1567,7,13,0,0,1567,286,1,0,0,0,1568,1569,7,12,
        0,0,1569,1570,7,11,0,0,1570,1571,7,5,0,0,1571,1572,7,9,0,0,1572,
        1573,7,4,0,0,1573,1574,7,3,0,0,1574,1575,7,7,0,0,1575,1576,7,3,0,
        0,1576,1577,7,19,0,0,1577,1578,7,12,0,0,1578,1579,7,14,0,0,1579,
        1580,7,8,0,0,1580,1581,7,13,0,0,1581,1582,7,5,0,0,1582,288,1,0,0,
        0,1583,1584,7,14,0,0,1584,1585,7,11,0,0,1585,1586,7,4,0,0,1586,1587,
        7,3,0,0,1587,1588,7,7,0,0,1588,1589,7,5,0,0,1589,290,1,0,0,0,1590,
        1591,7,4,0,0,1591,1592,7,18,0,0,1592,1593,7,19,0,0,1593,1594,7,23,
        0,0,1594,292,1,0,0,0,1595,1596,7,12,0,0,1596,1597,7,11,0,0,1597,
        1598,7,5,0,0,1598,1599,7,9,0,0,1599,1600,7,28,0,0,1600,1601,7,14,
        0,0,1601,1602,7,5,0,0,1602,1603,7,8,0,0,1603,1604,7,20,0,0,1604,
        294,1,0,0,0,1605,1606,7,14,0,0,1606,1607,7,11,0,0,1607,1608,7,4,
        0,0,1608,1609,7,3,0,0,1609,1610,7,7,0,0,1610,1611,7,5,0,0,1611,1612,
        7,7,0,0,1612,1613,7,5,0,0,1613,1614,7,6,0,0,1614,1615,7,7,0,0,1615,
        296,1,0,0,0,1616,1617,7,4,0,0,1617,1618,7,18,0,0,1618,1619,7,19,
        0,0,1619,1620,7,7,0,0,1620,1621,7,18,0,0,1621,1622,7,9,0,0,1622,
        1623,7,13,0,0,1623,1624,7,7,0,0,1624,298,1,0,0,0,1625,1626,7,12,
        0,0,1626,1627,7,11,0,0,1627,1628,7,5,0,0,1628,1629,7,9,0,0,1629,
        1630,7,8,0,0,1630,1631,7,12,0,0,1631,1632,7,25,0,0,1632,1633,7,19,
        0,0,1633,1634,7,5,0,0,1634,1635,7,7,0,0,1635,300,1,0,0,0,1636,1637,
        7,14,0,0,1637,1638,7,19,0,0,1638,1639,7,5,0,0,1639,302,1,0,0,0,1640,
        1641,7,4,0,0,1641,1642,7,18,0,0,1642,1643,7,19,0,0,1643,1644,7,7,
        0,0,1644,1645,7,8,0,0,1645,1646,7,18,0,0,1646,1647,7,17,0,0,1647,
        1648,7,14,0,0,1648,1649,7,7,0,0,1649,1650,7,5,0,0,1650,1651,7,4,
        0,0,1651,304,1,0,0,0,1652,1653,7,12,0,0,1653,1654,7,11,0,0,1654,
        1655,7,5,0,0,1655,1656,7,9,0,0,1656,1657,7,6,0,0,1657,1658,7,24,
        0,0,1658,1659,7,10,0,0,1659,306,1,0,0,0,1660,1661,7,14,0,0,1661,
        1662,7,19,0,0,1662,1663,7,5,0,0,1663,1664,7,8,0,0,1664,308,1,0,0,
        0,1665,1666,7,4,0,0,1666,1667,7,12,0,0,1667,1668,7,14,0,0,1668,1669,
        7,17,0,0,1669,1670,7,10,0,0,1670,1671,7,5,0,0,1671,310,1,0,0,0,1672,
        1673,7,12,0,0,1673,1674,7,11,0,0,1674,1675,7,7,0,0,1675,1676,7,18,
        0,0,1676,1677,7,12,0,0,1677,1678,7,9,0,0,1678,312,1,0,0,0,1679,1680,
        7,26,0,0,1680,1681,7,3,0,0,1681,1682,7,10,0,0,1682,1683,7,14,0,0,
        1683,1684,7,5,0,0,1684,1685,7,19,0,0,1685,314,1,0,0,0,1686,1687,
        7,4,0,0,1687,1688,7,8,0,0,1688,1689,7,12,0,0,1689,1690,7,11,0,0,
        1690,316,1,0,0,0,1691,1692,7,12,0,0,1692,1693,7,8,0,0,1693,318,1,
        0,0,0,1694,1695,7,26,0,0,1695,1696,7,3,0,0,1696,1697,7,8,0,0,1697,
        1698,7,20,0,0,1698,1699,7,18,0,0,1699,1700,7,9,0,0,1700,1701,7,21,
        0,0,1701,320,1,0,0,0,1702,1703,7,4,0,0,1703,1704,7,14,0,0,1704,1705,
        7,24,0,0,1705,1706,7,11,0,0,1706,322,1,0,0,0,1707,1708,7,12,0,0,
        1708,1709,7,8,0,0,1709,1710,7,4,0,0,1710,1711,7,5,0,0,1711,1712,
        7,8,0,0,1712,324,1,0,0,0,1713,1714,7,26,0,0,1714,1715,7,18,0,0,1715,
        1716,7,5,0,0,1716,1717,7,25,0,0,1717,326,1,0,0,0,1718,1719,7,5,0,
        0,1719,1720,7,10,0,0,1720,1721,7,19,0,0,1721,1722,7,5,0,0,1722,328,
        1,0,0,0,1723,1724,7,12,0,0,1724,1725,7,14,0,0,1725,1726,7,7,0,0,
        1726,1727,7,5,0,0,1727,1728,7,8,0,0,1728,330,1,0,0,0,1729,1730,7,
        25,0,0,1730,1731,7,3,0,0,1731,1732,7,18,0,0,1732,1733,7,7,0,0,1733,
        1734,7,15,0,0,1734,1735,7,12,0,0,1735,1736,7,8,0,0,1736,332,1,0,
        0,0,1737,1738,7,5,0,0,1738,1739,7,9,0,0,1739,1740,7,4,0,0,1740,334,
        1,0,0,0,1741,1742,7,12,0,0,1742,1743,7,26,0,0,1743,1744,7,5,0,0,
        1744,1745,7,8,0,0,1745,336,1,0,0,0,1746,1747,7,25,0,0,1747,1748,
        7,16,0,0,1748,1749,7,5,0,0,1749,1750,7,9,0,0,1750,338,1,0,0,0,1751,
        1752,7,5,0,0,1752,1753,7,8,0,0,1753,1754,7,8,0,0,1754,1755,7,10,
        0,0,1755,1756,7,26,0,0,1756,1757,7,10,0,0,1757,340,1,0,0,0,1758,
        1759,7,11,0,0,1759,1760,7,5,0,0,1760,1761,7,8,0,0,1761,1762,7,13,
        0,0,1762,1763,7,5,0,0,1763,1764,7,9,0,0,1764,1765,7,7,0,0,1765,342,
        1,0,0,0,1766,1767,7,25,0,0,1767,1768,7,16,0,0,1768,1769,7,5,0,0,
        1769,1770,7,8,0,0,1770,1771,7,5,0,0,1771,344,1,0,0,0,1772,1773,7,
        5,0,0,1773,1774,7,19,0,0,1774,1775,7,13,0,0,1775,1776,7,3,0,0,1776,
        1777,7,11,0,0,1777,1778,7,5,0,0,1778,346,1,0,0,0,1779,1780,7,11,
        0,0,1780,1781,7,18,0,0,1781,1782,7,26,0,0,1782,1783,7,12,0,0,1783,
        1784,7,7,0,0,1784,348,1,0,0,0,1785,1786,7,25,0,0,1786,1787,7,16,
        0,0,1787,1788,7,18,0,0,1788,1789,7,10,0,0,1789,1790,7,5,0,0,1790,
        350,1,0,0,0,1791,1792,7,5,0,0,1792,1793,7,6,0,0,1793,1794,7,13,0,
        0,1794,1795,7,5,0,0,1795,1796,7,11,0,0,1796,1797,7,7,0,0,1797,352,
        1,0,0,0,1798,1799,7,11,0,0,1799,1800,7,10,0,0,1800,1801,7,3,0,0,
        1801,1802,7,9,0,0,1802,354,1,0,0,0,1803,1804,7,25,0,0,1804,1805,
        7,18,0,0,1805,1806,7,7,0,0,1806,1807,7,16,0,0,1807,356,1,0,0,0,1808,
        1809,7,5,0,0,1809,1810,7,6,0,0,1810,1811,7,5,0,0,1811,1812,7,13,
        0,0,1812,358,1,0,0,0,1813,1814,7,11,0,0,1814,1815,7,8,0,0,1815,1816,
        7,5,0,0,1816,1817,7,13,0,0,1817,1818,7,18,0,0,1818,1819,7,19,0,0,
        1819,1820,7,18,0,0,1820,1821,7,12,0,0,1821,1822,7,9,0,0,1822,360,
        1,0,0,0,1823,1824,7,25,0,0,1824,1825,7,8,0,0,1825,1826,7,18,0,0,
        1826,1827,7,7,0,0,1827,1828,7,5,0,0,1828,1829,7,7,0,0,1829,1830,
        7,5,0,0,1830,1831,7,6,0,0,1831,1832,7,7,0,0,1832,362,1,0,0,0,1833,
        1834,7,5,0,0,1834,1835,7,6,0,0,1835,1836,7,5,0,0,1836,1837,7,13,
        0,0,1837,1838,7,14,0,0,1838,1839,7,7,0,0,1839,1840,7,5,0,0,1840,
        364,1,0,0,0,1841,1842,7,11,0,0,1842,1843,7,8,0,0,1843,1844,7,18,
        0,0,1844,1845,7,24,0,0,1845,1846,7,3,0,0,1846,1847,7,8,0,0,1847,
        1848,7,20,0,0,1848,366,1,0,0,0,1849,1850,7,18,0,0,1850,1851,7,9,
        0,0,1851,1852,7,7,0,0,1852,1853,7,5,0,0,1853,1854,7,21,0,0,1854,
        1855,7,5,0,0,1855,1856,7,8,0,0,1856,368,1,0,0,0,1857,1858,7,9,0,
        0,1858,1859,7,26,0,0,1859,1860,7,3,0,0,1860,1861,7,8,0,0,1861,1862,
        7,13,0,0,1862,1863,7,16,0,0,1863,1864,7,3,0,0,1864,1865,7,8,0,0,
        1865,370,1,0,0,0,1866,1867,7,26,0,0,1867,1868,7,3,0,0,1868,1869,
        7,8,0,0,1869,1870,7,13,0,0,1870,1871,7,16,0,0,1871,1872,7,3,0,0,
        1872,1873,7,8,0,0,1873,372,1,0,0,0,1874,1875,7,24,0,0,1875,1876,
        7,3,0,0,1876,1877,7,6,0,0,1877,374,1,0,0,0,1878,1879,7,24,0,0,1879,
        1880,7,18,0,0,1880,1881,7,9,0,0,1881,376,1,0,0,0,1882,1883,7,3,0,
        0,1883,1884,7,26,0,0,1884,1885,7,21,0,0,1885,378,1,0,0,0,1886,1887,
        7,19,0,0,1887,1888,7,14,0,0,1888,1889,7,24,0,0,1889,380,1,0,0,0,
        1890,1891,7,13,0,0,1891,1892,7,12,0,0,1892,1893,7,14,0,0,1893,1894,
        7,9,0,0,1894,1895,7,7,0,0,1895,382,1,0,0,0,1896,1897,7,7,0,0,1897,
        1898,7,8,0,0,1898,1899,7,20,0,0,1899,384,1,0,0,0,1900,1901,7,13,
        0,0,1901,1902,7,3,0,0,1902,1903,7,7,0,0,1903,1904,7,13,0,0,1904,
        1905,7,16,0,0,1905,386,1,0,0,0,1906,1907,7,5,0,0,1907,1908,7,6,0,
        0,1908,1909,7,18,0,0,1909,1910,7,19,0,0,1910,1911,7,7,0,0,1911,1912,
        7,19,0,0,1912,388,1,0,0,0,1913,1915,3,1,0,0,1914,1913,1,0,0,0,1915,
        1916,1,0,0,0,1916,1914,1,0,0,0,1916,1917,1,0,0,0,1917,390,1,0,0,
        0,1918,1920,3,1,0,0,1919,1918,1,0,0,0,1920,1921,1,0,0,0,1921,1919,
        1,0,0,0,1921,1922,1,0,0,0,1922,1923,1,0,0,0,1923,1925,5,46,0,0,1924,
        1926,3,1,0,0,1925,1924,1,0,0,0,1926,1927,1,0,0,0,1927,1925,1,0,0,
        0,1927,1928,1,0,0,0,1928,392,1,0,0,0,1929,1930,5,48,0,0,1930,1932,
        7,6,0,0,1931,1929,1,0,0,0,1932,1933,1,0,0,0,1933,1931,1,0,0,0,1933,
        1934,1,0,0,0,1934,394,1,0,0,0,1935,1936,5,48,0,0,1936,1937,7,17,
        0,0,1937,1939,1,0,0,0,1938,1940,7,29,0,0,1939,1938,1,0,0,0,1940,
        1941,1,0,0,0,1941,1939,1,0,0,0,1941,1942,1,0,0,0,1942,396,1,0,0,
        0,1943,1944,7,7,0,0,1944,1945,7,8,0,0,1945,1946,7,14,0,0,1946,1947,
        7,5,0,0,1947,398,1,0,0,0,1948,1949,7,15,0,0,1949,1950,7,3,0,0,1950,
        1951,7,10,0,0,1951,1952,7,19,0,0,1952,1953,7,5,0,0,1953,400,1,0,
        0,0,1954,1956,7,9,0,0,1955,1954,1,0,0,0,1955,1956,1,0,0,0,1956,1957,
        1,0,0,0,1957,1982,5,39,0,0,1958,1981,8,30,0,0,1959,1960,5,92,0,0,
        1960,1981,9,0,0,0,1961,1962,5,39,0,0,1962,1981,5,39,0,0,1963,1967,
        5,92,0,0,1964,1966,7,31,0,0,1965,1964,1,0,0,0,1966,1969,1,0,0,0,
        1967,1965,1,0,0,0,1967,1968,1,0,0,0,1968,1971,1,0,0,0,1969,1967,
        1,0,0,0,1970,1972,5,13,0,0,1971,1970,1,0,0,0,1971,1972,1,0,0,0,1972,
        1973,1,0,0,0,1973,1977,5,10,0,0,1974,1976,7,31,0,0,1975,1974,1,0,
        0,0,1976,1979,1,0,0,0,1977,1975,1,0,0,0,1977,1978,1,0,0,0,1978,1981,
        1,0,0,0,1979,1977,1,0,0,0,1980,1958,1,0,0,0,1980,1959,1,0,0,0,1980,
        1961,1,0,0,0,1980,1963,1,0,0,0,1981,1984,1,0,0,0,1982,1980,1,0,0,
        0,1982,1983,1,0,0,0,1983,1985,1,0,0,0,1984,1982,1,0,0,0,1985,1986,
        5,39,0,0,1986,1987,6,200,1,0,1987,402,1,0,0,0,1988,1992,5,91,0,0,
        1989,1991,8,32,0,0,1990,1989,1,0,0,0,1991,1994,1,0,0,0,1992,1990,
        1,0,0,0,1992,1993,1,0,0,0,1993,1995,1,0,0,0,1994,1992,1,0,0,0,1995,
        1996,5,93,0,0,1996,404,1,0,0,0,1997,2002,3,3,1,0,1998,2001,3,3,1,
        0,1999,2001,3,1,0,0,2000,1998,1,0,0,0,2000,1999,1,0,0,0,2001,2004,
        1,0,0,0,2002,2000,1,0,0,0,2002,2003,1,0,0,0,2003,406,1,0,0,0,2004,
        2002,1,0,0,0,2005,2006,5,64,0,0,2006,2007,3,405,202,0,2007,408,1,
        0,0,0,2008,2009,5,61,0,0,2009,410,1,0,0,0,2010,2011,5,60,0,0,2011,
        2015,5,62,0,0,2012,2013,5,33,0,0,2013,2015,5,61,0,0,2014,2010,1,
        0,0,0,2014,2012,1,0,0,0,2015,412,1,0,0,0,2016,2017,5,62,0,0,2017,
        414,1,0,0,0,2018,2019,5,60,0,0,2019,416,1,0,0,0,2020,2021,5,62,0,
        0,2021,2022,5,61,0,0,2022,418,1,0,0,0,2023,2024,5,60,0,0,2024,2025,
        5,61,0,0,2025,420,1,0,0,0,2026,2027,5,43,0,0,2027,422,1,0,0,0,2028,
        2029,5,45,0,0,2029,424,1,0,0,0,2030,2031,5,42,0,0,2031,426,1,0,0,
        0,2032,2033,5,47,0,0,2033,428,1,0,0,0,2034,2035,5,43,0,0,2035,2036,
        5,61,0,0,2036,430,1,0,0,0,2037,2038,5,44,0,0,2038,432,1,0,0,0,2039,
        2040,5,46,0,0,2040,434,1,0,0,0,2041,2042,5,40,0,0,2042,436,1,0,0,
        0,2043,2044,5,41,0,0,2044,438,1,0,0,0,2045,2046,5,91,0,0,2046,440,
        1,0,0,0,2047,2048,5,93,0,0,2048,442,1,0,0,0,2049,2050,5,59,0,0,2050,
        444,1,0,0,0,2051,2052,5,45,0,0,2052,2053,5,45,0,0,2053,2057,1,0,
        0,0,2054,2056,8,33,0,0,2055,2054,1,0,0,0,2056,2059,1,0,0,0,2057,
        2055,1,0,0,0,2057,2058,1,0,0,0,2058,2060,1,0,0,0,2059,2057,1,0,0,
        0,2060,2061,6,222,0,0,2061,446,1,0,0,0,2062,2063,5,47,0,0,2063,2064,
        5,42,0,0,2064,2069,1,0,0,0,2065,2068,3,447,223,0,2066,2068,9,0,0,
        0,2067,2065,1,0,0,0,2067,2066,1,0,0,0,2068,2071,1,0,0,0,2069,2070,
        1,0,0,0,2069,2067,1,0,0,0,2070,2072,1,0,0,0,2071,2069,1,0,0,0,2072,
        2073,5,42,0,0,2073,2074,5,47,0,0,2074,2075,1,0,0,0,2075,2076,6,223,
        0,0,2076,448,1,0,0,0,2077,2079,7,34,0,0,2078,2077,1,0,0,0,2079,2080,
        1,0,0,0,2080,2078,1,0,0,0,2080,2081,1,0,0,0,2081,2082,1,0,0,0,2082,
        2083,6,224,0,0,2083,450,1,0,0,0,20,0,1916,1921,1927,1933,1941,1955,
        1967,1971,1977,1980,1982,1992,2000,2002,2014,2057,2067,2069,2080,
        2,6,0,0,1,200,0
    ]

class SqlLexer(Lexer):

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    ADD = 1
    EXTERNAL = 2
    PROCEDURE = 3
    ALL = 4
    FETCH = 5
    PUBLIC = 6
    ALTER = 7
    FILE = 8
    RAISERROR = 9
    AND = 10
    FILLFACTOR = 11
    READ = 12
    ANY = 13
    FOR = 14
    READTEXT = 15
    AS = 16
    FOREIGN = 17
    RECONFIGURE = 18
    ASC = 19
    FREETEXT = 20
    REFERENCES = 21
    AUTHORIZATION = 22
    FREETEXTTABLE = 23
    REPLICATION = 24
    BACKUP = 25
    FROM = 26
    RESTORE = 27
    BEGIN = 28
    FULL = 29
    RESTRICT = 30
    BETWEEN = 31
    FUNCTION = 32
    RETURN = 33
    BREAK = 34
    GOTO = 35
    GO = 36
    REVERT = 37
    BROWSE = 38
    GRANT = 39
    REVOKE = 40
    BULK = 41
    GROUP = 42
    RIGHT = 43
    BY = 44
    HAVING = 45
    ROLLBACK = 46
    CASCADE = 47
    HOLDLOCK = 48
    ROWCOUNT = 49
    CASE = 50
    IDENTITY = 51
    ROWGUIDCOL = 52
    CHECK = 53
    IDENTITY_INSERT = 54
    RULE = 55
    CHECKPOINT = 56
    IDENTITYCOL = 57
    SAVE = 58
    CLOSE = 59
    IF = 60
    SCHEMA = 61
    CLUSTERED = 62
    IN = 63
    SECURITYAUDIT = 64
    COALESCE = 65
    INDEX = 66
    SELECT = 67
    COLLATE = 68
    INNER = 69
    SEMANTICKEYPHRASETABLE = 70
    COLUMN = 71
    INSERT = 72
    SEMANTICSIMILARITYDETAILSTABLE = 73
    COMMIT = 74
    INTERSECT = 75
    SEMANTICSIMILARITYTABLE = 76
    COMPUTE = 77
    INTO = 78
    SESSION_USER = 79
    CONSTRAINT = 80
    IS = 81
    SET = 82
    CONTAINS = 83
    JOIN = 84
    SETUSER = 85
    CONTAINSTABLE = 86
    KEY = 87
    SHUTDOWN = 88
    CONTINUE = 89
    KILL = 90
    SOME = 91
    CONVERT = 92
    LEFT = 93
    STATISTICS = 94
    CREATE = 95
    LIKE = 96
    SYSTEM_USER = 97
    CROSS = 98
    LINENO = 99
    TABLE = 100
    CURRENT = 101
    LOAD = 102
    TABLESAMPLE = 103
    CURRENT_DATE = 104
    MERGE = 105
    TEXTSIZE = 106
    CURRENT_TIME = 107
    NATIONAL = 108
    THEN = 109
    CURRENT_TIMESTAMP = 110
    NOCHECK = 111
    TO = 112
    CURRENT_USER = 113
    NONCLUSTERED = 114
    TOP = 115
    CURSOR = 116
    NOT = 117
    TRAN = 118
    DATABASE = 119
    NULL = 120
    TRANSACTION = 121
    DBCC = 122
    NULLIF = 123
    TRIGGER = 124
    DEALLOCATE = 125
    OF = 126
    TRUNCATE = 127
    DECLARE = 128
    OFF = 129
    TRY_CONVERT = 130
    DEFAULT = 131
    OFFSETS = 132
    TSEQUAL = 133
    DELETE = 134
    ON = 135
    UNION = 136
    DENY = 137
    OPEN = 138
    UNIQUE = 139
    DESC = 140
    OPENDATASOURCE = 141
    UPDATE = 142
    DISK = 143
    OPENQUERY = 144
    UPDATETEXT = 145
    DISTINCT = 146
    OPENROWSET = 147
    USE = 148
    DISTRIBUTED = 149
    OPENXML = 150
    USER = 151
    DOUBLE = 152
    OPTION = 153
    VALUES = 154
    DROP = 155
    OR = 156
    VARYING = 157
    DUMP = 158
    ORDER = 159
    VIEW = 160
    ELSE = 161
    OUTER = 162
    WAITFOR = 163
    END = 164
    OVER = 165
    WHEN = 166
    ERRLVL = 167
    PERCENT = 168
    WHERE = 169
    ESCAPE = 170
    PIVOT = 171
    WHILE = 172
    EXCEPT = 173
    PLAN = 174
    WITH = 175
    EXEC = 176
    PRECISION = 177
    WRITETEXT = 178
    EXECUTE = 179
    PRIMARY = 180
    INT = 181
    NVARCHAR = 182
    VARCHAR = 183
    MAX = 184
    MIN = 185
    AVG = 186
    SUM = 187
    COUNT = 188
    TRY = 189
    CATCH = 190
    EXISTS = 191
    INT_LITERAL = 192
    FLOAT_LITERAL = 193
    HEX_LITERAL = 194
    BIT_LITERAL = 195
    TRUE_LITERAL = 196
    FALSE_LITERAL = 197
    STRING_LITERAL = 198
    BRACKET_IDENTIFIER = 199
    IDENTIFIER = 200
    USER_VAR = 201
    EQ = 202
    NEQ = 203
    GT = 204
    LT = 205
    GTE = 206
    LTE = 207
    PLUS = 208
    MINUS = 209
    STAR = 210
    SLASH = 211
    PLUS_EQ = 212
    COMMA = 213
    DOT = 214
    LPAREN = 215
    RPAREN = 216
    SPAREN = 217
    ZPAREN = 218
    SEMI = 219
    LINE_COMMENT = 220
    COMMENT = 221
    WS = 222

    channelNames = [ u"DEFAULT_TOKEN_CHANNEL", u"HIDDEN" ]

    modeNames = [ "DEFAULT_MODE" ]

    literalNames = [ "<INVALID>",
            "'ADD'", "'EXTERNAL'", "'PROCEDURE'", "'ALL'", "'FETCH'", "'PUBLIC'", 
            "'ALTER'", "'FILE'", "'RAISERROR'", "'AND'", "'FILLFACTOR'", 
            "'READ'", "'ANY'", "'FOR'", "'READTEXT'", "'AS'", "'FOREIGN'", 
            "'RECONFIGURE'", "'ASC'", "'FREETEXT'", "'REFERENCES'", "'AUTHORIZATION'", 
            "'FREETEXTTABLE'", "'REPLICATION'", "'BACKUP'", "'FROM'", "'RESTORE'", 
            "'BEGIN'", "'FULL'", "'RESTRICT'", "'BETWEEN'", "'FUNCTION'", 
            "'RETURN'", "'BREAK'", "'GOTO'", "'GO'", "'REVERT'", "'BROWSE'", 
            "'GRANT'", "'REVOKE'", "'BULK'", "'GROUP'", "'RIGHT'", "'BY'", 
            "'HAVING'", "'ROLLBACK'", "'CASCADE'", "'HOLDLOCK'", "'ROWCOUNT'", 
            "'CASE'", "'IDENTITY'", "'ROWGUIDCOL'", "'CHECK'", "'IDENTITY_INSERT'", 
            "'RULE'", "'CHECKPOINT'", "'IDENTITYCOL'", "'SAVE'", "'CLOSE'", 
            "'IF'", "'SCHEMA'", "'CLUSTERED'", "'IN'", "'SECURITYAUDIT'", 
            "'COALESCE'", "'INDEX'", "'SELECT'", "'COLLATE'", "'INNER'", 
            "'SEMANTICKEYPHRASETABLE'", "'COLUMN'", "'INSERT'", "'SEMANTICSIMILARITYDETAILSTABLE'", 
            "'COMMIT'", "'INTERSECT'", "'SEMANTICSIMILARITYTABLE'", "'COMPUTE'", 
            "'INTO'", "'SESSION_USER'", "'CONSTRAINT'", "'IS'", "'SET'", 
            "'CONTAINS'", "'JOIN'", "'SETUSER'", "'CONTAINSTABLE'", "'KEY'", 
            "'SHUTDOWN'", "'CONTINUE'", "'KILL'", "'SOME'", "'CONVERT'", 
            "'LEFT'", "'STATISTICS'", "'CREATE'", "'LIKE'", "'SYSTEM_USER'", 
            "'CROSS'", "'LINENO'", "'TABLE'", "'CURRENT'", "'LOAD'", "'TABLESAMPLE'", 
            "'CURRENT_DATE'", "'MERGE'", "'TEXTSIZE'", "'CURRENT_TIME'", 
            "'NATIONAL'", "'THEN'", "'CURRENT_TIMESTAMP'", "'NOCHECK'", 
            "'TO'", "'CURRENT_USER'", "'NONCLUSTERED'", "'TOP'", "'CURSOR'", 
            "'NOT'", "'TRAN'", "'DATABASE'", "'NULL'", "'TRANSACTION'", 
            "'DBCC'", "'NULLIF'", "'TRIGGER'", "'DEALLOCATE'", "'OF'", "'TRUNCATE'", 
            "'DECLARE'", "'OFF'", "'TRY_CONVERT'", "'DEFAULT'", "'OFFSETS'", 
            "'TSEQUAL'", "'DELETE'", "'ON'", "'UNION'", "'DENY'", "'OPEN'", 
            "'UNIQUE'", "'DESC'", "'OPENDATASOURCE'", "'UPDATE'", "'DISK'", 
            "'OPENQUERY'", "'UPDATETEXT'", "'DISTINCT'", "'OPENROWSET'", 
            "'USE'", "'DISTRIBUTED'", "'OPENXML'", "'USER'", "'DOUBLE'", 
            "'OPTION'", "'VALUES'", "'DROP'", "'OR'", "'VARYING'", "'DUMP'", 
            "'ORDER'", "'VIEW'", "'ELSE'", "'OUTER'", "'WAITFOR'", "'END'", 
            "'OVER'", "'WHEN'", "'ERRLVL'", "'PERCENT'", "'WHERE'", "'ESCAPE'", 
            "'PIVOT'", "'WHILE'", "'EXCEPT'", "'PLAN'", "'WITH'", "'EXEC'", 
            "'PRECISION'", "'WRITETEXT'", "'EXECUTE'", "'PRIMARY'", "'INTEGER'", 
            "'NVARCHAR'", "'VARCHAR'", "'MAX'", "'MIN'", "'AVG'", "'SUM'", 
            "'COUNT'", "'TRY'", "'CATCH'", "'EXISTS'", "'TRUE'", "'FALSE'", 
            "'='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", 
            "'+='", "','", "'.'", "'('", "')'", "'['", "']'", "';'" ]

    symbolicNames = [ "<INVALID>",
            "ADD", "EXTERNAL", "PROCEDURE", "ALL", "FETCH", "PUBLIC", "ALTER", 
            "FILE", "RAISERROR", "AND", "FILLFACTOR", "READ", "ANY", "FOR", 
            "READTEXT", "AS", "FOREIGN", "RECONFIGURE", "ASC", "FREETEXT", 
            "REFERENCES", "AUTHORIZATION", "FREETEXTTABLE", "REPLICATION", 
            "BACKUP", "FROM", "RESTORE", "BEGIN", "FULL", "RESTRICT", "BETWEEN", 
            "FUNCTION", "RETURN", "BREAK", "GOTO", "GO", "REVERT", "BROWSE", 
            "GRANT", "REVOKE", "BULK", "GROUP", "RIGHT", "BY", "HAVING", 
            "ROLLBACK", "CASCADE", "HOLDLOCK", "ROWCOUNT", "CASE", "IDENTITY", 
            "ROWGUIDCOL", "CHECK", "IDENTITY_INSERT", "RULE", "CHECKPOINT", 
            "IDENTITYCOL", "SAVE", "CLOSE", "IF", "SCHEMA", "CLUSTERED", 
            "IN", "SECURITYAUDIT", "COALESCE", "INDEX", "SELECT", "COLLATE", 
            "INNER", "SEMANTICKEYPHRASETABLE", "COLUMN", "INSERT", "SEMANTICSIMILARITYDETAILSTABLE", 
            "COMMIT", "INTERSECT", "SEMANTICSIMILARITYTABLE", "COMPUTE", 
            "INTO", "SESSION_USER", "CONSTRAINT", "IS", "SET", "CONTAINS", 
            "JOIN", "SETUSER", "CONTAINSTABLE", "KEY", "SHUTDOWN", "CONTINUE", 
            "KILL", "SOME", "CONVERT", "LEFT", "STATISTICS", "CREATE", "LIKE", 
            "SYSTEM_USER", "CROSS", "LINENO", "TABLE", "CURRENT", "LOAD", 
            "TABLESAMPLE", "CURRENT_DATE", "MERGE", "TEXTSIZE", "CURRENT_TIME", 
            "NATIONAL", "THEN", "CURRENT_TIMESTAMP", "NOCHECK", "TO", "CURRENT_USER", 
            "NONCLUSTERED", "TOP", "CURSOR", "NOT", "TRAN", "DATABASE", 
            "NULL", "TRANSACTION", "DBCC", "NULLIF", "TRIGGER", "DEALLOCATE", 
            "OF", "TRUNCATE", "DECLARE", "OFF", "TRY_CONVERT", "DEFAULT", 
            "OFFSETS", "TSEQUAL", "DELETE", "ON", "UNION", "DENY", "OPEN", 
            "UNIQUE", "DESC", "OPENDATASOURCE", "UPDATE", "DISK", "OPENQUERY", 
            "UPDATETEXT", "DISTINCT", "OPENROWSET", "USE", "DISTRIBUTED", 
            "OPENXML", "USER", "DOUBLE", "OPTION", "VALUES", "DROP", "OR", 
            "VARYING", "DUMP", "ORDER", "VIEW", "ELSE", "OUTER", "WAITFOR", 
            "END", "OVER", "WHEN", "ERRLVL", "PERCENT", "WHERE", "ESCAPE", 
            "PIVOT", "WHILE", "EXCEPT", "PLAN", "WITH", "EXEC", "PRECISION", 
            "WRITETEXT", "EXECUTE", "PRIMARY", "INT", "NVARCHAR", "VARCHAR", 
            "MAX", "MIN", "AVG", "SUM", "COUNT", "TRY", "CATCH", "EXISTS", 
            "INT_LITERAL", "FLOAT_LITERAL", "HEX_LITERAL", "BIT_LITERAL", 
            "TRUE_LITERAL", "FALSE_LITERAL", "STRING_LITERAL", "BRACKET_IDENTIFIER", 
            "IDENTIFIER", "USER_VAR", "EQ", "NEQ", "GT", "LT", "GTE", "LTE", 
            "PLUS", "MINUS", "STAR", "SLASH", "PLUS_EQ", "COMMA", "DOT", 
            "LPAREN", "RPAREN", "SPAREN", "ZPAREN", "SEMI", "LINE_COMMENT", 
            "COMMENT", "WS" ]

    ruleNames = [ "DIGIT", "LETTER", "HEXDIGIT", "ADD", "EXTERNAL", "PROCEDURE", 
                  "ALL", "FETCH", "PUBLIC", "ALTER", "FILE", "RAISERROR", 
                  "AND", "FILLFACTOR", "READ", "ANY", "FOR", "READTEXT", 
                  "AS", "FOREIGN", "RECONFIGURE", "ASC", "FREETEXT", "REFERENCES", 
                  "AUTHORIZATION", "FREETEXTTABLE", "REPLICATION", "BACKUP", 
                  "FROM", "RESTORE", "BEGIN", "FULL", "RESTRICT", "BETWEEN", 
                  "FUNCTION", "RETURN", "BREAK", "GOTO", "GO", "REVERT", 
                  "BROWSE", "GRANT", "REVOKE", "BULK", "GROUP", "RIGHT", 
                  "BY", "HAVING", "ROLLBACK", "CASCADE", "HOLDLOCK", "ROWCOUNT", 
                  "CASE", "IDENTITY", "ROWGUIDCOL", "CHECK", "IDENTITY_INSERT", 
                  "RULE", "CHECKPOINT", "IDENTITYCOL", "SAVE", "CLOSE", 
                  "IF", "SCHEMA", "CLUSTERED", "IN", "SECURITYAUDIT", "COALESCE", 
                  "INDEX", "SELECT", "COLLATE", "INNER", "SEMANTICKEYPHRASETABLE", 
                  "COLUMN", "INSERT", "SEMANTICSIMILARITYDETAILSTABLE", 
                  "COMMIT", "INTERSECT", "SEMANTICSIMILARITYTABLE", "COMPUTE", 
                  "INTO", "SESSION_USER", "CONSTRAINT", "IS", "SET", "CONTAINS", 
                  "JOIN", "SETUSER", "CONTAINSTABLE", "KEY", "SHUTDOWN", 
                  "CONTINUE", "KILL", "SOME", "CONVERT", "LEFT", "STATISTICS", 
                  "CREATE", "LIKE", "SYSTEM_USER", "CROSS", "LINENO", "TABLE", 
                  "CURRENT", "LOAD", "TABLESAMPLE", "CURRENT_DATE", "MERGE", 
                  "TEXTSIZE", "CURRENT_TIME", "NATIONAL", "THEN", "CURRENT_TIMESTAMP", 
                  "NOCHECK", "TO", "CURRENT_USER", "NONCLUSTERED", "TOP", 
                  "CURSOR", "NOT", "TRAN", "DATABASE", "NULL", "TRANSACTION", 
                  "DBCC", "NULLIF", "TRIGGER", "DEALLOCATE", "OF", "TRUNCATE", 
                  "DECLARE", "OFF", "TRY_CONVERT", "DEFAULT", "OFFSETS", 
                  "TSEQUAL", "DELETE", "ON", "UNION", "DENY", "OPEN", "UNIQUE", 
                  "DESC", "OPENDATASOURCE", "UPDATE", "DISK", "OPENQUERY", 
                  "UPDATETEXT", "DISTINCT", "OPENROWSET", "USE", "DISTRIBUTED", 
                  "OPENXML", "USER", "DOUBLE", "OPTION", "VALUES", "DROP", 
                  "OR", "VARYING", "DUMP", "ORDER", "VIEW", "ELSE", "OUTER", 
                  "WAITFOR", "END", "OVER", "WHEN", "ERRLVL", "PERCENT", 
                  "WHERE", "ESCAPE", "PIVOT", "WHILE", "EXCEPT", "PLAN", 
                  "WITH", "EXEC", "PRECISION", "WRITETEXT", "EXECUTE", "PRIMARY", 
                  "INT", "NVARCHAR", "VARCHAR", "MAX", "MIN", "AVG", "SUM", 
                  "COUNT", "TRY", "CATCH", "EXISTS", "INT_LITERAL", "FLOAT_LITERAL", 
                  "HEX_LITERAL", "BIT_LITERAL", "TRUE_LITERAL", "FALSE_LITERAL", 
                  "STRING_LITERAL", "BRACKET_IDENTIFIER", "IDENTIFIER", 
                  "USER_VAR", "EQ", "NEQ", "GT", "LT", "GTE", "LTE", "PLUS", 
                  "MINUS", "STAR", "SLASH", "PLUS_EQ", "COMMA", "DOT", "LPAREN", 
                  "RPAREN", "SPAREN", "ZPAREN", "SEMI", "LINE_COMMENT", 
                  "COMMENT", "WS" ]

    grammarFileName = "SqlLexer.g4"

    def __init__(self, input=None, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.13.2")
        self._interp = LexerATNSimulator(self, self.atn, self.decisionsToDFA, PredictionContextCache())
        self._actions = None
        self._predicates = None


    def action(self, localctx:RuleContext, ruleIndex:int, actionIndex:int):
        if self._actions is None:
            actions = dict()
            actions[200] = self.STRING_LITERAL_action 
            self._actions = actions
        action = self._actions.get(ruleIndex, None)
        if action is not None:
            action(localctx, actionIndex)
        else:
            raise Exception("No registered action for:" + str(ruleIndex))


    def STRING_LITERAL_action(self, localctx:RuleContext , actionIndex:int):
        if actionIndex == 0:

                      import re
                      # replace line-continuation backslashes with space
                      self.text = re.sub(r'\\[ \t]*\r?\n[ \t]*', ' ', self.text)
                  
     



```

---

### <a id="📄-sqlparser-java"></a>📄 `SqlParser.java`

**File Info:**
- **Size**: 187.25 KB
- **Extension**: `.java`
- **Language**: `java`
- **Location**: `SqlParser.java`
- **Relative Path**: `root`
- **Created**: 2026-01-11 06:03:50 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-18 10:21:27 (Asia/Damascus / GMT+03:00)
- **MD5**: `f25bd37e2d3d2087f7b1c1f8a020ff69`
- **SHA256**: `4a9d6315149729778fcef8a03d32eec1fb53501472158f49bc66e199f58db6d3`
- **Encoding**: ASCII

**File code content:**

```java
// Generated from c:/Users/salah/Programming_Tests/Java/Compilrt_Project/SqlParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ADD=1, EXTERNAL=2, PROCEDURE=3, ALL=4, FETCH=5, PUBLIC=6, ALTER=7, FILE=8, 
		RAISERROR=9, AND=10, FILLFACTOR=11, READ=12, ANY=13, FOR=14, READTEXT=15, 
		AS=16, FOREIGN=17, RECONFIGURE=18, ASC=19, FREETEXT=20, REFERENCES=21, 
		AUTHORIZATION=22, FREETEXTTABLE=23, REPLICATION=24, BACKUP=25, FROM=26, 
		RESTORE=27, BEGIN=28, FULL=29, RESTRICT=30, BETWEEN=31, FUNCTION=32, RETURN=33, 
		BREAK=34, GOTO=35, GO=36, REVERT=37, BROWSE=38, GRANT=39, REVOKE=40, BULK=41, 
		GROUP=42, RIGHT=43, BY=44, HAVING=45, ROLLBACK=46, CASCADE=47, HOLDLOCK=48, 
		ROWCOUNT=49, CASE=50, IDENTITY=51, ROWGUIDCOL=52, CHECK=53, IDENTITY_INSERT=54, 
		RULE=55, CHECKPOINT=56, IDENTITYCOL=57, SAVE=58, CLOSE=59, IF=60, SCHEMA=61, 
		CLUSTERED=62, IN=63, SECURITYAUDIT=64, COALESCE=65, INDEX=66, SELECT=67, 
		COLLATE=68, INNER=69, SEMANTICKEYPHRASETABLE=70, COLUMN=71, INSERT=72, 
		SEMANTICSIMILARITYDETAILSTABLE=73, COMMIT=74, INTERSECT=75, SEMANTICSIMILARITYTABLE=76, 
		COMPUTE=77, INTO=78, SESSION_USER=79, CONSTRAINT=80, IS=81, SET=82, CONTAINS=83, 
		JOIN=84, SETUSER=85, CONTAINSTABLE=86, KEY=87, SHUTDOWN=88, CONTINUE=89, 
		KILL=90, SOME=91, CONVERT=92, LEFT=93, STATISTICS=94, CREATE=95, LIKE=96, 
		SYSTEM_USER=97, CROSS=98, LINENO=99, TABLE=100, CURRENT=101, LOAD=102, 
		TABLESAMPLE=103, CURRENT_DATE=104, MERGE=105, TEXTSIZE=106, CURRENT_TIME=107, 
		NATIONAL=108, THEN=109, CURRENT_TIMESTAMP=110, NOCHECK=111, TO=112, CURRENT_USER=113, 
		NONCLUSTERED=114, TOP=115, CURSOR=116, NOT=117, TRAN=118, DATABASE=119, 
		NULL=120, TRANSACTION=121, DBCC=122, NULLIF=123, TRIGGER=124, DEALLOCATE=125, 
		OF=126, TRUNCATE=127, DECLARE=128, OFF=129, TRY_CONVERT=130, DEFAULT=131, 
		OFFSETS=132, TSEQUAL=133, DELETE=134, ON=135, UNION=136, DENY=137, OPEN=138, 
		UNIQUE=139, DESC=140, OPENDATASOURCE=141, UPDATE=142, DISK=143, OPENQUERY=144, 
		UPDATETEXT=145, DISTINCT=146, OPENROWSET=147, USE=148, DISTRIBUTED=149, 
		OPENXML=150, USER=151, DOUBLE=152, OPTION=153, VALUES=154, DROP=155, OR=156, 
		VARYING=157, DUMP=158, ORDER=159, VIEW=160, ELSE=161, OUTER=162, WAITFOR=163, 
		END=164, OVER=165, WHEN=166, ERRLVL=167, PERCENT=168, WHERE=169, ESCAPE=170, 
		PIVOT=171, WHILE=172, EXCEPT=173, PLAN=174, WITH=175, EXEC=176, PRECISION=177, 
		WRITETEXT=178, EXECUTE=179, PRIMARY=180, INT=181, NVARCHAR=182, VARCHAR=183, 
		MAX=184, MIN=185, AVG=186, SUM=187, COUNT=188, TRY=189, CATCH=190, EXISTS=191, 
		INT_LITERAL=192, FLOAT_LITERAL=193, HEX_LITERAL=194, BIT_LITERAL=195, 
		TRUE_LITERAL=196, FALSE_LITERAL=197, STRING_LITERAL=198, BRACKET_IDENTIFIER=199, 
		IDENTIFIER=200, USER_VAR=201, EQ=202, NEQ=203, GT=204, LT=205, GTE=206, 
		LTE=207, PLUS=208, MINUS=209, STAR=210, SLASH=211, PLUS_EQ=212, COMMA=213, 
		DOT=214, LPAREN=215, RPAREN=216, SPAREN=217, ZPAREN=218, SEMI=219, LINE_COMMENT=220, 
		COMMENT=221, WS=222;
	public static final int
		RULE_sqlFile = 0, RULE_sqlStatement = 1, RULE_cteStatement = 2, RULE_cteDefinition = 3, 
		RULE_dmlStatement = 4, RULE_selectStatement = 5, RULE_selectList = 6, 
		RULE_selectElement = 7, RULE_tableSource = 8, RULE_tableName = 9, RULE_joinClause = 10, 
		RULE_joinType = 11, RULE_columnName = 12, RULE_whereClause = 13, RULE_groupByClause = 14, 
		RULE_orderByClause = 15, RULE_orderElement = 16, RULE_searchCondition = 17, 
		RULE_orExpression = 18, RULE_andExpression = 19, RULE_notExpression = 20, 
		RULE_predicate = 21, RULE_comparisonOperator = 22, RULE_expression = 23, 
		RULE_assignmentExpression = 24, RULE_additiveExpression = 25, RULE_multiplicativeExpression = 26, 
		RULE_unaryExpression = 27, RULE_primaryExpression = 28, RULE_caseExpression = 29, 
		RULE_whenClause = 30, RULE_literal = 31, RULE_functionCall = 32, RULE_insertStatement = 33, 
		RULE_updateStatement = 34, RULE_assignment = 35, RULE_deleteStatement = 36, 
		RULE_ddlStatement = 37, RULE_createTableStatement = 38, RULE_columnDefinition = 39, 
		RULE_nullability = 40, RULE_dataType = 41, RULE_typeParams = 42, RULE_dropTableStatement = 43, 
		RULE_alterTableStatement = 44, RULE_alterAction = 45, RULE_cursorStatement = 46, 
		RULE_declareCursor = 47, RULE_openCursor = 48, RULE_fetchCursor = 49, 
		RULE_closeCursor = 50, RULE_blockStatement = 51, RULE_blockContent = 52, 
		RULE_execStatement = 53, RULE_tryCatchStatement = 54, RULE_ifStatement = 55, 
		RULE_declareStatement = 56, RULE_setStatement = 57, RULE_havingClause = 58, 
		RULE_useDatabaseStatement = 59, RULE_truncateTableStatement = 60;
	private static String[] makeRuleNames() {
		return new String[] {
			"sqlFile", "sqlStatement", "cteStatement", "cteDefinition", "dmlStatement", 
			"selectStatement", "selectList", "selectElement", "tableSource", "tableName", 
			"joinClause", "joinType", "columnName", "whereClause", "groupByClause", 
			"orderByClause", "orderElement", "searchCondition", "orExpression", "andExpression", 
			"notExpression", "predicate", "comparisonOperator", "expression", "assignmentExpression", 
			"additiveExpression", "multiplicativeExpression", "unaryExpression", 
			"primaryExpression", "caseExpression", "whenClause", "literal", "functionCall", 
			"insertStatement", "updateStatement", "assignment", "deleteStatement", 
			"ddlStatement", "createTableStatement", "columnDefinition", "nullability", 
			"dataType", "typeParams", "dropTableStatement", "alterTableStatement", 
			"alterAction", "cursorStatement", "declareCursor", "openCursor", "fetchCursor", 
			"closeCursor", "blockStatement", "blockContent", "execStatement", "tryCatchStatement", 
			"ifStatement", "declareStatement", "setStatement", "havingClause", "useDatabaseStatement", 
			"truncateTableStatement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ADD'", "'EXTERNAL'", "'PROCEDURE'", "'ALL'", "'FETCH'", "'PUBLIC'", 
			"'ALTER'", "'FILE'", "'RAISERROR'", "'AND'", "'FILLFACTOR'", "'READ'", 
			"'ANY'", "'FOR'", "'READTEXT'", "'AS'", "'FOREIGN'", "'RECONFIGURE'", 
			"'ASC'", "'FREETEXT'", "'REFERENCES'", "'AUTHORIZATION'", "'FREETEXTTABLE'", 
			"'REPLICATION'", "'BACKUP'", "'FROM'", "'RESTORE'", "'BEGIN'", "'FULL'", 
			"'RESTRICT'", "'BETWEEN'", "'FUNCTION'", "'RETURN'", "'BREAK'", "'GOTO'", 
			"'GO'", "'REVERT'", "'BROWSE'", "'GRANT'", "'REVOKE'", "'BULK'", "'GROUP'", 
			"'RIGHT'", "'BY'", "'HAVING'", "'ROLLBACK'", "'CASCADE'", "'HOLDLOCK'", 
			"'ROWCOUNT'", "'CASE'", "'IDENTITY'", "'ROWGUIDCOL'", "'CHECK'", "'IDENTITY_INSERT'", 
			"'RULE'", "'CHECKPOINT'", "'IDENTITYCOL'", "'SAVE'", "'CLOSE'", "'IF'", 
			"'SCHEMA'", "'CLUSTERED'", "'IN'", "'SECURITYAUDIT'", "'COALESCE'", "'INDEX'", 
			"'SELECT'", "'COLLATE'", "'INNER'", "'SEMANTICKEYPHRASETABLE'", "'COLUMN'", 
			"'INSERT'", "'SEMANTICSIMILARITYDETAILSTABLE'", "'COMMIT'", "'INTERSECT'", 
			"'SEMANTICSIMILARITYTABLE'", "'COMPUTE'", "'INTO'", "'SESSION_USER'", 
			"'CONSTRAINT'", "'IS'", "'SET'", "'CONTAINS'", "'JOIN'", "'SETUSER'", 
			"'CONTAINSTABLE'", "'KEY'", "'SHUTDOWN'", "'CONTINUE'", "'KILL'", "'SOME'", 
			"'CONVERT'", "'LEFT'", "'STATISTICS'", "'CREATE'", "'LIKE'", "'SYSTEM_USER'", 
			"'CROSS'", "'LINENO'", "'TABLE'", "'CURRENT'", "'LOAD'", "'TABLESAMPLE'", 
			"'CURRENT_DATE'", "'MERGE'", "'TEXTSIZE'", "'CURRENT_TIME'", "'NATIONAL'", 
			"'THEN'", "'CURRENT_TIMESTAMP'", "'NOCHECK'", "'TO'", "'CURRENT_USER'", 
			"'NONCLUSTERED'", "'TOP'", "'CURSOR'", "'NOT'", "'TRAN'", "'DATABASE'", 
			"'NULL'", "'TRANSACTION'", "'DBCC'", "'NULLIF'", "'TRIGGER'", "'DEALLOCATE'", 
			"'OF'", "'TRUNCATE'", "'DECLARE'", "'OFF'", "'TRY_CONVERT'", "'DEFAULT'", 
			"'OFFSETS'", "'TSEQUAL'", "'DELETE'", "'ON'", "'UNION'", "'DENY'", "'OPEN'", 
			"'UNIQUE'", "'DESC'", "'OPENDATASOURCE'", "'UPDATE'", "'DISK'", "'OPENQUERY'", 
			"'UPDATETEXT'", "'DISTINCT'", "'OPENROWSET'", "'USE'", "'DISTRIBUTED'", 
			"'OPENXML'", "'USER'", "'DOUBLE'", "'OPTION'", "'VALUES'", "'DROP'", 
			"'OR'", "'VARYING'", "'DUMP'", "'ORDER'", "'VIEW'", "'ELSE'", "'OUTER'", 
			"'WAITFOR'", "'END'", "'OVER'", "'WHEN'", "'ERRLVL'", "'PERCENT'", "'WHERE'", 
			"'ESCAPE'", "'PIVOT'", "'WHILE'", "'EXCEPT'", "'PLAN'", "'WITH'", "'EXEC'", 
			"'PRECISION'", "'WRITETEXT'", "'EXECUTE'", "'PRIMARY'", "'INTEGER'", 
			"'NVARCHAR'", "'VARCHAR'", "'MAX'", "'MIN'", "'AVG'", "'SUM'", "'COUNT'", 
			"'TRY'", "'CATCH'", "'EXISTS'", null, null, null, null, "'TRUE'", "'FALSE'", 
			null, null, null, null, "'='", null, "'>'", "'<'", "'>='", "'<='", "'+'", 
			"'-'", "'*'", "'/'", "'+='", "','", "'.'", "'('", "')'", "'['", "']'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ADD", "EXTERNAL", "PROCEDURE", "ALL", "FETCH", "PUBLIC", "ALTER", 
			"FILE", "RAISERROR", "AND", "FILLFACTOR", "READ", "ANY", "FOR", "READTEXT", 
			"AS", "FOREIGN", "RECONFIGURE", "ASC", "FREETEXT", "REFERENCES", "AUTHORIZATION", 
			"FREETEXTTABLE", "REPLICATION", "BACKUP", "FROM", "RESTORE", "BEGIN", 
			"FULL", "RESTRICT", "BETWEEN", "FUNCTION", "RETURN", "BREAK", "GOTO", 
			"GO", "REVERT", "BROWSE", "GRANT", "REVOKE", "BULK", "GROUP", "RIGHT", 
			"BY", "HAVING", "ROLLBACK", "CASCADE", "HOLDLOCK", "ROWCOUNT", "CASE", 
			"IDENTITY", "ROWGUIDCOL", "CHECK", "IDENTITY_INSERT", "RULE", "CHECKPOINT", 
			"IDENTITYCOL", "SAVE", "CLOSE", "IF", "SCHEMA", "CLUSTERED", "IN", "SECURITYAUDIT", 
			"COALESCE", "INDEX", "SELECT", "COLLATE", "INNER", "SEMANTICKEYPHRASETABLE", 
			"COLUMN", "INSERT", "SEMANTICSIMILARITYDETAILSTABLE", "COMMIT", "INTERSECT", 
			"SEMANTICSIMILARITYTABLE", "COMPUTE", "INTO", "SESSION_USER", "CONSTRAINT", 
			"IS", "SET", "CONTAINS", "JOIN", "SETUSER", "CONTAINSTABLE", "KEY", "SHUTDOWN", 
			"CONTINUE", "KILL", "SOME", "CONVERT", "LEFT", "STATISTICS", "CREATE", 
			"LIKE", "SYSTEM_USER", "CROSS", "LINENO", "TABLE", "CURRENT", "LOAD", 
			"TABLESAMPLE", "CURRENT_DATE", "MERGE", "TEXTSIZE", "CURRENT_TIME", "NATIONAL", 
			"THEN", "CURRENT_TIMESTAMP", "NOCHECK", "TO", "CURRENT_USER", "NONCLUSTERED", 
			"TOP", "CURSOR", "NOT", "TRAN", "DATABASE", "NULL", "TRANSACTION", "DBCC", 
			"NULLIF", "TRIGGER", "DEALLOCATE", "OF", "TRUNCATE", "DECLARE", "OFF", 
			"TRY_CONVERT", "DEFAULT", "OFFSETS", "TSEQUAL", "DELETE", "ON", "UNION", 
			"DENY", "OPEN", "UNIQUE", "DESC", "OPENDATASOURCE", "UPDATE", "DISK", 
			"OPENQUERY", "UPDATETEXT", "DISTINCT", "OPENROWSET", "USE", "DISTRIBUTED", 
			"OPENXML", "USER", "DOUBLE", "OPTION", "VALUES", "DROP", "OR", "VARYING", 
			"DUMP", "ORDER", "VIEW", "ELSE", "OUTER", "WAITFOR", "END", "OVER", "WHEN", 
			"ERRLVL", "PERCENT", "WHERE", "ESCAPE", "PIVOT", "WHILE", "EXCEPT", "PLAN", 
			"WITH", "EXEC", "PRECISION", "WRITETEXT", "EXECUTE", "PRIMARY", "INT", 
			"NVARCHAR", "VARCHAR", "MAX", "MIN", "AVG", "SUM", "COUNT", "TRY", "CATCH", 
			"EXISTS", "INT_LITERAL", "FLOAT_LITERAL", "HEX_LITERAL", "BIT_LITERAL", 
			"TRUE_LITERAL", "FALSE_LITERAL", "STRING_LITERAL", "BRACKET_IDENTIFIER", 
			"IDENTIFIER", "USER_VAR", "EQ", "NEQ", "GT", "LT", "GTE", "LTE", "PLUS", 
			"MINUS", "STAR", "SLASH", "PLUS_EQ", "COMMA", "DOT", "LPAREN", "RPAREN", 
			"SPAREN", "ZPAREN", "SEMI", "LINE_COMMENT", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SqlParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SqlFileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SqlParser.EOF, 0); }
		public List<SqlStatementContext> sqlStatement() {
			return getRuleContexts(SqlStatementContext.class);
		}
		public SqlStatementContext sqlStatement(int i) {
			return getRuleContext(SqlStatementContext.class,i);
		}
		public SqlFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterSqlFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitSqlFile(this);
		}
	}

	public final SqlFileContext sqlFile() throws RecognitionException {
		SqlFileContext _localctx = new SqlFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sqlFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729382257178706080L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 3458764514089009185L) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & 41781443969297L) != 0)) {
				{
				{
				setState(122);
				sqlStatement();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SqlStatementContext extends ParserRuleContext {
		public DmlStatementContext dmlStatement() {
			return getRuleContext(DmlStatementContext.class,0);
		}
		public DdlStatementContext ddlStatement() {
			return getRuleContext(DdlStatementContext.class,0);
		}
		public CursorStatementContext cursorStatement() {
			return getRuleContext(CursorStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public ExecStatementContext execStatement() {
			return getRuleContext(ExecStatementContext.class,0);
		}
		public TryCatchStatementContext tryCatchStatement() {
			return getRuleContext(TryCatchStatementContext.class,0);
		}
		public CteStatementContext cteStatement() {
			return getRuleContext(CteStatementContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SqlParser.SEMI, 0); }
		public SqlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterSqlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitSqlStatement(this);
		}
	}

	public final SqlStatementContext sqlStatement() throws RecognitionException {
		SqlStatementContext _localctx = new SqlStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sqlStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(130);
				cteStatement();
				}
			}

			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(133);
				dmlStatement();
				}
				break;
			case 2:
				{
				setState(134);
				ddlStatement();
				}
				break;
			case 3:
				{
				setState(135);
				cursorStatement();
				}
				break;
			case 4:
				{
				setState(136);
				ifStatement();
				}
				break;
			case 5:
				{
				setState(137);
				blockStatement();
				}
				break;
			case 6:
				{
				setState(138);
				execStatement();
				}
				break;
			case 7:
				{
				setState(139);
				tryCatchStatement();
				}
				break;
			}
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(142);
				match(SEMI);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CteStatementContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(SqlParser.WITH, 0); }
		public List<CteDefinitionContext> cteDefinition() {
			return getRuleContexts(CteDefinitionContext.class);
		}
		public CteDefinitionContext cteDefinition(int i) {
			return getRuleContext(CteDefinitionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public CteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cteStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterCteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitCteStatement(this);
		}
	}

	public final CteStatementContext cteStatement() throws RecognitionException {
		CteStatementContext _localctx = new CteStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cteStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(WITH);
			setState(146);
			cteDefinition();
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(147);
				match(COMMA);
				setState(148);
				cteDefinition();
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CteDefinitionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public TerminalNode LPAREN() { return getToken(SqlParser.LPAREN, 0); }
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SqlParser.RPAREN, 0); }
		public CteDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cteDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterCteDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitCteDefinition(this);
		}
	}

	public final CteDefinitionContext cteDefinition() throws RecognitionException {
		CteDefinitionContext _localctx = new CteDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cteDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(IDENTIFIER);
			setState(155);
			match(AS);
			setState(156);
			match(LPAREN);
			setState(157);
			selectStatement();
			setState(158);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DmlStatementContext extends ParserRuleContext {
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public InsertStatementContext insertStatement() {
			return getRuleContext(InsertStatementContext.class,0);
		}
		public UpdateStatementContext updateStatement() {
			return getRuleContext(UpdateStatementContext.class,0);
		}
		public DeleteStatementContext deleteStatement() {
			return getRuleContext(DeleteStatementContext.class,0);
		}
		public SetStatementContext setStatement() {
			return getRuleContext(SetStatementContext.class,0);
		}
		public DmlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dmlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterDmlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitDmlStatement(this);
		}
	}

	public final DmlStatementContext dmlStatement() throws RecognitionException {
		DmlStatementContext _localctx = new DmlStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dmlStatement);
		try {
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				selectStatement();
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				insertStatement();
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				updateStatement();
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
				deleteStatement();
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 5);
				{
				setState(164);
				setStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectStatementContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(SqlParser.SELECT, 0); }
		public SelectListContext selectList() {
			return getRuleContext(SelectListContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SqlParser.FROM, 0); }
		public TableSourceContext tableSource() {
			return getRuleContext(TableSourceContext.class,0);
		}
		public List<JoinClauseContext> joinClause() {
			return getRuleContexts(JoinClauseContext.class);
		}
		public JoinClauseContext joinClause(int i) {
			return getRuleContext(JoinClauseContext.class,i);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public GroupByClauseContext groupByClause() {
			return getRuleContext(GroupByClauseContext.class,0);
		}
		public HavingClauseContext havingClause() {
			return getRuleContext(HavingClauseContext.class,0);
		}
		public OrderByClauseContext orderByClause() {
			return getRuleContext(OrderByClauseContext.class,0);
		}
		public SelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitSelectStatement(this);
		}
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_selectStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(SELECT);
			setState(168);
			selectList();
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(169);
				match(FROM);
				setState(170);
				tableSource();
				}
			}

			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FULL || _la==RIGHT || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 16809985L) != 0)) {
				{
				{
				setState(173);
				joinClause();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(179);
				whereClause();
				}
			}

			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(182);
				groupByClause();
				}
			}

			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(185);
				havingClause();
				}
			}

			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(188);
				orderByClause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectListContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(SqlParser.STAR, 0); }
		public List<SelectElementContext> selectElement() {
			return getRuleContexts(SelectElementContext.class);
		}
		public SelectElementContext selectElement(int i) {
			return getRuleContext(SelectElementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public SelectListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterSelectList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitSelectList(this);
		}
	}

	public final SelectListContext selectList() throws RecognitionException {
		SelectListContext _localctx = new SelectListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_selectList);
		int _la;
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(STAR);
				}
				break;
			case NULL:
			case MAX:
			case MIN:
			case AVG:
			case SUM:
			case COUNT:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case TRUE_LITERAL:
			case FALSE_LITERAL:
			case STRING_LITERAL:
			case BRACKET_IDENTIFIER:
			case IDENTIFIER:
			case USER_VAR:
			case PLUS:
			case MINUS:
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				selectElement();
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(193);
					match(COMMA);
					setState(194);
					selectElement();
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectElementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SqlParser.STRING_LITERAL, 0); }
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public SelectElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterSelectElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitSelectElement(this);
		}
	}

	public final SelectElementContext selectElement() throws RecognitionException {
		SelectElementContext _localctx = new SelectElementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_selectElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			expression();
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS || _la==STRING_LITERAL || _la==IDENTIFIER) {
				{
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(203);
					match(AS);
					}
				}

				setState(206);
				_la = _input.LA(1);
				if ( !(_la==STRING_LITERAL || _la==IDENTIFIER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableSourceContext extends ParserRuleContext {
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public TableSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterTableSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitTableSource(this);
		}
	}

	public final TableSourceContext tableSource() throws RecognitionException {
		TableSourceContext _localctx = new TableSourceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tableSource);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			tableName();
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS || _la==IDENTIFIER) {
				{
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(210);
					match(AS);
					}
				}

				setState(213);
				match(IDENTIFIER);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableNameContext extends ParserRuleContext {
		public List<TerminalNode> BRACKET_IDENTIFIER() { return getTokens(SqlParser.BRACKET_IDENTIFIER); }
		public TerminalNode BRACKET_IDENTIFIER(int i) {
			return getToken(SqlParser.BRACKET_IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(SqlParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SqlParser.IDENTIFIER, i);
		}
		public List<TerminalNode> DOT() { return getTokens(SqlParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SqlParser.DOT, i);
		}
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitTableName(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tableName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_la = _input.LA(1);
			if ( !(_la==BRACKET_IDENTIFIER || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(217);
				match(DOT);
				setState(218);
				_la = _input.LA(1);
				if ( !(_la==BRACKET_IDENTIFIER || _la==IDENTIFIER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JoinClauseContext extends ParserRuleContext {
		public JoinTypeContext joinType() {
			return getRuleContext(JoinTypeContext.class,0);
		}
		public TerminalNode JOIN() { return getToken(SqlParser.JOIN, 0); }
		public TableSourceContext tableSource() {
			return getRuleContext(TableSourceContext.class,0);
		}
		public TerminalNode ON() { return getToken(SqlParser.ON, 0); }
		public SearchConditionContext searchCondition() {
			return getRuleContext(SearchConditionContext.class,0);
		}
		public JoinClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterJoinClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitJoinClause(this);
		}
	}

	public final JoinClauseContext joinClause() throws RecognitionException {
		JoinClauseContext _localctx = new JoinClauseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_joinClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			joinType();
			setState(225);
			match(JOIN);
			setState(226);
			tableSource();
			setState(227);
			match(ON);
			setState(228);
			searchCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JoinTypeContext extends ParserRuleContext {
		public TerminalNode INNER() { return getToken(SqlParser.INNER, 0); }
		public TerminalNode OUTER() { return getToken(SqlParser.OUTER, 0); }
		public TerminalNode LEFT() { return getToken(SqlParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(SqlParser.RIGHT, 0); }
		public TerminalNode FULL() { return getToken(SqlParser.FULL, 0); }
		public JoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitJoinType(this);
		}
	}

	public final JoinTypeContext joinType() throws RecognitionException {
		JoinTypeContext _localctx = new JoinTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_joinType);
		int _la;
		try {
			setState(247);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(INNER);
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(231);
					match(OUTER);
					}
				}

				}
				break;
			case LEFT:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(LEFT);
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(235);
					match(OUTER);
					}
				}

				}
				break;
			case RIGHT:
				enterOuterAlt(_localctx, 3);
				{
				setState(238);
				match(RIGHT);
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(239);
					match(OUTER);
					}
				}

				}
				break;
			case FULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(242);
				match(FULL);
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(243);
					match(OUTER);
					}
				}

				}
				break;
			case JOIN:
				enterOuterAlt(_localctx, 5);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnNameContext extends ParserRuleContext {
		public List<TerminalNode> BRACKET_IDENTIFIER() { return getTokens(SqlParser.BRACKET_IDENTIFIER); }
		public TerminalNode BRACKET_IDENTIFIER(int i) {
			return getToken(SqlParser.BRACKET_IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(SqlParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SqlParser.IDENTIFIER, i);
		}
		public List<TerminalNode> DOT() { return getTokens(SqlParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SqlParser.DOT, i);
		}
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitColumnName(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_columnName);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_la = _input.LA(1);
			if ( !(_la==BRACKET_IDENTIFIER || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(254);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(250);
					match(DOT);
					setState(251);
					_la = _input.LA(1);
					if ( !(_la==BRACKET_IDENTIFIER || _la==IDENTIFIER) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(256);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SqlParser.WHERE, 0); }
		public SearchConditionContext searchCondition() {
			return getRuleContext(SearchConditionContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitWhereClause(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(WHERE);
			setState(258);
			searchCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GroupByClauseContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(SqlParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(SqlParser.BY, 0); }
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public GroupByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterGroupByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitGroupByClause(this);
		}
	}

	public final GroupByClauseContext groupByClause() throws RecognitionException {
		GroupByClauseContext _localctx = new GroupByClauseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_groupByClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(GROUP);
			setState(261);
			match(BY);
			setState(262);
			columnName();
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(263);
				match(COMMA);
				setState(264);
				columnName();
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OrderByClauseContext extends ParserRuleContext {
		public TerminalNode ORDER() { return getToken(SqlParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SqlParser.BY, 0); }
		public List<OrderElementContext> orderElement() {
			return getRuleContexts(OrderElementContext.class);
		}
		public OrderElementContext orderElement(int i) {
			return getRuleContext(OrderElementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public OrderByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterOrderByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitOrderByClause(this);
		}
	}

	public final OrderByClauseContext orderByClause() throws RecognitionException {
		OrderByClauseContext _localctx = new OrderByClauseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_orderByClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(ORDER);
			setState(271);
			match(BY);
			setState(272);
			orderElement();
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(273);
				match(COMMA);
				setState(274);
				orderElement();
				}
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OrderElementContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode ASC() { return getToken(SqlParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SqlParser.DESC, 0); }
		public OrderElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterOrderElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitOrderElement(this);
		}
	}

	public final OrderElementContext orderElement() throws RecognitionException {
		OrderElementContext _localctx = new OrderElementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_orderElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			columnName();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(281);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SearchConditionContext extends ParserRuleContext {
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public SearchConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searchCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterSearchCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitSearchCondition(this);
		}
	}

	public final SearchConditionContext searchCondition() throws RecognitionException {
		SearchConditionContext _localctx = new SearchConditionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_searchCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			orExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OrExpressionContext extends ParserRuleContext {
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode OR() { return getToken(SqlParser.OR, 0); }
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitOrExpression(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		return orExpression(0);
	}

	private OrExpressionContext orExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, _parentState);
		OrExpressionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_orExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(287);
			andExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(294);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_orExpression);
					setState(289);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(290);
					match(OR);
					setState(291);
					andExpression(0);
					}
					} 
				}
				setState(296);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AndExpressionContext extends ParserRuleContext {
		public NotExpressionContext notExpression() {
			return getRuleContext(NotExpressionContext.class,0);
		}
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public TerminalNode AND() { return getToken(SqlParser.AND, 0); }
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitAndExpression(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		return andExpression(0);
	}

	private AndExpressionContext andExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, _parentState);
		AndExpressionContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_andExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(298);
			notExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(305);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andExpression);
					setState(300);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(301);
					match(AND);
					setState(302);
					notExpression();
					}
					} 
				}
				setState(307);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NotExpressionContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public NotExpressionContext notExpression() {
			return getRuleContext(NotExpressionContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public NotExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitNotExpression(this);
		}
	}

	public final NotExpressionContext notExpression() throws RecognitionException {
		NotExpressionContext _localctx = new NotExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_notExpression);
		try {
			setState(311);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				match(NOT);
				setState(309);
				notExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(SqlParser.LPAREN, 0); }
		public SearchConditionContext searchCondition() {
			return getRuleContext(SearchConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SqlParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public TerminalNode IN() { return getToken(SqlParser.IN, 0); }
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TerminalNode IS() { return getToken(SqlParser.IS, 0); }
		public TerminalNode NULL() { return getToken(SqlParser.NULL, 0); }
		public TerminalNode EXISTS() { return getToken(SqlParser.EXISTS, 0); }
		public TerminalNode BETWEEN() { return getToken(SqlParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(SqlParser.AND, 0); }
		public TerminalNode LIKE() { return getToken(SqlParser.LIKE, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_predicate);
		int _la;
		try {
			setState(375);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				match(LPAREN);
				setState(314);
				searchCondition();
				setState(315);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(317);
				expression();
				setState(318);
				comparisonOperator();
				setState(319);
				expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(321);
				expression();
				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(322);
					match(NOT);
					}
				}

				setState(325);
				match(IN);
				setState(326);
				match(LPAREN);
				setState(336);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NULL:
				case MAX:
				case MIN:
				case AVG:
				case SUM:
				case COUNT:
				case INT_LITERAL:
				case FLOAT_LITERAL:
				case TRUE_LITERAL:
				case FALSE_LITERAL:
				case STRING_LITERAL:
				case BRACKET_IDENTIFIER:
				case IDENTIFIER:
				case USER_VAR:
				case PLUS:
				case MINUS:
				case LPAREN:
					{
					setState(327);
					expression();
					setState(332);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(328);
						match(COMMA);
						setState(329);
						expression();
						}
						}
						setState(334);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case SELECT:
					{
					setState(335);
					selectStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(338);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(340);
				expression();
				setState(341);
				match(IS);
				setState(343);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(342);
					match(NOT);
					}
				}

				setState(345);
				match(NULL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(347);
				match(EXISTS);
				setState(348);
				match(LPAREN);
				setState(349);
				selectStatement();
				setState(350);
				match(RPAREN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(352);
				match(NOT);
				setState(353);
				match(EXISTS);
				setState(354);
				match(LPAREN);
				setState(355);
				selectStatement();
				setState(356);
				match(RPAREN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(358);
				expression();
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(359);
					match(NOT);
					}
				}

				setState(362);
				match(BETWEEN);
				setState(363);
				expression();
				setState(364);
				match(AND);
				setState(365);
				expression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(368);
				expression();
				setState(370);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(369);
					match(NOT);
					}
				}

				setState(372);
				match(LIKE);
				setState(373);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(SqlParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(SqlParser.NEQ, 0); }
		public TerminalNode GT() { return getToken(SqlParser.GT, 0); }
		public TerminalNode GTE() { return getToken(SqlParser.GTE, 0); }
		public TerminalNode LT() { return getToken(SqlParser.LT, 0); }
		public TerminalNode LTE() { return getToken(SqlParser.LTE, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitComparisonOperator(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			_la = _input.LA(1);
			if ( !(((((_la - 202)) & ~0x3f) == 0 && ((1L << (_la - 202)) & 63L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			assignmentExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExpressionContext extends ParserRuleContext {
		public TerminalNode USER_VAR() { return getToken(SqlParser.USER_VAR, 0); }
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SqlParser.EQ, 0); }
		public TerminalNode PLUS_EQ() { return getToken(SqlParser.PLUS_EQ, 0); }
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitAssignmentExpression(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_assignmentExpression);
		int _la;
		try {
			setState(385);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(381);
				match(USER_VAR);
				setState(382);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==PLUS_EQ) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(383);
				additiveExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(384);
				additiveExpression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExpressionContext extends ParserRuleContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(SqlParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SqlParser.MINUS, 0); }
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitAdditiveExpression(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		return additiveExpression(0);
	}

	private AdditiveExpressionContext additiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, _parentState);
		AdditiveExpressionContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(388);
			multiplicativeExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(398);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(396);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(390);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(391);
						match(PLUS);
						setState(392);
						multiplicativeExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(393);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(394);
						match(MINUS);
						setState(395);
						multiplicativeExpression(0);
						}
						break;
					}
					} 
				}
				setState(400);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public TerminalNode STAR() { return getToken(SqlParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(SqlParser.SLASH, 0); }
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitMultiplicativeExpression(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		return multiplicativeExpression(0);
	}

	private MultiplicativeExpressionContext multiplicativeExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, _parentState);
		MultiplicativeExpressionContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_multiplicativeExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(402);
			unaryExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(412);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(410);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(404);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(405);
						match(STAR);
						setState(406);
						unaryExpression();
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(407);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(408);
						match(SLASH);
						setState(409);
						unaryExpression();
						}
						break;
					}
					} 
				}
				setState(414);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpressionContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(SqlParser.PLUS, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(SqlParser.MINUS, 0); }
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitUnaryExpression(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_unaryExpression);
		try {
			setState(420);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(415);
				match(PLUS);
				setState(416);
				unaryExpression();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(417);
				match(MINUS);
				setState(418);
				unaryExpression();
				}
				break;
			case NULL:
			case MAX:
			case MIN:
			case AVG:
			case SUM:
			case COUNT:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case TRUE_LITERAL:
			case FALSE_LITERAL:
			case STRING_LITERAL:
			case BRACKET_IDENTIFIER:
			case IDENTIFIER:
			case USER_VAR:
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(419);
				primaryExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(SqlParser.LPAREN, 0); }
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SqlParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode USER_VAR() { return getToken(SqlParser.USER_VAR, 0); }
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitPrimaryExpression(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_primaryExpression);
		try {
			setState(434);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(422);
				match(LPAREN);
				setState(423);
				selectStatement();
				setState(424);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(426);
				match(LPAREN);
				setState(427);
				expression();
				setState(428);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(430);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(431);
				columnName();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(432);
				literal();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(433);
				match(USER_VAR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseExpressionContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(SqlParser.CASE, 0); }
		public TerminalNode END() { return getToken(SqlParser.END, 0); }
		public List<WhenClauseContext> whenClause() {
			return getRuleContexts(WhenClauseContext.class);
		}
		public WhenClauseContext whenClause(int i) {
			return getRuleContext(WhenClauseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SqlParser.ELSE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CaseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterCaseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitCaseExpression(this);
		}
	}

	public final CaseExpressionContext caseExpression() throws RecognitionException {
		CaseExpressionContext _localctx = new CaseExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_caseExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			match(CASE);
			setState(438); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(437);
				whenClause();
				}
				}
				setState(440); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(444);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(442);
				match(ELSE);
				setState(443);
				expression();
				}
			}

			setState(446);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhenClauseContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(SqlParser.WHEN, 0); }
		public SearchConditionContext searchCondition() {
			return getRuleContext(SearchConditionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(SqlParser.THEN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhenClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterWhenClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitWhenClause(this);
		}
	}

	public final WhenClauseContext whenClause() throws RecognitionException {
		WhenClauseContext _localctx = new WhenClauseContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_whenClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			match(WHEN);
			setState(449);
			searchCondition();
			setState(450);
			match(THEN);
			setState(451);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INT_LITERAL() { return getToken(SqlParser.INT_LITERAL, 0); }
		public TerminalNode FLOAT_LITERAL() { return getToken(SqlParser.FLOAT_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SqlParser.STRING_LITERAL, 0); }
		public TerminalNode TRUE_LITERAL() { return getToken(SqlParser.TRUE_LITERAL, 0); }
		public TerminalNode FALSE_LITERAL() { return getToken(SqlParser.FALSE_LITERAL, 0); }
		public TerminalNode NULL() { return getToken(SqlParser.NULL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			_la = _input.LA(1);
			if ( !(_la==NULL || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & 115L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(SqlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SqlParser.RPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public TerminalNode BRACKET_IDENTIFIER() { return getToken(SqlParser.BRACKET_IDENTIFIER, 0); }
		public TerminalNode MAX() { return getToken(SqlParser.MAX, 0); }
		public TerminalNode AVG() { return getToken(SqlParser.AVG, 0); }
		public TerminalNode COUNT() { return getToken(SqlParser.COUNT, 0); }
		public TerminalNode SUM() { return getToken(SqlParser.SUM, 0); }
		public TerminalNode MIN() { return getToken(SqlParser.MIN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			_la = _input.LA(1);
			if ( !(((((_la - 184)) & ~0x3f) == 0 && ((1L << (_la - 184)) & 98335L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(456);
			match(LPAREN);
			setState(465);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULL || ((((_la - 184)) & ~0x3f) == 0 && ((1L << (_la - 184)) & 2198074143L) != 0)) {
				{
				setState(457);
				expression();
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(458);
					match(COMMA);
					setState(459);
					expression();
					}
					}
					setState(464);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(467);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InsertStatementContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(SqlParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(SqlParser.INTO, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public List<TerminalNode> LPAREN() { return getTokens(SqlParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(SqlParser.LPAREN, i);
		}
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(SqlParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(SqlParser.RPAREN, i);
		}
		public TerminalNode VALUES() { return getToken(SqlParser.VALUES, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public InsertStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterInsertStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitInsertStatement(this);
		}
	}

	public final InsertStatementContext insertStatement() throws RecognitionException {
		InsertStatementContext _localctx = new InsertStatementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_insertStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(INSERT);
			setState(470);
			match(INTO);
			setState(471);
			tableName();
			setState(472);
			match(LPAREN);
			setState(473);
			columnName();
			setState(478);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(474);
				match(COMMA);
				setState(475);
				columnName();
				}
				}
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(481);
			match(RPAREN);
			setState(482);
			match(VALUES);
			{
			setState(483);
			match(LPAREN);
			setState(484);
			literal();
			setState(489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(485);
				match(COMMA);
				setState(486);
				literal();
				}
				}
				setState(491);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(492);
			match(RPAREN);
			}
			setState(508);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(494);
				match(COMMA);
				setState(495);
				match(LPAREN);
				setState(496);
				literal();
				setState(501);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(497);
					match(COMMA);
					setState(498);
					literal();
					}
					}
					setState(503);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(504);
				match(RPAREN);
				}
				}
				setState(510);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UpdateStatementContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(SqlParser.UPDATE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode SET() { return getToken(SqlParser.SET, 0); }
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public UpdateStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterUpdateStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitUpdateStatement(this);
		}
	}

	public final UpdateStatementContext updateStatement() throws RecognitionException {
		UpdateStatementContext _localctx = new UpdateStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_updateStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			match(UPDATE);
			setState(512);
			tableName();
			setState(513);
			match(SET);
			setState(514);
			assignment();
			setState(519);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(515);
				match(COMMA);
				setState(516);
				assignment();
				}
				}
				setState(521);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(523);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(522);
				whereClause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SqlParser.EQ, 0); }
		public TerminalNode PLUS_EQ() { return getToken(SqlParser.PLUS_EQ, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			columnName();
			setState(526);
			_la = _input.LA(1);
			if ( !(_la==EQ || _la==PLUS_EQ) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(527);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeleteStatementContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(SqlParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(SqlParser.FROM, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public DeleteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterDeleteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitDeleteStatement(this);
		}
	}

	public final DeleteStatementContext deleteStatement() throws RecognitionException {
		DeleteStatementContext _localctx = new DeleteStatementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_deleteStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			match(DELETE);
			setState(530);
			match(FROM);
			setState(531);
			tableName();
			setState(533);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(532);
				whereClause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DdlStatementContext extends ParserRuleContext {
		public CreateTableStatementContext createTableStatement() {
			return getRuleContext(CreateTableStatementContext.class,0);
		}
		public DropTableStatementContext dropTableStatement() {
			return getRuleContext(DropTableStatementContext.class,0);
		}
		public AlterTableStatementContext alterTableStatement() {
			return getRuleContext(AlterTableStatementContext.class,0);
		}
		public DeclareStatementContext declareStatement() {
			return getRuleContext(DeclareStatementContext.class,0);
		}
		public UseDatabaseStatementContext useDatabaseStatement() {
			return getRuleContext(UseDatabaseStatementContext.class,0);
		}
		public TruncateTableStatementContext truncateTableStatement() {
			return getRuleContext(TruncateTableStatementContext.class,0);
		}
		public DdlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ddlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterDdlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitDdlStatement(this);
		}
	}

	public final DdlStatementContext ddlStatement() throws RecognitionException {
		DdlStatementContext _localctx = new DdlStatementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_ddlStatement);
		try {
			setState(541);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(535);
				createTableStatement();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(536);
				dropTableStatement();
				}
				break;
			case ALTER:
				enterOuterAlt(_localctx, 3);
				{
				setState(537);
				alterTableStatement();
				}
				break;
			case DECLARE:
				enterOuterAlt(_localctx, 4);
				{
				setState(538);
				declareStatement();
				}
				break;
			case USE:
				enterOuterAlt(_localctx, 5);
				{
				setState(539);
				useDatabaseStatement();
				}
				break;
			case TRUNCATE:
				enterOuterAlt(_localctx, 6);
				{
				setState(540);
				truncateTableStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreateTableStatementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SqlParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(SqlParser.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(SqlParser.LPAREN, 0); }
		public List<ColumnDefinitionContext> columnDefinition() {
			return getRuleContexts(ColumnDefinitionContext.class);
		}
		public ColumnDefinitionContext columnDefinition(int i) {
			return getRuleContext(ColumnDefinitionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(SqlParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public CreateTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterCreateTableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitCreateTableStatement(this);
		}
	}

	public final CreateTableStatementContext createTableStatement() throws RecognitionException {
		CreateTableStatementContext _localctx = new CreateTableStatementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_createTableStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			match(CREATE);
			setState(544);
			match(TABLE);
			setState(545);
			tableName();
			setState(546);
			match(LPAREN);
			setState(547);
			columnDefinition();
			setState(552);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(548);
				match(COMMA);
				setState(549);
				columnDefinition();
				}
				}
				setState(554);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(555);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnDefinitionContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public List<NullabilityContext> nullability() {
			return getRuleContexts(NullabilityContext.class);
		}
		public NullabilityContext nullability(int i) {
			return getRuleContext(NullabilityContext.class,i);
		}
		public ColumnDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterColumnDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitColumnDefinition(this);
		}
	}

	public final ColumnDefinitionContext columnDefinition() throws RecognitionException {
		ColumnDefinitionContext _localctx = new ColumnDefinitionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_columnDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			columnName();
			setState(558);
			dataType();
			setState(562);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTITY || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & -9223372036854775799L) != 0)) {
				{
				{
				setState(559);
				nullability();
				}
				}
				setState(564);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NullabilityContext extends ParserRuleContext {
		public TerminalNode IDENTITY() { return getToken(SqlParser.IDENTITY, 0); }
		public TerminalNode PRIMARY() { return getToken(SqlParser.PRIMARY, 0); }
		public TerminalNode KEY() { return getToken(SqlParser.KEY, 0); }
		public TerminalNode NULL() { return getToken(SqlParser.NULL, 0); }
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public NullabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullability; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterNullability(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitNullability(this);
		}
	}

	public final NullabilityContext nullability() throws RecognitionException {
		NullabilityContext _localctx = new NullabilityContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_nullability);
		try {
			setState(571);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTITY:
				enterOuterAlt(_localctx, 1);
				{
				setState(565);
				match(IDENTITY);
				}
				break;
			case PRIMARY:
				enterOuterAlt(_localctx, 2);
				{
				setState(566);
				match(PRIMARY);
				setState(567);
				match(KEY);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(568);
				match(NULL);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 4);
				{
				setState(569);
				match(NOT);
				setState(570);
				match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataTypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SqlParser.INT, 0); }
		public TerminalNode NVARCHAR() { return getToken(SqlParser.NVARCHAR, 0); }
		public TerminalNode LPAREN() { return getToken(SqlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SqlParser.RPAREN, 0); }
		public TerminalNode VARCHAR() { return getToken(SqlParser.VARCHAR, 0); }
		public TerminalNode BRACKET_IDENTIFIER() { return getToken(SqlParser.BRACKET_IDENTIFIER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public TerminalNode MAX() { return getToken(SqlParser.MAX, 0); }
		public TerminalNode INT_LITERAL() { return getToken(SqlParser.INT_LITERAL, 0); }
		public TypeParamsContext typeParams() {
			return getRuleContext(TypeParamsContext.class,0);
		}
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitDataType(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_dataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(573);
				match(INT);
				}
				break;
			case NVARCHAR:
				{
				setState(574);
				match(NVARCHAR);
				setState(575);
				match(LPAREN);
				setState(576);
				_la = _input.LA(1);
				if ( !(_la==MAX || _la==INT_LITERAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(577);
				match(RPAREN);
				}
				break;
			case VARCHAR:
				{
				setState(578);
				match(VARCHAR);
				setState(579);
				match(LPAREN);
				setState(580);
				_la = _input.LA(1);
				if ( !(_la==MAX || _la==INT_LITERAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(581);
				match(RPAREN);
				}
				break;
			case BRACKET_IDENTIFIER:
				{
				setState(582);
				match(BRACKET_IDENTIFIER);
				}
				break;
			case IDENTIFIER:
				{
				setState(583);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(587);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(586);
				typeParams();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParamsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(SqlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SqlParser.RPAREN, 0); }
		public TerminalNode MAX() { return getToken(SqlParser.MAX, 0); }
		public TerminalNode INT_LITERAL() { return getToken(SqlParser.INT_LITERAL, 0); }
		public TypeParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterTypeParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitTypeParams(this);
		}
	}

	public final TypeParamsContext typeParams() throws RecognitionException {
		TypeParamsContext _localctx = new TypeParamsContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_typeParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			match(LPAREN);
			setState(590);
			_la = _input.LA(1);
			if ( !(_la==MAX || _la==INT_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(591);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DropTableStatementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public TerminalNode TABLE() { return getToken(SqlParser.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public DropTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropTableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterDropTableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitDropTableStatement(this);
		}
	}

	public final DropTableStatementContext dropTableStatement() throws RecognitionException {
		DropTableStatementContext _localctx = new DropTableStatementContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_dropTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			match(DROP);
			setState(594);
			match(TABLE);
			setState(595);
			tableName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AlterTableStatementContext extends ParserRuleContext {
		public TerminalNode ALTER() { return getToken(SqlParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlParser.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public AlterActionContext alterAction() {
			return getRuleContext(AlterActionContext.class,0);
		}
		public AlterTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alterTableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterAlterTableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitAlterTableStatement(this);
		}
	}

	public final AlterTableStatementContext alterTableStatement() throws RecognitionException {
		AlterTableStatementContext _localctx = new AlterTableStatementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_alterTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
			match(ALTER);
			setState(598);
			match(TABLE);
			setState(599);
			tableName();
			setState(600);
			alterAction();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AlterActionContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(SqlParser.ADD, 0); }
		public ColumnDefinitionContext columnDefinition() {
			return getRuleContext(ColumnDefinitionContext.class,0);
		}
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public AlterActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alterAction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterAlterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitAlterAction(this);
		}
	}

	public final AlterActionContext alterAction() throws RecognitionException {
		AlterActionContext _localctx = new AlterActionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_alterAction);
		try {
			setState(606);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(602);
				match(ADD);
				setState(603);
				columnDefinition();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(604);
				match(DROP);
				setState(605);
				columnName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CursorStatementContext extends ParserRuleContext {
		public DeclareCursorContext declareCursor() {
			return getRuleContext(DeclareCursorContext.class,0);
		}
		public OpenCursorContext openCursor() {
			return getRuleContext(OpenCursorContext.class,0);
		}
		public FetchCursorContext fetchCursor() {
			return getRuleContext(FetchCursorContext.class,0);
		}
		public CloseCursorContext closeCursor() {
			return getRuleContext(CloseCursorContext.class,0);
		}
		public CursorStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cursorStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterCursorStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitCursorStatement(this);
		}
	}

	public final CursorStatementContext cursorStatement() throws RecognitionException {
		CursorStatementContext _localctx = new CursorStatementContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_cursorStatement);
		try {
			setState(612);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECLARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(608);
				declareCursor();
				}
				break;
			case OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(609);
				openCursor();
				}
				break;
			case FETCH:
				enterOuterAlt(_localctx, 3);
				{
				setState(610);
				fetchCursor();
				}
				break;
			case CLOSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(611);
				closeCursor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclareCursorContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(SqlParser.DECLARE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public TerminalNode CURSOR() { return getToken(SqlParser.CURSOR, 0); }
		public TerminalNode FOR() { return getToken(SqlParser.FOR, 0); }
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public DeclareCursorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declareCursor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterDeclareCursor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitDeclareCursor(this);
		}
	}

	public final DeclareCursorContext declareCursor() throws RecognitionException {
		DeclareCursorContext _localctx = new DeclareCursorContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_declareCursor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			match(DECLARE);
			setState(615);
			match(IDENTIFIER);
			setState(616);
			match(CURSOR);
			setState(617);
			match(FOR);
			setState(618);
			selectStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OpenCursorContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(SqlParser.OPEN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public OpenCursorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_openCursor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterOpenCursor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitOpenCursor(this);
		}
	}

	public final OpenCursorContext openCursor() throws RecognitionException {
		OpenCursorContext _localctx = new OpenCursorContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_openCursor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			match(OPEN);
			setState(621);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FetchCursorContext extends ParserRuleContext {
		public TerminalNode FETCH() { return getToken(SqlParser.FETCH, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public FetchCursorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fetchCursor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterFetchCursor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitFetchCursor(this);
		}
	}

	public final FetchCursorContext fetchCursor() throws RecognitionException {
		FetchCursorContext _localctx = new FetchCursorContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_fetchCursor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			match(FETCH);
			setState(624);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CloseCursorContext extends ParserRuleContext {
		public TerminalNode CLOSE() { return getToken(SqlParser.CLOSE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public CloseCursorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closeCursor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterCloseCursor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitCloseCursor(this);
		}
	}

	public final CloseCursorContext closeCursor() throws RecognitionException {
		CloseCursorContext _localctx = new CloseCursorContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_closeCursor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
			match(CLOSE);
			setState(627);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(SqlParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(SqlParser.END, 0); }
		public List<BlockContentContext> blockContent() {
			return getRuleContexts(BlockContentContext.class);
		}
		public BlockContentContext blockContent(int i) {
			return getRuleContext(BlockContentContext.class,i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitBlockStatement(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			match(BEGIN);
			setState(633);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729382257178706080L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 3458764514089009185L) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & 41781443969297L) != 0)) {
				{
				{
				setState(630);
				blockContent();
				}
				}
				setState(635);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(636);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContentContext extends ParserRuleContext {
		public SqlStatementContext sqlStatement() {
			return getRuleContext(SqlStatementContext.class,0);
		}
		public TryCatchStatementContext tryCatchStatement() {
			return getRuleContext(TryCatchStatementContext.class,0);
		}
		public BlockContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterBlockContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitBlockContent(this);
		}
	}

	public final BlockContentContext blockContent() throws RecognitionException {
		BlockContentContext _localctx = new BlockContentContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_blockContent);
		try {
			setState(640);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(638);
				sqlStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(639);
				tryCatchStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExecStatementContext extends ParserRuleContext {
		public TerminalNode EXEC() { return getToken(SqlParser.EXEC, 0); }
		public TerminalNode EXECUTE() { return getToken(SqlParser.EXECUTE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public TerminalNode BRACKET_IDENTIFIER() { return getToken(SqlParser.BRACKET_IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(SqlParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public ExecStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_execStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterExecStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitExecStatement(this);
		}
	}

	public final ExecStatementContext execStatement() throws RecognitionException {
		ExecStatementContext _localctx = new ExecStatementContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_execStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(642);
			_la = _input.LA(1);
			if ( !(_la==EXEC || _la==EXECUTE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(643);
			_la = _input.LA(1);
			if ( !(_la==BRACKET_IDENTIFIER || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(652);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULL || ((((_la - 184)) & ~0x3f) == 0 && ((1L << (_la - 184)) & 2198074143L) != 0)) {
				{
				setState(644);
				expression();
				setState(649);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(645);
					match(COMMA);
					setState(646);
					expression();
					}
					}
					setState(651);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(655);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(654);
				match(SEMI);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TryCatchStatementContext extends ParserRuleContext {
		public List<TerminalNode> BEGIN() { return getTokens(SqlParser.BEGIN); }
		public TerminalNode BEGIN(int i) {
			return getToken(SqlParser.BEGIN, i);
		}
		public List<TerminalNode> TRY() { return getTokens(SqlParser.TRY); }
		public TerminalNode TRY(int i) {
			return getToken(SqlParser.TRY, i);
		}
		public List<TerminalNode> END() { return getTokens(SqlParser.END); }
		public TerminalNode END(int i) {
			return getToken(SqlParser.END, i);
		}
		public List<TerminalNode> CATCH() { return getTokens(SqlParser.CATCH); }
		public TerminalNode CATCH(int i) {
			return getToken(SqlParser.CATCH, i);
		}
		public List<BlockContentContext> blockContent() {
			return getRuleContexts(BlockContentContext.class);
		}
		public BlockContentContext blockContent(int i) {
			return getRuleContext(BlockContentContext.class,i);
		}
		public TryCatchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryCatchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterTryCatchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitTryCatchStatement(this);
		}
	}

	public final TryCatchStatementContext tryCatchStatement() throws RecognitionException {
		TryCatchStatementContext _localctx = new TryCatchStatementContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_tryCatchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			match(BEGIN);
			setState(658);
			match(TRY);
			setState(662);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729382257178706080L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 3458764514089009185L) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & 41781443969297L) != 0)) {
				{
				{
				setState(659);
				blockContent();
				}
				}
				setState(664);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(665);
			match(END);
			setState(666);
			match(TRY);
			setState(667);
			match(BEGIN);
			setState(668);
			match(CATCH);
			setState(672);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729382257178706080L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 3458764514089009185L) != 0) || ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & 41781443969297L) != 0)) {
				{
				{
				setState(669);
				blockContent();
				}
				}
				setState(674);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(675);
			match(END);
			setState(676);
			match(CATCH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SqlParser.IF, 0); }
		public SearchConditionContext searchCondition() {
			return getRuleContext(SearchConditionContext.class,0);
		}
		public List<SqlStatementContext> sqlStatement() {
			return getRuleContexts(SqlStatementContext.class);
		}
		public SqlStatementContext sqlStatement(int i) {
			return getRuleContext(SqlStatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SqlParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(678);
			match(IF);
			setState(679);
			searchCondition();
			setState(680);
			sqlStatement();
			setState(683);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(681);
				match(ELSE);
				setState(682);
				sqlStatement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclareStatementContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(SqlParser.DECLARE, 0); }
		public List<TerminalNode> USER_VAR() { return getTokens(SqlParser.USER_VAR); }
		public TerminalNode USER_VAR(int i) {
			return getToken(SqlParser.USER_VAR, i);
		}
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public List<TerminalNode> EQ() { return getTokens(SqlParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(SqlParser.EQ, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public DeclareStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declareStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterDeclareStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitDeclareStatement(this);
		}
	}

	public final DeclareStatementContext declareStatement() throws RecognitionException {
		DeclareStatementContext _localctx = new DeclareStatementContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_declareStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
			match(DECLARE);
			setState(686);
			match(USER_VAR);
			setState(687);
			dataType();
			setState(690);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(688);
				match(EQ);
				setState(689);
				expression();
				}
			}

			setState(701);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(692);
				match(COMMA);
				setState(693);
				match(USER_VAR);
				setState(694);
				dataType();
				setState(697);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQ) {
					{
					setState(695);
					match(EQ);
					setState(696);
					expression();
					}
				}

				}
				}
				setState(703);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SetStatementContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(SqlParser.SET, 0); }
		public List<TerminalNode> USER_VAR() { return getTokens(SqlParser.USER_VAR); }
		public TerminalNode USER_VAR(int i) {
			return getToken(SqlParser.USER_VAR, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> EQ() { return getTokens(SqlParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(SqlParser.EQ, i);
		}
		public List<TerminalNode> PLUS_EQ() { return getTokens(SqlParser.PLUS_EQ); }
		public TerminalNode PLUS_EQ(int i) {
			return getToken(SqlParser.PLUS_EQ, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TerminalNode SEMI() { return getToken(SqlParser.SEMI, 0); }
		public SetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterSetStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitSetStatement(this);
		}
	}

	public final SetStatementContext setStatement() throws RecognitionException {
		SetStatementContext _localctx = new SetStatementContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_setStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(704);
			match(SET);
			setState(705);
			match(USER_VAR);
			setState(706);
			_la = _input.LA(1);
			if ( !(_la==EQ || _la==PLUS_EQ) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(707);
			expression();
			setState(714);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(708);
				match(COMMA);
				setState(709);
				match(USER_VAR);
				setState(710);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==PLUS_EQ) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(711);
				expression();
				}
				}
				setState(716);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(718);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				{
				setState(717);
				match(SEMI);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HavingClauseContext extends ParserRuleContext {
		public TerminalNode HAVING() { return getToken(SqlParser.HAVING, 0); }
		public SearchConditionContext searchCondition() {
			return getRuleContext(SearchConditionContext.class,0);
		}
		public HavingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_havingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterHavingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitHavingClause(this);
		}
	}

	public final HavingClauseContext havingClause() throws RecognitionException {
		HavingClauseContext _localctx = new HavingClauseContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_havingClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(720);
			match(HAVING);
			setState(721);
			searchCondition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UseDatabaseStatementContext extends ParserRuleContext {
		public TerminalNode USE() { return getToken(SqlParser.USE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public UseDatabaseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_useDatabaseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterUseDatabaseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitUseDatabaseStatement(this);
		}
	}

	public final UseDatabaseStatementContext useDatabaseStatement() throws RecognitionException {
		UseDatabaseStatementContext _localctx = new UseDatabaseStatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_useDatabaseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(723);
			match(USE);
			setState(724);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TruncateTableStatementContext extends ParserRuleContext {
		public TerminalNode TRUNCATE() { return getToken(SqlParser.TRUNCATE, 0); }
		public TerminalNode TABLE() { return getToken(SqlParser.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SqlParser.SEMI, 0); }
		public TruncateTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_truncateTableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).enterTruncateTableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlParserListener ) ((SqlParserListener)listener).exitTruncateTableStatement(this);
		}
	}

	public final TruncateTableStatementContext truncateTableStatement() throws RecognitionException {
		TruncateTableStatementContext _localctx = new TruncateTableStatementContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_truncateTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(726);
			match(TRUNCATE);
			setState(727);
			match(TABLE);
			setState(728);
			tableName();
			setState(730);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				{
				setState(729);
				match(SEMI);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 18:
			return orExpression_sempred((OrExpressionContext)_localctx, predIndex);
		case 19:
			return andExpression_sempred((AndExpressionContext)_localctx, predIndex);
		case 25:
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 26:
			return multiplicativeExpression_sempred((MultiplicativeExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean orExpression_sempred(OrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean andExpression_sempred(AndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multiplicativeExpression_sempred(MultiplicativeExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u00de\u02dd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0001\u0000\u0005\u0000|\b\u0000\n\u0000\f\u0000\u007f"+
		"\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0003\u0001\u0084\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u008d\b\u0001\u0001\u0001\u0003\u0001\u0090\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0096"+
		"\b\u0002\n\u0002\f\u0002\u0099\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004\u00a6\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u00ac\b\u0005\u0001\u0005\u0005\u0005"+
		"\u00af\b\u0005\n\u0005\f\u0005\u00b2\t\u0005\u0001\u0005\u0003\u0005\u00b5"+
		"\b\u0005\u0001\u0005\u0003\u0005\u00b8\b\u0005\u0001\u0005\u0003\u0005"+
		"\u00bb\b\u0005\u0001\u0005\u0003\u0005\u00be\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00c4\b\u0006\n\u0006\f\u0006"+
		"\u00c7\t\u0006\u0003\u0006\u00c9\b\u0006\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u00cd\b\u0007\u0001\u0007\u0003\u0007\u00d0\b\u0007\u0001\b\u0001"+
		"\b\u0003\b\u00d4\b\b\u0001\b\u0003\b\u00d7\b\b\u0001\t\u0001\t\u0001\t"+
		"\u0005\t\u00dc\b\t\n\t\f\t\u00df\t\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0003\u000b\u00e9\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00ed\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00f1\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00f5\b\u000b\u0001"+
		"\u000b\u0003\u000b\u00f8\b\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u00fd"+
		"\b\f\n\f\f\f\u0100\t\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u010a\b\u000e\n\u000e"+
		"\f\u000e\u010d\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0005\u000f\u0114\b\u000f\n\u000f\f\u000f\u0117\t\u000f\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u011b\b\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005"+
		"\u0012\u0125\b\u0012\n\u0012\f\u0012\u0128\t\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0130\b\u0013"+
		"\n\u0013\f\u0013\u0133\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u0138\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u0144\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0005\u0015\u014b\b\u0015\n\u0015\f\u0015\u014e\t\u0015\u0001\u0015"+
		"\u0003\u0015\u0151\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u0158\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u0169\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0173\b\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0178\b\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0003\u0018\u0182\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0005\u0019\u018d\b\u0019\n\u0019\f\u0019\u0190\t\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0005\u001a\u019b\b\u001a\n\u001a\f\u001a\u019e\t\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u01a5\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0003\u001c\u01b3\b\u001c\u0001\u001d\u0001\u001d\u0004\u001d"+
		"\u01b7\b\u001d\u000b\u001d\f\u001d\u01b8\u0001\u001d\u0001\u001d\u0003"+
		"\u001d\u01bd\b\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0005 \u01cd\b \n \f \u01d0\t \u0003 \u01d2\b \u0001 "+
		"\u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0005!\u01dd"+
		"\b!\n!\f!\u01e0\t!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0005!\u01e8"+
		"\b!\n!\f!\u01eb\t!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0005"+
		"!\u01f4\b!\n!\f!\u01f7\t!\u0001!\u0001!\u0005!\u01fb\b!\n!\f!\u01fe\t"+
		"!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0005\"\u0206\b\"\n"+
		"\"\f\"\u0209\t\"\u0001\"\u0003\"\u020c\b\"\u0001#\u0001#\u0001#\u0001"+
		"#\u0001$\u0001$\u0001$\u0001$\u0003$\u0216\b$\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0003%\u021e\b%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0005&\u0227\b&\n&\f&\u022a\t&\u0001&\u0001&\u0001\'\u0001\'"+
		"\u0001\'\u0005\'\u0231\b\'\n\'\f\'\u0234\t\'\u0001(\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0003(\u023c\b(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0003)\u0249\b)\u0001)\u0003)\u024c"+
		"\b)\u0001*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0003-\u025f\b-\u0001"+
		".\u0001.\u0001.\u0001.\u0003.\u0265\b.\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u00010\u00010\u00010\u00011\u00011\u00011\u00012\u00012\u0001"+
		"2\u00013\u00013\u00053\u0278\b3\n3\f3\u027b\t3\u00013\u00013\u00014\u0001"+
		"4\u00034\u0281\b4\u00015\u00015\u00015\u00015\u00015\u00055\u0288\b5\n"+
		"5\f5\u028b\t5\u00035\u028d\b5\u00015\u00035\u0290\b5\u00016\u00016\u0001"+
		"6\u00056\u0295\b6\n6\f6\u0298\t6\u00016\u00016\u00016\u00016\u00016\u0005"+
		"6\u029f\b6\n6\f6\u02a2\t6\u00016\u00016\u00016\u00017\u00017\u00017\u0001"+
		"7\u00017\u00037\u02ac\b7\u00018\u00018\u00018\u00018\u00018\u00038\u02b3"+
		"\b8\u00018\u00018\u00018\u00018\u00018\u00038\u02ba\b8\u00058\u02bc\b"+
		"8\n8\f8\u02bf\t8\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"+
		"9\u00059\u02c9\b9\n9\f9\u02cc\t9\u00019\u00039\u02cf\b9\u0001:\u0001:"+
		"\u0001:\u0001;\u0001;\u0001;\u0001<\u0001<\u0001<\u0001<\u0003<\u02db"+
		"\b<\u0001<\u0000\u0004$&24=\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR"+
		"TVXZ\\^`bdfhjlnprtvx\u0000\t\u0002\u0000\u00c6\u00c6\u00c8\u00c8\u0001"+
		"\u0000\u00c7\u00c8\u0002\u0000\u0013\u0013\u008c\u008c\u0001\u0000\u00ca"+
		"\u00cf\u0002\u0000\u00ca\u00ca\u00d4\u00d4\u0003\u0000xx\u00c0\u00c1\u00c4"+
		"\u00c6\u0002\u0000\u00b8\u00bc\u00c7\u00c8\u0002\u0000\u00b8\u00b8\u00c0"+
		"\u00c0\u0002\u0000\u00b0\u00b0\u00b3\u00b3\u030f\u0000}\u0001\u0000\u0000"+
		"\u0000\u0002\u0083\u0001\u0000\u0000\u0000\u0004\u0091\u0001\u0000\u0000"+
		"\u0000\u0006\u009a\u0001\u0000\u0000\u0000\b\u00a5\u0001\u0000\u0000\u0000"+
		"\n\u00a7\u0001\u0000\u0000\u0000\f\u00c8\u0001\u0000\u0000\u0000\u000e"+
		"\u00ca\u0001\u0000\u0000\u0000\u0010\u00d1\u0001\u0000\u0000\u0000\u0012"+
		"\u00d8\u0001\u0000\u0000\u0000\u0014\u00e0\u0001\u0000\u0000\u0000\u0016"+
		"\u00f7\u0001\u0000\u0000\u0000\u0018\u00f9\u0001\u0000\u0000\u0000\u001a"+
		"\u0101\u0001\u0000\u0000\u0000\u001c\u0104\u0001\u0000\u0000\u0000\u001e"+
		"\u010e\u0001\u0000\u0000\u0000 \u0118\u0001\u0000\u0000\u0000\"\u011c"+
		"\u0001\u0000\u0000\u0000$\u011e\u0001\u0000\u0000\u0000&\u0129\u0001\u0000"+
		"\u0000\u0000(\u0137\u0001\u0000\u0000\u0000*\u0177\u0001\u0000\u0000\u0000"+
		",\u0179\u0001\u0000\u0000\u0000.\u017b\u0001\u0000\u0000\u00000\u0181"+
		"\u0001\u0000\u0000\u00002\u0183\u0001\u0000\u0000\u00004\u0191\u0001\u0000"+
		"\u0000\u00006\u01a4\u0001\u0000\u0000\u00008\u01b2\u0001\u0000\u0000\u0000"+
		":\u01b4\u0001\u0000\u0000\u0000<\u01c0\u0001\u0000\u0000\u0000>\u01c5"+
		"\u0001\u0000\u0000\u0000@\u01c7\u0001\u0000\u0000\u0000B\u01d5\u0001\u0000"+
		"\u0000\u0000D\u01ff\u0001\u0000\u0000\u0000F\u020d\u0001\u0000\u0000\u0000"+
		"H\u0211\u0001\u0000\u0000\u0000J\u021d\u0001\u0000\u0000\u0000L\u021f"+
		"\u0001\u0000\u0000\u0000N\u022d\u0001\u0000\u0000\u0000P\u023b\u0001\u0000"+
		"\u0000\u0000R\u0248\u0001\u0000\u0000\u0000T\u024d\u0001\u0000\u0000\u0000"+
		"V\u0251\u0001\u0000\u0000\u0000X\u0255\u0001\u0000\u0000\u0000Z\u025e"+
		"\u0001\u0000\u0000\u0000\\\u0264\u0001\u0000\u0000\u0000^\u0266\u0001"+
		"\u0000\u0000\u0000`\u026c\u0001\u0000\u0000\u0000b\u026f\u0001\u0000\u0000"+
		"\u0000d\u0272\u0001\u0000\u0000\u0000f\u0275\u0001\u0000\u0000\u0000h"+
		"\u0280\u0001\u0000\u0000\u0000j\u0282\u0001\u0000\u0000\u0000l\u0291\u0001"+
		"\u0000\u0000\u0000n\u02a6\u0001\u0000\u0000\u0000p\u02ad\u0001\u0000\u0000"+
		"\u0000r\u02c0\u0001\u0000\u0000\u0000t\u02d0\u0001\u0000\u0000\u0000v"+
		"\u02d3\u0001\u0000\u0000\u0000x\u02d6\u0001\u0000\u0000\u0000z|\u0003"+
		"\u0002\u0001\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000\u0000"+
		"\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080\u0001"+
		"\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u0000"+
		"\u0000\u0001\u0081\u0001\u0001\u0000\u0000\u0000\u0082\u0084\u0003\u0004"+
		"\u0002\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000"+
		"\u0000\u0000\u0084\u008c\u0001\u0000\u0000\u0000\u0085\u008d\u0003\b\u0004"+
		"\u0000\u0086\u008d\u0003J%\u0000\u0087\u008d\u0003\\.\u0000\u0088\u008d"+
		"\u0003n7\u0000\u0089\u008d\u0003f3\u0000\u008a\u008d\u0003j5\u0000\u008b"+
		"\u008d\u0003l6\u0000\u008c\u0085\u0001\u0000\u0000\u0000\u008c\u0086\u0001"+
		"\u0000\u0000\u0000\u008c\u0087\u0001\u0000\u0000\u0000\u008c\u0088\u0001"+
		"\u0000\u0000\u0000\u008c\u0089\u0001\u0000\u0000\u0000\u008c\u008a\u0001"+
		"\u0000\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d\u008f\u0001"+
		"\u0000\u0000\u0000\u008e\u0090\u0005\u00db\u0000\u0000\u008f\u008e\u0001"+
		"\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0003\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0005\u00af\u0000\u0000\u0092\u0097\u0003"+
		"\u0006\u0003\u0000\u0093\u0094\u0005\u00d5\u0000\u0000\u0094\u0096\u0003"+
		"\u0006\u0003\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u0099\u0001"+
		"\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001"+
		"\u0000\u0000\u0000\u0098\u0005\u0001\u0000\u0000\u0000\u0099\u0097\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0005\u00c8\u0000\u0000\u009b\u009c\u0005"+
		"\u0010\u0000\u0000\u009c\u009d\u0005\u00d7\u0000\u0000\u009d\u009e\u0003"+
		"\n\u0005\u0000\u009e\u009f\u0005\u00d8\u0000\u0000\u009f\u0007\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a6\u0003\n\u0005\u0000\u00a1\u00a6\u0003B!\u0000"+
		"\u00a2\u00a6\u0003D\"\u0000\u00a3\u00a6\u0003H$\u0000\u00a4\u00a6\u0003"+
		"r9\u0000\u00a5\u00a0\u0001\u0000\u0000\u0000\u00a5\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\t\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0005C\u0000\u0000\u00a8\u00ab\u0003\f\u0006\u0000\u00a9"+
		"\u00aa\u0005\u001a\u0000\u0000\u00aa\u00ac\u0003\u0010\b\u0000\u00ab\u00a9"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00b0"+
		"\u0001\u0000\u0000\u0000\u00ad\u00af\u0003\u0014\n\u0000\u00ae\u00ad\u0001"+
		"\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b4\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b5\u0003"+
		"\u001a\r\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6\u00b8\u0003\u001c"+
		"\u000e\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000"+
		"\u0000\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000\u00b9\u00bb\u0003t:\u0000"+
		"\u00ba\u00b9\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bd\u0001\u0000\u0000\u0000\u00bc\u00be\u0003\u001e\u000f\u0000"+
		"\u00bd\u00bc\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000"+
		"\u00be\u000b\u0001\u0000\u0000\u0000\u00bf\u00c9\u0005\u00d2\u0000\u0000"+
		"\u00c0\u00c5\u0003\u000e\u0007\u0000\u00c1\u00c2\u0005\u00d5\u0000\u0000"+
		"\u00c2\u00c4\u0003\u000e\u0007\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c9\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00bf\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c0\u0001\u0000\u0000\u0000\u00c9\r\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cf\u0003.\u0017\u0000\u00cb\u00cd\u0005\u0010\u0000\u0000\u00cc\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00ce"+
		"\u0001\u0000\u0000\u0000\u00ce\u00d0\u0007\u0000\u0000\u0000\u00cf\u00cc"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u000f"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d6\u0003\u0012\t\u0000\u00d2\u00d4\u0005"+
		"\u0010\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d7\u0005"+
		"\u00c8\u0000\u0000\u00d6\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d7\u0011\u0001\u0000\u0000\u0000\u00d8\u00dd\u0007"+
		"\u0001\u0000\u0000\u00d9\u00da\u0005\u00d6\u0000\u0000\u00da\u00dc\u0007"+
		"\u0001\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00df\u0001"+
		"\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00de\u0001"+
		"\u0000\u0000\u0000\u00de\u0013\u0001\u0000\u0000\u0000\u00df\u00dd\u0001"+
		"\u0000\u0000\u0000\u00e0\u00e1\u0003\u0016\u000b\u0000\u00e1\u00e2\u0005"+
		"T\u0000\u0000\u00e2\u00e3\u0003\u0010\b\u0000\u00e3\u00e4\u0005\u0087"+
		"\u0000\u0000\u00e4\u00e5\u0003\"\u0011\u0000\u00e5\u0015\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e8\u0005E\u0000\u0000\u00e7\u00e9\u0005\u00a2\u0000\u0000"+
		"\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000"+
		"\u00e9\u00f8\u0001\u0000\u0000\u0000\u00ea\u00ec\u0005]\u0000\u0000\u00eb"+
		"\u00ed\u0005\u00a2\u0000\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ed\u0001\u0000\u0000\u0000\u00ed\u00f8\u0001\u0000\u0000\u0000\u00ee"+
		"\u00f0\u0005+\u0000\u0000\u00ef\u00f1\u0005\u00a2\u0000\u0000\u00f0\u00ef"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f8"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f4\u0005\u001d\u0000\u0000\u00f3\u00f5"+
		"\u0005\u00a2\u0000\u0000\u00f4\u00f3\u0001\u0000\u0000\u0000\u00f4\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f5\u00f8\u0001\u0000\u0000\u0000\u00f6\u00f8"+
		"\u0001\u0000\u0000\u0000\u00f7\u00e6\u0001\u0000\u0000\u0000\u00f7\u00ea"+
		"\u0001\u0000\u0000\u0000\u00f7\u00ee\u0001\u0000\u0000\u0000\u00f7\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f7\u00f6\u0001\u0000\u0000\u0000\u00f8\u0017"+
		"\u0001\u0000\u0000\u0000\u00f9\u00fe\u0007\u0001\u0000\u0000\u00fa\u00fb"+
		"\u0005\u00d6\u0000\u0000\u00fb\u00fd\u0007\u0001\u0000\u0000\u00fc\u00fa"+
		"\u0001\u0000\u0000\u0000\u00fd\u0100\u0001\u0000\u0000\u0000\u00fe\u00fc"+
		"\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0019"+
		"\u0001\u0000\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0101\u0102"+
		"\u0005\u00a9\u0000\u0000\u0102\u0103\u0003\"\u0011\u0000\u0103\u001b\u0001"+
		"\u0000\u0000\u0000\u0104\u0105\u0005*\u0000\u0000\u0105\u0106\u0005,\u0000"+
		"\u0000\u0106\u010b\u0003\u0018\f\u0000\u0107\u0108\u0005\u00d5\u0000\u0000"+
		"\u0108\u010a\u0003\u0018\f\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u010a"+
		"\u010d\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010b"+
		"\u010c\u0001\u0000\u0000\u0000\u010c\u001d\u0001\u0000\u0000\u0000\u010d"+
		"\u010b\u0001\u0000\u0000\u0000\u010e\u010f\u0005\u009f\u0000\u0000\u010f"+
		"\u0110\u0005,\u0000\u0000\u0110\u0115\u0003 \u0010\u0000\u0111\u0112\u0005"+
		"\u00d5\u0000\u0000\u0112\u0114\u0003 \u0010\u0000\u0113\u0111\u0001\u0000"+
		"\u0000\u0000\u0114\u0117\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000"+
		"\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u001f\u0001\u0000"+
		"\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0118\u011a\u0003\u0018"+
		"\f\u0000\u0119\u011b\u0007\u0002\u0000\u0000\u011a\u0119\u0001\u0000\u0000"+
		"\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b!\u0001\u0000\u0000\u0000"+
		"\u011c\u011d\u0003$\u0012\u0000\u011d#\u0001\u0000\u0000\u0000\u011e\u011f"+
		"\u0006\u0012\uffff\uffff\u0000\u011f\u0120\u0003&\u0013\u0000\u0120\u0126"+
		"\u0001\u0000\u0000\u0000\u0121\u0122\n\u0002\u0000\u0000\u0122\u0123\u0005"+
		"\u009c\u0000\u0000\u0123\u0125\u0003&\u0013\u0000\u0124\u0121\u0001\u0000"+
		"\u0000\u0000\u0125\u0128\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000"+
		"\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127%\u0001\u0000\u0000"+
		"\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0129\u012a\u0006\u0013\uffff"+
		"\uffff\u0000\u012a\u012b\u0003(\u0014\u0000\u012b\u0131\u0001\u0000\u0000"+
		"\u0000\u012c\u012d\n\u0002\u0000\u0000\u012d\u012e\u0005\n\u0000\u0000"+
		"\u012e\u0130\u0003(\u0014\u0000\u012f\u012c\u0001\u0000\u0000\u0000\u0130"+
		"\u0133\u0001\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000\u0000\u0131"+
		"\u0132\u0001\u0000\u0000\u0000\u0132\'\u0001\u0000\u0000\u0000\u0133\u0131"+
		"\u0001\u0000\u0000\u0000\u0134\u0135\u0005u\u0000\u0000\u0135\u0138\u0003"+
		"(\u0014\u0000\u0136\u0138\u0003*\u0015\u0000\u0137\u0134\u0001\u0000\u0000"+
		"\u0000\u0137\u0136\u0001\u0000\u0000\u0000\u0138)\u0001\u0000\u0000\u0000"+
		"\u0139\u013a\u0005\u00d7\u0000\u0000\u013a\u013b\u0003\"\u0011\u0000\u013b"+
		"\u013c\u0005\u00d8\u0000\u0000\u013c\u0178\u0001\u0000\u0000\u0000\u013d"+
		"\u013e\u0003.\u0017\u0000\u013e\u013f\u0003,\u0016\u0000\u013f\u0140\u0003"+
		".\u0017\u0000\u0140\u0178\u0001\u0000\u0000\u0000\u0141\u0143\u0003.\u0017"+
		"\u0000\u0142\u0144\u0005u\u0000\u0000\u0143\u0142\u0001\u0000\u0000\u0000"+
		"\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000"+
		"\u0145\u0146\u0005?\u0000\u0000\u0146\u0150\u0005\u00d7\u0000\u0000\u0147"+
		"\u014c\u0003.\u0017\u0000\u0148\u0149\u0005\u00d5\u0000\u0000\u0149\u014b"+
		"\u0003.\u0017\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014b\u014e\u0001"+
		"\u0000\u0000\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001"+
		"\u0000\u0000\u0000\u014d\u0151\u0001\u0000\u0000\u0000\u014e\u014c\u0001"+
		"\u0000\u0000\u0000\u014f\u0151\u0003\n\u0005\u0000\u0150\u0147\u0001\u0000"+
		"\u0000\u0000\u0150\u014f\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000"+
		"\u0000\u0000\u0152\u0153\u0005\u00d8\u0000\u0000\u0153\u0178\u0001\u0000"+
		"\u0000\u0000\u0154\u0155\u0003.\u0017\u0000\u0155\u0157\u0005Q\u0000\u0000"+
		"\u0156\u0158\u0005u\u0000\u0000\u0157\u0156\u0001\u0000\u0000\u0000\u0157"+
		"\u0158\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u0159"+
		"\u015a\u0005x\u0000\u0000\u015a\u0178\u0001\u0000\u0000\u0000\u015b\u015c"+
		"\u0005\u00bf\u0000\u0000\u015c\u015d\u0005\u00d7\u0000\u0000\u015d\u015e"+
		"\u0003\n\u0005\u0000\u015e\u015f\u0005\u00d8\u0000\u0000\u015f\u0178\u0001"+
		"\u0000\u0000\u0000\u0160\u0161\u0005u\u0000\u0000\u0161\u0162\u0005\u00bf"+
		"\u0000\u0000\u0162\u0163\u0005\u00d7\u0000\u0000\u0163\u0164\u0003\n\u0005"+
		"\u0000\u0164\u0165\u0005\u00d8\u0000\u0000\u0165\u0178\u0001\u0000\u0000"+
		"\u0000\u0166\u0168\u0003.\u0017\u0000\u0167\u0169\u0005u\u0000\u0000\u0168"+
		"\u0167\u0001\u0000\u0000\u0000\u0168\u0169\u0001\u0000\u0000\u0000\u0169"+
		"\u016a\u0001\u0000\u0000\u0000\u016a\u016b\u0005\u001f\u0000\u0000\u016b"+
		"\u016c\u0003.\u0017\u0000\u016c\u016d\u0005\n\u0000\u0000\u016d\u016e"+
		"\u0003.\u0017\u0000\u016e\u0178\u0001\u0000\u0000\u0000\u016f\u0178\u0001"+
		"\u0000\u0000\u0000\u0170\u0172\u0003.\u0017\u0000\u0171\u0173\u0005u\u0000"+
		"\u0000\u0172\u0171\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000\u0000"+
		"\u0000\u0173\u0174\u0001\u0000\u0000\u0000\u0174\u0175\u0005`\u0000\u0000"+
		"\u0175\u0176\u0003.\u0017\u0000\u0176\u0178\u0001\u0000\u0000\u0000\u0177"+
		"\u0139\u0001\u0000\u0000\u0000\u0177\u013d\u0001\u0000\u0000\u0000\u0177"+
		"\u0141\u0001\u0000\u0000\u0000\u0177\u0154\u0001\u0000\u0000\u0000\u0177"+
		"\u015b\u0001\u0000\u0000\u0000\u0177\u0160\u0001\u0000\u0000\u0000\u0177"+
		"\u0166\u0001\u0000\u0000\u0000\u0177\u016f\u0001\u0000\u0000\u0000\u0177"+
		"\u0170\u0001\u0000\u0000\u0000\u0178+\u0001\u0000\u0000\u0000\u0179\u017a"+
		"\u0007\u0003\u0000\u0000\u017a-\u0001\u0000\u0000\u0000\u017b\u017c\u0003"+
		"0\u0018\u0000\u017c/\u0001\u0000\u0000\u0000\u017d\u017e\u0005\u00c9\u0000"+
		"\u0000\u017e\u017f\u0007\u0004\u0000\u0000\u017f\u0182\u00032\u0019\u0000"+
		"\u0180\u0182\u00032\u0019\u0000\u0181\u017d\u0001\u0000\u0000\u0000\u0181"+
		"\u0180\u0001\u0000\u0000\u0000\u01821\u0001\u0000\u0000\u0000\u0183\u0184"+
		"\u0006\u0019\uffff\uffff\u0000\u0184\u0185\u00034\u001a\u0000\u0185\u018e"+
		"\u0001\u0000\u0000\u0000\u0186\u0187\n\u0003\u0000\u0000\u0187\u0188\u0005"+
		"\u00d0\u0000\u0000\u0188\u018d\u00034\u001a\u0000\u0189\u018a\n\u0002"+
		"\u0000\u0000\u018a\u018b\u0005\u00d1\u0000\u0000\u018b\u018d\u00034\u001a"+
		"\u0000\u018c\u0186\u0001\u0000\u0000\u0000\u018c\u0189\u0001\u0000\u0000"+
		"\u0000\u018d\u0190\u0001\u0000\u0000\u0000\u018e\u018c\u0001\u0000\u0000"+
		"\u0000\u018e\u018f\u0001\u0000\u0000\u0000\u018f3\u0001\u0000\u0000\u0000"+
		"\u0190\u018e\u0001\u0000\u0000\u0000\u0191\u0192\u0006\u001a\uffff\uffff"+
		"\u0000\u0192\u0193\u00036\u001b\u0000\u0193\u019c\u0001\u0000\u0000\u0000"+
		"\u0194\u0195\n\u0003\u0000\u0000\u0195\u0196\u0005\u00d2\u0000\u0000\u0196"+
		"\u019b\u00036\u001b\u0000\u0197\u0198\n\u0002\u0000\u0000\u0198\u0199"+
		"\u0005\u00d3\u0000\u0000\u0199\u019b\u00036\u001b\u0000\u019a\u0194\u0001"+
		"\u0000\u0000\u0000\u019a\u0197\u0001\u0000\u0000\u0000\u019b\u019e\u0001"+
		"\u0000\u0000\u0000\u019c\u019a\u0001\u0000\u0000\u0000\u019c\u019d\u0001"+
		"\u0000\u0000\u0000\u019d5\u0001\u0000\u0000\u0000\u019e\u019c\u0001\u0000"+
		"\u0000\u0000\u019f\u01a0\u0005\u00d0\u0000\u0000\u01a0\u01a5\u00036\u001b"+
		"\u0000\u01a1\u01a2\u0005\u00d1\u0000\u0000\u01a2\u01a5\u00036\u001b\u0000"+
		"\u01a3\u01a5\u00038\u001c\u0000\u01a4\u019f\u0001\u0000\u0000\u0000\u01a4"+
		"\u01a1\u0001\u0000\u0000\u0000\u01a4\u01a3\u0001\u0000\u0000\u0000\u01a5"+
		"7\u0001\u0000\u0000\u0000\u01a6\u01a7\u0005\u00d7\u0000\u0000\u01a7\u01a8"+
		"\u0003\n\u0005\u0000\u01a8\u01a9\u0005\u00d8\u0000\u0000\u01a9\u01b3\u0001"+
		"\u0000\u0000\u0000\u01aa\u01ab\u0005\u00d7\u0000\u0000\u01ab\u01ac\u0003"+
		".\u0017\u0000\u01ac\u01ad\u0005\u00d8\u0000\u0000\u01ad\u01b3\u0001\u0000"+
		"\u0000\u0000\u01ae\u01b3\u0003@ \u0000\u01af\u01b3\u0003\u0018\f\u0000"+
		"\u01b0\u01b3\u0003>\u001f\u0000\u01b1\u01b3\u0005\u00c9\u0000\u0000\u01b2"+
		"\u01a6\u0001\u0000\u0000\u0000\u01b2\u01aa\u0001\u0000\u0000\u0000\u01b2"+
		"\u01ae\u0001\u0000\u0000\u0000\u01b2\u01af\u0001\u0000\u0000\u0000\u01b2"+
		"\u01b0\u0001\u0000\u0000\u0000\u01b2\u01b1\u0001\u0000\u0000\u0000\u01b3"+
		"9\u0001\u0000\u0000\u0000\u01b4\u01b6\u00052\u0000\u0000\u01b5\u01b7\u0003"+
		"<\u001e\u0000\u01b6\u01b5\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001\u0000"+
		"\u0000\u0000\u01b8\u01b6\u0001\u0000\u0000\u0000\u01b8\u01b9\u0001\u0000"+
		"\u0000\u0000\u01b9\u01bc\u0001\u0000\u0000\u0000\u01ba\u01bb\u0005\u00a1"+
		"\u0000\u0000\u01bb\u01bd\u0003.\u0017\u0000\u01bc\u01ba\u0001\u0000\u0000"+
		"\u0000\u01bc\u01bd\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000\u0000"+
		"\u0000\u01be\u01bf\u0005\u00a4\u0000\u0000\u01bf;\u0001\u0000\u0000\u0000"+
		"\u01c0\u01c1\u0005\u00a6\u0000\u0000\u01c1\u01c2\u0003\"\u0011\u0000\u01c2"+
		"\u01c3\u0005m\u0000\u0000\u01c3\u01c4\u0003.\u0017\u0000\u01c4=\u0001"+
		"\u0000\u0000\u0000\u01c5\u01c6\u0007\u0005\u0000\u0000\u01c6?\u0001\u0000"+
		"\u0000\u0000\u01c7\u01c8\u0007\u0006\u0000\u0000\u01c8\u01d1\u0005\u00d7"+
		"\u0000\u0000\u01c9\u01ce\u0003.\u0017\u0000\u01ca\u01cb\u0005\u00d5\u0000"+
		"\u0000\u01cb\u01cd\u0003.\u0017\u0000\u01cc\u01ca\u0001\u0000\u0000\u0000"+
		"\u01cd\u01d0\u0001\u0000\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000\u0000"+
		"\u01ce\u01cf\u0001\u0000\u0000\u0000\u01cf\u01d2\u0001\u0000\u0000\u0000"+
		"\u01d0\u01ce\u0001\u0000\u0000\u0000\u01d1\u01c9\u0001\u0000\u0000\u0000"+
		"\u01d1\u01d2\u0001\u0000\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000"+
		"\u01d3\u01d4\u0005\u00d8\u0000\u0000\u01d4A\u0001\u0000\u0000\u0000\u01d5"+
		"\u01d6\u0005H\u0000\u0000\u01d6\u01d7\u0005N\u0000\u0000\u01d7\u01d8\u0003"+
		"\u0012\t\u0000\u01d8\u01d9\u0005\u00d7\u0000\u0000\u01d9\u01de\u0003\u0018"+
		"\f\u0000\u01da\u01db\u0005\u00d5\u0000\u0000\u01db\u01dd\u0003\u0018\f"+
		"\u0000\u01dc\u01da\u0001\u0000\u0000\u0000\u01dd\u01e0\u0001\u0000\u0000"+
		"\u0000\u01de\u01dc\u0001\u0000\u0000\u0000\u01de\u01df\u0001\u0000\u0000"+
		"\u0000\u01df\u01e1\u0001\u0000\u0000\u0000\u01e0\u01de\u0001\u0000\u0000"+
		"\u0000\u01e1\u01e2\u0005\u00d8\u0000\u0000\u01e2\u01e3\u0005\u009a\u0000"+
		"\u0000\u01e3\u01e4\u0005\u00d7\u0000\u0000\u01e4\u01e9\u0003>\u001f\u0000"+
		"\u01e5\u01e6\u0005\u00d5\u0000\u0000\u01e6\u01e8\u0003>\u001f\u0000\u01e7"+
		"\u01e5\u0001\u0000\u0000\u0000\u01e8\u01eb\u0001\u0000\u0000\u0000\u01e9"+
		"\u01e7\u0001\u0000\u0000\u0000\u01e9\u01ea\u0001\u0000\u0000\u0000\u01ea"+
		"\u01ec\u0001\u0000\u0000\u0000\u01eb\u01e9\u0001\u0000\u0000\u0000\u01ec"+
		"\u01ed\u0005\u00d8\u0000\u0000\u01ed\u01fc\u0001\u0000\u0000\u0000\u01ee"+
		"\u01ef\u0005\u00d5\u0000\u0000\u01ef\u01f0\u0005\u00d7\u0000\u0000\u01f0"+
		"\u01f5\u0003>\u001f\u0000\u01f1\u01f2\u0005\u00d5\u0000\u0000\u01f2\u01f4"+
		"\u0003>\u001f\u0000\u01f3\u01f1\u0001\u0000\u0000\u0000\u01f4\u01f7\u0001"+
		"\u0000\u0000\u0000\u01f5\u01f3\u0001\u0000\u0000\u0000\u01f5\u01f6\u0001"+
		"\u0000\u0000\u0000\u01f6\u01f8\u0001\u0000\u0000\u0000\u01f7\u01f5\u0001"+
		"\u0000\u0000\u0000\u01f8\u01f9\u0005\u00d8\u0000\u0000\u01f9\u01fb\u0001"+
		"\u0000\u0000\u0000\u01fa\u01ee\u0001\u0000\u0000\u0000\u01fb\u01fe\u0001"+
		"\u0000\u0000\u0000\u01fc\u01fa\u0001\u0000\u0000\u0000\u01fc\u01fd\u0001"+
		"\u0000\u0000\u0000\u01fdC\u0001\u0000\u0000\u0000\u01fe\u01fc\u0001\u0000"+
		"\u0000\u0000\u01ff\u0200\u0005\u008e\u0000\u0000\u0200\u0201\u0003\u0012"+
		"\t\u0000\u0201\u0202\u0005R\u0000\u0000\u0202\u0207\u0003F#\u0000\u0203"+
		"\u0204\u0005\u00d5\u0000\u0000\u0204\u0206\u0003F#\u0000\u0205\u0203\u0001"+
		"\u0000\u0000\u0000\u0206\u0209\u0001\u0000\u0000\u0000\u0207\u0205\u0001"+
		"\u0000\u0000\u0000\u0207\u0208\u0001\u0000\u0000\u0000\u0208\u020b\u0001"+
		"\u0000\u0000\u0000\u0209\u0207\u0001\u0000\u0000\u0000\u020a\u020c\u0003"+
		"\u001a\r\u0000\u020b\u020a\u0001\u0000\u0000\u0000\u020b\u020c\u0001\u0000"+
		"\u0000\u0000\u020cE\u0001\u0000\u0000\u0000\u020d\u020e\u0003\u0018\f"+
		"\u0000\u020e\u020f\u0007\u0004\u0000\u0000\u020f\u0210\u0003.\u0017\u0000"+
		"\u0210G\u0001\u0000\u0000\u0000\u0211\u0212\u0005\u0086\u0000\u0000\u0212"+
		"\u0213\u0005\u001a\u0000\u0000\u0213\u0215\u0003\u0012\t\u0000\u0214\u0216"+
		"\u0003\u001a\r\u0000\u0215\u0214\u0001\u0000\u0000\u0000\u0215\u0216\u0001"+
		"\u0000\u0000\u0000\u0216I\u0001\u0000\u0000\u0000\u0217\u021e\u0003L&"+
		"\u0000\u0218\u021e\u0003V+\u0000\u0219\u021e\u0003X,\u0000\u021a\u021e"+
		"\u0003p8\u0000\u021b\u021e\u0003v;\u0000\u021c\u021e\u0003x<\u0000\u021d"+
		"\u0217\u0001\u0000\u0000\u0000\u021d\u0218\u0001\u0000\u0000\u0000\u021d"+
		"\u0219\u0001\u0000\u0000\u0000\u021d\u021a\u0001\u0000\u0000\u0000\u021d"+
		"\u021b\u0001\u0000\u0000\u0000\u021d\u021c\u0001\u0000\u0000\u0000\u021e"+
		"K\u0001\u0000\u0000\u0000\u021f\u0220\u0005_\u0000\u0000\u0220\u0221\u0005"+
		"d\u0000\u0000\u0221\u0222\u0003\u0012\t\u0000\u0222\u0223\u0005\u00d7"+
		"\u0000\u0000\u0223\u0228\u0003N\'\u0000\u0224\u0225\u0005\u00d5\u0000"+
		"\u0000\u0225\u0227\u0003N\'\u0000\u0226\u0224\u0001\u0000\u0000\u0000"+
		"\u0227\u022a\u0001\u0000\u0000\u0000\u0228\u0226\u0001\u0000\u0000\u0000"+
		"\u0228\u0229\u0001\u0000\u0000\u0000\u0229\u022b\u0001\u0000\u0000\u0000"+
		"\u022a\u0228\u0001\u0000\u0000\u0000\u022b\u022c\u0005\u00d8\u0000\u0000"+
		"\u022cM\u0001\u0000\u0000\u0000\u022d\u022e\u0003\u0018\f\u0000\u022e"+
		"\u0232\u0003R)\u0000\u022f\u0231\u0003P(\u0000\u0230\u022f\u0001\u0000"+
		"\u0000\u0000\u0231\u0234\u0001\u0000\u0000\u0000\u0232\u0230\u0001\u0000"+
		"\u0000\u0000\u0232\u0233\u0001\u0000\u0000\u0000\u0233O\u0001\u0000\u0000"+
		"\u0000\u0234\u0232\u0001\u0000\u0000\u0000\u0235\u023c\u00053\u0000\u0000"+
		"\u0236\u0237\u0005\u00b4\u0000\u0000\u0237\u023c\u0005W\u0000\u0000\u0238"+
		"\u023c\u0005x\u0000\u0000\u0239\u023a\u0005u\u0000\u0000\u023a\u023c\u0005"+
		"x\u0000\u0000\u023b\u0235\u0001\u0000\u0000\u0000\u023b\u0236\u0001\u0000"+
		"\u0000\u0000\u023b\u0238\u0001\u0000\u0000\u0000\u023b\u0239\u0001\u0000"+
		"\u0000\u0000\u023cQ\u0001\u0000\u0000\u0000\u023d\u0249\u0005\u00b5\u0000"+
		"\u0000\u023e\u023f\u0005\u00b6\u0000\u0000\u023f\u0240\u0005\u00d7\u0000"+
		"\u0000\u0240\u0241\u0007\u0007\u0000\u0000\u0241\u0249\u0005\u00d8\u0000"+
		"\u0000\u0242\u0243\u0005\u00b7\u0000\u0000\u0243\u0244\u0005\u00d7\u0000"+
		"\u0000\u0244\u0245\u0007\u0007\u0000\u0000\u0245\u0249\u0005\u00d8\u0000"+
		"\u0000\u0246\u0249\u0005\u00c7\u0000\u0000\u0247\u0249\u0005\u00c8\u0000"+
		"\u0000\u0248\u023d\u0001\u0000\u0000\u0000\u0248\u023e\u0001\u0000\u0000"+
		"\u0000\u0248\u0242\u0001\u0000\u0000\u0000\u0248\u0246\u0001\u0000\u0000"+
		"\u0000\u0248\u0247\u0001\u0000\u0000\u0000\u0249\u024b\u0001\u0000\u0000"+
		"\u0000\u024a\u024c\u0003T*\u0000\u024b\u024a\u0001\u0000\u0000\u0000\u024b"+
		"\u024c\u0001\u0000\u0000\u0000\u024cS\u0001\u0000\u0000\u0000\u024d\u024e"+
		"\u0005\u00d7\u0000\u0000\u024e\u024f\u0007\u0007\u0000\u0000\u024f\u0250"+
		"\u0005\u00d8\u0000\u0000\u0250U\u0001\u0000\u0000\u0000\u0251\u0252\u0005"+
		"\u009b\u0000\u0000\u0252\u0253\u0005d\u0000\u0000\u0253\u0254\u0003\u0012"+
		"\t\u0000\u0254W\u0001\u0000\u0000\u0000\u0255\u0256\u0005\u0007\u0000"+
		"\u0000\u0256\u0257\u0005d\u0000\u0000\u0257\u0258\u0003\u0012\t\u0000"+
		"\u0258\u0259\u0003Z-\u0000\u0259Y\u0001\u0000\u0000\u0000\u025a\u025b"+
		"\u0005\u0001\u0000\u0000\u025b\u025f\u0003N\'\u0000\u025c\u025d\u0005"+
		"\u009b\u0000\u0000\u025d\u025f\u0003\u0018\f\u0000\u025e\u025a\u0001\u0000"+
		"\u0000\u0000\u025e\u025c\u0001\u0000\u0000\u0000\u025f[\u0001\u0000\u0000"+
		"\u0000\u0260\u0265\u0003^/\u0000\u0261\u0265\u0003`0\u0000\u0262\u0265"+
		"\u0003b1\u0000\u0263\u0265\u0003d2\u0000\u0264\u0260\u0001\u0000\u0000"+
		"\u0000\u0264\u0261\u0001\u0000\u0000\u0000\u0264\u0262\u0001\u0000\u0000"+
		"\u0000\u0264\u0263\u0001\u0000\u0000\u0000\u0265]\u0001\u0000\u0000\u0000"+
		"\u0266\u0267\u0005\u0080\u0000\u0000\u0267\u0268\u0005\u00c8\u0000\u0000"+
		"\u0268\u0269\u0005t\u0000\u0000\u0269\u026a\u0005\u000e\u0000\u0000\u026a"+
		"\u026b\u0003\n\u0005\u0000\u026b_\u0001\u0000\u0000\u0000\u026c\u026d"+
		"\u0005\u008a\u0000\u0000\u026d\u026e\u0005\u00c8\u0000\u0000\u026ea\u0001"+
		"\u0000\u0000\u0000\u026f\u0270\u0005\u0005\u0000\u0000\u0270\u0271\u0005"+
		"\u00c8\u0000\u0000\u0271c\u0001\u0000\u0000\u0000\u0272\u0273\u0005;\u0000"+
		"\u0000\u0273\u0274\u0005\u00c8\u0000\u0000\u0274e\u0001\u0000\u0000\u0000"+
		"\u0275\u0279\u0005\u001c\u0000\u0000\u0276\u0278\u0003h4\u0000\u0277\u0276"+
		"\u0001\u0000\u0000\u0000\u0278\u027b\u0001\u0000\u0000\u0000\u0279\u0277"+
		"\u0001\u0000\u0000\u0000\u0279\u027a\u0001\u0000\u0000\u0000\u027a\u027c"+
		"\u0001\u0000\u0000\u0000\u027b\u0279\u0001\u0000\u0000\u0000\u027c\u027d"+
		"\u0005\u00a4\u0000\u0000\u027dg\u0001\u0000\u0000\u0000\u027e\u0281\u0003"+
		"\u0002\u0001\u0000\u027f\u0281\u0003l6\u0000\u0280\u027e\u0001\u0000\u0000"+
		"\u0000\u0280\u027f\u0001\u0000\u0000\u0000\u0281i\u0001\u0000\u0000\u0000"+
		"\u0282\u0283\u0007\b\u0000\u0000\u0283\u028c\u0007\u0001\u0000\u0000\u0284"+
		"\u0289\u0003.\u0017\u0000\u0285\u0286\u0005\u00d5\u0000\u0000\u0286\u0288"+
		"\u0003.\u0017\u0000\u0287\u0285\u0001\u0000\u0000\u0000\u0288\u028b\u0001"+
		"\u0000\u0000\u0000\u0289\u0287\u0001\u0000\u0000\u0000\u0289\u028a\u0001"+
		"\u0000\u0000\u0000\u028a\u028d\u0001\u0000\u0000\u0000\u028b\u0289\u0001"+
		"\u0000\u0000\u0000\u028c\u0284\u0001\u0000\u0000\u0000\u028c\u028d\u0001"+
		"\u0000\u0000\u0000\u028d\u028f\u0001\u0000\u0000\u0000\u028e\u0290\u0005"+
		"\u00db\u0000\u0000\u028f\u028e\u0001\u0000\u0000\u0000\u028f\u0290\u0001"+
		"\u0000\u0000\u0000\u0290k\u0001\u0000\u0000\u0000\u0291\u0292\u0005\u001c"+
		"\u0000\u0000\u0292\u0296\u0005\u00bd\u0000\u0000\u0293\u0295\u0003h4\u0000"+
		"\u0294\u0293\u0001\u0000\u0000\u0000\u0295\u0298\u0001\u0000\u0000\u0000"+
		"\u0296\u0294\u0001\u0000\u0000\u0000\u0296\u0297\u0001\u0000\u0000\u0000"+
		"\u0297\u0299\u0001\u0000\u0000\u0000\u0298\u0296\u0001\u0000\u0000\u0000"+
		"\u0299\u029a\u0005\u00a4\u0000\u0000\u029a\u029b\u0005\u00bd\u0000\u0000"+
		"\u029b\u029c\u0005\u001c\u0000\u0000\u029c\u02a0\u0005\u00be\u0000\u0000"+
		"\u029d\u029f\u0003h4\u0000\u029e\u029d\u0001\u0000\u0000\u0000\u029f\u02a2"+
		"\u0001\u0000\u0000\u0000\u02a0\u029e\u0001\u0000\u0000\u0000\u02a0\u02a1"+
		"\u0001\u0000\u0000\u0000\u02a1\u02a3\u0001\u0000\u0000\u0000\u02a2\u02a0"+
		"\u0001\u0000\u0000\u0000\u02a3\u02a4\u0005\u00a4\u0000\u0000\u02a4\u02a5"+
		"\u0005\u00be\u0000\u0000\u02a5m\u0001\u0000\u0000\u0000\u02a6\u02a7\u0005"+
		"<\u0000\u0000\u02a7\u02a8\u0003\"\u0011\u0000\u02a8\u02ab\u0003\u0002"+
		"\u0001\u0000\u02a9\u02aa\u0005\u00a1\u0000\u0000\u02aa\u02ac\u0003\u0002"+
		"\u0001\u0000\u02ab\u02a9\u0001\u0000\u0000\u0000\u02ab\u02ac\u0001\u0000"+
		"\u0000\u0000\u02aco\u0001\u0000\u0000\u0000\u02ad\u02ae\u0005\u0080\u0000"+
		"\u0000\u02ae\u02af\u0005\u00c9\u0000\u0000\u02af\u02b2\u0003R)\u0000\u02b0"+
		"\u02b1\u0005\u00ca\u0000\u0000\u02b1\u02b3\u0003.\u0017\u0000\u02b2\u02b0"+
		"\u0001\u0000\u0000\u0000\u02b2\u02b3\u0001\u0000\u0000\u0000\u02b3\u02bd"+
		"\u0001\u0000\u0000\u0000\u02b4\u02b5\u0005\u00d5\u0000\u0000\u02b5\u02b6"+
		"\u0005\u00c9\u0000\u0000\u02b6\u02b9\u0003R)\u0000\u02b7\u02b8\u0005\u00ca"+
		"\u0000\u0000\u02b8\u02ba\u0003.\u0017\u0000\u02b9\u02b7\u0001\u0000\u0000"+
		"\u0000\u02b9\u02ba\u0001\u0000\u0000\u0000\u02ba\u02bc\u0001\u0000\u0000"+
		"\u0000\u02bb\u02b4\u0001\u0000\u0000\u0000\u02bc\u02bf\u0001\u0000\u0000"+
		"\u0000\u02bd\u02bb\u0001\u0000\u0000\u0000\u02bd\u02be\u0001\u0000\u0000"+
		"\u0000\u02beq\u0001\u0000\u0000\u0000\u02bf\u02bd\u0001\u0000\u0000\u0000"+
		"\u02c0\u02c1\u0005R\u0000\u0000\u02c1\u02c2\u0005\u00c9\u0000\u0000\u02c2"+
		"\u02c3\u0007\u0004\u0000\u0000\u02c3\u02ca\u0003.\u0017\u0000\u02c4\u02c5"+
		"\u0005\u00d5\u0000\u0000\u02c5\u02c6\u0005\u00c9\u0000\u0000\u02c6\u02c7"+
		"\u0007\u0004\u0000\u0000\u02c7\u02c9\u0003.\u0017\u0000\u02c8\u02c4\u0001"+
		"\u0000\u0000\u0000\u02c9\u02cc\u0001\u0000\u0000\u0000\u02ca\u02c8\u0001"+
		"\u0000\u0000\u0000\u02ca\u02cb\u0001\u0000\u0000\u0000\u02cb\u02ce\u0001"+
		"\u0000\u0000\u0000\u02cc\u02ca\u0001\u0000\u0000\u0000\u02cd\u02cf\u0005"+
		"\u00db\u0000\u0000\u02ce\u02cd\u0001\u0000\u0000\u0000\u02ce\u02cf\u0001"+
		"\u0000\u0000\u0000\u02cfs\u0001\u0000\u0000\u0000\u02d0\u02d1\u0005-\u0000"+
		"\u0000\u02d1\u02d2\u0003\"\u0011\u0000\u02d2u\u0001\u0000\u0000\u0000"+
		"\u02d3\u02d4\u0005\u0094\u0000\u0000\u02d4\u02d5\u0005\u00c8\u0000\u0000"+
		"\u02d5w\u0001\u0000\u0000\u0000\u02d6\u02d7\u0005\u007f\u0000\u0000\u02d7"+
		"\u02d8\u0005d\u0000\u0000\u02d8\u02da\u0003\u0012\t\u0000\u02d9\u02db"+
		"\u0005\u00db\u0000\u0000\u02da\u02d9\u0001\u0000\u0000\u0000\u02da\u02db"+
		"\u0001\u0000\u0000\u0000\u02dby\u0001\u0000\u0000\u0000N}\u0083\u008c"+
		"\u008f\u0097\u00a5\u00ab\u00b0\u00b4\u00b7\u00ba\u00bd\u00c5\u00c8\u00cc"+
		"\u00cf\u00d3\u00d6\u00dd\u00e8\u00ec\u00f0\u00f4\u00f7\u00fe\u010b\u0115"+
		"\u011a\u0126\u0131\u0137\u0143\u014c\u0150\u0157\u0168\u0172\u0177\u0181"+
		"\u018c\u018e\u019a\u019c\u01a4\u01b2\u01b8\u01bc\u01ce\u01d1\u01de\u01e9"+
		"\u01f5\u01fc\u0207\u020b\u0215\u021d\u0228\u0232\u023b\u0248\u024b\u025e"+
		"\u0264\u0279\u0280\u0289\u028c\u028f\u0296\u02a0\u02ab\u02b2\u02b9\u02bd"+
		"\u02ca\u02ce\u02da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
```

---

### <a id="📄-sqlparser-py"></a>📄 `SqlParser.py`

**File Info:**
- **Size**: 194.19 KB
- **Extension**: `.py`
- **Language**: `python`
- **Location**: `SqlParser.py`
- **Relative Path**: `root`
- **Created**: 2026-01-10 14:46:39 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-18 09:51:34 (Asia/Damascus / GMT+03:00)
- **MD5**: `d40c60d64bcda3a338c3f7c81209af06`
- **SHA256**: `fd232c6e5fcb6533df32af42f662b4fccda35105afbc115b7bfe9ef7788670c5`
- **Encoding**: ASCII

**File code content:**

```python
# Generated from SqlParser.g4 by ANTLR 4.13.2
# encoding: utf-8
from antlr4 import *
from io import StringIO
import sys
if sys.version_info[1] > 5:
	from typing import TextIO
else:
	from typing.io import TextIO

def serializedATN():
    return [
        4,1,222,733,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,6,
        7,6,2,7,7,7,2,8,7,8,2,9,7,9,2,10,7,10,2,11,7,11,2,12,7,12,2,13,7,
        13,2,14,7,14,2,15,7,15,2,16,7,16,2,17,7,17,2,18,7,18,2,19,7,19,2,
        20,7,20,2,21,7,21,2,22,7,22,2,23,7,23,2,24,7,24,2,25,7,25,2,26,7,
        26,2,27,7,27,2,28,7,28,2,29,7,29,2,30,7,30,2,31,7,31,2,32,7,32,2,
        33,7,33,2,34,7,34,2,35,7,35,2,36,7,36,2,37,7,37,2,38,7,38,2,39,7,
        39,2,40,7,40,2,41,7,41,2,42,7,42,2,43,7,43,2,44,7,44,2,45,7,45,2,
        46,7,46,2,47,7,47,2,48,7,48,2,49,7,49,2,50,7,50,2,51,7,51,2,52,7,
        52,2,53,7,53,2,54,7,54,2,55,7,55,2,56,7,56,2,57,7,57,2,58,7,58,2,
        59,7,59,2,60,7,60,1,0,5,0,124,8,0,10,0,12,0,127,9,0,1,0,1,0,1,1,
        3,1,132,8,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,1,141,8,1,1,1,3,1,144,
        8,1,1,2,1,2,1,2,1,2,5,2,150,8,2,10,2,12,2,153,9,2,1,3,1,3,1,3,1,
        3,1,3,1,3,1,4,1,4,1,4,1,4,1,4,3,4,166,8,4,1,5,1,5,1,5,1,5,3,5,172,
        8,5,1,5,5,5,175,8,5,10,5,12,5,178,9,5,1,5,3,5,181,8,5,1,5,3,5,184,
        8,5,1,5,3,5,187,8,5,1,5,3,5,190,8,5,1,6,1,6,1,6,1,6,5,6,196,8,6,
        10,6,12,6,199,9,6,3,6,201,8,6,1,7,1,7,3,7,205,8,7,1,7,3,7,208,8,
        7,1,8,1,8,3,8,212,8,8,1,8,3,8,215,8,8,1,9,1,9,1,9,5,9,220,8,9,10,
        9,12,9,223,9,9,1,10,1,10,1,10,1,10,1,10,1,10,1,11,1,11,3,11,233,
        8,11,1,11,1,11,3,11,237,8,11,1,11,1,11,3,11,241,8,11,1,11,1,11,3,
        11,245,8,11,1,11,3,11,248,8,11,1,12,1,12,1,12,5,12,253,8,12,10,12,
        12,12,256,9,12,1,13,1,13,1,13,1,14,1,14,1,14,1,14,1,14,5,14,266,
        8,14,10,14,12,14,269,9,14,1,15,1,15,1,15,1,15,1,15,5,15,276,8,15,
        10,15,12,15,279,9,15,1,16,1,16,3,16,283,8,16,1,17,1,17,1,18,1,18,
        1,18,1,18,1,18,1,18,5,18,293,8,18,10,18,12,18,296,9,18,1,19,1,19,
        1,19,1,19,1,19,1,19,5,19,304,8,19,10,19,12,19,307,9,19,1,20,1,20,
        1,20,3,20,312,8,20,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,
        1,21,3,21,324,8,21,1,21,1,21,1,21,1,21,1,21,5,21,331,8,21,10,21,
        12,21,334,9,21,1,21,3,21,337,8,21,1,21,1,21,1,21,1,21,1,21,3,21,
        344,8,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,
        1,21,1,21,1,21,1,21,3,21,361,8,21,1,21,1,21,1,21,1,21,1,21,1,21,
        1,21,1,21,3,21,371,8,21,1,21,1,21,1,21,3,21,376,8,21,1,22,1,22,1,
        23,1,23,1,24,1,24,1,24,1,24,3,24,386,8,24,1,25,1,25,1,25,1,25,1,
        25,1,25,1,25,1,25,1,25,5,25,397,8,25,10,25,12,25,400,9,25,1,26,1,
        26,1,26,1,26,1,26,1,26,1,26,1,26,1,26,5,26,411,8,26,10,26,12,26,
        414,9,26,1,27,1,27,1,27,1,27,1,27,3,27,421,8,27,1,28,1,28,1,28,1,
        28,1,28,1,28,1,28,1,28,1,28,1,28,1,28,1,28,3,28,435,8,28,1,29,1,
        29,4,29,439,8,29,11,29,12,29,440,1,29,1,29,3,29,445,8,29,1,29,1,
        29,1,30,1,30,1,30,1,30,1,30,1,31,1,31,1,32,1,32,1,32,1,32,1,32,5,
        32,461,8,32,10,32,12,32,464,9,32,3,32,466,8,32,1,32,1,32,1,33,1,
        33,1,33,1,33,1,33,1,33,1,33,5,33,477,8,33,10,33,12,33,480,9,33,1,
        33,1,33,1,33,1,33,1,33,1,33,5,33,488,8,33,10,33,12,33,491,9,33,1,
        33,1,33,1,33,1,33,1,33,1,33,1,33,5,33,500,8,33,10,33,12,33,503,9,
        33,1,33,1,33,5,33,507,8,33,10,33,12,33,510,9,33,1,34,1,34,1,34,1,
        34,1,34,1,34,5,34,518,8,34,10,34,12,34,521,9,34,1,34,3,34,524,8,
        34,1,35,1,35,1,35,1,35,1,36,1,36,1,36,1,36,3,36,534,8,36,1,37,1,
        37,1,37,1,37,1,37,1,37,3,37,542,8,37,1,38,1,38,1,38,1,38,1,38,1,
        38,1,38,5,38,551,8,38,10,38,12,38,554,9,38,1,38,1,38,1,39,1,39,1,
        39,5,39,561,8,39,10,39,12,39,564,9,39,1,40,1,40,1,40,1,40,1,40,1,
        40,3,40,572,8,40,1,41,1,41,1,41,1,41,1,41,1,41,1,41,1,41,1,41,1,
        41,1,41,3,41,585,8,41,1,41,3,41,588,8,41,1,42,1,42,1,42,1,42,1,43,
        1,43,1,43,1,43,1,44,1,44,1,44,1,44,1,44,1,45,1,45,1,45,1,45,3,45,
        607,8,45,1,46,1,46,1,46,1,46,3,46,613,8,46,1,47,1,47,1,47,1,47,1,
        47,1,47,1,48,1,48,1,48,1,49,1,49,1,49,1,50,1,50,1,50,1,51,1,51,5,
        51,632,8,51,10,51,12,51,635,9,51,1,51,1,51,1,52,1,52,3,52,641,8,
        52,1,53,1,53,1,53,1,53,1,53,5,53,648,8,53,10,53,12,53,651,9,53,3,
        53,653,8,53,1,53,3,53,656,8,53,1,54,1,54,1,54,5,54,661,8,54,10,54,
        12,54,664,9,54,1,54,1,54,1,54,1,54,1,54,5,54,671,8,54,10,54,12,54,
        674,9,54,1,54,1,54,1,54,1,55,1,55,1,55,1,55,1,55,3,55,684,8,55,1,
        56,1,56,1,56,1,56,1,56,3,56,691,8,56,1,56,1,56,1,56,1,56,1,56,3,
        56,698,8,56,5,56,700,8,56,10,56,12,56,703,9,56,1,57,1,57,1,57,1,
        57,1,57,1,57,1,57,1,57,5,57,713,8,57,10,57,12,57,716,9,57,1,57,3,
        57,719,8,57,1,58,1,58,1,58,1,59,1,59,1,59,1,60,1,60,1,60,1,60,3,
        60,731,8,60,1,60,0,4,36,38,50,52,61,0,2,4,6,8,10,12,14,16,18,20,
        22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,64,
        66,68,70,72,74,76,78,80,82,84,86,88,90,92,94,96,98,100,102,104,106,
        108,110,112,114,116,118,120,0,9,2,0,198,198,200,200,1,0,199,200,
        2,0,19,19,140,140,1,0,202,207,2,0,202,202,212,212,3,0,120,120,192,
        193,196,198,2,0,184,188,199,200,2,0,184,184,192,192,2,0,176,176,
        179,179,783,0,125,1,0,0,0,2,131,1,0,0,0,4,145,1,0,0,0,6,154,1,0,
        0,0,8,165,1,0,0,0,10,167,1,0,0,0,12,200,1,0,0,0,14,202,1,0,0,0,16,
        209,1,0,0,0,18,216,1,0,0,0,20,224,1,0,0,0,22,247,1,0,0,0,24,249,
        1,0,0,0,26,257,1,0,0,0,28,260,1,0,0,0,30,270,1,0,0,0,32,280,1,0,
        0,0,34,284,1,0,0,0,36,286,1,0,0,0,38,297,1,0,0,0,40,311,1,0,0,0,
        42,375,1,0,0,0,44,377,1,0,0,0,46,379,1,0,0,0,48,385,1,0,0,0,50,387,
        1,0,0,0,52,401,1,0,0,0,54,420,1,0,0,0,56,434,1,0,0,0,58,436,1,0,
        0,0,60,448,1,0,0,0,62,453,1,0,0,0,64,455,1,0,0,0,66,469,1,0,0,0,
        68,511,1,0,0,0,70,525,1,0,0,0,72,529,1,0,0,0,74,541,1,0,0,0,76,543,
        1,0,0,0,78,557,1,0,0,0,80,571,1,0,0,0,82,584,1,0,0,0,84,589,1,0,
        0,0,86,593,1,0,0,0,88,597,1,0,0,0,90,606,1,0,0,0,92,612,1,0,0,0,
        94,614,1,0,0,0,96,620,1,0,0,0,98,623,1,0,0,0,100,626,1,0,0,0,102,
        629,1,0,0,0,104,640,1,0,0,0,106,642,1,0,0,0,108,657,1,0,0,0,110,
        678,1,0,0,0,112,685,1,0,0,0,114,704,1,0,0,0,116,720,1,0,0,0,118,
        723,1,0,0,0,120,726,1,0,0,0,122,124,3,2,1,0,123,122,1,0,0,0,124,
        127,1,0,0,0,125,123,1,0,0,0,125,126,1,0,0,0,126,128,1,0,0,0,127,
        125,1,0,0,0,128,129,5,0,0,1,129,1,1,0,0,0,130,132,3,4,2,0,131,130,
        1,0,0,0,131,132,1,0,0,0,132,140,1,0,0,0,133,141,3,8,4,0,134,141,
        3,74,37,0,135,141,3,92,46,0,136,141,3,110,55,0,137,141,3,102,51,
        0,138,141,3,106,53,0,139,141,3,108,54,0,140,133,1,0,0,0,140,134,
        1,0,0,0,140,135,1,0,0,0,140,136,1,0,0,0,140,137,1,0,0,0,140,138,
        1,0,0,0,140,139,1,0,0,0,141,143,1,0,0,0,142,144,5,219,0,0,143,142,
        1,0,0,0,143,144,1,0,0,0,144,3,1,0,0,0,145,146,5,175,0,0,146,151,
        3,6,3,0,147,148,5,213,0,0,148,150,3,6,3,0,149,147,1,0,0,0,150,153,
        1,0,0,0,151,149,1,0,0,0,151,152,1,0,0,0,152,5,1,0,0,0,153,151,1,
        0,0,0,154,155,5,200,0,0,155,156,5,16,0,0,156,157,5,215,0,0,157,158,
        3,10,5,0,158,159,5,216,0,0,159,7,1,0,0,0,160,166,3,10,5,0,161,166,
        3,66,33,0,162,166,3,68,34,0,163,166,3,72,36,0,164,166,3,114,57,0,
        165,160,1,0,0,0,165,161,1,0,0,0,165,162,1,0,0,0,165,163,1,0,0,0,
        165,164,1,0,0,0,166,9,1,0,0,0,167,168,5,67,0,0,168,171,3,12,6,0,
        169,170,5,26,0,0,170,172,3,16,8,0,171,169,1,0,0,0,171,172,1,0,0,
        0,172,176,1,0,0,0,173,175,3,20,10,0,174,173,1,0,0,0,175,178,1,0,
        0,0,176,174,1,0,0,0,176,177,1,0,0,0,177,180,1,0,0,0,178,176,1,0,
        0,0,179,181,3,26,13,0,180,179,1,0,0,0,180,181,1,0,0,0,181,183,1,
        0,0,0,182,184,3,28,14,0,183,182,1,0,0,0,183,184,1,0,0,0,184,186,
        1,0,0,0,185,187,3,116,58,0,186,185,1,0,0,0,186,187,1,0,0,0,187,189,
        1,0,0,0,188,190,3,30,15,0,189,188,1,0,0,0,189,190,1,0,0,0,190,11,
        1,0,0,0,191,201,5,210,0,0,192,197,3,14,7,0,193,194,5,213,0,0,194,
        196,3,14,7,0,195,193,1,0,0,0,196,199,1,0,0,0,197,195,1,0,0,0,197,
        198,1,0,0,0,198,201,1,0,0,0,199,197,1,0,0,0,200,191,1,0,0,0,200,
        192,1,0,0,0,201,13,1,0,0,0,202,207,3,46,23,0,203,205,5,16,0,0,204,
        203,1,0,0,0,204,205,1,0,0,0,205,206,1,0,0,0,206,208,7,0,0,0,207,
        204,1,0,0,0,207,208,1,0,0,0,208,15,1,0,0,0,209,214,3,18,9,0,210,
        212,5,16,0,0,211,210,1,0,0,0,211,212,1,0,0,0,212,213,1,0,0,0,213,
        215,5,200,0,0,214,211,1,0,0,0,214,215,1,0,0,0,215,17,1,0,0,0,216,
        221,7,1,0,0,217,218,5,214,0,0,218,220,7,1,0,0,219,217,1,0,0,0,220,
        223,1,0,0,0,221,219,1,0,0,0,221,222,1,0,0,0,222,19,1,0,0,0,223,221,
        1,0,0,0,224,225,3,22,11,0,225,226,5,84,0,0,226,227,3,16,8,0,227,
        228,5,135,0,0,228,229,3,34,17,0,229,21,1,0,0,0,230,232,5,69,0,0,
        231,233,5,162,0,0,232,231,1,0,0,0,232,233,1,0,0,0,233,248,1,0,0,
        0,234,236,5,93,0,0,235,237,5,162,0,0,236,235,1,0,0,0,236,237,1,0,
        0,0,237,248,1,0,0,0,238,240,5,43,0,0,239,241,5,162,0,0,240,239,1,
        0,0,0,240,241,1,0,0,0,241,248,1,0,0,0,242,244,5,29,0,0,243,245,5,
        162,0,0,244,243,1,0,0,0,244,245,1,0,0,0,245,248,1,0,0,0,246,248,
        1,0,0,0,247,230,1,0,0,0,247,234,1,0,0,0,247,238,1,0,0,0,247,242,
        1,0,0,0,247,246,1,0,0,0,248,23,1,0,0,0,249,254,7,1,0,0,250,251,5,
        214,0,0,251,253,7,1,0,0,252,250,1,0,0,0,253,256,1,0,0,0,254,252,
        1,0,0,0,254,255,1,0,0,0,255,25,1,0,0,0,256,254,1,0,0,0,257,258,5,
        169,0,0,258,259,3,34,17,0,259,27,1,0,0,0,260,261,5,42,0,0,261,262,
        5,44,0,0,262,267,3,24,12,0,263,264,5,213,0,0,264,266,3,24,12,0,265,
        263,1,0,0,0,266,269,1,0,0,0,267,265,1,0,0,0,267,268,1,0,0,0,268,
        29,1,0,0,0,269,267,1,0,0,0,270,271,5,159,0,0,271,272,5,44,0,0,272,
        277,3,32,16,0,273,274,5,213,0,0,274,276,3,32,16,0,275,273,1,0,0,
        0,276,279,1,0,0,0,277,275,1,0,0,0,277,278,1,0,0,0,278,31,1,0,0,0,
        279,277,1,0,0,0,280,282,3,24,12,0,281,283,7,2,0,0,282,281,1,0,0,
        0,282,283,1,0,0,0,283,33,1,0,0,0,284,285,3,36,18,0,285,35,1,0,0,
        0,286,287,6,18,-1,0,287,288,3,38,19,0,288,294,1,0,0,0,289,290,10,
        2,0,0,290,291,5,156,0,0,291,293,3,38,19,0,292,289,1,0,0,0,293,296,
        1,0,0,0,294,292,1,0,0,0,294,295,1,0,0,0,295,37,1,0,0,0,296,294,1,
        0,0,0,297,298,6,19,-1,0,298,299,3,40,20,0,299,305,1,0,0,0,300,301,
        10,2,0,0,301,302,5,10,0,0,302,304,3,40,20,0,303,300,1,0,0,0,304,
        307,1,0,0,0,305,303,1,0,0,0,305,306,1,0,0,0,306,39,1,0,0,0,307,305,
        1,0,0,0,308,309,5,117,0,0,309,312,3,40,20,0,310,312,3,42,21,0,311,
        308,1,0,0,0,311,310,1,0,0,0,312,41,1,0,0,0,313,314,5,215,0,0,314,
        315,3,34,17,0,315,316,5,216,0,0,316,376,1,0,0,0,317,318,3,46,23,
        0,318,319,3,44,22,0,319,320,3,46,23,0,320,376,1,0,0,0,321,323,3,
        46,23,0,322,324,5,117,0,0,323,322,1,0,0,0,323,324,1,0,0,0,324,325,
        1,0,0,0,325,326,5,63,0,0,326,336,5,215,0,0,327,332,3,46,23,0,328,
        329,5,213,0,0,329,331,3,46,23,0,330,328,1,0,0,0,331,334,1,0,0,0,
        332,330,1,0,0,0,332,333,1,0,0,0,333,337,1,0,0,0,334,332,1,0,0,0,
        335,337,3,10,5,0,336,327,1,0,0,0,336,335,1,0,0,0,337,338,1,0,0,0,
        338,339,5,216,0,0,339,376,1,0,0,0,340,341,3,46,23,0,341,343,5,81,
        0,0,342,344,5,117,0,0,343,342,1,0,0,0,343,344,1,0,0,0,344,345,1,
        0,0,0,345,346,5,120,0,0,346,376,1,0,0,0,347,348,5,191,0,0,348,349,
        5,215,0,0,349,350,3,10,5,0,350,351,5,216,0,0,351,376,1,0,0,0,352,
        353,5,117,0,0,353,354,5,191,0,0,354,355,5,215,0,0,355,356,3,10,5,
        0,356,357,5,216,0,0,357,376,1,0,0,0,358,360,3,46,23,0,359,361,5,
        117,0,0,360,359,1,0,0,0,360,361,1,0,0,0,361,362,1,0,0,0,362,363,
        5,31,0,0,363,364,3,46,23,0,364,365,5,10,0,0,365,366,3,46,23,0,366,
        376,1,0,0,0,367,376,1,0,0,0,368,370,3,46,23,0,369,371,5,117,0,0,
        370,369,1,0,0,0,370,371,1,0,0,0,371,372,1,0,0,0,372,373,5,96,0,0,
        373,374,3,46,23,0,374,376,1,0,0,0,375,313,1,0,0,0,375,317,1,0,0,
        0,375,321,1,0,0,0,375,340,1,0,0,0,375,347,1,0,0,0,375,352,1,0,0,
        0,375,358,1,0,0,0,375,367,1,0,0,0,375,368,1,0,0,0,376,43,1,0,0,0,
        377,378,7,3,0,0,378,45,1,0,0,0,379,380,3,48,24,0,380,47,1,0,0,0,
        381,382,5,201,0,0,382,383,7,4,0,0,383,386,3,50,25,0,384,386,3,50,
        25,0,385,381,1,0,0,0,385,384,1,0,0,0,386,49,1,0,0,0,387,388,6,25,
        -1,0,388,389,3,52,26,0,389,398,1,0,0,0,390,391,10,3,0,0,391,392,
        5,208,0,0,392,397,3,52,26,0,393,394,10,2,0,0,394,395,5,209,0,0,395,
        397,3,52,26,0,396,390,1,0,0,0,396,393,1,0,0,0,397,400,1,0,0,0,398,
        396,1,0,0,0,398,399,1,0,0,0,399,51,1,0,0,0,400,398,1,0,0,0,401,402,
        6,26,-1,0,402,403,3,54,27,0,403,412,1,0,0,0,404,405,10,3,0,0,405,
        406,5,210,0,0,406,411,3,54,27,0,407,408,10,2,0,0,408,409,5,211,0,
        0,409,411,3,54,27,0,410,404,1,0,0,0,410,407,1,0,0,0,411,414,1,0,
        0,0,412,410,1,0,0,0,412,413,1,0,0,0,413,53,1,0,0,0,414,412,1,0,0,
        0,415,416,5,208,0,0,416,421,3,54,27,0,417,418,5,209,0,0,418,421,
        3,54,27,0,419,421,3,56,28,0,420,415,1,0,0,0,420,417,1,0,0,0,420,
        419,1,0,0,0,421,55,1,0,0,0,422,423,5,215,0,0,423,424,3,10,5,0,424,
        425,5,216,0,0,425,435,1,0,0,0,426,427,5,215,0,0,427,428,3,46,23,
        0,428,429,5,216,0,0,429,435,1,0,0,0,430,435,3,64,32,0,431,435,3,
        24,12,0,432,435,3,62,31,0,433,435,5,201,0,0,434,422,1,0,0,0,434,
        426,1,0,0,0,434,430,1,0,0,0,434,431,1,0,0,0,434,432,1,0,0,0,434,
        433,1,0,0,0,435,57,1,0,0,0,436,438,5,50,0,0,437,439,3,60,30,0,438,
        437,1,0,0,0,439,440,1,0,0,0,440,438,1,0,0,0,440,441,1,0,0,0,441,
        444,1,0,0,0,442,443,5,161,0,0,443,445,3,46,23,0,444,442,1,0,0,0,
        444,445,1,0,0,0,445,446,1,0,0,0,446,447,5,164,0,0,447,59,1,0,0,0,
        448,449,5,166,0,0,449,450,3,34,17,0,450,451,5,109,0,0,451,452,3,
        46,23,0,452,61,1,0,0,0,453,454,7,5,0,0,454,63,1,0,0,0,455,456,7,
        6,0,0,456,465,5,215,0,0,457,462,3,46,23,0,458,459,5,213,0,0,459,
        461,3,46,23,0,460,458,1,0,0,0,461,464,1,0,0,0,462,460,1,0,0,0,462,
        463,1,0,0,0,463,466,1,0,0,0,464,462,1,0,0,0,465,457,1,0,0,0,465,
        466,1,0,0,0,466,467,1,0,0,0,467,468,5,216,0,0,468,65,1,0,0,0,469,
        470,5,72,0,0,470,471,5,78,0,0,471,472,3,18,9,0,472,473,5,215,0,0,
        473,478,3,24,12,0,474,475,5,213,0,0,475,477,3,24,12,0,476,474,1,
        0,0,0,477,480,1,0,0,0,478,476,1,0,0,0,478,479,1,0,0,0,479,481,1,
        0,0,0,480,478,1,0,0,0,481,482,5,216,0,0,482,483,5,154,0,0,483,484,
        5,215,0,0,484,489,3,62,31,0,485,486,5,213,0,0,486,488,3,62,31,0,
        487,485,1,0,0,0,488,491,1,0,0,0,489,487,1,0,0,0,489,490,1,0,0,0,
        490,492,1,0,0,0,491,489,1,0,0,0,492,493,5,216,0,0,493,508,1,0,0,
        0,494,495,5,213,0,0,495,496,5,215,0,0,496,501,3,62,31,0,497,498,
        5,213,0,0,498,500,3,62,31,0,499,497,1,0,0,0,500,503,1,0,0,0,501,
        499,1,0,0,0,501,502,1,0,0,0,502,504,1,0,0,0,503,501,1,0,0,0,504,
        505,5,216,0,0,505,507,1,0,0,0,506,494,1,0,0,0,507,510,1,0,0,0,508,
        506,1,0,0,0,508,509,1,0,0,0,509,67,1,0,0,0,510,508,1,0,0,0,511,512,
        5,142,0,0,512,513,3,18,9,0,513,514,5,82,0,0,514,519,3,70,35,0,515,
        516,5,213,0,0,516,518,3,70,35,0,517,515,1,0,0,0,518,521,1,0,0,0,
        519,517,1,0,0,0,519,520,1,0,0,0,520,523,1,0,0,0,521,519,1,0,0,0,
        522,524,3,26,13,0,523,522,1,0,0,0,523,524,1,0,0,0,524,69,1,0,0,0,
        525,526,3,24,12,0,526,527,7,4,0,0,527,528,3,46,23,0,528,71,1,0,0,
        0,529,530,5,134,0,0,530,531,5,26,0,0,531,533,3,18,9,0,532,534,3,
        26,13,0,533,532,1,0,0,0,533,534,1,0,0,0,534,73,1,0,0,0,535,542,3,
        76,38,0,536,542,3,86,43,0,537,542,3,88,44,0,538,542,3,112,56,0,539,
        542,3,118,59,0,540,542,3,120,60,0,541,535,1,0,0,0,541,536,1,0,0,
        0,541,537,1,0,0,0,541,538,1,0,0,0,541,539,1,0,0,0,541,540,1,0,0,
        0,542,75,1,0,0,0,543,544,5,95,0,0,544,545,5,100,0,0,545,546,3,18,
        9,0,546,547,5,215,0,0,547,552,3,78,39,0,548,549,5,213,0,0,549,551,
        3,78,39,0,550,548,1,0,0,0,551,554,1,0,0,0,552,550,1,0,0,0,552,553,
        1,0,0,0,553,555,1,0,0,0,554,552,1,0,0,0,555,556,5,216,0,0,556,77,
        1,0,0,0,557,558,3,24,12,0,558,562,3,82,41,0,559,561,3,80,40,0,560,
        559,1,0,0,0,561,564,1,0,0,0,562,560,1,0,0,0,562,563,1,0,0,0,563,
        79,1,0,0,0,564,562,1,0,0,0,565,572,5,51,0,0,566,567,5,180,0,0,567,
        572,5,87,0,0,568,572,5,120,0,0,569,570,5,117,0,0,570,572,5,120,0,
        0,571,565,1,0,0,0,571,566,1,0,0,0,571,568,1,0,0,0,571,569,1,0,0,
        0,572,81,1,0,0,0,573,585,5,181,0,0,574,575,5,182,0,0,575,576,5,215,
        0,0,576,577,7,7,0,0,577,585,5,216,0,0,578,579,5,183,0,0,579,580,
        5,215,0,0,580,581,7,7,0,0,581,585,5,216,0,0,582,585,5,199,0,0,583,
        585,5,200,0,0,584,573,1,0,0,0,584,574,1,0,0,0,584,578,1,0,0,0,584,
        582,1,0,0,0,584,583,1,0,0,0,585,587,1,0,0,0,586,588,3,84,42,0,587,
        586,1,0,0,0,587,588,1,0,0,0,588,83,1,0,0,0,589,590,5,215,0,0,590,
        591,7,7,0,0,591,592,5,216,0,0,592,85,1,0,0,0,593,594,5,155,0,0,594,
        595,5,100,0,0,595,596,3,18,9,0,596,87,1,0,0,0,597,598,5,7,0,0,598,
        599,5,100,0,0,599,600,3,18,9,0,600,601,3,90,45,0,601,89,1,0,0,0,
        602,603,5,1,0,0,603,607,3,78,39,0,604,605,5,155,0,0,605,607,3,24,
        12,0,606,602,1,0,0,0,606,604,1,0,0,0,607,91,1,0,0,0,608,613,3,94,
        47,0,609,613,3,96,48,0,610,613,3,98,49,0,611,613,3,100,50,0,612,
        608,1,0,0,0,612,609,1,0,0,0,612,610,1,0,0,0,612,611,1,0,0,0,613,
        93,1,0,0,0,614,615,5,128,0,0,615,616,5,200,0,0,616,617,5,116,0,0,
        617,618,5,14,0,0,618,619,3,10,5,0,619,95,1,0,0,0,620,621,5,138,0,
        0,621,622,5,200,0,0,622,97,1,0,0,0,623,624,5,5,0,0,624,625,5,200,
        0,0,625,99,1,0,0,0,626,627,5,59,0,0,627,628,5,200,0,0,628,101,1,
        0,0,0,629,633,5,28,0,0,630,632,3,104,52,0,631,630,1,0,0,0,632,635,
        1,0,0,0,633,631,1,0,0,0,633,634,1,0,0,0,634,636,1,0,0,0,635,633,
        1,0,0,0,636,637,5,164,0,0,637,103,1,0,0,0,638,641,3,2,1,0,639,641,
        3,108,54,0,640,638,1,0,0,0,640,639,1,0,0,0,641,105,1,0,0,0,642,643,
        7,8,0,0,643,652,7,1,0,0,644,649,3,46,23,0,645,646,5,213,0,0,646,
        648,3,46,23,0,647,645,1,0,0,0,648,651,1,0,0,0,649,647,1,0,0,0,649,
        650,1,0,0,0,650,653,1,0,0,0,651,649,1,0,0,0,652,644,1,0,0,0,652,
        653,1,0,0,0,653,655,1,0,0,0,654,656,5,219,0,0,655,654,1,0,0,0,655,
        656,1,0,0,0,656,107,1,0,0,0,657,658,5,28,0,0,658,662,5,189,0,0,659,
        661,3,104,52,0,660,659,1,0,0,0,661,664,1,0,0,0,662,660,1,0,0,0,662,
        663,1,0,0,0,663,665,1,0,0,0,664,662,1,0,0,0,665,666,5,164,0,0,666,
        667,5,189,0,0,667,668,5,28,0,0,668,672,5,190,0,0,669,671,3,104,52,
        0,670,669,1,0,0,0,671,674,1,0,0,0,672,670,1,0,0,0,672,673,1,0,0,
        0,673,675,1,0,0,0,674,672,1,0,0,0,675,676,5,164,0,0,676,677,5,190,
        0,0,677,109,1,0,0,0,678,679,5,60,0,0,679,680,3,34,17,0,680,683,3,
        2,1,0,681,682,5,161,0,0,682,684,3,2,1,0,683,681,1,0,0,0,683,684,
        1,0,0,0,684,111,1,0,0,0,685,686,5,128,0,0,686,687,5,201,0,0,687,
        690,3,82,41,0,688,689,5,202,0,0,689,691,3,46,23,0,690,688,1,0,0,
        0,690,691,1,0,0,0,691,701,1,0,0,0,692,693,5,213,0,0,693,694,5,201,
        0,0,694,697,3,82,41,0,695,696,5,202,0,0,696,698,3,46,23,0,697,695,
        1,0,0,0,697,698,1,0,0,0,698,700,1,0,0,0,699,692,1,0,0,0,700,703,
        1,0,0,0,701,699,1,0,0,0,701,702,1,0,0,0,702,113,1,0,0,0,703,701,
        1,0,0,0,704,705,5,82,0,0,705,706,5,201,0,0,706,707,7,4,0,0,707,714,
        3,46,23,0,708,709,5,213,0,0,709,710,5,201,0,0,710,711,7,4,0,0,711,
        713,3,46,23,0,712,708,1,0,0,0,713,716,1,0,0,0,714,712,1,0,0,0,714,
        715,1,0,0,0,715,718,1,0,0,0,716,714,1,0,0,0,717,719,5,219,0,0,718,
        717,1,0,0,0,718,719,1,0,0,0,719,115,1,0,0,0,720,721,5,45,0,0,721,
        722,3,34,17,0,722,117,1,0,0,0,723,724,5,148,0,0,724,725,5,200,0,
        0,725,119,1,0,0,0,726,727,5,127,0,0,727,728,5,100,0,0,728,730,3,
        18,9,0,729,731,5,219,0,0,730,729,1,0,0,0,730,731,1,0,0,0,731,121,
        1,0,0,0,78,125,131,140,143,151,165,171,176,180,183,186,189,197,200,
        204,207,211,214,221,232,236,240,244,247,254,267,277,282,294,305,
        311,323,332,336,343,360,370,375,385,396,398,410,412,420,434,440,
        444,462,465,478,489,501,508,519,523,533,541,552,562,571,584,587,
        606,612,633,640,649,652,655,662,672,683,690,697,701,714,718,730
    ]

class SqlParser ( Parser ):

    grammarFileName = "SqlParser.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ "<INVALID>", "'ADD'", "'EXTERNAL'", "'PROCEDURE'", 
                     "'ALL'", "'FETCH'", "'PUBLIC'", "'ALTER'", "'FILE'", 
                     "'RAISERROR'", "'AND'", "'FILLFACTOR'", "'READ'", "'ANY'", 
                     "'FOR'", "'READTEXT'", "'AS'", "'FOREIGN'", "'RECONFIGURE'", 
                     "'ASC'", "'FREETEXT'", "'REFERENCES'", "'AUTHORIZATION'", 
                     "'FREETEXTTABLE'", "'REPLICATION'", "'BACKUP'", "'FROM'", 
                     "'RESTORE'", "'BEGIN'", "'FULL'", "'RESTRICT'", "'BETWEEN'", 
                     "'FUNCTION'", "'RETURN'", "'BREAK'", "'GOTO'", "'GO'", 
                     "'REVERT'", "'BROWSE'", "'GRANT'", "'REVOKE'", "'BULK'", 
                     "'GROUP'", "'RIGHT'", "'BY'", "'HAVING'", "'ROLLBACK'", 
                     "'CASCADE'", "'HOLDLOCK'", "'ROWCOUNT'", "'CASE'", 
                     "'IDENTITY'", "'ROWGUIDCOL'", "'CHECK'", "'IDENTITY_INSERT'", 
                     "'RULE'", "'CHECKPOINT'", "'IDENTITYCOL'", "'SAVE'", 
                     "'CLOSE'", "'IF'", "'SCHEMA'", "'CLUSTERED'", "'IN'", 
                     "'SECURITYAUDIT'", "'COALESCE'", "'INDEX'", "'SELECT'", 
                     "'COLLATE'", "'INNER'", "'SEMANTICKEYPHRASETABLE'", 
                     "'COLUMN'", "'INSERT'", "'SEMANTICSIMILARITYDETAILSTABLE'", 
                     "'COMMIT'", "'INTERSECT'", "'SEMANTICSIMILARITYTABLE'", 
                     "'COMPUTE'", "'INTO'", "'SESSION_USER'", "'CONSTRAINT'", 
                     "'IS'", "'SET'", "'CONTAINS'", "'JOIN'", "'SETUSER'", 
                     "'CONTAINSTABLE'", "'KEY'", "'SHUTDOWN'", "'CONTINUE'", 
                     "'KILL'", "'SOME'", "'CONVERT'", "'LEFT'", "'STATISTICS'", 
                     "'CREATE'", "'LIKE'", "'SYSTEM_USER'", "'CROSS'", "'LINENO'", 
                     "'TABLE'", "'CURRENT'", "'LOAD'", "'TABLESAMPLE'", 
                     "'CURRENT_DATE'", "'MERGE'", "'TEXTSIZE'", "'CURRENT_TIME'", 
                     "'NATIONAL'", "'THEN'", "'CURRENT_TIMESTAMP'", "'NOCHECK'", 
                     "'TO'", "'CURRENT_USER'", "'NONCLUSTERED'", "'TOP'", 
                     "'CURSOR'", "'NOT'", "'TRAN'", "'DATABASE'", "'NULL'", 
                     "'TRANSACTION'", "'DBCC'", "'NULLIF'", "'TRIGGER'", 
                     "'DEALLOCATE'", "'OF'", "'TRUNCATE'", "'DECLARE'", 
                     "'OFF'", "'TRY_CONVERT'", "'DEFAULT'", "'OFFSETS'", 
                     "'TSEQUAL'", "'DELETE'", "'ON'", "'UNION'", "'DENY'", 
                     "'OPEN'", "'UNIQUE'", "'DESC'", "'OPENDATASOURCE'", 
                     "'UPDATE'", "'DISK'", "'OPENQUERY'", "'UPDATETEXT'", 
                     "'DISTINCT'", "'OPENROWSET'", "'USE'", "'DISTRIBUTED'", 
                     "'OPENXML'", "'USER'", "'DOUBLE'", "'OPTION'", "'VALUES'", 
                     "'DROP'", "'OR'", "'VARYING'", "'DUMP'", "'ORDER'", 
                     "'VIEW'", "'ELSE'", "'OUTER'", "'WAITFOR'", "'END'", 
                     "'OVER'", "'WHEN'", "'ERRLVL'", "'PERCENT'", "'WHERE'", 
                     "'ESCAPE'", "'PIVOT'", "'WHILE'", "'EXCEPT'", "'PLAN'", 
                     "'WITH'", "'EXEC'", "'PRECISION'", "'WRITETEXT'", "'EXECUTE'", 
                     "'PRIMARY'", "'INTEGER'", "'NVARCHAR'", "'VARCHAR'", 
                     "'MAX'", "'MIN'", "'AVG'", "'SUM'", "'COUNT'", "'TRY'", 
                     "'CATCH'", "'EXISTS'", "<INVALID>", "<INVALID>", "<INVALID>", 
                     "<INVALID>", "'TRUE'", "'FALSE'", "<INVALID>", "<INVALID>", 
                     "<INVALID>", "<INVALID>", "'='", "<INVALID>", "'>'", 
                     "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", 
                     "'+='", "','", "'.'", "'('", "')'", "'['", "']'", "';'" ]

    symbolicNames = [ "<INVALID>", "ADD", "EXTERNAL", "PROCEDURE", "ALL", 
                      "FETCH", "PUBLIC", "ALTER", "FILE", "RAISERROR", "AND", 
                      "FILLFACTOR", "READ", "ANY", "FOR", "READTEXT", "AS", 
                      "FOREIGN", "RECONFIGURE", "ASC", "FREETEXT", "REFERENCES", 
                      "AUTHORIZATION", "FREETEXTTABLE", "REPLICATION", "BACKUP", 
                      "FROM", "RESTORE", "BEGIN", "FULL", "RESTRICT", "BETWEEN", 
                      "FUNCTION", "RETURN", "BREAK", "GOTO", "GO", "REVERT", 
                      "BROWSE", "GRANT", "REVOKE", "BULK", "GROUP", "RIGHT", 
                      "BY", "HAVING", "ROLLBACK", "CASCADE", "HOLDLOCK", 
                      "ROWCOUNT", "CASE", "IDENTITY", "ROWGUIDCOL", "CHECK", 
                      "IDENTITY_INSERT", "RULE", "CHECKPOINT", "IDENTITYCOL", 
                      "SAVE", "CLOSE", "IF", "SCHEMA", "CLUSTERED", "IN", 
                      "SECURITYAUDIT", "COALESCE", "INDEX", "SELECT", "COLLATE", 
                      "INNER", "SEMANTICKEYPHRASETABLE", "COLUMN", "INSERT", 
                      "SEMANTICSIMILARITYDETAILSTABLE", "COMMIT", "INTERSECT", 
                      "SEMANTICSIMILARITYTABLE", "COMPUTE", "INTO", "SESSION_USER", 
                      "CONSTRAINT", "IS", "SET", "CONTAINS", "JOIN", "SETUSER", 
                      "CONTAINSTABLE", "KEY", "SHUTDOWN", "CONTINUE", "KILL", 
                      "SOME", "CONVERT", "LEFT", "STATISTICS", "CREATE", 
                      "LIKE", "SYSTEM_USER", "CROSS", "LINENO", "TABLE", 
                      "CURRENT", "LOAD", "TABLESAMPLE", "CURRENT_DATE", 
                      "MERGE", "TEXTSIZE", "CURRENT_TIME", "NATIONAL", "THEN", 
                      "CURRENT_TIMESTAMP", "NOCHECK", "TO", "CURRENT_USER", 
                      "NONCLUSTERED", "TOP", "CURSOR", "NOT", "TRAN", "DATABASE", 
                      "NULL", "TRANSACTION", "DBCC", "NULLIF", "TRIGGER", 
                      "DEALLOCATE", "OF", "TRUNCATE", "DECLARE", "OFF", 
                      "TRY_CONVERT", "DEFAULT", "OFFSETS", "TSEQUAL", "DELETE", 
                      "ON", "UNION", "DENY", "OPEN", "UNIQUE", "DESC", "OPENDATASOURCE", 
                      "UPDATE", "DISK", "OPENQUERY", "UPDATETEXT", "DISTINCT", 
                      "OPENROWSET", "USE", "DISTRIBUTED", "OPENXML", "USER", 
                      "DOUBLE", "OPTION", "VALUES", "DROP", "OR", "VARYING", 
                      "DUMP", "ORDER", "VIEW", "ELSE", "OUTER", "WAITFOR", 
                      "END", "OVER", "WHEN", "ERRLVL", "PERCENT", "WHERE", 
                      "ESCAPE", "PIVOT", "WHILE", "EXCEPT", "PLAN", "WITH", 
                      "EXEC", "PRECISION", "WRITETEXT", "EXECUTE", "PRIMARY", 
                      "INT", "NVARCHAR", "VARCHAR", "MAX", "MIN", "AVG", 
                      "SUM", "COUNT", "TRY", "CATCH", "EXISTS", "INT_LITERAL", 
                      "FLOAT_LITERAL", "HEX_LITERAL", "BIT_LITERAL", "TRUE_LITERAL", 
                      "FALSE_LITERAL", "STRING_LITERAL", "BRACKET_IDENTIFIER", 
                      "IDENTIFIER", "USER_VAR", "EQ", "NEQ", "GT", "LT", 
                      "GTE", "LTE", "PLUS", "MINUS", "STAR", "SLASH", "PLUS_EQ", 
                      "COMMA", "DOT", "LPAREN", "RPAREN", "SPAREN", "ZPAREN", 
                      "SEMI", "LINE_COMMENT", "COMMENT", "WS" ]

    RULE_sqlFile = 0
    RULE_sqlStatement = 1
    RULE_cteStatement = 2
    RULE_cteDefinition = 3
    RULE_dmlStatement = 4
    RULE_selectStatement = 5
    RULE_selectList = 6
    RULE_selectElement = 7
    RULE_tableSource = 8
    RULE_tableName = 9
    RULE_joinClause = 10
    RULE_joinType = 11
    RULE_columnName = 12
    RULE_whereClause = 13
    RULE_groupByClause = 14
    RULE_orderByClause = 15
    RULE_orderElement = 16
    RULE_searchCondition = 17
    RULE_orExpression = 18
    RULE_andExpression = 19
    RULE_notExpression = 20
    RULE_predicate = 21
    RULE_comparisonOperator = 22
    RULE_expression = 23
    RULE_assignmentExpression = 24
    RULE_additiveExpression = 25
    RULE_multiplicativeExpression = 26
    RULE_unaryExpression = 27
    RULE_primaryExpression = 28
    RULE_caseExpression = 29
    RULE_whenClause = 30
    RULE_literal = 31
    RULE_functionCall = 32
    RULE_insertStatement = 33
    RULE_updateStatement = 34
    RULE_assignment = 35
    RULE_deleteStatement = 36
    RULE_ddlStatement = 37
    RULE_createTableStatement = 38
    RULE_columnDefinition = 39
    RULE_nullability = 40
    RULE_dataType = 41
    RULE_typeParams = 42
    RULE_dropTableStatement = 43
    RULE_alterTableStatement = 44
    RULE_alterAction = 45
    RULE_cursorStatement = 46
    RULE_declareCursor = 47
    RULE_openCursor = 48
    RULE_fetchCursor = 49
    RULE_closeCursor = 50
    RULE_blockStatement = 51
    RULE_blockContent = 52
    RULE_execStatement = 53
    RULE_tryCatchStatement = 54
    RULE_ifStatement = 55
    RULE_declareStatement = 56
    RULE_setStatement = 57
    RULE_havingClause = 58
    RULE_useDatabaseStatement = 59
    RULE_truncateTableStatement = 60

    ruleNames =  [ "sqlFile", "sqlStatement", "cteStatement", "cteDefinition", 
                   "dmlStatement", "selectStatement", "selectList", "selectElement", 
                   "tableSource", "tableName", "joinClause", "joinType", 
                   "columnName", "whereClause", "groupByClause", "orderByClause", 
                   "orderElement", "searchCondition", "orExpression", "andExpression", 
                   "notExpression", "predicate", "comparisonOperator", "expression", 
                   "assignmentExpression", "additiveExpression", "multiplicativeExpression", 
                   "unaryExpression", "primaryExpression", "caseExpression", 
                   "whenClause", "literal", "functionCall", "insertStatement", 
                   "updateStatement", "assignment", "deleteStatement", "ddlStatement", 
                   "createTableStatement", "columnDefinition", "nullability", 
                   "dataType", "typeParams", "dropTableStatement", "alterTableStatement", 
                   "alterAction", "cursorStatement", "declareCursor", "openCursor", 
                   "fetchCursor", "closeCursor", "blockStatement", "blockContent", 
                   "execStatement", "tryCatchStatement", "ifStatement", 
                   "declareStatement", "setStatement", "havingClause", "useDatabaseStatement", 
                   "truncateTableStatement" ]

    EOF = Token.EOF
    ADD=1
    EXTERNAL=2
    PROCEDURE=3
    ALL=4
    FETCH=5
    PUBLIC=6
    ALTER=7
    FILE=8
    RAISERROR=9
    AND=10
    FILLFACTOR=11
    READ=12
    ANY=13
    FOR=14
    READTEXT=15
    AS=16
    FOREIGN=17
    RECONFIGURE=18
    ASC=19
    FREETEXT=20
    REFERENCES=21
    AUTHORIZATION=22
    FREETEXTTABLE=23
    REPLICATION=24
    BACKUP=25
    FROM=26
    RESTORE=27
    BEGIN=28
    FULL=29
    RESTRICT=30
    BETWEEN=31
    FUNCTION=32
    RETURN=33
    BREAK=34
    GOTO=35
    GO=36
    REVERT=37
    BROWSE=38
    GRANT=39
    REVOKE=40
    BULK=41
    GROUP=42
    RIGHT=43
    BY=44
    HAVING=45
    ROLLBACK=46
    CASCADE=47
    HOLDLOCK=48
    ROWCOUNT=49
    CASE=50
    IDENTITY=51
    ROWGUIDCOL=52
    CHECK=53
    IDENTITY_INSERT=54
    RULE=55
    CHECKPOINT=56
    IDENTITYCOL=57
    SAVE=58
    CLOSE=59
    IF=60
    SCHEMA=61
    CLUSTERED=62
    IN=63
    SECURITYAUDIT=64
    COALESCE=65
    INDEX=66
    SELECT=67
    COLLATE=68
    INNER=69
    SEMANTICKEYPHRASETABLE=70
    COLUMN=71
    INSERT=72
    SEMANTICSIMILARITYDETAILSTABLE=73
    COMMIT=74
    INTERSECT=75
    SEMANTICSIMILARITYTABLE=76
    COMPUTE=77
    INTO=78
    SESSION_USER=79
    CONSTRAINT=80
    IS=81
    SET=82
    CONTAINS=83
    JOIN=84
    SETUSER=85
    CONTAINSTABLE=86
    KEY=87
    SHUTDOWN=88
    CONTINUE=89
    KILL=90
    SOME=91
    CONVERT=92
    LEFT=93
    STATISTICS=94
    CREATE=95
    LIKE=96
    SYSTEM_USER=97
    CROSS=98
    LINENO=99
    TABLE=100
    CURRENT=101
    LOAD=102
    TABLESAMPLE=103
    CURRENT_DATE=104
    MERGE=105
    TEXTSIZE=106
    CURRENT_TIME=107
    NATIONAL=108
    THEN=109
    CURRENT_TIMESTAMP=110
    NOCHECK=111
    TO=112
    CURRENT_USER=113
    NONCLUSTERED=114
    TOP=115
    CURSOR=116
    NOT=117
    TRAN=118
    DATABASE=119
    NULL=120
    TRANSACTION=121
    DBCC=122
    NULLIF=123
    TRIGGER=124
    DEALLOCATE=125
    OF=126
    TRUNCATE=127
    DECLARE=128
    OFF=129
    TRY_CONVERT=130
    DEFAULT=131
    OFFSETS=132
    TSEQUAL=133
    DELETE=134
    ON=135
    UNION=136
    DENY=137
    OPEN=138
    UNIQUE=139
    DESC=140
    OPENDATASOURCE=141
    UPDATE=142
    DISK=143
    OPENQUERY=144
    UPDATETEXT=145
    DISTINCT=146
    OPENROWSET=147
    USE=148
    DISTRIBUTED=149
    OPENXML=150
    USER=151
    DOUBLE=152
    OPTION=153
    VALUES=154
    DROP=155
    OR=156
    VARYING=157
    DUMP=158
    ORDER=159
    VIEW=160
    ELSE=161
    OUTER=162
    WAITFOR=163
    END=164
    OVER=165
    WHEN=166
    ERRLVL=167
    PERCENT=168
    WHERE=169
    ESCAPE=170
    PIVOT=171
    WHILE=172
    EXCEPT=173
    PLAN=174
    WITH=175
    EXEC=176
    PRECISION=177
    WRITETEXT=178
    EXECUTE=179
    PRIMARY=180
    INT=181
    NVARCHAR=182
    VARCHAR=183
    MAX=184
    MIN=185
    AVG=186
    SUM=187
    COUNT=188
    TRY=189
    CATCH=190
    EXISTS=191
    INT_LITERAL=192
    FLOAT_LITERAL=193
    HEX_LITERAL=194
    BIT_LITERAL=195
    TRUE_LITERAL=196
    FALSE_LITERAL=197
    STRING_LITERAL=198
    BRACKET_IDENTIFIER=199
    IDENTIFIER=200
    USER_VAR=201
    EQ=202
    NEQ=203
    GT=204
    LT=205
    GTE=206
    LTE=207
    PLUS=208
    MINUS=209
    STAR=210
    SLASH=211
    PLUS_EQ=212
    COMMA=213
    DOT=214
    LPAREN=215
    RPAREN=216
    SPAREN=217
    ZPAREN=218
    SEMI=219
    LINE_COMMENT=220
    COMMENT=221
    WS=222

    def __init__(self, input:TokenStream, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.13.2")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None




    class SqlFileContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def EOF(self):
            return self.getToken(SqlParser.EOF, 0)

        def sqlStatement(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.SqlStatementContext)
            else:
                return self.getTypedRuleContext(SqlParser.SqlStatementContext,i)


        def getRuleIndex(self):
            return SqlParser.RULE_sqlFile

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterSqlFile" ):
                listener.enterSqlFile(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitSqlFile" ):
                listener.exitSqlFile(self)




    def sqlFile(self):

        localctx = SqlParser.SqlFileContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_sqlFile)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 125
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while (((_la) & ~0x3f) == 0 and ((1 << _la) & 1729382257178706080) != 0) or ((((_la - 67)) & ~0x3f) == 0 and ((1 << (_la - 67)) & 3458764514089009185) != 0) or ((((_la - 134)) & ~0x3f) == 0 and ((1 << (_la - 134)) & 41781443969297) != 0):
                self.state = 122
                self.sqlStatement()
                self.state = 127
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 128
            self.match(SqlParser.EOF)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class SqlStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def dmlStatement(self):
            return self.getTypedRuleContext(SqlParser.DmlStatementContext,0)


        def ddlStatement(self):
            return self.getTypedRuleContext(SqlParser.DdlStatementContext,0)


        def cursorStatement(self):
            return self.getTypedRuleContext(SqlParser.CursorStatementContext,0)


        def ifStatement(self):
            return self.getTypedRuleContext(SqlParser.IfStatementContext,0)


        def blockStatement(self):
            return self.getTypedRuleContext(SqlParser.BlockStatementContext,0)


        def execStatement(self):
            return self.getTypedRuleContext(SqlParser.ExecStatementContext,0)


        def tryCatchStatement(self):
            return self.getTypedRuleContext(SqlParser.TryCatchStatementContext,0)


        def cteStatement(self):
            return self.getTypedRuleContext(SqlParser.CteStatementContext,0)


        def SEMI(self):
            return self.getToken(SqlParser.SEMI, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_sqlStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterSqlStatement" ):
                listener.enterSqlStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitSqlStatement" ):
                listener.exitSqlStatement(self)




    def sqlStatement(self):

        localctx = SqlParser.SqlStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_sqlStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 131
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==175:
                self.state = 130
                self.cteStatement()


            self.state = 140
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,2,self._ctx)
            if la_ == 1:
                self.state = 133
                self.dmlStatement()
                pass

            elif la_ == 2:
                self.state = 134
                self.ddlStatement()
                pass

            elif la_ == 3:
                self.state = 135
                self.cursorStatement()
                pass

            elif la_ == 4:
                self.state = 136
                self.ifStatement()
                pass

            elif la_ == 5:
                self.state = 137
                self.blockStatement()
                pass

            elif la_ == 6:
                self.state = 138
                self.execStatement()
                pass

            elif la_ == 7:
                self.state = 139
                self.tryCatchStatement()
                pass


            self.state = 143
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,3,self._ctx)
            if la_ == 1:
                self.state = 142
                self.match(SqlParser.SEMI)


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class CteStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def WITH(self):
            return self.getToken(SqlParser.WITH, 0)

        def cteDefinition(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.CteDefinitionContext)
            else:
                return self.getTypedRuleContext(SqlParser.CteDefinitionContext,i)


        def COMMA(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.COMMA)
            else:
                return self.getToken(SqlParser.COMMA, i)

        def getRuleIndex(self):
            return SqlParser.RULE_cteStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterCteStatement" ):
                listener.enterCteStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitCteStatement" ):
                listener.exitCteStatement(self)




    def cteStatement(self):

        localctx = SqlParser.CteStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 4, self.RULE_cteStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 145
            self.match(SqlParser.WITH)
            self.state = 146
            self.cteDefinition()
            self.state = 151
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==213:
                self.state = 147
                self.match(SqlParser.COMMA)
                self.state = 148
                self.cteDefinition()
                self.state = 153
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class CteDefinitionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def IDENTIFIER(self):
            return self.getToken(SqlParser.IDENTIFIER, 0)

        def AS(self):
            return self.getToken(SqlParser.AS, 0)

        def LPAREN(self):
            return self.getToken(SqlParser.LPAREN, 0)

        def selectStatement(self):
            return self.getTypedRuleContext(SqlParser.SelectStatementContext,0)


        def RPAREN(self):
            return self.getToken(SqlParser.RPAREN, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_cteDefinition

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterCteDefinition" ):
                listener.enterCteDefinition(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitCteDefinition" ):
                listener.exitCteDefinition(self)




    def cteDefinition(self):

        localctx = SqlParser.CteDefinitionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 6, self.RULE_cteDefinition)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 154
            self.match(SqlParser.IDENTIFIER)
            self.state = 155
            self.match(SqlParser.AS)
            self.state = 156
            self.match(SqlParser.LPAREN)
            self.state = 157
            self.selectStatement()
            self.state = 158
            self.match(SqlParser.RPAREN)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class DmlStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def selectStatement(self):
            return self.getTypedRuleContext(SqlParser.SelectStatementContext,0)


        def insertStatement(self):
            return self.getTypedRuleContext(SqlParser.InsertStatementContext,0)


        def updateStatement(self):
            return self.getTypedRuleContext(SqlParser.UpdateStatementContext,0)


        def deleteStatement(self):
            return self.getTypedRuleContext(SqlParser.DeleteStatementContext,0)


        def setStatement(self):
            return self.getTypedRuleContext(SqlParser.SetStatementContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_dmlStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterDmlStatement" ):
                listener.enterDmlStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitDmlStatement" ):
                listener.exitDmlStatement(self)




    def dmlStatement(self):

        localctx = SqlParser.DmlStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 8, self.RULE_dmlStatement)
        try:
            self.state = 165
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [67]:
                self.enterOuterAlt(localctx, 1)
                self.state = 160
                self.selectStatement()
                pass
            elif token in [72]:
                self.enterOuterAlt(localctx, 2)
                self.state = 161
                self.insertStatement()
                pass
            elif token in [142]:
                self.enterOuterAlt(localctx, 3)
                self.state = 162
                self.updateStatement()
                pass
            elif token in [134]:
                self.enterOuterAlt(localctx, 4)
                self.state = 163
                self.deleteStatement()
                pass
            elif token in [82]:
                self.enterOuterAlt(localctx, 5)
                self.state = 164
                self.setStatement()
                pass
            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class SelectStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def SELECT(self):
            return self.getToken(SqlParser.SELECT, 0)

        def selectList(self):
            return self.getTypedRuleContext(SqlParser.SelectListContext,0)


        def FROM(self):
            return self.getToken(SqlParser.FROM, 0)

        def tableSource(self):
            return self.getTypedRuleContext(SqlParser.TableSourceContext,0)


        def joinClause(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.JoinClauseContext)
            else:
                return self.getTypedRuleContext(SqlParser.JoinClauseContext,i)


        def whereClause(self):
            return self.getTypedRuleContext(SqlParser.WhereClauseContext,0)


        def groupByClause(self):
            return self.getTypedRuleContext(SqlParser.GroupByClauseContext,0)


        def havingClause(self):
            return self.getTypedRuleContext(SqlParser.HavingClauseContext,0)


        def orderByClause(self):
            return self.getTypedRuleContext(SqlParser.OrderByClauseContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_selectStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterSelectStatement" ):
                listener.enterSelectStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitSelectStatement" ):
                listener.exitSelectStatement(self)




    def selectStatement(self):

        localctx = SqlParser.SelectStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 10, self.RULE_selectStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 167
            self.match(SqlParser.SELECT)
            self.state = 168
            self.selectList()
            self.state = 171
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==26:
                self.state = 169
                self.match(SqlParser.FROM)
                self.state = 170
                self.tableSource()


            self.state = 176
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==29 or _la==43 or ((((_la - 69)) & ~0x3f) == 0 and ((1 << (_la - 69)) & 16809985) != 0):
                self.state = 173
                self.joinClause()
                self.state = 178
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 180
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==169:
                self.state = 179
                self.whereClause()


            self.state = 183
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==42:
                self.state = 182
                self.groupByClause()


            self.state = 186
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==45:
                self.state = 185
                self.havingClause()


            self.state = 189
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==159:
                self.state = 188
                self.orderByClause()


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class SelectListContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def STAR(self):
            return self.getToken(SqlParser.STAR, 0)

        def selectElement(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.SelectElementContext)
            else:
                return self.getTypedRuleContext(SqlParser.SelectElementContext,i)


        def COMMA(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.COMMA)
            else:
                return self.getToken(SqlParser.COMMA, i)

        def getRuleIndex(self):
            return SqlParser.RULE_selectList

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterSelectList" ):
                listener.enterSelectList(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitSelectList" ):
                listener.exitSelectList(self)




    def selectList(self):

        localctx = SqlParser.SelectListContext(self, self._ctx, self.state)
        self.enterRule(localctx, 12, self.RULE_selectList)
        self._la = 0 # Token type
        try:
            self.state = 200
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [210]:
                self.enterOuterAlt(localctx, 1)
                self.state = 191
                self.match(SqlParser.STAR)
                pass
            elif token in [120, 184, 185, 186, 187, 188, 192, 193, 196, 197, 198, 199, 200, 201, 208, 209, 215]:
                self.enterOuterAlt(localctx, 2)
                self.state = 192
                self.selectElement()
                self.state = 197
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==213:
                    self.state = 193
                    self.match(SqlParser.COMMA)
                    self.state = 194
                    self.selectElement()
                    self.state = 199
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)

                pass
            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class SelectElementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def expression(self):
            return self.getTypedRuleContext(SqlParser.ExpressionContext,0)


        def IDENTIFIER(self):
            return self.getToken(SqlParser.IDENTIFIER, 0)

        def STRING_LITERAL(self):
            return self.getToken(SqlParser.STRING_LITERAL, 0)

        def AS(self):
            return self.getToken(SqlParser.AS, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_selectElement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterSelectElement" ):
                listener.enterSelectElement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitSelectElement" ):
                listener.exitSelectElement(self)




    def selectElement(self):

        localctx = SqlParser.SelectElementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 14, self.RULE_selectElement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 202
            self.expression()
            self.state = 207
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==16 or _la==198 or _la==200:
                self.state = 204
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==16:
                    self.state = 203
                    self.match(SqlParser.AS)


                self.state = 206
                _la = self._input.LA(1)
                if not(_la==198 or _la==200):
                    self._errHandler.recoverInline(self)
                else:
                    self._errHandler.reportMatch(self)
                    self.consume()


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class TableSourceContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def tableName(self):
            return self.getTypedRuleContext(SqlParser.TableNameContext,0)


        def IDENTIFIER(self):
            return self.getToken(SqlParser.IDENTIFIER, 0)

        def AS(self):
            return self.getToken(SqlParser.AS, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_tableSource

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterTableSource" ):
                listener.enterTableSource(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitTableSource" ):
                listener.exitTableSource(self)




    def tableSource(self):

        localctx = SqlParser.TableSourceContext(self, self._ctx, self.state)
        self.enterRule(localctx, 16, self.RULE_tableSource)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 209
            self.tableName()
            self.state = 214
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==16 or _la==200:
                self.state = 211
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==16:
                    self.state = 210
                    self.match(SqlParser.AS)


                self.state = 213
                self.match(SqlParser.IDENTIFIER)


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class TableNameContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def BRACKET_IDENTIFIER(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.BRACKET_IDENTIFIER)
            else:
                return self.getToken(SqlParser.BRACKET_IDENTIFIER, i)

        def IDENTIFIER(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.IDENTIFIER)
            else:
                return self.getToken(SqlParser.IDENTIFIER, i)

        def DOT(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.DOT)
            else:
                return self.getToken(SqlParser.DOT, i)

        def getRuleIndex(self):
            return SqlParser.RULE_tableName

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterTableName" ):
                listener.enterTableName(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitTableName" ):
                listener.exitTableName(self)




    def tableName(self):

        localctx = SqlParser.TableNameContext(self, self._ctx, self.state)
        self.enterRule(localctx, 18, self.RULE_tableName)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 216
            _la = self._input.LA(1)
            if not(_la==199 or _la==200):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
            self.state = 221
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==214:
                self.state = 217
                self.match(SqlParser.DOT)
                self.state = 218
                _la = self._input.LA(1)
                if not(_la==199 or _la==200):
                    self._errHandler.recoverInline(self)
                else:
                    self._errHandler.reportMatch(self)
                    self.consume()
                self.state = 223
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class JoinClauseContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def joinType(self):
            return self.getTypedRuleContext(SqlParser.JoinTypeContext,0)


        def JOIN(self):
            return self.getToken(SqlParser.JOIN, 0)

        def tableSource(self):
            return self.getTypedRuleContext(SqlParser.TableSourceContext,0)


        def ON(self):
            return self.getToken(SqlParser.ON, 0)

        def searchCondition(self):
            return self.getTypedRuleContext(SqlParser.SearchConditionContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_joinClause

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterJoinClause" ):
                listener.enterJoinClause(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitJoinClause" ):
                listener.exitJoinClause(self)




    def joinClause(self):

        localctx = SqlParser.JoinClauseContext(self, self._ctx, self.state)
        self.enterRule(localctx, 20, self.RULE_joinClause)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 224
            self.joinType()
            self.state = 225
            self.match(SqlParser.JOIN)
            self.state = 226
            self.tableSource()
            self.state = 227
            self.match(SqlParser.ON)
            self.state = 228
            self.searchCondition()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class JoinTypeContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def INNER(self):
            return self.getToken(SqlParser.INNER, 0)

        def OUTER(self):
            return self.getToken(SqlParser.OUTER, 0)

        def LEFT(self):
            return self.getToken(SqlParser.LEFT, 0)

        def RIGHT(self):
            return self.getToken(SqlParser.RIGHT, 0)

        def FULL(self):
            return self.getToken(SqlParser.FULL, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_joinType

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterJoinType" ):
                listener.enterJoinType(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitJoinType" ):
                listener.exitJoinType(self)




    def joinType(self):

        localctx = SqlParser.JoinTypeContext(self, self._ctx, self.state)
        self.enterRule(localctx, 22, self.RULE_joinType)
        self._la = 0 # Token type
        try:
            self.state = 247
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [69]:
                self.enterOuterAlt(localctx, 1)
                self.state = 230
                self.match(SqlParser.INNER)
                self.state = 232
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==162:
                    self.state = 231
                    self.match(SqlParser.OUTER)


                pass
            elif token in [93]:
                self.enterOuterAlt(localctx, 2)
                self.state = 234
                self.match(SqlParser.LEFT)
                self.state = 236
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==162:
                    self.state = 235
                    self.match(SqlParser.OUTER)


                pass
            elif token in [43]:
                self.enterOuterAlt(localctx, 3)
                self.state = 238
                self.match(SqlParser.RIGHT)
                self.state = 240
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==162:
                    self.state = 239
                    self.match(SqlParser.OUTER)


                pass
            elif token in [29]:
                self.enterOuterAlt(localctx, 4)
                self.state = 242
                self.match(SqlParser.FULL)
                self.state = 244
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==162:
                    self.state = 243
                    self.match(SqlParser.OUTER)


                pass
            elif token in [84]:
                self.enterOuterAlt(localctx, 5)

                pass
            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class ColumnNameContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def BRACKET_IDENTIFIER(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.BRACKET_IDENTIFIER)
            else:
                return self.getToken(SqlParser.BRACKET_IDENTIFIER, i)

        def IDENTIFIER(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.IDENTIFIER)
            else:
                return self.getToken(SqlParser.IDENTIFIER, i)

        def DOT(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.DOT)
            else:
                return self.getToken(SqlParser.DOT, i)

        def getRuleIndex(self):
            return SqlParser.RULE_columnName

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterColumnName" ):
                listener.enterColumnName(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitColumnName" ):
                listener.exitColumnName(self)




    def columnName(self):

        localctx = SqlParser.ColumnNameContext(self, self._ctx, self.state)
        self.enterRule(localctx, 24, self.RULE_columnName)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 249
            _la = self._input.LA(1)
            if not(_la==199 or _la==200):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
            self.state = 254
            self._errHandler.sync(self)
            _alt = self._interp.adaptivePredict(self._input,24,self._ctx)
            while _alt!=2 and _alt!=ATN.INVALID_ALT_NUMBER:
                if _alt==1:
                    self.state = 250
                    self.match(SqlParser.DOT)
                    self.state = 251
                    _la = self._input.LA(1)
                    if not(_la==199 or _la==200):
                        self._errHandler.recoverInline(self)
                    else:
                        self._errHandler.reportMatch(self)
                        self.consume() 
                self.state = 256
                self._errHandler.sync(self)
                _alt = self._interp.adaptivePredict(self._input,24,self._ctx)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class WhereClauseContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def WHERE(self):
            return self.getToken(SqlParser.WHERE, 0)

        def searchCondition(self):
            return self.getTypedRuleContext(SqlParser.SearchConditionContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_whereClause

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterWhereClause" ):
                listener.enterWhereClause(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitWhereClause" ):
                listener.exitWhereClause(self)




    def whereClause(self):

        localctx = SqlParser.WhereClauseContext(self, self._ctx, self.state)
        self.enterRule(localctx, 26, self.RULE_whereClause)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 257
            self.match(SqlParser.WHERE)
            self.state = 258
            self.searchCondition()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class GroupByClauseContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def GROUP(self):
            return self.getToken(SqlParser.GROUP, 0)

        def BY(self):
            return self.getToken(SqlParser.BY, 0)

        def columnName(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.ColumnNameContext)
            else:
                return self.getTypedRuleContext(SqlParser.ColumnNameContext,i)


        def COMMA(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.COMMA)
            else:
                return self.getToken(SqlParser.COMMA, i)

        def getRuleIndex(self):
            return SqlParser.RULE_groupByClause

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterGroupByClause" ):
                listener.enterGroupByClause(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitGroupByClause" ):
                listener.exitGroupByClause(self)




    def groupByClause(self):

        localctx = SqlParser.GroupByClauseContext(self, self._ctx, self.state)
        self.enterRule(localctx, 28, self.RULE_groupByClause)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 260
            self.match(SqlParser.GROUP)
            self.state = 261
            self.match(SqlParser.BY)
            self.state = 262
            self.columnName()
            self.state = 267
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==213:
                self.state = 263
                self.match(SqlParser.COMMA)
                self.state = 264
                self.columnName()
                self.state = 269
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class OrderByClauseContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def ORDER(self):
            return self.getToken(SqlParser.ORDER, 0)

        def BY(self):
            return self.getToken(SqlParser.BY, 0)

        def orderElement(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.OrderElementContext)
            else:
                return self.getTypedRuleContext(SqlParser.OrderElementContext,i)


        def COMMA(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.COMMA)
            else:
                return self.getToken(SqlParser.COMMA, i)

        def getRuleIndex(self):
            return SqlParser.RULE_orderByClause

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterOrderByClause" ):
                listener.enterOrderByClause(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitOrderByClause" ):
                listener.exitOrderByClause(self)




    def orderByClause(self):

        localctx = SqlParser.OrderByClauseContext(self, self._ctx, self.state)
        self.enterRule(localctx, 30, self.RULE_orderByClause)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 270
            self.match(SqlParser.ORDER)
            self.state = 271
            self.match(SqlParser.BY)
            self.state = 272
            self.orderElement()
            self.state = 277
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==213:
                self.state = 273
                self.match(SqlParser.COMMA)
                self.state = 274
                self.orderElement()
                self.state = 279
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class OrderElementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def columnName(self):
            return self.getTypedRuleContext(SqlParser.ColumnNameContext,0)


        def ASC(self):
            return self.getToken(SqlParser.ASC, 0)

        def DESC(self):
            return self.getToken(SqlParser.DESC, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_orderElement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterOrderElement" ):
                listener.enterOrderElement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitOrderElement" ):
                listener.exitOrderElement(self)




    def orderElement(self):

        localctx = SqlParser.OrderElementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 32, self.RULE_orderElement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 280
            self.columnName()
            self.state = 282
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==19 or _la==140:
                self.state = 281
                _la = self._input.LA(1)
                if not(_la==19 or _la==140):
                    self._errHandler.recoverInline(self)
                else:
                    self._errHandler.reportMatch(self)
                    self.consume()


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class SearchConditionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def orExpression(self):
            return self.getTypedRuleContext(SqlParser.OrExpressionContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_searchCondition

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterSearchCondition" ):
                listener.enterSearchCondition(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitSearchCondition" ):
                listener.exitSearchCondition(self)




    def searchCondition(self):

        localctx = SqlParser.SearchConditionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 34, self.RULE_searchCondition)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 284
            self.orExpression(0)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class OrExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def andExpression(self):
            return self.getTypedRuleContext(SqlParser.AndExpressionContext,0)


        def orExpression(self):
            return self.getTypedRuleContext(SqlParser.OrExpressionContext,0)


        def OR(self):
            return self.getToken(SqlParser.OR, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_orExpression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterOrExpression" ):
                listener.enterOrExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitOrExpression" ):
                listener.exitOrExpression(self)



    def orExpression(self, _p:int=0):
        _parentctx = self._ctx
        _parentState = self.state
        localctx = SqlParser.OrExpressionContext(self, self._ctx, _parentState)
        _prevctx = localctx
        _startState = 36
        self.enterRecursionRule(localctx, 36, self.RULE_orExpression, _p)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 287
            self.andExpression(0)
            self._ctx.stop = self._input.LT(-1)
            self.state = 294
            self._errHandler.sync(self)
            _alt = self._interp.adaptivePredict(self._input,28,self._ctx)
            while _alt!=2 and _alt!=ATN.INVALID_ALT_NUMBER:
                if _alt==1:
                    if self._parseListeners is not None:
                        self.triggerExitRuleEvent()
                    _prevctx = localctx
                    localctx = SqlParser.OrExpressionContext(self, _parentctx, _parentState)
                    self.pushNewRecursionContext(localctx, _startState, self.RULE_orExpression)
                    self.state = 289
                    if not self.precpred(self._ctx, 2):
                        from antlr4.error.Errors import FailedPredicateException
                        raise FailedPredicateException(self, "self.precpred(self._ctx, 2)")
                    self.state = 290
                    self.match(SqlParser.OR)
                    self.state = 291
                    self.andExpression(0) 
                self.state = 296
                self._errHandler.sync(self)
                _alt = self._interp.adaptivePredict(self._input,28,self._ctx)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.unrollRecursionContexts(_parentctx)
        return localctx


    class AndExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def notExpression(self):
            return self.getTypedRuleContext(SqlParser.NotExpressionContext,0)


        def andExpression(self):
            return self.getTypedRuleContext(SqlParser.AndExpressionContext,0)


        def AND(self):
            return self.getToken(SqlParser.AND, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_andExpression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterAndExpression" ):
                listener.enterAndExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitAndExpression" ):
                listener.exitAndExpression(self)



    def andExpression(self, _p:int=0):
        _parentctx = self._ctx
        _parentState = self.state
        localctx = SqlParser.AndExpressionContext(self, self._ctx, _parentState)
        _prevctx = localctx
        _startState = 38
        self.enterRecursionRule(localctx, 38, self.RULE_andExpression, _p)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 298
            self.notExpression()
            self._ctx.stop = self._input.LT(-1)
            self.state = 305
            self._errHandler.sync(self)
            _alt = self._interp.adaptivePredict(self._input,29,self._ctx)
            while _alt!=2 and _alt!=ATN.INVALID_ALT_NUMBER:
                if _alt==1:
                    if self._parseListeners is not None:
                        self.triggerExitRuleEvent()
                    _prevctx = localctx
                    localctx = SqlParser.AndExpressionContext(self, _parentctx, _parentState)
                    self.pushNewRecursionContext(localctx, _startState, self.RULE_andExpression)
                    self.state = 300
                    if not self.precpred(self._ctx, 2):
                        from antlr4.error.Errors import FailedPredicateException
                        raise FailedPredicateException(self, "self.precpred(self._ctx, 2)")
                    self.state = 301
                    self.match(SqlParser.AND)
                    self.state = 302
                    self.notExpression() 
                self.state = 307
                self._errHandler.sync(self)
                _alt = self._interp.adaptivePredict(self._input,29,self._ctx)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.unrollRecursionContexts(_parentctx)
        return localctx


    class NotExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def NOT(self):
            return self.getToken(SqlParser.NOT, 0)

        def notExpression(self):
            return self.getTypedRuleContext(SqlParser.NotExpressionContext,0)


        def predicate(self):
            return self.getTypedRuleContext(SqlParser.PredicateContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_notExpression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterNotExpression" ):
                listener.enterNotExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitNotExpression" ):
                listener.exitNotExpression(self)




    def notExpression(self):

        localctx = SqlParser.NotExpressionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 40, self.RULE_notExpression)
        try:
            self.state = 311
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,30,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 308
                self.match(SqlParser.NOT)
                self.state = 309
                self.notExpression()
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 310
                self.predicate()
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class PredicateContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def LPAREN(self):
            return self.getToken(SqlParser.LPAREN, 0)

        def searchCondition(self):
            return self.getTypedRuleContext(SqlParser.SearchConditionContext,0)


        def RPAREN(self):
            return self.getToken(SqlParser.RPAREN, 0)

        def expression(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.ExpressionContext)
            else:
                return self.getTypedRuleContext(SqlParser.ExpressionContext,i)


        def comparisonOperator(self):
            return self.getTypedRuleContext(SqlParser.ComparisonOperatorContext,0)


        def IN(self):
            return self.getToken(SqlParser.IN, 0)

        def selectStatement(self):
            return self.getTypedRuleContext(SqlParser.SelectStatementContext,0)


        def NOT(self):
            return self.getToken(SqlParser.NOT, 0)

        def COMMA(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.COMMA)
            else:
                return self.getToken(SqlParser.COMMA, i)

        def IS(self):
            return self.getToken(SqlParser.IS, 0)

        def NULL(self):
            return self.getToken(SqlParser.NULL, 0)

        def EXISTS(self):
            return self.getToken(SqlParser.EXISTS, 0)

        def BETWEEN(self):
            return self.getToken(SqlParser.BETWEEN, 0)

        def AND(self):
            return self.getToken(SqlParser.AND, 0)

        def LIKE(self):
            return self.getToken(SqlParser.LIKE, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_predicate

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterPredicate" ):
                listener.enterPredicate(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitPredicate" ):
                listener.exitPredicate(self)




    def predicate(self):

        localctx = SqlParser.PredicateContext(self, self._ctx, self.state)
        self.enterRule(localctx, 42, self.RULE_predicate)
        self._la = 0 # Token type
        try:
            self.state = 375
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,37,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 313
                self.match(SqlParser.LPAREN)
                self.state = 314
                self.searchCondition()
                self.state = 315
                self.match(SqlParser.RPAREN)
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 317
                self.expression()
                self.state = 318
                self.comparisonOperator()
                self.state = 319
                self.expression()
                pass

            elif la_ == 3:
                self.enterOuterAlt(localctx, 3)
                self.state = 321
                self.expression()
                self.state = 323
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==117:
                    self.state = 322
                    self.match(SqlParser.NOT)


                self.state = 325
                self.match(SqlParser.IN)
                self.state = 326
                self.match(SqlParser.LPAREN)
                self.state = 336
                self._errHandler.sync(self)
                token = self._input.LA(1)
                if token in [120, 184, 185, 186, 187, 188, 192, 193, 196, 197, 198, 199, 200, 201, 208, 209, 215]:
                    self.state = 327
                    self.expression()
                    self.state = 332
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)
                    while _la==213:
                        self.state = 328
                        self.match(SqlParser.COMMA)
                        self.state = 329
                        self.expression()
                        self.state = 334
                        self._errHandler.sync(self)
                        _la = self._input.LA(1)

                    pass
                elif token in [67]:
                    self.state = 335
                    self.selectStatement()
                    pass
                else:
                    raise NoViableAltException(self)

                self.state = 338
                self.match(SqlParser.RPAREN)
                pass

            elif la_ == 4:
                self.enterOuterAlt(localctx, 4)
                self.state = 340
                self.expression()
                self.state = 341
                self.match(SqlParser.IS)
                self.state = 343
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==117:
                    self.state = 342
                    self.match(SqlParser.NOT)


                self.state = 345
                self.match(SqlParser.NULL)
                pass

            elif la_ == 5:
                self.enterOuterAlt(localctx, 5)
                self.state = 347
                self.match(SqlParser.EXISTS)
                self.state = 348
                self.match(SqlParser.LPAREN)
                self.state = 349
                self.selectStatement()
                self.state = 350
                self.match(SqlParser.RPAREN)
                pass

            elif la_ == 6:
                self.enterOuterAlt(localctx, 6)
                self.state = 352
                self.match(SqlParser.NOT)
                self.state = 353
                self.match(SqlParser.EXISTS)
                self.state = 354
                self.match(SqlParser.LPAREN)
                self.state = 355
                self.selectStatement()
                self.state = 356
                self.match(SqlParser.RPAREN)
                pass

            elif la_ == 7:
                self.enterOuterAlt(localctx, 7)
                self.state = 358
                self.expression()
                self.state = 360
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==117:
                    self.state = 359
                    self.match(SqlParser.NOT)


                self.state = 362
                self.match(SqlParser.BETWEEN)
                self.state = 363
                self.expression()
                self.state = 364
                self.match(SqlParser.AND)
                self.state = 365
                self.expression()
                pass

            elif la_ == 8:
                self.enterOuterAlt(localctx, 8)

                pass

            elif la_ == 9:
                self.enterOuterAlt(localctx, 9)
                self.state = 368
                self.expression()
                self.state = 370
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==117:
                    self.state = 369
                    self.match(SqlParser.NOT)


                self.state = 372
                self.match(SqlParser.LIKE)
                self.state = 373
                self.expression()
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class ComparisonOperatorContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def EQ(self):
            return self.getToken(SqlParser.EQ, 0)

        def NEQ(self):
            return self.getToken(SqlParser.NEQ, 0)

        def GT(self):
            return self.getToken(SqlParser.GT, 0)

        def GTE(self):
            return self.getToken(SqlParser.GTE, 0)

        def LT(self):
            return self.getToken(SqlParser.LT, 0)

        def LTE(self):
            return self.getToken(SqlParser.LTE, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_comparisonOperator

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterComparisonOperator" ):
                listener.enterComparisonOperator(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitComparisonOperator" ):
                listener.exitComparisonOperator(self)




    def comparisonOperator(self):

        localctx = SqlParser.ComparisonOperatorContext(self, self._ctx, self.state)
        self.enterRule(localctx, 44, self.RULE_comparisonOperator)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 377
            _la = self._input.LA(1)
            if not(((((_la - 202)) & ~0x3f) == 0 and ((1 << (_la - 202)) & 63) != 0)):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class ExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def assignmentExpression(self):
            return self.getTypedRuleContext(SqlParser.AssignmentExpressionContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_expression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterExpression" ):
                listener.enterExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitExpression" ):
                listener.exitExpression(self)




    def expression(self):

        localctx = SqlParser.ExpressionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 46, self.RULE_expression)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 379
            self.assignmentExpression()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class AssignmentExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def USER_VAR(self):
            return self.getToken(SqlParser.USER_VAR, 0)

        def additiveExpression(self):
            return self.getTypedRuleContext(SqlParser.AdditiveExpressionContext,0)


        def EQ(self):
            return self.getToken(SqlParser.EQ, 0)

        def PLUS_EQ(self):
            return self.getToken(SqlParser.PLUS_EQ, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_assignmentExpression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterAssignmentExpression" ):
                listener.enterAssignmentExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitAssignmentExpression" ):
                listener.exitAssignmentExpression(self)




    def assignmentExpression(self):

        localctx = SqlParser.AssignmentExpressionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 48, self.RULE_assignmentExpression)
        self._la = 0 # Token type
        try:
            self.state = 385
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,38,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 381
                self.match(SqlParser.USER_VAR)
                self.state = 382
                _la = self._input.LA(1)
                if not(_la==202 or _la==212):
                    self._errHandler.recoverInline(self)
                else:
                    self._errHandler.reportMatch(self)
                    self.consume()
                self.state = 383
                self.additiveExpression(0)
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 384
                self.additiveExpression(0)
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class AdditiveExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def multiplicativeExpression(self):
            return self.getTypedRuleContext(SqlParser.MultiplicativeExpressionContext,0)


        def additiveExpression(self):
            return self.getTypedRuleContext(SqlParser.AdditiveExpressionContext,0)


        def PLUS(self):
            return self.getToken(SqlParser.PLUS, 0)

        def MINUS(self):
            return self.getToken(SqlParser.MINUS, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_additiveExpression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterAdditiveExpression" ):
                listener.enterAdditiveExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitAdditiveExpression" ):
                listener.exitAdditiveExpression(self)



    def additiveExpression(self, _p:int=0):
        _parentctx = self._ctx
        _parentState = self.state
        localctx = SqlParser.AdditiveExpressionContext(self, self._ctx, _parentState)
        _prevctx = localctx
        _startState = 50
        self.enterRecursionRule(localctx, 50, self.RULE_additiveExpression, _p)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 388
            self.multiplicativeExpression(0)
            self._ctx.stop = self._input.LT(-1)
            self.state = 398
            self._errHandler.sync(self)
            _alt = self._interp.adaptivePredict(self._input,40,self._ctx)
            while _alt!=2 and _alt!=ATN.INVALID_ALT_NUMBER:
                if _alt==1:
                    if self._parseListeners is not None:
                        self.triggerExitRuleEvent()
                    _prevctx = localctx
                    self.state = 396
                    self._errHandler.sync(self)
                    la_ = self._interp.adaptivePredict(self._input,39,self._ctx)
                    if la_ == 1:
                        localctx = SqlParser.AdditiveExpressionContext(self, _parentctx, _parentState)
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_additiveExpression)
                        self.state = 390
                        if not self.precpred(self._ctx, 3):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 3)")
                        self.state = 391
                        self.match(SqlParser.PLUS)
                        self.state = 392
                        self.multiplicativeExpression(0)
                        pass

                    elif la_ == 2:
                        localctx = SqlParser.AdditiveExpressionContext(self, _parentctx, _parentState)
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_additiveExpression)
                        self.state = 393
                        if not self.precpred(self._ctx, 2):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 2)")
                        self.state = 394
                        self.match(SqlParser.MINUS)
                        self.state = 395
                        self.multiplicativeExpression(0)
                        pass

             
                self.state = 400
                self._errHandler.sync(self)
                _alt = self._interp.adaptivePredict(self._input,40,self._ctx)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.unrollRecursionContexts(_parentctx)
        return localctx


    class MultiplicativeExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def unaryExpression(self):
            return self.getTypedRuleContext(SqlParser.UnaryExpressionContext,0)


        def multiplicativeExpression(self):
            return self.getTypedRuleContext(SqlParser.MultiplicativeExpressionContext,0)


        def STAR(self):
            return self.getToken(SqlParser.STAR, 0)

        def SLASH(self):
            return self.getToken(SqlParser.SLASH, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_multiplicativeExpression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterMultiplicativeExpression" ):
                listener.enterMultiplicativeExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitMultiplicativeExpression" ):
                listener.exitMultiplicativeExpression(self)



    def multiplicativeExpression(self, _p:int=0):
        _parentctx = self._ctx
        _parentState = self.state
        localctx = SqlParser.MultiplicativeExpressionContext(self, self._ctx, _parentState)
        _prevctx = localctx
        _startState = 52
        self.enterRecursionRule(localctx, 52, self.RULE_multiplicativeExpression, _p)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 402
            self.unaryExpression()
            self._ctx.stop = self._input.LT(-1)
            self.state = 412
            self._errHandler.sync(self)
            _alt = self._interp.adaptivePredict(self._input,42,self._ctx)
            while _alt!=2 and _alt!=ATN.INVALID_ALT_NUMBER:
                if _alt==1:
                    if self._parseListeners is not None:
                        self.triggerExitRuleEvent()
                    _prevctx = localctx
                    self.state = 410
                    self._errHandler.sync(self)
                    la_ = self._interp.adaptivePredict(self._input,41,self._ctx)
                    if la_ == 1:
                        localctx = SqlParser.MultiplicativeExpressionContext(self, _parentctx, _parentState)
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_multiplicativeExpression)
                        self.state = 404
                        if not self.precpred(self._ctx, 3):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 3)")
                        self.state = 405
                        self.match(SqlParser.STAR)
                        self.state = 406
                        self.unaryExpression()
                        pass

                    elif la_ == 2:
                        localctx = SqlParser.MultiplicativeExpressionContext(self, _parentctx, _parentState)
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_multiplicativeExpression)
                        self.state = 407
                        if not self.precpred(self._ctx, 2):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 2)")
                        self.state = 408
                        self.match(SqlParser.SLASH)
                        self.state = 409
                        self.unaryExpression()
                        pass

             
                self.state = 414
                self._errHandler.sync(self)
                _alt = self._interp.adaptivePredict(self._input,42,self._ctx)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.unrollRecursionContexts(_parentctx)
        return localctx


    class UnaryExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def PLUS(self):
            return self.getToken(SqlParser.PLUS, 0)

        def unaryExpression(self):
            return self.getTypedRuleContext(SqlParser.UnaryExpressionContext,0)


        def MINUS(self):
            return self.getToken(SqlParser.MINUS, 0)

        def primaryExpression(self):
            return self.getTypedRuleContext(SqlParser.PrimaryExpressionContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_unaryExpression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterUnaryExpression" ):
                listener.enterUnaryExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitUnaryExpression" ):
                listener.exitUnaryExpression(self)




    def unaryExpression(self):

        localctx = SqlParser.UnaryExpressionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 54, self.RULE_unaryExpression)
        try:
            self.state = 420
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [208]:
                self.enterOuterAlt(localctx, 1)
                self.state = 415
                self.match(SqlParser.PLUS)
                self.state = 416
                self.unaryExpression()
                pass
            elif token in [209]:
                self.enterOuterAlt(localctx, 2)
                self.state = 417
                self.match(SqlParser.MINUS)
                self.state = 418
                self.unaryExpression()
                pass
            elif token in [120, 184, 185, 186, 187, 188, 192, 193, 196, 197, 198, 199, 200, 201, 215]:
                self.enterOuterAlt(localctx, 3)
                self.state = 419
                self.primaryExpression()
                pass
            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class PrimaryExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def LPAREN(self):
            return self.getToken(SqlParser.LPAREN, 0)

        def selectStatement(self):
            return self.getTypedRuleContext(SqlParser.SelectStatementContext,0)


        def RPAREN(self):
            return self.getToken(SqlParser.RPAREN, 0)

        def expression(self):
            return self.getTypedRuleContext(SqlParser.ExpressionContext,0)


        def functionCall(self):
            return self.getTypedRuleContext(SqlParser.FunctionCallContext,0)


        def columnName(self):
            return self.getTypedRuleContext(SqlParser.ColumnNameContext,0)


        def literal(self):
            return self.getTypedRuleContext(SqlParser.LiteralContext,0)


        def USER_VAR(self):
            return self.getToken(SqlParser.USER_VAR, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_primaryExpression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterPrimaryExpression" ):
                listener.enterPrimaryExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitPrimaryExpression" ):
                listener.exitPrimaryExpression(self)




    def primaryExpression(self):

        localctx = SqlParser.PrimaryExpressionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 56, self.RULE_primaryExpression)
        try:
            self.state = 434
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,44,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 422
                self.match(SqlParser.LPAREN)
                self.state = 423
                self.selectStatement()
                self.state = 424
                self.match(SqlParser.RPAREN)
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 426
                self.match(SqlParser.LPAREN)
                self.state = 427
                self.expression()
                self.state = 428
                self.match(SqlParser.RPAREN)
                pass

            elif la_ == 3:
                self.enterOuterAlt(localctx, 3)
                self.state = 430
                self.functionCall()
                pass

            elif la_ == 4:
                self.enterOuterAlt(localctx, 4)
                self.state = 431
                self.columnName()
                pass

            elif la_ == 5:
                self.enterOuterAlt(localctx, 5)
                self.state = 432
                self.literal()
                pass

            elif la_ == 6:
                self.enterOuterAlt(localctx, 6)
                self.state = 433
                self.match(SqlParser.USER_VAR)
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class CaseExpressionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def CASE(self):
            return self.getToken(SqlParser.CASE, 0)

        def END(self):
            return self.getToken(SqlParser.END, 0)

        def whenClause(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.WhenClauseContext)
            else:
                return self.getTypedRuleContext(SqlParser.WhenClauseContext,i)


        def ELSE(self):
            return self.getToken(SqlParser.ELSE, 0)

        def expression(self):
            return self.getTypedRuleContext(SqlParser.ExpressionContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_caseExpression

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterCaseExpression" ):
                listener.enterCaseExpression(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitCaseExpression" ):
                listener.exitCaseExpression(self)




    def caseExpression(self):

        localctx = SqlParser.CaseExpressionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 58, self.RULE_caseExpression)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 436
            self.match(SqlParser.CASE)
            self.state = 438 
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while True:
                self.state = 437
                self.whenClause()
                self.state = 440 
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if not (_la==166):
                    break

            self.state = 444
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==161:
                self.state = 442
                self.match(SqlParser.ELSE)
                self.state = 443
                self.expression()


            self.state = 446
            self.match(SqlParser.END)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class WhenClauseContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def WHEN(self):
            return self.getToken(SqlParser.WHEN, 0)

        def searchCondition(self):
            return self.getTypedRuleContext(SqlParser.SearchConditionContext,0)


        def THEN(self):
            return self.getToken(SqlParser.THEN, 0)

        def expression(self):
            return self.getTypedRuleContext(SqlParser.ExpressionContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_whenClause

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterWhenClause" ):
                listener.enterWhenClause(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitWhenClause" ):
                listener.exitWhenClause(self)




    def whenClause(self):

        localctx = SqlParser.WhenClauseContext(self, self._ctx, self.state)
        self.enterRule(localctx, 60, self.RULE_whenClause)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 448
            self.match(SqlParser.WHEN)
            self.state = 449
            self.searchCondition()
            self.state = 450
            self.match(SqlParser.THEN)
            self.state = 451
            self.expression()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class LiteralContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def INT_LITERAL(self):
            return self.getToken(SqlParser.INT_LITERAL, 0)

        def FLOAT_LITERAL(self):
            return self.getToken(SqlParser.FLOAT_LITERAL, 0)

        def STRING_LITERAL(self):
            return self.getToken(SqlParser.STRING_LITERAL, 0)

        def TRUE_LITERAL(self):
            return self.getToken(SqlParser.TRUE_LITERAL, 0)

        def FALSE_LITERAL(self):
            return self.getToken(SqlParser.FALSE_LITERAL, 0)

        def NULL(self):
            return self.getToken(SqlParser.NULL, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_literal

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterLiteral" ):
                listener.enterLiteral(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitLiteral" ):
                listener.exitLiteral(self)




    def literal(self):

        localctx = SqlParser.LiteralContext(self, self._ctx, self.state)
        self.enterRule(localctx, 62, self.RULE_literal)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 453
            _la = self._input.LA(1)
            if not(_la==120 or ((((_la - 192)) & ~0x3f) == 0 and ((1 << (_la - 192)) & 115) != 0)):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class FunctionCallContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def LPAREN(self):
            return self.getToken(SqlParser.LPAREN, 0)

        def RPAREN(self):
            return self.getToken(SqlParser.RPAREN, 0)

        def IDENTIFIER(self):
            return self.getToken(SqlParser.IDENTIFIER, 0)

        def BRACKET_IDENTIFIER(self):
            return self.getToken(SqlParser.BRACKET_IDENTIFIER, 0)

        def MAX(self):
            return self.getToken(SqlParser.MAX, 0)

        def AVG(self):
            return self.getToken(SqlParser.AVG, 0)

        def COUNT(self):
            return self.getToken(SqlParser.COUNT, 0)

        def SUM(self):
            return self.getToken(SqlParser.SUM, 0)

        def MIN(self):
            return self.getToken(SqlParser.MIN, 0)

        def expression(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.ExpressionContext)
            else:
                return self.getTypedRuleContext(SqlParser.ExpressionContext,i)


        def COMMA(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.COMMA)
            else:
                return self.getToken(SqlParser.COMMA, i)

        def getRuleIndex(self):
            return SqlParser.RULE_functionCall

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterFunctionCall" ):
                listener.enterFunctionCall(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitFunctionCall" ):
                listener.exitFunctionCall(self)




    def functionCall(self):

        localctx = SqlParser.FunctionCallContext(self, self._ctx, self.state)
        self.enterRule(localctx, 64, self.RULE_functionCall)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 455
            _la = self._input.LA(1)
            if not(((((_la - 184)) & ~0x3f) == 0 and ((1 << (_la - 184)) & 98335) != 0)):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
            self.state = 456
            self.match(SqlParser.LPAREN)
            self.state = 465
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==120 or ((((_la - 184)) & ~0x3f) == 0 and ((1 << (_la - 184)) & 2198074143) != 0):
                self.state = 457
                self.expression()
                self.state = 462
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==213:
                    self.state = 458
                    self.match(SqlParser.COMMA)
                    self.state = 459
                    self.expression()
                    self.state = 464
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)



            self.state = 467
            self.match(SqlParser.RPAREN)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class InsertStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def INSERT(self):
            return self.getToken(SqlParser.INSERT, 0)

        def INTO(self):
            return self.getToken(SqlParser.INTO, 0)

        def tableName(self):
            return self.getTypedRuleContext(SqlParser.TableNameContext,0)


        def LPAREN(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.LPAREN)
            else:
                return self.getToken(SqlParser.LPAREN, i)

        def columnName(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.ColumnNameContext)
            else:
                return self.getTypedRuleContext(SqlParser.ColumnNameContext,i)


        def RPAREN(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.RPAREN)
            else:
                return self.getToken(SqlParser.RPAREN, i)

        def VALUES(self):
            return self.getToken(SqlParser.VALUES, 0)

        def literal(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.LiteralContext)
            else:
                return self.getTypedRuleContext(SqlParser.LiteralContext,i)


        def COMMA(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.COMMA)
            else:
                return self.getToken(SqlParser.COMMA, i)

        def getRuleIndex(self):
            return SqlParser.RULE_insertStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterInsertStatement" ):
                listener.enterInsertStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitInsertStatement" ):
                listener.exitInsertStatement(self)




    def insertStatement(self):

        localctx = SqlParser.InsertStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 66, self.RULE_insertStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 469
            self.match(SqlParser.INSERT)
            self.state = 470
            self.match(SqlParser.INTO)
            self.state = 471
            self.tableName()
            self.state = 472
            self.match(SqlParser.LPAREN)
            self.state = 473
            self.columnName()
            self.state = 478
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==213:
                self.state = 474
                self.match(SqlParser.COMMA)
                self.state = 475
                self.columnName()
                self.state = 480
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 481
            self.match(SqlParser.RPAREN)
            self.state = 482
            self.match(SqlParser.VALUES)

            self.state = 483
            self.match(SqlParser.LPAREN)
            self.state = 484
            self.literal()
            self.state = 489
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==213:
                self.state = 485
                self.match(SqlParser.COMMA)
                self.state = 486
                self.literal()
                self.state = 491
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 492
            self.match(SqlParser.RPAREN)
            self.state = 508
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==213:
                self.state = 494
                self.match(SqlParser.COMMA)
                self.state = 495
                self.match(SqlParser.LPAREN)
                self.state = 496
                self.literal()
                self.state = 501
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==213:
                    self.state = 497
                    self.match(SqlParser.COMMA)
                    self.state = 498
                    self.literal()
                    self.state = 503
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)

                self.state = 504
                self.match(SqlParser.RPAREN)
                self.state = 510
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class UpdateStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def UPDATE(self):
            return self.getToken(SqlParser.UPDATE, 0)

        def tableName(self):
            return self.getTypedRuleContext(SqlParser.TableNameContext,0)


        def SET(self):
            return self.getToken(SqlParser.SET, 0)

        def assignment(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.AssignmentContext)
            else:
                return self.getTypedRuleContext(SqlParser.AssignmentContext,i)


        def COMMA(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.COMMA)
            else:
                return self.getToken(SqlParser.COMMA, i)

        def whereClause(self):
            return self.getTypedRuleContext(SqlParser.WhereClauseContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_updateStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterUpdateStatement" ):
                listener.enterUpdateStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitUpdateStatement" ):
                listener.exitUpdateStatement(self)




    def updateStatement(self):

        localctx = SqlParser.UpdateStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 68, self.RULE_updateStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 511
            self.match(SqlParser.UPDATE)
            self.state = 512
            self.tableName()
            self.state = 513
            self.match(SqlParser.SET)
            self.state = 514
            self.assignment()
            self.state = 519
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==213:
                self.state = 515
                self.match(SqlParser.COMMA)
                self.state = 516
                self.assignment()
                self.state = 521
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 523
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==169:
                self.state = 522
                self.whereClause()


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class AssignmentContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def columnName(self):
            return self.getTypedRuleContext(SqlParser.ColumnNameContext,0)


        def expression(self):
            return self.getTypedRuleContext(SqlParser.ExpressionContext,0)


        def EQ(self):
            return self.getToken(SqlParser.EQ, 0)

        def PLUS_EQ(self):
            return self.getToken(SqlParser.PLUS_EQ, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_assignment

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterAssignment" ):
                listener.enterAssignment(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitAssignment" ):
                listener.exitAssignment(self)




    def assignment(self):

        localctx = SqlParser.AssignmentContext(self, self._ctx, self.state)
        self.enterRule(localctx, 70, self.RULE_assignment)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 525
            self.columnName()
            self.state = 526
            _la = self._input.LA(1)
            if not(_la==202 or _la==212):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
            self.state = 527
            self.expression()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class DeleteStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def DELETE(self):
            return self.getToken(SqlParser.DELETE, 0)

        def FROM(self):
            return self.getToken(SqlParser.FROM, 0)

        def tableName(self):
            return self.getTypedRuleContext(SqlParser.TableNameContext,0)


        def whereClause(self):
            return self.getTypedRuleContext(SqlParser.WhereClauseContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_deleteStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterDeleteStatement" ):
                listener.enterDeleteStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitDeleteStatement" ):
                listener.exitDeleteStatement(self)




    def deleteStatement(self):

        localctx = SqlParser.DeleteStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 72, self.RULE_deleteStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 529
            self.match(SqlParser.DELETE)
            self.state = 530
            self.match(SqlParser.FROM)
            self.state = 531
            self.tableName()
            self.state = 533
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==169:
                self.state = 532
                self.whereClause()


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class DdlStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def createTableStatement(self):
            return self.getTypedRuleContext(SqlParser.CreateTableStatementContext,0)


        def dropTableStatement(self):
            return self.getTypedRuleContext(SqlParser.DropTableStatementContext,0)


        def alterTableStatement(self):
            return self.getTypedRuleContext(SqlParser.AlterTableStatementContext,0)


        def declareStatement(self):
            return self.getTypedRuleContext(SqlParser.DeclareStatementContext,0)


        def useDatabaseStatement(self):
            return self.getTypedRuleContext(SqlParser.UseDatabaseStatementContext,0)


        def truncateTableStatement(self):
            return self.getTypedRuleContext(SqlParser.TruncateTableStatementContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_ddlStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterDdlStatement" ):
                listener.enterDdlStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitDdlStatement" ):
                listener.exitDdlStatement(self)




    def ddlStatement(self):

        localctx = SqlParser.DdlStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 74, self.RULE_ddlStatement)
        try:
            self.state = 541
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [95]:
                self.enterOuterAlt(localctx, 1)
                self.state = 535
                self.createTableStatement()
                pass
            elif token in [155]:
                self.enterOuterAlt(localctx, 2)
                self.state = 536
                self.dropTableStatement()
                pass
            elif token in [7]:
                self.enterOuterAlt(localctx, 3)
                self.state = 537
                self.alterTableStatement()
                pass
            elif token in [128]:
                self.enterOuterAlt(localctx, 4)
                self.state = 538
                self.declareStatement()
                pass
            elif token in [148]:
                self.enterOuterAlt(localctx, 5)
                self.state = 539
                self.useDatabaseStatement()
                pass
            elif token in [127]:
                self.enterOuterAlt(localctx, 6)
                self.state = 540
                self.truncateTableStatement()
                pass
            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class CreateTableStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def CREATE(self):
            return self.getToken(SqlParser.CREATE, 0)

        def TABLE(self):
            return self.getToken(SqlParser.TABLE, 0)

        def tableName(self):
            return self.getTypedRuleContext(SqlParser.TableNameContext,0)


        def LPAREN(self):
            return self.getToken(SqlParser.LPAREN, 0)

        def columnDefinition(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.ColumnDefinitionContext)
            else:
                return self.getTypedRuleContext(SqlParser.ColumnDefinitionContext,i)


        def RPAREN(self):
            return self.getToken(SqlParser.RPAREN, 0)

        def COMMA(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.COMMA)
            else:
                return self.getToken(SqlParser.COMMA, i)

        def getRuleIndex(self):
            return SqlParser.RULE_createTableStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterCreateTableStatement" ):
                listener.enterCreateTableStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitCreateTableStatement" ):
                listener.exitCreateTableStatement(self)




    def createTableStatement(self):

        localctx = SqlParser.CreateTableStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 76, self.RULE_createTableStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 543
            self.match(SqlParser.CREATE)
            self.state = 544
            self.match(SqlParser.TABLE)
            self.state = 545
            self.tableName()
            self.state = 546
            self.match(SqlParser.LPAREN)
            self.state = 547
            self.columnDefinition()
            self.state = 552
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==213:
                self.state = 548
                self.match(SqlParser.COMMA)
                self.state = 549
                self.columnDefinition()
                self.state = 554
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 555
            self.match(SqlParser.RPAREN)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class ColumnDefinitionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def columnName(self):
            return self.getTypedRuleContext(SqlParser.ColumnNameContext,0)


        def dataType(self):
            return self.getTypedRuleContext(SqlParser.DataTypeContext,0)


        def nullability(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.NullabilityContext)
            else:
                return self.getTypedRuleContext(SqlParser.NullabilityContext,i)


        def getRuleIndex(self):
            return SqlParser.RULE_columnDefinition

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterColumnDefinition" ):
                listener.enterColumnDefinition(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitColumnDefinition" ):
                listener.exitColumnDefinition(self)




    def columnDefinition(self):

        localctx = SqlParser.ColumnDefinitionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 78, self.RULE_columnDefinition)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 557
            self.columnName()
            self.state = 558
            self.dataType()
            self.state = 562
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==51 or ((((_la - 117)) & ~0x3f) == 0 and ((1 << (_la - 117)) & -9223372036854775799) != 0):
                self.state = 559
                self.nullability()
                self.state = 564
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class NullabilityContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def IDENTITY(self):
            return self.getToken(SqlParser.IDENTITY, 0)

        def PRIMARY(self):
            return self.getToken(SqlParser.PRIMARY, 0)

        def KEY(self):
            return self.getToken(SqlParser.KEY, 0)

        def NULL(self):
            return self.getToken(SqlParser.NULL, 0)

        def NOT(self):
            return self.getToken(SqlParser.NOT, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_nullability

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterNullability" ):
                listener.enterNullability(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitNullability" ):
                listener.exitNullability(self)




    def nullability(self):

        localctx = SqlParser.NullabilityContext(self, self._ctx, self.state)
        self.enterRule(localctx, 80, self.RULE_nullability)
        try:
            self.state = 571
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [51]:
                self.enterOuterAlt(localctx, 1)
                self.state = 565
                self.match(SqlParser.IDENTITY)
                pass
            elif token in [180]:
                self.enterOuterAlt(localctx, 2)
                self.state = 566
                self.match(SqlParser.PRIMARY)
                self.state = 567
                self.match(SqlParser.KEY)
                pass
            elif token in [120]:
                self.enterOuterAlt(localctx, 3)
                self.state = 568
                self.match(SqlParser.NULL)
                pass
            elif token in [117]:
                self.enterOuterAlt(localctx, 4)
                self.state = 569
                self.match(SqlParser.NOT)
                self.state = 570
                self.match(SqlParser.NULL)
                pass
            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class DataTypeContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def INT(self):
            return self.getToken(SqlParser.INT, 0)

        def NVARCHAR(self):
            return self.getToken(SqlParser.NVARCHAR, 0)

        def LPAREN(self):
            return self.getToken(SqlParser.LPAREN, 0)

        def RPAREN(self):
            return self.getToken(SqlParser.RPAREN, 0)

        def VARCHAR(self):
            return self.getToken(SqlParser.VARCHAR, 0)

        def BRACKET_IDENTIFIER(self):
            return self.getToken(SqlParser.BRACKET_IDENTIFIER, 0)

        def IDENTIFIER(self):
            return self.getToken(SqlParser.IDENTIFIER, 0)

        def MAX(self):
            return self.getToken(SqlParser.MAX, 0)

        def INT_LITERAL(self):
            return self.getToken(SqlParser.INT_LITERAL, 0)

        def typeParams(self):
            return self.getTypedRuleContext(SqlParser.TypeParamsContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_dataType

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterDataType" ):
                listener.enterDataType(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitDataType" ):
                listener.exitDataType(self)




    def dataType(self):

        localctx = SqlParser.DataTypeContext(self, self._ctx, self.state)
        self.enterRule(localctx, 82, self.RULE_dataType)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 584
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [181]:
                self.state = 573
                self.match(SqlParser.INT)
                pass
            elif token in [182]:
                self.state = 574
                self.match(SqlParser.NVARCHAR)
                self.state = 575
                self.match(SqlParser.LPAREN)
                self.state = 576
                _la = self._input.LA(1)
                if not(_la==184 or _la==192):
                    self._errHandler.recoverInline(self)
                else:
                    self._errHandler.reportMatch(self)
                    self.consume()
                self.state = 577
                self.match(SqlParser.RPAREN)
                pass
            elif token in [183]:
                self.state = 578
                self.match(SqlParser.VARCHAR)
                self.state = 579
                self.match(SqlParser.LPAREN)
                self.state = 580
                _la = self._input.LA(1)
                if not(_la==184 or _la==192):
                    self._errHandler.recoverInline(self)
                else:
                    self._errHandler.reportMatch(self)
                    self.consume()
                self.state = 581
                self.match(SqlParser.RPAREN)
                pass
            elif token in [199]:
                self.state = 582
                self.match(SqlParser.BRACKET_IDENTIFIER)
                pass
            elif token in [200]:
                self.state = 583
                self.match(SqlParser.IDENTIFIER)
                pass
            else:
                raise NoViableAltException(self)

            self.state = 587
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==215:
                self.state = 586
                self.typeParams()


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class TypeParamsContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def LPAREN(self):
            return self.getToken(SqlParser.LPAREN, 0)

        def RPAREN(self):
            return self.getToken(SqlParser.RPAREN, 0)

        def MAX(self):
            return self.getToken(SqlParser.MAX, 0)

        def INT_LITERAL(self):
            return self.getToken(SqlParser.INT_LITERAL, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_typeParams

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterTypeParams" ):
                listener.enterTypeParams(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitTypeParams" ):
                listener.exitTypeParams(self)




    def typeParams(self):

        localctx = SqlParser.TypeParamsContext(self, self._ctx, self.state)
        self.enterRule(localctx, 84, self.RULE_typeParams)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 589
            self.match(SqlParser.LPAREN)
            self.state = 590
            _la = self._input.LA(1)
            if not(_la==184 or _la==192):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
            self.state = 591
            self.match(SqlParser.RPAREN)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class DropTableStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def DROP(self):
            return self.getToken(SqlParser.DROP, 0)

        def TABLE(self):
            return self.getToken(SqlParser.TABLE, 0)

        def tableName(self):
            return self.getTypedRuleContext(SqlParser.TableNameContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_dropTableStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterDropTableStatement" ):
                listener.enterDropTableStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitDropTableStatement" ):
                listener.exitDropTableStatement(self)




    def dropTableStatement(self):

        localctx = SqlParser.DropTableStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 86, self.RULE_dropTableStatement)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 593
            self.match(SqlParser.DROP)
            self.state = 594
            self.match(SqlParser.TABLE)
            self.state = 595
            self.tableName()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class AlterTableStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def ALTER(self):
            return self.getToken(SqlParser.ALTER, 0)

        def TABLE(self):
            return self.getToken(SqlParser.TABLE, 0)

        def tableName(self):
            return self.getTypedRuleContext(SqlParser.TableNameContext,0)


        def alterAction(self):
            return self.getTypedRuleContext(SqlParser.AlterActionContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_alterTableStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterAlterTableStatement" ):
                listener.enterAlterTableStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitAlterTableStatement" ):
                listener.exitAlterTableStatement(self)




    def alterTableStatement(self):

        localctx = SqlParser.AlterTableStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 88, self.RULE_alterTableStatement)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 597
            self.match(SqlParser.ALTER)
            self.state = 598
            self.match(SqlParser.TABLE)
            self.state = 599
            self.tableName()
            self.state = 600
            self.alterAction()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class AlterActionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def ADD(self):
            return self.getToken(SqlParser.ADD, 0)

        def columnDefinition(self):
            return self.getTypedRuleContext(SqlParser.ColumnDefinitionContext,0)


        def DROP(self):
            return self.getToken(SqlParser.DROP, 0)

        def columnName(self):
            return self.getTypedRuleContext(SqlParser.ColumnNameContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_alterAction

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterAlterAction" ):
                listener.enterAlterAction(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitAlterAction" ):
                listener.exitAlterAction(self)




    def alterAction(self):

        localctx = SqlParser.AlterActionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 90, self.RULE_alterAction)
        try:
            self.state = 606
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [1]:
                self.enterOuterAlt(localctx, 1)
                self.state = 602
                self.match(SqlParser.ADD)
                self.state = 603
                self.columnDefinition()
                pass
            elif token in [155]:
                self.enterOuterAlt(localctx, 2)
                self.state = 604
                self.match(SqlParser.DROP)
                self.state = 605
                self.columnName()
                pass
            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class CursorStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def declareCursor(self):
            return self.getTypedRuleContext(SqlParser.DeclareCursorContext,0)


        def openCursor(self):
            return self.getTypedRuleContext(SqlParser.OpenCursorContext,0)


        def fetchCursor(self):
            return self.getTypedRuleContext(SqlParser.FetchCursorContext,0)


        def closeCursor(self):
            return self.getTypedRuleContext(SqlParser.CloseCursorContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_cursorStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterCursorStatement" ):
                listener.enterCursorStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitCursorStatement" ):
                listener.exitCursorStatement(self)




    def cursorStatement(self):

        localctx = SqlParser.CursorStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 92, self.RULE_cursorStatement)
        try:
            self.state = 612
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [128]:
                self.enterOuterAlt(localctx, 1)
                self.state = 608
                self.declareCursor()
                pass
            elif token in [138]:
                self.enterOuterAlt(localctx, 2)
                self.state = 609
                self.openCursor()
                pass
            elif token in [5]:
                self.enterOuterAlt(localctx, 3)
                self.state = 610
                self.fetchCursor()
                pass
            elif token in [59]:
                self.enterOuterAlt(localctx, 4)
                self.state = 611
                self.closeCursor()
                pass
            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class DeclareCursorContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def DECLARE(self):
            return self.getToken(SqlParser.DECLARE, 0)

        def IDENTIFIER(self):
            return self.getToken(SqlParser.IDENTIFIER, 0)

        def CURSOR(self):
            return self.getToken(SqlParser.CURSOR, 0)

        def FOR(self):
            return self.getToken(SqlParser.FOR, 0)

        def selectStatement(self):
            return self.getTypedRuleContext(SqlParser.SelectStatementContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_declareCursor

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterDeclareCursor" ):
                listener.enterDeclareCursor(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitDeclareCursor" ):
                listener.exitDeclareCursor(self)




    def declareCursor(self):

        localctx = SqlParser.DeclareCursorContext(self, self._ctx, self.state)
        self.enterRule(localctx, 94, self.RULE_declareCursor)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 614
            self.match(SqlParser.DECLARE)
            self.state = 615
            self.match(SqlParser.IDENTIFIER)
            self.state = 616
            self.match(SqlParser.CURSOR)
            self.state = 617
            self.match(SqlParser.FOR)
            self.state = 618
            self.selectStatement()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class OpenCursorContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def OPEN(self):
            return self.getToken(SqlParser.OPEN, 0)

        def IDENTIFIER(self):
            return self.getToken(SqlParser.IDENTIFIER, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_openCursor

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterOpenCursor" ):
                listener.enterOpenCursor(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitOpenCursor" ):
                listener.exitOpenCursor(self)




    def openCursor(self):

        localctx = SqlParser.OpenCursorContext(self, self._ctx, self.state)
        self.enterRule(localctx, 96, self.RULE_openCursor)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 620
            self.match(SqlParser.OPEN)
            self.state = 621
            self.match(SqlParser.IDENTIFIER)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class FetchCursorContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def FETCH(self):
            return self.getToken(SqlParser.FETCH, 0)

        def IDENTIFIER(self):
            return self.getToken(SqlParser.IDENTIFIER, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_fetchCursor

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterFetchCursor" ):
                listener.enterFetchCursor(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitFetchCursor" ):
                listener.exitFetchCursor(self)




    def fetchCursor(self):

        localctx = SqlParser.FetchCursorContext(self, self._ctx, self.state)
        self.enterRule(localctx, 98, self.RULE_fetchCursor)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 623
            self.match(SqlParser.FETCH)
            self.state = 624
            self.match(SqlParser.IDENTIFIER)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class CloseCursorContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def CLOSE(self):
            return self.getToken(SqlParser.CLOSE, 0)

        def IDENTIFIER(self):
            return self.getToken(SqlParser.IDENTIFIER, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_closeCursor

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterCloseCursor" ):
                listener.enterCloseCursor(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitCloseCursor" ):
                listener.exitCloseCursor(self)




    def closeCursor(self):

        localctx = SqlParser.CloseCursorContext(self, self._ctx, self.state)
        self.enterRule(localctx, 100, self.RULE_closeCursor)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 626
            self.match(SqlParser.CLOSE)
            self.state = 627
            self.match(SqlParser.IDENTIFIER)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class BlockStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def BEGIN(self):
            return self.getToken(SqlParser.BEGIN, 0)

        def END(self):
            return self.getToken(SqlParser.END, 0)

        def blockContent(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.BlockContentContext)
            else:
                return self.getTypedRuleContext(SqlParser.BlockContentContext,i)


        def getRuleIndex(self):
            return SqlParser.RULE_blockStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterBlockStatement" ):
                listener.enterBlockStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitBlockStatement" ):
                listener.exitBlockStatement(self)




    def blockStatement(self):

        localctx = SqlParser.BlockStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 102, self.RULE_blockStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 629
            self.match(SqlParser.BEGIN)
            self.state = 633
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while (((_la) & ~0x3f) == 0 and ((1 << _la) & 1729382257178706080) != 0) or ((((_la - 67)) & ~0x3f) == 0 and ((1 << (_la - 67)) & 3458764514089009185) != 0) or ((((_la - 134)) & ~0x3f) == 0 and ((1 << (_la - 134)) & 41781443969297) != 0):
                self.state = 630
                self.blockContent()
                self.state = 635
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 636
            self.match(SqlParser.END)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class BlockContentContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def sqlStatement(self):
            return self.getTypedRuleContext(SqlParser.SqlStatementContext,0)


        def tryCatchStatement(self):
            return self.getTypedRuleContext(SqlParser.TryCatchStatementContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_blockContent

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterBlockContent" ):
                listener.enterBlockContent(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitBlockContent" ):
                listener.exitBlockContent(self)




    def blockContent(self):

        localctx = SqlParser.BlockContentContext(self, self._ctx, self.state)
        self.enterRule(localctx, 104, self.RULE_blockContent)
        try:
            self.state = 640
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,65,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 638
                self.sqlStatement()
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 639
                self.tryCatchStatement()
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class ExecStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def EXEC(self):
            return self.getToken(SqlParser.EXEC, 0)

        def EXECUTE(self):
            return self.getToken(SqlParser.EXECUTE, 0)

        def IDENTIFIER(self):
            return self.getToken(SqlParser.IDENTIFIER, 0)

        def BRACKET_IDENTIFIER(self):
            return self.getToken(SqlParser.BRACKET_IDENTIFIER, 0)

        def expression(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.ExpressionContext)
            else:
                return self.getTypedRuleContext(SqlParser.ExpressionContext,i)


        def SEMI(self):
            return self.getToken(SqlParser.SEMI, 0)

        def COMMA(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.COMMA)
            else:
                return self.getToken(SqlParser.COMMA, i)

        def getRuleIndex(self):
            return SqlParser.RULE_execStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterExecStatement" ):
                listener.enterExecStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitExecStatement" ):
                listener.exitExecStatement(self)




    def execStatement(self):

        localctx = SqlParser.ExecStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 106, self.RULE_execStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 642
            _la = self._input.LA(1)
            if not(_la==176 or _la==179):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
            self.state = 643
            _la = self._input.LA(1)
            if not(_la==199 or _la==200):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
            self.state = 652
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==120 or ((((_la - 184)) & ~0x3f) == 0 and ((1 << (_la - 184)) & 2198074143) != 0):
                self.state = 644
                self.expression()
                self.state = 649
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==213:
                    self.state = 645
                    self.match(SqlParser.COMMA)
                    self.state = 646
                    self.expression()
                    self.state = 651
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)



            self.state = 655
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,68,self._ctx)
            if la_ == 1:
                self.state = 654
                self.match(SqlParser.SEMI)


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class TryCatchStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def BEGIN(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.BEGIN)
            else:
                return self.getToken(SqlParser.BEGIN, i)

        def TRY(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.TRY)
            else:
                return self.getToken(SqlParser.TRY, i)

        def END(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.END)
            else:
                return self.getToken(SqlParser.END, i)

        def CATCH(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.CATCH)
            else:
                return self.getToken(SqlParser.CATCH, i)

        def blockContent(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.BlockContentContext)
            else:
                return self.getTypedRuleContext(SqlParser.BlockContentContext,i)


        def getRuleIndex(self):
            return SqlParser.RULE_tryCatchStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterTryCatchStatement" ):
                listener.enterTryCatchStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitTryCatchStatement" ):
                listener.exitTryCatchStatement(self)




    def tryCatchStatement(self):

        localctx = SqlParser.TryCatchStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 108, self.RULE_tryCatchStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 657
            self.match(SqlParser.BEGIN)
            self.state = 658
            self.match(SqlParser.TRY)
            self.state = 662
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while (((_la) & ~0x3f) == 0 and ((1 << _la) & 1729382257178706080) != 0) or ((((_la - 67)) & ~0x3f) == 0 and ((1 << (_la - 67)) & 3458764514089009185) != 0) or ((((_la - 134)) & ~0x3f) == 0 and ((1 << (_la - 134)) & 41781443969297) != 0):
                self.state = 659
                self.blockContent()
                self.state = 664
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 665
            self.match(SqlParser.END)
            self.state = 666
            self.match(SqlParser.TRY)
            self.state = 667
            self.match(SqlParser.BEGIN)
            self.state = 668
            self.match(SqlParser.CATCH)
            self.state = 672
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while (((_la) & ~0x3f) == 0 and ((1 << _la) & 1729382257178706080) != 0) or ((((_la - 67)) & ~0x3f) == 0 and ((1 << (_la - 67)) & 3458764514089009185) != 0) or ((((_la - 134)) & ~0x3f) == 0 and ((1 << (_la - 134)) & 41781443969297) != 0):
                self.state = 669
                self.blockContent()
                self.state = 674
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 675
            self.match(SqlParser.END)
            self.state = 676
            self.match(SqlParser.CATCH)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class IfStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def IF(self):
            return self.getToken(SqlParser.IF, 0)

        def searchCondition(self):
            return self.getTypedRuleContext(SqlParser.SearchConditionContext,0)


        def sqlStatement(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.SqlStatementContext)
            else:
                return self.getTypedRuleContext(SqlParser.SqlStatementContext,i)


        def ELSE(self):
            return self.getToken(SqlParser.ELSE, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_ifStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterIfStatement" ):
                listener.enterIfStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitIfStatement" ):
                listener.exitIfStatement(self)




    def ifStatement(self):

        localctx = SqlParser.IfStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 110, self.RULE_ifStatement)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 678
            self.match(SqlParser.IF)
            self.state = 679
            self.searchCondition()
            self.state = 680
            self.sqlStatement()
            self.state = 683
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,71,self._ctx)
            if la_ == 1:
                self.state = 681
                self.match(SqlParser.ELSE)
                self.state = 682
                self.sqlStatement()


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class DeclareStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def DECLARE(self):
            return self.getToken(SqlParser.DECLARE, 0)

        def USER_VAR(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.USER_VAR)
            else:
                return self.getToken(SqlParser.USER_VAR, i)

        def dataType(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.DataTypeContext)
            else:
                return self.getTypedRuleContext(SqlParser.DataTypeContext,i)


        def EQ(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.EQ)
            else:
                return self.getToken(SqlParser.EQ, i)

        def expression(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.ExpressionContext)
            else:
                return self.getTypedRuleContext(SqlParser.ExpressionContext,i)


        def COMMA(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.COMMA)
            else:
                return self.getToken(SqlParser.COMMA, i)

        def getRuleIndex(self):
            return SqlParser.RULE_declareStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterDeclareStatement" ):
                listener.enterDeclareStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitDeclareStatement" ):
                listener.exitDeclareStatement(self)




    def declareStatement(self):

        localctx = SqlParser.DeclareStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 112, self.RULE_declareStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 685
            self.match(SqlParser.DECLARE)
            self.state = 686
            self.match(SqlParser.USER_VAR)
            self.state = 687
            self.dataType()
            self.state = 690
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==202:
                self.state = 688
                self.match(SqlParser.EQ)
                self.state = 689
                self.expression()


            self.state = 701
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==213:
                self.state = 692
                self.match(SqlParser.COMMA)
                self.state = 693
                self.match(SqlParser.USER_VAR)
                self.state = 694
                self.dataType()
                self.state = 697
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==202:
                    self.state = 695
                    self.match(SqlParser.EQ)
                    self.state = 696
                    self.expression()


                self.state = 703
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class SetStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def SET(self):
            return self.getToken(SqlParser.SET, 0)

        def USER_VAR(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.USER_VAR)
            else:
                return self.getToken(SqlParser.USER_VAR, i)

        def expression(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.ExpressionContext)
            else:
                return self.getTypedRuleContext(SqlParser.ExpressionContext,i)


        def EQ(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.EQ)
            else:
                return self.getToken(SqlParser.EQ, i)

        def PLUS_EQ(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.PLUS_EQ)
            else:
                return self.getToken(SqlParser.PLUS_EQ, i)

        def COMMA(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.COMMA)
            else:
                return self.getToken(SqlParser.COMMA, i)

        def SEMI(self):
            return self.getToken(SqlParser.SEMI, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_setStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterSetStatement" ):
                listener.enterSetStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitSetStatement" ):
                listener.exitSetStatement(self)




    def setStatement(self):

        localctx = SqlParser.SetStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 114, self.RULE_setStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 704
            self.match(SqlParser.SET)
            self.state = 705
            self.match(SqlParser.USER_VAR)
            self.state = 706
            _la = self._input.LA(1)
            if not(_la==202 or _la==212):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
            self.state = 707
            self.expression()
            self.state = 714
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==213:
                self.state = 708
                self.match(SqlParser.COMMA)
                self.state = 709
                self.match(SqlParser.USER_VAR)
                self.state = 710
                _la = self._input.LA(1)
                if not(_la==202 or _la==212):
                    self._errHandler.recoverInline(self)
                else:
                    self._errHandler.reportMatch(self)
                    self.consume()
                self.state = 711
                self.expression()
                self.state = 716
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 718
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,76,self._ctx)
            if la_ == 1:
                self.state = 717
                self.match(SqlParser.SEMI)


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class HavingClauseContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def HAVING(self):
            return self.getToken(SqlParser.HAVING, 0)

        def searchCondition(self):
            return self.getTypedRuleContext(SqlParser.SearchConditionContext,0)


        def getRuleIndex(self):
            return SqlParser.RULE_havingClause

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterHavingClause" ):
                listener.enterHavingClause(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitHavingClause" ):
                listener.exitHavingClause(self)




    def havingClause(self):

        localctx = SqlParser.HavingClauseContext(self, self._ctx, self.state)
        self.enterRule(localctx, 116, self.RULE_havingClause)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 720
            self.match(SqlParser.HAVING)
            self.state = 721
            self.searchCondition()
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class UseDatabaseStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def USE(self):
            return self.getToken(SqlParser.USE, 0)

        def IDENTIFIER(self):
            return self.getToken(SqlParser.IDENTIFIER, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_useDatabaseStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterUseDatabaseStatement" ):
                listener.enterUseDatabaseStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitUseDatabaseStatement" ):
                listener.exitUseDatabaseStatement(self)




    def useDatabaseStatement(self):

        localctx = SqlParser.UseDatabaseStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 118, self.RULE_useDatabaseStatement)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 723
            self.match(SqlParser.USE)
            self.state = 724
            self.match(SqlParser.IDENTIFIER)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class TruncateTableStatementContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def TRUNCATE(self):
            return self.getToken(SqlParser.TRUNCATE, 0)

        def TABLE(self):
            return self.getToken(SqlParser.TABLE, 0)

        def tableName(self):
            return self.getTypedRuleContext(SqlParser.TableNameContext,0)


        def SEMI(self):
            return self.getToken(SqlParser.SEMI, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_truncateTableStatement

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterTruncateTableStatement" ):
                listener.enterTruncateTableStatement(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitTruncateTableStatement" ):
                listener.exitTruncateTableStatement(self)




    def truncateTableStatement(self):

        localctx = SqlParser.TruncateTableStatementContext(self, self._ctx, self.state)
        self.enterRule(localctx, 120, self.RULE_truncateTableStatement)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 726
            self.match(SqlParser.TRUNCATE)
            self.state = 727
            self.match(SqlParser.TABLE)
            self.state = 728
            self.tableName()
            self.state = 730
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,77,self._ctx)
            if la_ == 1:
                self.state = 729
                self.match(SqlParser.SEMI)


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx



    def sempred(self, localctx:RuleContext, ruleIndex:int, predIndex:int):
        if self._predicates == None:
            self._predicates = dict()
        self._predicates[18] = self.orExpression_sempred
        self._predicates[19] = self.andExpression_sempred
        self._predicates[25] = self.additiveExpression_sempred
        self._predicates[26] = self.multiplicativeExpression_sempred
        pred = self._predicates.get(ruleIndex, None)
        if pred is None:
            raise Exception("No predicate with index:" + str(ruleIndex))
        else:
            return pred(localctx, predIndex)

    def orExpression_sempred(self, localctx:OrExpressionContext, predIndex:int):
            if predIndex == 0:
                return self.precpred(self._ctx, 2)
         

    def andExpression_sempred(self, localctx:AndExpressionContext, predIndex:int):
            if predIndex == 1:
                return self.precpred(self._ctx, 2)
         

    def additiveExpression_sempred(self, localctx:AdditiveExpressionContext, predIndex:int):
            if predIndex == 2:
                return self.precpred(self._ctx, 3)
         

            if predIndex == 3:
                return self.precpred(self._ctx, 2)
         

    def multiplicativeExpression_sempred(self, localctx:MultiplicativeExpressionContext, predIndex:int):
            if predIndex == 4:
                return self.precpred(self._ctx, 3)
         

            if predIndex == 5:
                return self.precpred(self._ctx, 2)
         





```

---

### <a id="📄-sqlparserbaselistener-java"></a>📄 `SqlParserBaseListener.java`

**File Info:**
- **Size**: 21.63 KB
- **Extension**: `.java`
- **Language**: `java`
- **Location**: `SqlParserBaseListener.java`
- **Relative Path**: `root`
- **Created**: 2026-01-11 06:03:50 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-18 10:21:27 (Asia/Damascus / GMT+03:00)
- **MD5**: `acb09820d249e925d75bcc3f04d988f0`
- **SHA256**: `e42af0a1fc7972112877be6d00fb74a952c0b100e86f65dd1086f11a32a30e7d`
- **Encoding**: ASCII

**File code content:**

```java
// Generated from c:/Users/salah/Programming_Tests/Java/Compilrt_Project/SqlParser.g4 by ANTLR 4.13.1

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link SqlParserListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
@SuppressWarnings("CheckReturnValue")
public class SqlParserBaseListener implements SqlParserListener {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSqlFile(SqlParser.SqlFileContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSqlFile(SqlParser.SqlFileContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSqlStatement(SqlParser.SqlStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSqlStatement(SqlParser.SqlStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCteStatement(SqlParser.CteStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCteStatement(SqlParser.CteStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCteDefinition(SqlParser.CteDefinitionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCteDefinition(SqlParser.CteDefinitionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDmlStatement(SqlParser.DmlStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDmlStatement(SqlParser.DmlStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSelectStatement(SqlParser.SelectStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSelectStatement(SqlParser.SelectStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSelectList(SqlParser.SelectListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSelectList(SqlParser.SelectListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSelectElement(SqlParser.SelectElementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSelectElement(SqlParser.SelectElementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTableSource(SqlParser.TableSourceContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTableSource(SqlParser.TableSourceContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTableName(SqlParser.TableNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTableName(SqlParser.TableNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterJoinClause(SqlParser.JoinClauseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitJoinClause(SqlParser.JoinClauseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterJoinType(SqlParser.JoinTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitJoinType(SqlParser.JoinTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterColumnName(SqlParser.ColumnNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitColumnName(SqlParser.ColumnNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWhereClause(SqlParser.WhereClauseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWhereClause(SqlParser.WhereClauseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterGroupByClause(SqlParser.GroupByClauseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitGroupByClause(SqlParser.GroupByClauseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterOrderByClause(SqlParser.OrderByClauseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitOrderByClause(SqlParser.OrderByClauseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterOrderElement(SqlParser.OrderElementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitOrderElement(SqlParser.OrderElementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSearchCondition(SqlParser.SearchConditionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSearchCondition(SqlParser.SearchConditionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterOrExpression(SqlParser.OrExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitOrExpression(SqlParser.OrExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAndExpression(SqlParser.AndExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAndExpression(SqlParser.AndExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNotExpression(SqlParser.NotExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitNotExpression(SqlParser.NotExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPredicate(SqlParser.PredicateContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPredicate(SqlParser.PredicateContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterComparisonOperator(SqlParser.ComparisonOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitComparisonOperator(SqlParser.ComparisonOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpression(SqlParser.ExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpression(SqlParser.ExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssignmentExpression(SqlParser.AssignmentExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssignmentExpression(SqlParser.AssignmentExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAdditiveExpression(SqlParser.AdditiveExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAdditiveExpression(SqlParser.AdditiveExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMultiplicativeExpression(SqlParser.MultiplicativeExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMultiplicativeExpression(SqlParser.MultiplicativeExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterUnaryExpression(SqlParser.UnaryExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitUnaryExpression(SqlParser.UnaryExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPrimaryExpression(SqlParser.PrimaryExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrimaryExpression(SqlParser.PrimaryExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCaseExpression(SqlParser.CaseExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCaseExpression(SqlParser.CaseExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWhenClause(SqlParser.WhenClauseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWhenClause(SqlParser.WhenClauseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLiteral(SqlParser.LiteralContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLiteral(SqlParser.LiteralContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunctionCall(SqlParser.FunctionCallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunctionCall(SqlParser.FunctionCallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInsertStatement(SqlParser.InsertStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInsertStatement(SqlParser.InsertStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterUpdateStatement(SqlParser.UpdateStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitUpdateStatement(SqlParser.UpdateStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssignment(SqlParser.AssignmentContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssignment(SqlParser.AssignmentContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDeleteStatement(SqlParser.DeleteStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDeleteStatement(SqlParser.DeleteStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDdlStatement(SqlParser.DdlStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDdlStatement(SqlParser.DdlStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCreateTableStatement(SqlParser.CreateTableStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCreateTableStatement(SqlParser.CreateTableStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterColumnDefinition(SqlParser.ColumnDefinitionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitColumnDefinition(SqlParser.ColumnDefinitionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNullability(SqlParser.NullabilityContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitNullability(SqlParser.NullabilityContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDataType(SqlParser.DataTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDataType(SqlParser.DataTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTypeParams(SqlParser.TypeParamsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTypeParams(SqlParser.TypeParamsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDropTableStatement(SqlParser.DropTableStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDropTableStatement(SqlParser.DropTableStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAlterTableStatement(SqlParser.AlterTableStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAlterTableStatement(SqlParser.AlterTableStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAlterAction(SqlParser.AlterActionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAlterAction(SqlParser.AlterActionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCursorStatement(SqlParser.CursorStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCursorStatement(SqlParser.CursorStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDeclareCursor(SqlParser.DeclareCursorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDeclareCursor(SqlParser.DeclareCursorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterOpenCursor(SqlParser.OpenCursorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitOpenCursor(SqlParser.OpenCursorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFetchCursor(SqlParser.FetchCursorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFetchCursor(SqlParser.FetchCursorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCloseCursor(SqlParser.CloseCursorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCloseCursor(SqlParser.CloseCursorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBlockStatement(SqlParser.BlockStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBlockStatement(SqlParser.BlockStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBlockContent(SqlParser.BlockContentContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBlockContent(SqlParser.BlockContentContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExecStatement(SqlParser.ExecStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExecStatement(SqlParser.ExecStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTryCatchStatement(SqlParser.TryCatchStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTryCatchStatement(SqlParser.TryCatchStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIfStatement(SqlParser.IfStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIfStatement(SqlParser.IfStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDeclareStatement(SqlParser.DeclareStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDeclareStatement(SqlParser.DeclareStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSetStatement(SqlParser.SetStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSetStatement(SqlParser.SetStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterHavingClause(SqlParser.HavingClauseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitHavingClause(SqlParser.HavingClauseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterUseDatabaseStatement(SqlParser.UseDatabaseStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitUseDatabaseStatement(SqlParser.UseDatabaseStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTruncateTableStatement(SqlParser.TruncateTableStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTruncateTableStatement(SqlParser.TruncateTableStatementContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}
```

---

### <a id="📄-sqlparserlistener-java"></a>📄 `SqlParserListener.java`

**File Info:**
- **Size**: 21.14 KB
- **Extension**: `.java`
- **Language**: `java`
- **Location**: `SqlParserListener.java`
- **Relative Path**: `root`
- **Created**: 2026-01-11 06:03:50 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-18 10:21:27 (Asia/Damascus / GMT+03:00)
- **MD5**: `891763f8ce9fb23e1c7681d496d304cd`
- **SHA256**: `c1d7e54ea399088f73486d77d274bb27c84121c57efc8ced936ce7fc99ad3a26`
- **Encoding**: ASCII

**File code content:**

```java
// Generated from c:/Users/salah/Programming_Tests/Java/Compilrt_Project/SqlParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlParser}.
 */
public interface SqlParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlFile}.
	 * @param ctx the parse tree
	 */
	void enterSqlFile(SqlParser.SqlFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlFile}.
	 * @param ctx the parse tree
	 */
	void exitSqlFile(SqlParser.SqlFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void enterSqlStatement(SqlParser.SqlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void exitSqlStatement(SqlParser.SqlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#cteStatement}.
	 * @param ctx the parse tree
	 */
	void enterCteStatement(SqlParser.CteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#cteStatement}.
	 * @param ctx the parse tree
	 */
	void exitCteStatement(SqlParser.CteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#cteDefinition}.
	 * @param ctx the parse tree
	 */
	void enterCteDefinition(SqlParser.CteDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#cteDefinition}.
	 * @param ctx the parse tree
	 */
	void exitCteDefinition(SqlParser.CteDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#dmlStatement}.
	 * @param ctx the parse tree
	 */
	void enterDmlStatement(SqlParser.DmlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#dmlStatement}.
	 * @param ctx the parse tree
	 */
	void exitDmlStatement(SqlParser.DmlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatement(SqlParser.SelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatement(SqlParser.SelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#selectList}.
	 * @param ctx the parse tree
	 */
	void enterSelectList(SqlParser.SelectListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#selectList}.
	 * @param ctx the parse tree
	 */
	void exitSelectList(SqlParser.SelectListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void enterSelectElement(SqlParser.SelectElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void exitSelectElement(SqlParser.SelectElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#tableSource}.
	 * @param ctx the parse tree
	 */
	void enterTableSource(SqlParser.TableSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#tableSource}.
	 * @param ctx the parse tree
	 */
	void exitTableSource(SqlParser.TableSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(SqlParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(SqlParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void enterJoinClause(SqlParser.JoinClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void exitJoinClause(SqlParser.JoinClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#joinType}.
	 * @param ctx the parse tree
	 */
	void enterJoinType(SqlParser.JoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#joinType}.
	 * @param ctx the parse tree
	 */
	void exitJoinType(SqlParser.JoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(SqlParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(SqlParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(SqlParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(SqlParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupByClause(SqlParser.GroupByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupByClause(SqlParser.GroupByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderByClause(SqlParser.OrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderByClause(SqlParser.OrderByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#orderElement}.
	 * @param ctx the parse tree
	 */
	void enterOrderElement(SqlParser.OrderElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#orderElement}.
	 * @param ctx the parse tree
	 */
	void exitOrderElement(SqlParser.OrderElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#searchCondition}.
	 * @param ctx the parse tree
	 */
	void enterSearchCondition(SqlParser.SearchConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#searchCondition}.
	 * @param ctx the parse tree
	 */
	void exitSearchCondition(SqlParser.SearchConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(SqlParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(SqlParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(SqlParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(SqlParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(SqlParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(SqlParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(SqlParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(SqlParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(SqlParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(SqlParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SqlParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SqlParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(SqlParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(SqlParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(SqlParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(SqlParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(SqlParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(SqlParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(SqlParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(SqlParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(SqlParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(SqlParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#caseExpression}.
	 * @param ctx the parse tree
	 */
	void enterCaseExpression(SqlParser.CaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#caseExpression}.
	 * @param ctx the parse tree
	 */
	void exitCaseExpression(SqlParser.CaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#whenClause}.
	 * @param ctx the parse tree
	 */
	void enterWhenClause(SqlParser.WhenClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#whenClause}.
	 * @param ctx the parse tree
	 */
	void exitWhenClause(SqlParser.WhenClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SqlParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SqlParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SqlParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SqlParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void enterInsertStatement(SqlParser.InsertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void exitInsertStatement(SqlParser.InsertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void enterUpdateStatement(SqlParser.UpdateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void exitUpdateStatement(SqlParser.UpdateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SqlParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SqlParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeleteStatement(SqlParser.DeleteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeleteStatement(SqlParser.DeleteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#ddlStatement}.
	 * @param ctx the parse tree
	 */
	void enterDdlStatement(SqlParser.DdlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#ddlStatement}.
	 * @param ctx the parse tree
	 */
	void exitDdlStatement(SqlParser.DdlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#createTableStatement}.
	 * @param ctx the parse tree
	 */
	void enterCreateTableStatement(SqlParser.CreateTableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#createTableStatement}.
	 * @param ctx the parse tree
	 */
	void exitCreateTableStatement(SqlParser.CreateTableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#columnDefinition}.
	 * @param ctx the parse tree
	 */
	void enterColumnDefinition(SqlParser.ColumnDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#columnDefinition}.
	 * @param ctx the parse tree
	 */
	void exitColumnDefinition(SqlParser.ColumnDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#nullability}.
	 * @param ctx the parse tree
	 */
	void enterNullability(SqlParser.NullabilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#nullability}.
	 * @param ctx the parse tree
	 */
	void exitNullability(SqlParser.NullabilityContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(SqlParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(SqlParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#typeParams}.
	 * @param ctx the parse tree
	 */
	void enterTypeParams(SqlParser.TypeParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#typeParams}.
	 * @param ctx the parse tree
	 */
	void exitTypeParams(SqlParser.TypeParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#dropTableStatement}.
	 * @param ctx the parse tree
	 */
	void enterDropTableStatement(SqlParser.DropTableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#dropTableStatement}.
	 * @param ctx the parse tree
	 */
	void exitDropTableStatement(SqlParser.DropTableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#alterTableStatement}.
	 * @param ctx the parse tree
	 */
	void enterAlterTableStatement(SqlParser.AlterTableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#alterTableStatement}.
	 * @param ctx the parse tree
	 */
	void exitAlterTableStatement(SqlParser.AlterTableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#alterAction}.
	 * @param ctx the parse tree
	 */
	void enterAlterAction(SqlParser.AlterActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#alterAction}.
	 * @param ctx the parse tree
	 */
	void exitAlterAction(SqlParser.AlterActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#cursorStatement}.
	 * @param ctx the parse tree
	 */
	void enterCursorStatement(SqlParser.CursorStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#cursorStatement}.
	 * @param ctx the parse tree
	 */
	void exitCursorStatement(SqlParser.CursorStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#declareCursor}.
	 * @param ctx the parse tree
	 */
	void enterDeclareCursor(SqlParser.DeclareCursorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#declareCursor}.
	 * @param ctx the parse tree
	 */
	void exitDeclareCursor(SqlParser.DeclareCursorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#openCursor}.
	 * @param ctx the parse tree
	 */
	void enterOpenCursor(SqlParser.OpenCursorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#openCursor}.
	 * @param ctx the parse tree
	 */
	void exitOpenCursor(SqlParser.OpenCursorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#fetchCursor}.
	 * @param ctx the parse tree
	 */
	void enterFetchCursor(SqlParser.FetchCursorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#fetchCursor}.
	 * @param ctx the parse tree
	 */
	void exitFetchCursor(SqlParser.FetchCursorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#closeCursor}.
	 * @param ctx the parse tree
	 */
	void enterCloseCursor(SqlParser.CloseCursorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#closeCursor}.
	 * @param ctx the parse tree
	 */
	void exitCloseCursor(SqlParser.CloseCursorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(SqlParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(SqlParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#blockContent}.
	 * @param ctx the parse tree
	 */
	void enterBlockContent(SqlParser.BlockContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#blockContent}.
	 * @param ctx the parse tree
	 */
	void exitBlockContent(SqlParser.BlockContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#execStatement}.
	 * @param ctx the parse tree
	 */
	void enterExecStatement(SqlParser.ExecStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#execStatement}.
	 * @param ctx the parse tree
	 */
	void exitExecStatement(SqlParser.ExecStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#tryCatchStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryCatchStatement(SqlParser.TryCatchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#tryCatchStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryCatchStatement(SqlParser.TryCatchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SqlParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SqlParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#declareStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclareStatement(SqlParser.DeclareStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#declareStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclareStatement(SqlParser.DeclareStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void enterSetStatement(SqlParser.SetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void exitSetStatement(SqlParser.SetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void enterHavingClause(SqlParser.HavingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void exitHavingClause(SqlParser.HavingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#useDatabaseStatement}.
	 * @param ctx the parse tree
	 */
	void enterUseDatabaseStatement(SqlParser.UseDatabaseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#useDatabaseStatement}.
	 * @param ctx the parse tree
	 */
	void exitUseDatabaseStatement(SqlParser.UseDatabaseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#truncateTableStatement}.
	 * @param ctx the parse tree
	 */
	void enterTruncateTableStatement(SqlParser.TruncateTableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#truncateTableStatement}.
	 * @param ctx the parse tree
	 */
	void exitTruncateTableStatement(SqlParser.TruncateTableStatementContext ctx);
}
```

---

### <a id="📄-sqlparserlistener-py"></a>📄 `SqlParserListener.py`

**File Info:**
- **Size**: 18.26 KB
- **Extension**: `.py`
- **Language**: `python`
- **Location**: `SqlParserListener.py`
- **Relative Path**: `root`
- **Created**: 2026-01-10 14:46:39 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-18 09:51:34 (Asia/Damascus / GMT+03:00)
- **MD5**: `cd97bf2e65fe79dfcdf3683dd7ef684a`
- **SHA256**: `496dc7067a5778fa91beb7af37eaab1a30e41640423454ee56461e3182a5d859`
- **Encoding**: ASCII

**File code content:**

```python
# Generated from SqlParser.g4 by ANTLR 4.13.2
from antlr4 import *
if "." in __name__:
    from .SqlParser import SqlParser
else:
    from SqlParser import SqlParser

# This class defines a complete listener for a parse tree produced by SqlParser.
class SqlParserListener(ParseTreeListener):

    # Enter a parse tree produced by SqlParser#sqlFile.
    def enterSqlFile(self, ctx:SqlParser.SqlFileContext):
        pass

    # Exit a parse tree produced by SqlParser#sqlFile.
    def exitSqlFile(self, ctx:SqlParser.SqlFileContext):
        pass


    # Enter a parse tree produced by SqlParser#sqlStatement.
    def enterSqlStatement(self, ctx:SqlParser.SqlStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#sqlStatement.
    def exitSqlStatement(self, ctx:SqlParser.SqlStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#cteStatement.
    def enterCteStatement(self, ctx:SqlParser.CteStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#cteStatement.
    def exitCteStatement(self, ctx:SqlParser.CteStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#cteDefinition.
    def enterCteDefinition(self, ctx:SqlParser.CteDefinitionContext):
        pass

    # Exit a parse tree produced by SqlParser#cteDefinition.
    def exitCteDefinition(self, ctx:SqlParser.CteDefinitionContext):
        pass


    # Enter a parse tree produced by SqlParser#dmlStatement.
    def enterDmlStatement(self, ctx:SqlParser.DmlStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#dmlStatement.
    def exitDmlStatement(self, ctx:SqlParser.DmlStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#selectStatement.
    def enterSelectStatement(self, ctx:SqlParser.SelectStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#selectStatement.
    def exitSelectStatement(self, ctx:SqlParser.SelectStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#selectList.
    def enterSelectList(self, ctx:SqlParser.SelectListContext):
        pass

    # Exit a parse tree produced by SqlParser#selectList.
    def exitSelectList(self, ctx:SqlParser.SelectListContext):
        pass


    # Enter a parse tree produced by SqlParser#selectElement.
    def enterSelectElement(self, ctx:SqlParser.SelectElementContext):
        pass

    # Exit a parse tree produced by SqlParser#selectElement.
    def exitSelectElement(self, ctx:SqlParser.SelectElementContext):
        pass


    # Enter a parse tree produced by SqlParser#tableSource.
    def enterTableSource(self, ctx:SqlParser.TableSourceContext):
        pass

    # Exit a parse tree produced by SqlParser#tableSource.
    def exitTableSource(self, ctx:SqlParser.TableSourceContext):
        pass


    # Enter a parse tree produced by SqlParser#tableName.
    def enterTableName(self, ctx:SqlParser.TableNameContext):
        pass

    # Exit a parse tree produced by SqlParser#tableName.
    def exitTableName(self, ctx:SqlParser.TableNameContext):
        pass


    # Enter a parse tree produced by SqlParser#joinClause.
    def enterJoinClause(self, ctx:SqlParser.JoinClauseContext):
        pass

    # Exit a parse tree produced by SqlParser#joinClause.
    def exitJoinClause(self, ctx:SqlParser.JoinClauseContext):
        pass


    # Enter a parse tree produced by SqlParser#joinType.
    def enterJoinType(self, ctx:SqlParser.JoinTypeContext):
        pass

    # Exit a parse tree produced by SqlParser#joinType.
    def exitJoinType(self, ctx:SqlParser.JoinTypeContext):
        pass


    # Enter a parse tree produced by SqlParser#columnName.
    def enterColumnName(self, ctx:SqlParser.ColumnNameContext):
        pass

    # Exit a parse tree produced by SqlParser#columnName.
    def exitColumnName(self, ctx:SqlParser.ColumnNameContext):
        pass


    # Enter a parse tree produced by SqlParser#whereClause.
    def enterWhereClause(self, ctx:SqlParser.WhereClauseContext):
        pass

    # Exit a parse tree produced by SqlParser#whereClause.
    def exitWhereClause(self, ctx:SqlParser.WhereClauseContext):
        pass


    # Enter a parse tree produced by SqlParser#groupByClause.
    def enterGroupByClause(self, ctx:SqlParser.GroupByClauseContext):
        pass

    # Exit a parse tree produced by SqlParser#groupByClause.
    def exitGroupByClause(self, ctx:SqlParser.GroupByClauseContext):
        pass


    # Enter a parse tree produced by SqlParser#orderByClause.
    def enterOrderByClause(self, ctx:SqlParser.OrderByClauseContext):
        pass

    # Exit a parse tree produced by SqlParser#orderByClause.
    def exitOrderByClause(self, ctx:SqlParser.OrderByClauseContext):
        pass


    # Enter a parse tree produced by SqlParser#orderElement.
    def enterOrderElement(self, ctx:SqlParser.OrderElementContext):
        pass

    # Exit a parse tree produced by SqlParser#orderElement.
    def exitOrderElement(self, ctx:SqlParser.OrderElementContext):
        pass


    # Enter a parse tree produced by SqlParser#searchCondition.
    def enterSearchCondition(self, ctx:SqlParser.SearchConditionContext):
        pass

    # Exit a parse tree produced by SqlParser#searchCondition.
    def exitSearchCondition(self, ctx:SqlParser.SearchConditionContext):
        pass


    # Enter a parse tree produced by SqlParser#orExpression.
    def enterOrExpression(self, ctx:SqlParser.OrExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#orExpression.
    def exitOrExpression(self, ctx:SqlParser.OrExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#andExpression.
    def enterAndExpression(self, ctx:SqlParser.AndExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#andExpression.
    def exitAndExpression(self, ctx:SqlParser.AndExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#notExpression.
    def enterNotExpression(self, ctx:SqlParser.NotExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#notExpression.
    def exitNotExpression(self, ctx:SqlParser.NotExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#predicate.
    def enterPredicate(self, ctx:SqlParser.PredicateContext):
        pass

    # Exit a parse tree produced by SqlParser#predicate.
    def exitPredicate(self, ctx:SqlParser.PredicateContext):
        pass


    # Enter a parse tree produced by SqlParser#comparisonOperator.
    def enterComparisonOperator(self, ctx:SqlParser.ComparisonOperatorContext):
        pass

    # Exit a parse tree produced by SqlParser#comparisonOperator.
    def exitComparisonOperator(self, ctx:SqlParser.ComparisonOperatorContext):
        pass


    # Enter a parse tree produced by SqlParser#expression.
    def enterExpression(self, ctx:SqlParser.ExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#expression.
    def exitExpression(self, ctx:SqlParser.ExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#assignmentExpression.
    def enterAssignmentExpression(self, ctx:SqlParser.AssignmentExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#assignmentExpression.
    def exitAssignmentExpression(self, ctx:SqlParser.AssignmentExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#additiveExpression.
    def enterAdditiveExpression(self, ctx:SqlParser.AdditiveExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#additiveExpression.
    def exitAdditiveExpression(self, ctx:SqlParser.AdditiveExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#multiplicativeExpression.
    def enterMultiplicativeExpression(self, ctx:SqlParser.MultiplicativeExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#multiplicativeExpression.
    def exitMultiplicativeExpression(self, ctx:SqlParser.MultiplicativeExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#unaryExpression.
    def enterUnaryExpression(self, ctx:SqlParser.UnaryExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#unaryExpression.
    def exitUnaryExpression(self, ctx:SqlParser.UnaryExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#primaryExpression.
    def enterPrimaryExpression(self, ctx:SqlParser.PrimaryExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#primaryExpression.
    def exitPrimaryExpression(self, ctx:SqlParser.PrimaryExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#caseExpression.
    def enterCaseExpression(self, ctx:SqlParser.CaseExpressionContext):
        pass

    # Exit a parse tree produced by SqlParser#caseExpression.
    def exitCaseExpression(self, ctx:SqlParser.CaseExpressionContext):
        pass


    # Enter a parse tree produced by SqlParser#whenClause.
    def enterWhenClause(self, ctx:SqlParser.WhenClauseContext):
        pass

    # Exit a parse tree produced by SqlParser#whenClause.
    def exitWhenClause(self, ctx:SqlParser.WhenClauseContext):
        pass


    # Enter a parse tree produced by SqlParser#literal.
    def enterLiteral(self, ctx:SqlParser.LiteralContext):
        pass

    # Exit a parse tree produced by SqlParser#literal.
    def exitLiteral(self, ctx:SqlParser.LiteralContext):
        pass


    # Enter a parse tree produced by SqlParser#functionCall.
    def enterFunctionCall(self, ctx:SqlParser.FunctionCallContext):
        pass

    # Exit a parse tree produced by SqlParser#functionCall.
    def exitFunctionCall(self, ctx:SqlParser.FunctionCallContext):
        pass


    # Enter a parse tree produced by SqlParser#insertStatement.
    def enterInsertStatement(self, ctx:SqlParser.InsertStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#insertStatement.
    def exitInsertStatement(self, ctx:SqlParser.InsertStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#updateStatement.
    def enterUpdateStatement(self, ctx:SqlParser.UpdateStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#updateStatement.
    def exitUpdateStatement(self, ctx:SqlParser.UpdateStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#assignment.
    def enterAssignment(self, ctx:SqlParser.AssignmentContext):
        pass

    # Exit a parse tree produced by SqlParser#assignment.
    def exitAssignment(self, ctx:SqlParser.AssignmentContext):
        pass


    # Enter a parse tree produced by SqlParser#deleteStatement.
    def enterDeleteStatement(self, ctx:SqlParser.DeleteStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#deleteStatement.
    def exitDeleteStatement(self, ctx:SqlParser.DeleteStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#ddlStatement.
    def enterDdlStatement(self, ctx:SqlParser.DdlStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#ddlStatement.
    def exitDdlStatement(self, ctx:SqlParser.DdlStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#createTableStatement.
    def enterCreateTableStatement(self, ctx:SqlParser.CreateTableStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#createTableStatement.
    def exitCreateTableStatement(self, ctx:SqlParser.CreateTableStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#columnDefinition.
    def enterColumnDefinition(self, ctx:SqlParser.ColumnDefinitionContext):
        pass

    # Exit a parse tree produced by SqlParser#columnDefinition.
    def exitColumnDefinition(self, ctx:SqlParser.ColumnDefinitionContext):
        pass


    # Enter a parse tree produced by SqlParser#nullability.
    def enterNullability(self, ctx:SqlParser.NullabilityContext):
        pass

    # Exit a parse tree produced by SqlParser#nullability.
    def exitNullability(self, ctx:SqlParser.NullabilityContext):
        pass


    # Enter a parse tree produced by SqlParser#dataType.
    def enterDataType(self, ctx:SqlParser.DataTypeContext):
        pass

    # Exit a parse tree produced by SqlParser#dataType.
    def exitDataType(self, ctx:SqlParser.DataTypeContext):
        pass


    # Enter a parse tree produced by SqlParser#typeParams.
    def enterTypeParams(self, ctx:SqlParser.TypeParamsContext):
        pass

    # Exit a parse tree produced by SqlParser#typeParams.
    def exitTypeParams(self, ctx:SqlParser.TypeParamsContext):
        pass


    # Enter a parse tree produced by SqlParser#dropTableStatement.
    def enterDropTableStatement(self, ctx:SqlParser.DropTableStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#dropTableStatement.
    def exitDropTableStatement(self, ctx:SqlParser.DropTableStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#alterTableStatement.
    def enterAlterTableStatement(self, ctx:SqlParser.AlterTableStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#alterTableStatement.
    def exitAlterTableStatement(self, ctx:SqlParser.AlterTableStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#alterAction.
    def enterAlterAction(self, ctx:SqlParser.AlterActionContext):
        pass

    # Exit a parse tree produced by SqlParser#alterAction.
    def exitAlterAction(self, ctx:SqlParser.AlterActionContext):
        pass


    # Enter a parse tree produced by SqlParser#cursorStatement.
    def enterCursorStatement(self, ctx:SqlParser.CursorStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#cursorStatement.
    def exitCursorStatement(self, ctx:SqlParser.CursorStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#declareCursor.
    def enterDeclareCursor(self, ctx:SqlParser.DeclareCursorContext):
        pass

    # Exit a parse tree produced by SqlParser#declareCursor.
    def exitDeclareCursor(self, ctx:SqlParser.DeclareCursorContext):
        pass


    # Enter a parse tree produced by SqlParser#openCursor.
    def enterOpenCursor(self, ctx:SqlParser.OpenCursorContext):
        pass

    # Exit a parse tree produced by SqlParser#openCursor.
    def exitOpenCursor(self, ctx:SqlParser.OpenCursorContext):
        pass


    # Enter a parse tree produced by SqlParser#fetchCursor.
    def enterFetchCursor(self, ctx:SqlParser.FetchCursorContext):
        pass

    # Exit a parse tree produced by SqlParser#fetchCursor.
    def exitFetchCursor(self, ctx:SqlParser.FetchCursorContext):
        pass


    # Enter a parse tree produced by SqlParser#closeCursor.
    def enterCloseCursor(self, ctx:SqlParser.CloseCursorContext):
        pass

    # Exit a parse tree produced by SqlParser#closeCursor.
    def exitCloseCursor(self, ctx:SqlParser.CloseCursorContext):
        pass


    # Enter a parse tree produced by SqlParser#blockStatement.
    def enterBlockStatement(self, ctx:SqlParser.BlockStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#blockStatement.
    def exitBlockStatement(self, ctx:SqlParser.BlockStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#blockContent.
    def enterBlockContent(self, ctx:SqlParser.BlockContentContext):
        pass

    # Exit a parse tree produced by SqlParser#blockContent.
    def exitBlockContent(self, ctx:SqlParser.BlockContentContext):
        pass


    # Enter a parse tree produced by SqlParser#execStatement.
    def enterExecStatement(self, ctx:SqlParser.ExecStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#execStatement.
    def exitExecStatement(self, ctx:SqlParser.ExecStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#tryCatchStatement.
    def enterTryCatchStatement(self, ctx:SqlParser.TryCatchStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#tryCatchStatement.
    def exitTryCatchStatement(self, ctx:SqlParser.TryCatchStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#ifStatement.
    def enterIfStatement(self, ctx:SqlParser.IfStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#ifStatement.
    def exitIfStatement(self, ctx:SqlParser.IfStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#declareStatement.
    def enterDeclareStatement(self, ctx:SqlParser.DeclareStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#declareStatement.
    def exitDeclareStatement(self, ctx:SqlParser.DeclareStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#setStatement.
    def enterSetStatement(self, ctx:SqlParser.SetStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#setStatement.
    def exitSetStatement(self, ctx:SqlParser.SetStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#havingClause.
    def enterHavingClause(self, ctx:SqlParser.HavingClauseContext):
        pass

    # Exit a parse tree produced by SqlParser#havingClause.
    def exitHavingClause(self, ctx:SqlParser.HavingClauseContext):
        pass


    # Enter a parse tree produced by SqlParser#useDatabaseStatement.
    def enterUseDatabaseStatement(self, ctx:SqlParser.UseDatabaseStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#useDatabaseStatement.
    def exitUseDatabaseStatement(self, ctx:SqlParser.UseDatabaseStatementContext):
        pass


    # Enter a parse tree produced by SqlParser#truncateTableStatement.
    def enterTruncateTableStatement(self, ctx:SqlParser.TruncateTableStatementContext):
        pass

    # Exit a parse tree produced by SqlParser#truncateTableStatement.
    def exitTruncateTableStatement(self, ctx:SqlParser.TruncateTableStatementContext):
        pass



del SqlParser
```

---

### <a id="📄-test-sql"></a>📄 `test.sql`

**File Info:**
- **Size**: 2.39 KB
- **Extension**: `.sql`
- **Language**: `sql`
- **Location**: `test.sql`
- **Relative Path**: `root`
- **Created**: 2026-01-10 14:46:39 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-10 14:46:39 (Asia/Damascus / GMT+03:00)
- **MD5**: `9ed02d2861163f03f67e6e50c11d915c`
- **SHA256**: `9c163da829b632a62afdb7be099faee728c0bed8843023666306f395708bd0f8`
- **Encoding**: ASCII

**File code content:**

```sql

CREATE TABLE [dbo].[DIAGNOSIS](
	[DIAGNOSIS_KEY'1] [int] NOT NULL,
	[DIAGNOSIS_NAME] [nvarchar](300) NOT NULL,
	[DIAGNOSIS_CATEGORY_KEY] [int] NULL
	)

IF NOT EXISTS (
    SELECT 1 FROM sys.columns
    WHERE Name = 'KEY1''S'
      AND Object_ID = Object_ID('FACT1')
)
BEGIN
		ALTER TABLE FACT1 
        ADD [KEY1'S] INT NULL;
END
GO

UPDATE FACT1
SET [KEY1'S] =
    CASE 
        WHEN KEY2 = 4 OR KEY3 IN (1,7) THEN 1
        WHEN KEY5 = 2 THEN 2
        ELSE 0
    END
WHERE [KEY1'S] IS NULL;
GO

IF NOT EXISTS (
    SELECT 1 FROM sys.columns 
    WHERE Name = 'HASH2' 
      AND Object_ID = Object_ID('FACT_2')
)
BEGIN
    ALTER TABLE FACT_2 
    ADD HASH2 BIGINT NULL;
END
GO

IF NOT EXISTS (
    SELECT 1 FROM sys.columns 
    WHERE Name = 'DIAGNOSIS_KEY''1' 
      AND Object_ID = Object_ID('FACT_2')
)
BEGIN
    ALTER TABLE FACT_2 
    ADD [DIAGNOSIS_KEY'1] INT NULL;
END
GO


DECLARE @ErrorMessage         NVARCHAR(4000)          
DECLARE @ErrorState           INT          
DECLARE @ErrorSeverity        INT 

/* DROP CONSTARINTS */
declare @sql_drop_constarints nvarchar(max)
set @sql_drop_constarints = ''

SELECT @sql_drop_constarints += N'
ALTER TABLE ' + QUOTENAME(OBJECT_SCHEMA_NAME(parent_object_id))
    + '.' + QUOTENAME(OBJECT_NAME(parent_object_id)) + 
    ' DROP CONSTRAINT ' + QUOTENAME(name) + ';' 
FROM sys.foreign_keys;

BEGIN TRY
EXEC sp_executesql @sql_drop_constarints;
END TRY
BEGIN CATCH

    --Obtain the error message, severity and state      
    SELECT @ErrorMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE()      
    --RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState)         
END CATCH


/* DROP ALL TABLES EXECPT 
/* DROP ALL TABLES EXECPT 
*/
*/
DECLARE @sql_drop_tables NVARCHAR(max)=''

SELECT @sql_drop_tables += ' Drop table ' + QUOTENAME(TABLE_SCHEMA) + '.'+ QUOTENAME(TABLE_NAME) + '; '
FROM   INFORMATION_SCHEMA.TABLES
WHERE  TABLE_TYPE = 'BASE TABLE'
AND TABLE_NAME NOT IN ('FACT1', 'fact2', 'Fact3' )

Exec Sp_executesql @sql_drop_tables

BEGIN TRY
EXEC sp_executesql @sql_drop_tables;
END TRY
BEGIN CATCH
    --Obtain the error message, severity and state      
    SELECT @ErrorMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE()      
    --RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState)         
END CATCH
```

---

### <a id="📄-testing-sql"></a>📄 `testing.sql`

**File Info:**
- **Size**: 2.39 KB
- **Extension**: `.sql`
- **Language**: `sql`
- **Location**: `testing.sql`
- **Relative Path**: `root`
- **Created**: 2025-12-04 04:15:38 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-18 09:05:27 (Asia/Damascus / GMT+03:00)
- **MD5**: `fa8ccb74fc36cbfcd1b6ec2af70e149b`
- **SHA256**: `dddcab0487a2bdd406e157e99d58a4a3b48705da8ea7190a00ebac6c33a40186`
- **Encoding**: ASCII

**File code content:**

```sql

CREATE TABLE [dbo].[DIAGNOSIS](
	[DIAGNOSIS_KEY'1] [int] NOT NULL,
	[DIAGNOSIS_NAME] [nvarchar](300) NOT NULL,
	[DIAGNOSIS_CATEGORY_KEY] [int] NULL
	)

IF NOT EXISTS (
    SELECT 1 FROM sys.columns
    WHERE Name = 'KEY1''S'
      AND Object_ID = Object_ID('FACT1')
)
BEGIN
		ALTER TABLE FACT1 
        ADD [KEY1'S] INT NULL;
END
GO

UPDATE FACT1
SET [KEY1'S] =
    CASE 
        WHEN KEY2 = 4 OR KEY3 IN (1,7) THEN 1
        WHEN KEY5 = 2 THEN 2
        ELSE 0
    END
WHERE [KEY1'S] IS NULL;
GO

IF NOT EXISTS (
    SELECT 1 FROM sys.columns 
    WHERE Name = 'HASH2' 
      AND Object_ID = Object_ID('FACT_2')
)
BEGIN
    ALTER TABLE FACT_2 
    ADD HASH2 BIGINT NULL;
END
GO

IF NOT EXISTS (
    SELECT 1 FROM sys.columns 
    WHERE Name = 'DIAGNOSIS_KEY''1' 
      AND Object_ID = Object_ID('FACT_2')
)
BEGIN
    ALTER TABLE FACT_2 
    ADD [DIAGNOSIS_KEY'1] INT NULL;
END
GO


DECLARE @ErrorMessage         NVARCHAR(4000)          
DECLARE @ErrorState           INT          
DECLARE @ErrorSeverity        INT 

/* DROP CONSTARINTS */
declare @sql_drop_constarints nvarchar(max)
set @sql_drop_constarints = ''

SELECT @sql_drop_constarints += N'
ALTER TABLE ' + QUOTENAME(OBJECT_SCHEMA_NAME(parent_object_id))
    + '.' + QUOTENAME(OBJECT_NAME(parent_object_id)) + 
    ' DROP CONSTRAINT ' + QUOTENAME(name) + ';' 
FROM sys.foreign_keys;

BEGIN TRY
EXEC sp_executesql @sql_drop_constarints;
END TRY
BEGIN CATCH

    --Obtain the error message, severity and state      
    SELECT @ErrorMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE()      
    --RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState)         
END CATCH


/* DROP ALL TABLES EXECPT 
/* DROP ALL TABLES EXECPT 
*/
*/
DECLARE @sql_drop_tables NVARCHAR(max)=''

SELECT @sql_drop_tables += ' Drop table ' + QUOTENAME(TABLE_SCHEMA) + '.'+ QUOTENAME(TABLE_NAME) + '; '
FROM   INFORMATION_SCHEMA.TABLES
WHERE  TABLE_TYPE = 'BASE TABLE'
AND TABLE_NAME NOT IN ('FACT1', 'fact2', 'Fact3' )

Exec Sp_executesql @sql_drop_tables

BEGIN TRY
EXEC sp_executesql @sql_drop_tables;
END TRY
BEGIN CATCH
    --Obtain the error message, severity and state      
    SELECT @ErrorMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE()      
    --RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState)         
END CATCH


```

---

### <a id="📄-train-sql"></a>📄 `train.sql`

**File Info:**
- **Size**: 4.34 KB
- **Extension**: `.sql`
- **Language**: `sql`
- **Location**: `train.sql`
- **Relative Path**: `root`
- **Created**: 2026-01-17 09:30:59 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-18 09:33:16 (Asia/Damascus / GMT+03:00)
- **MD5**: `d4b28d0f2dba5c5ea0ef1e24e3093066`
- **SHA256**: `e6ee22af466ce020d6a104e435b00f69619b4154cafae19296f1f0b1fec04075`
- **Encoding**: ASCII

**File code content:**

```sql
-- Using a subquery that uses the MAX() function

SELECT 
    productid, productname, unitprice
FROM
    products
WHERE
    unitprice = (SELECT MAX(unitprice) FROM products);

--Will be equal to

SELECT 
    productid, productname, unitprice
FROM
    products
WHERE
    unitprice = 263.50;

SELECT 
    AVG(unitprice)
FROM
    products;


SELECT 
    AVG(unitprice) AS 'avg unit price'
FROM
    products;
	
-- Using a subquery that uses the AVG() function

SELECT 
    productid, productname, unitprice
FROM
    products
WHERE
    unitprice > (SELECT AVG(unitprice) FROM products);

--Will be equal to

SELECT 
    productid, productname, unitprice
FROM
    products
WHERE
    unitprice > 28.8663;



	SELECT CompanyName, city
  FROM Suppliers  
  WHERE Country = 'USA'  
  ORDER BY CompanyName; 

--Using BETWEEN operator
SELECT * FROM Employees 
WHERE EmployeeID BETWEEN 1 AND 5

--Using IN operator
SELECT * FROM Employees 
WHERE EmployeeID IN (1,2,3)

--Using LIKE operator
SELECT * FROM Employees 
WHERE FirstName Like 'Robert'

SELECT FirstName, BirthDate FROM Employees
ORDER BY BirthDate DESC

--First sort by BD, then by First name
SELECT FirstName, BirthDate FROM Employees
ORDER BY BirthDate DESC,
FirstName ASC;

SELECT ProductName,UnitPrice FROM Products 
GROUP BY ProductName, UnitPrice
HAVING AVG(UnitPrice)>20

SELECT * FROM Products 

SELECT ProductName,UnitPrice FROM Products 

--a simple expression:
SELECT 1 + 1

--combine string using CONCAT()
SELECT CONCAT(LastName,', ',FirstName) AS fullname
FROM employees

use employee_db
go
CREATE TABLE EmployeeMaster
(
	  Id INT IDENTITY PRIMARY KEY,      
	  EmployeeCode varchar(10),
	  EmployeeName varchar(25),
      DepartmentCode varchar(10),
      LocationCode varchar(10),
      salary int
)

TRUNCATE TABLE EmployeeMaster;
GO;



INSERT into EmployeeMaster(EmployeeCode, EmployeeName, DepartmentCode, LocationCode ,salary)
VALUES
('E0001', 'Hulk', 'IT','TVM', 4000),
('E0002', 'Spiderman', 'IT','TVM',  4000),
('E0003', 'Ironman', 'QA','KLM', 3000),
('E0004', 'Superman', 'QA','KLM', 3000),
('E0005', 'Batman', 'HR','TVM', 5000),
('E0005', 'Raju', 'HR','KTM', 5000),
('E0005', 'Radha', 'HR','KTM', 5000)



SELECT * from EmployeeMaster WHERE salary IS NOT NULL

SELECT * from EmployeeMaster WHERE salary IS NULL

SELECT * from EmployeeMaster WHERE employeename LIKE 'super'

SELECT * from EmployeeMaster WHERE employeename LIKE 'super''\\\\AZ\
c'

SELECT * from EmployeeMaster WHERE employeename LIKE 'super''\\\\AZ
c'

SELECT * from EmployeeMaster WHERE employeename LIKE 'sup%'

SELECT * from EmployeeMaster WHERE employeename LIKE '%man'

SELECT * from EmployeeMaster WHERE employeename NOT LIKE '%ra%'

/*will return 8 letter names starting with Su, containing p or j in between and ending in erman*/
SELECT * from EmployeeMaster WHERE employeename LIKE 'Su[pj]erman%'

/*will return 4 letter names starting with ra, containing n or j in between and ending in u*/
SELECT * from EmployeeMaster WHERE employeename LIKE 'ra[nj]u%'

/*will return 4 letter names starting with ra, NOT containing n or j in between and ending in u*/
SELECT * from EmployeeMaster WHERE employeename LIKE 'ra[^nj]u%'

SELECT * from EmployeeMaster WHERE employeename NOT LIKE 'raj%'

select * from EmployeeMaster WHERE EXISTS
(select * from EmployeeMaster where EmployeeName  LIKE 'superman')



SELECT trainee.admission_no, trainee.first_name, trainee.last_name, fee.course, fee.amount  
FROM trainee  
INNER JOIN fee ON trainee.admission_no = fee.admission_no; 

SELECT trainee.admission_no, trainee.first_name, trainee.last_name, fee.course, fee.amount, semester.sem_name 
FROM trainee  
INNER JOIN fee ON trainee.admission_no = fee.admission_no
INNER JOIN semester ON semester.sem_no = fee.sem_no  

SELECT trainee.admission_no, trainee.first_name, trainee.last_name, fee.course, fee.amount  
FROM trainee  
LEFT OUTER JOIN fee ON trainee.admission_no = fee.admission_no; 

SELECT trainee.admission_no, trainee.first_name, trainee.last_name, fee.course, fee.amount  
FROM trainee  
RIGHT OUTER JOIN fee ON trainee.admission_no = fee.admission_no;

SELECT trainee.admission_no, trainee.first_name, trainee.last_name, fee.course, fee.amount  
FROM trainee  
FULL OUTER JOIN fee ON trainee.admission_no = fee.admission_no;
```

---

### <a id="📄-train2-sql"></a>📄 `train2.sql`

**File Info:**
- **Size**: 1.64 KB
- **Extension**: `.sql`
- **Language**: `sql`
- **Location**: `train2.sql`
- **Relative Path**: `root`
- **Created**: 2026-01-18 09:52:19 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-18 09:52:21 (Asia/Damascus / GMT+03:00)
- **MD5**: `cacb21747a741073c1f81d71383ba295`
- **SHA256**: `c431b87a23fd68356e591624651e596df940b9454574feb8ae7101ca25920dce`
- **Encoding**: ASCII

**File code content:**

```sql
-- Syntax for SQL Server and Azure SQL Database   
[ WITH <common_table_expression> [...n] ]   
UPDATE    
    [ TOP ( expression ) [ PERCENT ] ]    
    { { table_alias | <object> | rowset_function_limited    
         [ WITH ( <Table_Hint_Limited> [ ...n ] ) ]   
      }   
      | @table_variable       
    }   
    SET   
        { column_name = { expression | DEFAULT | NULL }   
          | { udt_column_name.{ { property_name = expression   
                                | field_name = expression }   
                                | method_name ( argument [ ,...n ] )   
                              }   
          }   
          | column_name { .WRITE ( expression , @Offset , @Length ) }   
          | @variable = expression   
          | @variable = column = expression   
          | column_name { += | -= | *= | /= | %= | &= | ^= | |= } expression   
          | @variable { += | -= | *= | /= | %= | &= | ^= | |= } expression   
          | @variable = column { += | -= | *= | /= | %= | &= | ^= | |= } expression   
        } [ ,...n ]    
   
    [ <OUTPUT Clause> ]   
    [ FROM{ <table_source> } [ ,...n ] ]    
    [ WHERE { <search_condition>    
            | { [ CURRENT OF    
                  { { [ GLOBAL ] cursor_name }    
                      | cursor_variable_name    
                  }    
                ]   
              }   
            }    
    ]    
    [ OPTION ( <query_hint> [ ,...n ] ) ]   
[ ; ]   
   
<object> ::=   
{    
    [ server_name . database_name . schema_name .    
    | database_name .[ schema_name ] .    
    | schema_name .   
    ]   
    table_or_view_name}
```

---

## 🚫 Binary/Excluded Files

The following files were not included in the text content:

- `SqlLexer.g4`
- `SqlLexer.tokens`
- `SqlParser.g4`
- `SqlParser.tokens`

