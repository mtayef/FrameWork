package dataProvider;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	XSSFWorkbook wb;
	
	public ExcelDataProvider() 
	{
		try 
		{ 
			wb = new XSSFWorkbook(new FileInputStream
					(new File(System.getProperty
							("user.dir")+"/TestData/Login.xlsx")));
		} catch (Exception e) {
			System.err.println("ERROR: Unable to upload the file " + e.getMessage());
		}
	}
		
		public String getStringData(String sheetname,int row,int column) 
		{
			String data = wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
			return data;
		}
		public String getStringData(int sheetindex,int row,int column) 
		{
			String data = wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
			return data;
		}
		public double getDoubleData(String sheetname,int row,int column) 
		{
			double data = wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
			return data;
		}
		public int getIntData(String sheetname,int row,int column) 
		{
			int data = (int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
			return data;
		}
		
}

