package com.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

	/*
	执行时机：会先到拦截器的preHandle方法。
			  这个方法是在目标方法前被执行。
	return true 正常执行。
	return false 如果是返回false的话，后续就不会执行了。
	作用：会在这个方法中来做权限。日志，事务等的操作。
	 */
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
	System.out.println("第一个拦截器的preHandle方法");
	return false;
}
	/*
	执行时机：目标方法执行完，渲染视图前执行的这个方法。
	作用：用来请求域中的属性或视图做出修改。
	 */
public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
	System.out.println("第一个拦截器的postHandle方法");
}
	/*
	执行时机：渲染视图之后。
	作用：释放资源。
	 */

public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
	System.out.println("第一个拦截器的afterCompletion方法");
}
}
