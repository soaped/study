package com.yangfuzhao.common.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public final class QRCode {

    
    private static final int BLACK = 0xff000000;
    private static final int WHITE = 0xFFFFFFFF;
    
    
    /**
     * @Title: generate
     * @Description: 生成二维码
     * @param name
     *            二维码图片名称
     * @param params
     *            二维码信息
     * @param path
     *            二维码图片存放目录
     * @throws Exception
     */
    public static void generate(String name,String ext, String params, String path,int width,int height) throws Exception {

        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        path = path.concat(name.concat("."+ext));

        file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }

        BitMatrix bitMatrix = new MultiFormatWriter().encode(params,BarcodeFormat.QR_CODE, width, height);
        BufferedImage image = toBufferedImage(bitMatrix);
        ImageIO.write(image, ext, file);
    }


    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) == true ? BLACK : WHITE);
            }
        }
        return image;
    }
    
    
}