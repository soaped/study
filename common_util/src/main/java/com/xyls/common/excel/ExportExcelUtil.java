package com.xyls.common.excel;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: benyamin
 * Date: 17-3-22
 * Time: 下午5:48
 * To change this template use File | Settings | File Templates.
 */
public class ExportExcelUtil {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private String fileName;
    private List<String> header;
    private List<String> fieldNames;
    private XSSFCellStyle headerFontStyle;//默认字体样式
    private XSSFCellStyle cellFontStyle;//默认字体样式

    /*
    * 1. 第一步 创建
    * */
    public void create(String fileName, List<String> header, List<String> fieldNames) {

        this.fileName = fileName;
        this.fieldNames = fieldNames;
        this.header = header;

        //创建Xls
        workbook = new XSSFWorkbook();

        //创建sheet
        sheet = workbook.createSheet("sheet1");
        sheet.setVerticallyCenter(true);
        sheet.setHorizontallyCenter(true);

        setDefaultStyle();
        //写入头信息
        writeHeader(header, headerFontStyle);
    }

    private void setStyle(XSSFCellStyle headerFontStyle, XSSFCellStyle cellFontStyle) {
        this.headerFontStyle = headerFontStyle;
        this.cellFontStyle = cellFontStyle;

    }

    private void setDefaultStyle() {
        //设置字体样式
        headerFontStyle = workbook.createCellStyle();
        headerFontStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        XSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        headerFontStyle.setFont(font);
        byte[] bytes= new byte[] {(byte) 153, (byte) 204, (byte) 255};
        XSSFColor xssfColor=new XSSFColor();
        xssfColor.getCTColor().setRgb(bytes);
        headerFontStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerFontStyle.setFillForegroundColor(xssfColor);
        headerFontStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        headerFontStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        headerFontStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        headerFontStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框


        cellFontStyle = workbook.createCellStyle();
        cellFontStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        cellFontStyle.setFont(font);
        cellFontStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        cellFontStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        cellFontStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        cellFontStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

    }

    //写入头信息
    private void writeHeader(List<String> header, XSSFCellStyle style) {
        if (CollectionUtils.isEmpty(header)) {
            return;
        }

        XSSFRow xssfRow = sheet.createRow(0);
        for (int i = 0; header.size() > i; i++) {
            //sheet.setColumnWidth(i,header.get(i).getBytes().length*2*256);
            Cell cell = xssfRow.createCell(i);
            writerCell(cell, header.get(i), HSSFCell.CELL_TYPE_STRING, style);
        }
    }

    private void writerCell(Cell cell, String value, Integer cellType, XSSFCellStyle style) {
        cell.setCellStyle(style);
        cell.setCellType(cellType);
        if(null==value ){
            if(HSSFCell.CELL_TYPE_NUMERIC == cellType){
                value = "0";
            }else {
                value="";
            }
        }
        if(HSSFCell.CELL_TYPE_NUMERIC == cellType ){
            cell.setCellValue(Double.parseDouble(value));
        }else{
            cell.setCellValue(value+"\t");
        }
    }


    //第二步，写入行
    public void writeEntity(Object obj, int rowIndex) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (CollectionUtils.isEmpty(fieldNames)) {
            return;
        }
        XSSFRow row = sheet.createRow(rowIndex);
        Cell cell = null;
        for (int i = 0; fieldNames.size() > i; i++) {
            String value = BeanUtils.getProperty(obj, fieldNames.get(i));
            cell = row.createCell(i);
            writerCell(cell, value, HSSFCell.CELL_TYPE_STRING, cellFontStyle);
        }
    }


    //3 Excle导出
    public void exportExcel(HttpServletResponse response,HttpServletRequest request) throws IOException {

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/x-msdownload;charset=UTF-8");

        //增加了对火狐浏览器文件名 乱码的兼容
        String agent = (String)request.getHeader("USER-AGENT");
        if(agent != null && agent.toLowerCase().indexOf("firefox") > 0)
        {
            response.setHeader("Content-Disposition", "attachment; filename*=utf-8'zh_cn'" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
        }
        else
        {
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
        }
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
    }

    /**
     * 将excel导出到硬盘
     * @param excelPath
     * @throws IOException
     */
    public void exportExcelToDisk(String excelPath) throws IOException {
        //File file = new File(excelPath);
        OutputStream outputStream = new FileOutputStream(new File(excelPath));
        workbook.write(outputStream);
        outputStream.close();
    }
}
