package banking.keyworddriven;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class Driver {

	@Test
	public void execute() {
		Keywords keywords = new Keywords();
		Method[] methods = keywords.getClass().getMethods();
		// create ExcelHelper class objects so that we can read data from the excelfiles
		ExcelHelper tcExcel = new ExcelHelper();
		tcExcel.openExcel("resources", "keywords.xlsx", "testcases");
		ExcelHelper tsExcel = new ExcelHelper();
		tsExcel.openExcel("resources", "keywords.xlsx", "teststeps");

		// iterate over rows inside the test case excel
		for (int i = 1; i <= tcExcel.getRows(); i++) {
			// retrieve the data from test case excel
			String tcname = tcExcel.readData(i, 1);
			String runMode = tcExcel.readData(i, 2);
			if (runMode.equals("yes")) {
				// iterate over rows inside the test steps excel
				for (int j = 1; j <= tsExcel.getRows(); j++) {
					// retrieve the data from test step excel
					String tsd_tcname = tsExcel.readData(j, ExcelColumns.TSD_TCNAME);
					if (tcname.equals(tsd_tcname)) {
						String stepName = tsExcel.readData(j, ExcelColumns.STEPNAME);
						String locType = tsExcel.readData(j, ExcelColumns.LOCTYPE);
						String locValue = tsExcel.readData(j, ExcelColumns.LOCVALUE);
						String action = tsExcel.readData(j, ExcelColumns.ACTION);
						String testData = tsExcel.readData(j, ExcelColumns.TESTDATA);
						for(Method method : methods) {
							if(method.getName().equals(action)) {
								try {
									method.invoke(keywords, locType, locValue, testData);
									
									break;
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		}
	}
}
