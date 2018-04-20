package com.ssm.aop;


public class TestAop {
	//当与拦截器共同使用的时候，先执行拦截器的preHandle方法。

	public void TestAopMethod(){
		System.out.println("测试AOP切面编程");
	}
}
