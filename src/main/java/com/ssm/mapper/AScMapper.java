package com.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AScMapper {
    /**
     * 查询学生平均成绩及其名次
     * @return
     */
    List<Map<String,Object>> selectAvg();

    /**
     * 查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分
     * @return
     */
    List<Map<String,Object>> selectMaxAndMin();
    /**
     *  查询“001”课程比“002”课程成绩高的所有学生的学号；
     * select a.s_id,a.score
     * FROM
     * (select aa.s_id,aa.score
     * from a_sc aa
     * where aa.c_id ='001') a,
     * (select bb.s_id,bb.score
     * from a_sc bb
     * where bb.c_id ='002') b
     * where a.score>b.score
     * and a.s_id=b.s_id
     */
    List<Map<String,Object>> selectAGreaterB(HashMap map);

    /**
     * 查询平均成绩大于60分的同学的学号和平均成绩；
     */
    List<Map<String,Object>> selectAvgGreaterScore(@Param("score") Integer score);

    /**
     * 查询所有同学的学号、姓名、选课数、总成绩；
     * @return
     */
    List<Map<String,Object>> selectCountXuanKeShu();

    /**
     * 查询李姓老师有多少个
     * @return
     */
    int selectCountLiTeacher();
}
