import static org.junit.Assert.*;

import org.junit.Test;

public class TestDataMatrix
{

   static String[] sImageIn_2 =
   { "                                          ",
      "                                          ",
      "* * * * * * * * * * * * * * * * * * *     ",
      "*                                    *    ",
      "**** *** **   ***** ****   *********      ",
      "* ************ ************ **********    ",
      "** *      *    *  * * *         * *       ",
      "***   *  *           * **    *      **    ",
      "* ** * *  *   * * * **  *   ***   ***     ",
      "* *           **    *****  *   **   **    ",
      "****  *  * *  * **  ** *   ** *  * *      ",
      "**************************************    ",
      "                                          ",
      "                                          ",
      "                                          ",
      "                                          "

   };

   @Test
   public void testGernerateImageFromText()
   {
      DataMatrix dm = new DataMatrix("What a great resume builder this is!");
      dm.displayTextToConsole();
      dm.generateImageFromText();
      dm.translateImageToText();
      dm.displayImageToConsole();

      dm.translateImageToText();
      dm.displayTextToConsole();
      // assertEquals("You did it! Great work. Celebrate.",
      // dm.displayTextToConsole());
   }

}
