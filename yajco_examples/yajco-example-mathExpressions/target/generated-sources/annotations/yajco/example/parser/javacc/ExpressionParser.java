/* Generated By:JavaCC: Do not edit this line. ExpressionParser.java */
package yajco.example.parser.javacc;

public class ExpressionParser implements ExpressionParserConstants {

  static final public yajco.example.expression.model.Expression parse() throws ParseException {
  yajco.example.expression.model.Expression _value;
    _value = Expression1Symbol();
    jj_consume_token(0);
   {if (true) return _value;}
    throw new Error("Missing return statement in function");
  }

  static final public yajco.example.expression.model.Expression ExpressionSymbol() throws ParseException {
  yajco.example.expression.model.Expression _value = null;
    if (jj_2_1(2147483647)) {
      _value = NumberSymbol();
    } else if (jj_2_2(2147483647)) {
      jj_consume_token(_40);
      _value = Expression1Symbol();
      jj_consume_token(_41);
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return _value;}
    throw new Error("Missing return statement in function");
  }

  static final public yajco.example.expression.model.Expression Expression1Symbol() throws ParseException {
  yajco.example.expression.model.Expression _node1 = null;
  yajco.example.expression.model.Expression _node2 = null;
    _node1 = Expression2Symbol();
    label_1:
    while (true) {
      if (jj_2_3(2147483647)) {
        ;
      } else {
        break label_1;
      }
      if (jj_2_4(2147483647)) {
        jj_consume_token(PLUS);
        _node2 = Expression2Symbol();
    _node1 = yajco.ReferenceResolver.getInstance().register(new yajco.example.expression.model.Add(_node1, _node2), (Object)_node1, _node2);
      } else if (jj_2_5(2147483647)) {
        jj_consume_token(MINUS);
        _node2 = Expression2Symbol();
    _node1 = yajco.ReferenceResolver.getInstance().register(new yajco.example.expression.model.Sub(_node1, _node2), (Object)_node1, _node2);
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    {if (true) return _node1;}
    throw new Error("Missing return statement in function");
  }

  static final public yajco.example.expression.model.Expression Expression2Symbol() throws ParseException {
  yajco.example.expression.model.Expression _node1 = null;
  yajco.example.expression.model.Expression _node2 = null;
    _node1 = ExpressionSymbol();
    label_2:
    while (true) {
      if (jj_2_6(2147483647)) {
        ;
      } else {
        break label_2;
      }
      if (jj_2_7(2147483647)) {
        jj_consume_token(SLASH);
        _node2 = ExpressionSymbol();
    _node1 = yajco.ReferenceResolver.getInstance().register(new yajco.example.expression.model.Div(_node1, _node2), (Object)_node1, _node2);
      } else if (jj_2_8(2147483647)) {
        jj_consume_token(STAR);
        _node2 = ExpressionSymbol();
    _node1 = yajco.ReferenceResolver.getInstance().register(new yajco.example.expression.model.Mul(_node1, _node2), (Object)_node1, _node2);
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    {if (true) return _node1;}
    throw new Error("Missing return statement in function");
  }

  static final public yajco.example.expression.model.Number NumberSymbol() throws ParseException {
  int value_1 = 0;
  Token _tokenvalue_1 = null;
  int value_2 = 0;
  Token _tokenvalue_2 = null;
    if (jj_2_9(2147483647)) {
      _tokenvalue_1 = jj_consume_token(VALUE);
                                      value_1 = Integer.parseInt(_tokenvalue_1.image);
    {if (true) return yajco.ReferenceResolver.getInstance().register(new yajco.example.expression.model.Number( value_1), (Object)value_1);}
    } else if (jj_2_10(2147483647)) {
      _tokenvalue_2 = jj_consume_token(VALUE);
                                      value_2 = Integer.parseInt(_tokenvalue_2.image);
    {if (true) return yajco.ReferenceResolver.getInstance().register(new yajco.example.expression.model.Number( value_2), (Object)value_2);}
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  static private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  static private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  static private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  static private boolean jj_2_8(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  static private boolean jj_2_9(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_9(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  static private boolean jj_2_10(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_10(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(9, xla); }
  }

  static private boolean jj_3R_4() {
    if (jj_3R_7()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_13()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  static private boolean jj_3R_19() {
    if (jj_scan_token(SLASH)) return true;
    if (jj_3R_10()) return true;
    return false;
  }

  static private boolean jj_3_10() {
    if (jj_scan_token(VALUE)) return true;
    return false;
  }

  static private boolean jj_3R_14() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_19()) {
    jj_scanpos = xsp;
    if (jj_3R_20()) return true;
    }
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_3()) return true;
    return false;
  }

  static private boolean jj_3_2() {
    if (jj_scan_token(_40)) return true;
    if (jj_3R_4()) return true;
    if (jj_scan_token(_41)) return true;
    return false;
  }

  static private boolean jj_3R_9() {
    if (jj_scan_token(STAR)) return true;
    if (jj_3R_10()) return true;
    return false;
  }

  static private boolean jj_3_9() {
    if (jj_scan_token(VALUE)) return true;
    return false;
  }

  static private boolean jj_3R_7() {
    if (jj_3R_10()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_14()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  static private boolean jj_3R_12() {
    if (jj_scan_token(VALUE)) return true;
    return false;
  }

  static private boolean jj_3R_16() {
    if (jj_scan_token(_40)) return true;
    if (jj_3R_4()) return true;
    if (jj_scan_token(_41)) return true;
    return false;
  }

  static private boolean jj_3R_15() {
    if (jj_3R_3()) return true;
    return false;
  }

  static private boolean jj_3R_10() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_15()) {
    jj_scanpos = xsp;
    if (jj_3R_16()) return true;
    }
    return false;
  }

  static private boolean jj_3R_11() {
    if (jj_scan_token(VALUE)) return true;
    return false;
  }

  static private boolean jj_3_5() {
    if (jj_scan_token(MINUS)) return true;
    if (jj_3R_7()) return true;
    return false;
  }

  static private boolean jj_3R_3() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_11()) {
    jj_scanpos = xsp;
    if (jj_3R_12()) return true;
    }
    return false;
  }

  static private boolean jj_3_4() {
    if (jj_scan_token(PLUS)) return true;
    if (jj_3R_7()) return true;
    return false;
  }

  static private boolean jj_3R_5() {
    if (jj_scan_token(PLUS)) return true;
    if (jj_3R_7()) return true;
    return false;
  }

  static private boolean jj_3_3() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_5()) {
    jj_scanpos = xsp;
    if (jj_3R_6()) return true;
    }
    return false;
  }

  static private boolean jj_3R_18() {
    if (jj_scan_token(MINUS)) return true;
    if (jj_3R_7()) return true;
    return false;
  }

  static private boolean jj_3_8() {
    if (jj_scan_token(STAR)) return true;
    if (jj_3R_10()) return true;
    return false;
  }

  static private boolean jj_3R_17() {
    if (jj_scan_token(PLUS)) return true;
    if (jj_3R_7()) return true;
    return false;
  }

  static private boolean jj_3_7() {
    if (jj_scan_token(SLASH)) return true;
    if (jj_3R_10()) return true;
    return false;
  }

  static private boolean jj_3R_13() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_17()) {
    jj_scanpos = xsp;
    if (jj_3R_18()) return true;
    }
    return false;
  }

  static private boolean jj_3R_8() {
    if (jj_scan_token(SLASH)) return true;
    if (jj_3R_10()) return true;
    return false;
  }

  static private boolean jj_3R_6() {
    if (jj_scan_token(MINUS)) return true;
    if (jj_3R_7()) return true;
    return false;
  }

  static private boolean jj_3_6() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_8()) {
    jj_scanpos = xsp;
    if (jj_3R_9()) return true;
    }
    return false;
  }

  static private boolean jj_3R_20() {
    if (jj_scan_token(STAR)) return true;
    if (jj_3R_10()) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** User defined Token Manager. */
  static public TokenManager token_source;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[0];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[10];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;


  /** Constructor with user supplied Token Manager. */
  public ExpressionParser(TokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[8];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 0; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 8; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 10; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
            case 8: jj_3_9(); break;
            case 9: jj_3_10(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

                               }
