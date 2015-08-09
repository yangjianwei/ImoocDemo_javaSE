package com.yjw.excel.jxl;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * jxl解析Excel
 * @author yjw 2015-8-9
 *
 */
public class JxlReadExcel {
	public static void main(String[] args) {
		try {
			//创建workbook
			Workbook workbook = Workbook.getWorkbook(new File("F:/jxl_test.xlsx"));
			//获取工作表sheet
			Sheet sheet = workbook.getSheet(0);
			//获取数据
			for(int i=0;i<sheet.getRows();i++){
				for(int j=0;j<sheet.getColumns();j++){
					Cell cell = sheet.getCell(j,i);
					System.out.print(cell.getContents()+" ");
				}
				System.out.println();
			}
			workbook.close();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
