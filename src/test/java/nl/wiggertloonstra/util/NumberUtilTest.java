package nl.wiggertloonstra.util;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NumberUtilTest {

	@Test
	public void myFirstTest() throws Exception {
		NumberUtil numberUtil = new NumberUtil();
		assertThat(numberUtil.addNumbers(2, 3), is(5));
	}
	
}
