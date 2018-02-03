package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	
	public  ExcelDataProvider()
	{
		File src = new File ("./ApplicationData/rideSheet.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to load Excel Sheet"+e.getMessage());
			
		}
	
		
		
	}
	
	public String getData(int sheetindex, int row, int column )
	{
		
		String data=wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
		return data;
		
		
	}
	
	public String getData(String sheetname, int row, int column)
	{
		String data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	
}
