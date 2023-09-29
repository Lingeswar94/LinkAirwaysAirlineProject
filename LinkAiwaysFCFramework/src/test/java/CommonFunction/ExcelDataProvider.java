package CommonFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelDataProvider {
	XSSFWorkbook workbook;
	static WebDriver driver;

	public ExcelDataProvider() throws IOException {

		File file = new File("./Testdata/FCdata.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream);
	}

	public String getAdultdata(String Sheetname, int row, int colunm) {
		XSSFCell cell = workbook.getSheet(Sheetname).getRow(row).getCell(colunm);
		DataFormatter formatter = new DataFormatter();
		String fi = formatter.formatCellValue(cell);
		return fi;
	}

	public String getRoutedata(String sheetname, int row, int column) {
		XSSFCell route = workbook.getSheet(sheetname).getRow(row).getCell(column);
		DataFormatter format = new DataFormatter();
		String routes = format.formatCellValue(route);
		return routes;
	}

	public String getPaymentdata(String sheetname, int row, int column) {
		XSSFCell paycell = workbook.getSheet(sheetname).getRow(row).getCell(column);
		DataFormatter dataFormatter = new DataFormatter();
		String pay = dataFormatter.formatCellValue(paycell);
		return pay;
	}

	public String getbillingdata(String sheetname, int row, int column) {
		XSSFCell cell = workbook.getSheet(sheetname).getRow(row).getCell(column);
		DataFormatter formatter = new DataFormatter();
		String bill = formatter.formatCellValue(cell);
		return bill;
	}
}
