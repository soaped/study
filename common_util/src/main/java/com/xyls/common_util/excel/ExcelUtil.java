package com.xyls.common_util.excel;

import com.alibaba.dubbo.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.poi.POIXMLException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: ipaynow0929
 * Date: 17-3-30
 * Time: 下午4:26
 * To change this template use File | Settings | File Templates.
 */
public class ExcelUtil {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private String fileName;
    private List<String> header;
    private List<String> fieldNames;
    private List<Integer> cellTypes;
    private XSSFCellStyle headerFontStyle;//默认字体样式
    private XSSFCellStyle cellFontStyle;//默认字体样式

    /*
 * @param fileName 文件名
 * @pram  header   标题头行
 * @param fieldNames 导出字段名
 * @param cellTypes  导出字段输出类型
 * */
    public static ExcelUtil getInstance(String fileName, List<String> header, List<String> fieldNames, List<Integer> cellTypes) {
        ExcelUtil excelUtil = new ExcelUtil();
        excelUtil.init(fileName, header, fieldNames, cellTypes);
        return excelUtil;
    }

    /*
    * 初始化Excle信息
    * @param fileName 文件名
    * @pram  header   标题头行
    * @param fieldNames 导出字段名
    * @param cellTypes  导出字段输出类型
    * */
    private void init(String fileName, List<String> header, List<String> fieldNames, List<Integer> cellTypes) {

        this.fileName = fileName;
        this.fieldNames = fieldNames;
        this.cellTypes = cellTypes;
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
            sheet.setColumnWidth(i,header.get(i).getBytes().length*2*256);
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


    //将实体写入一行
    public void writeEntity(Object obj, int rowIndex) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (CollectionUtils.isEmpty(fieldNames) || CollectionUtils.isEmpty(cellTypes)) {
            return;
        }
        XSSFRow row = sheet.createRow(rowIndex);
        Cell cell = null;
        for (int i = 0; fieldNames.size() > i; i++) {
            String value = BeanUtils.getProperty(obj, fieldNames.get(i));
            Integer cellType = cellTypes.get(i);
            cell = row.createCell(i);
            writerCell(cell, value, cellType, cellFontStyle);
        }
    }


    /**
     * 判断是否为科学计数法
     * @param str
     * @return
     */
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
     * 读取整个excel表为集合
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
                    Cell cellHeadFiled = headRow.getCell(j);
                    Cell cellFiled = row.getCell(j);
                    if(cellHeadFiled == null || cellFiled == null){
                        continue;
                    }
                    String cellFiledName = null;
                    if(cellHeadFiled != null){
                        cellFiledName = cellHeadFiled.getRichStringCellValue().getString().split("\\|")[1];
                    }

//                    cellFiled.setCellType(Cell.CELL_TYPE_STRING);
                    String value = getCellStringValue(cellFiled, null);
//                    String cellFiledValue = String.valueOf(cellFiled.getRichStringCellValue());

                    setFiledValue(t, cellFiledName, value);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getCellStringValue(Cell cellFiled, FormulaEvaluator formulaEvaluator) {
        String value = null;
        System.out.print(cellFiled.getCellType());
        switch (cellFiled.getCellType()){
            case Cell.CELL_TYPE_STRING : {value = cellFiled.getStringCellValue().trim(); break;}
            case Cell.CELL_TYPE_BOOLEAN : {value = String.valueOf(cellFiled.getBooleanCellValue());break;}
            case Cell.CELL_TYPE_NUMERIC : {
                DecimalFormat df = new DecimalFormat("0");
                String strVal = df.format(cellFiled.getNumericCellValue());
                value = strVal;
                break;}
            case Cell.CELL_TYPE_FORMULA :
                {
                value = String.valueOf(cellFiled.getStringCellValue().trim().replaceAll("#N/A", "")); break;}
            default:value = "";
        }
        return value;  //To change body of created methods use File | Settings | File Templates.
    }

    private static String getString(String s){
        DecimalFormat df = new DecimalFormat("0");
        String strVal = df.format(new BigDecimal(s));
        return strVal;
    }

