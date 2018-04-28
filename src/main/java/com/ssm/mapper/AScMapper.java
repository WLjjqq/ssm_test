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
    int selectCountLiTeacher(@Param("tName") String tName);

    /**
     * 查询没学过“叶平”老师课的同学的学号、姓名；
     * @return
     */
    List<Map<String,Object>> selectSnameAndSid();

    /**
     * 查询学过“001”并且也学过编号“002”课程的同学的学号、姓名；
     *
     * SELECT
     * 	a_student.s_id,
     * 	a_student.sname
     * FROM
     * 	a_student,
     * 	a_SC
     * WHERE
     * 	a_student.s_id = a_sc.s_id
     * AND a_sc.c_id = '001'
     * AND EXISTS (
     * 	SELECT
     * 		*
     * 	FROM
     * 		a_sc AS SC_2
     * 	WHERE
     * 		SC_2.S_id = a_sc.s_id
     * 	AND SC_2.c_id = '002'
     * );
     */
    List<Map<String,Object>> select001And002(@Param("param1") Integer param1,@Param("param2") Integer param2);

    /**
     * 查询学过“叶平”老师所教的所有课的同学的学号、姓名；
     */
    /*
    1：都有哪些学生学习了叶平老师的课。
    SELECT
    a.s_id,count(a.c_id)
    FROM
    a_sc a
    INNER JOIN a_course b ON a.c_id = b.c_id
    INNER JOIN a_teacher c ON c.t_id = b.t_id
            WHERE
    c.tname = '叶平'
    GROUP BY
    a.s_id
    2：叶平老师教了几门课。
    SELECT
			count(a_course.c_id)
		FROM
			a_course
		INNER JOIN a_teacher ON a_teacher.t_id = a_course.t_id
		WHERE
			a_teacher.tname = '叶平'
	)
	3：学叶平老师课和叶平老师教的课一样的学生的信息。
	SELECT
	a.s_id
FROM
	a_sc a
INNER JOIN a_course b ON a.c_id = b.c_id
INNER JOIN a_teacher c ON c.t_id = b.t_id
WHERE
	c.tname = '叶平'
GROUP BY
	a.s_id
HAVING
	count(a.c_id) = (
		SELECT
			count(a_course.c_id)
		FROM
			a_course
		INNER JOIN a_teacher ON a_teacher.t_id = a_course.t_id
		WHERE
			a_teacher.tname = '叶平'
	)
	*/
    List<Map<String,Object>> selectYepingAllCourse(@Param("name") String name);
}
