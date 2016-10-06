package analisador;

import static analisador.Token.*;

class Lexer {

  public static final int YYEOF = -1;

  private static final int ZZ_BUFFERSIZE = 16384;

  public static final int YYINITIAL = 0;

  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\3\2\0\1\3\22\0\1\3\1\13\1\31\2\0"+
    "\1\10\1\11\1\0\1\27\1\30\1\6\1\4\1\31\1\5\1\31"+
    "\1\7\12\2\1\0\1\31\1\15\1\16\1\14\2\0\22\1\1\52"+
    "\7\1\1\31\1\0\1\31\1\0\1\1\1\0\1\24\1\40\1\36"+
    "\1\37\1\22\1\23\1\51\1\46\1\33\1\1\1\50\1\25\1\43"+
    "\1\42\1\35\1\32\1\1\1\20\1\26\1\17\1\21\1\34\1\44"+
    "\1\41\1\45\1\47\1\31\1\12\1\31\uff82\0";

  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\5\5\3\6\2\7"+
    "\1\10\7\2\2\11\12\2\1\10\1\12\1\6\1\7"+
    "\21\2\1\0\3\2\1\13\10\2\1\13\34\2\1\0"+
    "\4\2\1\13\20\2\1\14\12\2\1\3\16\2\1\13"+
    "\2\2\1\13\42\2";

