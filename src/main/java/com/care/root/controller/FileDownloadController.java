package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.service.FileService;

@Controller
public class FileDownloadController {
	@GetMapping("download")
	public void download(@RequestParam String file, HttpServletResponse response) throws Exception {
		response.addHeader("Content-disposition", "attachment; fileName="+file);
		File fi = new File(FileService.IMAGE_REPO+"\\"+file);
		FileInputStream in = new FileInputStream(fi);
		FileCopyUtils.copy(in, response.getOutputStream());
		in.close();
	}
}
