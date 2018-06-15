package com.craftsvilla.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	/* declaring instance variable instead of local variable, as no memory allocation will be done here. Only declaration is done.
	 */
	public static File file = null;
	public static FileInputStream fin = null;
	public static Workbook wb = null;
	public static Sheet sh = null;
	
	public static String[][] getData(String Filename, String Sheetname)
	{
		try
		{
			// memory allocation is done here. Garbage collection happens only with the local variables. Once the method is exited.
			file = new File(Filename); // gets object of an excelfile
			fin = new FileInputStream(file); //???? gets an pbject to handle excelfile
			wb = new XSSFWorkbook(fin); // gets object for the workbook
			sh = wb.getSheet(Sheetname); // gets access to the sheet in the workbook
			
			int rowNum = sh.getLastRowNum();
			int cellNum = sh.getRow(0).getLastCellNum(); // gets last cell from the first row
			
			String[][] data = new String[rowNum][cellNum];
			
			for(int i=0; i<rowNum; i++)
			{
				Row rw = sh.getRow(i); // gets row from the sheet
				for(int j=0; j<cellNum; j++)
				{
					Cell c = rw.getCell(j); // gets cell value from the defined row & cell
					String value = new DataFormatter().formatCellValue(c); // formats the cell value to String. As the value has to saved in an 2D array of strings
					data[i][j] = value;
				}
			}
			
			return data;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null; // is important when an exception occurs
		}
		
		finally
			{
				/* have to use try/catch block as the poi api methods will throw exceptions */
				try 
				{
					wb.close();
					// to make sure all the local variables are closed, so that it can be opened later.
					wb = null;
					
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
			}
	
	}
}
