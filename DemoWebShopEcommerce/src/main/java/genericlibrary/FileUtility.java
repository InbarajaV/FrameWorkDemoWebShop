package genericlibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
public static  String getProperty(String key) throws IOException {
		
		//step1: get the java representation of physical file
		FileInputStream fis = new FileInputStream(FrameworkConstants.PROPERTIES_Path);
		
		//step2: Create a object of properties class
		Properties pObj = new Properties();
		
		//step 3: Load all key and values to properties object
		pObj.load(fis);
		
		//step 4: Get value using the key
		return pObj.getProperty(key);

}
}