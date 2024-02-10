package testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericlibrary.BaseClass;
import genericlibrary.ExcelUtility;

public class BookTest extends BaseClass{
	
@Test
public void bookpage_001() throws InterruptedException {
	//moveMouseCursor(homepage.getComputerLink());
	scrollWindowBy(driver, 0,200);
	Thread.sleep(2000);
	MouseCursor(null);
}
	
	
@Test
public void test() throws EncryptedDocumentException, IOException {
	ExcelUtility.getCelldata("Sheet1", 0, 0);
}
}
