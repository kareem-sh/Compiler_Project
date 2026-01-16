# 📁 PROJECT EXPORT FOR LLMs

## 📊 Project Information

- **Project Name**: `Compilrt_Project`
- **Generated On**: 2026-01-16 10:36:01 (Asia/Damascus / GMT+03:00)
- **Total Files Processed**: 16
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
│   ├── 📄 SqlLexer.cpython-313.pyc (96.09 KB)
│   └── 📄 SqlParser.cpython-313.pyc (264.47 KB)
├── 📄 main.py (1.5 KB)
├── 📄 SqlLexer.g4 (5 KB)
├── 📄 SqlLexer.java (114.56 KB)
├── 📄 SqlLexer.py (69.69 KB)
├── 📄 SqlLexer.tokens (5.33 KB)
├── 📄 SqlParser.g4 (7.9 KB)
├── 📄 SqlParser.java (164.86 KB)
├── 📄 SqlParser.py (172.28 KB)
├── 📄 SqlParser.tokens (5.33 KB)
├── 📄 SqlParserBaseListener.java (19.56 KB)
├── 📄 SqlParserListener.java (19.02 KB)
├── 📄 SqlParserListener.py (16.42 KB)
├── 📄 test.sql (2.39 KB)
└── 📄 testing.sql (2.39 KB)
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

---

## 📈 Project Statistics

| Metric | Count |
|--------|-------|
| Total Files | 16 |
| Total Directories | 1 |
| Text Files | 10 |
| Binary Files | 6 |
| Total Size | 966.83 KB |

### 📄 File Types Distribution

| Extension | Count |
|-----------|-------|
| `.py` | 4 |
| `.java` | 4 |
| `.pyc` | 2 |
| `.g4` | 2 |
| `.tokens` | 2 |
| `.sql` | 2 |

## 💻 File Code Contents

## 🚫 Binary/Excluded Files

The following files were not included in the text content:

- `__pycache__/SqlLexer.cpython-313.pyc`
- `__pycache__/SqlParser.cpython-313.pyc`

### <a id="📄-main-py"></a>📄 `main.py`

**File Info:**
- **Size**: 1.5 KB
- **Extension**: `.py`
- **Language**: `python`
- **Location**: `main.py`
- **Relative Path**: `root`
- **Created**: 2025-11-27 05:06:21 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-10 14:46:39 (Asia/Damascus / GMT+03:00)
- **MD5**: `e150b0105511799397a1b4baf7e9c396`
- **SHA256**: `fc0f44312773798942c429993963d2d08fd99c76139c1c1c89a86934f05293f1`
- **Encoding**: UTF-8

**File code content:**

```python
from antlr4 import *
from SqlLexer import SqlLexer
from SqlParser import SqlParser
from antlr4.tree.Trees import Trees


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
parse_file("testing.sql")

```

---

### <a id="📄-sqllexer-java"></a>📄 `SqlLexer.java`

**File Info:**
- **Size**: 114.56 KB
- **Extension**: `.java`
- **Language**: `java`
- **Location**: `SqlLexer.java`
- **Relative Path**: `root`
- **Created**: 2025-11-27 05:08:16 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-16 10:35:58 (Asia/Damascus / GMT+03:00)
- **MD5**: `26561a7a03fc7982be3baf5e25e36f9d`
- **SHA256**: `ac4ded9c746e902444108f7d58751cc93e9ad27141c50ad1ec9039dc7e341431`
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
		BREAK=34, GOTO=35, REVERT=36, BROWSE=37, GRANT=38, REVOKE=39, BULK=40, 
		GROUP=41, RIGHT=42, BY=43, HAVING=44, ROLLBACK=45, CASCADE=46, HOLDLOCK=47, 
		ROWCOUNT=48, CASE=49, IDENTITY=50, ROWGUIDCOL=51, CHECK=52, IDENTITY_INSERT=53, 
		RULE=54, CHECKPOINT=55, IDENTITYCOL=56, SAVE=57, CLOSE=58, IF=59, SCHEMA=60, 
		CLUSTERED=61, IN=62, SECURITYAUDIT=63, COALESCE=64, INDEX=65, SELECT=66, 
		COLLATE=67, INNER=68, SEMANTICKEYPHRASETABLE=69, COLUMN=70, INSERT=71, 
		SEMANTICSIMILARITYDETAILSTABLE=72, COMMIT=73, INTERSECT=74, SEMANTICSIMILARITYTABLE=75, 
		COMPUTE=76, INTO=77, SESSION_USER=78, CONSTRAINT=79, IS=80, SET=81, CONTAINS=82, 
		JOIN=83, SETUSER=84, CONTAINSTABLE=85, KEY=86, SHUTDOWN=87, CONTINUE=88, 
		KILL=89, SOME=90, CONVERT=91, LEFT=92, STATISTICS=93, CREATE=94, LIKE=95, 
		SYSTEM_USER=96, CROSS=97, LINENO=98, TABLE=99, CURRENT=100, LOAD=101, 
		TABLESAMPLE=102, CURRENT_DATE=103, MERGE=104, TEXTSIZE=105, CURRENT_TIME=106, 
		NATIONAL=107, THEN=108, CURRENT_TIMESTAMP=109, NOCHECK=110, TO=111, CURRENT_USER=112, 
		NONCLUSTERED=113, TOP=114, CURSOR=115, NOT=116, TRAN=117, DATABASE=118, 
		NULL=119, TRANSACTION=120, DBCC=121, NULLIF=122, TRIGGER=123, DEALLOCATE=124, 
		OF=125, TRUNCATE=126, DECLARE=127, OFF=128, TRY_CONVERT=129, DEFAULT=130, 
		OFFSETS=131, TSEQUAL=132, DELETE=133, ON=134, UNION=135, DENY=136, OPEN=137, 
		UNIQUE=138, DESC=139, OPENDATASOURCE=140, UPDATE=141, DISK=142, OPENQUERY=143, 
		UPDATETEXT=144, DISTINCT=145, OPENROWSET=146, USE=147, DISTRIBUTED=148, 
		OPENXML=149, USER=150, DOUBLE=151, OPTION=152, VALUES=153, DROP=154, OR=155, 
		VARYING=156, DUMP=157, ORDER=158, VIEW=159, ELSE=160, OUTER=161, WAITFOR=162, 
		END=163, OVER=164, WHEN=165, ERRLVL=166, PERCENT=167, WHERE=168, ESCAPE=169, 
		PIVOT=170, WHILE=171, EXCEPT=172, PLAN=173, WITH=174, EXEC=175, PRECISION=176, 
		WRITETEXT=177, EXECUTE=178, PRIMARY=179, INT=180, NVARCHAR=181, VARCHAR=182, 
		MAX=183, TRY=184, CATCH=185, EXISTS=186, INT_LITERAL=187, FLOAT_LITERAL=188, 
		HEX_LITERAL=189, BIT_LITERAL=190, TRUE_LITERAL=191, FALSE_LITERAL=192, 
		STRING_LITERAL=193, BRACKET_IDENTIFIER=194, IDENTIFIER=195, USER_VAR=196, 
		EQ=197, NEQ=198, GT=199, LT=200, GTE=201, LTE=202, PLUS=203, MINUS=204, 
		STAR=205, SLASH=206, PLUS_EQ=207, COMMA=208, DOT=209, LPAREN=210, RPAREN=211, 
		SPAREN=212, ZPAREN=213, SEMI=214, LINE_COMMENT=215, COMMENT=216, WS=217;
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
			"FUNCTION", "RETURN", "BREAK", "GOTO", "REVERT", "BROWSE", "GRANT", "REVOKE", 
			"BULK", "GROUP", "RIGHT", "BY", "HAVING", "ROLLBACK", "CASCADE", "HOLDLOCK", 
			"ROWCOUNT", "CASE", "IDENTITY", "ROWGUIDCOL", "CHECK", "IDENTITY_INSERT", 
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
			"EXECUTE", "PRIMARY", "INT", "NVARCHAR", "VARCHAR", "MAX", "TRY", "CATCH", 
			"EXISTS", "INT_LITERAL", "FLOAT_LITERAL", "HEX_LITERAL", "BIT_LITERAL", 
			"TRUE_LITERAL", "FALSE_LITERAL", "STRING_LITERAL", "BRACKET_IDENTIFIER", 
			"IDENTIFIER", "USER_VAR", "EQ", "NEQ", "GT", "LT", "GTE", "LTE", "PLUS", 
			"MINUS", "STAR", "SLASH", "PLUS_EQ", "COMMA", "DOT", "LPAREN", "RPAREN", 
			"SPAREN", "ZPAREN", "SEMI", "LINE_COMMENT", "COMMENT", "WS"
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
			"'REVERT'", "'BROWSE'", "'GRANT'", "'REVOKE'", "'BULK'", "'GROUP'", "'RIGHT'", 
			"'BY'", "'HAVING'", "'ROLLBACK'", "'CASCADE'", "'HOLDLOCK'", "'ROWCOUNT'", 
			"'CASE'", "'IDENTITY'", "'ROWGUIDCOL'", "'CHECK'", "'IDENTITY_INSERT'", 
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
			"'NVARCHAR'", "'VARCHAR'", "'MAX'", "'TRY'", "'CATCH'", "'EXISTS'", null, 
			null, null, null, "'TRUE'", "'FALSE'", null, null, null, null, "'='", 
			null, "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'+='", 
			"','", "'.'", "'('", "')'", "'['", "']'", "';'"
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
			"REVERT", "BROWSE", "GRANT", "REVOKE", "BULK", "GROUP", "RIGHT", "BY", 
			"HAVING", "ROLLBACK", "CASCADE", "HOLDLOCK", "ROWCOUNT", "CASE", "IDENTITY", 
			"ROWGUIDCOL", "CHECK", "IDENTITY_INSERT", "RULE", "CHECKPOINT", "IDENTITYCOL", 
			"SAVE", "CLOSE", "IF", "SCHEMA", "CLUSTERED", "IN", "SECURITYAUDIT", 
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
			"NVARCHAR", "VARCHAR", "MAX", "TRY", "CATCH", "EXISTS", "INT_LITERAL", 
			"FLOAT_LITERAL", "HEX_LITERAL", "BIT_LITERAL", "TRUE_LITERAL", "FALSE_LITERAL", 
			"STRING_LITERAL", "BRACKET_IDENTIFIER", "IDENTIFIER", "USER_VAR", "EQ", 
			"NEQ", "GT", "LT", "GTE", "LTE", "PLUS", "MINUS", "STAR", "SLASH", "PLUS_EQ", 
			"COMMA", "DOT", "LPAREN", "RPAREN", "SPAREN", "ZPAREN", "SEMI", "LINE_COMMENT", 
			"COMMENT", "WS"
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
		case 195:
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
		"\u0004\u0000\u00d9\u0803\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
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
		"\u0002\u00da\u0007\u00da\u0002\u00db\u0007\u00db\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001#"+
		"\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001*\u0001*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001-\u0001"+
		"-\u0001-\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u00010\u00010\u0001"+
		"0\u00010\u00010\u00010\u00010\u00010\u00011\u00011\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00011\u00012\u00012\u00012\u00012\u00012\u0001"+
		"2\u00012\u00012\u00012\u00013\u00013\u00013\u00013\u00013\u00014\u0001"+
		"4\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00015\u00015\u0001"+
		"5\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00017\u00017\u00017\u00017\u00017\u0001"+
		"7\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u0001"+
		"7\u00018\u00018\u00018\u00018\u00018\u00019\u00019\u00019\u00019\u0001"+
		"9\u00019\u00019\u00019\u00019\u00019\u00019\u0001:\u0001:\u0001:\u0001"+
		":\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001"+
		"=\u0001=\u0001=\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001"+
		"?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001"+
		"@\u0001@\u0001@\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001"+
		"A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001B\u0001B\u0001B\u0001"+
		"B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001C\u0001C\u0001C\u0001C\u0001"+
		"C\u0001C\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0001E\u0001"+
		"E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001F\u0001F\u0001F\u0001"+
		"F\u0001F\u0001F\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001"+
		"G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001"+
		"G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001H\u0001H\u0001H\u0001H\u0001"+
		"H\u0001H\u0001H\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001"+
		"J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001"+
		"J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001"+
		"J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001"+
		"J\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001L\u0001L\u0001"+
		"L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001M\u0001M\u0001"+
		"M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001"+
		"M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001"+
		"M\u0001M\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001"+
		"O\u0001O\u0001O\u0001O\u0001O\u0001P\u0001P\u0001P\u0001P\u0001P\u0001"+
		"P\u0001P\u0001P\u0001P\u0001P\u0001P\u0001P\u0001P\u0001Q\u0001Q\u0001"+
		"Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001R\u0001"+
		"R\u0001R\u0001S\u0001S\u0001S\u0001S\u0001T\u0001T\u0001T\u0001T\u0001"+
		"T\u0001T\u0001T\u0001T\u0001T\u0001U\u0001U\u0001U\u0001U\u0001U\u0001"+
		"V\u0001V\u0001V\u0001V\u0001V\u0001V\u0001V\u0001V\u0001W\u0001W\u0001"+
		"W\u0001W\u0001W\u0001W\u0001W\u0001W\u0001W\u0001W\u0001W\u0001W\u0001"+
		"W\u0001W\u0001X\u0001X\u0001X\u0001X\u0001Y\u0001Y\u0001Y\u0001Y\u0001"+
		"Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001"+
		"Z\u0001Z\u0001Z\u0001Z\u0001[\u0001[\u0001[\u0001[\u0001[\u0001\\\u0001"+
		"\\\u0001\\\u0001\\\u0001\\\u0001]\u0001]\u0001]\u0001]\u0001]\u0001]\u0001"+
		"]\u0001]\u0001^\u0001^\u0001^\u0001^\u0001^\u0001_\u0001_\u0001_\u0001"+
		"_\u0001_\u0001_\u0001_\u0001_\u0001_\u0001_\u0001_\u0001`\u0001`\u0001"+
		"`\u0001`\u0001`\u0001`\u0001`\u0001a\u0001a\u0001a\u0001a\u0001a\u0001"+
		"b\u0001b\u0001b\u0001b\u0001b\u0001b\u0001b\u0001b\u0001b\u0001b\u0001"+
		"b\u0001b\u0001c\u0001c\u0001c\u0001c\u0001c\u0001c\u0001d\u0001d\u0001"+
		"d\u0001d\u0001d\u0001d\u0001d\u0001e\u0001e\u0001e\u0001e\u0001e\u0001"+
		"e\u0001f\u0001f\u0001f\u0001f\u0001f\u0001f\u0001f\u0001f\u0001g\u0001"+
		"g\u0001g\u0001g\u0001g\u0001h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001"+
		"h\u0001h\u0001h\u0001h\u0001h\u0001h\u0001i\u0001i\u0001i\u0001i\u0001"+
		"i\u0001i\u0001i\u0001i\u0001i\u0001i\u0001i\u0001i\u0001i\u0001j\u0001"+
		"j\u0001j\u0001j\u0001j\u0001j\u0001k\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0001l\u0001l\u0001l\u0001l\u0001l\u0001l\u0001"+
		"l\u0001l\u0001l\u0001l\u0001l\u0001l\u0001l\u0001m\u0001m\u0001m\u0001"+
		"m\u0001m\u0001m\u0001m\u0001m\u0001m\u0001n\u0001n\u0001n\u0001n\u0001"+
		"n\u0001o\u0001o\u0001o\u0001o\u0001o\u0001o\u0001o\u0001o\u0001o\u0001"+
		"o\u0001o\u0001o\u0001o\u0001o\u0001o\u0001o\u0001o\u0001o\u0001p\u0001"+
		"p\u0001p\u0001p\u0001p\u0001p\u0001p\u0001p\u0001q\u0001q\u0001q\u0001"+
		"r\u0001r\u0001r\u0001r\u0001r\u0001r\u0001r\u0001r\u0001r\u0001r\u0001"+
		"r\u0001r\u0001r\u0001s\u0001s\u0001s\u0001s\u0001s\u0001s\u0001s\u0001"+
		"s\u0001s\u0001s\u0001s\u0001s\u0001s\u0001t\u0001t\u0001t\u0001t\u0001"+
		"u\u0001u\u0001u\u0001u\u0001u\u0001u\u0001u\u0001v\u0001v\u0001v\u0001"+
		"v\u0001w\u0001w\u0001w\u0001w\u0001w\u0001x\u0001x\u0001x\u0001x\u0001"+
		"x\u0001x\u0001x\u0001x\u0001x\u0001y\u0001y\u0001y\u0001y\u0001y\u0001"+
		"z\u0001z\u0001z\u0001z\u0001z\u0001z\u0001z\u0001z\u0001z\u0001z\u0001"+
		"z\u0001z\u0001{\u0001{\u0001{\u0001{\u0001{\u0001|\u0001|\u0001|\u0001"+
		"|\u0001|\u0001|\u0001|\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001"+
		"}\u0001}\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001"+
		"~\u0001~\u0001~\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u0080\u0001"+
		"\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0001"+
		"\u0080\u0001\u0080\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001"+
		"\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0082\u0001\u0082\u0001"+
		"\u0082\u0001\u0082\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0001"+
		"\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0001"+
		"\u0083\u0001\u0083\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001"+
		"\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0085\u0001\u0085\u0001"+
		"\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0001"+
		"\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0001"+
		"\u0086\u0001\u0086\u0001\u0087\u0001\u0087\u0001\u0087\u0001\u0087\u0001"+
		"\u0087\u0001\u0087\u0001\u0087\u0001\u0088\u0001\u0088\u0001\u0088\u0001"+
		"\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0001"+
		"\u008a\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008b\u0001"+
		"\u008b\u0001\u008b\u0001\u008b\u0001\u008b\u0001\u008c\u0001\u008c\u0001"+
		"\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008d\u0001"+
		"\u008d\u0001\u008d\u0001\u008d\u0001\u008d\u0001\u008e\u0001\u008e\u0001"+
		"\u008e\u0001\u008e\u0001\u008e\u0001\u008e\u0001\u008e\u0001\u008e\u0001"+
		"\u008e\u0001\u008e\u0001\u008e\u0001\u008e\u0001\u008e\u0001\u008e\u0001"+
		"\u008e\u0001\u008f\u0001\u008f\u0001\u008f\u0001\u008f\u0001\u008f\u0001"+
		"\u008f\u0001\u008f\u0001\u0090\u0001\u0090\u0001\u0090\u0001\u0090\u0001"+
		"\u0090\u0001\u0091\u0001\u0091\u0001\u0091\u0001\u0091\u0001\u0091\u0001"+
		"\u0091\u0001\u0091\u0001\u0091\u0001\u0091\u0001\u0091\u0001\u0092\u0001"+
		"\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0001"+
		"\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0093\u0001\u0093\u0001"+
		"\u0093\u0001\u0093\u0001\u0093\u0001\u0093\u0001\u0093\u0001\u0093\u0001"+
		"\u0093\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001"+
		"\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001"+
		"\u0095\u0001\u0095\u0001\u0095\u0001\u0095\u0001\u0096\u0001\u0096\u0001"+
		"\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0001"+
		"\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0097\u0001\u0097\u0001"+
		"\u0097\u0001\u0097\u0001\u0097\u0001\u0097\u0001\u0097\u0001\u0097\u0001"+
		"\u0098\u0001\u0098\u0001\u0098\u0001\u0098\u0001\u0098\u0001\u0099\u0001"+
		"\u0099\u0001\u0099\u0001\u0099\u0001\u0099\u0001\u0099\u0001\u0099\u0001"+
		"\u009a\u0001\u009a\u0001\u009a\u0001\u009a\u0001\u009a\u0001\u009a\u0001"+
		"\u009a\u0001\u009b\u0001\u009b\u0001\u009b\u0001\u009b\u0001\u009b\u0001"+
		"\u009b\u0001\u009b\u0001\u009c\u0001\u009c\u0001\u009c\u0001\u009c\u0001"+
		"\u009c\u0001\u009d\u0001\u009d\u0001\u009d\u0001\u009e\u0001\u009e\u0001"+
		"\u009e\u0001\u009e\u0001\u009e\u0001\u009e\u0001\u009e\u0001\u009e\u0001"+
		"\u009f\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u00a0\u0001"+
		"\u00a0\u0001\u00a0\u0001\u00a0\u0001\u00a0\u0001\u00a0\u0001\u00a1\u0001"+
		"\u00a1\u0001\u00a1\u0001\u00a1\u0001\u00a1\u0001\u00a2\u0001\u00a2\u0001"+
		"\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a3\u0001\u00a3\u0001\u00a3\u0001"+
		"\u00a3\u0001\u00a3\u0001\u00a3\u0001\u00a4\u0001\u00a4\u0001\u00a4\u0001"+
		"\u00a4\u0001\u00a4\u0001\u00a4\u0001\u00a4\u0001\u00a4\u0001\u00a5\u0001"+
		"\u00a5\u0001\u00a5\u0001\u00a5\u0001\u00a6\u0001\u00a6\u0001\u00a6\u0001"+
		"\u00a6\u0001\u00a6\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001"+
		"\u00a7\u0001\u00a8\u0001\u00a8\u0001\u00a8\u0001\u00a8\u0001\u00a8\u0001"+
		"\u00a8\u0001\u00a8\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001"+
		"\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00aa\u0001\u00aa\u0001"+
		"\u00aa\u0001\u00aa\u0001\u00aa\u0001\u00aa\u0001\u00ab\u0001\u00ab\u0001"+
		"\u00ab\u0001\u00ab\u0001\u00ab\u0001\u00ab\u0001\u00ab\u0001\u00ac\u0001"+
		"\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ad\u0001"+
		"\u00ad\u0001\u00ad\u0001\u00ad\u0001\u00ad\u0001\u00ad\u0001\u00ae\u0001"+
		"\u00ae\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0001"+
		"\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00b0\u0001"+
		"\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b1\u0001\u00b1\u0001"+
		"\u00b1\u0001\u00b1\u0001\u00b1\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001"+
		"\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001"+
		"\u00b2\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001"+
		"\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b4\u0001"+
		"\u00b4\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0001"+
		"\u00b4\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001"+
		"\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001"+
		"\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b7\u0001"+
		"\u00b7\u0001\u00b7\u0001\u00b7\u0001\u00b7\u0001\u00b7\u0001\u00b7\u0001"+
		"\u00b7\u0001\u00b7\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001"+
		"\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b9\u0001\u00b9\u0001"+
		"\u00b9\u0001\u00b9\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0001"+
		"\u00bb\u0001\u00bb\u0001\u00bb\u0001\u00bb\u0001\u00bb\u0001\u00bb\u0001"+
		"\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001"+
		"\u00bc\u0001\u00bd\u0004\u00bd\u075a\b\u00bd\u000b\u00bd\f\u00bd\u075b"+
		"\u0001\u00be\u0004\u00be\u075f\b\u00be\u000b\u00be\f\u00be\u0760\u0001"+
		"\u00be\u0001\u00be\u0004\u00be\u0765\b\u00be\u000b\u00be\f\u00be\u0766"+
		"\u0001\u00bf\u0001\u00bf\u0004\u00bf\u076b\b\u00bf\u000b\u00bf\f\u00bf"+
		"\u076c\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0004\u00c0\u0773"+
		"\b\u00c0\u000b\u00c0\f\u00c0\u0774\u0001\u00c1\u0001\u00c1\u0001\u00c1"+
		"\u0001\u00c1\u0001\u00c1\u0001\u00c2\u0001\u00c2\u0001\u00c2\u0001\u00c2"+
		"\u0001\u00c2\u0001\u00c2\u0001\u00c3\u0003\u00c3\u0783\b\u00c3\u0001\u00c3"+
		"\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3"+
		"\u0001\u00c3\u0005\u00c3\u078d\b\u00c3\n\u00c3\f\u00c3\u0790\t\u00c3\u0001"+
		"\u00c3\u0003\u00c3\u0793\b\u00c3\u0001\u00c3\u0001\u00c3\u0005\u00c3\u0797"+
		"\b\u00c3\n\u00c3\f\u00c3\u079a\t\u00c3\u0005\u00c3\u079c\b\u00c3\n\u00c3"+
		"\f\u00c3\u079f\t\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c4"+
		"\u0001\u00c4\u0005\u00c4\u07a6\b\u00c4\n\u00c4\f\u00c4\u07a9\t\u00c4\u0001"+
		"\u00c4\u0001\u00c4\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0005\u00c5\u07b0"+
		"\b\u00c5\n\u00c5\f\u00c5\u07b3\t\u00c5\u0001\u00c6\u0001\u00c6\u0001\u00c6"+
		"\u0001\u00c7\u0001\u00c7\u0001\u00c8\u0001\u00c8\u0001\u00c8\u0001\u00c8"+
		"\u0003\u00c8\u07be\b\u00c8\u0001\u00c9\u0001\u00c9\u0001\u00ca\u0001\u00ca"+
		"\u0001\u00cb\u0001\u00cb\u0001\u00cb\u0001\u00cc\u0001\u00cc\u0001\u00cc"+
		"\u0001\u00cd\u0001\u00cd\u0001\u00ce\u0001\u00ce\u0001\u00cf\u0001\u00cf"+
		"\u0001\u00d0\u0001\u00d0\u0001\u00d1\u0001\u00d1\u0001\u00d1\u0001\u00d2"+
		"\u0001\u00d2\u0001\u00d3\u0001\u00d3\u0001\u00d4\u0001\u00d4\u0001\u00d5"+
		"\u0001\u00d5\u0001\u00d6\u0001\u00d6\u0001\u00d7\u0001\u00d7\u0001\u00d8"+
		"\u0001\u00d8\u0001\u00d9\u0001\u00d9\u0001\u00d9\u0001\u00d9\u0005\u00d9"+
		"\u07e7\b\u00d9\n\u00d9\f\u00d9\u07ea\t\u00d9\u0001\u00d9\u0001\u00d9\u0001"+
		"\u00da\u0001\u00da\u0001\u00da\u0001\u00da\u0001\u00da\u0005\u00da\u07f3"+
		"\b\u00da\n\u00da\f\u00da\u07f6\t\u00da\u0001\u00da\u0001\u00da\u0001\u00da"+
		"\u0001\u00da\u0001\u00da\u0001\u00db\u0004\u00db\u07fe\b\u00db\u000b\u00db"+
		"\f\u00db\u07ff\u0001\u00db\u0001\u00db\u0001\u07f4\u0000\u00dc\u0001\u0000"+
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
		"\u01b3\u00d7\u01b5\u00d8\u01b7\u00d9\u0001\u0000#\u0001\u000009\u0003"+
		"\u0000AZ__az\u0003\u000009AFaf\u0002\u0000AAaa\u0002\u0000DDdd\u0002\u0000"+
		"EEee\u0002\u0000XXxx\u0002\u0000TTtt\u0002\u0000RRrr\u0002\u0000NNnn\u0002"+
		"\u0000LLll\u0002\u0000PPpp\u0002\u0000OOoo\u0002\u0000CCcc\u0002\u0000"+
		"UUuu\u0002\u0000FFff\u0002\u0000HHhh\u0002\u0000BBbb\u0002\u0000IIii\u0002"+
		"\u0000SSss\u0002\u0000YYyy\u0002\u0000GGgg\u0002\u0000ZZzz\u0002\u0000"+
		"KKkk\u0002\u0000MMmm\u0002\u0000WWww\u0002\u0000VVvv\u0002\u0000JJjj\u0002"+
		"\u0000QQqq\u0001\u000001\u0002\u0000\'\'\\\\\u0002\u0000\t\t  \u0003\u0000"+
		"\n\n\r\r]]\u0002\u0000\n\n\r\r\u0003\u0000\t\n\r\r  \u0814\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u0000"+
		"7\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001"+
		"\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000"+
		"\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000"+
		"E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001"+
		"\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000"+
		"\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000"+
		"S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001"+
		"\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000"+
		"\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0000"+
		"a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000e\u0001"+
		"\u0000\u0000\u0000\u0000g\u0001\u0000\u0000\u0000\u0000i\u0001\u0000\u0000"+
		"\u0000\u0000k\u0001\u0000\u0000\u0000\u0000m\u0001\u0000\u0000\u0000\u0000"+
		"o\u0001\u0000\u0000\u0000\u0000q\u0001\u0000\u0000\u0000\u0000s\u0001"+
		"\u0000\u0000\u0000\u0000u\u0001\u0000\u0000\u0000\u0000w\u0001\u0000\u0000"+
		"\u0000\u0000y\u0001\u0000\u0000\u0000\u0000{\u0001\u0000\u0000\u0000\u0000"+
		"}\u0001\u0000\u0000\u0000\u0000\u007f\u0001\u0000\u0000\u0000\u0000\u0081"+
		"\u0001\u0000\u0000\u0000\u0000\u0083\u0001\u0000\u0000\u0000\u0000\u0085"+
		"\u0001\u0000\u0000\u0000\u0000\u0087\u0001\u0000\u0000\u0000\u0000\u0089"+
		"\u0001\u0000\u0000\u0000\u0000\u008b\u0001\u0000\u0000\u0000\u0000\u008d"+
		"\u0001\u0000\u0000\u0000\u0000\u008f\u0001\u0000\u0000\u0000\u0000\u0091"+
		"\u0001\u0000\u0000\u0000\u0000\u0093\u0001\u0000\u0000\u0000\u0000\u0095"+
		"\u0001\u0000\u0000\u0000\u0000\u0097\u0001\u0000\u0000\u0000\u0000\u0099"+
		"\u0001\u0000\u0000\u0000\u0000\u009b\u0001\u0000\u0000\u0000\u0000\u009d"+
		"\u0001\u0000\u0000\u0000\u0000\u009f\u0001\u0000\u0000\u0000\u0000\u00a1"+
		"\u0001\u0000\u0000\u0000\u0000\u00a3\u0001\u0000\u0000\u0000\u0000\u00a5"+
		"\u0001\u0000\u0000\u0000\u0000\u00a7\u0001\u0000\u0000\u0000\u0000\u00a9"+
		"\u0001\u0000\u0000\u0000\u0000\u00ab\u0001\u0000\u0000\u0000\u0000\u00ad"+
		"\u0001\u0000\u0000\u0000\u0000\u00af\u0001\u0000\u0000\u0000\u0000\u00b1"+
		"\u0001\u0000\u0000\u0000\u0000\u00b3\u0001\u0000\u0000\u0000\u0000\u00b5"+
		"\u0001\u0000\u0000\u0000\u0000\u00b7\u0001\u0000\u0000\u0000\u0000\u00b9"+
		"\u0001\u0000\u0000\u0000\u0000\u00bb\u0001\u0000\u0000\u0000\u0000\u00bd"+
		"\u0001\u0000\u0000\u0000\u0000\u00bf\u0001\u0000\u0000\u0000\u0000\u00c1"+
		"\u0001\u0000\u0000\u0000\u0000\u00c3\u0001\u0000\u0000\u0000\u0000\u00c5"+
		"\u0001\u0000\u0000\u0000\u0000\u00c7\u0001\u0000\u0000\u0000\u0000\u00c9"+
		"\u0001\u0000\u0000\u0000\u0000\u00cb\u0001\u0000\u0000\u0000\u0000\u00cd"+
		"\u0001\u0000\u0000\u0000\u0000\u00cf\u0001\u0000\u0000\u0000\u0000\u00d1"+
		"\u0001\u0000\u0000\u0000\u0000\u00d3\u0001\u0000\u0000\u0000\u0000\u00d5"+
		"\u0001\u0000\u0000\u0000\u0000\u00d7\u0001\u0000\u0000\u0000\u0000\u00d9"+
		"\u0001\u0000\u0000\u0000\u0000\u00db\u0001\u0000\u0000\u0000\u0000\u00dd"+
		"\u0001\u0000\u0000\u0000\u0000\u00df\u0001\u0000\u0000\u0000\u0000\u00e1"+
		"\u0001\u0000\u0000\u0000\u0000\u00e3\u0001\u0000\u0000\u0000\u0000\u00e5"+
		"\u0001\u0000\u0000\u0000\u0000\u00e7\u0001\u0000\u0000\u0000\u0000\u00e9"+
		"\u0001\u0000\u0000\u0000\u0000\u00eb\u0001\u0000\u0000\u0000\u0000\u00ed"+
		"\u0001\u0000\u0000\u0000\u0000\u00ef\u0001\u0000\u0000\u0000\u0000\u00f1"+
		"\u0001\u0000\u0000\u0000\u0000\u00f3\u0001\u0000\u0000\u0000\u0000\u00f5"+
		"\u0001\u0000\u0000\u0000\u0000\u00f7\u0001\u0000\u0000\u0000\u0000\u00f9"+
		"\u0001\u0000\u0000\u0000\u0000\u00fb\u0001\u0000\u0000\u0000\u0000\u00fd"+
		"\u0001\u0000\u0000\u0000\u0000\u00ff\u0001\u0000\u0000\u0000\u0000\u0101"+
		"\u0001\u0000\u0000\u0000\u0000\u0103\u0001\u0000\u0000\u0000\u0000\u0105"+
		"\u0001\u0000\u0000\u0000\u0000\u0107\u0001\u0000\u0000\u0000\u0000\u0109"+
		"\u0001\u0000\u0000\u0000\u0000\u010b\u0001\u0000\u0000\u0000\u0000\u010d"+
		"\u0001\u0000\u0000\u0000\u0000\u010f\u0001\u0000\u0000\u0000\u0000\u0111"+
		"\u0001\u0000\u0000\u0000\u0000\u0113\u0001\u0000\u0000\u0000\u0000\u0115"+
		"\u0001\u0000\u0000\u0000\u0000\u0117\u0001\u0000\u0000\u0000\u0000\u0119"+
		"\u0001\u0000\u0000\u0000\u0000\u011b\u0001\u0000\u0000\u0000\u0000\u011d"+
		"\u0001\u0000\u0000\u0000\u0000\u011f\u0001\u0000\u0000\u0000\u0000\u0121"+
		"\u0001\u0000\u0000\u0000\u0000\u0123\u0001\u0000\u0000\u0000\u0000\u0125"+
		"\u0001\u0000\u0000\u0000\u0000\u0127\u0001\u0000\u0000\u0000\u0000\u0129"+
		"\u0001\u0000\u0000\u0000\u0000\u012b\u0001\u0000\u0000\u0000\u0000\u012d"+
		"\u0001\u0000\u0000\u0000\u0000\u012f\u0001\u0000\u0000\u0000\u0000\u0131"+
		"\u0001\u0000\u0000\u0000\u0000\u0133\u0001\u0000\u0000\u0000\u0000\u0135"+
		"\u0001\u0000\u0000\u0000\u0000\u0137\u0001\u0000\u0000\u0000\u0000\u0139"+
		"\u0001\u0000\u0000\u0000\u0000\u013b\u0001\u0000\u0000\u0000\u0000\u013d"+
		"\u0001\u0000\u0000\u0000\u0000\u013f\u0001\u0000\u0000\u0000\u0000\u0141"+
		"\u0001\u0000\u0000\u0000\u0000\u0143\u0001\u0000\u0000\u0000\u0000\u0145"+
		"\u0001\u0000\u0000\u0000\u0000\u0147\u0001\u0000\u0000\u0000\u0000\u0149"+
		"\u0001\u0000\u0000\u0000\u0000\u014b\u0001\u0000\u0000\u0000\u0000\u014d"+
		"\u0001\u0000\u0000\u0000\u0000\u014f\u0001\u0000\u0000\u0000\u0000\u0151"+
		"\u0001\u0000\u0000\u0000\u0000\u0153\u0001\u0000\u0000\u0000\u0000\u0155"+
		"\u0001\u0000\u0000\u0000\u0000\u0157\u0001\u0000\u0000\u0000\u0000\u0159"+
		"\u0001\u0000\u0000\u0000\u0000\u015b\u0001\u0000\u0000\u0000\u0000\u015d"+
		"\u0001\u0000\u0000\u0000\u0000\u015f\u0001\u0000\u0000\u0000\u0000\u0161"+
		"\u0001\u0000\u0000\u0000\u0000\u0163\u0001\u0000\u0000\u0000\u0000\u0165"+
		"\u0001\u0000\u0000\u0000\u0000\u0167\u0001\u0000\u0000\u0000\u0000\u0169"+
		"\u0001\u0000\u0000\u0000\u0000\u016b\u0001\u0000\u0000\u0000\u0000\u016d"+
		"\u0001\u0000\u0000\u0000\u0000\u016f\u0001\u0000\u0000\u0000\u0000\u0171"+
		"\u0001\u0000\u0000\u0000\u0000\u0173\u0001\u0000\u0000\u0000\u0000\u0175"+
		"\u0001\u0000\u0000\u0000\u0000\u0177\u0001\u0000\u0000\u0000\u0000\u0179"+
		"\u0001\u0000\u0000\u0000\u0000\u017b\u0001\u0000\u0000\u0000\u0000\u017d"+
		"\u0001\u0000\u0000\u0000\u0000\u017f\u0001\u0000\u0000\u0000\u0000\u0181"+
		"\u0001\u0000\u0000\u0000\u0000\u0183\u0001\u0000\u0000\u0000\u0000\u0185"+
		"\u0001\u0000\u0000\u0000\u0000\u0187\u0001\u0000\u0000\u0000\u0000\u0189"+
		"\u0001\u0000\u0000\u0000\u0000\u018b\u0001\u0000\u0000\u0000\u0000\u018d"+
		"\u0001\u0000\u0000\u0000\u0000\u018f\u0001\u0000\u0000\u0000\u0000\u0191"+
		"\u0001\u0000\u0000\u0000\u0000\u0193\u0001\u0000\u0000\u0000\u0000\u0195"+
		"\u0001\u0000\u0000\u0000\u0000\u0197\u0001\u0000\u0000\u0000\u0000\u0199"+
		"\u0001\u0000\u0000\u0000\u0000\u019b\u0001\u0000\u0000\u0000\u0000\u019d"+
		"\u0001\u0000\u0000\u0000\u0000\u019f\u0001\u0000\u0000\u0000\u0000\u01a1"+
		"\u0001\u0000\u0000\u0000\u0000\u01a3\u0001\u0000\u0000\u0000\u0000\u01a5"+
		"\u0001\u0000\u0000\u0000\u0000\u01a7\u0001\u0000\u0000\u0000\u0000\u01a9"+
		"\u0001\u0000\u0000\u0000\u0000\u01ab\u0001\u0000\u0000\u0000\u0000\u01ad"+
		"\u0001\u0000\u0000\u0000\u0000\u01af\u0001\u0000\u0000\u0000\u0000\u01b1"+
		"\u0001\u0000\u0000\u0000\u0000\u01b3\u0001\u0000\u0000\u0000\u0000\u01b5"+
		"\u0001\u0000\u0000\u0000\u0000\u01b7\u0001\u0000\u0000\u0000\u0001\u01b9"+
		"\u0001\u0000\u0000\u0000\u0003\u01bb\u0001\u0000\u0000\u0000\u0005\u01bd"+
		"\u0001\u0000\u0000\u0000\u0007\u01bf\u0001\u0000\u0000\u0000\t\u01c3\u0001"+
		"\u0000\u0000\u0000\u000b\u01cc\u0001\u0000\u0000\u0000\r\u01d6\u0001\u0000"+
		"\u0000\u0000\u000f\u01da\u0001\u0000\u0000\u0000\u0011\u01e0\u0001\u0000"+
		"\u0000\u0000\u0013\u01e7\u0001\u0000\u0000\u0000\u0015\u01ed\u0001\u0000"+
		"\u0000\u0000\u0017\u01f2\u0001\u0000\u0000\u0000\u0019\u01fc\u0001\u0000"+
		"\u0000\u0000\u001b\u0200\u0001\u0000\u0000\u0000\u001d\u020b\u0001\u0000"+
		"\u0000\u0000\u001f\u0210\u0001\u0000\u0000\u0000!\u0214\u0001\u0000\u0000"+
		"\u0000#\u0218\u0001\u0000\u0000\u0000%\u0221\u0001\u0000\u0000\u0000\'"+
		"\u0224\u0001\u0000\u0000\u0000)\u022c\u0001\u0000\u0000\u0000+\u0238\u0001"+
		"\u0000\u0000\u0000-\u023c\u0001\u0000\u0000\u0000/\u0245\u0001\u0000\u0000"+
		"\u00001\u0250\u0001\u0000\u0000\u00003\u025e\u0001\u0000\u0000\u00005"+
		"\u026c\u0001\u0000\u0000\u00007\u0278\u0001\u0000\u0000\u00009\u027f\u0001"+
		"\u0000\u0000\u0000;\u0284\u0001\u0000\u0000\u0000=\u028c\u0001\u0000\u0000"+
		"\u0000?\u0292\u0001\u0000\u0000\u0000A\u0297\u0001\u0000\u0000\u0000C"+
		"\u02a0\u0001\u0000\u0000\u0000E\u02a8\u0001\u0000\u0000\u0000G\u02b1\u0001"+
		"\u0000\u0000\u0000I\u02b8\u0001\u0000\u0000\u0000K\u02be\u0001\u0000\u0000"+
		"\u0000M\u02c3\u0001\u0000\u0000\u0000O\u02ca\u0001\u0000\u0000\u0000Q"+
		"\u02d1\u0001\u0000\u0000\u0000S\u02d7\u0001\u0000\u0000\u0000U\u02de\u0001"+
		"\u0000\u0000\u0000W\u02e3\u0001\u0000\u0000\u0000Y\u02e9\u0001\u0000\u0000"+
		"\u0000[\u02ef\u0001\u0000\u0000\u0000]\u02f2\u0001\u0000\u0000\u0000_"+
		"\u02f9\u0001\u0000\u0000\u0000a\u0302\u0001\u0000\u0000\u0000c\u030a\u0001"+
		"\u0000\u0000\u0000e\u0313\u0001\u0000\u0000\u0000g\u031c\u0001\u0000\u0000"+
		"\u0000i\u0321\u0001\u0000\u0000\u0000k\u032a\u0001\u0000\u0000\u0000m"+
		"\u0335\u0001\u0000\u0000\u0000o\u033b\u0001\u0000\u0000\u0000q\u034b\u0001"+
		"\u0000\u0000\u0000s\u0350\u0001\u0000\u0000\u0000u\u035b\u0001\u0000\u0000"+
		"\u0000w\u0367\u0001\u0000\u0000\u0000y\u036c\u0001\u0000\u0000\u0000{"+
		"\u0372\u0001\u0000\u0000\u0000}\u0375\u0001\u0000\u0000\u0000\u007f\u037c"+
		"\u0001\u0000\u0000\u0000\u0081\u0386\u0001\u0000\u0000\u0000\u0083\u0389"+
		"\u0001\u0000\u0000\u0000\u0085\u0397\u0001\u0000\u0000\u0000\u0087\u03a0"+
		"\u0001\u0000\u0000\u0000\u0089\u03a6\u0001\u0000\u0000\u0000\u008b\u03ad"+
		"\u0001\u0000\u0000\u0000\u008d\u03b5\u0001\u0000\u0000\u0000\u008f\u03bb"+
		"\u0001\u0000\u0000\u0000\u0091\u03d2\u0001\u0000\u0000\u0000\u0093\u03d9"+
		"\u0001\u0000\u0000\u0000\u0095\u03e0\u0001\u0000\u0000\u0000\u0097\u03ff"+
		"\u0001\u0000\u0000\u0000\u0099\u0406\u0001\u0000\u0000\u0000\u009b\u0410"+
		"\u0001\u0000\u0000\u0000\u009d\u0428\u0001\u0000\u0000\u0000\u009f\u0430"+
		"\u0001\u0000\u0000\u0000\u00a1\u0435\u0001\u0000\u0000\u0000\u00a3\u0442"+
		"\u0001\u0000\u0000\u0000\u00a5\u044d\u0001\u0000\u0000\u0000\u00a7\u0450"+
		"\u0001\u0000\u0000\u0000\u00a9\u0454\u0001\u0000\u0000\u0000\u00ab\u045d"+
		"\u0001\u0000\u0000\u0000\u00ad\u0462\u0001\u0000\u0000\u0000\u00af\u046a"+
		"\u0001\u0000\u0000\u0000\u00b1\u0478\u0001\u0000\u0000\u0000\u00b3\u047c"+
		"\u0001\u0000\u0000\u0000\u00b5\u0485\u0001\u0000\u0000\u0000\u00b7\u048e"+
		"\u0001\u0000\u0000\u0000\u00b9\u0493\u0001\u0000\u0000\u0000\u00bb\u0498"+
		"\u0001\u0000\u0000\u0000\u00bd\u04a0\u0001\u0000\u0000\u0000\u00bf\u04a5"+
		"\u0001\u0000\u0000\u0000\u00c1\u04b0\u0001\u0000\u0000\u0000\u00c3\u04b7"+
		"\u0001\u0000\u0000\u0000\u00c5\u04bc\u0001\u0000\u0000\u0000\u00c7\u04c8"+
		"\u0001\u0000\u0000\u0000\u00c9\u04ce\u0001\u0000\u0000\u0000\u00cb\u04d5"+
		"\u0001\u0000\u0000\u0000\u00cd\u04db\u0001\u0000\u0000\u0000\u00cf\u04e3"+
		"\u0001\u0000\u0000\u0000\u00d1\u04e8\u0001\u0000\u0000\u0000\u00d3\u04f4"+
		"\u0001\u0000\u0000\u0000\u00d5\u0501\u0001\u0000\u0000\u0000\u00d7\u0507"+
		"\u0001\u0000\u0000\u0000\u00d9\u0510\u0001\u0000\u0000\u0000\u00db\u051d"+
		"\u0001\u0000\u0000\u0000\u00dd\u0526\u0001\u0000\u0000\u0000\u00df\u052b"+
		"\u0001\u0000\u0000\u0000\u00e1\u053d\u0001\u0000\u0000\u0000\u00e3\u0545"+
		"\u0001\u0000\u0000\u0000\u00e5\u0548\u0001\u0000\u0000\u0000\u00e7\u0555"+
		"\u0001\u0000\u0000\u0000\u00e9\u0562\u0001\u0000\u0000\u0000\u00eb\u0566"+
		"\u0001\u0000\u0000\u0000\u00ed\u056d\u0001\u0000\u0000\u0000\u00ef\u0571"+
		"\u0001\u0000\u0000\u0000\u00f1\u0576\u0001\u0000\u0000\u0000\u00f3\u057f"+
		"\u0001\u0000\u0000\u0000\u00f5\u0584\u0001\u0000\u0000\u0000\u00f7\u0590"+
		"\u0001\u0000\u0000\u0000\u00f9\u0595\u0001\u0000\u0000\u0000\u00fb\u059c"+
		"\u0001\u0000\u0000\u0000\u00fd\u05a4\u0001\u0000\u0000\u0000\u00ff\u05af"+
		"\u0001\u0000\u0000\u0000\u0101\u05b2\u0001\u0000\u0000\u0000\u0103\u05bb"+
		"\u0001\u0000\u0000\u0000\u0105\u05c3\u0001\u0000\u0000\u0000\u0107\u05c7"+
		"\u0001\u0000\u0000\u0000\u0109\u05d3\u0001\u0000\u0000\u0000\u010b\u05db"+
		"\u0001\u0000\u0000\u0000\u010d\u05e3\u0001\u0000\u0000\u0000\u010f\u05eb"+
		"\u0001\u0000\u0000\u0000\u0111\u05f2\u0001\u0000\u0000\u0000\u0113\u05f5"+
		"\u0001\u0000\u0000\u0000\u0115\u05fb\u0001\u0000\u0000\u0000\u0117\u0600"+
		"\u0001\u0000\u0000\u0000\u0119\u0605\u0001\u0000\u0000\u0000\u011b\u060c"+
		"\u0001\u0000\u0000\u0000\u011d\u0611\u0001\u0000\u0000\u0000\u011f\u0620"+
		"\u0001\u0000\u0000\u0000\u0121\u0627\u0001\u0000\u0000\u0000\u0123\u062c"+
		"\u0001\u0000\u0000\u0000\u0125\u0636\u0001\u0000\u0000\u0000\u0127\u0641"+
		"\u0001\u0000\u0000\u0000\u0129\u064a\u0001\u0000\u0000\u0000\u012b\u0655"+
		"\u0001\u0000\u0000\u0000\u012d\u0659\u0001\u0000\u0000\u0000\u012f\u0665"+
		"\u0001\u0000\u0000\u0000\u0131\u066d\u0001\u0000\u0000\u0000\u0133\u0672"+
		"\u0001\u0000\u0000\u0000\u0135\u0679\u0001\u0000\u0000\u0000\u0137\u0680"+
		"\u0001\u0000\u0000\u0000\u0139\u0687\u0001\u0000\u0000\u0000\u013b\u068c"+
		"\u0001\u0000\u0000\u0000\u013d\u068f\u0001\u0000\u0000\u0000\u013f\u0697"+
		"\u0001\u0000\u0000\u0000\u0141\u069c\u0001\u0000\u0000\u0000\u0143\u06a2"+
		"\u0001\u0000\u0000\u0000\u0145\u06a7\u0001\u0000\u0000\u0000\u0147\u06ac"+
		"\u0001\u0000\u0000\u0000\u0149\u06b2\u0001\u0000\u0000\u0000\u014b\u06ba"+
		"\u0001\u0000\u0000\u0000\u014d\u06be\u0001\u0000\u0000\u0000\u014f\u06c3"+
		"\u0001\u0000\u0000\u0000\u0151\u06c8\u0001\u0000\u0000\u0000\u0153\u06cf"+
		"\u0001\u0000\u0000\u0000\u0155\u06d7\u0001\u0000\u0000\u0000\u0157\u06dd"+
		"\u0001\u0000\u0000\u0000\u0159\u06e4\u0001\u0000\u0000\u0000\u015b\u06ea"+
		"\u0001\u0000\u0000\u0000\u015d\u06f0\u0001\u0000\u0000\u0000\u015f\u06f7"+
		"\u0001\u0000\u0000\u0000\u0161\u06fc\u0001\u0000\u0000\u0000\u0163\u0701"+
		"\u0001\u0000\u0000\u0000\u0165\u0706\u0001\u0000\u0000\u0000\u0167\u0710"+
		"\u0001\u0000\u0000\u0000\u0169\u071a\u0001\u0000\u0000\u0000\u016b\u0722"+
		"\u0001\u0000\u0000\u0000\u016d\u072a\u0001\u0000\u0000\u0000\u016f\u0732"+
		"\u0001\u0000\u0000\u0000\u0171\u073b\u0001\u0000\u0000\u0000\u0173\u0743"+
		"\u0001\u0000\u0000\u0000\u0175\u0747\u0001\u0000\u0000\u0000\u0177\u074b"+
		"\u0001\u0000\u0000\u0000\u0179\u0751\u0001\u0000\u0000\u0000\u017b\u0759"+
		"\u0001\u0000\u0000\u0000\u017d\u075e\u0001\u0000\u0000\u0000\u017f\u076a"+
		"\u0001\u0000\u0000\u0000\u0181\u076e\u0001\u0000\u0000\u0000\u0183\u0776"+
		"\u0001\u0000\u0000\u0000\u0185\u077b\u0001\u0000\u0000\u0000\u0187\u0782"+
		"\u0001\u0000\u0000\u0000\u0189\u07a3\u0001\u0000\u0000\u0000\u018b\u07ac"+
		"\u0001\u0000\u0000\u0000\u018d\u07b4\u0001\u0000\u0000\u0000\u018f\u07b7"+
		"\u0001\u0000\u0000\u0000\u0191\u07bd\u0001\u0000\u0000\u0000\u0193\u07bf"+
		"\u0001\u0000\u0000\u0000\u0195\u07c1\u0001\u0000\u0000\u0000\u0197\u07c3"+
		"\u0001\u0000\u0000\u0000\u0199\u07c6\u0001\u0000\u0000\u0000\u019b\u07c9"+
		"\u0001\u0000\u0000\u0000\u019d\u07cb\u0001\u0000\u0000\u0000\u019f\u07cd"+
		"\u0001\u0000\u0000\u0000\u01a1\u07cf\u0001\u0000\u0000\u0000\u01a3\u07d1"+
		"\u0001\u0000\u0000\u0000\u01a5\u07d4\u0001\u0000\u0000\u0000\u01a7\u07d6"+
		"\u0001\u0000\u0000\u0000\u01a9\u07d8\u0001\u0000\u0000\u0000\u01ab\u07da"+
		"\u0001\u0000\u0000\u0000\u01ad\u07dc\u0001\u0000\u0000\u0000\u01af\u07de"+
		"\u0001\u0000\u0000\u0000\u01b1\u07e0\u0001\u0000\u0000\u0000\u01b3\u07e2"+
		"\u0001\u0000\u0000\u0000\u01b5\u07ed\u0001\u0000\u0000\u0000\u01b7\u07fd"+
		"\u0001\u0000\u0000\u0000\u01b9\u01ba\u0007\u0000\u0000\u0000\u01ba\u0002"+
		"\u0001\u0000\u0000\u0000\u01bb\u01bc\u0007\u0001\u0000\u0000\u01bc\u0004"+
		"\u0001\u0000\u0000\u0000\u01bd\u01be\u0007\u0002\u0000\u0000\u01be\u0006"+
		"\u0001\u0000\u0000\u0000\u01bf\u01c0\u0007\u0003\u0000\u0000\u01c0\u01c1"+
		"\u0007\u0004\u0000\u0000\u01c1\u01c2\u0007\u0004\u0000\u0000\u01c2\b\u0001"+
		"\u0000\u0000\u0000\u01c3\u01c4\u0007\u0005\u0000\u0000\u01c4\u01c5\u0007"+
		"\u0006\u0000\u0000\u01c5\u01c6\u0007\u0007\u0000\u0000\u01c6\u01c7\u0007"+
		"\u0005\u0000\u0000\u01c7\u01c8\u0007\b\u0000\u0000\u01c8\u01c9\u0007\t"+
		"\u0000\u0000\u01c9\u01ca\u0007\u0003\u0000\u0000\u01ca\u01cb\u0007\n\u0000"+
		"\u0000\u01cb\n\u0001\u0000\u0000\u0000\u01cc\u01cd\u0007\u000b\u0000\u0000"+
		"\u01cd\u01ce\u0007\b\u0000\u0000\u01ce\u01cf\u0007\f\u0000\u0000\u01cf"+
		"\u01d0\u0007\r\u0000\u0000\u01d0\u01d1\u0007\u0005\u0000\u0000\u01d1\u01d2"+
		"\u0007\u0004\u0000\u0000\u01d2\u01d3\u0007\u000e\u0000\u0000\u01d3\u01d4"+
		"\u0007\b\u0000\u0000\u01d4\u01d5\u0007\u0005\u0000\u0000\u01d5\f\u0001"+
		"\u0000\u0000\u0000\u01d6\u01d7\u0007\u0003\u0000\u0000\u01d7\u01d8\u0007"+
		"\n\u0000\u0000\u01d8\u01d9\u0007\n\u0000\u0000\u01d9\u000e\u0001\u0000"+
		"\u0000\u0000\u01da\u01db\u0007\u000f\u0000\u0000\u01db\u01dc\u0007\u0005"+
		"\u0000\u0000\u01dc\u01dd\u0007\u0007\u0000\u0000\u01dd\u01de\u0007\r\u0000"+
		"\u0000\u01de\u01df\u0007\u0010\u0000\u0000\u01df\u0010\u0001\u0000\u0000"+
		"\u0000\u01e0\u01e1\u0007\u000b\u0000\u0000\u01e1\u01e2\u0007\u000e\u0000"+
		"\u0000\u01e2\u01e3\u0007\u0011\u0000\u0000\u01e3\u01e4\u0007\n\u0000\u0000"+
		"\u01e4\u01e5\u0007\u0012\u0000\u0000\u01e5\u01e6\u0007\r\u0000\u0000\u01e6"+
		"\u0012\u0001\u0000\u0000\u0000\u01e7\u01e8\u0007\u0003\u0000\u0000\u01e8"+
		"\u01e9\u0007\n\u0000\u0000\u01e9\u01ea\u0007\u0007\u0000\u0000\u01ea\u01eb"+
		"\u0007\u0005\u0000\u0000\u01eb\u01ec\u0007\b\u0000\u0000\u01ec\u0014\u0001"+
		"\u0000\u0000\u0000\u01ed\u01ee\u0007\u000f\u0000\u0000\u01ee\u01ef\u0007"+
		"\u0012\u0000\u0000\u01ef\u01f0\u0007\n\u0000\u0000\u01f0\u01f1\u0007\u0005"+
		"\u0000\u0000\u01f1\u0016\u0001\u0000\u0000\u0000\u01f2\u01f3\u0007\b\u0000"+
		"\u0000\u01f3\u01f4\u0007\u0003\u0000\u0000\u01f4\u01f5\u0007\u0012\u0000"+
		"\u0000\u01f5\u01f6\u0007\u0013\u0000\u0000\u01f6\u01f7\u0007\u0005\u0000"+
		"\u0000\u01f7\u01f8\u0007\b\u0000\u0000\u01f8\u01f9\u0007\b\u0000\u0000"+
		"\u01f9\u01fa\u0007\f\u0000\u0000\u01fa\u01fb\u0007\b\u0000\u0000\u01fb"+
		"\u0018\u0001\u0000\u0000\u0000\u01fc\u01fd\u0007\u0003\u0000\u0000\u01fd"+
		"\u01fe\u0007\t\u0000\u0000\u01fe\u01ff\u0007\u0004\u0000\u0000\u01ff\u001a"+
		"\u0001\u0000\u0000\u0000\u0200\u0201\u0007\u000f\u0000\u0000\u0201\u0202"+
		"\u0007\u0012\u0000\u0000\u0202\u0203\u0007\n\u0000\u0000\u0203\u0204\u0007"+
		"\n\u0000\u0000\u0204\u0205\u0007\u000f\u0000\u0000\u0205\u0206\u0007\u0003"+
		"\u0000\u0000\u0206\u0207\u0007\r\u0000\u0000\u0207\u0208\u0007\u0007\u0000"+
		"\u0000\u0208\u0209\u0007\f\u0000\u0000\u0209\u020a\u0007\b\u0000\u0000"+
		"\u020a\u001c\u0001\u0000\u0000\u0000\u020b\u020c\u0007\b\u0000\u0000\u020c"+
		"\u020d\u0007\u0005\u0000\u0000\u020d\u020e\u0007\u0003\u0000\u0000\u020e"+
		"\u020f\u0007\u0004\u0000\u0000\u020f\u001e\u0001\u0000\u0000\u0000\u0210"+
		"\u0211\u0007\u0003\u0000\u0000\u0211\u0212\u0007\t\u0000\u0000\u0212\u0213"+
		"\u0007\u0014\u0000\u0000\u0213 \u0001\u0000\u0000\u0000\u0214\u0215\u0007"+
		"\u000f\u0000\u0000\u0215\u0216\u0007\f\u0000\u0000\u0216\u0217\u0007\b"+
		"\u0000\u0000\u0217\"\u0001\u0000\u0000\u0000\u0218\u0219\u0007\b\u0000"+
		"\u0000\u0219\u021a\u0007\u0005\u0000\u0000\u021a\u021b\u0007\u0003\u0000"+
		"\u0000\u021b\u021c\u0007\u0004\u0000\u0000\u021c\u021d\u0007\u0007\u0000"+
		"\u0000\u021d\u021e\u0007\u0005\u0000\u0000\u021e\u021f\u0007\u0006\u0000"+
		"\u0000\u021f\u0220\u0007\u0007\u0000\u0000\u0220$\u0001\u0000\u0000\u0000"+
		"\u0221\u0222\u0007\u0003\u0000\u0000\u0222\u0223\u0007\u0013\u0000\u0000"+
		"\u0223&\u0001\u0000\u0000\u0000\u0224\u0225\u0007\u000f\u0000\u0000\u0225"+
		"\u0226\u0007\f\u0000\u0000\u0226\u0227\u0007\b\u0000\u0000\u0227\u0228"+
		"\u0007\u0005\u0000\u0000\u0228\u0229\u0007\u0012\u0000\u0000\u0229\u022a"+
		"\u0007\u0015\u0000\u0000\u022a\u022b\u0007\t\u0000\u0000\u022b(\u0001"+
		"\u0000\u0000\u0000\u022c\u022d\u0007\b\u0000\u0000\u022d\u022e\u0007\u0005"+
		"\u0000\u0000\u022e\u022f\u0007\r\u0000\u0000\u022f\u0230\u0007\f\u0000"+
		"\u0000\u0230\u0231\u0007\t\u0000\u0000\u0231\u0232\u0007\u000f\u0000\u0000"+
		"\u0232\u0233\u0007\u0012\u0000\u0000\u0233\u0234\u0007\u0015\u0000\u0000"+
		"\u0234\u0235\u0007\u000e\u0000\u0000\u0235\u0236\u0007\b\u0000\u0000\u0236"+
		"\u0237\u0007\u0005\u0000\u0000\u0237*\u0001\u0000\u0000\u0000\u0238\u0239"+
		"\u0007\u0003\u0000\u0000\u0239\u023a\u0007\u0013\u0000\u0000\u023a\u023b"+
		"\u0007\r\u0000\u0000\u023b,\u0001\u0000\u0000\u0000\u023c\u023d\u0007"+
		"\u000f\u0000\u0000\u023d\u023e\u0007\b\u0000\u0000\u023e\u023f\u0007\u0005"+
		"\u0000\u0000\u023f\u0240\u0007\u0005\u0000\u0000\u0240\u0241\u0007\u0007"+
		"\u0000\u0000\u0241\u0242\u0007\u0005\u0000\u0000\u0242\u0243\u0007\u0006"+
		"\u0000\u0000\u0243\u0244\u0007\u0007\u0000\u0000\u0244.\u0001\u0000\u0000"+
		"\u0000\u0245\u0246\u0007\b\u0000\u0000\u0246\u0247\u0007\u0005\u0000\u0000"+
		"\u0247\u0248\u0007\u000f\u0000\u0000\u0248\u0249\u0007\u0005\u0000\u0000"+
		"\u0249\u024a\u0007\b\u0000\u0000\u024a\u024b\u0007\u0005\u0000\u0000\u024b"+
		"\u024c\u0007\t\u0000\u0000\u024c\u024d\u0007\r\u0000\u0000\u024d\u024e"+
		"\u0007\u0005\u0000\u0000\u024e\u024f\u0007\u0013\u0000\u0000\u024f0\u0001"+
		"\u0000\u0000\u0000\u0250\u0251\u0007\u0003\u0000\u0000\u0251\u0252\u0007"+
		"\u000e\u0000\u0000\u0252\u0253\u0007\u0007\u0000\u0000\u0253\u0254\u0007"+
		"\u0010\u0000\u0000\u0254\u0255\u0007\f\u0000\u0000\u0255\u0256\u0007\b"+
		"\u0000\u0000\u0256\u0257\u0007\u0012\u0000\u0000\u0257\u0258\u0007\u0016"+
		"\u0000\u0000\u0258\u0259\u0007\u0003\u0000\u0000\u0259\u025a\u0007\u0007"+
		"\u0000\u0000\u025a\u025b\u0007\u0012\u0000\u0000\u025b\u025c\u0007\f\u0000"+
		"\u0000\u025c\u025d\u0007\t\u0000\u0000\u025d2\u0001\u0000\u0000\u0000"+
		"\u025e\u025f\u0007\u000f\u0000\u0000\u025f\u0260\u0007\b\u0000\u0000\u0260"+
		"\u0261\u0007\u0005\u0000\u0000\u0261\u0262\u0007\u0005\u0000\u0000\u0262"+
		"\u0263\u0007\u0007\u0000\u0000\u0263\u0264\u0007\u0005\u0000\u0000\u0264"+
		"\u0265\u0007\u0006\u0000\u0000\u0265\u0266\u0007\u0007\u0000\u0000\u0266"+
		"\u0267\u0007\u0007\u0000\u0000\u0267\u0268\u0007\u0003\u0000\u0000\u0268"+
		"\u0269\u0007\u0011\u0000\u0000\u0269\u026a\u0007\n\u0000\u0000\u026a\u026b"+
		"\u0007\u0005\u0000\u0000\u026b4\u0001\u0000\u0000\u0000\u026c\u026d\u0007"+
		"\b\u0000\u0000\u026d\u026e\u0007\u0005\u0000\u0000\u026e\u026f\u0007\u000b"+
		"\u0000\u0000\u026f\u0270\u0007\n\u0000\u0000\u0270\u0271\u0007\u0012\u0000"+
		"\u0000\u0271\u0272\u0007\r\u0000\u0000\u0272\u0273\u0007\u0003\u0000\u0000"+
		"\u0273\u0274\u0007\u0007\u0000\u0000\u0274\u0275\u0007\u0012\u0000\u0000"+
		"\u0275\u0276\u0007\f\u0000\u0000\u0276\u0277\u0007\t\u0000\u0000\u0277"+
		"6\u0001\u0000\u0000\u0000\u0278\u0279\u0007\u0011\u0000\u0000\u0279\u027a"+
		"\u0007\u0003\u0000\u0000\u027a\u027b\u0007\r\u0000\u0000\u027b\u027c\u0007"+
		"\u0017\u0000\u0000\u027c\u027d\u0007\u000e\u0000\u0000\u027d\u027e\u0007"+
		"\u000b\u0000\u0000\u027e8\u0001\u0000\u0000\u0000\u027f\u0280\u0007\u000f"+
		"\u0000\u0000\u0280\u0281\u0007\b\u0000\u0000\u0281\u0282\u0007\f\u0000"+
		"\u0000\u0282\u0283\u0007\u0018\u0000\u0000\u0283:\u0001\u0000\u0000\u0000"+
		"\u0284\u0285\u0007\b\u0000\u0000\u0285\u0286\u0007\u0005\u0000\u0000\u0286"+
		"\u0287\u0007\u0013\u0000\u0000\u0287\u0288\u0007\u0007\u0000\u0000\u0288"+
		"\u0289\u0007\f\u0000\u0000\u0289\u028a\u0007\b\u0000\u0000\u028a\u028b"+
		"\u0007\u0005\u0000\u0000\u028b<\u0001\u0000\u0000\u0000\u028c\u028d\u0007"+
		"\u0011\u0000\u0000\u028d\u028e\u0007\u0005\u0000\u0000\u028e\u028f\u0007"+
		"\u0015\u0000\u0000\u028f\u0290\u0007\u0012\u0000\u0000\u0290\u0291\u0007"+
		"\t\u0000\u0000\u0291>\u0001\u0000\u0000\u0000\u0292\u0293\u0007\u000f"+
		"\u0000\u0000\u0293\u0294\u0007\u000e\u0000\u0000\u0294\u0295\u0007\n\u0000"+
		"\u0000\u0295\u0296\u0007\n\u0000\u0000\u0296@\u0001\u0000\u0000\u0000"+
		"\u0297\u0298\u0007\b\u0000\u0000\u0298\u0299\u0007\u0005\u0000\u0000\u0299"+
		"\u029a\u0007\u0013\u0000\u0000\u029a\u029b\u0007\u0007\u0000\u0000\u029b"+
		"\u029c\u0007\b\u0000\u0000\u029c\u029d\u0007\u0012\u0000\u0000\u029d\u029e"+
		"\u0007\r\u0000\u0000\u029e\u029f\u0007\u0007\u0000\u0000\u029fB\u0001"+
		"\u0000\u0000\u0000\u02a0\u02a1\u0007\u0011\u0000\u0000\u02a1\u02a2\u0007"+
		"\u0005\u0000\u0000\u02a2\u02a3\u0007\u0007\u0000\u0000\u02a3\u02a4\u0007"+
		"\u0019\u0000\u0000\u02a4\u02a5\u0007\u0005\u0000\u0000\u02a5\u02a6\u0007"+
		"\u0005\u0000\u0000\u02a6\u02a7\u0007\t\u0000\u0000\u02a7D\u0001\u0000"+
		"\u0000\u0000\u02a8\u02a9\u0007\u000f\u0000\u0000\u02a9\u02aa\u0007\u000e"+
		"\u0000\u0000\u02aa\u02ab\u0007\t\u0000\u0000\u02ab\u02ac\u0007\r\u0000"+
		"\u0000\u02ac\u02ad\u0007\u0007\u0000\u0000\u02ad\u02ae\u0007\u0012\u0000"+
		"\u0000\u02ae\u02af\u0007\f\u0000\u0000\u02af\u02b0\u0007\t\u0000\u0000"+
		"\u02b0F\u0001\u0000\u0000\u0000\u02b1\u02b2\u0007\b\u0000\u0000\u02b2"+
		"\u02b3\u0007\u0005\u0000\u0000\u02b3\u02b4\u0007\u0007\u0000\u0000\u02b4"+
		"\u02b5\u0007\u000e\u0000\u0000\u02b5\u02b6\u0007\b\u0000\u0000\u02b6\u02b7"+
		"\u0007\t\u0000\u0000\u02b7H\u0001\u0000\u0000\u0000\u02b8\u02b9\u0007"+
		"\u0011\u0000\u0000\u02b9\u02ba\u0007\b\u0000\u0000\u02ba\u02bb\u0007\u0005"+
		"\u0000\u0000\u02bb\u02bc\u0007\u0003\u0000\u0000\u02bc\u02bd\u0007\u0017"+
		"\u0000\u0000\u02bdJ\u0001\u0000\u0000\u0000\u02be\u02bf\u0007\u0015\u0000"+
		"\u0000\u02bf\u02c0\u0007\f\u0000\u0000\u02c0\u02c1\u0007\u0007\u0000\u0000"+
		"\u02c1\u02c2\u0007\f\u0000\u0000\u02c2L\u0001\u0000\u0000\u0000\u02c3"+
		"\u02c4\u0007\b\u0000\u0000\u02c4\u02c5\u0007\u0005\u0000\u0000\u02c5\u02c6"+
		"\u0007\u001a\u0000\u0000\u02c6\u02c7\u0007\u0005\u0000\u0000\u02c7\u02c8"+
		"\u0007\b\u0000\u0000\u02c8\u02c9\u0007\u0007\u0000\u0000\u02c9N\u0001"+
		"\u0000\u0000\u0000\u02ca\u02cb\u0007\u0011\u0000\u0000\u02cb\u02cc\u0007"+
		"\b\u0000\u0000\u02cc\u02cd\u0007\f\u0000\u0000\u02cd\u02ce\u0007\u0019"+
		"\u0000\u0000\u02ce\u02cf\u0007\u0013\u0000\u0000\u02cf\u02d0\u0007\u0005"+
		"\u0000\u0000\u02d0P\u0001\u0000\u0000\u0000\u02d1\u02d2\u0007\u0015\u0000"+
		"\u0000\u02d2\u02d3\u0007\b\u0000\u0000\u02d3\u02d4\u0007\u0003\u0000\u0000"+
		"\u02d4\u02d5\u0007\t\u0000\u0000\u02d5\u02d6\u0007\u0007\u0000\u0000\u02d6"+
		"R\u0001\u0000\u0000\u0000\u02d7\u02d8\u0007\b\u0000\u0000\u02d8\u02d9"+
		"\u0007\u0005\u0000\u0000\u02d9\u02da\u0007\u001a\u0000\u0000\u02da\u02db"+
		"\u0007\f\u0000\u0000\u02db\u02dc\u0007\u0017\u0000\u0000\u02dc\u02dd\u0007"+
		"\u0005\u0000\u0000\u02ddT\u0001\u0000\u0000\u0000\u02de\u02df\u0007\u0011"+
		"\u0000\u0000\u02df\u02e0\u0007\u000e\u0000\u0000\u02e0\u02e1\u0007\n\u0000"+
		"\u0000\u02e1\u02e2\u0007\u0017\u0000\u0000\u02e2V\u0001\u0000\u0000\u0000"+
		"\u02e3\u02e4\u0007\u0015\u0000\u0000\u02e4\u02e5\u0007\b\u0000\u0000\u02e5"+
		"\u02e6\u0007\f\u0000\u0000\u02e6\u02e7\u0007\u000e\u0000\u0000\u02e7\u02e8"+
		"\u0007\u000b\u0000\u0000\u02e8X\u0001\u0000\u0000\u0000\u02e9\u02ea\u0007"+
		"\b\u0000\u0000\u02ea\u02eb\u0007\u0012\u0000\u0000\u02eb\u02ec\u0007\u0015"+
		"\u0000\u0000\u02ec\u02ed\u0007\u0010\u0000\u0000\u02ed\u02ee\u0007\u0007"+
		"\u0000\u0000\u02eeZ\u0001\u0000\u0000\u0000\u02ef\u02f0\u0007\u0011\u0000"+
		"\u0000\u02f0\u02f1\u0007\u0014\u0000\u0000\u02f1\\\u0001\u0000\u0000\u0000"+
		"\u02f2\u02f3\u0007\u0010\u0000\u0000\u02f3\u02f4\u0007\u0003\u0000\u0000"+
		"\u02f4\u02f5\u0007\u001a\u0000\u0000\u02f5\u02f6\u0007\u0012\u0000\u0000"+
		"\u02f6\u02f7\u0007\t\u0000\u0000\u02f7\u02f8\u0007\u0015\u0000\u0000\u02f8"+
		"^\u0001\u0000\u0000\u0000\u02f9\u02fa\u0007\b\u0000\u0000\u02fa\u02fb"+
		"\u0007\f\u0000\u0000\u02fb\u02fc\u0007\n\u0000\u0000\u02fc\u02fd\u0007"+
		"\n\u0000\u0000\u02fd\u02fe\u0007\u0011\u0000\u0000\u02fe\u02ff\u0007\u0003"+
		"\u0000\u0000\u02ff\u0300\u0007\r\u0000\u0000\u0300\u0301\u0007\u0017\u0000"+
		"\u0000\u0301`\u0001\u0000\u0000\u0000\u0302\u0303\u0007\r\u0000\u0000"+
		"\u0303\u0304\u0007\u0003\u0000\u0000\u0304\u0305\u0007\u0013\u0000\u0000"+
		"\u0305\u0306\u0007\r\u0000\u0000\u0306\u0307\u0007\u0003\u0000\u0000\u0307"+
		"\u0308\u0007\u0004\u0000\u0000\u0308\u0309\u0007\u0005\u0000\u0000\u0309"+
		"b\u0001\u0000\u0000\u0000\u030a\u030b\u0007\u0010\u0000\u0000\u030b\u030c"+
		"\u0007\f\u0000\u0000\u030c\u030d\u0007\n\u0000\u0000\u030d\u030e\u0007"+
		"\u0004\u0000\u0000\u030e\u030f\u0007\n\u0000\u0000\u030f\u0310\u0007\f"+
		"\u0000\u0000\u0310\u0311\u0007\r\u0000\u0000\u0311\u0312\u0007\u0017\u0000"+
		"\u0000\u0312d\u0001\u0000\u0000\u0000\u0313\u0314\u0007\b\u0000\u0000"+
		"\u0314\u0315\u0007\f\u0000\u0000\u0315\u0316\u0007\u0019\u0000\u0000\u0316"+
		"\u0317\u0007\r\u0000\u0000\u0317\u0318\u0007\f\u0000\u0000\u0318\u0319"+
		"\u0007\u000e\u0000\u0000\u0319\u031a\u0007\t\u0000\u0000\u031a\u031b\u0007"+
		"\u0007\u0000\u0000\u031bf\u0001\u0000\u0000\u0000\u031c\u031d\u0007\r"+
		"\u0000\u0000\u031d\u031e\u0007\u0003\u0000\u0000\u031e\u031f\u0007\u0013"+
		"\u0000\u0000\u031f\u0320\u0007\u0005\u0000\u0000\u0320h\u0001\u0000\u0000"+
		"\u0000\u0321\u0322\u0007\u0012\u0000\u0000\u0322\u0323\u0007\u0004\u0000"+
		"\u0000\u0323\u0324\u0007\u0005\u0000\u0000\u0324\u0325\u0007\t\u0000\u0000"+
		"\u0325\u0326\u0007\u0007\u0000\u0000\u0326\u0327\u0007\u0012\u0000\u0000"+
		"\u0327\u0328\u0007\u0007\u0000\u0000\u0328\u0329\u0007\u0014\u0000\u0000"+
		"\u0329j\u0001\u0000\u0000\u0000\u032a\u032b\u0007\b\u0000\u0000\u032b"+
		"\u032c\u0007\f\u0000\u0000\u032c\u032d\u0007\u0019\u0000\u0000\u032d\u032e"+
		"\u0007\u0015\u0000\u0000\u032e\u032f\u0007\u000e\u0000\u0000\u032f\u0330"+
		"\u0007\u0012\u0000\u0000\u0330\u0331\u0007\u0004\u0000\u0000\u0331\u0332"+
		"\u0007\r\u0000\u0000\u0332\u0333\u0007\f\u0000\u0000\u0333\u0334\u0007"+
		"\n\u0000\u0000\u0334l\u0001\u0000\u0000\u0000\u0335\u0336\u0007\r\u0000"+
		"\u0000\u0336\u0337\u0007\u0010\u0000\u0000\u0337\u0338\u0007\u0005\u0000"+
		"\u0000\u0338\u0339\u0007\r\u0000\u0000\u0339\u033a\u0007\u0017\u0000\u0000"+
		"\u033an\u0001\u0000\u0000\u0000\u033b\u033c\u0007\u0012\u0000\u0000\u033c"+
		"\u033d\u0007\u0004\u0000\u0000\u033d\u033e\u0007\u0005\u0000\u0000\u033e"+
		"\u033f\u0007\t\u0000\u0000\u033f\u0340\u0007\u0007\u0000\u0000\u0340\u0341"+
		"\u0007\u0012\u0000\u0000\u0341\u0342\u0007\u0007\u0000\u0000\u0342\u0343"+
		"\u0007\u0014\u0000\u0000\u0343\u0344\u0005_\u0000\u0000\u0344\u0345\u0007"+
		"\u0012\u0000\u0000\u0345\u0346\u0007\t\u0000\u0000\u0346\u0347\u0007\u0013"+
		"\u0000\u0000\u0347\u0348\u0007\u0005\u0000\u0000\u0348\u0349\u0007\b\u0000"+
		"\u0000\u0349\u034a\u0007\u0007\u0000\u0000\u034ap\u0001\u0000\u0000\u0000"+
		"\u034b\u034c\u0007\b\u0000\u0000\u034c\u034d\u0007\u000e\u0000\u0000\u034d"+
		"\u034e\u0007\n\u0000\u0000\u034e\u034f\u0007\u0005\u0000\u0000\u034fr"+
		"\u0001\u0000\u0000\u0000\u0350\u0351\u0007\r\u0000\u0000\u0351\u0352\u0007"+
		"\u0010\u0000\u0000\u0352\u0353\u0007\u0005\u0000\u0000\u0353\u0354\u0007"+
		"\r\u0000\u0000\u0354\u0355\u0007\u0017\u0000\u0000\u0355\u0356\u0007\u000b"+
		"\u0000\u0000\u0356\u0357\u0007\f\u0000\u0000\u0357\u0358\u0007\u0012\u0000"+
		"\u0000\u0358\u0359\u0007\t\u0000\u0000\u0359\u035a\u0007\u0007\u0000\u0000"+
		"\u035at\u0001\u0000\u0000\u0000\u035b\u035c\u0007\u0012\u0000\u0000\u035c"+
		"\u035d\u0007\u0004\u0000\u0000\u035d\u035e\u0007\u0005\u0000\u0000\u035e"+
		"\u035f\u0007\t\u0000\u0000\u035f\u0360\u0007\u0007\u0000\u0000\u0360\u0361"+
		"\u0007\u0012\u0000\u0000\u0361\u0362\u0007\u0007\u0000\u0000\u0362\u0363"+
		"\u0007\u0014\u0000\u0000\u0363\u0364\u0007\r\u0000\u0000\u0364\u0365\u0007"+
		"\f\u0000\u0000\u0365\u0366\u0007\n\u0000\u0000\u0366v\u0001\u0000\u0000"+
		"\u0000\u0367\u0368\u0007\u0013\u0000\u0000\u0368\u0369\u0007\u0003\u0000"+
		"\u0000\u0369\u036a\u0007\u001a\u0000\u0000\u036a\u036b\u0007\u0005\u0000"+
		"\u0000\u036bx\u0001\u0000\u0000\u0000\u036c\u036d\u0007\r\u0000\u0000"+
		"\u036d\u036e\u0007\n\u0000\u0000\u036e\u036f\u0007\f\u0000\u0000\u036f"+
		"\u0370\u0007\u0013\u0000\u0000\u0370\u0371\u0007\u0005\u0000\u0000\u0371"+
		"z\u0001\u0000\u0000\u0000\u0372\u0373\u0007\u0012\u0000\u0000\u0373\u0374"+
		"\u0007\u000f\u0000\u0000\u0374|\u0001\u0000\u0000\u0000\u0375\u0376\u0007"+
		"\u0013\u0000\u0000\u0376\u0377\u0007\r\u0000\u0000\u0377\u0378\u0007\u0010"+
		"\u0000\u0000\u0378\u0379\u0007\u0005\u0000\u0000\u0379\u037a\u0007\u0018"+
		"\u0000\u0000\u037a\u037b\u0007\u0003\u0000\u0000\u037b~\u0001\u0000\u0000"+
		"\u0000\u037c\u037d\u0007\r\u0000\u0000\u037d\u037e\u0007\n\u0000\u0000"+
		"\u037e\u037f\u0007\u000e\u0000\u0000\u037f\u0380\u0007\u0013\u0000\u0000"+
		"\u0380\u0381\u0007\u0007\u0000\u0000\u0381\u0382\u0007\u0005\u0000\u0000"+
		"\u0382\u0383\u0007\b\u0000\u0000\u0383\u0384\u0007\u0005\u0000\u0000\u0384"+
		"\u0385\u0007\u0004\u0000\u0000\u0385\u0080\u0001\u0000\u0000\u0000\u0386"+
		"\u0387\u0007\u0012\u0000\u0000\u0387\u0388\u0007\t\u0000\u0000\u0388\u0082"+
		"\u0001\u0000\u0000\u0000\u0389\u038a\u0007\u0013\u0000\u0000\u038a\u038b"+
		"\u0007\u0005\u0000\u0000\u038b\u038c\u0007\r\u0000\u0000\u038c\u038d\u0007"+
		"\u000e\u0000\u0000\u038d\u038e\u0007\b\u0000\u0000\u038e\u038f\u0007\u0012"+
		"\u0000\u0000\u038f\u0390\u0007\u0007\u0000\u0000\u0390\u0391\u0007\u0014"+
		"\u0000\u0000\u0391\u0392\u0007\u0003\u0000\u0000\u0392\u0393\u0007\u000e"+
		"\u0000\u0000\u0393\u0394\u0007\u0004\u0000\u0000\u0394\u0395\u0007\u0012"+
		"\u0000\u0000\u0395\u0396\u0007\u0007\u0000\u0000\u0396\u0084\u0001\u0000"+
		"\u0000\u0000\u0397\u0398\u0007\r\u0000\u0000\u0398\u0399\u0007\f\u0000"+
		"\u0000\u0399\u039a\u0007\u0003\u0000\u0000\u039a\u039b\u0007\n\u0000\u0000"+
		"\u039b\u039c\u0007\u0005\u0000\u0000\u039c\u039d\u0007\u0013\u0000\u0000"+
		"\u039d\u039e\u0007\r\u0000\u0000\u039e\u039f\u0007\u0005\u0000\u0000\u039f"+
		"\u0086\u0001\u0000\u0000\u0000\u03a0\u03a1\u0007\u0012\u0000\u0000\u03a1"+
		"\u03a2\u0007\t\u0000\u0000\u03a2\u03a3\u0007\u0004\u0000\u0000\u03a3\u03a4"+
		"\u0007\u0005\u0000\u0000\u03a4\u03a5\u0007\u0006\u0000\u0000\u03a5\u0088"+
		"\u0001\u0000\u0000\u0000\u03a6\u03a7\u0007\u0013\u0000\u0000\u03a7\u03a8"+
		"\u0007\u0005\u0000\u0000\u03a8\u03a9\u0007\n\u0000\u0000\u03a9\u03aa\u0007"+
		"\u0005\u0000\u0000\u03aa\u03ab\u0007\r\u0000\u0000\u03ab\u03ac\u0007\u0007"+
		"\u0000\u0000\u03ac\u008a\u0001\u0000\u0000\u0000\u03ad\u03ae\u0007\r\u0000"+
		"\u0000\u03ae\u03af\u0007\f\u0000\u0000\u03af\u03b0\u0007\n\u0000\u0000"+
		"\u03b0\u03b1\u0007\n\u0000\u0000\u03b1\u03b2\u0007\u0003\u0000\u0000\u03b2"+
		"\u03b3\u0007\u0007\u0000\u0000\u03b3\u03b4\u0007\u0005\u0000\u0000\u03b4"+
		"\u008c\u0001\u0000\u0000\u0000\u03b5\u03b6\u0007\u0012\u0000\u0000\u03b6"+
		"\u03b7\u0007\t\u0000\u0000\u03b7\u03b8\u0007\t\u0000\u0000\u03b8\u03b9"+
		"\u0007\u0005\u0000\u0000\u03b9\u03ba\u0007\b\u0000\u0000\u03ba\u008e\u0001"+
		"\u0000\u0000\u0000\u03bb\u03bc\u0007\u0013\u0000\u0000\u03bc\u03bd\u0007"+
		"\u0005\u0000\u0000\u03bd\u03be\u0007\u0018\u0000\u0000\u03be\u03bf\u0007"+
		"\u0003\u0000\u0000\u03bf\u03c0\u0007\t\u0000\u0000\u03c0\u03c1\u0007\u0007"+
		"\u0000\u0000\u03c1\u03c2\u0007\u0012\u0000\u0000\u03c2\u03c3\u0007\r\u0000"+
		"\u0000\u03c3\u03c4\u0007\u0017\u0000\u0000\u03c4\u03c5\u0007\u0005\u0000"+
		"\u0000\u03c5\u03c6\u0007\u0014\u0000\u0000\u03c6\u03c7\u0007\u000b\u0000"+
		"\u0000\u03c7\u03c8\u0007\u0010\u0000\u0000\u03c8\u03c9\u0007\b\u0000\u0000"+
		"\u03c9\u03ca\u0007\u0003\u0000\u0000\u03ca\u03cb\u0007\u0013\u0000\u0000"+
		"\u03cb\u03cc\u0007\u0005\u0000\u0000\u03cc\u03cd\u0007\u0007\u0000\u0000"+
		"\u03cd\u03ce\u0007\u0003\u0000\u0000\u03ce\u03cf\u0007\u0011\u0000\u0000"+
		"\u03cf\u03d0\u0007\n\u0000\u0000\u03d0\u03d1\u0007\u0005\u0000\u0000\u03d1"+
		"\u0090\u0001\u0000\u0000\u0000\u03d2\u03d3\u0007\r\u0000\u0000\u03d3\u03d4"+
		"\u0007\f\u0000\u0000\u03d4\u03d5\u0007\n\u0000\u0000\u03d5\u03d6\u0007"+
		"\u000e\u0000\u0000\u03d6\u03d7\u0007\u0018\u0000\u0000\u03d7\u03d8\u0007"+
		"\t\u0000\u0000\u03d8\u0092\u0001\u0000\u0000\u0000\u03d9\u03da\u0007\u0012"+
		"\u0000\u0000\u03da\u03db\u0007\t\u0000\u0000\u03db\u03dc\u0007\u0013\u0000"+
		"\u0000\u03dc\u03dd\u0007\u0005\u0000\u0000\u03dd\u03de\u0007\b\u0000\u0000"+
		"\u03de\u03df\u0007\u0007\u0000\u0000\u03df\u0094\u0001\u0000\u0000\u0000"+
		"\u03e0\u03e1\u0007\u0013\u0000\u0000\u03e1\u03e2\u0007\u0005\u0000\u0000"+
		"\u03e2\u03e3\u0007\u0018\u0000\u0000\u03e3\u03e4\u0007\u0003\u0000\u0000"+
		"\u03e4\u03e5\u0007\t\u0000\u0000\u03e5\u03e6\u0007\u0007\u0000\u0000\u03e6"+
		"\u03e7\u0007\u0012\u0000\u0000\u03e7\u03e8\u0007\r\u0000\u0000\u03e8\u03e9"+
		"\u0007\u0013\u0000\u0000\u03e9\u03ea\u0007\u0012\u0000\u0000\u03ea\u03eb"+
		"\u0007\u0018\u0000\u0000\u03eb\u03ec\u0007\u0012\u0000\u0000\u03ec\u03ed"+
		"\u0007\n\u0000\u0000\u03ed\u03ee\u0007\u0003\u0000\u0000\u03ee\u03ef\u0007"+
		"\b\u0000\u0000\u03ef\u03f0\u0007\u0012\u0000\u0000\u03f0\u03f1\u0007\u0007"+
		"\u0000\u0000\u03f1\u03f2\u0007\u0014\u0000\u0000\u03f2\u03f3\u0007\u0004"+
		"\u0000\u0000\u03f3\u03f4\u0007\u0005\u0000\u0000\u03f4\u03f5\u0007\u0007"+
		"\u0000\u0000\u03f5\u03f6\u0007\u0003\u0000\u0000\u03f6\u03f7\u0007\u0012"+
		"\u0000\u0000\u03f7\u03f8\u0007\n\u0000\u0000\u03f8\u03f9\u0007\u0013\u0000"+
		"\u0000\u03f9\u03fa\u0007\u0007\u0000\u0000\u03fa\u03fb\u0007\u0003\u0000"+
		"\u0000\u03fb\u03fc\u0007\u0011\u0000\u0000\u03fc\u03fd\u0007\n\u0000\u0000"+
		"\u03fd\u03fe\u0007\u0005\u0000\u0000\u03fe\u0096\u0001\u0000\u0000\u0000"+
		"\u03ff\u0400\u0007\r\u0000\u0000\u0400\u0401\u0007\f\u0000\u0000\u0401"+
		"\u0402\u0007\u0018\u0000\u0000\u0402\u0403\u0007\u0018\u0000\u0000\u0403"+
		"\u0404\u0007\u0012\u0000\u0000\u0404\u0405\u0007\u0007\u0000\u0000\u0405"+
		"\u0098\u0001\u0000\u0000\u0000\u0406\u0407\u0007\u0012\u0000\u0000\u0407"+
		"\u0408\u0007\t\u0000\u0000\u0408\u0409\u0007\u0007\u0000\u0000\u0409\u040a"+
		"\u0007\u0005\u0000\u0000\u040a\u040b\u0007\b\u0000\u0000\u040b\u040c\u0007"+
		"\u0013\u0000\u0000\u040c\u040d\u0007\u0005\u0000\u0000\u040d\u040e\u0007"+
		"\r\u0000\u0000\u040e\u040f\u0007\u0007\u0000\u0000\u040f\u009a\u0001\u0000"+
		"\u0000\u0000\u0410\u0411\u0007\u0013\u0000\u0000\u0411\u0412\u0007\u0005"+
		"\u0000\u0000\u0412\u0413\u0007\u0018\u0000\u0000\u0413\u0414\u0007\u0003"+
		"\u0000\u0000\u0414\u0415\u0007\t\u0000\u0000\u0415\u0416\u0007\u0007\u0000"+
		"\u0000\u0416\u0417\u0007\u0012\u0000\u0000\u0417\u0418\u0007\r\u0000\u0000"+
		"\u0418\u0419\u0007\u0013\u0000\u0000\u0419\u041a\u0007\u0012\u0000\u0000"+
		"\u041a\u041b\u0007\u0018\u0000\u0000\u041b\u041c\u0007\u0012\u0000\u0000"+
		"\u041c\u041d\u0007\n\u0000\u0000\u041d\u041e\u0007\u0003\u0000\u0000\u041e"+
		"\u041f\u0007\b\u0000\u0000\u041f\u0420\u0007\u0012\u0000\u0000\u0420\u0421"+
		"\u0007\u0007\u0000\u0000\u0421\u0422\u0007\u0014\u0000\u0000\u0422\u0423"+
		"\u0007\u0007\u0000\u0000\u0423\u0424\u0007\u0003\u0000\u0000\u0424\u0425"+
		"\u0007\u0011\u0000\u0000\u0425\u0426\u0007\n\u0000\u0000\u0426\u0427\u0007"+
		"\u0005\u0000\u0000\u0427\u009c\u0001\u0000\u0000\u0000\u0428\u0429\u0007"+
		"\r\u0000\u0000\u0429\u042a\u0007\f\u0000\u0000\u042a\u042b\u0007\u0018"+
		"\u0000\u0000\u042b\u042c\u0007\u000b\u0000\u0000\u042c\u042d\u0007\u000e"+
		"\u0000\u0000\u042d\u042e\u0007\u0007\u0000\u0000\u042e\u042f\u0007\u0005"+
		"\u0000\u0000\u042f\u009e\u0001\u0000\u0000\u0000\u0430\u0431\u0007\u0012"+
		"\u0000\u0000\u0431\u0432\u0007\t\u0000\u0000\u0432\u0433\u0007\u0007\u0000"+
		"\u0000\u0433\u0434\u0007\f\u0000\u0000\u0434\u00a0\u0001\u0000\u0000\u0000"+
		"\u0435\u0436\u0007\u0013\u0000\u0000\u0436\u0437\u0007\u0005\u0000\u0000"+
		"\u0437\u0438\u0007\u0013\u0000\u0000\u0438\u0439\u0007\u0013\u0000\u0000"+
		"\u0439\u043a\u0007\u0012\u0000\u0000\u043a\u043b\u0007\f\u0000\u0000\u043b"+
		"\u043c\u0007\t\u0000\u0000\u043c\u043d\u0005_\u0000\u0000\u043d\u043e"+
		"\u0007\u000e\u0000\u0000\u043e\u043f\u0007\u0013\u0000\u0000\u043f\u0440"+
		"\u0007\u0005\u0000\u0000\u0440\u0441\u0007\b\u0000\u0000\u0441\u00a2\u0001"+
		"\u0000\u0000\u0000\u0442\u0443\u0007\r\u0000\u0000\u0443\u0444\u0007\f"+
		"\u0000\u0000\u0444\u0445\u0007\t\u0000\u0000\u0445\u0446\u0007\u0013\u0000"+
		"\u0000\u0446\u0447\u0007\u0007\u0000\u0000\u0447\u0448\u0007\b\u0000\u0000"+
		"\u0448\u0449\u0007\u0003\u0000\u0000\u0449\u044a\u0007\u0012\u0000\u0000"+
		"\u044a\u044b\u0007\t\u0000\u0000\u044b\u044c\u0007\u0007\u0000\u0000\u044c"+
		"\u00a4\u0001\u0000\u0000\u0000\u044d\u044e\u0007\u0012\u0000\u0000\u044e"+
		"\u044f\u0007\u0013\u0000\u0000\u044f\u00a6\u0001\u0000\u0000\u0000\u0450"+
		"\u0451\u0007\u0013\u0000\u0000\u0451\u0452\u0007\u0005\u0000\u0000\u0452"+
		"\u0453\u0007\u0007\u0000\u0000\u0453\u00a8\u0001\u0000\u0000\u0000\u0454"+
		"\u0455\u0007\r\u0000\u0000\u0455\u0456\u0007\f\u0000\u0000\u0456\u0457"+
		"\u0007\t\u0000\u0000\u0457\u0458\u0007\u0007\u0000\u0000\u0458\u0459\u0007"+
		"\u0003\u0000\u0000\u0459\u045a\u0007\u0012\u0000\u0000\u045a\u045b\u0007"+
		"\t\u0000\u0000\u045b\u045c\u0007\u0013\u0000\u0000\u045c\u00aa\u0001\u0000"+
		"\u0000\u0000\u045d\u045e\u0007\u001b\u0000\u0000\u045e\u045f\u0007\f\u0000"+
		"\u0000\u045f\u0460\u0007\u0012\u0000\u0000\u0460\u0461\u0007\t\u0000\u0000"+
		"\u0461\u00ac\u0001\u0000\u0000\u0000\u0462\u0463\u0007\u0013\u0000\u0000"+
		"\u0463\u0464\u0007\u0005\u0000\u0000\u0464\u0465\u0007\u0007\u0000\u0000"+
		"\u0465\u0466\u0007\u000e\u0000\u0000\u0466\u0467\u0007\u0013\u0000\u0000"+
		"\u0467\u0468\u0007\u0005\u0000\u0000\u0468\u0469\u0007\b\u0000\u0000\u0469"+
		"\u00ae\u0001\u0000\u0000\u0000\u046a\u046b\u0007\r\u0000\u0000\u046b\u046c"+
		"\u0007\f\u0000\u0000\u046c\u046d\u0007\t\u0000\u0000\u046d\u046e\u0007"+
		"\u0007\u0000\u0000\u046e\u046f\u0007\u0003\u0000\u0000\u046f\u0470\u0007"+
		"\u0012\u0000\u0000\u0470\u0471\u0007\t\u0000\u0000\u0471\u0472\u0007\u0013"+
		"\u0000\u0000\u0472\u0473\u0007\u0007\u0000\u0000\u0473\u0474\u0007\u0003"+
		"\u0000\u0000\u0474\u0475\u0007\u0011\u0000\u0000\u0475\u0476\u0007\n\u0000"+
		"\u0000\u0476\u0477\u0007\u0005\u0000\u0000\u0477\u00b0\u0001\u0000\u0000"+
		"\u0000\u0478\u0479\u0007\u0017\u0000\u0000\u0479\u047a\u0007\u0005\u0000"+
		"\u0000\u047a\u047b\u0007\u0014\u0000\u0000\u047b\u00b2\u0001\u0000\u0000"+
		"\u0000\u047c\u047d\u0007\u0013\u0000\u0000\u047d\u047e\u0007\u0010\u0000"+
		"\u0000\u047e\u047f\u0007\u000e\u0000\u0000\u047f\u0480\u0007\u0007\u0000"+
		"\u0000\u0480\u0481\u0007\u0004\u0000\u0000\u0481\u0482\u0007\f\u0000\u0000"+
		"\u0482\u0483\u0007\u0019\u0000\u0000\u0483\u0484\u0007\t\u0000\u0000\u0484"+
		"\u00b4\u0001\u0000\u0000\u0000\u0485\u0486\u0007\r\u0000\u0000\u0486\u0487"+
		"\u0007\f\u0000\u0000\u0487\u0488\u0007\t\u0000\u0000\u0488\u0489\u0007"+
		"\u0007\u0000\u0000\u0489\u048a\u0007\u0012\u0000\u0000\u048a\u048b\u0007"+
		"\t\u0000\u0000\u048b\u048c\u0007\u000e\u0000\u0000\u048c\u048d\u0007\u0005"+
		"\u0000\u0000\u048d\u00b6\u0001\u0000\u0000\u0000\u048e\u048f\u0007\u0017"+
		"\u0000\u0000\u048f\u0490\u0007\u0012\u0000\u0000\u0490\u0491\u0007\n\u0000"+
		"\u0000\u0491\u0492\u0007\n\u0000\u0000\u0492\u00b8\u0001\u0000\u0000\u0000"+
		"\u0493\u0494\u0007\u0013\u0000\u0000\u0494\u0495\u0007\f\u0000\u0000\u0495"+
		"\u0496\u0007\u0018\u0000\u0000\u0496\u0497\u0007\u0005\u0000\u0000\u0497"+
		"\u00ba\u0001\u0000\u0000\u0000\u0498\u0499\u0007\r\u0000\u0000\u0499\u049a"+
		"\u0007\f\u0000\u0000\u049a\u049b\u0007\t\u0000\u0000\u049b\u049c\u0007"+
		"\u001a\u0000\u0000\u049c\u049d\u0007\u0005\u0000\u0000\u049d\u049e\u0007"+
		"\b\u0000\u0000\u049e\u049f\u0007\u0007\u0000\u0000\u049f\u00bc\u0001\u0000"+
		"\u0000\u0000\u04a0\u04a1\u0007\n\u0000\u0000\u04a1\u04a2\u0007\u0005\u0000"+
		"\u0000\u04a2\u04a3\u0007\u000f\u0000\u0000\u04a3\u04a4\u0007\u0007\u0000"+
		"\u0000\u04a4\u00be\u0001\u0000\u0000\u0000\u04a5\u04a6\u0007\u0013\u0000"+
		"\u0000\u04a6\u04a7\u0007\u0007\u0000\u0000\u04a7\u04a8\u0007\u0003\u0000"+
		"\u0000\u04a8\u04a9\u0007\u0007\u0000\u0000\u04a9\u04aa\u0007\u0012\u0000"+
		"\u0000\u04aa\u04ab\u0007\u0013\u0000\u0000\u04ab\u04ac\u0007\u0007\u0000"+
		"\u0000\u04ac\u04ad\u0007\u0012\u0000\u0000\u04ad\u04ae\u0007\r\u0000\u0000"+
		"\u04ae\u04af\u0007\u0013\u0000\u0000\u04af\u00c0\u0001\u0000\u0000\u0000"+
		"\u04b0\u04b1\u0007\r\u0000\u0000\u04b1\u04b2\u0007\b\u0000\u0000\u04b2"+
		"\u04b3\u0007\u0005\u0000\u0000\u04b3\u04b4\u0007\u0003\u0000\u0000\u04b4"+
		"\u04b5\u0007\u0007\u0000\u0000\u04b5\u04b6\u0007\u0005\u0000\u0000\u04b6"+
		"\u00c2\u0001\u0000\u0000\u0000\u04b7\u04b8\u0007\n\u0000\u0000\u04b8\u04b9"+
		"\u0007\u0012\u0000\u0000\u04b9\u04ba\u0007\u0017\u0000\u0000\u04ba\u04bb"+
		"\u0007\u0005\u0000\u0000\u04bb\u00c4\u0001\u0000\u0000\u0000\u04bc\u04bd"+
		"\u0007\u0013\u0000\u0000\u04bd\u04be\u0007\u0014\u0000\u0000\u04be\u04bf"+
		"\u0007\u0013\u0000\u0000\u04bf\u04c0\u0007\u0007\u0000\u0000\u04c0\u04c1"+
		"\u0007\u0005\u0000\u0000\u04c1\u04c2\u0007\u0018\u0000\u0000\u04c2\u04c3"+
		"\u0005_\u0000\u0000\u04c3\u04c4\u0007\u000e\u0000\u0000\u04c4\u04c5\u0007"+
		"\u0013\u0000\u0000\u04c5\u04c6\u0007\u0005\u0000\u0000\u04c6\u04c7\u0007"+
		"\b\u0000\u0000\u04c7\u00c6\u0001\u0000\u0000\u0000\u04c8\u04c9\u0007\r"+
		"\u0000\u0000\u04c9\u04ca\u0007\b\u0000\u0000\u04ca\u04cb\u0007\f\u0000"+
		"\u0000\u04cb\u04cc\u0007\u0013\u0000\u0000\u04cc\u04cd\u0007\u0013\u0000"+
		"\u0000\u04cd\u00c8\u0001\u0000\u0000\u0000\u04ce\u04cf\u0007\n\u0000\u0000"+
		"\u04cf\u04d0\u0007\u0012\u0000\u0000\u04d0\u04d1\u0007\t\u0000\u0000\u04d1"+
		"\u04d2\u0007\u0005\u0000\u0000\u04d2\u04d3\u0007\t\u0000\u0000\u04d3\u04d4"+
		"\u0007\f\u0000\u0000\u04d4\u00ca\u0001\u0000\u0000\u0000\u04d5\u04d6\u0007"+
		"\u0007\u0000\u0000\u04d6\u04d7\u0007\u0003\u0000\u0000\u04d7\u04d8\u0007"+
		"\u0011\u0000\u0000\u04d8\u04d9\u0007\n\u0000\u0000\u04d9\u04da\u0007\u0005"+
		"\u0000\u0000\u04da\u00cc\u0001\u0000\u0000\u0000\u04db\u04dc\u0007\r\u0000"+
		"\u0000\u04dc\u04dd\u0007\u000e\u0000\u0000\u04dd\u04de\u0007\b\u0000\u0000"+
		"\u04de\u04df\u0007\b\u0000\u0000\u04df\u04e0\u0007\u0005\u0000\u0000\u04e0"+
		"\u04e1\u0007\t\u0000\u0000\u04e1\u04e2\u0007\u0007\u0000\u0000\u04e2\u00ce"+
		"\u0001\u0000\u0000\u0000\u04e3\u04e4\u0007\n\u0000\u0000\u04e4\u04e5\u0007"+
		"\f\u0000\u0000\u04e5\u04e6\u0007\u0003\u0000\u0000\u04e6\u04e7\u0007\u0004"+
		"\u0000\u0000\u04e7\u00d0\u0001\u0000\u0000\u0000\u04e8\u04e9\u0007\u0007"+
		"\u0000\u0000\u04e9\u04ea\u0007\u0003\u0000\u0000\u04ea\u04eb\u0007\u0011"+
		"\u0000\u0000\u04eb\u04ec\u0007\n\u0000\u0000\u04ec\u04ed\u0007\u0005\u0000"+
		"\u0000\u04ed\u04ee\u0007\u0013\u0000\u0000\u04ee\u04ef\u0007\u0003\u0000"+
		"\u0000\u04ef\u04f0\u0007\u0018\u0000\u0000\u04f0\u04f1\u0007\u000b\u0000"+
		"\u0000\u04f1\u04f2\u0007\n\u0000\u0000\u04f2\u04f3\u0007\u0005\u0000\u0000"+
		"\u04f3\u00d2\u0001\u0000\u0000\u0000\u04f4\u04f5\u0007\r\u0000\u0000\u04f5"+
		"\u04f6\u0007\u000e\u0000\u0000\u04f6\u04f7\u0007\b\u0000\u0000\u04f7\u04f8"+
		"\u0007\b\u0000\u0000\u04f8\u04f9\u0007\u0005\u0000\u0000\u04f9\u04fa\u0007"+
		"\t\u0000\u0000\u04fa\u04fb\u0007\u0007\u0000\u0000\u04fb\u04fc\u0005_"+
		"\u0000\u0000\u04fc\u04fd\u0007\u0004\u0000\u0000\u04fd\u04fe\u0007\u0003"+
		"\u0000\u0000\u04fe\u04ff\u0007\u0007\u0000\u0000\u04ff\u0500\u0007\u0005"+
		"\u0000\u0000\u0500\u00d4\u0001\u0000\u0000\u0000\u0501\u0502\u0007\u0018"+
		"\u0000\u0000\u0502\u0503\u0007\u0005\u0000\u0000\u0503\u0504\u0007\b\u0000"+
		"\u0000\u0504\u0505\u0007\u0015\u0000\u0000\u0505\u0506\u0007\u0005\u0000"+
		"\u0000\u0506\u00d6\u0001\u0000\u0000\u0000\u0507\u0508\u0007\u0007\u0000"+
		"\u0000\u0508\u0509\u0007\u0005\u0000\u0000\u0509\u050a\u0007\u0006\u0000"+
		"\u0000\u050a\u050b\u0007\u0007\u0000\u0000\u050b\u050c\u0007\u0013\u0000"+
		"\u0000\u050c\u050d\u0007\u0012\u0000\u0000\u050d\u050e\u0007\u0016\u0000"+
		"\u0000\u050e\u050f\u0007\u0005\u0000\u0000\u050f\u00d8\u0001\u0000\u0000"+
		"\u0000\u0510\u0511\u0007\r\u0000\u0000\u0511\u0512\u0007\u000e\u0000\u0000"+
		"\u0512\u0513\u0007\b\u0000\u0000\u0513\u0514\u0007\b\u0000\u0000\u0514"+
		"\u0515\u0007\u0005\u0000\u0000\u0515\u0516\u0007\t\u0000\u0000\u0516\u0517"+
		"\u0007\u0007\u0000\u0000\u0517\u0518\u0005_\u0000\u0000\u0518\u0519\u0007"+
		"\u0007\u0000\u0000\u0519\u051a\u0007\u0012\u0000\u0000\u051a\u051b\u0007"+
		"\u0018\u0000\u0000\u051b\u051c\u0007\u0005\u0000\u0000\u051c\u00da\u0001"+
		"\u0000\u0000\u0000\u051d\u051e\u0007\t\u0000\u0000\u051e\u051f\u0007\u0003"+
		"\u0000\u0000\u051f\u0520\u0007\u0007\u0000\u0000\u0520\u0521\u0007\u0012"+
		"\u0000\u0000\u0521\u0522\u0007\f\u0000\u0000\u0522\u0523\u0007\t\u0000"+
		"\u0000\u0523\u0524\u0007\u0003\u0000\u0000\u0524\u0525\u0007\n\u0000\u0000"+
		"\u0525\u00dc\u0001\u0000\u0000\u0000\u0526\u0527\u0007\u0007\u0000\u0000"+
		"\u0527\u0528\u0007\u0010\u0000\u0000\u0528\u0529\u0007\u0005\u0000\u0000"+
		"\u0529\u052a\u0007\t\u0000\u0000\u052a\u00de\u0001\u0000\u0000\u0000\u052b"+
		"\u052c\u0007\r\u0000\u0000\u052c\u052d\u0007\u000e\u0000\u0000\u052d\u052e"+
		"\u0007\b\u0000\u0000\u052e\u052f\u0007\b\u0000\u0000\u052f\u0530\u0007"+
		"\u0005\u0000\u0000\u0530\u0531\u0007\t\u0000\u0000\u0531\u0532\u0007\u0007"+
		"\u0000\u0000\u0532\u0533\u0005_\u0000\u0000\u0533\u0534\u0007\u0007\u0000"+
		"\u0000\u0534\u0535\u0007\u0012\u0000\u0000\u0535\u0536\u0007\u0018\u0000"+
		"\u0000\u0536\u0537\u0007\u0005\u0000\u0000\u0537\u0538\u0007\u0013\u0000"+
		"\u0000\u0538\u0539\u0007\u0007\u0000\u0000\u0539\u053a\u0007\u0003\u0000"+
		"\u0000\u053a\u053b\u0007\u0018\u0000\u0000\u053b\u053c\u0007\u000b\u0000"+
		"\u0000\u053c\u00e0\u0001\u0000\u0000\u0000\u053d\u053e\u0007\t\u0000\u0000"+
		"\u053e\u053f\u0007\f\u0000\u0000\u053f\u0540\u0007\r\u0000\u0000\u0540"+
		"\u0541\u0007\u0010\u0000\u0000\u0541\u0542\u0007\u0005\u0000\u0000\u0542"+
		"\u0543\u0007\r\u0000\u0000\u0543\u0544\u0007\u0017\u0000\u0000\u0544\u00e2"+
		"\u0001\u0000\u0000\u0000\u0545\u0546\u0007\u0007\u0000\u0000\u0546\u0547"+
		"\u0007\f\u0000\u0000\u0547\u00e4\u0001\u0000\u0000\u0000\u0548\u0549\u0007"+
		"\r\u0000\u0000\u0549\u054a\u0007\u000e\u0000\u0000\u054a\u054b\u0007\b"+
		"\u0000\u0000\u054b\u054c\u0007\b\u0000\u0000\u054c\u054d\u0007\u0005\u0000"+
		"\u0000\u054d\u054e\u0007\t\u0000\u0000\u054e\u054f\u0007\u0007\u0000\u0000"+
		"\u054f\u0550\u0005_\u0000\u0000\u0550\u0551\u0007\u000e\u0000\u0000\u0551"+
		"\u0552\u0007\u0013\u0000\u0000\u0552\u0553\u0007\u0005\u0000\u0000\u0553"+
		"\u0554\u0007\b\u0000\u0000\u0554\u00e6\u0001\u0000\u0000\u0000\u0555\u0556"+
		"\u0007\t\u0000\u0000\u0556\u0557\u0007\f\u0000\u0000\u0557\u0558\u0007"+
		"\t\u0000\u0000\u0558\u0559\u0007\r\u0000\u0000\u0559\u055a\u0007\n\u0000"+
		"\u0000\u055a\u055b\u0007\u000e\u0000\u0000\u055b\u055c\u0007\u0013\u0000"+
		"\u0000\u055c\u055d\u0007\u0007\u0000\u0000\u055d\u055e\u0007\u0005\u0000"+
		"\u0000\u055e\u055f\u0007\b\u0000\u0000\u055f\u0560\u0007\u0005\u0000\u0000"+
		"\u0560\u0561\u0007\u0004\u0000\u0000\u0561\u00e8\u0001\u0000\u0000\u0000"+
		"\u0562\u0563\u0007\u0007\u0000\u0000\u0563\u0564\u0007\f\u0000\u0000\u0564"+
		"\u0565\u0007\u000b\u0000\u0000\u0565\u00ea\u0001\u0000\u0000\u0000\u0566"+
		"\u0567\u0007\r\u0000\u0000\u0567\u0568\u0007\u000e\u0000\u0000\u0568\u0569"+
		"\u0007\b\u0000\u0000\u0569\u056a\u0007\u0013\u0000\u0000\u056a\u056b\u0007"+
		"\f\u0000\u0000\u056b\u056c\u0007\b\u0000\u0000\u056c\u00ec\u0001\u0000"+
		"\u0000\u0000\u056d\u056e\u0007\t\u0000\u0000\u056e\u056f\u0007\f\u0000"+
		"\u0000\u056f\u0570\u0007\u0007\u0000\u0000\u0570\u00ee\u0001\u0000\u0000"+
		"\u0000\u0571\u0572\u0007\u0007\u0000\u0000\u0572\u0573\u0007\b\u0000\u0000"+
		"\u0573\u0574\u0007\u0003\u0000\u0000\u0574\u0575\u0007\t\u0000\u0000\u0575"+
		"\u00f0\u0001\u0000\u0000\u0000\u0576\u0577\u0007\u0004\u0000\u0000\u0577"+
		"\u0578\u0007\u0003\u0000\u0000\u0578\u0579\u0007\u0007\u0000\u0000\u0579"+
		"\u057a\u0007\u0003\u0000\u0000\u057a\u057b\u0007\u0011\u0000\u0000\u057b"+
		"\u057c\u0007\u0003\u0000\u0000\u057c\u057d\u0007\u0013\u0000\u0000\u057d"+
		"\u057e\u0007\u0005\u0000\u0000\u057e\u00f2\u0001\u0000\u0000\u0000\u057f"+
		"\u0580\u0007\t\u0000\u0000\u0580\u0581\u0007\u000e\u0000\u0000\u0581\u0582"+
		"\u0007\n\u0000\u0000\u0582\u0583\u0007\n\u0000\u0000\u0583\u00f4\u0001"+
		"\u0000\u0000\u0000\u0584\u0585\u0007\u0007\u0000\u0000\u0585\u0586\u0007"+
		"\b\u0000\u0000\u0586\u0587\u0007\u0003\u0000\u0000\u0587\u0588\u0007\t"+
		"\u0000\u0000\u0588\u0589\u0007\u0013\u0000\u0000\u0589\u058a\u0007\u0003"+
		"\u0000\u0000\u058a\u058b\u0007\r\u0000\u0000\u058b\u058c\u0007\u0007\u0000"+
		"\u0000\u058c\u058d\u0007\u0012\u0000\u0000\u058d\u058e\u0007\f\u0000\u0000"+
		"\u058e\u058f\u0007\t\u0000\u0000\u058f\u00f6\u0001\u0000\u0000\u0000\u0590"+
		"\u0591\u0007\u0004\u0000\u0000\u0591\u0592\u0007\u0011\u0000\u0000\u0592"+
		"\u0593\u0007\r\u0000\u0000\u0593\u0594\u0007\r\u0000\u0000\u0594\u00f8"+
		"\u0001\u0000\u0000\u0000\u0595\u0596\u0007\t\u0000\u0000\u0596\u0597\u0007"+
		"\u000e\u0000\u0000\u0597\u0598\u0007\n\u0000\u0000\u0598\u0599\u0007\n"+
		"\u0000\u0000\u0599\u059a\u0007\u0012\u0000\u0000\u059a\u059b\u0007\u000f"+
		"\u0000\u0000\u059b\u00fa\u0001\u0000\u0000\u0000\u059c\u059d\u0007\u0007"+
		"\u0000\u0000\u059d\u059e\u0007\b\u0000\u0000\u059e\u059f\u0007\u0012\u0000"+
		"\u0000\u059f\u05a0\u0007\u0015\u0000\u0000\u05a0\u05a1\u0007\u0015\u0000"+
		"\u0000\u05a1\u05a2\u0007\u0005\u0000\u0000\u05a2\u05a3\u0007\b\u0000\u0000"+
		"\u05a3\u00fc\u0001\u0000\u0000\u0000\u05a4\u05a5\u0007\u0004\u0000\u0000"+
		"\u05a5\u05a6\u0007\u0005\u0000\u0000\u05a6\u05a7\u0007\u0003\u0000\u0000"+
		"\u05a7\u05a8\u0007\n\u0000\u0000\u05a8\u05a9\u0007\n\u0000\u0000\u05a9"+
		"\u05aa\u0007\f\u0000\u0000\u05aa\u05ab\u0007\r\u0000\u0000\u05ab\u05ac"+
		"\u0007\u0003\u0000\u0000\u05ac\u05ad\u0007\u0007\u0000\u0000\u05ad\u05ae"+
		"\u0007\u0005\u0000\u0000\u05ae\u00fe\u0001\u0000\u0000\u0000\u05af\u05b0"+
		"\u0007\f\u0000\u0000\u05b0\u05b1\u0007\u000f\u0000\u0000\u05b1\u0100\u0001"+
		"\u0000\u0000\u0000\u05b2\u05b3\u0007\u0007\u0000\u0000\u05b3\u05b4\u0007"+
		"\b\u0000\u0000\u05b4\u05b5\u0007\u000e\u0000\u0000\u05b5\u05b6\u0007\t"+
		"\u0000\u0000\u05b6\u05b7\u0007\r\u0000\u0000\u05b7\u05b8\u0007\u0003\u0000"+
		"\u0000\u05b8\u05b9\u0007\u0007\u0000\u0000\u05b9\u05ba\u0007\u0005\u0000"+
		"\u0000\u05ba\u0102\u0001\u0000\u0000\u0000\u05bb\u05bc\u0007\u0004\u0000"+
		"\u0000\u05bc\u05bd\u0007\u0005\u0000\u0000\u05bd\u05be\u0007\r\u0000\u0000"+
		"\u05be\u05bf\u0007\n\u0000\u0000\u05bf\u05c0\u0007\u0003\u0000\u0000\u05c0"+
		"\u05c1\u0007\b\u0000\u0000\u05c1\u05c2\u0007\u0005\u0000\u0000\u05c2\u0104"+
		"\u0001\u0000\u0000\u0000\u05c3\u05c4\u0007\f\u0000\u0000\u05c4\u05c5\u0007"+
		"\u000f\u0000\u0000\u05c5\u05c6\u0007\u000f\u0000\u0000\u05c6\u0106\u0001"+
		"\u0000\u0000\u0000\u05c7\u05c8\u0007\u0007\u0000\u0000\u05c8\u05c9\u0007"+
		"\b\u0000\u0000\u05c9\u05ca\u0007\u0014\u0000\u0000\u05ca\u05cb\u0005_"+
		"\u0000\u0000\u05cb\u05cc\u0007\r\u0000\u0000\u05cc\u05cd\u0007\f\u0000"+
		"\u0000\u05cd\u05ce\u0007\t\u0000\u0000\u05ce\u05cf\u0007\u001a\u0000\u0000"+
		"\u05cf\u05d0\u0007\u0005\u0000\u0000\u05d0\u05d1\u0007\b\u0000\u0000\u05d1"+
		"\u05d2\u0007\u0007\u0000\u0000\u05d2\u0108\u0001\u0000\u0000\u0000\u05d3"+
		"\u05d4\u0007\u0004\u0000\u0000\u05d4\u05d5\u0007\u0005\u0000\u0000\u05d5"+
		"\u05d6\u0007\u000f\u0000\u0000\u05d6\u05d7\u0007\u0003\u0000\u0000\u05d7"+
		"\u05d8\u0007\u000e\u0000\u0000\u05d8\u05d9\u0007\n\u0000\u0000\u05d9\u05da"+
		"\u0007\u0007\u0000\u0000\u05da\u010a\u0001\u0000\u0000\u0000\u05db\u05dc"+
		"\u0007\f\u0000\u0000\u05dc\u05dd\u0007\u000f\u0000\u0000\u05dd\u05de\u0007"+
		"\u000f\u0000\u0000\u05de\u05df\u0007\u0013\u0000\u0000\u05df\u05e0\u0007"+
		"\u0005\u0000\u0000\u05e0\u05e1\u0007\u0007\u0000\u0000\u05e1\u05e2\u0007"+
		"\u0013\u0000\u0000\u05e2\u010c\u0001\u0000\u0000\u0000\u05e3\u05e4\u0007"+
		"\u0007\u0000\u0000\u05e4\u05e5\u0007\u0013\u0000\u0000\u05e5\u05e6\u0007"+
		"\u0005\u0000\u0000\u05e6\u05e7\u0007\u001c\u0000\u0000\u05e7\u05e8\u0007"+
		"\u000e\u0000\u0000\u05e8\u05e9\u0007\u0003\u0000\u0000\u05e9\u05ea\u0007"+
		"\n\u0000\u0000\u05ea\u010e\u0001\u0000\u0000\u0000\u05eb\u05ec\u0007\u0004"+
		"\u0000\u0000\u05ec\u05ed\u0007\u0005\u0000\u0000\u05ed\u05ee\u0007\n\u0000"+
		"\u0000\u05ee\u05ef\u0007\u0005\u0000\u0000\u05ef\u05f0\u0007\u0007\u0000"+
		"\u0000\u05f0\u05f1\u0007\u0005\u0000\u0000\u05f1\u0110\u0001\u0000\u0000"+
		"\u0000\u05f2\u05f3\u0007\f\u0000\u0000\u05f3\u05f4\u0007\t\u0000\u0000"+
		"\u05f4\u0112\u0001\u0000\u0000\u0000\u05f5\u05f6\u0007\u000e\u0000\u0000"+
		"\u05f6\u05f7\u0007\t\u0000\u0000\u05f7\u05f8\u0007\u0012\u0000\u0000\u05f8"+
		"\u05f9\u0007\f\u0000\u0000\u05f9\u05fa\u0007\t\u0000\u0000\u05fa\u0114"+
		"\u0001\u0000\u0000\u0000\u05fb\u05fc\u0007\u0004\u0000\u0000\u05fc\u05fd"+
		"\u0007\u0005\u0000\u0000\u05fd\u05fe\u0007\t\u0000\u0000\u05fe\u05ff\u0007"+
		"\u0014\u0000\u0000\u05ff\u0116\u0001\u0000\u0000\u0000\u0600\u0601\u0007"+
		"\f\u0000\u0000\u0601\u0602\u0007\u000b\u0000\u0000\u0602\u0603\u0007\u0005"+
		"\u0000\u0000\u0603\u0604\u0007\t\u0000\u0000\u0604\u0118\u0001\u0000\u0000"+
		"\u0000\u0605\u0606\u0007\u000e\u0000\u0000\u0606\u0607\u0007\t\u0000\u0000"+
		"\u0607\u0608\u0007\u0012\u0000\u0000\u0608\u0609\u0007\u001c\u0000\u0000"+
		"\u0609\u060a\u0007\u000e\u0000\u0000\u060a\u060b\u0007\u0005\u0000\u0000"+
		"\u060b\u011a\u0001\u0000\u0000\u0000\u060c\u060d\u0007\u0004\u0000\u0000"+
		"\u060d\u060e\u0007\u0005\u0000\u0000\u060e\u060f\u0007\u0013\u0000\u0000"+
		"\u060f\u0610\u0007\r\u0000\u0000\u0610\u011c\u0001\u0000\u0000\u0000\u0611"+
		"\u0612\u0007\f\u0000\u0000\u0612\u0613\u0007\u000b\u0000\u0000\u0613\u0614"+
		"\u0007\u0005\u0000\u0000\u0614\u0615\u0007\t\u0000\u0000\u0615\u0616\u0007"+
		"\u0004\u0000\u0000\u0616\u0617\u0007\u0003\u0000\u0000\u0617\u0618\u0007"+
		"\u0007\u0000\u0000\u0618\u0619\u0007\u0003\u0000\u0000\u0619\u061a\u0007"+
		"\u0013\u0000\u0000\u061a\u061b\u0007\f\u0000\u0000\u061b\u061c\u0007\u000e"+
		"\u0000\u0000\u061c\u061d\u0007\b\u0000\u0000\u061d\u061e\u0007\r\u0000"+
		"\u0000\u061e\u061f\u0007\u0005\u0000\u0000\u061f\u011e\u0001\u0000\u0000"+
		"\u0000\u0620\u0621\u0007\u000e\u0000\u0000\u0621\u0622\u0007\u000b\u0000"+
		"\u0000\u0622\u0623\u0007\u0004\u0000\u0000\u0623\u0624\u0007\u0003\u0000"+
		"\u0000\u0624\u0625\u0007\u0007\u0000\u0000\u0625\u0626\u0007\u0005\u0000"+
		"\u0000\u0626\u0120\u0001\u0000\u0000\u0000\u0627\u0628\u0007\u0004\u0000"+
		"\u0000\u0628\u0629\u0007\u0012\u0000\u0000\u0629\u062a\u0007\u0013\u0000"+
		"\u0000\u062a\u062b\u0007\u0017\u0000\u0000\u062b\u0122\u0001\u0000\u0000"+
		"\u0000\u062c\u062d\u0007\f\u0000\u0000\u062d\u062e\u0007\u000b\u0000\u0000"+
		"\u062e\u062f\u0007\u0005\u0000\u0000\u062f\u0630\u0007\t\u0000\u0000\u0630"+
		"\u0631\u0007\u001c\u0000\u0000\u0631\u0632\u0007\u000e\u0000\u0000\u0632"+
		"\u0633\u0007\u0005\u0000\u0000\u0633\u0634\u0007\b\u0000\u0000\u0634\u0635"+
		"\u0007\u0014\u0000\u0000\u0635\u0124\u0001\u0000\u0000\u0000\u0636\u0637"+
		"\u0007\u000e\u0000\u0000\u0637\u0638\u0007\u000b\u0000\u0000\u0638\u0639"+
		"\u0007\u0004\u0000\u0000\u0639\u063a\u0007\u0003\u0000\u0000\u063a\u063b"+
		"\u0007\u0007\u0000\u0000\u063b\u063c\u0007\u0005\u0000\u0000\u063c\u063d"+
		"\u0007\u0007\u0000\u0000\u063d\u063e\u0007\u0005\u0000\u0000\u063e\u063f"+
		"\u0007\u0006\u0000\u0000\u063f\u0640\u0007\u0007\u0000\u0000\u0640\u0126"+
		"\u0001\u0000\u0000\u0000\u0641\u0642\u0007\u0004\u0000\u0000\u0642\u0643"+
		"\u0007\u0012\u0000\u0000\u0643\u0644\u0007\u0013\u0000\u0000\u0644\u0645"+
		"\u0007\u0007\u0000\u0000\u0645\u0646\u0007\u0012\u0000\u0000\u0646\u0647"+
		"\u0007\t\u0000\u0000\u0647\u0648\u0007\r\u0000\u0000\u0648\u0649\u0007"+
		"\u0007\u0000\u0000\u0649\u0128\u0001\u0000\u0000\u0000\u064a\u064b\u0007"+
		"\f\u0000\u0000\u064b\u064c\u0007\u000b\u0000\u0000\u064c\u064d\u0007\u0005"+
		"\u0000\u0000\u064d\u064e\u0007\t\u0000\u0000\u064e\u064f\u0007\b\u0000"+
		"\u0000\u064f\u0650\u0007\f\u0000\u0000\u0650\u0651\u0007\u0019\u0000\u0000"+
		"\u0651\u0652\u0007\u0013\u0000\u0000\u0652\u0653\u0007\u0005\u0000\u0000"+
		"\u0653\u0654\u0007\u0007\u0000\u0000\u0654\u012a\u0001\u0000\u0000\u0000"+
		"\u0655\u0656\u0007\u000e\u0000\u0000\u0656\u0657\u0007\u0013\u0000\u0000"+
		"\u0657\u0658\u0007\u0005\u0000\u0000\u0658\u012c\u0001\u0000\u0000\u0000"+
		"\u0659\u065a\u0007\u0004\u0000\u0000\u065a\u065b\u0007\u0012\u0000\u0000"+
		"\u065b\u065c\u0007\u0013\u0000\u0000\u065c\u065d\u0007\u0007\u0000\u0000"+
		"\u065d\u065e\u0007\b\u0000\u0000\u065e\u065f\u0007\u0012\u0000\u0000\u065f"+
		"\u0660\u0007\u0011\u0000\u0000\u0660\u0661\u0007\u000e\u0000\u0000\u0661"+
		"\u0662\u0007\u0007\u0000\u0000\u0662\u0663\u0007\u0005\u0000\u0000\u0663"+
		"\u0664\u0007\u0004\u0000\u0000\u0664\u012e\u0001\u0000\u0000\u0000\u0665"+
		"\u0666\u0007\f\u0000\u0000\u0666\u0667\u0007\u000b\u0000\u0000\u0667\u0668"+
		"\u0007\u0005\u0000\u0000\u0668\u0669\u0007\t\u0000\u0000\u0669\u066a\u0007"+
		"\u0006\u0000\u0000\u066a\u066b\u0007\u0018\u0000\u0000\u066b\u066c\u0007"+
		"\n\u0000\u0000\u066c\u0130\u0001\u0000\u0000\u0000\u066d\u066e\u0007\u000e"+
		"\u0000\u0000\u066e\u066f\u0007\u0013\u0000\u0000\u066f\u0670\u0007\u0005"+
		"\u0000\u0000\u0670\u0671\u0007\b\u0000\u0000\u0671\u0132\u0001\u0000\u0000"+
		"\u0000\u0672\u0673\u0007\u0004\u0000\u0000\u0673\u0674\u0007\f\u0000\u0000"+
		"\u0674\u0675\u0007\u000e\u0000\u0000\u0675\u0676\u0007\u0011\u0000\u0000"+
		"\u0676\u0677\u0007\n\u0000\u0000\u0677\u0678\u0007\u0005\u0000\u0000\u0678"+
		"\u0134\u0001\u0000\u0000\u0000\u0679\u067a\u0007\f\u0000\u0000\u067a\u067b"+
		"\u0007\u000b\u0000\u0000\u067b\u067c\u0007\u0007\u0000\u0000\u067c\u067d"+
		"\u0007\u0012\u0000\u0000\u067d\u067e\u0007\f\u0000\u0000\u067e\u067f\u0007"+
		"\t\u0000\u0000\u067f\u0136\u0001\u0000\u0000\u0000\u0680\u0681\u0007\u001a"+
		"\u0000\u0000\u0681\u0682\u0007\u0003\u0000\u0000\u0682\u0683\u0007\n\u0000"+
		"\u0000\u0683\u0684\u0007\u000e\u0000\u0000\u0684\u0685\u0007\u0005\u0000"+
		"\u0000\u0685\u0686\u0007\u0013\u0000\u0000\u0686\u0138\u0001\u0000\u0000"+
		"\u0000\u0687\u0688\u0007\u0004\u0000\u0000\u0688\u0689\u0007\b\u0000\u0000"+
		"\u0689\u068a\u0007\f\u0000\u0000\u068a\u068b\u0007\u000b\u0000\u0000\u068b"+
		"\u013a\u0001\u0000\u0000\u0000\u068c\u068d\u0007\f\u0000\u0000\u068d\u068e"+
		"\u0007\b\u0000\u0000\u068e\u013c\u0001\u0000\u0000\u0000\u068f\u0690\u0007"+
		"\u001a\u0000\u0000\u0690\u0691\u0007\u0003\u0000\u0000\u0691\u0692\u0007"+
		"\b\u0000\u0000\u0692\u0693\u0007\u0014\u0000\u0000\u0693\u0694\u0007\u0012"+
		"\u0000\u0000\u0694\u0695\u0007\t\u0000\u0000\u0695\u0696\u0007\u0015\u0000"+
		"\u0000\u0696\u013e\u0001\u0000\u0000\u0000\u0697\u0698\u0007\u0004\u0000"+
		"\u0000\u0698\u0699\u0007\u000e\u0000\u0000\u0699\u069a\u0007\u0018\u0000"+
		"\u0000\u069a\u069b\u0007\u000b\u0000\u0000\u069b\u0140\u0001\u0000\u0000"+
		"\u0000\u069c\u069d\u0007\f\u0000\u0000\u069d\u069e\u0007\b\u0000\u0000"+
		"\u069e\u069f\u0007\u0004\u0000\u0000\u069f\u06a0\u0007\u0005\u0000\u0000"+
		"\u06a0\u06a1\u0007\b\u0000\u0000\u06a1\u0142\u0001\u0000\u0000\u0000\u06a2"+
		"\u06a3\u0007\u001a\u0000\u0000\u06a3\u06a4\u0007\u0012\u0000\u0000\u06a4"+
		"\u06a5\u0007\u0005\u0000\u0000\u06a5\u06a6\u0007\u0019\u0000\u0000\u06a6"+
		"\u0144\u0001\u0000\u0000\u0000\u06a7\u06a8\u0007\u0005\u0000\u0000\u06a8"+
		"\u06a9\u0007\n\u0000\u0000\u06a9\u06aa\u0007\u0013\u0000\u0000\u06aa\u06ab"+
		"\u0007\u0005\u0000\u0000\u06ab\u0146\u0001\u0000\u0000\u0000\u06ac\u06ad"+
		"\u0007\f\u0000\u0000\u06ad\u06ae\u0007\u000e\u0000\u0000\u06ae\u06af\u0007"+
		"\u0007\u0000\u0000\u06af\u06b0\u0007\u0005\u0000\u0000\u06b0\u06b1\u0007"+
		"\b\u0000\u0000\u06b1\u0148\u0001\u0000\u0000\u0000\u06b2\u06b3\u0007\u0019"+
		"\u0000\u0000\u06b3\u06b4\u0007\u0003\u0000\u0000\u06b4\u06b5\u0007\u0012"+
		"\u0000\u0000\u06b5\u06b6\u0007\u0007\u0000\u0000\u06b6\u06b7\u0007\u000f"+
		"\u0000\u0000\u06b7\u06b8\u0007\f\u0000\u0000\u06b8\u06b9\u0007\b\u0000"+
		"\u0000\u06b9\u014a\u0001\u0000\u0000\u0000\u06ba\u06bb\u0007\u0005\u0000"+
		"\u0000\u06bb\u06bc\u0007\t\u0000\u0000\u06bc\u06bd\u0007\u0004\u0000\u0000"+
		"\u06bd\u014c\u0001\u0000\u0000\u0000\u06be\u06bf\u0007\f\u0000\u0000\u06bf"+
		"\u06c0\u0007\u001a\u0000\u0000\u06c0\u06c1\u0007\u0005\u0000\u0000\u06c1"+
		"\u06c2\u0007\b\u0000\u0000\u06c2\u014e\u0001\u0000\u0000\u0000\u06c3\u06c4"+
		"\u0007\u0019\u0000\u0000\u06c4\u06c5\u0007\u0010\u0000\u0000\u06c5\u06c6"+
		"\u0007\u0005\u0000\u0000\u06c6\u06c7\u0007\t\u0000\u0000\u06c7\u0150\u0001"+
		"\u0000\u0000\u0000\u06c8\u06c9\u0007\u0005\u0000\u0000\u06c9\u06ca\u0007"+
		"\b\u0000\u0000\u06ca\u06cb\u0007\b\u0000\u0000\u06cb\u06cc\u0007\n\u0000"+
		"\u0000\u06cc\u06cd\u0007\u001a\u0000\u0000\u06cd\u06ce\u0007\n\u0000\u0000"+
		"\u06ce\u0152\u0001\u0000\u0000\u0000\u06cf\u06d0\u0007\u000b\u0000\u0000"+
		"\u06d0\u06d1\u0007\u0005\u0000\u0000\u06d1\u06d2\u0007\b\u0000\u0000\u06d2"+
		"\u06d3\u0007\r\u0000\u0000\u06d3\u06d4\u0007\u0005\u0000\u0000\u06d4\u06d5"+
		"\u0007\t\u0000\u0000\u06d5\u06d6\u0007\u0007\u0000\u0000\u06d6\u0154\u0001"+
		"\u0000\u0000\u0000\u06d7\u06d8\u0007\u0019\u0000\u0000\u06d8\u06d9\u0007"+
		"\u0010\u0000\u0000\u06d9\u06da\u0007\u0005\u0000\u0000\u06da\u06db\u0007"+
		"\b\u0000\u0000\u06db\u06dc\u0007\u0005\u0000\u0000\u06dc\u0156\u0001\u0000"+
		"\u0000\u0000\u06dd\u06de\u0007\u0005\u0000\u0000\u06de\u06df\u0007\u0013"+
		"\u0000\u0000\u06df\u06e0\u0007\r\u0000\u0000\u06e0\u06e1\u0007\u0003\u0000"+
		"\u0000\u06e1\u06e2\u0007\u000b\u0000\u0000\u06e2\u06e3\u0007\u0005\u0000"+
		"\u0000\u06e3\u0158\u0001\u0000\u0000\u0000\u06e4\u06e5\u0007\u000b\u0000"+
		"\u0000\u06e5\u06e6\u0007\u0012\u0000\u0000\u06e6\u06e7\u0007\u001a\u0000"+
		"\u0000\u06e7\u06e8\u0007\f\u0000\u0000\u06e8\u06e9\u0007\u0007\u0000\u0000"+
		"\u06e9\u015a\u0001\u0000\u0000\u0000\u06ea\u06eb\u0007\u0019\u0000\u0000"+
		"\u06eb\u06ec\u0007\u0010\u0000\u0000\u06ec\u06ed\u0007\u0012\u0000\u0000"+
		"\u06ed\u06ee\u0007\n\u0000\u0000\u06ee\u06ef\u0007\u0005\u0000\u0000\u06ef"+
		"\u015c\u0001\u0000\u0000\u0000\u06f0\u06f1\u0007\u0005\u0000\u0000\u06f1"+
		"\u06f2\u0007\u0006\u0000\u0000\u06f2\u06f3\u0007\r\u0000\u0000\u06f3\u06f4"+
		"\u0007\u0005\u0000\u0000\u06f4\u06f5\u0007\u000b\u0000\u0000\u06f5\u06f6"+
		"\u0007\u0007\u0000\u0000\u06f6\u015e\u0001\u0000\u0000\u0000\u06f7\u06f8"+
		"\u0007\u000b\u0000\u0000\u06f8\u06f9\u0007\n\u0000\u0000\u06f9\u06fa\u0007"+
		"\u0003\u0000\u0000\u06fa\u06fb\u0007\t\u0000\u0000\u06fb\u0160\u0001\u0000"+
		"\u0000\u0000\u06fc\u06fd\u0007\u0019\u0000\u0000\u06fd\u06fe\u0007\u0012"+
		"\u0000\u0000\u06fe\u06ff\u0007\u0007\u0000\u0000\u06ff\u0700\u0007\u0010"+
		"\u0000\u0000\u0700\u0162\u0001\u0000\u0000\u0000\u0701\u0702\u0007\u0005"+
		"\u0000\u0000\u0702\u0703\u0007\u0006\u0000\u0000\u0703\u0704\u0007\u0005"+
		"\u0000\u0000\u0704\u0705\u0007\r\u0000\u0000\u0705\u0164\u0001\u0000\u0000"+
		"\u0000\u0706\u0707\u0007\u000b\u0000\u0000\u0707\u0708\u0007\b\u0000\u0000"+
		"\u0708\u0709\u0007\u0005\u0000\u0000\u0709\u070a\u0007\r\u0000\u0000\u070a"+
		"\u070b\u0007\u0012\u0000\u0000\u070b\u070c\u0007\u0013\u0000\u0000\u070c"+
		"\u070d\u0007\u0012\u0000\u0000\u070d\u070e\u0007\f\u0000\u0000\u070e\u070f"+
		"\u0007\t\u0000\u0000\u070f\u0166\u0001\u0000\u0000\u0000\u0710\u0711\u0007"+
		"\u0019\u0000\u0000\u0711\u0712\u0007\b\u0000\u0000\u0712\u0713\u0007\u0012"+
		"\u0000\u0000\u0713\u0714\u0007\u0007\u0000\u0000\u0714\u0715\u0007\u0005"+
		"\u0000\u0000\u0715\u0716\u0007\u0007\u0000\u0000\u0716\u0717\u0007\u0005"+
		"\u0000\u0000\u0717\u0718\u0007\u0006\u0000\u0000\u0718\u0719\u0007\u0007"+
		"\u0000\u0000\u0719\u0168\u0001\u0000\u0000\u0000\u071a\u071b\u0007\u0005"+
		"\u0000\u0000\u071b\u071c\u0007\u0006\u0000\u0000\u071c\u071d\u0007\u0005"+
		"\u0000\u0000\u071d\u071e\u0007\r\u0000\u0000\u071e\u071f\u0007\u000e\u0000"+
		"\u0000\u071f\u0720\u0007\u0007\u0000\u0000\u0720\u0721\u0007\u0005\u0000"+
		"\u0000\u0721\u016a\u0001\u0000\u0000\u0000\u0722\u0723\u0007\u000b\u0000"+
		"\u0000\u0723\u0724\u0007\b\u0000\u0000\u0724\u0725\u0007\u0012\u0000\u0000"+
		"\u0725\u0726\u0007\u0018\u0000\u0000\u0726\u0727\u0007\u0003\u0000\u0000"+
		"\u0727\u0728\u0007\b\u0000\u0000\u0728\u0729\u0007\u0014\u0000\u0000\u0729"+
		"\u016c\u0001\u0000\u0000\u0000\u072a\u072b\u0007\u0012\u0000\u0000\u072b"+
		"\u072c\u0007\t\u0000\u0000\u072c\u072d\u0007\u0007\u0000\u0000\u072d\u072e"+
		"\u0007\u0005\u0000\u0000\u072e\u072f\u0007\u0015\u0000\u0000\u072f\u0730"+
		"\u0007\u0005\u0000\u0000\u0730\u0731\u0007\b\u0000\u0000\u0731\u016e\u0001"+
		"\u0000\u0000\u0000\u0732\u0733\u0007\t\u0000\u0000\u0733\u0734\u0007\u001a"+
		"\u0000\u0000\u0734\u0735\u0007\u0003\u0000\u0000\u0735\u0736\u0007\b\u0000"+
		"\u0000\u0736\u0737\u0007\r\u0000\u0000\u0737\u0738\u0007\u0010\u0000\u0000"+
		"\u0738\u0739\u0007\u0003\u0000\u0000\u0739\u073a\u0007\b\u0000\u0000\u073a"+
		"\u0170\u0001\u0000\u0000\u0000\u073b\u073c\u0007\u001a\u0000\u0000\u073c"+
		"\u073d\u0007\u0003\u0000\u0000\u073d\u073e\u0007\b\u0000\u0000\u073e\u073f"+
		"\u0007\r\u0000\u0000\u073f\u0740\u0007\u0010\u0000\u0000\u0740\u0741\u0007"+
		"\u0003\u0000\u0000\u0741\u0742\u0007\b\u0000\u0000\u0742\u0172\u0001\u0000"+
		"\u0000\u0000\u0743\u0744\u0007\u0018\u0000\u0000\u0744\u0745\u0007\u0003"+
		"\u0000\u0000\u0745\u0746\u0007\u0006\u0000\u0000\u0746\u0174\u0001\u0000"+
		"\u0000\u0000\u0747\u0748\u0007\u0007\u0000\u0000\u0748\u0749\u0007\b\u0000"+
		"\u0000\u0749\u074a\u0007\u0014\u0000\u0000\u074a\u0176\u0001\u0000\u0000"+
		"\u0000\u074b\u074c\u0007\r\u0000\u0000\u074c\u074d\u0007\u0003\u0000\u0000"+
		"\u074d\u074e\u0007\u0007\u0000\u0000\u074e\u074f\u0007\r\u0000\u0000\u074f"+
		"\u0750\u0007\u0010\u0000\u0000\u0750\u0178\u0001\u0000\u0000\u0000\u0751"+
		"\u0752\u0007\u0005\u0000\u0000\u0752\u0753\u0007\u0006\u0000\u0000\u0753"+
		"\u0754\u0007\u0012\u0000\u0000\u0754\u0755\u0007\u0013\u0000\u0000\u0755"+
		"\u0756\u0007\u0007\u0000\u0000\u0756\u0757\u0007\u0013\u0000\u0000\u0757"+
		"\u017a\u0001\u0000\u0000\u0000\u0758\u075a\u0003\u0001\u0000\u0000\u0759"+
		"\u0758\u0001\u0000\u0000\u0000\u075a\u075b\u0001\u0000\u0000\u0000\u075b"+
		"\u0759\u0001\u0000\u0000\u0000\u075b\u075c\u0001\u0000\u0000\u0000\u075c"+
		"\u017c\u0001\u0000\u0000\u0000\u075d\u075f\u0003\u0001\u0000\u0000\u075e"+
		"\u075d\u0001\u0000\u0000\u0000\u075f\u0760\u0001\u0000\u0000\u0000\u0760"+
		"\u075e\u0001\u0000\u0000\u0000\u0760\u0761\u0001\u0000\u0000\u0000\u0761"+
		"\u0762\u0001\u0000\u0000\u0000\u0762\u0764\u0005.\u0000\u0000\u0763\u0765"+
		"\u0003\u0001\u0000\u0000\u0764\u0763\u0001\u0000\u0000\u0000\u0765\u0766"+
		"\u0001\u0000\u0000\u0000\u0766\u0764\u0001\u0000\u0000\u0000\u0766\u0767"+
		"\u0001\u0000\u0000\u0000\u0767\u017e\u0001\u0000\u0000\u0000\u0768\u0769"+
		"\u00050\u0000\u0000\u0769\u076b\u0007\u0006\u0000\u0000\u076a\u0768\u0001"+
		"\u0000\u0000\u0000\u076b\u076c\u0001\u0000\u0000\u0000\u076c\u076a\u0001"+
		"\u0000\u0000\u0000\u076c\u076d\u0001\u0000\u0000\u0000\u076d\u0180\u0001"+
		"\u0000\u0000\u0000\u076e\u076f\u00050\u0000\u0000\u076f\u0770\u0007\u0011"+
		"\u0000\u0000\u0770\u0772\u0001\u0000\u0000\u0000\u0771\u0773\u0007\u001d"+
		"\u0000\u0000\u0772\u0771\u0001\u0000\u0000\u0000\u0773\u0774\u0001\u0000"+
		"\u0000\u0000\u0774\u0772\u0001\u0000\u0000\u0000\u0774\u0775\u0001\u0000"+
		"\u0000\u0000\u0775\u0182\u0001\u0000\u0000\u0000\u0776\u0777\u0007\u0007"+
		"\u0000\u0000\u0777\u0778\u0007\b\u0000\u0000\u0778\u0779\u0007\u000e\u0000"+
		"\u0000\u0779\u077a\u0007\u0005\u0000\u0000\u077a\u0184\u0001\u0000\u0000"+
		"\u0000\u077b\u077c\u0007\u000f\u0000\u0000\u077c\u077d\u0007\u0003\u0000"+
		"\u0000\u077d\u077e\u0007\n\u0000\u0000\u077e\u077f\u0007\u0013\u0000\u0000"+
		"\u077f\u0780\u0007\u0005\u0000\u0000\u0780\u0186\u0001\u0000\u0000\u0000"+
		"\u0781\u0783\u0007\t\u0000\u0000\u0782\u0781\u0001\u0000\u0000\u0000\u0782"+
		"\u0783\u0001\u0000\u0000\u0000\u0783\u0784\u0001\u0000\u0000\u0000\u0784"+
		"\u079d\u0005\'\u0000\u0000\u0785\u079c\b\u001e\u0000\u0000\u0786\u0787"+
		"\u0005\\\u0000\u0000\u0787\u079c\t\u0000\u0000\u0000\u0788\u0789\u0005"+
		"\'\u0000\u0000\u0789\u079c\u0005\'\u0000\u0000\u078a\u078e\u0005\\\u0000"+
		"\u0000\u078b\u078d\u0007\u001f\u0000\u0000\u078c\u078b\u0001\u0000\u0000"+
		"\u0000\u078d\u0790\u0001\u0000\u0000\u0000\u078e\u078c\u0001\u0000\u0000"+
		"\u0000\u078e\u078f\u0001\u0000\u0000\u0000\u078f\u0792\u0001\u0000\u0000"+
		"\u0000\u0790\u078e\u0001\u0000\u0000\u0000\u0791\u0793\u0005\r\u0000\u0000"+
		"\u0792\u0791\u0001\u0000\u0000\u0000\u0792\u0793\u0001\u0000\u0000\u0000"+
		"\u0793\u0794\u0001\u0000\u0000\u0000\u0794\u0798\u0005\n\u0000\u0000\u0795"+
		"\u0797\u0007\u001f\u0000\u0000\u0796\u0795\u0001\u0000\u0000\u0000\u0797"+
		"\u079a\u0001\u0000\u0000\u0000\u0798\u0796\u0001\u0000\u0000\u0000\u0798"+
		"\u0799\u0001\u0000\u0000\u0000\u0799\u079c\u0001\u0000\u0000\u0000\u079a"+
		"\u0798\u0001\u0000\u0000\u0000\u079b\u0785\u0001\u0000\u0000\u0000\u079b"+
		"\u0786\u0001\u0000\u0000\u0000\u079b\u0788\u0001\u0000\u0000\u0000\u079b"+
		"\u078a\u0001\u0000\u0000\u0000\u079c\u079f\u0001\u0000\u0000\u0000\u079d"+
		"\u079b\u0001\u0000\u0000\u0000\u079d\u079e\u0001\u0000\u0000\u0000\u079e"+
		"\u07a0\u0001\u0000\u0000\u0000\u079f\u079d\u0001\u0000\u0000\u0000\u07a0"+
		"\u07a1\u0005\'\u0000\u0000\u07a1\u07a2\u0006\u00c3\u0000\u0000\u07a2\u0188"+
		"\u0001\u0000\u0000\u0000\u07a3\u07a7\u0005[\u0000\u0000\u07a4\u07a6\b"+
		" \u0000\u0000\u07a5\u07a4\u0001\u0000\u0000\u0000\u07a6\u07a9\u0001\u0000"+
		"\u0000\u0000\u07a7\u07a5\u0001\u0000\u0000\u0000\u07a7\u07a8\u0001\u0000"+
		"\u0000\u0000\u07a8\u07aa\u0001\u0000\u0000\u0000\u07a9\u07a7\u0001\u0000"+
		"\u0000\u0000\u07aa\u07ab\u0005]\u0000\u0000\u07ab\u018a\u0001\u0000\u0000"+
		"\u0000\u07ac\u07b1\u0003\u0003\u0001\u0000\u07ad\u07b0\u0003\u0003\u0001"+
		"\u0000\u07ae\u07b0\u0003\u0001\u0000\u0000\u07af\u07ad\u0001\u0000\u0000"+
		"\u0000\u07af\u07ae\u0001\u0000\u0000\u0000\u07b0\u07b3\u0001\u0000\u0000"+
		"\u0000\u07b1\u07af\u0001\u0000\u0000\u0000\u07b1\u07b2\u0001\u0000\u0000"+
		"\u0000\u07b2\u018c\u0001\u0000\u0000\u0000\u07b3\u07b1\u0001\u0000\u0000"+
		"\u0000\u07b4\u07b5\u0005@\u0000\u0000\u07b5\u07b6\u0003\u018b\u00c5\u0000"+
		"\u07b6\u018e\u0001\u0000\u0000\u0000\u07b7\u07b8\u0005=\u0000\u0000\u07b8"+
		"\u0190\u0001\u0000\u0000\u0000\u07b9\u07ba\u0005<\u0000\u0000\u07ba\u07be"+
		"\u0005>\u0000\u0000\u07bb\u07bc\u0005!\u0000\u0000\u07bc\u07be\u0005="+
		"\u0000\u0000\u07bd\u07b9\u0001\u0000\u0000\u0000\u07bd\u07bb\u0001\u0000"+
		"\u0000\u0000\u07be\u0192\u0001\u0000\u0000\u0000\u07bf\u07c0\u0005>\u0000"+
		"\u0000\u07c0\u0194\u0001\u0000\u0000\u0000\u07c1\u07c2\u0005<\u0000\u0000"+
		"\u07c2\u0196\u0001\u0000\u0000\u0000\u07c3\u07c4\u0005>\u0000\u0000\u07c4"+
		"\u07c5\u0005=\u0000\u0000\u07c5\u0198\u0001\u0000\u0000\u0000\u07c6\u07c7"+
		"\u0005<\u0000\u0000\u07c7\u07c8\u0005=\u0000\u0000\u07c8\u019a\u0001\u0000"+
		"\u0000\u0000\u07c9\u07ca\u0005+\u0000\u0000\u07ca\u019c\u0001\u0000\u0000"+
		"\u0000\u07cb\u07cc\u0005-\u0000\u0000\u07cc\u019e\u0001\u0000\u0000\u0000"+
		"\u07cd\u07ce\u0005*\u0000\u0000\u07ce\u01a0\u0001\u0000\u0000\u0000\u07cf"+
		"\u07d0\u0005/\u0000\u0000\u07d0\u01a2\u0001\u0000\u0000\u0000\u07d1\u07d2"+
		"\u0005+\u0000\u0000\u07d2\u07d3\u0005=\u0000\u0000\u07d3\u01a4\u0001\u0000"+
		"\u0000\u0000\u07d4\u07d5\u0005,\u0000\u0000\u07d5\u01a6\u0001\u0000\u0000"+
		"\u0000\u07d6\u07d7\u0005.\u0000\u0000\u07d7\u01a8\u0001\u0000\u0000\u0000"+
		"\u07d8\u07d9\u0005(\u0000\u0000\u07d9\u01aa\u0001\u0000\u0000\u0000\u07da"+
		"\u07db\u0005)\u0000\u0000\u07db\u01ac\u0001\u0000\u0000\u0000\u07dc\u07dd"+
		"\u0005[\u0000\u0000\u07dd\u01ae\u0001\u0000\u0000\u0000\u07de\u07df\u0005"+
		"]\u0000\u0000\u07df\u01b0\u0001\u0000\u0000\u0000\u07e0\u07e1\u0005;\u0000"+
		"\u0000\u07e1\u01b2\u0001\u0000\u0000\u0000\u07e2\u07e3\u0005-\u0000\u0000"+
		"\u07e3\u07e4\u0005-\u0000\u0000\u07e4\u07e8\u0001\u0000\u0000\u0000\u07e5"+
		"\u07e7\b!\u0000\u0000\u07e6\u07e5\u0001\u0000\u0000\u0000\u07e7\u07ea"+
		"\u0001\u0000\u0000\u0000\u07e8\u07e6\u0001\u0000\u0000\u0000\u07e8\u07e9"+
		"\u0001\u0000\u0000\u0000\u07e9\u07eb\u0001\u0000\u0000\u0000\u07ea\u07e8"+
		"\u0001\u0000\u0000\u0000\u07eb\u07ec\u0006\u00d9\u0001\u0000\u07ec\u01b4"+
		"\u0001\u0000\u0000\u0000\u07ed\u07ee\u0005/\u0000\u0000\u07ee\u07ef\u0005"+
		"*\u0000\u0000\u07ef\u07f4\u0001\u0000\u0000\u0000\u07f0\u07f3\u0003\u01b5"+
		"\u00da\u0000\u07f1\u07f3\t\u0000\u0000\u0000\u07f2\u07f0\u0001\u0000\u0000"+
		"\u0000\u07f2\u07f1\u0001\u0000\u0000\u0000\u07f3\u07f6\u0001\u0000\u0000"+
		"\u0000\u07f4\u07f5\u0001\u0000\u0000\u0000\u07f4\u07f2\u0001\u0000\u0000"+
		"\u0000\u07f5\u07f7\u0001\u0000\u0000\u0000\u07f6\u07f4\u0001\u0000\u0000"+
		"\u0000\u07f7\u07f8\u0005*\u0000\u0000\u07f8\u07f9\u0005/\u0000\u0000\u07f9"+
		"\u07fa\u0001\u0000\u0000\u0000\u07fa\u07fb\u0006\u00da\u0001\u0000\u07fb"+
		"\u01b6\u0001\u0000\u0000\u0000\u07fc\u07fe\u0007\"\u0000\u0000\u07fd\u07fc"+
		"\u0001\u0000\u0000\u0000\u07fe\u07ff\u0001\u0000\u0000\u0000\u07ff\u07fd"+
		"\u0001\u0000\u0000\u0000\u07ff\u0800\u0001\u0000\u0000\u0000\u0800\u0801"+
		"\u0001\u0000\u0000\u0000\u0801\u0802\u0006\u00db\u0001\u0000\u0802\u01b8"+
		"\u0001\u0000\u0000\u0000\u0014\u0000\u075b\u0760\u0766\u076c\u0774\u0782"+
		"\u078e\u0792\u0798\u079b\u079d\u07a7\u07af\u07b1\u07bd\u07e8\u07f2\u07f4"+
		"\u07ff\u0002\u0001\u00c3\u0000\u0006\u0000\u0000";
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
- **Size**: 69.69 KB
- **Extension**: `.py`
- **Language**: `python`
- **Location**: `SqlLexer.py`
- **Relative Path**: `root`
- **Created**: 2025-11-27 05:06:21 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-15 11:20:50 (Asia/Damascus / GMT+03:00)
- **MD5**: `c4a45d787a4daba498840220372d3bda`
- **SHA256**: `a5945bc9308993f504559a80a7e8bf14c92d8fac2e8e26fa220f36298a696bc6`
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
        4,0,217,2051,6,-1,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,
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
        2,219,7,219,1,0,1,0,1,1,1,1,1,2,1,2,1,3,1,3,1,3,1,3,1,4,1,4,1,4,
        1,4,1,4,1,4,1,4,1,4,1,4,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,
        1,6,1,6,1,6,1,6,1,7,1,7,1,7,1,7,1,7,1,7,1,8,1,8,1,8,1,8,1,8,1,8,
        1,8,1,9,1,9,1,9,1,9,1,9,1,9,1,10,1,10,1,10,1,10,1,10,1,11,1,11,1,
        11,1,11,1,11,1,11,1,11,1,11,1,11,1,11,1,12,1,12,1,12,1,12,1,13,1,
        13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,13,1,14,1,14,1,14,1,
        14,1,14,1,15,1,15,1,15,1,15,1,16,1,16,1,16,1,16,1,17,1,17,1,17,1,
        17,1,17,1,17,1,17,1,17,1,17,1,18,1,18,1,18,1,19,1,19,1,19,1,19,1,
        19,1,19,1,19,1,19,1,20,1,20,1,20,1,20,1,20,1,20,1,20,1,20,1,20,1,
        20,1,20,1,20,1,21,1,21,1,21,1,21,1,22,1,22,1,22,1,22,1,22,1,22,1,
        22,1,22,1,22,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,
        23,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,24,1,
        24,1,24,1,25,1,25,1,25,1,25,1,25,1,25,1,25,1,25,1,25,1,25,1,25,1,
        25,1,25,1,25,1,26,1,26,1,26,1,26,1,26,1,26,1,26,1,26,1,26,1,26,1,
        26,1,26,1,27,1,27,1,27,1,27,1,27,1,27,1,27,1,28,1,28,1,28,1,28,1,
        28,1,29,1,29,1,29,1,29,1,29,1,29,1,29,1,29,1,30,1,30,1,30,1,30,1,
        30,1,30,1,31,1,31,1,31,1,31,1,31,1,32,1,32,1,32,1,32,1,32,1,32,1,
        32,1,32,1,32,1,33,1,33,1,33,1,33,1,33,1,33,1,33,1,33,1,34,1,34,1,
        34,1,34,1,34,1,34,1,34,1,34,1,34,1,35,1,35,1,35,1,35,1,35,1,35,1,
        35,1,36,1,36,1,36,1,36,1,36,1,36,1,37,1,37,1,37,1,37,1,37,1,38,1,
        38,1,38,1,38,1,38,1,38,1,38,1,39,1,39,1,39,1,39,1,39,1,39,1,39,1,
        40,1,40,1,40,1,40,1,40,1,40,1,41,1,41,1,41,1,41,1,41,1,41,1,41,1,
        42,1,42,1,42,1,42,1,42,1,43,1,43,1,43,1,43,1,43,1,43,1,44,1,44,1,
        44,1,44,1,44,1,44,1,45,1,45,1,45,1,46,1,46,1,46,1,46,1,46,1,46,1,
        46,1,47,1,47,1,47,1,47,1,47,1,47,1,47,1,47,1,47,1,48,1,48,1,48,1,
        48,1,48,1,48,1,48,1,48,1,49,1,49,1,49,1,49,1,49,1,49,1,49,1,49,1,
        49,1,50,1,50,1,50,1,50,1,50,1,50,1,50,1,50,1,50,1,51,1,51,1,51,1,
        51,1,51,1,52,1,52,1,52,1,52,1,52,1,52,1,52,1,52,1,52,1,53,1,53,1,
        53,1,53,1,53,1,53,1,53,1,53,1,53,1,53,1,53,1,54,1,54,1,54,1,54,1,
        54,1,54,1,55,1,55,1,55,1,55,1,55,1,55,1,55,1,55,1,55,1,55,1,55,1,
        55,1,55,1,55,1,55,1,55,1,56,1,56,1,56,1,56,1,56,1,57,1,57,1,57,1,
        57,1,57,1,57,1,57,1,57,1,57,1,57,1,57,1,58,1,58,1,58,1,58,1,58,1,
        58,1,58,1,58,1,58,1,58,1,58,1,58,1,59,1,59,1,59,1,59,1,59,1,60,1,
        60,1,60,1,60,1,60,1,60,1,61,1,61,1,61,1,62,1,62,1,62,1,62,1,62,1,
        62,1,62,1,63,1,63,1,63,1,63,1,63,1,63,1,63,1,63,1,63,1,63,1,64,1,
        64,1,64,1,65,1,65,1,65,1,65,1,65,1,65,1,65,1,65,1,65,1,65,1,65,1,
        65,1,65,1,65,1,66,1,66,1,66,1,66,1,66,1,66,1,66,1,66,1,66,1,67,1,
        67,1,67,1,67,1,67,1,67,1,68,1,68,1,68,1,68,1,68,1,68,1,68,1,69,1,
        69,1,69,1,69,1,69,1,69,1,69,1,69,1,70,1,70,1,70,1,70,1,70,1,70,1,
        71,1,71,1,71,1,71,1,71,1,71,1,71,1,71,1,71,1,71,1,71,1,71,1,71,1,
        71,1,71,1,71,1,71,1,71,1,71,1,71,1,71,1,71,1,71,1,72,1,72,1,72,1,
        72,1,72,1,72,1,72,1,73,1,73,1,73,1,73,1,73,1,73,1,73,1,74,1,74,1,
        74,1,74,1,74,1,74,1,74,1,74,1,74,1,74,1,74,1,74,1,74,1,74,1,74,1,
        74,1,74,1,74,1,74,1,74,1,74,1,74,1,74,1,74,1,74,1,74,1,74,1,74,1,
        74,1,74,1,74,1,75,1,75,1,75,1,75,1,75,1,75,1,75,1,76,1,76,1,76,1,
        76,1,76,1,76,1,76,1,76,1,76,1,76,1,77,1,77,1,77,1,77,1,77,1,77,1,
        77,1,77,1,77,1,77,1,77,1,77,1,77,1,77,1,77,1,77,1,77,1,77,1,77,1,
        77,1,77,1,77,1,77,1,77,1,78,1,78,1,78,1,78,1,78,1,78,1,78,1,78,1,
        79,1,79,1,79,1,79,1,79,1,80,1,80,1,80,1,80,1,80,1,80,1,80,1,80,1,
        80,1,80,1,80,1,80,1,80,1,81,1,81,1,81,1,81,1,81,1,81,1,81,1,81,1,
        81,1,81,1,81,1,82,1,82,1,82,1,83,1,83,1,83,1,83,1,84,1,84,1,84,1,
        84,1,84,1,84,1,84,1,84,1,84,1,85,1,85,1,85,1,85,1,85,1,86,1,86,1,
        86,1,86,1,86,1,86,1,86,1,86,1,87,1,87,1,87,1,87,1,87,1,87,1,87,1,
        87,1,87,1,87,1,87,1,87,1,87,1,87,1,88,1,88,1,88,1,88,1,89,1,89,1,
        89,1,89,1,89,1,89,1,89,1,89,1,89,1,90,1,90,1,90,1,90,1,90,1,90,1,
        90,1,90,1,90,1,91,1,91,1,91,1,91,1,91,1,92,1,92,1,92,1,92,1,92,1,
        93,1,93,1,93,1,93,1,93,1,93,1,93,1,93,1,94,1,94,1,94,1,94,1,94,1,
        95,1,95,1,95,1,95,1,95,1,95,1,95,1,95,1,95,1,95,1,95,1,96,1,96,1,
        96,1,96,1,96,1,96,1,96,1,97,1,97,1,97,1,97,1,97,1,98,1,98,1,98,1,
        98,1,98,1,98,1,98,1,98,1,98,1,98,1,98,1,98,1,99,1,99,1,99,1,99,1,
        99,1,99,1,100,1,100,1,100,1,100,1,100,1,100,1,100,1,101,1,101,1,
        101,1,101,1,101,1,101,1,102,1,102,1,102,1,102,1,102,1,102,1,102,
        1,102,1,103,1,103,1,103,1,103,1,103,1,104,1,104,1,104,1,104,1,104,
        1,104,1,104,1,104,1,104,1,104,1,104,1,104,1,105,1,105,1,105,1,105,
        1,105,1,105,1,105,1,105,1,105,1,105,1,105,1,105,1,105,1,106,1,106,
        1,106,1,106,1,106,1,106,1,107,1,107,1,107,1,107,1,107,1,107,1,107,
        1,107,1,107,1,108,1,108,1,108,1,108,1,108,1,108,1,108,1,108,1,108,
        1,108,1,108,1,108,1,108,1,109,1,109,1,109,1,109,1,109,1,109,1,109,
        1,109,1,109,1,110,1,110,1,110,1,110,1,110,1,111,1,111,1,111,1,111,
        1,111,1,111,1,111,1,111,1,111,1,111,1,111,1,111,1,111,1,111,1,111,
        1,111,1,111,1,111,1,112,1,112,1,112,1,112,1,112,1,112,1,112,1,112,
        1,113,1,113,1,113,1,114,1,114,1,114,1,114,1,114,1,114,1,114,1,114,
        1,114,1,114,1,114,1,114,1,114,1,115,1,115,1,115,1,115,1,115,1,115,
        1,115,1,115,1,115,1,115,1,115,1,115,1,115,1,116,1,116,1,116,1,116,
        1,117,1,117,1,117,1,117,1,117,1,117,1,117,1,118,1,118,1,118,1,118,
        1,119,1,119,1,119,1,119,1,119,1,120,1,120,1,120,1,120,1,120,1,120,
        1,120,1,120,1,120,1,121,1,121,1,121,1,121,1,121,1,122,1,122,1,122,
        1,122,1,122,1,122,1,122,1,122,1,122,1,122,1,122,1,122,1,123,1,123,
        1,123,1,123,1,123,1,124,1,124,1,124,1,124,1,124,1,124,1,124,1,125,
        1,125,1,125,1,125,1,125,1,125,1,125,1,125,1,126,1,126,1,126,1,126,
        1,126,1,126,1,126,1,126,1,126,1,126,1,126,1,127,1,127,1,127,1,128,
        1,128,1,128,1,128,1,128,1,128,1,128,1,128,1,128,1,129,1,129,1,129,
        1,129,1,129,1,129,1,129,1,129,1,130,1,130,1,130,1,130,1,131,1,131,
        1,131,1,131,1,131,1,131,1,131,1,131,1,131,1,131,1,131,1,131,1,132,
        1,132,1,132,1,132,1,132,1,132,1,132,1,132,1,133,1,133,1,133,1,133,
        1,133,1,133,1,133,1,133,1,134,1,134,1,134,1,134,1,134,1,134,1,134,
        1,134,1,135,1,135,1,135,1,135,1,135,1,135,1,135,1,136,1,136,1,136,
        1,137,1,137,1,137,1,137,1,137,1,137,1,138,1,138,1,138,1,138,1,138,
        1,139,1,139,1,139,1,139,1,139,1,140,1,140,1,140,1,140,1,140,1,140,
        1,140,1,141,1,141,1,141,1,141,1,141,1,142,1,142,1,142,1,142,1,142,
        1,142,1,142,1,142,1,142,1,142,1,142,1,142,1,142,1,142,1,142,1,143,
        1,143,1,143,1,143,1,143,1,143,1,143,1,144,1,144,1,144,1,144,1,144,
        1,145,1,145,1,145,1,145,1,145,1,145,1,145,1,145,1,145,1,145,1,146,
        1,146,1,146,1,146,1,146,1,146,1,146,1,146,1,146,1,146,1,146,1,147,
        1,147,1,147,1,147,1,147,1,147,1,147,1,147,1,147,1,148,1,148,1,148,
        1,148,1,148,1,148,1,148,1,148,1,148,1,148,1,148,1,149,1,149,1,149,
        1,149,1,150,1,150,1,150,1,150,1,150,1,150,1,150,1,150,1,150,1,150,
        1,150,1,150,1,151,1,151,1,151,1,151,1,151,1,151,1,151,1,151,1,152,
        1,152,1,152,1,152,1,152,1,153,1,153,1,153,1,153,1,153,1,153,1,153,
        1,154,1,154,1,154,1,154,1,154,1,154,1,154,1,155,1,155,1,155,1,155,
        1,155,1,155,1,155,1,156,1,156,1,156,1,156,1,156,1,157,1,157,1,157,
        1,158,1,158,1,158,1,158,1,158,1,158,1,158,1,158,1,159,1,159,1,159,
        1,159,1,159,1,160,1,160,1,160,1,160,1,160,1,160,1,161,1,161,1,161,
        1,161,1,161,1,162,1,162,1,162,1,162,1,162,1,163,1,163,1,163,1,163,
        1,163,1,163,1,164,1,164,1,164,1,164,1,164,1,164,1,164,1,164,1,165,
        1,165,1,165,1,165,1,166,1,166,1,166,1,166,1,166,1,167,1,167,1,167,
        1,167,1,167,1,168,1,168,1,168,1,168,1,168,1,168,1,168,1,169,1,169,
        1,169,1,169,1,169,1,169,1,169,1,169,1,170,1,170,1,170,1,170,1,170,
        1,170,1,171,1,171,1,171,1,171,1,171,1,171,1,171,1,172,1,172,1,172,
        1,172,1,172,1,172,1,173,1,173,1,173,1,173,1,173,1,173,1,174,1,174,
        1,174,1,174,1,174,1,174,1,174,1,175,1,175,1,175,1,175,1,175,1,176,
        1,176,1,176,1,176,1,176,1,177,1,177,1,177,1,177,1,177,1,178,1,178,
        1,178,1,178,1,178,1,178,1,178,1,178,1,178,1,178,1,179,1,179,1,179,
        1,179,1,179,1,179,1,179,1,179,1,179,1,179,1,180,1,180,1,180,1,180,
        1,180,1,180,1,180,1,180,1,181,1,181,1,181,1,181,1,181,1,181,1,181,
        1,181,1,182,1,182,1,182,1,182,1,182,1,182,1,182,1,182,1,183,1,183,
        1,183,1,183,1,183,1,183,1,183,1,183,1,183,1,184,1,184,1,184,1,184,
        1,184,1,184,1,184,1,184,1,185,1,185,1,185,1,185,1,186,1,186,1,186,
        1,186,1,187,1,187,1,187,1,187,1,187,1,187,1,188,1,188,1,188,1,188,
        1,188,1,188,1,188,1,189,4,189,1882,8,189,11,189,12,189,1883,1,190,
        4,190,1887,8,190,11,190,12,190,1888,1,190,1,190,4,190,1893,8,190,
        11,190,12,190,1894,1,191,1,191,4,191,1899,8,191,11,191,12,191,1900,
        1,192,1,192,1,192,1,192,4,192,1907,8,192,11,192,12,192,1908,1,193,
        1,193,1,193,1,193,1,193,1,194,1,194,1,194,1,194,1,194,1,194,1,195,
        3,195,1923,8,195,1,195,1,195,1,195,1,195,1,195,1,195,1,195,1,195,
        5,195,1933,8,195,10,195,12,195,1936,9,195,1,195,3,195,1939,8,195,
        1,195,1,195,5,195,1943,8,195,10,195,12,195,1946,9,195,5,195,1948,
        8,195,10,195,12,195,1951,9,195,1,195,1,195,1,195,1,196,1,196,5,196,
        1958,8,196,10,196,12,196,1961,9,196,1,196,1,196,1,197,1,197,1,197,
        5,197,1968,8,197,10,197,12,197,1971,9,197,1,198,1,198,1,198,1,199,
        1,199,1,200,1,200,1,200,1,200,3,200,1982,8,200,1,201,1,201,1,202,
        1,202,1,203,1,203,1,203,1,204,1,204,1,204,1,205,1,205,1,206,1,206,
        1,207,1,207,1,208,1,208,1,209,1,209,1,209,1,210,1,210,1,211,1,211,
        1,212,1,212,1,213,1,213,1,214,1,214,1,215,1,215,1,216,1,216,1,217,
        1,217,1,217,1,217,5,217,2023,8,217,10,217,12,217,2026,9,217,1,217,
        1,217,1,218,1,218,1,218,1,218,1,218,5,218,2035,8,218,10,218,12,218,
        2038,9,218,1,218,1,218,1,218,1,218,1,218,1,219,4,219,2046,8,219,
        11,219,12,219,2047,1,219,1,219,1,2036,0,220,1,0,3,0,5,0,7,1,9,2,
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
        216,439,217,1,0,35,1,0,48,57,3,0,65,90,95,95,97,122,3,0,48,57,65,
        70,97,102,2,0,65,65,97,97,2,0,68,68,100,100,2,0,69,69,101,101,2,
        0,88,88,120,120,2,0,84,84,116,116,2,0,82,82,114,114,2,0,78,78,110,
        110,2,0,76,76,108,108,2,0,80,80,112,112,2,0,79,79,111,111,2,0,67,
        67,99,99,2,0,85,85,117,117,2,0,70,70,102,102,2,0,72,72,104,104,2,
        0,66,66,98,98,2,0,73,73,105,105,2,0,83,83,115,115,2,0,89,89,121,
        121,2,0,71,71,103,103,2,0,90,90,122,122,2,0,75,75,107,107,2,0,77,
        77,109,109,2,0,87,87,119,119,2,0,86,86,118,118,2,0,74,74,106,106,
        2,0,81,81,113,113,1,0,48,49,2,0,39,39,92,92,2,0,9,9,32,32,3,0,10,
        10,13,13,93,93,2,0,10,10,13,13,3,0,9,10,13,13,32,32,2068,0,7,1,0,
        0,0,0,9,1,0,0,0,0,11,1,0,0,0,0,13,1,0,0,0,0,15,1,0,0,0,0,17,1,0,
        0,0,0,19,1,0,0,0,0,21,1,0,0,0,0,23,1,0,0,0,0,25,1,0,0,0,0,27,1,0,
        0,0,0,29,1,0,0,0,0,31,1,0,0,0,0,33,1,0,0,0,0,35,1,0,0,0,0,37,1,0,
        0,0,0,39,1,0,0,0,0,41,1,0,0,0,0,43,1,0,0,0,0,45,1,0,0,0,0,47,1,0,
        0,0,0,49,1,0,0,0,0,51,1,0,0,0,0,53,1,0,0,0,0,55,1,0,0,0,0,57,1,0,
        0,0,0,59,1,0,0,0,0,61,1,0,0,0,0,63,1,0,0,0,0,65,1,0,0,0,0,67,1,0,
        0,0,0,69,1,0,0,0,0,71,1,0,0,0,0,73,1,0,0,0,0,75,1,0,0,0,0,77,1,0,
        0,0,0,79,1,0,0,0,0,81,1,0,0,0,0,83,1,0,0,0,0,85,1,0,0,0,0,87,1,0,
        0,0,0,89,1,0,0,0,0,91,1,0,0,0,0,93,1,0,0,0,0,95,1,0,0,0,0,97,1,0,
        0,0,0,99,1,0,0,0,0,101,1,0,0,0,0,103,1,0,0,0,0,105,1,0,0,0,0,107,
        1,0,0,0,0,109,1,0,0,0,0,111,1,0,0,0,0,113,1,0,0,0,0,115,1,0,0,0,
        0,117,1,0,0,0,0,119,1,0,0,0,0,121,1,0,0,0,0,123,1,0,0,0,0,125,1,
        0,0,0,0,127,1,0,0,0,0,129,1,0,0,0,0,131,1,0,0,0,0,133,1,0,0,0,0,
        135,1,0,0,0,0,137,1,0,0,0,0,139,1,0,0,0,0,141,1,0,0,0,0,143,1,0,
        0,0,0,145,1,0,0,0,0,147,1,0,0,0,0,149,1,0,0,0,0,151,1,0,0,0,0,153,
        1,0,0,0,0,155,1,0,0,0,0,157,1,0,0,0,0,159,1,0,0,0,0,161,1,0,0,0,
        0,163,1,0,0,0,0,165,1,0,0,0,0,167,1,0,0,0,0,169,1,0,0,0,0,171,1,
        0,0,0,0,173,1,0,0,0,0,175,1,0,0,0,0,177,1,0,0,0,0,179,1,0,0,0,0,
        181,1,0,0,0,0,183,1,0,0,0,0,185,1,0,0,0,0,187,1,0,0,0,0,189,1,0,
        0,0,0,191,1,0,0,0,0,193,1,0,0,0,0,195,1,0,0,0,0,197,1,0,0,0,0,199,
        1,0,0,0,0,201,1,0,0,0,0,203,1,0,0,0,0,205,1,0,0,0,0,207,1,0,0,0,
        0,209,1,0,0,0,0,211,1,0,0,0,0,213,1,0,0,0,0,215,1,0,0,0,0,217,1,
        0,0,0,0,219,1,0,0,0,0,221,1,0,0,0,0,223,1,0,0,0,0,225,1,0,0,0,0,
        227,1,0,0,0,0,229,1,0,0,0,0,231,1,0,0,0,0,233,1,0,0,0,0,235,1,0,
        0,0,0,237,1,0,0,0,0,239,1,0,0,0,0,241,1,0,0,0,0,243,1,0,0,0,0,245,
        1,0,0,0,0,247,1,0,0,0,0,249,1,0,0,0,0,251,1,0,0,0,0,253,1,0,0,0,
        0,255,1,0,0,0,0,257,1,0,0,0,0,259,1,0,0,0,0,261,1,0,0,0,0,263,1,
        0,0,0,0,265,1,0,0,0,0,267,1,0,0,0,0,269,1,0,0,0,0,271,1,0,0,0,0,
        273,1,0,0,0,0,275,1,0,0,0,0,277,1,0,0,0,0,279,1,0,0,0,0,281,1,0,
        0,0,0,283,1,0,0,0,0,285,1,0,0,0,0,287,1,0,0,0,0,289,1,0,0,0,0,291,
        1,0,0,0,0,293,1,0,0,0,0,295,1,0,0,0,0,297,1,0,0,0,0,299,1,0,0,0,
        0,301,1,0,0,0,0,303,1,0,0,0,0,305,1,0,0,0,0,307,1,0,0,0,0,309,1,
        0,0,0,0,311,1,0,0,0,0,313,1,0,0,0,0,315,1,0,0,0,0,317,1,0,0,0,0,
        319,1,0,0,0,0,321,1,0,0,0,0,323,1,0,0,0,0,325,1,0,0,0,0,327,1,0,
        0,0,0,329,1,0,0,0,0,331,1,0,0,0,0,333,1,0,0,0,0,335,1,0,0,0,0,337,
        1,0,0,0,0,339,1,0,0,0,0,341,1,0,0,0,0,343,1,0,0,0,0,345,1,0,0,0,
        0,347,1,0,0,0,0,349,1,0,0,0,0,351,1,0,0,0,0,353,1,0,0,0,0,355,1,
        0,0,0,0,357,1,0,0,0,0,359,1,0,0,0,0,361,1,0,0,0,0,363,1,0,0,0,0,
        365,1,0,0,0,0,367,1,0,0,0,0,369,1,0,0,0,0,371,1,0,0,0,0,373,1,0,
        0,0,0,375,1,0,0,0,0,377,1,0,0,0,0,379,1,0,0,0,0,381,1,0,0,0,0,383,
        1,0,0,0,0,385,1,0,0,0,0,387,1,0,0,0,0,389,1,0,0,0,0,391,1,0,0,0,
        0,393,1,0,0,0,0,395,1,0,0,0,0,397,1,0,0,0,0,399,1,0,0,0,0,401,1,
        0,0,0,0,403,1,0,0,0,0,405,1,0,0,0,0,407,1,0,0,0,0,409,1,0,0,0,0,
        411,1,0,0,0,0,413,1,0,0,0,0,415,1,0,0,0,0,417,1,0,0,0,0,419,1,0,
        0,0,0,421,1,0,0,0,0,423,1,0,0,0,0,425,1,0,0,0,0,427,1,0,0,0,0,429,
        1,0,0,0,0,431,1,0,0,0,0,433,1,0,0,0,0,435,1,0,0,0,0,437,1,0,0,0,
        0,439,1,0,0,0,1,441,1,0,0,0,3,443,1,0,0,0,5,445,1,0,0,0,7,447,1,
        0,0,0,9,451,1,0,0,0,11,460,1,0,0,0,13,470,1,0,0,0,15,474,1,0,0,0,
        17,480,1,0,0,0,19,487,1,0,0,0,21,493,1,0,0,0,23,498,1,0,0,0,25,508,
        1,0,0,0,27,512,1,0,0,0,29,523,1,0,0,0,31,528,1,0,0,0,33,532,1,0,
        0,0,35,536,1,0,0,0,37,545,1,0,0,0,39,548,1,0,0,0,41,556,1,0,0,0,
        43,568,1,0,0,0,45,572,1,0,0,0,47,581,1,0,0,0,49,592,1,0,0,0,51,606,
        1,0,0,0,53,620,1,0,0,0,55,632,1,0,0,0,57,639,1,0,0,0,59,644,1,0,
        0,0,61,652,1,0,0,0,63,658,1,0,0,0,65,663,1,0,0,0,67,672,1,0,0,0,
        69,680,1,0,0,0,71,689,1,0,0,0,73,696,1,0,0,0,75,702,1,0,0,0,77,707,
        1,0,0,0,79,714,1,0,0,0,81,721,1,0,0,0,83,727,1,0,0,0,85,734,1,0,
        0,0,87,739,1,0,0,0,89,745,1,0,0,0,91,751,1,0,0,0,93,754,1,0,0,0,
        95,761,1,0,0,0,97,770,1,0,0,0,99,778,1,0,0,0,101,787,1,0,0,0,103,
        796,1,0,0,0,105,801,1,0,0,0,107,810,1,0,0,0,109,821,1,0,0,0,111,
        827,1,0,0,0,113,843,1,0,0,0,115,848,1,0,0,0,117,859,1,0,0,0,119,
        871,1,0,0,0,121,876,1,0,0,0,123,882,1,0,0,0,125,885,1,0,0,0,127,
        892,1,0,0,0,129,902,1,0,0,0,131,905,1,0,0,0,133,919,1,0,0,0,135,
        928,1,0,0,0,137,934,1,0,0,0,139,941,1,0,0,0,141,949,1,0,0,0,143,
        955,1,0,0,0,145,978,1,0,0,0,147,985,1,0,0,0,149,992,1,0,0,0,151,
        1023,1,0,0,0,153,1030,1,0,0,0,155,1040,1,0,0,0,157,1064,1,0,0,0,
        159,1072,1,0,0,0,161,1077,1,0,0,0,163,1090,1,0,0,0,165,1101,1,0,
        0,0,167,1104,1,0,0,0,169,1108,1,0,0,0,171,1117,1,0,0,0,173,1122,
        1,0,0,0,175,1130,1,0,0,0,177,1144,1,0,0,0,179,1148,1,0,0,0,181,1157,
        1,0,0,0,183,1166,1,0,0,0,185,1171,1,0,0,0,187,1176,1,0,0,0,189,1184,
        1,0,0,0,191,1189,1,0,0,0,193,1200,1,0,0,0,195,1207,1,0,0,0,197,1212,
        1,0,0,0,199,1224,1,0,0,0,201,1230,1,0,0,0,203,1237,1,0,0,0,205,1243,
        1,0,0,0,207,1251,1,0,0,0,209,1256,1,0,0,0,211,1268,1,0,0,0,213,1281,
        1,0,0,0,215,1287,1,0,0,0,217,1296,1,0,0,0,219,1309,1,0,0,0,221,1318,
        1,0,0,0,223,1323,1,0,0,0,225,1341,1,0,0,0,227,1349,1,0,0,0,229,1352,
        1,0,0,0,231,1365,1,0,0,0,233,1378,1,0,0,0,235,1382,1,0,0,0,237,1389,
        1,0,0,0,239,1393,1,0,0,0,241,1398,1,0,0,0,243,1407,1,0,0,0,245,1412,
        1,0,0,0,247,1424,1,0,0,0,249,1429,1,0,0,0,251,1436,1,0,0,0,253,1444,
        1,0,0,0,255,1455,1,0,0,0,257,1458,1,0,0,0,259,1467,1,0,0,0,261,1475,
        1,0,0,0,263,1479,1,0,0,0,265,1491,1,0,0,0,267,1499,1,0,0,0,269,1507,
        1,0,0,0,271,1515,1,0,0,0,273,1522,1,0,0,0,275,1525,1,0,0,0,277,1531,
        1,0,0,0,279,1536,1,0,0,0,281,1541,1,0,0,0,283,1548,1,0,0,0,285,1553,
        1,0,0,0,287,1568,1,0,0,0,289,1575,1,0,0,0,291,1580,1,0,0,0,293,1590,
        1,0,0,0,295,1601,1,0,0,0,297,1610,1,0,0,0,299,1621,1,0,0,0,301,1625,
        1,0,0,0,303,1637,1,0,0,0,305,1645,1,0,0,0,307,1650,1,0,0,0,309,1657,
        1,0,0,0,311,1664,1,0,0,0,313,1671,1,0,0,0,315,1676,1,0,0,0,317,1679,
        1,0,0,0,319,1687,1,0,0,0,321,1692,1,0,0,0,323,1698,1,0,0,0,325,1703,
        1,0,0,0,327,1708,1,0,0,0,329,1714,1,0,0,0,331,1722,1,0,0,0,333,1726,
        1,0,0,0,335,1731,1,0,0,0,337,1736,1,0,0,0,339,1743,1,0,0,0,341,1751,
        1,0,0,0,343,1757,1,0,0,0,345,1764,1,0,0,0,347,1770,1,0,0,0,349,1776,
        1,0,0,0,351,1783,1,0,0,0,353,1788,1,0,0,0,355,1793,1,0,0,0,357,1798,
        1,0,0,0,359,1808,1,0,0,0,361,1818,1,0,0,0,363,1826,1,0,0,0,365,1834,
        1,0,0,0,367,1842,1,0,0,0,369,1851,1,0,0,0,371,1859,1,0,0,0,373,1863,
        1,0,0,0,375,1867,1,0,0,0,377,1873,1,0,0,0,379,1881,1,0,0,0,381,1886,
        1,0,0,0,383,1898,1,0,0,0,385,1902,1,0,0,0,387,1910,1,0,0,0,389,1915,
        1,0,0,0,391,1922,1,0,0,0,393,1955,1,0,0,0,395,1964,1,0,0,0,397,1972,
        1,0,0,0,399,1975,1,0,0,0,401,1981,1,0,0,0,403,1983,1,0,0,0,405,1985,
        1,0,0,0,407,1987,1,0,0,0,409,1990,1,0,0,0,411,1993,1,0,0,0,413,1995,
        1,0,0,0,415,1997,1,0,0,0,417,1999,1,0,0,0,419,2001,1,0,0,0,421,2004,
        1,0,0,0,423,2006,1,0,0,0,425,2008,1,0,0,0,427,2010,1,0,0,0,429,2012,
        1,0,0,0,431,2014,1,0,0,0,433,2016,1,0,0,0,435,2018,1,0,0,0,437,2029,
        1,0,0,0,439,2045,1,0,0,0,441,442,7,0,0,0,442,2,1,0,0,0,443,444,7,
        1,0,0,444,4,1,0,0,0,445,446,7,2,0,0,446,6,1,0,0,0,447,448,7,3,0,
        0,448,449,7,4,0,0,449,450,7,4,0,0,450,8,1,0,0,0,451,452,7,5,0,0,
        452,453,7,6,0,0,453,454,7,7,0,0,454,455,7,5,0,0,455,456,7,8,0,0,
        456,457,7,9,0,0,457,458,7,3,0,0,458,459,7,10,0,0,459,10,1,0,0,0,
        460,461,7,11,0,0,461,462,7,8,0,0,462,463,7,12,0,0,463,464,7,13,0,
        0,464,465,7,5,0,0,465,466,7,4,0,0,466,467,7,14,0,0,467,468,7,8,0,
        0,468,469,7,5,0,0,469,12,1,0,0,0,470,471,7,3,0,0,471,472,7,10,0,
        0,472,473,7,10,0,0,473,14,1,0,0,0,474,475,7,15,0,0,475,476,7,5,0,
        0,476,477,7,7,0,0,477,478,7,13,0,0,478,479,7,16,0,0,479,16,1,0,0,
        0,480,481,7,11,0,0,481,482,7,14,0,0,482,483,7,17,0,0,483,484,7,10,
        0,0,484,485,7,18,0,0,485,486,7,13,0,0,486,18,1,0,0,0,487,488,7,3,
        0,0,488,489,7,10,0,0,489,490,7,7,0,0,490,491,7,5,0,0,491,492,7,8,
        0,0,492,20,1,0,0,0,493,494,7,15,0,0,494,495,7,18,0,0,495,496,7,10,
        0,0,496,497,7,5,0,0,497,22,1,0,0,0,498,499,7,8,0,0,499,500,7,3,0,
        0,500,501,7,18,0,0,501,502,7,19,0,0,502,503,7,5,0,0,503,504,7,8,
        0,0,504,505,7,8,0,0,505,506,7,12,0,0,506,507,7,8,0,0,507,24,1,0,
        0,0,508,509,7,3,0,0,509,510,7,9,0,0,510,511,7,4,0,0,511,26,1,0,0,
        0,512,513,7,15,0,0,513,514,7,18,0,0,514,515,7,10,0,0,515,516,7,10,
        0,0,516,517,7,15,0,0,517,518,7,3,0,0,518,519,7,13,0,0,519,520,7,
        7,0,0,520,521,7,12,0,0,521,522,7,8,0,0,522,28,1,0,0,0,523,524,7,
        8,0,0,524,525,7,5,0,0,525,526,7,3,0,0,526,527,7,4,0,0,527,30,1,0,
        0,0,528,529,7,3,0,0,529,530,7,9,0,0,530,531,7,20,0,0,531,32,1,0,
        0,0,532,533,7,15,0,0,533,534,7,12,0,0,534,535,7,8,0,0,535,34,1,0,
        0,0,536,537,7,8,0,0,537,538,7,5,0,0,538,539,7,3,0,0,539,540,7,4,
        0,0,540,541,7,7,0,0,541,542,7,5,0,0,542,543,7,6,0,0,543,544,7,7,
        0,0,544,36,1,0,0,0,545,546,7,3,0,0,546,547,7,19,0,0,547,38,1,0,0,
        0,548,549,7,15,0,0,549,550,7,12,0,0,550,551,7,8,0,0,551,552,7,5,
        0,0,552,553,7,18,0,0,553,554,7,21,0,0,554,555,7,9,0,0,555,40,1,0,
        0,0,556,557,7,8,0,0,557,558,7,5,0,0,558,559,7,13,0,0,559,560,7,12,
        0,0,560,561,7,9,0,0,561,562,7,15,0,0,562,563,7,18,0,0,563,564,7,
        21,0,0,564,565,7,14,0,0,565,566,7,8,0,0,566,567,7,5,0,0,567,42,1,
        0,0,0,568,569,7,3,0,0,569,570,7,19,0,0,570,571,7,13,0,0,571,44,1,
        0,0,0,572,573,7,15,0,0,573,574,7,8,0,0,574,575,7,5,0,0,575,576,7,
        5,0,0,576,577,7,7,0,0,577,578,7,5,0,0,578,579,7,6,0,0,579,580,7,
        7,0,0,580,46,1,0,0,0,581,582,7,8,0,0,582,583,7,5,0,0,583,584,7,15,
        0,0,584,585,7,5,0,0,585,586,7,8,0,0,586,587,7,5,0,0,587,588,7,9,
        0,0,588,589,7,13,0,0,589,590,7,5,0,0,590,591,7,19,0,0,591,48,1,0,
        0,0,592,593,7,3,0,0,593,594,7,14,0,0,594,595,7,7,0,0,595,596,7,16,
        0,0,596,597,7,12,0,0,597,598,7,8,0,0,598,599,7,18,0,0,599,600,7,
        22,0,0,600,601,7,3,0,0,601,602,7,7,0,0,602,603,7,18,0,0,603,604,
        7,12,0,0,604,605,7,9,0,0,605,50,1,0,0,0,606,607,7,15,0,0,607,608,
        7,8,0,0,608,609,7,5,0,0,609,610,7,5,0,0,610,611,7,7,0,0,611,612,
        7,5,0,0,612,613,7,6,0,0,613,614,7,7,0,0,614,615,7,7,0,0,615,616,
        7,3,0,0,616,617,7,17,0,0,617,618,7,10,0,0,618,619,7,5,0,0,619,52,
        1,0,0,0,620,621,7,8,0,0,621,622,7,5,0,0,622,623,7,11,0,0,623,624,
        7,10,0,0,624,625,7,18,0,0,625,626,7,13,0,0,626,627,7,3,0,0,627,628,
        7,7,0,0,628,629,7,18,0,0,629,630,7,12,0,0,630,631,7,9,0,0,631,54,
        1,0,0,0,632,633,7,17,0,0,633,634,7,3,0,0,634,635,7,13,0,0,635,636,
        7,23,0,0,636,637,7,14,0,0,637,638,7,11,0,0,638,56,1,0,0,0,639,640,
        7,15,0,0,640,641,7,8,0,0,641,642,7,12,0,0,642,643,7,24,0,0,643,58,
        1,0,0,0,644,645,7,8,0,0,645,646,7,5,0,0,646,647,7,19,0,0,647,648,
        7,7,0,0,648,649,7,12,0,0,649,650,7,8,0,0,650,651,7,5,0,0,651,60,
        1,0,0,0,652,653,7,17,0,0,653,654,7,5,0,0,654,655,7,21,0,0,655,656,
        7,18,0,0,656,657,7,9,0,0,657,62,1,0,0,0,658,659,7,15,0,0,659,660,
        7,14,0,0,660,661,7,10,0,0,661,662,7,10,0,0,662,64,1,0,0,0,663,664,
        7,8,0,0,664,665,7,5,0,0,665,666,7,19,0,0,666,667,7,7,0,0,667,668,
        7,8,0,0,668,669,7,18,0,0,669,670,7,13,0,0,670,671,7,7,0,0,671,66,
        1,0,0,0,672,673,7,17,0,0,673,674,7,5,0,0,674,675,7,7,0,0,675,676,
        7,25,0,0,676,677,7,5,0,0,677,678,7,5,0,0,678,679,7,9,0,0,679,68,
        1,0,0,0,680,681,7,15,0,0,681,682,7,14,0,0,682,683,7,9,0,0,683,684,
        7,13,0,0,684,685,7,7,0,0,685,686,7,18,0,0,686,687,7,12,0,0,687,688,
        7,9,0,0,688,70,1,0,0,0,689,690,7,8,0,0,690,691,7,5,0,0,691,692,7,
        7,0,0,692,693,7,14,0,0,693,694,7,8,0,0,694,695,7,9,0,0,695,72,1,
        0,0,0,696,697,7,17,0,0,697,698,7,8,0,0,698,699,7,5,0,0,699,700,7,
        3,0,0,700,701,7,23,0,0,701,74,1,0,0,0,702,703,7,21,0,0,703,704,7,
        12,0,0,704,705,7,7,0,0,705,706,7,12,0,0,706,76,1,0,0,0,707,708,7,
        8,0,0,708,709,7,5,0,0,709,710,7,26,0,0,710,711,7,5,0,0,711,712,7,
        8,0,0,712,713,7,7,0,0,713,78,1,0,0,0,714,715,7,17,0,0,715,716,7,
        8,0,0,716,717,7,12,0,0,717,718,7,25,0,0,718,719,7,19,0,0,719,720,
        7,5,0,0,720,80,1,0,0,0,721,722,7,21,0,0,722,723,7,8,0,0,723,724,
        7,3,0,0,724,725,7,9,0,0,725,726,7,7,0,0,726,82,1,0,0,0,727,728,7,
        8,0,0,728,729,7,5,0,0,729,730,7,26,0,0,730,731,7,12,0,0,731,732,
        7,23,0,0,732,733,7,5,0,0,733,84,1,0,0,0,734,735,7,17,0,0,735,736,
        7,14,0,0,736,737,7,10,0,0,737,738,7,23,0,0,738,86,1,0,0,0,739,740,
        7,21,0,0,740,741,7,8,0,0,741,742,7,12,0,0,742,743,7,14,0,0,743,744,
        7,11,0,0,744,88,1,0,0,0,745,746,7,8,0,0,746,747,7,18,0,0,747,748,
        7,21,0,0,748,749,7,16,0,0,749,750,7,7,0,0,750,90,1,0,0,0,751,752,
        7,17,0,0,752,753,7,20,0,0,753,92,1,0,0,0,754,755,7,16,0,0,755,756,
        7,3,0,0,756,757,7,26,0,0,757,758,7,18,0,0,758,759,7,9,0,0,759,760,
        7,21,0,0,760,94,1,0,0,0,761,762,7,8,0,0,762,763,7,12,0,0,763,764,
        7,10,0,0,764,765,7,10,0,0,765,766,7,17,0,0,766,767,7,3,0,0,767,768,
        7,13,0,0,768,769,7,23,0,0,769,96,1,0,0,0,770,771,7,13,0,0,771,772,
        7,3,0,0,772,773,7,19,0,0,773,774,7,13,0,0,774,775,7,3,0,0,775,776,
        7,4,0,0,776,777,7,5,0,0,777,98,1,0,0,0,778,779,7,16,0,0,779,780,
        7,12,0,0,780,781,7,10,0,0,781,782,7,4,0,0,782,783,7,10,0,0,783,784,
        7,12,0,0,784,785,7,13,0,0,785,786,7,23,0,0,786,100,1,0,0,0,787,788,
        7,8,0,0,788,789,7,12,0,0,789,790,7,25,0,0,790,791,7,13,0,0,791,792,
        7,12,0,0,792,793,7,14,0,0,793,794,7,9,0,0,794,795,7,7,0,0,795,102,
        1,0,0,0,796,797,7,13,0,0,797,798,7,3,0,0,798,799,7,19,0,0,799,800,
        7,5,0,0,800,104,1,0,0,0,801,802,7,18,0,0,802,803,7,4,0,0,803,804,
        7,5,0,0,804,805,7,9,0,0,805,806,7,7,0,0,806,807,7,18,0,0,807,808,
        7,7,0,0,808,809,7,20,0,0,809,106,1,0,0,0,810,811,7,8,0,0,811,812,
        7,12,0,0,812,813,7,25,0,0,813,814,7,21,0,0,814,815,7,14,0,0,815,
        816,7,18,0,0,816,817,7,4,0,0,817,818,7,13,0,0,818,819,7,12,0,0,819,
        820,7,10,0,0,820,108,1,0,0,0,821,822,7,13,0,0,822,823,7,16,0,0,823,
        824,7,5,0,0,824,825,7,13,0,0,825,826,7,23,0,0,826,110,1,0,0,0,827,
        828,7,18,0,0,828,829,7,4,0,0,829,830,7,5,0,0,830,831,7,9,0,0,831,
        832,7,7,0,0,832,833,7,18,0,0,833,834,7,7,0,0,834,835,7,20,0,0,835,
        836,5,95,0,0,836,837,7,18,0,0,837,838,7,9,0,0,838,839,7,19,0,0,839,
        840,7,5,0,0,840,841,7,8,0,0,841,842,7,7,0,0,842,112,1,0,0,0,843,
        844,7,8,0,0,844,845,7,14,0,0,845,846,7,10,0,0,846,847,7,5,0,0,847,
        114,1,0,0,0,848,849,7,13,0,0,849,850,7,16,0,0,850,851,7,5,0,0,851,
        852,7,13,0,0,852,853,7,23,0,0,853,854,7,11,0,0,854,855,7,12,0,0,
        855,856,7,18,0,0,856,857,7,9,0,0,857,858,7,7,0,0,858,116,1,0,0,0,
        859,860,7,18,0,0,860,861,7,4,0,0,861,862,7,5,0,0,862,863,7,9,0,0,
        863,864,7,7,0,0,864,865,7,18,0,0,865,866,7,7,0,0,866,867,7,20,0,
        0,867,868,7,13,0,0,868,869,7,12,0,0,869,870,7,10,0,0,870,118,1,0,
        0,0,871,872,7,19,0,0,872,873,7,3,0,0,873,874,7,26,0,0,874,875,7,
        5,0,0,875,120,1,0,0,0,876,877,7,13,0,0,877,878,7,10,0,0,878,879,
        7,12,0,0,879,880,7,19,0,0,880,881,7,5,0,0,881,122,1,0,0,0,882,883,
        7,18,0,0,883,884,7,15,0,0,884,124,1,0,0,0,885,886,7,19,0,0,886,887,
        7,13,0,0,887,888,7,16,0,0,888,889,7,5,0,0,889,890,7,24,0,0,890,891,
        7,3,0,0,891,126,1,0,0,0,892,893,7,13,0,0,893,894,7,10,0,0,894,895,
        7,14,0,0,895,896,7,19,0,0,896,897,7,7,0,0,897,898,7,5,0,0,898,899,
        7,8,0,0,899,900,7,5,0,0,900,901,7,4,0,0,901,128,1,0,0,0,902,903,
        7,18,0,0,903,904,7,9,0,0,904,130,1,0,0,0,905,906,7,19,0,0,906,907,
        7,5,0,0,907,908,7,13,0,0,908,909,7,14,0,0,909,910,7,8,0,0,910,911,
        7,18,0,0,911,912,7,7,0,0,912,913,7,20,0,0,913,914,7,3,0,0,914,915,
        7,14,0,0,915,916,7,4,0,0,916,917,7,18,0,0,917,918,7,7,0,0,918,132,
        1,0,0,0,919,920,7,13,0,0,920,921,7,12,0,0,921,922,7,3,0,0,922,923,
        7,10,0,0,923,924,7,5,0,0,924,925,7,19,0,0,925,926,7,13,0,0,926,927,
        7,5,0,0,927,134,1,0,0,0,928,929,7,18,0,0,929,930,7,9,0,0,930,931,
        7,4,0,0,931,932,7,5,0,0,932,933,7,6,0,0,933,136,1,0,0,0,934,935,
        7,19,0,0,935,936,7,5,0,0,936,937,7,10,0,0,937,938,7,5,0,0,938,939,
        7,13,0,0,939,940,7,7,0,0,940,138,1,0,0,0,941,942,7,13,0,0,942,943,
        7,12,0,0,943,944,7,10,0,0,944,945,7,10,0,0,945,946,7,3,0,0,946,947,
        7,7,0,0,947,948,7,5,0,0,948,140,1,0,0,0,949,950,7,18,0,0,950,951,
        7,9,0,0,951,952,7,9,0,0,952,953,7,5,0,0,953,954,7,8,0,0,954,142,
        1,0,0,0,955,956,7,19,0,0,956,957,7,5,0,0,957,958,7,24,0,0,958,959,
        7,3,0,0,959,960,7,9,0,0,960,961,7,7,0,0,961,962,7,18,0,0,962,963,
        7,13,0,0,963,964,7,23,0,0,964,965,7,5,0,0,965,966,7,20,0,0,966,967,
        7,11,0,0,967,968,7,16,0,0,968,969,7,8,0,0,969,970,7,3,0,0,970,971,
        7,19,0,0,971,972,7,5,0,0,972,973,7,7,0,0,973,974,7,3,0,0,974,975,
        7,17,0,0,975,976,7,10,0,0,976,977,7,5,0,0,977,144,1,0,0,0,978,979,
        7,13,0,0,979,980,7,12,0,0,980,981,7,10,0,0,981,982,7,14,0,0,982,
        983,7,24,0,0,983,984,7,9,0,0,984,146,1,0,0,0,985,986,7,18,0,0,986,
        987,7,9,0,0,987,988,7,19,0,0,988,989,7,5,0,0,989,990,7,8,0,0,990,
        991,7,7,0,0,991,148,1,0,0,0,992,993,7,19,0,0,993,994,7,5,0,0,994,
        995,7,24,0,0,995,996,7,3,0,0,996,997,7,9,0,0,997,998,7,7,0,0,998,
        999,7,18,0,0,999,1000,7,13,0,0,1000,1001,7,19,0,0,1001,1002,7,18,
        0,0,1002,1003,7,24,0,0,1003,1004,7,18,0,0,1004,1005,7,10,0,0,1005,
        1006,7,3,0,0,1006,1007,7,8,0,0,1007,1008,7,18,0,0,1008,1009,7,7,
        0,0,1009,1010,7,20,0,0,1010,1011,7,4,0,0,1011,1012,7,5,0,0,1012,
        1013,7,7,0,0,1013,1014,7,3,0,0,1014,1015,7,18,0,0,1015,1016,7,10,
        0,0,1016,1017,7,19,0,0,1017,1018,7,7,0,0,1018,1019,7,3,0,0,1019,
        1020,7,17,0,0,1020,1021,7,10,0,0,1021,1022,7,5,0,0,1022,150,1,0,
        0,0,1023,1024,7,13,0,0,1024,1025,7,12,0,0,1025,1026,7,24,0,0,1026,
        1027,7,24,0,0,1027,1028,7,18,0,0,1028,1029,7,7,0,0,1029,152,1,0,
        0,0,1030,1031,7,18,0,0,1031,1032,7,9,0,0,1032,1033,7,7,0,0,1033,
        1034,7,5,0,0,1034,1035,7,8,0,0,1035,1036,7,19,0,0,1036,1037,7,5,
        0,0,1037,1038,7,13,0,0,1038,1039,7,7,0,0,1039,154,1,0,0,0,1040,1041,
        7,19,0,0,1041,1042,7,5,0,0,1042,1043,7,24,0,0,1043,1044,7,3,0,0,
        1044,1045,7,9,0,0,1045,1046,7,7,0,0,1046,1047,7,18,0,0,1047,1048,
        7,13,0,0,1048,1049,7,19,0,0,1049,1050,7,18,0,0,1050,1051,7,24,0,
        0,1051,1052,7,18,0,0,1052,1053,7,10,0,0,1053,1054,7,3,0,0,1054,1055,
        7,8,0,0,1055,1056,7,18,0,0,1056,1057,7,7,0,0,1057,1058,7,20,0,0,
        1058,1059,7,7,0,0,1059,1060,7,3,0,0,1060,1061,7,17,0,0,1061,1062,
        7,10,0,0,1062,1063,7,5,0,0,1063,156,1,0,0,0,1064,1065,7,13,0,0,1065,
        1066,7,12,0,0,1066,1067,7,24,0,0,1067,1068,7,11,0,0,1068,1069,7,
        14,0,0,1069,1070,7,7,0,0,1070,1071,7,5,0,0,1071,158,1,0,0,0,1072,
        1073,7,18,0,0,1073,1074,7,9,0,0,1074,1075,7,7,0,0,1075,1076,7,12,
        0,0,1076,160,1,0,0,0,1077,1078,7,19,0,0,1078,1079,7,5,0,0,1079,1080,
        7,19,0,0,1080,1081,7,19,0,0,1081,1082,7,18,0,0,1082,1083,7,12,0,
        0,1083,1084,7,9,0,0,1084,1085,5,95,0,0,1085,1086,7,14,0,0,1086,1087,
        7,19,0,0,1087,1088,7,5,0,0,1088,1089,7,8,0,0,1089,162,1,0,0,0,1090,
        1091,7,13,0,0,1091,1092,7,12,0,0,1092,1093,7,9,0,0,1093,1094,7,19,
        0,0,1094,1095,7,7,0,0,1095,1096,7,8,0,0,1096,1097,7,3,0,0,1097,1098,
        7,18,0,0,1098,1099,7,9,0,0,1099,1100,7,7,0,0,1100,164,1,0,0,0,1101,
        1102,7,18,0,0,1102,1103,7,19,0,0,1103,166,1,0,0,0,1104,1105,7,19,
        0,0,1105,1106,7,5,0,0,1106,1107,7,7,0,0,1107,168,1,0,0,0,1108,1109,
        7,13,0,0,1109,1110,7,12,0,0,1110,1111,7,9,0,0,1111,1112,7,7,0,0,
        1112,1113,7,3,0,0,1113,1114,7,18,0,0,1114,1115,7,9,0,0,1115,1116,
        7,19,0,0,1116,170,1,0,0,0,1117,1118,7,27,0,0,1118,1119,7,12,0,0,
        1119,1120,7,18,0,0,1120,1121,7,9,0,0,1121,172,1,0,0,0,1122,1123,
        7,19,0,0,1123,1124,7,5,0,0,1124,1125,7,7,0,0,1125,1126,7,14,0,0,
        1126,1127,7,19,0,0,1127,1128,7,5,0,0,1128,1129,7,8,0,0,1129,174,
        1,0,0,0,1130,1131,7,13,0,0,1131,1132,7,12,0,0,1132,1133,7,9,0,0,
        1133,1134,7,7,0,0,1134,1135,7,3,0,0,1135,1136,7,18,0,0,1136,1137,
        7,9,0,0,1137,1138,7,19,0,0,1138,1139,7,7,0,0,1139,1140,7,3,0,0,1140,
        1141,7,17,0,0,1141,1142,7,10,0,0,1142,1143,7,5,0,0,1143,176,1,0,
        0,0,1144,1145,7,23,0,0,1145,1146,7,5,0,0,1146,1147,7,20,0,0,1147,
        178,1,0,0,0,1148,1149,7,19,0,0,1149,1150,7,16,0,0,1150,1151,7,14,
        0,0,1151,1152,7,7,0,0,1152,1153,7,4,0,0,1153,1154,7,12,0,0,1154,
        1155,7,25,0,0,1155,1156,7,9,0,0,1156,180,1,0,0,0,1157,1158,7,13,
        0,0,1158,1159,7,12,0,0,1159,1160,7,9,0,0,1160,1161,7,7,0,0,1161,
        1162,7,18,0,0,1162,1163,7,9,0,0,1163,1164,7,14,0,0,1164,1165,7,5,
        0,0,1165,182,1,0,0,0,1166,1167,7,23,0,0,1167,1168,7,18,0,0,1168,
        1169,7,10,0,0,1169,1170,7,10,0,0,1170,184,1,0,0,0,1171,1172,7,19,
        0,0,1172,1173,7,12,0,0,1173,1174,7,24,0,0,1174,1175,7,5,0,0,1175,
        186,1,0,0,0,1176,1177,7,13,0,0,1177,1178,7,12,0,0,1178,1179,7,9,
        0,0,1179,1180,7,26,0,0,1180,1181,7,5,0,0,1181,1182,7,8,0,0,1182,
        1183,7,7,0,0,1183,188,1,0,0,0,1184,1185,7,10,0,0,1185,1186,7,5,0,
        0,1186,1187,7,15,0,0,1187,1188,7,7,0,0,1188,190,1,0,0,0,1189,1190,
        7,19,0,0,1190,1191,7,7,0,0,1191,1192,7,3,0,0,1192,1193,7,7,0,0,1193,
        1194,7,18,0,0,1194,1195,7,19,0,0,1195,1196,7,7,0,0,1196,1197,7,18,
        0,0,1197,1198,7,13,0,0,1198,1199,7,19,0,0,1199,192,1,0,0,0,1200,
        1201,7,13,0,0,1201,1202,7,8,0,0,1202,1203,7,5,0,0,1203,1204,7,3,
        0,0,1204,1205,7,7,0,0,1205,1206,7,5,0,0,1206,194,1,0,0,0,1207,1208,
        7,10,0,0,1208,1209,7,18,0,0,1209,1210,7,23,0,0,1210,1211,7,5,0,0,
        1211,196,1,0,0,0,1212,1213,7,19,0,0,1213,1214,7,20,0,0,1214,1215,
        7,19,0,0,1215,1216,7,7,0,0,1216,1217,7,5,0,0,1217,1218,7,24,0,0,
        1218,1219,5,95,0,0,1219,1220,7,14,0,0,1220,1221,7,19,0,0,1221,1222,
        7,5,0,0,1222,1223,7,8,0,0,1223,198,1,0,0,0,1224,1225,7,13,0,0,1225,
        1226,7,8,0,0,1226,1227,7,12,0,0,1227,1228,7,19,0,0,1228,1229,7,19,
        0,0,1229,200,1,0,0,0,1230,1231,7,10,0,0,1231,1232,7,18,0,0,1232,
        1233,7,9,0,0,1233,1234,7,5,0,0,1234,1235,7,9,0,0,1235,1236,7,12,
        0,0,1236,202,1,0,0,0,1237,1238,7,7,0,0,1238,1239,7,3,0,0,1239,1240,
        7,17,0,0,1240,1241,7,10,0,0,1241,1242,7,5,0,0,1242,204,1,0,0,0,1243,
        1244,7,13,0,0,1244,1245,7,14,0,0,1245,1246,7,8,0,0,1246,1247,7,8,
        0,0,1247,1248,7,5,0,0,1248,1249,7,9,0,0,1249,1250,7,7,0,0,1250,206,
        1,0,0,0,1251,1252,7,10,0,0,1252,1253,7,12,0,0,1253,1254,7,3,0,0,
        1254,1255,7,4,0,0,1255,208,1,0,0,0,1256,1257,7,7,0,0,1257,1258,7,
        3,0,0,1258,1259,7,17,0,0,1259,1260,7,10,0,0,1260,1261,7,5,0,0,1261,
        1262,7,19,0,0,1262,1263,7,3,0,0,1263,1264,7,24,0,0,1264,1265,7,11,
        0,0,1265,1266,7,10,0,0,1266,1267,7,5,0,0,1267,210,1,0,0,0,1268,1269,
        7,13,0,0,1269,1270,7,14,0,0,1270,1271,7,8,0,0,1271,1272,7,8,0,0,
        1272,1273,7,5,0,0,1273,1274,7,9,0,0,1274,1275,7,7,0,0,1275,1276,
        5,95,0,0,1276,1277,7,4,0,0,1277,1278,7,3,0,0,1278,1279,7,7,0,0,1279,
        1280,7,5,0,0,1280,212,1,0,0,0,1281,1282,7,24,0,0,1282,1283,7,5,0,
        0,1283,1284,7,8,0,0,1284,1285,7,21,0,0,1285,1286,7,5,0,0,1286,214,
        1,0,0,0,1287,1288,7,7,0,0,1288,1289,7,5,0,0,1289,1290,7,6,0,0,1290,
        1291,7,7,0,0,1291,1292,7,19,0,0,1292,1293,7,18,0,0,1293,1294,7,22,
        0,0,1294,1295,7,5,0,0,1295,216,1,0,0,0,1296,1297,7,13,0,0,1297,1298,
        7,14,0,0,1298,1299,7,8,0,0,1299,1300,7,8,0,0,1300,1301,7,5,0,0,1301,
        1302,7,9,0,0,1302,1303,7,7,0,0,1303,1304,5,95,0,0,1304,1305,7,7,
        0,0,1305,1306,7,18,0,0,1306,1307,7,24,0,0,1307,1308,7,5,0,0,1308,
        218,1,0,0,0,1309,1310,7,9,0,0,1310,1311,7,3,0,0,1311,1312,7,7,0,
        0,1312,1313,7,18,0,0,1313,1314,7,12,0,0,1314,1315,7,9,0,0,1315,1316,
        7,3,0,0,1316,1317,7,10,0,0,1317,220,1,0,0,0,1318,1319,7,7,0,0,1319,
        1320,7,16,0,0,1320,1321,7,5,0,0,1321,1322,7,9,0,0,1322,222,1,0,0,
        0,1323,1324,7,13,0,0,1324,1325,7,14,0,0,1325,1326,7,8,0,0,1326,1327,
        7,8,0,0,1327,1328,7,5,0,0,1328,1329,7,9,0,0,1329,1330,7,7,0,0,1330,
        1331,5,95,0,0,1331,1332,7,7,0,0,1332,1333,7,18,0,0,1333,1334,7,24,
        0,0,1334,1335,7,5,0,0,1335,1336,7,19,0,0,1336,1337,7,7,0,0,1337,
        1338,7,3,0,0,1338,1339,7,24,0,0,1339,1340,7,11,0,0,1340,224,1,0,
        0,0,1341,1342,7,9,0,0,1342,1343,7,12,0,0,1343,1344,7,13,0,0,1344,
        1345,7,16,0,0,1345,1346,7,5,0,0,1346,1347,7,13,0,0,1347,1348,7,23,
        0,0,1348,226,1,0,0,0,1349,1350,7,7,0,0,1350,1351,7,12,0,0,1351,228,
        1,0,0,0,1352,1353,7,13,0,0,1353,1354,7,14,0,0,1354,1355,7,8,0,0,
        1355,1356,7,8,0,0,1356,1357,7,5,0,0,1357,1358,7,9,0,0,1358,1359,
        7,7,0,0,1359,1360,5,95,0,0,1360,1361,7,14,0,0,1361,1362,7,19,0,0,
        1362,1363,7,5,0,0,1363,1364,7,8,0,0,1364,230,1,0,0,0,1365,1366,7,
        9,0,0,1366,1367,7,12,0,0,1367,1368,7,9,0,0,1368,1369,7,13,0,0,1369,
        1370,7,10,0,0,1370,1371,7,14,0,0,1371,1372,7,19,0,0,1372,1373,7,
        7,0,0,1373,1374,7,5,0,0,1374,1375,7,8,0,0,1375,1376,7,5,0,0,1376,
        1377,7,4,0,0,1377,232,1,0,0,0,1378,1379,7,7,0,0,1379,1380,7,12,0,
        0,1380,1381,7,11,0,0,1381,234,1,0,0,0,1382,1383,7,13,0,0,1383,1384,
        7,14,0,0,1384,1385,7,8,0,0,1385,1386,7,19,0,0,1386,1387,7,12,0,0,
        1387,1388,7,8,0,0,1388,236,1,0,0,0,1389,1390,7,9,0,0,1390,1391,7,
        12,0,0,1391,1392,7,7,0,0,1392,238,1,0,0,0,1393,1394,7,7,0,0,1394,
        1395,7,8,0,0,1395,1396,7,3,0,0,1396,1397,7,9,0,0,1397,240,1,0,0,
        0,1398,1399,7,4,0,0,1399,1400,7,3,0,0,1400,1401,7,7,0,0,1401,1402,
        7,3,0,0,1402,1403,7,17,0,0,1403,1404,7,3,0,0,1404,1405,7,19,0,0,
        1405,1406,7,5,0,0,1406,242,1,0,0,0,1407,1408,7,9,0,0,1408,1409,7,
        14,0,0,1409,1410,7,10,0,0,1410,1411,7,10,0,0,1411,244,1,0,0,0,1412,
        1413,7,7,0,0,1413,1414,7,8,0,0,1414,1415,7,3,0,0,1415,1416,7,9,0,
        0,1416,1417,7,19,0,0,1417,1418,7,3,0,0,1418,1419,7,13,0,0,1419,1420,
        7,7,0,0,1420,1421,7,18,0,0,1421,1422,7,12,0,0,1422,1423,7,9,0,0,
        1423,246,1,0,0,0,1424,1425,7,4,0,0,1425,1426,7,17,0,0,1426,1427,
        7,13,0,0,1427,1428,7,13,0,0,1428,248,1,0,0,0,1429,1430,7,9,0,0,1430,
        1431,7,14,0,0,1431,1432,7,10,0,0,1432,1433,7,10,0,0,1433,1434,7,
        18,0,0,1434,1435,7,15,0,0,1435,250,1,0,0,0,1436,1437,7,7,0,0,1437,
        1438,7,8,0,0,1438,1439,7,18,0,0,1439,1440,7,21,0,0,1440,1441,7,21,
        0,0,1441,1442,7,5,0,0,1442,1443,7,8,0,0,1443,252,1,0,0,0,1444,1445,
        7,4,0,0,1445,1446,7,5,0,0,1446,1447,7,3,0,0,1447,1448,7,10,0,0,1448,
        1449,7,10,0,0,1449,1450,7,12,0,0,1450,1451,7,13,0,0,1451,1452,7,
        3,0,0,1452,1453,7,7,0,0,1453,1454,7,5,0,0,1454,254,1,0,0,0,1455,
        1456,7,12,0,0,1456,1457,7,15,0,0,1457,256,1,0,0,0,1458,1459,7,7,
        0,0,1459,1460,7,8,0,0,1460,1461,7,14,0,0,1461,1462,7,9,0,0,1462,
        1463,7,13,0,0,1463,1464,7,3,0,0,1464,1465,7,7,0,0,1465,1466,7,5,
        0,0,1466,258,1,0,0,0,1467,1468,7,4,0,0,1468,1469,7,5,0,0,1469,1470,
        7,13,0,0,1470,1471,7,10,0,0,1471,1472,7,3,0,0,1472,1473,7,8,0,0,
        1473,1474,7,5,0,0,1474,260,1,0,0,0,1475,1476,7,12,0,0,1476,1477,
        7,15,0,0,1477,1478,7,15,0,0,1478,262,1,0,0,0,1479,1480,7,7,0,0,1480,
        1481,7,8,0,0,1481,1482,7,20,0,0,1482,1483,5,95,0,0,1483,1484,7,13,
        0,0,1484,1485,7,12,0,0,1485,1486,7,9,0,0,1486,1487,7,26,0,0,1487,
        1488,7,5,0,0,1488,1489,7,8,0,0,1489,1490,7,7,0,0,1490,264,1,0,0,
        0,1491,1492,7,4,0,0,1492,1493,7,5,0,0,1493,1494,7,15,0,0,1494,1495,
        7,3,0,0,1495,1496,7,14,0,0,1496,1497,7,10,0,0,1497,1498,7,7,0,0,
        1498,266,1,0,0,0,1499,1500,7,12,0,0,1500,1501,7,15,0,0,1501,1502,
        7,15,0,0,1502,1503,7,19,0,0,1503,1504,7,5,0,0,1504,1505,7,7,0,0,
        1505,1506,7,19,0,0,1506,268,1,0,0,0,1507,1508,7,7,0,0,1508,1509,
        7,19,0,0,1509,1510,7,5,0,0,1510,1511,7,28,0,0,1511,1512,7,14,0,0,
        1512,1513,7,3,0,0,1513,1514,7,10,0,0,1514,270,1,0,0,0,1515,1516,
        7,4,0,0,1516,1517,7,5,0,0,1517,1518,7,10,0,0,1518,1519,7,5,0,0,1519,
        1520,7,7,0,0,1520,1521,7,5,0,0,1521,272,1,0,0,0,1522,1523,7,12,0,
        0,1523,1524,7,9,0,0,1524,274,1,0,0,0,1525,1526,7,14,0,0,1526,1527,
        7,9,0,0,1527,1528,7,18,0,0,1528,1529,7,12,0,0,1529,1530,7,9,0,0,
        1530,276,1,0,0,0,1531,1532,7,4,0,0,1532,1533,7,5,0,0,1533,1534,7,
        9,0,0,1534,1535,7,20,0,0,1535,278,1,0,0,0,1536,1537,7,12,0,0,1537,
        1538,7,11,0,0,1538,1539,7,5,0,0,1539,1540,7,9,0,0,1540,280,1,0,0,
        0,1541,1542,7,14,0,0,1542,1543,7,9,0,0,1543,1544,7,18,0,0,1544,1545,
        7,28,0,0,1545,1546,7,14,0,0,1546,1547,7,5,0,0,1547,282,1,0,0,0,1548,
        1549,7,4,0,0,1549,1550,7,5,0,0,1550,1551,7,19,0,0,1551,1552,7,13,
        0,0,1552,284,1,0,0,0,1553,1554,7,12,0,0,1554,1555,7,11,0,0,1555,
        1556,7,5,0,0,1556,1557,7,9,0,0,1557,1558,7,4,0,0,1558,1559,7,3,0,
        0,1559,1560,7,7,0,0,1560,1561,7,3,0,0,1561,1562,7,19,0,0,1562,1563,
        7,12,0,0,1563,1564,7,14,0,0,1564,1565,7,8,0,0,1565,1566,7,13,0,0,
        1566,1567,7,5,0,0,1567,286,1,0,0,0,1568,1569,7,14,0,0,1569,1570,
        7,11,0,0,1570,1571,7,4,0,0,1571,1572,7,3,0,0,1572,1573,7,7,0,0,1573,
        1574,7,5,0,0,1574,288,1,0,0,0,1575,1576,7,4,0,0,1576,1577,7,18,0,
        0,1577,1578,7,19,0,0,1578,1579,7,23,0,0,1579,290,1,0,0,0,1580,1581,
        7,12,0,0,1581,1582,7,11,0,0,1582,1583,7,5,0,0,1583,1584,7,9,0,0,
        1584,1585,7,28,0,0,1585,1586,7,14,0,0,1586,1587,7,5,0,0,1587,1588,
        7,8,0,0,1588,1589,7,20,0,0,1589,292,1,0,0,0,1590,1591,7,14,0,0,1591,
        1592,7,11,0,0,1592,1593,7,4,0,0,1593,1594,7,3,0,0,1594,1595,7,7,
        0,0,1595,1596,7,5,0,0,1596,1597,7,7,0,0,1597,1598,7,5,0,0,1598,1599,
        7,6,0,0,1599,1600,7,7,0,0,1600,294,1,0,0,0,1601,1602,7,4,0,0,1602,
        1603,7,18,0,0,1603,1604,7,19,0,0,1604,1605,7,7,0,0,1605,1606,7,18,
        0,0,1606,1607,7,9,0,0,1607,1608,7,13,0,0,1608,1609,7,7,0,0,1609,
        296,1,0,0,0,1610,1611,7,12,0,0,1611,1612,7,11,0,0,1612,1613,7,5,
        0,0,1613,1614,7,9,0,0,1614,1615,7,8,0,0,1615,1616,7,12,0,0,1616,
        1617,7,25,0,0,1617,1618,7,19,0,0,1618,1619,7,5,0,0,1619,1620,7,7,
        0,0,1620,298,1,0,0,0,1621,1622,7,14,0,0,1622,1623,7,19,0,0,1623,
        1624,7,5,0,0,1624,300,1,0,0,0,1625,1626,7,4,0,0,1626,1627,7,18,0,
        0,1627,1628,7,19,0,0,1628,1629,7,7,0,0,1629,1630,7,8,0,0,1630,1631,
        7,18,0,0,1631,1632,7,17,0,0,1632,1633,7,14,0,0,1633,1634,7,7,0,0,
        1634,1635,7,5,0,0,1635,1636,7,4,0,0,1636,302,1,0,0,0,1637,1638,7,
        12,0,0,1638,1639,7,11,0,0,1639,1640,7,5,0,0,1640,1641,7,9,0,0,1641,
        1642,7,6,0,0,1642,1643,7,24,0,0,1643,1644,7,10,0,0,1644,304,1,0,
        0,0,1645,1646,7,14,0,0,1646,1647,7,19,0,0,1647,1648,7,5,0,0,1648,
        1649,7,8,0,0,1649,306,1,0,0,0,1650,1651,7,4,0,0,1651,1652,7,12,0,
        0,1652,1653,7,14,0,0,1653,1654,7,17,0,0,1654,1655,7,10,0,0,1655,
        1656,7,5,0,0,1656,308,1,0,0,0,1657,1658,7,12,0,0,1658,1659,7,11,
        0,0,1659,1660,7,7,0,0,1660,1661,7,18,0,0,1661,1662,7,12,0,0,1662,
        1663,7,9,0,0,1663,310,1,0,0,0,1664,1665,7,26,0,0,1665,1666,7,3,0,
        0,1666,1667,7,10,0,0,1667,1668,7,14,0,0,1668,1669,7,5,0,0,1669,1670,
        7,19,0,0,1670,312,1,0,0,0,1671,1672,7,4,0,0,1672,1673,7,8,0,0,1673,
        1674,7,12,0,0,1674,1675,7,11,0,0,1675,314,1,0,0,0,1676,1677,7,12,
        0,0,1677,1678,7,8,0,0,1678,316,1,0,0,0,1679,1680,7,26,0,0,1680,1681,
        7,3,0,0,1681,1682,7,8,0,0,1682,1683,7,20,0,0,1683,1684,7,18,0,0,
        1684,1685,7,9,0,0,1685,1686,7,21,0,0,1686,318,1,0,0,0,1687,1688,
        7,4,0,0,1688,1689,7,14,0,0,1689,1690,7,24,0,0,1690,1691,7,11,0,0,
        1691,320,1,0,0,0,1692,1693,7,12,0,0,1693,1694,7,8,0,0,1694,1695,
        7,4,0,0,1695,1696,7,5,0,0,1696,1697,7,8,0,0,1697,322,1,0,0,0,1698,
        1699,7,26,0,0,1699,1700,7,18,0,0,1700,1701,7,5,0,0,1701,1702,7,25,
        0,0,1702,324,1,0,0,0,1703,1704,7,5,0,0,1704,1705,7,10,0,0,1705,1706,
        7,19,0,0,1706,1707,7,5,0,0,1707,326,1,0,0,0,1708,1709,7,12,0,0,1709,
        1710,7,14,0,0,1710,1711,7,7,0,0,1711,1712,7,5,0,0,1712,1713,7,8,
        0,0,1713,328,1,0,0,0,1714,1715,7,25,0,0,1715,1716,7,3,0,0,1716,1717,
        7,18,0,0,1717,1718,7,7,0,0,1718,1719,7,15,0,0,1719,1720,7,12,0,0,
        1720,1721,7,8,0,0,1721,330,1,0,0,0,1722,1723,7,5,0,0,1723,1724,7,
        9,0,0,1724,1725,7,4,0,0,1725,332,1,0,0,0,1726,1727,7,12,0,0,1727,
        1728,7,26,0,0,1728,1729,7,5,0,0,1729,1730,7,8,0,0,1730,334,1,0,0,
        0,1731,1732,7,25,0,0,1732,1733,7,16,0,0,1733,1734,7,5,0,0,1734,1735,
        7,9,0,0,1735,336,1,0,0,0,1736,1737,7,5,0,0,1737,1738,7,8,0,0,1738,
        1739,7,8,0,0,1739,1740,7,10,0,0,1740,1741,7,26,0,0,1741,1742,7,10,
        0,0,1742,338,1,0,0,0,1743,1744,7,11,0,0,1744,1745,7,5,0,0,1745,1746,
        7,8,0,0,1746,1747,7,13,0,0,1747,1748,7,5,0,0,1748,1749,7,9,0,0,1749,
        1750,7,7,0,0,1750,340,1,0,0,0,1751,1752,7,25,0,0,1752,1753,7,16,
        0,0,1753,1754,7,5,0,0,1754,1755,7,8,0,0,1755,1756,7,5,0,0,1756,342,
        1,0,0,0,1757,1758,7,5,0,0,1758,1759,7,19,0,0,1759,1760,7,13,0,0,
        1760,1761,7,3,0,0,1761,1762,7,11,0,0,1762,1763,7,5,0,0,1763,344,
        1,0,0,0,1764,1765,7,11,0,0,1765,1766,7,18,0,0,1766,1767,7,26,0,0,
        1767,1768,7,12,0,0,1768,1769,7,7,0,0,1769,346,1,0,0,0,1770,1771,
        7,25,0,0,1771,1772,7,16,0,0,1772,1773,7,18,0,0,1773,1774,7,10,0,
        0,1774,1775,7,5,0,0,1775,348,1,0,0,0,1776,1777,7,5,0,0,1777,1778,
        7,6,0,0,1778,1779,7,13,0,0,1779,1780,7,5,0,0,1780,1781,7,11,0,0,
        1781,1782,7,7,0,0,1782,350,1,0,0,0,1783,1784,7,11,0,0,1784,1785,
        7,10,0,0,1785,1786,7,3,0,0,1786,1787,7,9,0,0,1787,352,1,0,0,0,1788,
        1789,7,25,0,0,1789,1790,7,18,0,0,1790,1791,7,7,0,0,1791,1792,7,16,
        0,0,1792,354,1,0,0,0,1793,1794,7,5,0,0,1794,1795,7,6,0,0,1795,1796,
        7,5,0,0,1796,1797,7,13,0,0,1797,356,1,0,0,0,1798,1799,7,11,0,0,1799,
        1800,7,8,0,0,1800,1801,7,5,0,0,1801,1802,7,13,0,0,1802,1803,7,18,
        0,0,1803,1804,7,19,0,0,1804,1805,7,18,0,0,1805,1806,7,12,0,0,1806,
        1807,7,9,0,0,1807,358,1,0,0,0,1808,1809,7,25,0,0,1809,1810,7,8,0,
        0,1810,1811,7,18,0,0,1811,1812,7,7,0,0,1812,1813,7,5,0,0,1813,1814,
        7,7,0,0,1814,1815,7,5,0,0,1815,1816,7,6,0,0,1816,1817,7,7,0,0,1817,
        360,1,0,0,0,1818,1819,7,5,0,0,1819,1820,7,6,0,0,1820,1821,7,5,0,
        0,1821,1822,7,13,0,0,1822,1823,7,14,0,0,1823,1824,7,7,0,0,1824,1825,
        7,5,0,0,1825,362,1,0,0,0,1826,1827,7,11,0,0,1827,1828,7,8,0,0,1828,
        1829,7,18,0,0,1829,1830,7,24,0,0,1830,1831,7,3,0,0,1831,1832,7,8,
        0,0,1832,1833,7,20,0,0,1833,364,1,0,0,0,1834,1835,7,18,0,0,1835,
        1836,7,9,0,0,1836,1837,7,7,0,0,1837,1838,7,5,0,0,1838,1839,7,21,
        0,0,1839,1840,7,5,0,0,1840,1841,7,8,0,0,1841,366,1,0,0,0,1842,1843,
        7,9,0,0,1843,1844,7,26,0,0,1844,1845,7,3,0,0,1845,1846,7,8,0,0,1846,
        1847,7,13,0,0,1847,1848,7,16,0,0,1848,1849,7,3,0,0,1849,1850,7,8,
        0,0,1850,368,1,0,0,0,1851,1852,7,26,0,0,1852,1853,7,3,0,0,1853,1854,
        7,8,0,0,1854,1855,7,13,0,0,1855,1856,7,16,0,0,1856,1857,7,3,0,0,
        1857,1858,7,8,0,0,1858,370,1,0,0,0,1859,1860,7,24,0,0,1860,1861,
        7,3,0,0,1861,1862,7,6,0,0,1862,372,1,0,0,0,1863,1864,7,7,0,0,1864,
        1865,7,8,0,0,1865,1866,7,20,0,0,1866,374,1,0,0,0,1867,1868,7,13,
        0,0,1868,1869,7,3,0,0,1869,1870,7,7,0,0,1870,1871,7,13,0,0,1871,
        1872,7,16,0,0,1872,376,1,0,0,0,1873,1874,7,5,0,0,1874,1875,7,6,0,
        0,1875,1876,7,18,0,0,1876,1877,7,19,0,0,1877,1878,7,7,0,0,1878,1879,
        7,19,0,0,1879,378,1,0,0,0,1880,1882,3,1,0,0,1881,1880,1,0,0,0,1882,
        1883,1,0,0,0,1883,1881,1,0,0,0,1883,1884,1,0,0,0,1884,380,1,0,0,
        0,1885,1887,3,1,0,0,1886,1885,1,0,0,0,1887,1888,1,0,0,0,1888,1886,
        1,0,0,0,1888,1889,1,0,0,0,1889,1890,1,0,0,0,1890,1892,5,46,0,0,1891,
        1893,3,1,0,0,1892,1891,1,0,0,0,1893,1894,1,0,0,0,1894,1892,1,0,0,
        0,1894,1895,1,0,0,0,1895,382,1,0,0,0,1896,1897,5,48,0,0,1897,1899,
        7,6,0,0,1898,1896,1,0,0,0,1899,1900,1,0,0,0,1900,1898,1,0,0,0,1900,
        1901,1,0,0,0,1901,384,1,0,0,0,1902,1903,5,48,0,0,1903,1904,7,17,
        0,0,1904,1906,1,0,0,0,1905,1907,7,29,0,0,1906,1905,1,0,0,0,1907,
        1908,1,0,0,0,1908,1906,1,0,0,0,1908,1909,1,0,0,0,1909,386,1,0,0,
        0,1910,1911,7,7,0,0,1911,1912,7,8,0,0,1912,1913,7,14,0,0,1913,1914,
        7,5,0,0,1914,388,1,0,0,0,1915,1916,7,15,0,0,1916,1917,7,3,0,0,1917,
        1918,7,10,0,0,1918,1919,7,19,0,0,1919,1920,7,5,0,0,1920,390,1,0,
        0,0,1921,1923,7,9,0,0,1922,1921,1,0,0,0,1922,1923,1,0,0,0,1923,1924,
        1,0,0,0,1924,1949,5,39,0,0,1925,1948,8,30,0,0,1926,1927,5,92,0,0,
        1927,1948,9,0,0,0,1928,1929,5,39,0,0,1929,1948,5,39,0,0,1930,1934,
        5,92,0,0,1931,1933,7,31,0,0,1932,1931,1,0,0,0,1933,1936,1,0,0,0,
        1934,1932,1,0,0,0,1934,1935,1,0,0,0,1935,1938,1,0,0,0,1936,1934,
        1,0,0,0,1937,1939,5,13,0,0,1938,1937,1,0,0,0,1938,1939,1,0,0,0,1939,
        1940,1,0,0,0,1940,1944,5,10,0,0,1941,1943,7,31,0,0,1942,1941,1,0,
        0,0,1943,1946,1,0,0,0,1944,1942,1,0,0,0,1944,1945,1,0,0,0,1945,1948,
        1,0,0,0,1946,1944,1,0,0,0,1947,1925,1,0,0,0,1947,1926,1,0,0,0,1947,
        1928,1,0,0,0,1947,1930,1,0,0,0,1948,1951,1,0,0,0,1949,1947,1,0,0,
        0,1949,1950,1,0,0,0,1950,1952,1,0,0,0,1951,1949,1,0,0,0,1952,1953,
        5,39,0,0,1953,1954,6,195,0,0,1954,392,1,0,0,0,1955,1959,5,91,0,0,
        1956,1958,8,32,0,0,1957,1956,1,0,0,0,1958,1961,1,0,0,0,1959,1957,
        1,0,0,0,1959,1960,1,0,0,0,1960,1962,1,0,0,0,1961,1959,1,0,0,0,1962,
        1963,5,93,0,0,1963,394,1,0,0,0,1964,1969,3,3,1,0,1965,1968,3,3,1,
        0,1966,1968,3,1,0,0,1967,1965,1,0,0,0,1967,1966,1,0,0,0,1968,1971,
        1,0,0,0,1969,1967,1,0,0,0,1969,1970,1,0,0,0,1970,396,1,0,0,0,1971,
        1969,1,0,0,0,1972,1973,5,64,0,0,1973,1974,3,395,197,0,1974,398,1,
        0,0,0,1975,1976,5,61,0,0,1976,400,1,0,0,0,1977,1978,5,60,0,0,1978,
        1982,5,62,0,0,1979,1980,5,33,0,0,1980,1982,5,61,0,0,1981,1977,1,
        0,0,0,1981,1979,1,0,0,0,1982,402,1,0,0,0,1983,1984,5,62,0,0,1984,
        404,1,0,0,0,1985,1986,5,60,0,0,1986,406,1,0,0,0,1987,1988,5,62,0,
        0,1988,1989,5,61,0,0,1989,408,1,0,0,0,1990,1991,5,60,0,0,1991,1992,
        5,61,0,0,1992,410,1,0,0,0,1993,1994,5,43,0,0,1994,412,1,0,0,0,1995,
        1996,5,45,0,0,1996,414,1,0,0,0,1997,1998,5,42,0,0,1998,416,1,0,0,
        0,1999,2000,5,47,0,0,2000,418,1,0,0,0,2001,2002,5,43,0,0,2002,2003,
        5,61,0,0,2003,420,1,0,0,0,2004,2005,5,44,0,0,2005,422,1,0,0,0,2006,
        2007,5,46,0,0,2007,424,1,0,0,0,2008,2009,5,40,0,0,2009,426,1,0,0,
        0,2010,2011,5,41,0,0,2011,428,1,0,0,0,2012,2013,5,91,0,0,2013,430,
        1,0,0,0,2014,2015,5,93,0,0,2015,432,1,0,0,0,2016,2017,5,59,0,0,2017,
        434,1,0,0,0,2018,2019,5,45,0,0,2019,2020,5,45,0,0,2020,2024,1,0,
        0,0,2021,2023,8,33,0,0,2022,2021,1,0,0,0,2023,2026,1,0,0,0,2024,
        2022,1,0,0,0,2024,2025,1,0,0,0,2025,2027,1,0,0,0,2026,2024,1,0,0,
        0,2027,2028,6,217,1,0,2028,436,1,0,0,0,2029,2030,5,47,0,0,2030,2031,
        5,42,0,0,2031,2036,1,0,0,0,2032,2035,3,437,218,0,2033,2035,9,0,0,
        0,2034,2032,1,0,0,0,2034,2033,1,0,0,0,2035,2038,1,0,0,0,2036,2037,
        1,0,0,0,2036,2034,1,0,0,0,2037,2039,1,0,0,0,2038,2036,1,0,0,0,2039,
        2040,5,42,0,0,2040,2041,5,47,0,0,2041,2042,1,0,0,0,2042,2043,6,218,
        1,0,2043,438,1,0,0,0,2044,2046,7,34,0,0,2045,2044,1,0,0,0,2046,2047,
        1,0,0,0,2047,2045,1,0,0,0,2047,2048,1,0,0,0,2048,2049,1,0,0,0,2049,
        2050,6,219,1,0,2050,440,1,0,0,0,20,0,1883,1888,1894,1900,1908,1922,
        1934,1938,1944,1947,1949,1959,1967,1969,1981,2024,2034,2036,2047,
        2,1,195,0,6,0,0
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
    REVERT = 36
    BROWSE = 37
    GRANT = 38
    REVOKE = 39
    BULK = 40
    GROUP = 41
    RIGHT = 42
    BY = 43
    HAVING = 44
    ROLLBACK = 45
    CASCADE = 46
    HOLDLOCK = 47
    ROWCOUNT = 48
    CASE = 49
    IDENTITY = 50
    ROWGUIDCOL = 51
    CHECK = 52
    IDENTITY_INSERT = 53
    RULE = 54
    CHECKPOINT = 55
    IDENTITYCOL = 56
    SAVE = 57
    CLOSE = 58
    IF = 59
    SCHEMA = 60
    CLUSTERED = 61
    IN = 62
    SECURITYAUDIT = 63
    COALESCE = 64
    INDEX = 65
    SELECT = 66
    COLLATE = 67
    INNER = 68
    SEMANTICKEYPHRASETABLE = 69
    COLUMN = 70
    INSERT = 71
    SEMANTICSIMILARITYDETAILSTABLE = 72
    COMMIT = 73
    INTERSECT = 74
    SEMANTICSIMILARITYTABLE = 75
    COMPUTE = 76
    INTO = 77
    SESSION_USER = 78
    CONSTRAINT = 79
    IS = 80
    SET = 81
    CONTAINS = 82
    JOIN = 83
    SETUSER = 84
    CONTAINSTABLE = 85
    KEY = 86
    SHUTDOWN = 87
    CONTINUE = 88
    KILL = 89
    SOME = 90
    CONVERT = 91
    LEFT = 92
    STATISTICS = 93
    CREATE = 94
    LIKE = 95
    SYSTEM_USER = 96
    CROSS = 97
    LINENO = 98
    TABLE = 99
    CURRENT = 100
    LOAD = 101
    TABLESAMPLE = 102
    CURRENT_DATE = 103
    MERGE = 104
    TEXTSIZE = 105
    CURRENT_TIME = 106
    NATIONAL = 107
    THEN = 108
    CURRENT_TIMESTAMP = 109
    NOCHECK = 110
    TO = 111
    CURRENT_USER = 112
    NONCLUSTERED = 113
    TOP = 114
    CURSOR = 115
    NOT = 116
    TRAN = 117
    DATABASE = 118
    NULL = 119
    TRANSACTION = 120
    DBCC = 121
    NULLIF = 122
    TRIGGER = 123
    DEALLOCATE = 124
    OF = 125
    TRUNCATE = 126
    DECLARE = 127
    OFF = 128
    TRY_CONVERT = 129
    DEFAULT = 130
    OFFSETS = 131
    TSEQUAL = 132
    DELETE = 133
    ON = 134
    UNION = 135
    DENY = 136
    OPEN = 137
    UNIQUE = 138
    DESC = 139
    OPENDATASOURCE = 140
    UPDATE = 141
    DISK = 142
    OPENQUERY = 143
    UPDATETEXT = 144
    DISTINCT = 145
    OPENROWSET = 146
    USE = 147
    DISTRIBUTED = 148
    OPENXML = 149
    USER = 150
    DOUBLE = 151
    OPTION = 152
    VALUES = 153
    DROP = 154
    OR = 155
    VARYING = 156
    DUMP = 157
    ORDER = 158
    VIEW = 159
    ELSE = 160
    OUTER = 161
    WAITFOR = 162
    END = 163
    OVER = 164
    WHEN = 165
    ERRLVL = 166
    PERCENT = 167
    WHERE = 168
    ESCAPE = 169
    PIVOT = 170
    WHILE = 171
    EXCEPT = 172
    PLAN = 173
    WITH = 174
    EXEC = 175
    PRECISION = 176
    WRITETEXT = 177
    EXECUTE = 178
    PRIMARY = 179
    INT = 180
    NVARCHAR = 181
    VARCHAR = 182
    MAX = 183
    TRY = 184
    CATCH = 185
    EXISTS = 186
    INT_LITERAL = 187
    FLOAT_LITERAL = 188
    HEX_LITERAL = 189
    BIT_LITERAL = 190
    TRUE_LITERAL = 191
    FALSE_LITERAL = 192
    STRING_LITERAL = 193
    BRACKET_IDENTIFIER = 194
    IDENTIFIER = 195
    USER_VAR = 196
    EQ = 197
    NEQ = 198
    GT = 199
    LT = 200
    GTE = 201
    LTE = 202
    PLUS = 203
    MINUS = 204
    STAR = 205
    SLASH = 206
    PLUS_EQ = 207
    COMMA = 208
    DOT = 209
    LPAREN = 210
    RPAREN = 211
    SPAREN = 212
    ZPAREN = 213
    SEMI = 214
    LINE_COMMENT = 215
    COMMENT = 216
    WS = 217

    channelNames = [ u"DEFAULT_TOKEN_CHANNEL", u"HIDDEN" ]

    modeNames = [ "DEFAULT_MODE" ]

    literalNames = [ "<INVALID>",
            "'ADD'", "'EXTERNAL'", "'PROCEDURE'", "'ALL'", "'FETCH'", "'PUBLIC'", 
            "'ALTER'", "'FILE'", "'RAISERROR'", "'AND'", "'FILLFACTOR'", 
            "'READ'", "'ANY'", "'FOR'", "'READTEXT'", "'AS'", "'FOREIGN'", 
            "'RECONFIGURE'", "'ASC'", "'FREETEXT'", "'REFERENCES'", "'AUTHORIZATION'", 
            "'FREETEXTTABLE'", "'REPLICATION'", "'BACKUP'", "'FROM'", "'RESTORE'", 
            "'BEGIN'", "'FULL'", "'RESTRICT'", "'BETWEEN'", "'FUNCTION'", 
            "'RETURN'", "'BREAK'", "'GOTO'", "'REVERT'", "'BROWSE'", "'GRANT'", 
            "'REVOKE'", "'BULK'", "'GROUP'", "'RIGHT'", "'BY'", "'HAVING'", 
            "'ROLLBACK'", "'CASCADE'", "'HOLDLOCK'", "'ROWCOUNT'", "'CASE'", 
            "'IDENTITY'", "'ROWGUIDCOL'", "'CHECK'", "'IDENTITY_INSERT'", 
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
            "'NVARCHAR'", "'VARCHAR'", "'MAX'", "'TRY'", "'CATCH'", "'EXISTS'", 
            "'TRUE'", "'FALSE'", "'='", "'>'", "'<'", "'>='", "'<='", "'+'", 
            "'-'", "'*'", "'/'", "'+='", "','", "'.'", "'('", "')'", "'['", 
            "']'", "';'" ]

    symbolicNames = [ "<INVALID>",
            "ADD", "EXTERNAL", "PROCEDURE", "ALL", "FETCH", "PUBLIC", "ALTER", 
            "FILE", "RAISERROR", "AND", "FILLFACTOR", "READ", "ANY", "FOR", 
            "READTEXT", "AS", "FOREIGN", "RECONFIGURE", "ASC", "FREETEXT", 
            "REFERENCES", "AUTHORIZATION", "FREETEXTTABLE", "REPLICATION", 
            "BACKUP", "FROM", "RESTORE", "BEGIN", "FULL", "RESTRICT", "BETWEEN", 
            "FUNCTION", "RETURN", "BREAK", "GOTO", "REVERT", "BROWSE", "GRANT", 
            "REVOKE", "BULK", "GROUP", "RIGHT", "BY", "HAVING", "ROLLBACK", 
            "CASCADE", "HOLDLOCK", "ROWCOUNT", "CASE", "IDENTITY", "ROWGUIDCOL", 
            "CHECK", "IDENTITY_INSERT", "RULE", "CHECKPOINT", "IDENTITYCOL", 
            "SAVE", "CLOSE", "IF", "SCHEMA", "CLUSTERED", "IN", "SECURITYAUDIT", 
            "COALESCE", "INDEX", "SELECT", "COLLATE", "INNER", "SEMANTICKEYPHRASETABLE", 
            "COLUMN", "INSERT", "SEMANTICSIMILARITYDETAILSTABLE", "COMMIT", 
            "INTERSECT", "SEMANTICSIMILARITYTABLE", "COMPUTE", "INTO", "SESSION_USER", 
            "CONSTRAINT", "IS", "SET", "CONTAINS", "JOIN", "SETUSER", "CONTAINSTABLE", 
            "KEY", "SHUTDOWN", "CONTINUE", "KILL", "SOME", "CONVERT", "LEFT", 
            "STATISTICS", "CREATE", "LIKE", "SYSTEM_USER", "CROSS", "LINENO", 
            "TABLE", "CURRENT", "LOAD", "TABLESAMPLE", "CURRENT_DATE", "MERGE", 
            "TEXTSIZE", "CURRENT_TIME", "NATIONAL", "THEN", "CURRENT_TIMESTAMP", 
            "NOCHECK", "TO", "CURRENT_USER", "NONCLUSTERED", "TOP", "CURSOR", 
            "NOT", "TRAN", "DATABASE", "NULL", "TRANSACTION", "DBCC", "NULLIF", 
            "TRIGGER", "DEALLOCATE", "OF", "TRUNCATE", "DECLARE", "OFF", 
            "TRY_CONVERT", "DEFAULT", "OFFSETS", "TSEQUAL", "DELETE", "ON", 
            "UNION", "DENY", "OPEN", "UNIQUE", "DESC", "OPENDATASOURCE", 
            "UPDATE", "DISK", "OPENQUERY", "UPDATETEXT", "DISTINCT", "OPENROWSET", 
            "USE", "DISTRIBUTED", "OPENXML", "USER", "DOUBLE", "OPTION", 
            "VALUES", "DROP", "OR", "VARYING", "DUMP", "ORDER", "VIEW", 
            "ELSE", "OUTER", "WAITFOR", "END", "OVER", "WHEN", "ERRLVL", 
            "PERCENT", "WHERE", "ESCAPE", "PIVOT", "WHILE", "EXCEPT", "PLAN", 
            "WITH", "EXEC", "PRECISION", "WRITETEXT", "EXECUTE", "PRIMARY", 
            "INT", "NVARCHAR", "VARCHAR", "MAX", "TRY", "CATCH", "EXISTS", 
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
                  "FUNCTION", "RETURN", "BREAK", "GOTO", "REVERT", "BROWSE", 
                  "GRANT", "REVOKE", "BULK", "GROUP", "RIGHT", "BY", "HAVING", 
                  "ROLLBACK", "CASCADE", "HOLDLOCK", "ROWCOUNT", "CASE", 
                  "IDENTITY", "ROWGUIDCOL", "CHECK", "IDENTITY_INSERT", 
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
                  "INT", "NVARCHAR", "VARCHAR", "MAX", "TRY", "CATCH", "EXISTS", 
                  "INT_LITERAL", "FLOAT_LITERAL", "HEX_LITERAL", "BIT_LITERAL", 
                  "TRUE_LITERAL", "FALSE_LITERAL", "STRING_LITERAL", "BRACKET_IDENTIFIER", 
                  "IDENTIFIER", "USER_VAR", "EQ", "NEQ", "GT", "LT", "GTE", 
                  "LTE", "PLUS", "MINUS", "STAR", "SLASH", "PLUS_EQ", "COMMA", 
                  "DOT", "LPAREN", "RPAREN", "SPAREN", "ZPAREN", "SEMI", 
                  "LINE_COMMENT", "COMMENT", "WS" ]

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
            actions[195] = self.STRING_LITERAL_action 
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
- **Size**: 164.86 KB
- **Extension**: `.java`
- **Language**: `java`
- **Location**: `SqlParser.java`
- **Relative Path**: `root`
- **Created**: 2026-01-11 06:03:50 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-15 13:30:58 (Asia/Damascus / GMT+03:00)
- **MD5**: `758406b39fe9385eb8601afd75e71919`
- **SHA256**: `c4cb79690d7ccff61e654603c0e622366100de4f51b86574268232a02c5aff77`
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
		BREAK=34, GOTO=35, REVERT=36, BROWSE=37, GRANT=38, REVOKE=39, BULK=40, 
		GROUP=41, RIGHT=42, BY=43, HAVING=44, ROLLBACK=45, CASCADE=46, HOLDLOCK=47, 
		ROWCOUNT=48, CASE=49, IDENTITY=50, ROWGUIDCOL=51, CHECK=52, IDENTITY_INSERT=53, 
		RULE=54, CHECKPOINT=55, IDENTITYCOL=56, SAVE=57, CLOSE=58, IF=59, SCHEMA=60, 
		CLUSTERED=61, IN=62, SECURITYAUDIT=63, COALESCE=64, INDEX=65, SELECT=66, 
		COLLATE=67, INNER=68, SEMANTICKEYPHRASETABLE=69, COLUMN=70, INSERT=71, 
		SEMANTICSIMILARITYDETAILSTABLE=72, COMMIT=73, INTERSECT=74, SEMANTICSIMILARITYTABLE=75, 
		COMPUTE=76, INTO=77, SESSION_USER=78, CONSTRAINT=79, IS=80, SET=81, CONTAINS=82, 
		JOIN=83, SETUSER=84, CONTAINSTABLE=85, KEY=86, SHUTDOWN=87, CONTINUE=88, 
		KILL=89, SOME=90, CONVERT=91, LEFT=92, STATISTICS=93, CREATE=94, LIKE=95, 
		SYSTEM_USER=96, CROSS=97, LINENO=98, TABLE=99, CURRENT=100, LOAD=101, 
		TABLESAMPLE=102, CURRENT_DATE=103, MERGE=104, TEXTSIZE=105, CURRENT_TIME=106, 
		NATIONAL=107, THEN=108, CURRENT_TIMESTAMP=109, NOCHECK=110, TO=111, CURRENT_USER=112, 
		NONCLUSTERED=113, TOP=114, CURSOR=115, NOT=116, TRAN=117, DATABASE=118, 
		NULL=119, TRANSACTION=120, DBCC=121, NULLIF=122, TRIGGER=123, DEALLOCATE=124, 
		OF=125, TRUNCATE=126, DECLARE=127, OFF=128, TRY_CONVERT=129, DEFAULT=130, 
		OFFSETS=131, TSEQUAL=132, DELETE=133, ON=134, UNION=135, DENY=136, OPEN=137, 
		UNIQUE=138, DESC=139, OPENDATASOURCE=140, UPDATE=141, DISK=142, OPENQUERY=143, 
		UPDATETEXT=144, DISTINCT=145, OPENROWSET=146, USE=147, DISTRIBUTED=148, 
		OPENXML=149, USER=150, DOUBLE=151, OPTION=152, VALUES=153, DROP=154, OR=155, 
		VARYING=156, DUMP=157, ORDER=158, VIEW=159, ELSE=160, OUTER=161, WAITFOR=162, 
		END=163, OVER=164, WHEN=165, ERRLVL=166, PERCENT=167, WHERE=168, ESCAPE=169, 
		PIVOT=170, WHILE=171, EXCEPT=172, PLAN=173, WITH=174, EXEC=175, PRECISION=176, 
		WRITETEXT=177, EXECUTE=178, PRIMARY=179, INT=180, NVARCHAR=181, VARCHAR=182, 
		MAX=183, TRY=184, CATCH=185, EXISTS=186, INT_LITERAL=187, FLOAT_LITERAL=188, 
		HEX_LITERAL=189, BIT_LITERAL=190, TRUE_LITERAL=191, FALSE_LITERAL=192, 
		STRING_LITERAL=193, BRACKET_IDENTIFIER=194, IDENTIFIER=195, USER_VAR=196, 
		EQ=197, NEQ=198, GT=199, LT=200, GTE=201, LTE=202, PLUS=203, MINUS=204, 
		STAR=205, SLASH=206, PLUS_EQ=207, COMMA=208, DOT=209, LPAREN=210, RPAREN=211, 
		SPAREN=212, ZPAREN=213, SEMI=214, LINE_COMMENT=215, COMMENT=216, WS=217;
	public static final int
		RULE_sqlFile = 0, RULE_sqlStatement = 1, RULE_cteStatement = 2, RULE_cteDefinition = 3, 
		RULE_dmlStatement = 4, RULE_selectStatement = 5, RULE_selectList = 6, 
		RULE_selectElement = 7, RULE_tableSource = 8, RULE_tableName = 9, RULE_joinClause = 10, 
		RULE_joinType = 11, RULE_columnName = 12, RULE_whereClause = 13, RULE_groupByClause = 14, 
		RULE_orderByClause = 15, RULE_orderElement = 16, RULE_searchCondition = 17, 
		RULE_predicate = 18, RULE_comparisonOperator = 19, RULE_expression = 20, 
		RULE_assignmentExpression = 21, RULE_additiveExpression = 22, RULE_multiplicativeExpression = 23, 
		RULE_unaryExpression = 24, RULE_primaryExpression = 25, RULE_caseExpression = 26, 
		RULE_whenClause = 27, RULE_literal = 28, RULE_functionCall = 29, RULE_insertStatement = 30, 
		RULE_updateStatement = 31, RULE_assignment = 32, RULE_deleteStatement = 33, 
		RULE_ddlStatement = 34, RULE_createTableStatement = 35, RULE_columnDefinition = 36, 
		RULE_nullability = 37, RULE_dataType = 38, RULE_typeParams = 39, RULE_dropTableStatement = 40, 
		RULE_alterTableStatement = 41, RULE_alterAction = 42, RULE_cursorStatement = 43, 
		RULE_declareCursor = 44, RULE_openCursor = 45, RULE_fetchCursor = 46, 
		RULE_closeCursor = 47, RULE_blockStatement = 48, RULE_blockContent = 49, 
		RULE_execStatement = 50, RULE_tryCatchStatement = 51, RULE_ifStatement = 52, 
		RULE_declareStatement = 53, RULE_setStatement = 54;
	private static String[] makeRuleNames() {
		return new String[] {
			"sqlFile", "sqlStatement", "cteStatement", "cteDefinition", "dmlStatement", 
			"selectStatement", "selectList", "selectElement", "tableSource", "tableName", 
			"joinClause", "joinType", "columnName", "whereClause", "groupByClause", 
			"orderByClause", "orderElement", "searchCondition", "predicate", "comparisonOperator", 
			"expression", "assignmentExpression", "additiveExpression", "multiplicativeExpression", 
			"unaryExpression", "primaryExpression", "caseExpression", "whenClause", 
			"literal", "functionCall", "insertStatement", "updateStatement", "assignment", 
			"deleteStatement", "ddlStatement", "createTableStatement", "columnDefinition", 
			"nullability", "dataType", "typeParams", "dropTableStatement", "alterTableStatement", 
			"alterAction", "cursorStatement", "declareCursor", "openCursor", "fetchCursor", 
			"closeCursor", "blockStatement", "blockContent", "execStatement", "tryCatchStatement", 
			"ifStatement", "declareStatement", "setStatement"
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
			"'REVERT'", "'BROWSE'", "'GRANT'", "'REVOKE'", "'BULK'", "'GROUP'", "'RIGHT'", 
			"'BY'", "'HAVING'", "'ROLLBACK'", "'CASCADE'", "'HOLDLOCK'", "'ROWCOUNT'", 
			"'CASE'", "'IDENTITY'", "'ROWGUIDCOL'", "'CHECK'", "'IDENTITY_INSERT'", 
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
			"'NVARCHAR'", "'VARCHAR'", "'MAX'", "'TRY'", "'CATCH'", "'EXISTS'", null, 
			null, null, null, "'TRUE'", "'FALSE'", null, null, null, null, "'='", 
			null, "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'+='", 
			"','", "'.'", "'('", "')'", "'['", "']'", "';'"
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
			"REVERT", "BROWSE", "GRANT", "REVOKE", "BULK", "GROUP", "RIGHT", "BY", 
			"HAVING", "ROLLBACK", "CASCADE", "HOLDLOCK", "ROWCOUNT", "CASE", "IDENTITY", 
			"ROWGUIDCOL", "CHECK", "IDENTITY_INSERT", "RULE", "CHECKPOINT", "IDENTITYCOL", 
			"SAVE", "CLOSE", "IF", "SCHEMA", "CLUSTERED", "IN", "SECURITYAUDIT", 
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
			"NVARCHAR", "VARCHAR", "MAX", "TRY", "CATCH", "EXISTS", "INT_LITERAL", 
			"FLOAT_LITERAL", "HEX_LITERAL", "BIT_LITERAL", "TRUE_LITERAL", "FALSE_LITERAL", 
			"STRING_LITERAL", "BRACKET_IDENTIFIER", "IDENTIFIER", "USER_VAR", "EQ", 
			"NEQ", "GT", "LT", "GTE", "LTE", "PLUS", "MINUS", "STAR", "SLASH", "PLUS_EQ", 
			"COMMA", "DOT", "LPAREN", "RPAREN", "SPAREN", "ZPAREN", "SEMI", "LINE_COMMENT", 
			"COMMENT", "WS"
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
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691128723570848L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 2305843009482162209L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 41781443952913L) != 0)) {
				{
				{
				setState(110);
				sqlStatement();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
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
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(118);
				cteStatement();
				}
			}

			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(121);
				dmlStatement();
				}
				break;
			case 2:
				{
				setState(122);
				ddlStatement();
				}
				break;
			case 3:
				{
				setState(123);
				cursorStatement();
				}
				break;
			case 4:
				{
				setState(124);
				ifStatement();
				}
				break;
			case 5:
				{
				setState(125);
				blockStatement();
				}
				break;
			case 6:
				{
				setState(126);
				execStatement();
				}
				break;
			case 7:
				{
				setState(127);
				tryCatchStatement();
				}
				break;
			}
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(130);
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
			setState(133);
			match(WITH);
			setState(134);
			cteDefinition();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(135);
				match(COMMA);
				setState(136);
				cteDefinition();
				}
				}
				setState(141);
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
			setState(142);
			match(IDENTIFIER);
			setState(143);
			match(AS);
			setState(144);
			match(LPAREN);
			setState(145);
			selectStatement();
			setState(146);
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
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				selectStatement();
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				insertStatement();
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				updateStatement();
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 4);
				{
				setState(151);
				deleteStatement();
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 5);
				{
				setState(152);
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
			setState(155);
			match(SELECT);
			setState(156);
			selectList();
			setState(157);
			match(FROM);
			setState(158);
			tableSource();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 29)) & ~0x3f) == 0 && ((1L << (_la - 29)) & -9205357088589471743L) != 0)) {
				{
				{
				setState(159);
				joinClause();
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(165);
				whereClause();
				}
			}

			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(168);
				groupByClause();
				}
			}

			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(171);
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
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(STAR);
				}
				break;
			case NULL:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case TRUE_LITERAL:
			case FALSE_LITERAL:
			case STRING_LITERAL:
			case BRACKET_IDENTIFIER:
			case IDENTIFIER:
			case USER_VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				selectElement();
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(176);
					match(COMMA);
					setState(177);
					selectElement();
					}
					}
					setState(182);
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
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode USER_VAR() { return getToken(SqlParser.USER_VAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SqlParser.EQ, 0); }
		public TerminalNode PLUS_EQ() { return getToken(SqlParser.PLUS_EQ, 0); }
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
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				columnName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(187);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(188);
				match(USER_VAR);
				setState(189);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==PLUS_EQ) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(190);
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
	public static class TableSourceContext extends ParserRuleContext {
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
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
			setState(195);
			_la = _input.LA(1);
			if ( !(_la==BRACKET_IDENTIFIER || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(196);
				match(DOT);
				setState(197);
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
				setState(202);
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
			setState(203);
			joinType();
			setState(204);
			match(JOIN);
			setState(205);
			tableSource();
			setState(206);
			match(ON);
			setState(207);
			searchCondition(0);
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
		try {
			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(INNER);
				}
				break;
			case LEFT:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				match(LEFT);
				}
				break;
			case RIGHT:
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				match(RIGHT);
				}
				break;
			case FULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(212);
				match(FULL);
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
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public TerminalNode BRACKET_IDENTIFIER() { return getToken(SqlParser.BRACKET_IDENTIFIER, 0); }
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
			setState(218);
			match(WHERE);
			setState(219);
			searchCondition(0);
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
			setState(221);
			match(GROUP);
			setState(222);
			match(BY);
			setState(223);
			columnName();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(224);
				match(COMMA);
				setState(225);
				columnName();
				}
				}
				setState(230);
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
			setState(231);
			match(ORDER);
			setState(232);
			match(BY);
			setState(233);
			orderElement();
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(234);
				match(COMMA);
				setState(235);
				orderElement();
				}
				}
				setState(240);
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
			setState(241);
			columnName();
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(242);
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
		public TerminalNode LPAREN() { return getToken(SqlParser.LPAREN, 0); }
		public List<SearchConditionContext> searchCondition() {
			return getRuleContexts(SearchConditionContext.class);
		}
		public SearchConditionContext searchCondition(int i) {
			return getRuleContext(SearchConditionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(SqlParser.RPAREN, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode AND() { return getToken(SqlParser.AND, 0); }
		public TerminalNode OR() { return getToken(SqlParser.OR, 0); }
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
		return searchCondition(0);
	}

	private SearchConditionContext searchCondition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SearchConditionContext _localctx = new SearchConditionContext(_ctx, _parentState);
		SearchConditionContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_searchCondition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(246);
				match(LPAREN);
				setState(247);
				searchCondition(0);
				setState(248);
				match(RPAREN);
				}
				break;
			case 2:
				{
				setState(250);
				predicate();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(261);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(259);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new SearchConditionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_searchCondition);
						setState(253);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(254);
						match(AND);
						setState(255);
						searchCondition(5);
						}
						break;
					case 2:
						{
						_localctx = new SearchConditionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_searchCondition);
						setState(256);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(257);
						match(OR);
						setState(258);
						searchCondition(4);
						}
						break;
					}
					} 
				}
				setState(263);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
	public static class PredicateContext extends ParserRuleContext {
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
		public TerminalNode LPAREN() { return getToken(SqlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SqlParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TerminalNode IS() { return getToken(SqlParser.IS, 0); }
		public TerminalNode NULL() { return getToken(SqlParser.NULL, 0); }
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SqlParser.EXISTS, 0); }
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
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
		enterRule(_localctx, 36, RULE_predicate);
		int _la;
		try {
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				expression();
				setState(265);
				comparisonOperator();
				setState(266);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				expression();
				setState(269);
				match(IN);
				setState(270);
				match(LPAREN);
				setState(271);
				expression();
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(272);
					match(COMMA);
					setState(273);
					expression();
					}
					}
					setState(278);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(279);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(281);
				expression();
				setState(282);
				match(IS);
				setState(283);
				match(NULL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(285);
				expression();
				setState(286);
				match(IS);
				setState(287);
				match(NOT);
				setState(288);
				match(NULL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(290);
				match(EXISTS);
				setState(291);
				match(LPAREN);
				setState(292);
				selectStatement();
				setState(293);
				match(RPAREN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(295);
				match(NOT);
				setState(296);
				match(EXISTS);
				setState(297);
				match(LPAREN);
				setState(298);
				selectStatement();
				setState(299);
				match(RPAREN);
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
		enterRule(_localctx, 38, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			_la = _input.LA(1);
			if ( !(((((_la - 197)) & ~0x3f) == 0 && ((1L << (_la - 197)) & 63L) != 0)) ) {
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
		enterRule(_localctx, 40, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
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
		enterRule(_localctx, 42, RULE_assignmentExpression);
		int _la;
		try {
			setState(311);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				match(USER_VAR);
				setState(308);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==PLUS_EQ) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(309);
				additiveExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(314);
			multiplicativeExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(324);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(322);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(316);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(317);
						match(PLUS);
						setState(318);
						multiplicativeExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(319);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(320);
						match(MINUS);
						setState(321);
						multiplicativeExpression(0);
						}
						break;
					}
					} 
				}
				setState(326);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_multiplicativeExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(328);
			unaryExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(338);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(336);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(330);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(331);
						match(STAR);
						setState(332);
						unaryExpression();
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(333);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(334);
						match(SLASH);
						setState(335);
						unaryExpression();
						}
						break;
					}
					} 
				}
				setState(340);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
		enterRule(_localctx, 48, RULE_unaryExpression);
		try {
			setState(346);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(341);
				match(PLUS);
				setState(342);
				unaryExpression();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				match(MINUS);
				setState(344);
				unaryExpression();
				}
				break;
			case NULL:
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
				setState(345);
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
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode USER_VAR() { return getToken(SqlParser.USER_VAR, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(SqlParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SqlParser.RPAREN, 0); }
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
		enterRule(_localctx, 50, RULE_primaryExpression);
		try {
			setState(356);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				columnName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				match(USER_VAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(351);
				functionCall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(352);
				match(LPAREN);
				setState(353);
				expression();
				setState(354);
				match(RPAREN);
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
		enterRule(_localctx, 52, RULE_caseExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			match(CASE);
			setState(360); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(359);
				whenClause();
				}
				}
				setState(362); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(364);
				match(ELSE);
				setState(365);
				expression();
				}
			}

			setState(368);
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
		enterRule(_localctx, 54, RULE_whenClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(WHEN);
			setState(371);
			searchCondition(0);
			setState(372);
			match(THEN);
			setState(373);
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
		enterRule(_localctx, 56, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			_la = _input.LA(1);
			if ( !(_la==NULL || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & 115L) != 0)) ) {
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
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(SqlParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SqlParser.RPAREN, 0); }
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
		public TerminalNode BRACKET_IDENTIFIER() { return getToken(SqlParser.BRACKET_IDENTIFIER, 0); }
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
		enterRule(_localctx, 58, RULE_functionCall);
		int _la;
		try {
			setState(403);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(377);
				match(IDENTIFIER);
				setState(378);
				match(LPAREN);
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NULL || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & 8586227L) != 0)) {
					{
					setState(379);
					expression();
					setState(384);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(380);
						match(COMMA);
						setState(381);
						expression();
						}
						}
						setState(386);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(389);
				match(RPAREN);
				}
				break;
			case BRACKET_IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(390);
				match(BRACKET_IDENTIFIER);
				setState(391);
				match(LPAREN);
				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NULL || ((((_la - 187)) & ~0x3f) == 0 && ((1L << (_la - 187)) & 8586227L) != 0)) {
					{
					setState(392);
					expression();
					setState(397);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(393);
						match(COMMA);
						setState(394);
						expression();
						}
						}
						setState(399);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(402);
				match(RPAREN);
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
		enterRule(_localctx, 60, RULE_insertStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			match(INSERT);
			setState(406);
			match(INTO);
			setState(407);
			tableName();
			setState(408);
			match(LPAREN);
			setState(409);
			columnName();
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(410);
				match(COMMA);
				setState(411);
				columnName();
				}
				}
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(417);
			match(RPAREN);
			setState(418);
			match(VALUES);
			setState(419);
			match(LPAREN);
			setState(420);
			literal();
			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(421);
				match(COMMA);
				setState(422);
				literal();
				}
				}
				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(428);
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
		enterRule(_localctx, 62, RULE_updateStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			match(UPDATE);
			setState(431);
			tableName();
			setState(432);
			match(SET);
			setState(433);
			assignment();
			setState(438);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(434);
				match(COMMA);
				setState(435);
				assignment();
				}
				}
				setState(440);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(441);
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
		enterRule(_localctx, 64, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			columnName();
			setState(445);
			_la = _input.LA(1);
			if ( !(_la==EQ || _la==PLUS_EQ) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(446);
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
		enterRule(_localctx, 66, RULE_deleteStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			match(DELETE);
			setState(449);
			match(FROM);
			setState(450);
			tableName();
			setState(452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(451);
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
		enterRule(_localctx, 68, RULE_ddlStatement);
		try {
			setState(458);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(454);
				createTableStatement();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(455);
				dropTableStatement();
				}
				break;
			case ALTER:
				enterOuterAlt(_localctx, 3);
				{
				setState(456);
				alterTableStatement();
				}
				break;
			case DECLARE:
				enterOuterAlt(_localctx, 4);
				{
				setState(457);
				declareStatement();
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
		enterRule(_localctx, 70, RULE_createTableStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			match(CREATE);
			setState(461);
			match(TABLE);
			setState(462);
			tableName();
			setState(463);
			match(LPAREN);
			setState(464);
			columnDefinition();
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(465);
				match(COMMA);
				setState(466);
				columnDefinition();
				}
				}
				setState(471);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(472);
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
		public NullabilityContext nullability() {
			return getRuleContext(NullabilityContext.class,0);
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
		enterRule(_localctx, 72, RULE_columnDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			columnName();
			setState(475);
			dataType();
			setState(477);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT || _la==NULL) {
				{
				setState(476);
				nullability();
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
	public static class NullabilityContext extends ParserRuleContext {
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
		enterRule(_localctx, 74, RULE_nullability);
		try {
			setState(482);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NULL:
				enterOuterAlt(_localctx, 1);
				{
				setState(479);
				match(NULL);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(480);
				match(NOT);
				setState(481);
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
		enterRule(_localctx, 76, RULE_dataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(484);
				match(INT);
				}
				break;
			case NVARCHAR:
				{
				setState(485);
				match(NVARCHAR);
				setState(486);
				match(LPAREN);
				setState(487);
				_la = _input.LA(1);
				if ( !(_la==MAX || _la==INT_LITERAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(488);
				match(RPAREN);
				}
				break;
			case VARCHAR:
				{
				setState(489);
				match(VARCHAR);
				setState(490);
				match(LPAREN);
				setState(491);
				_la = _input.LA(1);
				if ( !(_la==MAX || _la==INT_LITERAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(492);
				match(RPAREN);
				}
				break;
			case BRACKET_IDENTIFIER:
				{
				setState(493);
				match(BRACKET_IDENTIFIER);
				}
				break;
			case IDENTIFIER:
				{
				setState(494);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(497);
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
		enterRule(_localctx, 78, RULE_typeParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			match(LPAREN);
			setState(501);
			_la = _input.LA(1);
			if ( !(_la==MAX || _la==INT_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(502);
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
		enterRule(_localctx, 80, RULE_dropTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			match(DROP);
			setState(505);
			match(TABLE);
			setState(506);
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
		enterRule(_localctx, 82, RULE_alterTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			match(ALTER);
			setState(509);
			match(TABLE);
			setState(510);
			tableName();
			setState(511);
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
		enterRule(_localctx, 84, RULE_alterAction);
		try {
			setState(517);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(513);
				match(ADD);
				setState(514);
				columnDefinition();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(515);
				match(DROP);
				setState(516);
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
		enterRule(_localctx, 86, RULE_cursorStatement);
		try {
			setState(523);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECLARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(519);
				declareCursor();
				}
				break;
			case OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(520);
				openCursor();
				}
				break;
			case FETCH:
				enterOuterAlt(_localctx, 3);
				{
				setState(521);
				fetchCursor();
				}
				break;
			case CLOSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(522);
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
		enterRule(_localctx, 88, RULE_declareCursor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			match(DECLARE);
			setState(526);
			match(IDENTIFIER);
			setState(527);
			match(CURSOR);
			setState(528);
			match(FOR);
			setState(529);
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
		enterRule(_localctx, 90, RULE_openCursor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			match(OPEN);
			setState(532);
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
		enterRule(_localctx, 92, RULE_fetchCursor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			match(FETCH);
			setState(535);
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
		enterRule(_localctx, 94, RULE_closeCursor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			match(CLOSE);
			setState(538);
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
		enterRule(_localctx, 96, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			match(BEGIN);
			setState(544);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691128723570848L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 2305843009482162209L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 41781443952913L) != 0)) {
				{
				{
				setState(541);
				blockContent();
				}
				}
				setState(546);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(547);
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
		enterRule(_localctx, 98, RULE_blockContent);
		try {
			setState(551);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(549);
				sqlStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(550);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EXEC() { return getToken(SqlParser.EXEC, 0); }
		public TerminalNode EXECUTE() { return getToken(SqlParser.EXECUTE, 0); }
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
		enterRule(_localctx, 100, RULE_execStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			_la = _input.LA(1);
			if ( !(_la==EXEC || _la==EXECUTE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(554);
			expression();
			setState(559);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(555);
				match(COMMA);
				setState(556);
				expression();
				}
				}
				setState(561);
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
		enterRule(_localctx, 102, RULE_tryCatchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			match(BEGIN);
			setState(563);
			match(TRY);
			setState(567);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691128723570848L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 2305843009482162209L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 41781443952913L) != 0)) {
				{
				{
				setState(564);
				blockContent();
				}
				}
				setState(569);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(570);
			match(END);
			setState(571);
			match(TRY);
			setState(572);
			match(BEGIN);
			setState(573);
			match(CATCH);
			setState(577);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691128723570848L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 2305843009482162209L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 41781443952913L) != 0)) {
				{
				{
				setState(574);
				blockContent();
				}
				}
				setState(579);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(580);
			match(END);
			setState(581);
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
		enterRule(_localctx, 104, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			match(IF);
			setState(584);
			searchCondition(0);
			setState(585);
			sqlStatement();
			setState(588);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(586);
				match(ELSE);
				setState(587);
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
		enterRule(_localctx, 106, RULE_declareStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
			match(DECLARE);
			setState(591);
			match(USER_VAR);
			setState(592);
			dataType();
			setState(595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(593);
				match(EQ);
				setState(594);
				expression();
				}
			}

			setState(606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(597);
				match(COMMA);
				setState(598);
				match(USER_VAR);
				setState(599);
				dataType();
				setState(602);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQ) {
					{
					setState(600);
					match(EQ);
					setState(601);
					expression();
					}
				}

				}
				}
				setState(608);
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
		enterRule(_localctx, 108, RULE_setStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			match(SET);
			setState(610);
			match(USER_VAR);
			setState(611);
			_la = _input.LA(1);
			if ( !(_la==EQ || _la==PLUS_EQ) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(612);
			expression();
			setState(619);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(613);
				match(COMMA);
				setState(614);
				match(USER_VAR);
				setState(615);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==PLUS_EQ) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(616);
				expression();
				}
				}
				setState(621);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(623);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(622);
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
		case 17:
			return searchCondition_sempred((SearchConditionContext)_localctx, predIndex);
		case 22:
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 23:
			return multiplicativeExpression_sempred((MultiplicativeExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean searchCondition_sempred(SearchConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
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
		"\u0004\u0001\u00d9\u0272\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
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
		"6\u0001\u0000\u0005\u0000p\b\u0000\n\u0000\f\u0000s\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0003\u0001x\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u0081\b\u0001\u0001\u0001\u0003\u0001\u0084\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u008a\b\u0002\n\u0002\f\u0002"+
		"\u008d\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u009a\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u00a1\b\u0005\n\u0005\f\u0005\u00a4\t\u0005\u0001"+
		"\u0005\u0003\u0005\u00a7\b\u0005\u0001\u0005\u0003\u0005\u00aa\b\u0005"+
		"\u0001\u0005\u0003\u0005\u00ad\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u00b3\b\u0006\n\u0006\f\u0006\u00b6\t\u0006\u0003"+
		"\u0006\u00b8\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00c0\b\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u00c7\b\t\n\t\f\t\u00ca\t\t\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00d7\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u00e3\b\u000e\n\u000e\f\u000e\u00e6\t\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00ed\b\u000f\n\u000f"+
		"\f\u000f\u00f0\t\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u00f4\b\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u00fc\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u0104\b\u0011\n\u0011\f\u0011\u0107"+
		"\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0113"+
		"\b\u0012\n\u0012\f\u0012\u0116\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u012e\b\u0012\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u0138\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0143\b\u0016"+
		"\n\u0016\f\u0016\u0146\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005"+
		"\u0017\u0151\b\u0017\n\u0017\f\u0017\u0154\t\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u015b\b\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0165\b\u0019\u0001\u001a\u0001\u001a\u0004\u001a"+
		"\u0169\b\u001a\u000b\u001a\f\u001a\u016a\u0001\u001a\u0001\u001a\u0003"+
		"\u001a\u016f\b\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u017f\b\u001d\n"+
		"\u001d\f\u001d\u0182\t\u001d\u0003\u001d\u0184\b\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u018c"+
		"\b\u001d\n\u001d\f\u001d\u018f\t\u001d\u0003\u001d\u0191\b\u001d\u0001"+
		"\u001d\u0003\u001d\u0194\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u019d\b\u001e\n"+
		"\u001e\f\u001e\u01a0\t\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u01a8\b\u001e\n\u001e\f\u001e"+
		"\u01ab\t\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u01b5\b\u001f\n\u001f"+
		"\f\u001f\u01b8\t\u001f\u0001\u001f\u0003\u001f\u01bb\b\u001f\u0001 \u0001"+
		" \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0003!\u01c5\b!\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0003\"\u01cb\b\"\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0005#\u01d4\b#\n#\f#\u01d7\t#\u0001#\u0001#\u0001$\u0001"+
		"$\u0001$\u0003$\u01de\b$\u0001%\u0001%\u0001%\u0003%\u01e3\b%\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003"+
		"&\u01f0\b&\u0001&\u0003&\u01f3\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"(\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001*\u0001"+
		"*\u0001*\u0001*\u0003*\u0206\b*\u0001+\u0001+\u0001+\u0001+\u0003+\u020c"+
		"\b+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001"+
		".\u0001.\u0001.\u0001/\u0001/\u0001/\u00010\u00010\u00050\u021f\b0\n0"+
		"\f0\u0222\t0\u00010\u00010\u00011\u00011\u00031\u0228\b1\u00012\u0001"+
		"2\u00012\u00012\u00052\u022e\b2\n2\f2\u0231\t2\u00013\u00013\u00013\u0005"+
		"3\u0236\b3\n3\f3\u0239\t3\u00013\u00013\u00013\u00013\u00013\u00053\u0240"+
		"\b3\n3\f3\u0243\t3\u00013\u00013\u00013\u00014\u00014\u00014\u00014\u0001"+
		"4\u00034\u024d\b4\u00015\u00015\u00015\u00015\u00015\u00035\u0254\b5\u0001"+
		"5\u00015\u00015\u00015\u00015\u00035\u025b\b5\u00055\u025d\b5\n5\f5\u0260"+
		"\t5\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00056\u026a"+
		"\b6\n6\f6\u026d\t6\u00016\u00036\u0270\b6\u00016\u0000\u0003\",.7\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjl\u0000\u0007\u0002\u0000"+
		"\u00c5\u00c5\u00cf\u00cf\u0001\u0000\u00c2\u00c3\u0002\u0000\u0013\u0013"+
		"\u008b\u008b\u0001\u0000\u00c5\u00ca\u0003\u0000ww\u00bb\u00bc\u00bf\u00c1"+
		"\u0002\u0000\u00b7\u00b7\u00bb\u00bb\u0002\u0000\u00af\u00af\u00b2\u00b2"+
		"\u0293\u0000q\u0001\u0000\u0000\u0000\u0002w\u0001\u0000\u0000\u0000\u0004"+
		"\u0085\u0001\u0000\u0000\u0000\u0006\u008e\u0001\u0000\u0000\u0000\b\u0099"+
		"\u0001\u0000\u0000\u0000\n\u009b\u0001\u0000\u0000\u0000\f\u00b7\u0001"+
		"\u0000\u0000\u0000\u000e\u00bf\u0001\u0000\u0000\u0000\u0010\u00c1\u0001"+
		"\u0000\u0000\u0000\u0012\u00c3\u0001\u0000\u0000\u0000\u0014\u00cb\u0001"+
		"\u0000\u0000\u0000\u0016\u00d6\u0001\u0000\u0000\u0000\u0018\u00d8\u0001"+
		"\u0000\u0000\u0000\u001a\u00da\u0001\u0000\u0000\u0000\u001c\u00dd\u0001"+
		"\u0000\u0000\u0000\u001e\u00e7\u0001\u0000\u0000\u0000 \u00f1\u0001\u0000"+
		"\u0000\u0000\"\u00fb\u0001\u0000\u0000\u0000$\u012d\u0001\u0000\u0000"+
		"\u0000&\u012f\u0001\u0000\u0000\u0000(\u0131\u0001\u0000\u0000\u0000*"+
		"\u0137\u0001\u0000\u0000\u0000,\u0139\u0001\u0000\u0000\u0000.\u0147\u0001"+
		"\u0000\u0000\u00000\u015a\u0001\u0000\u0000\u00002\u0164\u0001\u0000\u0000"+
		"\u00004\u0166\u0001\u0000\u0000\u00006\u0172\u0001\u0000\u0000\u00008"+
		"\u0177\u0001\u0000\u0000\u0000:\u0193\u0001\u0000\u0000\u0000<\u0195\u0001"+
		"\u0000\u0000\u0000>\u01ae\u0001\u0000\u0000\u0000@\u01bc\u0001\u0000\u0000"+
		"\u0000B\u01c0\u0001\u0000\u0000\u0000D\u01ca\u0001\u0000\u0000\u0000F"+
		"\u01cc\u0001\u0000\u0000\u0000H\u01da\u0001\u0000\u0000\u0000J\u01e2\u0001"+
		"\u0000\u0000\u0000L\u01ef\u0001\u0000\u0000\u0000N\u01f4\u0001\u0000\u0000"+
		"\u0000P\u01f8\u0001\u0000\u0000\u0000R\u01fc\u0001\u0000\u0000\u0000T"+
		"\u0205\u0001\u0000\u0000\u0000V\u020b\u0001\u0000\u0000\u0000X\u020d\u0001"+
		"\u0000\u0000\u0000Z\u0213\u0001\u0000\u0000\u0000\\\u0216\u0001\u0000"+
		"\u0000\u0000^\u0219\u0001\u0000\u0000\u0000`\u021c\u0001\u0000\u0000\u0000"+
		"b\u0227\u0001\u0000\u0000\u0000d\u0229\u0001\u0000\u0000\u0000f\u0232"+
		"\u0001\u0000\u0000\u0000h\u0247\u0001\u0000\u0000\u0000j\u024e\u0001\u0000"+
		"\u0000\u0000l\u0261\u0001\u0000\u0000\u0000np\u0003\u0002\u0001\u0000"+
		"on\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000"+
		"\u0000qr\u0001\u0000\u0000\u0000rt\u0001\u0000\u0000\u0000sq\u0001\u0000"+
		"\u0000\u0000tu\u0005\u0000\u0000\u0001u\u0001\u0001\u0000\u0000\u0000"+
		"vx\u0003\u0004\u0002\u0000wv\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000"+
		"\u0000x\u0080\u0001\u0000\u0000\u0000y\u0081\u0003\b\u0004\u0000z\u0081"+
		"\u0003D\"\u0000{\u0081\u0003V+\u0000|\u0081\u0003h4\u0000}\u0081\u0003"+
		"`0\u0000~\u0081\u0003d2\u0000\u007f\u0081\u0003f3\u0000\u0080y\u0001\u0000"+
		"\u0000\u0000\u0080z\u0001\u0000\u0000\u0000\u0080{\u0001\u0000\u0000\u0000"+
		"\u0080|\u0001\u0000\u0000\u0000\u0080}\u0001\u0000\u0000\u0000\u0080~"+
		"\u0001\u0000\u0000\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0083"+
		"\u0001\u0000\u0000\u0000\u0082\u0084\u0005\u00d6\u0000\u0000\u0083\u0082"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0003"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u00ae\u0000\u0000\u0086\u008b"+
		"\u0003\u0006\u0003\u0000\u0087\u0088\u0005\u00d0\u0000\u0000\u0088\u008a"+
		"\u0003\u0006\u0003\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008d"+
		"\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c"+
		"\u0001\u0000\u0000\u0000\u008c\u0005\u0001\u0000\u0000\u0000\u008d\u008b"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0005\u00c3\u0000\u0000\u008f\u0090"+
		"\u0005\u0010\u0000\u0000\u0090\u0091\u0005\u00d2\u0000\u0000\u0091\u0092"+
		"\u0003\n\u0005\u0000\u0092\u0093\u0005\u00d3\u0000\u0000\u0093\u0007\u0001"+
		"\u0000\u0000\u0000\u0094\u009a\u0003\n\u0005\u0000\u0095\u009a\u0003<"+
		"\u001e\u0000\u0096\u009a\u0003>\u001f\u0000\u0097\u009a\u0003B!\u0000"+
		"\u0098\u009a\u0003l6\u0000\u0099\u0094\u0001\u0000\u0000\u0000\u0099\u0095"+
		"\u0001\u0000\u0000\u0000\u0099\u0096\u0001\u0000\u0000\u0000\u0099\u0097"+
		"\u0001\u0000\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u009a\t\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0005B\u0000\u0000\u009c\u009d\u0003\f"+
		"\u0006\u0000\u009d\u009e\u0005\u001a\u0000\u0000\u009e\u00a2\u0003\u0010"+
		"\b\u0000\u009f\u00a1\u0003\u0014\n\u0000\u00a0\u009f\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a7\u0003\u001a\r\u0000"+
		"\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a9\u0001\u0000\u0000\u0000\u00a8\u00aa\u0003\u001c\u000e\u0000"+
		"\u00a9\u00a8\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ac\u0001\u0000\u0000\u0000\u00ab\u00ad\u0003\u001e\u000f\u0000"+
		"\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000"+
		"\u00ad\u000b\u0001\u0000\u0000\u0000\u00ae\u00b8\u0005\u00cd\u0000\u0000"+
		"\u00af\u00b4\u0003\u000e\u0007\u0000\u00b0\u00b1\u0005\u00d0\u0000\u0000"+
		"\u00b1\u00b3\u0003\u000e\u0007\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b6\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7\u00ae\u0001\u0000\u0000\u0000"+
		"\u00b7\u00af\u0001\u0000\u0000\u0000\u00b8\r\u0001\u0000\u0000\u0000\u00b9"+
		"\u00c0\u0003\u0018\f\u0000\u00ba\u00c0\u00038\u001c\u0000\u00bb\u00c0"+
		"\u0003:\u001d\u0000\u00bc\u00bd\u0005\u00c4\u0000\u0000\u00bd\u00be\u0007"+
		"\u0000\u0000\u0000\u00be\u00c0\u0003(\u0014\u0000\u00bf\u00b9\u0001\u0000"+
		"\u0000\u0000\u00bf\u00ba\u0001\u0000\u0000\u0000\u00bf\u00bb\u0001\u0000"+
		"\u0000\u0000\u00bf\u00bc\u0001\u0000\u0000\u0000\u00c0\u000f\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0003\u0012\t\u0000\u00c2\u0011\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c8\u0007\u0001\u0000\u0000\u00c4\u00c5\u0005\u00d1\u0000"+
		"\u0000\u00c5\u00c7\u0007\u0001\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c7\u00ca\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u0013\u0001\u0000\u0000"+
		"\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00cb\u00cc\u0003\u0016\u000b"+
		"\u0000\u00cc\u00cd\u0005S\u0000\u0000\u00cd\u00ce\u0003\u0010\b\u0000"+
		"\u00ce\u00cf\u0005\u0086\u0000\u0000\u00cf\u00d0\u0003\"\u0011\u0000\u00d0"+
		"\u0015\u0001\u0000\u0000\u0000\u00d1\u00d7\u0005D\u0000\u0000\u00d2\u00d7"+
		"\u0005\\\u0000\u0000\u00d3\u00d7\u0005*\u0000\u0000\u00d4\u00d7\u0005"+
		"\u001d\u0000\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000\u00d6\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d2\u0001\u0000\u0000\u0000\u00d6\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d7\u0017\u0001\u0000\u0000\u0000\u00d8\u00d9\u0007"+
		"\u0001\u0000\u0000\u00d9\u0019\u0001\u0000\u0000\u0000\u00da\u00db\u0005"+
		"\u00a8\u0000\u0000\u00db\u00dc\u0003\"\u0011\u0000\u00dc\u001b\u0001\u0000"+
		"\u0000\u0000\u00dd\u00de\u0005)\u0000\u0000\u00de\u00df\u0005+\u0000\u0000"+
		"\u00df\u00e4\u0003\u0018\f\u0000\u00e0\u00e1\u0005\u00d0\u0000\u0000\u00e1"+
		"\u00e3\u0003\u0018\f\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e5\u001d\u0001\u0000\u0000\u0000\u00e6\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e7\u00e8\u0005\u009e\u0000\u0000\u00e8\u00e9"+
		"\u0005+\u0000\u0000\u00e9\u00ee\u0003 \u0010\u0000\u00ea\u00eb\u0005\u00d0"+
		"\u0000\u0000\u00eb\u00ed\u0003 \u0010\u0000\u00ec\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ed\u00f0\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u001f\u0001\u0000\u0000"+
		"\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1\u00f3\u0003\u0018\f\u0000"+
		"\u00f2\u00f4\u0007\u0002\u0000\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4!\u0001\u0000\u0000\u0000\u00f5"+
		"\u00f6\u0006\u0011\uffff\uffff\u0000\u00f6\u00f7\u0005\u00d2\u0000\u0000"+
		"\u00f7\u00f8\u0003\"\u0011\u0000\u00f8\u00f9\u0005\u00d3\u0000\u0000\u00f9"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fa\u00fc\u0003$\u0012\u0000\u00fb\u00f5"+
		"\u0001\u0000\u0000\u0000\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fc\u0105"+
		"\u0001\u0000\u0000\u0000\u00fd\u00fe\n\u0004\u0000\u0000\u00fe\u00ff\u0005"+
		"\n\u0000\u0000\u00ff\u0104\u0003\"\u0011\u0005\u0100\u0101\n\u0003\u0000"+
		"\u0000\u0101\u0102\u0005\u009b\u0000\u0000\u0102\u0104\u0003\"\u0011\u0004"+
		"\u0103\u00fd\u0001\u0000\u0000\u0000\u0103\u0100\u0001\u0000\u0000\u0000"+
		"\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000"+
		"\u0105\u0106\u0001\u0000\u0000\u0000\u0106#\u0001\u0000\u0000\u0000\u0107"+
		"\u0105\u0001\u0000\u0000\u0000\u0108\u0109\u0003(\u0014\u0000\u0109\u010a"+
		"\u0003&\u0013\u0000\u010a\u010b\u0003(\u0014\u0000\u010b\u012e\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0003(\u0014\u0000\u010d\u010e\u0005>\u0000\u0000"+
		"\u010e\u010f\u0005\u00d2\u0000\u0000\u010f\u0114\u0003(\u0014\u0000\u0110"+
		"\u0111\u0005\u00d0\u0000\u0000\u0111\u0113\u0003(\u0014\u0000\u0112\u0110"+
		"\u0001\u0000\u0000\u0000\u0113\u0116\u0001\u0000\u0000\u0000\u0114\u0112"+
		"\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0117"+
		"\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0117\u0118"+
		"\u0005\u00d3\u0000\u0000\u0118\u012e\u0001\u0000\u0000\u0000\u0119\u011a"+
		"\u0003(\u0014\u0000\u011a\u011b\u0005P\u0000\u0000\u011b\u011c\u0005w"+
		"\u0000\u0000\u011c\u012e\u0001\u0000\u0000\u0000\u011d\u011e\u0003(\u0014"+
		"\u0000\u011e\u011f\u0005P\u0000\u0000\u011f\u0120\u0005t\u0000\u0000\u0120"+
		"\u0121\u0005w\u0000\u0000\u0121\u012e\u0001\u0000\u0000\u0000\u0122\u0123"+
		"\u0005\u00ba\u0000\u0000\u0123\u0124\u0005\u00d2\u0000\u0000\u0124\u0125"+
		"\u0003\n\u0005\u0000\u0125\u0126\u0005\u00d3\u0000\u0000\u0126\u012e\u0001"+
		"\u0000\u0000\u0000\u0127\u0128\u0005t\u0000\u0000\u0128\u0129\u0005\u00ba"+
		"\u0000\u0000\u0129\u012a\u0005\u00d2\u0000\u0000\u012a\u012b\u0003\n\u0005"+
		"\u0000\u012b\u012c\u0005\u00d3\u0000\u0000\u012c\u012e\u0001\u0000\u0000"+
		"\u0000\u012d\u0108\u0001\u0000\u0000\u0000\u012d\u010c\u0001\u0000\u0000"+
		"\u0000\u012d\u0119\u0001\u0000\u0000\u0000\u012d\u011d\u0001\u0000\u0000"+
		"\u0000\u012d\u0122\u0001\u0000\u0000\u0000\u012d\u0127\u0001\u0000\u0000"+
		"\u0000\u012e%\u0001\u0000\u0000\u0000\u012f\u0130\u0007\u0003\u0000\u0000"+
		"\u0130\'\u0001\u0000\u0000\u0000\u0131\u0132\u0003*\u0015\u0000\u0132"+
		")\u0001\u0000\u0000\u0000\u0133\u0134\u0005\u00c4\u0000\u0000\u0134\u0135"+
		"\u0007\u0000\u0000\u0000\u0135\u0138\u0003,\u0016\u0000\u0136\u0138\u0003"+
		",\u0016\u0000\u0137\u0133\u0001\u0000\u0000\u0000\u0137\u0136\u0001\u0000"+
		"\u0000\u0000\u0138+\u0001\u0000\u0000\u0000\u0139\u013a\u0006\u0016\uffff"+
		"\uffff\u0000\u013a\u013b\u0003.\u0017\u0000\u013b\u0144\u0001\u0000\u0000"+
		"\u0000\u013c\u013d\n\u0003\u0000\u0000\u013d\u013e\u0005\u00cb\u0000\u0000"+
		"\u013e\u0143\u0003.\u0017\u0000\u013f\u0140\n\u0002\u0000\u0000\u0140"+
		"\u0141\u0005\u00cc\u0000\u0000\u0141\u0143\u0003.\u0017\u0000\u0142\u013c"+
		"\u0001\u0000\u0000\u0000\u0142\u013f\u0001\u0000\u0000\u0000\u0143\u0146"+
		"\u0001\u0000\u0000\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0144\u0145"+
		"\u0001\u0000\u0000\u0000\u0145-\u0001\u0000\u0000\u0000\u0146\u0144\u0001"+
		"\u0000\u0000\u0000\u0147\u0148\u0006\u0017\uffff\uffff\u0000\u0148\u0149"+
		"\u00030\u0018\u0000\u0149\u0152\u0001\u0000\u0000\u0000\u014a\u014b\n"+
		"\u0003\u0000\u0000\u014b\u014c\u0005\u00cd\u0000\u0000\u014c\u0151\u0003"+
		"0\u0018\u0000\u014d\u014e\n\u0002\u0000\u0000\u014e\u014f\u0005\u00ce"+
		"\u0000\u0000\u014f\u0151\u00030\u0018\u0000\u0150\u014a\u0001\u0000\u0000"+
		"\u0000\u0150\u014d\u0001\u0000\u0000\u0000\u0151\u0154\u0001\u0000\u0000"+
		"\u0000\u0152\u0150\u0001\u0000\u0000\u0000\u0152\u0153\u0001\u0000\u0000"+
		"\u0000\u0153/\u0001\u0000\u0000\u0000\u0154\u0152\u0001\u0000\u0000\u0000"+
		"\u0155\u0156\u0005\u00cb\u0000\u0000\u0156\u015b\u00030\u0018\u0000\u0157"+
		"\u0158\u0005\u00cc\u0000\u0000\u0158\u015b\u00030\u0018\u0000\u0159\u015b"+
		"\u00032\u0019\u0000\u015a\u0155\u0001\u0000\u0000\u0000\u015a\u0157\u0001"+
		"\u0000\u0000\u0000\u015a\u0159\u0001\u0000\u0000\u0000\u015b1\u0001\u0000"+
		"\u0000\u0000\u015c\u0165\u0003\u0018\f\u0000\u015d\u0165\u00038\u001c"+
		"\u0000\u015e\u0165\u0005\u00c4\u0000\u0000\u015f\u0165\u0003:\u001d\u0000"+
		"\u0160\u0161\u0005\u00d2\u0000\u0000\u0161\u0162\u0003(\u0014\u0000\u0162"+
		"\u0163\u0005\u00d3\u0000\u0000\u0163\u0165\u0001\u0000\u0000\u0000\u0164"+
		"\u015c\u0001\u0000\u0000\u0000\u0164\u015d\u0001\u0000\u0000\u0000\u0164"+
		"\u015e\u0001\u0000\u0000\u0000\u0164\u015f\u0001\u0000\u0000\u0000\u0164"+
		"\u0160\u0001\u0000\u0000\u0000\u01653\u0001\u0000\u0000\u0000\u0166\u0168"+
		"\u00051\u0000\u0000\u0167\u0169\u00036\u001b\u0000\u0168\u0167\u0001\u0000"+
		"\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016a\u0168\u0001\u0000"+
		"\u0000\u0000\u016a\u016b\u0001\u0000\u0000\u0000\u016b\u016e\u0001\u0000"+
		"\u0000\u0000\u016c\u016d\u0005\u00a0\u0000\u0000\u016d\u016f\u0003(\u0014"+
		"\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000"+
		"\u0000\u016f\u0170\u0001\u0000\u0000\u0000\u0170\u0171\u0005\u00a3\u0000"+
		"\u0000\u01715\u0001\u0000\u0000\u0000\u0172\u0173\u0005\u00a5\u0000\u0000"+
		"\u0173\u0174\u0003\"\u0011\u0000\u0174\u0175\u0005l\u0000\u0000\u0175"+
		"\u0176\u0003(\u0014\u0000\u01767\u0001\u0000\u0000\u0000\u0177\u0178\u0007"+
		"\u0004\u0000\u0000\u01789\u0001\u0000\u0000\u0000\u0179\u017a\u0005\u00c3"+
		"\u0000\u0000\u017a\u0183\u0005\u00d2\u0000\u0000\u017b\u0180\u0003(\u0014"+
		"\u0000\u017c\u017d\u0005\u00d0\u0000\u0000\u017d\u017f\u0003(\u0014\u0000"+
		"\u017e\u017c\u0001\u0000\u0000\u0000\u017f\u0182\u0001\u0000\u0000\u0000"+
		"\u0180\u017e\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000\u0000\u0000"+
		"\u0181\u0184\u0001\u0000\u0000\u0000\u0182\u0180\u0001\u0000\u0000\u0000"+
		"\u0183\u017b\u0001\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000\u0000"+
		"\u0184\u0185\u0001\u0000\u0000\u0000\u0185\u0194\u0005\u00d3\u0000\u0000"+
		"\u0186\u0187\u0005\u00c2\u0000\u0000\u0187\u0190\u0005\u00d2\u0000\u0000"+
		"\u0188\u018d\u0003(\u0014\u0000\u0189\u018a\u0005\u00d0\u0000\u0000\u018a"+
		"\u018c\u0003(\u0014\u0000\u018b\u0189\u0001\u0000\u0000\u0000\u018c\u018f"+
		"\u0001\u0000\u0000\u0000\u018d\u018b\u0001\u0000\u0000\u0000\u018d\u018e"+
		"\u0001\u0000\u0000\u0000\u018e\u0191\u0001\u0000\u0000\u0000\u018f\u018d"+
		"\u0001\u0000\u0000\u0000\u0190\u0188\u0001\u0000\u0000\u0000\u0190\u0191"+
		"\u0001\u0000\u0000\u0000\u0191\u0192\u0001\u0000\u0000\u0000\u0192\u0194"+
		"\u0005\u00d3\u0000\u0000\u0193\u0179\u0001\u0000\u0000\u0000\u0193\u0186"+
		"\u0001\u0000\u0000\u0000\u0194;\u0001\u0000\u0000\u0000\u0195\u0196\u0005"+
		"G\u0000\u0000\u0196\u0197\u0005M\u0000\u0000\u0197\u0198\u0003\u0012\t"+
		"\u0000\u0198\u0199\u0005\u00d2\u0000\u0000\u0199\u019e\u0003\u0018\f\u0000"+
		"\u019a\u019b\u0005\u00d0\u0000\u0000\u019b\u019d\u0003\u0018\f\u0000\u019c"+
		"\u019a\u0001\u0000\u0000\u0000\u019d\u01a0\u0001\u0000\u0000\u0000\u019e"+
		"\u019c\u0001\u0000\u0000\u0000\u019e\u019f\u0001\u0000\u0000\u0000\u019f"+
		"\u01a1\u0001\u0000\u0000\u0000\u01a0\u019e\u0001\u0000\u0000\u0000\u01a1"+
		"\u01a2\u0005\u00d3\u0000\u0000\u01a2\u01a3\u0005\u0099\u0000\u0000\u01a3"+
		"\u01a4\u0005\u00d2\u0000\u0000\u01a4\u01a9\u00038\u001c\u0000\u01a5\u01a6"+
		"\u0005\u00d0\u0000\u0000\u01a6\u01a8\u00038\u001c\u0000\u01a7\u01a5\u0001"+
		"\u0000\u0000\u0000\u01a8\u01ab\u0001\u0000\u0000\u0000\u01a9\u01a7\u0001"+
		"\u0000\u0000\u0000\u01a9\u01aa\u0001\u0000\u0000\u0000\u01aa\u01ac\u0001"+
		"\u0000\u0000\u0000\u01ab\u01a9\u0001\u0000\u0000\u0000\u01ac\u01ad\u0005"+
		"\u00d3\u0000\u0000\u01ad=\u0001\u0000\u0000\u0000\u01ae\u01af\u0005\u008d"+
		"\u0000\u0000\u01af\u01b0\u0003\u0012\t\u0000\u01b0\u01b1\u0005Q\u0000"+
		"\u0000\u01b1\u01b6\u0003@ \u0000\u01b2\u01b3\u0005\u00d0\u0000\u0000\u01b3"+
		"\u01b5\u0003@ \u0000\u01b4\u01b2\u0001\u0000\u0000\u0000\u01b5\u01b8\u0001"+
		"\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000\u0000\u0000\u01b6\u01b7\u0001"+
		"\u0000\u0000\u0000\u01b7\u01ba\u0001\u0000\u0000\u0000\u01b8\u01b6\u0001"+
		"\u0000\u0000\u0000\u01b9\u01bb\u0003\u001a\r\u0000\u01ba\u01b9\u0001\u0000"+
		"\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000\u0000\u01bb?\u0001\u0000\u0000"+
		"\u0000\u01bc\u01bd\u0003\u0018\f\u0000\u01bd\u01be\u0007\u0000\u0000\u0000"+
		"\u01be\u01bf\u0003(\u0014\u0000\u01bfA\u0001\u0000\u0000\u0000\u01c0\u01c1"+
		"\u0005\u0085\u0000\u0000\u01c1\u01c2\u0005\u001a\u0000\u0000\u01c2\u01c4"+
		"\u0003\u0012\t\u0000\u01c3\u01c5\u0003\u001a\r\u0000\u01c4\u01c3\u0001"+
		"\u0000\u0000\u0000\u01c4\u01c5\u0001\u0000\u0000\u0000\u01c5C\u0001\u0000"+
		"\u0000\u0000\u01c6\u01cb\u0003F#\u0000\u01c7\u01cb\u0003P(\u0000\u01c8"+
		"\u01cb\u0003R)\u0000\u01c9\u01cb\u0003j5\u0000\u01ca\u01c6\u0001\u0000"+
		"\u0000\u0000\u01ca\u01c7\u0001\u0000\u0000\u0000\u01ca\u01c8\u0001\u0000"+
		"\u0000\u0000\u01ca\u01c9\u0001\u0000\u0000\u0000\u01cbE\u0001\u0000\u0000"+
		"\u0000\u01cc\u01cd\u0005^\u0000\u0000\u01cd\u01ce\u0005c\u0000\u0000\u01ce"+
		"\u01cf\u0003\u0012\t\u0000\u01cf\u01d0\u0005\u00d2\u0000\u0000\u01d0\u01d5"+
		"\u0003H$\u0000\u01d1\u01d2\u0005\u00d0\u0000\u0000\u01d2\u01d4\u0003H"+
		"$\u0000\u01d3\u01d1\u0001\u0000\u0000\u0000\u01d4\u01d7\u0001\u0000\u0000"+
		"\u0000\u01d5\u01d3\u0001\u0000\u0000\u0000\u01d5\u01d6\u0001\u0000\u0000"+
		"\u0000\u01d6\u01d8\u0001\u0000\u0000\u0000\u01d7\u01d5\u0001\u0000\u0000"+
		"\u0000\u01d8\u01d9\u0005\u00d3\u0000\u0000\u01d9G\u0001\u0000\u0000\u0000"+
		"\u01da\u01db\u0003\u0018\f\u0000\u01db\u01dd\u0003L&\u0000\u01dc\u01de"+
		"\u0003J%\u0000\u01dd\u01dc\u0001\u0000\u0000\u0000\u01dd\u01de\u0001\u0000"+
		"\u0000\u0000\u01deI\u0001\u0000\u0000\u0000\u01df\u01e3\u0005w\u0000\u0000"+
		"\u01e0\u01e1\u0005t\u0000\u0000\u01e1\u01e3\u0005w\u0000\u0000\u01e2\u01df"+
		"\u0001\u0000\u0000\u0000\u01e2\u01e0\u0001\u0000\u0000\u0000\u01e3K\u0001"+
		"\u0000\u0000\u0000\u01e4\u01f0\u0005\u00b4\u0000\u0000\u01e5\u01e6\u0005"+
		"\u00b5\u0000\u0000\u01e6\u01e7\u0005\u00d2\u0000\u0000\u01e7\u01e8\u0007"+
		"\u0005\u0000\u0000\u01e8\u01f0\u0005\u00d3\u0000\u0000\u01e9\u01ea\u0005"+
		"\u00b6\u0000\u0000\u01ea\u01eb\u0005\u00d2\u0000\u0000\u01eb\u01ec\u0007"+
		"\u0005\u0000\u0000\u01ec\u01f0\u0005\u00d3\u0000\u0000\u01ed\u01f0\u0005"+
		"\u00c2\u0000\u0000\u01ee\u01f0\u0005\u00c3\u0000\u0000\u01ef\u01e4\u0001"+
		"\u0000\u0000\u0000\u01ef\u01e5\u0001\u0000\u0000\u0000\u01ef\u01e9\u0001"+
		"\u0000\u0000\u0000\u01ef\u01ed\u0001\u0000\u0000\u0000\u01ef\u01ee\u0001"+
		"\u0000\u0000\u0000\u01f0\u01f2\u0001\u0000\u0000\u0000\u01f1\u01f3\u0003"+
		"N\'\u0000\u01f2\u01f1\u0001\u0000\u0000\u0000\u01f2\u01f3\u0001\u0000"+
		"\u0000\u0000\u01f3M\u0001\u0000\u0000\u0000\u01f4\u01f5\u0005\u00d2\u0000"+
		"\u0000\u01f5\u01f6\u0007\u0005\u0000\u0000\u01f6\u01f7\u0005\u00d3\u0000"+
		"\u0000\u01f7O\u0001\u0000\u0000\u0000\u01f8\u01f9\u0005\u009a\u0000\u0000"+
		"\u01f9\u01fa\u0005c\u0000\u0000\u01fa\u01fb\u0003\u0012\t\u0000\u01fb"+
		"Q\u0001\u0000\u0000\u0000\u01fc\u01fd\u0005\u0007\u0000\u0000\u01fd\u01fe"+
		"\u0005c\u0000\u0000\u01fe\u01ff\u0003\u0012\t\u0000\u01ff\u0200\u0003"+
		"T*\u0000\u0200S\u0001\u0000\u0000\u0000\u0201\u0202\u0005\u0001\u0000"+
		"\u0000\u0202\u0206\u0003H$\u0000\u0203\u0204\u0005\u009a\u0000\u0000\u0204"+
		"\u0206\u0003\u0018\f\u0000\u0205\u0201\u0001\u0000\u0000\u0000\u0205\u0203"+
		"\u0001\u0000\u0000\u0000\u0206U\u0001\u0000\u0000\u0000\u0207\u020c\u0003"+
		"X,\u0000\u0208\u020c\u0003Z-\u0000\u0209\u020c\u0003\\.\u0000\u020a\u020c"+
		"\u0003^/\u0000\u020b\u0207\u0001\u0000\u0000\u0000\u020b\u0208\u0001\u0000"+
		"\u0000\u0000\u020b\u0209\u0001\u0000\u0000\u0000\u020b\u020a\u0001\u0000"+
		"\u0000\u0000\u020cW\u0001\u0000\u0000\u0000\u020d\u020e\u0005\u007f\u0000"+
		"\u0000\u020e\u020f\u0005\u00c3\u0000\u0000\u020f\u0210\u0005s\u0000\u0000"+
		"\u0210\u0211\u0005\u000e\u0000\u0000\u0211\u0212\u0003\n\u0005\u0000\u0212"+
		"Y\u0001\u0000\u0000\u0000\u0213\u0214\u0005\u0089\u0000\u0000\u0214\u0215"+
		"\u0005\u00c3\u0000\u0000\u0215[\u0001\u0000\u0000\u0000\u0216\u0217\u0005"+
		"\u0005\u0000\u0000\u0217\u0218\u0005\u00c3\u0000\u0000\u0218]\u0001\u0000"+
		"\u0000\u0000\u0219\u021a\u0005:\u0000\u0000\u021a\u021b\u0005\u00c3\u0000"+
		"\u0000\u021b_\u0001\u0000\u0000\u0000\u021c\u0220\u0005\u001c\u0000\u0000"+
		"\u021d\u021f\u0003b1\u0000\u021e\u021d\u0001\u0000\u0000\u0000\u021f\u0222"+
		"\u0001\u0000\u0000\u0000\u0220\u021e\u0001\u0000\u0000\u0000\u0220\u0221"+
		"\u0001\u0000\u0000\u0000\u0221\u0223\u0001\u0000\u0000\u0000\u0222\u0220"+
		"\u0001\u0000\u0000\u0000\u0223\u0224\u0005\u00a3\u0000\u0000\u0224a\u0001"+
		"\u0000\u0000\u0000\u0225\u0228\u0003\u0002\u0001\u0000\u0226\u0228\u0003"+
		"f3\u0000\u0227\u0225\u0001\u0000\u0000\u0000\u0227\u0226\u0001\u0000\u0000"+
		"\u0000\u0228c\u0001\u0000\u0000\u0000\u0229\u022a\u0007\u0006\u0000\u0000"+
		"\u022a\u022f\u0003(\u0014\u0000\u022b\u022c\u0005\u00d0\u0000\u0000\u022c"+
		"\u022e\u0003(\u0014\u0000\u022d\u022b\u0001\u0000\u0000\u0000\u022e\u0231"+
		"\u0001\u0000\u0000\u0000\u022f\u022d\u0001\u0000\u0000\u0000\u022f\u0230"+
		"\u0001\u0000\u0000\u0000\u0230e\u0001\u0000\u0000\u0000\u0231\u022f\u0001"+
		"\u0000\u0000\u0000\u0232\u0233\u0005\u001c\u0000\u0000\u0233\u0237\u0005"+
		"\u00b8\u0000\u0000\u0234\u0236\u0003b1\u0000\u0235\u0234\u0001\u0000\u0000"+
		"\u0000\u0236\u0239\u0001\u0000\u0000\u0000\u0237\u0235\u0001\u0000\u0000"+
		"\u0000\u0237\u0238\u0001\u0000\u0000\u0000\u0238\u023a\u0001\u0000\u0000"+
		"\u0000\u0239\u0237\u0001\u0000\u0000\u0000\u023a\u023b\u0005\u00a3\u0000"+
		"\u0000\u023b\u023c\u0005\u00b8\u0000\u0000\u023c\u023d\u0005\u001c\u0000"+
		"\u0000\u023d\u0241\u0005\u00b9\u0000\u0000\u023e\u0240\u0003b1\u0000\u023f"+
		"\u023e\u0001\u0000\u0000\u0000\u0240\u0243\u0001\u0000\u0000\u0000\u0241"+
		"\u023f\u0001\u0000\u0000\u0000\u0241\u0242\u0001\u0000\u0000\u0000\u0242"+
		"\u0244\u0001\u0000\u0000\u0000\u0243\u0241\u0001\u0000\u0000\u0000\u0244"+
		"\u0245\u0005\u00a3\u0000\u0000\u0245\u0246\u0005\u00b9\u0000\u0000\u0246"+
		"g\u0001\u0000\u0000\u0000\u0247\u0248\u0005;\u0000\u0000\u0248\u0249\u0003"+
		"\"\u0011\u0000\u0249\u024c\u0003\u0002\u0001\u0000\u024a\u024b\u0005\u00a0"+
		"\u0000\u0000\u024b\u024d\u0003\u0002\u0001\u0000\u024c\u024a\u0001\u0000"+
		"\u0000\u0000\u024c\u024d\u0001\u0000\u0000\u0000\u024di\u0001\u0000\u0000"+
		"\u0000\u024e\u024f\u0005\u007f\u0000\u0000\u024f\u0250\u0005\u00c4\u0000"+
		"\u0000\u0250\u0253\u0003L&\u0000\u0251\u0252\u0005\u00c5\u0000\u0000\u0252"+
		"\u0254\u0003(\u0014\u0000\u0253\u0251\u0001\u0000\u0000\u0000\u0253\u0254"+
		"\u0001\u0000\u0000\u0000\u0254\u025e\u0001\u0000\u0000\u0000\u0255\u0256"+
		"\u0005\u00d0\u0000\u0000\u0256\u0257\u0005\u00c4\u0000\u0000\u0257\u025a"+
		"\u0003L&\u0000\u0258\u0259\u0005\u00c5\u0000\u0000\u0259\u025b\u0003("+
		"\u0014\u0000\u025a\u0258\u0001\u0000\u0000\u0000\u025a\u025b\u0001\u0000"+
		"\u0000\u0000\u025b\u025d\u0001\u0000\u0000\u0000\u025c\u0255\u0001\u0000"+
		"\u0000\u0000\u025d\u0260\u0001\u0000\u0000\u0000\u025e\u025c\u0001\u0000"+
		"\u0000\u0000\u025e\u025f\u0001\u0000\u0000\u0000\u025fk\u0001\u0000\u0000"+
		"\u0000\u0260\u025e\u0001\u0000\u0000\u0000\u0261\u0262\u0005Q\u0000\u0000"+
		"\u0262\u0263\u0005\u00c4\u0000\u0000\u0263\u0264\u0007\u0000\u0000\u0000"+
		"\u0264\u026b\u0003(\u0014\u0000\u0265\u0266\u0005\u00d0\u0000\u0000\u0266"+
		"\u0267\u0005\u00c4\u0000\u0000\u0267\u0268\u0007\u0000\u0000\u0000\u0268"+
		"\u026a\u0003(\u0014\u0000\u0269\u0265\u0001\u0000\u0000\u0000\u026a\u026d"+
		"\u0001\u0000\u0000\u0000\u026b\u0269\u0001\u0000\u0000\u0000\u026b\u026c"+
		"\u0001\u0000\u0000\u0000\u026c\u026f\u0001\u0000\u0000\u0000\u026d\u026b"+
		"\u0001\u0000\u0000\u0000\u026e\u0270\u0005\u00d6\u0000\u0000\u026f\u026e"+
		"\u0001\u0000\u0000\u0000\u026f\u0270\u0001\u0000\u0000\u0000\u0270m\u0001"+
		"\u0000\u0000\u0000=qw\u0080\u0083\u008b\u0099\u00a2\u00a6\u00a9\u00ac"+
		"\u00b4\u00b7\u00bf\u00c8\u00d6\u00e4\u00ee\u00f3\u00fb\u0103\u0105\u0114"+
		"\u012d\u0137\u0142\u0144\u0150\u0152\u015a\u0164\u016a\u016e\u0180\u0183"+
		"\u018d\u0190\u0193\u019e\u01a9\u01b6\u01ba\u01c4\u01ca\u01d5\u01dd\u01e2"+
		"\u01ef\u01f2\u0205\u020b\u0220\u0227\u022f\u0237\u0241\u024c\u0253\u025a"+
		"\u025e\u026b\u026f";
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
- **Size**: 172.28 KB
- **Extension**: `.py`
- **Language**: `python`
- **Location**: `SqlParser.py`
- **Relative Path**: `root`
- **Created**: 2026-01-10 14:46:39 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-15 11:20:50 (Asia/Damascus / GMT+03:00)
- **MD5**: `36966c1e34f2f9596d93f2a1907a199f`
- **SHA256**: `68764b23340d6d47b7ee4245fa028f836b45c2f2e06aa7266683ebd814e5cf33`
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
        4,1,217,626,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,6,
        7,6,2,7,7,7,2,8,7,8,2,9,7,9,2,10,7,10,2,11,7,11,2,12,7,12,2,13,7,
        13,2,14,7,14,2,15,7,15,2,16,7,16,2,17,7,17,2,18,7,18,2,19,7,19,2,
        20,7,20,2,21,7,21,2,22,7,22,2,23,7,23,2,24,7,24,2,25,7,25,2,26,7,
        26,2,27,7,27,2,28,7,28,2,29,7,29,2,30,7,30,2,31,7,31,2,32,7,32,2,
        33,7,33,2,34,7,34,2,35,7,35,2,36,7,36,2,37,7,37,2,38,7,38,2,39,7,
        39,2,40,7,40,2,41,7,41,2,42,7,42,2,43,7,43,2,44,7,44,2,45,7,45,2,
        46,7,46,2,47,7,47,2,48,7,48,2,49,7,49,2,50,7,50,2,51,7,51,2,52,7,
        52,2,53,7,53,2,54,7,54,1,0,5,0,112,8,0,10,0,12,0,115,9,0,1,0,1,0,
        1,1,3,1,120,8,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,1,131,8,1,
        1,1,3,1,134,8,1,1,2,1,2,1,2,1,2,5,2,140,8,2,10,2,12,2,143,9,2,1,
        3,1,3,1,3,1,3,1,3,1,3,1,4,1,4,1,4,1,4,3,4,155,8,4,1,5,1,5,1,5,1,
        5,1,5,5,5,162,8,5,10,5,12,5,165,9,5,1,5,3,5,168,8,5,1,5,3,5,171,
        8,5,1,5,3,5,174,8,5,1,6,1,6,1,6,1,6,5,6,180,8,6,10,6,12,6,183,9,
        6,3,6,185,8,6,1,7,1,7,1,7,1,7,1,7,1,7,3,7,193,8,7,1,8,1,8,1,9,1,
        9,1,9,5,9,200,8,9,10,9,12,9,203,9,9,1,10,1,10,1,10,1,10,1,10,1,10,
        1,11,1,11,1,11,1,11,1,11,3,11,216,8,11,1,12,1,12,1,13,1,13,1,13,
        1,14,1,14,1,14,1,14,1,14,5,14,228,8,14,10,14,12,14,231,9,14,1,15,
        1,15,1,15,1,15,1,15,5,15,238,8,15,10,15,12,15,241,9,15,1,16,1,16,
        3,16,245,8,16,1,17,1,17,1,17,1,17,1,17,1,17,3,17,253,8,17,1,17,1,
        17,1,17,1,17,1,17,1,17,5,17,261,8,17,10,17,12,17,264,9,17,1,18,1,
        18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,5,18,276,8,18,10,18,12,
        18,279,9,18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,1,
        18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,3,18,303,
        8,18,1,19,1,19,1,20,1,20,1,21,1,21,1,21,1,21,3,21,313,8,21,1,22,
        1,22,1,22,1,22,1,22,1,22,1,22,1,22,1,22,5,22,324,8,22,10,22,12,22,
        327,9,22,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,23,5,23,338,8,
        23,10,23,12,23,341,9,23,1,24,1,24,1,24,1,24,1,24,3,24,348,8,24,1,
        25,1,25,1,25,1,25,1,25,1,25,1,25,1,25,3,25,358,8,25,1,26,1,26,4,
        26,362,8,26,11,26,12,26,363,1,26,1,26,3,26,368,8,26,1,26,1,26,1,
        27,1,27,1,27,1,27,1,27,1,28,1,28,1,29,1,29,1,29,1,29,1,29,5,29,384,
        8,29,10,29,12,29,387,9,29,3,29,389,8,29,1,29,1,29,1,29,1,29,1,29,
        1,29,5,29,397,8,29,10,29,12,29,400,9,29,3,29,402,8,29,1,29,3,29,
        405,8,29,1,30,1,30,1,30,1,30,1,30,1,30,1,30,5,30,414,8,30,10,30,
        12,30,417,9,30,1,30,1,30,1,30,1,30,1,30,1,30,5,30,425,8,30,10,30,
        12,30,428,9,30,1,30,1,30,1,31,1,31,1,31,1,31,1,31,1,31,5,31,438,
        8,31,10,31,12,31,441,9,31,1,31,3,31,444,8,31,1,32,1,32,1,32,1,32,
        1,33,1,33,1,33,1,33,3,33,454,8,33,1,34,1,34,1,34,3,34,459,8,34,1,
        35,1,35,1,35,1,35,1,35,1,35,1,35,5,35,468,8,35,10,35,12,35,471,9,
        35,1,35,1,35,1,36,1,36,1,36,3,36,478,8,36,1,37,1,37,1,37,3,37,483,
        8,37,1,38,1,38,1,38,1,38,1,38,1,38,1,38,1,38,1,38,1,38,1,38,3,38,
        496,8,38,1,38,3,38,499,8,38,1,39,1,39,1,39,1,39,1,40,1,40,1,40,1,
        40,1,41,1,41,1,41,1,41,1,41,1,42,1,42,1,42,1,42,3,42,518,8,42,1,
        43,1,43,1,43,1,43,3,43,524,8,43,1,44,1,44,1,44,1,44,1,44,1,44,1,
        45,1,45,1,45,1,46,1,46,1,46,1,47,1,47,1,47,1,48,1,48,5,48,543,8,
        48,10,48,12,48,546,9,48,1,48,1,48,1,49,1,49,3,49,552,8,49,1,50,1,
        50,1,50,1,50,5,50,558,8,50,10,50,12,50,561,9,50,1,51,1,51,1,51,5,
        51,566,8,51,10,51,12,51,569,9,51,1,51,1,51,1,51,1,51,1,51,5,51,576,
        8,51,10,51,12,51,579,9,51,1,51,1,51,1,51,1,52,1,52,1,52,1,52,1,52,
        3,52,589,8,52,1,53,1,53,1,53,1,53,1,53,3,53,596,8,53,1,53,1,53,1,
        53,1,53,1,53,3,53,603,8,53,5,53,605,8,53,10,53,12,53,608,9,53,1,
        54,1,54,1,54,1,54,1,54,1,54,1,54,1,54,5,54,618,8,54,10,54,12,54,
        621,9,54,1,54,3,54,624,8,54,1,54,0,3,34,44,46,55,0,2,4,6,8,10,12,
        14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,
        58,60,62,64,66,68,70,72,74,76,78,80,82,84,86,88,90,92,94,96,98,100,
        102,104,106,108,0,7,2,0,197,197,207,207,1,0,194,195,2,0,19,19,139,
        139,1,0,197,202,3,0,119,119,187,188,191,193,2,0,183,183,187,187,
        2,0,175,175,178,178,659,0,113,1,0,0,0,2,119,1,0,0,0,4,135,1,0,0,
        0,6,144,1,0,0,0,8,154,1,0,0,0,10,156,1,0,0,0,12,184,1,0,0,0,14,192,
        1,0,0,0,16,194,1,0,0,0,18,196,1,0,0,0,20,204,1,0,0,0,22,215,1,0,
        0,0,24,217,1,0,0,0,26,219,1,0,0,0,28,222,1,0,0,0,30,232,1,0,0,0,
        32,242,1,0,0,0,34,252,1,0,0,0,36,302,1,0,0,0,38,304,1,0,0,0,40,306,
        1,0,0,0,42,312,1,0,0,0,44,314,1,0,0,0,46,328,1,0,0,0,48,347,1,0,
        0,0,50,357,1,0,0,0,52,359,1,0,0,0,54,371,1,0,0,0,56,376,1,0,0,0,
        58,404,1,0,0,0,60,406,1,0,0,0,62,431,1,0,0,0,64,445,1,0,0,0,66,449,
        1,0,0,0,68,458,1,0,0,0,70,460,1,0,0,0,72,474,1,0,0,0,74,482,1,0,
        0,0,76,495,1,0,0,0,78,500,1,0,0,0,80,504,1,0,0,0,82,508,1,0,0,0,
        84,517,1,0,0,0,86,523,1,0,0,0,88,525,1,0,0,0,90,531,1,0,0,0,92,534,
        1,0,0,0,94,537,1,0,0,0,96,540,1,0,0,0,98,551,1,0,0,0,100,553,1,0,
        0,0,102,562,1,0,0,0,104,583,1,0,0,0,106,590,1,0,0,0,108,609,1,0,
        0,0,110,112,3,2,1,0,111,110,1,0,0,0,112,115,1,0,0,0,113,111,1,0,
        0,0,113,114,1,0,0,0,114,116,1,0,0,0,115,113,1,0,0,0,116,117,5,0,
        0,1,117,1,1,0,0,0,118,120,3,4,2,0,119,118,1,0,0,0,119,120,1,0,0,
        0,120,130,1,0,0,0,121,131,3,8,4,0,122,131,3,68,34,0,123,131,3,86,
        43,0,124,131,3,104,52,0,125,131,3,96,48,0,126,131,3,106,53,0,127,
        131,3,108,54,0,128,131,3,100,50,0,129,131,3,102,51,0,130,121,1,0,
        0,0,130,122,1,0,0,0,130,123,1,0,0,0,130,124,1,0,0,0,130,125,1,0,
        0,0,130,126,1,0,0,0,130,127,1,0,0,0,130,128,1,0,0,0,130,129,1,0,
        0,0,131,133,1,0,0,0,132,134,5,214,0,0,133,132,1,0,0,0,133,134,1,
        0,0,0,134,3,1,0,0,0,135,136,5,174,0,0,136,141,3,6,3,0,137,138,5,
        208,0,0,138,140,3,6,3,0,139,137,1,0,0,0,140,143,1,0,0,0,141,139,
        1,0,0,0,141,142,1,0,0,0,142,5,1,0,0,0,143,141,1,0,0,0,144,145,5,
        195,0,0,145,146,5,16,0,0,146,147,5,210,0,0,147,148,3,10,5,0,148,
        149,5,211,0,0,149,7,1,0,0,0,150,155,3,10,5,0,151,155,3,60,30,0,152,
        155,3,62,31,0,153,155,3,66,33,0,154,150,1,0,0,0,154,151,1,0,0,0,
        154,152,1,0,0,0,154,153,1,0,0,0,155,9,1,0,0,0,156,157,5,66,0,0,157,
        158,3,12,6,0,158,159,5,26,0,0,159,163,3,16,8,0,160,162,3,20,10,0,
        161,160,1,0,0,0,162,165,1,0,0,0,163,161,1,0,0,0,163,164,1,0,0,0,
        164,167,1,0,0,0,165,163,1,0,0,0,166,168,3,26,13,0,167,166,1,0,0,
        0,167,168,1,0,0,0,168,170,1,0,0,0,169,171,3,28,14,0,170,169,1,0,
        0,0,170,171,1,0,0,0,171,173,1,0,0,0,172,174,3,30,15,0,173,172,1,
        0,0,0,173,174,1,0,0,0,174,11,1,0,0,0,175,185,5,205,0,0,176,181,3,
        14,7,0,177,178,5,208,0,0,178,180,3,14,7,0,179,177,1,0,0,0,180,183,
        1,0,0,0,181,179,1,0,0,0,181,182,1,0,0,0,182,185,1,0,0,0,183,181,
        1,0,0,0,184,175,1,0,0,0,184,176,1,0,0,0,185,13,1,0,0,0,186,193,3,
        24,12,0,187,193,3,56,28,0,188,193,3,58,29,0,189,190,5,196,0,0,190,
        191,7,0,0,0,191,193,3,40,20,0,192,186,1,0,0,0,192,187,1,0,0,0,192,
        188,1,0,0,0,192,189,1,0,0,0,193,15,1,0,0,0,194,195,3,18,9,0,195,
        17,1,0,0,0,196,201,7,1,0,0,197,198,5,209,0,0,198,200,7,1,0,0,199,
        197,1,0,0,0,200,203,1,0,0,0,201,199,1,0,0,0,201,202,1,0,0,0,202,
        19,1,0,0,0,203,201,1,0,0,0,204,205,3,22,11,0,205,206,5,83,0,0,206,
        207,3,16,8,0,207,208,5,134,0,0,208,209,3,34,17,0,209,21,1,0,0,0,
        210,216,5,68,0,0,211,216,5,92,0,0,212,216,5,42,0,0,213,216,5,29,
        0,0,214,216,1,0,0,0,215,210,1,0,0,0,215,211,1,0,0,0,215,212,1,0,
        0,0,215,213,1,0,0,0,215,214,1,0,0,0,216,23,1,0,0,0,217,218,7,1,0,
        0,218,25,1,0,0,0,219,220,5,168,0,0,220,221,3,34,17,0,221,27,1,0,
        0,0,222,223,5,41,0,0,223,224,5,43,0,0,224,229,3,24,12,0,225,226,
        5,208,0,0,226,228,3,24,12,0,227,225,1,0,0,0,228,231,1,0,0,0,229,
        227,1,0,0,0,229,230,1,0,0,0,230,29,1,0,0,0,231,229,1,0,0,0,232,233,
        5,158,0,0,233,234,5,43,0,0,234,239,3,32,16,0,235,236,5,208,0,0,236,
        238,3,32,16,0,237,235,1,0,0,0,238,241,1,0,0,0,239,237,1,0,0,0,239,
        240,1,0,0,0,240,31,1,0,0,0,241,239,1,0,0,0,242,244,3,24,12,0,243,
        245,7,2,0,0,244,243,1,0,0,0,244,245,1,0,0,0,245,33,1,0,0,0,246,247,
        6,17,-1,0,247,248,5,210,0,0,248,249,3,34,17,0,249,250,5,211,0,0,
        250,253,1,0,0,0,251,253,3,36,18,0,252,246,1,0,0,0,252,251,1,0,0,
        0,253,262,1,0,0,0,254,255,10,4,0,0,255,256,5,10,0,0,256,261,3,34,
        17,5,257,258,10,3,0,0,258,259,5,155,0,0,259,261,3,34,17,4,260,254,
        1,0,0,0,260,257,1,0,0,0,261,264,1,0,0,0,262,260,1,0,0,0,262,263,
        1,0,0,0,263,35,1,0,0,0,264,262,1,0,0,0,265,266,3,40,20,0,266,267,
        3,38,19,0,267,268,3,40,20,0,268,303,1,0,0,0,269,270,3,40,20,0,270,
        271,5,62,0,0,271,272,5,210,0,0,272,277,3,40,20,0,273,274,5,208,0,
        0,274,276,3,40,20,0,275,273,1,0,0,0,276,279,1,0,0,0,277,275,1,0,
        0,0,277,278,1,0,0,0,278,280,1,0,0,0,279,277,1,0,0,0,280,281,5,211,
        0,0,281,303,1,0,0,0,282,283,3,40,20,0,283,284,5,80,0,0,284,285,5,
        119,0,0,285,303,1,0,0,0,286,287,3,40,20,0,287,288,5,80,0,0,288,289,
        5,116,0,0,289,290,5,119,0,0,290,303,1,0,0,0,291,292,5,186,0,0,292,
        293,5,210,0,0,293,294,3,10,5,0,294,295,5,211,0,0,295,303,1,0,0,0,
        296,297,5,116,0,0,297,298,5,186,0,0,298,299,5,210,0,0,299,300,3,
        10,5,0,300,301,5,211,0,0,301,303,1,0,0,0,302,265,1,0,0,0,302,269,
        1,0,0,0,302,282,1,0,0,0,302,286,1,0,0,0,302,291,1,0,0,0,302,296,
        1,0,0,0,303,37,1,0,0,0,304,305,7,3,0,0,305,39,1,0,0,0,306,307,3,
        42,21,0,307,41,1,0,0,0,308,309,5,196,0,0,309,310,7,0,0,0,310,313,
        3,44,22,0,311,313,3,44,22,0,312,308,1,0,0,0,312,311,1,0,0,0,313,
        43,1,0,0,0,314,315,6,22,-1,0,315,316,3,46,23,0,316,325,1,0,0,0,317,
        318,10,3,0,0,318,319,5,203,0,0,319,324,3,46,23,0,320,321,10,2,0,
        0,321,322,5,204,0,0,322,324,3,46,23,0,323,317,1,0,0,0,323,320,1,
        0,0,0,324,327,1,0,0,0,325,323,1,0,0,0,325,326,1,0,0,0,326,45,1,0,
        0,0,327,325,1,0,0,0,328,329,6,23,-1,0,329,330,3,48,24,0,330,339,
        1,0,0,0,331,332,10,3,0,0,332,333,5,205,0,0,333,338,3,48,24,0,334,
        335,10,2,0,0,335,336,5,206,0,0,336,338,3,48,24,0,337,331,1,0,0,0,
        337,334,1,0,0,0,338,341,1,0,0,0,339,337,1,0,0,0,339,340,1,0,0,0,
        340,47,1,0,0,0,341,339,1,0,0,0,342,343,5,203,0,0,343,348,3,48,24,
        0,344,345,5,204,0,0,345,348,3,48,24,0,346,348,3,50,25,0,347,342,
        1,0,0,0,347,344,1,0,0,0,347,346,1,0,0,0,348,49,1,0,0,0,349,358,3,
        24,12,0,350,358,3,56,28,0,351,358,5,196,0,0,352,358,3,58,29,0,353,
        354,5,210,0,0,354,355,3,40,20,0,355,356,5,211,0,0,356,358,1,0,0,
        0,357,349,1,0,0,0,357,350,1,0,0,0,357,351,1,0,0,0,357,352,1,0,0,
        0,357,353,1,0,0,0,358,51,1,0,0,0,359,361,5,49,0,0,360,362,3,54,27,
        0,361,360,1,0,0,0,362,363,1,0,0,0,363,361,1,0,0,0,363,364,1,0,0,
        0,364,367,1,0,0,0,365,366,5,160,0,0,366,368,3,40,20,0,367,365,1,
        0,0,0,367,368,1,0,0,0,368,369,1,0,0,0,369,370,5,163,0,0,370,53,1,
        0,0,0,371,372,5,165,0,0,372,373,3,34,17,0,373,374,5,108,0,0,374,
        375,3,40,20,0,375,55,1,0,0,0,376,377,7,4,0,0,377,57,1,0,0,0,378,
        379,5,195,0,0,379,388,5,210,0,0,380,385,3,40,20,0,381,382,5,208,
        0,0,382,384,3,40,20,0,383,381,1,0,0,0,384,387,1,0,0,0,385,383,1,
        0,0,0,385,386,1,0,0,0,386,389,1,0,0,0,387,385,1,0,0,0,388,380,1,
        0,0,0,388,389,1,0,0,0,389,390,1,0,0,0,390,405,5,211,0,0,391,392,
        5,194,0,0,392,401,5,210,0,0,393,398,3,40,20,0,394,395,5,208,0,0,
        395,397,3,40,20,0,396,394,1,0,0,0,397,400,1,0,0,0,398,396,1,0,0,
        0,398,399,1,0,0,0,399,402,1,0,0,0,400,398,1,0,0,0,401,393,1,0,0,
        0,401,402,1,0,0,0,402,403,1,0,0,0,403,405,5,211,0,0,404,378,1,0,
        0,0,404,391,1,0,0,0,405,59,1,0,0,0,406,407,5,71,0,0,407,408,5,77,
        0,0,408,409,3,18,9,0,409,410,5,210,0,0,410,415,3,24,12,0,411,412,
        5,208,0,0,412,414,3,24,12,0,413,411,1,0,0,0,414,417,1,0,0,0,415,
        413,1,0,0,0,415,416,1,0,0,0,416,418,1,0,0,0,417,415,1,0,0,0,418,
        419,5,211,0,0,419,420,5,153,0,0,420,421,5,210,0,0,421,426,3,56,28,
        0,422,423,5,208,0,0,423,425,3,56,28,0,424,422,1,0,0,0,425,428,1,
        0,0,0,426,424,1,0,0,0,426,427,1,0,0,0,427,429,1,0,0,0,428,426,1,
        0,0,0,429,430,5,211,0,0,430,61,1,0,0,0,431,432,5,141,0,0,432,433,
        3,18,9,0,433,434,5,81,0,0,434,439,3,64,32,0,435,436,5,208,0,0,436,
        438,3,64,32,0,437,435,1,0,0,0,438,441,1,0,0,0,439,437,1,0,0,0,439,
        440,1,0,0,0,440,443,1,0,0,0,441,439,1,0,0,0,442,444,3,26,13,0,443,
        442,1,0,0,0,443,444,1,0,0,0,444,63,1,0,0,0,445,446,3,24,12,0,446,
        447,7,0,0,0,447,448,3,40,20,0,448,65,1,0,0,0,449,450,5,133,0,0,450,
        451,5,26,0,0,451,453,3,18,9,0,452,454,3,26,13,0,453,452,1,0,0,0,
        453,454,1,0,0,0,454,67,1,0,0,0,455,459,3,70,35,0,456,459,3,80,40,
        0,457,459,3,82,41,0,458,455,1,0,0,0,458,456,1,0,0,0,458,457,1,0,
        0,0,459,69,1,0,0,0,460,461,5,94,0,0,461,462,5,99,0,0,462,463,3,18,
        9,0,463,464,5,210,0,0,464,469,3,72,36,0,465,466,5,208,0,0,466,468,
        3,72,36,0,467,465,1,0,0,0,468,471,1,0,0,0,469,467,1,0,0,0,469,470,
        1,0,0,0,470,472,1,0,0,0,471,469,1,0,0,0,472,473,5,211,0,0,473,71,
        1,0,0,0,474,475,3,24,12,0,475,477,3,76,38,0,476,478,3,74,37,0,477,
        476,1,0,0,0,477,478,1,0,0,0,478,73,1,0,0,0,479,483,5,119,0,0,480,
        481,5,116,0,0,481,483,5,119,0,0,482,479,1,0,0,0,482,480,1,0,0,0,
        483,75,1,0,0,0,484,496,5,180,0,0,485,486,5,181,0,0,486,487,5,210,
        0,0,487,488,7,5,0,0,488,496,5,211,0,0,489,490,5,182,0,0,490,491,
        5,210,0,0,491,492,7,5,0,0,492,496,5,211,0,0,493,496,5,194,0,0,494,
        496,5,195,0,0,495,484,1,0,0,0,495,485,1,0,0,0,495,489,1,0,0,0,495,
        493,1,0,0,0,495,494,1,0,0,0,496,498,1,0,0,0,497,499,3,78,39,0,498,
        497,1,0,0,0,498,499,1,0,0,0,499,77,1,0,0,0,500,501,5,210,0,0,501,
        502,7,5,0,0,502,503,5,211,0,0,503,79,1,0,0,0,504,505,5,154,0,0,505,
        506,5,99,0,0,506,507,3,18,9,0,507,81,1,0,0,0,508,509,5,7,0,0,509,
        510,5,99,0,0,510,511,3,18,9,0,511,512,3,84,42,0,512,83,1,0,0,0,513,
        514,5,1,0,0,514,518,3,72,36,0,515,516,5,154,0,0,516,518,3,24,12,
        0,517,513,1,0,0,0,517,515,1,0,0,0,518,85,1,0,0,0,519,524,3,88,44,
        0,520,524,3,90,45,0,521,524,3,92,46,0,522,524,3,94,47,0,523,519,
        1,0,0,0,523,520,1,0,0,0,523,521,1,0,0,0,523,522,1,0,0,0,524,87,1,
        0,0,0,525,526,5,127,0,0,526,527,5,195,0,0,527,528,5,115,0,0,528,
        529,5,14,0,0,529,530,3,10,5,0,530,89,1,0,0,0,531,532,5,137,0,0,532,
        533,5,195,0,0,533,91,1,0,0,0,534,535,5,5,0,0,535,536,5,195,0,0,536,
        93,1,0,0,0,537,538,5,58,0,0,538,539,5,195,0,0,539,95,1,0,0,0,540,
        544,5,28,0,0,541,543,3,98,49,0,542,541,1,0,0,0,543,546,1,0,0,0,544,
        542,1,0,0,0,544,545,1,0,0,0,545,547,1,0,0,0,546,544,1,0,0,0,547,
        548,5,163,0,0,548,97,1,0,0,0,549,552,3,2,1,0,550,552,3,102,51,0,
        551,549,1,0,0,0,551,550,1,0,0,0,552,99,1,0,0,0,553,554,7,6,0,0,554,
        559,3,40,20,0,555,556,5,208,0,0,556,558,3,40,20,0,557,555,1,0,0,
        0,558,561,1,0,0,0,559,557,1,0,0,0,559,560,1,0,0,0,560,101,1,0,0,
        0,561,559,1,0,0,0,562,563,5,28,0,0,563,567,5,184,0,0,564,566,3,98,
        49,0,565,564,1,0,0,0,566,569,1,0,0,0,567,565,1,0,0,0,567,568,1,0,
        0,0,568,570,1,0,0,0,569,567,1,0,0,0,570,571,5,163,0,0,571,572,5,
        184,0,0,572,573,5,28,0,0,573,577,5,185,0,0,574,576,3,98,49,0,575,
        574,1,0,0,0,576,579,1,0,0,0,577,575,1,0,0,0,577,578,1,0,0,0,578,
        580,1,0,0,0,579,577,1,0,0,0,580,581,5,163,0,0,581,582,5,185,0,0,
        582,103,1,0,0,0,583,584,5,59,0,0,584,585,3,34,17,0,585,588,3,2,1,
        0,586,587,5,160,0,0,587,589,3,2,1,0,588,586,1,0,0,0,588,589,1,0,
        0,0,589,105,1,0,0,0,590,591,5,127,0,0,591,592,5,196,0,0,592,595,
        3,76,38,0,593,594,5,197,0,0,594,596,3,40,20,0,595,593,1,0,0,0,595,
        596,1,0,0,0,596,606,1,0,0,0,597,598,5,208,0,0,598,599,5,196,0,0,
        599,602,3,76,38,0,600,601,5,197,0,0,601,603,3,40,20,0,602,600,1,
        0,0,0,602,603,1,0,0,0,603,605,1,0,0,0,604,597,1,0,0,0,605,608,1,
        0,0,0,606,604,1,0,0,0,606,607,1,0,0,0,607,107,1,0,0,0,608,606,1,
        0,0,0,609,610,5,81,0,0,610,611,5,196,0,0,611,612,7,0,0,0,612,619,
        3,40,20,0,613,614,5,208,0,0,614,615,5,196,0,0,615,616,7,0,0,0,616,
        618,3,40,20,0,617,613,1,0,0,0,618,621,1,0,0,0,619,617,1,0,0,0,619,
        620,1,0,0,0,620,623,1,0,0,0,621,619,1,0,0,0,622,624,5,214,0,0,623,
        622,1,0,0,0,623,624,1,0,0,0,624,109,1,0,0,0,61,113,119,130,133,141,
        154,163,167,170,173,181,184,192,201,215,229,239,244,252,260,262,
        277,302,312,323,325,337,339,347,357,363,367,385,388,398,401,404,
        415,426,439,443,453,458,469,477,482,495,498,517,523,544,551,559,
        567,577,588,595,602,606,619,623
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
                     "'FUNCTION'", "'RETURN'", "'BREAK'", "'GOTO'", "'REVERT'", 
                     "'BROWSE'", "'GRANT'", "'REVOKE'", "'BULK'", "'GROUP'", 
                     "'RIGHT'", "'BY'", "'HAVING'", "'ROLLBACK'", "'CASCADE'", 
                     "'HOLDLOCK'", "'ROWCOUNT'", "'CASE'", "'IDENTITY'", 
                     "'ROWGUIDCOL'", "'CHECK'", "'IDENTITY_INSERT'", "'RULE'", 
                     "'CHECKPOINT'", "'IDENTITYCOL'", "'SAVE'", "'CLOSE'", 
                     "'IF'", "'SCHEMA'", "'CLUSTERED'", "'IN'", "'SECURITYAUDIT'", 
                     "'COALESCE'", "'INDEX'", "'SELECT'", "'COLLATE'", "'INNER'", 
                     "'SEMANTICKEYPHRASETABLE'", "'COLUMN'", "'INSERT'", 
                     "'SEMANTICSIMILARITYDETAILSTABLE'", "'COMMIT'", "'INTERSECT'", 
                     "'SEMANTICSIMILARITYTABLE'", "'COMPUTE'", "'INTO'", 
                     "'SESSION_USER'", "'CONSTRAINT'", "'IS'", "'SET'", 
                     "'CONTAINS'", "'JOIN'", "'SETUSER'", "'CONTAINSTABLE'", 
                     "'KEY'", "'SHUTDOWN'", "'CONTINUE'", "'KILL'", "'SOME'", 
                     "'CONVERT'", "'LEFT'", "'STATISTICS'", "'CREATE'", 
                     "'LIKE'", "'SYSTEM_USER'", "'CROSS'", "'LINENO'", "'TABLE'", 
                     "'CURRENT'", "'LOAD'", "'TABLESAMPLE'", "'CURRENT_DATE'", 
                     "'MERGE'", "'TEXTSIZE'", "'CURRENT_TIME'", "'NATIONAL'", 
                     "'THEN'", "'CURRENT_TIMESTAMP'", "'NOCHECK'", "'TO'", 
                     "'CURRENT_USER'", "'NONCLUSTERED'", "'TOP'", "'CURSOR'", 
                     "'NOT'", "'TRAN'", "'DATABASE'", "'NULL'", "'TRANSACTION'", 
                     "'DBCC'", "'NULLIF'", "'TRIGGER'", "'DEALLOCATE'", 
                     "'OF'", "'TRUNCATE'", "'DECLARE'", "'OFF'", "'TRY_CONVERT'", 
                     "'DEFAULT'", "'OFFSETS'", "'TSEQUAL'", "'DELETE'", 
                     "'ON'", "'UNION'", "'DENY'", "'OPEN'", "'UNIQUE'", 
                     "'DESC'", "'OPENDATASOURCE'", "'UPDATE'", "'DISK'", 
                     "'OPENQUERY'", "'UPDATETEXT'", "'DISTINCT'", "'OPENROWSET'", 
                     "'USE'", "'DISTRIBUTED'", "'OPENXML'", "'USER'", "'DOUBLE'", 
                     "'OPTION'", "'VALUES'", "'DROP'", "'OR'", "'VARYING'", 
                     "'DUMP'", "'ORDER'", "'VIEW'", "'ELSE'", "'OUTER'", 
                     "'WAITFOR'", "'END'", "'OVER'", "'WHEN'", "'ERRLVL'", 
                     "'PERCENT'", "'WHERE'", "'ESCAPE'", "'PIVOT'", "'WHILE'", 
                     "'EXCEPT'", "'PLAN'", "'WITH'", "'EXEC'", "'PRECISION'", 
                     "'WRITETEXT'", "'EXECUTE'", "'PRIMARY'", "'INTEGER'", 
                     "'NVARCHAR'", "'VARCHAR'", "'MAX'", "'TRY'", "'CATCH'", 
                     "'EXISTS'", "<INVALID>", "<INVALID>", "<INVALID>", 
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
                      "FUNCTION", "RETURN", "BREAK", "GOTO", "REVERT", "BROWSE", 
                      "GRANT", "REVOKE", "BULK", "GROUP", "RIGHT", "BY", 
                      "HAVING", "ROLLBACK", "CASCADE", "HOLDLOCK", "ROWCOUNT", 
                      "CASE", "IDENTITY", "ROWGUIDCOL", "CHECK", "IDENTITY_INSERT", 
                      "RULE", "CHECKPOINT", "IDENTITYCOL", "SAVE", "CLOSE", 
                      "IF", "SCHEMA", "CLUSTERED", "IN", "SECURITYAUDIT", 
                      "COALESCE", "INDEX", "SELECT", "COLLATE", "INNER", 
                      "SEMANTICKEYPHRASETABLE", "COLUMN", "INSERT", "SEMANTICSIMILARITYDETAILSTABLE", 
                      "COMMIT", "INTERSECT", "SEMANTICSIMILARITYTABLE", 
                      "COMPUTE", "INTO", "SESSION_USER", "CONSTRAINT", "IS", 
                      "SET", "CONTAINS", "JOIN", "SETUSER", "CONTAINSTABLE", 
                      "KEY", "SHUTDOWN", "CONTINUE", "KILL", "SOME", "CONVERT", 
                      "LEFT", "STATISTICS", "CREATE", "LIKE", "SYSTEM_USER", 
                      "CROSS", "LINENO", "TABLE", "CURRENT", "LOAD", "TABLESAMPLE", 
                      "CURRENT_DATE", "MERGE", "TEXTSIZE", "CURRENT_TIME", 
                      "NATIONAL", "THEN", "CURRENT_TIMESTAMP", "NOCHECK", 
                      "TO", "CURRENT_USER", "NONCLUSTERED", "TOP", "CURSOR", 
                      "NOT", "TRAN", "DATABASE", "NULL", "TRANSACTION", 
                      "DBCC", "NULLIF", "TRIGGER", "DEALLOCATE", "OF", "TRUNCATE", 
                      "DECLARE", "OFF", "TRY_CONVERT", "DEFAULT", "OFFSETS", 
                      "TSEQUAL", "DELETE", "ON", "UNION", "DENY", "OPEN", 
                      "UNIQUE", "DESC", "OPENDATASOURCE", "UPDATE", "DISK", 
                      "OPENQUERY", "UPDATETEXT", "DISTINCT", "OPENROWSET", 
                      "USE", "DISTRIBUTED", "OPENXML", "USER", "DOUBLE", 
                      "OPTION", "VALUES", "DROP", "OR", "VARYING", "DUMP", 
                      "ORDER", "VIEW", "ELSE", "OUTER", "WAITFOR", "END", 
                      "OVER", "WHEN", "ERRLVL", "PERCENT", "WHERE", "ESCAPE", 
                      "PIVOT", "WHILE", "EXCEPT", "PLAN", "WITH", "EXEC", 
                      "PRECISION", "WRITETEXT", "EXECUTE", "PRIMARY", "INT", 
                      "NVARCHAR", "VARCHAR", "MAX", "TRY", "CATCH", "EXISTS", 
                      "INT_LITERAL", "FLOAT_LITERAL", "HEX_LITERAL", "BIT_LITERAL", 
                      "TRUE_LITERAL", "FALSE_LITERAL", "STRING_LITERAL", 
                      "BRACKET_IDENTIFIER", "IDENTIFIER", "USER_VAR", "EQ", 
                      "NEQ", "GT", "LT", "GTE", "LTE", "PLUS", "MINUS", 
                      "STAR", "SLASH", "PLUS_EQ", "COMMA", "DOT", "LPAREN", 
                      "RPAREN", "SPAREN", "ZPAREN", "SEMI", "LINE_COMMENT", 
                      "COMMENT", "WS" ]

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
    RULE_predicate = 18
    RULE_comparisonOperator = 19
    RULE_expression = 20
    RULE_assignmentExpression = 21
    RULE_additiveExpression = 22
    RULE_multiplicativeExpression = 23
    RULE_unaryExpression = 24
    RULE_primaryExpression = 25
    RULE_caseExpression = 26
    RULE_whenClause = 27
    RULE_literal = 28
    RULE_functionCall = 29
    RULE_insertStatement = 30
    RULE_updateStatement = 31
    RULE_assignment = 32
    RULE_deleteStatement = 33
    RULE_ddlStatement = 34
    RULE_createTableStatement = 35
    RULE_columnDefinition = 36
    RULE_nullability = 37
    RULE_dataType = 38
    RULE_typeParams = 39
    RULE_dropTableStatement = 40
    RULE_alterTableStatement = 41
    RULE_alterAction = 42
    RULE_cursorStatement = 43
    RULE_declareCursor = 44
    RULE_openCursor = 45
    RULE_fetchCursor = 46
    RULE_closeCursor = 47
    RULE_blockStatement = 48
    RULE_blockContent = 49
    RULE_execStatement = 50
    RULE_tryCatchStatement = 51
    RULE_ifStatement = 52
    RULE_declareStatement = 53
    RULE_setStatement = 54

    ruleNames =  [ "sqlFile", "sqlStatement", "cteStatement", "cteDefinition", 
                   "dmlStatement", "selectStatement", "selectList", "selectElement", 
                   "tableSource", "tableName", "joinClause", "joinType", 
                   "columnName", "whereClause", "groupByClause", "orderByClause", 
                   "orderElement", "searchCondition", "predicate", "comparisonOperator", 
                   "expression", "assignmentExpression", "additiveExpression", 
                   "multiplicativeExpression", "unaryExpression", "primaryExpression", 
                   "caseExpression", "whenClause", "literal", "functionCall", 
                   "insertStatement", "updateStatement", "assignment", "deleteStatement", 
                   "ddlStatement", "createTableStatement", "columnDefinition", 
                   "nullability", "dataType", "typeParams", "dropTableStatement", 
                   "alterTableStatement", "alterAction", "cursorStatement", 
                   "declareCursor", "openCursor", "fetchCursor", "closeCursor", 
                   "blockStatement", "blockContent", "execStatement", "tryCatchStatement", 
                   "ifStatement", "declareStatement", "setStatement" ]

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
    REVERT=36
    BROWSE=37
    GRANT=38
    REVOKE=39
    BULK=40
    GROUP=41
    RIGHT=42
    BY=43
    HAVING=44
    ROLLBACK=45
    CASCADE=46
    HOLDLOCK=47
    ROWCOUNT=48
    CASE=49
    IDENTITY=50
    ROWGUIDCOL=51
    CHECK=52
    IDENTITY_INSERT=53
    RULE=54
    CHECKPOINT=55
    IDENTITYCOL=56
    SAVE=57
    CLOSE=58
    IF=59
    SCHEMA=60
    CLUSTERED=61
    IN=62
    SECURITYAUDIT=63
    COALESCE=64
    INDEX=65
    SELECT=66
    COLLATE=67
    INNER=68
    SEMANTICKEYPHRASETABLE=69
    COLUMN=70
    INSERT=71
    SEMANTICSIMILARITYDETAILSTABLE=72
    COMMIT=73
    INTERSECT=74
    SEMANTICSIMILARITYTABLE=75
    COMPUTE=76
    INTO=77
    SESSION_USER=78
    CONSTRAINT=79
    IS=80
    SET=81
    CONTAINS=82
    JOIN=83
    SETUSER=84
    CONTAINSTABLE=85
    KEY=86
    SHUTDOWN=87
    CONTINUE=88
    KILL=89
    SOME=90
    CONVERT=91
    LEFT=92
    STATISTICS=93
    CREATE=94
    LIKE=95
    SYSTEM_USER=96
    CROSS=97
    LINENO=98
    TABLE=99
    CURRENT=100
    LOAD=101
    TABLESAMPLE=102
    CURRENT_DATE=103
    MERGE=104
    TEXTSIZE=105
    CURRENT_TIME=106
    NATIONAL=107
    THEN=108
    CURRENT_TIMESTAMP=109
    NOCHECK=110
    TO=111
    CURRENT_USER=112
    NONCLUSTERED=113
    TOP=114
    CURSOR=115
    NOT=116
    TRAN=117
    DATABASE=118
    NULL=119
    TRANSACTION=120
    DBCC=121
    NULLIF=122
    TRIGGER=123
    DEALLOCATE=124
    OF=125
    TRUNCATE=126
    DECLARE=127
    OFF=128
    TRY_CONVERT=129
    DEFAULT=130
    OFFSETS=131
    TSEQUAL=132
    DELETE=133
    ON=134
    UNION=135
    DENY=136
    OPEN=137
    UNIQUE=138
    DESC=139
    OPENDATASOURCE=140
    UPDATE=141
    DISK=142
    OPENQUERY=143
    UPDATETEXT=144
    DISTINCT=145
    OPENROWSET=146
    USE=147
    DISTRIBUTED=148
    OPENXML=149
    USER=150
    DOUBLE=151
    OPTION=152
    VALUES=153
    DROP=154
    OR=155
    VARYING=156
    DUMP=157
    ORDER=158
    VIEW=159
    ELSE=160
    OUTER=161
    WAITFOR=162
    END=163
    OVER=164
    WHEN=165
    ERRLVL=166
    PERCENT=167
    WHERE=168
    ESCAPE=169
    PIVOT=170
    WHILE=171
    EXCEPT=172
    PLAN=173
    WITH=174
    EXEC=175
    PRECISION=176
    WRITETEXT=177
    EXECUTE=178
    PRIMARY=179
    INT=180
    NVARCHAR=181
    VARCHAR=182
    MAX=183
    TRY=184
    CATCH=185
    EXISTS=186
    INT_LITERAL=187
    FLOAT_LITERAL=188
    HEX_LITERAL=189
    BIT_LITERAL=190
    TRUE_LITERAL=191
    FALSE_LITERAL=192
    STRING_LITERAL=193
    BRACKET_IDENTIFIER=194
    IDENTIFIER=195
    USER_VAR=196
    EQ=197
    NEQ=198
    GT=199
    LT=200
    GTE=201
    LTE=202
    PLUS=203
    MINUS=204
    STAR=205
    SLASH=206
    PLUS_EQ=207
    COMMA=208
    DOT=209
    LPAREN=210
    RPAREN=211
    SPAREN=212
    ZPAREN=213
    SEMI=214
    LINE_COMMENT=215
    COMMENT=216
    WS=217

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
            self.state = 113
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while (((_la) & ~0x3f) == 0 and ((1 << _la) & 864691128723570848) != 0) or ((((_la - 66)) & ~0x3f) == 0 and ((1 << (_la - 66)) & 2305843009482162209) != 0) or ((((_la - 133)) & ~0x3f) == 0 and ((1 << (_la - 133)) & 41781443952913) != 0):
                self.state = 110
                self.sqlStatement()
                self.state = 115
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 116
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


        def declareStatement(self):
            return self.getTypedRuleContext(SqlParser.DeclareStatementContext,0)


        def setStatement(self):
            return self.getTypedRuleContext(SqlParser.SetStatementContext,0)


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
            self.state = 119
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==174:
                self.state = 118
                self.cteStatement()


            self.state = 130
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,2,self._ctx)
            if la_ == 1:
                self.state = 121
                self.dmlStatement()
                pass

            elif la_ == 2:
                self.state = 122
                self.ddlStatement()
                pass

            elif la_ == 3:
                self.state = 123
                self.cursorStatement()
                pass

            elif la_ == 4:
                self.state = 124
                self.ifStatement()
                pass

            elif la_ == 5:
                self.state = 125
                self.blockStatement()
                pass

            elif la_ == 6:
                self.state = 126
                self.declareStatement()
                pass

            elif la_ == 7:
                self.state = 127
                self.setStatement()
                pass

            elif la_ == 8:
                self.state = 128
                self.execStatement()
                pass

            elif la_ == 9:
                self.state = 129
                self.tryCatchStatement()
                pass


            self.state = 133
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,3,self._ctx)
            if la_ == 1:
                self.state = 132
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
            self.state = 135
            self.match(SqlParser.WITH)
            self.state = 136
            self.cteDefinition()
            self.state = 141
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==208:
                self.state = 137
                self.match(SqlParser.COMMA)
                self.state = 138
                self.cteDefinition()
                self.state = 143
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
            self.state = 144
            self.match(SqlParser.IDENTIFIER)
            self.state = 145
            self.match(SqlParser.AS)
            self.state = 146
            self.match(SqlParser.LPAREN)
            self.state = 147
            self.selectStatement()
            self.state = 148
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
            self.state = 154
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [66]:
                self.enterOuterAlt(localctx, 1)
                self.state = 150
                self.selectStatement()
                pass
            elif token in [71]:
                self.enterOuterAlt(localctx, 2)
                self.state = 151
                self.insertStatement()
                pass
            elif token in [141]:
                self.enterOuterAlt(localctx, 3)
                self.state = 152
                self.updateStatement()
                pass
            elif token in [133]:
                self.enterOuterAlt(localctx, 4)
                self.state = 153
                self.deleteStatement()
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
            self.state = 156
            self.match(SqlParser.SELECT)
            self.state = 157
            self.selectList()
            self.state = 158
            self.match(SqlParser.FROM)
            self.state = 159
            self.tableSource()
            self.state = 163
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while ((((_la - 29)) & ~0x3f) == 0 and ((1 << (_la - 29)) & -9205357088589471743) != 0):
                self.state = 160
                self.joinClause()
                self.state = 165
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 167
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==168:
                self.state = 166
                self.whereClause()


            self.state = 170
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==41:
                self.state = 169
                self.groupByClause()


            self.state = 173
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==158:
                self.state = 172
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
            self.state = 184
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [205]:
                self.enterOuterAlt(localctx, 1)
                self.state = 175
                self.match(SqlParser.STAR)
                pass
            elif token in [119, 187, 188, 191, 192, 193, 194, 195, 196]:
                self.enterOuterAlt(localctx, 2)
                self.state = 176
                self.selectElement()
                self.state = 181
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==208:
                    self.state = 177
                    self.match(SqlParser.COMMA)
                    self.state = 178
                    self.selectElement()
                    self.state = 183
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

        def columnName(self):
            return self.getTypedRuleContext(SqlParser.ColumnNameContext,0)


        def literal(self):
            return self.getTypedRuleContext(SqlParser.LiteralContext,0)


        def functionCall(self):
            return self.getTypedRuleContext(SqlParser.FunctionCallContext,0)


        def USER_VAR(self):
            return self.getToken(SqlParser.USER_VAR, 0)

        def expression(self):
            return self.getTypedRuleContext(SqlParser.ExpressionContext,0)


        def EQ(self):
            return self.getToken(SqlParser.EQ, 0)

        def PLUS_EQ(self):
            return self.getToken(SqlParser.PLUS_EQ, 0)

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
            self.state = 192
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,12,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 186
                self.columnName()
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 187
                self.literal()
                pass

            elif la_ == 3:
                self.enterOuterAlt(localctx, 3)
                self.state = 188
                self.functionCall()
                pass

            elif la_ == 4:
                self.enterOuterAlt(localctx, 4)
                self.state = 189
                self.match(SqlParser.USER_VAR)
                self.state = 190
                _la = self._input.LA(1)
                if not(_la==197 or _la==207):
                    self._errHandler.recoverInline(self)
                else:
                    self._errHandler.reportMatch(self)
                    self.consume()
                self.state = 191
                self.expression()
                pass


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
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 194
            self.tableName()
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
            self.state = 196
            _la = self._input.LA(1)
            if not(_la==194 or _la==195):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
            self.state = 201
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==209:
                self.state = 197
                self.match(SqlParser.DOT)
                self.state = 198
                _la = self._input.LA(1)
                if not(_la==194 or _la==195):
                    self._errHandler.recoverInline(self)
                else:
                    self._errHandler.reportMatch(self)
                    self.consume()
                self.state = 203
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
            self.state = 204
            self.joinType()
            self.state = 205
            self.match(SqlParser.JOIN)
            self.state = 206
            self.tableSource()
            self.state = 207
            self.match(SqlParser.ON)
            self.state = 208
            self.searchCondition(0)
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
        try:
            self.state = 215
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [68]:
                self.enterOuterAlt(localctx, 1)
                self.state = 210
                self.match(SqlParser.INNER)
                pass
            elif token in [92]:
                self.enterOuterAlt(localctx, 2)
                self.state = 211
                self.match(SqlParser.LEFT)
                pass
            elif token in [42]:
                self.enterOuterAlt(localctx, 3)
                self.state = 212
                self.match(SqlParser.RIGHT)
                pass
            elif token in [29]:
                self.enterOuterAlt(localctx, 4)
                self.state = 213
                self.match(SqlParser.FULL)
                pass
            elif token in [83]:
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

        def IDENTIFIER(self):
            return self.getToken(SqlParser.IDENTIFIER, 0)

        def BRACKET_IDENTIFIER(self):
            return self.getToken(SqlParser.BRACKET_IDENTIFIER, 0)

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
            self.state = 217
            _la = self._input.LA(1)
            if not(_la==194 or _la==195):
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
            self.state = 219
            self.match(SqlParser.WHERE)
            self.state = 220
            self.searchCondition(0)
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
            self.state = 222
            self.match(SqlParser.GROUP)
            self.state = 223
            self.match(SqlParser.BY)
            self.state = 224
            self.columnName()
            self.state = 229
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==208:
                self.state = 225
                self.match(SqlParser.COMMA)
                self.state = 226
                self.columnName()
                self.state = 231
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
            self.state = 232
            self.match(SqlParser.ORDER)
            self.state = 233
            self.match(SqlParser.BY)
            self.state = 234
            self.orderElement()
            self.state = 239
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==208:
                self.state = 235
                self.match(SqlParser.COMMA)
                self.state = 236
                self.orderElement()
                self.state = 241
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
            self.state = 242
            self.columnName()
            self.state = 244
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==19 or _la==139:
                self.state = 243
                _la = self._input.LA(1)
                if not(_la==19 or _la==139):
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

        def LPAREN(self):
            return self.getToken(SqlParser.LPAREN, 0)

        def searchCondition(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.SearchConditionContext)
            else:
                return self.getTypedRuleContext(SqlParser.SearchConditionContext,i)


        def RPAREN(self):
            return self.getToken(SqlParser.RPAREN, 0)

        def predicate(self):
            return self.getTypedRuleContext(SqlParser.PredicateContext,0)


        def AND(self):
            return self.getToken(SqlParser.AND, 0)

        def OR(self):
            return self.getToken(SqlParser.OR, 0)

        def getRuleIndex(self):
            return SqlParser.RULE_searchCondition

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterSearchCondition" ):
                listener.enterSearchCondition(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitSearchCondition" ):
                listener.exitSearchCondition(self)



    def searchCondition(self, _p:int=0):
        _parentctx = self._ctx
        _parentState = self.state
        localctx = SqlParser.SearchConditionContext(self, self._ctx, _parentState)
        _prevctx = localctx
        _startState = 34
        self.enterRecursionRule(localctx, 34, self.RULE_searchCondition, _p)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 252
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,18,self._ctx)
            if la_ == 1:
                self.state = 247
                self.match(SqlParser.LPAREN)
                self.state = 248
                self.searchCondition(0)
                self.state = 249
                self.match(SqlParser.RPAREN)
                pass

            elif la_ == 2:
                self.state = 251
                self.predicate()
                pass


            self._ctx.stop = self._input.LT(-1)
            self.state = 262
            self._errHandler.sync(self)
            _alt = self._interp.adaptivePredict(self._input,20,self._ctx)
            while _alt!=2 and _alt!=ATN.INVALID_ALT_NUMBER:
                if _alt==1:
                    if self._parseListeners is not None:
                        self.triggerExitRuleEvent()
                    _prevctx = localctx
                    self.state = 260
                    self._errHandler.sync(self)
                    la_ = self._interp.adaptivePredict(self._input,19,self._ctx)
                    if la_ == 1:
                        localctx = SqlParser.SearchConditionContext(self, _parentctx, _parentState)
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_searchCondition)
                        self.state = 254
                        if not self.precpred(self._ctx, 4):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 4)")
                        self.state = 255
                        self.match(SqlParser.AND)
                        self.state = 256
                        self.searchCondition(5)
                        pass

                    elif la_ == 2:
                        localctx = SqlParser.SearchConditionContext(self, _parentctx, _parentState)
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_searchCondition)
                        self.state = 257
                        if not self.precpred(self._ctx, 3):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 3)")
                        self.state = 258
                        self.match(SqlParser.OR)
                        self.state = 259
                        self.searchCondition(4)
                        pass

             
                self.state = 264
                self._errHandler.sync(self)
                _alt = self._interp.adaptivePredict(self._input,20,self._ctx)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.unrollRecursionContexts(_parentctx)
        return localctx


    class PredicateContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def expression(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.ExpressionContext)
            else:
                return self.getTypedRuleContext(SqlParser.ExpressionContext,i)


        def comparisonOperator(self):
            return self.getTypedRuleContext(SqlParser.ComparisonOperatorContext,0)


        def IN(self):
            return self.getToken(SqlParser.IN, 0)

        def LPAREN(self):
            return self.getToken(SqlParser.LPAREN, 0)

        def RPAREN(self):
            return self.getToken(SqlParser.RPAREN, 0)

        def COMMA(self, i:int=None):
            if i is None:
                return self.getTokens(SqlParser.COMMA)
            else:
                return self.getToken(SqlParser.COMMA, i)

        def IS(self):
            return self.getToken(SqlParser.IS, 0)

        def NULL(self):
            return self.getToken(SqlParser.NULL, 0)

        def NOT(self):
            return self.getToken(SqlParser.NOT, 0)

        def EXISTS(self):
            return self.getToken(SqlParser.EXISTS, 0)

        def selectStatement(self):
            return self.getTypedRuleContext(SqlParser.SelectStatementContext,0)


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
        self.enterRule(localctx, 36, self.RULE_predicate)
        self._la = 0 # Token type
        try:
            self.state = 302
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,22,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 265
                self.expression()
                self.state = 266
                self.comparisonOperator()
                self.state = 267
                self.expression()
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 269
                self.expression()
                self.state = 270
                self.match(SqlParser.IN)
                self.state = 271
                self.match(SqlParser.LPAREN)
                self.state = 272
                self.expression()
                self.state = 277
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==208:
                    self.state = 273
                    self.match(SqlParser.COMMA)
                    self.state = 274
                    self.expression()
                    self.state = 279
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)

                self.state = 280
                self.match(SqlParser.RPAREN)
                pass

            elif la_ == 3:
                self.enterOuterAlt(localctx, 3)
                self.state = 282
                self.expression()
                self.state = 283
                self.match(SqlParser.IS)
                self.state = 284
                self.match(SqlParser.NULL)
                pass

            elif la_ == 4:
                self.enterOuterAlt(localctx, 4)
                self.state = 286
                self.expression()
                self.state = 287
                self.match(SqlParser.IS)
                self.state = 288
                self.match(SqlParser.NOT)
                self.state = 289
                self.match(SqlParser.NULL)
                pass

            elif la_ == 5:
                self.enterOuterAlt(localctx, 5)
                self.state = 291
                self.match(SqlParser.EXISTS)
                self.state = 292
                self.match(SqlParser.LPAREN)
                self.state = 293
                self.selectStatement()
                self.state = 294
                self.match(SqlParser.RPAREN)
                pass

            elif la_ == 6:
                self.enterOuterAlt(localctx, 6)
                self.state = 296
                self.match(SqlParser.NOT)
                self.state = 297
                self.match(SqlParser.EXISTS)
                self.state = 298
                self.match(SqlParser.LPAREN)
                self.state = 299
                self.selectStatement()
                self.state = 300
                self.match(SqlParser.RPAREN)
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
        self.enterRule(localctx, 38, self.RULE_comparisonOperator)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 304
            _la = self._input.LA(1)
            if not(((((_la - 197)) & ~0x3f) == 0 and ((1 << (_la - 197)) & 63) != 0)):
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
        self.enterRule(localctx, 40, self.RULE_expression)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 306
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
        self.enterRule(localctx, 42, self.RULE_assignmentExpression)
        self._la = 0 # Token type
        try:
            self.state = 312
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,23,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 308
                self.match(SqlParser.USER_VAR)
                self.state = 309
                _la = self._input.LA(1)
                if not(_la==197 or _la==207):
                    self._errHandler.recoverInline(self)
                else:
                    self._errHandler.reportMatch(self)
                    self.consume()
                self.state = 310
                self.additiveExpression(0)
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 311
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
        _startState = 44
        self.enterRecursionRule(localctx, 44, self.RULE_additiveExpression, _p)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 315
            self.multiplicativeExpression(0)
            self._ctx.stop = self._input.LT(-1)
            self.state = 325
            self._errHandler.sync(self)
            _alt = self._interp.adaptivePredict(self._input,25,self._ctx)
            while _alt!=2 and _alt!=ATN.INVALID_ALT_NUMBER:
                if _alt==1:
                    if self._parseListeners is not None:
                        self.triggerExitRuleEvent()
                    _prevctx = localctx
                    self.state = 323
                    self._errHandler.sync(self)
                    la_ = self._interp.adaptivePredict(self._input,24,self._ctx)
                    if la_ == 1:
                        localctx = SqlParser.AdditiveExpressionContext(self, _parentctx, _parentState)
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_additiveExpression)
                        self.state = 317
                        if not self.precpred(self._ctx, 3):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 3)")
                        self.state = 318
                        self.match(SqlParser.PLUS)
                        self.state = 319
                        self.multiplicativeExpression(0)
                        pass

                    elif la_ == 2:
                        localctx = SqlParser.AdditiveExpressionContext(self, _parentctx, _parentState)
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_additiveExpression)
                        self.state = 320
                        if not self.precpred(self._ctx, 2):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 2)")
                        self.state = 321
                        self.match(SqlParser.MINUS)
                        self.state = 322
                        self.multiplicativeExpression(0)
                        pass

             
                self.state = 327
                self._errHandler.sync(self)
                _alt = self._interp.adaptivePredict(self._input,25,self._ctx)

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
        _startState = 46
        self.enterRecursionRule(localctx, 46, self.RULE_multiplicativeExpression, _p)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 329
            self.unaryExpression()
            self._ctx.stop = self._input.LT(-1)
            self.state = 339
            self._errHandler.sync(self)
            _alt = self._interp.adaptivePredict(self._input,27,self._ctx)
            while _alt!=2 and _alt!=ATN.INVALID_ALT_NUMBER:
                if _alt==1:
                    if self._parseListeners is not None:
                        self.triggerExitRuleEvent()
                    _prevctx = localctx
                    self.state = 337
                    self._errHandler.sync(self)
                    la_ = self._interp.adaptivePredict(self._input,26,self._ctx)
                    if la_ == 1:
                        localctx = SqlParser.MultiplicativeExpressionContext(self, _parentctx, _parentState)
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_multiplicativeExpression)
                        self.state = 331
                        if not self.precpred(self._ctx, 3):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 3)")
                        self.state = 332
                        self.match(SqlParser.STAR)
                        self.state = 333
                        self.unaryExpression()
                        pass

                    elif la_ == 2:
                        localctx = SqlParser.MultiplicativeExpressionContext(self, _parentctx, _parentState)
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_multiplicativeExpression)
                        self.state = 334
                        if not self.precpred(self._ctx, 2):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 2)")
                        self.state = 335
                        self.match(SqlParser.SLASH)
                        self.state = 336
                        self.unaryExpression()
                        pass

             
                self.state = 341
                self._errHandler.sync(self)
                _alt = self._interp.adaptivePredict(self._input,27,self._ctx)

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
        self.enterRule(localctx, 48, self.RULE_unaryExpression)
        try:
            self.state = 347
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [203]:
                self.enterOuterAlt(localctx, 1)
                self.state = 342
                self.match(SqlParser.PLUS)
                self.state = 343
                self.unaryExpression()
                pass
            elif token in [204]:
                self.enterOuterAlt(localctx, 2)
                self.state = 344
                self.match(SqlParser.MINUS)
                self.state = 345
                self.unaryExpression()
                pass
            elif token in [119, 187, 188, 191, 192, 193, 194, 195, 196, 210]:
                self.enterOuterAlt(localctx, 3)
                self.state = 346
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

        def columnName(self):
            return self.getTypedRuleContext(SqlParser.ColumnNameContext,0)


        def literal(self):
            return self.getTypedRuleContext(SqlParser.LiteralContext,0)


        def USER_VAR(self):
            return self.getToken(SqlParser.USER_VAR, 0)

        def functionCall(self):
            return self.getTypedRuleContext(SqlParser.FunctionCallContext,0)


        def LPAREN(self):
            return self.getToken(SqlParser.LPAREN, 0)

        def expression(self):
            return self.getTypedRuleContext(SqlParser.ExpressionContext,0)


        def RPAREN(self):
            return self.getToken(SqlParser.RPAREN, 0)

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
        self.enterRule(localctx, 50, self.RULE_primaryExpression)
        try:
            self.state = 357
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,29,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 349
                self.columnName()
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 350
                self.literal()
                pass

            elif la_ == 3:
                self.enterOuterAlt(localctx, 3)
                self.state = 351
                self.match(SqlParser.USER_VAR)
                pass

            elif la_ == 4:
                self.enterOuterAlt(localctx, 4)
                self.state = 352
                self.functionCall()
                pass

            elif la_ == 5:
                self.enterOuterAlt(localctx, 5)
                self.state = 353
                self.match(SqlParser.LPAREN)
                self.state = 354
                self.expression()
                self.state = 355
                self.match(SqlParser.RPAREN)
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
        self.enterRule(localctx, 52, self.RULE_caseExpression)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 359
            self.match(SqlParser.CASE)
            self.state = 361 
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while True:
                self.state = 360
                self.whenClause()
                self.state = 363 
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if not (_la==165):
                    break

            self.state = 367
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==160:
                self.state = 365
                self.match(SqlParser.ELSE)
                self.state = 366
                self.expression()


            self.state = 369
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
        self.enterRule(localctx, 54, self.RULE_whenClause)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 371
            self.match(SqlParser.WHEN)
            self.state = 372
            self.searchCondition(0)
            self.state = 373
            self.match(SqlParser.THEN)
            self.state = 374
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
        self.enterRule(localctx, 56, self.RULE_literal)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 376
            _la = self._input.LA(1)
            if not(_la==119 or ((((_la - 187)) & ~0x3f) == 0 and ((1 << (_la - 187)) & 115) != 0)):
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

        def IDENTIFIER(self):
            return self.getToken(SqlParser.IDENTIFIER, 0)

        def LPAREN(self):
            return self.getToken(SqlParser.LPAREN, 0)

        def RPAREN(self):
            return self.getToken(SqlParser.RPAREN, 0)

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

        def BRACKET_IDENTIFIER(self):
            return self.getToken(SqlParser.BRACKET_IDENTIFIER, 0)

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
        self.enterRule(localctx, 58, self.RULE_functionCall)
        self._la = 0 # Token type
        try:
            self.state = 404
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [195]:
                self.enterOuterAlt(localctx, 1)
                self.state = 378
                self.match(SqlParser.IDENTIFIER)
                self.state = 379
                self.match(SqlParser.LPAREN)
                self.state = 388
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==119 or ((((_la - 187)) & ~0x3f) == 0 and ((1 << (_la - 187)) & 8586227) != 0):
                    self.state = 380
                    self.expression()
                    self.state = 385
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)
                    while _la==208:
                        self.state = 381
                        self.match(SqlParser.COMMA)
                        self.state = 382
                        self.expression()
                        self.state = 387
                        self._errHandler.sync(self)
                        _la = self._input.LA(1)



                self.state = 390
                self.match(SqlParser.RPAREN)
                pass
            elif token in [194]:
                self.enterOuterAlt(localctx, 2)
                self.state = 391
                self.match(SqlParser.BRACKET_IDENTIFIER)
                self.state = 392
                self.match(SqlParser.LPAREN)
                self.state = 401
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==119 or ((((_la - 187)) & ~0x3f) == 0 and ((1 << (_la - 187)) & 8586227) != 0):
                    self.state = 393
                    self.expression()
                    self.state = 398
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)
                    while _la==208:
                        self.state = 394
                        self.match(SqlParser.COMMA)
                        self.state = 395
                        self.expression()
                        self.state = 400
                        self._errHandler.sync(self)
                        _la = self._input.LA(1)



                self.state = 403
                self.match(SqlParser.RPAREN)
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
        self.enterRule(localctx, 60, self.RULE_insertStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 406
            self.match(SqlParser.INSERT)
            self.state = 407
            self.match(SqlParser.INTO)
            self.state = 408
            self.tableName()
            self.state = 409
            self.match(SqlParser.LPAREN)
            self.state = 410
            self.columnName()
            self.state = 415
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==208:
                self.state = 411
                self.match(SqlParser.COMMA)
                self.state = 412
                self.columnName()
                self.state = 417
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 418
            self.match(SqlParser.RPAREN)
            self.state = 419
            self.match(SqlParser.VALUES)
            self.state = 420
            self.match(SqlParser.LPAREN)
            self.state = 421
            self.literal()
            self.state = 426
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==208:
                self.state = 422
                self.match(SqlParser.COMMA)
                self.state = 423
                self.literal()
                self.state = 428
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 429
            self.match(SqlParser.RPAREN)
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
        self.enterRule(localctx, 62, self.RULE_updateStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 431
            self.match(SqlParser.UPDATE)
            self.state = 432
            self.tableName()
            self.state = 433
            self.match(SqlParser.SET)
            self.state = 434
            self.assignment()
            self.state = 439
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==208:
                self.state = 435
                self.match(SqlParser.COMMA)
                self.state = 436
                self.assignment()
                self.state = 441
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 443
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==168:
                self.state = 442
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
        self.enterRule(localctx, 64, self.RULE_assignment)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 445
            self.columnName()
            self.state = 446
            _la = self._input.LA(1)
            if not(_la==197 or _la==207):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
            self.state = 447
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
        self.enterRule(localctx, 66, self.RULE_deleteStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 449
            self.match(SqlParser.DELETE)
            self.state = 450
            self.match(SqlParser.FROM)
            self.state = 451
            self.tableName()
            self.state = 453
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==168:
                self.state = 452
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
        self.enterRule(localctx, 68, self.RULE_ddlStatement)
        try:
            self.state = 458
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [94]:
                self.enterOuterAlt(localctx, 1)
                self.state = 455
                self.createTableStatement()
                pass
            elif token in [154]:
                self.enterOuterAlt(localctx, 2)
                self.state = 456
                self.dropTableStatement()
                pass
            elif token in [7]:
                self.enterOuterAlt(localctx, 3)
                self.state = 457
                self.alterTableStatement()
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
        self.enterRule(localctx, 70, self.RULE_createTableStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 460
            self.match(SqlParser.CREATE)
            self.state = 461
            self.match(SqlParser.TABLE)
            self.state = 462
            self.tableName()
            self.state = 463
            self.match(SqlParser.LPAREN)
            self.state = 464
            self.columnDefinition()
            self.state = 469
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==208:
                self.state = 465
                self.match(SqlParser.COMMA)
                self.state = 466
                self.columnDefinition()
                self.state = 471
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 472
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


        def nullability(self):
            return self.getTypedRuleContext(SqlParser.NullabilityContext,0)


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
        self.enterRule(localctx, 72, self.RULE_columnDefinition)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 474
            self.columnName()
            self.state = 475
            self.dataType()
            self.state = 477
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==116 or _la==119:
                self.state = 476
                self.nullability()


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
        self.enterRule(localctx, 74, self.RULE_nullability)
        try:
            self.state = 482
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [119]:
                self.enterOuterAlt(localctx, 1)
                self.state = 479
                self.match(SqlParser.NULL)
                pass
            elif token in [116]:
                self.enterOuterAlt(localctx, 2)
                self.state = 480
                self.match(SqlParser.NOT)
                self.state = 481
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
        self.enterRule(localctx, 76, self.RULE_dataType)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 495
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [180]:
                self.state = 484
                self.match(SqlParser.INT)
                pass
            elif token in [181]:
                self.state = 485
                self.match(SqlParser.NVARCHAR)
                self.state = 486
                self.match(SqlParser.LPAREN)
                self.state = 487
                _la = self._input.LA(1)
                if not(_la==183 or _la==187):
                    self._errHandler.recoverInline(self)
                else:
                    self._errHandler.reportMatch(self)
                    self.consume()
                self.state = 488
                self.match(SqlParser.RPAREN)
                pass
            elif token in [182]:
                self.state = 489
                self.match(SqlParser.VARCHAR)
                self.state = 490
                self.match(SqlParser.LPAREN)
                self.state = 491
                _la = self._input.LA(1)
                if not(_la==183 or _la==187):
                    self._errHandler.recoverInline(self)
                else:
                    self._errHandler.reportMatch(self)
                    self.consume()
                self.state = 492
                self.match(SqlParser.RPAREN)
                pass
            elif token in [194]:
                self.state = 493
                self.match(SqlParser.BRACKET_IDENTIFIER)
                pass
            elif token in [195]:
                self.state = 494
                self.match(SqlParser.IDENTIFIER)
                pass
            else:
                raise NoViableAltException(self)

            self.state = 498
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==210:
                self.state = 497
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
        self.enterRule(localctx, 78, self.RULE_typeParams)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 500
            self.match(SqlParser.LPAREN)
            self.state = 501
            _la = self._input.LA(1)
            if not(_la==183 or _la==187):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
            self.state = 502
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
        self.enterRule(localctx, 80, self.RULE_dropTableStatement)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 504
            self.match(SqlParser.DROP)
            self.state = 505
            self.match(SqlParser.TABLE)
            self.state = 506
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
        self.enterRule(localctx, 82, self.RULE_alterTableStatement)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 508
            self.match(SqlParser.ALTER)
            self.state = 509
            self.match(SqlParser.TABLE)
            self.state = 510
            self.tableName()
            self.state = 511
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
        self.enterRule(localctx, 84, self.RULE_alterAction)
        try:
            self.state = 517
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [1]:
                self.enterOuterAlt(localctx, 1)
                self.state = 513
                self.match(SqlParser.ADD)
                self.state = 514
                self.columnDefinition()
                pass
            elif token in [154]:
                self.enterOuterAlt(localctx, 2)
                self.state = 515
                self.match(SqlParser.DROP)
                self.state = 516
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
        self.enterRule(localctx, 86, self.RULE_cursorStatement)
        try:
            self.state = 523
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [127]:
                self.enterOuterAlt(localctx, 1)
                self.state = 519
                self.declareCursor()
                pass
            elif token in [137]:
                self.enterOuterAlt(localctx, 2)
                self.state = 520
                self.openCursor()
                pass
            elif token in [5]:
                self.enterOuterAlt(localctx, 3)
                self.state = 521
                self.fetchCursor()
                pass
            elif token in [58]:
                self.enterOuterAlt(localctx, 4)
                self.state = 522
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
        self.enterRule(localctx, 88, self.RULE_declareCursor)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 525
            self.match(SqlParser.DECLARE)
            self.state = 526
            self.match(SqlParser.IDENTIFIER)
            self.state = 527
            self.match(SqlParser.CURSOR)
            self.state = 528
            self.match(SqlParser.FOR)
            self.state = 529
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
        self.enterRule(localctx, 90, self.RULE_openCursor)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 531
            self.match(SqlParser.OPEN)
            self.state = 532
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
        self.enterRule(localctx, 92, self.RULE_fetchCursor)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 534
            self.match(SqlParser.FETCH)
            self.state = 535
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
        self.enterRule(localctx, 94, self.RULE_closeCursor)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 537
            self.match(SqlParser.CLOSE)
            self.state = 538
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
        self.enterRule(localctx, 96, self.RULE_blockStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 540
            self.match(SqlParser.BEGIN)
            self.state = 544
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while (((_la) & ~0x3f) == 0 and ((1 << _la) & 864691128723570848) != 0) or ((((_la - 66)) & ~0x3f) == 0 and ((1 << (_la - 66)) & 2305843009482162209) != 0) or ((((_la - 133)) & ~0x3f) == 0 and ((1 << (_la - 133)) & 41781443952913) != 0):
                self.state = 541
                self.blockContent()
                self.state = 546
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 547
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
        self.enterRule(localctx, 98, self.RULE_blockContent)
        try:
            self.state = 551
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,51,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 549
                self.sqlStatement()
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 550
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

        def expression(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(SqlParser.ExpressionContext)
            else:
                return self.getTypedRuleContext(SqlParser.ExpressionContext,i)


        def EXEC(self):
            return self.getToken(SqlParser.EXEC, 0)

        def EXECUTE(self):
            return self.getToken(SqlParser.EXECUTE, 0)

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
        self.enterRule(localctx, 100, self.RULE_execStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 553
            _la = self._input.LA(1)
            if not(_la==175 or _la==178):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
            self.state = 554
            self.expression()
            self.state = 559
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==208:
                self.state = 555
                self.match(SqlParser.COMMA)
                self.state = 556
                self.expression()
                self.state = 561
                self._errHandler.sync(self)
                _la = self._input.LA(1)

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
        self.enterRule(localctx, 102, self.RULE_tryCatchStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 562
            self.match(SqlParser.BEGIN)
            self.state = 563
            self.match(SqlParser.TRY)
            self.state = 567
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while (((_la) & ~0x3f) == 0 and ((1 << _la) & 864691128723570848) != 0) or ((((_la - 66)) & ~0x3f) == 0 and ((1 << (_la - 66)) & 2305843009482162209) != 0) or ((((_la - 133)) & ~0x3f) == 0 and ((1 << (_la - 133)) & 41781443952913) != 0):
                self.state = 564
                self.blockContent()
                self.state = 569
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 570
            self.match(SqlParser.END)
            self.state = 571
            self.match(SqlParser.TRY)
            self.state = 572
            self.match(SqlParser.BEGIN)
            self.state = 573
            self.match(SqlParser.CATCH)
            self.state = 577
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while (((_la) & ~0x3f) == 0 and ((1 << _la) & 864691128723570848) != 0) or ((((_la - 66)) & ~0x3f) == 0 and ((1 << (_la - 66)) & 2305843009482162209) != 0) or ((((_la - 133)) & ~0x3f) == 0 and ((1 << (_la - 133)) & 41781443952913) != 0):
                self.state = 574
                self.blockContent()
                self.state = 579
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 580
            self.match(SqlParser.END)
            self.state = 581
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
        self.enterRule(localctx, 104, self.RULE_ifStatement)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 583
            self.match(SqlParser.IF)
            self.state = 584
            self.searchCondition(0)
            self.state = 585
            self.sqlStatement()
            self.state = 588
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,55,self._ctx)
            if la_ == 1:
                self.state = 586
                self.match(SqlParser.ELSE)
                self.state = 587
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
        self.enterRule(localctx, 106, self.RULE_declareStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 590
            self.match(SqlParser.DECLARE)
            self.state = 591
            self.match(SqlParser.USER_VAR)
            self.state = 592
            self.dataType()
            self.state = 595
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==197:
                self.state = 593
                self.match(SqlParser.EQ)
                self.state = 594
                self.expression()


            self.state = 606
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==208:
                self.state = 597
                self.match(SqlParser.COMMA)
                self.state = 598
                self.match(SqlParser.USER_VAR)
                self.state = 599
                self.dataType()
                self.state = 602
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==197:
                    self.state = 600
                    self.match(SqlParser.EQ)
                    self.state = 601
                    self.expression()


                self.state = 608
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
        self.enterRule(localctx, 108, self.RULE_setStatement)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 609
            self.match(SqlParser.SET)
            self.state = 610
            self.match(SqlParser.USER_VAR)
            self.state = 611
            _la = self._input.LA(1)
            if not(_la==197 or _la==207):
                self._errHandler.recoverInline(self)
            else:
                self._errHandler.reportMatch(self)
                self.consume()
            self.state = 612
            self.expression()
            self.state = 619
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==208:
                self.state = 613
                self.match(SqlParser.COMMA)
                self.state = 614
                self.match(SqlParser.USER_VAR)
                self.state = 615
                _la = self._input.LA(1)
                if not(_la==197 or _la==207):
                    self._errHandler.recoverInline(self)
                else:
                    self._errHandler.reportMatch(self)
                    self.consume()
                self.state = 616
                self.expression()
                self.state = 621
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 623
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,60,self._ctx)
            if la_ == 1:
                self.state = 622
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
        self._predicates[17] = self.searchCondition_sempred
        self._predicates[22] = self.additiveExpression_sempred
        self._predicates[23] = self.multiplicativeExpression_sempred
        pred = self._predicates.get(ruleIndex, None)
        if pred is None:
            raise Exception("No predicate with index:" + str(ruleIndex))
        else:
            return pred(localctx, predIndex)

    def searchCondition_sempred(self, localctx:SearchConditionContext, predIndex:int):
            if predIndex == 0:
                return self.precpred(self._ctx, 4)
         

            if predIndex == 1:
                return self.precpred(self._ctx, 3)
         

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
- **Size**: 19.56 KB
- **Extension**: `.java`
- **Language**: `java`
- **Location**: `SqlParserBaseListener.java`
- **Relative Path**: `root`
- **Created**: 2026-01-11 06:03:50 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-15 13:30:58 (Asia/Damascus / GMT+03:00)
- **MD5**: `9e1e2816eb9eb9bbd710b89b1f9d62f7`
- **SHA256**: `3ebd51e95827084c3a8d57258ae1f00623f75281850481c073f633b67526dc36`
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
- **Size**: 19.02 KB
- **Extension**: `.java`
- **Language**: `java`
- **Location**: `SqlParserListener.java`
- **Relative Path**: `root`
- **Created**: 2026-01-11 06:03:50 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-15 13:30:58 (Asia/Damascus / GMT+03:00)
- **MD5**: `00c7cff84dbca7a59c481b058799919c`
- **SHA256**: `08c05c7288d375fa437f2c06bbd9751d1a6ba04570b8d7c5bf4319b2f816c9d2`
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
}
```

---

### <a id="📄-sqlparserlistener-py"></a>📄 `SqlParserListener.py`

**File Info:**
- **Size**: 16.42 KB
- **Extension**: `.py`
- **Language**: `python`
- **Location**: `SqlParserListener.py`
- **Relative Path**: `root`
- **Created**: 2026-01-10 14:46:39 (Asia/Damascus / GMT+03:00)
- **Modified**: 2026-01-15 11:20:50 (Asia/Damascus / GMT+03:00)
- **MD5**: `fa58255e4ef8fd9ae292543441128305`
- **SHA256**: `c4ee9c1f7c568f1f1b0473067187a4c356285c8c53946850a10908e5ce3d769d`
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
- **Modified**: 2026-01-15 06:28:33 (Asia/Damascus / GMT+03:00)
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

## 🚫 Binary/Excluded Files

The following files were not included in the text content:

- `SqlLexer.g4`
- `SqlLexer.tokens`
- `SqlParser.g4`
- `SqlParser.tokens`

