import com.ssm.mapper.AScMapper;
import com.ssm.service.AScService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
}
