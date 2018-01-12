package com.xyls.common.excel;

import com.alibaba.dubbo.common.utils.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将读取后表格中Double的值转换为Int ,只检查需要整形数的单元格
 * Created with IntelliJ IDEA.
 * User: ipaynow0929
 * Date: 16-11-2
 * Time: 下午2:35
 * To change this template use File | Settings | File Templates.
 */
public class CellDoubleToInt {

    public static Workbook getWorkBook(MultipartFile file) {
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


    /**
     * 获取double值
     * @param str
     * @return
     */
    public static Double getDouble(String str){
        Double v =null;
        try {
           v = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return  null;
        }
        return v;
    }


    /**
     * 创建应用格式校验
     * @param row
     * @param errMessage
     */
    public static void createAppFormatCell(Row row, StringBuilder errMessage) {
        for (int j = 0 ; j < row.getLastCellNum(); j++) {
            if (row.getCell(j) == null || row.getCell(j).getCellType() == Cell.CELL_TYPE_BLANK)continue;
            if(row.getCell(j).getCellType() != Cell.CELL_TYPE_STRING){
                for(IndexParameterMapping.CreateAppExcel batchExcel : IndexParameterMapping.CreateAppExcel.values()){
                    if(batchExcel.getCellNum() == j){
                        errMessage.append(batchExcel.getValue()+"格式不正确，请转换为文本格式！<br>");
                    }
                }
            }else{
                row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(j).setCellValue(row.getCell(j).getStringCellValue().trim());
            }
        }
    }

    /**
     * 中信商户批量签约
     * @param row
     * @param errMessage
     */
    public static void citicBatchRegisterFormatCell(Row row, StringBuilder errMessage) {
        for (int j = 0 ; j < row.getLastCellNum(); j++) {
            if (row.getCell(j) == null || row.getCell(j).getCellType() == Cell.CELL_TYPE_BLANK)continue;
            if(row.getCell(j).getCellType() != Cell.CELL_TYPE_STRING){
                for(IndexParameterMapping.CiticBatchRegisterExcel batchExcel : IndexParameterMapping.CiticBatchRegisterExcel.values()){
                    if(batchExcel.getCellNum() == j){
                        errMessage.append(batchExcel.getValue()+"格式不正确，请转换为文本格式！<br>");
                    }
                }
            }else{
                row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(j).setCellValue(row.getCell(j).getStringCellValue().trim());
            }
        }
    }

    /**
     * 创建联行号数据格式检查
     * @param row
     * @param errMessage
     */
    public static void createBranchFormatCell(Row row, StringBuilder errMessage) {
        for (int j = 0 ; j < row.getLastCellNum(); j++) {
            if (row.getCell(j) == null || row.getCell(j).getCellType() == Cell.CELL_TYPE_BLANK)continue;
            if(row.getCell(j).getCellType() != Cell.CELL_TYPE_STRING){
                for(IndexParameterMapping.BatchCreateBranchExcel branchExcel : IndexParameterMapping.BatchCreateBranchExcel.values()){
                    if(branchExcel.getCellNum() == j){
                        errMessage.append(branchExcel.getValue()+"格式不正确，请转换为文本格式！<br>");
                    }
                }
            }else{
                row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(j).setCellValue(row.getCell(j).getStringCellValue().trim());
            }
        }

    }

    /**
     * 商户入驻数据格式校验
     * @param row
     * @param errMessage
     */
    public static void registerFormatCell(Row row, StringBuilder errMessage) {
        for (int j = 0 ; j < row.getLastCellNum(); j++) {
           if (row.getCell(j) == null || row.getCell(j).getCellType() == Cell.CELL_TYPE_BLANK)continue;
           if(row.getCell(j).getCellType() != Cell.CELL_TYPE_STRING){
                for(IndexParameterMapping.RegisterExcel batchExcel : IndexParameterMapping.RegisterExcel.values()){
                    if(batchExcel.getCellNum() == j){
                        errMessage.append(batchExcel.getValue()+"格式不正确，请转换为文本格式！<br>");
                    }
                }
            }else{
                row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(j).setCellValue(row.getCell(j).getStringCellValue().trim());
            }
        }
    }

    /**
     * 民生批量入驻格式检查
     * @param row
     * @param errMessage
     */
    public static void cmbcBatchRegisterFormatCell(Row row, StringBuilder errMessage) {
        for (int j = 0 ; j < row.getLastCellNum(); j++) {
            if (row.getCell(j) == null || row.getCell(j).getCellType() == Cell.CELL_TYPE_BLANK)continue;
            if(row.getCell(j).getCellType() != Cell.CELL_TYPE_STRING){
                for(IndexParameterMapping.CmbcBatchRegisterExcel batchExcel : IndexParameterMapping.CmbcBatchRegisterExcel.values()){
                    if(batchExcel.getCellNum() == j){
                        errMessage.append(batchExcel.getValue()+"格式不正确，请转换为文本格式！<br>");
                    }
                }
            }else{
                row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(j).setCellValue(row.getCell(j).getStringCellValue().trim());
            }
        }
    }

    public static void wzBatchRegisterFormatCell(Row row, StringBuilder errMessage) {
        for (int j = 0 ; j < row.getLastCellNum(); j++) {
            if (row.getCell(j) == null || row.getCell(j).getCellType() == Cell.CELL_TYPE_BLANK)continue;
            if(row.getCell(j).getCellType() != Cell.CELL_TYPE_STRING){
                for(IndexParameterMapping.WzBatchRegisterExcel batchExcel : IndexParameterMapping.WzBatchRegisterExcel.values()){
                    if(batchExcel.getCellNum() == j){
                        errMessage.append(batchExcel.getValue()+"格式不正确，请转换为文本格式！<br>");
                    }
                }
            }else{
                row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(j).setCellValue(row.getCell(j).getStringCellValue().trim());
            }
        }
    }

    /**
     * 将读取表格过程产生的小数去掉
     * @param row
     * @param
     */
    public static void formatCell(Row row,StringBuilder errMessage,CellStyle cellStyle){

        for (int j = 0 ; j < row.getLastCellNum(); j++) {
            if (row.getCell(j) == null)continue;
            if(row.getCell(j).getCellType() == Cell.CELL_TYPE_BLANK)continue;
            if(j == IndexParameterMapping.excelNum.ZFB_PAY_TYPE_FEE_RATE.getCellNum()
                    || j == IndexParameterMapping.excelNum.WX_PAY_TYPE_FEE_RATE.getCellNum()){
                row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                DecimalFormat decimalFormat = new DecimalFormat("#.####");
                String cellString = row.getCell(j).getStringCellValue().trim();
                Double doubleVal = Double.parseDouble(cellString);
                decimalFormat.format(doubleVal);
                row.getCell(j).setCellValue(cellString);
            }else if(row.getCell(j).getCellType() != Cell.CELL_TYPE_STRING){
                row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(j).setCellStyle(cellStyle);
                errMessage.append("第"+(j+1)+"列格式不正确，请转换为文本格式！<br> ");
              /*  String cell =  getInt(row.getCell(j));
                row.getCell(j).setCellValue(cell);*/
            }else{
                row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(j).setCellValue(row.getCell(j).getStringCellValue().trim());
            }
        }
    }

    public static boolean isENumeric(String str){
        try {
            Double douable = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return  false;
        }

        Pattern pattern = Pattern.compile("^((-?\\d+.?\\d*)[Ee]?([-+]?\\d+))$");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

    /**
     * 将double 类型科学计数法数据 转换为整形数字符串
     * @param cell
     * @return
     */
    public static String getInt(Cell cell) {
       BigDecimal bigDecimal = new BigDecimal(cell.getStringCellValue());
       String cellString = bigDecimal.toPlainString();
        if(cellString.lastIndexOf(".")>0){
            return cellString.substring(0,cellString.lastIndexOf("."));
        }
        return cellString;
    }

    public static String getInt(String cell) {
        BigDecimal bigDecimal = new BigDecimal(cell);
        String cellString = bigDecimal.toPlainString();
        if(cellString.lastIndexOf(".")>0){
            return cellString.substring(0,cellString.lastIndexOf("."));
        }
        return cellString;
    }

    /**
     * 解决反馈表不能为中文问题
     * @param s
     * @return
     */
    public static String toUtf8String(String s){
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c >= 0 && c <= 255){sb.append(c);}
            else{
                byte[] b;
                try { b = Character.toString(c).getBytes("utf-8");}
                catch (Exception ex) {
                    System.out.println(ex);
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0) k += 256;
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }

    public static String getIntValue(String stringCellValue) {
       Integer d = (int)Double.parseDouble(stringCellValue);
        return d+""; //To change body of created methods use File | Settings | File Templates.
    }


    /**
     * 读取excel
     * @param classz
     * @param fileSrc
     * @return
     */
    public static <T> List<T> readAllExcelToList(T classz,String fileSrc){
        try {
            File file = new File(fileSrc);
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow headRow = sheet.getRow(0);
            List list = new ArrayList<>(sheet.getLastRowNum() + 1);
            if(sheet.getLastRowNum() < 1){
                return list;
            }
            for (int i = 1; i < sheet.getLastRowNum() + 1 ; i++){
                XSSFRow row = sheet.getRow(i);
                if(row == null)continue;
                T t = (T) classz.getClass().newInstance();
                for(int j = 0; j < row.getLastCellNum(); j++){
                    XSSFCell cellHeadFiled = headRow.getCell(j);
                    XSSFCell cellFiled = row.getCell(j);
                    if(cellHeadFiled == null || cellFiled == null){
                        continue;
                    }
                    String cellFiledName = null;
                    if(cellHeadFiled != null){
                        cellFiledName = cellHeadFiled.getRichStringCellValue().getString().split("\\|")[1];
                    }
                    cellFiled.setCellType(Cell.CELL_TYPE_STRING);
                    String cellFiledValue = String.valueOf(cellFiled.getRichStringCellValue());
                    setFiledValue(t, cellFiledName, cellFiledValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取excel
     * @param classz
     * @param dataRow
     * @param headRow
     * @return
     */
    public static <T> T readRowObject(T classz,XSSFRow dataRow,XSSFRow headRow){
        try {
            if(dataRow == null)return null;
            T t = (T) classz.getClass().newInstance();
            for(int j = 0; j < dataRow.getLastCellNum(); j++){
                XSSFCell cellHeadFiled = headRow.getCell(j);
                XSSFCell cellFiled = dataRow.getCell(j);
                if(cellHeadFiled == null || cellFiled == null){
                    continue;
                }
                String cellFiledName = null;
                if(cellHeadFiled != null){
                    cellFiledName = cellHeadFiled.getRichStringCellValue().getString().split("\\|")[1];
                }
                cellFiled.setCellType(Cell.CELL_TYPE_STRING);
                String cellFiledValue = String.valueOf(cellFiled.getRichStringCellValue());
                setFiledValue(t, cellFiledName, cellFiledValue);
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置字段值
     * @param object
     * @param excelFiledName
     * @param value
     */
    private static <T> void setFiledValue(T object,String excelFiledName,String value){
        Class classz = object.getClass();
        Field  field = null;
        try {
            field = classz.getDeclaredField(excelFiledName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        String filedName = field.getName();
        String orgFiledName = field.getType().getName();
        String filedTypeName = orgFiledName.toUpperCase();
        if(excelFiledName.equalsIgnoreCase(filedName)){
            field.setAccessible(true);
            try {
                if(filedTypeName.contains("INT")){
                    field.set(object, Integer.valueOf(value));
                }else if(filedTypeName.contains("DOUBLE")){
                    field.set(object, Double.valueOf(value));
                }else if(filedTypeName.contains("FLOAT")){
                    field.set(object, Float.valueOf(value));
                }else if(filedTypeName.contains("LONG")){
                    field.set(object, Long.valueOf(value));
                }else if(filedTypeName.contains("SHORT")){
                    field.set(object, Short.valueOf(value));
                }else if(filedTypeName.contains("BOOLEAN")){
                    field.set(object,Boolean.valueOf(value));
                }else {
                    field.set(object,value);
                }
            } catch (Exception e) {
                e.printStackTrace();
             }
        }
    }

    /**
     * 判断字符串是否为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        if(StringUtils.isEmpty(str)){
            return false;
        }
        try {
            Double.parseDouble(str);
        } catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    public static void main(String [] arg){
//        AddCiticParamsReq req = new AddCiticParamsReq();
//        List<AddCiticParamsReq> addCiticParamsReqs = CellDoubleToInt.readAllExcelToList(req,"C:\\Users\\ipaynow0929\\Desktop\\template\\citicBatchRegister.xlsx");
//        for (AddCiticParamsReq addCiticParamsReq : addCiticParamsReqs){
//            System.out.println(addCiticParamsReq.getMerchtFullNm());
//        }
    }
}
