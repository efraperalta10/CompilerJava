/* The following code was generated by JFlex 1.4.3 on 1/07/22 07:01 PM */

package compiler;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 1/07/22 07:01 PM from the specification file
 * <tt>C:/Users/moy_r_000/Desktop/CompilerJava/src/compiler/LexerCup.flex</tt>
 */
class LexerCup implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  3, 23,  0,  0,  3,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     3, 31,  0,  0,  0,  0,  0,  0, 35, 36, 24, 26,  3, 27, 33, 22, 
     2,  2,  2,  2,  2,  2,  2,  2,  2,  2, 34, 32, 29, 25, 30,  0, 
     0,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  0,  0,  0, 28,  1, 
     0,  8, 20,  1, 15, 12, 11,  7, 21, 10,  1,  1, 13,  9, 17,  6, 
     4,  1,  5, 14, 18, 16,  1, 19,  1,  1,  1, 37,  0, 38,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\16\2\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\1\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\0\2\2"+
    "\1\24\2\2\1\25\2\2\1\26\2\2\1\27\7\2"+
    "\1\4\1\0\1\30\1\31\1\32\1\33\1\0\1\34"+
    "\2\2\1\35\1\2\1\36\4\2\1\37\5\2\2\0"+
    "\1\2\1\40\1\41\1\2\1\42\1\2\1\43\1\44"+
    "\2\2\1\45\1\4\1\3\1\2\1\46\1\47\1\50"+
    "\1\51\1\2\1\52";

  private static int [] zzUnpackAction() {
    int [] result = new int[100];
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
    "\0\0\0\47\0\116\0\165\0\234\0\303\0\352\0\u0111"+
    "\0\u0138\0\u015f\0\u0186\0\u01ad\0\u01d4\0\u01fb\0\u0222\0\u0249"+
    "\0\u0270\0\u0297\0\u02be\0\u02e5\0\47\0\u030c\0\47\0\47"+
    "\0\47\0\u0333\0\u035a\0\u0381\0\47\0\47\0\47\0\u03a8"+
    "\0\47\0\47\0\47\0\u03cf\0\u03f6\0\u041d\0\116\0\u0444"+
    "\0\u046b\0\116\0\u0492\0\u04b9\0\116\0\u04e0\0\u0507\0\116"+
    "\0\u052e\0\u0555\0\u057c\0\u05a3\0\u05ca\0\u05f1\0\u0618\0\u063f"+
    "\0\u0666\0\47\0\47\0\47\0\47\0\u068d\0\u03cf\0\u06b4"+
    "\0\u06db\0\116\0\u0702\0\116\0\u0729\0\u0750\0\u0777\0\u079e"+
    "\0\116\0\u07c5\0\u07ec\0\u0813\0\u083a\0\u0861\0\u0888\0\u08af"+
    "\0\u08d6\0\116\0\116\0\u08fd\0\116\0\u0924\0\116\0\116"+
    "\0\u094b\0\u0972\0\116\0\u0666\0\47\0\u0999\0\116\0\116"+
    "\0\116\0\116\0\u09c0\0\116";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[100];
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
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\3"+
    "\1\11\1\12\1\13\1\14\1\15\2\3\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\3\1\24\1\5\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\50\0\2\3"+
    "\1\0\22\3\23\0\1\4\36\0\1\44\10\0\1\5"+
    "\23\0\1\5\20\0\2\3\1\0\1\3\1\45\20\3"+
    "\22\0\2\3\1\0\10\3\1\46\11\3\22\0\2\3"+
    "\1\0\1\3\1\47\20\3\22\0\2\3\1\0\15\3"+
    "\1\50\4\3\22\0\2\3\1\0\4\3\1\51\15\3"+
    "\22\0\2\3\1\0\7\3\1\52\5\3\1\53\4\3"+
    "\22\0\2\3\1\0\4\3\1\54\1\3\1\55\2\3"+
    "\1\56\10\3\22\0\2\3\1\0\11\3\1\57\10\3"+
    "\22\0\2\3\1\0\2\3\1\60\17\3\22\0\2\3"+
    "\1\0\15\3\1\61\4\3\22\0\2\3\1\0\2\3"+
    "\1\62\17\3\22\0\2\3\1\0\1\3\1\63\17\3"+
    "\1\64\22\0\2\3\1\0\1\3\1\65\17\3\1\66"+
    "\22\0\2\3\1\0\2\3\1\67\17\3\47\0\1\70"+
    "\1\0\1\71\47\0\1\72\46\0\1\73\46\0\1\74"+
    "\46\0\1\75\50\0\1\76\15\0\1\77\45\0\2\3"+
    "\1\0\2\3\1\100\17\3\22\0\2\3\1\0\4\3"+
    "\1\101\15\3\22\0\2\3\1\0\13\3\1\102\6\3"+
    "\22\0\2\3\1\0\6\3\1\103\13\3\22\0\2\3"+
    "\1\0\16\3\1\104\3\3\22\0\2\3\1\0\11\3"+
    "\1\105\10\3\22\0\2\3\1\0\2\3\1\106\17\3"+
    "\22\0\2\3\1\0\12\3\1\107\7\3\22\0\2\3"+
    "\1\0\16\3\1\110\3\3\22\0\2\3\1\0\16\3"+
    "\1\111\3\3\22\0\2\3\1\0\14\3\1\112\5\3"+
    "\22\0\2\3\1\0\10\3\1\113\11\3\22\0\2\3"+
    "\1\0\6\3\1\114\13\3\22\0\2\3\1\0\6\3"+
    "\1\115\13\3\22\0\2\3\1\0\2\3\1\116\17\3"+
    "\21\0\27\70\1\0\17\70\27\71\1\0\1\117\16\71"+
    "\2\0\1\120\45\0\2\3\1\0\3\3\1\121\16\3"+
    "\22\0\2\3\1\0\13\3\1\122\6\3\22\0\2\3"+
    "\1\0\15\3\1\123\4\3\22\0\2\3\1\0\12\3"+
    "\1\112\7\3\22\0\2\3\1\0\4\3\1\124\15\3"+
    "\22\0\2\3\1\0\10\3\1\125\11\3\22\0\2\3"+
    "\1\0\6\3\1\126\13\3\22\0\2\3\1\0\10\3"+
    "\1\127\11\3\22\0\2\3\1\0\15\3\1\130\4\3"+
    "\22\0\2\3\1\0\16\3\1\131\3\3\22\0\2\3"+
    "\1\0\11\3\1\132\10\3\22\0\2\3\1\0\11\3"+
    "\1\133\10\3\21\0\26\71\1\134\1\0\1\117\16\71"+
    "\2\0\1\120\41\0\1\135\3\0\2\3\1\0\1\3"+
    "\1\136\20\3\22\0\2\3\1\0\16\3\1\137\3\3"+
    "\22\0\2\3\1\0\11\3\1\140\10\3\22\0\2\3"+
    "\1\0\10\3\1\141\11\3\22\0\2\3\1\0\10\3"+
    "\1\142\11\3\22\0\2\3\1\0\4\3\1\143\15\3"+
    "\22\0\2\3\1\0\5\3\1\144\14\3\21\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2535];
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


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\22\1\1\11\1\1\3\11\3\1\3\11"+
    "\1\1\3\11\1\0\24\1\1\0\4\11\1\0\20\1"+
    "\2\0\14\1\1\11\7\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[100];
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

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  LexerCup(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  LexerCup(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
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
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
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


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
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
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 16: 
          { return new Symbol(sym.Par_abre, yychar, yyline, yytext());
          }
        case 43: break;
        case 30: 
          { return new Symbol(sym.Int, yychar, yyline, yytext());
          }
        case 44: break;
        case 42: 
          { return new Symbol(sym.Program, yychar, yyline, yytext());
          }
        case 45: break;
        case 13: 
          { return new Symbol(sym.Punto_coma, yychar, yyline, yytext());
          }
        case 46: break;
        case 32: 
          { return new Symbol(sym.Read, yychar, yyline, yytext());
          }
        case 47: break;
        case 18: 
          { return new Symbol(sym.Llave_abre, yychar, yyline, yytext());
          }
        case 48: break;
        case 34: 
          { return new Symbol(sym.Else, yychar, yyline, yytext());
          }
        case 49: break;
        case 25: 
          { return new Symbol(sym.Menor_igual, yychar, yyline, yytext());
          }
        case 50: break;
        case 36: 
          { return new Symbol(sym.Then, yychar, yyline, yytext());
          }
        case 51: break;
        case 5: 
          { return new Symbol(sym.Division, yychar, yyline, yytext());
          }
        case 52: break;
        case 28: 
          { return new Symbol(sym.Decimal, yychar, yyline, yytext());
          }
        case 53: break;
        case 23: 
          { return new Symbol(sym.Do, yychar, yyline, yytext());
          }
        case 54: break;
        case 26: 
          { return new Symbol(sym.Mayor_igual, yychar, yyline, yytext());
          }
        case 55: break;
        case 37: 
          { return new Symbol(sym.Bool, yychar, yyline, yytext());
          }
        case 56: break;
        case 9: 
          { return new Symbol(sym.Resta, yychar, yyline, yytext());
          }
        case 57: break;
        case 31: 
          { return new Symbol(sym.Not, yychar, yyline, yytext());
          }
        case 58: break;
        case 19: 
          { return new Symbol(sym.Llave_cierre, yychar, yyline, yytext());
          }
        case 59: break;
        case 12: 
          { return new Symbol(sym.Mayor, yychar, yyline, yytext());
          }
        case 60: break;
        case 11: 
          { return new Symbol(sym.Menor, yychar, yyline, yytext());
          }
        case 61: break;
        case 21: 
          { return new Symbol(sym.If, yychar, yyline, yytext());
          }
        case 62: break;
        case 40: 
          { return new Symbol(sym.Write, yychar, yyline, yytext());
          }
        case 63: break;
        case 29: 
          { return new Symbol(sym.And, yychar, yyline, yytext());
          }
        case 64: break;
        case 33: 
          { return new Symbol(sym.Main, yychar, yyline, yytext());
          }
        case 65: break;
        case 10: 
          { return new Symbol(sym.Potencia, yychar, yyline, yytext());
          }
        case 66: break;
        case 6: 
          { return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());
          }
        case 67: break;
        case 8: 
          { return new Symbol(sym.Suma, yychar, yyline, yytext());
          }
        case 68: break;
        case 24: 
          { return new Symbol(sym.Asignacion, yychar, yyline, yytext());
          }
        case 69: break;
        case 39: 
          { return new Symbol(sym.Until, yychar, yyline, yytext());
          }
        case 70: break;
        case 27: 
          { return new Symbol(sym.Diferente, yychar, yyline, yytext());
          }
        case 71: break;
        case 17: 
          { return new Symbol(sym.Par_cierre, yychar, yyline, yytext());
          }
        case 72: break;
        case 1: 
          { return new Symbol(sym.Error, yychar, yyline, yytext());
          }
        case 73: break;
        case 41: 
          { return new Symbol(sym.While, yychar, yyline, yytext());
          }
        case 74: break;
        case 20: 
          { return new Symbol(sym.Or, yychar, yyline, yytext());
          }
        case 75: break;
        case 14: 
          { return new Symbol(sym.Punto, yychar, yyline, yytext());
          }
        case 76: break;
        case 4: 
          { /*Ignore*/
          }
        case 77: break;
        case 7: 
          { return new Symbol(sym.Igual, yychar, yyline, yytext());
          }
        case 78: break;
        case 15: 
          { return new Symbol(sym.Coma, yychar, yyline, yytext());
          }
        case 79: break;
        case 2: 
          { return new Symbol(sym.Identificador, yychar, yyline, yytext());
          }
        case 80: break;
        case 22: 
          { return new Symbol(sym.Fi, yychar, yyline, yytext());
          }
        case 81: break;
        case 3: 
          { return new Symbol(sym.Numero, yychar, yyline, yytext());
          }
        case 82: break;
        case 38: 
          { return new Symbol(sym.Float, yychar, yyline, yytext());
          }
        case 83: break;
        case 35: 
          { return new Symbol(sym.Op_booleano, yychar, yyline, yytext());
          }
        case 84: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
