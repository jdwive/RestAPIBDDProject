package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cucumber.api.java.After;

public class ExcelUtility extends ConfigUtility{
	
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public ExcelUtility(){
		super();
				
	}
	public String readExcel(int rowNum, int columnNum) throws IOException {
		try{
			fis = new FileInputStream(readData("TestDataFile"));
			wb=new XSSFWorkbook(fis);
			sheet = wb.getSheet(readData("TestDataSheet"));
			row = sheet.getRow(rowNum);
			return row.getCell(columnNum).getStringCellValue();
		}
		catch (Exception e){
			System.out.println(e);
		}
		finally {
			wb.close();
		}
		return null;
		
	}
	public void writeExcel(int rowNum, int columnNum, String result) throws IOException{
		try {
			fis = new FileInputStream(readData("TestDataFile"));
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(readData("TestDataSheet"));
			row = sheet.getRow(rowNum);
			row.createCell(columnNum).setCellValue(result);
			fis.close();
			fos = new FileOutputStream(readData("TestDataFile"));
			wb.write(fos);
			fos.close();
		}
		catch(Exception e) {
			
		}
		finally {
			wb.close();
		}
		
	}
	@After
	public void closeConnection() throws IOException {
		wb.close();
	}
}
