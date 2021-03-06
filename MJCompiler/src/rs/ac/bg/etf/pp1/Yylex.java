// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: spec/mjlexer.flex

package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
class Yylex implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int COMMENT = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1, 1
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\10\0\2\1\1\2\1\3\1\4\1\5\22\0\1\1"+
    "\1\6\3\0\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\12\22\1\23\1\24"+
    "\1\25\1\26\1\27\2\0\32\30\1\31\1\0\1\32"+
    "\1\0\1\33\1\0\1\34\1\35\1\36\1\37\1\40"+
    "\1\41\1\42\1\43\1\44\1\30\1\45\1\46\1\47"+
    "\1\50\1\51\1\52\1\30\1\53\1\54\1\55\1\56"+
    "\1\57\1\60\1\61\2\30\1\62\1\63\1\64\7\0"+
    "\1\3\u01a2\0\2\3\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\0\1\1\1\3\2\1\1\4"+
    "\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\16\22\1\25\1\1\1\26\1\27\1\0\1\30\1\31"+
    "\1\0\1\32\1\33\1\34\1\35\1\36\3\22\1\37"+
    "\5\22\1\40\10\22\1\41\1\42\1\43\10\22\1\44"+
    "\16\22\1\45\1\46\1\22\1\47\2\22\1\50\3\22"+
    "\1\51\1\52\1\53\1\22\1\54\1\55\1\56\2\22"+
    "\1\57\3\22\1\60\1\61\3\22\1\62\1\63\1\22"+
    "\1\64\1\65\1\66";

  private static int [] zzUnpackAction() {
    int [] result = new int[131];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\65\0\152\0\152\0\237\0\324\0\152\0\u0109"+
    "\0\u013e\0\152\0\152\0\152\0\u0173\0\152\0\u01a8\0\152"+
    "\0\u01dd\0\u0212\0\152\0\152\0\u0247\0\u027c\0\u02b1\0\u02e6"+
    "\0\152\0\152\0\u031b\0\u0350\0\u0385\0\u03ba\0\u03ef\0\u0424"+
    "\0\u0459\0\u048e\0\u04c3\0\u04f8\0\u052d\0\u0562\0\u0597\0\u05cc"+
    "\0\152\0\u0601\0\152\0\152\0\u0636\0\152\0\152\0\u066b"+
    "\0\152\0\152\0\152\0\152\0\152\0\u06a0\0\u06d5\0\u070a"+
    "\0\u02e6\0\u073f\0\u0774\0\u07a9\0\u07de\0\u0813\0\u02e6\0\u0848"+
    "\0\u087d\0\u08b2\0\u08e7\0\u091c\0\u0951\0\u0986\0\u09bb\0\152"+
    "\0\152\0\152\0\u09f0\0\u0a25\0\u0a5a\0\u0a8f\0\u0ac4\0\u0af9"+
    "\0\u0b2e\0\u0b63\0\u02e6\0\u0b98\0\u0bcd\0\u0c02\0\u0c37\0\u0c6c"+
    "\0\u0ca1\0\u0cd6\0\u0d0b\0\u0d40\0\u0d75\0\u0daa\0\u0ddf\0\u0e14"+
    "\0\u0e49\0\u02e6\0\u02e6\0\u0e7e\0\u02e6\0\u0eb3\0\u0ee8\0\u02e6"+
    "\0\u0f1d\0\u0f52\0\u0f87\0\u02e6\0\u02e6\0\u02e6\0\u0fbc\0\u02e6"+
    "\0\u02e6\0\u02e6\0\u0ff1\0\u1026\0\u02e6\0\u105b\0\u1090\0\u10c5"+
    "\0\u02e6\0\u02e6\0\u10fa\0\u112f\0\u1164\0\u02e6\0\u02e6\0\u1199"+
    "\0\u02e6\0\u02e6\0\u02e6";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[131];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\2\0\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\32\1\3\1\30\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\30\1\41\3\30\1\42\1\30\1\43"+
    "\1\44\1\45\1\46\1\30\1\47\1\50\1\30\1\51"+
    "\1\52\1\53\2\54\3\0\1\55\57\54\67\0\1\4"+
    "\110\0\1\56\46\0\1\57\54\0\2\60\4\0\57\60"+
    "\15\0\1\61\66\0\1\62\66\0\1\54\65\0\1\22"+
    "\70\0\1\63\64\0\1\64\64\0\1\65\60\0\1\30"+
    "\5\0\1\30\2\0\27\30\1\0\1\30\23\0\1\30"+
    "\5\0\1\30\2\0\20\30\1\66\6\30\1\0\1\30"+
    "\23\0\1\30\5\0\1\30\2\0\13\30\1\67\2\30"+
    "\1\70\10\30\1\0\1\30\23\0\1\30\5\0\1\30"+
    "\2\0\16\30\1\71\10\30\1\0\1\30\23\0\1\30"+
    "\5\0\1\30\2\0\13\30\1\72\1\30\1\73\10\30"+
    "\1\74\1\0\1\30\23\0\1\30\5\0\1\30\2\0"+
    "\1\30\1\75\25\30\1\0\1\30\23\0\1\30\5\0"+
    "\1\30\2\0\16\30\1\76\10\30\1\0\1\30\23\0"+
    "\1\30\5\0\1\30\2\0\6\30\1\77\20\30\1\0"+
    "\1\30\23\0\1\30\5\0\1\30\2\0\5\30\1\100"+
    "\21\30\1\0\1\30\23\0\1\30\5\0\1\30\2\0"+
    "\20\30\1\101\6\30\1\0\1\30\23\0\1\30\5\0"+
    "\1\30\2\0\5\30\1\102\21\30\1\0\1\30\23\0"+
    "\1\30\5\0\1\30\2\0\23\30\1\103\3\30\1\0"+
    "\1\30\23\0\1\30\5\0\1\30\2\0\10\30\1\104"+
    "\7\30\1\105\6\30\1\0\1\30\23\0\1\30\5\0"+
    "\1\30\2\0\16\30\1\106\10\30\1\0\1\30\23\0"+
    "\1\30\5\0\1\30\2\0\10\30\1\107\16\30\1\0"+
    "\1\30\64\0\1\110\3\0\1\111\73\0\1\112\75\0"+
    "\1\30\5\0\1\30\2\0\5\30\1\113\21\30\1\0"+
    "\1\30\23\0\1\30\5\0\1\30\2\0\1\30\1\114"+
    "\25\30\1\0\1\30\23\0\1\30\5\0\1\30\2\0"+
    "\15\30\1\115\11\30\1\0\1\30\23\0\1\30\5\0"+
    "\1\30\2\0\21\30\1\116\5\30\1\0\1\30\23\0"+
    "\1\30\5\0\1\30\2\0\23\30\1\117\3\30\1\0"+
    "\1\30\23\0\1\30\5\0\1\30\2\0\22\30\1\120"+
    "\4\30\1\0\1\30\23\0\1\30\5\0\1\30\2\0"+
    "\13\30\1\121\13\30\1\0\1\30\23\0\1\30\5\0"+
    "\1\30\2\0\22\30\1\122\4\30\1\0\1\30\23\0"+
    "\1\30\5\0\1\30\2\0\25\30\1\123\1\30\1\0"+
    "\1\30\23\0\1\30\5\0\1\30\2\0\11\30\1\124"+
    "\4\30\1\125\10\30\1\0\1\30\23\0\1\30\5\0"+
    "\1\30\2\0\1\30\1\126\1\30\1\127\16\30\1\130"+
    "\4\30\1\0\1\30\23\0\1\30\5\0\1\30\2\0"+
    "\17\30\1\131\7\30\1\0\1\30\23\0\1\30\5\0"+
    "\1\30\2\0\11\30\1\132\15\30\1\0\1\30\23\0"+
    "\1\30\5\0\1\30\2\0\23\30\1\133\3\30\1\0"+
    "\1\30\23\0\1\30\5\0\1\30\2\0\11\30\1\134"+
    "\15\30\1\0\1\30\23\0\1\30\5\0\1\30\2\0"+
    "\11\30\1\135\15\30\1\0\1\30\23\0\1\30\5\0"+
    "\1\30\2\0\1\30\1\136\25\30\1\0\1\30\23\0"+
    "\1\30\5\0\1\30\2\0\21\30\1\137\5\30\1\0"+
    "\1\30\23\0\1\30\5\0\1\30\2\0\21\30\1\140"+
    "\1\141\4\30\1\0\1\30\23\0\1\30\5\0\1\30"+
    "\2\0\5\30\1\142\21\30\1\0\1\30\23\0\1\30"+
    "\5\0\1\30\2\0\14\30\1\143\12\30\1\0\1\30"+
    "\23\0\1\30\5\0\1\30\2\0\5\30\1\144\21\30"+
    "\1\0\1\30\23\0\1\30\5\0\1\30\2\0\21\30"+
    "\1\133\5\30\1\0\1\30\23\0\1\30\5\0\1\30"+
    "\2\0\16\30\1\145\10\30\1\0\1\30\23\0\1\30"+
    "\5\0\1\30\2\0\15\30\1\146\11\30\1\0\1\30"+
    "\23\0\1\30\5\0\1\30\2\0\7\30\1\147\17\30"+
    "\1\0\1\30\23\0\1\30\5\0\1\30\2\0\4\30"+
    "\1\150\22\30\1\0\1\30\23\0\1\30\5\0\1\30"+
    "\2\0\16\30\1\151\10\30\1\0\1\30\23\0\1\30"+
    "\5\0\1\30\2\0\23\30\1\152\3\30\1\0\1\30"+
    "\23\0\1\30\5\0\1\30\2\0\5\30\1\153\21\30"+
    "\1\0\1\30\23\0\1\30\5\0\1\30\2\0\21\30"+
    "\1\154\5\30\1\0\1\30\23\0\1\30\5\0\1\30"+
    "\2\0\5\30\1\155\21\30\1\0\1\30\23\0\1\30"+
    "\5\0\1\30\2\0\4\30\1\156\22\30\1\0\1\30"+
    "\23\0\1\30\5\0\1\30\2\0\13\30\1\157\13\30"+
    "\1\0\1\30\23\0\1\30\5\0\1\30\2\0\12\30"+
    "\1\160\14\30\1\0\1\30\23\0\1\30\5\0\1\30"+
    "\2\0\21\30\1\161\5\30\1\0\1\30\23\0\1\30"+
    "\5\0\1\30\2\0\22\30\1\162\4\30\1\0\1\30"+
    "\23\0\1\30\5\0\1\30\2\0\11\30\1\163\15\30"+
    "\1\0\1\30\23\0\1\30\5\0\1\30\2\0\15\30"+
    "\1\164\11\30\1\0\1\30\23\0\1\30\5\0\1\30"+
    "\2\0\22\30\1\165\4\30\1\0\1\30\23\0\1\30"+
    "\5\0\1\30\2\0\20\30\1\166\6\30\1\0\1\30"+
    "\23\0\1\30\5\0\1\30\2\0\20\30\1\167\6\30"+
    "\1\0\1\30\23\0\1\30\5\0\1\30\2\0\20\30"+
    "\1\170\6\30\1\0\1\30\23\0\1\30\5\0\1\30"+
    "\2\0\20\30\1\171\6\30\1\0\1\30\23\0\1\30"+
    "\5\0\1\30\2\0\5\30\1\172\21\30\1\0\1\30"+
    "\23\0\1\30\5\0\1\30\2\0\15\30\1\173\11\30"+
    "\1\0\1\30\23\0\1\30\5\0\1\30\2\0\4\30"+
    "\1\174\22\30\1\0\1\30\23\0\1\30\5\0\1\30"+
    "\2\0\1\30\1\175\25\30\1\0\1\30\23\0\1\30"+
    "\5\0\1\30\2\0\4\30\1\176\22\30\1\0\1\30"+
    "\23\0\1\30\5\0\1\30\2\0\15\30\1\177\11\30"+
    "\1\0\1\30\23\0\1\30\5\0\1\30\2\0\23\30"+
    "\1\200\3\30\1\0\1\30\23\0\1\30\5\0\1\30"+
    "\2\0\21\30\1\201\5\30\1\0\1\30\23\0\1\30"+
    "\5\0\1\30\2\0\14\30\1\202\12\30\1\0\1\30"+
    "\23\0\1\30\5\0\1\30\2\0\5\30\1\203\21\30"+
    "\1\0\1\30\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4558];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\2\11\1\0\1\1\1\11\2\1\3\11\1\1"+
    "\1\11\1\1\1\11\2\1\2\11\4\1\2\11\16\1"+
    "\1\11\1\1\2\11\1\0\2\11\1\0\5\11\22\1"+
    "\3\11\71\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[131];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Yylex(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { 	return new_symbol(sym.EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1));
            }
            // fall through
          case 55: break;
          case 2:
            { 
            }
            // fall through
          case 56: break;
          case 3:
            { return new_symbol(sym.MOD, yytext());
            }
            // fall through
          case 57: break;
          case 4:
            { return new_symbol(sym.LPAREN, yytext());
            }
            // fall through
          case 58: break;
          case 5:
            { return new_symbol(sym.RPAREN, yytext());
            }
            // fall through
          case 59: break;
          case 6:
            { return new_symbol(sym.MUL, yytext());
            }
            // fall through
          case 60: break;
          case 7:
            { return new_symbol(sym.PLUS, yytext());
            }
            // fall through
          case 61: break;
          case 8:
            { return new_symbol(sym.COMMA, yytext());
            }
            // fall through
          case 62: break;
          case 9:
            { return new_symbol(sym.MINUS, yytext());
            }
            // fall through
          case 63: break;
          case 10:
            { return new_symbol(sym.DOT, yytext());
            }
            // fall through
          case 64: break;
          case 11:
            { return new_symbol(sym.DIV, yytext());
            }
            // fall through
          case 65: break;
          case 12:
            { return new_symbol(sym.NUMBER, new Integer (yytext()));
            }
            // fall through
          case 66: break;
          case 13:
            { return new_symbol(sym.COLON, yytext());
            }
            // fall through
          case 67: break;
          case 14:
            { return new_symbol(sym.SEMI, yytext());
            }
            // fall through
          case 68: break;
          case 15:
            { return new_symbol(sym.LT, yytext());
            }
            // fall through
          case 69: break;
          case 16:
            { return new_symbol(sym.EQUAL, yytext());
            }
            // fall through
          case 70: break;
          case 17:
            { return new_symbol(sym.GT, yytext());
            }
            // fall through
          case 71: break;
          case 18:
            { return new_symbol (sym.IDENT, yytext());
            }
            // fall through
          case 72: break;
          case 19:
            { return new_symbol(sym.LSQBR, yytext());
            }
            // fall through
          case 73: break;
          case 20:
            { return new_symbol(sym.RSQBR, yytext());
            }
            // fall through
          case 74: break;
          case 21:
            { return new_symbol(sym.LBRACE, yytext());
            }
            // fall through
          case 75: break;
          case 22:
            { return new_symbol(sym.RBRACE, yytext());
            }
            // fall through
          case 76: break;
          case 23:
            { yybegin(COMMENT);
            }
            // fall through
          case 77: break;
          case 24:
            { return new_symbol(sym.NOTEQUAL, yytext());
            }
            // fall through
          case 78: break;
          case 25:
            { return new_symbol(sym.AND, yytext());
            }
            // fall through
          case 79: break;
          case 26:
            { return new_symbol(sym.INC, yytext());
            }
            // fall through
          case 80: break;
          case 27:
            { return new_symbol(sym.DEC, yytext());
            }
            // fall through
          case 81: break;
          case 28:
            { return new_symbol(sym.LTE, yytext());
            }
            // fall through
          case 82: break;
          case 29:
            { return new_symbol(sym.EQEQ, yytext());
            }
            // fall through
          case 83: break;
          case 30:
            { return new_symbol(sym.GTE, yytext());
            }
            // fall through
          case 84: break;
          case 31:
            { return new_symbol(sym.DO, yytext());
            }
            // fall through
          case 85: break;
          case 32:
            { return new_symbol(sym.IF, yytext());
            }
            // fall through
          case 86: break;
          case 33:
            { return new_symbol(sym.OR, yytext());
            }
            // fall through
          case 87: break;
          case 34:
            { yybegin(YYINITIAL);
            }
            // fall through
          case 88: break;
          case 35:
            { return new_symbol (sym.CHAR, new Character(yytext().charAt(1)) );
            }
            // fall through
          case 89: break;
          case 36:
            { return new_symbol(sym.NEW, yytext());
            }
            // fall through
          case 90: break;
          case 37:
            { return new_symbol(sym.ELSE, yytext());
            }
            // fall through
          case 91: break;
          case 38:
            { return new_symbol(sym.ENUM, yytext());
            }
            // fall through
          case 92: break;
          case 39:
            { return new_symbol(sym.GOTO, yytext());
            }
            // fall through
          case 93: break;
          case 40:
            { return new_symbol(sym.READ, yytext());
            }
            // fall through
          case 94: break;
          case 41:
            { return new_symbol(sym.THIS, yytext());
            }
            // fall through
          case 95: break;
          case 42:
            { return new_symbol(sym.BOOL, yytext().equals("true") ? 1 : 0);
            }
            // fall through
          case 96: break;
          case 43:
            { return new_symbol(sym.VOID, yytext());
            }
            // fall through
          case 97: break;
          case 44:
            { return new_symbol(sym.BREAK, yytext());
            }
            // fall through
          case 98: break;
          case 45:
            { return new_symbol(sym.CLASS, yytext());
            }
            // fall through
          case 99: break;
          case 46:
            { return new_symbol(sym.CONST, yytext());
            }
            // fall through
          case 100: break;
          case 47:
            { return new_symbol(sym.PRINT, yytext());
            }
            // fall through
          case 101: break;
          case 48:
            { return new_symbol(sym.SUPER, yytext());
            }
            // fall through
          case 102: break;
          case 49:
            { return new_symbol(sym.WHILE, yytext());
            }
            // fall through
          case 103: break;
          case 50:
            { return new_symbol(sym.RECORD, yytext());
            }
            // fall through
          case 104: break;
          case 51:
            { return new_symbol(sym.RETURN, yytext());
            }
            // fall through
          case 105: break;
          case 52:
            { return new_symbol(sym.EXTENDS, yytext());
            }
            // fall through
          case 106: break;
          case 53:
            { return new_symbol(sym.PROG, yytext());
            }
            // fall through
          case 107: break;
          case 54:
            { return new_symbol(sym.CONT, yytext());
            }
            // fall through
          case 108: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
