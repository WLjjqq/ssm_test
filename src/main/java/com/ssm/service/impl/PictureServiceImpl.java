package com.ssm.service.impl;

import com.ssm.bean.Picture;
import com.ssm.mapper.PictureMapper;
import com.ssm.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {

	@Autowired
PictureMapper pictureMapper;
	public void insertPicture(Picture picture) throws IOException {

		pictureMapper.savePicture(picture);
	}

public Picture queryPicture(Integer id) {
	return pictureMapper.selectPicture(id);
}
}
