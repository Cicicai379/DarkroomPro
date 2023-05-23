import java.awt.*;
import java.net.URL;
import java.lang.Math;
import java.util.ArrayList;
// The secret image:
// CS60 in a heart

/**
 * A class that represents a picture.  This class inherits from SimplePicture
 * 	and allows the student to add functionality and picture effects.  
 * 
 * @author Barb Ericson (ericson@cc.gatech.edu)
 * @author Modified by Colleen Lewis (lewis@cs.hmc.edu),
 * 	Jonathan Kotker (jo_ko_berkeley@berkeley.edu),
 * 	Kaushik Iyer (kiyer@berkeley.edu), George Wang (georgewang@berkeley.edu),
 * 	and David Zeng (davidzeng@berkeley.edu), Edwin Lagos (elagos@cis.edu.hk)
 * 
 * 
 */
public class Picture extends SimplePicture 
{
	/////////////////////////// Static Variables //////////////////////////////

	// Different axes available to flip a picture.
	public static final int HORIZONTAL = 1;
	public static final int VERTICAL = 2;
	public static final int FORWARD_DIAGONAL = 3;
	public static final int BACKWARD_DIAGONAL = 4;


	//////////////////////////// Constructors /////////////////////////////////

	/**
	 * A constructor that takes no arguments.
	 */
	public Picture () {
		super();  
	}

	/**
	 * Creates a Picture from the file name provided.
	 * 
	 * @param fileName The name of the file to create the picture from.
	 */
	public Picture(String fileName) {
		// Let the parent class handle this fileName.
		super(fileName);
	}

	/**
	 * Creates a Picture from the width and height provided.
	 * 
	 * @param width the width of the desired picture.
	 * @param height the height of the desired picture.
	 */
	public Picture(int width, int height) {
		// Let the parent class handle this width and height.
		super(width, height);
	}

	/**
	 * Creates a copy of the Picture provided.
	 * 
	 * @param pictureToCopy Picture to be copied.
	 */
	public Picture(Picture pictureToCopy) {
		// Let the parent class do the copying.
		super(pictureToCopy);
	}

	/**
	 * Creates a copy of the SimplePicture provided.
	 * 
	 * @param pictureToCopy SimplePicture to be copied.
	 */
	public Picture(SimplePicture pictureToCopy) {
		// Let the parent class do the copying.
		super(pictureToCopy);
	}

	/////////////////////////////// Methods ///////////////////////////////////

	//////////////////////////// Provided Methods /////////////////////////////////

	/**
	 * Helper method to determine if a x and y coordinate is valid (within the image) 
	 * 
	 * @param ix is the x value that might be outside of the image
	 * @param iy is the y value that might be outside of the image
	 * @return true if the x and y values are within the image and false otherwise
	 */
	@SuppressWarnings("unused")
	private boolean inImage(int ix, int iy) {
		return ix >= 0 && ix < this.getWidth() && iy >= 0
				&& iy < this.getHeight();
	}
	
	/**
	 * @return A string with information about the picture, such as 
	 * 	filename, height, and width.
	 */
	public String toString() {
		String output = "Picture, filename = " + this.getFileName() + "," + 
		" height = " + this.getHeight() + ", width = " + this.getWidth();
		return output;
	}
	/**
	 * Equals method for two Picture objects. 
	 * 
	 * @param obj is an Object to compare to the current Picture object
	 * @return true if obj is a Picture object with the same size as the
	 *         original and with the same color at each Pixel
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Picture)) {
			return false;
		}

		Picture p = (Picture) obj;
		// Check that the two pictures have the same dimensions.
		if ((p.getWidth() != this.getWidth()) ||
				(p.getHeight() != this.getHeight())) {
			return false;
		}

		// Check each pixel.
		for (int x = 0; x < this.getWidth(); x++) {
			for(int y = 0; y < this.getHeight(); y++) {
				if (!this.getPixel(x, y).equals(p.getPixel(x, y))) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Helper method for loading a picture in the current directory.
	 */
	protected static Picture loadPicture(String pictureName) {
		URL url = Picture.class.getResource(pictureName);
		return new Picture(url.getFile().replaceAll("%20", " "));
	}

	//////////////////////////// Debugging Methods /////////////////////////////////

	/**
	 * Method to print out a table of the intensity for each Pixel in an image
	 */
	public void printLuminosity(){
		int pictureHeight = this.getHeight();
		int pictureWidth = this.getWidth();
		System.out.println("Luminosity:");
		for(int y = 0; y < pictureHeight; y++) {
			System.out.print("[");
			for(int x = 0; x < pictureWidth; x++) {
				System.out.print(this.luminosityOfPixel(x, y) + "\t");
			}
			System.out.println("]");
		}		
	}
	/**
	 * Method to print out a table of the energy for each Pixel in an image
	 */
	public void printEnergy(){
		int pictureHeight = this.getHeight();
		int pictureWidth = this.getWidth();
		System.out.println("Energy:");
		for(int y = 0; y < pictureHeight; y++) {
			System.out.print("[");
			for(int x = 0; x < pictureWidth; x++) {
				System.out.print(this.getEnergy(x, y) + "\t");
			}
			System.out.println("]");
		}		
	}
	
