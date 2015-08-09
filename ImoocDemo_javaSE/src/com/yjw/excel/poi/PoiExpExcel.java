package com.yjw.excel.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * poi生成excel文件
 * @author yjw 2015-8-9
 *
 */
public class PoiExpExcel {
	public static void main(String[] args) {
		String[] title = {"id","name","sex"};
		//创建excel工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建一个工作表sheet
		HSSFSheet sheet = workbook.createSheet();
		//创建第一行
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;
		//插入第一行数据id,name,sex
		for(int i = 0;i<title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		//追加数据
		for(int i=1;i<=10;i++){
			HSSFRow nextRow = sheet.createRow(i);
			HSSFCell nextCell = nextRow.createCell(0);
			nextCell.setCellValue("a"+i);
			
			nextCell = nextRow.createCell(1);
			nextCell.setCellValue("user"+i);
			
			nextCell = nextRow.createCell(2);
			nextCell.setCellValue("男"+i);
		}
		
		//创建一个文件
		File file = new File("F:/poi_text.xls");
		try {
			file.createNewFile();
			//将Excel内容存盘
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workbook.write(stream);
			workbook.close();
			stream.close();
			System.out.println("创建excel结束,文件为："+file.getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("创建excel异常");
		}
	}
}
