package com.univ.action;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
 * @author: liuml
 * @date: 2015年8月28日 上午8:56:15 
 * @version: 1.0 
 * @description: 
 */

public class JxlTest {

	/**
	 * 读取存在的excel文件内容
	 */
	@Test
	public void readFromExcel() throws BiffException, IOException{
		String path = "D:\\excelTest\\201211野炊人员名单.xls";//此文件已存在
		File excelFile = new File(path);
		Workbook workbook  = Workbook.getWorkbook(excelFile);
		//得到第一张工作表sheet
		Sheet sheet = workbook.getSheet(0);
		//得到工作表的总列数和总行数
		int colNums = sheet.getColumns();
		int rowNums = sheet.getRows();
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
	}
	
	/**
	 * 向已存在的excel文件中追加内容
	 */
	@Test
	public void AppendToExcel() throws IOException, RowsExceededException, WriteException, BiffException {
		//这里假设lml.xls已经存在
		String path = "D:"+File.separator+"excelTest"+File.separator+"lml.xls";
		File file = new File(path);
		/*
		 * 工作原理：原来的excel文件（lml.xls）并没有发生变化，而是新生成一个excel文件，存放lml.xls中的内容和新增加的内容
		 */
		File outFile = new File("D:"+File.separator+"excelTest"+File.separator+"lmlNew.xls");
		//取得已存在excel文件对应的Workbook对象
		Workbook wb = Workbook.getWorkbook(file);
		WritableWorkbook workbook = Workbook.createWorkbook(outFile,wb);

		WritableSheet sheet= workbook.getSheet(0);

		int rows = sheet.getRows();	
		Label label = new Label(0, rows,"新增");
		sheet.addCell(label);		
		workbook.write();		
		workbook.close();	
		wb.close();
	}
//	for (int row = 0; row < 5; row++) {
//	for (int col = 0; col < 4; col++) {
//		 Label label = new Label(col, row, "row");
//		 try {
//			sheet.addCell(label);//注意，此时还没有将内容真正写入到excel中，写入需要用write方法
//		} catch (WriteException e) {
//			e.printStackTrace();
//		}
//	}
//}
	/**
	 * 修改以存在的excel文件
	 */
	@Test
	public void modifyExcel() throws BiffException, IOException, RowsExceededException, WriteException{
		//修改之前先按普通的方法获得excel文件
		String path = "D:\\excelTest\\test.xls";//此文件已存在
		File excelFile = new File(path);
		Workbook workbook  = Workbook.getWorkbook(excelFile);
		
		//获取excelFile的一个副本，注意，此时内存空间中有两份excel文件，因此不适合修改大的excel文件
		WritableWorkbook copybook = Workbook.createWorkbook(excelFile, workbook);
		WritableSheet sheet = copybook.getSheet(0);
		
		//新增单元格		
		Label label = new Label(3,5,"added");
		/*
		 * 注意，执行下面的语句后，列数和行数从之前的0和0变成了6和4
		 */
		sheet.addCell(label);

		//修改已存在单元格的值,注意，如果单元格没有值，则cell.getType()的值为Empty
        WritableCell cell = sheet.getWritableCell(1, 2);         
        if (cell.getType() == CellType.LABEL) 
        { System.out.println("===========");
          Label l = (Label) cell; 
          l.setString("modified cell"); 
        } 
        
		copybook.write();
		copybook.close();
	}
	
	/*
	 * 合并单元格测试
	 */
	@Test
	public void merge() throws IOException, WriteException, BiffException{
		String path = "D:\\excelTest\\实验室工作人员信息统计1.xls";//此文件已存在
		File excelFile = new File(path);
		Workbook workbook  = Workbook.getWorkbook(excelFile);
		
		//获取excelFile的一个副本，注意，此时内存空间中有两份excel文件，因此不适合修改大的excel文件
		WritableWorkbook copybook = Workbook.createWorkbook(excelFile, workbook);
		WritableSheet sheet = copybook.getSheet(0);

		
		/*
		 * 注意：合并单元格后，整个大的单元格将由mergeCells方法的前两个参数唯一表示，
		 * 因此执行sheet.mergeCells(0, 0, 1, 2)后，如果想给这个大的合并后的单元格赋值，则只有sheet.addCell(Label)有效，
		 * sheet.addCell(Label2)无效。
		 */
		sheet.mergeCells(0, 0, 1, 2);
		
		/*
		 * 设置单元格格式
		 */
		WritableCellFormat cellFormat = new WritableCellFormat();
		cellFormat.setAlignment(Alignment.CENTRE);//设置单元格内容水平对齐
		cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);//设置单元格内容垂直对齐
		
		Label Label = new Label(0, 0, "hello",cellFormat);
		sheet.addCell(Label);
		
		sheet.setRowView(44, 500);
		sheet.setColumnView(0, 20);
		
		/*Label Label2 = new Label(0, 0, "hello");
		sheet.addCell(Label2);*/

		
		sheet.mergeCells(3, 5, 4, 10);
		//真正将数据写入excel中
		copybook.write();
		copybook.close();		
		
		
	}
	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("before ..................");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after..................");
	}

}


