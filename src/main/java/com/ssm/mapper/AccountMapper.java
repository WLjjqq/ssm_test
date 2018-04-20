package com.ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface AccountMapper {
	void minus(@Param("name") String name, @Param("num") int num);//测试减积分
	void plus(@Param("name") String name, @Param("num") int num);//测试加积分
	Integer getByName(@Param("name") String name);
}