    /**
     * 设置字段值
     * @param object
     * @param excelFiledName
     * @param value
     */
    private static <T> void setFiledValue(T object,String excelFiledName,String value){
        Class classz = object.getClass();
        Field field = null;
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
     * 读取excel行转换为单个对象
     * @param classz
     * @param dataRow
     * @param headRow
     * @return
     */
    public static <T> T readRowObject(Class<T> classz,Row dataRow,Row headRow, FormulaEvaluator formulaEvaluator){
        try {
            if(dataRow == null)return null;
            T t = classz.newInstance();
            for(int j = 0; j < dataRow.getLastCellNum(); j++){
                Cell cellHeadFiled = headRow.getCell(j);
                Cell cellFiled = dataRow.getCell(j);
                if(cellHeadFiled == null || cellFiled == null){
                    continue;
                }
                String cellFiledName = null;
                if(cellHeadFiled != null){
                    cellHeadFiled.setCellType(Cell.CELL_TYPE_STRING);
                    cellFiledName = cellHeadFiled.getRichStringCellValue().getString().split("\\|")[1];
                }

                String cellFiledValue = getCellStringValue(cellFiled ,formulaEvaluator);

                setFiledValue(t, cellFiledName, cellFiledValue);
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    public static void main(String[] args) {
//        String data = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>  \n" +
//                "  <ss:Workbook xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\"> " +
//                "    <ss:Worksheet ss:Name=\"Sheet1\">  \n" +
//                "     <ss:Table ss:ExpandedColumnCount=\"2\" ss:ExpandedRowCount=\"3\" x:FullColumns=\"1\"  \n" +
//                "      x:FullRows=\"1\" ss:DefaultColumnWidth=\"54\" ss:DefaultRowHeight=\"16.5\">  \n" +
//                "      <ss:Row ss:AutoFitHeight=\"0\">  \n" +
//                "       <ss:Cell ss:StyleID=\"s23\"><ss:Data ss:Type=\"String\">商户名称</ss:Data></ss:Cell> "+
//                 "       <ss:Cell ss:StyleID=\"s23\"><ss:Data ss:Type=\"String\">年龄</ss:Data> </ss:Cell> \n" +
//                "      </ss:Row>  \n" +
//                "      <ss:Row ss:AutoFitHeight=\"0\">  \n" +
//                "       <ss:Cell><ss:Data ss:Type=\"String\">2</ss:Data></ss:Cell>  \n" +
//                "       <ss:Cell><ss:Data ss:Type=\"String\">bbb</ss:Data></ss:Cell>  \n" +
//                "      </ss:Row>  \n" +
//                "    </ss:Worksheet>  \n" +
//                "  </Workbook> ";
        List<ExcelTest> excelTests = new ArrayList<>();
        ExcelTest excelTest = new ExcelTest("张三","老三") ;
        excelTests.add(excelTest);
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File("C:\\Users\\ipaynow0929\\Desktop\\test.xls"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        responsExcel(outputStream,excelTests);
//            System.out.print(data);
    }



    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExcelCellName {
        public String cellName();
    }
    @Data
    @AllArgsConstructor
   static class ExcelTest{
        @ExcelCellName(cellName = "姓名")
        String name;

        @ExcelCellName(cellName = "小名")
        String sm;
    }

   private static final String EXCEL_HEAD = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>  \n" +
            "<ss:Workbook xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\">\n" +
            "<ss:Worksheet ss:Name=\"Sheet1\"><ss:Table>";

   private static final String EXCEL_END = "</ss:Table></ss:Worksheet></ss:Workbook>\n";


    /**
     * 将对象转换为xml字符串，将字符串以excel格式输出即可
     * @param objects
     * @return
     */
   public static String getExcelXmlString(List objects){
       if (CollectionUtils.isEmpty(objects)){
           return null;
       }
       Field[] headNames = objects.get(0).getClass().getDeclaredFields() ;
       //生成表头
       StringBuilder excelHead = new StringBuilder();
       //添加行
       excelHead.append("<ss:Row ss:AutoFitHeight=\"0\">");
       for (Field field : headNames){
           ExcelCellName excelCellName = field.getAnnotation(ExcelCellName.class);
           if (excelCellName == null)continue;
           //添加单元格
           excelHead.append("<ss:Cell><ss:Data ss:Type=\"String\">").append(excelCellName.cellName()).append("</ss:Data></ss:Cell>");
       }
       excelHead.append("</ss:Row> ");
       StringBuilder dataXml = new StringBuilder();
       dataXml.append(EXCEL_HEAD).append(excelHead.toString());
       for (Object obj : objects){
           dataXml.append("<ss:Row ss:AutoFitHeight=\"0\">");
           for (Field field : obj.getClass().getDeclaredFields()){
               ExcelCellName excelCellName = field.getAnnotation(ExcelCellName.class);
               if (excelCellName == null)continue;
               //添加行数据
               field.setAccessible(true);
               try {
                   dataXml.append("<ss:Cell ><ss:Data ss:Type=\"String\">").append(field.get(obj) == null ? "" : field.get(obj)).append("</ss:Data></ss:Cell>");
               } catch (IllegalAccessException e) {
                   e.printStackTrace();
               }
           }
           dataXml.append("</ss:Row> ");
       }
       //添加表格结束标识
       dataXml.append(EXCEL_END);
       return dataXml.toString();
   }



    public static void responsExcel(OutputStream outputStream, List dataList) {
        String xmlExcel = getExcelXmlString(dataList);
        if (StringUtils.isNotEmpty(xmlExcel)){
            try {
                outputStream.write(xmlExcel.getBytes(), 0, xmlExcel.getBytes().length);
                outputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }















    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------




    public static void makeWorkBook(List<String> header,List<Object> objs,OutputStream  outputStream) throws IOException {


         Map<Integer,String> indexFieldNameMap = new HashMap<>();
         int index = 0;
         for(Field field : objs.get(0).getClass().getDeclaredFields()) {
             CelIndex celIndex = field.getAnnotation(CelIndex.class);
             if(celIndex == null) continue;
             indexFieldNameMap.put(celIndex.index(),field.getName());
             index ++;
         }
        for(Field field : objs.get(0).getClass().getDeclaredFields()) {
            CelIndex celIndex = field.getAnnotation(CelIndex.class);
            if(celIndex != null) continue;
            indexFieldNameMap.put(index++,field.getName());
        }

         XSSFWorkbook workbook = new XSSFWorkbook();

         XSSFSheet sheet = getXSSFSheet(workbook);
         XSSFCellStyle headerFontStyle = getHeadFontStyle(workbook);
         XSSFCellStyle cellFontStyle = getXSSFCellStyle(workbook);


         //写header
         XSSFRow xssfRow = sheet.createRow(0);
         for (int i = 0; header.size() > i; i++) {
             sheet.setColumnWidth(i,header.get(i).getBytes().length*2*256);
             Cell cell = xssfRow.createCell(i);
             setCell(cell, header.get(i), HSSFCell.CELL_TYPE_STRING, headerFontStyle);
         }

         //写每行
         for(int i = 1 ;i <= objs.size(); i++){
             Object o = objs.get(i - 1);
             setRow(o,i,cellFontStyle,sheet,indexFieldNameMap);
         }

         workbook.write(outputStream);
     }



     private static XSSFSheet getXSSFSheet(XSSFWorkbook workbook){
         XSSFSheet sheet = workbook.createSheet("sheet1");
         sheet.setVerticallyCenter(true);
         sheet.setHorizontallyCenter(true);
         return sheet;
     }

     private static XSSFCellStyle getHeadFontStyle(XSSFWorkbook workbook){
         XSSFCellStyle headerFontStyle = workbook.createCellStyle();
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
         return headerFontStyle;
     }

     private static XSSFCellStyle getXSSFCellStyle(XSSFWorkbook workbook){
         XSSFCellStyle cellFontStyle = workbook.createCellStyle();
         cellFontStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
         XSSFFont font = workbook.createFont();
         font = workbook.createFont();
         font.setColor(HSSFColor.BLACK.index);
         font.setFontHeightInPoints((short) 12);
         font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
         cellFontStyle.setFont(font);
         cellFontStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
         cellFontStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
         cellFontStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
         cellFontStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
         return cellFontStyle;
     }

    private static void setRow(Object obj, int rowIndex,XSSFCellStyle cellFontStyle,XSSFSheet xssfSheet,Map<Integer,String> indexFieldNameMap){

        XSSFRow row = xssfSheet.createRow(rowIndex);
        Cell cell = null;
        for(Integer index : indexFieldNameMap.keySet()){
            String value = null;
            try {
                value = BeanUtils.getProperty(obj, indexFieldNameMap.get(index));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            cell = row.createCell(index);
            setCell(cell, value, HSSFCell.CELL_TYPE_STRING, cellFontStyle);
        }
    }

    private static void setCell(Cell cell, String value, Integer cellType, XSSFCellStyle style) {
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



    public static class GetWorkBookException extends Exception{

        public GetWorkBookException(String errMsg) {
            this.errMsg = errMsg;
        }
        private String errMsg;

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }
    }
    /**
     * excel文件映射进对象，可以这样使用
     *
     *
     * @AllArgsConstructor
     @NoArgsConstructor
     @Setter
     @Getter
     public static class CardBinExcelObject{
     @ExcelUtil.CelIndex(0)
     private String bankNameCardIssuerCode;

     @ExcelUtil.CelIndex(1)
     private String cardName;

     @ExcelUtil.CelIndex(8)
     private Integer mainAccountLength;

     @ExcelUtil.CelIndex(9)
     private String mainAccount;

     @ExcelUtil.CelIndex(12)
     private Integer cardBinLength;

     @ExcelUtil.CelIndex(13)
     private String cardBin;

     @ExcelUtil.CelIndex(15)
     private String cardType;
     }


     *
     * List<CardBinExcelObject> cardBinExcelObjectList = ExcelUtil.getWorkBook(
     addCardBinSimpleReq.getFile(),
     0,
     4,
     CardBinExcelObject.class);
     */

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CelIndex {
        int index();
        boolean nullAble() default true;
        String valueIn() default "";
    }


    private static Workbook getWorkbook(InputStream is) throws GetWorkBookException {

        //inputStream重复使用
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        try {
            while ((len = is.read(buffer)) > -1 ) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Workbook workbook = null;
        try {
//            workbook = new HSSFWorkbook(is);
            //首先尝试处理2007版本
            workbook = new XSSFWorkbook(new ByteArrayInputStream(baos.toByteArray()));
        } catch (IOException e) {
            throw new GetWorkBookException("io exception , " + e.toString());
        } catch (OfficeXmlFileException e){
            //使用HSSFWorkbook的方式处理2007版
            try {
                workbook = new XSSFWorkbook(new ByteArrayInputStream(baos.toByteArray()));
            } catch (IOException e1) {
                throw new GetWorkBookException("io exception , " + e1.toString());
            }
        } catch (POIXMLException e){
            //使用XSSFWorkbook的方式处理2003版
            try {
                workbook = new HSSFWorkbook(new ByteArrayInputStream(baos.toByteArray()));
            } catch (IOException e1) {
                throw new GetWorkBookException("io exception , " + e1.toString());
            }
        }
        return workbook;
    }

    public static <T> List<T> getWorkBook(MultipartFile file, int sheetIndex, int startRowIndex, Integer rowCount,Class<T> clz) throws GetWorkBookException {
        CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile)file;
        File f = ((DiskFileItem)commonsMultipartFile.getFileItem()).getStoreLocation();
        return getWorkBook(f,sheetIndex,startRowIndex,rowCount,clz);
    }
    public static <T> List<T> getWorkBook(File file,int sheetIndex,int startRowIndex, Integer rowCount,Class<T> clz) throws GetWorkBookException {
        try {
            return getWorkBook(new FileInputStream(file),sheetIndex,startRowIndex,rowCount,clz);
        } catch (FileNotFoundException e) {
            throw new GetWorkBookException("无法获取文件, " + file);
        }
    }
    public static <T> List<T> getWorkBook(InputStream is,int sheetIndex,int startRowIndex, Integer rowCount,Class<T> clz) throws GetWorkBookException {
        Workbook workbook = getWorkbook(is);
        List<T> list = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        for(int i = startRowIndex ;i <= (rowCount == null ?sheet.getLastRowNum():startRowIndex + rowCount - 1) ; i++){
            T t = null;
            try {
                t = clz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
            Row h = sheet.getRow(i);
            for(Field field : clz.getDeclaredFields()){
                CelIndex celIndex = field.getAnnotation(CelIndex.class);
                if(celIndex == null) continue;
                field.setAccessible(true);

                try{
                    if(h.getCell(celIndex.index()) == null){
                        throw new GetWorkBookException("excel表格没有相关列");
                    }
                    if(!celIndex.nullAble() && StringUtils.isEmpty(h.getCell(celIndex.index()).getStringCellValue())){
                        throw new GetWorkBookException("excel表格相关列不能为空");
                    }
                    if(StringUtils.isNotEmpty(celIndex.valueIn()) && StringUtils.isNotEmpty(h.getCell(celIndex.index()).getStringCellValue()) &&
                            !Arrays.asList(celIndex.valueIn().split(",")).contains(h.getCell(celIndex.index()).getStringCellValue())){
                        throw new GetWorkBookException("excel表格相关列的值不在"+celIndex.valueIn()+"范围内");
                    }
                    if(h.getCell(celIndex.index()).getStringCellValue().trim().equals("")){
                        continue;
                    }

                    if(field.getGenericType().toString().contains("java.lang.Integer") || field.getGenericType().toString().equals("int")){
                        field.set(t, Integer.valueOf(h.getCell(celIndex.index()).getStringCellValue()));
                    }else if(field.getGenericType().toString().contains("java.lang.Double") || field.getGenericType().toString().equals("double")){
                        field.set(t, Double.valueOf(h.getCell(celIndex.index()).getStringCellValue()));
                    }else if(field.getGenericType().toString().contains("java.lang.Float") || field.getGenericType().toString().equals("float")){
                        field.set(t, Float.valueOf(h.getCell(celIndex.index()).getStringCellValue()));
                    }else if(field.getGenericType().toString().contains("java.lang.Long") || field.getGenericType().toString().equals("long")){
                        field.set(t, Long.valueOf(h.getCell(celIndex.index()).getStringCellValue()));
                    }else if(field.getGenericType().toString().contains("java.lang.Short")|| field.getGenericType().toString().equals("short") ){
                        field.set(t, Short.valueOf(h.getCell(celIndex.index()).getStringCellValue()));
                    }else if(field.getGenericType().toString().contains("java.lang.Boolean") || field.getGenericType().toString().equals("boolean")){
                        field.set(t,Boolean.valueOf(h.getCell(celIndex.index()).getStringCellValue()));
                    }else {
                        field.set(t,h.getCell(celIndex.index()).getStringCellValue());
                    }
                } catch (NumberFormatException e){
                    throw new GetWorkBookException("excel表格数据类型错误 : rowIndex = " + i + " , cellIndex = " + celIndex.index());
                } catch (Exception e) {
                    if(e instanceof GetWorkBookException){
                        throw new GetWorkBookException("其他错误 : " + ((GetWorkBookException)e).getErrMsg() + "rowIndex = " + i + " , cellIndex = " + celIndex.index());
                    }else{
                        throw new GetWorkBookException("其他错误 : " + e.getMessage() + "rowIndex = " + i + " , cellIndex = " + celIndex.index());
                    }

                }
            }
            list.add(t);
        }
        return list;
    }







    public static String[][] getWorkBook(MultipartFile file, int sheetIndex) throws GetWorkBookException {
        CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile)file;
        File f = ((DiskFileItem)commonsMultipartFile.getFileItem()).getStoreLocation();
        return getWorkBook(f,sheetIndex);
    }
    public static String[][] getWorkBook(File file,int sheetIndex) throws GetWorkBookException {
        try {
            return getWorkBook(new FileInputStream(file),sheetIndex);
        } catch (FileNotFoundException e) {
            throw new GetWorkBookException("can not file fount , " + file);
        }
    }

    public static String[][] getWorkBook(InputStream is,int sheetIndex) throws GetWorkBookException {
        Workbook workbook = getWorkbook(is);

        Sheet sheet = workbook.getSheetAt(sheetIndex);
        int rowCount = sheet.getLastRowNum() + 1;
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        String [][] result = new String[rowCount][colCount];
        for(int i = 0 ;i < rowCount ; i++){
            Row row = sheet.getRow(i);
            for(int j = 0 ;j < colCount;j++){
                String value;
                switch (row.getCell(j).getCellType()) {
                    case Cell.CELL_TYPE_STRING: {
                        value = row.getCell(j).getStringCellValue();
                        break;
                    }
                    case Cell.CELL_TYPE_BOOLEAN: {
                        value = String.valueOf(row.getCell(j).getBooleanCellValue());
                        break;
                    }
                    case Cell.CELL_TYPE_NUMERIC: {
                        DecimalFormat df = new DecimalFormat("0");
                        String strVal = df.format(row.getCell(j).getNumericCellValue());
                        value = strVal;
                        break;
                    }
                    case Cell.CELL_TYPE_FORMULA: {
                        value = String.valueOf(row.getCell(j).getStringCellValue().trim().replaceAll("#N/A", ""));
                        break;
                    }
                    default:
                        value = "";
                }
//                row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                result[i][j] = value;
            }
        }
        return result;
    }








    @Getter
    @Setter
    public static class TestReadXml {
        @ExcelUtil.CelIndex(index = 0)
        private String a1;
        @ExcelUtil.CelIndex(index = 1)
        private String a2;
        @ExcelUtil.CelIndex(index = 2)
        private String a3;
//        @ExcelUtil.CelIndex(3)
//        private String a4;
//        @ExcelUtil.CelIndex(4)
//        private String a5;
//        @ExcelUtil.CelIndex(5)
//        private String a6;
//        @ExcelUtil.CelIndex(6)
//        private String a7;
//        @ExcelUtil.CelIndex(7)
//        private String a8;
//        @ExcelUtil.CelIndex(8)
//        private String a9;
//        @ExcelUtil.CelIndex(9)
//        private String a10;
//
//        @ExcelUtil.CelIndex(10)
//        private String a11;
//        @ExcelUtil.CelIndex(11)
//        private String a12;
//        @ExcelUtil.CelIndex(12)
//        private String a13;
//        @ExcelUtil.CelIndex(13)
//        private String a14;
//        @ExcelUtil.CelIndex(14)
//        private String a15;
//        @ExcelUtil.CelIndex(15)
//        private String a16;
//        @ExcelUtil.CelIndex(16)
//        private String a17;
//        @ExcelUtil.CelIndex(17)
//        private String a18;
//        @ExcelUtil.CelIndex(18)
//        private String a19;
//        @ExcelUtil.CelIndex(19)
//        private String a20;
//        @ExcelUtil.CelIndex(20)
//        private String a21;

    }














//    public static void main(String [] args) throws IOException {
//        List<TestReadXml> testReadXmls = null;
////        try {
////            testReadXmls = ExcelUtil.getWorkBook(
////                    new File("d:\\2.xls"),
////                    0,
////                    1,
////                    null,
////                    TestReadXml.class);
////        } catch (GetWorkBookException e) {
////            System.out.println(e.getErrMsg());
////        }
////        if(testReadXmls != null) {
////            System.out.println(testReadXmls.size());
////            System.out.println(testReadXmls.get(0).a20);
////            System.out.println(testReadXmls.get(0).a21);
////        }
//
//
////        try {
////            ExcelUtil.getWorkBook(new File("d:\\2.xls"),0);
////        } catch (GetWorkBookException e) {
////            System.out.println(e.getErrMsg());
////        }
//
//
//        TestReadXml testReadXml = new TestReadXml();
//        testReadXml.setA1("a1");
//        testReadXml.setA2("a2");
//        testReadXml.setA3("a3");
//
//        TestReadXml testReadXml1 = new TestReadXml();
//        testReadXml1.setA1("a11");
//        testReadXml1.setA2("a22");
//        testReadXml1.setA3("a33");
//
//        List<Object> testReadXmlList = new ArrayList<>();
//        testReadXmlList.add(testReadXml);
//        testReadXmlList.add(testReadXml1);
//
//
//        List<String> headers = new ArrayList<>();
//        headers.add("一");
//        headers.add("二");
//        headers.add("三");
//        OutputStream outputStream = new FileOutputStream("d://abc.xlsx");
//        ExcelUtil.makeWorkBook(headers,testReadXmlList,outputStream);
//        outputStream.flush();
//        outputStream.close();
//
//    }
}
