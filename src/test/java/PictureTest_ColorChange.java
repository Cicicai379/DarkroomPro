import static org.junit.Assert.*;

import org.junit.Test;

public class PictureTest_ColorChange {
	/*
	 * Validate that grayscale works and does not modify the original Picture
	 * object.
	 */
	@Test
	public void testGrayscale_Micro() {
		Picture pic = Picture.loadPicture("Micro.bmp");
		Picture picCopy = new Picture(pic);
		Picture picCorrect = Picture.loadPicture("MicroGray.bmp");
		Picture picTest = pic.grayscale();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that grayscale works and does not modify the original Picture
	 * object.
	 */
	@Test
	public void testGrayscale() {
		Picture pic = Picture.loadPicture("Creek.bmp");
		Picture picCopy = new Picture(pic);
		Picture picCorrect = Picture.loadPicture("Creek_grayscale.bmp");
		Picture picTest = pic.grayscale();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that negate works and does not modify the original Picture
	 * object.
	 */
	@Test
	public void testNegateCreek() {
		Picture pic = Picture.loadPicture("Creek.bmp");
		Picture picCopy = new Picture(pic);
		Picture picCorrect = Picture.loadPicture("Creek_negate.bmp");
		Picture picTest = pic.negate();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that negate works and does not modify the original Picture
	 * object.
	 */
	@Test
	public void testNegateMaria() {
		Picture pic = Picture.loadPicture("Maria1.bmp");
		Picture picCopy = new Picture(pic);
		Picture picCorrect = Picture.loadPicture("Maria1_negate.bmp");
		Picture picTest = pic.negate();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Tests the color changing a solid color: darken
	 */
	@Test
	public void testColorTranslationsDarker() {
		Picture pic = Picture.loadPicture("Gray.bmp");
		Picture darker = Picture.loadPicture("Gray_darker.bmp");
		assertTrue(darker.equals(pic.darken(30)));

	}

	/*
	 * Tests the color changing a solid color: lighten
	 */
	@Test
	public void testColorTranslationsLighter() {
		Picture pic = Picture.loadPicture("Gray.bmp");
		Picture lighter = Picture.loadPicture("Gray_lighter.bmp");
		assertTrue(lighter.equals(pic.lighten(30)));

	}

	/*
	 * Tests the color changing a solid color: addGreen
	 */
	@Test
	public void testColorTranslationsGreener() {
		Picture pic = Picture.loadPicture("Gray.bmp");
		Picture greener = Picture.loadPicture("Gray_more_green.bmp");
		assertTrue(greener.equals(pic.addGreen(30)));

	}

	/*
	 * Tests the color changing a solid color: addBlue
	 */
	@Test
	public void testColorTranslationsBluer() {
		Picture pic = Picture.loadPicture("Gray.bmp");
		Picture bluer = Picture.loadPicture("Gray_more_blue.bmp");
		assertTrue(bluer.equals(pic.addBlue(30)));

	}

	/*
	 * Tests the color changing a solid color: addRed
	 */
	@Test
	public void testColorTranslationsReder() {
		Picture pic = Picture.loadPicture("Gray.bmp");
		Picture reder = Picture.loadPicture("Gray_more_red.bmp");
		assertTrue(reder.equals(pic.addRed(30)));

	}

	/*
	 * Validate that luminosity() works and does not modify the original Picture
	 * object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testLuminosity_Micro() {
		Picture pic = Picture.loadPicture("Micro.bmp");
		Picture picCopy = new Picture(pic);
		Picture picCorrect = Picture.loadPicture("MicroLum.bmp");
		Picture picTest = pic.luminosity();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that luminosity() works and does not modify the original Picture
	 * object.
	 * 
	 * Test with a small image that has few colors
	 */
	@Test
	public void testLuminosity_Tiny() {
		Picture pic = Picture.loadPicture("Tiny.bmp");
		Picture picCopy = new Picture(pic);
		Picture picCorrect = Picture.loadPicture("TinyLuminosity.bmp");
		Picture picTest = pic.luminosity();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that luminosity() works and does not modify the original Picture
	 * object.
	 * 
	 * Test with a small image
	 */
	@Test
	public void testLuminosity_Okinawa_Tiny() {
		Picture pic = Picture.loadPicture("Okinawa_tiny.bmp");
		Picture picCopy = new Picture(pic);
		Picture picCorrect = Picture.loadPicture("OkinawaTinyLuminosity.bmp");
		Picture picTest = pic.luminosity();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that luminosity() works and does not modify the original Picture
	 * object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testLuminosity_Okinawa() {
		Picture pic = Picture.loadPicture("Okinawa.bmp");
		Picture picCopy = new Picture(pic);
		Picture picCorrect = Picture.loadPicture("OkinawaLuminosity.bmp");
		Picture picTest = pic.luminosity();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

	/*
	 * Validate that luminosity() works and does not modify the original Picture
	 * object.
	 * 
	 * Test with a large image
	 */
	@Test
	public void testLuminosity_Camel() {
		Picture pic = Picture.loadPicture("Camel.bmp");
		Picture picCopy = new Picture(pic);
		Picture picCorrect = Picture.loadPicture("CamelLuminosity.bmp");
		Picture picTest = pic.luminosity();
		assertTrue(pic.equals(picCopy));
		assertTrue(picCorrect.equals(picTest));
	}

}
