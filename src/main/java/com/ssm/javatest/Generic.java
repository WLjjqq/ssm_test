package com.ssm.javatest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//泛型机制
public class Generic {
	public static void main(String[] args) {
		/*//1:为什么需要使用泛型
		List list = new ArrayList();
		list.add("XIA");
		list.add(100);
		for (int i = 0; i < list.size(); i++) {
			//取出Integer时，运行时出现异常 ClassCastException java.lang.Integer cannot be cast to java.lang.String
			String name = (String) list.get(i);
			System.out.println("name:" + name);
		}*/

		//2：接下来使用泛型
		List<String> list1 = new ArrayList<String>();
		//list1.add(100);//List集合中只能存放String类型的数据。

		//3：泛型只能在编译期起作用。
		/*
		* 也就是说Java中的泛型，只在编译阶段有效。在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦出，
		* 并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。也就是说，成功编译过后的class文件中是不包含任何泛型信息的。
		* */
		ArrayList<String> a=new ArrayList<String>();
		ArrayList b = new ArrayList();
		System.out.println(a.getClass()==b.getClass());  //返回的是true

		//用反射的例子来验证3.
		//输出：[xia, 100]
		ArrayList<String> c = new ArrayList<String>();
		c.add("xia");
		Class d = c.getClass();
		try{
			Method method = d.getMethod("add",Object.class);
			method.invoke(c,100);

		}catch(Exception e){
			e.printStackTrace();
		}System.out.println(c);

		//泛型使用的注意事项
		//1:不能对确切的泛型类型使用instanceof操作。
		//2:List与List<?>   这个?是一个通配符。
		//（1）List实际上也是List<Object>。List实际上表示持有任何Object类型的原生List。
		//（2）而List<?>表示具有某种特定类型的非原生List，只是我们不知道那种类型是什么。
		//3:泛型不能使用在静态方法和静态类中。

		//泛型的一个面试题
		/*List<? extends T>和List <? super T>之间有什么区别 ?
				这两个List的声明都是限定通配符的例子，
		List<? extends T>可以接受任何继承自T的类型的List，而List<? super T>可以接受任何T的父类构成的List。
		例如List<? extends Number>可以接受List<Integer>或List<Float>。在本段出现的连接中可以找到更多信息。*/
		List<Object> listo = new ArrayList<Object>();
		List<String> lists = new ArrayList<String>();
				//System.out.println(listo=lists);编译都不通过。  说明泛型可以把String存放到Object中。但是不能把List<String>传递给一个接受List<Object>参数的方法
				System.out.println(listo.equals(lists));//true

		listo.add("String");
		System.out.println(listo);
	}
}
