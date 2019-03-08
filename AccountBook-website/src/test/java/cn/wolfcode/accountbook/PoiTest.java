package cn.wolfcode.accountbook;

import lombok.Cleanup;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Unit test for simple ApplicationCoreConfig.
 */
public class PoiTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void wordBook()throws Exception{
        //创建工作薄
        Workbook wb = new HSSFWorkbook();
        //创建第一页数
        Sheet sheet = wb.createSheet("工作薄");
        //创建一行
        Row row = sheet.createRow(0);
        row.createCell(0, CellType._NONE).setCellValue("姓名");
        row.createCell(1).setCellValue("年龄");
        @Cleanup//自动关闭该资源
        OutputStream fileOut = new FileOutputStream("F:\\home\\workbook.xls");
        wb.write(fileOut);


    }

    @Test
    public void workbook() throws Exception{
        Workbook wb = new HSSFWorkbook();
        // Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet();

        //创建一行并在其中放入一些单元格。行以0为基础。
        Row row = sheet.createRow(0);
        //创建一个单元格并在其中放置一个值。
        Cell cell = row.createCell(0);
        cell.setCellValue(1);

        //或者在一条线上做
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue(
        createHelper.createRichTextString("This is a string"));
        row.createCell(3).setCellValue("");

        //将输出写入文件
        @Cleanup
        OutputStream fileOut = new FileOutputStream("F:\\home\\workbook.xls");
            wb.write(fileOut);

    }
}
