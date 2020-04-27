package com.Mini_Project.Utiliti;


import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Login_Data_Driver_Utilites {

	public XSSFWorkbook workbook;
	public XSSFSheet sheet;

	public Login_Data_Driver_Utilites(String path,String shet) {

		try {
			workbook=new XSSFWorkbook(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheet=workbook.getSheet(shet);

	}

	public int getRow_Count() {

		int row_count=sheet.getPhysicalNumberOfRows();
		return row_count;
	}
	
	public int getColumn_Count() {
		int column_Count=sheet.getRow(0).getPhysicalNumberOfCells();
		return column_Count;
	}
	
	public Object get_Cell_Data(int row,int col) {
		//DataFormatter formatter=new DataFormatter();
		Object cell_data=sheet.getRow(row).getCell(col).getStringCellValue();
		return cell_data;
	}

}
