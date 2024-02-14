package reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
// Hi
public class Reportexample {
ExtentReports report= new ExtentReports("./Reports/report.html");
@Test
public void test() {
ExtentTest test=report.startTest("Login testscript");

WebDriver driver=new ChromeDriver();
test.log(LogStatus.INFO,"Browser is launched");

driver.manage().window().maximize();
test.log(LogStatus.INFO, "maximized");

driver.get("https:google.com");
test.log(LogStatus.INFO, "navigate to google webpage");

test.log(LogStatus.FAIL, "testscript pass");
report.endTest(test);
report.flush();
}


}
