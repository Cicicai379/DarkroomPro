import static org.junit.Assert.*;

import org.junit.Test;


public class PictureTest_ShowSeam {

	/*
	 * Validate that showSeam works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testShowSeam_Micro()
	{
		Picture pic 		= Picture.loadPicture("Micro.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("MicroShowSeam.bmp");
		Picture picTest		= pic.showSeam();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that showSeam works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testShowSeam_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("TinySeam.bmp");
		Picture picTest		= pic.showSeam();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that showSeam works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a small image
	 */
	@Test
	public void testShowSeam_Okinawa_Tiny()
	{
		Picture pic 		= Picture.loadPicture("Okinawa_tiny.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaTinySeam.bmp");
		Picture picTest		= pic.showSeam();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that showSeam works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testShowSeam_Okinawa()
	{
		Picture pic 		= Picture.loadPicture("Okinawa.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("OkinawaSeam.bmp");
		Picture picTest		= pic.showSeam();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}
	/*
	 * Validate that showSeam works and does not modify the 
	 * original Picture object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testShowSeam_Camel()
	{
		Picture pic 		= Picture.loadPicture("Camel.bmp");
		Picture picCopy 	= new Picture(pic);
		Picture picCorrect	= Picture.loadPicture("CamelSeam.bmp");
		Picture picTest		= pic.showSeam();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

}
