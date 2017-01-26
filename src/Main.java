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
		
		BarcodeImage image = new BarcodeImage(sImageIn);
		image.displayToConsole();
		DataMatrix newImage = new DataMatrix(image);

		
		

		
		
	}
}
