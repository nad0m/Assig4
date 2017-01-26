/**
 * 
 */

/**
 * @author BigMac
 *
 */
class DataMatrix
{
	public static final char BLACK_CHAR = '*';
	public static final char WHITE_CHAR = ' '; 
	
	private BarcodeImage image;
	private String text;
	private int actualWidth;
	private int actualHeight;
	
	DataMatrix()
	{
		
	}
	DataMatrix(BarcodeImage image) 
	{
		cleanImage();
	}
	DataMatrix(String text)
	{
		
	}
	
	private void cleanImage()
	{
		
		for (int i = BarcodeImage.MAX_HEIGHT-1; i >= 0 ; i--)
		{
			for (int j = 0; j < BarcodeImage.MAX_WIDTH; j++)
			{
				if (image.getPixel(i,j))
				{
					image.setPixel(i, j, false);
					image.setPixel(i + (BarcodeImage.MAX_HEIGHT-i-1), j - 5, true);					
				}
			}
		}
	
	}
	
}