  private static int [] zzUnpackAction() {
    int [] result = new int[184];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;   
    int j = offset;
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\53\0\126\0\201\0\53\0\254\0\327\0\u0102"+
    "\0\u012d\0\u0158\0\u0183\0\u01ae\0\u01d9\0\u0204\0\u022f\0\u01d9"+
    "\0\u025a\0\u0285\0\u02b0\0\u02db\0\u0306\0\u0331\0\u035c\0\u0387"+
    "\0\53\0\u03b2\0\u03dd\0\u0408\0\u0433\0\u045e\0\u0489\0\u04b4"+
    "\0\u04df\0\u050a\0\u0535\0\53\0\53\0\53\0\53\0\u0560"+
    "\0\u058b\0\u05b6\0\u05e1\0\u060c\0\u0637\0\u0662\0\u068d\0\u06b8"+
    "\0\u06e3\0\u070e\0\u0739\0\u0764\0\u078f\0\u07ba\0\u07e5\0\u0810"+
    "\0\u083b\0\u0866\0\u0891\0\u08bc\0\126\0\u08e7\0\u0912\0\u093d"+
    "\0\u0968\0\u0993\0\u09be\0\u09e9\0\u0a14\0\u0a3f\0\u0a6a\0\u0a95"+
    "\0\u0ac0\0\u0aeb\0\u0b16\0\u0b41\0\u0b6c\0\u0b97\0\u0bc2\0\u0bed"+
    "\0\u0c18\0\u0c43\0\u0c6e\0\u0c99\0\u0cc4\0\u0cef\0\u0d1a\0\u0d45"+
    "\0\u0d70\0\u0d9b\0\u0dc6\0\u0df1\0\u0e1c\0\u0e47\0\u0e72\0\u0e9d"+
    "\0\u0ec8\0\u0ef3\0\u0f1e\0\u0f49\0\u0f74\0\u0f9f\0\u0fca\0\u0ff5"+
    "\0\u1020\0\u104b\0\u1076\0\u10a1\0\u10cc\0\u10f7\0\u1122\0\u114d"+
    "\0\u1178\0\u11a3\0\u11ce\0\u11f9\0\u1224\0\u124f\0\u127a\0\u12a5"+
    "\0\126\0\u12d0\0\u12fb\0\u1326\0\u1351\0\u137c\0\u13a7\0\u13d2"+
    "\0\u13fd\0\u1428\0\u1453\0\53\0\u147e\0\u14a9\0\u14d4\0\u14ff"+
    "\0\u152a\0\u1555\0\u1580\0\u15ab\0\u15d6\0\u1601\0\u162c\0\u1657"+
    "\0\u1682\0\u16ad\0\u0c6e\0\u16d8\0\u1703\0\u172e\0\u1759\0\u1784"+
    "\0\u17af\0\u17da\0\u1805\0\u1830\0\u185b\0\u1886\0\u18b1\0\u18dc"+
    "\0\u1907\0\u1932\0\u195d\0\u1988\0\u19b3\0\u19de\0\u1a09\0\u1a34"+
    "\0\u1a5f\0\u1a8a\0\u1ab5\0\u1ae0\0\u1b0b\0\u1b36\0\u1b61\0\u1b8c"+
    "\0\u1bb7\0\u1be2\0\u1c0d\0\u1c38\0\u1c63\0\u1c8e\0\u1cb9\0\u1ce4";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[184];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0; 
    int j = offset; 
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\3\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\2\31\1\32\1\33\1\34\1\3\1\35\1\36\1\37"+
    "\1\3\1\40\1\3\1\41\4\3\1\42\1\43\54\0"+
    "\2\3\14\0\10\3\3\0\21\3\2\0\1\4\54\0"+
    "\1\44\11\0\1\44\41\0\1\44\10\0\1\44\43\0"+
    "\1\45\6\0\1\44\42\0\2\45\6\0\1\44\52\0"+
    "\1\44\45\0\1\46\53\0\1\46\56\0\1\47\50\0"+
    "\1\47\1\0\1\47\51\0\2\47\35\0\2\3\14\0"+
    "\1\3\1\50\6\3\3\0\14\3\1\51\4\3\1\0"+
    "\2\3\14\0\3\3\1\52\4\3\3\0\21\3\1\0"+
    "\2\3\14\0\6\3\1\53\1\3\3\0\7\3\1\54"+
    "\11\3\1\0\2\3\14\0\5\3\1\55\1\56\1\3"+
    "\3\0\1\3\1\57\1\3\1\60\15\3\1\0\2\3"+
    "\14\0\7\3\1\61\3\0\6\3\1\62\12\3\1\0"+
    "\2\3\14\0\10\3\3\0\3\3\1\63\15\3\1\0"+
    "\2\3\14\0\1\64\1\3\1\65\5\3\3\0\12\3"+
    "\1\66\1\67\1\70\4\3\5\0\1\71\46\0\2\3"+
    "\14\0\1\3\1\72\1\73\2\3\1\74\2\3\3\0"+
    "\21\3\1\0\2\3\14\0\4\3\1\75\3\3\3\0"+
    "\10\3\1\76\1\77\7\3\1\0\2\3\14\0\10\3"+
    "\3\0\3\3\1\100\15\3\1\0\2\3\14\0\5\3"+
    "\1\101\1\102\1\3\3\0\3\3\1\103\10\3\1\104"+
    "\4\3\1\0\2\3\14\0\3\3\1\105\4\3\3\0"+
    "\3\3\1\106\15\3\1\0\2\3\14\0\1\3\1\107"+
    "\6\3\3\0\3\3\1\110\7\3\1\111\5\3\1\0"+
    "\2\3\14\0\2\3\1\112\1\113\1\3\1\114\2\3"+
    "\3\0\21\3\1\0\2\3\14\0\10\3\3\0\14\3"+
    "\1\115\4\3\1\0\2\3\14\0\10\3\3\0\3\3"+
    "\1\116\15\3\1\0\2\3\14\0\1\117\7\3\3\0"+
    "\21\3\1\0\2\3\14\0\2\3\1\120\2\3\1\121"+
    "\2\3\3\0\13\3\1\75\5\3\1\0\2\3\14\0"+
    "\1\3\1\122\6\3\3\0\1\3\1\123\17\3\1\0"+
    "\2\3\14\0\1\124\7\3\3\0\21\3\1\0\2\3"+
    "\14\0\7\3\1\125\3\0\21\3\1\0\2\3\14\0"+
    "\1\126\7\3\3\0\21\3\1\0\2\3\14\0\6\3"+
    "\1\127\1\3\3\0\21\3\1\0\2\3\14\0\10\3"+
    "\3\0\3\3\1\130\15\3\1\0\2\3\14\0\10\3"+
    "\3\0\10\3\1\131\10\3\1\0\2\3\14\0\1\3"+
    "\1\75\6\3\3\0\21\3\1\0\2\3\14\0\7\3"+
    "\1\132\3\0\21\3\1\0\2\3\14\0\7\3\1\133"+
    "\3\0\21\3\1\0\2\3\14\0\10\3\3\0\10\3"+
    "\1\134\10\3\1\0\2\3\14\0\1\3\1\135\3\3"+
    "\1\136\2\3\3\0\21\3\1\0\2\3\14\0\10\3"+
    "\3\0\1\137\20\3\1\0\2\3\14\0\10\3\3\0"+
    "\1\3\1\140\17\3\1\0\2\3\14\0\10\3\3\0"+
    "\10\3\1\141\10\3\1\0\2\3\14\0\10\3\3\0"+
    "\3\3\1\142\15\3\2\0\1\143\51\0\2\3\14\0"+
    "\10\3\3\0\1\3\1\144\1\3\1\145\15\3\1\0"+
    "\2\3\14\0\10\3\3\0\6\3\1\146\12\3\1\0"+
    "\2\3\14\0\10\3\3\0\4\3\1\147\14\3\1\0"+
    "\2\3\14\0\1\150\6\3\1\151\3\0\21\3\1\0"+
    "\2\3\14\0\10\3\3\0\1\152\20\3\1\0\2\3"+
    "\14\0\6\3\1\153\1\3\3\0\1\3\1\154\17\3"+
    "\1\0\2\3\14\0\1\155\6\3\1\125\3\0\21\3"+
    "\1\0\2\3\14\0\5\3\1\156\2\3\3\0\21\3"+
    "\1\0\2\3\14\0\10\3\3\0\10\3\1\157\10\3"+
    "\1\0\2\3\14\0\5\3\1\60\2\3\3\0\21\3"+
    "\1\0\2\3\14\0\4\3\1\160\3\3\3\0\21\3"+
    "\1\0\2\3\14\0\2\3\1\161\5\3\3\0\21\3"+
    "\1\0\2\3\14\0\3\3\1\162\4\3\3\0\21\3"+
    "\1\0\2\3\14\0\10\3\3\0\3\3\1\163\15\3"+
    "\1\0\2\3\14\0\1\125\7\3\3\0\21\3\1\0"+
    "\2\3\14\0\6\3\1\164\1\3\3\0\21\3\1\0"+
    "\2\3\14\0\10\3\3\0\12\3\1\75\6\3\1\0"+
    "\2\3\14\0\1\165\7\3\3\0\21\3\1\0\2\3"+
    "\14\0\10\3\3\0\1\3\1\166\17\3\1\0\2\3"+
    "\14\0\1\167\7\3\3\0\21\3\1\0\2\3\14\0"+
    "\1\3\1\170\6\3\3\0\21\3\1\0\2\3\14\0"+
    "\3\3\1\171\4\3\3\0\21\3\1\0\2\3\14\0"+
    "\10\3\3\0\10\3\1\172\10\3\1\0\2\3\14\0"+
    "\10\3\3\0\3\3\1\173\15\3\1\0\2\3\14\0"+
    "\7\3\1\75\3\0\21\3\1\0\2\3\14\0\2\3"+
    "\1\174\5\3\3\0\21\3\1\0\2\3\14\0\3\3"+
    "\1\75\4\3\3\0\21\3\1\0\2\3\14\0\3\3"+
    "\1\175\4\3\3\0\21\3\1\0\2\3\14\0\7\3"+
    "\1\120\3\0\21\3\1\0\2\3\14\0\5\3\1\176"+
    "\2\3\3\0\21\3\1\0\2\3\14\0\5\3\1\177"+
    "\2\3\3\0\21\3\1\0\2\3\14\0\3\3\1\142"+
    "\4\3\3\0\21\3\1\0\2\3\14\0\1\200\7\3"+
    "\3\0\21\3\1\0\2\3\14\0\10\3\3\0\17\3"+
    "\1\75\1\3\1\0\2\3\14\0\10\3\3\0\1\3"+
    "\1\201\17\3\1\0\2\3\14\0\1\202\7\3\3\0"+
    "\21\3\1\0\2\3\14\0\3\3\1\60\4\3\3\0"+
    "\21\3\1\0\2\3\14\0\1\155\7\3\3\0\21\3"+
    "\1\0\2\3\14\0\10\3\3\0\4\3\1\203\14\3"+
    "\1\0\2\3\14\0\1\3\1\176\6\3\3\0\21\3"+
    "\2\0\1\143\25\0\1\204\23\0\2\3\14\0\10\3"+
    "\3\0\2\3\1\205\16\3\1\0\2\3\14\0\1\206"+
    "\7\3\3\0\21\3\1\0\2\3\14\0\6\3\1\202"+
    "\1\3\3\0\21\3\1\0\2\3\14\0\10\3\3\0"+
    "\16\3\1\207\2\3\1\0\2\3\14\0\3\3\1\210"+
    "\4\3\3\0\21\3\1\0\2\3\14\0\1\211\7\3"+
    "\3\0\21\3\1\0\2\3\14\0\6\3\1\212\1\3"+
    "\3\0\3\3\1\142\15\3\1\0\2\3\14\0\5\3"+
    "\1\213\2\3\3\0\21\3\1\0\2\3\14\0\10\3"+
    "\3\0\5\3\1\75\13\3\1\0\2\3\14\0\10\3"+
    "\3\0\4\3\1\214\14\3\1\0\2\3\14\0\7\3"+
    "\1\123\3\0\21\3\1\0\2\3\14\0\1\215\6\3"+
    "\1\176\3\0\21\3\1\0\2\3\14\0\5\3\1\216"+
    "\2\3\3\0\21\3\1\0\2\3\14\0\10\3\3\0"+
    "\6\3\1\166\12\3\1\0\2\3\14\0\5\3\1\217"+
    "\2\3\3\0\21\3\1\0\2\3\14\0\6\3\1\220"+
    "\1\3\3\0\21\3\1\0\2\3\14\0\6\3\1\75"+
    "\1\3\3\0\21\3\1\0\2\3\14\0\10\3\3\0"+
    "\1\3\1\221\17\3\1\0\2\3\14\0\6\3\1\125"+
    "\1\3\3\0\21\3\1\0\2\3\14\0\10\3\3\0"+
    "\3\3\1\75\15\3\1\0\2\3\14\0\10\3\3\0"+
    "\1\3\1\63\17\3\1\0\2\3\14\0\7\3\1\222"+
    "\3\0\21\3\1\0\2\3\14\0\10\3\3\0\12\3"+
    "\1\223\6\3\1\0\2\3\14\0\1\3\1\224\6\3"+
    "\3\0\21\3\1\0\2\3\14\0\10\3\3\0\10\3"+
    "\1\225\10\3\1\0\2\3\14\0\1\75\7\3\3\0"+
    "\21\3\1\0\2\3\14\0\6\3\1\226\1\3\3\0"+
    "\21\3\1\0\2\3\14\0\1\3\1\227\6\3\3\0"+
    "\21\3\1\0\2\3\14\0\10\3\3\0\4\3\1\230"+
    "\14\3\1\0\2\3\14\0\10\3\3\0\1\3\1\231"+
    "\17\3\1\0\2\3\14\0\10\3\3\0\14\3\1\232"+
    "\4\3\1\0\2\3\14\0\5\3\1\111\2\3\3\0"+
    "\21\3\1\0\2\3\14\0\3\3\1\233\4\3\3\0"+
    "\21\3\1\0\2\3\14\0\5\3\1\234\2\3\3\0"+
    "\21\3\1\0\2\3\14\0\1\3\1\235\6\3\3\0"+
    "\21\3\1\0\2\3\14\0\5\3\1\236\2\3\3\0"+
    "\21\3\1\0\2\3\14\0\3\3\1\237\4\3\3\0"+
    "\21\3\1\0\2\3\14\0\1\115\7\3\3\0\21\3"+
    "\1\0\2\3\14\0\10\3\3\0\14\3\1\75\4\3"+
    "\1\0\2\3\14\0\10\3\3\0\1\3\1\240\17\3"+
    "\1\0\2\3\14\0\2\3\1\241\5\3\3\0\21\3"+
    "\1\0\2\3\14\0\10\3\3\0\16\3\1\75\2\3"+
    "\1\0\2\3\14\0\3\3\1\242\4\3\3\0\21\3"+
    "\1\0\2\3\14\0\10\3\3\0\2\3\1\125\16\3"+
    "\1\0\2\3\14\0\10\3\3\0\1\3\1\243\17\3"+
    "\1\0\2\3\14\0\10\3\3\0\10\3\1\75\10\3"+
    "\1\0\2\3\14\0\10\3\3\0\5\3\1\123\13\3"+
    "\1\0\2\3\14\0\6\3\1\244\1\3\3\0\21\3"+
    "\1\0\2\3\14\0\5\3\1\245\2\3\3\0\21\3"+
    "\1\0\2\3\14\0\1\246\7\3\3\0\21\3\1\0"+
    "\2\3\14\0\10\3\3\0\4\3\1\75\14\3\1\0"+
    "\2\3\14\0\1\3\1\247\6\3\3\0\21\3\1\0"+
    "\2\3\14\0\10\3\3\0\4\3\1\250\14\3\1\0"+
    "\2\3\14\0\10\3\3\0\17\3\1\125\1\3\1\0"+
    "\2\3\14\0\4\3\1\251\3\3\3\0\21\3\1\0"+
    "\2\3\14\0\10\3\3\0\10\3\1\252\10\3\1\0"+
    "\2\3\14\0\10\3\3\0\11\3\1\253\7\3\1\0"+
    "\2\3\14\0\10\3\3\0\10\3\1\254\10\3\1\0"+
    "\2\3\14\0\6\3\1\176\1\3\3\0\21\3\1\0"+
    "\2\3\14\0\5\3\1\224\2\3\3\0\21\3\1\0"+
    "\2\3\14\0\3\3\1\255\4\3\3\0\21\3\1\0"+
    "\2\3\14\0\10\3\3\0\13\3\1\75\5\3\1\0"+
    "\2\3\14\0\10\3\3\0\4\3\1\176\14\3\1\0"+
    "\2\3\14\0\4\3\1\256\3\3\3\0\21\3\1\0"+
    "\2\3\14\0\10\3\3\0\3\3\1\257\15\3\1\0"+
    "\2\3\14\0\1\260\7\3\3\0\21\3\1\0\2\3"+
    "\14\0\5\3\1\261\2\3\3\0\21\3\1\0\2\3"+
    "\14\0\10\3\3\0\4\3\1\262\14\3\1\0\2\3"+
    "\14\0\3\3\1\263\4\3\3\0\21\3\1\0\2\3"+
    "\14\0\2\3\1\125\5\3\3\0\21\3\1\0\2\3"+
    "\14\0\10\3\3\0\10\3\1\176\10\3\1\0\2\3"+
    "\14\0\10\3\3\0\1\75\20\3\1\0\2\3\14\0"+
    "\10\3\3\0\10\3\1\264\10\3\1\0\2\3\14\0"+
    "\3\3\1\154\4\3\3\0\21\3\1\0\2\3\14\0"+
    "\10\3\3\0\4\3\1\125\14\3\1\0\2\3\14\0"+
    "\3\3\1\265\4\3\3\0\21\3\1\0\2\3\14\0"+
    "\10\3\3\0\10\3\1\266\10\3\1\0\2\3\14\0"+
    "\10\3\3\0\1\3\1\267\17\3\1\0\2\3\14\0"+
    "\10\3\3\0\3\3\1\270\15\3\1\0\2\3\14\0"+
    "\1\123\7\3\3\0\21\3\1\0\2\3\14\0\10\3"+
    "\3\0\15\3\1\260\3\3\1\0\2\3\14\0\4\3"+
    "\1\75\3\3\3\0\21\3";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7439];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;    
    int j = offset;
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\23\1\1\11\12\1\4\11"+
    "\21\1\1\0\51\1\1\0\40\1\1\11\64\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[184];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;      
    int j = offset;  
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  private java.io.Reader zzReader;

