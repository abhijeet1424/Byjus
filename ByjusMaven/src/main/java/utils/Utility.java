package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.apache.poi.ss.usermodel.Cell;

public class Utility {
	
	public static String getDataFromExcelsheet(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		String data="";
		String filepath="src\\test\\resources\\DataResource\\ProjectTestData.xlsx";
		InputStream file=new FileInputStream(filepath);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet excelSheet=workbook.getSheet(sheet);
		Row excelRow=excelSheet.getRow(row);
		Cell excelCell=excelRow.getCell(cell);
		
		try 
		{
			data=excelCell.getStringCellValue();
		} 
		catch (Exception e) 
		{
			double value=excelCell.getNumericCellValue();
			data=String.format("%f", value);
			
			
		}
		file.close();
		return data;
		
		
	}
	
	
	public static void getScreenshot(WebDriver driver,String testID) throws IOException
	{
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String currentDateTime=dateFormat.format(new Date());
		
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile= new File("test-output\\FailedTestCaseScreenshots\\Test"+" "+testID+" "+currentDateTime+".png");
		FileHandler.copy(sourceFile, destinationFile);
	}

}
