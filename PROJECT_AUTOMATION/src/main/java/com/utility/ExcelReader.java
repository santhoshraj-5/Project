package com.utility;


import java.io.IOException;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader  {
	private String filelocation=System.getProperty("user.dir")+"/src/test/resources/testdata/project.xlsx";
	private XSSFWorkbook wbook;
	private XSSFSheet sheet;
	private DataFormatter formate;
	private XSSFRow row;
	private XSSFCell cell;
	public ExcelReader()  {
		 try {
			wbook=new XSSFWorkbook(filelocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getrowcount_without_header(String sheetname) {
		sheet=wbook.getSheet(sheetname);
		int row_count=sheet.getLastRowNum();
		return row_count;
	}
	public int getrowcount_include_header(String sheetname) {
		sheet=wbook.getSheet(sheetname);
		int row_count=sheet.getPhysicalNumberOfRows();
		return row_count;
	}
	public short getTotalCellcount(String sheetname) {
		sheet=wbook.getSheet(sheetname);
		short cell_count=sheet.getRow(0).getLastCellNum();
		return cell_count;
	}
	
//change for login test i=1
	public String[][] readxl(String sheetname)throws IOException{ 
		 try {
				wbook=new XSSFWorkbook(filelocation);
			} catch (IOException e) {
				e.printStackTrace();
			}
		sheet=wbook.getSheet(sheetname);
		//XSSFSheet sheet=wbook.getSheetAt(0);
		int row_count=sheet.getPhysicalNumberOfRows();
		//int row_count=sheet.getLastRowNum();
		System.out.println("row count in excel "+row_count);
		short cell_count=sheet.getRow(0).getLastCellNum();
		System.out.println("cell count in excel "+cell_count);
		formate=new DataFormatter();
		String[][] xlvalues=new String[row_count-1][cell_count];
		for(int i=1;i<row_count;i++) {
			   row=sheet.getRow(i);
			for(int j=0;j<cell_count;j++) {
				cell=row.getCell(j);
				String value=formate.formatCellValue(cell);
				xlvalues[i-1][j]=value;
			}
		}
		try {
			wbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return xlvalues;
	}
	 
}
	

