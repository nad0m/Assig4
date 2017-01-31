/**
 * 
 */

/**
 * @author BigMac
 *
 */
class DataMatrix implements BarcodeIO {
	public static final char BLACK_CHAR = '*';
	public static final char WHITE_CHAR = ' ';

	private BarcodeImage image;
	private String text;
	private int actualHeight;
	private int actualWidth;

	/**
	 * Default constructor that initializes all variables and creates an empty
	 * image.
	 * 
	 */
	DataMatrix() {
		this.text = "";
		this.actualWidth = 0;
		this.actualHeight = 0;
		this.image = new BarcodeImage();
	}

	/**
	 * A constructor that scans an image.
	 * 
	 */
	DataMatrix(BarcodeImage image) {
		scan(image);
	}

	/**
	 * A constructor that reads given text input.
	 * 
	 */
	DataMatrix(String text) {
		this();
		readText(text);
		
	    //this is for testing.
		generateImageFromText();
		scan(image);
		
	}

	/**
	 * Public method that creates a clone of the image and then "cleans" it.
	 * Actual height and width of the barcode are also initialized.
	 * 
	 */
	public boolean scan(BarcodeImage barcode) {
		try {
			image = (BarcodeImage) barcode.clone();
			cleanImage();
			actualHeight = computeSignalHeight();
			actualWidth = computeSignalWidth();

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * Private method that guarantees any input image to be packed into the
	 * bottom-left corner.
	 * 
	 */
	private void cleanImage() {
		boolean found = false;
		int heightOffset = 0;
		int widthOffset = 0;

		for (int i = BarcodeImage.MAX_HEIGHT - 1; i >= 0; i--) {
			for (int j = 0; j < BarcodeImage.MAX_WIDTH; j++) {
				if (image.getPixel(i, j) && found == false) {
					found = true;
					heightOffset = BarcodeImage.MAX_HEIGHT - 1 - i;
					widthOffset = j;
				}

				if (image.getPixel(i, j) && found) {
					movePixelToLowerLeft(i, j, heightOffset, widthOffset);
				}
			}
		}

	}

	private void movePixelToLowerLeft(int row, int col, int heightOffset,
			int widthOffset) {
		// turns current pixel "off"
		image.setPixel(row, col, false);

		// move pixel to bottom-left based on offset values
		image.setPixel(row + heightOffset, col - widthOffset, true);
	}

	private int computeSignalHeight() {
		int height = 0;

		for (int i = BarcodeImage.MAX_HEIGHT - 1; i >= 0; i--) {
			if (image.getPixel(i, 0)) {
				height++;
			}
		}
		return height;
	}

	private int computeSignalWidth() {
		int j = 0;

		for (j = 0; j < BarcodeImage.MAX_WIDTH; j++) {
			if (image.getPixel(BarcodeImage.MAX_HEIGHT - 1, j) == false) {
				return j;
			}
		}
		return j;
	}

	public int getActualHeight() {
		return actualHeight;
	}

	public int getActualWidth() {
		return actualWidth;
	}

	public void displayImageToConsole() {
		horizontalLines();

		for (int i = BarcodeImage.MAX_HEIGHT - actualHeight; i < BarcodeImage.MAX_HEIGHT; i++) {
			printValues(i);

			System.out.print("\n");
		}

	}

	private void printValues(int row) {
		for (int j = 0; j <= actualWidth; j++) {
			if (j == 0) {
				System.out.print("|");
			} else if (j == actualWidth) {
				System.out.print("|");
			}

			if (image.getPixel(row, j)) {
				System.out.print(BLACK_CHAR);
			} else {
				System.out.print(WHITE_CHAR);
			}
		}
	}

	/**
	 * Public method that computes the barcode and save it into text string.
	 * 
	 */
	public boolean translateImageToText() {
		text = "";

		if (image == null) {
			return false;
		}

		for (int i = 1; i < actualWidth - 1; i++) {
			text += (char) getASCII(i);
		}

		return true;
	}

	private int getASCII(int col) {
		int sum = 0;
		int exponent = 0;

		for (int j = BarcodeImage.MAX_HEIGHT - 2; j > BarcodeImage.MAX_HEIGHT
				- actualHeight; j--, exponent++) {
			if (image.getPixel(j, col)) {
				sum += (int) Math.pow(2, exponent);
			}
		}
		return sum;
	}

	public void displayTextToConsole() {
		System.out.println(text);
	}

	private void horizontalLines() {
		for (int i = 0; i < actualWidth + 2; i++) {
			System.out.print("-");
		}
		System.out.print("\n");
	}

	/**
	 * sets the text to be translated.
	 */
	public boolean readText(String text) {
		actualWidth =text.length();
		actualHeight = 10;
		this.text = text;
		return this.text == text;
	}
	
	public boolean generateImageFromText() {
		char [] textChars = text.toCharArray();
		int col = 1;
		creatClosedLimitationLine();
		for(char c : textChars){
			int charToConvert = (int)c;
		for(int row = 9; row >= 0; row--){
			if(row == 9 || row == 0){
				image.setPixel(row, col, true);
			}
			else if((charToConvert & 1) ==	1){
				image.setPixel(row, col, true);
				charToConvert >>=1;
			}
			else{
				image.setPixel(row, col, false);
				charToConvert >>=1;
			}
		}
		col++;
		}
		computeSignalWidth();
		computeSignalHeight();
		return true;
	}

	private void creatClosedLimitationLine() {
		for (int i = 0; i < 10; i++) {
			image.setPixel(i, 0 , true);
		}
		
	}
}
