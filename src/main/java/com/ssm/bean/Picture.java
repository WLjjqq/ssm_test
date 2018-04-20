package com.ssm.bean;

import java.util.Arrays;

public class Picture {
	private Integer id;//图片id
	private byte[] img;
	private String pictureName;//图片名称
	private String pictureDesc;//图片描述
	private Boolean pictureBoolean;//图片是否上传成功
	private String pictureNote;//备注.URL

public Picture() {
}

public Picture(Integer id, byte[] img, String pictureName, String pictureDesc, Boolean pictureBoolean, String pictureNote) {
	this.id = id;
	this.img = img;
	this.pictureName = pictureName;
	this.pictureDesc = pictureDesc;
	this.pictureBoolean = pictureBoolean;
	this.pictureNote = pictureNote;
}

public byte[] getImg() {
	return img;
}

public void setImg(byte[] img) {
	this.img = img;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getPictureName() {
	return pictureName;
}

public void setPictureName(String pictureName) {
	this.pictureName = pictureName;
}

public String getPictureDesc() {
	return pictureDesc;
}

public void setPictureDesc(String pictureDesc) {
	this.pictureDesc = pictureDesc;
}

public Boolean getPictureBoolean() {
	return pictureBoolean;
}

public void setPictureBoolean(Boolean pictureBoolean) {
	this.pictureBoolean = pictureBoolean;
}

public String getPictureNote() {
	return pictureNote;
}

public void setPictureNote(String pictureNote) {
	this.pictureNote = pictureNote;
}

@Override
public String toString() {
	return "Picture{" +
			"id=" + id +
			", img=" + Arrays.toString(img) +
			", pictureName='" + pictureName + '\'' +
			", pictureDesc='" + pictureDesc + '\'' +
			", pictureBoolean=" + pictureBoolean +
			", pictureNote='" + pictureNote + '\'' +
			'}';
}
}
