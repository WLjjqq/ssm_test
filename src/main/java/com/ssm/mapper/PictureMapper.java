package com.ssm.mapper;

import com.ssm.bean.Picture;

public interface PictureMapper {
	 void savePicture(Picture picture);
	 Picture selectPicture(Integer id);
}
