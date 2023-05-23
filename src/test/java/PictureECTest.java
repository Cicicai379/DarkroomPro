import java.awt.Color;

import junit.framework.TestCase;

/*
 * This testing framework provides basic level tests for 
 * each of the methods, however additional testing will be 
 * required, along with extensive testing of ALL helper methods
 * that you write.
 */
public class PictureECTest extends TestCase {

	/*
	 * Validate that flip(Picture.HORIZONTAL) works and does not modify the 
	 * original Picture object.
	 */
	public void testFlipHorixontal_Logos()
	{
		Picture pic 		= Picture.loadPicture("Logos.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Logos_flipHorizontally.bmp");
		Picture picTest		= pic.flip(Picture.HORIZONTAL);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that flip(Picture.HORIZONTAL) works and does not modify the 
	 * original Picture object.
	 */
	public void testFlipHorixontal_Maria()
	{
		Picture pic 		= Picture.loadPicture("Maria1.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Maria1_flipHorizontally.bmp");
		Picture picTest		= pic.flip(Picture.HORIZONTAL);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	
	/*
	 * Validate that flip(Picture.VERTICAL) works and does not modify the 
	 * original Picture object.
	 */
	public void testFlipVertical_Logos()
	{
		Picture pic 		= Picture.loadPicture("Logos.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Logos_flipVertically.bmp");
		Picture picTest		= pic.flip(Picture.VERTICAL);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that flip(Picture.VERTICAL) works and does not modify the 
	 * original Picture object.
	 */
	public void testFlipVertical_Maria()
	{
		Picture pic 		= Picture.loadPicture("Maria1.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Maria1_flipVertically.bmp");
		Picture picTest		= pic.flip(Picture.VERTICAL);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that flip(Picture.FORWARD_DIAGONAL) works and 
	 * does not modify the original Picture object.
	 */
	public void testFlipForwardDiagonal_Logos()
	{
		Picture pic 		= Picture.loadPicture("Logos.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Logos_flipForwardSlash.bmp");
		Picture picTest		= pic.flip(Picture.FORWARD_DIAGONAL);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that flip(Picture.FORWARD_DIAGONAL) works and 
	 * does not modify the original Picture object.
	 */
	public void testFlipForwardDiagonal_Maria()
	{
		Picture pic 		= Picture.loadPicture("Maria1.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Maria1_flipForwardSlash.bmp");
		Picture picTest		= pic.flip(Picture.FORWARD_DIAGONAL);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that flip(Picture.BACKWARD_DIAGONAL) works and 
	 * does not modify the original Picture object.
	 */
	public void testFlipBackwardDiagonal_Logos()
	{
		Picture pic 		= Picture.loadPicture("Logos.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Logos_flipBackwardSlash.bmp");
		Picture picTest		= pic.flip(Picture.BACKWARD_DIAGONAL);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that flip(Picture.BACKWARD_DIAGONAL) works and 
	 * does not modify the original Picture object.
	 */
	public void testFlipBackwardDiagonal_Maria()
	{
		Picture pic 		= Picture.loadPicture("Maria1.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Maria1_flipBackwardSlash.bmp");
		Picture picTest		= pic.flip(Picture.BACKWARD_DIAGONAL);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that blur works and does not modify the 
	 * original Picture object.
	 */
	public void testBlur()
	{
		Picture pic 		= Picture.loadPicture("Creek.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Creek_blur.bmp");
		Picture picTest		= pic.blur(3);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that chromaKey works and does not modify the 
	 * original Picture object.
	 */
	public void testChromaKey_Logos()
	{
		Picture pic 		= Picture.loadPicture("Logos.bmp");
		Picture bg 			= Picture.loadPicture("Creek.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Logos_chromaKeyCreek.bmp");
		Picture picTest		= pic.chromaKey(118, 54, bg, 30);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that chromaKey works and does not modify the 
	 * original Picture object.
	 */
	public void testChromaKey_Maria()
	{
		Picture pic 		= Picture.loadPicture("Maria1.bmp");
		Picture bg 			= Picture.loadPicture("HMC.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Maria1_ChromaKeyHMC.bmp");
		Picture picTest		= pic.chromaKey(118, 54, bg, 30);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	
	/*
	 * Validate that paintBucket works and does not modify the 
	 * original Picture object.
	 */
	public void testPaintBucket()
	{
		Picture pic 		= Picture.loadPicture("Maria1.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Maria_paintBucket.bmp");
		Picture picTest		= pic.paintBucket(118, 54, 30, new Color(0, 255, 0));
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that showEdges works and does not modify the 
	 * original Picture object
	 */
	public void testShowEdgesMickey()
	{
		Picture pic         = Picture.loadPicture("mickey.bmp");
		Picture picCopy     = new Picture(pic);
		Picture picCorrect  = Picture.loadPicture("mickey_showEdges.bmp");
		Picture picTest     = pic.showEdges(20);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that showEdges works and does not modify the 
	 * original Picture object.
	 */
	public void testShowEdges_Geese()
	{
		// These are geese painted by Maria Klawe
		Picture pic 		= Picture.loadPicture("SnowGeese.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("SnowGeese_ShowEdges20.bmp");
		Picture picTest		= pic.showEdges(20);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	
}
