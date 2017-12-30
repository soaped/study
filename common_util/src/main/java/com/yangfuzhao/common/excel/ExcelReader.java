package com.yangfuzhao.common.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * 将读取后表格中Double的值转换为Int ,只检查需要整形数的单元格
 * Created with IntelliJ IDEA.
 * User: ipaynow0929
 * Date: 16-11-2
 * Time: 下午2:35
 * To change this template use File | Settings | File Templates.
 */
public class ExcelReader {

    private final static ExcelReader excelReader = new ExcelReader();

    private ExcelReader() {

    }

    public static ExcelReader getInstance() {
        return excelReader;
    }

    public Workbook getWorkbook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith("xls")){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith("xlsx")){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }

}
