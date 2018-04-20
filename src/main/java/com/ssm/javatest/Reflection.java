package com.ssm.javatest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//反射机制
public class Reflection {
	//动态语言是指在程序运行时允许改变程序结构或者变量类型。java虽然不是动态语言，但是有一个动态机制：反射。
	/*2. Java反射API

		反射API用来生成在当前Java虚拟机中的类、接口或者对象的信息。

		Class类：反射的核心类，可以获取类的属性，方法等内容信息。

		Field类：Java.lang.reflect.表示类的属性，可以获取和设置类的中属性值。

		Method类：Java.lang.reflect。表示类的方法，它可以用来获取类中方法的信息或者执行方法

		Construcor类：Java.lang.reflect。表示类的构造方法。*/

public static void main(String[] args) {
		Student student=null;
		//1：得到类的信息
		Class a=Student.class;
		System.out.println("类对象直接用类.class "+a);
		String aClass=Student.class.getName();
		System.out.println("利用类对象得到类的名称，包括包名。getSimpleName()不包括包名 "+aClass);


		//2：得到属性值,只能得到public类型的。能得到父类的。
		Field[] field = a.getFields();
		System.out.println(field.length);//输出：1
		//2：得到所有的属性。但是得不到父类的。
		Field[] field2 = a.getDeclaredFields();
		System.out.println(field2.length);
		for (int i=0;i<field2.length;i++)
		{
			//输出结果：
			//得到属性的值private java.lang.String com.ssm.javatest.Student.id
			//得到属性的值private java.lang.String com.ssm.javatest.Student.name
			System.out.println("得到属性的值"+field2[i]);
		}
		//2：得到单个属性的信息，如何去使用。  Declared是获得本类中所有的属性。getField()。获取public的，和父类中的。
	try {
		 student = new Student();
		Field field3=a.getDeclaredField("id");
		field3.set(student,"100");
		System.out.println("field3"+field3);
		//输出结果：Student{id='100', name='null'}
		System.out.println(student);
	} catch (Exception e) {
		e.printStackTrace();
	}


	//3：得到方法的信息 getDeclaredMethods只是自己类中的。 getMethods得到的是父类的和自己中public中的。

		Method[] method=a.getDeclaredMethods();
	for (int m=0;m<method.length;m++
		 )
	{
		System.out.println("方法的信息"+method[m]);
	}
	//3：得到类的方法后，如何去使用。
	try {
		 student = new Student();
		Method method1 = a.getDeclaredMethod("setId", String.class);
		method1.invoke(student,"101");
		System.out.println("反射去使用method方法  "+student.getId());
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
