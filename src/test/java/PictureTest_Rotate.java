import static org.junit.Assert.*;

import org.junit.Test;


public class PictureTest_Rotate {
	/*
	 * Validate that rotate(1) works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testRotate1_Logos()
	{
		Picture pic 		= Picture.loadPicture("Logos.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Logos_rotateRight_once.bmp");
		Picture picTest		= pic.rotateRight();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that rotate(1) works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testRotate1_Maria()
	{
		Picture pic 		= Picture.loadPicture("Maria1.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Maria1_rotateRight_once.bmp");
		Picture picTest		= pic.rotateRight();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that rotate(2) works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testRotate2_Logos()
	{
		Picture pic 		= Picture.loadPicture("Logos.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Logos_rotateRight_twice.bmp");
		Picture picTest		= pic.rotateRight().rotateRight();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that rotate(2) works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testRotate2_Maria()
	{
		Picture pic 		= Picture.loadPicture("Maria1.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Maria1_rotateRight_twice.bmp");
		Picture picTest		= pic.rotateRight().rotateRight();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that rotate(3) works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testRotate3_Logos()
	{
		Picture pic 		= Picture.loadPicture("Logos.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Logos_rotateRight_thrice.bmp");
		Picture picTest		= pic.rotateRight().rotateRight().rotateRight();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that rotate(3) works and does not modify the 
	 * original Picture object.
	 */
	@Test
	public void testRotate3_Maria()
	{
		Picture pic 		= Picture.loadPicture("Maria1.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("Maria1_rotateRight_thrice.bmp");
		Picture picTest		= pic.rotateRight().rotateRight().rotateRight();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}



}
