package genericlibrary;



import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import objectRepository.Homepage;
import objectRepository.Loginpage;





public class BaseClass extends UtilityMethods {
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	@BeforeSuite
	public void bs() {
		report=new ExtentReports("./Reports/"+getSystemDateAndTime()+".html");
		System.out.println("Before suite");
		}
	@AfterSuite
	public void As() {
		report.flush();
		System.out.println("After suite");
	}
	@BeforeClass
     public void launch() throws IOException {
		
		String browser = FileUtility.getProperty("browser");
		if (browser.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();	
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			
		} 
		
		else if (browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			
		} 
		
		else {
			driver= new ChromeDriver();

		}
		
		driver.manage().window().maximize();
		//driver.get("https://demowebshop.tricentis.com/");
		driver.get(FileUtility.getProperty("url"));
		System.out.println("Before class");
		initObjects(driver);
	}
	@AfterClass
	public void AC() {
		driver.quit();
		System.out.println("After class");
		}
	@BeforeMethod
	public void Bm(Method method) throws IOException {
		String methodName = method.getName();
		test=report.startTest(methodName);
		//test = report.startTest("Login testscript");
        Homepage homepage=new Homepage(driver);
		Loginpage loginpage=new Loginpage(driver);
		
		//click on login link
		homepage.getLoginlink().click();
		
		//Enter email address
		loginpage.getEmailtxtfield().sendKeys(FileUtility.getProperty("email"));
		//loginpage.getEmailtxtfield().sendKeys("vvinothinba460@gmail.com");
		
		//enter password
		loginpage.getPasswordtxtfield().sendKeys(FileUtility.getProperty("password"));
		//loginpage.getPasswordtxtfield().sendKeys("Inba@97911");
		
		//click on login button
		loginpage.getLoginbutton().click();
		}
	
	@AfterMethod
	public void Am() {
		
		report.endTest(test);
		//click on logout link
		
		Homepage homepage = new Homepage(driver);
		homepage.getLogoutlink().click();
		System.out.println("logout done in after method");
		
		
	}
	@BeforeTest
	public void Bt() {
		System.out.println("Before Test");
		
	}
	@AfterTest
	public void At() {
		System.out.println("After Test");
	}
	@Test
	public void test1() {
		System.out.println("testcase 1");
		test.log(LogStatus.INFO, "Browser is launched");
		test.log(LogStatus.INFO, "Maximized");
		test.log(LogStatus.INFO, "Navigate To Google Page");
		test.log(LogStatus.PASS, "TestScript pass");
	}
}



