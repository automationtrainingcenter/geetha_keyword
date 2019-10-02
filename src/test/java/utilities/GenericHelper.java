package utilities;

import java.io.File;

public class GenericHelper {
	/*
	 * method to retrieve the path of given file or folder in project root folder
	 */
	public String getPath(String folderName, String fileName) {
		return System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName;
	}


}