	/**
	 * Prints a two dimensional array of ints
	 * @param array
	 */
	public void printArray(int[][] array) {
		int height = array.length;
		int width = array[0].length;
		for (int r = 0; r < width; ++r) {
			for (int c = 0; c < height; ++c) {
				System.out.print(array[r][c] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * This method can be used like the other Picture methods, to create a
	 * Picture that shows what Pixels are different between two Picture objects.
	 * 
	 * @param picture2 is a Picture to compare the current Picture to
	 * @return returns a new Picture with red pixels indicating differences between 
	 * 			the two Pictures
	 */
	public Picture showDifferences(Picture picture2){
		Picture newPicture = new Picture(this);

		int pictureHeight = this.getHeight();
		int pictureWidth = this.getWidth();
		Color red = new Color(255, 0, 0);
		for(int x = 0; x < pictureWidth; x++) {
			for(int y = 0; y < pictureHeight; y++) {
				if (!this.getPixel(x, y).equals(picture2.getPixel(x, y))) {
					Pixel p = newPicture.getPixel(x, y);
					p.setColor(red);
				}
			}
		}
		return newPicture;
	}


	//////////////////////////// Grayscale Example /////////////////////////////////
	/*
	 * Each of the methods below is constructive: in other words, each of the
	 * methods below generates a new Picture, without permanently modifying the
	 * original Picture.
	 */

	/**
	 * Returns a new Picture, which is the gray version of the current Picture (this)
	 * 
	 * This is an example where all of the pixel-processing occurs within
	 * the nested for loops (over the columns, x, and rows, y).
	 * 
	 * @return A new Picture that is the grayscale version of this Picture.
	 */
	public Picture grayscale2() {
		Picture newPicture = new Picture(this);

		int pictureHeight = this.getHeight();
		int pictureWidth = this.getWidth();

		for (int x = 0; x < pictureWidth; x++) {
			for (int y = 0; y < pictureHeight; y++) {
				
				Pixel currentPixel = newPicture.getPixel(x, y);
				
				Color c = currentPixel.getColor();
				int redComponent = c.getRed();
				int greenComponent = c.getGreen();
				int blueComponent = c.getBlue();

				int average = (redComponent + greenComponent + blueComponent) / 3;

				currentPixel.setRed(average);
				currentPixel.setGreen(average);
				currentPixel.setBlue(average);
			}
		}
		return newPicture;
	}
	
	
	/**
	 * Converts the Picture into grayscale. Since any variation of gray
	 * 	is obtained by setting the red, green, and blue components to the same
	 * 	value, a Picture can be converted into its grayscale component
	 * 	by setting the red, green, and blue components of each pixel in the
	 * 	new picture to the same value: the average of the red, green, and blue
	 * 	components of the same pixel in the original.
	 * 
	 * This example shows a more modular approach: grayscale uses a helper
	 * named setPixelToGray; setPixelToGray, in turn, uses the helper averageOfRGB.
	 *  
	 * @return A new Picture that is the grayscale version of this Picture.
	 */
	public Picture grayscale() {
		Picture newPicture = new Picture(this);

		int pictureHeight = this.getHeight();
		int pictureWidth = this.getWidth();

		for(int x = 0; x < pictureWidth; x++) {
			for(int y = 0; y < pictureHeight; y++) {
				newPicture.setPixelToGray(x, y);
			}
		}
		return newPicture;
	}

	/**
	 * Helper method for grayscale() to set a pixel at (x, y) to be gray.
	 * 
	 * @param x The x-coordinate of the pixel to be set to gray.
	 * @param y The y-coordinate of the pixel to be set to gray.
	 */
	private void setPixelToGray(int x, int y) {
		Pixel currentPixel = this.getPixel(x, y);
		int average = Picture.averageOfRGB(currentPixel.getColor());
		currentPixel.setRed(average);
		currentPixel.setGreen(average);
		currentPixel.setBlue(average);		
	}
	/**
	 * Helper method for grayscale() to calculate the
	 * average value of red, green and blue.
	 *
	 * @param c is the Color to be averaged
	 * @return The average of the red, green and blue values of this Color
	 */
	private static int averageOfRGB(Color c) {
		int redComponent = c.getRed();
		int greenComponent = c.getGreen();
		int blueComponent = c.getBlue();

		// this uses integer division, which is what we want here
		// pixels always need to have integer values from 0 to 255 (inclusive)
		// for their red, green, and blue components:
		int average = (redComponent + greenComponent + blueComponent) / 3;
		return average;
	}
	
	//////////////////////////// Change Colors Menu /////////////////////////////////

	//////////////////////////// Negate /////////////////////////////////
 
	/**
	 * Converts the Picture into its photonegative version. The photonegative
	 * 	version of an image is obtained by setting each of the red, green,
	 * 	and blue components of every pixel to a value that is 255 minus their
	 * 	current values.
	 * 
	 * @return A new Picture that is the photonegative version of this Picture. 
	 */
	public Picture negate() {
		Picture newPicture = new Picture(this);
		int height = this.getHeight();
		int width = this.getWidth();

		//loop through each pixel
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				Pixel pixel = this.getPixel(i, j);//get one pixel object
				int newRed = 255 - pixel.getRed(); //calculate new RGB
				int newGreen = 255 - pixel.getGreen();
				int newBlue = 255 - pixel.getBlue();
				Pixel newPixel = newPicture.getPixel(i, j);
				newPixel.setRed(newRed);//update the RGB of the pixel
				newPixel.setBlue(newBlue);
				newPixel.setGreen(newGreen);
			}
		}
		return newPicture;

	}

	/**
	 lighten and darken helper method
	 */
	public Picture darkenLightHelper(int amount){
		Picture newPicture = new Picture(this);

		int pictureHeight = this.getHeight();
		int pictureWidth = this.getWidth();

		if(amount>225 || amount<0) return this;

		//loop through each pixel
		for(int x = 0; x < pictureWidth; x++) {
			for(int y = 0; y < pictureHeight; y++) {
				Pixel pixel = this.getPixel(x, y);//get one pixel
				int newRed = pixel.getRed() + amount; //add amount to each RGB color
				int newGreen = pixel.getGreen() + amount;
				int newBlue = pixel.getBlue() + amount;
				Pixel newPixel = newPicture.getPixel(x, y);//a pixel object that is from newPicture
				newPixel.setRed(newRed);//update RGB
				newPixel.setGreen(newGreen);
				newPixel.setBlue(newBlue);
			}
		}
		return newPicture;
	}
	//////////////////////////// Lighten /////////////////////////////////
	
	/**
	 * Creates an image that is lighter than the original image. The range of
	 * each color component should be between 0 and 255 in the new image. The
	 * alpha value should not be changed.
	 * 
	 * @return A new Picture that has every color value of the Picture increased
	 *         by the lightenAmount.
	 */
	public Picture lighten(int lightenAmount) {
		return darkenLightHelper(lightenAmount);
	}

	//////////////////////////// Darken /////////////////////////////////

	/**
	 * Creates an image that is darker than the original image.The range of
	 * each color component should be between 0 and 255 in the new image. The
	 * alpha value should not be changed.
	 * 
	 * @return A new Picture that has every color value of the Picture decreased
	 *         by the darkenAmount.
	 */

	public Picture darken(int darkenAmount) {
		//negative of amount because it is darken
		return darkenLightHelper(darkenAmount*-1);
		// NOTE - This is REALLY similar to lighten, could you write a helper
		// method that both call? Don't just copy and paste! :)

	}

	//////////////////////////// Add[Blue,Green,Red] /////////////////////////////////
	/**
	 add colours helper method
	 * red=1;
	 * blue=2;
	 * green=3;
	 */
	public Picture changeColourHelper(int amount, int colour){
		Picture newPicture = new Picture(this);
		int pictureHeight = this.getHeight();
		int pictureWidth = this.getWidth();

		// check the amount is <225
		if(amount>225 || amount<0) return this;

		//loop through each pixel
		for(int x = 0; x < pictureWidth; x++) {
			for(int y = 0; y < pictureHeight; y++) {
				Pixel pixel = this.getPixel(x, y);
				int newColor=0;
				if(colour==1){ //check the color
					 newColor = pixel.getRed() + amount;
				}else if (colour==2){ // if the color is blue
					 newColor = pixel.getBlue() + amount;
				}else{ //green
					 newColor = pixel.getGreen() + amount;
				}
				Pixel newPixel = newPicture.getPixel(x, y); //get the pixel from new Picture
				newPixel.setBlue(newColor); //update color to the pixel
			}
		}
		return newPicture;
	}
	/**
	 * Creates an image where the blue value has been increased by amount.The range of
	 * each color component should be between 0 and 255 in the new image. The
	 * alpha value should not be changed.
	 * 
	 * @return A new Picture that has every blue value of the Picture increased
	 *         by amount.
	 */
	public Picture addBlue(int amount) {
		return changeColourHelper(amount,2);
	}
	
	/**
	 * Creates an image where the red value has been increased by amount. The range of
	 * each color component should be between 0 and 255 in the new image. The
	 * alpha value should not be changed.
	 * 
	 * @return A new Picture that has every red value of the Picture increased
	 *         by amount.
	 */
	public Picture addRed(int amount) {
		return changeColourHelper(amount,1);
	}
	
	/**
	 * Creates an image where the green value has been increased by amount. The range of
	 * each color component should be between 0 and 255 in the new image. The
	 * alpha value should not be changed.
	 * 
	 * @return A new Picture that has every green value of the Picture increased
	 *         by amount.
	 */
	public Picture addGreen(int amount) {
		return changeColourHelper(amount,3);
	}
	
	//////////////////////////// Rotate Right /////////////////////////////////

	/**
	 * Returns a new picture where the Picture is rotated to the right by 90
	 * degrees. If the picture was originally 50 Pixels by 70 Pixels, the new
	 * Picture should be 70 Pixels by 50 Pixels.
	 * 
	 * @return a new Picture rotated right by 90 degrees
	 */
	public Picture rotateRight() {
		int Height = this.getHeight();
		int Width = this.getWidth();
		int newWidth = Height;
		int newHeight = Width;
		Picture newPicture = new Picture(newWidth, newHeight);
		//loop through each pixel
		for(int i = 0; i < Width; i++) {
			for(int j = 0; j < Height; j++) {
				Pixel pixel = this.getPixel(i, j);
				Pixel newPixel = newPicture.getPixel(Height - 1 - j, i); //when rotated, the pixel of the new picture should be (Height - 1 - j, i) pixel of the original picture
				newPixel.setColor(pixel.getColor());//update the pixel
			}

		}
		return newPicture;
	}

	//////////////////////////// Seam Carving Section /////////////////////////////////
	
	//////////////////////////// Luminosity /////////////////////////////////
	/**
	 * Returns a Picture of a version of grayscale using luminosity instead
	 * of a direct average. The Picture should be converted into its luminosity
	 * version by setting the red, green, and blue components of each pixel in
	 * the new picture to the same value: the luminosity of the red, green, and
	 * blue components of the same pixel in the original. Where luminosity =
	 * 0.21 * redness + 0.72 * greenness + 0.07 * blueness
	 * 
	 * @return A new Picture that is the luminosity version of this Picture.
	 */
	public Picture luminosity(){
		Picture newPicture = new Picture(this);
		int height = this.getHeight();
		int width = this.getWidth();

		//loop through each pixel
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++){
				int newLuminosity = luminosityOfPixel(i, j); //calculate luminosity of that pixel
				Pixel newPixel = newPicture.getPixel(i, j);
				newPixel.setBlue(newLuminosity); // update RGB of the pixel
				newPixel.setRed(newLuminosity);
				newPixel.setGreen(newLuminosity);
			}
		}
		return newPicture;

	}
	
	
	/**
	 * Helper method for luminosity() to calculate the
	 * luminosity of a pixel at (x,y).
	 *
	 * @param x  the x-coordinate of the pixel
	 * @param y  the y-coordinate of the pixel
	 * @return The luminosity of that pixel
	 */
	private int luminosityOfPixel(int x, int y) {
		Pixel pixel = this.getPixel(x, y);
		//calculate luminosity using the formula
		int luminosity = (int)(0.21 * pixel.getRed() + 0.72 * pixel.getGreen() + 0.07 * pixel.getBlue());
		return luminosity;
	}

