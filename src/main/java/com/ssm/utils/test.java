package com.ssm.utils;

public class test {
    public Boolean test(){
        int a=10;
        int b=20;
        if(a>b){
            return false;
        }else {
            return true;
        }
    }
    public static void main(String[] args) {
        test t =new test();
        if(t.test()){
            System.out.println("if后面跟的是true");
        }else{
            System.out.println("if后面跟的是false");
        }
    }
}
