package com;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Log4jConfigurer;

import com.bkweb.common.utils.FileUtils;
import com.bkweb.common.utils.IdUtils;
import com.bkweb.common.utils.ImageUtils;

public class ImageTest {

	@Before
	public void before() {
		try {
			Log4jConfigurer.initLogging("classpath:testconfig/log4j.properties");
		} catch (FileNotFoundException ex) {
			System.err.println("Cannot Initialize log4j");
		}
	}

	@Test
	public void test() throws IOException {
		Integer[] index = { 640, 225 };
		Integer[] sort = { 320, 220 };
		Integer[] order = { 600, 250 };
		Integer[] search = { 200, 200 };
		String source = "C:\\Users\\Administrator\\Desktop\\img\\source";
		// String source = "F:\\工作记录\\笔记\\bk\\app缓存图片\\";
		List<File> fileList = FileUtils.getFiles(source, null);
		List<Integer[]> sizeList = new ArrayList<Integer[]>();
		sizeList.add(index);
		sizeList.add(sort);
		sizeList.add(order);
		sizeList.add(search);

		System.out.println("----共找到" + fileList.size() + "个文件----");
		System.out.println("----开始遍历文件----");
		for (File file : fileList) {
			FileInputStream fileInputStream = new FileInputStream(file);
			BufferedImage image = ImageIO.read(fileInputStream);
			fileInputStream.close();
			int width = image.getWidth();
			int height = image.getHeight();
			String fileName = IdUtils.uuid();
			String fileExt = file.getName().substring(file.getName().lastIndexOf("."));

			for (Integer[] size : sizeList) {
				String targetPath = "C:\\Users\\Administrator\\Desktop\\img\\" + size[0] + "-" + size[1] + "\\"
						+ fileName + fileExt;
				String targetPathTemp = "C:\\Users\\Administrator\\Desktop\\img\\" + size[0] + "-" + size[1]
						+ "\\temp\\" + fileName + fileExt;
				if (size[0] == width && size[1] == height) {
					System.out.println("-----发现一个符合尺寸的----------");
					FileUtils.copyFileCover(file.getAbsolutePath(), targetPath, true);
				} else {
					if (size[0] <= width && size[1] <= height) {
						FileUtils.createDirectory(targetPathTemp);
						ImageUtils.scaling(file.getAbsolutePath(), targetPathTemp, size[0], size[1]);
						ImageUtils.cutCenter(targetPathTemp, targetPath, size[0], size[1]);
						System.out.println("-----图片已经缩放并且裁剪--------");
					}
				}
			}
		}
		System.out.println("----所有的文件已经遍历完毕--------");
	}
}