	//////////////////////////// Energy /////////////////////////////////

	/**
	 * Returns a Picture into a version of the energy of the Picture
	 * 
	 * @return A new Picture that is the energy version of this Picture.
	 */
	public Picture energy(){
		Picture newPicture = new Picture(this);
		int height = this.getHeight();
		int width = this.getWidth();
		for(int i = 0; i < width; i++) {//loop through all pixels
			for(int j = 0; j < height; j++){
				int newEnergy = getEnergy(i, j); //calculate energy of that pixel
				Pixel newPixel = newPicture.getPixel(i, j);
				newPixel.setGreen(newEnergy); //update RGB
				newPixel.setBlue(newEnergy);
				newPixel.setRed(newEnergy);
			}
		}
		return newPicture;
	}
	
	/**
	 * Helper method for energy() to calculate the
	 * energy of a Pixel.
	 *
	 * @param x is the x value of the Pixel to be evaluated
	 * @param y is the y value of the Pixel to be evaluated
	 * @return The energy of this Pixel
	 */
	private int getEnergy(int x, int y) {
		int energy = 0;
		int height = this.getHeight();
		int width = this.getWidth();

		if ( x + 1 > width - 1 && y + 1 > height - 1) { //if the pixel is at lower right corner
			energy = Math.abs(luminosityOfPixel(x, y) - luminosityOfPixel(x - 1, y)) + Math.abs(luminosityOfPixel(x, y) - luminosityOfPixel(x, y - 1));
		}
		else if ( x + 1 > width - 1) { //if the pixel is on the right column
			energy = Math.abs(luminosityOfPixel(x, y) - luminosityOfPixel(x - 1, y)) + Math.abs(luminosityOfPixel(x, y + 1) - luminosityOfPixel(x, y));
		}
		else if ( y + 1 > height - 1) { //if the pixel is on the last row
			energy = Math.abs(luminosityOfPixel(x + 1, y) - luminosityOfPixel(x, y)) + Math.abs(luminosityOfPixel(x, y) - luminosityOfPixel(x, y - 1));
		}
		else { //at the centre
			energy = Math.abs(luminosityOfPixel(x + 1, y) - luminosityOfPixel(x, y)) + Math.abs(luminosityOfPixel(x, y + 1) - luminosityOfPixel(x, y));
		}
		return energy;
	}


