import static org.junit.Assert.*;

import org.junit.Test;


public class PictureTest_CarveMany {

	/*
	 * Validate that carveMany works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testCarve2_Micro()
	{
		Picture pic 		= Picture.loadPicture("Micro.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("MicroCarve2.bmp");
		Picture picTest		= pic.carveMany(2);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that carveMany works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testCarve5_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("TinyCarve5.bmp");
		Picture picTest		= pic.carveMany(5);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that carveMany works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image
	 */
	@Test
	public void testCarve5_Okinawa_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Okinawa_tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaTinyCarve5.bmp");
		Picture picTest		= pic.carveMany(5);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that carveMany works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testCarve5_Okinawa()
	{
		Picture pic 		= Picture.loadPicture("Okinawa.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaCarve5.bmp");
		Picture picTest		= pic.carveMany(5);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that carveMany works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testCarve5_Camel()
	{
		Picture pic 		= Picture.loadPicture("Camel.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("CamelCarve5.bmp");
		Picture picTest		= pic.carveMany(5);
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

}
