import com.ssm.utils.algorithm.array.CustomArray;
import org.junit.Test;

public class ArrayTest {


    @Test
    public void test(){
        CustomArray customArray = new CustomArray(20);

        //添加
        customArray.add(1);
        customArray.add(2);
        System.out.println("测试添加：添加后数组的长度："+customArray.getSize());
        //获取下标为1的。
        System.out.println("测试获取下标：下标为1的值为2："+customArray.get(1));
        /**
         * 查找值为2的。
         */
        int i = customArray.find(2);
        System.out.println("获取值为2的下标为： " + i);
        //删除
        customArray.delete(2);
        System.out.println("删除后的长度："+customArray.getSize());
        //修改
        System.out.println("修改前的值："+customArray.get(0));
        customArray.update(1, 4);
        System.out.println("修改后的值："+customArray.get(0));

    }
}