	//////////////////////////// Compute Seam /////////////////////////////////

	/**
	 * private helper method computeSeam returns an int array with the
	 * x-coordinates (columns) of the lowest-energy seam running from the top
	 * row to the bottom row.
	 * 
	 * See the course assignment for additional details.
	 */
	@SuppressWarnings("unused")
	public int[] computeSeam() {

		// Initialize variables
		int height = this.getHeight();
		int width = this.getWidth();
		int[][] energyTable = new int[height][width];
		int[][] costTable = new int[height][width];
		int[][] parent = new int[height][width];

		// Fill energy table
		for(int i = 0; i < width; i++)
			for(int j = 0; j < height; j++)
				energyTable[j][i] = getEnergy(i, j);

		// Fill cost table and parent table
		for(int i = 0; i < width; i++) costTable[0][i] = energyTable[0][i];
		for(int i = 0; i < width; i++) parent[0][i] = 1;
		int parentNum = 0;
		for (int y = 1; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (x - 1 < 0) {
					costTable[y][x] = energyTable[y][x] + Math.min(costTable[y-1][x], costTable[y-1][x+1]);
					if (costTable[y-1][x] == costTable[y-1][x+1] || costTable[y-1][x] < costTable[y-1][x+1]) {
						parentNum = x;
					} else {
						parentNum = x + 1;
					}
					parent[y][x] = parentNum;
				} else if (x + 1 > width - 1) {
					costTable[y][x] = energyTable[y][x] + Math.min(costTable[y-1][x-1], costTable[y-1][x]);
					if (costTable[y-1][x-1] == costTable[y-1][x] || costTable[y-1][x] < costTable[y-1][x-1]) {
						parentNum = x;
					} else {
						parentNum = x - 1;
					}
					parent[y][x] = parentNum;
				} else {
					// Compute minimum and update cost and parent tables
					int minimum = Math.min(Math.min(costTable[y-1][x-1], costTable[y-1][x]), costTable[y-1][x+1]);
					costTable[y][x] = energyTable[y][x] + minimum;
					if (costTable[y-1][x] == minimum) {
						parentNum = x;
					} else if (costTable[y-1][x-1] == minimum) {
						parentNum = x - 1;
					} else {
						parentNum = x + 1;
					}
					parent[y][x] = parentNum;
				}
			}
		}

