import com.ssm.enums.AppointStateEnum;
import com.ssm.enums.Weekday;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ssm.utils.algorithm.array.Array.listHasAElement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Java {
   @Test
    public void test(){
      /**
       * 枚举的使用
       */
      AppointStateEnum appointStateEnum = AppointStateEnum.SUCCESS;
       System.out.println(appointStateEnum.getStateInfo()); //预约成功
       Weekday weekday=Weekday.MON;
       System.out.println(weekday.getLabel());
   }

   /**
    * 一个list中存放一个map，然后取出map里的值
    */
   @Test
   public void test2(){
      Map map = new HashMap<>();
      map.put("w","22");
      List list = new ArrayList<>();
      list.add(map);
      Map map1 = (Map)list.get(0);
      String str = (String)map1.get("w");//str就是22
      System.out.println(str);
   }

   @Test
   public void test3(){
       int[] a=new int[5];
       a[1]=1;
       a[2]=2;
       System.out.println("头开始的值"+a[2]);
       a[2]=0;
       System.out.println("后来的值"+a[2]);
       System.out.println(a.length);
   }


   @Test
   public void test4(){
       String name="li";
       List<String> list = new ArrayList<>();
       list.add("li");
       list.add("zhao");
        if(listHasAElement(list,name)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
   }
}
