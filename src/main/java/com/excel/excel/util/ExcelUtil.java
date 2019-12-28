package com.excel.excel.util;

import com.excel.excel.excelcontroller.User;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author : yaobiao
 * @Description:
 * @time : 2019/12/15 16:42
 */
@Component
public class ExcelUtil {


    public void excel(List<User> list, ServletOutputStream outputStream) {
        try {
            //创建工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            //创建合并单元格对象
            CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 2);
            //头标题样式
            HSSFCellStyle style1 = createCellStyle(workbook, (short) 16);
            //列标题样式
            HSSFCellStyle style2 = createCellStyle(workbook, (short) 13);
            //创建工作表
            //TODO 文件名
            HSSFSheet sheet = workbook.createSheet("用户列表");
            //加载合并单元格对象
            sheet.addMergedRegion(cellRangeAddress);

            //创建行,
            //创建头标题；并设置头标题
            HSSFRow row1 = sheet.createRow(0);
            HSSFCell cell1 = row1.createCell(0);
            //加载样式
            cell1.setCellStyle(style1);
            //TODO 头的名字
            cell1.setCellValue("导出数据");

            //创建标题行，并设置标题
            HSSFRow row2 = sheet.createRow(1);
            //TODO
            String[] titles = {"用户名", "年龄"};
            for (int i = 0; i < titles.length; i++) {
                HSSFCell cell2 = row2.createCell(i);
                //加载单元格样式
                cell2.setCellStyle(style2);
                cell2.setCellValue(titles[i]);
            }
            //操作单元格；将用户列表写入excel
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    //从第二开始
                    HSSFRow row = sheet.createRow(i + 2);
                    //第1列
                    HSSFCell cell5 = row.createCell(0);
                    cell5.setCellValue(list.get(i).getName());

                    //第2列
                    HSSFCell cell2 = row.createCell(1);
                    cell2.setCellValue(list.get(i).getAge());
                }
            }
            workbook.write(outputStream);
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short fontSize) {
        //头标题样式
        HSSFCellStyle style = workbook.createCellStyle();
        //水平居中
        style.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        //创建字体
        HSSFFont font = workbook.createFont();
        //设置字体名称
        font.setFontName("微软雅黑");
        //设置字号
        font.setFontHeightInPoints(fontSize);
        //加载字体
        style.setFont(font);
        return style;

    }


}
