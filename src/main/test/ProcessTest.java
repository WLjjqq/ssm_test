import com.ssm.bean.Process;
import com.ssm.enums.ComputerState;
import com.ssm.mapper.ProcessMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProcessTest extends BaseTest{

    @Autowired
    ProcessMapper processMapper;

    @Test
    public void test(){
       /* Process process = new Process(10,"li",ComputerState.FAULT);
        Integer id = process.getId();
        if(id>14){
            process.setStatus(ComputerState.OPEN);
        }else{
            process.setStatus(ComputerState.CLOSE);
        }

        processMapper.insertProcess(process);*/


        Process process = processMapper.selectProcess(1);
        System.out.println("process的值 "+process);
        Process process2 = processMapper.selectProcess(1);
        System.out.println("process的值 "+process2);
    }

    /**
     * 查询条件为in
     */
    @Test
    public void testSelectIn(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        processMapper.selectAllProcess(list);
    }
}
