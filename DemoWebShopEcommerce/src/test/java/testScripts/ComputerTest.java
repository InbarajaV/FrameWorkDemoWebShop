package testScripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ComputerTest {

	@Test
	public void test() {

		System.out.println("hi sir");
		System.out.println("bye sir");
		System.out.println("I love you all too");

		Reporter.log("I love you sir",true);
	}
	
}
