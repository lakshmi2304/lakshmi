package in.srssprojects.kexim_bank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.commons.collections4.functors.SwitchClosure;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	static XSSFWorkbook book;
	static XSSFSheet sh;

//	set an excel file to read the data
	public static void setExcel(String folderName, String fileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(BaseClass.getFilePath(folderName, fileName) + ".xlsx");
			book = new XSSFWorkbook(fis);
			sh = book.getSheet(sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	get the number of rows
	public static int getRowCount() {
		return sh.getPhysicalNumberOfRows();
	}

//	get the number of cells
	public static int getCellCount() {
		return sh.getRow(1).getPhysicalNumberOfCells();
	}

	public static String readData(int rnum, int cnum) {
		CellType cellTypeEnum = sh.getRow(rnum).getCell(cnum).getCellTypeEnum();
		switch (cellTypeEnum) {
		case STRING:
			return sh.getRow(rnum).getCell(cnum).getStringCellValue();
		case NUMERIC:
			return Integer.toString((int)(sh.getRow(rnum).getCell(cnum).getNumericCellValue()));
		default:
			return null;
		}
	}

//	get all cells data and store in a two dimensional string array
	public static String[][] getData(String folderName, String fileName, String sheetName) {
		setExcel(folderName, fileName, sheetName);
		int nor = getRowCount();
		int noc = getCellCount();
		String[][] data = new String[nor - 1][noc];
		for (int i = 1; i < nor; i++) {
			for (int j = 0; j < noc; j++) {
				data[i - 1][j] = readData(i, j);
//				System.out.print(readData(i, j)+"\t");
			}
//			System.out.println();
		}
		return data;
	}
	
//	public static void main(String[] args) {
//		String[][] data = getData("resources", "testdata", "branchdata");
//		
//	}

}
