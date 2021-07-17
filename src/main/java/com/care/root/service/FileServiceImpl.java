package com.care.root.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.dto.ShoesDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService {
	@Autowired FileMapper fm;
	
	public void fileProcess(MultipartHttpServletRequest mul) {
		MultipartFile file = mul.getFile("file");
		
		ShoesDTO dto = new ShoesDTO();
		dto.setName(mul.getParameter("name"));
		dto.setId(mul.getParameter("id"));
		
		if(file.getSize() != 0) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String sysFileName = format.format(calendar.getTime()) + file.getOriginalFilename();
			
			File saveFile = new File(IMAGE_REPO+"\\" + sysFileName);
			dto.setImgName(sysFileName);
			try {
				file.transferTo(saveFile);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			dto.setImgName("nan");
		}
		fm.saveData(dto);
	}
	public void getShoesImage(Model model) {
		model.addAttribute("list", fm.getShoesImage());
	}
}
