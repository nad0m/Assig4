// Assignment 4: Barcode
// Name: Huy Nguyen, Wissawakon Sriwarom, Keith Groves

public class Main 
{

	public static void main(String[] args) 
	{		
	      String[] sImageIn =
	          {
	             "                                               ",
	             "                                               ",
	             "                                               ",
	             "     * * * * * * * * * * * * * * * * * * * * * ",
	             "     *                                       * ",
	             "     ****** **** ****** ******* ** *** *****   ",
	             "     *     *    ****************************** ",
	             "     * **    * *        **  *    * * *   *     ",
	             "     *   *    *  *****    *   * *   *  **  *** ",
	             "     *  **     * *** **   **  *    **  ***  *  ",
	             "     ***  * **   **  *   ****    *  *  ** * ** ",
	             "     *****  ***  *  * *   ** ** **  *   * *    ",
	             "     ***************************************** ",  
	             "                                               ",
	             "                                               ",
	             "                                               "

	          };      
	                
	             	          
	          String[] sImageIn_2 =
	          {
	                "                                          ",
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
		
		BarcodeImage image = new BarcodeImage(sImageIn);
		image.displayToConsole();
		DataMatrix newImage = new DataMatrix(image);

		BarcodeImage image_2 = new BarcodeImage(sImageIn_2);
		image_2.displayToConsole();
		DataMatrix newImage_2 = new DataMatrix(image_2);


		
	}
}
