package com.ssm.java;

/**
 * Super
 * usage1:super.  直接去调用父类的方法和属性。
 * usage2:放在构造器中的第一位，代表引用父类的构造器。
 */
class SuperSub {
    String name;
    void value() {
        name = "China";
    }
    SuperSub(){
        System.out.println("父类，无参构造方法");
    }
    SuperSub(String name){
        System.out.println("父类，有参构造方法");
    }
}
public class SuperUsage extends SuperSub{
    String name;
    void value() {
        name = "Shanghai";
        super.value();      //调用父类的方法
        System.out.println(name);
        System.out.println(super.name);
    }

    SuperUsage(){
        super();//调用父类无参构造函数
        System.out.println("子类，无参构造方法");
    }
    SuperUsage(String name){
        super(name);//调用父类有参构造函数
        System.out.println("子类，有参构造方法");
    }


    public static void main(String[] args) {
        SuperUsage superUsage = new SuperUsage();
        superUsage.value();//输出结果 Shanghai   China


        SuperUsage superUsage1 = new SuperUsage();
        superUsage=new SuperUsage("li");
        /**
         * 输出结果：
         * 父类，无参构造方法
         * 子类，无参构造方法
         * 父类，有参构造方法
         * 子类，有参构造方法
         */

    }
}
