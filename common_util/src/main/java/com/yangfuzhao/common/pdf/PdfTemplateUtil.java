package com.yangfuzhao.common.pdf;

import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ipaynow0712 on 2017/6/13.
 */
public class PdfTemplateUtil {

    public static void main(String[] args) throws Exception {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("openCmbc_1","On");


        byte[] b = PdfTemplateUtil.createNewPdf("D:\\下载 (2).pdf", paramMap);
        FileOutputStream f = new FileOutputStream("d:/test222.pdf");
        f.write(b);
        f.flush();;
        f.close();

    }

    public static File createNewPdf(String templatePDF, String outFile, Map<String, String> hashMap) throws Exception {
        PdfReader reader = null;
        FileOutputStream fos = null;
        ByteArrayOutputStream bos = null;
        PdfStamper stamp = null;
        try {
            reader = new PdfReader(templatePDF);
            fos = new FileOutputStream(outFile);
            bos = new ByteArrayOutputStream();
            stamp = new PdfStamper(reader, bos);
            AcroFields form = stamp.getAcroFields();
            Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
                    BaseFont.NOT_EMBEDDED);
            for (Map.Entry<String, String> entry : entrySet) {
                form.setFieldProperty(entry.getKey(), "textfont", bf, null); //设置中文格式
                form.setField(entry.getKey(), entry.getValue(),true);
            }
            stamp.setFormFlattening(true);
            stamp.close();
            reader.close();
            fos.write(bos.toByteArray());
            fos.flush();
            fos.close();
            bos.close();
            return new File(outFile);
        } finally {
            if (stamp != null) {
                stamp.close();
            }
            if (reader != null) {
                reader.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
    }


    public static byte[] createNewPdf(String templatePDF, Map<String, String> hashMap) throws Exception {
        PdfReader reader = null;
        ByteArrayOutputStream bos = null;
        PdfStamper stamp = null;
        try {
            reader = new PdfReader(templatePDF);
            bos = new ByteArrayOutputStream();
            stamp = new PdfStamper(reader, bos);
            AcroFields form = stamp.getAcroFields();
            Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
                    BaseFont.NOT_EMBEDDED);
            for (Map.Entry<String, String> entry : entrySet) {
                form.setFieldProperty(entry.getKey(), "textfont", bf, null); //设置中文格式
                //保留appearance
                form.setField(entry.getKey(), entry.getValue(),true);
            }
            stamp.setFormFlattening(true);
            stamp.close();
            reader.close();
            return bos.toByteArray();
        } finally {
            if (stamp != null) {
                stamp.close();
            }
            if (reader != null) {
                reader.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
    }

}
