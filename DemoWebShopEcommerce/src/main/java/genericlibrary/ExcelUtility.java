package genericlibrary;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public static String getCelldata(String Sheet1,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		//step 1: Get the java representation of physical file
		FileInputStream fis = new FileInputStream(FrameworkConstants.EXCEL_Path);
		
		//step2:Create a workbook
		Workbook workbook = WorkbookFactory.create(fis);
		
		//step 3: Get the Sheet from workbook
		Sheet sheet = workbook.getSheet(Sheet1);
		
		//step 4: Get row from the sheet
		 Row row = sheet.getRow(rowNum);
		 
		//step 5: Get the cell from the given row
		 Cell cell = row.getCell(cellNum);
		 
		String data = cell.getStringCellValue();
		return data;
		
		
		
	
	}

	
public static String[][] getRowdata(String Sheet1) throws EncryptedDocumentException, IOException {
    
	//step 1: get the java representation of physical file
	FileInputStream fis=new FileInputStream(FrameworkConstants.EXCEL_Path);
	
	//step 2: create a workbook
	Workbook workbook=WorkbookFactory.create(fis);
	
	//step 3: Get the sheet from workbook
	Sheet sheet=workbook.getSheet(Sheet1);
	
	//step 4:
	int rowcount=sheet.getPhysicalNumberOfRows(); 
	//step5:
	int columncount = sheet.getRow(0).getPhysicalNumberOfCells();
	
	String [][]data=new String[rowcount-1][columncount];
	
	for (int i = 1; i < rowcount; i++) {
		for (int j = 0; j < columncount; j++) {
			data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			
		}
	}
	return data;
}
}
