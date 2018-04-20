package com.ssm.service;

public interface AccountService {
	/**
	 * 积分转移
	 *
	 * @param sourceName 转出方
	 * @param targetName 转入方
	 * @param num        转移数量
	 */
	void transfer(String sourceName, String targetName, int num);

	Integer getPoints(String name);

}
