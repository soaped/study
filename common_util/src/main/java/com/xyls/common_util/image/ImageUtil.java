package com.xyls.common_util.image;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class ImageUtil {
	
	public static final byte TYPE_AUTO=0;
	public static final byte TYPE_FIXED_WITH_AUTO=1;
	public static final byte TYPE_FIXED_WITH_HEIGHT=2;
	
	public static byte type;

	
	/**
	 * 图片缩放
	 * @param originalFile 原始图片
	 * @param resizedFile 目的图片
	 * @param newWidth 新的宽度
	 * @param newHeight 新的高度
	 * @param quality 生成图片质量
	 * @param type TYPE_AUTO,根据新的宽度自动调整宽度或高度。TYPE_FIXED_WITH_AUTO,根据新的宽度自动调整高度。TYPE_FIXED_WITH_HEIGHT,按照给定的宽度和高度缩放图片
	 * @throws IOException
	 */
	public static void resize(File originalFile, File resizedFile,
			int newWidth, int newHeight,float quality,byte type) throws IOException {

		if (quality > 1) {
			throw new IllegalArgumentException(
					"Quality has to be between 0 and 1");
		}

		ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
		Image i = ii.getImage();
		Image resizedImage = null;

		int iWidth = i.getWidth(null);
		int iHeight = i.getHeight(null);

		if(type==ImageUtil.TYPE_AUTO){
			if (iWidth > iHeight) {
				resizedImage = i.getScaledInstance(newWidth, (newWidth * iHeight)
						/ iWidth, Image.SCALE_SMOOTH);
			} else {
				resizedImage = i.getScaledInstance((newWidth * iWidth) / iHeight,
						newWidth, Image.SCALE_SMOOTH);
			}
		}else if(type==ImageUtil.TYPE_FIXED_WITH_AUTO){
			resizedImage = i.getScaledInstance(newWidth, (newWidth * iHeight)
					/ iWidth, Image.SCALE_SMOOTH);
		}else if(type==ImageUtil.TYPE_FIXED_WITH_HEIGHT){
			resizedImage = i.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		}
		

		// This code ensures that all the pixels in the image are loaded.
		Image temp = new ImageIcon(resizedImage).getImage();

		// Create the buffered image.
		BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),
				temp.getHeight(null), BufferedImage.TYPE_INT_RGB);

		// Copy image to buffered image.
		Graphics g = bufferedImage.createGraphics();

		// Clear background and paint the image.
		g.setColor(Color.white);
		g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
		g.drawImage(temp, 0, 0, null);
		g.dispose();

		// Soften.
		float softenFactor = 0.05f;
		float[] softenArray = { 0, softenFactor, 0, softenFactor,
				1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };
		Kernel kernel = new Kernel(3, 3, softenArray);
		ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		bufferedImage = cOp.filter(bufferedImage, null);
		
		
		
		String formatName = resizedFile.getName().substring(resizedFile.getName().lastIndexOf(".") + 1);
		
		
		ImageIO.write(bufferedImage, /*"GIF"*/ formatName /* format desired */ , resizedFile /* target */ );
	} // Example usage

	
	
	
	/**
	 * 给图片添加水印
	 *
	 * @param iconPath水印图片路径
	 * @param srcImgPath源图片路径
	 * @param targerPath目标图片路径
	 */
	public static void markImageByIcon(String iconPath, String srcImgPath,
			String targerPath) {
		markImageByIcon(iconPath, srcImgPath, targerPath, null);
	}

	/**
	 * 给图片添加水印、可设置水印图片旋转角度
	 *
	 * @param iconPath水印图片路径
	 * @param srcImgPath源图片路径
	 * @param targerPath目标图片路径
	 * @param degree水印图片旋转角度
	 */
	private static void markImageByIcon(String iconPath, String srcImgPath,
			String targerPath, Integer degree) {
		OutputStream os = null;
		try {
			Image srcImg = ImageIO.read(new File(srcImgPath));

			BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
					srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

			// 得到画笔对象
			// Graphics g= buffImg.getGraphics();
			Graphics2D g = buffImg.createGraphics();

			// 设置对线段的锯齿状边缘处理
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BILINEAR);

			g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg
					.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);

			if (null != degree) {
				// 设置水印旋转
				g.rotate(Math.toRadians(degree),
						(double) buffImg.getWidth() / 2, (double) buffImg
								.getHeight() / 2);
			}

			// 水印图象的路径 水印一般为gif或者png的，这样可设置透明度
			ImageIcon imgIcon = new ImageIcon(iconPath);

			// 得到Image对象。
			Image img = imgIcon.getImage();

			float alpha = 0.2f; // 透明度
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
					alpha));
			// 表示水印图片的位置
			g.drawImage(img, 0, srcImg.getHeight(null)-18, null);

			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

			g.dispose();

			os = new FileOutputStream(targerPath);

			// 生成图片
			ImageIO.write(buffImg, "JPG", os);

			System.out.println("图片完成添加Icon印章。。。。。。");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != os)
					os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	public static void ma1in(String[] args) throws IOException {

		String path = "F:\\workspace4\\test\\";
		int i = 0;
		
		
		if(i == 0){
			//缩放成x轴400像素
			for(String fileName:new File(path).list()){
				File originalImage = new File(path+fileName);
				if(originalImage.isDirectory()){
					continue;
				}
				File destImage = new File(path+"img\\"+fileName);
				resize(originalImage, destImage,400,0, 1f,ImageUtil.TYPE_FIXED_WITH_AUTO);
			}
		}
		if(i == 1){
			//缩放成360*200像素
			for(String fileName:new File(path).list()){
				File originalImage = new File(path+fileName);
				if(originalImage.isDirectory()){
					continue;
				}
				File destImage = new File(path+"fm\\"+fileName);
				resize(originalImage, destImage,360,200, 1f,ImageUtil.TYPE_FIXED_WITH_HEIGHT);
			}
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		String srcImgPath = "F:\\workspace4\\mydr\\mydr-wx\\src\\main\\webapp\\images\\ss.jpg";
		String destImgPath = "F:\\workspace4\\mydr\\mydr-wx\\src\\main\\webapp\\images\\sss.jpg";
//		String iconPath = "F:\\workspace4\\test\\img\\e.png";
//		String targerPath = "F:\\workspace4\\test\\img\\tttttt.jpg";
//		String targerPath2 = "d:/test/micmiu/img_mark_icon_rotate.jpg";

		ImageUtil.resize(new File(srcImgPath), new File(destImgPath), 400, 0,1f, TYPE_AUTO);
		
		// 给图片添加水印
//		ImageUtil.markImageByIcon(iconPath, srcImgPath, targerPath);
		// 给图片添加水印,水印旋转-45
//		ImageUtil.markImageByIcon(iconPath, srcImgPath, targerPath2,-45);
	}
}
