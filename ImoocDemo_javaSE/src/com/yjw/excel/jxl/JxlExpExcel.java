package com.yjw.excel.jxl;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * JXL创建Excel文件
 * @author yjw 2015-8-9
 *
 */
public class JxlExpExcel {
	public static void main(String[] args) {
		String[] title = {"id","name","sex"};
		
		//创建Excel文件
//		File file = new File("F:/jxl_test.xlsx");
		File file = new File("F:/jxl_test.xls");
		
		try {
			file.createNewFile();
			//创建工作簿
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			//创建sheet（视图页）
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			Label label = null;
			//第一行设置列名
			for(int i=0;i<title.length;i++){
				label = new Label(i,0,title[i]);
				sheet.addCell(label);
			}
			//追加数据
			for(int i = 1;i<10;i++){
				label = new Label(0,i,"a"+1);
				sheet.addCell(label);
				label = new Label(1,i,"user"+1);
				sheet.addCell(label);
				label = new Label(2,i,"男"+1);
				sheet.addCell(label);
			}
			//写入数据
			workbook.write();
			workbook.close();
			System.out.println("创建excel结束,文件为："+file.getPath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("创建excel异常");
		}
	}
}
