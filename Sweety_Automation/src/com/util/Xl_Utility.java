package com.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xl_Utility 
{

		public static FileInputStream fi;
		public static Workbook wb;
		public static Sheet ws;
		public static Row row;
		public static Cell cell;
		 
		public static int getRowCount(String xlfile,String xlsheet) throws IOException
		{
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet); 
			int rowcount = ws.getLastRowNum();
			wb.close();
			fi.close();
			return rowcount;		
		}	
		
		public static int getColumnCount(String xlfile,String xlsheet,int rownum) throws IOException
		{
			
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			short colcount = row.getLastCellNum();
			wb.close();
			fi.close();
			return colcount;
		}
		
		public static String getStringCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
		{
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			String data;
			try 
			{
				cell = row.getCell(colnum);
				data = cell.getStringCellValue();
			} catch (Exception e) 
			{
				data="";
			}
			wb.close();
			fi.close();
			return data;		
		}
		
		public static String getCellData(String xlfile,String xlsheet,int rownum, int column)
		{
			String data = " ";
			if(wb.getSheet(xlsheet).getRow(rownum).getCell(column).getCellType()==CellType.NUMERIC)
			{
				int cellData = (int)wb.getSheet(xlsheet).getRow(rownum).getCell(0).getNumericCellValue();
				data = String.valueOf(cellData);
			}
			else
			{
				wb.getSheet(xlsheet).getRow(rownum).getCell(0);
			}
			return data;
		}

}
