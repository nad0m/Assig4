/**
 * 
 */

/**
 * @author BigMac
 *
 */
class DataMatrix implements BarcodeIO
{
	public static final char BLACK_CHAR = '*';
	public static final char WHITE_CHAR = ' '; 
	
	private BarcodeImage image;
	private String text;
	private int actualHeight;
	private int actualWidth;
	
	
	DataMatrix()
	{
		this.text = "";
	    this.actualWidth = 0;
	    this.actualHeight = 0;
	    this.image = new BarcodeImage();
	}
	DataMatrix(BarcodeImage image) 
	{
		scan(image);
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
				
				if (image.getPixel(i, j) && found)
				{
					movePixelToLowerLeft(i, j, heightOffset, widthOffset);
				}				
			}
		}
	
	}
	
	
	private void movePixelToLowerLeft(int row, int col, int heightOffset, int widthOffset)
	{
		// turns current pixel "off"
		image.setPixel(row, col, false);
		
		// move pixel to bottom-left based on offset values
		image.setPixel(row + heightOffset, col - widthOffset, true);
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
		return j;
	}
	

	public int getActualHeight()
	{
		return actualHeight;
	}
	   
	public int getActualWidth()
	{
		return actualWidth;
	}
	
	public void displayImageToConsole()
	{
		horizontalLines();

		for (int i = BarcodeImage.MAX_HEIGHT - actualHeight; i < BarcodeImage.MAX_HEIGHT; i++)
		{
			printValues(i);
				
			System.out.print("\n");
		}
		
	}
	
	private void printValues(int i)
	{
		for (int j = 0; j <= actualWidth; j++)
		{
			if (j == 0)
			{
	               System.out.print("|");
			}
	        else if (j == actualWidth)
	        {
	               System.out.print("|");
	        }
			
			
	        if(image.getPixel(i, j))
	        {
	               System.out.print(BLACK_CHAR);
	        }else{
	        	System.out.print(WHITE_CHAR);
	        }
		}
	}
	

	public boolean translateImageToText()
	{
		text = "";
		
		if (image == null)
		{
			return false;
		}

		
		for (int i = 1; i < actualWidth-1; i++)
		{			
			text += (char) getASCII(i);		
		}
		
		return true;
	}
	
	

	
	private int getASCII(int col)
	{
		int sum = 0;
		int exponent = 0;
		
		for (int j = BarcodeImage.MAX_HEIGHT-2; j > BarcodeImage.MAX_HEIGHT-actualHeight; j--, exponent++)
		{
			if (image.getPixel(j, col))
			{
				sum += (int) Math.pow(2, exponent);					
			}				
		}
		return sum;
	}	

	public void displayTextToConsole()
	{
		System.out.println(text);
	}
	
	private void horizontalLines()
	{
		for (int i = 0; i < actualWidth+2; i++)
		{
			System.out.print("-");
		}
		System.out.print("\n");
	}
}
