package com.bkweb.modules.menu.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.common.utils.FileUploadUtils;
import com.bkweb.common.utils.FileUtils;
import com.bkweb.common.utils.IdUtils;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.modules.menu.dao.MenuFindDao;
import com.bkweb.modules.menu.entity.MenuFind;

@Service
@Transactional(readOnly = true)
public class MenuFindService extends CrudService<MenuFindDao, MenuFind> {

	@Transactional(readOnly = false)
	public boolean save(HttpServletRequest request, MenuFind menuFind) {
		File file = FileUploadUtils.upload(request, FileUploadUtils.getDefaultImgLocalUrl(), IdUtils.uuid());
		if (file != null) {
			if (!checkImage(file)) {
				FileUtils.deleteFile(file.getAbsolutePath());
				return false;
			}
			String url = dao.get(menuFind).getLocalUrl();
			if (!StringUtils.isEmpty(url)) {
				FileUtils.deleteFile(url);
			}
			menuFind.setImage(FileUploadUtils.getDefaultImgUrl(request, file.getName()));
			menuFind.setLocalUrl(file.getAbsolutePath());
		}
		dao.saveOrUpdate(menuFind);
		return true;
	}

	private boolean checkImage(File file) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			BufferedImage sourceImg = ImageIO.read(inputStream);
			int width = sourceImg.getWidth();
			int height = sourceImg.getHeight();
			if (width == 500 && height == 255) {
				return true;
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
		return false;
	}
}
