/**
 * 
 */

/**
 * @author BigMac
 *
 */
class BarcodeImage implements Cloneable
{
   public static final int MAX_HEIGHT = 30;
   public static final int MAX_WIDTH = 65;

   private boolean[][] image_data;

   /**
    * Default constructor that generates a blank 2D array based on the constant
    * dimensions MAX_WIDTH x MAX_HEIGHT.
    */
   public BarcodeImage()
   {
      this.image_data = new boolean[MAX_HEIGHT][MAX_WIDTH];

      // Generating blank 2D array
      for (int i = 0; i < MAX_HEIGHT; i++)
      {
         for (int j = 0; j < MAX_WIDTH; j++)
         {
            image_data[i][j] = false;
         }
      }

   }

   /**
    * A constructor that takes a 1D array of Strings and converts it to the
    * internal 2D array of booleans.
    */
   public BarcodeImage(String[] str_data)
   {
      this.image_data = new boolean[MAX_HEIGHT][MAX_WIDTH];

      int lineNumber = str_data.length - 1;

      // begin at bottom left corner
      for (int i = MAX_HEIGHT - 1; i >= 0; i--)
      {
         for (int j = 0; j < MAX_WIDTH; j++)
         {
            if (j < str_data[lineNumber].length() && lineNumber >= 0)
            {
               if (str_data[lineNumber].charAt(j) == ' ')
               {
                  setPixel(i, j, false);
               } else
               {
                  setPixel(i, j, true);
               }
            } else
            {
               setPixel(i, j, false);
            }
         }

         if (lineNumber > 0)
         {
            lineNumber--;
         }
      }

   }

   /**
    * Mutator for a particular pixel.
    * 
    * @param row
    *           , col, value
    */
   public boolean setPixel(int row, int col, boolean value)
   {
      if ((row < 0 || row >= MAX_HEIGHT) || (col < 0 || col >= MAX_WIDTH))
      {
         return false;
      }

      this.image_data[row][col] = value;
      return true;
   }

   /**
    * accesses individual pixel
    * @param row
    * @param col
    * @return
    */
   public boolean getPixel(int row, int col)
   {
      if ((row >= 0 && row < MAX_HEIGHT) && (col >= 0 && col < MAX_WIDTH))
      {
         return this.image_data[row][col];
      } else
      {
         return false;
      }

   }

   /**
    * Overrides Cloneable interface method and returns copy of BarcodeImage
    * 
    */
   public Object clone()
   {
      BarcodeImage duplicate = null;
      try
      {
         duplicate = (BarcodeImage) super.clone();
         duplicate.image_data = (boolean[][]) image_data.clone();
      } catch (CloneNotSupportedException e)
      {
      }
      return duplicate;
   }

   /**
    * Displays the original string in 2D format to console. (For debugging)
    * 
    */
   public void displayToConsole()
   {
      for (int i = 0; i < MAX_HEIGHT; i++)
      {
         for (int j = 0; j < MAX_WIDTH; j++)
         {
            if (image_data[i][j])
            {
               System.out.print('*');
            } else
            {
               System.out.print(' ');
            }
         }

         System.out.print("\n");
      }
   }

}
