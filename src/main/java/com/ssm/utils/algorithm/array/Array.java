package com.ssm.utils.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class Array {
    //查询List中有没有一个元素。
    public static boolean listHasAElement(List<String> list,String element){
        for(String s:list){
           if(s.equals(element)){
               return true;
           }else {
               return false;
           }
        }
        return false;
    }



}
