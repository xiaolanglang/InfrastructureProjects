package com.bkweb.common.utils.swf;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConvertToSwf {

	Log log = LogFactory.getLog(ConvertToSwf.class);
	private final String CONVERTFILETYPE = "pdf,jpg,jpeg,font,gif,png,wav";
	private String swftoolsPath;

	/**
	 * @param swftoolsPath
	 *            用于进行把文件转化为swf的工具地址
	 */
	public ConvertToSwf(String swftoolsPath) {
		this.swftoolsPath = swftoolsPath;
	}

	/**
	 * 把文件转化为swf格式支持"pdf,jpg,jpeg,font,gif,png,wav"
	 * 
	 * @param sourceFilePath
	 *            要进行转化为swf文件的地址
	 * @param swfFilePath
	 *            转化后的swf的文件地址
	 * @return
	 */
	public boolean convertFileToSwf(String sourceFilePath, String swfFilePath) {
		log.info("开始转化文件到swf格式");
		if (swftoolsPath == null || swftoolsPath == "") {
			if (log.isWarnEnabled()) {
				log.warn("未指定要进行swf转化工具的地址！！！");
			}
			return false;
		}
		String filetype = sourceFilePath.substring(sourceFilePath.lastIndexOf(".") + 1);
		// 判读上传文件类型是否符合转换为pdf
		log.info("判断文件类型通过");
		if (CONVERTFILETYPE.indexOf(filetype.toLowerCase()) == -1) {
			if (log.isWarnEnabled()) {
				log.warn("当前文件不符合要转化为SWF的文件类型！！！");
			}
			return false;
		}
		File sourceFile = new File(sourceFilePath);

		if (!sourceFile.exists()) {
			if (log.isWarnEnabled()) {
				log.warn("要进行swf的文件不存在！！！");
			}
			return false;
		}
		log.info("准备转换的文件路径存在");
		if (!swftoolsPath.endsWith(File.separator)) {
			swftoolsPath += File.separator;
		}
//		StringBuilder commandBuidler = new StringBuilder(swftoolsPath);
		File swfFile = new File(swfFilePath);
		if (!swfFile.getParentFile().exists()) {
			swfFile.getParentFile().mkdirs();
		}
		if (filetype.toLowerCase().equals("jpg")) {
			filetype = "jpeg";
		}
		List<String> command = new ArrayList<String>();
		command.add(this.swftoolsPath + "\\" + filetype.toLowerCase() + "2swf.exe");// 从配置文件里读取
		command.add("-z");
		command.add("-s");
		command.add("flashversion=9");
		command.add("-s");
		command.add("poly2bitmap");// 加入poly2bitmap的目的是为了防止出现大文件或图形过多的文件转换时的出错，没有生成swf文件的异常
		command.add(sourceFilePath);
		command.add("-o");
		command.add(swfFilePath);
		try {
			ProcessBuilder processBuilder = new ProcessBuilder();
			processBuilder.command(command);
			Process process = processBuilder.start();
			log.info("开始生成swf文件..");
			dealWith(process);
			try {
				process.waitFor();// 等待子进程的结束，子进程就是系统调用文件转换这个新进程
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			File swf = new File(swfFilePath);
			if (!swf.exists()) {
				return false;
			}
			log.info("转化SWF文件成功!!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("转化为SWF文件失败!!!");
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		ConvertToSwf a = new ConvertToSwf("C:\\Users\\Administrator\\Desktop\\SWFTools");
		a.convertFileToSwf("C:\\Users\\Administrator\\Desktop\\p.pdf", "C:\\Users\\Administrator\\Desktop\\p.swf");
	}

	private void dealWith(final Process pro) {
		// 下面是处理堵塞的情况
		try {
			new Thread() {
				public void run() {
					BufferedReader br1 = new BufferedReader(new InputStreamReader(pro.getInputStream()));
					String text;
					try {
						while ((text = br1.readLine()) != null) {
							System.out.println(text);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			new Thread() {
				public void run() {
					BufferedReader br2 = new BufferedReader(new InputStreamReader(pro.getErrorStream()));// 这定不要忘记处理出理时产生的信息，不然会堵塞不前的
					String text;
					try {
						while ((text = br2.readLine()) != null) {
							System.err.println(text);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
