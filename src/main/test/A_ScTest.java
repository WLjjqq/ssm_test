import com.ssm.mapper.AScMapper;
import com.ssm.service.AScService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class A_ScTest extends BaseTest {
    @Autowired
   private AScMapper ascMapper;
    @Autowired
    private AScService aScService;
    @Test
    public void test(){
      List<Map<String,Object>> list=ascMapper.selectAvg();
        for (Map<String,Object> m:list
             ) {
            System.out.println(m);
        }
    }
    @Test
    public void testSelectMaxAndMin(){
        List<Map<String, Object>> list = aScService.queryAvg();
        for (Map<String,Object> m:list
             ) {
            System.out.println(m);
        }
    }

    /**
     * 测试 查询“001”课程比“002”课程成绩高的所有学生的学号；
     * 因为是传递两个参数。所以用map封装起来。cId对应的就是第一个参数。cId2对应的是第二个参数。
     */
    @Test
    public void testSelectAGreaterB(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("cId",001);
        map.put("cId2",002);
        List<Map<String,Object>> list = ascMapper.selectAGreaterB(map);
        for (Map<String,Object> i:list
             ) {
            System.out.println(i);
        }
    }

    /**
     * 查询平均成绩大于60分的同学的学号和平均成绩；
     */
    @Test
    public void testSelectAvgGreaterScore(){
        Integer score=60;
        List<Map<String, Object>> list = ascMapper.selectAvgGreaterScore(score);
        for (Map<String,Object> i:list
                ) {
            System.out.println(i);
        }
    }

    /**
     * 查询所有同学的学号、姓名、选课数、总成绩；
     */
    @Test
    public void testSelectCountXuanKeShu(){
        List<Map<String, Object>> list = ascMapper.selectCountXuanKeShu();
        for (Map<String,Object> i:list
                ) {
            System.out.println(i);
        }
    }

    /**
     * 查询所有李姓老师
     */
    @Test
    public void testSelectCountLiTeacher(){
        String tName="李";
        int a = ascMapper.selectCountLiTeacher(tName);
        System.out.println(a);
    }

    /**
     * 查询没学过“叶平”老师课的同学的学号、姓名；
     */
    @Test
    public void testSelectSnameAndSid(){
        List<Map<String, Object>> list = ascMapper.selectSnameAndSid();
        for (Map<String,Object> i:list
                ) {
            System.out.println(i);
        }
    }

    /**
     * 查询学过“001”并且也学过编号“002”课程的同学的学号、姓名；
     */
    @Test
    public void testSelect001And002(){
        List<Map<String, Object>> list = ascMapper.select001And002(002,001);
        for (Map<String,Object> i:list){
            System.out.println(i);
        }

        for(int i=0;i<list.size();i++){
            Map map=list.get(i);
            //是用set来接收的。不能重复。无顺序
            Set set = map.keySet();
            System.out.println("set的值 "+set);
            Object sId = map.get("sId");
            System.out.println("sId的值 "+sId);
        }
    }
    /**
     * 查询学过“叶平”老师所教的所有课的同学的学号、姓名；
     */
    @Test
    public void testSelectYepingAllCourse(){
        List<Map<String, Object>> list = ascMapper.selectYepingAllCourse("李一");
        for (Map<String,Object> i:list){
            System.out.println(i);
        }
        for(int i=0;i<list.size();i++){
            Map map=list.get(i);
            //是用set来接收的。不能重复。无顺序
            Set set = map.keySet();
            System.out.println("set的值 "+set);
            Object sId = map.get("sId");
            System.out.println("得到sId的值 "+sId);
        }
    }
}
