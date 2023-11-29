import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ua.cn.stu.remotelabs.Result;

public class ResultTest {
	
	@Test
	public void testCreate() throws Exception {
		Result testResult = new Result(1, 7.75, "ppm", "17:42:58 17/11/2023");
		System.out.println("--RESULT_TEST--");
		assertEquals(testResult.getId(), 1);
		assertEquals(testResult.getValue(), 7.75, 0.00);
		assertEquals(testResult.getMark(), "ppm");
		assertEquals(testResult.getDatetime(), "17:42:58 17/11/2023");
		testResult.setId(5);
		testResult.setValue(75.4);
		testResult.setMark("%");
		testResult.setDatetime("17:57:00 19/11/2023");
		assertEquals(testResult.getId(), 5);
		assertEquals(testResult.getValue(), 75.4, 0.00);
		assertEquals(testResult.getMark(), "%");
		assertEquals(testResult.getDatetime(), "17:57:00 19/11/2023");
	}
	
}
