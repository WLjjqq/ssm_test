import com.ssm.mapper.AScMapper;
import com.ssm.service.AScService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int a = ascMapper.selectCountLiTeacher();
        System.out.println(a);
    }
}
