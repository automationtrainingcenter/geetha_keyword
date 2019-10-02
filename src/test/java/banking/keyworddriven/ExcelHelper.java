package banking.keyworddriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import utilities.GenericHelper;

public class ExcelHelper extends GenericHelper {
	private Workbook book;
	private Sheet sheet;

	// open excel file to read the data
	public void openExcel(String folderName, String fileName, String sheetName) {
		try {
			// create an object of FileInputStream class
			FileInputStream fis = new FileInputStream(getPath(folderName, fileName));
			// verify file ends with xls or xlsx
			if (fileName.endsWith("xls")) {
				book = new HSSFWorkbook(fis);
			} else if (fileName.endsWith("xlsx")) {
				book = new XSSFWorkbook(fis);
			}
			this.sheet = book.getSheet(sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// find the number of rows
	public int getRows() {
		return this.sheet.getLastRowNum();
	}

	// find the number of columns
	public int getColumns() {
		return sheet.getRow(0).getLastCellNum();
	}

	// read the data from given row and column
	public String readData(int rnum, int cnum) {
		Cell cell = sheet.getRow(rnum).getCell(cnum);
		CellType cellType = cell.getCellType();
		String data = "";
		switch (cellType) {
		case STRING:
			data = cell.getStringCellValue();
			break;
		case NUMERIC:
			int i = (int) cell.getNumericCellValue();
			data = Integer.toString(i);
			break;
		default:
			throw new RuntimeException("invalid cell type");
		}
		return data;

	}

	// close excel file
	public void closeExcel() {
		try {
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Test
//	public void testmethod() {
//		openExcel("resources", "keywords.xlsx", "Sheet1");
//		int nor = getRows();
//		int noc = getColumns();
//		for(int i = 0; i<=nor; i++) {
//				System.out.print(readData(i, 0)+"\t");
//				System.out.println(readData(i, 1));
//		}
//		closeExcel();
//	}
}
