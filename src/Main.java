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
		//DataMatrix newImage = new DataMatrix(image);

		image.displayToConsole();
		
		System.out.println(image.getPixel(26, 4));
		
		
	}
}
