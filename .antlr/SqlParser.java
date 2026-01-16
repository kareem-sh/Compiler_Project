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
		WRITETEXT=177, EXECUTE=178, PRIMARY=179, INT=180, INT_LITERAL=181, FLOAT_LITERAL=182, 
		HEX_LITERAL=183, BIT_LITERAL=184, TRUE_LITERAL=185, FALSE_LITERAL=186, 
		STRING_LITERAL=187, BRACKET_IDENTIFIER=188, IDENTIFIER=189, USER_VAR=190, 
		EQ=191, NEQ=192, GT=193, LT=194, GTE=195, LTE=196, PLUS=197, MINUS=198, 
		STAR=199, SLASH=200, COMMA=201, DOT=202, LPAREN=203, RPAREN=204, SPAREN=205, 
		ZPAREN=206, SEMI=207, LINE_COMMENT=208, COMMENT=209, WS=210;
	public static final int
		RULE_sqlFile = 0, RULE_sqlStatement = 1, RULE_cteStatement = 2, RULE_cteDefinition = 3, 
		RULE_dmlStatement = 4, RULE_selectStatement = 5, RULE_selectList = 6, 
		RULE_selectElement = 7, RULE_tableSource = 8, RULE_tableName = 9, RULE_joinClause = 10, 
		RULE_joinType = 11, RULE_columnName = 12, RULE_whereClause = 13, RULE_groupByClause = 14, 
		RULE_orderByClause = 15, RULE_orderElement = 16, RULE_searchCondition = 17, 
		RULE_predicate = 18, RULE_comparisonOperator = 19, RULE_expression = 20, 
		RULE_literal = 21, RULE_insertStatement = 22, RULE_updateStatement = 23, 
		RULE_assignment = 24, RULE_deleteStatement = 25, RULE_ddlStatement = 26, 
		RULE_createTableStatement = 27, RULE_columnDefinition = 28, RULE_dataType = 29, 
		RULE_dropTableStatement = 30, RULE_alterTableStatement = 31, RULE_alterAction = 32, 
		RULE_cursorStatement = 33, RULE_declareCursor = 34, RULE_openCursor = 35, 
		RULE_fetchCursor = 36, RULE_closeCursor = 37;
	private static String[] makeRuleNames() {
		return new String[] {
			"sqlFile", "sqlStatement", "cteStatement", "cteDefinition", "dmlStatement", 
			"selectStatement", "selectList", "selectElement", "tableSource", "tableName", 
			"joinClause", "joinType", "columnName", "whereClause", "groupByClause", 
			"orderByClause", "orderElement", "searchCondition", "predicate", "comparisonOperator", 
			"expression", "literal", "insertStatement", "updateStatement", "assignment", 
			"deleteStatement", "ddlStatement", "createTableStatement", "columnDefinition", 
			"dataType", "dropTableStatement", "alterTableStatement", "alterAction", 
			"cursorStatement", "declareCursor", "openCursor", "fetchCursor", "closeCursor"
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
			null, null, null, null, "'TRUE'", "'FALSE'", null, null, null, null, 
			"'='", null, "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", 
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
			"INT_LITERAL", "FLOAT_LITERAL", "HEX_LITERAL", "BIT_LITERAL", "TRUE_LITERAL", 
			"FALSE_LITERAL", "STRING_LITERAL", "BRACKET_IDENTIFIER", "IDENTIFIER", 
			"USER_VAR", "EQ", "NEQ", "GT", "LT", "GTE", "LTE", "PLUS", "MINUS", "STAR", 
			"SLASH", "COMMA", "DOT", "LPAREN", "RPAREN", "SPAREN", "ZPAREN", "SEMI", 
			"LINE_COMMENT", "COMMENT", "WS"
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
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376151711904L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 2305843009482129441L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 2199025352977L) != 0)) {
				{
				{
				setState(76);
				sqlStatement();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
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
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(84);
				cteStatement();
				}
			}

			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
			case INSERT:
			case DELETE:
			case UPDATE:
				{
				setState(87);
				dmlStatement();
				}
				break;
			case ALTER:
			case CREATE:
			case DROP:
				{
				setState(88);
				ddlStatement();
				}
				break;
			case FETCH:
			case CLOSE:
			case DECLARE:
			case OPEN:
				{
				setState(89);
				cursorStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(92);
				match(SEMI);
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
			setState(95);
			match(WITH);
			setState(96);
			cteDefinition();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(97);
				match(COMMA);
				setState(98);
				cteDefinition();
				}
				}
				setState(103);
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
			setState(104);
			match(IDENTIFIER);
			setState(105);
			match(AS);
			setState(106);
			match(LPAREN);
			setState(107);
			selectStatement();
			setState(108);
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
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				selectStatement();
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				insertStatement();
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				updateStatement();
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
				deleteStatement();
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
			setState(116);
			match(SELECT);
			setState(117);
			selectList();
			setState(118);
			match(FROM);
			setState(119);
			tableSource();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 29)) & ~0x3f) == 0 && ((1L << (_la - 29)) & -9205357088589471743L) != 0)) {
				{
				{
				setState(120);
				joinClause();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(126);
				whereClause();
				}
			}

			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(129);
				groupByClause();
				}
			}

			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(132);
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
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(STAR);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				selectElement();
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(137);
					match(COMMA);
					setState(138);
					selectElement();
					}
					}
					setState(143);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			columnName();
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
			setState(148);
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
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
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
			setState(152);
			joinType();
			setState(153);
			match(JOIN);
			setState(154);
			tableSource();
			setState(155);
			match(ON);
			setState(156);
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
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(INNER);
				}
				break;
			case LEFT:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(LEFT);
				}
				break;
			case RIGHT:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				match(RIGHT);
				}
				break;
			case FULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(161);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
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
			setState(167);
			match(WHERE);
			setState(168);
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
			setState(170);
			match(GROUP);
			setState(171);
			match(BY);
			setState(172);
			columnName();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(173);
				match(COMMA);
				setState(174);
				columnName();
				}
				}
				setState(179);
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
			setState(180);
			match(ORDER);
			setState(181);
			match(BY);
			setState(182);
			orderElement();
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(183);
				match(COMMA);
				setState(184);
				orderElement();
				}
				}
				setState(189);
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
			setState(190);
			columnName();
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(191);
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
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(195);
				match(LPAREN);
				setState(196);
				searchCondition(0);
				setState(197);
				match(RPAREN);
				}
				break;
			case NULL:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case TRUE_LITERAL:
			case FALSE_LITERAL:
			case STRING_LITERAL:
			case IDENTIFIER:
				{
				setState(199);
				predicate();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(208);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new SearchConditionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_searchCondition);
						setState(202);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(203);
						match(AND);
						setState(204);
						searchCondition(5);
						}
						break;
					case 2:
						{
						_localctx = new SearchConditionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_searchCondition);
						setState(205);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(206);
						match(OR);
						setState(207);
						searchCondition(4);
						}
						break;
					}
					} 
				}
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			expression();
			setState(214);
			comparisonOperator();
			setState(215);
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
			setState(217);
			_la = _input.LA(1);
			if ( !(((((_la - 191)) & ~0x3f) == 0 && ((1L << (_la - 191)) & 63L) != 0)) ) {
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
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
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
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				columnName();
				}
				break;
			case NULL:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case TRUE_LITERAL:
			case FALSE_LITERAL:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				literal();
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
		enterRule(_localctx, 42, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_la = _input.LA(1);
			if ( !(((((_la - 119)) & ~0x3f) == 0 && ((1L << (_la - 119)) & -4611686018427387903L) != 0) || ((((_la - 185)) & ~0x3f) == 0 && ((1L << (_la - 185)) & 7L) != 0)) ) {
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
		enterRule(_localctx, 44, RULE_insertStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(INSERT);
			setState(226);
			match(INTO);
			setState(227);
			tableName();
			setState(228);
			match(LPAREN);
			setState(229);
			columnName();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(230);
				match(COMMA);
				setState(231);
				columnName();
				}
				}
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(237);
			match(RPAREN);
			setState(238);
			match(VALUES);
			setState(239);
			match(LPAREN);
			setState(240);
			literal();
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(241);
				match(COMMA);
				setState(242);
				literal();
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(248);
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
		enterRule(_localctx, 46, RULE_updateStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(UPDATE);
			setState(251);
			tableName();
			setState(252);
			match(SET);
			setState(253);
			assignment();
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(254);
				match(COMMA);
				setState(255);
				assignment();
				}
				}
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(261);
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
		public TerminalNode EQ() { return getToken(SqlParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 48, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			columnName();
			setState(265);
			match(EQ);
			setState(266);
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
		enterRule(_localctx, 50, RULE_deleteStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(DELETE);
			setState(269);
			match(FROM);
			setState(270);
			tableName();
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(271);
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
		enterRule(_localctx, 52, RULE_ddlStatement);
		try {
			setState(277);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				createTableStatement();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				dropTableStatement();
				}
				break;
			case ALTER:
				enterOuterAlt(_localctx, 3);
				{
				setState(276);
				alterTableStatement();
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
		enterRule(_localctx, 54, RULE_createTableStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(CREATE);
			setState(280);
			match(TABLE);
			setState(281);
			tableName();
			setState(282);
			match(LPAREN);
			setState(283);
			columnDefinition();
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(284);
				match(COMMA);
				setState(285);
				columnDefinition();
				}
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(291);
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
		enterRule(_localctx, 56, RULE_columnDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			columnName();
			setState(294);
			dataType();
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
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
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
		enterRule(_localctx, 58, RULE_dataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==IDENTIFIER) ) {
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
		enterRule(_localctx, 60, RULE_dropTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(DROP);
			setState(299);
			match(TABLE);
			setState(300);
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
		enterRule(_localctx, 62, RULE_alterTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(ALTER);
			setState(303);
			match(TABLE);
			setState(304);
			tableName();
			setState(305);
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
		enterRule(_localctx, 64, RULE_alterAction);
		try {
			setState(311);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				match(ADD);
				setState(308);
				columnDefinition();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(309);
				match(DROP);
				setState(310);
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
		enterRule(_localctx, 66, RULE_cursorStatement);
		try {
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECLARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				declareCursor();
				}
				break;
			case OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				openCursor();
				}
				break;
			case FETCH:
				enterOuterAlt(_localctx, 3);
				{
				setState(315);
				fetchCursor();
				}
				break;
			case CLOSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(316);
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
		enterRule(_localctx, 68, RULE_declareCursor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(DECLARE);
			setState(320);
			match(IDENTIFIER);
			setState(321);
			match(CURSOR);
			setState(322);
			match(FOR);
			setState(323);
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
		enterRule(_localctx, 70, RULE_openCursor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(OPEN);
			setState(326);
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
		enterRule(_localctx, 72, RULE_fetchCursor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(FETCH);
			setState(329);
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
		enterRule(_localctx, 74, RULE_closeCursor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(CLOSE);
			setState(332);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return searchCondition_sempred((SearchConditionContext)_localctx, predIndex);
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

	public static final String _serializedATN =
		"\u0004\u0001\u00d2\u014f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
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
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0001\u0000\u0005\u0000N"+
		"\b\u0000\n\u0000\f\u0000Q\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0003\u0001V\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"[\b\u0001\u0001\u0001\u0003\u0001^\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u0002d\b\u0002\n\u0002\f\u0002g\t\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004s\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005z\b"+
		"\u0005\n\u0005\f\u0005}\t\u0005\u0001\u0005\u0003\u0005\u0080\b\u0005"+
		"\u0001\u0005\u0003\u0005\u0083\b\u0005\u0001\u0005\u0003\u0005\u0086\b"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u008c"+
		"\b\u0006\n\u0006\f\u0006\u008f\t\u0006\u0003\u0006\u0091\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00a4\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u00b0\b\u000e\n\u000e\f\u000e\u00b3\t\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00ba\b\u000f\n\u000f"+
		"\f\u000f\u00bd\t\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u00c1\b\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u00c9\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u00d1\b\u0011\n\u0011\f\u0011\u00d4"+
		"\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0003\u0014\u00de\b\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0005\u0016\u00e9\b\u0016\n\u0016\f\u0016\u00ec\t\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0005\u0016\u00f4\b\u0016\n\u0016\f\u0016\u00f7\t\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u0017\u0101\b\u0017\n\u0017\f\u0017\u0104\t\u0017\u0001\u0017"+
		"\u0003\u0017\u0107\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0111\b\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0116\b\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0005\u001b\u011f\b\u001b\n\u001b\f\u001b\u0122\t\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0003 \u0138"+
		"\b \u0001!\u0001!\u0001!\u0001!\u0003!\u013e\b!\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001"+
		"%\u0001%\u0001%\u0001%\u0000\u0001\"&\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJ\u0000\u0004\u0002\u0000\u0013\u0013\u008b\u008b\u0001\u0000\u00bf\u00c4"+
		"\u0003\u0000ww\u00b5\u00b6\u00b9\u00bb\u0002\u0000\u00b4\u00b4\u00bd\u00bd"+
		"\u014e\u0000O\u0001\u0000\u0000\u0000\u0002U\u0001\u0000\u0000\u0000\u0004"+
		"_\u0001\u0000\u0000\u0000\u0006h\u0001\u0000\u0000\u0000\br\u0001\u0000"+
		"\u0000\u0000\nt\u0001\u0000\u0000\u0000\f\u0090\u0001\u0000\u0000\u0000"+
		"\u000e\u0092\u0001\u0000\u0000\u0000\u0010\u0094\u0001\u0000\u0000\u0000"+
		"\u0012\u0096\u0001\u0000\u0000\u0000\u0014\u0098\u0001\u0000\u0000\u0000"+
		"\u0016\u00a3\u0001\u0000\u0000\u0000\u0018\u00a5\u0001\u0000\u0000\u0000"+
		"\u001a\u00a7\u0001\u0000\u0000\u0000\u001c\u00aa\u0001\u0000\u0000\u0000"+
		"\u001e\u00b4\u0001\u0000\u0000\u0000 \u00be\u0001\u0000\u0000\u0000\""+
		"\u00c8\u0001\u0000\u0000\u0000$\u00d5\u0001\u0000\u0000\u0000&\u00d9\u0001"+
		"\u0000\u0000\u0000(\u00dd\u0001\u0000\u0000\u0000*\u00df\u0001\u0000\u0000"+
		"\u0000,\u00e1\u0001\u0000\u0000\u0000.\u00fa\u0001\u0000\u0000\u00000"+
		"\u0108\u0001\u0000\u0000\u00002\u010c\u0001\u0000\u0000\u00004\u0115\u0001"+
		"\u0000\u0000\u00006\u0117\u0001\u0000\u0000\u00008\u0125\u0001\u0000\u0000"+
		"\u0000:\u0128\u0001\u0000\u0000\u0000<\u012a\u0001\u0000\u0000\u0000>"+
		"\u012e\u0001\u0000\u0000\u0000@\u0137\u0001\u0000\u0000\u0000B\u013d\u0001"+
		"\u0000\u0000\u0000D\u013f\u0001\u0000\u0000\u0000F\u0145\u0001\u0000\u0000"+
		"\u0000H\u0148\u0001\u0000\u0000\u0000J\u014b\u0001\u0000\u0000\u0000L"+
		"N\u0003\u0002\u0001\u0000ML\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000"+
		"\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000"+
		"\u0000\u0000QO\u0001\u0000\u0000\u0000RS\u0005\u0000\u0000\u0001S\u0001"+
		"\u0001\u0000\u0000\u0000TV\u0003\u0004\u0002\u0000UT\u0001\u0000\u0000"+
		"\u0000UV\u0001\u0000\u0000\u0000VZ\u0001\u0000\u0000\u0000W[\u0003\b\u0004"+
		"\u0000X[\u00034\u001a\u0000Y[\u0003B!\u0000ZW\u0001\u0000\u0000\u0000"+
		"ZX\u0001\u0000\u0000\u0000ZY\u0001\u0000\u0000\u0000[]\u0001\u0000\u0000"+
		"\u0000\\^\u0005\u00cf\u0000\u0000]\\\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^\u0003\u0001\u0000\u0000\u0000_`\u0005\u00ae\u0000\u0000"+
		"`e\u0003\u0006\u0003\u0000ab\u0005\u00c9\u0000\u0000bd\u0003\u0006\u0003"+
		"\u0000ca\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000"+
		"\u0000\u0000ef\u0001\u0000\u0000\u0000f\u0005\u0001\u0000\u0000\u0000"+
		"ge\u0001\u0000\u0000\u0000hi\u0005\u00bd\u0000\u0000ij\u0005\u0010\u0000"+
		"\u0000jk\u0005\u00cb\u0000\u0000kl\u0003\n\u0005\u0000lm\u0005\u00cc\u0000"+
		"\u0000m\u0007\u0001\u0000\u0000\u0000ns\u0003\n\u0005\u0000os\u0003,\u0016"+
		"\u0000ps\u0003.\u0017\u0000qs\u00032\u0019\u0000rn\u0001\u0000\u0000\u0000"+
		"ro\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rq\u0001\u0000\u0000"+
		"\u0000s\t\u0001\u0000\u0000\u0000tu\u0005B\u0000\u0000uv\u0003\f\u0006"+
		"\u0000vw\u0005\u001a\u0000\u0000w{\u0003\u0010\b\u0000xz\u0003\u0014\n"+
		"\u0000yx\u0001\u0000\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000"+
		"\u0000\u0000{|\u0001\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000"+
		"}{\u0001\u0000\u0000\u0000~\u0080\u0003\u001a\r\u0000\u007f~\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0082\u0001\u0000"+
		"\u0000\u0000\u0081\u0083\u0003\u001c\u000e\u0000\u0082\u0081\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0085\u0001\u0000"+
		"\u0000\u0000\u0084\u0086\u0003\u001e\u000f\u0000\u0085\u0084\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u000b\u0001\u0000"+
		"\u0000\u0000\u0087\u0091\u0005\u00c7\u0000\u0000\u0088\u008d\u0003\u000e"+
		"\u0007\u0000\u0089\u008a\u0005\u00c9\u0000\u0000\u008a\u008c\u0003\u000e"+
		"\u0007\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000"+
		"\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000"+
		"\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000"+
		"\u0000\u0000\u0090\u0087\u0001\u0000\u0000\u0000\u0090\u0088\u0001\u0000"+
		"\u0000\u0000\u0091\r\u0001\u0000\u0000\u0000\u0092\u0093\u0003\u0018\f"+
		"\u0000\u0093\u000f\u0001\u0000\u0000\u0000\u0094\u0095\u0003\u0012\t\u0000"+
		"\u0095\u0011\u0001\u0000\u0000\u0000\u0096\u0097\u0005\u00bd\u0000\u0000"+
		"\u0097\u0013\u0001\u0000\u0000\u0000\u0098\u0099\u0003\u0016\u000b\u0000"+
		"\u0099\u009a\u0005S\u0000\u0000\u009a\u009b\u0003\u0010\b\u0000\u009b"+
		"\u009c\u0005\u0086\u0000\u0000\u009c\u009d\u0003\"\u0011\u0000\u009d\u0015"+
		"\u0001\u0000\u0000\u0000\u009e\u00a4\u0005D\u0000\u0000\u009f\u00a4\u0005"+
		"\\\u0000\u0000\u00a0\u00a4\u0005*\u0000\u0000\u00a1\u00a4\u0005\u001d"+
		"\u0000\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3\u009e\u0001\u0000"+
		"\u0000\u0000\u00a3\u009f\u0001\u0000\u0000\u0000\u00a3\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a4\u0017\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u00bd"+
		"\u0000\u0000\u00a6\u0019\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u00a8"+
		"\u0000\u0000\u00a8\u00a9\u0003\"\u0011\u0000\u00a9\u001b\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0005)\u0000\u0000\u00ab\u00ac\u0005+\u0000\u0000\u00ac"+
		"\u00b1\u0003\u0018\f\u0000\u00ad\u00ae\u0005\u00c9\u0000\u0000\u00ae\u00b0"+
		"\u0003\u0018\f\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b2\u001d\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b5\u0005\u009e\u0000\u0000\u00b5\u00b6\u0005"+
		"+\u0000\u0000\u00b6\u00bb\u0003 \u0010\u0000\u00b7\u00b8\u0005\u00c9\u0000"+
		"\u0000\u00b8\u00ba\u0003 \u0010\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bd\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u001f\u0001\u0000\u0000\u0000"+
		"\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be\u00c0\u0003\u0018\f\u0000\u00bf"+
		"\u00c1\u0007\u0000\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c1!\u0001\u0000\u0000\u0000\u00c2\u00c3"+
		"\u0006\u0011\uffff\uffff\u0000\u00c3\u00c4\u0005\u00cb\u0000\u0000\u00c4"+
		"\u00c5\u0003\"\u0011\u0000\u00c5\u00c6\u0005\u00cc\u0000\u0000\u00c6\u00c9"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c9\u0003$\u0012\u0000\u00c8\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9\u00d2\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cb\n\u0004\u0000\u0000\u00cb\u00cc\u0005\n"+
		"\u0000\u0000\u00cc\u00d1\u0003\"\u0011\u0005\u00cd\u00ce\n\u0003\u0000"+
		"\u0000\u00ce\u00cf\u0005\u009b\u0000\u0000\u00cf\u00d1\u0003\"\u0011\u0004"+
		"\u00d0\u00ca\u0001\u0000\u0000\u0000\u00d0\u00cd\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d4\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3#\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d5\u00d6\u0003(\u0014\u0000\u00d6\u00d7"+
		"\u0003&\u0013\u0000\u00d7\u00d8\u0003(\u0014\u0000\u00d8%\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0007\u0001\u0000\u0000\u00da\'\u0001\u0000\u0000"+
		"\u0000\u00db\u00de\u0003\u0018\f\u0000\u00dc\u00de\u0003*\u0015\u0000"+
		"\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000"+
		"\u00de)\u0001\u0000\u0000\u0000\u00df\u00e0\u0007\u0002\u0000\u0000\u00e0"+
		"+\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005G\u0000\u0000\u00e2\u00e3\u0005"+
		"M\u0000\u0000\u00e3\u00e4\u0003\u0012\t\u0000\u00e4\u00e5\u0005\u00cb"+
		"\u0000\u0000\u00e5\u00ea\u0003\u0018\f\u0000\u00e6\u00e7\u0005\u00c9\u0000"+
		"\u0000\u00e7\u00e9\u0003\u0018\f\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ec\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000"+
		"\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005\u00cc\u0000\u0000"+
		"\u00ee\u00ef\u0005\u0099\u0000\u0000\u00ef\u00f0\u0005\u00cb\u0000\u0000"+
		"\u00f0\u00f5\u0003*\u0015\u0000\u00f1\u00f2\u0005\u00c9\u0000\u0000\u00f2"+
		"\u00f4\u0003*\u0015\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f4\u00f7"+
		"\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f6"+
		"\u0001\u0000\u0000\u0000\u00f6\u00f8\u0001\u0000\u0000\u0000\u00f7\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005\u00cc\u0000\u0000\u00f9-\u0001"+
		"\u0000\u0000\u0000\u00fa\u00fb\u0005\u008d\u0000\u0000\u00fb\u00fc\u0003"+
		"\u0012\t\u0000\u00fc\u00fd\u0005Q\u0000\u0000\u00fd\u0102\u00030\u0018"+
		"\u0000\u00fe\u00ff\u0005\u00c9\u0000\u0000\u00ff\u0101\u00030\u0018\u0000"+
		"\u0100\u00fe\u0001\u0000\u0000\u0000\u0101\u0104\u0001\u0000\u0000\u0000"+
		"\u0102\u0100\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000"+
		"\u0103\u0106\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000"+
		"\u0105\u0107\u0003\u001a\r\u0000\u0106\u0105\u0001\u0000\u0000\u0000\u0106"+
		"\u0107\u0001\u0000\u0000\u0000\u0107/\u0001\u0000\u0000\u0000\u0108\u0109"+
		"\u0003\u0018\f\u0000\u0109\u010a\u0005\u00bf\u0000\u0000\u010a\u010b\u0003"+
		"(\u0014\u0000\u010b1\u0001\u0000\u0000\u0000\u010c\u010d\u0005\u0085\u0000"+
		"\u0000\u010d\u010e\u0005\u001a\u0000\u0000\u010e\u0110\u0003\u0012\t\u0000"+
		"\u010f\u0111\u0003\u001a\r\u0000\u0110\u010f\u0001\u0000\u0000\u0000\u0110"+
		"\u0111\u0001\u0000\u0000\u0000\u01113\u0001\u0000\u0000\u0000\u0112\u0116"+
		"\u00036\u001b\u0000\u0113\u0116\u0003<\u001e\u0000\u0114\u0116\u0003>"+
		"\u001f\u0000\u0115\u0112\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000"+
		"\u0000\u0000\u0115\u0114\u0001\u0000\u0000\u0000\u01165\u0001\u0000\u0000"+
		"\u0000\u0117\u0118\u0005^\u0000\u0000\u0118\u0119\u0005c\u0000\u0000\u0119"+
		"\u011a\u0003\u0012\t\u0000\u011a\u011b\u0005\u00cb\u0000\u0000\u011b\u0120"+
		"\u00038\u001c\u0000\u011c\u011d\u0005\u00c9\u0000\u0000\u011d\u011f\u0003"+
		"8\u001c\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011f\u0122\u0001\u0000"+
		"\u0000\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000"+
		"\u0000\u0000\u0121\u0123\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000"+
		"\u0000\u0000\u0123\u0124\u0005\u00cc\u0000\u0000\u01247\u0001\u0000\u0000"+
		"\u0000\u0125\u0126\u0003\u0018\f\u0000\u0126\u0127\u0003:\u001d\u0000"+
		"\u01279\u0001\u0000\u0000\u0000\u0128\u0129\u0007\u0003\u0000\u0000\u0129"+
		";\u0001\u0000\u0000\u0000\u012a\u012b\u0005\u009a\u0000\u0000\u012b\u012c"+
		"\u0005c\u0000\u0000\u012c\u012d\u0003\u0012\t\u0000\u012d=\u0001\u0000"+
		"\u0000\u0000\u012e\u012f\u0005\u0007\u0000\u0000\u012f\u0130\u0005c\u0000"+
		"\u0000\u0130\u0131\u0003\u0012\t\u0000\u0131\u0132\u0003@ \u0000\u0132"+
		"?\u0001\u0000\u0000\u0000\u0133\u0134\u0005\u0001\u0000\u0000\u0134\u0138"+
		"\u00038\u001c\u0000\u0135\u0136\u0005\u009a\u0000\u0000\u0136\u0138\u0003"+
		"\u0018\f\u0000\u0137\u0133\u0001\u0000\u0000\u0000\u0137\u0135\u0001\u0000"+
		"\u0000\u0000\u0138A\u0001\u0000\u0000\u0000\u0139\u013e\u0003D\"\u0000"+
		"\u013a\u013e\u0003F#\u0000\u013b\u013e\u0003H$\u0000\u013c\u013e\u0003"+
		"J%\u0000\u013d\u0139\u0001\u0000\u0000\u0000\u013d\u013a\u0001\u0000\u0000"+
		"\u0000\u013d\u013b\u0001\u0000\u0000\u0000\u013d\u013c\u0001\u0000\u0000"+
		"\u0000\u013eC\u0001\u0000\u0000\u0000\u013f\u0140\u0005\u007f\u0000\u0000"+
		"\u0140\u0141\u0005\u00bd\u0000\u0000\u0141\u0142\u0005s\u0000\u0000\u0142"+
		"\u0143\u0005\u000e\u0000\u0000\u0143\u0144\u0003\n\u0005\u0000\u0144E"+
		"\u0001\u0000\u0000\u0000\u0145\u0146\u0005\u0089\u0000\u0000\u0146\u0147"+
		"\u0005\u00bd\u0000\u0000\u0147G\u0001\u0000\u0000\u0000\u0148\u0149\u0005"+
		"\u0005\u0000\u0000\u0149\u014a\u0005\u00bd\u0000\u0000\u014aI\u0001\u0000"+
		"\u0000\u0000\u014b\u014c\u0005:\u0000\u0000\u014c\u014d\u0005\u00bd\u0000"+
		"\u0000\u014dK\u0001\u0000\u0000\u0000\u001dOUZ]er{\u007f\u0082\u0085\u008d"+
		"\u0090\u00a3\u00b1\u00bb\u00c0\u00c8\u00d0\u00d2\u00dd\u00ea\u00f5\u0102"+
		"\u0106\u0110\u0115\u0120\u0137\u013d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}