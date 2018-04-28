package com.ssm.java;

/**
 *      1）：代表成员变量。也就是属性。this.i=i. 把形参赋值给当前属性。
 *
 * 　　2）：this(i) 放在构造器的第一位，去调用另外的一个构造器。i  代表调用的那个构造器的参数。
 *
 * 　　3）：调用别的方法。一般都直接写方法名了。
 *
 * 　　4）：return this;  返回的是对象本身。一定要与对象引用区分开来。
 */
public class ThisUsage {
    private int i=0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    //第一个构造器：有一个int型形参
    ThisUsage(int i){
        this.i=i+1;//此时this表示引用成员变量ｉ，而非函数参数ｉ
        System.out.println("Int constructor i——this.i:  "+i+"——"+this.i);
        System.out.println("i-1:"+(i-1)+"this.i+1:"+(this.i+1));
        //从两个输出结果充分证明了i和this.i是不一样的！
    }
    //  第二个构造器：有一个String型形参
    ThisUsage(String s){
        System.out.println("String constructor:  "+s);
    }
    //  第三个构造器：有一个int型形参和一个String型形参
    ThisUsage(int i,String s){
        this(s);//this调用第二个构造器
        //this(i);
       /*此处不能用，因为其他任何方法都不能调用构造器，只有构造方法能调用他。
       但是必须注意：就算是构造方法调用构造器，也必须为于其第一行，构造方法也只能调
       用一个且仅一次构造器！*/
        this.i=i++;//this以引用该类的成员变量
        System.out.println("Int constructor:  "+i+"/n"+"String constructor:  "+s);
    }
    public ThisUsage increment(){
        this.i++;
        return this;//返回的是当前的对象，该对象属于（ThisTest）
    }

    public ThisUsage test(){
        ThisUsage thisTest = new ThisUsage(3);
        return thisTest;
    }
    public static void main(String[] args){
        ThisUsage tt0=new ThisUsage(10);
        ThisUsage tt1=new ThisUsage("ok");
        ThisUsage tt2=new ThisUsage(20,"ok again!");

        System.out.println(tt0.i);
        System.out.println(tt0.increment().i);
        //tt0.increment()返回一个在tt0基础上ｉ++的ThisTest对象，
        //接着又返回在上面返回的对象基础上i++的ThisTest对象！
        //tt0输出的i 是11.然后tt0.increment()代表还是ThisTest.然后tt0.increment().i输出的是 12.
        System.out.println("----------------------");
        ThisUsage thisTest = new ThisUsage(2);
        int i = thisTest.test().getI();
        //如果return this 输出的是3.因为this代表i=2这个ThisTest.
        //如果return thisTest  输出的是4，代表的是thisTest这个引用对象。这个引用指向的是i=3这个ThisTest.
        System.out.println(i);
    }

}