package com.yjw.excel.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * poi生成excel文件
 * @author yjw 2015-8-9
 *
 */
public class PoiExpExcel_XSSF {
	public static void main(String[] args) {
		String[] title = {"id","name","sex"};
		//创建excel工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		//创建一个工作表sheet
		Sheet sheet = workbook.createSheet();
		//创建第一行
		Row row = sheet.createRow(0);
		Cell cell = null;
		//插入第一行数据id,name,sex
		for(int i = 0;i<title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		//追加数据
		for(int i=1;i<=10;i++){
			Row nextRow = sheet.createRow(i);
			Cell nextCell = nextRow.createCell(0);
			nextCell.setCellValue("a"+i);
			
			nextCell = nextRow.createCell(1);
			nextCell.setCellValue("user"+i);
			
			nextCell = nextRow.createCell(2);
			nextCell.setCellValue("男"+i);
		}
		
		//创建一个文件
		File file = new File("F:/poi_text.xlsx");
		try {
			file.createNewFile();
			//将Excel内容存盘
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workbook.write(stream);
			workbook.close();
			stream.close();
			System.out.println("创建高版本excel结束,文件为："+file.getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("创建高版本excel异常");
		}
	}
}
