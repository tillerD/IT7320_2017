package Assignment3.Part3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordCountTest {
	
	private WordCounter obj;

	@Before
	public void setUp() throws Exception {
		obj = new WordCounter();
	}

	@After
	public void tearDown() throws Exception {
		obj = null;
	}

	@Test
	public void testCount() {
		String text = "This is a test";
		int count = 4;
		assertEquals(count, obj.count(text));
	}
	
	@Test
	public void testDisplay() {
		int count = 4;
		boolean display = true;
		assertEquals(display, obj.display(count));
	}
	
	@Test
	public void testReverse() {
		String text = "This is a test";
		String txet = "tset a si sihT";
		assertEquals(txet, obj.reverse(text));
	}

}
