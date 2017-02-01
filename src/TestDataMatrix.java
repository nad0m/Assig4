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
      DataMatrix dm = new DataMatrix("CSUMB CSIT online program is top notch.");
      dm.generateImageFromText();
     dm.translateImageToText();
     dm.displayImageToConsole();
      dm.displayTextToConsole();

      
      DataMatrix dm2 = new DataMatrix();
      dm2.readText("CSUMB CSIT online program is top notch.");
      //dm.displayTextToConsole();
       
       dm2.generateImageFromText();
      dm2.translateImageToText();
      dm2.displayImageToConsole();

       dm2.displayTextToConsole();
   }

}

