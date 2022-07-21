package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelUse {
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow Row;
	private static XSSFCell cell;

	public void setExcelFile(String excelFilePath, String sheetName) throws IOException {
		File file = new File(excelFilePath);
		FileInputStream istream = new FileInputStream(file);
		workbook = new XSSFWorkbook(istream);
		sheet = workbook.getSheet("Sheet1");
	
	}

	public String getCellData(int rownum, int cellnum) {
		cell = sheet.getRow(rownum).getCell(cellnum);
		return cell.getStringCellValue();

	}

	public int getRowCountInSheet() {
		int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		return rowcount;
	}

	public void setCellValue(int rowNM, int cellNM, String cellValue, String excelFilepath) throws IOException {
		sheet.getRow(rowNM).createCell(cellNM).setCellValue(cellValue);
		FileOutputStream ostream = new FileOutputStream(excelFilepath);
		workbook.write(ostream);

}
}

