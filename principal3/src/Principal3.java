
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anastacio
 */
public class Principal3 {

    public static void main(String[] args) {
        Logon logon;
        String Usuario = JOptionPane.showInputDialog("Usuario:");
        String senha = JOptionPane.showInputDialog("senha:");
        if (!Usuario.equals(" ") && !senha.equals(" ")) {
            logon = new Logon(Usuario, senha);
        } else if (!Usuario.equals(" ") && !senha.equals(" ")) {
            logon = new Logon(Usuario);
        } else {
            System.out.println("opção Invalida:");
        }

    }
    package sun.text.resources.ga;

import sun.util.resources.ParallelListResourceBundle;

public class FormatData_ga extends ParallelListResourceBundle {

    public FormatData_ga() {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: invokespecial sun/util/resources/ParallelListResourceBundle."<init>":()V
         * 4: return
         *  */
        // </editor-fold>
    }

    protected final Object[][] getContents() {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: bipush        14
         * 2: anewarray     "[Ljava/lang/Object;"
         * 5: dup
         * 6: iconst_0
         * 7: iconst_2
         * 8: anewarray     java/lang/Object
         * 11: dup
         * 12: iconst_0
         * 13: ldc           MonthNames
         * 15: aastore
         * 16: dup
         * 17: iconst_1
         * 18: bipush        13
         * 20: anewarray     java/lang/String
         * 23: dup
         * 24: iconst_0
         * 25: ldc           EanÃ¡ir
         * 27: aastore
         * 28: dup
         * 29: iconst_1
         * 30: ldc           Feabhra
         * 32: aastore
         * 33: dup
         * 34: iconst_2
         * 35: ldc           MÃ¡rta
         * 37: aastore
         * 38: dup
         * 39: iconst_3
         * 40: ldc           AibreÃ¡n
         * 42: aastore
         * 43: dup
         * 44: iconst_4
         * 45: ldc           Bealtaine
         * 47: aastore
         * 48: dup
         * 49: iconst_5
         * 50: ldc           Meitheamh
         * 52: aastore
         * 53: dup
         * 54: bipush        6
         * 56: ldc           IÃºil
         * 58: aastore
         * 59: dup
         * 60: bipush        7
         * 62: ldc           LÃºnasa
         * 64: aastore
         * 65: dup
         * 66: bipush        8
         * 68: ldc           MeÃ¡n FÃ³mhair
         * 70: aastore
         * 71: dup
         * 72: bipush        9
         * 74: ldc           Deireadh FÃ³mhair
         * 76: aastore
         * 77: dup
         * 78: bipush        10
         * 80: ldc           Samhain
         * 82: aastore
         * 83: dup
         * 84: bipush        11
         * 86: ldc           Nollaig
         * 88: aastore
         * 89: dup
         * 90: bipush        12
         * 92: ldc
         * 94: aastore
         * 95: aastore
         * 96: aastore
         * 97: dup
         * 98: iconst_1
         * 99: iconst_2
         * 100: anewarray     java/lang/Object
         * 103: dup
         * 104: iconst_0
         * 105: ldc           MonthAbbreviations
         * 107: aastore
         * 108: dup
         * 109: iconst_1
         * 110: bipush        13
         * 112: anewarray     java/lang/String
         * 115: dup
         * 116: iconst_0
         * 117: ldc           Ean
         * 119: aastore
         * 120: dup
         * 121: iconst_1
         * 122: ldc           Feabh
         * 124: aastore
         * 125: dup
         * 126: iconst_2
         * 127: ldc           MÃ¡rta
         * 129: aastore
         * 130: dup
         * 131: iconst_3
         * 132: ldc           Aib
         * 134: aastore
         * 135: dup
         * 136: iconst_4
         * 137: ldc           Beal
         * 139: aastore
         * 140: dup
         * 141: iconst_5
         * 142: ldc           Meith
         * 144: aastore
         * 145: dup
         * 146: bipush        6
         * 148: ldc           IÃºil
         * 150: aastore
         * 151: dup
         * 152: bipush        7
         * 154: ldc           LÃºn
         * 156: aastore
         * 157: dup
         * 158: bipush        8
         * 160: ldc           MFÃ³mh
         * 162: aastore
         * 163: dup
         * 164: bipush        9
         * 166: ldc           DFÃ³mh
         * 168: aastore
         * 169: dup
         * 170: bipush        10
         * 172: ldc           Samh
         * 174: aastore
         * 175: dup
         * 176: bipush        11
         * 178: ldc           Noll
         * 180: aastore
         * 181: dup
         * 182: bipush        12
         * 184: ldc
         * 186: aastore
         * 187: aastore
         * 188: aastore
         * 189: dup
         * 190: iconst_2
         * 191: iconst_2
         * 192: anewarray     java/lang/Object
         * 195: dup
         * 196: iconst_0
         * 197: ldc           MonthNarrows
         * 199: aastore
         * 200: dup
         * 201: iconst_1
         * 202: bipush        13
         * 204: anewarray     java/lang/String
         * 207: dup
         * 208: iconst_0
         * 209: ldc           E
         * 211: aastore
         * 212: dup
         * 213: iconst_1
         * 214: ldc           F
         * 216: aastore
         * 217: dup
         * 218: iconst_2
         * 219: ldc           M
         * 221: aastore
         * 222: dup
         * 223: iconst_3
         * 224: ldc           A
         * 226: aastore
         * 227: dup
         * 228: iconst_4
         * 229: ldc           B
         * 231: aastore
         * 232: dup
         * 233: iconst_5
         * 234: ldc           M
         * 236: aastore
         * 237: dup
         * 238: bipush        6
         * 240: ldc           I
         * 242: aastore
         * 243: dup
         * 244: bipush        7
         * 246: ldc           L
         * 248: aastore
         * 249: dup
         * 250: bipush        8
         * 252: ldc           M
         * 254: aastore
         * 255: dup
         * 256: bipush        9
         * 258: ldc           D
         * 260: aastore
         * 261: dup
         * 262: bipush        10
         * 264: ldc           S
         * 266: aastore
         * 267: dup
         * 268: bipush        11
         * 270: ldc           N
         * 272: aastore
         * 273: dup
         * 274: bipush        12
         * 276: ldc
         * 278: aastore
         * 279: aastore
         * 280: aastore
         * 281: dup
         * 282: iconst_3
         * 283: iconst_2
         * 284: anewarray     java/lang/Object
         * 287: dup
         * 288: iconst_0
         * 289: ldc           DayNames
         * 291: aastore
         * 292: dup
         * 293: iconst_1
         * 294: bipush        7
         * 296: anewarray     java/lang/String
         * 299: dup
         * 300: iconst_0
         * 301: ldc           DÃ© Domhnaigh
         * 303: aastore
         * 304: dup
         * 305: iconst_1
         * 306: ldc           DÃ© Luain
         * 308: aastore
         * 309: dup
         * 310: iconst_2
         * 311: ldc           DÃ© MÃ¡irt
         * 313: aastore
         * 314: dup
         * 315: iconst_3
         * 316: ldc           DÃ© CÃ©adaoin
         * 318: aastore
         * 319: dup
         * 320: iconst_4
         * 321: ldc           DÃ©ardaoin
         * 323: aastore
         * 324: dup
         * 325: iconst_5
         * 326: ldc           DÃ© hAoine
         * 328: aastore
         * 329: dup
         * 330: bipush        6
         * 332: ldc           DÃ© Sathairn
         * 334: aastore
         * 335: aastore
         * 336: aastore
         * 337: dup
         * 338: iconst_4
         * 339: iconst_2
         * 340: anewarray     java/lang/Object
         * 343: dup
         * 344: iconst_0
         * 345: ldc           DayAbbreviations
         * 347: aastore
         * 348: dup
         * 349: iconst_1
         * 350: bipush        7
         * 352: anewarray     java/lang/String
         * 355: dup
         * 356: iconst_0
         * 357: ldc           Domh
         * 359: aastore
         * 360: dup
         * 361: iconst_1
         * 362: ldc           Luan
         * 364: aastore
         * 365: dup
         * 366: iconst_2
         * 367: ldc           MÃ¡irt
         * 369: aastore
         * 370: dup
         * 371: iconst_3
         * 372: ldc           CÃ©ad
         * 374: aastore
         * 375: dup
         * 376: iconst_4
         * 377: ldc           DÃ©ar
         * 379: aastore
         * 380: dup
         * 381: iconst_5
         * 382: ldc           Aoine
         * 384: aastore
         * 385: dup
         * 386: bipush        6
         * 388: ldc           Sath
         * 390: aastore
         * 391: aastore
         * 392: aastore
         * 393: dup
         * 394: iconst_5
         * 395: iconst_2
         * 396: anewarray     java/lang/Object
         * 399: dup
         * 400: iconst_0
         * 401: ldc           AmPmMarkers
         * 403: aastore
         * 404: dup
         * 405: iconst_1
         * 406: iconst_2
         * 407: anewarray     java/lang/String
         * 410: dup
         * 411: iconst_0
         * 412: ldc           a.m.
         * 414: aastore
         * 415: dup
         * 416: iconst_1
         * 417: ldc           p.m.
         * 419: aastore
         * 420: aastore
         * 421: aastore
         * 422: dup
         * 423: bipush        6
         * 425: iconst_2
         * 426: anewarray     java/lang/Object
         * 429: dup
         * 430: iconst_0
         * 431: ldc           Eras
         * 433: aastore
         * 434: dup
         * 435: iconst_1
         * 436: iconst_2
         * 437: anewarray     java/lang/String
         * 440: dup
         * 441: iconst_0
         * 442: ldc           RC
         * 444: aastore
         * 445: dup
         * 446: iconst_1
         * 447: ldc           AD
         * 449: aastore
         * 450: aastore
         * 451: aastore
         * 452: dup
         * 453: bipush        7
         * 455: iconst_2
         * 456: anewarray     java/lang/Object
         * 459: dup
         * 460: iconst_0
         * 461: ldc           short.Eras
         * 463: aastore
         * 464: dup
         * 465: iconst_1
         * 466: iconst_2
         * 467: anewarray     java/lang/String
         * 470: dup
         * 471: iconst_0
         * 472: ldc           RC
         * 474: aastore
         * 475: dup
         * 476: iconst_1
         * 477: ldc           AD
         * 479: aastore
         * 480: aastore
         * 481: aastore
         * 482: dup
         * 483: bipush        8
         * 485: iconst_2
         * 486: anewarray     java/lang/Object
         * 489: dup
         * 490: iconst_0
         * 491: ldc           NumberPatterns
         * 493: aastore
         * 494: dup
         * 495: iconst_1
         * 496: iconst_3
         * 497: anewarray     java/lang/String
         * 500: dup
         * 501: iconst_0
         * 502: ldc           #,##0.###
         * 504: aastore
         * 505: dup
         * 506: iconst_1
         * 507: ldc           Â¤ #,##0.00
         * 509: aastore
         * 510: dup
         * 511: iconst_2
         * 512: ldc           #,##0%
         * 514: aastore
         * 515: aastore
         * 516: aastore
         * 517: dup
         * 518: bipush        9
         * 520: iconst_2
         * 521: anewarray     java/lang/Object
         * 524: dup
         * 525: iconst_0
         * 526: ldc           NumberElements
         * 528: aastore
         * 529: dup
         * 530: iconst_1
         * 531: bipush        11
         * 533: anewarray     java/lang/String
         * 536: dup
         * 537: iconst_0
         * 538: ldc           .
         * 540: aastore
         * 541: dup
         * 542: iconst_1
         * 543: ldc           ,
         * 545: aastore
         * 546: dup
         * 547: iconst_2
         * 548: ldc           ;
         * 550: aastore
         * 551: dup
         * 552: iconst_3
         * 553: ldc           %
         * 555: aastore
         * 556: dup
         * 557: iconst_4
         * 558: ldc           0
         * 560: aastore
         * 561: dup
         * 562: iconst_5
         * 563: ldc           #
         * 565: aastore
         * 566: dup
         * 567: bipush        6
         * 569: ldc           -
         * 571: aastore
         * 572: dup
         * 573: bipush        7
         * 575: ldc           E
         * 577: aastore
         * 578: dup
         * 579: bipush        8
         * 581: ldc           â€°
         * 583: aastore
         * 584: dup
         * 585: bipush        9
         * 587: ldc           âˆž
         * 589: aastore
         * 590: dup
         * 591: bipush        10
         * 593: ldc           NaN
         * 595: aastore
         * 596: aastore
         * 597: aastore
         * 598: dup
         * 599: bipush        10
         * 601: iconst_2
         * 602: anewarray     java/lang/Object
         * 605: dup
         * 606: iconst_0
         * 607: ldc           TimePatterns
         * 609: aastore
         * 610: dup
         * 611: iconst_1
         * 612: iconst_4
         * 613: anewarray     java/lang/String
         * 616: dup
         * 617: iconst_0
         * 618: ldc           HH:mm:ss z
         * 620: aastore
         * 621: dup
         * 622: iconst_1
         * 623: ldc           HH:mm:ss z
         * 625: aastore
         * 626: dup
         * 627: iconst_2
         * 628: ldc           HH:mm:ss
         * 630: aastore
         * 631: dup
         * 632: iconst_3
         * 633: ldc           HH:mm
         * 635: aastore
         * 636: aastore
         * 637: aastore
         * 638: dup
         * 639: bipush        11
         * 641: iconst_2
         * 642: anewarray     java/lang/Object
         * 645: dup
         * 646: iconst_0
         * 647: ldc           DatePatterns
         * 649: aastore
         * 650: dup
         * 651: iconst_1
         * 652: iconst_4
         * 653: anewarray     java/lang/String
         * 656: dup
         * 657: iconst_0
         * 658: ldc           EEEE, yyyy MMMM dd
         * 660: aastore
         * 661: dup
         * 662: iconst_1
         * 663: ldc           yyyy MMMM d
         * 665: aastore
         * 666: dup
         * 667: iconst_2
         * 668: ldc           yyyy MMM d
         * 670: aastore
         * 671: dup
         * 672: iconst_3
         * 673: ldc           yy/MM/dd
         * 675: aastore
         * 676: aastore
         * 677: aastore
         * 678: dup
         * 679: bipush        12
         * 681: iconst_2
         * 682: anewarray     java/lang/Object
         * 685: dup
         * 686: iconst_0
         * 687: ldc           DateTimePatterns
         * 689: aastore
         * 690: dup
         * 691: iconst_1
         * 692: iconst_1
         * 693: anewarray     java/lang/String
         * 696: dup
         * 697: iconst_0
         * 698: ldc           {1} {0}
         * 700: aastore
         * 701: aastore
         * 702: aastore
         * 703: dup
         * 704: bipush        13
         * 706: iconst_2
         * 707: anewarray     java/lang/Object
         * 710: dup
         * 711: iconst_0
         * 712: ldc           DateTimePatternChars
         * 714: aastore
         * 715: dup
         * 716: iconst_1
         * 717: ldc           RbMLkUnsSElFtTauKcZ
         * 719: aastore
         * 720: aastore
         * 721: areturn
         *  */
        // </editor-fold>
    }
}

}
