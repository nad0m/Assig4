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
		scan(image);
		image.displayToConsole();//debug
	}
	DataMatrix(String text)
	{
		
	}
	
	public boolean scan (BarcodeImage barcode)
	{
		try
		{
			image = (BarcodeImage) barcode.clone();
			cleanImage();	
			actualHeight = computeSignalHeight();
			actualWidth = computeSignalWidth();
			
		}catch (Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	private void cleanImage()
	{
		boolean found = false;
		int heightOffset = 0;
		int widthOffset = 0;
		
		for (int i = BarcodeImage.MAX_HEIGHT-1; i >= 0 ; i--)
		{
			for (int j = 0; j < BarcodeImage.MAX_WIDTH; j++)
			{
				if (image.getPixel(i,j) && found == false)
				{
					found = true;					
					heightOffset = BarcodeImage.MAX_HEIGHT - 1 - i;
					widthOffset = j; 
				}
				
				if (image.getPixel(i,j) && found == true)
				{
					// turns current pixel "off"
					image.setPixel(i, j, false);
					
					// move pixel to bottom-left based on offset values
					image.setPixel(i + heightOffset, j - widthOffset, true);
				}				
			}
		}
	
	}
	
	
	
	
	private int computeSignalHeight() 
	{
		int height = 0;
		
		for (int i = BarcodeImage.MAX_HEIGHT-1; i >= 0 ; i--)
		{
			if (image.getPixel(i, 0))
			{
				height++;
			}
		}
		return height;
	}
	
	private int computeSignalWidth() 
	{
		int j = 0;
		
		for (j = 0; j < BarcodeImage.MAX_WIDTH; j++)
		{
			if (image.getPixel(BarcodeImage.MAX_HEIGHT-1, j) == false)
			{
				return j;
			}
		}
		return j+1;
	}
}
