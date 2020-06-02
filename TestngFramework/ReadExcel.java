package week5.day2.TestngFramework;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String[][] readData(String fileName) throws IOException {
		
		//create an object for workbook 
		//XSSFWorkbook wb = new XSSFWorkbook("./data/createlead.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
		
		//Get into worksheet
		XSSFSheet ws = wb.getSheetAt(0);
		
		int rowCount = ws.getLastRowNum();//Get row count
		
		int colCount = ws.getRow(0).getLastCellNum();//Get Column count
		
		String[][] data = new String[rowCount][colCount];
		
		for (int i = 1; i <=rowCount; i++) {
			
			for (int j = 0; j < colCount; j++) {
				
				String CellValue = ws.getRow(i).getCell(j).getStringCellValue();
				
				data[i-1][j]=CellValue;
			}
			
		}
		
		wb.close();
		return data;

	}

}
