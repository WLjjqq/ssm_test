package com.ssm.controller;

import com.ssm.bean.Picture;
import com.ssm.service.impl.PictureServiceImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.*;


@Controller
public class UploadController {

	@Autowired
	PictureServiceImpl pictureService;

@RequestMapping("/testFileUpload")
@ResponseBody
public String testFileUpload(
		@RequestParam("username") String username,
		@RequestParam("desc") String desc,
		@RequestParam("file")
				MultipartFile file) throws IOException {
	System.out.println("上传人"+username);
	System.out.println("desc :"+ desc);
	System.out.println("file :"+ file.getOriginalFilename());
	System.out.println("InputStream :"+file.getInputStream());

	//得到文件上传的路径，就是文件上传到哪个地方
	String path="E:/testupload/" +file.getOriginalFilename();
	System.out.println(path);
	//上传
	file.transferTo(new File(path));



	Picture picture=new Picture(null,file.getBytes(),file.getOriginalFilename(),desc,true,path);

	pictureService.insertPicture(picture);

	return "success";
}

@RequestMapping("/testDownload/{id}")
public ResponseEntity<byte[] > testDownload(@PathVariable("id")Integer id, HttpSession session) throws IOException {
	//得到文件的路径
	Picture picture=pictureService.queryPicture(id);
	System.out.println(picture.getPictureNote());
	//把保存地址转换成字符串
	String filenames = picture.getPictureNote().toString();
	//根据"/"进行截取，然后放到数组中。数组的最后一个就是文件名。
	String[] filesname=filenames.split("/");
	System.out.println(filesname[filesname.length-1]);
	String path=picture.getPictureNote();
	// path是指欲下载的文件的路径。
	File file = new File(path);
	//http请求头与相应头。
	HttpHeaders headers = new HttpHeaders();
	String fileName=new String(filesname[filesname.length-1].getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
	//设置响应文件。
	headers.setContentDispositionFormData("attachment", fileName);
	//设置响应方式。
	headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	//把文件以二进制形式写回。
	return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
			headers, HttpStatus.CREATED);


}
}
