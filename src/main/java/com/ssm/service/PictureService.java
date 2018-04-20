package com.ssm.service;

import com.ssm.bean.Picture;

import java.io.IOException;

public interface PictureService {
public void insertPicture(Picture picture) throws IOException;
public Picture queryPicture(Integer id);
}