  private int zzState;

  private int zzLexicalState = YYINITIAL;

  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  private int zzMarkedPos;

  private int zzCurrentPos;

  private int zzStartRead;

  private int zzEndRead;

  private int yyline;

  private int yychar;

  private int yycolumn;

  private boolean zzAtBOL = true;

  private boolean zzAtEOF;

  private boolean zzEOFDone;

public String lexeme;

  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0; 
    int j = 0; 
    while (i < 134) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  private boolean zzRefill() throws java.io.IOException {

    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    if (zzCurrentPos >= zzBuffer.length) {
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
 
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

    return true;
  }

  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }

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

  public final int yystate() {
    return zzLexicalState;
  }

  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }

  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }

  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }

  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }

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

  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }

  public Token yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

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

            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();

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

      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 8: 
          { lexeme = yytext(); return OP_ATRIBUICAO;
          }
        case 13: break;
        case 2: 
          { lexeme=yytext(); return ID;
          }
        case 14: break;
        case 6: 
          { lexeme = yytext(); return OP_LOGICO;
          }
        case 15: break;
        case 11: 
          { lexeme = yytext(); return PALAVRA_RESERVADA;
          }
        case 16: break;
        case 12: 
          { lexeme=yytext(); return OP_BOOLEAN;
          }
        case 17: break;
        case 10: 
          { lexeme = yytext(); return COMENTAR;
          }
        case 18: break;
        case 3: 
          { lexeme=yytext(); return NUM;
          }
        case 19: break;
        case 1: 
          { return ERROR;
          }
        case 20: break;
        case 5: 
          { lexeme = yytext(); return OP_ARITMETICO;
          }
        case 21: break;
        case 9: 
          { lexeme = yytext(); return SEPARADORES;
          }
        case 22: break;
        case 7: 
          { lexeme = yytext(); return OP_RELACIONAL;
          }
        case 23: break;
        case 4: 
          { 
          }
        case 24: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