		// Find the minimum cost seam
		int currMin = costTable[height-1][0];
		int currX = 0;
		for (int x = 1; x < width; x++) {
			if (currMin > costTable[height-1][x]) {
				currMin = costTable[height-1][x];
				currX = x;
			}
		}

		// Backtrack to find the seam
		int[] seam = new int[height];
		seam[height-1] = currX;
		seam[height-2] = parent[height-1][currX];
		for (int i = height-3; i >= 0; i--) {
			seam[i] = parent[i+1][seam[i+1]];
		}

		return seam;
	}

	//////////////////////////// Show Seam /////////////////////////////////

	/**
	 * Returns a new image, with the lowest cost seam shown in red. The lowest
	 * cost seam is calculated by calling computeSeam()
	 * 
	 * @return a new Picture
	 */
	public Picture showSeam(){

		Picture newPicture = new Picture(this);
		Color red = new Color(255, 0, 0);
		int height = this.getHeight();
		int width = this.getWidth();
		int[] seam = this.computeSeam();

		//loop through each pixel
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if ( seam[i]==j) { //if the pixel is in the seam
					Pixel pixel = this.getPixel(j, i);
					Pixel newPixel = newPicture.getPixel(j, i);
					newPixel.setColor(red); // update to red
				}
			}
		}
		return newPicture;
	}
	
	//////////////////////////// Carving (2 methods) /////////////////////////////////

	/**
	 * Returns a new picture, where the seam identified by calling computeSeam() is
	 * removed. The resulting image should be the same height as the original
	 * but have a width that is one smaller than the original.
	 */
	public Picture carve(){


		// Initialize variables and create new picture object
		int width = this.getWidth();
		int height = this.getHeight();
		int newWidth = width - 1;
		int newHeight = height;
		Picture newPicture = new Picture(newWidth, newHeight);

		// Compute seam and initialize seamFound flag
		int[] seam = this.computeSeam();
		boolean seamFound=false;

		// Loop through each column in the image
		for (int i = 0; i < newWidth; i++) {
			seamFound = false;
			// Loop through each row in the image
			for (int j = 0; j < newHeight - 1; j++) {
				// If we have found the seam, skip this pixel and shift the index by 1
				if (j == seam[i]) {
					Pixel pixel = this.getPixel(j + 1, i);
					Pixel newPixel = newPicture.getPixel(j, i);
					newPixel.setColor(pixel.getColor());
					j += 1;
					seamFound = true;
				}
				// If we have already the seam, shift the pixel to the left by one
				else if (seamFound == true) {
					Pixel pixel = this.getPixel(j, i);
					Pixel newPixel = newPicture.getPixel(j-1, i);
					newPixel.setColor(pixel.getColor());
				}
				// Otherwise, copy the pixel to the new picture
				else {
					Pixel pixel = this.getPixel(j, i);
					Pixel newPixel = newPicture.getPixel(j, i);
					newPixel.setColor(pixel.getColor());
				}
			}
		}

		// Copy the last column of pixels to the new picture
		for (int y = 0; y < height; y++) {
			if (width - 1 == seam[y]) {
				Pixel pixel = this.getPixel(width-2, y);
				Pixel newPixel = newPicture.getPixel(newWidth-1, y);
				newPixel.setColor(pixel.getColor());
			} else {
				Pixel pixel = this.getPixel(width-1, y);
				Pixel newPixel  = newPicture.getPixel(newWidth-1, y);
				newPixel.setColor(pixel.getColor());
			}
		}

		// Return the new picture
		return newPicture;
	}

	/**
	 * This returns a new Picture that has a number of seams removed.
	 *
	 * If the input is greater than the width of the Picture, first print an error using
	 * System.err instead of System.out, then return original image. Here is the error message:
	 *
	 * System.err.println("Cannot call carveMany with argument " + numSeams + " on image of width " + this.getWidth());
	 *
	 * @param numSeams is the number of times that carve should be called
	 * @return a new picture with numSeams removed
	 */
	public Picture carveMany(int numSeams){
		int pictureWidth = this.getWidth();
		Picture newPicture = this;

		//check if numSeams is valid
		if (numSeams > pictureWidth - 1) {
			System.err.println("Cannot call carveMany with argument " + numSeams + " on image of width " + this.getWidth());
			return this;
		}

		//carve() numSeams times
		for (int i = 0; i < numSeams; i++) {
			newPicture = newPicture.carve();
		}
		return newPicture;

	}

	
	//////////////////////////// Extension /////////////////////////////////

	/** 
	 * @param  x-coordinate of the pixel currently selected.
	 * @param  y-coordinate of the pixel currently selected.
	 * @param background Picture to use as the background.
	 * @param threshold Threshold within which to replace pixels.
	 * 
	 * @return A new Picture where all the pixels in the original Picture,
	 * 	which differ from the currently selected pixel within the provided
	 * 	threshold (in terms of color distance), are replaced with the
	 * 	corresponding pixels in the background picture provided.
	 * 
	 * 	If the two Pictures are of different dimensions, the new Picture will
	 * 	have length equal to the smallest of the two Pictures being combined,
	 * 	and height equal to the smallest of the two Pictures being combined.
	 * 	In this case, the Pictures are combined as if they were aligned at
	 * 	the top left corner (0, 0).
	 */
	public Picture chromaKey(int x, int y, Picture background, int threshold) {
		//initialize the size of the new picture
		int newHeight = Math.min(this.getHeight(), background.getHeight());
		int newWidth = Math.min(this.getWidth(), background.getWidth());
		Picture newPicture = new Picture(newWidth, newHeight);
		//get color of the selected pixel
		Pixel pixel = this.getPixel(x, y);
		Color color = pixel.getColor();

		//update all pixels
		for (int i = 0; i < newWidth; i++) {
			for (int j = 0; j < newHeight; j++) {
				Pixel curPixel = this.getPixel(i, j);
				Color curColor = curPixel.getColor();
				Pixel backPixel = background.getPixel(i, j);
				Color backColor = backPixel.getColor();
				newPicture.setPixelToChromaKey(i, j, threshold, color, curColor, backColor);
			}
		}
		return newPicture;
	}

	/**
	 * Helper method for chromaKey(). Update the pixel to either original color
	 * or background color according to the threshold value
	 */
	private void setPixelToChromaKey(int x, int y, int threshold, Color color, Color originalColor, Color backColor) {
		Pixel currentPixel = this.getPixel(x, y);
		double distance = currentPixel.colorDistance(color, originalColor);
		//set the pixel same as backgroun color if the color distance is smaller than threshold balue
		if ((int) distance <= threshold) {
			currentPixel.setColor(backColor);
		} else {
			currentPixel.setColor(originalColor);
		}
	}


	//////////////////////////// Flip /////////////////////////////////
	/**
	 helper methods for flip:
	 * 1)rotate by rotations number of times;
	 * 2)filp this picture vertically.
	 */
	private Picture rotate(int rotations) {
		Picture newPicture = new Picture(this);

		//rotate the picture by rotations times.
		while (rotations > 0) {
			newPicture = newPicture.rotateRight();
			rotations --;
		}
		return newPicture;
	}
	private Picture flipVertical() {
		Picture newPicture = new Picture(this);
		int height = this.getHeight();
		int width = this.getWidth();

		//update each pixel
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Pixel pixel = this.getPixel(x, y);
				Pixel newPixel = newPicture.getPixel(x,  height - 1 - y);
				newPixel.setColor(pixel.getColor());
			}
		}
		return newPicture;
	}

	/**
	 * Flips this Picture about the given axis. The axis can be one of
	 * 	four static integer constants:
	 * 
	 * 	(a) Picture.HORIZONTAL: The picture should be flipped about
	 * 		a horizontal axis passing through the center of the picture.
	 * 	(b) Picture.VERTICAL: The picture should be flipped about
	 * 		a vertical axis passing through the center of the picture.
	 * 	(c) Picture.FORWARD_DIAGONAL: The picture should be flipped about
	 * 		the line that passes through the southwest corner of the 
	 * 		picture and that extends at 45deg. to the northeast
	 * 	(d) Picture.BACKWARD_DIAGONAL: The picture should be flipped about
	 * 		an axis that passes through the north-west corner and extends
	 * 		at a 45deg angle to the southeast
	 * 
	 * If the input is not one of these static variables, print an error using
	 * System.err (instead of System.out):
	 * 				System.err.println("Invalid flip request");
	 *   ... and then return null.
	 * 
	 * 
	 * @param axis Axis about which to flip the Picture provided.
	 * 
	 * @return A new Picture flipped about the axis provided.
	 */
	public Picture flip(int axis) {

		// Get the dimensions of the picture
		int width = this.getWidth();
		int height = this.getHeight();

		// Check the value of the axis parameter and flip the picture accordingly
		if(axis==Picture.HORIZONTAL) {
			return this.rotate(1).flipVertical().rotate(3);
		}else if(axis==Picture.VERTICAL){
			return this.flipVertical();
		}else if(axis==Picture.FORWARD_DIAGONAL) {
			return this.rotate(1).rotate(1).flipVertical().rotate(3);
		}else if(axis==Picture.BACKWARD_DIAGONAL)  {
			return this.rotate(3).rotate(1).flipVertical().rotate(3);
		}else {
			System.err.println("Invalid flip request");
			return this;
		}

	}

	//////////////////////////// Show Edges /////////////////////////////////
	/** helper methods for show edges: set pixels to white or black
	 * given the x and y coordinates of a pixel
	 */
	private void setPixelToWhite(int x, int y) {
		Pixel pixel = this.getPixel(x, y);
		pixel.setRed(255);
		pixel.setGreen(255);
		pixel.setBlue(255);
	}
	//adjusts a pixel to 255 alpha, all black
	private void setPixelToBlack (int x, int y) {
		Pixel pixel = this.getPixel(x,y);
		pixel.setRed(0);
		pixel.setGreen(0);
		pixel.setBlue(0);

	}
	/**
	 * @param threshold
	 *            Threshold to use to determine the presence of edges.
	 * 
	 * @return A new Picture that contains only the edges of this Picture. For
	 *         each pixel, we separately consider the color distance between
	 *         that pixel and the one pixel to its left, and also the color
	 *         distance between that pixel and the one pixel to the north, where
	 *         applicable. As an example, we would compare the pixel at (3, 4)
	 *         with the pixels at (3, 3) and the pixels at (2, 4). Also, since
	 *         the pixel at (0, 4) only has a pixel to its north, we would only
	 *         compare it to that pixel. If either of the color distances is
	 *         larger than the provided color threshold, it is set to black
	 *         (with an alpha of 255); otherwise, the pixel is set to white
	 *         (with an alpha of 255). The pixel at (0, 0) will always be set to
	 *         white.
	 */
	public Picture showEdges(int threshold) {

		//initialize all variables
		int width = this.getWidth();
		int height = this.getHeight();
		Picture newPicture = new Picture(width, height);

		//check all pixels
		for (int x = 0; x <width; x++) {
			for (int y = 0; y <height; y++) {
				Pixel curPixel = this.getPixel(x,y);
				if(x > 0 && y > 0){ // if it has both up and right pixels
					Pixel up = this.getPixel(x-1,y);
					Pixel left = this.getPixel(x,y-1);
					if(up.colorDistance(curPixel.getColor())<=threshold && left.colorDistance(curPixel.getColor())<=threshold){
						newPicture.setPixelToWhite(x,y);
					}else{
						newPicture.setPixelToBlack(x,y);
					}
				}else if (x>0){ // only up pixels
					Pixel up = this.getPixel(x-1,y);
					if(up.colorDistance(curPixel.getColor())<=threshold){
						newPicture.setPixelToWhite(x,y);
					}else{
						newPicture.setPixelToBlack(x,y);
					}
				}else if (y>0) { // only left pixels
					Pixel up = this.getPixel(x, y - 1);
					if (up.colorDistance(curPixel.getColor()) <= threshold) {
						newPicture.setPixelToWhite(x, y);
					} else {
						setPixelToBlack(x, y);
					}
				}else{ // no reference pixels
					newPicture.setPixelToWhite(x, y);
				}
			}
		}

		return newPicture;
	}

	//////////////////////////////// Blur //////////////////////////////////
	public Color getBlurColor(Picture originalPicture, int x, int y, int blurThreshold){
		//size of the surrounding pixels
		int width = originalPicture.getWidth();
		int height = originalPicture.getHeight();
		int cnt = (2*blurThreshold+1)*(2*blurThreshold+1);
		ArrayList<Pixel> myArrayListOfPixels = new ArrayList<Pixel>(cnt);

		//store all involved pixels
		if (x<=blurThreshold || y<=blurThreshold || x>=originalPicture.getWidth()-blurThreshold || y>=originalPicture.getHeight()-blurThreshold) {
			for (int x1 = x-blurThreshold; x1<=x+blurThreshold; x1++) {
				for (int y1 = y-blurThreshold; y1<=y+blurThreshold; y1++) {
					if (x1<0 || y1 < 0 || x1>=originalPicture.getWidth() || y1 >=originalPicture.getHeight()) {
						cnt--;
					} else {
						Pixel newPixel = new Pixel(originalPicture, x1,y1);
						myArrayListOfPixels.add(newPixel);
					}
				}
			}
			myArrayListOfPixels.trimToSize();
		} else {
			for (int x1 = x-blurThreshold; x1<=x+blurThreshold; x1++) {
				for (int y1 = y-blurThreshold; y1<=y+blurThreshold; y1++) {
					Pixel newPixel = new Pixel(originalPicture, x1,y1);
					myArrayListOfPixels.add(newPixel);
				}
			}
		}

		int sumRed = 0, sumGreen = 0, sumBlue = 0, sumAlpha = 0;

		for (int i = 0; i<myArrayListOfPixels.size(); i++) {
			sumRed = sumRed + myArrayListOfPixels.get(i).getRed();
			sumBlue = sumBlue + myArrayListOfPixels.get(i).getBlue();
			sumGreen = sumGreen + myArrayListOfPixels.get(i).getGreen();
		}

		int aveRed = sumRed/cnt;
		int aveGreen = sumGreen/cnt;
		int aveBlue = sumBlue/cnt;

		Color lemonColor = new Color(aveRed, aveGreen, aveBlue);

		return lemonColor;

	}



	/**
	 * Blurs this Picture. To achieve this, the algorithm takes a pixel, and
	 * sets it to the average value of all the pixels in a square of side (2 *
	 * blurThreshold) + 1, centered at that pixel. For example, if blurThreshold
	 * is 2, and the current pixel is at location (8, 10), then we will consider
	 * the pixels in a 5 by 5 square that has corners at pixels (6, 8), (10, 8),
	 * (6, 12), and (10, 12). If there are not enough pixels available -- if the
	 * pixel is at the edge, for example, or if the threshold is larger than the
	 * image -- then the missing pixels are ignored, and the average is taken
	 * only of the pixels available.
	 * 
	 * The red, blue, green and alpha values should each be averaged separately.
	 * 
	 * @param blurThreshold
	 *            Size of the blurring square around the pixel.
	 * 
	 * @return A new Picture that is the blurred version of this Picture, using
	 *         a blurring square of size (2 * threshold) + 1.
	 */
	public Picture blur(int blurThreshold) {
		int width = this.getWidth();
		int height = this.getHeight();
		Picture newPicture = new Picture(width, height);

		//update each pixels
		for(int x=0; x<this.getWidth(); x++){
			for(int y=0; y<this.getHeight(); y++) {
				Pixel pixel = newPicture.getPixel(x,y);
				pixel.setColor(getBlurColor(this, x, y, blurThreshold));
			}
		}
		return newPicture;
	}

	//////////////////////////////// Paint Bucket //////////////////////////////////

	/**
	 * @param x x-coordinate of the pixel currently selected.
	 * @param y y-coordinate of the pixel currently selected.
	 * @param threshold Threshold within which to delete pixels.
	 * @param newColor New color to color pixels.
	 * 
	 * @return A new Picture where all the pixels connected to the currently
	 * 	selected pixel, and which differ from the selected pixel within the
	 * 	provided threshold (in terms of color distance), are colored with
	 * 	the new color provided. 
	 */
	public Picture paintBucket(int x, int y, int threshold, Color newColor) {
		Picture paintedPicture = new Picture(this);
		Pixel Pixel = paintedPicture.getPixel(x, y);
		Color Color = Pixel.getColor();
		Pixel.setColor(newColor);

		//paint connected pixels (up,down,left,right,four corners)
		paintedPicture.paintPixels(x + 1, y, threshold, Color, newColor);
		paintedPicture.paintPixels(x - 1, y, threshold, Color, newColor);
		paintedPicture.paintPixels(x, y + 1, threshold, Color, newColor);
		paintedPicture.paintPixels(x, y - 1, threshold, Color, newColor);
		paintedPicture.paintPixels(x + 1, y + 1, threshold, Color, newColor);
		paintedPicture.paintPixels(x + 1, y - 1, threshold, Color, newColor);
		paintedPicture.paintPixels(x - 1, y + 1, threshold, Color, newColor);
		paintedPicture.paintPixels(x - 1, y - 1, threshold, Color, newColor);

		return paintedPicture;
	}

	public void paintPixels(int x, int y, int threshold, Color Color, Color newColor){
		if(x < 0 || y < 0 || x >= this.getWidth() || y >= this.getHeight()) return;
		Pixel currentPixel = this.getPixel(x, y);

		//recursively paint the neighbourhood pixels
		if(currentPixel.colorDistance(Color) > 0 && currentPixel.colorDistance(Color) <= threshold){
			currentPixel.setColor(newColor);
			this.paintPixels(x + 1, y, threshold, Color, newColor);
			this.paintPixels(x - 1, y, threshold, Color, newColor);
			this.paintPixels(x, y + 1, threshold, Color, newColor);
			this.paintPixels(x, y - 1, threshold, Color, newColor);
			this.paintPixels(x + 1, y + 1, threshold, Color, newColor);
			this.paintPixels(x + 1, y - 1, threshold, Color, newColor);
			this.paintPixels(x - 1, y + 1, threshold, Color, newColor);
			this.paintPixels(x - 1, y - 1, threshold, Color, newColor);
		}
	}

	//////////////////////////////// Main Method //////////////////////////////////

	public static void main(String[] args) {
		// Try this code as you start debugging... 
		//		Picture tiny 		= Picture.loadPicture("Tiny.bmp");
		//		Picture tinyGray    = tiny.grayscale();
		//		tiny.explore(); // opens in the regular, zoomable window
		//		tinyGray.show(); // opens in a simpler window without the controls

		// This example asks you to pick a file and then launches the PictureExplorer
		//		Picture initialPicture = new Picture(
		//		FileChooser.pickAFile(FileChooser.OPEN));
		//		initialPicture.explore();
		/*Picture pic = Picture.loadPicture("Maria1.bmp");
		Picture pic2 = Picture.loadPicture("SecretMessage.bmp");
		Picture newPic = pic.showDifferences(pic2);*/
		Picture pic = Picture.loadPicture("Okinawa.bmp");

		pic.explore();
	}
	
} // End of Picture class
