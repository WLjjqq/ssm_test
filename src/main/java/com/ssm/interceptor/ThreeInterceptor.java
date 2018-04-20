package com.ssm.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class ThreeInterceptor implements WebRequestInterceptor {
	/*WebRequestInterceptor的实现和HandlerInterceptor一样，都是有这三个方法。执行的顺序也是一样的。
	 但是WebRequestInterceptor拦截器的preHandler没有返回值。所以只要配置了这个拦截器，就要执行下去。
	因此我们主要用它来进行资源的准备工作，比如我们在使用 Hibernate 的时候，可以在这个方法中准备一个
	 Hibernate 的Session 对象，然后利用 WebRequest 的 setAttribute(name, value, scope) 把它放到 WebRequest 的属性中。
	 在这里，进一步说说 setAttribute 方法的第三个参数 scope ，该参数是一个Integer 类型的。在 WebRequest 的父层接口 RequestAttributes 中对它定义了三个常量，分别为：
	SCOPE_REQUEST ，它的值是 0，表示只有在 request 中可以访问。
	SCOPE_SESSION，它的值是1，如果环境允许的话，它表示的是一个局部的隔离的 session，否则就代表普通的 session，并且在该 session 范围内可以访问。
	SCOPE_GLOBAL_SESSION，它的值是 2，如果环境允许的话，它表示的是一个全局共享的 session，否则就代表普通的 session，并且在该 session 范围内可以访问。*/
public void preHandle(WebRequest webRequest) throws Exception {
	System.out.println("WebRequestInterceptor拦截器的  preHandle方法");
}

public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {
	/*在这个方法里面通过改变数据模型 ModelMap 来改变数据的展示。该方法有两个参数，WebRequest 对象是用于传递整个请求数据的，
	 比如在 preHandle 中准备的数据都可以通过 WebRequest 来传递和访问；
	 ModelMap 就是 Controller 处理之后返回的 Model 对象，咱们可以通过改变它的属性来改变返回的 Model 模型。*/
	System.out.println("WebRequestInterceptor拦截器的 postHandle方法");
}

public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

	System.out.println("WebRequestInterceptor拦截器的 agterCompletion方法");
}
}
