package com.univ.action;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.opensymphony.xwork2.ActionSupport;

/** 
 * @author: liuml
 * @date: 2015年8月27日 下午4:08:29 
 * @version: 1.0 
 * @description: 测试excel的导入导出功能
 */

public class JxlAction extends ActionSupport {

	private String path = "D:\\excelTest\\201211野炊人员名单.xls";
	private File excelFile = new File(path);
	private Workbook workbook = null;
	
	public JxlAction(){
		try {
			workbook = Workbook.getWorkbook(excelFile);
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取存在的excel文件内容
	 */
	public String showContents(){
		//得到工作表sheet
		Sheet sheet = workbook.getSheet(0);
		
		//得到工作表的总列数和总行数
		int colNums = sheet.getColumns();
		int rowNums = sheet.getRows();
		System.out.println("rowNums:"+rowNums);
		System.out.println("colNums:"+colNums);
		//循环遍历sheet，输出sheet中的内容
		for(int row=0;row<rowNums;row++){
			//得到这一行的所有单元格cell
		
			Cell[] cells = sheet.getRow(row);
			//遍历一行中的所有单元格
			for(Cell c : cells){
				System.out.print(c.getContents()+"    ");
			}
			System.out.println();
		}
		return SUCCESS;
	}
	
	
}


