package genericlibrary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class UtilityMethods {
	static Actions action;
	static Select selectoption;
	static JavascriptExecutor jse;
	public static void selectoptionByIndex(WebElement dropdown , int index) {
     
	 selectoption = new Select(dropdown);
     selectoption.selectByIndex(index);
     }
	public static void selectoptionByValue(WebElement dropdown , String value) {
		
		selectoption = new Select(dropdown);
		selectoption.selectByValue(value);
}
	public static void selectoptionByVisibletext(WebElement dropdown,String text) {
		
		selectoption = new Select(dropdown);
		selectoption.selectByVisibleText(text);
	}
	
	public static String getWebpageScreenShot(WebDriver driver)  {
		//Step1
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		String img = FrameworkConstants.SCREENSHOT_Path+getSystemDateAndTime()+".jpg";
		//Step2
		File temp = ts.getScreenshotAs(OutputType.FILE);
		
		//Step3
		File permananent = new File(img);
		
		//step4
		try {
			FileHandler.copy(temp, permananent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "."+img;
	}
	
	public static String getWebElementScreenShot(WebElement element) {
		String img = FrameworkConstants.SCREENSHOT_Path+getSystemDateAndTime()+".jpg";
		File temp2 = element.getScreenshotAs(OutputType.FILE);
		
		File permananet2= new File(img);
		
		try {
			FileHandler.copy(temp2, permananet2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "."+img;
		
	}
	public static String getSystemDateAndTime() {
		// TODO Auto-generated method stub
		return LocalDateTime.now().toString().replace(":", "_").replace("-", "_");
	}
	public static void switchToWindowByTitle(WebDriver driver, String Title) {
		Set<String> allWindows = driver.getWindowHandles();
		
		for (String window : allWindows) {
			driver.switchTo().window(window);
			
			if (driver.getTitle().contains(Title)) {
				break;
				
			}
		}
		
	}
	public static void switchToWindowByURL(WebDriver driver,String url) {
		Set<String> allwindows = driver.getWindowHandles();
		
		for (String window : allwindows) {
			driver.switchTo().window(window);
			
			if (driver.getCurrentUrl().contains(url)) {
				break;
				
			}
			
		}
		
	}
	public static void initObjects(WebDriver driver) {
		jse=(JavascriptExecutor)driver;
		action= new Actions(driver);
	}
	
	public static void scrollWindowBy(WebDriver driver, int x,int y) {
		
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public static void scrollWindowTo(WebDriver driver,int x,int y) {
		jse.executeScript("window.scrollTo("+x+","+y+")");
		
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement element,boolean elementPosition) {
		jse.executeScript("arguments[0].scrollIntoView("+elementPosition+")", element);
	}
	
	public static void handleDisableOrHiddenButton(WebElement element) {
		jse.executeScript("arguments[0].click()", element);
	}
	
	public static void handleDisableOrHiddenTextField(WebElement element, String value) {
		jse.executeScript("arguments[0].value='"+value+"'", element);
	}
	public static void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public static void MouseCursor(WebElement element) {
	action.moveToElement(element).perform();
		
	}
	public static void ContextClick(WebElement element) {
		action.contextClick(element).perform();
	}
	public static void doubleClick(WebElement element) {
		action.doubleClick(element).perform();
		
	}
	public static void clickandHold(WebElement element) {
		action.clickAndHold(element).perform();
	}
	public static void dragAndDrop(WebElement element) {
		action.dragAndDrop(element, element).perform();
	}
}	