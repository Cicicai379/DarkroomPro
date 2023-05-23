import static org.junit.Assert.*;

import org.junit.Test;


public class PictureTest_Carve {
	/*
	 * Validate that carve works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testCarve_Micro()
	{
		Picture pic 		= Picture.loadPicture("Micro.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("MicroCarve.bmp");
		Picture picTest		= pic.carve();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that carve works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testCarve_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("TinyCarve1.bmp");
		Picture picTest		= pic.carve();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	
	/*
	 * Validate that carve works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image
	 */
	@Test
	public void testCarve_Okinawa_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Okinawa_tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaTinyCarve1.bmp");
		Picture picTest		= pic.carve();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that carve works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testCarve_Okinawa()
	{
		Picture pic 		= Picture.loadPicture("Okinawa.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaCarve1.bmp");
		Picture picTest		= pic.carve();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that carve works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testCarve_Camel()
	{
		Picture pic 		= Picture.loadPicture("Camel.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("CamelCarve1.bmp");
		Picture picTest		= pic.carve();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}


}
