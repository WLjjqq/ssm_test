package com.ssm.service.impl;

import com.ssm.mapper.AccountMapper;
import com.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	public void transfer(String sourceName, String targetName, int num) {
		accountMapper.minus(sourceName, num);
		doSomething();
		accountMapper.plus(targetName, num);

	}

public Integer getPoints(String name) {
	return accountMapper.getByName(name);
}

private void doSomething() {
	throw new RuntimeException("exception");
}

}
