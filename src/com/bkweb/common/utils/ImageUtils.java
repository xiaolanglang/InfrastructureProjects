package com.bkweb.common.utils;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.junit.Test;

public class ImageUtils {
	/**
	 * 按比例缩小图片的宽高
	 * 
	 * @param image2
	 *            上传的图片的输入流
	 * @param os
	 *            改变了图片的大小后，把图片的流输出到目标OutputStream
	 * @param heightSize
	 *            新图片的宽
	 * @param format
	 *            新图片的格式
	 * @throws IOException
	 */
	public static void scaling(BufferedImage prevImage, OutputStream os, double percent, String format)
			throws IOException {
		double width = prevImage.getWidth();
		double height = prevImage.getHeight();
		int newWidth = (int) (width * percent);
		int newHeight = (int) (height * percent);
		BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);
		Graphics graphics = image.createGraphics();
		graphics.drawImage(prevImage, 0, 0, newWidth, newHeight, null);
		ImageIO.write(image, format, os);
		if (os != null) {
			os.flush();
			os.close();
		}
		if (image != null) {
			image.flush();
		}
	}

	/**
	 * 缩小到最接近目标的宽高
	 * 
	 * @param srcPath
	 *            源文件<br>
	 *            例如C:\\Users\\Administrator\\Desktop\\img\\1.jpeg
	 * @param targetPath
	 *            生成文件绝对路径<br>
	 *            例如C:\\Users\\Administrator\\Desktop\\img\\2.jpeg
	 * @param targetWidth
	 *            目标宽度
	 * @param targetHeight
	 *            目标高度
	 */
	public static void scaling(String srcPath, String targetPath, double targetWidth, double targetHeight) {
		FileInputStream fileInputStream = null;
		FileOutputStream os = null;
		BufferedImage image = null;

		try {
			fileInputStream = new FileInputStream(srcPath);
			os = new FileOutputStream(targetPath);
			image = ImageIO.read(fileInputStream);

			int imgWidth = image.getWidth();
			int imgHeight = image.getHeight();
			double heightSize = targetHeight / imgHeight;
			double widthSize = targetWidth / imgWidth;

			int sufHeight = (int) (widthSize * imgHeight);
			int sufWidth = (int) (heightSize * imgWidth);
			if (sufHeight >= targetHeight) {
				scaling(image, os, widthSize,
						targetPath.substring(targetPath.lastIndexOf(".") + 1, targetPath.length()));
			} else if (sufWidth >= targetWidth) {
				scaling(image, os, heightSize,
						targetPath.substring(targetPath.lastIndexOf(".") + 1, targetPath.length()));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.flush();
					os.close();
				}
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * 对图片进行裁剪
	 * 
	 * @param srcpath
	 *            源文件
	 * @param subpath
	 *            生成文件
	 * @param x
	 *            裁剪X轴起始位置
	 * @param y
	 *            裁剪Y轴起始位置
	 * @param width
	 *            裁剪宽度
	 * @param height
	 *            裁剪高度
	 * @throws IOException
	 */
	public static void cut(String srcpath, String subpath, int x, int y, int width, int height) throws IOException {
		FileInputStream is = null;
		ImageInputStream iis = null;
		try {
			// 读取图片文件
			is = new FileInputStream(srcpath);

			/**
			 * 
			 * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader
			 * 
			 * 声称能够解码指定格式。 参数：formatName - 包含非正式格式名称 .
			 * 
			 * (例如 "jpeg" 或 "tiff")等 。
			 */
			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(srcpath.substring(
					srcpath.lastIndexOf(".") + 1, srcpath.length()));

			ImageReader reader = it.next();

			// 获取图片流
			iis = ImageIO.createImageInputStream(is);

			/**
			 * 
			 * <p>
			 * iis:读取源。true:只向前搜索
			 * </p>
			 * .将它标记为 ‘只向前搜索’。
			 * 
			 * 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader
			 * 
			 * 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
			 */
			reader.setInput(iis, true);

			/**
			 * 
			 * <p>
			 * 描述如何对流进行解码的类
			 * <p>
			 * .用于指定如何在输入时从 Java Image I/O
			 * 
			 * 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件
			 * 
			 * 将从其 ImageReader 实现的 getDefaultReadParam 方法中返回
			 * 
			 * ImageReadParam 的实例。
			 */
			ImageReadParam param = reader.getDefaultReadParam();

			/**
			 * 
			 * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
			 * 
			 * 的左上顶点的坐标(x，y)、宽度和高度可以定义这个区域。
			 */
			Rectangle rect = new Rectangle(x, y, width, height);

			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);

			/**
			 * 
			 * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将
			 * 
			 * 它作为一个完整的 BufferedImage 返回。
			 */
			BufferedImage bi = reader.read(0, param);

			// 保存新图片
			ImageIO.write(bi, subpath.substring(subpath.lastIndexOf(".") + 1, subpath.length()), new File(subpath));
		} finally {
			if (is != null) {
				is.close();
			}
			if (iis != null) {
				iis.close();
			}
		}

	}

	/**
	 * 剪切图片的中间部分
	 * 
	 * @param filePath
	 * @param newFilePath
	 * @param width
	 * @param height
	 */
	public static void cutCenter(String filePath, String newFilePath, int width, int height) {
		// ===剪切点x坐标
		int x = 0;
		int y = 0;
		BufferedImage image = null;
		FileInputStream fileInputStream = null;

		try {
			fileInputStream = new FileInputStream(filePath);
			image = ImageIO.read(fileInputStream);
			int mWidth = image.getWidth();
			int mHeight = image.getHeight();
			x = (mWidth - width) / 2;
			y = (mHeight - height) / 2;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (image != null) {
					image.flush();
				}
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			cut(filePath, newFilePath, x, y, width, height);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 检查图片大小
	 * 
	 * @param file
	 * @param width
	 * @param height
	 * @return 检查通过返回true,不通过返回false
	 */
	public static boolean checkImage(File file, int width, int height) {
		InputStream inputStream = null;
		boolean flag = false;
		try {
			inputStream = new FileInputStream(file);
			BufferedImage sourceImg = ImageIO.read(inputStream);
			int imgWidth = sourceImg.getWidth();
			int mgHeight = sourceImg.getHeight();
			if (imgWidth == width && mgHeight == height) {
				flag = true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	@Test
	public void testResize() {
		String srcPath = "C:\\Users\\Administrator\\Desktop\\img\\20140616121356_4xeMr.jpeg";
		String targetPath = "C:\\Users\\Administrator\\Desktop\\img\\1.png";
		scaling(srcPath, targetPath, 640, 225);

	}

	@Test
	public void testCutCenter() {
		String srcPath = "C:\\Users\\Administrator\\Desktop\\img\\1.png";
		String targetPath = "C:\\Users\\Administrator\\Desktop\\img\\2.png";
		cutCenter(srcPath, targetPath, 640, 225);

	}
}
